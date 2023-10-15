package org.baizhi.hjalogin;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigReader {
       static FileConfiguration fileConfiguration = HJALogin.instance.getConfig();
        public static void addPlayer(String name,String password){
                fileConfiguration.set(name.toLowerCase(),password);
                HJALogin.instance.saveConfig();
        }
        public static boolean isRegister(String name){
            return fileConfiguration.contains(name.toLowerCase());
        }
        public static boolean rightPassword(String name,String password){
            return password.equals(fileConfiguration.get(name.toLowerCase()));
        }
}
