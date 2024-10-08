package akira.serverStuffs.creative.checks;
import akira.serverStuffs.creative.ItemChecker;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class BookChecker extends ItemChecker {
	public BookChecker() {
		setting = "books";
	}
	@Override
	protected boolean trySatisfyInt(ItemStack item) {
		return item.getType() == Material.WRITABLE_BOOK || item.getType() == Material.WRITTEN_BOOK;
	}
	
	@Override
	public Result check(ItemStack item, Player player) {
		return Result.REMOVE_DATA;
	}
}