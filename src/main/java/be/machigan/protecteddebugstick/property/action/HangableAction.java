package be.machigan.protecteddebugstick.property.action;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Hangable;
import org.jetbrains.annotations.NotNull;

public class HangableAction implements PropertyAction {

    @Override
    public void modify(@NotNull BlockData data, @NotNull Block block, @NotNull BlockFace blockFace) throws ClassCastException {
        Hangable hangableData = (Hangable) data;

        hangableData.setHanging(!hangableData.isHanging());

        block.setBlockData(hangableData);
    }

    @Override
    public @NotNull String getValue(@NotNull BlockData data, @NotNull BlockFace blockFace) throws ClassCastException {
        Hangable hangableData = (Hangable) data;
        return Boolean.toString(hangableData.isHanging());
    }
}
