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
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct objc_property_attribute_t")
public class ObjCPropertyAttribute
extends Struct<ObjCPropertyAttribute>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int NAME;
    public static final int VALUE;

    protected ObjCPropertyAttribute(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected ObjCPropertyAttribute create(long param1, @Nullable ByteBuffer param3) {
        return new ObjCPropertyAttribute(param1, param3);
    }

    public ObjCPropertyAttribute(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), ObjCPropertyAttribute.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="char *")
    public ByteBuffer name() {
        return ObjCPropertyAttribute.nname(this.address());
    }

    @NativeType(value="char *")
    public String nameString() {
        return ObjCPropertyAttribute.nnameString(this.address());
    }

    @NativeType(value="char *")
    public ByteBuffer value() {
        return ObjCPropertyAttribute.nvalue(this.address());
    }

    @NativeType(value="char *")
    public String valueString() {
        return ObjCPropertyAttribute.nvalueString(this.address());
    }

    public ObjCPropertyAttribute name(@NativeType(value="char *") ByteBuffer param1) {
        ObjCPropertyAttribute.nname(this.address(), param1);
        return this;
    }

    public ObjCPropertyAttribute value(@NativeType(value="char *") ByteBuffer param1) {
        ObjCPropertyAttribute.nvalue(this.address(), param1);
        return this;
    }

    public ObjCPropertyAttribute set(ByteBuffer param1, ByteBuffer param2) {
        this.name(param1);
        this.value(param2);
        return this;
    }

    public ObjCPropertyAttribute set(ObjCPropertyAttribute param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static ObjCPropertyAttribute malloc() {
        return new ObjCPropertyAttribute(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static ObjCPropertyAttribute calloc() {
        return new ObjCPropertyAttribute(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static ObjCPropertyAttribute create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new ObjCPropertyAttribute(MemoryUtil.memAddress(v0), v0);
    }

    public static ObjCPropertyAttribute create(long param0) {
        return new ObjCPropertyAttribute(param0, null);
    }

    @Nullable
    public static ObjCPropertyAttribute createSafe(long param0) {
        return param0 == 0L ? null : new ObjCPropertyAttribute(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(ObjCPropertyAttribute.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = ObjCPropertyAttribute.__create(param0, SIZEOF);
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
    public static ObjCPropertyAttribute mallocStack() {
        return ObjCPropertyAttribute.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static ObjCPropertyAttribute callocStack() {
        return ObjCPropertyAttribute.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static ObjCPropertyAttribute mallocStack(MemoryStack param0) {
        return ObjCPropertyAttribute.malloc(param0);
    }

    @Deprecated
    public static ObjCPropertyAttribute callocStack(MemoryStack param0) {
        return ObjCPropertyAttribute.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return ObjCPropertyAttribute.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return ObjCPropertyAttribute.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return ObjCPropertyAttribute.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return ObjCPropertyAttribute.calloc(param0, param1);
    }

    public static ObjCPropertyAttribute malloc(MemoryStack param0) {
        return new ObjCPropertyAttribute(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static ObjCPropertyAttribute calloc(MemoryStack param0) {
        return new ObjCPropertyAttribute(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static ByteBuffer nname(long param0) {
        return MemoryUtil.memByteBufferNT1(MemoryUtil.memGetAddress(param0 + (long)NAME));
    }

    public static String nnameString(long param0) {
        return MemoryUtil.memUTF8(MemoryUtil.memGetAddress(param0 + (long)NAME));
    }

    public static ByteBuffer nvalue(long param0) {
        return MemoryUtil.memByteBufferNT1(MemoryUtil.memGetAddress(param0 + (long)VALUE));
    }

    public static String nvalueString(long param0) {
        return MemoryUtil.memUTF8(MemoryUtil.memGetAddress(param0 + (long)VALUE));
    }

    public static void nname(long param0, ByteBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param2);
        }
        MemoryUtil.memPutAddress(param0 + (long)NAME, MemoryUtil.memAddress(param2));
    }

    public static void nvalue(long param0, ByteBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param2);
        }
        MemoryUtil.memPutAddress(param0 + (long)VALUE, MemoryUtil.memAddress(param2));
    }

    public static void validate(long param0) {
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)NAME));
        Checks.check(MemoryUtil.memGetAddress(param0 + (long)VALUE));
    }

    static {
        Struct.Layout v0 = ObjCPropertyAttribute.__struct(ObjCPropertyAttribute.__member(POINTER_SIZE), ObjCPropertyAttribute.__member(POINTER_SIZE));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        NAME = v0.offsetof(0);
        VALUE = v0.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<ObjCPropertyAttribute, Buffer>
    implements NativeResource {
        private static final ObjCPropertyAttribute ELEMENT_FACTORY = ObjCPropertyAttribute.create(-1L);

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
        protected ObjCPropertyAttribute getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="char *")
        public ByteBuffer name() {
            return ObjCPropertyAttribute.nname(this.address());
        }

        @NativeType(value="char *")
        public String nameString() {
            return ObjCPropertyAttribute.nnameString(this.address());
        }

        @NativeType(value="char *")
        public ByteBuffer value() {
            return ObjCPropertyAttribute.nvalue(this.address());
        }

        @NativeType(value="char *")
        public String valueString() {
            return ObjCPropertyAttribute.nvalueString(this.address());
        }

        public Buffer name(@NativeType(value="char *") ByteBuffer param1) {
            ObjCPropertyAttribute.nname(this.address(), param1);
            return this;
        }

        public Buffer value(@NativeType(value="char *") ByteBuffer param1) {
            ObjCPropertyAttribute.nvalue(this.address(), param1);
            return this;
        }
    }
}

