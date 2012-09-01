package com.Iain.bitzcommands.settings;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class User {
	
	public static void checkIfOpped(Player player) {
		if(player.isOp()) {
			
		}
		UserConfig.UserConfig.set(player.getName() + ".IP", User.playerIP(player));
		UserConfig.saveConfig();
	}
	
	public static int getSavedBackX(Player targetplayer) {
		int BackX = UserConfig.UserConfig.getInt(targetplayer.getName() + ".back.x");
		return BackX;
	}
	public static int getSavedBackY(Player targetplayer) {
		int BackY = UserConfig.UserConfig.getInt(targetplayer.getName() + ".back.y");
		return BackY;
	}
	public static int getSavedBackZ(Player targetplayer) {
		int BackZ = UserConfig.UserConfig.getInt(targetplayer.getName() + ".back.z");
		return BackZ;
	}
	public static String getSavedBackWorld(Player targetplayer) {
		String BackWorld = (String) UserConfig.UserConfig.get(targetplayer.getName() + ".back.world");
		return BackWorld;
	}	
	
	public static int getSavedHomeX(Player targetplayer) {
		int HomeX = UserConfig.UserConfig.getInt(targetplayer.getName() + ".home.x");
		return HomeX;
	}
	public static int getSavedHomeY(Player targetplayer) {
		int HomeY = UserConfig.UserConfig.getInt(targetplayer.getName() + ".home.y");
		return HomeY;
	}
	public static int getSavedHomeZ(Player targetplayer) {
		int HomeZ = UserConfig.UserConfig.getInt(targetplayer.getName() + ".home.z");
		return HomeZ;
	}
	public static String getSavedHomeWorld(Player targetplayer) {
		String HomeWorld = (String) UserConfig.UserConfig.get(targetplayer.getName() + ".home.world");
		return HomeWorld;
	}	
	
	public static String getSavedIP(Player targetplayer) {
		String IP = (String) UserConfig.UserConfig.get(targetplayer.getName() + ".IP");
		return IP;
	}
	
	public static String playerIP(Player player) {
		return player.getAddress().getAddress().toString();
	}
	
	public static HashMap<String, Boolean> vanish = new HashMap<String, Boolean>();
	
	public static HashMap<String, Boolean> afk_hash = new HashMap<String, Boolean>();
	public static void afkPlayer(Player p) {
		afk_hash.put(p.getName(), true);
	}
	
	public static void unafkPlayer(Player p) {
		afk_hash.remove(p.getName());
	}
	
	public static HashMap<String, Boolean> godlist = new HashMap<String, Boolean>();
	public static void enableGodMode(Player p) {
		godlist.put(p.getName(), true);
	}
	
	public static void disableGodMode(Player p) {
		godlist.remove(p.getName());
	}

	public static HashMap<String, Boolean> freeze_hash = new HashMap<String, Boolean>();
	public static void freezePlayer(Player p) {
		freeze_hash.put(p.getName(), true);
	}
	
	public static void unfreezePlayer(Player p) {
		freeze_hash.remove(p.getName());
	}

	public static HashMap<String, Boolean> mute_hash = new HashMap<String, Boolean>();
	public static void mutePlayer(Player p) {
		mute_hash.put(p.getName(), true);
	}
	
	public static void unmutePlayer(Player p) {
		mute_hash.remove(p.getName());
	}
	
	public static void saveHomeLocation(Player player) {
		UserConfig.UserConfig.set(player.getName() + ".home.enabled", Boolean.valueOf(true));
		UserConfig.UserConfig.set(player.getName() + ".home.x", Double.valueOf(player.getLocation().getX()));
		UserConfig.UserConfig.set(player.getName() + ".home.y", Double.valueOf(player.getLocation().getY()));
		UserConfig.UserConfig.set(player.getName() + ".home.z", Double.valueOf(player.getLocation().getZ()));
		UserConfig.UserConfig.set(player.getName() + ".home.yaw", Double.valueOf(player.getLocation().getYaw()));
		UserConfig.UserConfig.set(player.getName() + ".home.pitch", Double.valueOf(player.getLocation().getPitch()));
		UserConfig.UserConfig.set(player.getName() + ".home.world", player.getWorld().getName());
		UserConfig.saveConfig();
	}

	public static Location teleportHome(Player player) {
		String world = UserConfig.UserConfig.getString(player.getName() + ".home.world", player.getWorld().getName());
		return new Location(Bukkit.getServer().getWorld(world), UserConfig.UserConfig.getInt(player.getName() + ".home.x"), UserConfig.UserConfig.getInt(player.getName() + ".home.y"), UserConfig.UserConfig.getInt(player.getName() + ".home.z"), UserConfig.UserConfig.getInt(player.getName() + ".home.yaw"), UserConfig.UserConfig.getInt(player.getName() + ".home.pitch"));
	}

	public static void saveLastLocation(Player player) {
		UserConfig.UserConfig.set(player.getName() + ".back.enabled", Boolean.valueOf(true));
		UserConfig.UserConfig.set(player.getName() + ".back.x", Double.valueOf(player.getLocation().getX()));
		UserConfig.UserConfig.set(player.getName() + ".back.y", Double.valueOf(player.getLocation().getY()));
		UserConfig.UserConfig.set(player.getName() + ".back.z", Double.valueOf(player.getLocation().getZ()));
		UserConfig.UserConfig.set(player.getName() + ".back.yaw", Double.valueOf(player.getLocation().getYaw()));
		UserConfig.UserConfig.set(player.getName() + ".back.pitch", Double.valueOf(player.getLocation().getPitch()));
		UserConfig.UserConfig.set(player.getName() + ".back.world", player.getWorld().getName());
		UserConfig.saveConfig();
	}
	
	public static void saveOthersLastLocation(Player targetplayer) {
		UserConfig.UserConfig.set(targetplayer.getName() + ".back.enabled", Boolean.valueOf(true));
		UserConfig.UserConfig.set(targetplayer.getName() + ".back.x", Double.valueOf(targetplayer.getLocation().getX()));
		UserConfig.UserConfig.set(targetplayer.getName() + ".back.y", Double.valueOf(targetplayer.getLocation().getY()));
		UserConfig.UserConfig.set(targetplayer.getName() + ".back.z", Double.valueOf(targetplayer.getLocation().getZ()));
		UserConfig.UserConfig.set(targetplayer.getName() + ".back.yaw", Double.valueOf(targetplayer.getLocation().getYaw()));
		UserConfig.UserConfig.set(targetplayer.getName() + ".back.pitch", Double.valueOf(targetplayer.getLocation().getPitch()));
		UserConfig.UserConfig.set(targetplayer.getName() + ".back.world", targetplayer.getWorld().getName());
		UserConfig.saveConfig();
	}
	
	public static void saveOthersLastLocationTp2p(Player target1) {
		UserConfig.UserConfig.set(target1.getName() + ".back.enabled", Boolean.valueOf(true));
		UserConfig.UserConfig.set(target1.getName() + ".back.x", Double.valueOf(target1.getLocation().getX()));
		UserConfig.UserConfig.set(target1.getName() + ".back.y", Double.valueOf(target1.getLocation().getY()));
		UserConfig.UserConfig.set(target1.getName() + ".back.z", Double.valueOf(target1.getLocation().getZ()));
		UserConfig.UserConfig.set(target1.getName() + ".back.yaw", Double.valueOf(target1.getLocation().getYaw()));
		UserConfig.UserConfig.set(target1.getName() + ".back.pitch", Double.valueOf(target1.getLocation().getPitch()));
		UserConfig.UserConfig.set(target1.getName() + ".back.world", target1.getWorld().getName());
		UserConfig.saveConfig();
	}

	public static Location teleportBack(Player player) {
		String world = UserConfig.UserConfig.getString(player.getName() + ".back.world", player.getWorld().getName());
		return new Location(Bukkit.getServer().getWorld(world), UserConfig.UserConfig.getInt(player.getName() + ".back.x"), UserConfig.UserConfig.getInt(player.getName() + ".back.y"), UserConfig.UserConfig.getInt(player.getName() + ".back.z"), UserConfig.UserConfig.getInt(player.getName() + ".back.yaw"), UserConfig.UserConfig.getInt(player.getName() + ".back.pitch"));
	}
	
	public static void saveIP(Player player) {
		UserConfig.UserConfig.set(player.getName() + ".IP", User.playerIP(player));
		UserConfig.saveConfig();
	}
}