/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux.liburing;

import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct io_uring_sqe")
public class IOURingSQE
extends Struct<IOURingSQE>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int OPCODE;
    public static final int FLAGS;
    public static final int IOPRIO;
    public static final int FD;
    public static final int OFF;
    public static final int ADDR2;
    public static final int CMD_OP;
    public static final int __PAD1;
    public static final int ADDR;
    public static final int SPLICE_OFF_IN;
    public static final int LEN;
    public static final int RW_FLAGS;
    public static final int FSYNC_FLAGS;
    public static final int POLL_EVENTS;
    public static final int POLL32_EVENTS;
    public static final int SYNC_RANGE_FLAGS;
    public static final int MSG_FLAGS;
    public static final int TIMEOUT_FLAGS;
    public static final int ACCEPT_FLAGS;
    public static final int CANCEL_FLAGS;
    public static final int OPEN_FLAGS;
    public static final int STATX_FLAGS;
    public static final int FADVISE_ADVICE;
    public static final int SPLICE_FLAGS;
    public static final int RENAME_FLAGS;
    public static final int UNLINK_FLAGS;
    public static final int HARDLINK_FLAGS;
    public static final int XATTR_FLAGS;
    public static final int MSG_RING_FLAGS;
    public static final int URING_CMD_FLAGS;
    public static final int USER_DATA;
    public static final int BUF_INDEX;
    public static final int BUF_GROUP;
    public static final int PERSONALITY;
    public static final int SPLICE_FD_IN;
    public static final int FILE_INDEX;
    public static final int ADDR_LEN;
    public static final int __PAD3;
    public static final int ADDR3;
    public static final int __PAD2;
    public static final int CMD;

    protected IOURingSQE(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected IOURingSQE create(long param1, @Nullable ByteBuffer param3) {
        return new IOURingSQE(param1, param3);
    }

    public IOURingSQE(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), IOURingSQE.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u8")
    public byte opcode() {
        return IOURingSQE.nopcode(this.address());
    }

    @NativeType(value="__u8")
    public byte flags() {
        return IOURingSQE.nflags(this.address());
    }

    @NativeType(value="__u16")
    public short ioprio() {
        return IOURingSQE.nioprio(this.address());
    }

    @NativeType(value="__s32")
    public int fd() {
        return IOURingSQE.nfd(this.address());
    }

    @NativeType(value="__u64")
    public long off() {
        return IOURingSQE.noff(this.address());
    }

    @NativeType(value="__u64")
    public long addr2() {
        return IOURingSQE.naddr2(this.address());
    }

    @NativeType(value="__u32")
    public int cmd_op() {
        return IOURingSQE.ncmd_op(this.address());
    }

    @NativeType(value="__u32")
    public int __pad1() {
        return IOURingSQE.n__pad1(this.address());
    }

    @NativeType(value="__u64")
    public long addr() {
        return IOURingSQE.naddr(this.address());
    }

    @NativeType(value="__u64")
    public long splice_off_in() {
        return IOURingSQE.nsplice_off_in(this.address());
    }

    @NativeType(value="__u32")
    public int len() {
        return IOURingSQE.nlen(this.address());
    }

    @NativeType(value="__kernel_rwf_t")
    public int rw_flags() {
        return IOURingSQE.nrw_flags(this.address());
    }

    @NativeType(value="__u32")
    public int fsync_flags() {
        return IOURingSQE.nfsync_flags(this.address());
    }

    @NativeType(value="__u16")
    public short poll_events() {
        return IOURingSQE.npoll_events(this.address());
    }

    @NativeType(value="__u32")
    public int poll32_events() {
        return IOURingSQE.npoll32_events(this.address());
    }

    @NativeType(value="__u32")
    public int sync_range_flags() {
        return IOURingSQE.nsync_range_flags(this.address());
    }

    @NativeType(value="__u32")
    public int msg_flags() {
        return IOURingSQE.nmsg_flags(this.address());
    }

    @NativeType(value="__u32")
    public int timeout_flags() {
        return IOURingSQE.ntimeout_flags(this.address());
    }

    @NativeType(value="__u32")
    public int accept_flags() {
        return IOURingSQE.naccept_flags(this.address());
    }

    @NativeType(value="__u32")
    public int cancel_flags() {
        return IOURingSQE.ncancel_flags(this.address());
    }

    @NativeType(value="__u32")
    public int open_flags() {
        return IOURingSQE.nopen_flags(this.address());
    }

    @NativeType(value="__u32")
    public int statx_flags() {
        return IOURingSQE.nstatx_flags(this.address());
    }

    @NativeType(value="__u32")
    public int fadvise_advice() {
        return IOURingSQE.nfadvise_advice(this.address());
    }

    @NativeType(value="__u32")
    public int splice_flags() {
        return IOURingSQE.nsplice_flags(this.address());
    }

    @NativeType(value="__u32")
    public int rename_flags() {
        return IOURingSQE.nrename_flags(this.address());
    }

    @NativeType(value="__u32")
    public int unlink_flags() {
        return IOURingSQE.nunlink_flags(this.address());
    }

    @NativeType(value="__u32")
    public int hardlink_flags() {
        return IOURingSQE.nhardlink_flags(this.address());
    }

    @NativeType(value="__u32")
    public int xattr_flags() {
        return IOURingSQE.nxattr_flags(this.address());
    }

    @NativeType(value="__u32")
    public int msg_ring_flags() {
        return IOURingSQE.nmsg_ring_flags(this.address());
    }

    @NativeType(value="__u32")
    public int uring_cmd_flags() {
        return IOURingSQE.nuring_cmd_flags(this.address());
    }

    @NativeType(value="__u64")
    public long user_data() {
        return IOURingSQE.nuser_data(this.address());
    }

    @NativeType(value="__u16")
    public short buf_index() {
        return IOURingSQE.nbuf_index(this.address());
    }

    @NativeType(value="__u16")
    public short buf_group() {
        return IOURingSQE.nbuf_group(this.address());
    }

    @NativeType(value="__u16")
    public short personality() {
        return IOURingSQE.npersonality(this.address());
    }

    @NativeType(value="__s32")
    public int splice_fd_in() {
        return IOURingSQE.nsplice_fd_in(this.address());
    }

    @NativeType(value="__u32")
    public int file_index() {
        return IOURingSQE.nfile_index(this.address());
    }

    @NativeType(value="__u16")
    public short addr_len() {
        return IOURingSQE.naddr_len(this.address());
    }

    @NativeType(value="__u16[1]")
    public ShortBuffer __pad3() {
        return IOURingSQE.n__pad3(this.address());
    }

    @NativeType(value="__u16")
    public short __pad3(int param1) {
        return IOURingSQE.n__pad3(this.address(), param1);
    }

    @NativeType(value="__u64")
    public long addr3() {
        return IOURingSQE.naddr3(this.address());
    }

    @NativeType(value="__u64[1]")
    public LongBuffer __pad2() {
        return IOURingSQE.n__pad2(this.address());
    }

    @NativeType(value="__u64")
    public long __pad2(int param1) {
        return IOURingSQE.n__pad2(this.address(), param1);
    }

    @NativeType(value="__u8[0]")
    public ByteBuffer cmd() {
        return IOURingSQE.ncmd(this.address());
    }

    @NativeType(value="__u8")
    public byte cmd(int param1) {
        return IOURingSQE.ncmd(this.address(), param1);
    }

    public IOURingSQE opcode(@NativeType(value="__u8") byte param1) {
        IOURingSQE.nopcode(this.address(), param1);
        return this;
    }

    public IOURingSQE flags(@NativeType(value="__u8") byte param1) {
        IOURingSQE.nflags(this.address(), param1);
        return this;
    }

    public IOURingSQE ioprio(@NativeType(value="__u16") short param1) {
        IOURingSQE.nioprio(this.address(), param1);
        return this;
    }

    public IOURingSQE fd(@NativeType(value="__s32") int param1) {
        IOURingSQE.nfd(this.address(), param1);
        return this;
    }

    public IOURingSQE off(@NativeType(value="__u64") long param1) {
        IOURingSQE.noff(this.address(), param1);
        return this;
    }

    public IOURingSQE addr2(@NativeType(value="__u64") long param1) {
        IOURingSQE.naddr2(this.address(), param1);
        return this;
    }

    public IOURingSQE cmd_op(@NativeType(value="__u32") int param1) {
        IOURingSQE.ncmd_op(this.address(), param1);
        return this;
    }

    public IOURingSQE __pad1(@NativeType(value="__u32") int param1) {
        IOURingSQE.n__pad1(this.address(), param1);
        return this;
    }

    public IOURingSQE addr(@NativeType(value="__u64") long param1) {
        IOURingSQE.naddr(this.address(), param1);
        return this;
    }

    public IOURingSQE splice_off_in(@NativeType(value="__u64") long param1) {
        IOURingSQE.nsplice_off_in(this.address(), param1);
        return this;
    }

    public IOURingSQE len(@NativeType(value="__u32") int param1) {
        IOURingSQE.nlen(this.address(), param1);
        return this;
    }

    public IOURingSQE rw_flags(@NativeType(value="__kernel_rwf_t") int param1) {
        IOURingSQE.nrw_flags(this.address(), param1);
        return this;
    }

    public IOURingSQE fsync_flags(@NativeType(value="__u32") int param1) {
        IOURingSQE.nfsync_flags(this.address(), param1);
        return this;
    }

    public IOURingSQE poll_events(@NativeType(value="__u16") short param1) {
        IOURingSQE.npoll_events(this.address(), param1);
        return this;
    }

    public IOURingSQE poll32_events(@NativeType(value="__u32") int param1) {
        IOURingSQE.npoll32_events(this.address(), param1);
        return this;
    }

    public IOURingSQE sync_range_flags(@NativeType(value="__u32") int param1) {
        IOURingSQE.nsync_range_flags(this.address(), param1);
        return this;
    }

    public IOURingSQE msg_flags(@NativeType(value="__u32") int param1) {
        IOURingSQE.nmsg_flags(this.address(), param1);
        return this;
    }

    public IOURingSQE timeout_flags(@NativeType(value="__u32") int param1) {
        IOURingSQE.ntimeout_flags(this.address(), param1);
        return this;
    }

    public IOURingSQE accept_flags(@NativeType(value="__u32") int param1) {
        IOURingSQE.naccept_flags(this.address(), param1);
        return this;
    }

    public IOURingSQE cancel_flags(@NativeType(value="__u32") int param1) {
        IOURingSQE.ncancel_flags(this.address(), param1);
        return this;
    }

    public IOURingSQE open_flags(@NativeType(value="__u32") int param1) {
        IOURingSQE.nopen_flags(this.address(), param1);
        return this;
    }

    public IOURingSQE statx_flags(@NativeType(value="__u32") int param1) {
        IOURingSQE.nstatx_flags(this.address(), param1);
        return this;
    }

    public IOURingSQE fadvise_advice(@NativeType(value="__u32") int param1) {
        IOURingSQE.nfadvise_advice(this.address(), param1);
        return this;
    }

    public IOURingSQE splice_flags(@NativeType(value="__u32") int param1) {
        IOURingSQE.nsplice_flags(this.address(), param1);
        return this;
    }

    public IOURingSQE rename_flags(@NativeType(value="__u32") int param1) {
        IOURingSQE.nrename_flags(this.address(), param1);
        return this;
    }

    public IOURingSQE unlink_flags(@NativeType(value="__u32") int param1) {
        IOURingSQE.nunlink_flags(this.address(), param1);
        return this;
    }

    public IOURingSQE hardlink_flags(@NativeType(value="__u32") int param1) {
        IOURingSQE.nhardlink_flags(this.address(), param1);
        return this;
    }

    public IOURingSQE xattr_flags(@NativeType(value="__u32") int param1) {
        IOURingSQE.nxattr_flags(this.address(), param1);
        return this;
    }

    public IOURingSQE msg_ring_flags(@NativeType(value="__u32") int param1) {
        IOURingSQE.nmsg_ring_flags(this.address(), param1);
        return this;
    }

    public IOURingSQE uring_cmd_flags(@NativeType(value="__u32") int param1) {
        IOURingSQE.nuring_cmd_flags(this.address(), param1);
        return this;
    }

    public IOURingSQE user_data(@NativeType(value="__u64") long param1) {
        IOURingSQE.nuser_data(this.address(), param1);
        return this;
    }

    public IOURingSQE buf_index(@NativeType(value="__u16") short param1) {
        IOURingSQE.nbuf_index(this.address(), param1);
        return this;
    }

    public IOURingSQE buf_group(@NativeType(value="__u16") short param1) {
        IOURingSQE.nbuf_group(this.address(), param1);
        return this;
    }

    public IOURingSQE personality(@NativeType(value="__u16") short param1) {
        IOURingSQE.npersonality(this.address(), param1);
        return this;
    }

    public IOURingSQE splice_fd_in(@NativeType(value="__s32") int param1) {
        IOURingSQE.nsplice_fd_in(this.address(), param1);
        return this;
    }

    public IOURingSQE file_index(@NativeType(value="__u32") int param1) {
        IOURingSQE.nfile_index(this.address(), param1);
        return this;
    }

    public IOURingSQE addr_len(@NativeType(value="__u16") short param1) {
        IOURingSQE.naddr_len(this.address(), param1);
        return this;
    }

    public IOURingSQE __pad3(@NativeType(value="__u16[1]") ShortBuffer param1) {
        IOURingSQE.n__pad3(this.address(), param1);
        return this;
    }

    public IOURingSQE __pad3(int param1, @NativeType(value="__u16") short param2) {
        IOURingSQE.n__pad3(this.address(), param1, param2);
        return this;
    }

    public IOURingSQE addr3(@NativeType(value="__u64") long param1) {
        IOURingSQE.naddr3(this.address(), param1);
        return this;
    }

    public IOURingSQE __pad2(@NativeType(value="__u64[1]") LongBuffer param1) {
        IOURingSQE.n__pad2(this.address(), param1);
        return this;
    }

    public IOURingSQE __pad2(int param1, @NativeType(value="__u64") long param2) {
        IOURingSQE.n__pad2(this.address(), param1, param2);
        return this;
    }

    public IOURingSQE cmd(@NativeType(value="__u8[0]") ByteBuffer param1) {
        IOURingSQE.ncmd(this.address(), param1);
        return this;
    }

    public IOURingSQE cmd(int param1, @NativeType(value="__u8") byte param2) {
        IOURingSQE.ncmd(this.address(), param1, param2);
        return this;
    }

    public IOURingSQE set(IOURingSQE param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingSQE malloc() {
        return new IOURingSQE(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingSQE calloc() {
        return new IOURingSQE(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingSQE create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingSQE(MemoryUtil.memAddress(v0), v0);
    }

    public static IOURingSQE create(long param0) {
        return new IOURingSQE(param0, null);
    }

    @Nullable
    public static IOURingSQE createSafe(long param0) {
        return param0 == 0L ? null : new IOURingSQE(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingSQE.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = IOURingSQE.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    public static IOURingSQE malloc(MemoryStack param0) {
        return new IOURingSQE(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingSQE calloc(MemoryStack param0) {
        return new IOURingSQE(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static byte nopcode(long param0) {
        return UNSAFE.getByte(null, param0 + (long)OPCODE);
    }

    public static byte nflags(long param0) {
        return UNSAFE.getByte(null, param0 + (long)FLAGS);
    }

    public static short nioprio(long param0) {
        return UNSAFE.getShort(null, param0 + (long)IOPRIO);
    }

    public static int nfd(long param0) {
        return UNSAFE.getInt(null, param0 + (long)FD);
    }

    public static long noff(long param0) {
        return UNSAFE.getLong(null, param0 + (long)OFF);
    }

    public static long naddr2(long param0) {
        return UNSAFE.getLong(null, param0 + (long)ADDR2);
    }

    public static int ncmd_op(long param0) {
        return UNSAFE.getInt(null, param0 + (long)CMD_OP);
    }

    public static int n__pad1(long param0) {
        return UNSAFE.getInt(null, param0 + (long)__PAD1);
    }

    public static long naddr(long param0) {
        return UNSAFE.getLong(null, param0 + (long)ADDR);
    }

    public static long nsplice_off_in(long param0) {
        return UNSAFE.getLong(null, param0 + (long)SPLICE_OFF_IN);
    }

    public static int nlen(long param0) {
        return UNSAFE.getInt(null, param0 + (long)LEN);
    }

    public static int nrw_flags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)RW_FLAGS);
    }

    public static int nfsync_flags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)FSYNC_FLAGS);
    }

    public static short npoll_events(long param0) {
        return UNSAFE.getShort(null, param0 + (long)POLL_EVENTS);
    }

    public static int npoll32_events(long param0) {
        return UNSAFE.getInt(null, param0 + (long)POLL32_EVENTS);
    }

    public static int nsync_range_flags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)SYNC_RANGE_FLAGS);
    }

    public static int nmsg_flags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)MSG_FLAGS);
    }

    public static int ntimeout_flags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)TIMEOUT_FLAGS);
    }

    public static int naccept_flags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)ACCEPT_FLAGS);
    }

    public static int ncancel_flags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)CANCEL_FLAGS);
    }

    public static int nopen_flags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)OPEN_FLAGS);
    }

    public static int nstatx_flags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)STATX_FLAGS);
    }

    public static int nfadvise_advice(long param0) {
        return UNSAFE.getInt(null, param0 + (long)FADVISE_ADVICE);
    }

    public static int nsplice_flags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)SPLICE_FLAGS);
    }

    public static int nrename_flags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)RENAME_FLAGS);
    }

    public static int nunlink_flags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)UNLINK_FLAGS);
    }

    public static int nhardlink_flags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)HARDLINK_FLAGS);
    }

    public static int nxattr_flags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)XATTR_FLAGS);
    }

    public static int nmsg_ring_flags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)MSG_RING_FLAGS);
    }

    public static int nuring_cmd_flags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)URING_CMD_FLAGS);
    }

    public static long nuser_data(long param0) {
        return UNSAFE.getLong(null, param0 + (long)USER_DATA);
    }

    public static short nbuf_index(long param0) {
        return UNSAFE.getShort(null, param0 + (long)BUF_INDEX);
    }

    public static short nbuf_group(long param0) {
        return UNSAFE.getShort(null, param0 + (long)BUF_GROUP);
    }

    public static short npersonality(long param0) {
        return UNSAFE.getShort(null, param0 + (long)PERSONALITY);
    }

    public static int nsplice_fd_in(long param0) {
        return UNSAFE.getInt(null, param0 + (long)SPLICE_FD_IN);
    }

    public static int nfile_index(long param0) {
        return UNSAFE.getInt(null, param0 + (long)FILE_INDEX);
    }

    public static short naddr_len(long param0) {
        return UNSAFE.getShort(null, param0 + (long)ADDR_LEN);
    }

    public static ShortBuffer n__pad3(long param0) {
        return MemoryUtil.memShortBuffer(param0 + (long)__PAD3, 1);
    }

    public static short n__pad3(long param0, int param2) {
        return UNSAFE.getShort(null, param0 + (long)__PAD3 + Checks.check(param2, 1) * 2L);
    }

    public static long naddr3(long param0) {
        return UNSAFE.getLong(null, param0 + (long)ADDR3);
    }

    public static LongBuffer n__pad2(long param0) {
        return MemoryUtil.memLongBuffer(param0 + (long)__PAD2, 1);
    }

    public static long n__pad2(long param0, int param2) {
        return UNSAFE.getLong(null, param0 + (long)__PAD2 + Checks.check(param2, 1) * 8L);
    }

    public static ByteBuffer ncmd(long param0) {
        return MemoryUtil.memByteBuffer(param0 + (long)CMD, 0);
    }

    public static byte ncmd(long param0, int param2) {
        return UNSAFE.getByte(null, param0 + (long)CMD + Checks.check(param2, 0) * 1L);
    }

    public static void nopcode(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)OPCODE, param2);
    }

    public static void nflags(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)FLAGS, param2);
    }

    public static void nioprio(long param0, short param2) {
        UNSAFE.putShort(null, param0 + (long)IOPRIO, param2);
    }

    public static void nfd(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)FD, param2);
    }

    public static void noff(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)OFF, param2);
    }

    public static void naddr2(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)ADDR2, param2);
    }

    public static void ncmd_op(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)CMD_OP, param2);
    }

    public static void n__pad1(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)__PAD1, param2);
    }

    public static void naddr(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)ADDR, param2);
    }

    public static void nsplice_off_in(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)SPLICE_OFF_IN, param2);
    }

    public static void nlen(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)LEN, param2);
    }

    public static void nrw_flags(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)RW_FLAGS, param2);
    }

    public static void nfsync_flags(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)FSYNC_FLAGS, param2);
    }

    public static void npoll_events(long param0, short param2) {
        UNSAFE.putShort(null, param0 + (long)POLL_EVENTS, param2);
    }

    public static void npoll32_events(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)POLL32_EVENTS, param2);
    }

    public static void nsync_range_flags(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)SYNC_RANGE_FLAGS, param2);
    }

    public static void nmsg_flags(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)MSG_FLAGS, param2);
    }

    public static void ntimeout_flags(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)TIMEOUT_FLAGS, param2);
    }

    public static void naccept_flags(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)ACCEPT_FLAGS, param2);
    }

    public static void ncancel_flags(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)CANCEL_FLAGS, param2);
    }

    public static void nopen_flags(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)OPEN_FLAGS, param2);
    }

    public static void nstatx_flags(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)STATX_FLAGS, param2);
    }

    public static void nfadvise_advice(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)FADVISE_ADVICE, param2);
    }

    public static void nsplice_flags(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)SPLICE_FLAGS, param2);
    }

    public static void nrename_flags(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)RENAME_FLAGS, param2);
    }

    public static void nunlink_flags(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)UNLINK_FLAGS, param2);
    }

    public static void nhardlink_flags(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)HARDLINK_FLAGS, param2);
    }

    public static void nxattr_flags(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)XATTR_FLAGS, param2);
    }

    public static void nmsg_ring_flags(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)MSG_RING_FLAGS, param2);
    }

    public static void nuring_cmd_flags(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)URING_CMD_FLAGS, param2);
    }

    public static void nuser_data(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)USER_DATA, param2);
    }

    public static void nbuf_index(long param0, short param2) {
        UNSAFE.putShort(null, param0 + (long)BUF_INDEX, param2);
    }

    public static void nbuf_group(long param0, short param2) {
        UNSAFE.putShort(null, param0 + (long)BUF_GROUP, param2);
    }

    public static void npersonality(long param0, short param2) {
        UNSAFE.putShort(null, param0 + (long)PERSONALITY, param2);
    }

    public static void nsplice_fd_in(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)SPLICE_FD_IN, param2);
    }

    public static void nfile_index(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)FILE_INDEX, param2);
    }

    public static void naddr_len(long param0, short param2) {
        UNSAFE.putShort(null, param0 + (long)ADDR_LEN, param2);
    }

    public static void n__pad3(long param0, ShortBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkGT(param2, 1);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(param2), param0 + (long)__PAD3, param2.remaining() * 2);
    }

    public static void n__pad3(long param0, int param2, short param3) {
        UNSAFE.putShort(null, param0 + (long)__PAD3 + Checks.check(param2, 1) * 2L, param3);
    }

    public static void naddr3(long param0, long param2) {
        UNSAFE.putLong(null, param0 + (long)ADDR3, param2);
    }

    public static void n__pad2(long param0, LongBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkGT(param2, 1);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(param2), param0 + (long)__PAD2, param2.remaining() * 8);
    }

    public static void n__pad2(long param0, int param2, long param3) {
        UNSAFE.putLong(null, param0 + (long)__PAD2 + Checks.check(param2, 1) * 8L, param3);
    }

    public static void ncmd(long param0, ByteBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkGT(param2, 0);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(param2), param0 + (long)CMD, param2.remaining() * 1);
    }

    public static void ncmd(long param0, int param2, byte param3) {
        UNSAFE.putByte(null, param0 + (long)CMD + Checks.check(param2, 0) * 1L, param3);
    }

    static {
        Struct.Layout v0 = IOURingSQE.__struct(IOURingSQE.__member(1), IOURingSQE.__member(1), IOURingSQE.__member(2), IOURingSQE.__member(4), IOURingSQE.__union(IOURingSQE.__member(8), IOURingSQE.__member(8), IOURingSQE.__struct(IOURingSQE.__member(4), IOURingSQE.__member(4))), IOURingSQE.__union(IOURingSQE.__member(8), IOURingSQE.__member(8)), IOURingSQE.__member(4), IOURingSQE.__union(IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(2), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4)), IOURingSQE.__member(8), IOURingSQE.__union(IOURingSQE.__member(2), IOURingSQE.__member(2)), IOURingSQE.__member(2), IOURingSQE.__union(IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__struct(IOURingSQE.__member(2), IOURingSQE.__array(2, 1))), IOURingSQE.__union(IOURingSQE.__struct(IOURingSQE.__member(8), IOURingSQE.__array(8, 1)), IOURingSQE.__array(1, 0)));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        OPCODE = v0.offsetof(0);
        FLAGS = v0.offsetof(1);
        IOPRIO = v0.offsetof(2);
        FD = v0.offsetof(3);
        OFF = v0.offsetof(5);
        ADDR2 = v0.offsetof(6);
        CMD_OP = v0.offsetof(8);
        __PAD1 = v0.offsetof(9);
        ADDR = v0.offsetof(11);
        SPLICE_OFF_IN = v0.offsetof(12);
        LEN = v0.offsetof(13);
        RW_FLAGS = v0.offsetof(15);
        FSYNC_FLAGS = v0.offsetof(16);
        POLL_EVENTS = v0.offsetof(17);
        POLL32_EVENTS = v0.offsetof(18);
        SYNC_RANGE_FLAGS = v0.offsetof(19);
        MSG_FLAGS = v0.offsetof(20);
        TIMEOUT_FLAGS = v0.offsetof(21);
        ACCEPT_FLAGS = v0.offsetof(22);
        CANCEL_FLAGS = v0.offsetof(23);
        OPEN_FLAGS = v0.offsetof(24);
        STATX_FLAGS = v0.offsetof(25);
        FADVISE_ADVICE = v0.offsetof(26);
        SPLICE_FLAGS = v0.offsetof(27);
        RENAME_FLAGS = v0.offsetof(28);
        UNLINK_FLAGS = v0.offsetof(29);
        HARDLINK_FLAGS = v0.offsetof(30);
        XATTR_FLAGS = v0.offsetof(31);
        MSG_RING_FLAGS = v0.offsetof(32);
        URING_CMD_FLAGS = v0.offsetof(33);
        USER_DATA = v0.offsetof(34);
        BUF_INDEX = v0.offsetof(36);
        BUF_GROUP = v0.offsetof(37);
        PERSONALITY = v0.offsetof(38);
        SPLICE_FD_IN = v0.offsetof(40);
        FILE_INDEX = v0.offsetof(41);
        ADDR_LEN = v0.offsetof(43);
        __PAD3 = v0.offsetof(44);
        ADDR3 = v0.offsetof(47);
        __PAD2 = v0.offsetof(48);
        CMD = v0.offsetof(49);
    }

    public static class Buffer
    extends StructBuffer<IOURingSQE, Buffer>
    implements NativeResource {
        private static final IOURingSQE ELEMENT_FACTORY = IOURingSQE.create(-1L);

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
        protected IOURingSQE getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u8")
        public byte opcode() {
            return IOURingSQE.nopcode(this.address());
        }

        @NativeType(value="__u8")
        public byte flags() {
            return IOURingSQE.nflags(this.address());
        }

        @NativeType(value="__u16")
        public short ioprio() {
            return IOURingSQE.nioprio(this.address());
        }

        @NativeType(value="__s32")
        public int fd() {
            return IOURingSQE.nfd(this.address());
        }

        @NativeType(value="__u64")
        public long off() {
            return IOURingSQE.noff(this.address());
        }

        @NativeType(value="__u64")
        public long addr2() {
            return IOURingSQE.naddr2(this.address());
        }

        @NativeType(value="__u32")
        public int cmd_op() {
            return IOURingSQE.ncmd_op(this.address());
        }

        @NativeType(value="__u32")
        public int __pad1() {
            return IOURingSQE.n__pad1(this.address());
        }

        @NativeType(value="__u64")
        public long addr() {
            return IOURingSQE.naddr(this.address());
        }

        @NativeType(value="__u64")
        public long splice_off_in() {
            return IOURingSQE.nsplice_off_in(this.address());
        }

        @NativeType(value="__u32")
        public int len() {
            return IOURingSQE.nlen(this.address());
        }

        @NativeType(value="__kernel_rwf_t")
        public int rw_flags() {
            return IOURingSQE.nrw_flags(this.address());
        }

        @NativeType(value="__u32")
        public int fsync_flags() {
            return IOURingSQE.nfsync_flags(this.address());
        }

        @NativeType(value="__u16")
        public short poll_events() {
            return IOURingSQE.npoll_events(this.address());
        }

        @NativeType(value="__u32")
        public int poll32_events() {
            return IOURingSQE.npoll32_events(this.address());
        }

        @NativeType(value="__u32")
        public int sync_range_flags() {
            return IOURingSQE.nsync_range_flags(this.address());
        }

        @NativeType(value="__u32")
        public int msg_flags() {
            return IOURingSQE.nmsg_flags(this.address());
        }

        @NativeType(value="__u32")
        public int timeout_flags() {
            return IOURingSQE.ntimeout_flags(this.address());
        }

        @NativeType(value="__u32")
        public int accept_flags() {
            return IOURingSQE.naccept_flags(this.address());
        }

        @NativeType(value="__u32")
        public int cancel_flags() {
            return IOURingSQE.ncancel_flags(this.address());
        }

        @NativeType(value="__u32")
        public int open_flags() {
            return IOURingSQE.nopen_flags(this.address());
        }

        @NativeType(value="__u32")
        public int statx_flags() {
            return IOURingSQE.nstatx_flags(this.address());
        }

        @NativeType(value="__u32")
        public int fadvise_advice() {
            return IOURingSQE.nfadvise_advice(this.address());
        }

        @NativeType(value="__u32")
        public int splice_flags() {
            return IOURingSQE.nsplice_flags(this.address());
        }

        @NativeType(value="__u32")
        public int rename_flags() {
            return IOURingSQE.nrename_flags(this.address());
        }

        @NativeType(value="__u32")
        public int unlink_flags() {
            return IOURingSQE.nunlink_flags(this.address());
        }

        @NativeType(value="__u32")
        public int hardlink_flags() {
            return IOURingSQE.nhardlink_flags(this.address());
        }

        @NativeType(value="__u32")
        public int xattr_flags() {
            return IOURingSQE.nxattr_flags(this.address());
        }

        @NativeType(value="__u32")
        public int msg_ring_flags() {
            return IOURingSQE.nmsg_ring_flags(this.address());
        }

        @NativeType(value="__u32")
        public int uring_cmd_flags() {
            return IOURingSQE.nuring_cmd_flags(this.address());
        }

        @NativeType(value="__u64")
        public long user_data() {
            return IOURingSQE.nuser_data(this.address());
        }

        @NativeType(value="__u16")
        public short buf_index() {
            return IOURingSQE.nbuf_index(this.address());
        }

        @NativeType(value="__u16")
        public short buf_group() {
            return IOURingSQE.nbuf_group(this.address());
        }

        @NativeType(value="__u16")
        public short personality() {
            return IOURingSQE.npersonality(this.address());
        }

        @NativeType(value="__s32")
        public int splice_fd_in() {
            return IOURingSQE.nsplice_fd_in(this.address());
        }

        @NativeType(value="__u32")
        public int file_index() {
            return IOURingSQE.nfile_index(this.address());
        }

        @NativeType(value="__u16")
        public short addr_len() {
            return IOURingSQE.naddr_len(this.address());
        }

        @NativeType(value="__u16[1]")
        public ShortBuffer __pad3() {
            return IOURingSQE.n__pad3(this.address());
        }

        @NativeType(value="__u16")
        public short __pad3(int param1) {
            return IOURingSQE.n__pad3(this.address(), param1);
        }

        @NativeType(value="__u64")
        public long addr3() {
            return IOURingSQE.naddr3(this.address());
        }

        @NativeType(value="__u64[1]")
        public LongBuffer __pad2() {
            return IOURingSQE.n__pad2(this.address());
        }

        @NativeType(value="__u64")
        public long __pad2(int param1) {
            return IOURingSQE.n__pad2(this.address(), param1);
        }

        @NativeType(value="__u8[0]")
        public ByteBuffer cmd() {
            return IOURingSQE.ncmd(this.address());
        }

        @NativeType(value="__u8")
        public byte cmd(int param1) {
            return IOURingSQE.ncmd(this.address(), param1);
        }

        public Buffer opcode(@NativeType(value="__u8") byte param1) {
            IOURingSQE.nopcode(this.address(), param1);
            return this;
        }

        public Buffer flags(@NativeType(value="__u8") byte param1) {
            IOURingSQE.nflags(this.address(), param1);
            return this;
        }

        public Buffer ioprio(@NativeType(value="__u16") short param1) {
            IOURingSQE.nioprio(this.address(), param1);
            return this;
        }

        public Buffer fd(@NativeType(value="__s32") int param1) {
            IOURingSQE.nfd(this.address(), param1);
            return this;
        }

        public Buffer off(@NativeType(value="__u64") long param1) {
            IOURingSQE.noff(this.address(), param1);
            return this;
        }

        public Buffer addr2(@NativeType(value="__u64") long param1) {
            IOURingSQE.naddr2(this.address(), param1);
            return this;
        }

        public Buffer cmd_op(@NativeType(value="__u32") int param1) {
            IOURingSQE.ncmd_op(this.address(), param1);
            return this;
        }

        public Buffer __pad1(@NativeType(value="__u32") int param1) {
            IOURingSQE.n__pad1(this.address(), param1);
            return this;
        }

        public Buffer addr(@NativeType(value="__u64") long param1) {
            IOURingSQE.naddr(this.address(), param1);
            return this;
        }

        public Buffer splice_off_in(@NativeType(value="__u64") long param1) {
            IOURingSQE.nsplice_off_in(this.address(), param1);
            return this;
        }

        public Buffer len(@NativeType(value="__u32") int param1) {
            IOURingSQE.nlen(this.address(), param1);
            return this;
        }

        public Buffer rw_flags(@NativeType(value="__kernel_rwf_t") int param1) {
            IOURingSQE.nrw_flags(this.address(), param1);
            return this;
        }

        public Buffer fsync_flags(@NativeType(value="__u32") int param1) {
            IOURingSQE.nfsync_flags(this.address(), param1);
            return this;
        }

        public Buffer poll_events(@NativeType(value="__u16") short param1) {
            IOURingSQE.npoll_events(this.address(), param1);
            return this;
        }

        public Buffer poll32_events(@NativeType(value="__u32") int param1) {
            IOURingSQE.npoll32_events(this.address(), param1);
            return this;
        }

        public Buffer sync_range_flags(@NativeType(value="__u32") int param1) {
            IOURingSQE.nsync_range_flags(this.address(), param1);
            return this;
        }

        public Buffer msg_flags(@NativeType(value="__u32") int param1) {
            IOURingSQE.nmsg_flags(this.address(), param1);
            return this;
        }

        public Buffer timeout_flags(@NativeType(value="__u32") int param1) {
            IOURingSQE.ntimeout_flags(this.address(), param1);
            return this;
        }

        public Buffer accept_flags(@NativeType(value="__u32") int param1) {
            IOURingSQE.naccept_flags(this.address(), param1);
            return this;
        }

        public Buffer cancel_flags(@NativeType(value="__u32") int param1) {
            IOURingSQE.ncancel_flags(this.address(), param1);
            return this;
        }

        public Buffer open_flags(@NativeType(value="__u32") int param1) {
            IOURingSQE.nopen_flags(this.address(), param1);
            return this;
        }

        public Buffer statx_flags(@NativeType(value="__u32") int param1) {
            IOURingSQE.nstatx_flags(this.address(), param1);
            return this;
        }

        public Buffer fadvise_advice(@NativeType(value="__u32") int param1) {
            IOURingSQE.nfadvise_advice(this.address(), param1);
            return this;
        }

        public Buffer splice_flags(@NativeType(value="__u32") int param1) {
            IOURingSQE.nsplice_flags(this.address(), param1);
            return this;
        }

        public Buffer rename_flags(@NativeType(value="__u32") int param1) {
            IOURingSQE.nrename_flags(this.address(), param1);
            return this;
        }

        public Buffer unlink_flags(@NativeType(value="__u32") int param1) {
            IOURingSQE.nunlink_flags(this.address(), param1);
            return this;
        }

        public Buffer hardlink_flags(@NativeType(value="__u32") int param1) {
            IOURingSQE.nhardlink_flags(this.address(), param1);
            return this;
        }

        public Buffer xattr_flags(@NativeType(value="__u32") int param1) {
            IOURingSQE.nxattr_flags(this.address(), param1);
            return this;
        }

        public Buffer msg_ring_flags(@NativeType(value="__u32") int param1) {
            IOURingSQE.nmsg_ring_flags(this.address(), param1);
            return this;
        }

        public Buffer uring_cmd_flags(@NativeType(value="__u32") int param1) {
            IOURingSQE.nuring_cmd_flags(this.address(), param1);
            return this;
        }

        public Buffer user_data(@NativeType(value="__u64") long param1) {
            IOURingSQE.nuser_data(this.address(), param1);
            return this;
        }

        public Buffer buf_index(@NativeType(value="__u16") short param1) {
            IOURingSQE.nbuf_index(this.address(), param1);
            return this;
        }

        public Buffer buf_group(@NativeType(value="__u16") short param1) {
            IOURingSQE.nbuf_group(this.address(), param1);
            return this;
        }

        public Buffer personality(@NativeType(value="__u16") short param1) {
            IOURingSQE.npersonality(this.address(), param1);
            return this;
        }

        public Buffer splice_fd_in(@NativeType(value="__s32") int param1) {
            IOURingSQE.nsplice_fd_in(this.address(), param1);
            return this;
        }

        public Buffer file_index(@NativeType(value="__u32") int param1) {
            IOURingSQE.nfile_index(this.address(), param1);
            return this;
        }

        public Buffer addr_len(@NativeType(value="__u16") short param1) {
            IOURingSQE.naddr_len(this.address(), param1);
            return this;
        }

        public Buffer __pad3(@NativeType(value="__u16[1]") ShortBuffer param1) {
            IOURingSQE.n__pad3(this.address(), param1);
            return this;
        }

        public Buffer __pad3(int param1, @NativeType(value="__u16") short param2) {
            IOURingSQE.n__pad3(this.address(), param1, param2);
            return this;
        }

        public Buffer addr3(@NativeType(value="__u64") long param1) {
            IOURingSQE.naddr3(this.address(), param1);
            return this;
        }

        public Buffer __pad2(@NativeType(value="__u64[1]") LongBuffer param1) {
            IOURingSQE.n__pad2(this.address(), param1);
            return this;
        }

        public Buffer __pad2(int param1, @NativeType(value="__u64") long param2) {
            IOURingSQE.n__pad2(this.address(), param1, param2);
            return this;
        }

        public Buffer cmd(@NativeType(value="__u8[0]") ByteBuffer param1) {
            IOURingSQE.ncmd(this.address(), param1);
            return this;
        }

        public Buffer cmd(int param1, @NativeType(value="__u8") byte param2) {
            IOURingSQE.ncmd(this.address(), param1, param2);
            return this;
        }
    }
}

