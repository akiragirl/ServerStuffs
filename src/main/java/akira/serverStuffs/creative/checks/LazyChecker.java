package akira.serverStuffs.creative.checks;
import akira.serverStuffs.creative.ItemChecker;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SpawnEggMeta;

public class LazyChecker extends ItemChecker {
	public LazyChecker() {
		setting = "lazy";
	}
	@Override
	protected boolean trySatisfyInt(ItemStack item) {
		return true;
	}
	
	@Override
	public Result check(ItemStack item, Player player) {
		return Result.REMOVE_DATA;
	}
}