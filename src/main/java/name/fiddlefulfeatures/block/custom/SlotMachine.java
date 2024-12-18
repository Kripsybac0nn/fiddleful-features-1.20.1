package name.fiddlefulfeatures.block.custom;

import name.fiddlefulfeatures.FiddlefulFeatures;
import name.fiddlefulfeatures.item.ModItems;
import name.fiddlefulfeatures.items.Mattock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.brain.task.Task;
import net.minecraft.entity.ai.brain.task.WaitTask;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.server.world.ChunkTaskPrioritySystem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class SlotMachine extends Block {
    public SlotMachine(Settings settings) {
        super(settings);
    }


    public static final BooleanProperty GAMBLEABLE = BooleanProperty.of("gambleable");
    public static boolean REBUILT = false;

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(GAMBLEABLE);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if ((itemStack.isOf(ModItems.COIN)) && !world.isClient() ) {
            world.setBlockState(pos, state.cycle(GAMBLEABLE));
            world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_BIT.value(), SoundCategory.BLOCKS, 1f, 1f);
            itemStack.decrement(1);
            int random = (int)(Math.random()*101);
            FiddlefulFeatures.LOGGER.info("You Rolled A " + random);


            world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_BIT.value(), SoundCategory.BLOCKS, 1f, 2f);
            if (random > -1 && random < 11){dropStack(world, pos, new ItemStack(Items.DIRT, 1));}
            else if (random > 10 && random < 26) {dropStack(world, pos, new ItemStack(Items.IRON_INGOT, 8));}
            else if (random > 25 && random < 51) {dropStack(world, pos, new ItemStack(Items.RAW_GOLD, 11));}
            else if (random > 50 && random < 69) {dropStack(world, pos, new ItemStack(Items.GOLDEN_APPLE, 3));}
            else if (random == 69) {dropStack(world, pos, new ItemStack(ModItems.COIN, 2));}
            else if (random > 69 && random < 90) {dropStack(world, pos, new ItemStack(Items.DIAMOND, 5));}
            else if (random > 89 && random < 100) {dropStack(world, pos, new ItemStack(Items.NETHERITE_SCRAP, 2));}
            else if (random == 100) {
                dropStack(world, pos, new ItemStack(ModItems.ORB, 1));
                world.playSound(player, pos, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 1f, 1f);
                world.setBlockState(pos, state.cycle(GAMBLEABLE));
            }

        }

        return ActionResult.SUCCESS;
    }
}
