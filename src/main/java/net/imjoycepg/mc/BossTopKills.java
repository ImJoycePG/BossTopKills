package net.imjoycepg.mc;

import lombok.Getter;
import net.imjoycepg.mc.Handlers.BossDeath;
import net.imjoycepg.mc.Utils.BossData;
import net.imjoycepg.mc.Utils.BossTopKillsExpansion;
import net.imjoycepg.mc.Utils.ConfigFile;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BossTopKills extends JavaPlugin {
    @Getter
    private static BossTopKills instance;
    private ConfigFile settings, message;
    private final List<BossData> bossDataList = new ArrayList<>();

    @Override
    public void onEnable() {
        instance = this;
        settings = new ConfigFile(this, "config.yml");
        message = new ConfigFile(this, "message.yml");
        getServer().getPluginManager().registerEvents(new BossDeath(), this);

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new BossTopKillsExpansion().register();
        }
    }

    @Override
    public void onDisable() {
    }
}
