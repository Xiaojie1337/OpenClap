/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.macosx;

import javax.annotation.Nullable;
import org.lwjgl.system.Callback;
import org.lwjgl.system.macosx.EnumerationMutationHandlerI;

public abstract class EnumerationMutationHandler
extends Callback
implements EnumerationMutationHandlerI {
    public static EnumerationMutationHandler create(long param0) {
        EnumerationMutationHandlerI v2 = (EnumerationMutationHandlerI)Callback.get(param0);
        return v2 instanceof EnumerationMutationHandler ? (EnumerationMutationHandler)v2 : new Container(param0, v2);
    }

    @Nullable
    public static EnumerationMutationHandler createSafe(long param0) {
        return param0 == 0L ? null : EnumerationMutationHandler.create(param0);
    }

    public static EnumerationMutationHandler create(EnumerationMutationHandlerI param0) {
        return param0 instanceof EnumerationMutationHandler ? (EnumerationMutationHandler)param0 : new Container(param0.address(), param0);
    }

    protected EnumerationMutationHandler() {
        super(CIF);
    }

    EnumerationMutationHandler(long param1) {
        super(param1);
    }

    private static final class Container
    extends EnumerationMutationHandler {
        private final EnumerationMutationHandlerI delegate;

        Container(long param1, EnumerationMutationHandlerI param3) {
            super(param1);
            this.delegate = param3;
        }

        @Override
        public void invoke(long param1) {
            this.delegate.invoke(param1);
        }
    }
}

