package name.fiddlefulfeatures.item.custom;


import name.fiddlefulfeatures.FiddlefulFeatures;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class WalletWhacker extends Item {
    public WalletWhacker(Settings settings) {
        super(settings);

    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.fiddlefulfeatures.walletwhacker.tooltip").formatted(Formatting.ITALIC,Formatting.DARK_GRAY));
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        FiddlefulFeatures.LOGGER.info("You Rolled A " + 1);
        Object RegistryEntry;
        // target.damage(mobAttack(attacker), 1);
        return false;
    }

}

