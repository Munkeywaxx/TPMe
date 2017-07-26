package Munkeywaxx.TPMe;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
	
	public Permission playerPermission = new Permission("tpme.true");
	
	@Override
	public void onEnable(){
		getLogger().info("TPMe enabled.");
		PluginManager pm = getServer().getPluginManager();
		pm.addPermission(playerPermission);
		new TPMeListener(this);
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
		
		@Override
		public void onDisable(){
			getLogger().info("Disabled.");
		
	}
		
		public boolean onCommand (CommandSender sender, Command cmd, String label, String[] args) { 
			
				 if (cmd.getName().equalsIgnoreCase("RTP") && sender instanceof Player) {
					Player player = (Player) sender;
					Location originalLocation = player.getLocation();
					
						if(label.equalsIgnoreCase("RTP")) {
							if (!player.hasPermission("tpme.true")) {
								player.sendMessage("Nope! - Seek help!"); }else{
									
						
						Random random = new Random();
						int x = random.nextInt(5000) +1;
						int y = 150;
						int z = random.nextInt(5000) +1;
						
						Location teleportLocation = new Location(player.getWorld(), x, y, z);
						player.teleport(teleportLocation);
						
						player.sendMessage(ChatColor.GREEN + "Teleported " + (int)teleportLocation.distance(originalLocation) + " Blocks Away.");
							}
						
						return true;
					}
				
				return false;
			
			 }
				return false;
	
		}}
