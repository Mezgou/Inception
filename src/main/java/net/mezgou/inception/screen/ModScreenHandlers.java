package net.mezgou.inception.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.mezgou.inception.Inception;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static ScreenHandlerType<RuneWorkbenchScreenHandler> RUNE_WORKBENCH_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(new Identifier(Inception.MOD_ID, "rune_workbench"),
                    RuneWorkbenchScreenHandler::new);
}
