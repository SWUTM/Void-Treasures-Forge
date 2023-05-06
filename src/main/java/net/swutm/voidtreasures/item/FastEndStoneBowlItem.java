
package net.swutm.voidtreasures.item;

import net.minecraft.world.item.*;

public class FastEndStoneBowlItem extends Item {
	public FastEndStoneBowlItem() {
		super(new Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}
}
