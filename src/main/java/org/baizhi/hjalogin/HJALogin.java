package org.baizhi.hjalogin;

import jdk.jpackage.internal.Log;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class HJALogin extends JavaPlugin implements Runnable {
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
        new Thread(new HJALogin()).start();
        instance = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        saveConfig();
    }

    @Override
    public void run() {
        while (!LoginData.isNull()){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ignored) {
            }
            for (Player player:Bukkit.getOnlinePlayers()){
                if (LoginData.hasList(player.getName())&&!ConfigReader.isRegister(player.getName())){
                    player.sendMessage(ChatColor.YELLOW+"请输入/register <密码> <确认密码>");
                }else if (LoginData.hasList(player.getName())&&ConfigReader.isRegister(player.getName())){
                    player.sendMessage(ChatColor.YELLOW+"请输入/login <密码>" );
                }
            }
        }
    }
}
