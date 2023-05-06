
/*
 *    swutm note: This file will be REGENERATED on each build.
 */
package net.swutm.voidtreasures.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.swutm.voidtreasures.item.VoidEndStoneBowlItem;
import net.swutm.voidtreasures.item.FastEndStoneBowlItem;
import net.swutm.voidtreasures.item.EndStoneBowlItem;
import net.swutm.voidtreasures.voidtreasures;

public class VoidTreasuresModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, voidtreasures.MOD_ID);
	public static final RegistryObject<Item> END_STONE_BOWL = REGISTRY.register("end_stone_bowl", () -> new EndStoneBowlItem());
	public static final RegistryObject<Item> VOID_END_STONE_BOWL = REGISTRY.register("void_end_stone_bowl", () -> new VoidEndStoneBowlItem());
	public static final RegistryObject<Item> FAST_END_STONE_BOWL = REGISTRY.register("fast_end_stone_bowl", () -> new FastEndStoneBowlItem());
}
