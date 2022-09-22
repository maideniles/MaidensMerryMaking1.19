package com.maideniles.maidensmerrymaking.modifiers;


import com.google.common.base.Suppliers;
import com.maideniles.maidensmerrymaking.util.MerryMakingConfig;
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



public class HalloweenChestLootModifier extends LootModifier {
    private final Item addition;

    public static final Supplier<Codec<HalloweenChestLootModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.create(inst -> codecStart(inst)
            .and(ForgeRegistries.ITEMS.getCodec().fieldOf("addition").forGetter(m -> m.addition))
            .apply(inst, HalloweenChestLootModifier::new)
    ));
    public HalloweenChestLootModifier(LootItemCondition[] conditionsIn, Item addition) {
        super(conditionsIn);

        this.addition = addition;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (context.getRandom().nextFloat() > 0.15) {
            generatedLoot.add(new ItemStack(addition, MerryMakingConfig.HALLOWEEN_DISC_CHEST_SPAWN.get()));
        }
        return generatedLoot;
    }

}














