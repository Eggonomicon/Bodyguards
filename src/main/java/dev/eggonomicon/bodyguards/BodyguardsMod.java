package dev.eggonomicon.bodyguards;

import dev.eggonomicon.bodyguards.init.ItemInit;
import dev.eggonomicon.bodyguards.init.LootRegistry;
import dev.eggonomicon.bodyguards.init.SummonedEntityRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.GourdBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class BodyguardsMod implements ModInitializer {

	// MOD_ID can only conatain lowercase letters, numbers, and _ underscore
	public static final String MOD_ID = "bodyguards";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier ID (String path){
		return new Identifier(MOD_ID, path);
	}

	public static final Random random = new Random();


	public static final ItemGroup BODYGUARDS = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, "bodyguards"),
			() -> new ItemStack(Blocks.RED_BANNER));
			/*
			() -> new ItemStack(ItemInit.damagingItems.get(DamagingItemsID.LIGHTNING_ROD)));
			 */

	@Override
	public void onInitialize() {
		ItemInit.init();
		//EnchantsRegistry.init();
		//StatusEffectInit.init();
		LootRegistry.init();
		SummonedEntityRegistry.register();

		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Bodyguards Mod: Initializing");


	}
}
