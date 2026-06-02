/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;
import org.lwjgl.system.linux.StatxTimestamp;

@NativeType(value="struct statx")
public class Statx
extends Struct<Statx>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int STX_MASK;
    public static final int STX_BLKSIZE;
    public static final int STX_ATTRIBUTES;
    public static final int STX_NLINK;
    public static final int STX_UID;
    public static final int STX_GID;
    public static final int STX_MODE;
    public static final int __SPARE0;
    public static final int STX_INO;
    public static final int STX_SIZE;
    public static final int STX_BLOCKS;
    public static final int STX_ATTRIBUTES_MASK;
    public static final int STX_ATIME;
    public static final int STX_BTIME;
    public static final int STX_CTIME;
    public static final int STX_MTIME;
    public static final int STX_RDEV_MAJOR;
    public static final int STX_RDEV_MINOR;
    public static final int STX_DEV_MAJOR;
    public static final int STX_DEV_MINOR;
    public static final int STX_MNT_ID;
    public static final int __SPARE2;
    public static final int __SPARE3;

    protected Statx(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected Statx create(long param1, @Nullable ByteBuffer param3) {
        return new Statx(param1, param3);
    }

    public Statx(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), Statx.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u32")
    public int stx_mask() {
        return Statx.nstx_mask(this.address());
    }

    @NativeType(value="__u32")
    public int stx_blksize() {
        return Statx.nstx_blksize(this.address());
    }

    @NativeType(value="__u64")
    public long stx_attributes() {
        return Statx.nstx_attributes(this.address());
    }

    @NativeType(value="__u32")
    public int stx_nlink() {
        return Statx.nstx_nlink(this.address());
    }

    @NativeType(value="__u32")
    public int stx_uid() {
        return Statx.nstx_uid(this.address());
    }

    @NativeType(value="__u32")
    public int stx_gid() {
        return Statx.nstx_gid(this.address());
    }

    @NativeType(value="__u16")
    public short stx_mode() {
        return Statx.nstx_mode(this.address());
    }

    @NativeType(value="__u64")
    public long stx_ino() {
        return Statx.nstx_ino(this.address());
    }

    @NativeType(value="__u64")
    public long stx_size() {
        return Statx.nstx_size(this.address());
    }

    @NativeType(value="__u64")
    public long stx_blocks() {
        return Statx.nstx_blocks(this.address());
    }

    @NativeType(value="__u64")
    public long stx_attributes_mask() {
        return Statx.nstx_attributes_mask(this.address());
    }

    @NativeType(value="struct statx_timestamp")
    public StatxTimestamp stx_atime() {
        return Statx.nstx_atime(this.address());
    }

    @NativeType(value="struct statx_timestamp")
    public StatxTimestamp stx_btime() {
        return Statx.nstx_btime(this.address());
    }

    @NativeType(value="struct statx_timestamp")
    public StatxTimestamp stx_ctime() {
        return Statx.nstx_ctime(this.address());
    }

    @NativeType(value="struct statx_timestamp")
    public StatxTimestamp stx_mtime() {
        return Statx.nstx_mtime(this.address());
    }

    @NativeType(value="__u32")
    public int stx_rdev_major() {
        return Statx.nstx_rdev_major(this.address());
    }

    @NativeType(value="__u32")
    public int stx_rdev_minor() {
        return Statx.nstx_rdev_minor(this.address());
    }

    @NativeType(value="__u32")
    public int stx_dev_major() {
        return Statx.nstx_dev_major(this.address());
    }

    @NativeType(value="__u32")
    public int stx_dev_minor() {
        return Statx.nstx_dev_minor(this.address());
    }

    @NativeType(value="__u64")
    public long stx_mnt_id() {
        return Statx.nstx_mnt_id(this.address());
    }

    public Statx stx_mask(@NativeType(value="__u32") int param1) {
        Statx.nstx_mask(this.address(), param1);
        return this;
    }

    public Statx stx_blksize(@NativeType(value="__u32") int param1) {
        Statx.nstx_blksize(this.address(), param1);
        return this;
    }

    public Statx stx_attributes(@NativeType(value="__u64") long param1) {
        Statx.nstx_attributes(this.address(), param1);
        return this;
    }

    public Statx stx_nlink(@NativeType(value="__u32") int param1) {
        Statx.nstx_nlink(this.address(), param1);
        return this;
    }

    public Statx stx_uid(@NativeType(value="__u32") int param1) {
        Statx.nstx_uid(this.address(), param1);
        return this;
    }

    public Statx stx_gid(@NativeType(value="__u32") int param1) {
        Statx.nstx_gid(this.address(), param1);
        return this;
    }

    public Statx stx_mode(@NativeType(value="__u16") short param1) {
        Statx.nstx_mode(this.address(), param1);
        return this;
    }

    public Statx stx_ino(@NativeType(value="__u64") long param1) {
        Statx.nstx_ino(this.address(), param1);
        return this;
    }

    public Statx stx_size(@NativeType(value="__u64") long param1) {
        Statx.nstx_size(this.address(), param1);
        return this;
    }

    public Statx stx_blocks(@NativeType(value="__u64") long param1) {
        Statx.nstx_blocks(this.address(), param1);
        return this;
    }

    public Statx stx_attributes_mask(@NativeType(value="__u64") long param1) {
        Statx.nstx_attributes_mask(this.address(), param1);
        return this;
    }

    public Statx stx_atime(@NativeType(value="struct statx_timestamp") StatxTimestamp param1) {
        Statx.nstx_atime(this.address(), param1);
        return this;
    }

    public Statx stx_atime(Consumer<StatxTimestamp> param1) {
        param1.accept(this.stx_atime());
        return this;
    }

    public Statx stx_btime(@NativeType(value="struct statx_timestamp") StatxTimestamp param1) {
        Statx.nstx_btime(this.address(), param1);
        return this;
    }

    public Statx stx_btime(Consumer<StatxTimestamp> param1) {
        param1.accept(this.stx_btime());
        return this;
    }

    public Statx stx_ctime(@NativeType(value="struct statx_timestamp") StatxTimestamp param1) {
        Statx.nstx_ctime(this.address(), param1);
        return this;
    }

    public Statx stx_ctime(Consumer<StatxTimestamp> param1) {
        param1.accept(this.stx_ctime());
        return this;
    }

    public Statx stx_mtime(@NativeType(value="struct statx_timestamp") StatxTimestamp param1) {
        Statx.nstx_mtime(this.address(), param1);
        return this;
    }

    public Statx stx_mtime(Consumer<StatxTimestamp> param1) {
        param1.accept(this.stx_mtime());
        return this;
    }

    public Statx stx_rdev_major(@NativeType(value="__u32") int param1) {
        Statx.nstx_rdev_major(this.address(), param1);
        return this;
    }

    public Statx stx_rdev_minor(@NativeType(value="__u32") int param1) {
        Statx.nstx_rdev_minor(this.address(), param1);
        return this;
    }

    public Statx stx_dev_major(@NativeType(value="__u32") int param1) {
        Statx.nstx_dev_major(this.address(), param1);
        return this;
    }

    public Statx stx_dev_minor(@NativeType(value="__u32") int param1) {
        Statx.nstx_dev_minor(this.address(), param1);
        return this;
    }

    public Statx stx_mnt_id(@NativeType(value="__u64") long param1) {
        Statx.nstx_mnt_id(this.address(), param1);
        return this;
    }

    public Statx set(int param1, int param2, long param3, int param5, int param6, int param7, short param8, long param9, long param11, long param13, long param15, StatxTimestamp param17, StatxTimestamp param18, StatxTimestamp param19, StatxTimestamp param20, int param21, int param22, int param23, int param24, long param25) {
        this.stx_mask(param1);
        this.stx_blksize(param2);
        this.stx_attributes(param3);
        this.stx_nlink(param5);
        this.stx_uid(param6);
        this.stx_gid(param7);
        this.stx_mode(param8);
        this.stx_ino(param9);
        this.stx_size(param11);
        this.stx_blocks(param13);
        this.stx_attributes_mask(param15);
        this.stx_atime(param17);
        this.stx_btime(param18);
        this.stx_ctime(param19);
        this.stx_mtime(param20);
        this.stx_rdev_major(param21);
        this.stx_rdev_minor(param22);
        this.stx_dev_major(param23);
        this.stx_dev_minor(param24);
        this.stx_mnt_id(param25);
        return this;
    }

    public Statx set(Statx param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static Statx malloc() {
        return new Statx(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static Statx calloc() {
        return new Statx(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static Statx create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new Statx(MemoryUtil.memAddress(v0), v0);
    }

    public static Statx create(long param0) {
        return new Statx(param0, null);
    }

    @Nullable
    public static Statx createSafe(long param0) {
        return param0 == 0L ? null : new Statx(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(Statx.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = Statx.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static Statx malloc(MemoryStack param0) {
        return new Statx(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static Statx calloc(MemoryStack param0) {
        return new Statx(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static int nstx_mask(long param0) {
        return UNSAFE.getInt(null, param0 + (long)STX_MASK);
    }

    public static int nstx_blksize(long param0) {
        return UNSAFE.getInt(null, param0 + (long)STX_BLKSIZE);
    }

    public static long nstx_attributes(long param0) {
        return UNSAFE.getLong(null, param0 + (long)STX_ATTRIBUTES);
    }

    public static int nstx_nlink(long param0) {
        return UNSAFE.getInt(null, param0 + (long)STX_NLINK);
    }

    public static int nstx_uid(long param0) {
        return UNSAFE.getInt(null, param0 + (long)STX_UID);
    }

    public static int nstx_gid(long param0) {
        return UNSAFE.getInt(null, param0 + (long)STX_GID);
    }

    public static short nstx_mode(long param0) {
        return UNSAFE.getShort(null, param0 + (long)STX_MODE);
    }

    public static ShortBuffer n__spare0(long param0) {
        return MemoryUtil.memShortBuffer(param0 + (long)__SPARE0, 1);
    }

    public static short n__spare0(long param0, int param2) {
        return UNSAFE.getShort(null, param0 + (long)__SPARE0 + Checks.check(param2, 1) * 2L);
    }

    public static long nstx_ino(long param0) {
        return UNSAFE.getLong(null, param0 + (long)STX_INO);
    }

    public static long nstx_size(long param0) {
        return UNSAFE.getLong(null, param0 + (long)STX_SIZE);
    }

    public static long nstx_blocks(long param0) {
        return UNSAFE.getLong(null, param0 + (long)STX_BLOCKS);
    }

    public static long nstx_attributes_mask(long param0) {
        return UNSAFE.getLong(null, param0 + (long)STX_ATTRIBUTES_MASK);
    }

    public static StatxTimestamp nstx_atime(long param0) {
        return StatxTimestamp.create(param0 + (long)STX_ATIME);
    }

    public static StatxTimestamp nstx_btime(long param0) {
        return StatxTimestamp.create(param0 + (long)STX_BTIME);
    }

    public static StatxTimestamp nstx_ctime(long param0) {
        return StatxTimestamp.create(param0 + (long)STX_CTIME);
    }

    public static StatxTimestamp nstx_mtime(long param0) {
        return StatxTimestamp.create(param0 + (long)STX_MTIME);
    }

    public static int nstx_rdev_major(long param0) {
        return UNSAFE.getInt(null, param0 + (long)STX_RDEV_MAJOR);
    }

    public static int nstx_rdev_minor(long param0) {
        return UNSAFE.getInt(null, param0 + (long)STX_RDEV_MINOR);
    }

    public static int nstx_dev_major(long param0) {
        return UNSAFE.getInt(null, param0 + (long)STX_DEV_MAJOR);
    }

    public static int nstx_dev_minor(long param0) {
        return UNSAFE.getInt(null, param0 + (long)STX_DEV_MINOR);
    }

    public static long nstx_mnt_id(long param0) {
        return UNSAFE.getLong(null, param0 + (long)STX_MNT_ID);
    }

    public static long n__spare2(long param0) {
        return UNSAFE.getLong(null, param0 + (long)__SPARE2);
    }

    public static LongBuffer n__spare3(long param0) {
        return MemoryUtil.memLongBuffer(param0 + (long)__SPARE3, 12);
    }

    public static long n__spare3(long param0, int param2) {
        return UNSAFE.getLong(null, param0 + (long)__SPARE3 + Checks.check(param2, 12) * 8L);
    }

    public static void nstx_mask(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)STX_MASK, param2);
    }

    public static void nstx_blksize(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)STX_BLKSIZE, param2);
    }

    public static void nstx_attributes(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)STX_ATTRIBUTES, param2);
    }

    public static void nstx_nlink(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)STX_NLINK, param2);
    }

    public static void nstx_uid(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)STX_UID, param2);
    }

    public static void nstx_gid(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)STX_GID, param2);
    }

    public static void nstx_mode(long param0, short param2) {
        UNSAFE.putShort(null, param0 + (long)STX_MODE, param2);
    }

    public static void n__spare0(long param0, ShortBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkGT(param2, 1);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(param2), param0 + (long)__SPARE0, param2.remaining() * 2);
    }

    public static void n__spare0(long param0, int param2, short param3) {
        UNSAFE.putShort(null, param0 + (long)__SPARE0 + Checks.check(param2, 1) * 2L, param3);
    }

    public static void nstx_ino(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)STX_INO, param2);
    }

    public static void nstx_size(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)STX_SIZE, param2);
    }

    public static void nstx_blocks(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)STX_BLOCKS, param2);
    }

    public static void nstx_attributes_mask(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)STX_ATTRIBUTES_MASK, param2);
    }

    public static void nstx_atime(long param0, StatxTimestamp param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)STX_ATIME, StatxTimestamp.SIZEOF);
    }

    public static void nstx_btime(long param0, StatxTimestamp param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)STX_BTIME, StatxTimestamp.SIZEOF);
    }

    public static void nstx_ctime(long param0, StatxTimestamp param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)STX_CTIME, StatxTimestamp.SIZEOF);
    }

    public static void nstx_mtime(long param0, StatxTimestamp param2) {
        MemoryUtil.memCopy(param2.address(), param0 + (long)STX_MTIME, StatxTimestamp.SIZEOF);
    }

    public static void nstx_rdev_major(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)STX_RDEV_MAJOR, param2);
    }

    public static void nstx_rdev_minor(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)STX_RDEV_MINOR, param2);
    }

    public static void nstx_dev_major(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)STX_DEV_MAJOR, param2);
    }

    public static void nstx_dev_minor(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)STX_DEV_MINOR, param2);
    }

    public static void nstx_mnt_id(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)STX_MNT_ID, param2);
    }

    public static void n__spare2(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)__SPARE2, param2);
    }

    public static void n__spare3(long param0, LongBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkGT(param2, 12);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(param2), param0 + (long)__SPARE3, param2.remaining() * 8);
    }

    public static void n__spare3(long param0, int param2, long param3) {
        UNSAFE.putLong(null, param0 + (long)__SPARE3 + Checks.check(param2, 12) * 8L, param3);
    }

    static {
        Struct.Layout v0 = Statx.__struct(Statx.__member(4), Statx.__member(4), Statx.__member(8), Statx.__member(4), Statx.__member(4), Statx.__member(4), Statx.__member(2), Statx.__array(2, 1), Statx.__member(8), Statx.__member(8), Statx.__member(8), Statx.__member(8), Statx.__member(StatxTimestamp.SIZEOF, StatxTimestamp.ALIGNOF), Statx.__member(StatxTimestamp.SIZEOF, StatxTimestamp.ALIGNOF), Statx.__member(StatxTimestamp.SIZEOF, StatxTimestamp.ALIGNOF), Statx.__member(StatxTimestamp.SIZEOF, StatxTimestamp.ALIGNOF), Statx.__member(4), Statx.__member(4), Statx.__member(4), Statx.__member(4), Statx.__member(8), Statx.__member(8), Statx.__array(8, 12));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        STX_MASK = v0.offsetof(0);
        STX_BLKSIZE = v0.offsetof(1);
        STX_ATTRIBUTES = v0.offsetof(2);
        STX_NLINK = v0.offsetof(3);
        STX_UID = v0.offsetof(4);
        STX_GID = v0.offsetof(5);
        STX_MODE = v0.offsetof(6);
        __SPARE0 = v0.offsetof(7);
        STX_INO = v0.offsetof(8);
        STX_SIZE = v0.offsetof(9);
        STX_BLOCKS = v0.offsetof(10);
        STX_ATTRIBUTES_MASK = v0.offsetof(11);
        STX_ATIME = v0.offsetof(12);
        STX_BTIME = v0.offsetof(13);
        STX_CTIME = v0.offsetof(14);
        STX_MTIME = v0.offsetof(15);
        STX_RDEV_MAJOR = v0.offsetof(16);
        STX_RDEV_MINOR = v0.offsetof(17);
        STX_DEV_MAJOR = v0.offsetof(18);
        STX_DEV_MINOR = v0.offsetof(19);
        STX_MNT_ID = v0.offsetof(20);
        __SPARE2 = v0.offsetof(21);
        __SPARE3 = v0.offsetof(22);
    }

    public static class Buffer
    extends StructBuffer<Statx, Buffer>
    implements NativeResource {
        private static final Statx ELEMENT_FACTORY = Statx.create(-1L);

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
        protected Statx getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u32")
        public int stx_mask() {
            return Statx.nstx_mask(this.address());
        }

        @NativeType(value="__u32")
        public int stx_blksize() {
            return Statx.nstx_blksize(this.address());
        }

        @NativeType(value="__u64")
        public long stx_attributes() {
            return Statx.nstx_attributes(this.address());
        }

        @NativeType(value="__u32")
        public int stx_nlink() {
            return Statx.nstx_nlink(this.address());
        }

        @NativeType(value="__u32")
        public int stx_uid() {
            return Statx.nstx_uid(this.address());
        }

        @NativeType(value="__u32")
        public int stx_gid() {
            return Statx.nstx_gid(this.address());
        }

        @NativeType(value="__u16")
        public short stx_mode() {
            return Statx.nstx_mode(this.address());
        }

        @NativeType(value="__u64")
        public long stx_ino() {
            return Statx.nstx_ino(this.address());
        }

        @NativeType(value="__u64")
        public long stx_size() {
            return Statx.nstx_size(this.address());
        }

        @NativeType(value="__u64")
        public long stx_blocks() {
            return Statx.nstx_blocks(this.address());
        }

        @NativeType(value="__u64")
        public long stx_attributes_mask() {
            return Statx.nstx_attributes_mask(this.address());
        }

        @NativeType(value="struct statx_timestamp")
        public StatxTimestamp stx_atime() {
            return Statx.nstx_atime(this.address());
        }

        @NativeType(value="struct statx_timestamp")
        public StatxTimestamp stx_btime() {
            return Statx.nstx_btime(this.address());
        }

        @NativeType(value="struct statx_timestamp")
        public StatxTimestamp stx_ctime() {
            return Statx.nstx_ctime(this.address());
        }

        @NativeType(value="struct statx_timestamp")
        public StatxTimestamp stx_mtime() {
            return Statx.nstx_mtime(this.address());
        }

        @NativeType(value="__u32")
        public int stx_rdev_major() {
            return Statx.nstx_rdev_major(this.address());
        }

        @NativeType(value="__u32")
        public int stx_rdev_minor() {
            return Statx.nstx_rdev_minor(this.address());
        }

        @NativeType(value="__u32")
        public int stx_dev_major() {
            return Statx.nstx_dev_major(this.address());
        }

        @NativeType(value="__u32")
        public int stx_dev_minor() {
            return Statx.nstx_dev_minor(this.address());
        }

        @NativeType(value="__u64")
        public long stx_mnt_id() {
            return Statx.nstx_mnt_id(this.address());
        }

        public Buffer stx_mask(@NativeType(value="__u32") int param1) {
            Statx.nstx_mask(this.address(), param1);
            return this;
        }

        public Buffer stx_blksize(@NativeType(value="__u32") int param1) {
            Statx.nstx_blksize(this.address(), param1);
            return this;
        }

        public Buffer stx_attributes(@NativeType(value="__u64") long param1) {
            Statx.nstx_attributes(this.address(), param1);
            return this;
        }

        public Buffer stx_nlink(@NativeType(value="__u32") int param1) {
            Statx.nstx_nlink(this.address(), param1);
            return this;
        }

        public Buffer stx_uid(@NativeType(value="__u32") int param1) {
            Statx.nstx_uid(this.address(), param1);
            return this;
        }

        public Buffer stx_gid(@NativeType(value="__u32") int param1) {
            Statx.nstx_gid(this.address(), param1);
            return this;
        }

        public Buffer stx_mode(@NativeType(value="__u16") short param1) {
            Statx.nstx_mode(this.address(), param1);
            return this;
        }

        public Buffer stx_ino(@NativeType(value="__u64") long param1) {
            Statx.nstx_ino(this.address(), param1);
            return this;
        }

        public Buffer stx_size(@NativeType(value="__u64") long param1) {
            Statx.nstx_size(this.address(), param1);
            return this;
        }

        public Buffer stx_blocks(@NativeType(value="__u64") long param1) {
            Statx.nstx_blocks(this.address(), param1);
            return this;
        }

        public Buffer stx_attributes_mask(@NativeType(value="__u64") long param1) {
            Statx.nstx_attributes_mask(this.address(), param1);
            return this;
        }

        public Buffer stx_atime(@NativeType(value="struct statx_timestamp") StatxTimestamp param1) {
            Statx.nstx_atime(this.address(), param1);
            return this;
        }

        public Buffer stx_atime(Consumer<StatxTimestamp> param1) {
            param1.accept(this.stx_atime());
            return this;
        }

        public Buffer stx_btime(@NativeType(value="struct statx_timestamp") StatxTimestamp param1) {
            Statx.nstx_btime(this.address(), param1);
            return this;
        }

        public Buffer stx_btime(Consumer<StatxTimestamp> param1) {
            param1.accept(this.stx_btime());
            return this;
        }

        public Buffer stx_ctime(@NativeType(value="struct statx_timestamp") StatxTimestamp param1) {
            Statx.nstx_ctime(this.address(), param1);
            return this;
        }

        public Buffer stx_ctime(Consumer<StatxTimestamp> param1) {
            param1.accept(this.stx_ctime());
            return this;
        }

        public Buffer stx_mtime(@NativeType(value="struct statx_timestamp") StatxTimestamp param1) {
            Statx.nstx_mtime(this.address(), param1);
            return this;
        }

        public Buffer stx_mtime(Consumer<StatxTimestamp> param1) {
            param1.accept(this.stx_mtime());
            return this;
        }

        public Buffer stx_rdev_major(@NativeType(value="__u32") int param1) {
            Statx.nstx_rdev_major(this.address(), param1);
            return this;
        }

        public Buffer stx_rdev_minor(@NativeType(value="__u32") int param1) {
            Statx.nstx_rdev_minor(this.address(), param1);
            return this;
        }

        public Buffer stx_dev_major(@NativeType(value="__u32") int param1) {
            Statx.nstx_dev_major(this.address(), param1);
            return this;
        }

        public Buffer stx_dev_minor(@NativeType(value="__u32") int param1) {
            Statx.nstx_dev_minor(this.address(), param1);
            return this;
        }

        public Buffer stx_mnt_id(@NativeType(value="__u64") long param1) {
            Statx.nstx_mnt_id(this.address(), param1);
            return this;
        }
    }
}

