package akira.serverStuffs.creative.checks;
import akira.serverStuffs.Main;
import akira.serverStuffs.creative.ItemChecker;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SpawnEggMeta;

public class SpawnEggChecker extends ItemChecker {
	public SpawnEggChecker() {
		setting = "spawn-eggs";
	}
	@Override
	protected boolean trySatisfyInt(ItemStack item) {
		return item.getItemMeta() instanceof SpawnEggMeta;
	}
	
	@Override
	public Result check(ItemStack item, Player player) {
		if (item.getItemMeta() instanceof SpawnEggMeta eggMeta) {
			if (eggMeta.hasDisplayName()) if (eggMeta.getDisplayName().length() > 32 || eggMeta.getDisplayName().contains("§")) return Result.REMOVE_DATA;
			if (eggMeta.getSpawnedEntity() == null) return Result.SAFE;
		}
		return Result.REMOVE_DATA;
	}
}