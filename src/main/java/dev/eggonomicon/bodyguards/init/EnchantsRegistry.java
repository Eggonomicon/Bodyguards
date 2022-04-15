package dev.eggonomicon.bodyguards.init;


import dev.eggonomicon.bodyguards.BodyguardsMod;
import dev.eggonomicon.bodyguards.enchants.ArmourEnchantment;
import dev.eggonomicon.bodyguards.enchants.EnchantID;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.registry.Registry;

import java.util.EnumMap;

public class EnchantsRegistry {
    public static final EnumMap<EnchantID, Enchantment> enchants = new EnumMap<>(EnchantID.class);

    public static void init(){
        for (EnchantID enchantID : EnchantID.values()) {
            /*
            if (!McdarConfig.config.enableEnchantment.get(enchantID))
                continue;
             */

            Enchantment enchantment = new ArmourEnchantment(enchantID);


            enchants.put(enchantID, enchantment);
            registerEnchant(enchantID.toString().toLowerCase(), enchantment);
        }
    }

    protected static void registerEnchant(String id, Enchantment enchant){
        Registry.register(Registry.ENCHANTMENT, BodyguardsMod.ID(id), enchant);
    }
}
