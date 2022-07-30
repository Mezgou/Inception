package net.mezgou.inception;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.mezgou.inception.block.ModBlocks;
import net.mezgou.inception.block.entity.ModBlockEntities;
import net.mezgou.inception.item.ModItems;
import net.mezgou.inception.screen.ModScreenHandlers;
import net.mezgou.inception.screen.RuneWorkbenchScreen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Inception implements ModInitializer {
	public static final String MOD_ID = "inception";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlock();

		ModBlockEntities.registerAllBlockEntities();

		ScreenRegistry.register(ModScreenHandlers.RUNE_WORKBENCH_SCREEN_HANDLER, RuneWorkbenchScreen::new);
	}
}
