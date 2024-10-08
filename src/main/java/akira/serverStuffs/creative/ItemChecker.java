package akira.serverStuffs.creative;

import akira.serverStuffs.Main;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemChecker {
	protected String setting;
	public ItemChecker() {
		setting = "placeholder";
	}
	public enum Result {
		SAFE,
		REMOVE_DATA,
		CLEAR
	}
	public boolean trySatisfy(ItemStack item, Player player) {
		if (!Main.blockCreative.getBoolean(setting) || player.hasPermission("serverstuffs.bypass.creative." + setting)) {
			return false;
		}
		return trySatisfyInt(item);
	}
	protected boolean trySatisfyInt(ItemStack item) {
		return false;
	}
	
	public Result check(ItemStack item, Player player) {
		return Result.SAFE;
	}
}
