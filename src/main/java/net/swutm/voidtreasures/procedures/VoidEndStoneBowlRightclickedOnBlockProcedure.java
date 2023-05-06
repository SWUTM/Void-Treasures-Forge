package net.swutm.voidtreasures.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.items.ItemHandlerHelper;
import net.swutm.voidtreasures.init.VoidTreasuresModItems;

public class VoidEndStoneBowlRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
				.getItem() == VoidTreasuresModItems.VOID_END_STONE_BOWL.get()) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(VoidTreasuresModItems.VOID_END_STONE_BOWL.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
						_player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(VoidTreasuresModItems.END_STONE_BOWL.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4,
						"", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/loot spawn ~ ~ ~ loot more_nuggets:blocks/void_bowl");
		}
	}
}
