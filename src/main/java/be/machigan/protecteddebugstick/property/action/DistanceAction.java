package be.machigan.protecteddebugstick.property.action;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Leaves;
import org.jetbrains.annotations.NotNull;

public class DistanceAction implements PropertyAction {
    final private static int MAX_DISTANCE = 7; //currently, the max value for the 'distance' property

    @Override
    public void modify(@NotNull BlockData data, @NotNull Block block, @NotNull BlockFace blockFace) throws ClassCastException {
        Leaves leavesData = (Leaves) data;

        if (leavesData.getDistance() == MAX_DISTANCE) {
            leavesData.setDistance(1);
        } else {
            leavesData.setDistance(leavesData.getDistance() + 1);
        }

        block.setBlockData(leavesData);
    }

    @Override
    public @NotNull String getValue(@NotNull BlockData data, @NotNull BlockFace blockFace) throws ClassCastException {
        return Integer.toString(((Leaves) data).getDistance());
    }
}
