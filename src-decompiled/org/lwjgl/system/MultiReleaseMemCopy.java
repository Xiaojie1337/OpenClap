/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Pointer;
import org.lwjgl.system.libc.LibCString;

final class MultiReleaseMemCopy {
    private MultiReleaseMemCopy() {
    }

    static void copy(long param0, long param2, long param4) {
        if (param4 <= 160L) {
            if (Pointer.BITS64 && ((param0 | param2) & 7L) == 0L) {
                MemoryUtil.memCopyAligned64(param0, param2, (int)param4 & 0xFF);
            } else {
                MemoryUtil.UNSAFE.copyMemory(null, param0, null, param2, param4);
            }
            return;
        }
        LibCString.nmemcpy(param2, param0, param4);
    }
}

