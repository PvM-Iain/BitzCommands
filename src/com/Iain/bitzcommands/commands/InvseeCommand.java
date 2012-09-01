package com.Iain.bitzcommands.commands;

import java.util.logging.Logger;

import com.Iain.bitzcommands.settings.Permissions;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvseeCommand implements CommandExecutor {
	 
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		  if (!(sender instanceof Player)) {
	           sender.sendMessage("This command can be only used in-game!");
	           return true;
		  }
		  Logger log = Logger.getLogger("Minecraft");
		Player player = (Player)sender;
		    if (cmd.getName().equalsIgnoreCase("invsee")) {
		    	if (!player.hasPermission("bitzcommands.invsee")) {
				Permissions.noPermissionMessage((Player) player);
				return true;
	    }
		        if (args.length == 1) {
			        if (player.getServer().getPlayer(args[0]) != null) {
					Player targetplayer = player.getServer().getPlayer(args[0]);
					player.openInventory(targetplayer.getInventory());
		        	log.info("[BitzCommands] [Command] " + player.getDisplayName() + ": "  + "/" + commandLabel + " " + targetplayer.getDisplayName());
		            player.sendMessage(ChatColor.YELLOW + "Successfully opened " + ChatColor.BLUE + targetplayer.getDisplayName() + "'s inventory.");
			          } else {
				          player.sendMessage(ChatColor.RED + "ERROR: Player not found.");
			          }
		        } else if (args.length > 1 || args.length < 1) {
		          player.sendMessage(ChatColor.RED + "Incorrect syntax!");
		          player.sendMessage(ChatColor.RED + "Usage: /" + commandLabel + " <player>");
		        }
		        }
			return true;
	  }
}