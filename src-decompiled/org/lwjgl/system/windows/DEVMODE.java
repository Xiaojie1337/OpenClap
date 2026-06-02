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
import org.lwjgl.system.windows.POINTL;

public class DEVMODE
extends Struct<DEVMODE>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int DMDEVICENAME;
    public static final int DMSPECVERSION;
    public static final int DMDRIVERVERSION;
    public static final int DMSIZE;
    public static final int DMDRIVEREXTRA;
    public static final int DMFIELDS;
    public static final int DMORIENTATION;
    public static final int DMPAPERSIZE;
    public static final int DMPAPERLENGTH;
    public static final int DMPAPERWIDTH;
    public static final int DMSCALE;
    public static final int DMCOPIES;
    public static final int DMDEFAULTSOURCE;
    public static final int DMPRINTQUALITY;
    public static final int DMPOSITION;
    public static final int DMDISPLAYORIENTATION;
    public static final int DMDISPLAYFIXEDOUTPUT;
    public static final int DMCOLOR;
    public static final int DMDUPLEX;
    public static final int DMYRESOLUTION;
    public static final int DMTTOPTION;
    public static final int DMCOLLATE;
    public static final int DMFORMNAME;
    public static final int DMLOGPIXELS;
    public static final int DMBITSPERPEL;
    public static final int DMPELSWIDTH;
    public static final int DMPELSHEIGHT;
    public static final int DMDISPLAYFLAGS;
    public static final int DMNUP;
    public static final int DMDISPLAYFREQUENCY;
    public static final int DMICMMETHOD;
    public static final int DMICMINTENT;
    public static final int DMMEDIATYPE;
    public static final int DMDITHERTYPE;
    public static final int DMRESERVED1;
    public static final int DMRESERVED2;
    public static final int DMPANNINGWIDTH;
    public static final int DMPANNINGHEIGHT;

    protected DEVMODE(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected DEVMODE create(long param1, @Nullable ByteBuffer param3) {
        return new DEVMODE(param1, param3);
    }

    public DEVMODE(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), DEVMODE.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="TCHAR[32]")
    public ByteBuffer dmDeviceName() {
        return DEVMODE.ndmDeviceName(this.address());
    }

    @NativeType(value="TCHAR[32]")
    public String dmDeviceNameString() {
        return DEVMODE.ndmDeviceNameString(this.address());
    }

    @NativeType(value="WORD")
    public short dmSpecVersion() {
        return DEVMODE.ndmSpecVersion(this.address());
    }

    @NativeType(value="WORD")
    public short dmDriverVersion() {
        return DEVMODE.ndmDriverVersion(this.address());
    }

    @NativeType(value="WORD")
    public short dmSize() {
        return DEVMODE.ndmSize(this.address());
    }

    @NativeType(value="WORD")
    public short dmDriverExtra() {
        return DEVMODE.ndmDriverExtra(this.address());
    }

    @NativeType(value="DWORD")
    public int dmFields() {
        return DEVMODE.ndmFields(this.address());
    }

    public short dmOrientation() {
        return DEVMODE.ndmOrientation(this.address());
    }

    public short dmPaperSize() {
        return DEVMODE.ndmPaperSize(this.address());
    }

    public short dmPaperLength() {
        return DEVMODE.ndmPaperLength(this.address());
    }

    public short dmPaperWidth() {
        return DEVMODE.ndmPaperWidth(this.address());
    }

    public short dmScale() {
        return DEVMODE.ndmScale(this.address());
    }

    public short dmCopies() {
        return DEVMODE.ndmCopies(this.address());
    }

    public short dmDefaultSource() {
        return DEVMODE.ndmDefaultSource(this.address());
    }

    public short dmPrintQuality() {
        return DEVMODE.ndmPrintQuality(this.address());
    }

    public POINTL dmPosition() {
        return DEVMODE.ndmPosition(this.address());
    }

    @NativeType(value="DWORD")
    public int dmDisplayOrientation() {
        return DEVMODE.ndmDisplayOrientation(this.address());
    }

    @NativeType(value="DWORD")
    public int dmDisplayFixedOutput() {
        return DEVMODE.ndmDisplayFixedOutput(this.address());
    }

    public short dmColor() {
        return DEVMODE.ndmColor(this.address());
    }

    public short dmDuplex() {
        return DEVMODE.ndmDuplex(this.address());
    }

    public short dmYResolution() {
        return DEVMODE.ndmYResolution(this.address());
    }

    public short dmTTOption() {
        return DEVMODE.ndmTTOption(this.address());
    }

    public short dmCollate() {
        return DEVMODE.ndmCollate(this.address());
    }

    @NativeType(value="TCHAR[32]")
    public ByteBuffer dmFormName() {
        return DEVMODE.ndmFormName(this.address());
    }

    @NativeType(value="TCHAR[32]")
    public String dmFormNameString() {
        return DEVMODE.ndmFormNameString(this.address());
    }

    @NativeType(value="WORD")
    public short dmLogPixels() {
        return DEVMODE.ndmLogPixels(this.address());
    }

    @NativeType(value="DWORD")
    public int dmBitsPerPel() {
        return DEVMODE.ndmBitsPerPel(this.address());
    }

    @NativeType(value="DWORD")
    public int dmPelsWidth() {
        return DEVMODE.ndmPelsWidth(this.address());
    }

    @NativeType(value="DWORD")
    public int dmPelsHeight() {
        return DEVMODE.ndmPelsHeight(this.address());
    }

    @NativeType(value="DWORD")
    public int dmDisplayFlags() {
        return DEVMODE.ndmDisplayFlags(this.address());
    }

    @NativeType(value="DWORD")
    public int dmNup() {
        return DEVMODE.ndmNup(this.address());
    }

    @NativeType(value="DWORD")
    public int dmDisplayFrequency() {
        return DEVMODE.ndmDisplayFrequency(this.address());
    }

    @NativeType(value="DWORD")
    public int dmICMMethod() {
        return DEVMODE.ndmICMMethod(this.address());
    }

    @NativeType(value="DWORD")
    public int dmICMIntent() {
        return DEVMODE.ndmICMIntent(this.address());
    }

    @NativeType(value="DWORD")
    public int dmMediaType() {
        return DEVMODE.ndmMediaType(this.address());
    }

    @NativeType(value="DWORD")
    public int dmDitherType() {
        return DEVMODE.ndmDitherType(this.address());
    }

    @NativeType(value="DWORD")
    public int dmReserved1() {
        return DEVMODE.ndmReserved1(this.address());
    }

    @NativeType(value="DWORD")
    public int dmReserved2() {
        return DEVMODE.ndmReserved2(this.address());
    }

    @NativeType(value="DWORD")
    public int dmPanningWidth() {
        return DEVMODE.ndmPanningWidth(this.address());
    }

    @NativeType(value="DWORD")
    public int dmPanningHeight() {
        return DEVMODE.ndmPanningHeight(this.address());
    }

    public DEVMODE dmSpecVersion(@NativeType(value="WORD") short param1) {
        DEVMODE.ndmSpecVersion(this.address(), param1);
        return this;
    }

    public DEVMODE dmSize(@NativeType(value="WORD") short param1) {
        DEVMODE.ndmSize(this.address(), param1);
        return this;
    }

    public DEVMODE dmDriverExtra(@NativeType(value="WORD") short param1) {
        DEVMODE.ndmDriverExtra(this.address(), param1);
        return this;
    }

    public DEVMODE set(DEVMODE param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static DEVMODE malloc() {
        return new DEVMODE(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static DEVMODE calloc() {
        return new DEVMODE(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static DEVMODE create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new DEVMODE(MemoryUtil.memAddress(v0), v0);
    }

    public static DEVMODE create(long param0) {
        return new DEVMODE(param0, null);
    }

    @Nullable
    public static DEVMODE createSafe(long param0) {
        return param0 == 0L ? null : new DEVMODE(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(DEVMODE.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = DEVMODE.__create(param0, SIZEOF);
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
    public static DEVMODE mallocStack() {
        return DEVMODE.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static DEVMODE callocStack() {
        return DEVMODE.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static DEVMODE mallocStack(MemoryStack param0) {
        return DEVMODE.malloc(param0);
    }

    @Deprecated
    public static DEVMODE callocStack(MemoryStack param0) {
        return DEVMODE.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return DEVMODE.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return DEVMODE.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return DEVMODE.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return DEVMODE.calloc(param0, param1);
    }

    public static DEVMODE malloc(MemoryStack param0) {
        return new DEVMODE(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static DEVMODE calloc(MemoryStack param0) {
        return new DEVMODE(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static ByteBuffer ndmDeviceName(long param0) {
        return MemoryUtil.memByteBuffer(param0 + (long)DMDEVICENAME, 64);
    }

    public static String ndmDeviceNameString(long param0) {
        return MemoryUtil.memUTF16(param0 + (long)DMDEVICENAME);
    }

    public static short ndmSpecVersion(long param0) {
        return UNSAFE.getShort(null, param0 + (long)DMSPECVERSION);
    }

    public static short ndmDriverVersion(long param0) {
        return UNSAFE.getShort(null, param0 + (long)DMDRIVERVERSION);
    }

    public static short ndmSize(long param0) {
        return UNSAFE.getShort(null, param0 + (long)DMSIZE);
    }

    public static short ndmDriverExtra(long param0) {
        return UNSAFE.getShort(null, param0 + (long)DMDRIVEREXTRA);
    }

    public static int ndmFields(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DMFIELDS);
    }

    public static short ndmOrientation(long param0) {
        return UNSAFE.getShort(null, param0 + (long)DMORIENTATION);
    }

    public static short ndmPaperSize(long param0) {
        return UNSAFE.getShort(null, param0 + (long)DMPAPERSIZE);
    }

    public static short ndmPaperLength(long param0) {
        return UNSAFE.getShort(null, param0 + (long)DMPAPERLENGTH);
    }

    public static short ndmPaperWidth(long param0) {
        return UNSAFE.getShort(null, param0 + (long)DMPAPERWIDTH);
    }

    public static short ndmScale(long param0) {
        return UNSAFE.getShort(null, param0 + (long)DMSCALE);
    }

    public static short ndmCopies(long param0) {
        return UNSAFE.getShort(null, param0 + (long)DMCOPIES);
    }

    public static short ndmDefaultSource(long param0) {
        return UNSAFE.getShort(null, param0 + (long)DMDEFAULTSOURCE);
    }

    public static short ndmPrintQuality(long param0) {
        return UNSAFE.getShort(null, param0 + (long)DMPRINTQUALITY);
    }

    public static POINTL ndmPosition(long param0) {
        return POINTL.create(param0 + (long)DMPOSITION);
    }

    public static int ndmDisplayOrientation(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DMDISPLAYORIENTATION);
    }

    public static int ndmDisplayFixedOutput(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DMDISPLAYFIXEDOUTPUT);
    }

    public static short ndmColor(long param0) {
        return UNSAFE.getShort(null, param0 + (long)DMCOLOR);
    }

    public static short ndmDuplex(long param0) {
        return UNSAFE.getShort(null, param0 + (long)DMDUPLEX);
    }

    public static short ndmYResolution(long param0) {
        return UNSAFE.getShort(null, param0 + (long)DMYRESOLUTION);
    }

    public static short ndmTTOption(long param0) {
        return UNSAFE.getShort(null, param0 + (long)DMTTOPTION);
    }

    public static short ndmCollate(long param0) {
        return UNSAFE.getShort(null, param0 + (long)DMCOLLATE);
    }

    public static ByteBuffer ndmFormName(long param0) {
        return MemoryUtil.memByteBuffer(param0 + (long)DMFORMNAME, 64);
    }

    public static String ndmFormNameString(long param0) {
        return MemoryUtil.memUTF16(param0 + (long)DMFORMNAME);
    }

    public static short ndmLogPixels(long param0) {
        return UNSAFE.getShort(null, param0 + (long)DMLOGPIXELS);
    }

    public static int ndmBitsPerPel(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DMBITSPERPEL);
    }

    public static int ndmPelsWidth(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DMPELSWIDTH);
    }

    public static int ndmPelsHeight(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DMPELSHEIGHT);
    }

    public static int ndmDisplayFlags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DMDISPLAYFLAGS);
    }

    public static int ndmNup(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DMNUP);
    }

    public static int ndmDisplayFrequency(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DMDISPLAYFREQUENCY);
    }

    public static int ndmICMMethod(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DMICMMETHOD);
    }

    public static int ndmICMIntent(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DMICMINTENT);
    }

    public static int ndmMediaType(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DMMEDIATYPE);
    }

    public static int ndmDitherType(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DMDITHERTYPE);
    }

    public static int ndmReserved1(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DMRESERVED1);
    }

    public static int ndmReserved2(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DMRESERVED2);
    }

    public static int ndmPanningWidth(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DMPANNINGWIDTH);
    }

    public static int ndmPanningHeight(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DMPANNINGHEIGHT);
    }

    public static void ndmSpecVersion(long param0, short param2) {
        UNSAFE.putShort(null, param0 + (long)DMSPECVERSION, param2);
    }

    public static void ndmSize(long param0, short param2) {
        UNSAFE.putShort(null, param0 + (long)DMSIZE, param2);
    }

    public static void ndmDriverExtra(long param0, short param2) {
        UNSAFE.putShort(null, param0 + (long)DMDRIVEREXTRA, param2);
    }

    static {
        Struct.Layout v0 = DEVMODE.__struct(DEVMODE.__array(2, 32), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(4), DEVMODE.__union(DEVMODE.__struct(DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2)), DEVMODE.__struct(DEVMODE.__member(POINTL.SIZEOF, POINTL.ALIGNOF), DEVMODE.__member(4), DEVMODE.__member(4))), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__array(2, 32), DEVMODE.__member(2), DEVMODE.__member(4), DEVMODE.__member(4), DEVMODE.__member(4), DEVMODE.__union(DEVMODE.__member(4), DEVMODE.__member(4)), DEVMODE.__member(4), DEVMODE.__member(4), DEVMODE.__member(4), DEVMODE.__member(4), DEVMODE.__member(4), DEVMODE.__member(4), DEVMODE.__member(4), DEVMODE.__member(4), DEVMODE.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        DMDEVICENAME = v0.offsetof(0);
        DMSPECVERSION = v0.offsetof(1);
        DMDRIVERVERSION = v0.offsetof(2);
        DMSIZE = v0.offsetof(3);
        DMDRIVEREXTRA = v0.offsetof(4);
        DMFIELDS = v0.offsetof(5);
        DMORIENTATION = v0.offsetof(8);
        DMPAPERSIZE = v0.offsetof(9);
        DMPAPERLENGTH = v0.offsetof(10);
        DMPAPERWIDTH = v0.offsetof(11);
        DMSCALE = v0.offsetof(12);
        DMCOPIES = v0.offsetof(13);
        DMDEFAULTSOURCE = v0.offsetof(14);
        DMPRINTQUALITY = v0.offsetof(15);
        DMPOSITION = v0.offsetof(17);
        DMDISPLAYORIENTATION = v0.offsetof(18);
        DMDISPLAYFIXEDOUTPUT = v0.offsetof(19);
        DMCOLOR = v0.offsetof(20);
        DMDUPLEX = v0.offsetof(21);
        DMYRESOLUTION = v0.offsetof(22);
        DMTTOPTION = v0.offsetof(23);
        DMCOLLATE = v0.offsetof(24);
        DMFORMNAME = v0.offsetof(25);
        DMLOGPIXELS = v0.offsetof(26);
        DMBITSPERPEL = v0.offsetof(27);
        DMPELSWIDTH = v0.offsetof(28);
        DMPELSHEIGHT = v0.offsetof(29);
        DMDISPLAYFLAGS = v0.offsetof(31);
        DMNUP = v0.offsetof(32);
        DMDISPLAYFREQUENCY = v0.offsetof(33);
        DMICMMETHOD = v0.offsetof(34);
        DMICMINTENT = v0.offsetof(35);
        DMMEDIATYPE = v0.offsetof(36);
        DMDITHERTYPE = v0.offsetof(37);
        DMRESERVED1 = v0.offsetof(38);
        DMRESERVED2 = v0.offsetof(39);
        DMPANNINGWIDTH = v0.offsetof(40);
        DMPANNINGHEIGHT = v0.offsetof(41);
    }

    public static class Buffer
    extends StructBuffer<DEVMODE, Buffer>
    implements NativeResource {
        private static final DEVMODE ELEMENT_FACTORY = DEVMODE.create(-1L);

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
        protected DEVMODE getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="TCHAR[32]")
        public ByteBuffer dmDeviceName() {
            return DEVMODE.ndmDeviceName(this.address());
        }

        @NativeType(value="TCHAR[32]")
        public String dmDeviceNameString() {
            return DEVMODE.ndmDeviceNameString(this.address());
        }

        @NativeType(value="WORD")
        public short dmSpecVersion() {
            return DEVMODE.ndmSpecVersion(this.address());
        }

        @NativeType(value="WORD")
        public short dmDriverVersion() {
            return DEVMODE.ndmDriverVersion(this.address());
        }

        @NativeType(value="WORD")
        public short dmSize() {
            return DEVMODE.ndmSize(this.address());
        }

        @NativeType(value="WORD")
        public short dmDriverExtra() {
            return DEVMODE.ndmDriverExtra(this.address());
        }

        @NativeType(value="DWORD")
        public int dmFields() {
            return DEVMODE.ndmFields(this.address());
        }

        public short dmOrientation() {
            return DEVMODE.ndmOrientation(this.address());
        }

        public short dmPaperSize() {
            return DEVMODE.ndmPaperSize(this.address());
        }

        public short dmPaperLength() {
            return DEVMODE.ndmPaperLength(this.address());
        }

        public short dmPaperWidth() {
            return DEVMODE.ndmPaperWidth(this.address());
        }

        public short dmScale() {
            return DEVMODE.ndmScale(this.address());
        }

        public short dmCopies() {
            return DEVMODE.ndmCopies(this.address());
        }

        public short dmDefaultSource() {
            return DEVMODE.ndmDefaultSource(this.address());
        }

        public short dmPrintQuality() {
            return DEVMODE.ndmPrintQuality(this.address());
        }

        public POINTL dmPosition() {
            return DEVMODE.ndmPosition(this.address());
        }

        @NativeType(value="DWORD")
        public int dmDisplayOrientation() {
            return DEVMODE.ndmDisplayOrientation(this.address());
        }

        @NativeType(value="DWORD")
        public int dmDisplayFixedOutput() {
            return DEVMODE.ndmDisplayFixedOutput(this.address());
        }

        public short dmColor() {
            return DEVMODE.ndmColor(this.address());
        }

        public short dmDuplex() {
            return DEVMODE.ndmDuplex(this.address());
        }

        public short dmYResolution() {
            return DEVMODE.ndmYResolution(this.address());
        }

        public short dmTTOption() {
            return DEVMODE.ndmTTOption(this.address());
        }

        public short dmCollate() {
            return DEVMODE.ndmCollate(this.address());
        }

        @NativeType(value="TCHAR[32]")
        public ByteBuffer dmFormName() {
            return DEVMODE.ndmFormName(this.address());
        }

        @NativeType(value="TCHAR[32]")
        public String dmFormNameString() {
            return DEVMODE.ndmFormNameString(this.address());
        }

        @NativeType(value="WORD")
        public short dmLogPixels() {
            return DEVMODE.ndmLogPixels(this.address());
        }

        @NativeType(value="DWORD")
        public int dmBitsPerPel() {
            return DEVMODE.ndmBitsPerPel(this.address());
        }

        @NativeType(value="DWORD")
        public int dmPelsWidth() {
            return DEVMODE.ndmPelsWidth(this.address());
        }

        @NativeType(value="DWORD")
        public int dmPelsHeight() {
            return DEVMODE.ndmPelsHeight(this.address());
        }

        @NativeType(value="DWORD")
        public int dmDisplayFlags() {
            return DEVMODE.ndmDisplayFlags(this.address());
        }

        @NativeType(value="DWORD")
        public int dmNup() {
            return DEVMODE.ndmNup(this.address());
        }

        @NativeType(value="DWORD")
        public int dmDisplayFrequency() {
            return DEVMODE.ndmDisplayFrequency(this.address());
        }

        @NativeType(value="DWORD")
        public int dmICMMethod() {
            return DEVMODE.ndmICMMethod(this.address());
        }

        @NativeType(value="DWORD")
        public int dmICMIntent() {
            return DEVMODE.ndmICMIntent(this.address());
        }

        @NativeType(value="DWORD")
        public int dmMediaType() {
            return DEVMODE.ndmMediaType(this.address());
        }

        @NativeType(value="DWORD")
        public int dmDitherType() {
            return DEVMODE.ndmDitherType(this.address());
        }

        @NativeType(value="DWORD")
        public int dmReserved1() {
            return DEVMODE.ndmReserved1(this.address());
        }

        @NativeType(value="DWORD")
        public int dmReserved2() {
            return DEVMODE.ndmReserved2(this.address());
        }

        @NativeType(value="DWORD")
        public int dmPanningWidth() {
            return DEVMODE.ndmPanningWidth(this.address());
        }

        @NativeType(value="DWORD")
        public int dmPanningHeight() {
            return DEVMODE.ndmPanningHeight(this.address());
        }

        public Buffer dmSpecVersion(@NativeType(value="WORD") short param1) {
            DEVMODE.ndmSpecVersion(this.address(), param1);
            return this;
        }

        public Buffer dmSize(@NativeType(value="WORD") short param1) {
            DEVMODE.ndmSize(this.address(), param1);
            return this;
        }

        public Buffer dmDriverExtra(@NativeType(value="WORD") short param1) {
            DEVMODE.ndmDriverExtra(this.address(), param1);
            return this;
        }
    }
}

