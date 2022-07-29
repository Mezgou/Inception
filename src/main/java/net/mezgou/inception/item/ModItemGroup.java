package net.mezgou.inception.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.mezgou.inception.Inception;
import net.mezgou.inception.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup ENRICHMENT = FabricItemGroupBuilder.build(new Identifier(Inception.MOD_ID, "enrichment"),
            () -> new ItemStack(ModBlocks.ENRICHMENT_STONE));
}
