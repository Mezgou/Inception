package net.mezgou.inception.block.entity;

import net.mezgou.inception.item.ModItems;
import net.mezgou.inception.item.inventory.ImplementedInventory;
import net.mezgou.inception.screen.RuneWorkbenchScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class RuneWorkbenchBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(9, ItemStack.EMPTY);

    public RuneWorkbenchBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.RUNE_WORKBENCH, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return new LiteralText("Rune Workbench");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new RuneWorkbenchScreenHandler(syncId, inv, this);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
    }

    public static void tick(World world, BlockPos pos, BlockState state, RuneWorkbenchBlockEntity entity) {
        if(hasRecipe(entity) && hasNotReachedStackLimit(entity)) {
            craftItem(entity);
        }
    }

    private static void craftItem(RuneWorkbenchBlockEntity entity) {
        entity.removeStack(0, 1);
        entity.removeStack(1, 1);
        entity.removeStack(2, 1);
        entity.removeStack(3, 1);
        entity.removeStack(4, 1);
        entity.removeStack(5, 1);
        entity.removeStack(6, 1);
        entity.removeStack(7, 1);

        entity.setStack(8, new ItemStack(ModItems.COBALT_INGOT,
                entity.getStack(8).getCount() + 1));
    }

    private static boolean hasRecipe(RuneWorkbenchBlockEntity entity) {
        boolean hasItemInFirstSlot = entity.getStack(0).getItem() == ModItems.RAW_COBALT;
        boolean hasItemInSecondSlot = entity.getStack(1).getItem() == ModItems.RAW_COBALT;
        boolean hasItemInThirdSlot = entity.getStack(2).getItem() == ModItems.RAW_COBALT;
        boolean hasItemInFourthSlot = entity.getStack(3).getItem() == ModItems.RAW_COBALT;
        boolean hasItemInFifthSlot = entity.getStack(4).getItem() == ModItems.RAW_COBALT;
        boolean hasItemInSixthSlot = entity.getStack(5).getItem() == ModItems.RAW_COBALT;
        boolean hasItemInSeventhSlot = entity.getStack(6).getItem() == ModItems.RAW_COBALT;
        boolean hasItemInEighthSlot = entity.getStack(7).getItem() == ModItems.RAW_COBALT;

        return hasItemInFirstSlot && hasItemInSecondSlot && hasItemInThirdSlot && hasItemInFourthSlot && hasItemInFifthSlot && hasItemInSixthSlot && hasItemInSeventhSlot && hasItemInEighthSlot;
    }

    private static boolean hasNotReachedStackLimit(RuneWorkbenchBlockEntity entity) {
        return entity.getStack(8).getCount() < entity.getStack(8).getMaxCount();
    }
}
