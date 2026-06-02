/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.client.render.ChunkRenderingDataPreparer
 *  net.minecraft.client.render.chunk.AbstractChunkRenderData
 *  net.minecraft.util.math.Direction
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package clap.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.render.ChunkRenderingDataPreparer;
import net.minecraft.client.render.chunk.AbstractChunkRenderData;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import clap.module.render.XrayModule;

@Mixin(value={ChunkRenderingDataPreparer.class})
public class ChunkRenderingDataPreparerMixin {
    @WrapOperation(method={"runUpdates"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/renderer/chunk/SectionMesh;facesCanSeeEachother(Lnet/minecraft/core/Direction;Lnet/minecraft/core/Direction;)Z")})
    private boolean clap$xrayFacesCanSeeEachOther(AbstractChunkRenderData param1, Direction param2, Direction param3, Operation param4) {
        XrayModule v5 = XrayModule.io0O();
        if (v5 != null && v5.IoOo()) {
            return true;
        }
        return (Boolean)param4.call(new Object[]{param1, param2, param3});
    }
}

