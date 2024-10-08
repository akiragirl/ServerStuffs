package akira.serverStuffs.creative;

import akira.serverStuffs.creative.checks.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Checkers {
	public static final LazyChecker lazyChecker = new LazyChecker();
	public static final ContainerChecker containerChecker = new ContainerChecker();
	public static final SpawnEggChecker spawnEggChecker = new SpawnEggChecker();
	public static final SpawnerChecker spawnerChecker = new SpawnerChecker();
	public static final MinecartChecker minecartChecker = new MinecartChecker();
	public static final EnchantmentChecker enchantmentChecker = new EnchantmentChecker();
	public static final BookChecker bookChecker = new BookChecker();
	
	public List<ItemChecker> getList() {
		List<ItemChecker> list = new ArrayList<>();
		try {
			for (Field field : Checkers.class.getDeclaredFields()) list.add((ItemChecker) field.get(this));
		} catch (Exception ignored) {}
		return list;
	}
}
