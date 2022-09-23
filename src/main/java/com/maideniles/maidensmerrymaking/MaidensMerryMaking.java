package com.maideniles.maidensmerrymaking;

import com.maideniles.maidensmerrymaking.client.RenderLayers;
import com.maideniles.maidensmerrymaking.conditions.ChristmasEnabledCondition;
import com.maideniles.maidensmerrymaking.conditions.EasterEnabledCondition;
import com.maideniles.maidensmerrymaking.conditions.HalloweenEnabledCondition;
import com.maideniles.maidensmerrymaking.conditions.StPatricksDayEnabledCondition;
import com.maideniles.maidensmerrymaking.event.HalloweenEntityEvents;
import com.maideniles.maidensmerrymaking.init.*;
import com.maideniles.maidensmerrymaking.config.MerryMakingConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;
import java.util.Objects;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MaidensMerryMaking.MOD_ID)
public class MaidensMerryMaking {
    public static final String MOD_ID = "maidensmerrymaking";
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();




    public MaidensMerryMaking() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, MerryMakingConfig.CLIENT_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, MerryMakingConfig.SERVER_CONFIG);

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        RenderLayers.safeRunClient();
        ModEntityTypes.register(eventBus);
        ModPlacements.register(eventBus);

        ModSoundEvents.register(eventBus);
        ModAdvancements.init();
    //    ModStructures.register(eventBus);

    //HALLOWEEN COSTUMED MOBS
        eventBus.addListener(HalloweenEntityEvents::registerEntityAttributes);

        eventBus.addListener(this::setup);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
       ;
    }

    // add a comment
    public void setup(final FMLCommonSetupEvent event) {

        IEventBus forgeBus = MinecraftForge.EVENT_BUS;

        forgeBus.addListener(ModConditions::registerConditionSerializers);

        event.enqueueWork(() -> {
            //HALLOWEEN COSTUMED MOBS
            if(!MerryMakingConfig.COSTUMES_ENABLED.get()== Boolean.FALSE){
            HalloweenEntityEvents.initializeMobs();
            }


        });

        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getName());


    }



    public static ResourceLocation prefix(String name) {
        return new ResourceLocation(MOD_ID, name.toLowerCase(Locale.ROOT));
    }




}
