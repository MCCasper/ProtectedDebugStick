package be.machigan.protecteddebugstick.property.action;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.RespawnAnchor;
import org.jetbrains.annotations.NotNull;

public class ChargesAction implements PropertyAction {

    @Override
    public void modify(@NotNull BlockData data, @NotNull Block block, @NotNull BlockFace blockFace) throws ClassCastException {
        RespawnAnchor respawnAnchor = (RespawnAnchor) data;

        if (respawnAnchor.getCharges() == respawnAnchor.getMaximumCharges()) {
            respawnAnchor.setCharges(0);
        } else {
            respawnAnchor.setCharges(respawnAnchor.getCharges() + 1);
        }

        block.setBlockData(respawnAnchor);
    }

    @Override
    public @NotNull String getValue(@NotNull BlockData data, @NotNull BlockFace blockFace) throws ClassCastException {
        RespawnAnchor respawnAnchor = (RespawnAnchor) data;
        return Integer.toString(respawnAnchor.getCharges());
    }
}
