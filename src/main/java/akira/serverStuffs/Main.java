package akira.serverStuffs;

import akira.serverStuffs.creative.ItemChecker;
import akira.serverStuffs.creative.Checkers;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Main extends JavaPlugin implements Listener {
	public static FileConfiguration config = null;
	public static File configFile = null;
	public static ConfigurationSection blockCreative = null;
	Checkers checkers = new Checkers();
	@Override
	public void onEnable() {
		setUpConfig();
		getServer().getPluginManager().registerEvents(this, this);
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {
		
		}, 0L, 1L);
	}
	
	@Override
	public void onDisable() {
	
	}
	
	public void setUpConfig() {
		saveDefaultConfig();
		reloadConfig();
		blockCreative = getConfig().getConfigurationSection("block-creative");
	}
	@EventHandler
	public void inventoryCreativeEvent(InventoryCreativeEvent event) {
		for (ItemChecker checker : checkers.getList()) {
			ItemStack item = event.getCursor();
			Player player = (Player) event.getWhoClicked();
			if (checker.trySatisfy(item, player)) switch (checker.check(item, player)) {
				case SAFE:
					return;
				case REMOVE_DATA:
					ItemStack newItem = item;
					newItem.setItemMeta(null);
					event.setCursor(newItem);
					break;
				case CLEAR:
					event.setCursor(new ItemStack(Material.AIR));
					break;
			}
			// don't break, multiple checkers may check the same item
		}
	}
}
