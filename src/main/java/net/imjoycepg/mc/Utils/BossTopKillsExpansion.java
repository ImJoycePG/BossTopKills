package net.imjoycepg.mc.Utils;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import net.imjoycepg.mc.BossTopKills;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

public class BossTopKillsExpansion extends PlaceholderExpansion {

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "BossTopKills";
    }

    @Override
    public @NotNull String getAuthor() {
        return BossTopKills.getInstance().getDescription().getAuthors().toString();
    }

    @Override
    public @NotNull String getVersion() {
        return BossTopKills.getInstance().getDescription().getVersion();
    }

    @Override
    public String onRequest(OfflinePlayer player, String identifier) {

        String[] args = identifier.split("_");

        if (args.length < 2) {
            return null;
        }
        BossData bossData = BossTopKills.getInstance().getBossDataList().get(0);

        if (args[0].equalsIgnoreCase("firstplayer")) {
            return bossData.getFirstPlayerName();
        }

        if (args[0].equalsIgnoreCase("firstdamage")) {
            return String.valueOf(bossData.getFirstPlayerDamage());
        }

        if (args[0].equalsIgnoreCase("secondplayer")) {
            return bossData.getSecondPlayerName();
        }

        if (args[0].equalsIgnoreCase("seconddamage")) {
            return String.valueOf(bossData.getSecondPlayerDamage());
        }

        if (args[0].equalsIgnoreCase("thirdplayer")) {
            return bossData.getThirdPlayerName();
        }

        if (args[0].equalsIgnoreCase("thirddamage")) {
            return String.valueOf(bossData.getThirdPlayerDamage());
        }

        if (args[0].equalsIgnoreCase("fourthplayer")) {
            return bossData.getFourthPlayerName();
        }

        if (args[0].equalsIgnoreCase("fourthdamage")) {
            return String.valueOf(bossData.getFourthPlayerDamage());
        }

        if (args[0].equalsIgnoreCase("fifthplayer")) {
            return bossData.getFifthPlayerName();
        }

        if (args[0].equalsIgnoreCase("fifthdamage")) {
            return String.valueOf(bossData.getFifthPlayerDamage());
        }

        return null;
    }

}
