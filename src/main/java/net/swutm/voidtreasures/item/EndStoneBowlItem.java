
package net.swutm.voidtreasures.item;

import net.minecraft.world.item.*;

public class EndStoneBowlItem extends Item {
	public EndStoneBowlItem() {
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
