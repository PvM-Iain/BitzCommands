package com.Iain.bitzcommands.events;

import java.util.logging.Logger;

import com.Iain.bitzcommands.BitzCommands;
import com.Iain.bitzcommands.settings.User;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.PluginDescriptionFile;

public class playerListener implements Listener {

	Logger log = Logger.getLogger("Minecraft");
	String banmessage = BitzCommands.plugin.getConfig().getString("BitzCommands.Ban Message");
	PluginDescriptionFile pdfFile = BitzCommands.plugin.getDescription();
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onDeathBack(EntityDeathEvent event) {
		if(event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			if (player.hasPermission("BitzCommands.back.ondeath")) { 
				User.saveLastLocation((Player) player);
				player.sendMessage(ChatColor.GRAY + "To teleport back to your death spot, do /back");
			}
		}
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerMove(PlayerMoveEvent event) {
		Player player = ((Player) event.getPlayer());
		if(User.freeze_hash.containsKey(player.getName())){
			event.setCancelled(true);
		}
		if(User.afk_hash.containsKey(player.getName())){
			User.unafkPlayer(player);
			Bukkit.getServer().broadcastMessage(ChatColor.GRAY + player.getDisplayName() + " isn't " + ChatColor.AQUA + "AFK " + ChatColor.GRAY + "anymore.");
		}
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		Player player = ((Player) event.getPlayer());
		if(User.mute_hash.containsKey(player.getName())) { event.setCancelled(true);
		}
}
	@EventHandler(priority = EventPriority.HIGH)
	public void onEntityDamage(EntityDamageEvent event) {
		if(event.getEntity() instanceof Player) {
			Player player = ((Player) event.getEntity());
			if(User.godlist.containsKey(player.getName())) {
				event.setCancelled(true);
				if(BitzCommands.plugin.getConfig().getBoolean("BitzCommands.Player.God.Effect when hit")) {
				player.getWorld().playEffect(player.getLocation(), Effect.MOBSPAWNER_FLAMES, 30);
			}
		}
	  }
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		if (BitzCommands.plugin.getConfig().getBoolean("BitzCommands.Join message")) {
			player.sendMessage(ChatColor.BLUE + "[BitzCommands] This server's running v"+ pdfFile.getVersion() + " of BitzCommands.");
		}
	}
	  @EventHandler(priority=EventPriority.HIGH)
	  public void customBanMessage(PlayerLoginEvent event) {
	    if (event.getResult() == PlayerLoginEvent.Result.KICK_BANNED) {
	    	event.setKickMessage((banmessage));
	    }
	}
		@EventHandler(priority = EventPriority.HIGH)
		public void joinMessages(PlayerJoinEvent event) {
			if (BitzCommands.plugin.getConfig().getBoolean("BitzCommands.Player.No join message")) {
				event.setJoinMessage("");
			}
			return;
		}
		@EventHandler(priority = EventPriority.HIGH)
		public void savePlayerIP(PlayerJoinEvent event) {
			Player player = ((Player) event.getPlayer());
			User.saveIP((Player) player);
			}
		@EventHandler(priority = EventPriority.HIGH)
		public void quitMessages(PlayerQuitEvent event) {
			if (BitzCommands.plugin.getConfig().getBoolean("BitzCommands.Player.No quit message")) {
				event.setQuitMessage("");
			}
			return;
		}
		@EventHandler(priority=EventPriority.HIGH)
		public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) { 
		  if (BitzCommands.plugin.getConfig().getBoolean("BitzCommands.Log all commands")) {
		  log.info("[BitzCommands] [LOG] " + event.getPlayer().getName() + " entered the command: " + event.getMessage());
		}
	}
}