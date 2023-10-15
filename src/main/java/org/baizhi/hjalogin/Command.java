package org.baizhi.hjalogin;

import org.bukkit.ChatColor;
import org.bukkit.block.data.type.Chain;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            System.out.println(ChatColor.RED+"非玩家无法使用该命令");
            return true;
        }
        if (strings.length!=1&&s.equals("login")){
            commandSender.sendMessage(ChatColor.RED+"格式错误！");
            return false;
        }
//        if (strings.length!=2&&s.equals("register")){
//            commandSender.sendMessage(ChatColor.RED+"格式错误！");
//            return false;
//        }
        if (ConfigReader.isRegister(commandSender.getName())) {
            if (LoginData.hasList(commandSender.getName())&&s.equals("login")) {
                if (ConfigReader.rightPassword(commandSender.getName(), strings[0])) {
                    LoginData.removeList(commandSender.getName());
                    commandSender.sendMessage(ChatColor.GREEN + "您已成功登录游戏！");
                    return true;
                }
            } else if (!LoginData.hasList(commandSender.getName())) {
                commandSender.sendMessage(ChatColor.RED + "您已经成功登录游戏！无需重新登录！");
                return true;
            }
        }else if (s.equals("login")&&!ConfigReader.isRegister(commandSender.getName())){
                commandSender.sendMessage(ChatColor.RED+"您还未注册！请输入/register <密码> <确认密码>来注册您的账户！");
                return true;
        }else if (s.equals("register")&&strings.length==1){
            commandSender.sendMessage(ChatColor.RED+"格式错误！正确格式：/register <密码> <确认密码>");
            return true;
        }else if (s.equals("register")&&strings.length==2&&!(strings[0].equals(strings[1]))) {
            commandSender.sendMessage(ChatColor.RED+"两次输入的密码不相同！请重试！");
            return true;
        } else if (s.equals("register") && strings.length == 2){
                ConfigReader.addPlayer(commandSender.getName(),strings[0]);
                LoginData.removeList(commandSender.getName());
                commandSender.sendMessage(ChatColor.GREEN+"您已成功注册！");
            }
                return true;
            }
        }

