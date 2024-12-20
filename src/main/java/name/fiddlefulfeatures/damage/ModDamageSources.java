package name.fiddlefulfeatures.damage;

import name.fiddlefulfeatures.FiddlefulFeatures;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.entry.RegistryEntry;

public class ModDamageSources extends DamageSources {
    public ModDamageSources(DynamicRegistryManager registryManager) {
        super(registryManager);
    }

    public static final DamageSource GAMBLING = new DamageSource((RegistryEntry<DamageType>) DamageTypes.FALLING_ANVIL);


}
