/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package clap.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTextureView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={RenderSystem.class})
public interface RenderSystemAccessor {
    @Accessor(value="outputColorTextureOverride", remap=false)
    public static GpuTextureView clap$getOutputColorTextureOverride() {
        throw new AssertionError();
    }

    @Accessor(value="outputColorTextureOverride", remap=false)
    public static void clap$setOutputColorTextureOverride(GpuTextureView param0) {
        throw new AssertionError();
    }

    @Accessor(value="outputDepthTextureOverride", remap=false)
    public static GpuTextureView clap$getOutputDepthTextureOverride() {
        throw new AssertionError();
    }

    @Accessor(value="outputDepthTextureOverride", remap=false)
    public static void clap$setOutputDepthTextureOverride(GpuTextureView param0) {
        throw new AssertionError();
    }
}

