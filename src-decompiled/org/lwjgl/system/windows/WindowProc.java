/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.windows;

import javax.annotation.Nullable;
import org.lwjgl.system.Callback;
import org.lwjgl.system.windows.WindowProcI;

public abstract class WindowProc
extends Callback
implements WindowProcI {
    public static WindowProc create(long param0) {
        WindowProcI v2 = (WindowProcI)Callback.get(param0);
        return v2 instanceof WindowProc ? (WindowProc)v2 : new Container(param0, v2);
    }

    @Nullable
    public static WindowProc createSafe(long param0) {
        return param0 == 0L ? null : WindowProc.create(param0);
    }

    public static WindowProc create(WindowProcI param0) {
        return param0 instanceof WindowProc ? (WindowProc)param0 : new Container(param0.address(), param0);
    }

    protected WindowProc() {
        super(CIF);
    }

    WindowProc(long param1) {
        super(param1);
    }

    private static final class Container
    extends WindowProc {
        private final WindowProcI delegate;

        Container(long param1, WindowProcI param3) {
            super(param1);
            this.delegate = param3;
        }

        @Override
        public long invoke(long param1, int param3, long param4, long param6) {
            return this.delegate.invoke(param1, param3, param4, param6);
        }
    }
}

