package name.fiddlefulfeatures;

import name.fiddlefulfeatures.entity.ModEntities;
import name.fiddlefulfeatures.entity.client.MattockModel;
import name.fiddlefulfeatures.entity.client.MattockRenderer;
import name.fiddlefulfeatures.entity.client.ModModelLayers;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.TridentEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class FiddlefulFeaturesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.MATTOCK, MattockModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.MATTOCK_ENTITY, MattockRenderer::new);

    }
}
