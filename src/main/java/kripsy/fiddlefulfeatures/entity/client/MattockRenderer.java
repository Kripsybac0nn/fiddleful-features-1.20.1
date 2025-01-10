package kripsy.fiddlefulfeatures.entity.client;

import kripsy.fiddlefulfeatures.FiddlefulFeatures;
import kripsy.fiddlefulfeatures.entity.custom.projectile.MattockEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

public class MattockRenderer extends EntityRenderer<MattockEntity> {
    private static final Identifier TEXTURE = new Identifier(FiddlefulFeatures.MOD_ID, "textures/entity/mattock.png");
    private final MattockModel model;

    public MattockRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new MattockModel(context.getPart(ModModelLayers.MATTOCK));
    }

    @Override
    public Identifier getTexture(MattockEntity entity)  {
        return TEXTURE;
    }



    public void render(MattockEntity MattockEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(g, MattockEntity.prevYaw, MattockEntity.getYaw()) - 90.0f));
        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(g, MattockEntity.prevPitch, MattockEntity.getPitch()) + 90.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(
                vertexConsumerProvider, this.model.getLayer(this.getTexture(MattockEntity)), false, MattockEntity.isEnchanted()
        );
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.pop();
        super.render(MattockEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }


}

