/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.linux.liburing;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import javax.annotation.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.linux.CMsghdr;
import org.lwjgl.system.linux.EpollEvent;
import org.lwjgl.system.linux.IOVec;
import org.lwjgl.system.linux.KernelTimespec;
import org.lwjgl.system.linux.Msghdr;
import org.lwjgl.system.linux.OpenHow;
import org.lwjgl.system.linux.Sockaddr;
import org.lwjgl.system.linux.Statx;
import org.lwjgl.system.linux.liburing.IOURing;
import org.lwjgl.system.linux.liburing.IOURingBuf;
import org.lwjgl.system.linux.liburing.IOURingBufReg;
import org.lwjgl.system.linux.liburing.IOURingBufRing;
import org.lwjgl.system.linux.liburing.IOURingCQE;
import org.lwjgl.system.linux.liburing.IOURingParams;
import org.lwjgl.system.linux.liburing.IOURingProbe;
import org.lwjgl.system.linux.liburing.IOURingRecvmsgOut;
import org.lwjgl.system.linux.liburing.IOURingRestriction;
import org.lwjgl.system.linux.liburing.IOURingSQE;
import org.lwjgl.system.linux.liburing.IOURingSyncCancelReg;

public class LibURing {
    public static final long LIBURING_UDATA_TIMEOUT = -1L;

    protected LibURing() {
        throw new UnsupportedOperationException();
    }

    public static native long nio_uring_get_probe_ring(long var0);

    @Nullable
    @NativeType(value="struct io_uring_probe *")
    public static IOURingProbe io_uring_get_probe_ring(@NativeType(value="struct io_uring *") IOURing param0) {
        long v1 = LibURing.nio_uring_get_probe_ring(param0.address());
        return IOURingProbe.createSafe(v1);
    }

    public static native long nio_uring_get_probe();

    @Nullable
    @NativeType(value="struct io_uring_probe *")
    public static IOURingProbe io_uring_get_probe() {
        long v0 = LibURing.nio_uring_get_probe();
        return IOURingProbe.createSafe(v0);
    }

    public static native void nio_uring_free_probe(long var0);

    public static void io_uring_free_probe(@NativeType(value="struct io_uring_probe *") IOURingProbe param0) {
        LibURing.nio_uring_free_probe(param0.address());
    }

    public static native int nio_uring_opcode_supported(long var0, int var2);

    public static int io_uring_opcode_supported(@NativeType(value="struct io_uring_probe const *") IOURingProbe param0, int param1) {
        return LibURing.nio_uring_opcode_supported(param0.address(), param1);
    }

    public static native int nio_uring_queue_init_params(int var0, long var1, long var3);

    public static int io_uring_queue_init_params(@NativeType(value="unsigned") int param0, @NativeType(value="struct io_uring *") IOURing param1, @NativeType(value="struct io_uring_params *") IOURingParams param2) {
        return LibURing.nio_uring_queue_init_params(param0, param1.address(), param2.address());
    }

    public static native int nio_uring_queue_init(int var0, long var1, int var3);

    public static int io_uring_queue_init(@NativeType(value="unsigned") int param0, @NativeType(value="struct io_uring *") IOURing param1, @NativeType(value="unsigned") int param2) {
        return LibURing.nio_uring_queue_init(param0, param1.address(), param2);
    }

    public static native int nio_uring_queue_mmap(int var0, long var1, long var3);

    public static int io_uring_queue_mmap(int param0, @NativeType(value="struct io_uring_params *") IOURingParams param1, @NativeType(value="struct io_uring *") IOURing param2) {
        return LibURing.nio_uring_queue_mmap(param0, param1.address(), param2.address());
    }

    public static native int nio_uring_ring_dontfork(long var0);

    public static int io_uring_ring_dontfork(@NativeType(value="struct io_uring *") IOURing param0) {
        return LibURing.nio_uring_ring_dontfork(param0.address());
    }

    public static native void nio_uring_queue_exit(long var0);

    public static void io_uring_queue_exit(@NativeType(value="struct io_uring *") IOURing param0) {
        LibURing.nio_uring_queue_exit(param0.address());
    }

    public static native int nio_uring_peek_batch_cqe(long var0, long var2, int var4);

    @NativeType(value="unsigned")
    public static int io_uring_peek_batch_cqe(@NativeType(value="struct io_uring *") IOURing param0, @NativeType(value="struct io_uring_cqe **") PointerBuffer param1) {
        return LibURing.nio_uring_peek_batch_cqe(param0.address(), MemoryUtil.memAddress(param1), param1.remaining());
    }

    public static native int nio_uring_wait_cqes(long var0, long var2, int var4, long var5, long var7);

    public static int io_uring_wait_cqes(@NativeType(value="struct io_uring *") IOURing param0, @NativeType(value="struct io_uring_cqe **") PointerBuffer param1, @Nullable @NativeType(value="struct __kernel_timespec *") KernelTimespec param2, @NativeType(value="sigset_t *") long param3) {
        return LibURing.nio_uring_wait_cqes(param0.address(), MemoryUtil.memAddress(param1), param1.remaining(), MemoryUtil.memAddressSafe(param2), param3);
    }

    public static native int nio_uring_wait_cqe_timeout(long var0, long var2, long var4);

    public static int io_uring_wait_cqe_timeout(@NativeType(value="struct io_uring *") IOURing param0, @NativeType(value="struct io_uring_cqe **") PointerBuffer param1, @Nullable @NativeType(value="struct __kernel_timespec *") KernelTimespec param2) {
        if (Checks.CHECKS) {
            Checks.check(param1, 1);
        }
        return LibURing.nio_uring_wait_cqe_timeout(param0.address(), MemoryUtil.memAddress(param1), MemoryUtil.memAddressSafe(param2));
    }

    public static native int nio_uring_submit(long var0);

    public static int io_uring_submit(@NativeType(value="struct io_uring *") IOURing param0) {
        return LibURing.nio_uring_submit(param0.address());
    }

    public static native int nio_uring_submit_and_wait(long var0, int var2);

    public static int io_uring_submit_and_wait(@NativeType(value="struct io_uring *") IOURing param0, @NativeType(value="unsigned") int param1) {
        return LibURing.nio_uring_submit_and_wait(param0.address(), param1);
    }

    public static native int nio_uring_submit_and_wait_timeout(long var0, long var2, int var4, long var5, long var7);

    public static int io_uring_submit_and_wait_timeout(@NativeType(value="struct io_uring *") IOURing param0, @NativeType(value="struct io_uring_cqe **") PointerBuffer param1, @Nullable @NativeType(value="struct __kernel_timespec *") KernelTimespec param2, @NativeType(value="sigset_t *") long param3) {
        return LibURing.nio_uring_submit_and_wait_timeout(param0.address(), MemoryUtil.memAddress(param1), param1.remaining(), MemoryUtil.memAddressSafe(param2), param3);
    }

    public static native int nio_uring_register_buffers(long var0, long var2, int var4);

    public static int io_uring_register_buffers(@NativeType(value="struct io_uring *") IOURing param0, @NativeType(value="struct iovec const *") IOVec.Buffer param1) {
        return LibURing.nio_uring_register_buffers(param0.address(), param1.address(), param1.remaining());
    }

    public static native int nio_uring_register_buffers_tags(long var0, long var2, long var4, int var6);

    public static int io_uring_register_buffers_tags(@NativeType(value="struct io_uring *") IOURing param0, @NativeType(value="struct iovec const *") IOVec.Buffer param1, @NativeType(value="__u64 const *") LongBuffer param2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param2, param1.remaining());
        }
        return LibURing.nio_uring_register_buffers_tags(param0.address(), param1.address(), MemoryUtil.memAddress(param2), param1.remaining());
    }

    public static native int nio_uring_register_buffers_sparse(long var0, int var2);

    public static int io_uring_register_buffers_sparse(@NativeType(value="struct io_uring *") IOURing param0, @NativeType(value="unsigned") int param1) {
        return LibURing.nio_uring_register_buffers_sparse(param0.address(), param1);
    }

    public static native int nio_uring_register_buffers_update_tag(long var0, int var2, long var3, long var5, int var7);

    public static int io_uring_register_buffers_update_tag(@NativeType(value="struct io_uring *") IOURing param0, @NativeType(value="unsigned") int param1, @NativeType(value="struct iovec const *") IOVec.Buffer param2, @NativeType(value="__u64 const *") LongBuffer param3) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param3, param2.remaining());
        }
        return LibURing.nio_uring_register_buffers_update_tag(param0.address(), param1, param2.address(), MemoryUtil.memAddress(param3), param2.remaining());
    }

    public static native int nio_uring_unregister_buffers(long var0);

    public static int io_uring_unregister_buffers(@NativeType(value="struct io_uring *") IOURing param0) {
        return LibURing.nio_uring_unregister_buffers(param0.address());
    }

    public static native int nio_uring_register_files(long var0, long var2, int var4);

    public static int io_uring_register_files(@NativeType(value="struct io_uring *") IOURing param0, @NativeType(value="int const *") IntBuffer param1) {
        return LibURing.nio_uring_register_files(param0.address(), MemoryUtil.memAddress(param1), param1.remaining());
    }

    public static native int nio_uring_register_files_tags(long var0, long var2, long var4, int var6);

    public static int io_uring_register_files_tags(@NativeType(value="struct io_uring *") IOURing param0, @NativeType(value="int const *") IntBuffer param1, @NativeType(value="__u64 const *") LongBuffer param2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param2, param1.remaining());
        }
        return LibURing.nio_uring_register_files_tags(param0.address(), MemoryUtil.memAddress(param1), MemoryUtil.memAddress(param2), param1.remaining());
    }

    public static native int nio_uring_register_files_sparse(long var0, int var2);

    public static int io_uring_register_files_sparse(@NativeType(value="struct io_uring *") IOURing param0, @NativeType(value="unsigned") int param1) {
        return LibURing.nio_uring_register_files_sparse(param0.address(), param1);
    }

    public static native int nio_uring_register_files_update_tag(long var0, int var2, long var3, long var5, int var7);

    public static int io_uring_register_files_update_tag(@NativeType(value="struct io_uring *") IOURing param0, @NativeType(value="unsigned") int param1, @NativeType(value="int const *") IntBuffer param2, @NativeType(value="__u64 const *") LongBuffer param3) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param3, param2.remaining());
        }
        return LibURing.nio_uring_register_files_update_tag(param0.address(), param1, MemoryUtil.memAddress(param2), MemoryUtil.memAddress(param3), param2.remaining());
    }

    public static native int nio_uring_unregister_files(long var0);

    public static int io_uring_unregister_files(@NativeType(value="struct io_uring *") IOURing param0) {
        return LibURing.nio_uring_unregister_files(param0.address());
    }

    public static native int nio_uring_register_files_update(long var0, int var2, long var3, int var5);

    public static int io_uring_register_files_update(@NativeType(value="struct io_uring *") IOURing param0, @NativeType(value="unsigned") int param1, @NativeType(value="int const *") IntBuffer param2) {
        return LibURing.nio_uring_register_files_update(param0.address(), param1, MemoryUtil.memAddress(param2), param2.remaining());
    }

    public static native int nio_uring_register_eventfd(long var0, int var2);

    public static int io_uring_register_eventfd(@NativeType(value="struct io_uring *") IOURing param0, int param1) {
        return LibURing.nio_uring_register_eventfd(param0.address(), param1);
    }

    public static native int nio_uring_register_eventfd_async(long var0, int var2);

    public static int io_uring_register_eventfd_async(@NativeType(value="struct io_uring *") IOURing param0, int param1) {
        return LibURing.nio_uring_register_eventfd_async(param0.address(), param1);
    }

    public static native int nio_uring_unregister_eventfd(long var0);

    public static int io_uring_unregister_eventfd(@NativeType(value="struct io_uring *") IOURing param0) {
        return LibURing.nio_uring_unregister_eventfd(param0.address());
    }

    public static native int nio_uring_register_probe(long var0, long var2, int var4);

    public static int io_uring_register_probe(@NativeType(value="struct io_uring *") IOURing param0, @NativeType(value="struct io_uring_probe *") IOURingProbe param1, @NativeType(value="unsigned") int param2) {
        return LibURing.nio_uring_register_probe(param0.address(), param1.address(), param2);
    }

    public static native int nio_uring_register_personality(long var0);

    public static int io_uring_register_personality(@NativeType(value="struct io_uring *") IOURing param0) {
        return LibURing.nio_uring_register_personality(param0.address());
    }

    public static native int nio_uring_unregister_personality(long var0, int var2);

    public static int io_uring_unregister_personality(@NativeType(value="struct io_uring *") IOURing param0, int param1) {
        return LibURing.nio_uring_unregister_personality(param0.address(), param1);
    }

    public static native int nio_uring_register_restrictions(long var0, long var2, int var4);

    public static int io_uring_register_restrictions(@NativeType(value="struct io_uring *") IOURing param0, @NativeType(value="struct io_uring_restriction *") IOURingRestriction.Buffer param1) {
        return LibURing.nio_uring_register_restrictions(param0.address(), param1.address(), param1.remaining());
    }

    public static native int nio_uring_enable_rings(long var0);

    public static int io_uring_enable_rings(@NativeType(value="struct io_uring *") IOURing param0) {
        return LibURing.nio_uring_enable_rings(param0.address());
    }

    public static native int n__io_uring_sqring_wait(long var0);

    public static int __io_uring_sqring_wait(@NativeType(value="struct io_uring *") IOURing param0) {
        return LibURing.n__io_uring_sqring_wait(param0.address());
    }

    public static native int nio_uring_register_iowq_aff(long var0, long var2, long var4);

    public static int io_uring_register_iowq_aff(@NativeType(value="struct io_uring *") IOURing param0, @NativeType(value="size_t") long param1, @NativeType(value="cpu_set_t const *") long param3) {
        if (Checks.CHECKS) {
            Checks.check(param3);
        }
        return LibURing.nio_uring_register_iowq_aff(param0.address(), param1, param3);
    }

    public static native int nio_uring_unregister_iowq_aff(long var0);

    public static int io_uring_unregister_iowq_aff(@NativeType(value="struct io_uring *") IOURing param0) {
        return LibURing.nio_uring_unregister_iowq_aff(param0.address());
    }

    public static native int nio_uring_register_iowq_max_workers(long var0, long var2);

    public static int io_uring_register_iowq_max_workers(@NativeType(value="struct io_uring *") IOURing param0, @NativeType(value="unsigned int *") IntBuffer param1) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param1, 2);
        }
        return LibURing.nio_uring_register_iowq_max_workers(param0.address(), MemoryUtil.memAddress(param1));
    }

    public static native int nio_uring_register_ring_fd(long var0);

    public static int io_uring_register_ring_fd(@NativeType(value="struct io_uring *") IOURing param0) {
        return LibURing.nio_uring_register_ring_fd(param0.address());
    }

    public static native int nio_uring_unregister_ring_fd(long var0);

    public static int io_uring_unregister_ring_fd(@NativeType(value="struct io_uring *") IOURing param0) {
        return LibURing.nio_uring_unregister_ring_fd(param0.address());
    }

    public static native int nio_uring_close_ring_fd(long var0);

    public static int io_uring_close_ring_fd(@NativeType(value="struct io_uring *") IOURing param0) {
        return LibURing.nio_uring_close_ring_fd(param0.address());
    }

    public static native int nio_uring_register_buf_ring(long var0, long var2, int var4);

    public static int io_uring_register_buf_ring(@NativeType(value="struct io_uring *") IOURing param0, @NativeType(value="struct io_uring_buf_reg *") IOURingBufReg param1, @NativeType(value="unsigned int") int param2) {
        return LibURing.nio_uring_register_buf_ring(param0.address(), param1.address(), param2);
    }

    public static native int nio_uring_unregister_buf_ring(long var0, int var2);

    public static int io_uring_unregister_buf_ring(@NativeType(value="struct io_uring *") IOURing param0, int param1) {
        return LibURing.nio_uring_unregister_buf_ring(param0.address(), param1);
    }

    public static native int nio_uring_register_sync_cancel(long var0, long var2);

    public static int io_uring_register_sync_cancel(@NativeType(value="struct io_uring *") IOURing param0, @NativeType(value="struct io_uring_sync_cancel_reg *") IOURingSyncCancelReg param1) {
        return LibURing.nio_uring_register_sync_cancel(param0.address(), param1.address());
    }

    public static native int nio_uring_register_file_alloc_range(long var0, int var2, int var3);

    public static int io_uring_register_file_alloc_range(@NativeType(value="struct io_uring *") IOURing param0, @NativeType(value="unsigned") int param1, @NativeType(value="unsigned") int param2) {
        return LibURing.nio_uring_register_file_alloc_range(param0.address(), param1, param2);
    }

    public static native int nio_uring_get_events(long var0);

    public static int io_uring_get_events(@NativeType(value="struct io_uring *") IOURing param0) {
        return LibURing.nio_uring_get_events(param0.address());
    }

    public static native int nio_uring_submit_and_get_events(long var0);

    public static int io_uring_submit_and_get_events(@NativeType(value="struct io_uring *") IOURing param0) {
        return LibURing.nio_uring_submit_and_get_events(param0.address());
    }

    public static native int nio_uring_enter(int var0, int var1, int var2, int var3, long var4);

    public static int io_uring_enter(@NativeType(value="unsigned int") int param0, @NativeType(value="unsigned int") int param1, @NativeType(value="unsigned int") int param2, @NativeType(value="unsigned int") int param3, @NativeType(value="sigset_t *") long param4) {
        if (Checks.CHECKS) {
            Checks.check(param4);
        }
        return LibURing.nio_uring_enter(param0, param1, param2, param3, param4);
    }

    public static native int nio_uring_enter2(int var0, int var1, int var2, int var3, long var4, long var6);

    public static int io_uring_enter2(@NativeType(value="unsigned int") int param0, @NativeType(value="unsigned int") int param1, @NativeType(value="unsigned int") int param2, @NativeType(value="unsigned int") int param3, @NativeType(value="sigset_t *") long param4, @NativeType(value="size_t") long param6) {
        if (Checks.CHECKS) {
            Checks.check(param4);
        }
        return LibURing.nio_uring_enter2(param0, param1, param2, param3, param4, param6);
    }

    public static native int nio_uring_setup(int var0, long var1);

    public static int io_uring_setup(@NativeType(value="unsigned int") int param0, @NativeType(value="struct io_uring_params *") IOURingParams param1) {
        return LibURing.nio_uring_setup(param0, param1.address());
    }

    public static native int io_uring_register(@NativeType(value="unsigned int") int var0, @NativeType(value="unsigned int") int var1, @NativeType(value="void *") long var2, @NativeType(value="unsigned int") int var4);

    public static native long nio_uring_setup_buf_ring(long var0, int var2, int var3, int var4, long var5);

    @Nullable
    @NativeType(value="struct io_uring_buf_ring *")
    public static IOURingBufRing io_uring_setup_buf_ring(@NativeType(value="struct io_uring *") IOURing param0, @NativeType(value="unsigned int") int param1, int param2, @NativeType(value="unsigned int") int param3, @NativeType(value="int *") IntBuffer param4) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param4, 1);
        }
        long v5 = LibURing.nio_uring_setup_buf_ring(param0.address(), param1, param2, param3, MemoryUtil.memAddress(param4));
        return IOURingBufRing.createSafe(v5);
    }

    public static native int nio_uring_free_buf_ring(long var0, long var2, int var4, int var5);

    public static int io_uring_free_buf_ring(@NativeType(value="struct io_uring *") IOURing param0, @NativeType(value="struct io_uring_buf_ring *") IOURingBufRing param1, @NativeType(value="unsigned int") int param2, int param3) {
        return LibURing.nio_uring_free_buf_ring(param0.address(), param1.address(), param2, param3);
    }

    public static native void nio_uring_cqe_seen(long var0, long var2);

    public static void io_uring_cqe_seen(@NativeType(value="struct io_uring *") IOURing param0, @NativeType(value="struct io_uring_cqe *") IOURingCQE param1) {
        LibURing.nio_uring_cqe_seen(param0.address(), param1.address());
    }

    public static native void nio_uring_sqe_set_data(long var0, long var2);

    public static void io_uring_sqe_set_data(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="void *") long param1) {
        if (Checks.CHECKS) {
            Checks.check(param1);
        }
        LibURing.nio_uring_sqe_set_data(param0.address(), param1);
    }

    public static native long nio_uring_cqe_get_data(long var0);

    @NativeType(value="void *")
    public static long io_uring_cqe_get_data(@NativeType(value="struct io_uring_cqe const *") IOURingCQE param0) {
        return LibURing.nio_uring_cqe_get_data(param0.address());
    }

    public static native void nio_uring_sqe_set_data64(long var0, long var2);

    public static void io_uring_sqe_set_data64(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="__u64") long param1) {
        LibURing.nio_uring_sqe_set_data64(param0.address(), param1);
    }

    public static native long nio_uring_cqe_get_data64(long var0);

    @NativeType(value="__u64")
    public static long io_uring_cqe_get_data64(@NativeType(value="struct io_uring_cqe const *") IOURingCQE param0) {
        return LibURing.nio_uring_cqe_get_data64(param0.address());
    }

    public static native void nio_uring_sqe_set_flags(long var0, int var2);

    public static void io_uring_sqe_set_flags(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="unsigned int") int param1) {
        LibURing.nio_uring_sqe_set_flags(param0.address(), param1);
    }

    public static native void nio_uring_prep_splice(long var0, int var2, long var3, int var5, long var6, int var8, int var9);

    public static void io_uring_prep_splice(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="int64_t") long param2, int param4, @NativeType(value="int64_t") long param5, @NativeType(value="unsigned int") int param7, @NativeType(value="unsigned int") int param8) {
        LibURing.nio_uring_prep_splice(param0.address(), param1, param2, param4, param5, param7, param8);
    }

    public static native void nio_uring_prep_tee(long var0, int var2, int var3, int var4, int var5);

    public static void io_uring_prep_tee(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, int param2, @NativeType(value="unsigned int") int param3, @NativeType(value="unsigned int") int param4) {
        LibURing.nio_uring_prep_tee(param0.address(), param1, param2, param3, param4);
    }

    public static native void nio_uring_prep_readv(long var0, int var2, long var3, int var5, int var6);

    public static void io_uring_prep_readv(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="struct iovec const *") IOVec.Buffer param2, int param3) {
        LibURing.nio_uring_prep_readv(param0.address(), param1, param2.address(), param2.remaining(), param3);
    }

    public static native void nio_uring_prep_readv2(long var0, int var2, long var3, int var5, int var6, int var7);

    public static void io_uring_prep_readv2(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="struct iovec const *") IOVec.Buffer param2, int param3, int param4) {
        LibURing.nio_uring_prep_readv2(param0.address(), param1, param2.address(), param2.remaining(), param3, param4);
    }

    public static native void nio_uring_prep_read_fixed(long var0, int var2, long var3, int var5, int var6, int var7);

    public static void io_uring_prep_read_fixed(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="void *") ByteBuffer param2, int param3, int param4) {
        LibURing.nio_uring_prep_read_fixed(param0.address(), param1, MemoryUtil.memAddress(param2), param2.remaining(), param3, param4);
    }

    public static native void nio_uring_prep_writev(long var0, int var2, long var3, int var5, int var6);

    public static void io_uring_prep_writev(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="struct iovec const *") IOVec.Buffer param2, int param3) {
        LibURing.nio_uring_prep_writev(param0.address(), param1, param2.address(), param2.remaining(), param3);
    }

    public static native void nio_uring_prep_writev2(long var0, int var2, long var3, int var5, int var6, int var7);

    public static void io_uring_prep_writev2(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="struct iovec const *") IOVec.Buffer param2, int param3, int param4) {
        LibURing.nio_uring_prep_writev2(param0.address(), param1, param2.address(), param2.remaining(), param3, param4);
    }

    public static native void nio_uring_prep_write_fixed(long var0, int var2, long var3, int var5, int var6, int var7);

    public static void io_uring_prep_write_fixed(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="void const *") ByteBuffer param2, int param3, int param4) {
        LibURing.nio_uring_prep_write_fixed(param0.address(), param1, MemoryUtil.memAddress(param2), param2.remaining(), param3, param4);
    }

    public static native void nio_uring_prep_recvmsg(long var0, int var2, long var3, int var5);

    public static void io_uring_prep_recvmsg(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="struct msghdr *") Msghdr param2, @NativeType(value="unsigned int") int param3) {
        LibURing.nio_uring_prep_recvmsg(param0.address(), param1, param2.address(), param3);
    }

    public static native void nio_uring_prep_recvmsg_multishot(long var0, int var2, long var3, int var5);

    public static void io_uring_prep_recvmsg_multishot(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="struct msghdr *") Msghdr param2, @NativeType(value="unsigned") int param3) {
        LibURing.nio_uring_prep_recvmsg_multishot(param0.address(), param1, param2.address(), param3);
    }

    public static native void nio_uring_prep_sendmsg(long var0, int var2, long var3, int var5);

    public static void io_uring_prep_sendmsg(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="struct msghdr const *") Msghdr param2, @NativeType(value="unsigned int") int param3) {
        if (Checks.CHECKS) {
            Msghdr.validate(param2.address());
        }
        LibURing.nio_uring_prep_sendmsg(param0.address(), param1, param2.address(), param3);
    }

    public static native void nio_uring_prep_poll_add(long var0, int var2, int var3);

    public static void io_uring_prep_poll_add(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="unsigned int") int param2) {
        LibURing.nio_uring_prep_poll_add(param0.address(), param1, param2);
    }

    public static native void nio_uring_prep_poll_multishot(long var0, int var2, int var3);

    public static void io_uring_prep_poll_multishot(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="unsigned int") int param2) {
        LibURing.nio_uring_prep_poll_multishot(param0.address(), param1, param2);
    }

    public static native void nio_uring_prep_poll_remove(long var0, long var2);

    public static void io_uring_prep_poll_remove(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="__u64") long param1) {
        LibURing.nio_uring_prep_poll_remove(param0.address(), param1);
    }

    public static native void nio_uring_prep_poll_update(long var0, long var2, long var4, int var6, int var7);

    public static void io_uring_prep_poll_update(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="__u64") long param1, @NativeType(value="__u64") long param3, @NativeType(value="unsigned int") int param5, @NativeType(value="unsigned int") int param6) {
        LibURing.nio_uring_prep_poll_update(param0.address(), param1, param3, param5, param6);
    }

    public static native void nio_uring_prep_fsync(long var0, int var2, int var3);

    public static void io_uring_prep_fsync(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="unsigned int") int param2) {
        LibURing.nio_uring_prep_fsync(param0.address(), param1, param2);
    }

    public static native void nio_uring_prep_nop(long var0);

    public static void io_uring_prep_nop(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0) {
        LibURing.nio_uring_prep_nop(param0.address());
    }

    public static native void nio_uring_prep_timeout(long var0, long var2, int var4, int var5);

    public static void io_uring_prep_timeout(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="struct __kernel_timespec *") KernelTimespec param1, @NativeType(value="unsigned int") int param2, @NativeType(value="unsigned int") int param3) {
        LibURing.nio_uring_prep_timeout(param0.address(), param1.address(), param2, param3);
    }

    public static native void nio_uring_prep_timeout_remove(long var0, long var2, int var4);

    public static void io_uring_prep_timeout_remove(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="__u64") long param1, @NativeType(value="unsigned int") int param3) {
        LibURing.nio_uring_prep_timeout_remove(param0.address(), param1, param3);
    }

    public static native void nio_uring_prep_timeout_update(long var0, long var2, long var4, int var6);

    public static void io_uring_prep_timeout_update(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="struct __kernel_timespec *") KernelTimespec param1, @NativeType(value="__u64") long param2, @NativeType(value="unsigned int") int param4) {
        LibURing.nio_uring_prep_timeout_update(param0.address(), param1.address(), param2, param4);
    }

    public static native void nio_uring_prep_accept(long var0, int var2, long var3, long var5, int var7);

    public static void io_uring_prep_accept(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="struct sockaddr *") Sockaddr param2, @NativeType(value="socklen_t *") IntBuffer param3, int param4) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param3, 1);
        }
        LibURing.nio_uring_prep_accept(param0.address(), param1, param2.address(), MemoryUtil.memAddress(param3), param4);
    }

    public static native void nio_uring_prep_accept_direct(long var0, int var2, long var3, long var5, int var7, int var8);

    public static void io_uring_prep_accept_direct(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="struct sockaddr *") Sockaddr param2, @NativeType(value="socklen_t *") IntBuffer param3, int param4, @NativeType(value="unsigned int") int param5) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param3, 1);
        }
        LibURing.nio_uring_prep_accept_direct(param0.address(), param1, param2.address(), MemoryUtil.memAddress(param3), param4, param5);
    }

    public static native void nio_uring_prep_multishot_accept(long var0, int var2, long var3, long var5, int var7);

    public static void io_uring_prep_multishot_accept(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="struct sockaddr *") Sockaddr param2, @NativeType(value="socklen_t *") IntBuffer param3, int param4) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param3, 1);
        }
        LibURing.nio_uring_prep_multishot_accept(param0.address(), param1, param2.address(), MemoryUtil.memAddress(param3), param4);
    }

    public static native void nio_uring_prep_multishot_accept_direct(long var0, int var2, long var3, long var5, int var7);

    public static void io_uring_prep_multishot_accept_direct(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="struct sockaddr *") Sockaddr param2, @NativeType(value="socklen_t *") IntBuffer param3, int param4) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param3, 1);
        }
        LibURing.nio_uring_prep_multishot_accept_direct(param0.address(), param1, param2.address(), MemoryUtil.memAddress(param3), param4);
    }

    public static native void nio_uring_prep_cancel64(long var0, long var2, int var4);

    public static void io_uring_prep_cancel64(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="__u64") long param1, int param3) {
        LibURing.nio_uring_prep_cancel64(param0.address(), param1, param3);
    }

    public static native void nio_uring_prep_cancel(long var0, long var2, int var4);

    public static void io_uring_prep_cancel(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="void *") long param1, int param3) {
        if (Checks.CHECKS) {
            Checks.check(param1);
        }
        LibURing.nio_uring_prep_cancel(param0.address(), param1, param3);
    }

    public static native void nio_uring_prep_cancel_fd(long var0, int var2, int var3);

    public static void io_uring_prep_cancel_fd(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="unsigned int") int param2) {
        LibURing.nio_uring_prep_cancel_fd(param0.address(), param1, param2);
    }

    public static native void nio_uring_prep_link_timeout(long var0, long var2, int var4);

    public static void io_uring_prep_link_timeout(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="struct __kernel_timespec *") KernelTimespec param1, @NativeType(value="unsigned int") int param2) {
        LibURing.nio_uring_prep_link_timeout(param0.address(), param1.address(), param2);
    }

    public static native void nio_uring_prep_connect(long var0, int var2, long var3, int var5);

    public static void io_uring_prep_connect(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="struct sockaddr const *") Sockaddr param2, @NativeType(value="socklen_t") int param3) {
        LibURing.nio_uring_prep_connect(param0.address(), param1, param2.address(), param3);
    }

    public static native void nio_uring_prep_files_update(long var0, long var2, int var4, int var5);

    public static void io_uring_prep_files_update(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="int *") IntBuffer param1, int param2) {
        LibURing.nio_uring_prep_files_update(param0.address(), MemoryUtil.memAddress(param1), param1.remaining(), param2);
    }

    public static native void nio_uring_prep_fallocate(long var0, int var2, int var3, long var4, long var6);

    public static void io_uring_prep_fallocate(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, int param2, @NativeType(value="off_t") long param3, @NativeType(value="off_t") long param5) {
        LibURing.nio_uring_prep_fallocate(param0.address(), param1, param2, param3, param5);
    }

    public static native void nio_uring_prep_openat(long var0, int var2, long var3, int var5, int var6);

    public static void io_uring_prep_openat(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="char const *") ByteBuffer param2, int param3, int param4) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param2);
        }
        LibURing.nio_uring_prep_openat(param0.address(), param1, MemoryUtil.memAddress(param2), param3, param4);
    }

    public static void io_uring_prep_openat(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="char const *") CharSequence param2, int param3, int param4) {
        MemoryStack v5 = MemoryStack.stackGet();
        int v6 = v5.getPointer();
        try {
            v5.nUTF8(param2, true);
            long v7 = v5.getPointerAddress();
            LibURing.nio_uring_prep_openat(param0.address(), param1, v7, param3, param4);
            return;
        }
        finally {
            v5.setPointer(v6);
        }
    }

    public static native void nio_uring_prep_openat_direct(long var0, int var2, long var3, int var5, int var6, int var7);

    public static void io_uring_prep_openat_direct(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="char const *") ByteBuffer param2, int param3, int param4, @NativeType(value="unsigned int") int param5) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param2);
        }
        LibURing.nio_uring_prep_openat_direct(param0.address(), param1, MemoryUtil.memAddress(param2), param3, param4, param5);
    }

    public static void io_uring_prep_openat_direct(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="char const *") CharSequence param2, int param3, int param4, @NativeType(value="unsigned int") int param5) {
        MemoryStack v6 = MemoryStack.stackGet();
        int v7 = v6.getPointer();
        try {
            v6.nUTF8(param2, true);
            long v8 = v6.getPointerAddress();
            LibURing.nio_uring_prep_openat_direct(param0.address(), param1, v8, param3, param4, param5);
            return;
        }
        finally {
            v6.setPointer(v7);
        }
    }

    public static native void nio_uring_prep_close(long var0, int var2);

    public static void io_uring_prep_close(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1) {
        LibURing.nio_uring_prep_close(param0.address(), param1);
    }

    public static native void nio_uring_prep_close_direct(long var0, int var2);

    public static void io_uring_prep_close_direct(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="unsigned int") int param1) {
        LibURing.nio_uring_prep_close_direct(param0.address(), param1);
    }

    public static native void nio_uring_prep_read(long var0, int var2, long var3, int var5, int var6);

    public static void io_uring_prep_read(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="void *") ByteBuffer param2, int param3) {
        LibURing.nio_uring_prep_read(param0.address(), param1, MemoryUtil.memAddress(param2), param2.remaining(), param3);
    }

    public static native void nio_uring_prep_write(long var0, int var2, long var3, int var5, int var6);

    public static void io_uring_prep_write(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="void const *") ByteBuffer param2, int param3) {
        LibURing.nio_uring_prep_write(param0.address(), param1, MemoryUtil.memAddress(param2), param2.remaining(), param3);
    }

    public static native void nio_uring_prep_statx(long var0, int var2, long var3, int var5, int var6, long var7);

    public static void io_uring_prep_statx(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="char const *") ByteBuffer param2, int param3, @NativeType(value="unsigned int") int param4, @NativeType(value="struct statx *") Statx param5) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param2);
        }
        LibURing.nio_uring_prep_statx(param0.address(), param1, MemoryUtil.memAddress(param2), param3, param4, param5.address());
    }

    public static void io_uring_prep_statx(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="char const *") CharSequence param2, int param3, @NativeType(value="unsigned int") int param4, @NativeType(value="struct statx *") Statx param5) {
        MemoryStack v6 = MemoryStack.stackGet();
        int v7 = v6.getPointer();
        try {
            v6.nUTF8(param2, true);
            long v8 = v6.getPointerAddress();
            LibURing.nio_uring_prep_statx(param0.address(), param1, v8, param3, param4, param5.address());
            return;
        }
        finally {
            v6.setPointer(v7);
        }
    }

    public static native void nio_uring_prep_fadvise(long var0, int var2, int var3, long var4, int var6);

    public static void io_uring_prep_fadvise(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, int param2, @NativeType(value="off_t") long param3, int param5) {
        LibURing.nio_uring_prep_fadvise(param0.address(), param1, param2, param3, param5);
    }

    public static native void nio_uring_prep_madvise(long var0, long var2, long var4, int var6);

    public static void io_uring_prep_madvise(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="void *") ByteBuffer param1, int param2) {
        LibURing.nio_uring_prep_madvise(param0.address(), MemoryUtil.memAddress(param1), param1.remaining(), param2);
    }

    public static native void nio_uring_prep_send(long var0, int var2, long var3, long var5, int var7);

    public static void io_uring_prep_send(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="void const *") ByteBuffer param2, int param3) {
        LibURing.nio_uring_prep_send(param0.address(), param1, MemoryUtil.memAddress(param2), param2.remaining(), param3);
    }

    public static native void nio_uring_prep_send_set_addr(long var0, long var2, short var4);

    public static void io_uring_prep_send_set_addr(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="struct sockaddr const *") Sockaddr param1, @NativeType(value="__u16") short param2) {
        LibURing.nio_uring_prep_send_set_addr(param0.address(), param1.address(), param2);
    }

    public static native void nio_uring_prep_sendto(long var0, int var2, long var3, long var5, int var7, long var8, int var10);

    public static void io_uring_prep_sendto(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="void const *") ByteBuffer param2, int param3, @NativeType(value="struct sockaddr const *") Sockaddr param4, @NativeType(value="socklen_t") int param5) {
        LibURing.nio_uring_prep_sendto(param0.address(), param1, MemoryUtil.memAddress(param2), param2.remaining(), param3, param4.address(), param5);
    }

    public static native void nio_uring_prep_send_zc(long var0, int var2, long var3, long var5, int var7, int var8);

    public static void io_uring_prep_send_zc(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="void const *") ByteBuffer param2, int param3, @NativeType(value="unsigned") int param4) {
        LibURing.nio_uring_prep_send_zc(param0.address(), param1, MemoryUtil.memAddress(param2), param2.remaining(), param3, param4);
    }

    public static native void nio_uring_prep_send_zc_fixed(long var0, int var2, long var3, long var5, int var7, int var8, int var9);

    public static void io_uring_prep_send_zc_fixed(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="void const *") ByteBuffer param2, int param3, @NativeType(value="unsigned") int param4, @NativeType(value="unsigned") int param5) {
        LibURing.nio_uring_prep_send_zc_fixed(param0.address(), param1, MemoryUtil.memAddress(param2), param2.remaining(), param3, param4, param5);
    }

    public static native void nio_uring_prep_sendmsg_zc(long var0, int var2, long var3, int var5);

    public static void io_uring_prep_sendmsg_zc(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="struct msghdr const *") Msghdr param2, @NativeType(value="unsigned") int param3) {
        if (Checks.CHECKS) {
            Msghdr.validate(param2.address());
        }
        LibURing.nio_uring_prep_sendmsg_zc(param0.address(), param1, param2.address(), param3);
    }

    public static native void nio_uring_prep_recv(long var0, int var2, long var3, long var5, int var7);

    public static void io_uring_prep_recv(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="void *") ByteBuffer param2, int param3) {
        LibURing.nio_uring_prep_recv(param0.address(), param1, MemoryUtil.memAddress(param2), param2.remaining(), param3);
    }

    public static native void nio_uring_prep_recv_multishot(long var0, int var2, long var3, long var5, int var7);

    public static void io_uring_prep_recv_multishot(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="void *") ByteBuffer param2, int param3) {
        LibURing.nio_uring_prep_recv_multishot(param0.address(), param1, MemoryUtil.memAddress(param2), param2.remaining(), param3);
    }

    public static native long nio_uring_recvmsg_validate(long var0, int var2, long var3);

    @Nullable
    @NativeType(value="struct io_uring_recvmsg_out *")
    public static IOURingRecvmsgOut io_uring_recvmsg_validate(@NativeType(value="void *") ByteBuffer param0, @NativeType(value="struct msghdr *") Msghdr param1) {
        long v2 = LibURing.nio_uring_recvmsg_validate(MemoryUtil.memAddress(param0), param0.remaining(), param1.address());
        return IOURingRecvmsgOut.createSafe(v2);
    }

    public static native long nio_uring_recvmsg_name(long var0);

    @NativeType(value="void *")
    public static long io_uring_recvmsg_name(@NativeType(value="struct io_uring_recvmsg_out *") IOURingRecvmsgOut param0) {
        return LibURing.nio_uring_recvmsg_name(param0.address());
    }

    public static native long nio_uring_recvmsg_cmsg_firsthdr(long var0, long var2);

    @Nullable
    @NativeType(value="struct cmsghdr *")
    public static CMsghdr io_uring_recvmsg_cmsg_firsthdr(@NativeType(value="struct io_uring_recvmsg_out *") IOURingRecvmsgOut param0, @NativeType(value="struct msghdr *") Msghdr param1) {
        long v2 = LibURing.nio_uring_recvmsg_cmsg_firsthdr(param0.address(), param1.address());
        return CMsghdr.createSafe(v2);
    }

    public static native long nio_uring_recvmsg_cmsg_nexthdr(long var0, long var2, long var4);

    @Nullable
    @NativeType(value="struct cmsghdr *")
    public static CMsghdr io_uring_recvmsg_cmsg_nexthdr(@NativeType(value="struct io_uring_recvmsg_out *") IOURingRecvmsgOut param0, @NativeType(value="struct msghdr *") Msghdr param1, @NativeType(value="struct cmsghdr *") CMsghdr param2) {
        long v3 = LibURing.nio_uring_recvmsg_cmsg_nexthdr(param0.address(), param1.address(), param2.address());
        return CMsghdr.createSafe(v3);
    }

    public static native long nio_uring_recvmsg_payload(long var0, long var2);

    @NativeType(value="void *")
    public static long io_uring_recvmsg_payload(@NativeType(value="struct io_uring_recvmsg_out *") IOURingRecvmsgOut param0, @NativeType(value="struct msghdr *") Msghdr param1) {
        return LibURing.nio_uring_recvmsg_payload(param0.address(), param1.address());
    }

    public static native int nio_uring_recvmsg_payload_length(long var0, int var2, long var3);

    @NativeType(value="unsigned int")
    public static int io_uring_recvmsg_payload_length(@NativeType(value="struct io_uring_recvmsg_out *") IOURingRecvmsgOut param0, int param1, @NativeType(value="struct msghdr *") Msghdr param2) {
        return LibURing.nio_uring_recvmsg_payload_length(param0.address(), param1, param2.address());
    }

    public static native void nio_uring_prep_openat2(long var0, int var2, long var3, long var5);

    public static void io_uring_prep_openat2(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="char const *") ByteBuffer param2, @NativeType(value="struct open_how *") OpenHow param3) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param2);
        }
        LibURing.nio_uring_prep_openat2(param0.address(), param1, MemoryUtil.memAddress(param2), param3.address());
    }

    public static void io_uring_prep_openat2(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="char const *") CharSequence param2, @NativeType(value="struct open_how *") OpenHow param3) {
        MemoryStack v4 = MemoryStack.stackGet();
        int v5 = v4.getPointer();
        try {
            v4.nUTF8(param2, true);
            long v6 = v4.getPointerAddress();
            LibURing.nio_uring_prep_openat2(param0.address(), param1, v6, param3.address());
            return;
        }
        finally {
            v4.setPointer(v5);
        }
    }

    public static native void nio_uring_prep_openat2_direct(long var0, int var2, long var3, long var5, int var7);

    public static void io_uring_prep_openat2_direct(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="char const *") ByteBuffer param2, @NativeType(value="struct open_how *") OpenHow param3, @NativeType(value="unsigned int") int param4) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param2);
        }
        LibURing.nio_uring_prep_openat2_direct(param0.address(), param1, MemoryUtil.memAddress(param2), param3.address(), param4);
    }

    public static void io_uring_prep_openat2_direct(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="char const *") CharSequence param2, @NativeType(value="struct open_how *") OpenHow param3, @NativeType(value="unsigned int") int param4) {
        MemoryStack v5 = MemoryStack.stackGet();
        int v6 = v5.getPointer();
        try {
            v5.nUTF8(param2, true);
            long v7 = v5.getPointerAddress();
            LibURing.nio_uring_prep_openat2_direct(param0.address(), param1, v7, param3.address(), param4);
            return;
        }
        finally {
            v5.setPointer(v6);
        }
    }

    public static native void nio_uring_prep_epoll_ctl(long var0, int var2, int var3, int var4, long var5);

    public static void io_uring_prep_epoll_ctl(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, int param2, int param3, @NativeType(value="struct epoll_event *") EpollEvent param4) {
        LibURing.nio_uring_prep_epoll_ctl(param0.address(), param1, param2, param3, param4.address());
    }

    public static native void nio_uring_prep_provide_buffers(long var0, long var2, int var4, int var5, int var6, int var7);

    public static void io_uring_prep_provide_buffers(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="void *") ByteBuffer param1, int param2, int param3, int param4) {
        LibURing.nio_uring_prep_provide_buffers(param0.address(), MemoryUtil.memAddress(param1), param1.remaining(), param2, param3, param4);
    }

    public static native void nio_uring_prep_remove_buffers(long var0, int var2, int var3);

    public static void io_uring_prep_remove_buffers(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, int param2) {
        LibURing.nio_uring_prep_remove_buffers(param0.address(), param1, param2);
    }

    public static native void nio_uring_prep_shutdown(long var0, int var2, int var3);

    public static void io_uring_prep_shutdown(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, int param2) {
        LibURing.nio_uring_prep_shutdown(param0.address(), param1, param2);
    }

    public static native void nio_uring_prep_unlinkat(long var0, int var2, long var3, int var5);

    public static void io_uring_prep_unlinkat(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="char const *") ByteBuffer param2, int param3) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param2);
        }
        LibURing.nio_uring_prep_unlinkat(param0.address(), param1, MemoryUtil.memAddress(param2), param3);
    }

    public static void io_uring_prep_unlinkat(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="char const *") CharSequence param2, int param3) {
        MemoryStack v4 = MemoryStack.stackGet();
        int v5 = v4.getPointer();
        try {
            v4.nUTF8(param2, true);
            long v6 = v4.getPointerAddress();
            LibURing.nio_uring_prep_unlinkat(param0.address(), param1, v6, param3);
            return;
        }
        finally {
            v4.setPointer(v5);
        }
    }

    public static native void nio_uring_prep_unlink(long var0, long var2, int var4);

    public static void io_uring_prep_unlink(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="char const *") ByteBuffer param1, int param2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param1);
        }
        LibURing.nio_uring_prep_unlink(param0.address(), MemoryUtil.memAddress(param1), param2);
    }

    public static void io_uring_prep_unlink(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="char const *") CharSequence param1, int param2) {
        MemoryStack v3 = MemoryStack.stackGet();
        int v4 = v3.getPointer();
        try {
            v3.nUTF8(param1, true);
            long v5 = v3.getPointerAddress();
            LibURing.nio_uring_prep_unlink(param0.address(), v5, param2);
            return;
        }
        finally {
            v3.setPointer(v4);
        }
    }

    public static native void nio_uring_prep_renameat(long var0, int var2, long var3, int var5, long var6, int var8);

    public static void io_uring_prep_renameat(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="char const *") ByteBuffer param2, int param3, @NativeType(value="char const *") ByteBuffer param4, @NativeType(value="unsigned int") int param5) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param2);
            Checks.checkNT1(param4);
        }
        LibURing.nio_uring_prep_renameat(param0.address(), param1, MemoryUtil.memAddress(param2), param3, MemoryUtil.memAddress(param4), param5);
    }

    public static void io_uring_prep_renameat(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="char const *") CharSequence param2, int param3, @NativeType(value="char const *") CharSequence param4, @NativeType(value="unsigned int") int param5) {
        MemoryStack v6 = MemoryStack.stackGet();
        int v7 = v6.getPointer();
        try {
            v6.nUTF8(param2, true);
            long v8 = v6.getPointerAddress();
            v6.nUTF8(param4, true);
            long v10 = v6.getPointerAddress();
            LibURing.nio_uring_prep_renameat(param0.address(), param1, v8, param3, v10, param5);
            return;
        }
        finally {
            v6.setPointer(v7);
        }
    }

    public static native void nio_uring_prep_rename(long var0, long var2, long var4);

    public static void io_uring_prep_rename(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="char const *") ByteBuffer param1, @NativeType(value="char const *") ByteBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param1);
            Checks.checkNT1(param2);
        }
        LibURing.nio_uring_prep_rename(param0.address(), MemoryUtil.memAddress(param1), MemoryUtil.memAddress(param2));
    }

    public static void io_uring_prep_rename(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="char const *") CharSequence param1, @NativeType(value="char const *") CharSequence param2) {
        MemoryStack v3 = MemoryStack.stackGet();
        int v4 = v3.getPointer();
        try {
            v3.nUTF8(param1, true);
            long v5 = v3.getPointerAddress();
            v3.nUTF8(param2, true);
            long v7 = v3.getPointerAddress();
            LibURing.nio_uring_prep_rename(param0.address(), v5, v7);
            return;
        }
        finally {
            v3.setPointer(v4);
        }
    }

    public static native void nio_uring_prep_sync_file_range(long var0, int var2, int var3, int var4, int var5);

    public static void io_uring_prep_sync_file_range(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="unsigned int") int param2, int param3, int param4) {
        LibURing.nio_uring_prep_sync_file_range(param0.address(), param1, param2, param3, param4);
    }

    public static native void nio_uring_prep_mkdirat(long var0, int var2, long var3, int var5);

    public static void io_uring_prep_mkdirat(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="char const *") ByteBuffer param2, int param3) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param2);
        }
        LibURing.nio_uring_prep_mkdirat(param0.address(), param1, MemoryUtil.memAddress(param2), param3);
    }

    public static void io_uring_prep_mkdirat(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="char const *") CharSequence param2, int param3) {
        MemoryStack v4 = MemoryStack.stackGet();
        int v5 = v4.getPointer();
        try {
            v4.nUTF8(param2, true);
            long v6 = v4.getPointerAddress();
            LibURing.nio_uring_prep_mkdirat(param0.address(), param1, v6, param3);
            return;
        }
        finally {
            v4.setPointer(v5);
        }
    }

    public static native void nio_uring_prep_mkdir(long var0, long var2, int var4);

    public static void io_uring_prep_mkdir(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="char const *") ByteBuffer param1, int param2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param1);
        }
        LibURing.nio_uring_prep_mkdir(param0.address(), MemoryUtil.memAddress(param1), param2);
    }

    public static void io_uring_prep_mkdir(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="char const *") CharSequence param1, int param2) {
        MemoryStack v3 = MemoryStack.stackGet();
        int v4 = v3.getPointer();
        try {
            v3.nUTF8(param1, true);
            long v5 = v3.getPointerAddress();
            LibURing.nio_uring_prep_mkdir(param0.address(), v5, param2);
            return;
        }
        finally {
            v3.setPointer(v4);
        }
    }

    public static native void nio_uring_prep_symlinkat(long var0, long var2, int var4, long var5);

    public static void io_uring_prep_symlinkat(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="char const *") ByteBuffer param1, int param2, @NativeType(value="char const *") ByteBuffer param3) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param1);
            Checks.checkNT1(param3);
        }
        LibURing.nio_uring_prep_symlinkat(param0.address(), MemoryUtil.memAddress(param1), param2, MemoryUtil.memAddress(param3));
    }

    public static void io_uring_prep_symlinkat(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="char const *") CharSequence param1, int param2, @NativeType(value="char const *") CharSequence param3) {
        MemoryStack v4 = MemoryStack.stackGet();
        int v5 = v4.getPointer();
        try {
            v4.nUTF8(param1, true);
            long v6 = v4.getPointerAddress();
            v4.nUTF8(param3, true);
            long v8 = v4.getPointerAddress();
            LibURing.nio_uring_prep_symlinkat(param0.address(), v6, param2, v8);
            return;
        }
        finally {
            v4.setPointer(v5);
        }
    }

    public static native void nio_uring_prep_symlink(long var0, long var2, long var4);

    public static void io_uring_prep_symlink(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="char const *") ByteBuffer param1, @NativeType(value="char const *") ByteBuffer param2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param1);
            Checks.checkNT1(param2);
        }
        LibURing.nio_uring_prep_symlink(param0.address(), MemoryUtil.memAddress(param1), MemoryUtil.memAddress(param2));
    }

    public static void io_uring_prep_symlink(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="char const *") CharSequence param1, @NativeType(value="char const *") CharSequence param2) {
        MemoryStack v3 = MemoryStack.stackGet();
        int v4 = v3.getPointer();
        try {
            v3.nUTF8(param1, true);
            long v5 = v3.getPointerAddress();
            v3.nUTF8(param2, true);
            long v7 = v3.getPointerAddress();
            LibURing.nio_uring_prep_symlink(param0.address(), v5, v7);
            return;
        }
        finally {
            v3.setPointer(v4);
        }
    }

    public static native void nio_uring_prep_linkat(long var0, int var2, long var3, int var5, long var6, int var8);

    public static void io_uring_prep_linkat(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="char const *") ByteBuffer param2, int param3, @NativeType(value="char const *") ByteBuffer param4, int param5) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param2);
            Checks.checkNT1(param4);
        }
        LibURing.nio_uring_prep_linkat(param0.address(), param1, MemoryUtil.memAddress(param2), param3, MemoryUtil.memAddress(param4), param5);
    }

    public static void io_uring_prep_linkat(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="char const *") CharSequence param2, int param3, @NativeType(value="char const *") CharSequence param4, int param5) {
        MemoryStack v6 = MemoryStack.stackGet();
        int v7 = v6.getPointer();
        try {
            v6.nUTF8(param2, true);
            long v8 = v6.getPointerAddress();
            v6.nUTF8(param4, true);
            long v10 = v6.getPointerAddress();
            LibURing.nio_uring_prep_linkat(param0.address(), param1, v8, param3, v10, param5);
            return;
        }
        finally {
            v6.setPointer(v7);
        }
    }

    public static native void nio_uring_prep_link(long var0, long var2, long var4, int var6);

    public static void io_uring_prep_link(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="char const *") ByteBuffer param1, @NativeType(value="char const *") ByteBuffer param2, int param3) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param1);
            Checks.checkNT1(param2);
        }
        LibURing.nio_uring_prep_link(param0.address(), MemoryUtil.memAddress(param1), MemoryUtil.memAddress(param2), param3);
    }

    public static void io_uring_prep_link(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="char const *") CharSequence param1, @NativeType(value="char const *") CharSequence param2, int param3) {
        MemoryStack v4 = MemoryStack.stackGet();
        int v5 = v4.getPointer();
        try {
            v4.nUTF8(param1, true);
            long v6 = v4.getPointerAddress();
            v4.nUTF8(param2, true);
            long v8 = v4.getPointerAddress();
            LibURing.nio_uring_prep_link(param0.address(), v6, v8, param3);
            return;
        }
        finally {
            v4.setPointer(v5);
        }
    }

    public static native void nio_uring_prep_msg_ring_cqe_flags(long var0, int var2, int var3, long var4, int var6, int var7);

    public static void io_uring_prep_msg_ring_cqe_flags(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="unsigned int") int param2, @NativeType(value="__u64") long param3, @NativeType(value="unsigned int") int param5, @NativeType(value="unsigned int") int param6) {
        LibURing.nio_uring_prep_msg_ring_cqe_flags(param0.address(), param1, param2, param3, param5, param6);
    }

    public static native void nio_uring_prep_msg_ring(long var0, int var2, int var3, long var4, int var6);

    public static void io_uring_prep_msg_ring(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="unsigned int") int param2, @NativeType(value="__u64") long param3, @NativeType(value="unsigned int") int param5) {
        LibURing.nio_uring_prep_msg_ring(param0.address(), param1, param2, param3, param5);
    }

    public static native void nio_uring_prep_msg_ring_fd(long var0, int var2, int var3, int var4, long var5, int var7);

    public static void io_uring_prep_msg_ring_fd(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, int param2, int param3, @NativeType(value="__u64") long param4, @NativeType(value="unsigned int") int param6) {
        LibURing.nio_uring_prep_msg_ring_fd(param0.address(), param1, param2, param3, param4, param6);
    }

    public static native void nio_uring_prep_msg_ring_fd_alloc(long var0, int var2, int var3, long var4, int var6);

    public static void io_uring_prep_msg_ring_fd_alloc(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, int param2, @NativeType(value="__u64") long param3, @NativeType(value="unsigned int") int param5) {
        LibURing.nio_uring_prep_msg_ring_fd_alloc(param0.address(), param1, param2, param3, param5);
    }

    public static native void nio_uring_prep_getxattr(long var0, long var2, long var4, long var6, int var8);

    public static void io_uring_prep_getxattr(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="char const *") ByteBuffer param1, @NativeType(value="char *") ByteBuffer param2, @NativeType(value="char const *") ByteBuffer param3) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param1);
            Checks.checkNT1(param3);
        }
        LibURing.nio_uring_prep_getxattr(param0.address(), MemoryUtil.memAddress(param1), MemoryUtil.memAddress(param2), MemoryUtil.memAddress(param3), param2.remaining());
    }

    public static void io_uring_prep_getxattr(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="char const *") CharSequence param1, @NativeType(value="char *") ByteBuffer param2, @NativeType(value="char const *") CharSequence param3) {
        MemoryStack v4 = MemoryStack.stackGet();
        int v5 = v4.getPointer();
        try {
            v4.nUTF8(param1, true);
            long v6 = v4.getPointerAddress();
            v4.nUTF8(param3, true);
            long v8 = v4.getPointerAddress();
            LibURing.nio_uring_prep_getxattr(param0.address(), v6, MemoryUtil.memAddress(param2), v8, param2.remaining());
            return;
        }
        finally {
            v4.setPointer(v5);
        }
    }

    public static native void nio_uring_prep_setxattr(long var0, long var2, long var4, long var6, int var8, int var9);

    public static void io_uring_prep_setxattr(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="char const *") ByteBuffer param1, @NativeType(value="char const *") ByteBuffer param2, @NativeType(value="char const *") ByteBuffer param3, int param4) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param1);
            Checks.checkNT1(param3);
        }
        LibURing.nio_uring_prep_setxattr(param0.address(), MemoryUtil.memAddress(param1), MemoryUtil.memAddress(param2), MemoryUtil.memAddress(param3), param4, param2.remaining());
    }

    public static void io_uring_prep_setxattr(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, @NativeType(value="char const *") CharSequence param1, @NativeType(value="char const *") ByteBuffer param2, @NativeType(value="char const *") CharSequence param3, int param4) {
        MemoryStack v5 = MemoryStack.stackGet();
        int v6 = v5.getPointer();
        try {
            v5.nUTF8(param1, true);
            long v7 = v5.getPointerAddress();
            v5.nUTF8(param3, true);
            long v9 = v5.getPointerAddress();
            LibURing.nio_uring_prep_setxattr(param0.address(), v7, MemoryUtil.memAddress(param2), v9, param4, param2.remaining());
            return;
        }
        finally {
            v5.setPointer(v6);
        }
    }

    public static native void nio_uring_prep_fgetxattr(long var0, int var2, long var3, long var5, int var7);

    public static void io_uring_prep_fgetxattr(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="char const *") ByteBuffer param2, @NativeType(value="char *") ByteBuffer param3) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param2);
        }
        LibURing.nio_uring_prep_fgetxattr(param0.address(), param1, MemoryUtil.memAddress(param2), MemoryUtil.memAddress(param3), param3.remaining());
    }

    public static void io_uring_prep_fgetxattr(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="char const *") CharSequence param2, @NativeType(value="char *") ByteBuffer param3) {
        MemoryStack v4 = MemoryStack.stackGet();
        int v5 = v4.getPointer();
        try {
            v4.nUTF8(param2, true);
            long v6 = v4.getPointerAddress();
            LibURing.nio_uring_prep_fgetxattr(param0.address(), param1, v6, MemoryUtil.memAddress(param3), param3.remaining());
            return;
        }
        finally {
            v4.setPointer(v5);
        }
    }

    public static native void nio_uring_prep_fsetxattr(long var0, int var2, long var3, long var5, int var7, int var8);

    public static void io_uring_prep_fsetxattr(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="char const *") ByteBuffer param2, @NativeType(value="char const *") ByteBuffer param3, int param4) {
        if (Checks.CHECKS) {
            Checks.checkNT1(param2);
        }
        LibURing.nio_uring_prep_fsetxattr(param0.address(), param1, MemoryUtil.memAddress(param2), MemoryUtil.memAddress(param3), param4, param3.remaining());
    }

    public static void io_uring_prep_fsetxattr(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, @NativeType(value="char const *") CharSequence param2, @NativeType(value="char const *") ByteBuffer param3, int param4) {
        MemoryStack v5 = MemoryStack.stackGet();
        int v6 = v5.getPointer();
        try {
            v5.nUTF8(param2, true);
            long v7 = v5.getPointerAddress();
            LibURing.nio_uring_prep_fsetxattr(param0.address(), param1, v7, MemoryUtil.memAddress(param3), param4, param3.remaining());
            return;
        }
        finally {
            v5.setPointer(v6);
        }
    }

    public static native void nio_uring_prep_socket(long var0, int var2, int var3, int var4, int var5);

    public static void io_uring_prep_socket(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, int param2, int param3, @NativeType(value="unsigned int") int param4) {
        LibURing.nio_uring_prep_socket(param0.address(), param1, param2, param3, param4);
    }

    public static native void nio_uring_prep_socket_direct(long var0, int var2, int var3, int var4, int var5, int var6);

    public static void io_uring_prep_socket_direct(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, int param2, int param3, @NativeType(value="unsigned int") int param4, @NativeType(value="unsigned int") int param5) {
        LibURing.nio_uring_prep_socket_direct(param0.address(), param1, param2, param3, param4, param5);
    }

    public static native void nio_uring_prep_socket_direct_alloc(long var0, int var2, int var3, int var4, int var5);

    public static void io_uring_prep_socket_direct_alloc(@NativeType(value="struct io_uring_sqe *") IOURingSQE param0, int param1, int param2, int param3, @NativeType(value="unsigned int") int param4) {
        LibURing.nio_uring_prep_socket_direct_alloc(param0.address(), param1, param2, param3, param4);
    }

    public static native int nio_uring_sq_ready(long var0);

    @NativeType(value="unsigned int")
    public static int io_uring_sq_ready(@NativeType(value="struct io_uring const *") IOURing param0) {
        if (Checks.CHECKS) {
            IOURing.validate(param0.address());
        }
        return LibURing.nio_uring_sq_ready(param0.address());
    }

    public static native int nio_uring_sq_space_left(long var0);

    @NativeType(value="unsigned int")
    public static int io_uring_sq_space_left(@NativeType(value="struct io_uring const *") IOURing param0) {
        if (Checks.CHECKS) {
            IOURing.validate(param0.address());
        }
        return LibURing.nio_uring_sq_space_left(param0.address());
    }

    public static native int nio_uring_sqring_wait(long var0);

    public static int io_uring_sqring_wait(@NativeType(value="struct io_uring *") IOURing param0) {
        return LibURing.nio_uring_sqring_wait(param0.address());
    }

    public static native int nio_uring_cq_ready(long var0);

    @NativeType(value="unsigned int")
    public static int io_uring_cq_ready(@NativeType(value="struct io_uring const *") IOURing param0) {
        if (Checks.CHECKS) {
            IOURing.validate(param0.address());
        }
        return LibURing.nio_uring_cq_ready(param0.address());
    }

    public static native boolean nio_uring_cq_has_overflow(long var0);

    @NativeType(value="bool")
    public static boolean io_uring_cq_has_overflow(@NativeType(value="struct io_uring const *") IOURing param0) {
        if (Checks.CHECKS) {
            IOURing.validate(param0.address());
        }
        return LibURing.nio_uring_cq_has_overflow(param0.address());
    }

    public static native boolean nio_uring_cq_eventfd_enabled(long var0);

    @NativeType(value="bool")
    public static boolean io_uring_cq_eventfd_enabled(@NativeType(value="struct io_uring const *") IOURing param0) {
        if (Checks.CHECKS) {
            IOURing.validate(param0.address());
        }
        return LibURing.nio_uring_cq_eventfd_enabled(param0.address());
    }

    public static native int nio_uring_cq_eventfd_toggle(long var0, boolean var2);

    public static int io_uring_cq_eventfd_toggle(@NativeType(value="struct io_uring *") IOURing param0, @NativeType(value="bool") boolean param1) {
        return LibURing.nio_uring_cq_eventfd_toggle(param0.address(), param1);
    }

    public static native int nio_uring_wait_cqe_nr(long var0, long var2, int var4);

    public static int io_uring_wait_cqe_nr(@NativeType(value="struct io_uring *") IOURing param0, @NativeType(value="struct io_uring_cqe **") PointerBuffer param1) {
        return LibURing.nio_uring_wait_cqe_nr(param0.address(), MemoryUtil.memAddress(param1), param1.remaining());
    }

    public static native int nio_uring_peek_cqe(long var0, long var2);

    public static int io_uring_peek_cqe(@NativeType(value="struct io_uring *") IOURing param0, @NativeType(value="struct io_uring_cqe **") PointerBuffer param1) {
        if (Checks.CHECKS) {
            Checks.check(param1, 1);
        }
        return LibURing.nio_uring_peek_cqe(param0.address(), MemoryUtil.memAddress(param1));
    }

    public static native int nio_uring_wait_cqe(long var0, long var2);

    public static int io_uring_wait_cqe(@NativeType(value="struct io_uring *") IOURing param0, @NativeType(value="struct io_uring_cqe **") PointerBuffer param1) {
        if (Checks.CHECKS) {
            Checks.check(param1, 1);
        }
        return LibURing.nio_uring_wait_cqe(param0.address(), MemoryUtil.memAddress(param1));
    }

    public static native void nio_uring_buf_ring_advance(long var0, int var2);

    public static void io_uring_buf_ring_advance(@NativeType(value="struct io_uring_buf_ring *") IOURingBufRing param0, int param1) {
        LibURing.nio_uring_buf_ring_advance(param0.address(), param1);
    }

    public static native void nio_uring_buf_ring_cq_advance(long var0, long var2, int var4);

    public static void io_uring_buf_ring_cq_advance(@NativeType(value="struct io_uring *") IOURing param0, @NativeType(value="struct io_uring_buf_ring *") IOURingBufRing param1, int param2) {
        LibURing.nio_uring_buf_ring_cq_advance(param0.address(), param1.address(), param2);
    }

    public static native long nio_uring_get_sqe(long var0);

    @Nullable
    @NativeType(value="struct io_uring_sqe *")
    public static IOURingSQE io_uring_get_sqe(@NativeType(value="struct io_uring *") IOURing param0) {
        long v1 = LibURing.nio_uring_get_sqe(param0.address());
        return IOURingSQE.createSafe(v1);
    }

    public static native int io_uring_mlock_size(@NativeType(value="unsigned") int var0, @NativeType(value="unsigned") int var1);

    public static native int nio_uring_mlock_size_params(int var0, long var1);

    public static int io_uring_mlock_size_params(@NativeType(value="unsigned") int param0, @NativeType(value="struct io_uring_params *") IOURingParams param1) {
        return LibURing.nio_uring_mlock_size_params(param0, param1.address());
    }

    public static native int io_uring_major_version();

    public static native int io_uring_minor_version();

    @NativeType(value="bool")
    public static native boolean io_uring_check_version(int var0, int var1);

    public static int io_uring_buf_ring_mask(@NativeType(value="__u32") int param0) {
        return param0 - 1;
    }

    public static void io_uring_buf_ring_init(@NativeType(value="struct io_uring_buf_ring *") IOURingBufRing param0) {
        param0.tail((short)0);
    }

    public static void io_uring_buf_ring_add(@NativeType(value="struct io_uring_buf_ring *") IOURingBufRing param0, @NativeType(value="void *") ByteBuffer param1, @NativeType(value="unsigned short") short param2, int param3, int param4) {
        IOURingBuf v5 = param0.bufs(param0.tail() + param4 & param3);
        v5.addr(MemoryUtil.memAddress(param1));
        v5.len(param1.remaining());
        v5.bid(param2);
    }

    static {
        Library.initialize();
    }
}

