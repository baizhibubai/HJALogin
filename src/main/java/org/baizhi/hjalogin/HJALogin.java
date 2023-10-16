package org.baizhi.hjalogin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class HJALogin extends JavaPlugin {
    static JavaPlugin instance;
    @Override
    public void onLoad(){
        saveDefaultConfig();
    }
    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getLogger().info("§e登录插件1.1，成功加载!");
        Bukkit.getPluginManager().registerEvents(new EventListener(),this);
        Objects.requireNonNull(Bukkit.getPluginCommand("login")).setExecutor(new Command());
        Objects.requireNonNull(Bukkit.getPluginCommand("register")).setExecutor(new Command());
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this,new InfoRegOrLog(),0,60);
        instance = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        saveConfig();
    }
}
