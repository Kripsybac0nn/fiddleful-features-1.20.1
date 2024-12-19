package name.fiddlefulfeatures.item.custom;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import name.fiddlefulfeatures.block.ModBlockTags;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.event.GameEvent;

import javax.swing.plaf.nimbus.State;
import java.util.Map;

public class Mattock extends MiningToolItem implements Vanishable {
    protected static final Map<Block, BlockState> PATH_STATES = Maps.newHashMap(new ImmutableMap.Builder<Block, BlockState>().put(Blocks.GRASS_BLOCK, Blocks.DIRT_PATH.getDefaultState()).put(Blocks.DIRT, Blocks.DIRT_PATH.getDefaultState()).put(Blocks.PODZOL, Blocks.DIRT_PATH.getDefaultState()).put(Blocks.COARSE_DIRT, Blocks.DIRT_PATH.getDefaultState()).put(Blocks.MYCELIUM, Blocks.DIRT_PATH.getDefaultState()).put(Blocks.ROOTED_DIRT, Blocks.DIRT_PATH.getDefaultState()).build());
    public Mattock(ToolMaterial material, float attackDamage, float attackSpeed, Item.Settings settings) {
        super(attackDamage, attackSpeed, ToolMaterials.NETHERITE, ModBlockTags.MATTOCK_BREAKABLE, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();

        BlockPos blockPos = context.getBlockPos();
        PlayerEntity playerEntity = context.getPlayer();
        BlockState blockState = world.getBlockState(blockPos);

        ItemStack itemStack = context.getStack();



            // Shovel
            if (context.getSide() != Direction.DOWN) {
                BlockState blockState2 = PATH_STATES.get(blockState.getBlock());
                BlockState blockState3 = null;
                if (blockState2 != null && world.getBlockState(blockPos.up()).isAir()) {
                    world.playSound(playerEntity, blockPos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0f, 1.0f);
                    blockState3 = blockState2;
                } else if (blockState.getBlock() instanceof CampfireBlock && blockState.get(CampfireBlock.LIT).booleanValue()) {
                    if (!world.isClient()) {
                        world.syncWorldEvent(null, WorldEvents.FIRE_EXTINGUISHED, blockPos, 0);
                    }
                    CampfireBlock.extinguish(context.getPlayer(), world, blockPos, blockState);
                    blockState3 = (BlockState)blockState.with(CampfireBlock.LIT, false);
                }
                if (blockState3 != null) {
                    if (!world.isClient) {
                        world.setBlockState(blockPos, blockState3, Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);
                        world.emitGameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Emitter.of(playerEntity, blockState3));
                        return ActionResult.SUCCESS;
                    }
                    else {
                        return ActionResult.SUCCESS;
                    }
                }
                return ActionResult.PASS;
            }


        return ActionResult.PASS;
    }


}




