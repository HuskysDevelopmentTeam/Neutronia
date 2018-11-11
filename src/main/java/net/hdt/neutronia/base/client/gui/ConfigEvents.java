package net.hdt.neutronia.base.client.gui;

import com.google.common.collect.ImmutableSet;
import net.hdt.neutronia.base.client.gui.elements.ColoredButton;
import net.hdt.neutronia.base.client.gui.screens.FirstLoadScreen;
import net.hdt.neutronia.base.client.gui.screens.GuiNeutroniaConfig;
import net.hdt.neutronia.base.groups.GlobalConfig;
import net.hdt.neutronia.base.groups.GroupLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public final class ConfigEvents {

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onGuiOpen(GuiOpenEvent event) {
        if (GroupLoader.firstLoad && event.getGui() instanceof GuiMainMenu) {
            GroupLoader.firstLoad = true;
            event.setGui(new FirstLoadScreen(event.getGui()));
        }
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onGuiInit(GuiScreenEvent.InitGuiEvent event) {
        GuiScreen gui = event.getGui();

        if (GlobalConfig.enableNButton && (gui instanceof GuiMainMenu || gui instanceof GuiIngameMenu)) {
            ImmutableSet<String> targets = GlobalConfig.NButtonOnRight
                    ? ImmutableSet.of(I18n.format("fml.menu.modoptions"), I18n.format("menu.online").replace("Minecraft", "").trim())
                    : ImmutableSet.of(I18n.format("menu.options"), I18n.format("fml.menu.mods"));

            List<GuiButton> buttons = event.getButtonList();
            for (GuiButton b : buttons)
                if (targets.contains(b.displayString)) {
                    GuiButton qButton = new ColoredButton(-82392, b.x + (GlobalConfig.NButtonOnRight ? 103 : -24), b.y, 20, "N", 0x48ddbc);
                    buttons.add(qButton);
                    return;
                }
        }
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onButtonClick(GuiScreenEvent.ActionPerformedEvent event) {
        if (event.getButton() instanceof ColoredButton)
            Minecraft.getMinecraft().displayGuiScreen(new GuiNeutroniaConfig(event.getGui()));
    }

}
