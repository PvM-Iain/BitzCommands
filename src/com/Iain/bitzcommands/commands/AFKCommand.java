package com.Iain.bitzcommands.commands;

import com.Iain.bitzcommands.settings.Permissions;
import com.Iain.bitzcommands.settings.User;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AFKCommand implements CommandExecutor {
	
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		  if (!(sender instanceof Player)) {
	           sender.sendMessage("This command can be only by in-game players!");
	           return true;
		  }
		Player player = (Player)sender;
		    if (cmd.getName().equalsIgnoreCase("afk")) {
		    	if (!player.hasPermission("bitzcommands.afk")) {
				Permissions.noPermissionMessage((Player) player);
				return true;
	    }
		    	if (args.length == 0) {
		    		if (!User.afk_hash.containsKey(player.getName())) {
				User.afkPlayer(player);
				Bukkit.getServer().broadcastMessage(ChatColor.GRAY + player.getDisplayName() + " is now " + ChatColor.AQUA + "AFK" + ChatColor.GRAY + ".");
		    		} else {
						User.unafkPlayer(player);
						Bukkit.getServer().broadcastMessage(ChatColor.GRAY + player.getDisplayName() + " is " + ChatColor.AQUA + "no longer " + ChatColor.GRAY + "AFK.");
		    		}
			} else if (args.length > 0) {
		          player.sendMessage(ChatColor.RED + "Incorrect syntax!");
		          player.sendMessage(ChatColor.RED + "Usage: /" + commandLabel);
			}
	}
			return true;
}
}
