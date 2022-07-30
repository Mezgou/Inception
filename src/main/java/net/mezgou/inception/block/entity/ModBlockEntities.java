package net.mezgou.inception.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.mezgou.inception.Inception;
import net.mezgou.inception.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModBlockEntities {
    public static BlockEntityType<RuneWorkbenchBlockEntity> RUNE_WORKBENCH;

    public static void registerAllBlockEntities() {
        RUNE_WORKBENCH = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(Inception.MOD_ID, "rune_workbench"),
                FabricBlockEntityTypeBuilder.create(RuneWorkbenchBlockEntity::new,
                        ModBlocks.RUNE_WORKBENCH).build(null));
    }

}
