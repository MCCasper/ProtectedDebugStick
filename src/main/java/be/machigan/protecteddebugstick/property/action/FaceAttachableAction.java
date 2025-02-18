package be.machigan.protecteddebugstick.property.action;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.FaceAttachable;
import org.jetbrains.annotations.NotNull;

public class FaceAttachableAction implements PropertyAction {

    @Override
    public void modify(@NotNull BlockData data, @NotNull Block block, @NotNull BlockFace blockFace) throws ClassCastException {
        FaceAttachable faceAttachable = (FaceAttachable) data;

        switch (faceAttachable.getAttachedFace()) {
            case CEILING:
                faceAttachable.setAttachedFace(FaceAttachable.AttachedFace.FLOOR);
                break;
            case FLOOR:
                faceAttachable.setAttachedFace(FaceAttachable.AttachedFace.WALL);
                break;
            case WALL:
                faceAttachable.setAttachedFace(FaceAttachable.AttachedFace.CEILING);
                break;
        }

        block.setBlockData(faceAttachable);
    }

    @Override
    public @NotNull String getValue(@NotNull BlockData data, @NotNull BlockFace blockFace) throws ClassCastException {
        FaceAttachable faceAttachable = (FaceAttachable) data;
        return faceAttachable.getAttachedFace().name().toLowerCase();
    }
}
