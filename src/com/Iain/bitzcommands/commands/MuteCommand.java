package com.Iain.bitzcommands.commands;

import java.util.logging.Logger;

import com.Iain.bitzcommands.settings.Permissions;
import com.Iain.bitzcommands.settings.User;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MuteCommand implements CommandExecutor {
	
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		  if (!(sender instanceof Player)) {
	           sender.sendMessage("This command can be only used by in-game players!");
	           return true;
		  }
		  Logger log = Logger.getLogger("Minecraft");
		Player player = (Player)sender;
		    if (cmd.getName().equalsIgnoreCase("mute")) {
		    	if (!player.hasPermission("bitzcommands.mute")) {
				Permissions.noPermissionMessage((Player) player);
				return true;
	    }
		    	if (args.length == 1) {
			          if (player.getServer().getPlayer(args[0]) != null) {
				            Player targetplayer = player.getServer().getPlayer(args[0]);
				User.mutePlayer(targetplayer);
				player.sendMessage(ChatColor.GRAY + "Muted " + targetplayer.getDisplayName());
				targetplayer.sendMessage(ChatColor.GRAY + "You've been muted. You must wait until your time is over before you may talk again.");
		    	log.info("[BitzCommands] [Command] " + player.getDisplayName() + ": "  + "/" + commandLabel + " " + targetplayer.getDisplayName());
			} else {
	    		player.sendMessage(ChatColor.RED + "ERROR: Player not found");
				}
			} else if (args.length > 1 || args.length < 1) {
		          player.sendMessage(ChatColor.RED + "Incorrect syntax!");
		          player.sendMessage(ChatColor.RED + "Usage: /" + commandLabel + " <player>");
			}
	}
			return true;
}
}

