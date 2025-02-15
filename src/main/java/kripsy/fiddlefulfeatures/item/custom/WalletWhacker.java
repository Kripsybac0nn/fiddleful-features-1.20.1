package kripsy.fiddlefulfeatures.item.custom;


import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Vanishable;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import net.minecraft.entity.LivingEntity;

import java.util.List;
import java.util.Objects;


import static net.minecraft.block.entity.BeaconBlockEntity.playSound;


public class WalletWhacker extends Item implements Vanishable {
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
    public WalletWhacker(Settings settings, int attackDamage, float attackSpeed) {
        super(settings);


        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(
                EntityAttributes.GENERIC_ATTACK_DAMAGE,
                new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Tool modifier", 7.0, EntityAttributeModifier.Operation.ADDITION)
        );
        builder.put(
                EntityAttributes.GENERIC_ATTACK_SPEED,
                new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Tool modifier", -2.4F, EntityAttributeModifier.Operation.ADDITION)
        );
        this.attributeModifiers = builder.build();
    }

    protected ParticleEffect getParticles() {
        return ParticleTypes.ITEM_SLIME;
    }



    public WalletWhacker(FabricItemSettings settings, Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers) {
        super(settings);

        this.attributeModifiers = attributeModifiers;
    }




    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.fiddlefulfeatures.walletwhacker.tooltip").formatted(Formatting.ITALIC,Formatting.DARK_GRAY));
    }
    private void spawnEffectsCloud(LivingEntity entity) {
        {
            AreaEffectCloudEntity areaEffectCloudEntity = new AreaEffectCloudEntity(entity.getWorld(), entity.getX(), entity.getY(), entity.getZ());

            areaEffectCloudEntity.setRadius(2.5F);
            areaEffectCloudEntity.setRadiusOnUse(-0.5F);
            areaEffectCloudEntity.setWaitTime(10);
            areaEffectCloudEntity.setDuration(areaEffectCloudEntity.getDuration() / 2);
            areaEffectCloudEntity.setRadiusGrowth(-areaEffectCloudEntity.getRadius() / (float)areaEffectCloudEntity.getDuration());


                areaEffectCloudEntity.addEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE));


            entity.getWorld().spawnEntity(areaEffectCloudEntity);
        }
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int random = (int)(Math.random()*21);
        attacker.sendMessage(Text.literal("Rolled " + random).formatted(Formatting.DARK_GRAY,Formatting.ITALIC));
        // execute command for later
        if (attacker != null) {
            CommandManager commandManager = (Objects.requireNonNull(attacker.getServer())).getCommandManager();
            ServerCommandSource commandSource = attacker.getServer().getCommandSource();
            commandManager.executeWithPrefix(commandSource, "execute at @p particle minecraft:heart ~ ~ ~ ~ ~ ~ 1 5 force");}
        if (random < 20 && random > 0){

        playSound(attacker.getWorld(), attacker.getBlockPos(), SoundEvents.BLOCK_BAMBOO_PLACE);
            playSound(attacker.getWorld(), attacker.getBlockPos(), SoundEvents.BLOCK_BAMBOO_HIT);
            assert MinecraftClient.getInstance().world != null;
            MinecraftClient.getInstance().world.addParticle(ParticleTypes.END_ROD, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int)(Math.random()*20-10)/100f, (int)(Math.random()*10)/100f, (int)(Math.random()*20-10)/100f);
            MinecraftClient.getInstance().world.addParticle(ParticleTypes.END_ROD, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int)(Math.random()*20-10)/100f, (int)(Math.random()*10)/100f, (int)(Math.random()*20-10)/100f);
            MinecraftClient.getInstance().world.addParticle(ParticleTypes.END_ROD, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int)(Math.random()*20-10)/100f, (int)(Math.random()*10)/100f, (int)(Math.random()*20-10)/100f);
            MinecraftClient.getInstance().world.addParticle(ParticleTypes.END_ROD, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int)(Math.random()*20-10)/100f, (int)(Math.random()*10)/100f, (int)(Math.random()*20-10)/100f);
            MinecraftClient.getInstance().world.addParticle(ParticleTypes.END_ROD, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int)(Math.random()*20-10)/100f, (int)(Math.random()*10)/100f, (int)(Math.random()*20-10)/100f);
        }
        if (random == 1) {attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 0), attacker);}
        else if (random == 2) {attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 200, 0), attacker);}
        else if (random == 3) {target.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 300, 1), attacker);}
        else if (random == 4) {target.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 150, 5), attacker);
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 5), attacker);}
        else if (random == 5) {target.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 300, 2), attacker);}
        else if (random == 6) {attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 6000, 5, true, false), attacker);}
        else if (random == 7) {target.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 1), attacker);}
        else if (random == 8) {target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200, 5), attacker);
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200, 5), attacker);
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 200, 5), attacker);}
        else if (random == 9) {target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 1), attacker);}
        else if (random == 10) {target.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 20, 255), attacker);}
        else if (random == 11) {target.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 600, 1), attacker);}
        else if (random == 12) {target.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 10, 20), attacker);}
        else if (random == 13) {target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 150, 1), attacker);}
        else if (random == 14) {target.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 0), attacker);}
        else if (random == 15) {attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 60, 5), attacker);}
        else if (random == 16) {target.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 600, 0), attacker);}
        else if (random == 17) {attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 100, 9), attacker);}
        else if (random == 18) {attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 100, 20), attacker);}
        else if (random == 19) {target.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 10, 40), attacker);}
        else if (random == 20) {
            target.damage(attacker.getDamageSources().mobAttack(attacker), 40);
            playSound(attacker.getWorld(), attacker.getBlockPos(), SoundEvents.ENTITY_ENDER_EYE_DEATH);
            playSound(attacker.getWorld(), attacker.getBlockPos(), SoundEvents.BLOCK_NOTE_BLOCK_BELL.value());
            playSound(attacker.getWorld(), attacker.getBlockPos(), SoundEvents.BLOCK_AMETHYST_BLOCK_BREAK);
            playSound(attacker.getWorld(), attacker.getBlockPos(), SoundEvents.BLOCK_SHROOMLIGHT_BREAK);
            assert MinecraftClient.getInstance().world != null;
            MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.TOTEM_OF_UNDYING, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);
            MinecraftClient.getInstance().world.addParticle(ParticleTypes.FALLING_SPORE_BLOSSOM, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);
            MinecraftClient.getInstance().world.addParticle(ParticleTypes.FALLING_SPORE_BLOSSOM, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);
            MinecraftClient.getInstance().world.addParticle(ParticleTypes.FALLING_SPORE_BLOSSOM, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);
            MinecraftClient.getInstance().world.addParticle(ParticleTypes.FALLING_SPORE_BLOSSOM, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);MinecraftClient.getInstance().world.addParticle(ParticleTypes.FALLING_SPORE_BLOSSOM, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);
            MinecraftClient.getInstance().world.addParticle(ParticleTypes.FALLING_SPORE_BLOSSOM, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);
            MinecraftClient.getInstance().world.addParticle(ParticleTypes.FALLING_SPORE_BLOSSOM, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);
            MinecraftClient.getInstance().world.addParticle(ParticleTypes.FALLING_SPORE_BLOSSOM, target.getX() + 0, target.getY() + 1, target.getZ() + 0, (int) (Math.random() * 20 - 10)/10f, (int) (Math.random() * 10)/10f, (int) (Math.random() * 20 - 10)/10f);




        }

        return false;
    }



    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(slot);
    }



    @Override
    public int getEnchantability() {
        return 1;
    }


}

