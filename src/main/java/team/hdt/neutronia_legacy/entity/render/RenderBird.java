package team.hdt.neutronia_legacy.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import team.hdt.neutronia_legacy.base.util.Reference;
import team.hdt.neutronia_legacy.entity.EntityBird;
import team.hdt.neutronia_legacy.entity.render.model.ModelBird;

public class RenderBird extends RenderLiving<EntityBird> {

    public static final ResourceLocation SCORP_TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/bird.png");

    public RenderBird(RenderManager manager) {
        super(manager, new ModelBird(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityBird entity) {
        return SCORP_TEXTURE;
    }
}