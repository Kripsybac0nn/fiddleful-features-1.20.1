package name.fiddlefulfeatures.item.custom;

import name.fiddlefulfeatures.FiddlefulFeatures;
import name.fiddlefulfeatures.item.ModItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
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
