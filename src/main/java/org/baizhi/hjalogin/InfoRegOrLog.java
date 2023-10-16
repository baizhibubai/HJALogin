package org.baizhi.hjalogin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class InfoRegOrLog implements Runnable {
    @Override
    public void run() {
            for (Player player: Bukkit.getOnlinePlayers()){
                if (LoginData.hasList(player.getName())&&!ConfigReader.isRegister(player.getName())){
                    player.sendMessage(ChatColor.YELLOW+"请输入/register <密码> <确认密码>");
                }else if (LoginData.hasList(player.getName())&&ConfigReader.isRegister(player.getName())){
                    player.sendMessage(ChatColor.YELLOW+"请输入/login <密码>" );
                }
            }
        }
    }
