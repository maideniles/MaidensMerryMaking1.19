package com.maideniles.maidensmerrymaking.util;

import com.google.gson.JsonObject;
import com.maideniles.maidensmerrymaking.MaidensMerryMaking;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class ChristmasEnabledCondition implements ICondition {

    @Override
    public ResourceLocation getID() {
        return MaidensMerryMaking.prefix("christmas_enabled");
    }

    @Override
    public boolean test(IContext context) {
        return MerryMakingConfig.CHRISTMAS_ENABLED.get();
    }



    public static class Serializer implements IConditionSerializer<ChristmasEnabledCondition> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void write(JsonObject json, ChristmasEnabledCondition value) { }

        @Override
        public ChristmasEnabledCondition read(JsonObject json) {
            return new ChristmasEnabledCondition();
        }

        @Override
        public ResourceLocation getID() {
            return MaidensMerryMaking.prefix("christmas_enabled");
        }
    }
}
