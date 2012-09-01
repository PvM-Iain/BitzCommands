package com.Iain.bitzcommands.commands;

import com.Iain.bitzcommands.BitzCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

public class BitzCommandsCommand implements CommandExecutor {
	
	PluginDescriptionFile pdfFile = BitzCommands.plugin.getDescription();

	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		  if (!(sender instanceof Player)) {
			    if (cmd.getName().equalsIgnoreCase("bitzcommands")) {
			    	sender.sendMessage(ChatColor.BLUE + "==============================================================");
			    	sender.sendMessage("BitzCommands v"+ pdfFile.getVersion());
			    	sender.sendMessage("Bitzcraft's private essential commands plugin");
			    	sender.sendMessage(" ");
			    	sender.sendMessage("Made by The Bitzcraft Development Team");
			    	sender.sendMessage("Twitter: @Bitzcraft");
			    	sender.sendMessage("http://www.bitzcraftonline.com");
			    	sender.sendMessage(ChatColor.BLUE + "==============================================================");
		        } else if (args.length > 0) {
		        	sender.sendMessage("Too many arguments!");
		        	sender.sendMessage("Usage: /" + commandLabel);
		        }
				return true;
		  }
		Player player = (Player)sender;
		    if (cmd.getName().equalsIgnoreCase("bitzcommands")) {
		    	player.sendMessage(ChatColor.BLUE + "==============================================================");
		    	player.sendMessage("BitzCommands" + ChatColor.AQUA + ChatColor.ITALIC + " v" + pdfFile.getVersion());
		    	player.sendMessage("Bitzcraft's private essential commands plugin");
		    	player.sendMessage(" ");
		    	player.sendMessage("Made by The Bitzcraft Development Team");
		    	player.sendMessage("Twitter: " + ChatColor.AQUA + "@Bitzcraft");
		    	player.sendMessage("Dev Team's website: " + ChatColor.AQUA + "http://www.bitzcraftonline.com");
		    	player.sendMessage(ChatColor.BLUE + "==============================================================");
	        } else if (args.length > 0) {
		          player.sendMessage(ChatColor.RED + "Too many arguments!");
		          player.sendMessage(ChatColor.RED + "Usage: /" + commandLabel);
	        }
			return true;
	  }
}