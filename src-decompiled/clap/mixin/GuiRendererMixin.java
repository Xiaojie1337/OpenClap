/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.mojang.blaze3d.buffers.GpuBuffer
 *  com.mojang.blaze3d.buffers.GpuBufferSlice
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  com.mojang.blaze3d.systems.RenderPass
 *  com.mojang.blaze3d.vertex.VertexFormat$IndexType
 *  net.minecraft.client.gui.ScreenRect
 *  net.minecraft.client.gui.render.GuiRenderer
 *  net.minecraft.client.gui.render.state.GuiRenderState
 *  net.minecraft.client.gui.render.state.SimpleGuiElementRenderState
 *  net.minecraft.client.render.BufferBuilder
 *  net.minecraft.client.texture.TextureSetup
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Coerce
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package clap.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import net.minecraft.client.gui.ScreenRect;
import net.minecraft.client.gui.render.GuiRenderer;
import net.minecraft.client.gui.render.state.GuiRenderState;
import net.minecraft.client.gui.render.state.SimpleGuiElementRenderState;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.texture.TextureSetup;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Coerce;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import clap.model.EnumType_0O00;
import clap.module.client.streamproof.StreamproofLogger;
import clap.render.RenderSupport_ooi_1;
import clap.render.RenderSupport_ooo_0;
import clap.render.RenderSupport_oooo_2;

@Mixin(value={GuiRenderer.class})
public abstract class GuiRendererMixin {
    @Unique
    private final Set clap$streamproofDraws = new HashSet();
    @Unique
    private final ArrayDeque clap$meshTagQueue = new ArrayDeque();
    @Unique
    private boolean clap$currentMeshIsStreamproof;
    @Shadow
    @Final
    private List field_59915;
    @Shadow
    @Final
    private List field_60310;
    @Shadow
    private BufferBuilder field_60037;
    @Shadow
    private RenderPipeline field_60035;
    @Shadow
    private TextureSetup field_60036;
    @Shadow
    private ScreenRect field_60034;

    @Shadow
    abstract void method_71286(BufferBuilder var1, RenderPipeline var2, TextureSetup var3, ScreenRect var4);

    @Shadow
    abstract BufferBuilder method_70882(RenderPipeline var1);

    @WrapMethod(method={"render(Lcom/mojang/blaze3d/buffers/GpuBufferSlice;)V"})
    private void clap$wrapRender(GpuBufferSlice param1, Operation param2) {
        this.clap$streamproofDraws.clear();
        this.clap$meshTagQueue.clear();
        this.clap$currentMeshIsStreamproof = false;
        param2.call(new Object[]{param1});
    }

    @WrapOperation(method={"prepareText"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/render/state/GuiRenderState;forEachText(Ljava/util/function/Consumer;)V")})
    private void clap$prepareStreamproofText(GuiRenderState param12, Consumer param2, Operation param3) {
        param3.call(new Object[]{param12, param1 -> {
            RenderSupport_ooi_1 v4;
            RenderSupport_ooo_0 v3;
            boolean v2 = StreamproofLogger.GuiSupport_OOI.contains(param1);
            if (v2 && (v3 = RenderSupport_oooo_2.getImpl()) instanceof RenderSupport_ooi_1) {
                v4 = (RenderSupport_ooi_1)v3;
                v4.HelpCommand();
            }
            try {
                param2.accept(param1);
                return;
            }
            finally {
                if (v2 && (v3 = RenderSupport_oooo_2.getImpl()) instanceof RenderSupport_ooi_1) {
                    v4 = (RenderSupport_ooi_1)v3;
                    v4.OOo();
                }
            }
        }});
    }

    @WrapOperation(method={"prepareItemElements"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/render/state/GuiRenderState;forEachItem(Ljava/util/function/Consumer;)V")})
    private void clap$prepareStreamproofItems(GuiRenderState param12, Consumer param2, Operation param3) {
        param3.call(new Object[]{param12, param1 -> {
            RenderSupport_ooi_1 v4;
            RenderSupport_ooo_0 v3;
            boolean v2 = StreamproofLogger.GuiSupport_OOI.contains(param1);
            if (v2 && (v3 = RenderSupport_oooo_2.getImpl()) instanceof RenderSupport_ooi_1) {
                v4 = (RenderSupport_ooi_1)v3;
                v4.HelpCommand();
            }
            try {
                param2.accept(param1);
                return;
            }
            finally {
                if (v2 && (v3 = RenderSupport_oooo_2.getImpl()) instanceof RenderSupport_ooi_1) {
                    v4 = (RenderSupport_ooi_1)v3;
                    v4.OOo();
                }
            }
        }});
    }

    @Inject(method={"addElementToMesh"}, at={@At(value="HEAD")})
    private void clap$splitStreamproofMeshes(SimpleGuiElementRenderState param1, CallbackInfo param2) {
        boolean v3 = StreamproofLogger.GuiSupport_OOI.contains(param1);
        if (v3 == this.clap$currentMeshIsStreamproof) {
            return;
        }
        if (this.field_60037 != null) {
            this.method_71286(this.field_60037, this.field_60035, this.field_60036, this.field_60034);
        }
        this.clap$currentMeshIsStreamproof = v3;
        this.field_60037 = this.method_70882(param1.pipeline());
        this.field_60035 = param1.pipeline();
        this.field_60036 = param1.textureSetup();
        this.field_60034 = param1.scissorArea();
    }

    @WrapOperation(method={"recordMesh"}, at={@At(value="INVOKE", target="Ljava/util/List;add(Ljava/lang/Object;)Z")})
    private boolean clap$tagRecordedMesh(List param1, @Coerce Object param2, Operation param3) {
        boolean v4 = (Boolean)param3.call(new Object[]{param1, param2});
        if (v4 && param1 == this.field_60310) {
            this.clap$meshTagQueue.addLast(this.clap$currentMeshIsStreamproof);
        }
        return v4;
    }

    @Inject(method={"recordDraws"}, at={@At(value="HEAD")})
    private void clap$resetDrawTags(CallbackInfo param1) {
        this.clap$streamproofDraws.clear();
    }

    @WrapOperation(method={"recordDraws"}, at={@At(value="INVOKE", target="Ljava/util/List;add(Ljava/lang/Object;)Z")})
    private boolean clap$carryMeshTagToDraw(List param1, @Coerce Object param2, Operation param3) {
        boolean v4 = (Boolean)param3.call(new Object[]{param1, param2});
        if (v4 && param1 == this.field_59915 && Boolean.TRUE.equals(this.clap$meshTagQueue.pollFirst())) {
            this.clap$streamproofDraws.add(param2);
        }
        return v4;
    }

    @WrapOperation(method={"executeDrawRange(Ljava/util/function/Supplier;Lcom/mojang/blaze3d/pipeline/RenderTarget;Lcom/mojang/blaze3d/buffers/GpuBufferSlice;Lcom/mojang/blaze3d/buffers/GpuBufferSlice;Lcom/mojang/blaze3d/buffers/GpuBuffer;Lcom/mojang/blaze3d/vertex/VertexFormat$IndexType;II)V"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/render/GuiRenderer;executeDraw(Lnet/minecraft/client/gui/render/GuiRenderer$Draw;Lcom/mojang/blaze3d/systems/RenderPass;Lcom/mojang/blaze3d/buffers/GpuBuffer;Lcom/mojang/blaze3d/vertex/VertexFormat$IndexType;)V")})
    private void clap$applyStreamproofDrawPass(GuiRenderer param1, @Coerce Object param2, RenderPass param3, GpuBuffer param4, VertexFormat.IndexType param5, Operation param6) {
        boolean v7 = this.clap$streamproofDraws.contains(param2);
        if (v7) {
            RenderSupport_oooo_2.start(EnumType_0O00.Gui);
        }
        try {
            param6.call(new Object[]{param1, param2, param3, param4, param5});
        }
        finally {
            if (v7) {
                RenderSupport_oooo_2.stop(EnumType_0O00.Gui);
            }
        }
    }
}

