package com.Iain.bitzcommands.commands;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Iain.bitzcommands.settings.Permissions;

public class GamemodeCommand implements CommandExecutor {
	
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage("This command can be only used by in-game players!");
      return true;
    }
    Logger log = Logger.getLogger("Minecraft");
    Player player  = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("gm")) {
    	if (!player.hasPermission("bitzcommands.gamemode")) {
		Permissions.noPermissionMessage((Player) player);
		return true;
}
      if (args.length == 0) {
      if (player.getGameMode() == GameMode.SURVIVAL) {
        player.setGameMode(GameMode.CREATIVE);
        player.sendMessage(ChatColor.GRAY + "Gamemode changed to creative.");
        log.info("[BitzCommands] [Command] " + player.getDisplayName() + ": " + "/" + commandLabel + " (Creative)");
      }
      else if (player.getGameMode() == GameMode.CREATIVE) {
        player.setGameMode(GameMode.ADVENTURE);
        player.sendMessage(ChatColor.GRAY + "Gamemode changed to adventure.");
        log.info("[BitzCommands] [Command] " + player.getDisplayName() + ": " + "/" + commandLabel + " (Adventure)");
      } 
      	else if (player.getGameMode() == GameMode.ADVENTURE) {
          player.setGameMode(GameMode.SURVIVAL);
          player.sendMessage(ChatColor.GRAY + "Gamemode changed to survival.");
          log.info("[BitzCommands] [Command] " + player.getDisplayName() + ": " + "/" + commandLabel + " (Survival)");
      	} 
      } else if (args.length == 1) {
		    	if (!player.hasPermission("bitzcommands.gamemodeother")) {
				Permissions.noPermissionMessage((Player) player);
				return true;
	    }
		          if (player.getServer().getPlayer(args[0]) != null) {
			            Player targetplayer = player.getServer().getPlayer(args[0]);
		        if (targetplayer.getGameMode() == GameMode.SURVIVAL) {
		        	targetplayer.setGameMode(GameMode.CREATIVE);
		        	targetplayer.sendMessage(ChatColor.GRAY + "Gamemode changed to creative.");
		            log.info("[BitzCommands] [Command] " + player.getDisplayName() + ": " + "/" + commandLabel + " " + targetplayer.getDisplayName() + " (Creative)");
		          }
		          else if (targetplayer.getGameMode() == GameMode.CREATIVE) {
		        	  targetplayer.setGameMode(GameMode.ADVENTURE);
		        	  targetplayer.sendMessage(ChatColor.GRAY + "Gamemode changed to adventure.");
		            log.info("[BitzCommands] [Command] " + player.getDisplayName() + ": " + "/" + commandLabel + " " + targetplayer.getDisplayName() + " (Adventure)");
		          } 
		          	else if (targetplayer.getGameMode() == GameMode.ADVENTURE) {
		          		targetplayer.setGameMode(GameMode.SURVIVAL);
		          		targetplayer.sendMessage(ChatColor.GRAY + "Gamemode changed to survival.");
		              log.info("[BitzCommands] [Command] " + player.getDisplayName() + ": " + "/" + commandLabel + " " + targetplayer.getDisplayName() + " (Survival)");
		          	}
        } else if (args.length > 1) {
          player.sendMessage(ChatColor.RED + "Incorrect Syntax!!");
          player.sendMessage(ChatColor.RED + "Usage: /" + commandLabel + " [player]");
        }
  }
}
	return true;
  }
  }
