/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderPass
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.gl.RenderPipelines
 *  org.lwjgl.opengl.GL33C
 */
package clap.render;

import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import java.security.Key;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.RenderPipelines;
import org.lwjgl.nanovg.NVGColor;
import org.lwjgl.nanovg.NVGPaint;
import org.lwjgl.nanovg.NanoVG;
import org.lwjgl.nanovg.NanoVGGL3;
import org.lwjgl.opengl.GL33C;
import clap.config.ConfigSupport_00O0;
import clap.core.NativeEntrypointBridge;
import clap.render.RenderSupport_oooo_2;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from clap.nativeapi.Kernel32SnapshotApii
 */
public final class RenderSupport_00oi_0 {
    private static final List OOi;
    private static boolean O0i;
    public static final NVGPaint OOo;
    private static final NVGColor HelpCommand;
    private static int OoO;
    private static boolean O0o;
    private static boolean HudElement;
    private static int Oo0;
    private static boolean EventBusApi;
    public static final NVGPaint GuiSupport_OOI;
    private static boolean ConfigSupport_O0I;
    private static long PacketEvent;
    private static boolean Ooo;
    static Object OoI;

    public static boolean Oii() {
        return O0i;
    }

    public static boolean OiI() {
        return ConfigSupport_O0I;
    }

    public static void O0i(float param0, float param1, float param2, float param3, float param4, float param5, float param6, float param7, float param8, int param9) {
        if (!HudElement) {
            return;
        }
        RenderSupport_00oi_0.ConfigSupport_0OO(param9);
        NanoVG.nvgBeginPath(PacketEvent);
        NanoVG.nvgStrokeColor(PacketEvent, HelpCommand);
        NanoVG.nvgStrokeWidth(PacketEvent, param8);
        NanoVG.nvgRoundedRectVarying(PacketEvent, param0, param1, param2, param3, param4, param5, param6, param7);
        NanoVG.nvgStroke(PacketEvent);
        NanoVG.nvgClosePath(PacketEvent);
    }

    public static void ConfigSupport_OI0(float param0, float param1, float param2, float param3) {
        if (!HudElement) {
            return;
        }
        NanoVG.nvgSave(PacketEvent);
        NanoVG.nvgScissor(PacketEvent, param0, param1, param2, param3);
    }

    public static void EventBusApi() {
        if (OOi.isEmpty()) {
            return;
        }
        ArrayList v0 = new ArrayList(OOi);
        OOi.clear();
        v0.forEach(Runnable::run);
    }

    public static void Ooo(float param0, float param1, float param2, float param3, float param4, float param5, float param6, float param7, NVGPaint param8) {
        if (!HudElement) {
            return;
        }
        NanoVG.nvgBeginPath(PacketEvent);
        NanoVG.nvgFillPaint(PacketEvent, param8);
        NanoVG.nvgRoundedRectVarying(PacketEvent, param0, param1, param2, param3, param4, param5, param6, param7);
        NanoVG.nvgFill(PacketEvent);
        NanoVG.nvgClosePath(PacketEvent);
    }

    public static NVGColor HelpCommand() {
        return HelpCommand;
    }

    private static boolean DataRecord_0O0() {
        if (PacketEvent != 0L) {
            return true;
        }
        try {
            PacketEvent = NanoVGGL3.nvgCreate(3);
            if (!O0o) {
                NativeEntrypointBridge.OOo.info("[NVG] context create result={}", (Object)PacketEvent);
                O0o = true;
            }
            return PacketEvent != 0L;
        }
        catch (IllegalStateException illegalStateException) {
            if (!EventBusApi) {
                NativeEntrypointBridge.OOo.warn("[NVG] GL capabilities are not ready yet");
                EventBusApi = true;
            }
            return false;
        }
    }

    public static void Oi0() {
        RenderSupport_00oi_0.Oio(OOo);
        RenderSupport_00oi_0.Oio(GuiSupport_OOI);
    }

    public static void ConfigSupport_O0I(float param0, float param1, float param2, float param3, float param4, float param5, int param6) {
        if (!HudElement) {
            return;
        }
        RenderSupport_00oi_0.ConfigSupport_0OO(param6);
        NanoVG.nvgBeginPath(PacketEvent);
        NanoVG.nvgStrokeColor(PacketEvent, HelpCommand);
        NanoVG.nvgStrokeWidth(PacketEvent, param5);
        NanoVG.nvgRoundedRect(PacketEvent, param0, param1, param2, param3, param4);
        NanoVG.nvgStroke(PacketEvent);
        NanoVG.nvgClosePath(PacketEvent);
    }

    public static void GuiSupport_OOI() {
        RenderSupport_00oi_0.OOi(true);
    }

    private RenderSupport_00oi_0() {
    }

    public static void ConfigSupport_OII(float param0, float param1, float param2) {
        if (!HudElement) {
            return;
        }
        NanoVG.nvgSave(PacketEvent);
        NanoVG.nvgTranslate(PacketEvent, param0, param1);
        NanoVG.nvgScale(PacketEvent, param2, param2);
        NanoVG.nvgTranslate(PacketEvent, -param0, -param1);
    }

    public static void KeystrokesHudElement(float param0, float param1, float param2, float param3, float param4, int param5) {
        if (!HudElement) {
            return;
        }
        RenderSupport_00oi_0.ConfigSupport_0OO(param5);
        NanoVG.nvgBeginPath(PacketEvent);
        NanoVG.nvgStrokeColor(PacketEvent, HelpCommand);
        NanoVG.nvgStrokeWidth(PacketEvent, param4);
        NanoVG.nvgRect(PacketEvent, param0, param1, param2, param3);
        NanoVG.nvgStroke(PacketEvent);
        NanoVG.nvgClosePath(PacketEvent);
    }

    public static void O0o(float param0, float param1, float param2, float param3, float param4, int param5) {
        if (!HudElement) {
            return;
        }
        RenderSupport_00oi_0.ConfigSupport_0OO(param5);
        NanoVG.nvgBeginPath(PacketEvent);
        NanoVG.nvgFillColor(PacketEvent, HelpCommand);
        NanoVG.nvgRoundedRect(PacketEvent, param0, param1, param2, param3, param4);
        NanoVG.nvgFill(PacketEvent);
        NanoVG.nvgClosePath(PacketEvent);
    }

    public static void RenderSupport_oii_4() {
        if (!HudElement) {
            return;
        }
        NanoVG.nvgRestore(PacketEvent);
    }

    public static void OIo() {
        if (!HudElement) {
            return;
        }
        NanoVG.nvgRestore(PacketEvent);
    }

    public static void OiO(int param0, int param1, float param2, float param3, String param4, NVGPaint param5) {
        if (!RenderSupport_00oi_0.DataRecord_0O0()) {
            return;
        }
        try {
            int v6 = Integer.parseInt(param4);
            RenderSupport_00oi_0.Oio(param5);
            int v7 = NanoVGGL3.nvglCreateImageFromHandle(PacketEvent, v6, param0, param1, 8);
            if (v7 == 0) {
                if (param5 == OOo) {
                    ConfigSupport_O0I = false;
                }
                if (param5 == GuiSupport_OOI) {
                    O0i = false;
                }
                return;
            }
            NanoVG.nvgImagePattern(PacketEvent, 0.0f, 0.0f, param2, param3, 0.0f, v7, 1.0f, param5);
            if (param5 == OOo) {
                OoO = v7;
            }
            if (param5 == GuiSupport_OOI) {
                Oo0 = v7;
            }
            if (param5 == OOo) {
                ConfigSupport_O0I = true;
            }
            if (param5 == GuiSupport_OOI) {
                O0i = true;
            }
        }
        catch (NumberFormatException numberFormatException) {
            if (param5 == OOo) {
                ConfigSupport_O0I = false;
            }
            if (param5 == GuiSupport_OOI) {
                O0i = false;
            }
        }
        catch (Throwable v6) {
            if (param5 == OOo) {
                ConfigSupport_O0I = false;
            }
            if (param5 == GuiSupport_OOI) {
                O0i = false;
            }
            RenderSupport_00oi_0.0Oo("create texture paint", v6);
        }
    }

    public static long PacketEvent() {
        return PacketEvent;
    }

    private static void 0Oo(String param0, Throwable param1) {
        try {
            RenderSupport_00oi_0.Oio(OOo);
            RenderSupport_00oi_0.Oio(GuiSupport_OOI);
            if (PacketEvent != 0L) {
                NanoVGGL3.nvgDelete(PacketEvent);
            }
        }
        catch (Throwable throwable) {
        }
        finally {
            PacketEvent = 0L;
            OoO = 0;
            Oo0 = 0;
            ConfigSupport_O0I = false;
            O0i = false;
            HudElement = false;
            Ooo = false;
            O0o = false;
        }
        NativeEntrypointBridge.OOo.warn("[NVG] Context invalidated during {}", (Object)param0, (Object)param1);
    }

    private static void Oio(NVGPaint param0) {
        if (PacketEvent == 0L) {
            return;
        }
        if (param0 == OOo && OoO != 0) {
            NanoVG.nvgDeleteImage(PacketEvent, OoO);
            OoO = 0;
            ConfigSupport_O0I = false;
        }
        if (param0 == GuiSupport_OOI && Oo0 != 0) {
            NanoVG.nvgDeleteImage(PacketEvent, Oo0);
            Oo0 = 0;
            O0i = false;
        }
    }

    public static boolean OOo(float param0, float param1, float param2) {
        if (HudElement) {
            return false;
        }
        if (!RenderSupport_00oi_0.DataRecord_0O0()) {
            return false;
        }
        ConfigSupport_00O0.PacketEvent();
        try {
            float v3 = param2 <= 0.0f ? 1.0f : param2;
            NanoVG.nvgBeginFrame(PacketEvent, param0 * v3, param1 * v3, 1.0f);
            NanoVG.nvgSave(PacketEvent);
            NanoVG.nvgTranslate(PacketEvent, 0.0f, 0.0f);
            NanoVG.nvgScale(PacketEvent, v3, v3);
            NanoVG.nvgTranslate(PacketEvent, 0.0f, 0.0f);
            Ooo = true;
            HudElement = true;
            return true;
        }
        catch (Throwable v3) {
            if (Ooo) {
                try {
                    NanoVG.nvgRestore(PacketEvent);
                }
                catch (Throwable throwable) {}
                Ooo = false;
            }
            ConfigSupport_00O0.HelpCommand();
            RenderSupport_00oi_0.0Oo("begin frame", v3);
            return false;
        }
    }

    public static void HudElement(Runnable param0) {
        if (param0 == null) {
            return;
        }
        OOi.add(param0);
    }

    public static void OOi(boolean param0) {
        block14: {
            if (!HudElement || PacketEvent == 0L) {
                return;
            }
            try {
                if (Ooo) {
                    NanoVG.nvgRestore(PacketEvent);
                    Ooo = false;
                }
                if (!param0 || RenderSupport_oooo_2.isWriting()) {
                    NanoVG.nvgEndFrame(PacketEvent);
                    break block14;
                }
                Framebuffer v1 = MinecraftClient.getInstance().getFramebuffer();
                try (RenderPass v2 = RenderSystem.getDevice().createCommandEncoder().createRenderPass(() -> "clap/nvg", v1.getColorAttachmentView(), OptionalInt.empty(), v1.useDepthAttachment ? v1.getDepthAttachmentView() : null, OptionalDouble.empty());){
                    v2.setPipeline(RenderPipelines.GUI);
                    NanoVG.nvgEndFrame(PacketEvent);
                }
            }
            catch (Throwable v1) {
                RenderSupport_00oi_0.0Oo("end frame", v1);
            }
            finally {
                ConfigSupport_00O0.HelpCommand();
                GL33C.glViewport((int)0, (int)0, (int)MinecraftClient.getInstance().getWindow().getFramebufferWidth(), (int)MinecraftClient.getInstance().getWindow().getFramebufferHeight());
                HudElement = false;
            }
        }
    }

    public static void ConfigSupport_0OO(int param0) {
        float v1 = (float)(param0 >>> 24 & 0xFF) / 255.0f;
        float v2 = (float)(param0 >>> 16 & 0xFF) / 255.0f;
        float v3 = (float)(param0 >>> 8 & 0xFF) / 255.0f;
        float v4 = (float)(param0 & 0xFF) / 255.0f;
        NanoVG.nvgRGBAf(v2, v3, v4, v1, HelpCommand);
    }

    public static void Ooi(float param0, float param1, float param2, float param3, int param4) {
        if (!HudElement) {
            return;
        }
        RenderSupport_00oi_0.ConfigSupport_0OO(param4);
        NanoVG.nvgBeginPath(PacketEvent);
        NanoVG.nvgFillColor(PacketEvent, HelpCommand);
        NanoVG.nvgRect(PacketEvent, param0, param1, param2, param3);
        NanoVG.nvgFill(PacketEvent);
        NanoVG.nvgClosePath(PacketEvent);
    }

    static {
        byte[] v0 = "V~\u00fd\u00ab\u00c6\u00b0\u0086E\u00faVwl*\u0004G\u00b7\u00f9\u000b\u00a7\r8;\u00d7\u00ff\u0092f\u00e9-\f\u00c3U\u0010\u0086\u00a2\u009a8\u00e8U\u00e1I\u00d3\u00dc-h0\u00c4\u0093l\u00d6\u00daf\u00a2\u00d6\u0081\u009e#./L\u00e4dZ\u00c7s\u00b1\u0086\u00abk\u009fC\u0018\u00ec%+\u0015\u00fb\u00e8D0\u00b3G\u00cf\u00e0ZsW73\u009e_\u0011\u00b5C\u009c\u00af\u00fc$\u00ae\u00cd\u0089\u0004\u009b\u008cC\u00de<\u00beSby\u0017\u00f94\u0001\u00bep=J\"\u00b2d_\u00a8\u0014C\u008d\u00b2\fb\u00fc\u00af\u00ca\u0007\u00e6<\u00de\u00fd\u00ed~{\u00d5PK\u0088\u00b7\u0086\r-\u0001\u00bd\u00e8P^\u00a8\u0001\u00e2-\u00f9\u00a4\u00a6\u00f4%\u00e0\u00af\u00b6DM\u0090\u008bo\u0091\n\u00fb\u008bu\u00e8\u00b1?+b\u0091\u0004\u0001\u00d1\u00b5\u00f1\u00b0\u00c6\u009f\u00c8oU\u00d1=\u00a1\u00d8\u00baBM\u0014".getBytes("ISO_8859_1");
        Object[] v1 = "\u00c4\u00b8t\u00ee\u00a7J(\u00ab".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -207886733;
                case 1 -> -1069679115;
                case 2 -> -65815932;
                case 3 -> -800605758;
                case 4 -> 1747040717;
                case 5 -> -1786904599;
                case 6 -> -1054174811;
                case 7 -> 1814344444;
                case 8 -> -1029191986;
                case 9 -> 289787243;
                case 10 -> 386242433;
                case 11 -> 230320906;
                case 12 -> -1457160162;
                case 13 -> 1687790305;
                case 14 -> -888579412;
                case 15 -> -1935762569;
                case 16 -> -831246861;
                case 17 -> 268473619;
                case 18 -> -99904685;
                case 19 -> 1851056016;
                case 20 -> 1758204781;
                case 21 -> -990750331;
                case 22 -> 1055704261;
                case 23 -> 963549911;
                case 24 -> 477688080;
                case 25 -> 1012005470;
                case 26 -> 1289395086;
                case 27 -> -2069576681;
                case 28 -> -24753954;
                case 29 -> 1636155046;
                case 30 -> 609829340;
                case 31 -> 370734269;
                case 32 -> -1339541352;
                case 33 -> -1643401630;
                case 34 -> 1668282459;
                case 35 -> -336839325;
                case 36 -> 1420688133;
                case 37 -> -1418892114;
                case 38 -> -1338527972;
                case 39 -> 1395632822;
                case 40 -> 85405192;
                case 41 -> -1066577733;
                case 42 -> -1613734220;
                case 43 -> 1578860483;
                case 44 -> -1506439729;
                case 45 -> 225576084;
                case 46 -> -1666420440;
                case 47 -> -2085127126;
                case 48 -> -1395079732;
                case 49 -> -1697313223;
                case 50 -> 1819246463;
                case 51 -> -84949255;
                case 52 -> 1864004294;
                case 53 -> -1123288091;
                case 54 -> -242217660;
                case 55 -> 1320633378;
                case 56 -> 1857851127;
                case 57 -> 1844127317;
                case 58 -> 1707227107;
                case 59 -> -1584297149;
                case 60 -> 1592576437;
                case 61 -> 448545636;
                case 62 -> 2049662205;
                case 63 -> 1508612640;
                case 64 -> 467901243;
                case 65 -> 2077372496;
                case 66 -> -675462566;
                case 67 -> 1330387165;
                case 68 -> -184677208;
                case 69 -> 652654197;
                case 70 -> 1461274770;
                case 71 -> -1344746785;
                case 72 -> 1717401330;
                case 73 -> 153498395;
                case 74 -> -901608990;
                case 75 -> 1865967576;
                case 76 -> 235457557;
                case 77 -> 1268276779;
                case 78 -> 1433412596;
                case 79 -> 817175564;
                case 80 -> 1849631038;
                case 81 -> 1138006102;
                case 82 -> 1975448870;
                case 83 -> -403354465;
                case 84 -> 325286846;
                case 85 -> -1629256191;
                case 86 -> -158039421;
                case 87 -> 1390766603;
                case 88 -> 1676029775;
                case 89 -> -2078876396;
                case 90 -> 528145104;
                case 91 -> 2110191369;
                case 92 -> -1408217536;
                case 93 -> -860120066;
                case 94 -> 1582804526;
                case 95 -> -1794767594;
                case 96 -> -1831212815;
                case 97 -> -619044218;
                case 98 -> 190771013;
                case 99 -> -793263591;
                case 100 -> -935582648;
                case 101 -> 175824932;
                case 102 -> -1354521015;
                case 103 -> -2001080604;
                case 104 -> 1694267818;
                case 105 -> 169707186;
                case 106 -> 1731189095;
                case 107 -> -678146740;
                case 108 -> -1610710206;
                case 109 -> -780406053;
                case 110 -> -1221152144;
                case 111 -> 1253727313;
                case 112 -> 1912487453;
                case 113 -> -871280894;
                case 114 -> -779993247;
                case 115 -> 970781341;
                case 116 -> -965957469;
                case 117 -> -1586424096;
                case 118 -> 816872576;
                case 119 -> -1847553893;
                case 120 -> 2068124794;
                case 121 -> -754916263;
                case 122 -> 1693022137;
                case 123 -> 1409711802;
                case 124 -> -1034837454;
                case 125 -> -1235001318;
                case 126 -> 1198704900;
                case 127 -> 1008992102;
                case 128 -> 1220132151;
                case 129 -> -103704120;
                case 130 -> -31278419;
                case 131 -> 44319186;
                case 132 -> -1239581194;
                case 133 -> 1904452113;
                case 134 -> -2124958590;
                case 135 -> 1707525677;
                case 136 -> -1221765431;
                case 137 -> -232764677;
                case 138 -> -901844676;
                case 139 -> -1974112456;
                case 140 -> -2132967641;
                case 141 -> 792146762;
                case 142 -> -1501593167;
                case 143 -> -1540722479;
                case 144 -> -313992087;
                case 145 -> 625459572;
                case 146 -> 135072705;
                case 147 -> 328190574;
                case 148 -> 1783592448;
                case 149 -> 1745517906;
                case 150 -> -969409877;
                case 151 -> -217640435;
                case 152 -> -1741112463;
                case 153 -> -1764099729;
                case 154 -> 1313269039;
                case 155 -> 983672694;
                case 156 -> -597552517;
                case 157 -> 1165189240;
                case 158 -> 4155047;
                case 159 -> 1073653962;
                case 160 -> 1166441567;
                case 161 -> 1444290559;
                case 162 -> -1774009539;
                case 163 -> 629486739;
                case 164 -> -457943302;
                case 165 -> 1183672082;
                case 166 -> 1279591304;
                case 167 -> 1170658495;
                case 168 -> 1808954091;
                case 169 -> 1931834160;
                case 170 -> -1054123176;
                case 171 -> 1784618620;
                case 172 -> 954601291;
                case 173 -> 741984876;
                case 174 -> 331946502;
                case 175 -> -1788681788;
                case 176 -> 2019524535;
                case 177 -> 2083058112;
                case 178 -> 1275095687;
                case 179 -> -759006167;
                case 180 -> 1087071371;
                case 181 -> 659373973;
                case 182 -> 348036762;
                case 183 -> 1093147537;
                case 184 -> 1134750812;
                case 185 -> 1029818986;
                case 186 -> 1826741642;
                case 187 -> -1324086009;
                case 188 -> 970289176;
                case 189 -> 783654382;
                case 190 -> -1383047627;
                case 191 -> -1702465499;
                case 192 -> -1555411482;
                case 193 -> -553734216;
                case 194 -> -496530039;
                case 195 -> 245811872;
                case 196 -> -549325904;
                case 197 -> 1992379956;
                case 198 -> 1701561839;
                case 199 -> -657493852;
                case 200 -> 1818849933;
                case 201 -> -2108166849;
                case 202 -> 1409778631;
                case 203 -> 1919664186;
                case 204 -> 585369837;
                case 205 -> 1039307535;
                case 206 -> 1039345934;
                case 207 -> 1282771833;
                case 208 -> 482504659;
                case 209 -> 799299234;
                case 210 -> 1087164885;
                case 211 -> 1632584014;
                case 212 -> 1788344413;
                case 213 -> -2029480105;
                case 214 -> 498708001;
                case 215 -> -142758425;
                case 216 -> -1906724959;
                case 217 -> 1014037302;
                case 218 -> 534839421;
                case 219 -> 43868786;
                case 220 -> 1991512680;
                case 221 -> -483898068;
                case 222 -> 1831514627;
                case 223 -> 18686036;
                case 224 -> -1933043238;
                case 225 -> 1382398620;
                case 226 -> -2069233428;
                case 227 -> -2079864167;
                case 228 -> -1912039067;
                case 229 -> 575613280;
                case 230 -> -776022719;
                case 231 -> 2143143672;
                case 232 -> -537050165;
                case 233 -> -450849604;
                case 234 -> -830556089;
                case 235 -> -232337357;
                case 236 -> -868171308;
                case 237 -> -1686528337;
                case 238 -> -845119074;
                case 239 -> -2115854352;
                case 240 -> 1684257449;
                case 241 -> 892459404;
                case 242 -> 708058070;
                case 243 -> 999287219;
                case 244 -> 2008464163;
                case 245 -> -1054379906;
                case 246 -> -333311015;
                case 247 -> 329686559;
                case 248 -> 345592369;
                case 249 -> -175954618;
                case 250 -> 1912917738;
                case 251 -> -35952497;
                case 252 -> 336384407;
                case 253 -> -500704362;
                case 254 -> 229081933;
                case 255 -> 1003475176;
                default -> 2100137548;
            });
        } while (v2 != 200);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(2, (Key)SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec((byte[])v1)), new IvParameterSpec(new byte[8]));
        v0 = cipher.doFinal(v0);
        int v3 = v0.length;
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.reset();
        v2 = v3 - 32;
        messageDigest.update(v0, 0, v2);
        v1 = messageDigest.digest();
        int v4 = 0;
        int v52 = 0;
        int v6 = 0;
        do {
            v52 |= v0[v2 + v4] ^ v1[v4];
        } while (++v4 != 32);
        if (v52 == 0) {
            Object[] objectArray = new Object[7];
            v1 = objectArray;
            OoI = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        HelpCommand = NVGColor.create();
        OOo = NVGPaint.create();
        GuiSupport_OOI = NVGPaint.create();
        OOi = new ArrayList();
    }

    public static void OoI(float param0, float param1, float param2, float param3, NVGPaint param4) {
        if (!HudElement) {
            return;
        }
        NanoVG.nvgBeginPath(PacketEvent);
        NanoVG.nvgFillPaint(PacketEvent, param4);
        NanoVG.nvgRect(PacketEvent, param0, param1, param2, param3);
        NanoVG.nvgFill(PacketEvent);
        NanoVG.nvgClosePath(PacketEvent);
    }

    public static void Oo0(float param0, float param1, float param2, float param3, float param4, NVGPaint param5) {
        if (!HudElement) {
            return;
        }
        NanoVG.nvgBeginPath(PacketEvent);
        NanoVG.nvgFillPaint(PacketEvent, param5);
        NanoVG.nvgRoundedRect(PacketEvent, param0, param1, param2, param3, param4);
        NanoVG.nvgFill(PacketEvent);
        NanoVG.nvgClosePath(PacketEvent);
    }

    public static void OoO(float param0, float param1, float param2, float param3, float param4, float param5, float param6, float param7, int param8) {
        if (!HudElement) {
            return;
        }
        RenderSupport_00oi_0.ConfigSupport_0OO(param8);
        NanoVG.nvgBeginPath(PacketEvent);
        NanoVG.nvgFillColor(PacketEvent, HelpCommand);
        NanoVG.nvgRoundedRectVarying(PacketEvent, param0, param1, param2, param3, param4, param5, param6, param7);
        NanoVG.nvgFill(PacketEvent);
        NanoVG.nvgClosePath(PacketEvent);
    }
}

