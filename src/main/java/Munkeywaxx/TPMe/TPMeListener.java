package Munkeywaxx.TPMe;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class TPMeListener implements Listener {
	
	public TPMeListener(Main main) {
		
		main.getServer().getPluginManager().registerEvents(this, main);
	}
	

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent s) {
		Player player = s.getPlayer();
		s.setJoinMessage(ChatColor.AQUA + "Welcome back " + player.getName() + ("!"));
		
		if (player.hasPlayedBefore() == true) {
			player.sendMessage(ChatColor.BLUE + "Welcome back!");
			
		} else if (player.hasPlayedBefore() == false) {
			s.setJoinMessage(player.getName() + ChatColor.GOLD + "Is a new guy. Welcome!");
			
			
		} 
			
			
		}
	}


