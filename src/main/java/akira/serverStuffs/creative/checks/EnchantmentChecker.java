package akira.serverStuffs.creative.checks;
import akira.serverStuffs.creative.ItemChecker;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class EnchantmentChecker extends ItemChecker {
	public EnchantmentChecker() {
		setting = "enchantments";
	}
	@Override
	protected boolean trySatisfyInt(ItemStack item) {
		if (item.getItemMeta() == null) return false;
		return item.getItemMeta().hasEnchants();
	}
	
	@Override
	public Result check(ItemStack item, Player player) {
		Map<Enchantment, Integer> enchantments = item.getEnchantments();
		for (Enchantment enchantment : enchantments.keySet()) {
			if (enchantments.get(enchantment) > enchantment.getMaxLevel()) return Result.REMOVE_DATA;
		}
		return Result.SAFE;
	}
}