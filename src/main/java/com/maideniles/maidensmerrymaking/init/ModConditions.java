package com.maideniles.maidensmerrymaking.init;

import com.maideniles.maidensmerrymaking.MaidensMerryMaking;
import com.maideniles.maidensmerrymaking.util.ChristmasEnabledCondition;
import com.maideniles.maidensmerrymaking.util.EasterEnabledCondition;
import com.maideniles.maidensmerrymaking.util.HalloweenEnabledCondition;
import com.maideniles.maidensmerrymaking.util.StPatricksDayEnabledCondition;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

@Mod.EventBusSubscriber(modid = MaidensMerryMaking.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModConditions {



    public static final ChristmasEnabledCondition CHRISTMAS_ENABLED_CONDITION = new ChristmasEnabledCondition();
    public static final StPatricksDayEnabledCondition ST_PATRICKS_DAY_ENABLED_CONDITION = new StPatricksDayEnabledCondition();
    public static final EasterEnabledCondition EASTER_ENABLED_CONDITION = new EasterEnabledCondition();
    public static final HalloweenEnabledCondition HALLOWEEN_ENABLED_CONDITION = new HalloweenEnabledCondition();


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