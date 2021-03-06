package com.Iain.bitzcommands.commands;

import java.util.logging.Logger;

import com.Iain.bitzcommands.settings.Permissions;
import com.Iain.bitzcommands.settings.User;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UngodCommand implements CommandExecutor {
	
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		  if (!(sender instanceof Player)) {
			    if (cmd.getName().equalsIgnoreCase("ungod")) {
			    	if (args.length == 1) {
			          if (sender.getServer().getPlayer(args[0]) != null) {
			            Player targetplayer = sender.getServer().getPlayer(args[0]);
			            User.disableGodMode((Player) targetplayer);
			            sender.sendMessage(ChatColor.GRAY + "God mode disabled for " + targetplayer.getDisplayName());
			            targetplayer.sendMessage(ChatColor.GRAY + "Your god mode has been disabled.");
			          } else {
			        	  sender.sendMessage(ChatColor.RED + "ERROR: Player not found.");
			          }
			        } else if (args.length > 1) {
			        	sender.sendMessage("Too many arguments!");
				        sender.sendMessage("Usage: /" + commandLabel + " <player>");
			          }
			        }
				return true;
			    }
		  Logger log = Logger.getLogger("Minecraft");
		Player player = (Player)sender;
		    if (cmd.getName().equalsIgnoreCase("ungod")) {
		    	if (!player.hasPermission("bitzcommands.godmode")) {
				Permissions.noPermissionMessage((Player) player);
				return true;
	    }
	        if (args.length == 0) {
        		User.disableGodMode((Player) sender);
				player.sendMessage(ChatColor.GRAY + "God mode disabled.");
		    	log.info("[BitzCommands] [Command] " + player.getDisplayName() + ": "  + "/" + commandLabel);
	        } else if (args.length == 1) {
		    	if (!player.hasPermission("bitzcommands.godmode.others")) {
				Permissions.noPermissionMessage((Player) player);
				return true;
	    }
		          if (player.getServer().getPlayer(args[0]) != null) {
			            Player targetplayer = player.getServer().getPlayer(args[0]);
			            User.disableGodMode((Player) targetplayer);
			            player.sendMessage(ChatColor.GRAY + "God mode disabled for " + targetplayer.getDisplayName());
			            targetplayer.sendMessage(ChatColor.GRAY + "Your god mode has been disabled.");
			            log.info("[BitzCommands] [Command] " + player.getDisplayName() + ": "  + "/" + commandLabel + " " + targetplayer.getDisplayName());
		          } else {
			          player.sendMessage(ChatColor.RED + "ERROR: Player not found.");
		          }
			} else if (args.length > 1 || args.length < 1) {
		          player.sendMessage(ChatColor.RED + "Incorrect syntax!");
		          player.sendMessage(ChatColor.RED + "Usage: /" + commandLabel + "[player]");
			}
	}
			return true;
}
}
