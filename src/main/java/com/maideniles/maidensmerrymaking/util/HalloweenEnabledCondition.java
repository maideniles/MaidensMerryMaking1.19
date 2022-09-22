package com.maideniles.maidensmerrymaking.util;

import com.google.gson.JsonObject;
import com.maideniles.maidensmerrymaking.MaidensMerryMaking;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class HalloweenEnabledCondition implements ICondition {

    @Override
    public ResourceLocation getID() {
        return MaidensMerryMaking.prefix("christmas_enabled");
    }

    @Override
    public boolean test(IContext context) {
        return MerryMakingConfig.HALLOWEEN_ENABLED.get();
    }


    public static class Serializer implements IConditionSerializer<HalloweenEnabledCondition> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void write(JsonObject json, HalloweenEnabledCondition value) { }

        @Override
        public HalloweenEnabledCondition read(JsonObject json) {
            return new HalloweenEnabledCondition();
        }

        @Override
        public ResourceLocation getID() {
            return MaidensMerryMaking.prefix("halloween_enabled");
        }
    }
}
