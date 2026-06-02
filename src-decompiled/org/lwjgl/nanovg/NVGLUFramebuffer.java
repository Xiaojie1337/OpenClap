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
public class NVGLUFramebuffer
extends Struct<NVGLUFramebuffer> {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int FBO;
    public static final int RBO;
    public static final int TEXTURE;
    public static final int IMAGE;

    protected NVGLUFramebuffer(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected NVGLUFramebuffer create(long param1, @Nullable ByteBuffer param3) {
        return new NVGLUFramebuffer(param1, param3);
    }

    public NVGLUFramebuffer(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), NVGLUFramebuffer.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="GLuint")
    public int fbo() {
        return NVGLUFramebuffer.nfbo(this.address());
    }

    @NativeType(value="GLuint")
    public int rbo() {
        return NVGLUFramebuffer.nrbo(this.address());
    }

    @NativeType(value="GLuint")
    public int texture() {
        return NVGLUFramebuffer.ntexture(this.address());
    }

    public int image() {
        return NVGLUFramebuffer.nimage(this.address());
    }

    public static NVGLUFramebuffer create(long param0) {
        return new NVGLUFramebuffer(param0, null);
    }

    @Nullable
    public static NVGLUFramebuffer createSafe(long param0) {
        return param0 == 0L ? null : new NVGLUFramebuffer(param0, null);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static int nfbo(long param0) {
        return UNSAFE.getInt(null, param0 + (long)FBO);
    }

    public static int nrbo(long param0) {
        return UNSAFE.getInt(null, param0 + (long)RBO);
    }

    public static int ntexture(long param0) {
        return UNSAFE.getInt(null, param0 + (long)TEXTURE);
    }

    public static int nimage(long param0) {
        return UNSAFE.getInt(null, param0 + (long)IMAGE);
    }

    static {
        Struct.Layout v0 = NVGLUFramebuffer.__struct(NVGLUFramebuffer.__member(4), NVGLUFramebuffer.__member(4), NVGLUFramebuffer.__member(4), NVGLUFramebuffer.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        FBO = v0.offsetof(0);
        RBO = v0.offsetof(1);
        TEXTURE = v0.offsetof(2);
        IMAGE = v0.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<NVGLUFramebuffer, Buffer> {
        private static final NVGLUFramebuffer ELEMENT_FACTORY = NVGLUFramebuffer.create(-1L);

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
        protected NVGLUFramebuffer getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="GLuint")
        public int fbo() {
            return NVGLUFramebuffer.nfbo(this.address());
        }

        @NativeType(value="GLuint")
        public int rbo() {
            return NVGLUFramebuffer.nrbo(this.address());
        }

        @NativeType(value="GLuint")
        public int texture() {
            return NVGLUFramebuffer.ntexture(this.address());
        }

        public int image() {
            return NVGLUFramebuffer.nimage(this.address());
        }
    }
}

