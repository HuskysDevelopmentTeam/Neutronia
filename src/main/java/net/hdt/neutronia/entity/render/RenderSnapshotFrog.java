package net.hdt.neutronia.entity.render;

import net.hdt.neutronia.base.util.Reference;
import net.hdt.neutronia.entity.EntitySnapshotFrog;
import net.hdt.neutronia.entity.render.model.ModelSnapshotFrog;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderSnapshotFrog extends RenderLiving<EntitySnapshotFrog> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/snapshot_day_frog.png");

    public RenderSnapshotFrog(RenderManager manager) {
        super(manager, new ModelSnapshotFrog(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySnapshotFrog entity) {
        return TEXTURE;
    }

    @Override
    protected void preRenderCallback(EntitySnapshotFrog entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(0.35F, 0.35F, 0.35F);
    }

}