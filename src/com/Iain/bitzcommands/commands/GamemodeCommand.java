package com.Iain.bitzcommands.commands;

import java.util.logging.Logger;

import com.Iain.bitzcommands.settings.Permissions;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
        player.sendMessage("Your gamemode has been changed.");
        log.info("[BitzCommands] [Command] " + player.getDisplayName() + ": " + "/" + commandLabel + " (Creative)");
      }
      else if (player.getGameMode() == GameMode.CREATIVE) {
        player.setGameMode(GameMode.SURVIVAL);
        player.sendMessage("Your gamemode has been changed.");
        log.info("[BitzCommands] [Command] " + player.getDisplayName() + ": " + "/" + commandLabel + " (Survival)");
        } else if (args.length > 0) {
          player.sendMessage(ChatColor.RED + "Incorrect syntax!");
          player.sendMessage(ChatColor.RED + "Usage: /" + commandLabel);
        }
  }
}
	return true;
}
}
