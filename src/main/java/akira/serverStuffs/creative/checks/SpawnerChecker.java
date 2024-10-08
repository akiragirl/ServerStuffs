package akira.serverStuffs.creative.checks;
import akira.serverStuffs.creative.ItemChecker;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SpawnEggMeta;

public class SpawnerChecker extends ItemChecker {
	public SpawnerChecker() {
		setting = "spawners";
	}
	@Override
	protected boolean trySatisfyInt(ItemStack item) {
		return item.getType() == Material.SPAWNER;
	}
	
	@Override
	public Result check(ItemStack item, Player player) {
		return Result.REMOVE_DATA;
	}
}