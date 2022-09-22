package com.maideniles.maidensmerrymaking.init;

import com.maideniles.maidensmerrymaking.MaidensMerryMaking;
import com.maideniles.maidensmerrymaking.modifiers.ChestLootModifier;
import com.maideniles.maidensmerrymaking.modifiers.EasterChestLootModifier;
import com.maideniles.maidensmerrymaking.modifiers.HalloweenChestLootModifier;
import com.maideniles.maidensmerrymaking.modifiers.SpruceLeavesConverterModifier;
import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {

    //REGISTER LOOT MODIFIERS HERE//
    private static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLOBAL_LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, MaidensMerryMaking.MOD_ID);

    private static final RegistryObject<Codec<ChestLootModifier>> CHEST_LOOT = GLOBAL_LOOT_MODIFIERS.register("chest_loot_modifier", ChestLootModifier.CODEC);

    private static final RegistryObject<Codec<EasterChestLootModifier>> EASTER_CHEST_LOOT = GLOBAL_LOOT_MODIFIERS.register("easter_chest_loot_modifier", EasterChestLootModifier.CODEC);

    private static final RegistryObject<Codec<HalloweenChestLootModifier>> HALLOWEEN_CHEST_LOOT = GLOBAL_LOOT_MODIFIERS.register("halloween_chest_loot_modifier", HalloweenChestLootModifier.CODEC);

    private static final RegistryObject<Codec<SpruceLeavesConverterModifier>> SPRUCE_LEAVES_CHEST_LOOT = GLOBAL_LOOT_MODIFIERS.register("tiny_spruce_from_leaves", SpruceLeavesConverterModifier.CODEC);

}
