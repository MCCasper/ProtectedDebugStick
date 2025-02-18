package be.machigan.protecteddebugstick.property.action;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.PointedDripstone;
import org.jetbrains.annotations.NotNull;

public class VerticalDirectionAction implements PropertyAction {

    @Override
    public void modify(@NotNull BlockData data, @NotNull Block block, @NotNull BlockFace blockFace) throws ClassCastException {
        PointedDripstone dripstone = (PointedDripstone) data;

        switch (dripstone.getVerticalDirection()) {
            case UP:
                dripstone.setVerticalDirection(BlockFace.DOWN);
                break;
            case DOWN:
                dripstone.setVerticalDirection(BlockFace.UP);
                break;
        }

        block.setBlockData(dripstone);
    }

    @Override
    public @NotNull String getValue(@NotNull BlockData data, @NotNull BlockFace blockFace) throws ClassCastException {
        PointedDripstone dripstone = (PointedDripstone) data;
        return dripstone.getVerticalDirection().name().toLowerCase();
    }
}
