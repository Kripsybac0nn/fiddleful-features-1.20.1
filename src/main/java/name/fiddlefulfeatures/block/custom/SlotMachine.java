package name.fiddlefulfeatures.block.custom;

import name.fiddlefulfeatures.FiddlefulFeatures;
import name.fiddlefulfeatures.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;


public class SlotMachine extends Block {
    public SlotMachine(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }


    public static final BooleanProperty GAMBLEABLE = BooleanProperty.of("gambleable");
    public static final IntProperty STATE = IntProperty.of("state", 1, 3);


    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(GAMBLEABLE);
        builder.add(STATE);
        builder.add(Properties.HORIZONTAL_FACING);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if ((itemStack.isOf(ModItems.COIN)) && world.isClient() && ((Boolean)state.get(GAMBLEABLE)) && !(state.get(STATE)==2)) {
            world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_BIT.value(), SoundCategory.BLOCKS, 1f, 2f);}
        if ((itemStack.isOf(ModItems.COIN)) && !world.isClient() && ((Boolean)state.get(GAMBLEABLE)) && !(state.get(STATE)==2)) {


            world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_BIT.value(), SoundCategory.BLOCKS, 1f, 1f);
            itemStack.decrement(1);
            int random = (int)(Math.random()*101);
            FiddlefulFeatures.LOGGER.info("You Rolled A " + random);

            world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_BIT.value(), SoundCategory.BLOCKS, 1f, 1f);
            if (random > -1 && random < 11){dropStack(world, pos, new ItemStack(Items.DIRT, 1));}
            else if (random > 10 && random < 26) {dropStack(world, pos, new ItemStack(Items.IRON_INGOT, 8));}
            else if (random > 25 && random < 51) {dropStack(world, pos, new ItemStack(Items.RAW_GOLD, 11));}
            else if (random > 50 && random < 69) {dropStack(world, pos, new ItemStack(Items.GOLDEN_APPLE, 3));}
            else if (random == 69) {dropStack(world, pos, new ItemStack(ModItems.COIN, 2));}
            else if (random > 69 && random < 90) {dropStack(world, pos, new ItemStack(Items.DIAMOND, 5));}
            else if (random > 89 && random < 100) {dropStack(world, pos, new ItemStack(Items.NETHERITE_SCRAP, 2));}
            else if (random == 100) { if ((state.get(STATE)==1)) {
                dropStack(world, pos, new ItemStack(ModItems.WALLETWHACKER, 1));
                world.playSound(player, pos, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 1f, 1f);
                world.setBlockState(pos, state.cycle(STATE));}
                else {dropStack(world, pos, new ItemStack(Items.ENCHANTED_GOLDEN_APPLE, 1));}}

        }
        if ((itemStack.isOf(Items.LEVER)) && !world.isClient() && (state.get(STATE)==2)) {
            world.setBlockState(pos, state.cycle(STATE));
            world.playSound(player, pos, SoundEvents.BLOCK_DEEPSLATE_BRICKS_BREAK, SoundCategory.BLOCKS, 2f, 1f);
            itemStack.decrement(1);
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(Properties.HORIZONTAL_FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

}
