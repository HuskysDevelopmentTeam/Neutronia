package team.hdt.neutronia.base.proxy;

import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.lwjgl.opengl.Display;
import team.hdt.neutronia.base.Reference;
import team.hdt.neutronia.base.client.ContributorRewardHandler;
import team.hdt.neutronia.base.modules.ModuleLoader;
import team.hdt.neutronia.client.render.RenderTileCustomChest;
import team.hdt.neutronia.tileentities.TileCustomChest;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        Display.setTitle(String.format("%s %s | Minecraft 1.12.2", Reference.MOD_NAME, Reference.VERSION));
        ModuleLoader.preInitClient(event);
        ClientRegistry.bindTileEntitySpecialRenderer(TileCustomChest.class, new RenderTileCustomChest());
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        ModuleLoader.initClient(event);
        ContributorRewardHandler.init();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
        ModuleLoader.postInitClient(event);
    }

}
