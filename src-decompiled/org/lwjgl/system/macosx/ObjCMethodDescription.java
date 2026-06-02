/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.macosx;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct objc_method_description")
public class ObjCMethodDescription
extends Struct<ObjCMethodDescription>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int NAME;
    public static final int TYPES;

    protected ObjCMethodDescription(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected ObjCMethodDescription create(long param1, @Nullable ByteBuffer param3) {
        return new ObjCMethodDescription(param1, param3);
    }

    public ObjCMethodDescription(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), ObjCMethodDescription.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="SEL")
    public long name() {
        return ObjCMethodDescription.nname(this.address());
    }

    @NativeType(value="char *")
    public ByteBuffer types() {
        return ObjCMethodDescription.ntypes(this.address());
    }

    @NativeType(value="char *")
    public String typesString() {
        return ObjCMethodDescription.ntypesString(this.address());
    }

    public static ObjCMethodDescription malloc() {
        return new ObjCMethodDescription(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static ObjCMethodDescription calloc() {
        return new ObjCMethodDescription(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static ObjCMethodDescription create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new ObjCMethodDescription(MemoryUtil.memAddress(v0), v0);
    }

    public static ObjCMethodDescription create(long param0) {
        return new ObjCMethodDescription(param0, null);
    }

    @Nullable
    public static ObjCMethodDescription createSafe(long param0) {
        return param0 == 0L ? null : new ObjCMethodDescription(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(ObjCMethodDescription.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = ObjCMethodDescription.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    @Deprecated
    public static ObjCMethodDescription mallocStack() {
        return ObjCMethodDescription.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static ObjCMethodDescription callocStack() {
        return ObjCMethodDescription.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static ObjCMethodDescription mallocStack(MemoryStack param0) {
        return ObjCMethodDescription.malloc(param0);
    }

    @Deprecated
    public static ObjCMethodDescription callocStack(MemoryStack param0) {
        return ObjCMethodDescription.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return ObjCMethodDescription.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return ObjCMethodDescription.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return ObjCMethodDescription.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return ObjCMethodDescription.calloc(param0, param1);
    }

    public static ObjCMethodDescription malloc(MemoryStack param0) {
        return new ObjCMethodDescription(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static ObjCMethodDescription calloc(MemoryStack param0) {
        return new ObjCMethodDescription(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static long nname(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)NAME);
    }

    public static ByteBuffer ntypes(long param0) {
        return MemoryUtil.memByteBufferNT1(MemoryUtil.memGetAddress(param0 + (long)TYPES));
    }

    public static String ntypesString(long param0) {
        return MemoryUtil.memUTF8(MemoryUtil.memGetAddress(param0 + (long)TYPES));
    }

    static {
        Struct.Layout v0 = ObjCMethodDescription.__struct(ObjCMethodDescription.__member(POINTER_SIZE), ObjCMethodDescription.__member(POINTER_SIZE));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        NAME = v0.offsetof(0);
        TYPES = v0.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<ObjCMethodDescription, Buffer>
    implements NativeResource {
        private static final ObjCMethodDescription ELEMENT_FACTORY = ObjCMethodDescription.create(-1L);

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
        protected ObjCMethodDescription getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="SEL")
        public long name() {
            return ObjCMethodDescription.nname(this.address());
        }

        @NativeType(value="char *")
        public ByteBuffer types() {
            return ObjCMethodDescription.ntypes(this.address());
        }

        @NativeType(value="char *")
        public String typesString() {
            return ObjCMethodDescription.ntypesString(this.address());
        }
    }
}

