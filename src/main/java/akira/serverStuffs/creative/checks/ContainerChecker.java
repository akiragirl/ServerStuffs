package akira.serverStuffs.creative.checks;
import akira.serverStuffs.creative.ItemChecker;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;

public class ContainerChecker extends ItemChecker {
	public ContainerChecker() {
		setting = "block-states";
	}
	@Override
	protected boolean trySatisfyInt(ItemStack item) {
		return item.getItemMeta() instanceof BlockStateMeta;
	}
	
	@Override
	public Result check(ItemStack item, Player player) {
		return Result.REMOVE_DATA;
	}
}