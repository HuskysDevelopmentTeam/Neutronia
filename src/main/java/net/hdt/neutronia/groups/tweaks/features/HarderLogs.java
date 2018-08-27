package net.hdt.neutronia.groups.tweaks.features;

import net.hdt.neutronia.base.groups.Component;
import net.minecraft.block.BlockLog;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HarderLogs extends Component {

    @SubscribeEvent
    public void onBreakBlocks(PlayerEvent.BreakSpeed event) {
        if(event.getEntityPlayer().getActiveItemStack().isEmpty() || event.getEntityPlayer().getActiveItemStack().getItem() instanceof ItemBlock) {
            if(event.getState().getBlock() instanceof BlockLog) {
                event.setNewSpeed(0);
            }
        }
    }

    @Override
    public boolean hasSubscriptions() {
        return true;
    }

}