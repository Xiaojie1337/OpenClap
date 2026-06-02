/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gl.ShaderLoader
 *  net.minecraft.client.render.ProjectionMatrix2
 *  net.minecraft.client.texture.TextureManager
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package clap.mixin;

import net.minecraft.client.gl.ShaderLoader;
import net.minecraft.client.render.ProjectionMatrix2;
import net.minecraft.client.texture.TextureManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={ShaderLoader.class})
public interface ShaderLoaderAccessor {
    @Accessor(value="textureManager")
    public TextureManager clap$getTextureManager();

    @Accessor(value="postChainProjectionMatrixBuffer")
    public ProjectionMatrix2 clap$getPostChainProjectionMatrixBuffer();
}

