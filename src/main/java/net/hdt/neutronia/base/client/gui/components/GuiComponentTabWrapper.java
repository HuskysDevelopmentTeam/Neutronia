package net.hdt.neutronia.base.client.gui.components;

import net.hdt.neutronia.base.client.gui.listener.IMouseDownListener;

public class GuiComponentTabWrapper extends BaseComposite {

    private final BaseComponent mainComponent;
    private GuiComponentTab activeTab;

    public GuiComponentTabWrapper(int x, int y, BaseComponent mainComponent) {
        super(x, y);
        this.mainComponent = mainComponent;
        addComponent(mainComponent);
    }

    @Override
    public BaseComposite addComponent(BaseComponent component) {
        super.addComponent(component);
        if (component instanceof GuiComponentTab) {
            final GuiComponentTab tab = (GuiComponentTab) component;
            component.setX(component.getX() + mainComponent.getWidth());
            component.setListener((IMouseDownListener) (self, x, y, button) -> {
                if (activeTab != tab) {
                    if (activeTab != null) activeTab.setActive(false);
                    activeTab = tab;
                    activeTab.setActive(true);
                } else if (activeTab.isOrigin(x, y)) {
                    tab.setActive(false);
                    activeTab = null;
                }
            });
        }
        return this;
    }

    @Override
    protected void renderComponentBackground(int offsetX, int offsetY, int mouseX, int mouseY) {
        realignTabsVertically();
    }

    private void realignTabsVertically() {
        int oY = mainComponent.getY() + 4;

        for (BaseComponent component : components) {
            if (component instanceof GuiComponentTab) {
                component.setY(oY);
                oY += component.getHeight() - 1;
            }
        }
    }

    public void onTabClicked(GuiComponentTab tab) {
        if (tab != activeTab) {
            if (activeTab != null) {
                activeTab.setActive(false);
            }
            tab.setActive(true);
            activeTab = tab;
        } else {
            tab.setActive(false);
            activeTab = null;
        }
    }

    @Override
    public int getWidth() {
        int maxTabWidth = 0;
        for (BaseComponent component : components) {
            if (component.getX() + component.getWidth() > maxTabWidth) {
                maxTabWidth = component.getX() + component.getWidth();
            }
        }
        return mainComponent.getWidth() + maxTabWidth;
    }

    @Override
    public int getHeight() {
        int maxTabHeight = 0;
        for (BaseComponent component : components) {
            if (component.getY() + component.getHeight() > maxTabHeight) {
                maxTabHeight = component.getY() + component.getHeight();
            }
        }
        return mainComponent.getHeight() + maxTabHeight;
    }

}