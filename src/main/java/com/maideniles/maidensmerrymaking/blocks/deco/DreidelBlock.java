package com.maideniles.maidensmerrymaking.blocks.deco;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DreidelBlock extends HorizontalDecoBlock{

    protected static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 13.0D, 8.0D, 13.0D);

    public DreidelBlock(Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState state, BlockGetter p_48946_, BlockPos p_48947_, CollisionContext p_48948_) {
        return SHAPE;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return super.getStateForPlacement(context).setValue(DIRECTION, context.getHorizontalDirection().getOpposite());

    }
}
