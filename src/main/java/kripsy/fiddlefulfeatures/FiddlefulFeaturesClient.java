package kripsy.fiddlefulfeatures;

import kripsy.fiddlefulfeatures.entity.ModEntities;
import kripsy.fiddlefulfeatures.entity.client.MattockModel;
import kripsy.fiddlefulfeatures.entity.client.MattockRenderer;
import kripsy.fiddlefulfeatures.entity.client.ModModelLayers;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class FiddlefulFeaturesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.MATTOCK, MattockModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.MATTOCK_ENTITY, MattockRenderer::new);


    }
}
