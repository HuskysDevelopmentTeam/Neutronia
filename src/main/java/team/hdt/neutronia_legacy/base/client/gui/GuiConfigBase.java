package team.hdt.neutronia_legacy.base.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiConfirmOpenLink;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.common.config.Property;
import team.hdt.neutronia_legacy.base.client.gui.elements.ConfigSettingsButton;
import team.hdt.neutronia_legacy.base.client.gui.screens.ConfigLinkScreen;
import team.hdt.neutronia_legacy.base.groups.GroupLoader;
import team.hdt.neutronia_legacy.base.lib.LibMisc;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

public class GuiConfigBase extends GuiScreen {

    public static boolean mayRequireRestart = false;
    private static List<Property> restartRequiringProperties = new LinkedList<>();
    public String title;
    public GuiScreen parent;
    public GuiButton backButton;

    public GuiConfigBase(GuiScreen parent) {
        this.parent = parent;
    }

    @Override
    public void initGui() {
        super.initGui();

        buttonList.clear();
        title = I18n.translateToLocal("neutronia_legacy.config.title");
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        drawCenteredString(fontRenderer, title, width / 2, 15, 0xFFFFFF);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        if (keyCode == 1) // Esc
            returnToParent();
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        super.actionPerformed(button);

        if (backButton != null && button == backButton)
            returnToParent();

        if (button instanceof ConfigSettingsButton) {
            ConfigSettingsButton configButton = (ConfigSettingsButton) button;
            configButton.prop.set(!configButton.prop.getBoolean());
            if (configButton.prop.requiresMcRestart()) {
                if (restartRequiringProperties.contains(configButton.prop))
                    restartRequiringProperties.remove(configButton.prop);
                else restartRequiringProperties.add(configButton.prop);

                mayRequireRestart = !restartRequiringProperties.isEmpty();
            }
            GroupLoader.loadConfig();
        }
    }

    private void returnToParent() {
        mc.displayGuiScreen(parent);

        if (mc.currentScreen == null)
            mc.setIngameFocus();
    }

    public void tryOpenWebsite(String url) {
        GuiConfirmOpenLink gui = new ConfigLinkScreen(this, url);
        mc.displayGuiScreen(gui);
    }

    @Override
    public void confirmClicked(boolean result, int id) {
        if (id == 0) {
            try {
                if (result)
                    openWebLink(new URI(LibMisc.MOD_WEBSITE));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

            mc.displayGuiScreen(this);
        }
    }

    private void openWebLink(URI url) {
        try {
            Class<?> oclass = Class.forName("java.awt.Desktop");
            Object object = oclass.getMethod("getDesktop").invoke(null);
            oclass.getMethod("browse", URI.class).invoke(object, url);
        } catch (Throwable throwable1) {
            Throwable throwable = throwable1.getCause();
            LibMisc.LOGGER.warn("Couldn't open link: {}", (throwable == null ? "<UNKNOWN>" : throwable.getMessage()));
        }
    }

}