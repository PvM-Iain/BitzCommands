package com.Iain.bitzcommands.commands;

import java.util.logging.Logger;

import com.Iain.bitzcommands.BitzCommands;
import com.Iain.bitzcommands.settings.Permissions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BanCommand implements CommandExecutor {
	
	String banmessage = BitzCommands.plugin.getConfig().getString("BitzCommands.Ban Message");
	 
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		  if (!(sender instanceof Player)) {
			    if (cmd.getName().equalsIgnoreCase("ban")) {
			        if (args.length == 1) {
						Bukkit.getOfflinePlayer(args[0]).setBanned(true);
						if (Bukkit.getPlayer(args[0]) != null) Bukkit.getPlayer(args[0]).kickPlayer(banmessage);
						sender.sendMessage("Banned " + args[0]);
				    	if (BitzCommands.plugin.getConfig().getBoolean("BitzCommands.Broadcast bans")) {
				    		Bukkit.getServer().broadcastMessage(ChatColor.GRAY + "The CONSOLE just banned " + args[0]);
				    	}
			        } else if (args.length > 1 || args.length < 1) {
			        	sender.sendMessage("An error has occured!");
			        	sender.sendMessage("Usage: /" + commandLabel + " <player>");
			        }
		  }
				return true;
		  }
		  Logger log = Logger.getLogger("Minecraft");
		Player player = (Player)sender;
		    if (cmd.getName().equalsIgnoreCase("ban")) {
		    	if (!player.hasPermission("bitzcommands.ban")) {
				Permissions.noPermissionMessage((Player) player);
				return true;
	    }
		        if (args.length == 1) {
					Bukkit.getOfflinePlayer(args[0]).setBanned(true);
					if (Bukkit.getPlayer(args[0]) != null) Bukkit.getPlayer(args[0]).kickPlayer(banmessage);
					log.info("[BitzCommands] [Command] " + player.getDisplayName() + ": "  + "/" + commandLabel + " " + args[0]);
		            player.sendMessage(ChatColor.GRAY + "Banned " + args[0]);
			    	if (BitzCommands.plugin.getConfig().getBoolean("BitzCommands.Broadcast bans")) {
			    		Bukkit.getServer().broadcastMessage(ChatColor.GRAY + player.getDisplayName() + " just banned " + args[0] + " !");
			    	}
		        } else if (args.length > 1 || args.length < 1) {
		          player.sendMessage(ChatColor.RED + "Error!");
		          player.sendMessage(ChatColor.RED + "Usage: /" + commandLabel + " <player>");
		        }
	  }
			return true;
	  }
}
