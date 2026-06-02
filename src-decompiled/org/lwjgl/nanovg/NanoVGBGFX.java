/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.nanovg;

import javax.annotation.Nullable;
import org.lwjgl.nanovg.NVGLUFramebufferBGFX;
import org.lwjgl.nanovg.NanoVG;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.SharedLibrary;

public class NanoVGBGFX {
    public static final int NVG_IMAGE_NODELETE = 65536;

    protected NanoVGBGFX() {
        throw new UnsupportedOperationException();
    }

    public static long nnvgCreate(int param0, short param1, long param2) {
        long v4 = Functions.Create;
        return JNI.invokeCPP(param0, param1, param2, v4);
    }

    @NativeType(value="NVGcontext *")
    public static long nvgCreate(@NativeType(value="int32_t") boolean param0, @NativeType(value="bgfx_view_id_t") int param1, @NativeType(value="bgfx_allocator_interface_t *") long param2) {
        return NanoVGBGFX.nnvgCreate(param0 ? 1 : 0, (short)param1, param2);
    }

    public static void nvgDelete(@NativeType(value="NVGcontext *") long param0) {
        long v2 = Functions.Delete;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        JNI.invokePV(param0, v2);
    }

    public static void nnvgSetViewId(long param0, short param2) {
        long v3 = Functions.SetViewId;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        JNI.invokePCV(param0, param2, v3);
    }

    public static void nvgSetViewId(@NativeType(value="NVGcontext *") long param0, @NativeType(value="bgfx_view_id_t") int param2) {
        NanoVGBGFX.nnvgSetViewId(param0, (short)param2);
    }

    @NativeType(value="uint16_t")
    public static short nvgGetViewId(@NativeType(value="NVGcontext *") long param0) {
        long v2 = Functions.GetViewId;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePC(param0, v2);
    }

    public static long nnvgluCreateFramebuffer(long param0, int param2, int param3, int param4) {
        long v5 = Functions.luCreateFramebuffer;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        return JNI.invokePP(param0, param2, param3, param4, v5);
    }

    @Nullable
    @NativeType(value="NVGLUframebuffer *")
    public static NVGLUFramebufferBGFX nvgluCreateFramebuffer(@NativeType(value="NVGcontext *") long param0, @NativeType(value="int32_t") int param2, @NativeType(value="int32_t") int param3, @NativeType(value="int32_t") int param4) {
        long v5 = NanoVGBGFX.nnvgluCreateFramebuffer(param0, param2, param3, param4);
        return NVGLUFramebufferBGFX.createSafe(v5);
    }

    public static void nnvgluBindFramebuffer(long param0) {
        long v2 = Functions.luBindFramebuffer;
        JNI.invokePV(param0, v2);
    }

    public static void nvgluBindFramebuffer(@Nullable @NativeType(value="NVGLUframebuffer *") NVGLUFramebufferBGFX param0) {
        NanoVGBGFX.nnvgluBindFramebuffer(MemoryUtil.memAddressSafe(param0));
    }

    public static void nnvgluDeleteFramebuffer(long param0) {
        long v2 = Functions.luDeleteFramebuffer;
        JNI.invokePV(param0, v2);
    }

    public static void nvgluDeleteFramebuffer(@NativeType(value="NVGLUframebuffer *") NVGLUFramebufferBGFX param0) {
        NanoVGBGFX.nnvgluDeleteFramebuffer(param0.address());
    }

    public static void nnvgluSetViewFramebuffer(short param0, long param1) {
        long v3 = Functions.luSetViewFramebuffer;
        JNI.invokeCPV(param0, param1, v3);
    }

    public static void nvgluSetViewFramebuffer(@NativeType(value="bgfx_view_id_t") int param0, @NativeType(value="NVGLUframebuffer *") NVGLUFramebufferBGFX param1) {
        NanoVGBGFX.nnvgluSetViewFramebuffer((short)param0, param1.address());
    }

    public static void nvgCreateBgfxTexture(@NativeType(value="NVGcontext *") long param0, @NativeType(value="bgfx_texture_handle_t") short param2, int param3, int param4, int param5) {
        long v6 = Functions.CreateBgfxTexture;
        if (Checks.CHECKS) {
            Checks.check(param0);
        }
        JNI.invokePCV(param0, param2, param3, param4, param5, v6);
    }

    private static void org_lwjgl_nanovg_setup(@NativeType(value="void *") long param0, @NativeType(value="void *") long param2, @NativeType(value="void *") long param4, @NativeType(value="void *") long param6, @NativeType(value="void *") long param8) {
        long v10 = Functions.org_lwjgl_nanovg_setup;
        if (Checks.CHECKS) {
            Checks.check(param0);
            Checks.check(param2);
            Checks.check(param4);
            Checks.check(param6);
            Checks.check(param8);
        }
        JNI.invokePPPPPV(param0, param2, param4, param6, param8, v10);
    }

    static {
        MemoryUtil.MemoryAllocator v0 = MemoryUtil.getAllocator(Configuration.DEBUG_MEMORY_ALLOCATOR_INTERNAL.get(true));
        NanoVGBGFX.org_lwjgl_nanovg_setup(v0.getRealloc(), v0.getFree(), NanoVG.nvgCreateInternal, NanoVG.nvgInternalParams, NanoVG.nvgDeleteInternal);
    }

    private static class BGFX {
        private static final SharedLibrary library;

        private BGFX() {
        }

        static SharedLibrary getLibrary() {
            return library;
        }

        static {
            try {
                library = (SharedLibrary)Class.forName("org.lwjgl.bgfx.BGFX").getMethod("getLibrary", new Class[0]).invoke(null, new Object[0]);
                return;
            }
            catch (Exception v0) {
                throw new RuntimeException(v0);
            }
        }
    }

    public static final class Functions {
        public static final long Create = APIUtil.apiGetFunctionAddress(BGFX.getLibrary(), "nvgCreate");
        public static final long Delete = APIUtil.apiGetFunctionAddress(BGFX.getLibrary(), "nvgDelete");
        public static final long SetViewId = APIUtil.apiGetFunctionAddress(BGFX.getLibrary(), "nvgSetViewId");
        public static final long GetViewId = APIUtil.apiGetFunctionAddress(BGFX.getLibrary(), "nvgGetViewId");
        public static final long luCreateFramebuffer = APIUtil.apiGetFunctionAddress(BGFX.getLibrary(), "nvgluCreateFramebuffer");
        public static final long luBindFramebuffer = APIUtil.apiGetFunctionAddress(BGFX.getLibrary(), "nvgluBindFramebuffer");
        public static final long luDeleteFramebuffer = APIUtil.apiGetFunctionAddress(BGFX.getLibrary(), "nvgluDeleteFramebuffer");
        public static final long luSetViewFramebuffer = APIUtil.apiGetFunctionAddress(BGFX.getLibrary(), "nvgluSetViewFramebuffer");
        public static final long CreateBgfxTexture = APIUtil.apiGetFunctionAddress(BGFX.getLibrary(), "nvgCreateBgfxTexture");
        public static final long org_lwjgl_nanovg_setup = APIUtil.apiGetFunctionAddress(BGFX.getLibrary(), "org_lwjgl_nanovg_setup");

        private Functions() {
        }
    }
}

