package kripsy.fiddlefulfeatures.entity.client;

import kripsy.fiddlefulfeatures.FiddlefulFeatures;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer MATTOCK =
            new EntityModelLayer(new Identifier(FiddlefulFeatures.MOD_ID, "mattock" ), "main") ;
}
