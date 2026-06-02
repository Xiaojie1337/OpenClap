/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.libffi;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;
import org.lwjgl.system.libffi.FFICIF;

@NativeType(value="struct ffi_closure")
public class FFIClosure
extends Struct<FFIClosure>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int CIF;
    public static final int FUN;
    public static final int USER_DATA;

    private static native int offsets(long var0);

    protected FFIClosure(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected FFIClosure create(long param1, @Nullable ByteBuffer param3) {
        return new FFIClosure(param1, param3);
    }

    public FFIClosure(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), FFIClosure.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="ffi_cif *")
    public FFICIF cif() {
        return FFIClosure.ncif(this.address());
    }

    @NativeType(value="void (*)(ffi_cif*,void*,void**,void*)")
    public long fun() {
        return FFIClosure.nfun(this.address());
    }

    @NativeType(value="void *")
    public long user_data() {
        return FFIClosure.nuser_data(this.address());
    }

    public static FFIClosure malloc() {
        return new FFIClosure(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static FFIClosure calloc() {
        return new FFIClosure(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static FFIClosure create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new FFIClosure(MemoryUtil.memAddress(v0), v0);
    }

    public static FFIClosure create(long param0) {
        return new FFIClosure(param0, null);
    }

    @Nullable
    public static FFIClosure createSafe(long param0) {
        return param0 == 0L ? null : new FFIClosure(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(FFIClosure.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = FFIClosure.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static FFIClosure malloc(MemoryStack param0) {
        return new FFIClosure(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static FFIClosure calloc(MemoryStack param0) {
        return new FFIClosure(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static FFICIF ncif(long param0) {
        return FFICIF.create(MemoryUtil.memGetAddress(param0 + (long)CIF));
    }

    public static long nfun(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)FUN);
    }

    public static long nuser_data(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)USER_DATA);
    }

    static {
        MemoryStack v0 = MemoryStack.stackPush();
        Throwable v1 = null;
        try {
            IntBuffer v2 = v0.mallocInt(4);
            SIZEOF = FFIClosure.offsets(MemoryUtil.memAddress(v2));
            CIF = v2.get(0);
            FUN = v2.get(1);
            USER_DATA = v2.get(2);
            ALIGNOF = v2.get(3);
            if (v0 != null) {
                v0.close();
            }
        }
        catch (Throwable v2) {
            try {
                v1 = v2;
                throw v2;
            }
            catch (Throwable v3) {
                if (v0 != null) {
                    if (v1 != null) {
                        try {
                            v0.close();
                        }
                        catch (Throwable v4) {
                            v1.addSuppressed(v4);
                        }
                    } else {
                        v0.close();
                    }
                }
                throw v3;
            }
        }
    }

    public static class Buffer
    extends StructBuffer<FFIClosure, Buffer>
    implements NativeResource {
        private static final FFIClosure ELEMENT_FACTORY = FFIClosure.create(-1L);

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
        protected FFIClosure getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="ffi_cif *")
        public FFICIF cif() {
            return FFIClosure.ncif(this.address());
        }

        @NativeType(value="void (*)(ffi_cif*,void*,void**,void*)")
        public long fun() {
            return FFIClosure.nfun(this.address());
        }

        @NativeType(value="void *")
        public long user_data() {
            return FFIClosure.nuser_data(this.address());
        }
    }
}

