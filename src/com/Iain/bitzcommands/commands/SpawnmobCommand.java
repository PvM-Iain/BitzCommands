package com.Iain.bitzcommands.commands;

import java.util.logging.Logger;

import com.Iain.bitzcommands.settings.Permissions;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SpawnmobCommand implements CommandExecutor {
	 
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		  if (!(sender instanceof Player)) {
	           sender.sendMessage("This command can be only used in-game!");
	           return true;
		  }
		  Logger log = Logger.getLogger("Minecraft");
		  Player player = (Player)sender;
		  if (cmd.getName().equalsIgnoreCase("spawnmob")) {
				if (!player.hasPermission("bitzcommands.spawnmob")) {
					Permissions.noPermissionMessage((Player) player);
					return true;
		    }
        	if (args.length == 2) {
        		try
	    	      {
        	      for (int i = 0; i < Integer.parseInt(args[1]); i++) {
        	          ((Player)sender).getWorld().spawnEntity(((Player)sender).getTargetBlock(null, 0).getLocation(), EntityType.fromName(args[0].toLowerCase()));
        	        }
        	      player.sendMessage(ChatColor.GRAY + "You've spawned " + args[1] + " " + args[0] + "(s)");
  		    	log.info("[BitzCommands] [Command] " + player.getDisplayName() + ": "  + "/" + commandLabel + " " + args[1] + " " + args[0]);

        	} catch (Exception e) {
	        	  player.sendMessage(ChatColor.RED + "ERROR: Mob not found.");
	          }
	        } else if (args.length > 2 || args.length < 2) {
		          player.sendMessage(ChatColor.RED + "An error has occured!");
		          player.sendMessage(ChatColor.RED + "Usage: /" + commandLabel + " <mob> <amount>");
	          }
	    }
		return true;
	}
}
