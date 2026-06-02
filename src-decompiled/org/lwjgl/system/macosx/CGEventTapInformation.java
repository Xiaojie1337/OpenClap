/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.macosx;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class CGEventTapInformation
extends Struct<CGEventTapInformation>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int EVENTTAPID;
    public static final int TAPPOINT;
    public static final int OPTIONS;
    public static final int EVENTSOFINTEREST;
    public static final int TAPPINGPROCESS;
    public static final int PROCESSBEINGTAPPED;
    public static final int ENABLED;
    public static final int MINUSECLATENCY;
    public static final int AVGUSECLATENCY;
    public static final int MAXUSECLATENCY;

    protected CGEventTapInformation(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected CGEventTapInformation create(long param1, @Nullable ByteBuffer param3) {
        return new CGEventTapInformation(param1, param3);
    }

    public CGEventTapInformation(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), CGEventTapInformation.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="uint32_t")
    public int eventTapID() {
        return CGEventTapInformation.neventTapID(this.address());
    }

    @NativeType(value="CGEventTapLocation")
    public int tapPoint() {
        return CGEventTapInformation.ntapPoint(this.address());
    }

    @NativeType(value="CGEventTapOptions")
    public int options() {
        return CGEventTapInformation.noptions(this.address());
    }

    @NativeType(value="CGEventMask")
    public long eventsOfInterest() {
        return CGEventTapInformation.neventsOfInterest(this.address());
    }

    @NativeType(value="pid_t")
    public long tappingProcess() {
        return CGEventTapInformation.ntappingProcess(this.address());
    }

    @NativeType(value="pid_t")
    public long processBeingTapped() {
        return CGEventTapInformation.nprocessBeingTapped(this.address());
    }

    @NativeType(value="bool")
    public boolean enabled() {
        return CGEventTapInformation.nenabled(this.address());
    }

    public float minUsecLatency() {
        return CGEventTapInformation.nminUsecLatency(this.address());
    }

    public float avgUsecLatency() {
        return CGEventTapInformation.navgUsecLatency(this.address());
    }

    public float maxUsecLatency() {
        return CGEventTapInformation.nmaxUsecLatency(this.address());
    }

    public static CGEventTapInformation malloc() {
        return new CGEventTapInformation(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static CGEventTapInformation calloc() {
        return new CGEventTapInformation(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static CGEventTapInformation create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new CGEventTapInformation(MemoryUtil.memAddress(v0), v0);
    }

    public static CGEventTapInformation create(long param0) {
        return new CGEventTapInformation(param0, null);
    }

    @Nullable
    public static CGEventTapInformation createSafe(long param0) {
        return param0 == 0L ? null : new CGEventTapInformation(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(CGEventTapInformation.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = CGEventTapInformation.__create(param0, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(v1), v1, -1, 0, param0, param0);
    }

    public static Buffer create(long param0, int param2) {
        return new Buffer(param0, param2);
    }

    @Nullable
    public static Buffer createSafe(long param0, int param2) {
        return param0 == 0L ? null : new Buffer(param0, param2);
    }

    @Deprecated
    public static CGEventTapInformation mallocStack() {
        return CGEventTapInformation.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static CGEventTapInformation callocStack() {
        return CGEventTapInformation.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static CGEventTapInformation mallocStack(MemoryStack param0) {
        return CGEventTapInformation.malloc(param0);
    }

    @Deprecated
    public static CGEventTapInformation callocStack(MemoryStack param0) {
        return CGEventTapInformation.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return CGEventTapInformation.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return CGEventTapInformation.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return CGEventTapInformation.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return CGEventTapInformation.calloc(param0, param1);
    }

    public static CGEventTapInformation malloc(MemoryStack param0) {
        return new CGEventTapInformation(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static CGEventTapInformation calloc(MemoryStack param0) {
        return new CGEventTapInformation(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static int neventTapID(long param0) {
        return UNSAFE.getInt(null, param0 + (long)EVENTTAPID);
    }

    public static int ntapPoint(long param0) {
        return UNSAFE.getInt(null, param0 + (long)TAPPOINT);
    }

    public static int noptions(long param0) {
        return UNSAFE.getInt(null, param0 + (long)OPTIONS);
    }

    public static long neventsOfInterest(long param0) {
        return UNSAFE.getLong(null, param0 + (long)EVENTSOFINTEREST);
    }

    public static long ntappingProcess(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)TAPPINGPROCESS);
    }

    public static long nprocessBeingTapped(long param0) {
        return MemoryUtil.memGetAddress(param0 + (long)PROCESSBEINGTAPPED);
    }

    public static boolean nenabled(long param0) {
        return UNSAFE.getByte(null, param0 + (long)ENABLED) != 0;
    }

    public static float nminUsecLatency(long param0) {
        return UNSAFE.getFloat(null, param0 + (long)MINUSECLATENCY);
    }

    public static float navgUsecLatency(long param0) {
        return UNSAFE.getFloat(null, param0 + (long)AVGUSECLATENCY);
    }

    public static float nmaxUsecLatency(long param0) {
        return UNSAFE.getFloat(null, param0 + (long)MAXUSECLATENCY);
    }

    static {
        Struct.Layout v0 = CGEventTapInformation.__struct(CGEventTapInformation.__member(4), CGEventTapInformation.__member(4), CGEventTapInformation.__member(4), CGEventTapInformation.__member(8), CGEventTapInformation.__member(POINTER_SIZE), CGEventTapInformation.__member(POINTER_SIZE), CGEventTapInformation.__member(1), CGEventTapInformation.__member(4), CGEventTapInformation.__member(4), CGEventTapInformation.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        EVENTTAPID = v0.offsetof(0);
        TAPPOINT = v0.offsetof(1);
        OPTIONS = v0.offsetof(2);
        EVENTSOFINTEREST = v0.offsetof(3);
        TAPPINGPROCESS = v0.offsetof(4);
        PROCESSBEINGTAPPED = v0.offsetof(5);
        ENABLED = v0.offsetof(6);
        MINUSECLATENCY = v0.offsetof(7);
        AVGUSECLATENCY = v0.offsetof(8);
        MAXUSECLATENCY = v0.offsetof(9);
    }

    public static class Buffer
    extends StructBuffer<CGEventTapInformation, Buffer>
    implements NativeResource {
        private static final CGEventTapInformation ELEMENT_FACTORY = CGEventTapInformation.create(-1L);

        public Buffer(ByteBuffer param1) {
            super(param1, param1.remaining() / SIZEOF);
        }

        public Buffer(long param1, int param3) {
            super(param1, null, -1, 0, param3, param3);
        }

        Buffer(long param1, @Nullable ByteBuffer param3, int param4, int param5, int param6, int param7) {
            super(param1, param3, param4, param5, param6, param7);
        }

        @Override
        protected Buffer self() {
            return this;
        }

        @Override
        protected CGEventTapInformation getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="uint32_t")
        public int eventTapID() {
            return CGEventTapInformation.neventTapID(this.address());
        }

        @NativeType(value="CGEventTapLocation")
        public int tapPoint() {
            return CGEventTapInformation.ntapPoint(this.address());
        }

        @NativeType(value="CGEventTapOptions")
        public int options() {
            return CGEventTapInformation.noptions(this.address());
        }

        @NativeType(value="CGEventMask")
        public long eventsOfInterest() {
            return CGEventTapInformation.neventsOfInterest(this.address());
        }

        @NativeType(value="pid_t")
        public long tappingProcess() {
            return CGEventTapInformation.ntappingProcess(this.address());
        }

        @NativeType(value="pid_t")
        public long processBeingTapped() {
            return CGEventTapInformation.nprocessBeingTapped(this.address());
        }

        @NativeType(value="bool")
        public boolean enabled() {
            return CGEventTapInformation.nenabled(this.address());
        }

        public float minUsecLatency() {
            return CGEventTapInformation.nminUsecLatency(this.address());
        }

        public float avgUsecLatency() {
            return CGEventTapInformation.navgUsecLatency(this.address());
        }

        public float maxUsecLatency() {
            return CGEventTapInformation.nmaxUsecLatency(this.address());
        }
    }
}

