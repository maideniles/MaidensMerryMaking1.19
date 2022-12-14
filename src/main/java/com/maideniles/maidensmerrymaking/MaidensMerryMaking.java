package com.maideniles.maidensmerrymaking;

import com.maideniles.maidensmerrymaking.client.RenderLayers;
import com.maideniles.maidensmerrymaking.config.MerryMakingConfig;
import com.maideniles.maidensmerrymaking.entity.render.ColoredChickenRenderer;
import com.maideniles.maidensmerrymaking.entity.render.bunny.*;
import com.maideniles.maidensmerrymaking.entity.render.halloween.*;
import com.maideniles.maidensmerrymaking.event.HalloweenEntityEvents;
import com.maideniles.maidensmerrymaking.init.*;
import com.maideniles.maidensmerrymaking.items.armor.item.BunnyHoodArmorItem;
import com.maideniles.maidensmerrymaking.items.armor.item.RedChristmasArmorItem;
import com.maideniles.maidensmerrymaking.items.armor.item.ReindeerEarsArmorItem;
import com.maideniles.maidensmerrymaking.items.armor.render.BunnyHoodArmorRenderer;
import com.maideniles.maidensmerrymaking.items.armor.render.RedChristmasArmorRenderer;
import com.maideniles.maidensmerrymaking.items.armor.render.ReindeerEarsArmorRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

import java.util.Locale;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MaidensMerryMaking.MOD_ID)
public class MaidensMerryMaking {
    public static final String MOD_ID = "maidensmerrymaking";
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();




    public MaidensMerryMaking() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;


        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        RenderLayers.safeRunClient();
        ModEntityTypes.register(eventBus);
        ModPlacements.register(eventBus);
        ModLootModifiers.GLOBAL_LOOT_MODIFIERS.register(eventBus);

        ModSoundEvents.register(eventBus);
        ModAdvancements.init();



    //    ModStructures.register(eventBus);

    //HALLOWEEN COSTUMED MOBS
        eventBus.addListener(HalloweenEntityEvents::registerEntityAttributes);

    //   forgeBus.addListener(ModConditions::registerConditionSerializers);
        eventBus.addListener(this::setup);

        GeckoLib.initialize();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
       ;

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, MerryMakingConfig.CLIENT_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, MerryMakingConfig.SERVER_CONFIG);

    }

    // add a comment
    public void setup(final FMLCommonSetupEvent event) {





        event.enqueueWork(() -> {





        });

        // some preinit code



    }
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            if(MerryMakingConfig.COSTUMES_ENABLED.get()){
                HalloweenEntityEvents.initializeMobs();
            }


            EntityRenderers.register(ModEntityTypes.COLORED_CHICKEN.get(), ColoredChickenRenderer::new);

            EntityRenderers.register(ModEntityTypes.PINK_BUNNY.get(), PinkBunnyRenderer::new);
            EntityRenderers.register(ModEntityTypes.PINK_BUNNY_SMALL.get(), PinkBunnyRendererSmall::new);
            EntityRenderers.register(ModEntityTypes.PINK_BUNNY_LARGE.get(), PinkBunnyRendererLarge::new);

//BUNNY//
            EntityRenderers.register(ModEntityTypes.BLUE_BUNNY.get(), BlueBunnyRenderer::new);
            EntityRenderers.register(ModEntityTypes.BLUE_BUNNY_SMALL.get(), BlueBunnyRendererSmall::new);
            EntityRenderers.register(ModEntityTypes.BLUE_BUNNY_LARGE.get(), BlueBunnyRendererLarge::new);

            EntityRenderers.register(ModEntityTypes.CYAN_BUNNY.get(), CyanBunnyRenderer::new);
            EntityRenderers.register(ModEntityTypes.CYAN_BUNNY_SMALL.get(), CyanBunnyRendererSmall::new);
            EntityRenderers.register(ModEntityTypes.CYAN_BUNNY_LARGE.get(), CyanBunnyRendererLarge::new);

            EntityRenderers.register(ModEntityTypes.PURPLE_BUNNY.get(), PurpleBunnyRenderer::new);
            EntityRenderers.register(ModEntityTypes.PURPLE_BUNNY_SMALL.get(), PurpleBunnyRendererSmall::new);
            EntityRenderers.register(ModEntityTypes.PURPLE_BUNNY_LARGE.get(), PurpleBunnyRendererLarge::new);

            EntityRenderers.register(ModEntityTypes.YELLOW_BUNNY.get(), YellowBunnyRenderer::new);
            EntityRenderers.register(ModEntityTypes.YELLOW_BUNNY_SMALL.get(), YellowBunnyRendererSmall::new);
            EntityRenderers.register(ModEntityTypes.YELLOW_BUNNY_LARGE.get(), YellowBunnyRendererLarge::new);
//HALLOWEEN//
            EntityRenderers.register(ModEntityTypes.COSTUMED_ZOMBIE.get(), ZombieCostumeRenderer::new);
            EntityRenderers.register(ModEntityTypes.COSTUMED_SKELETON.get(), SkeletonCostumeRenderer::new);
            EntityRenderers.register(ModEntityTypes.COSTUMED_HUSK.get(), HuskCostumeRenderer::new);
            EntityRenderers.register(ModEntityTypes.COSTUMED_DROWNED.get(), DrownedCostumeRenderer::new);
            EntityRenderers.register(ModEntityTypes.COSTUMED_DROWNED_MERMAID.get(), DrownedMermaidCostumeRenderer::new);
            EntityRenderers.register(ModEntityTypes.COSTUMED_ZOMBIE_VILLAGER.get(), ZombieVillagerCostumeRenderer::new);
            EntityRenderers.register(ModEntityTypes.COSTUMED_WITCH.get(), WitchCostumeRenderer::new);
            EntityRenderers.register(ModEntityTypes.COSTUMED_CREEPER.get(), CreeperCostumeRenderer::new);
            EntityRenderers.register(ModEntityTypes.COSTUMED_SPIDER.get(), SpiderCostumeRenderer::new);

            GeoArmorRenderer.registerArmorRenderer(BunnyHoodArmorItem.class, new BunnyHoodArmorRenderer());
            GeoArmorRenderer.registerArmorRenderer(RedChristmasArmorItem.class, new RedChristmasArmorRenderer());
            GeoArmorRenderer.registerArmorRenderer(ReindeerEarsArmorItem.class, new ReindeerEarsArmorRenderer());
        }
    }



    public static ResourceLocation prefix(String name) {
        return new ResourceLocation(MOD_ID, name.toLowerCase(Locale.ROOT));
    }




}
