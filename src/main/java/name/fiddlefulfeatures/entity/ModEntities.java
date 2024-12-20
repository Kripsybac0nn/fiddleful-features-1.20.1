package name.fiddlefulfeatures.entity;

import name.fiddlefulfeatures.FiddlefulFeatures;
import name.fiddlefulfeatures.entity.custom.projectile.MattockEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<MattockEntity> MATTOCK_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(FiddlefulFeatures.MOD_ID, "mattock_entity"),
            FabricEntityTypeBuilder.<MattockEntity>create(SpawnGroup.MISC, MattockEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 1f)).build());


}
