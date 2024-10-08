package akira.serverStuffs.creative.checks;
import akira.serverStuffs.creative.ItemChecker;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MinecartChecker extends ItemChecker {
	public MinecartChecker() {
		setting = "minecarts";
	}
	@Override
	protected boolean trySatisfyInt(ItemStack item) {
		return item.getType().name().endsWith("MINECART");
	}
	
	@Override
	public Result check(ItemStack item, Player player) {
		return Result.REMOVE_DATA;
	}
}