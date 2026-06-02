/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct flock64")
public class Flock
extends Struct<Flock>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int L_TYPE;
    public static final int L_WHENCE;
    public static final int L_START;
    public static final int L_LEN;
    public static final int L_PID;

    protected Flock(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected Flock create(long param1, @Nullable ByteBuffer param3) {
        return new Flock(param1, param3);
    }

    public Flock(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), Flock.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public short l_type() {
        return Flock.nl_type(this.address());
    }

    public short l_whence() {
        return Flock.nl_whence(this.address());
    }

    @NativeType(value="off_t")
    public long l_start() {
        return Flock.nl_start(this.address());
    }

    @NativeType(value="off_t")
    public long l_len() {
        return Flock.nl_len(this.address());
    }

    @NativeType(value="pid_t")
    public int l_pid() {
        return Flock.nl_pid(this.address());
    }

    public Flock l_type(short param1) {
        Flock.nl_type(this.address(), param1);
        return this;
    }

    public Flock l_whence(short param1) {
        Flock.nl_whence(this.address(), param1);
        return this;
    }

    public Flock l_start(@NativeType(value="off_t") long param1) {
        Flock.nl_start(this.address(), param1);
        return this;
    }

    public Flock l_len(@NativeType(value="off_t") long param1) {
        Flock.nl_len(this.address(), param1);
        return this;
    }

    public Flock l_pid(@NativeType(value="pid_t") int param1) {
        Flock.nl_pid(this.address(), param1);
        return this;
    }

    public Flock set(short param1, short param2, long param3, long param5, int param7) {
        this.l_type(param1);
        this.l_whence(param2);
        this.l_start(param3);
        this.l_len(param5);
        this.l_pid(param7);
        return this;
    }

    public Flock set(Flock param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static Flock malloc() {
        return new Flock(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static Flock calloc() {
        return new Flock(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static Flock create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new Flock(MemoryUtil.memAddress(v0), v0);
    }

    public static Flock create(long param0) {
        return new Flock(param0, null);
    }

    @Nullable
    public static Flock createSafe(long param0) {
        return param0 == 0L ? null : new Flock(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(Flock.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = Flock.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static Flock malloc(MemoryStack param0) {
        return new Flock(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static Flock calloc(MemoryStack param0) {
        return new Flock(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static short nl_type(long param0) {
        return UNSAFE.getShort(null, param0 + (long)L_TYPE);
    }

    public static short nl_whence(long param0) {
        return UNSAFE.getShort(null, param0 + (long)L_WHENCE);
    }

    public static long nl_start(long param0) {
        return UNSAFE.getLong(null, param0 + (long)L_START);
    }

    public static long nl_len(long param0) {
        return UNSAFE.getLong(null, param0 + (long)L_LEN);
    }

    public static int nl_pid(long param0) {
        return UNSAFE.getInt(null, param0 + (long)L_PID);
    }

    public static void nl_type(long param0, short param2) {
        UNSAFE.putShort(null, param0 + (long)L_TYPE, param2);
    }

    public static void nl_whence(long param0, short param2) {
        UNSAFE.putShort(null, param0 + (long)L_WHENCE, param2);
    }

    public static void nl_start(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)L_START, param2);
    }

    public static void nl_len(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)L_LEN, param2);
    }

    public static void nl_pid(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)L_PID, param2);
    }

    static {
        Struct.Layout v0 = Flock.__struct(Flock.__member(2), Flock.__member(2), Flock.__member(8), Flock.__member(8), Flock.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        L_TYPE = v0.offsetof(0);
        L_WHENCE = v0.offsetof(1);
        L_START = v0.offsetof(2);
        L_LEN = v0.offsetof(3);
        L_PID = v0.offsetof(4);
    }

    public static class Buffer
    extends StructBuffer<Flock, Buffer>
    implements NativeResource {
        private static final Flock ELEMENT_FACTORY = Flock.create(-1L);

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
        protected Flock getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public short l_type() {
            return Flock.nl_type(this.address());
        }

        public short l_whence() {
            return Flock.nl_whence(this.address());
        }

        @NativeType(value="off_t")
        public long l_start() {
            return Flock.nl_start(this.address());
        }

        @NativeType(value="off_t")
        public long l_len() {
            return Flock.nl_len(this.address());
        }

        @NativeType(value="pid_t")
        public int l_pid() {
            return Flock.nl_pid(this.address());
        }

        public Buffer l_type(short param1) {
            Flock.nl_type(this.address(), param1);
            return this;
        }

        public Buffer l_whence(short param1) {
            Flock.nl_whence(this.address(), param1);
            return this;
        }

        public Buffer l_start(@NativeType(value="off_t") long param1) {
            Flock.nl_start(this.address(), param1);
            return this;
        }

        public Buffer l_len(@NativeType(value="off_t") long param1) {
            Flock.nl_len(this.address(), param1);
            return this;
        }

        public Buffer l_pid(@NativeType(value="pid_t") int param1) {
            Flock.nl_pid(this.address(), param1);
            return this;
        }
    }
}

