package net.mezgou.inception.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.mezgou.inception.Inception;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item RAW_COBALT = registerItem("raw_cobalt",
            new Item(new FabricItemSettings().group(ModItemGroup.ENRICHMENT)));

    public static final Item COBALT_INGOT = registerItem("cobalt_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.ENRICHMENT)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Inception.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Inception.LOGGER.info("Registering Mod Items for " + Inception.MOD_ID);
    }
}
