package name.fiddlefulfeatures.item.custom;


import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import name.fiddlefulfeatures.FiddlefulFeatures;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Vanishable;
import net.minecraft.network.packet.s2c.play.TitleS2CPacket;
import net.minecraft.server.command.ExecuteCommand;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;


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

    public WalletWhacker(FabricItemSettings settings, Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers) {
        super(settings);

        this.attributeModifiers = attributeModifiers;
    }




    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.fiddlefulfeatures.walletwhacker.tooltip").formatted(Formatting.ITALIC,Formatting.DARK_GRAY));
    }


    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        FiddlefulFeatures.LOGGER.info("You Rolled A " + 1);
        Object RegistryEntry;
        int random = (int)(Math.random()*21);
        FiddlefulFeatures.LOGGER.info("You Rolled A " + random);



        if (random == 1) {attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 0), attacker);}
        else if (random == 2) {attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300, 0), attacker);}
        else if (random == 3) {target.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 300, 1), attacker);}
        else if (random == 4) {target.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 150, 5), attacker);
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 5), attacker);}
        else if (random == 5) {target.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 600, 2), attacker);}
        else if (random == 6) {target.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 6000, 5, false, false), attacker);}
        else if (random == 7) {target.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 1), attacker);}
        else if (random == 8) {target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200, 5), attacker);
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200, 5), attacker);
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 200, 5), attacker);}
        else if (random == 9) {target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 600, 1), attacker);}
        else if (random == 10) {target.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 20, 255), attacker);}
        else if (random == 11) {target.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 600, 1), attacker);}
        else if (random == 12) {target.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 10, 9), attacker);}
        else if (random == 13) {target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 300, 0), attacker);}
        else if (random == 14) {target.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 0), attacker);}
        else if (random == 15) {attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 40, 5), attacker);}
        else if (random == 16) {target.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 600, 0), attacker);}
        else if (random == 17) {attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 100, 9), attacker);}
        else if (random == 18) {attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 100, 10), attacker);}
        else if (random == 19) {target.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 20, 20), attacker);}
        else if (random == 20) {target.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 140, 1), attacker);}

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

