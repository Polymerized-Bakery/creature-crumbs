package com.daedreus.Bakery.CreatureCrumbs;

import eu.pb4.polymer.core.api.entity.PolymerEntityUtils;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.*;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;
import net.minecraft.entity.EntityType.EntityFactory;
import net.minecraft.registry.Registry;
public class MobRegistry {
    public static final EntityType<Flare> Flare = register(
            com.daedreus.Bakery.CreatureCrumbs.Flare.ID,
            EntityType.EntityFactory
                    .EntityFactory(Flare::new)
                    .spawnGroup(SpawnGroup.MONSTER)
                    .dimensions(EntityDimensions.changing(1.8f, 2.7f))
                    .defaultAttributes(Flare::createAttributes)
                    .spawnRestriction(SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::checkMonsterSpawnRules)
                    .trackRangeChunks(8)
    );

    private static <T extends Entity> EntityType<T> register(Identifier id, FabricEntityTypeBuilder<T> builder) {
        EntityType<T> type = builder.build();
        PolymerEntityUtils.registerType(type);
        return Registry.register(Registries.ENTITY_TYPE, id, type);
    }

    public static void registerMobs() {
    }
}