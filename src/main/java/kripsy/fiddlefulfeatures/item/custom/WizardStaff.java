package kripsy.fiddlefulfeatures.item.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class WizardStaff extends Item {
    private int scaledWidth;
    private int scaledHeight;
    private static final Identifier WIZARD = new Identifier("fiddlefulfeatures:textures/misc/wizard.png");
    public WizardStaff(Settings settings) {
        super(settings);
    }



    private void renderOverlay(DrawContext context, Identifier texture, float opacity) {
        long Time = TimeHelper.SECOND_IN_NANOS * 3;
        opacity = Time/1000000000f;
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        context.setShaderColor(1.0F, 1.0F, 1.0F, opacity);
        int width = context.getScaledWindowWidth();
        int height = context.getScaledWindowHeight();
        context.drawTexture(texture, 0, 0, -90, 0.0F, 0.0F, width, height, width, height);
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
        context.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient()) {
            float secondsRange = 5;
            float ticksPassed = secondsRange * 20;
            
            user.playSound(SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, 1.0F, 0.5F);
            user.playSound(SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, 1.0F, 1.0F);
            user.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.0F, 0.7F);
            user.playSound(SoundEvents.ENTITY_DRAGON_FIREBALL_EXPLODE, 0.8F, 0.8F);

        HudRenderCallback.EVENT.register((drawContext, tickDeltaManager) -> {
            float opacity = 0;
            renderOverlay(drawContext, WIZARD, opacity);


                    if(ticksPassed >= secondsRange) return;
                });
        }
        return TypedActionResult.pass(user.getStackInHand(hand));
    }


}


