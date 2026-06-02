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

public class PIXELFORMATDESCRIPTOR
extends Struct<PIXELFORMATDESCRIPTOR>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int NSIZE;
    public static final int NVERSION;
    public static final int DWFLAGS;
    public static final int IPIXELTYPE;
    public static final int CCOLORBITS;
    public static final int CREDBITS;
    public static final int CREDSHIFT;
    public static final int CGREENBITS;
    public static final int CGREENSHIFT;
    public static final int CBLUEBITS;
    public static final int CBLUESHIFT;
    public static final int CALPHABITS;
    public static final int CALPHASHIFT;
    public static final int CACCUMBITS;
    public static final int CACCUMREDBITS;
    public static final int CACCUMGREENBITS;
    public static final int CACCUMBLUEBITS;
    public static final int CACCUMALPHABITS;
    public static final int CDEPTHBITS;
    public static final int CSTENCILBITS;
    public static final int CAUXBUFFERS;
    public static final int ILAYERTYPE;
    public static final int BRESERVED;
    public static final int DWLAYERMASK;
    public static final int DWVISIBLEMASK;
    public static final int DWDAMAGEMASK;

    protected PIXELFORMATDESCRIPTOR(long param1, @Nullable ByteBuffer param3) {
        super(param1, param3);
    }

    @Override
    protected PIXELFORMATDESCRIPTOR create(long param1, @Nullable ByteBuffer param3) {
        return new PIXELFORMATDESCRIPTOR(param1, param3);
    }

    public PIXELFORMATDESCRIPTOR(ByteBuffer param1) {
        super(MemoryUtil.memAddress(param1), PIXELFORMATDESCRIPTOR.__checkContainer(param1, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="WORD")
    public short nSize() {
        return PIXELFORMATDESCRIPTOR.nnSize(this.address());
    }

    @NativeType(value="WORD")
    public short nVersion() {
        return PIXELFORMATDESCRIPTOR.nnVersion(this.address());
    }

    @NativeType(value="DWORD")
    public int dwFlags() {
        return PIXELFORMATDESCRIPTOR.ndwFlags(this.address());
    }

    @NativeType(value="BYTE")
    public byte iPixelType() {
        return PIXELFORMATDESCRIPTOR.niPixelType(this.address());
    }

    @NativeType(value="BYTE")
    public byte cColorBits() {
        return PIXELFORMATDESCRIPTOR.ncColorBits(this.address());
    }

    @NativeType(value="BYTE")
    public byte cRedBits() {
        return PIXELFORMATDESCRIPTOR.ncRedBits(this.address());
    }

    @NativeType(value="BYTE")
    public byte cRedShift() {
        return PIXELFORMATDESCRIPTOR.ncRedShift(this.address());
    }

    @NativeType(value="BYTE")
    public byte cGreenBits() {
        return PIXELFORMATDESCRIPTOR.ncGreenBits(this.address());
    }

    @NativeType(value="BYTE")
    public byte cGreenShift() {
        return PIXELFORMATDESCRIPTOR.ncGreenShift(this.address());
    }

    @NativeType(value="BYTE")
    public byte cBlueBits() {
        return PIXELFORMATDESCRIPTOR.ncBlueBits(this.address());
    }

    @NativeType(value="BYTE")
    public byte cBlueShift() {
        return PIXELFORMATDESCRIPTOR.ncBlueShift(this.address());
    }

    @NativeType(value="BYTE")
    public byte cAlphaBits() {
        return PIXELFORMATDESCRIPTOR.ncAlphaBits(this.address());
    }

    @NativeType(value="BYTE")
    public byte cAlphaShift() {
        return PIXELFORMATDESCRIPTOR.ncAlphaShift(this.address());
    }

    @NativeType(value="BYTE")
    public byte cAccumBits() {
        return PIXELFORMATDESCRIPTOR.ncAccumBits(this.address());
    }

    @NativeType(value="BYTE")
    public byte cAccumRedBits() {
        return PIXELFORMATDESCRIPTOR.ncAccumRedBits(this.address());
    }

    @NativeType(value="BYTE")
    public byte cAccumGreenBits() {
        return PIXELFORMATDESCRIPTOR.ncAccumGreenBits(this.address());
    }

    @NativeType(value="BYTE")
    public byte cAccumBlueBits() {
        return PIXELFORMATDESCRIPTOR.ncAccumBlueBits(this.address());
    }

    @NativeType(value="BYTE")
    public byte cAccumAlphaBits() {
        return PIXELFORMATDESCRIPTOR.ncAccumAlphaBits(this.address());
    }

    @NativeType(value="BYTE")
    public byte cDepthBits() {
        return PIXELFORMATDESCRIPTOR.ncDepthBits(this.address());
    }

    @NativeType(value="BYTE")
    public byte cStencilBits() {
        return PIXELFORMATDESCRIPTOR.ncStencilBits(this.address());
    }

    @NativeType(value="BYTE")
    public byte cAuxBuffers() {
        return PIXELFORMATDESCRIPTOR.ncAuxBuffers(this.address());
    }

    @NativeType(value="BYTE")
    public byte iLayerType() {
        return PIXELFORMATDESCRIPTOR.niLayerType(this.address());
    }

    @NativeType(value="BYTE")
    public byte bReserved() {
        return PIXELFORMATDESCRIPTOR.nbReserved(this.address());
    }

    @NativeType(value="DWORD")
    public int dwLayerMask() {
        return PIXELFORMATDESCRIPTOR.ndwLayerMask(this.address());
    }

    @NativeType(value="DWORD")
    public int dwVisibleMask() {
        return PIXELFORMATDESCRIPTOR.ndwVisibleMask(this.address());
    }

    @NativeType(value="DWORD")
    public int dwDamageMask() {
        return PIXELFORMATDESCRIPTOR.ndwDamageMask(this.address());
    }

    public PIXELFORMATDESCRIPTOR nSize(@NativeType(value="WORD") short param1) {
        PIXELFORMATDESCRIPTOR.nnSize(this.address(), param1);
        return this;
    }

    public PIXELFORMATDESCRIPTOR nVersion(@NativeType(value="WORD") short param1) {
        PIXELFORMATDESCRIPTOR.nnVersion(this.address(), param1);
        return this;
    }

    public PIXELFORMATDESCRIPTOR dwFlags(@NativeType(value="DWORD") int param1) {
        PIXELFORMATDESCRIPTOR.ndwFlags(this.address(), param1);
        return this;
    }

    public PIXELFORMATDESCRIPTOR iPixelType(@NativeType(value="BYTE") byte param1) {
        PIXELFORMATDESCRIPTOR.niPixelType(this.address(), param1);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cColorBits(@NativeType(value="BYTE") byte param1) {
        PIXELFORMATDESCRIPTOR.ncColorBits(this.address(), param1);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cRedBits(@NativeType(value="BYTE") byte param1) {
        PIXELFORMATDESCRIPTOR.ncRedBits(this.address(), param1);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cRedShift(@NativeType(value="BYTE") byte param1) {
        PIXELFORMATDESCRIPTOR.ncRedShift(this.address(), param1);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cGreenBits(@NativeType(value="BYTE") byte param1) {
        PIXELFORMATDESCRIPTOR.ncGreenBits(this.address(), param1);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cGreenShift(@NativeType(value="BYTE") byte param1) {
        PIXELFORMATDESCRIPTOR.ncGreenShift(this.address(), param1);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cBlueBits(@NativeType(value="BYTE") byte param1) {
        PIXELFORMATDESCRIPTOR.ncBlueBits(this.address(), param1);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cBlueShift(@NativeType(value="BYTE") byte param1) {
        PIXELFORMATDESCRIPTOR.ncBlueShift(this.address(), param1);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cAlphaBits(@NativeType(value="BYTE") byte param1) {
        PIXELFORMATDESCRIPTOR.ncAlphaBits(this.address(), param1);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cAlphaShift(@NativeType(value="BYTE") byte param1) {
        PIXELFORMATDESCRIPTOR.ncAlphaShift(this.address(), param1);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cAccumBits(@NativeType(value="BYTE") byte param1) {
        PIXELFORMATDESCRIPTOR.ncAccumBits(this.address(), param1);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cAccumRedBits(@NativeType(value="BYTE") byte param1) {
        PIXELFORMATDESCRIPTOR.ncAccumRedBits(this.address(), param1);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cAccumGreenBits(@NativeType(value="BYTE") byte param1) {
        PIXELFORMATDESCRIPTOR.ncAccumGreenBits(this.address(), param1);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cAccumBlueBits(@NativeType(value="BYTE") byte param1) {
        PIXELFORMATDESCRIPTOR.ncAccumBlueBits(this.address(), param1);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cAccumAlphaBits(@NativeType(value="BYTE") byte param1) {
        PIXELFORMATDESCRIPTOR.ncAccumAlphaBits(this.address(), param1);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cDepthBits(@NativeType(value="BYTE") byte param1) {
        PIXELFORMATDESCRIPTOR.ncDepthBits(this.address(), param1);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cStencilBits(@NativeType(value="BYTE") byte param1) {
        PIXELFORMATDESCRIPTOR.ncStencilBits(this.address(), param1);
        return this;
    }

    public PIXELFORMATDESCRIPTOR cAuxBuffers(@NativeType(value="BYTE") byte param1) {
        PIXELFORMATDESCRIPTOR.ncAuxBuffers(this.address(), param1);
        return this;
    }

    public PIXELFORMATDESCRIPTOR iLayerType(@NativeType(value="BYTE") byte param1) {
        PIXELFORMATDESCRIPTOR.niLayerType(this.address(), param1);
        return this;
    }

    public PIXELFORMATDESCRIPTOR bReserved(@NativeType(value="BYTE") byte param1) {
        PIXELFORMATDESCRIPTOR.nbReserved(this.address(), param1);
        return this;
    }

    public PIXELFORMATDESCRIPTOR dwLayerMask(@NativeType(value="DWORD") int param1) {
        PIXELFORMATDESCRIPTOR.ndwLayerMask(this.address(), param1);
        return this;
    }

    public PIXELFORMATDESCRIPTOR dwVisibleMask(@NativeType(value="DWORD") int param1) {
        PIXELFORMATDESCRIPTOR.ndwVisibleMask(this.address(), param1);
        return this;
    }

    public PIXELFORMATDESCRIPTOR dwDamageMask(@NativeType(value="DWORD") int param1) {
        PIXELFORMATDESCRIPTOR.ndwDamageMask(this.address(), param1);
        return this;
    }

    public PIXELFORMATDESCRIPTOR set(short param1, short param2, int param3, byte param4, byte param5, byte param6, byte param7, byte param8, byte param9, byte param10, byte param11, byte param12, byte param13, byte param14, byte param15, byte param16, byte param17, byte param18, byte param19, byte param20, byte param21, byte param22, byte param23, int param24, int param25, int param26) {
        this.nSize(param1);
        this.nVersion(param2);
        this.dwFlags(param3);
        this.iPixelType(param4);
        this.cColorBits(param5);
        this.cRedBits(param6);
        this.cRedShift(param7);
        this.cGreenBits(param8);
        this.cGreenShift(param9);
        this.cBlueBits(param10);
        this.cBlueShift(param11);
        this.cAlphaBits(param12);
        this.cAlphaShift(param13);
        this.cAccumBits(param14);
        this.cAccumRedBits(param15);
        this.cAccumGreenBits(param16);
        this.cAccumBlueBits(param17);
        this.cAccumAlphaBits(param18);
        this.cDepthBits(param19);
        this.cStencilBits(param20);
        this.cAuxBuffers(param21);
        this.iLayerType(param22);
        this.bReserved(param23);
        this.dwLayerMask(param24);
        this.dwVisibleMask(param25);
        this.dwDamageMask(param26);
        return this;
    }

    public PIXELFORMATDESCRIPTOR set(PIXELFORMATDESCRIPTOR param1) {
        MemoryUtil.memCopy(param1.address(), this.address(), SIZEOF);
        return this;
    }

    public static PIXELFORMATDESCRIPTOR malloc() {
        return new PIXELFORMATDESCRIPTOR(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static PIXELFORMATDESCRIPTOR calloc() {
        return new PIXELFORMATDESCRIPTOR(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static PIXELFORMATDESCRIPTOR create() {
        ByteBuffer v0 = BufferUtils.createByteBuffer(SIZEOF);
        return new PIXELFORMATDESCRIPTOR(MemoryUtil.memAddress(v0), v0);
    }

    public static PIXELFORMATDESCRIPTOR create(long param0) {
        return new PIXELFORMATDESCRIPTOR(param0, null);
    }

    @Nullable
    public static PIXELFORMATDESCRIPTOR createSafe(long param0) {
        return param0 == 0L ? null : new PIXELFORMATDESCRIPTOR(param0, null);
    }

    public static Buffer malloc(int param0) {
        return new Buffer(MemoryUtil.nmemAllocChecked(PIXELFORMATDESCRIPTOR.__checkMalloc(param0, SIZEOF)), param0);
    }

    public static Buffer calloc(int param0) {
        return new Buffer(MemoryUtil.nmemCallocChecked(param0, SIZEOF), param0);
    }

    public static Buffer create(int param0) {
        ByteBuffer v1 = PIXELFORMATDESCRIPTOR.__create(param0, SIZEOF);
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
    public static PIXELFORMATDESCRIPTOR mallocStack() {
        return PIXELFORMATDESCRIPTOR.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static PIXELFORMATDESCRIPTOR callocStack() {
        return PIXELFORMATDESCRIPTOR.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static PIXELFORMATDESCRIPTOR mallocStack(MemoryStack param0) {
        return PIXELFORMATDESCRIPTOR.malloc(param0);
    }

    @Deprecated
    public static PIXELFORMATDESCRIPTOR callocStack(MemoryStack param0) {
        return PIXELFORMATDESCRIPTOR.calloc(param0);
    }

    @Deprecated
    public static Buffer mallocStack(int param0) {
        return PIXELFORMATDESCRIPTOR.malloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int param0) {
        return PIXELFORMATDESCRIPTOR.calloc(param0, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int param0, MemoryStack param1) {
        return PIXELFORMATDESCRIPTOR.malloc(param0, param1);
    }

    @Deprecated
    public static Buffer callocStack(int param0, MemoryStack param1) {
        return PIXELFORMATDESCRIPTOR.calloc(param0, param1);
    }

    public static PIXELFORMATDESCRIPTOR malloc(MemoryStack param0) {
        return new PIXELFORMATDESCRIPTOR(param0.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static PIXELFORMATDESCRIPTOR calloc(MemoryStack param0) {
        return new PIXELFORMATDESCRIPTOR(param0.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int param0, MemoryStack param1) {
        return new Buffer(param1.nmalloc(ALIGNOF, param0 * SIZEOF), param0);
    }

    public static Buffer calloc(int param0, MemoryStack param1) {
        return new Buffer(param1.ncalloc(ALIGNOF, param0, SIZEOF), param0);
    }

    public static short nnSize(long param0) {
        return UNSAFE.getShort(null, param0 + (long)NSIZE);
    }

    public static short nnVersion(long param0) {
        return UNSAFE.getShort(null, param0 + (long)NVERSION);
    }

    public static int ndwFlags(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DWFLAGS);
    }

    public static byte niPixelType(long param0) {
        return UNSAFE.getByte(null, param0 + (long)IPIXELTYPE);
    }

    public static byte ncColorBits(long param0) {
        return UNSAFE.getByte(null, param0 + (long)CCOLORBITS);
    }

    public static byte ncRedBits(long param0) {
        return UNSAFE.getByte(null, param0 + (long)CREDBITS);
    }

    public static byte ncRedShift(long param0) {
        return UNSAFE.getByte(null, param0 + (long)CREDSHIFT);
    }

    public static byte ncGreenBits(long param0) {
        return UNSAFE.getByte(null, param0 + (long)CGREENBITS);
    }

    public static byte ncGreenShift(long param0) {
        return UNSAFE.getByte(null, param0 + (long)CGREENSHIFT);
    }

    public static byte ncBlueBits(long param0) {
        return UNSAFE.getByte(null, param0 + (long)CBLUEBITS);
    }

    public static byte ncBlueShift(long param0) {
        return UNSAFE.getByte(null, param0 + (long)CBLUESHIFT);
    }

    public static byte ncAlphaBits(long param0) {
        return UNSAFE.getByte(null, param0 + (long)CALPHABITS);
    }

    public static byte ncAlphaShift(long param0) {
        return UNSAFE.getByte(null, param0 + (long)CALPHASHIFT);
    }

    public static byte ncAccumBits(long param0) {
        return UNSAFE.getByte(null, param0 + (long)CACCUMBITS);
    }

    public static byte ncAccumRedBits(long param0) {
        return UNSAFE.getByte(null, param0 + (long)CACCUMREDBITS);
    }

    public static byte ncAccumGreenBits(long param0) {
        return UNSAFE.getByte(null, param0 + (long)CACCUMGREENBITS);
    }

    public static byte ncAccumBlueBits(long param0) {
        return UNSAFE.getByte(null, param0 + (long)CACCUMBLUEBITS);
    }

    public static byte ncAccumAlphaBits(long param0) {
        return UNSAFE.getByte(null, param0 + (long)CACCUMALPHABITS);
    }

    public static byte ncDepthBits(long param0) {
        return UNSAFE.getByte(null, param0 + (long)CDEPTHBITS);
    }

    public static byte ncStencilBits(long param0) {
        return UNSAFE.getByte(null, param0 + (long)CSTENCILBITS);
    }

    public static byte ncAuxBuffers(long param0) {
        return UNSAFE.getByte(null, param0 + (long)CAUXBUFFERS);
    }

    public static byte niLayerType(long param0) {
        return UNSAFE.getByte(null, param0 + (long)ILAYERTYPE);
    }

    public static byte nbReserved(long param0) {
        return UNSAFE.getByte(null, param0 + (long)BRESERVED);
    }

    public static int ndwLayerMask(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DWLAYERMASK);
    }

    public static int ndwVisibleMask(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DWVISIBLEMASK);
    }

    public static int ndwDamageMask(long param0) {
        return UNSAFE.getInt(null, param0 + (long)DWDAMAGEMASK);
    }

    public static void nnSize(long param0, short param2) {
        UNSAFE.putShort(null, param0 + (long)NSIZE, param2);
    }

    public static void nnVersion(long param0, short param2) {
        UNSAFE.putShort(null, param0 + (long)NVERSION, param2);
    }

    public static void ndwFlags(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)DWFLAGS, param2);
    }

    public static void niPixelType(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)IPIXELTYPE, param2);
    }

    public static void ncColorBits(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)CCOLORBITS, param2);
    }

    public static void ncRedBits(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)CREDBITS, param2);
    }

    public static void ncRedShift(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)CREDSHIFT, param2);
    }

    public static void ncGreenBits(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)CGREENBITS, param2);
    }

    public static void ncGreenShift(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)CGREENSHIFT, param2);
    }

    public static void ncBlueBits(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)CBLUEBITS, param2);
    }

    public static void ncBlueShift(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)CBLUESHIFT, param2);
    }

    public static void ncAlphaBits(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)CALPHABITS, param2);
    }

    public static void ncAlphaShift(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)CALPHASHIFT, param2);
    }

    public static void ncAccumBits(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)CACCUMBITS, param2);
    }

    public static void ncAccumRedBits(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)CACCUMREDBITS, param2);
    }

    public static void ncAccumGreenBits(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)CACCUMGREENBITS, param2);
    }

    public static void ncAccumBlueBits(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)CACCUMBLUEBITS, param2);
    }

    public static void ncAccumAlphaBits(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)CACCUMALPHABITS, param2);
    }

    public static void ncDepthBits(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)CDEPTHBITS, param2);
    }

    public static void ncStencilBits(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)CSTENCILBITS, param2);
    }

    public static void ncAuxBuffers(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)CAUXBUFFERS, param2);
    }

    public static void niLayerType(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)ILAYERTYPE, param2);
    }

    public static void nbReserved(long param0, byte param2) {
        UNSAFE.putByte(null, param0 + (long)BRESERVED, param2);
    }

    public static void ndwLayerMask(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)DWLAYERMASK, param2);
    }

    public static void ndwVisibleMask(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)DWVISIBLEMASK, param2);
    }

    public static void ndwDamageMask(long param0, int param2) {
        UNSAFE.putInt(null, param0 + (long)DWDAMAGEMASK, param2);
    }

    static {
        Struct.Layout v0 = PIXELFORMATDESCRIPTOR.__struct(PIXELFORMATDESCRIPTOR.__member(2), PIXELFORMATDESCRIPTOR.__member(2), PIXELFORMATDESCRIPTOR.__member(4), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(1), PIXELFORMATDESCRIPTOR.__member(4), PIXELFORMATDESCRIPTOR.__member(4), PIXELFORMATDESCRIPTOR.__member(4));
        SIZEOF = v0.getSize();
        ALIGNOF = v0.getAlignment();
        NSIZE = v0.offsetof(0);
        NVERSION = v0.offsetof(1);
        DWFLAGS = v0.offsetof(2);
        IPIXELTYPE = v0.offsetof(3);
        CCOLORBITS = v0.offsetof(4);
        CREDBITS = v0.offsetof(5);
        CREDSHIFT = v0.offsetof(6);
        CGREENBITS = v0.offsetof(7);
        CGREENSHIFT = v0.offsetof(8);
        CBLUEBITS = v0.offsetof(9);
        CBLUESHIFT = v0.offsetof(10);
        CALPHABITS = v0.offsetof(11);
        CALPHASHIFT = v0.offsetof(12);
        CACCUMBITS = v0.offsetof(13);
        CACCUMREDBITS = v0.offsetof(14);
        CACCUMGREENBITS = v0.offsetof(15);
        CACCUMBLUEBITS = v0.offsetof(16);
        CACCUMALPHABITS = v0.offsetof(17);
        CDEPTHBITS = v0.offsetof(18);
        CSTENCILBITS = v0.offsetof(19);
        CAUXBUFFERS = v0.offsetof(20);
        ILAYERTYPE = v0.offsetof(21);
        BRESERVED = v0.offsetof(22);
        DWLAYERMASK = v0.offsetof(23);
        DWVISIBLEMASK = v0.offsetof(24);
        DWDAMAGEMASK = v0.offsetof(25);
    }

    public static class Buffer
    extends StructBuffer<PIXELFORMATDESCRIPTOR, Buffer>
    implements NativeResource {
        private static final PIXELFORMATDESCRIPTOR ELEMENT_FACTORY = PIXELFORMATDESCRIPTOR.create(-1L);

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
        protected PIXELFORMATDESCRIPTOR getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="WORD")
        public short nSize() {
            return PIXELFORMATDESCRIPTOR.nnSize(this.address());
        }

        @NativeType(value="WORD")
        public short nVersion() {
            return PIXELFORMATDESCRIPTOR.nnVersion(this.address());
        }

        @NativeType(value="DWORD")
        public int dwFlags() {
            return PIXELFORMATDESCRIPTOR.ndwFlags(this.address());
        }

        @NativeType(value="BYTE")
        public byte iPixelType() {
            return PIXELFORMATDESCRIPTOR.niPixelType(this.address());
        }

        @NativeType(value="BYTE")
        public byte cColorBits() {
            return PIXELFORMATDESCRIPTOR.ncColorBits(this.address());
        }

        @NativeType(value="BYTE")
        public byte cRedBits() {
            return PIXELFORMATDESCRIPTOR.ncRedBits(this.address());
        }

        @NativeType(value="BYTE")
        public byte cRedShift() {
            return PIXELFORMATDESCRIPTOR.ncRedShift(this.address());
        }

        @NativeType(value="BYTE")
        public byte cGreenBits() {
            return PIXELFORMATDESCRIPTOR.ncGreenBits(this.address());
        }

        @NativeType(value="BYTE")
        public byte cGreenShift() {
            return PIXELFORMATDESCRIPTOR.ncGreenShift(this.address());
        }

        @NativeType(value="BYTE")
        public byte cBlueBits() {
            return PIXELFORMATDESCRIPTOR.ncBlueBits(this.address());
        }

        @NativeType(value="BYTE")
        public byte cBlueShift() {
            return PIXELFORMATDESCRIPTOR.ncBlueShift(this.address());
        }

        @NativeType(value="BYTE")
        public byte cAlphaBits() {
            return PIXELFORMATDESCRIPTOR.ncAlphaBits(this.address());
        }

        @NativeType(value="BYTE")
        public byte cAlphaShift() {
            return PIXELFORMATDESCRIPTOR.ncAlphaShift(this.address());
        }

        @NativeType(value="BYTE")
        public byte cAccumBits() {
            return PIXELFORMATDESCRIPTOR.ncAccumBits(this.address());
        }

        @NativeType(value="BYTE")
        public byte cAccumRedBits() {
            return PIXELFORMATDESCRIPTOR.ncAccumRedBits(this.address());
        }

        @NativeType(value="BYTE")
        public byte cAccumGreenBits() {
            return PIXELFORMATDESCRIPTOR.ncAccumGreenBits(this.address());
        }

        @NativeType(value="BYTE")
        public byte cAccumBlueBits() {
            return PIXELFORMATDESCRIPTOR.ncAccumBlueBits(this.address());
        }

        @NativeType(value="BYTE")
        public byte cAccumAlphaBits() {
            return PIXELFORMATDESCRIPTOR.ncAccumAlphaBits(this.address());
        }

        @NativeType(value="BYTE")
        public byte cDepthBits() {
            return PIXELFORMATDESCRIPTOR.ncDepthBits(this.address());
        }

        @NativeType(value="BYTE")
        public byte cStencilBits() {
            return PIXELFORMATDESCRIPTOR.ncStencilBits(this.address());
        }

        @NativeType(value="BYTE")
        public byte cAuxBuffers() {
            return PIXELFORMATDESCRIPTOR.ncAuxBuffers(this.address());
        }

        @NativeType(value="BYTE")
        public byte iLayerType() {
            return PIXELFORMATDESCRIPTOR.niLayerType(this.address());
        }

        @NativeType(value="BYTE")
        public byte bReserved() {
            return PIXELFORMATDESCRIPTOR.nbReserved(this.address());
        }

        @NativeType(value="DWORD")
        public int dwLayerMask() {
            return PIXELFORMATDESCRIPTOR.ndwLayerMask(this.address());
        }

        @NativeType(value="DWORD")
        public int dwVisibleMask() {
            return PIXELFORMATDESCRIPTOR.ndwVisibleMask(this.address());
        }

        @NativeType(value="DWORD")
        public int dwDamageMask() {
            return PIXELFORMATDESCRIPTOR.ndwDamageMask(this.address());
        }

        public Buffer nSize(@NativeType(value="WORD") short param1) {
            PIXELFORMATDESCRIPTOR.nnSize(this.address(), param1);
            return this;
        }

        public Buffer nVersion(@NativeType(value="WORD") short param1) {
            PIXELFORMATDESCRIPTOR.nnVersion(this.address(), param1);
            return this;
        }

        public Buffer dwFlags(@NativeType(value="DWORD") int param1) {
            PIXELFORMATDESCRIPTOR.ndwFlags(this.address(), param1);
            return this;
        }

        public Buffer iPixelType(@NativeType(value="BYTE") byte param1) {
            PIXELFORMATDESCRIPTOR.niPixelType(this.address(), param1);
            return this;
        }

        public Buffer cColorBits(@NativeType(value="BYTE") byte param1) {
            PIXELFORMATDESCRIPTOR.ncColorBits(this.address(), param1);
            return this;
        }

        public Buffer cRedBits(@NativeType(value="BYTE") byte param1) {
            PIXELFORMATDESCRIPTOR.ncRedBits(this.address(), param1);
            return this;
        }

        public Buffer cRedShift(@NativeType(value="BYTE") byte param1) {
            PIXELFORMATDESCRIPTOR.ncRedShift(this.address(), param1);
            return this;
        }

        public Buffer cGreenBits(@NativeType(value="BYTE") byte param1) {
            PIXELFORMATDESCRIPTOR.ncGreenBits(this.address(), param1);
            return this;
        }

        public Buffer cGreenShift(@NativeType(value="BYTE") byte param1) {
            PIXELFORMATDESCRIPTOR.ncGreenShift(this.address(), param1);
            return this;
        }

        public Buffer cBlueBits(@NativeType(value="BYTE") byte param1) {
            PIXELFORMATDESCRIPTOR.ncBlueBits(this.address(), param1);
            return this;
        }

        public Buffer cBlueShift(@NativeType(value="BYTE") byte param1) {
            PIXELFORMATDESCRIPTOR.ncBlueShift(this.address(), param1);
            return this;
        }

        public Buffer cAlphaBits(@NativeType(value="BYTE") byte param1) {
            PIXELFORMATDESCRIPTOR.ncAlphaBits(this.address(), param1);
            return this;
        }

        public Buffer cAlphaShift(@NativeType(value="BYTE") byte param1) {
            PIXELFORMATDESCRIPTOR.ncAlphaShift(this.address(), param1);
            return this;
        }

        public Buffer cAccumBits(@NativeType(value="BYTE") byte param1) {
            PIXELFORMATDESCRIPTOR.ncAccumBits(this.address(), param1);
            return this;
        }

        public Buffer cAccumRedBits(@NativeType(value="BYTE") byte param1) {
            PIXELFORMATDESCRIPTOR.ncAccumRedBits(this.address(), param1);
            return this;
        }

        public Buffer cAccumGreenBits(@NativeType(value="BYTE") byte param1) {
            PIXELFORMATDESCRIPTOR.ncAccumGreenBits(this.address(), param1);
            return this;
        }

        public Buffer cAccumBlueBits(@NativeType(value="BYTE") byte param1) {
            PIXELFORMATDESCRIPTOR.ncAccumBlueBits(this.address(), param1);
            return this;
        }

        public Buffer cAccumAlphaBits(@NativeType(value="BYTE") byte param1) {
            PIXELFORMATDESCRIPTOR.ncAccumAlphaBits(this.address(), param1);
            return this;
        }

        public Buffer cDepthBits(@NativeType(value="BYTE") byte param1) {
            PIXELFORMATDESCRIPTOR.ncDepthBits(this.address(), param1);
            return this;
        }

        public Buffer cStencilBits(@NativeType(value="BYTE") byte param1) {
            PIXELFORMATDESCRIPTOR.ncStencilBits(this.address(), param1);
            return this;
        }

        public Buffer cAuxBuffers(@NativeType(value="BYTE") byte param1) {
            PIXELFORMATDESCRIPTOR.ncAuxBuffers(this.address(), param1);
            return this;
        }

        public Buffer iLayerType(@NativeType(value="BYTE") byte param1) {
            PIXELFORMATDESCRIPTOR.niLayerType(this.address(), param1);
            return this;
        }

        public Buffer bReserved(@NativeType(value="BYTE") byte param1) {
            PIXELFORMATDESCRIPTOR.nbReserved(this.address(), param1);
            return this;
        }

        public Buffer dwLayerMask(@NativeType(value="DWORD") int param1) {
            PIXELFORMATDESCRIPTOR.ndwLayerMask(this.address(), param1);
            return this;
        }

        public Buffer dwVisibleMask(@NativeType(value="DWORD") int param1) {
            PIXELFORMATDESCRIPTOR.ndwVisibleMask(this.address(), param1);
            return this;
        }

        public Buffer dwDamageMask(@NativeType(value="DWORD") int param1) {
            PIXELFORMATDESCRIPTOR.ndwDamageMask(this.address(), param1);
            return this;
        }
    }
}

