package name.fiddlefulfeatures.sound;

import name.fiddlefulfeatures.FiddlefulFeatures;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent WALLETWHACKER_HIT = registerSoundEvent("walletwhacker_hit");


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(FiddlefulFeatures.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));

    }
    public static void registerSounds() {
        FiddlefulFeatures.LOGGER.info("Registering Mod Sounds for " + FiddlefulFeatures.MOD_ID);
    }
}
