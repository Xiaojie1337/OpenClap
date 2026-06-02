/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.macosx;

import javax.annotation.Nullable;
import org.lwjgl.system.Callback;
import org.lwjgl.system.macosx.CGEventTapCallBackI;

public abstract class CGEventTapCallBack
extends Callback
implements CGEventTapCallBackI {
    public static CGEventTapCallBack create(long param0) {
        CGEventTapCallBackI v2 = (CGEventTapCallBackI)Callback.get(param0);
        return v2 instanceof CGEventTapCallBack ? (CGEventTapCallBack)v2 : new Container(param0, v2);
    }

    @Nullable
    public static CGEventTapCallBack createSafe(long param0) {
        return param0 == 0L ? null : CGEventTapCallBack.create(param0);
    }

    public static CGEventTapCallBack create(CGEventTapCallBackI param0) {
        return param0 instanceof CGEventTapCallBack ? (CGEventTapCallBack)param0 : new Container(param0.address(), param0);
    }

    protected CGEventTapCallBack() {
        super(CIF);
    }

    CGEventTapCallBack(long param1) {
        super(param1);
    }

    private static final class Container
    extends CGEventTapCallBack {
        private final CGEventTapCallBackI delegate;

        Container(long param1, CGEventTapCallBackI param3) {
            super(param1);
            this.delegate = param3;
        }

        @Override
        public long invoke(long param1, int param3, long param4, long param6) {
            return this.delegate.invoke(param1, param3, param4, param6);
        }
    }
}

