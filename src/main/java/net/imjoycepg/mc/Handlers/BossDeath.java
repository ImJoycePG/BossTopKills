package net.imjoycepg.mc.Handlers;

import me.clip.placeholderapi.PlaceholderAPI;
import net.imjoycepg.mc.BossTopKills;
import net.imjoycepg.mc.Utils.BossData;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.mineacademy.boss.api.event.BossDeathEvent;
import org.mineacademy.boss.model.Boss;

import java.util.Map;

public class BossDeath implements Listener {

    @EventHandler
    public void onBossDeath(BossDeathEvent event) {
        Boss boss = event.getBoss();

        Entity entity = event.getEntity();
        for (Entity nearby : entity.getNearbyEntities(100.0, 20.0, 100)) {
            if (!(nearby instanceof Player)) {
                continue;
            }

            Player player = (Player) nearby;

            Map.Entry<Double, Player>[] top5 = boss.getRecentDamagerPlayer(entity).entrySet().stream().limit(5).toArray(Map.Entry[]::new);

            BossData bossData = new BossData();

            bossData.setFirstPlayerName(top5.length >= 1 ? top5[0].getValue().getName() : "");
            bossData.setFirstPlayerDamage(top5.length >= 1 ? Math.round(top5[0].getKey() * 100.0) / 100.0 : 0.0);

            bossData.setSecondPlayerName(top5.length >= 2 ? top5[1].getValue().getName() : "");
            bossData.setSecondPlayerDamage(top5.length >= 2 ? Math.round(top5[1].getKey() * 100.0) / 100.0 : 0.0);

            bossData.setThirdPlayerName(top5.length >= 3 ? top5[2].getValue().getName() : "");
            bossData.setThirdPlayerDamage(top5.length >= 3 ? Math.round(top5[2].getKey() * 100.0) / 100.0 : 0.0);

            bossData.setFourthPlayerName(top5.length >= 4 ? top5[3].getValue().getName() : "");
            bossData.setFourthPlayerDamage(top5.length >= 4 ? Math.round(top5[3].getKey() * 100.0) / 100.0 : 0.0);

            bossData.setFifthPlayerName(top5.length >= 5 ? top5[4].getValue().getName() : "");
            bossData.setFifthPlayerDamage(top5.length >= 5 ? Math.round(top5[4].getKey() * 100.0) / 100.0 : 0.0);

            for (String message : BossTopKills.getInstance().getMessage().getStringList("TopDamage")) {
                message = message.replace("%firstPlayer%", bossData.getFirstPlayerName()).replace("%firstDamage%", String.valueOf(bossData.getFirstPlayerDamage()));
                message = message.replace("%secondPlayer%", bossData.getSecondPlayerName()).replace("%secondDamage%", String.valueOf(bossData.getSecondPlayerDamage()));
                message = message.replace("%thirdPlayer%", bossData.getThirdPlayerName()).replace("%thirdDamage%", String.valueOf(bossData.getThirdPlayerDamage()));
                message = message.replace("%fourthPlayer%", bossData.getFourthPlayerName()).replace("%fourthDamage%", String.valueOf(bossData.getFourthPlayerDamage()));
                message = message.replace("%fifthPlayer%", bossData.getFifthPlayerName()).replace("%fifthDamage%", String.valueOf(bossData.getFifthPlayerDamage()));
                player.sendMessage(message);
            }
        }
    }
}
