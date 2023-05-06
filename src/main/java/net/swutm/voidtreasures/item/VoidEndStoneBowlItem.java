
package net.swutm.voidtreasures.item;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.swutm.voidtreasures.procedures.VoidEndStoneBowlRightclickedOnBlockProcedure;

public class VoidEndStoneBowlItem extends Item {
	public VoidEndStoneBowlItem() {
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

	@Override
	public InteractionResult useOn(UseOnContext context) {
		InteractionResult retval = super.useOn(context);
		VoidEndStoneBowlRightclickedOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(),
				context.getClickedPos().getZ(), context.getPlayer());
		return retval;
	}
}
