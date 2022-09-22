package com.maideniles.maidensmerrymaking.init;

import com.maideniles.maidensmerrymaking.MaidensMerryMaking;
import com.maideniles.maidensmerrymaking.conditions.ChristmasEnabledCondition;
import com.maideniles.maidensmerrymaking.conditions.EasterEnabledCondition;
import com.maideniles.maidensmerrymaking.conditions.HalloweenEnabledCondition;
import com.maideniles.maidensmerrymaking.conditions.StPatricksDayEnabledCondition;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

@Mod.EventBusSubscriber(modid = MaidensMerryMaking.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModConditions {



    public static final ChristmasEnabledCondition.Serializer CHRISTMAS_ENABLED_CONDITION = new ChristmasEnabledCondition.Serializer();
    public static final StPatricksDayEnabledCondition.Serializer ST_PATRICKS_DAY_ENABLED_CONDITION = new StPatricksDayEnabledCondition.Serializer();
    public static final EasterEnabledCondition.Serializer EASTER_ENABLED_CONDITION = new EasterEnabledCondition.Serializer();
    public static final HalloweenEnabledCondition.Serializer HALLOWEEN_ENABLED_CONDITION = new HalloweenEnabledCondition.Serializer();


@SubscribeEvent
    public void registerSerializers(RegisterEvent event) {
        event.register(ForgeRegistries.Keys.RECIPE_SERIALIZERS,
                helper -> CraftingHelper.register((IConditionSerializer<?>) CHRISTMAS_ENABLED_CONDITION));
    event.register(ForgeRegistries.Keys.RECIPE_SERIALIZERS,
            helper -> CraftingHelper.register((IConditionSerializer<?>) ST_PATRICKS_DAY_ENABLED_CONDITION));

    event.register(ForgeRegistries.Keys.RECIPE_SERIALIZERS,
            helper -> CraftingHelper.register((IConditionSerializer<?>) EASTER_ENABLED_CONDITION));

    event.register(ForgeRegistries.Keys.RECIPE_SERIALIZERS,
            helper -> CraftingHelper.register((IConditionSerializer<?>) HALLOWEEN_ENABLED_CONDITION));


}
}