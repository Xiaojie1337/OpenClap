/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

import java.nio.ByteBuffer;
import org.lwjgl.system.FunctionProvider;
import org.lwjgl.system.MemoryStack;

public interface FunctionProviderLocal
extends FunctionProvider {
    default public long getFunctionAddress(long param1, CharSequence param3) {
        MemoryStack v4 = MemoryStack.stackPush();
        Throwable v5 = null;
        try {
            long v6 = this.getFunctionAddress(param1, v4.ASCII(param3));
            if (v4 != null) {
                v4.close();
            }
            return v6;
        }
        catch (Throwable v9) {
            try {
                v5 = v9;
                throw v9;
            }
            catch (Throwable v10) {
                if (v4 != null) {
                    if (v5 != null) {
                        try {
                            v4.close();
                        }
                        catch (Throwable v11) {
                            v5.addSuppressed(v11);
                        }
                    } else {
                        v4.close();
                    }
                }
                throw v10;
            }
        }
    }

    public long getFunctionAddress(long var1, ByteBuffer var3);
}

