package name.fiddlefulfeatures.entity.client;


import name.fiddlefulfeatures.entity.custom.projectile.MattockEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class MattockModel<T extends MattockEntity> extends SinglePartEntityModel<T> {
	private final ModelPart mattock;
	public MattockModel(ModelPart root) {
		this.mattock = root.getChild("mattock");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData mattock = modelPartData.addChild("mattock", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 16.0F, 0.0F));

		ModelPartData head = mattock.addChild("head", ModelPartBuilder.create().uv(20, 12).cuboid(-1.0F, -14.0F, -6.0F, 2.0F, 4.0F, 4.0F, new Dilation(0.2F))
				.uv(20, 20).cuboid(-1.0F, -14.0F, -5.0F, 2.0F, 1.0F, 5.0F, new Dilation(0.0F))
				.uv(0, 12).cuboid(-1.0F, -15.0F, -5.0F, 2.0F, 1.0F, 8.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-1.0F, -16.0F, -6.0F, 2.0F, 1.0F, 11.0F, new Dilation(0.1F))
				.uv(26, 0).cuboid(-1.0F, -12.0F, -7.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.1F))
				.uv(10, 21).cuboid(-1.0F, -10.0F, -8.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F))
				.uv(26, 9).cuboid(-1.0F, -6.0F, -8.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 8.0F, 0.0F));

		ModelPartData stick = mattock.addChild("stick", ModelPartBuilder.create().uv(0, 21).cuboid(-1.0F, -3.0F, 5.0F, 2.0F, 3.0F, 3.0F, new Dilation(0.3F))
				.uv(26, 5).cuboid(-1.0F, -4.0F, 4.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.2F))
				.uv(18, 26).cuboid(-1.0F, -5.0F, 3.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(26, 26).cuboid(-1.0F, -6.0F, 2.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.1F))
				.uv(0, 27).cuboid(-1.0F, -7.0F, 1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(8, 27).cuboid(-1.0F, -8.0F, 0.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.2F))
				.uv(16, 30).cuboid(-1.0F, -9.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(24, 30).cuboid(-1.0F, -10.0F, -2.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.1F))
				.uv(0, 31).cuboid(-1.0F, -11.0F, -3.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 8.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(MattockEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		mattock.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return mattock;
	}
}