package be.machigan.protecteddebugstick.property.action;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.SculkCatalyst;
import org.jetbrains.annotations.NotNull;

public class BloomAction implements PropertyAction {

    @Override
    public void modify(@NotNull BlockData data, @NotNull Block block, @NotNull BlockFace blockFace) throws ClassCastException {
        SculkCatalyst sculkCatalyst = (SculkCatalyst) data;

        sculkCatalyst.setBloom(!sculkCatalyst.isBloom());

        block.setBlockData(sculkCatalyst);
    }

    @Override
    public @NotNull String getValue(@NotNull BlockData data, @NotNull BlockFace blockFace) throws ClassCastException {
        SculkCatalyst sculkCatalyst = (SculkCatalyst) data;
        return Boolean.toString(sculkCatalyst.isBloom());
    }
}
