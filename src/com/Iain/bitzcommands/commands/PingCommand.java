package com.Iain.bitzcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor {
	 
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		  if (!(sender instanceof Player)) {
			    if (cmd.getName().equalsIgnoreCase("ping")) {
			        if (args.length == 0) {
						sender.sendMessage("Pong!");
			        } else if (args.length > 0) {
			        	sender.sendMessage("Too many arguments!");
			        	sender.sendMessage("Usage: /" + commandLabel);
			        }
		  }
				return true;
		  }
		  Player player = (Player)sender;
		    if (cmd.getName().equalsIgnoreCase("ping")) if (player.hasPermission("bitzcommands.ping")) {
		        if (args.length == 0) {
		            player.sendMessage(ChatColor.GRAY + "Pong!");
		        } else if (args.length > 0) {
		          player.sendMessage(ChatColor.RED + "Too many arguments!");
		          player.sendMessage(ChatColor.RED + "Usage: /" + commandLabel);
		        }
	  }
			return true;
	  }
}