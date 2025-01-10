package kripsy.fiddlefulfeatures;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class SoundEventRegistry {
    public static final Identifier PLUSHIE_PAT_SOUND_ID = Identifier.of(FiddlefulFeatures.MOD_ID,"plushie_pat_sound");
    public static SoundEvent PLUSHIE_PAT_SOUND_EVENT = SoundEvent.of(PLUSHIE_PAT_SOUND_ID);
    public static BlockSoundGroup PLUSHIE_SOUND_GROUP = new BlockSoundGroup(0.8f,1.05f, PLUSHIE_PAT_SOUND_EVENT, SoundEvents.BLOCK_WOOL_STEP,PLUSHIE_PAT_SOUND_EVENT,SoundEvents.BLOCK_WOOL_HIT,PLUSHIE_PAT_SOUND_EVENT);

    public static void registerSoundEvents() {
        FiddlefulFeatures.LOGGER.info("Registering Sound Events for " + FiddlefulFeatures.MOD_ID);

        Registry.register(Registries.SOUND_EVENT, PLUSHIE_PAT_SOUND_ID, PLUSHIE_PAT_SOUND_EVENT);
    }
}
