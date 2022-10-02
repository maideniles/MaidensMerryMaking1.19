package com.maideniles.maidensmerrymaking.event;


import com.maideniles.maidensmerrymaking.MaidensMerryMaking;
import com.maideniles.maidensmerrymaking.init.ModEntityTypes;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MaidensMerryMaking.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class HalloweenEntityEvents {





    public static void initializeMobs() {
        SpawnPlacements.register(ModEntityTypes.COSTUMED_ZOMBIE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(ModEntityTypes.COSTUMED_SKELETON.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
   //     SpawnPlacements.register(ModEntityTypes.COSTUMED_WITHER_SKELETON.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(ModEntityTypes.COSTUMED_HUSK.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(ModEntityTypes.COSTUMED_DROWNED.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(ModEntityTypes.COSTUMED_DROWNED_MERMAID.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);

        SpawnPlacements.register(ModEntityTypes.COSTUMED_ZOMBIE_VILLAGER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
   //     SpawnPlacements.register(ModEntityTypes.COSTUMED_PILLAGER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
    //    SpawnPlacements.register(ModEntityTypes.COSTUMED_VINDICATOR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
   //     SpawnPlacements.register(ModEntityTypes.COSTUMED_EVOKER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(ModEntityTypes.COSTUMED_WITCH.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(ModEntityTypes.COSTUMED_CREEPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(ModEntityTypes.COSTUMED_SPIDER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);


    }

    public static void registerEntityAttributes(EntityAttributeCreationEvent event) {

        event.put(ModEntityTypes.COSTUMED_ZOMBIE.get(), Zombie.createAttributes().build());
        event.put(ModEntityTypes.COSTUMED_SKELETON.get(), Skeleton.createAttributes().build());
    //    event.put(ModEntityTypes.COSTUMED_WITHER_SKELETON.get(), WitherSkeleton.createAttributes().build());
        event.put(ModEntityTypes.COSTUMED_HUSK.get(), Husk.createAttributes().build());
        event.put(ModEntityTypes.COSTUMED_ZOMBIE_VILLAGER.get(), ZombieVillager.createAttributes().build());
    //    event.put(ModEntityTypes.COSTUMED_PILLAGER.get(), Pillager.createAttributes().build());
   //     event.put(ModEntityTypes.COSTUMED_VINDICATOR.get(), Vindicator.createAttributes().build());
      //  event.put(ModEntityTypes.COSTUMED_EVOKER.get(), Evoker.createAttributes().build());
        event.put(ModEntityTypes.COSTUMED_WITCH.get(), Witch.createAttributes().build());
        event.put(ModEntityTypes.COSTUMED_DROWNED.get(), Drowned.createAttributes().build());
        event.put(ModEntityTypes.COSTUMED_DROWNED_MERMAID.get(), Drowned.createAttributes().build());
        event.put(ModEntityTypes.COSTUMED_CREEPER.get(), Creeper.createAttributes().build());
        event.put(ModEntityTypes.COSTUMED_SPIDER.get(), Spider.createAttributes().build());


    }

}
