/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package org.lwjgl.system.windows;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class DISPLAY_DEVICE
extends Struct<DISPLAY_DEVICE>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int CB;
    public static final int DEVICENAME;
    public static final int DEVICESTRING;
    public static final int STATEFLAGS;
    public static final int DEVICEID;
    public static final int DEVICEKEY;

    protected DISPLAY_DEVICE(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected DISPLAY_DEVICE create(long param1, @Nullable ByteBuffer param3) {
        return new DISPLAY_DEVICE(param1, param3);
    }

    public DISPLAY_DEVICE(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), DISPLAY_DEVICE.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="DWORD")
    public int cb() {
        return DISPLAY_DEVICE.ncb(this.address());
    }

    @NativeType(value="TCHAR[32]")
    public ByteBuffer DeviceName() {
        return DISPLAY_DEVICE.nDeviceName(this.address());
    }

    @NativeType(value="TCHAR[32]")
    public String DeviceNameString() {
        return DISPLAY_DEVICE.nDeviceNameString(this.address());
    }

    @NativeType(value="TCHAR[128]")
    public ByteBuffer DeviceString() {
        return DISPLAY_DEVICE.nDeviceString(this.address());
    }

    @NativeType(value="TCHAR[128]")
    public String DeviceStringString() {
        return DISPLAY_DEVICE.nDeviceStringString(this.address());
    }

    @NativeType(value="DWORD")
    public int StateFlags() {
        return DISPLAY_DEVICE.nStateFlags(this.address());
    }

    @NativeType(value="TCHAR[128]")
    public ByteBuffer DeviceID() {
        return DISPLAY_DEVICE.nDeviceID(this.address());
    }

    @NativeType(value="TCHAR[128]")
    public String DeviceIDString() {
        return DISPLAY_DEVICE.nDeviceIDString(this.address());
    }

    @NativeType(value="TCHAR[128]")
    public ByteBuffer DeviceKey() {
        return DISPLAY_DEVICE.nDeviceKey(this.address());
    }

    @NativeType(value="TCHAR[128]")
    public String DeviceKeyString() {
        return DISPLAY_DEVICE.nDeviceKeyString(this.address());
    }

    public DISPLAY_DEVICE cb(@NativeType(value="DWORD") int param1) {
        DISPLAY_DEVICE.ncb(this.address(), param1);
        return this;
    }

    public DISPLAY_DEVICE set(DISPLAY_DEVICE param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static DISPLAY_DEVICE malloc() {
        return new DISPLAY_DEVICE(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static DISPLAY_DEVICE calloc() {
        return new DISPLAY_DEVICE(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static DISPLAY_DEVICE create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new DISPLAY_DEVICE(MemoryUtil.memAddress(v0), v0);
    }

    public static DISPLAY_DEVICE create(long param0) {
        return new DISPLAY_DEVICE(param0, null);
    }

    @Nullable
    public static DISPLAY_DEVICE createSafe(long param0) {
        return param0 == 0L ? null : new DISPLAY_DEVICE(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(DISPLAY_DEVICE.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = DISPLAY_DEVICE.__create(param0, SIZEOF);
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
    public static DISPLAY_DEVICE mallocStack() {
        return DISPLAY_DEVICE.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static DISPLAY_DEVICE callocStack() {
        return DISPLAY_DEVICE.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static DISPLAY_DEVICE mallocStack(MemoryStack param0) {
        return DISPLAY_DEVICE.malloc(param0);
    }

    @Deprecated
    public static DISPLAY_DEVICE callocStack(MemoryStack param0) {
        return DISPLAY_DEVICE.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return DISPLAY_DEVICE.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return DISPLAY_DEVICE.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return DISPLAY_DEVICE.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return DISPLAY_DEVICE.calloc(param0, param1);
    }

    public static DISPLAY_DEVICE malloc(MemoryStack param0) {
        return new DISPLAY_DEVICE(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static DISPLAY_DEVICE calloc(MemoryStack param0) {
        return new DISPLAY_DEVICE(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static int ncb(long param0) {
        return UNSAFE.getInt(null, param0 + (long)CB);
    }

    public static ByteBuffer nDeviceName(long param0) {
        return MemoryUtil.memByteBuffer(param0 + (long)DEVICENAME, 64);
    }

    public static String nDeviceNameString(long param0) {
        return MemoryUtil.memUTF16(param0 + (long)DEVICENAME);
    }

    public static ByteBuffer nDeviceString(long param0) {
        return MemoryUtil.memByteBuffer(param0 + (long)DEVICESTRING, 256);
    }

    public static String nDeviceStringString(long param0) {
        return MemoryUtil.memUTF16(param0 + (long)DEVICESTRING);
    }

    public static int nStateFlags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)STATEFLAGS);
    }

    public static ByteBuffer nDeviceID(long param0) {
        return MemoryUtil.memByteBuffer(param0 + (long)DEVICEID, 256);
    }

    public static String nDeviceIDString(long param0) {
        return MemoryUtil.memUTF16(param0 + (long)DEVICEID);
    }

    public static ByteBuffer nDeviceKey(long param0) {
        return MemoryUtil.memByteBuffer(param0 + (long)DEVICEKEY, 256);
    }

    public static String nDeviceKeyString(long param0) {
        return MemoryUtil.memUTF16(param0 + (long)DEVICEKEY);
    }

    public static void ncb(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)CB, param2);
    }

    static {
        Struct.Layout v0 = DISPLAY_DEVICE.__struct(DISPLAY_DEVICE.__member(4), DISPLAY_DEVICE.__array(2, 32), DISPLAY_DEVICE.__array(2, 128), DISPLAY_DEVICE.__member(4), DISPLAY_DEVICE.__array(2, 128), DISPLAY_DEVICE.__array(2, 128));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        CB = v0.offsetof(0);
        DEVICENAME = v0.offsetof(1);
        DEVICESTRING = v0.offsetof(2);
        STATEFLAGS = v0.offsetof(3);
        DEVICEID = v0.offsetof(4);
        DEVICEKEY = v0.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<DISPLAY_DEVICE, Buffer>
    implements NativeResource {
        private static final DISPLAY_DEVICE ELEMENT_FACTORY = DISPLAY_DEVICE.create(-1L);

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
        protected DISPLAY_DEVICE getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="DWORD")
        public int cb() {
            return DISPLAY_DEVICE.ncb(this.address());
        }

        @NativeType(value="TCHAR[32]")
        public ByteBuffer DeviceName() {
            return DISPLAY_DEVICE.nDeviceName(this.address());
        }

        @NativeType(value="TCHAR[32]")
        public String DeviceNameString() {
            return DISPLAY_DEVICE.nDeviceNameString(this.address());
        }

        @NativeType(value="TCHAR[128]")
        public ByteBuffer DeviceString() {
            return DISPLAY_DEVICE.nDeviceString(this.address());
        }

        @NativeType(value="TCHAR[128]")
        public String DeviceStringString() {
            return DISPLAY_DEVICE.nDeviceStringString(this.address());
        }

        @NativeType(value="DWORD")
        public int StateFlags() {
            return DISPLAY_DEVICE.nStateFlags(this.address());
        }

        @NativeType(value="TCHAR[128]")
        public ByteBuffer DeviceID() {
            return DISPLAY_DEVICE.nDeviceID(this.address());
        }

        @NativeType(value="TCHAR[128]")
        public String DeviceIDString() {
            return DISPLAY_DEVICE.nDeviceIDString(this.address());
        }

        @NativeType(value="TCHAR[128]")
        public ByteBuffer DeviceKey() {
            return DISPLAY_DEVICE.nDeviceKey(this.address());
        }

        @NativeType(value="TCHAR[128]")
        public String DeviceKeyString() {
            return DISPLAY_DEVICE.nDeviceKeyString(this.address());
        }

        public Buffer cb(@NativeType(value="DWORD") int param1) {
            DISPLAY_DEVICE.ncb(this.address(), param1);
            return this;
        }
    }
}

