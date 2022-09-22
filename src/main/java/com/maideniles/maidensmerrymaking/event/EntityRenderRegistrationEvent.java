package com.maideniles.maidensmerrymaking.event;

import com.maideniles.maidensmerrymaking.MaidensMerryMaking;
import com.maideniles.maidensmerrymaking.entity.render.ColoredChickenRenderer;
import com.maideniles.maidensmerrymaking.entity.render.bunny.*;
import com.maideniles.maidensmerrymaking.entity.render.halloween.*;
import com.maideniles.maidensmerrymaking.init.ModEntityTypes;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MaidensMerryMaking.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityRenderRegistrationEvent {

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerEntityRenderer(EntityRenderersEvent.RegisterRenderers event) {



        event.registerEntityRenderer(ModEntityTypes.COLORED_CHICKEN.get(), ColoredChickenRenderer::new);

        event.registerEntityRenderer(ModEntityTypes.PINK_BUNNY.get(), PinkBunnyRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.PINK_BUNNY_SMALL.get(), PinkBunnyRendererSmall::new);
        event.registerEntityRenderer(ModEntityTypes.PINK_BUNNY_LARGE.get(), PinkBunnyRendererLarge::new);

//BUNNY//
        event.registerEntityRenderer(ModEntityTypes.BLUE_BUNNY.get(), BlueBunnyRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.BLUE_BUNNY_SMALL.get(), BlueBunnyRendererSmall::new);
        event.registerEntityRenderer(ModEntityTypes.BLUE_BUNNY_LARGE.get(), BlueBunnyRendererLarge::new);

        event.registerEntityRenderer(ModEntityTypes.CYAN_BUNNY.get(), CyanBunnyRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.CYAN_BUNNY_SMALL.get(), CyanBunnyRendererSmall::new);
        event.registerEntityRenderer(ModEntityTypes.CYAN_BUNNY_LARGE.get(), CyanBunnyRendererLarge::new);

        event.registerEntityRenderer(ModEntityTypes.PURPLE_BUNNY.get(), PurpleBunnyRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.PURPLE_BUNNY_SMALL.get(), PurpleBunnyRendererSmall::new);
        event.registerEntityRenderer(ModEntityTypes.PURPLE_BUNNY_LARGE.get(), PurpleBunnyRendererLarge::new);

        event.registerEntityRenderer(ModEntityTypes.YELLOW_BUNNY.get(), YellowBunnyRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.YELLOW_BUNNY_SMALL.get(), YellowBunnyRendererSmall::new);
        event.registerEntityRenderer(ModEntityTypes.YELLOW_BUNNY_LARGE.get(), YellowBunnyRendererLarge::new);
//HALLOWEEN//
        event.registerEntityRenderer(ModEntityTypes.COSTUMED_ZOMBIE.get(), ZombieCostumeRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.COSTUMED_SKELETON.get(), SkeletonCostumeRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.COSTUMED_HUSK.get(), HuskCostumeRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.COSTUMED_DROWNED.get(), DrownedCostumeRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.COSTUMED_DROWNED_MERMAID.get(), DrownedMermaidCostumeRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.COSTUMED_ZOMBIE_VILLAGER.get(), ZombieVillagerCostumeRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.COSTUMED_WITCH.get(), WitchCostumeRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.COSTUMED_CREEPER.get(), CreeperCostumeRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.COSTUMED_SPIDER.get(), SpiderCostumeRenderer::new);

    }

}