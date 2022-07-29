package net.mezgou.inception.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.mezgou.inception.Inception;
import net.mezgou.inception.item.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block ENRICHMENT_STONE = registerBlock("enrichment_stone",
            new Block(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE)
                    .strength(6f).requiresTool().luminance(7)), ModItemGroup.ENRICHMENT);

    public static final Block BLOCK_OF_COBALT = registerBlock("block_of_cobalt",
            new Block(FabricBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.METAL)
                    .strength(8f).requiresTool()), ModItemGroup.ENRICHMENT);

    public static final Block COBALT_ORE = registerBlock("cobalt_ore",
            new Block(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE)
                    .strength(8f).requiresTool()), ModItemGroup.ENRICHMENT);

    private static final Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(Inception.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(Inception.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlock() {
        Inception.LOGGER.info("Registering ModBlocks for " + Inception.MOD_ID);
    }
}
