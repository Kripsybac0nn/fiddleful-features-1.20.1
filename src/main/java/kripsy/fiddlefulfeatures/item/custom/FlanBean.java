package kripsy.fiddlefulfeatures.item.custom;

import kripsy.fiddlefulfeatures.item.ModItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FlanBean extends Item {

    public FlanBean(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.fiddlefulfeatures.flanbean.tooltip").formatted(Formatting.ITALIC,Formatting.DARK_GRAY,Formatting.STRIKETHROUGH));
        tooltip.add(Text.translatable("tooltip.fiddlefulfeatures.flanbean2.tooltip").formatted(Formatting.ITALIC,Formatting.DARK_GRAY));
    }


    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        DamageSource damageSource = new DamageSource(
                world.getRegistryManager()
                        .get(RegistryKeys.DAMAGE_TYPE)
                        .entryOf(ModItems.BEAN_DAMAGE));
        user.damage(damageSource, 10000);
        ItemStack itemStack = super.finishUsing(stack, world, user);

        return itemStack;
    }
}
