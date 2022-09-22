package com.maideniles.maidensmerrymaking.modifiers;


import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;


public class SpruceLeavesConverterModifier extends LootModifier {
    public static final Supplier<Codec<SpruceLeavesConverterModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.create(inst -> codecStart(inst).and(
            inst.group(
                    Codec.INT.fieldOf("numSeeds").forGetter(m -> m.numSeedsToConvert),
                    ForgeRegistries.ITEMS.getCodec().fieldOf("seedItem").forGetter(m -> m.itemToCheck),
                    ForgeRegistries.ITEMS.getCodec().fieldOf("replacement").forGetter(m -> m.itemReward)
            )).apply(inst, SpruceLeavesConverterModifier::new)
    ));

    private final int numSeedsToConvert;
    private final Item itemToCheck;
    private final Item itemReward;
    public SpruceLeavesConverterModifier(LootItemCondition[] conditionsIn, int numSeeds, Item itemCheck, Item reward) {
        super(conditionsIn);
        numSeedsToConvert = numSeeds;
        itemToCheck = itemCheck;
        itemReward = reward;
    }

    @NotNull
    @Override
    public ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        //
        // Additional conditions can be checked, though as much as possible should be parameterized via JSON data.
        // It is better to write a new ILootCondition implementation than to do things here.
        //
        int numSeeds = 0;
        for(ItemStack stack : generatedLoot) {
            if(stack.getItem() == itemToCheck)
                numSeeds+=stack.getCount();
        }
        if(numSeeds >= numSeedsToConvert) {
            generatedLoot.removeIf(x -> x.getItem() == itemToCheck);
            generatedLoot.add(new ItemStack(itemReward, (numSeeds/numSeedsToConvert)));
            numSeeds = numSeeds%numSeedsToConvert;
            if(numSeeds > 0)
                generatedLoot.add(new ItemStack(itemToCheck, numSeeds));
        }
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
