/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.nanovg;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct NVGLUframebuffer")
public class NVGLUFramebufferBGFX
extends Struct<NVGLUFramebufferBGFX> {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int CTX;
    public static final int HANDLE;
    public static final int IMAGE;
    public static final int VIEWID;

    protected NVGLUFramebufferBGFX(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected NVGLUFramebufferBGFX create(long param1, @Nullable ByteBuffer param3) {
        return new NVGLUFramebufferBGFX(param1, param3);
    }

    public NVGLUFramebufferBGFX(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), NVGLUFramebufferBGFX.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="NVGcontext *")
    public long ctx() {
        return NVGLUFramebufferBGFX.nctx(this.address());
    }

    @NativeType(value="bgfx_frame_buffer_handle_t")
    public short handle() {
        return NVGLUFramebufferBGFX.nhandle(this.address());
    }

    public int image() {
        return NVGLUFramebufferBGFX.nimage(this.address());
    }

    @NativeType(value="bgfx_view_id_t")
    public short viewId() {
        return NVGLUFramebufferBGFX.nviewId(this.address());
    }

    public static NVGLUFramebufferBGFX create(long param0) {
        return new NVGLUFramebufferBGFX(param0, null);
    }

    @Nullable
    public static NVGLUFramebufferBGFX createSafe(long param0) {
        return param0 == 0L ? null : new NVGLUFramebufferBGFX(param0, null);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static long nctx(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)CTX);
    }

    public static short nhandle(long param0) {
        return UNSAFE.getShort(null, param0 + (long)HANDLE);
    }

    public static int nimage(long param0) {
        return UNSAFE.getInt(null, param0 + (long)IMAGE);
    }

    public static short nviewId(long param0) {
        return UNSAFE.getShort(null, param0 + (long)VIEWID);
    }

    static {
        Struct.Layout v0 = NVGLUFramebufferBGFX.__struct(NVGLUFramebufferBGFX.__member(POINTER_SIZE), NVGLUFramebufferBGFX.__member(2), NVGLUFramebufferBGFX.__member(4), NVGLUFramebufferBGFX.__member(2));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        CTX = v0.offsetof(0);
        HANDLE = v0.offsetof(1);
        IMAGE = v0.offsetof(2);
        VIEWID = v0.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<NVGLUFramebufferBGFX, Buffer> {
        private static final NVGLUFramebufferBGFX ELEMENT_FACTORY = NVGLUFramebufferBGFX.create(-1L);

        public Buffer(ByteBuffer param1) {
            super(param1, param1.remaining() / SIZEOF);
        }

        public Buffer(long param1, int param3) {
            super(param1, null, -1, 0, param3, param3);
        }

        Buffer(long param1, @Nullable ByteBuffer param3, int param4, int param5, int param6, int param7) {
            super(param1, param3, param4, param5, param6, param7);
        }

        @Override
        protected Buffer self() {
            return this;
        }

        @Override
        protected NVGLUFramebufferBGFX getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="NVGcontext *")
        public long ctx() {
            return NVGLUFramebufferBGFX.nctx(this.address());
        }

        @NativeType(value="bgfx_frame_buffer_handle_t")
        public short handle() {
            return NVGLUFramebufferBGFX.nhandle(this.address());
        }

        public int image() {
            return NVGLUFramebufferBGFX.nimage(this.address());
        }

        @NativeType(value="bgfx_view_id_t")
        public short viewId() {
            return NVGLUFramebufferBGFX.nviewId(this.address());
        }
    }
}

