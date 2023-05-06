package net.swutm.voidtreasures.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.ItemHandlerHelper;
import net.swutm.voidtreasures.init.VoidTreasuresModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ESBProcedureProcedure {
	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		if (event.getHand() != event.getPlayer().getUsedItemHand())
			return;
		execute(event, event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == VoidTreasuresModItems.END_STONE_BOWL
				.get()) {
			if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.VOID_AIR) {
				if (new Object() {
					public double getSubmergedHeight(Entity _entity) {
						for (TagKey<Fluid> _fldtag : Registry.FLUID.getTagNames().toList()) {
							if (_entity.level.getFluidState(entity.blockPosition()).is(_fldtag))
								return _entity.getFluidHeight(_fldtag);
						}
						return 0;
					}
				}.getSubmergedHeight(entity) >= 0) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(VoidTreasuresModItems.END_STONE_BOWL.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
								_player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(VoidTreasuresModItems.VOID_END_STONE_BOWL.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
			}
		}
	}
}
