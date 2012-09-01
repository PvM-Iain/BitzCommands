package com.Iain.bitzcommands.commands;

import com.Iain.bitzcommands.settings.Permissions;
import com.Iain.bitzcommands.settings.User;
import com.Iain.bitzcommands.settings.UserConfig;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomeCommand implements CommandExecutor {
	
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		  if (!(sender instanceof Player)) {
	           sender.sendMessage("This command can be only used in-game!");
	           return true;
		  }
		Player player = (Player)sender;
		  if (cmd.getName().equalsIgnoreCase("home")) {
		    	if (!player.hasPermission("bitzcommands.home")) {
				Permissions.noPermissionMessage((Player) player);
				return true;
	    }
			  if (args.length == 0) {
				  if(UserConfig.UserConfig.getBoolean(((Player) sender).getName() + ".home.enabled") == true) {
					  User.saveLastLocation((Player) sender);
					  ((Player)sender).teleport(User.teleportHome((Player)sender));
				  player.sendMessage(ChatColor.GRAY + "Teleported to your home!");
			  } else {
				  player.sendMessage(ChatColor.RED + "You have not set a home. Use /sethome to set one.");
			  }
			  } else if (args.length > 0) {
			          player.sendMessage(ChatColor.RED + "Too many arguments!");
			          player.sendMessage(ChatColor.RED + "Usage: /" + commandLabel);
		          }
		  }
		return true;
	  }
}