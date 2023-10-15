package org.baizhi.hjalogin;

import org.bukkit.ChatColor;
import org.bukkit.event.Cancellable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.*;

public class EventListener implements Listener {
    @EventHandler
    public void onJoin(PlayerLoginEvent event){
        event.getPlayer().sendMessage(ChatColor.GREEN+"请输入/login <密码>指令，注册或登录您的账号");
        LoginData.addList(event.getPlayer().getName());
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent event){
        LoginData.removeList(event.getPlayer().getName());
    }
    @EventHandler
    public void restrictTeleport(PlayerTeleportEvent event){
        cancelifnotlogin(event);
    }
    @EventHandler
    public void restrictMove(PlayerMoveEvent event){
        cancelifnotlogin(event);
    }
    @EventHandler
    public void restrictOpenInventory(InventoryOpenEvent event){
        cancelifnotlogin(event);
    }
    @EventHandler
    public void restrictInteract(PlayerInteractEvent event){
        cancelifnotlogin(event);
    }
    @EventHandler
    public void restrictPortal(PlayerPortalEvent event){
        cancelifnotlogin(event);
    }

    public void cancelifnotlogin(Cancellable cancellable){
        if (cancellable instanceof PlayerEvent){
            if (LoginData.hasList(((PlayerEvent) cancellable).getPlayer().getName())){
                cancellable.setCancelled(true);
            }
        }
        if (cancellable instanceof InventoryOpenEvent){
            if (LoginData.hasList(((InventoryOpenEvent) cancellable).getPlayer().getName())){
                cancellable.setCancelled(true);
            }
        }
    }
}
