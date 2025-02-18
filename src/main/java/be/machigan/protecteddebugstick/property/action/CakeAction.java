package be.machigan.protecteddebugstick.property.action;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Cake;
import org.jetbrains.annotations.NotNull;

public class CakeAction implements PropertyAction {

    @Override
    public void modify(@NotNull BlockData data, @NotNull Block block, @NotNull BlockFace blockFace) throws ClassCastException {
        Cake cake = (Cake) data;

        if (cake.getBites() == cake.getMaximumBites()) {
            cake.setBites(0);
        } else {
            cake.setBites(cake.getBites() + 1);
        }

        block.setBlockData(cake);
    }

    @Override
    public @NotNull String getValue(@NotNull BlockData data, @NotNull BlockFace blockFace) throws ClassCastException {
        Cake cake = (Cake) data;
        return Integer.toString(cake.getBites());
    }
}
