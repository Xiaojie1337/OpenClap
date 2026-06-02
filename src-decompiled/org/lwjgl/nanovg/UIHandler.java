/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.nanovg;

import javax.annotation.Nullable;
import org.lwjgl.nanovg.UIHandlerI;
import org.lwjgl.system.Callback;

public abstract class UIHandler
extends Callback
implements UIHandlerI {
    public static UIHandler create(long param0) {
        UIHandlerI v2 = (UIHandlerI)Callback.get(param0);
        return v2 instanceof UIHandler ? (UIHandler)v2 : new Container(param0, v2);
    }

    @Nullable
    public static UIHandler createSafe(long param0) {
        return param0 == 0L ? null : UIHandler.create(param0);
    }

    public static UIHandler create(UIHandlerI param0) {
        return param0 instanceof UIHandler ? (UIHandler)param0 : new Container(param0.address(), param0);
    }

    protected UIHandler() {
        super(CIF);
    }

    UIHandler(long param1) {
        super(param1);
    }

    private static final class Container
    extends UIHandler {
        private final UIHandlerI delegate;

        Container(long param1, UIHandlerI param3) {
            super(param1);
            this.delegate = param3;
        }

        @Override
        public void invoke(int param1, int param2) {
            this.delegate.invoke(param1, param2);
        }
    }
}

