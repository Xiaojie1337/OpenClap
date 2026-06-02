/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.windows;

import org.lwjgl.system.windows.WinBase;

public final class WindowsUtil {
    private WindowsUtil() {
    }

    public static void windowsThrowException(String param0) {
        throw new RuntimeException(param0 + " (error code = " + WinBase.getLastError() + ")");
    }
}

