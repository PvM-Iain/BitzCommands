package com.Iain.bitzcommands.settings;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Permissions {

	  public static void noPermissionMessage(Player player) {
		  player.sendMessage(ChatColor.YELLOW + "Sorry but you do not have the correct permissions to execute this command.");
		  }

}
