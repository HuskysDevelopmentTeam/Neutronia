package net.hdt.neutronia.groups.earlyGame.features;

import net.hdt.neutronia.base.groups.Component;
import net.hdt.neutronia.groups.earlyGame.blocks.BlockClayCauldron;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClayCauldron extends Component {

    private BlockClayCauldron clayCauldron;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        clayCauldron = new BlockClayCauldron();
    }

}