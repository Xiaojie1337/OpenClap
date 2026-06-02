/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

public final class CheckIntrinsics {
    private CheckIntrinsics() {
    }

    public static int checkIndex(int param0, int param1) {
        if (param0 < 0 || param1 <= param0) {
            throw new IndexOutOfBoundsException();
        }
        return param0;
    }

    public static int checkFromToIndex(int param0, int param1, int param2) {
        if (param0 < 0 || param1 < param0 || param2 < param1) {
            throw new IndexOutOfBoundsException();
        }
        return param0;
    }

    public static int checkFromIndexSize(int param0, int param1, int param2) {
        if ((param2 | param0 | param1) < 0 || param2 - param0 < param1) {
            throw new IndexOutOfBoundsException();
        }
        return param0;
    }
}

