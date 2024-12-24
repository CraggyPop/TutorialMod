package co.za.ren.tutorialmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class ChiselItem extends Item {

    private static final Map<Block, Block> CHISEL_MAP = Map.ofEntries(
            Map.entry(Blocks.STONE, Blocks.STONE_BRICKS),
            Map.entry(Blocks.INFESTED_STONE, Blocks.INFESTED_STONE_BRICKS),
            Map.entry(Blocks.STONE_BRICKS, Blocks.CHISELED_STONE_BRICKS),
            Map.entry(Blocks.INFESTED_STONE_BRICKS, Blocks.INFESTED_CHISELED_STONE_BRICKS),
            Map.entry(Blocks.SANDSTONE, Blocks.CHISELED_SANDSTONE),
            Map.entry(Blocks.RED_SANDSTONE, Blocks.CHISELED_RED_SANDSTONE),
            Map.entry(Blocks.QUARTZ_BLOCK, Blocks.CHISELED_QUARTZ_BLOCK),
            Map.entry(Blocks.DEEPSLATE, Blocks.DEEPSLATE_TILES),
            Map.entry(Blocks.DEEPSLATE_TILES, Blocks.DEEPSLATE_BRICKS),
            Map.entry(Blocks.DEEPSLATE_BRICKS, Blocks.CHISELED_DEEPSLATE),
            Map.entry(Blocks.NETHER_BRICKS, Blocks.CHISELED_NETHER_BRICKS),
            Map.entry(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE),
            Map.entry(Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS),
            Map.entry(Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.CHISELED_POLISHED_BLACKSTONE),
            Map.entry(Blocks.TUFF, Blocks.TUFF_BRICKS),
            Map.entry(Blocks.TUFF_BRICKS, Blocks.CHISELED_TUFF_BRICKS),
            Map.entry(Blocks.CHISELED_TUFF_BRICKS, Blocks.CHISELED_TUFF),
            Map.entry(Blocks.COPPER_BLOCK, Blocks.CHISELED_COPPER),
            Map.entry(Blocks.WEATHERED_COPPER, Blocks.WEATHERED_CHISELED_COPPER),
            Map.entry(Blocks.EXPOSED_COPPER, Blocks.EXPOSED_CHISELED_COPPER),
            Map.entry(Blocks.OXIDIZED_COPPER, Blocks.OXIDIZED_CHISELED_COPPER),
            Map.entry(Blocks.WAXED_COPPER_BLOCK, Blocks.WAXED_CHISELED_COPPER),
            Map.entry(Blocks.WAXED_WEATHERED_COPPER, Blocks.WAXED_WEATHERED_CHISELED_COPPER),
            Map.entry(Blocks.WAXED_EXPOSED_COPPER, Blocks.WAXED_EXPOSED_CHISELED_COPPER),
            Map.entry(Blocks.WAXED_OXIDIZED_COPPER, Blocks.WAXED_OXIDIZED_CHISELED_COPPER),
            Map.entry(Blocks.END_STONE, Blocks.END_STONE_BRICKS)
    );

    public ChiselItem(Settings settings){
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(CHISEL_MAP.containsKey(clickedBlock)) {
            if(!world.isClient()) {
                world.setBlockState(context.getBlockPos(), CHISEL_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, (ServerWorld) world, (ServerPlayerEntity) context.getPlayer(),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);
            }
        }

        return ActionResult.SUCCESS;
    }
}
