/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Platform;
import org.lwjgl.system.Pointer;
import org.lwjgl.system.StructBuffer;

public abstract class Struct<SELF extends Struct<SELF>>
extends Pointer.Default {
    protected static final int DEFAULT_PACK_ALIGNMENT;
    protected static final int DEFAULT_ALIGN_AS;
    @Nullable
    protected ByteBuffer container;

    protected Struct(long param1, @Nullable ByteBuffer param3) {
        super(param1);
        this.container = param3;
    }

    protected abstract SELF create(long var1, @Nullable ByteBuffer var3);

    public abstract int sizeof();

    public void clear() {
        MemoryUtil.memSet(this.address(), 0, this.sizeof());
    }

    public void free() {
        MemoryUtil.nmemFree(this.address());
    }

    public boolean isNull(int param1) {
        if (Checks.DEBUG) {
            this.checkMemberOffset(param1);
        }
        return MemoryUtil.memGetAddress(this.address() + (long)param1) == 0L;
    }

    private void checkMemberOffset(int param1) {
        if (param1 < 0 || this.sizeof() - param1 < POINTER_SIZE) {
            throw new IllegalArgumentException("Invalid member offset.");
        }
    }

    protected static ByteBuffer __checkContainer(ByteBuffer param0, int param1) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)param0, param1);
        }
        return param0;
    }

    private static long getBytes(int param0, int param1) {
        return ((long)param0 & 0xFFFFFFFFL) * (long)param1;
    }

    protected static long __checkMalloc(int param0, int param1) {
        long v2 = ((long)param0 & 0xFFFFFFFFL) * (long)param1;
        if (Checks.DEBUG) {
            if (param0 < 0) {
                throw new IllegalArgumentException("Invalid number of elements");
            }
            if (BITS32 && 0xFFFFFFFFL < v2) {
                throw new IllegalArgumentException("The request allocation is too large");
            }
        }
        return v2;
    }

    protected static ByteBuffer __create(int param0, int param1) {
        APIUtil.apiCheckAllocation(param0, Struct.getBytes(param0, param1), Integer.MAX_VALUE);
        return ByteBuffer.allocateDirect(param0 * param1).order(ByteOrder.nativeOrder());
    }

    @Nullable
    protected static <T extends Struct<T>> ByteBuffer __getContainer(T param0) {
        return param0.container;
    }

    @Nullable
    protected static ByteBuffer __getContainer(StructBuffer<?, ?> param0) {
        return param0.container;
    }

    public static void validate(long param0, int param2, int param3, StructValidation param4) {
        for (int v5 = 0; v5 < param2; ++v5) {
            param4.validate(param0 + Integer.toUnsignedLong(v5) * (long)param3);
        }
    }

    protected static Member __padding(int param0, boolean param1) {
        return Struct.__padding(param0, 1, param1);
    }

    protected static Member __padding(int param0, int param1, boolean param2) {
        return Struct.__member(param2 ? param0 * param1 : 0, param1);
    }

    protected static Member __member(int param0) {
        return Struct.__member(param0, param0);
    }

    protected static Member __member(int param0, int param1) {
        return Struct.__member(param0, param1, false);
    }

    protected static Member __member(int param0, int param1, boolean param2) {
        return new Member(param0, param1, param2);
    }

    protected static Member __array(int param0, int param1) {
        return Struct.__array(param0, param0, param1);
    }

    protected static Member __array(int param0, int param1, int param2) {
        return new Member(param0 * param2, param1, false);
    }

    protected static Member __array(int param0, int param1, boolean param2, int param3) {
        return new Member(param0 * param3, param1, param2);
    }

    protected static Layout __union(Member ... param0) {
        return Struct.__union(DEFAULT_PACK_ALIGNMENT, 0, param0);
    }

    protected static Layout __union(int param0, int param1, Member ... param2) {
        ArrayList<Member> v3 = new ArrayList<Member>(param2.length);
        int v4 = 0;
        int v5 = param1;
        for (Member v9 : param2) {
            v4 = Math.max(v4, v9.size);
            v5 = Math.max(v5, v9.getAlignment(param0));
            v9.offset = 0;
            v3.add(v9);
            if (!(v9 instanceof Layout)) continue;
            Struct.addNestedMembers(v9, v3, 0);
        }
        return new Layout(v4, v5, param1 != 0, v3.toArray(new Member[0]));
    }

    protected static Layout __struct(Member ... param0) {
        return Struct.__struct(DEFAULT_PACK_ALIGNMENT, 0, param0);
    }

    protected static Layout __struct(int param0, int param1, Member ... param2) {
        ArrayList<Member> v3 = new ArrayList<Member>(param2.length);
        int v4 = 0;
        int v5 = param1;
        for (Member v9 : param2) {
            int v10 = v9.getAlignment(param0);
            v9.offset = Struct.align(v4, v10);
            v4 = v9.offset + v9.size;
            v5 = Math.max(v5, v10);
            v3.add(v9);
            if (!(v9 instanceof Layout)) continue;
            Struct.addNestedMembers(v9, v3, v9.offset);
        }
        v4 = Struct.align(v4, v5);
        return new Layout(v4, v5, param1 != 0, v3.toArray(new Member[0]));
    }

    private static void addNestedMembers(Member param0, List<Member> param1, int param2) {
        Layout v3 = (Layout)param0;
        for (Member v7 : v3.members) {
            v7.offset += param2;
            param1.add(v7);
        }
    }

    private static int align(int param0, int param1) {
        return (param0 - 1 | param1 - 1) + 1;
    }

    static {
        DEFAULT_ALIGN_AS = 0;
        DEFAULT_PACK_ALIGNMENT = Platform.get() == Platform.WINDOWS ? 8 : 0x40000000;
        Library.initialize();
    }

    protected static class Layout
    extends Member {
        final Member[] members;

        Layout(int param1, int param2, boolean param3, Member[] param4) {
            super(param1, param2, param3);
            this.members = param4;
        }

        public int offsetof(int param1) {
            return this.members[param1].offset;
        }
    }

    protected static class Member {
        final int size;
        final int alignment;
        final boolean forcedAlignment;
        int offset;

        Member(int param1, int param2, boolean param3) {
            this.size = param1;
            this.alignment = param2;
            this.forcedAlignment = param3;
        }

        public int getSize() {
            return this.size;
        }

        public int getAlignment() {
            return this.alignment;
        }

        public int getAlignment(int param1) {
            return this.forcedAlignment ? this.alignment : Math.min(this.alignment, param1);
        }
    }

    @FunctionalInterface
    public static interface StructValidation {
        public void validate(long var1);
    }
}

