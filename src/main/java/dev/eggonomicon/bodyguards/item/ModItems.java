package dev.eggonomicon.bodyguards.item;

import dev.eggonomicon.bodyguards.BodyguardsMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    // --------------------
    // Spawn Items
    // --------------------
    public static final Item VINDICATORGUARD_EGG = registerItem("vindicatorguard_egg",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(BodyguardsMod.MOD_ID, name), item);
    }

    // --------------------
    // REGISTER ITEMS
    // --------------------
    public static  void registerModItems() {
        System.out.println("Registering Mod Items for " + BodyguardsMod.MOD_ID);
    }

}
