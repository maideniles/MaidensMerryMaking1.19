package com.maideniles.maidensmerrymaking.util;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;

import java.io.File;

public class MerryMakingConfig {
    public static ForgeConfigSpec SERVER_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;
    public static ForgeConfigSpec.IntValue CHRISTMAS_PRESENT_CHEST_SPAWN;
    public static ForgeConfigSpec.BooleanValue CHRISTMAS_ENABLED;
    public static ForgeConfigSpec.BooleanValue HOLLY_ENABLED;
    public static ForgeConfigSpec.BooleanValue TINY_SPRUCE_ENABLED;
    public static ForgeConfigSpec.BooleanValue ST_PATRICKS_DAY_ENABLED;
    public static ForgeConfigSpec.BooleanValue CLOVER_ENABLED;
    public static ForgeConfigSpec.BooleanValue EASTER_ENABLED;
    public static ForgeConfigSpec.BooleanValue HALLOWEEN_ENABLED;
    public static ForgeConfigSpec.BooleanValue GRAVESTONES_ENABLED;
    public static ForgeConfigSpec.BooleanValue COSTUMES_ENABLED;
    public static ForgeConfigSpec.IntValue HALLOWEEN_DISC_CHEST_SPAWN;
    public static ForgeConfigSpec.IntValue COLORED_EGG_SPAWN;
    public static ForgeConfigSpec.IntValue EASTER_BASKET_CHEST_SPAWN;
    public static ForgeConfigSpec.BooleanValue EASTER_LILY_ENABLED;
    public static ForgeConfigSpec.BooleanValue HYDRANGEA_ENABLED;
    public static ForgeConfigSpec.BooleanValue HYACINTH_ENABLED;
    public static ForgeConfigSpec.BooleanValue COLORED_CHICKEN_WORLD_SPAWN;


    static {
        ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
        ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

        makeConfigs(SERVER_BUILDER, CLIENT_BUILDER);

        SERVER_CONFIG= SERVER_BUILDER.build();
        CLIENT_CONFIG= CLIENT_BUILDER.build();

    }

    private static void makeConfigs(ForgeConfigSpec.Builder SERVER_BUILDER, ForgeConfigSpec.Builder CLIENT_BUILDER) {
        {
    //BEGIN CHRISTMAS/WINTER CONTENT//
            CHRISTMAS_PRESENT_CHEST_SPAWN = SERVER_BUILDER.comment("Christmas presents can spawn in chests. Set to 0 to disable")
                    .defineInRange("christmas_present_chest_spawn", 1, 0, Integer.MAX_VALUE);

            CHRISTMAS_ENABLED = SERVER_BUILDER.comment("Enable Christmas Recipes such as armor, foods, decorations. Set to False to disable")
                    .define("christmas_enabled", true);

            HOLLY_ENABLED = SERVER_BUILDER.comment("Enable Holly tree to spawn in world. Set to False to disable")
                    .define("holly_enabled", true);

            TINY_SPRUCE_ENABLED = SERVER_BUILDER.comment("Enable Tiny Spruce tree to spawn in world. Set to False to disable")
                    .define("tiny_spruce_enabled", true);

//BEGIN ST PATRICK'S DAY CONTENT//
            ST_PATRICKS_DAY_ENABLED = SERVER_BUILDER.comment("Enable Pot O Gold Spawn and St Patrick's Day Recipes.")
                    .define("st_patricks_day_enabled", true);

            CLOVER_ENABLED = SERVER_BUILDER.comment("Enable Clover to grow naturally in the world. Set to False to disable")
                    .define("clover_enabled", true);

//BEGIN EASTER CONTENT//
            EASTER_ENABLED = SERVER_BUILDER.comment("Enable Easter recipes.")
                    .define("easter_enabled", true);

            COLORED_EGG_SPAWN = SERVER_BUILDER.comment("Chickens will drop colored eggs. Set to 0 to disable")
                    .defineInRange("colored_egg_spawn", 1, 0, Integer.MAX_VALUE);

            EASTER_BASKET_CHEST_SPAWN = SERVER_BUILDER.comment("Easter baskets can spawn in chests. Set to 0 to disable")
                    .defineInRange("easter_basket_chest_spawn", 1, 0, Integer.MAX_VALUE);

            EASTER_LILY_ENABLED = SERVER_BUILDER.comment("Enable Easter Lily flower to grow naturally in the world. Set to False to disable")
                    .define("easter_lily_enabled", true);

            HYDRANGEA_ENABLED = SERVER_BUILDER.comment("Enable Hydrangea flower to grow naturally in the world.  Set to False to disable")
                    .define("hydrangea_enabled", true);

            HYACINTH_ENABLED = SERVER_BUILDER.comment("Enable Hyacinth flower to grow naturally in the world. Set to False to disable")
                    .define("hyacinth_enabled", true);

            COLORED_CHICKEN_WORLD_SPAWN = SERVER_BUILDER.comment("Enable Colored Chickens to spawn naturally in the world. Set to False to disable")
                    .define("colored_chicken_enabled", true);

//BEGIN HALLOWEEN CONTENT//
            HALLOWEEN_ENABLED = SERVER_BUILDER.comment("Enable Halloween recipes.")
                    .define("halloween_enabled", true);

            COSTUMES_ENABLED = SERVER_BUILDER.comment("Enable Costumed Mobs to spawn in the world. Set to False to disable")
                    .define("costumes_enabled", true);

            GRAVESTONES_ENABLED = SERVER_BUILDER.comment("Enable Gravestones to spawn in the world. Set to False to disable")
                    .define("gravestones_enabled", true);

            HALLOWEEN_DISC_CHEST_SPAWN = SERVER_BUILDER.comment("Halloween Discs can spawn in chests. Set to 0 to disable")
                    .defineInRange("halloween_disc_chest_spawn", 1, 0, Integer.MAX_VALUE);

        }


    }
    public static void loadConfigFile(ForgeConfigSpec config, String path)
    {

        final CommentedFileConfig file = CommentedFileConfig.builder(new File(path))
                .sync().autosave().writingMode(WritingMode.REPLACE).build();
        file.load();
        config.setConfig(file);

    }

}

