/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

import java.nio.ByteBuffer;
import org.lwjgl.system.MemoryStack;

@FunctionalInterface
public interface FunctionProvider {
    default public long getFunctionAddress(CharSequence param1) {
        MemoryStack v2 = MemoryStack.stackPush();
        Throwable v3 = null;
        try {
            long v4 = this.getFunctionAddress(v2.ASCII(param1));
            if (v2 != null) {
                v2.close();
            }
            return v4;
        }
        catch (Throwable v7) {
            try {
                v3 = v7;
                throw v7;
            }
            catch (Throwable v8) {
                if (v2 != null) {
                    if (v3 != null) {
                        try {
                            v2.close();
                        }
                        catch (Throwable v9) {
                            v3.addSuppressed(v9);
                        }
                    } else {
                        v2.close();
                    }
                }
                throw v8;
            }
        }
    }

    public long getFunctionAddress(ByteBuffer var1);
}

