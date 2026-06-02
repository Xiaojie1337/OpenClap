/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.mojang.blaze3d.buffers.GpuBuffer
 *  com.mojang.blaze3d.buffers.Std140Builder
 *  com.mojang.blaze3d.buffers.Std140SizeCalculator
 *  com.mojang.blaze3d.systems.CommandEncoder
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.serialization.DynamicOps
 *  com.mojang.serialization.JsonOps
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.gl.PostEffectPipeline
 *  net.minecraft.client.gl.PostEffectProcessor
 *  net.minecraft.client.gl.ShaderLoader
 *  net.minecraft.client.gl.SimpleFramebuffer
 *  net.minecraft.client.render.ProjectionMatrix2
 *  net.minecraft.client.texture.TextureManager
 *  net.minecraft.client.util.ObjectAllocator
 *  net.minecraft.client.util.Pool
 *  net.minecraft.resource.Resource
 *  net.minecraft.util.Identifier
 *  net.minecraft.util.StrictJsonParser
 */
package clap.render;

import com.google.gson.JsonElement;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.Std140Builder;
import com.mojang.blaze3d.buffers.Std140SizeCalculator;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.JsonOps;
import java.io.BufferedReader;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.security.Key;
import java.security.MessageDigest;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.PostEffectPipeline;
import net.minecraft.client.gl.PostEffectProcessor;
import net.minecraft.client.gl.ShaderLoader;
import net.minecraft.client.gl.SimpleFramebuffer;
import net.minecraft.client.render.ProjectionMatrix2;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.client.util.ObjectAllocator;
import net.minecraft.client.util.Pool;
import net.minecraft.resource.Resource;
import net.minecraft.util.Identifier;
import net.minecraft.util.StrictJsonParser;
import org.lwjgl.system.MemoryStack;
import clap.mixin.PostEffectPassAccessor;
import clap.mixin.ShaderLoaderAccessor;
import clap.mixin.PostEffectProcessorAccessor;
import clap.module.render.PostProcessingModule;
import clap.render.RenderSupport_00oi_0;
import clap.core.NativeEntrypointBridge;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from clap.model.DataRecord_00Ii
 */
public final class RenderSupport_00ii_0 {
    private static final long EventBusApi;
    private static final long HudElement;
    private static final Identifier HelpCommand;
    private static int KeystrokesHudElement;
    private static PostEffectProcessor Oo0;
    private static PostEffectProcessor OoO;
    private static SimpleFramebuffer O0i;
    private static boolean Oii;
    private static final int OOi;
    private static final Pool GuiSupport_OOI;
    private static long ConfigSupport_0OO;
    private static SimpleFramebuffer ConfigSupport_O0I;
    private static boolean Oi0;
    private static final Pool OOo;
    private static boolean OiI;
    private static boolean Oio;
    private static int RenderSupport_oii_4;
    private static int 0Oo;
    private static int OIo;
    private static final MinecraftClient PacketEvent;
    private static long DataRecord_0O0;
    private static int Ooi;
    private static final String O0o;
    private static boolean Ooo;
    private static boolean OoI;
    private static int ConfigSupport_OI0;
    private static int ConfigSupport_OII;
    private static int OiO;
    static Object EnumType_0OI;
    private static volatile /* synthetic */ long __k__gH4it;

    private static void ConfigSupport_OI0(PostEffectProcessor param0, int param1, boolean param2) {
        int v132;
        if (param0 == null || Ooo) {
            return;
        }
        int n = v132 = param2 ? KeystrokesHudElement : Ooi;
        if (v132 == param1) {
            return;
        }
        try {
            List v4 = ((PostEffectProcessorAccessor)param0).clap$getPasses();
            for (int v5 = 0; v5 < v4.size(); ++v5) {
                ByteBuffer v11;
                float v9;
                Map v6 = ((PostEffectPassAccessor)v4.get(v5)).clap$getCustomUniforms();
                GpuBuffer v7 = (GpuBuffer)v6.get("BlurConfig");
                if (v7 == null) continue;
                float v8 = (v5 & 1) == 0 ? 1.0f : 0.0f;
                float f = v9 = (v5 & 1) == 0 ? 0.0f : 1.0f;
                if ((v7.usage() & 8) == 0 || v7.isClosed()) {
                    int v10 = v5;
                    v11 = RenderSupport_00ii_0.Oii(v8, v9, param1);
                    GpuBuffer v12 = RenderSystem.getDevice().createBuffer(() -> "Clap BlurConfig " + v10, 136, v11);
                    if (!v7.isClosed()) {
                        v7.close();
                    }
                    v6.put("BlurConfig", v12);
                    continue;
                }
                try (MemoryStack v10 = MemoryStack.stackPush();){
                    v11 = Std140Builder.onStack((MemoryStack)v10, (int)OOi).putVec2(v8, v9).putFloat((float)param1).get();
                    RenderSystem.getDevice().createCommandEncoder().writeToBuffer(v7.slice(), v11);
                    continue;
                }
            }
            if (param2) {
                KeystrokesHudElement = param1;
            } else {
                Ooi = param1;
            }
        }
        catch (Throwable v132) {
            Ooo = true;
            RenderSupport_00ii_0.0Oo("Failed to update blur uniforms", v132);
        }
    }

    private static void OiI() {
        RenderSupport_00ii_0.Oi0();
        RenderSupport_00ii_0.Oio();
    }

    static {
        __k__gH4it = RenderSupport_00ii_0.__k__gH4it((long)5874705533981683217L);
        __rP__gH4it0 = new String[]{"\u74e0\uddfa\u03bf\u5636\ud18a\udd5b\u7bfd\u015d\u7524\udcab\u0217\u5717\ud00d\udc9d\u7b22\u02fe\u763a\udf4e\u01f9\u54db\ud357\udf20\u7835\u0397\u774b\ude45-\u55f7\ud2d3\ude6b\u79f5\u0428\u709e\ud9e6\u07fa\u52d7\ud5dc\ud912\u7ecb\u0567\u7199\ud8e3\u068e\u53b8\ud4af\ud8b5\u7f95\u050b\u724d\udbd1\u0568\u505e\ud71f\udb66\u7cd9\u0634\u7397\uda7d\u0413\u5100\ud61e\uda89\u7d99\u071d\u7c86\ud5e7\u0bfe\u5e98\ud97e\ud5c4\u72df\u0801\u7d21\ud44f\u0a4f\u5fdf\ud844\ud467\u73d4\u0935\u7d32\ud7a1\u09ee\u5c0b\udb92\ud71c\u706e\u0abf\u7e76\ud695\u0892\u5d13\udafa\ud6b0\u71e6\u0b79\u7f8a\ud192\u0fb3\u5a5f\udd2c\ud1fe\u76ee\u0c49\u785e\ud097\u0e6f\u5b8c\udc5f\ud072\u772e\u0df7\u79a3\ud03c\u0d6c\u5895\udf4e\ud33a\u7411\u0e7b\u7aee\ud38a\u0c55\u59ca\udedb\ud236\u75bf\u0f5b\u7bf8\ud288\u1330\u466e\uc119\ucd9c\u6a68\u1076\u6414\ucd99\u13d4\u475a\uc0b5\ucc8f\u6b88\u1177\u65bf\ucc5d\u1246\u4440\uc3c4\ucfcc\u6876\u125d\u6653\ucf89\u11f9\u452a\uc2dd\uce03\u698e\u1395\u67f0\uce39\u10d3\u428a\uc5af\uc99b\u6e08\u1448\u60b5\uc94f\u171b\u429a\uc4e4\uc8c3\u6fda\u1543\u61c2\uc8cc\u16a8\u433f\uc7b5\ucb56\u6cbe\u1675\u62ee\ucb0c\u15ff\u4072\uc669\uca52\u6d0d\u17c1\u636e\ucace\u14f5\u418f\uc971\uc5d9\u62e8\u1809\u6cf7\uc5a3\u1b9a\u4ef2\uc9cc\uc429\u6315\u1949\u6d9e\uc479\u1a22\u4f62\uc840\uc7d6\u60b0\u1a46\u6ed5\uc743\u1954\u4c6b\ucb23\uc6dd\u615b\u1b74\u6f34\uc6a7\u188d\u4df5\uca50\uc147\u66f7\u1cab\u6856\uc1b7\u1f2a\u4a10\ucd9c\uc16c\u67e2\u1d01\u6903\uc014\u1e85\u4b3b\ucc60\uc09d\u64c1\u1ebc\u6ad0\uc369\u1ddf\u4869\ucf05\uc3ac\u65ce\u1f98\u6bda\uc29d\u1cee\u49de\uced2\uc272\u5a84\u2078\u5423\ufdf9\u238e\u767a\uf184\ufdb3\u5ac1\u219b\u5543\ufc7c\u2258\u77b4\uf0dd\ufc05\u5b14\u2217\u5656\uffcf\u21d8\u749a\uf31a\uff19\u5875\u23d2\u5778\ufeb7\u20a5\u7571\uf257\ufe21\u5924\u2476\u5099\uf9db\u27b0\u72d6\uf58e\uf9ef\u5e76\u2462\u51f3\uf8fe\u2683\u732c\uf4f0\uf8f2\u5f4e\u2562\u5206\ufb41\u254c\u703a\uf75e\ufb03\u5caf\u26c5\u5394\ufa65\u24ef\u71f7\uf69a\ufaec\u5d97\u2763\u5c61\uf5c4\u2b55\u7e73\uf95e\uf5ac\u5208\u283f\u5c1f\uf438\u2a6d\u7f2f\uf85e\uf4d4\u536c\u29cc", "\u757c\udc1e\u02ca\u572b\ud0f8\udc5c\u7b3c\u01b0\u7662\udf74", "\u7569\udc12\u02ca\u575e\ud0e1"};
        __rP__gH4it1 = new String[]{"\u7582\udc19\u023a\u57f6\ud05e\udc31\u7b55\u01d9"};
        __rP__gH4it2 = new String[]{"\u756a\udc11\u02b1\u5772\ud068\udc0f\u7b25\u018f\u7586\udf27\u01a9\u5406\ud316\udf15\u780f\u02cc\u76ba\ude0d\u009c\u552a"};
        __rP__gH4it3 = new String[]{"\u757e\udc10\u02c4\u5729\ud0fa\udc5a\u7b3a\u01b2\u7660\udf6a", "\u757c\udc07\u02db", "\u756c\udc13\u02d2\u5743\ud0e8\udc4f\u7b21"};
        byte[] v0 = "\u0086\u00e6\u00e5\u0093\u0019n#\u0005J\u00bf\u00b5\u008a\u00e6\u0090\u0004\u009e,bSN\u00b4%\u001b\u00ffUa\u009fz(v\u00c3X\u0098\u00da@R/\u0007\u00f5\u001f\u0097\u00d7\f\u00c5d\u00d8\u0093\u008b{\u009d\u00e2+\u00dc\u0003\u00d7\u00bc\u00a99\u0081m\u00c5\u00f4\u008f\u008d\u00a0\u00bbd\u00fd\u00ad\u00b1\u00c1\u0099\u000f\u001b\u00ad\u0082o*\u00b2\u0095\u00e4\u00cd\u0004^\u00b1Y\u0000\u0017\u00a8\u00f1`^\u00c1\u00ed\u0090\u00c9L\u00eeI\u001a\u001f\u00ab\u0090\u00f1\u0090\u00e3\u00ad\u00b1T\u00dfh7U\u00b0\u00a6\u00a0M\u009f_\u00b3\u0010\u000e\u0087\u00e7\u00c0\u008b\u00e9\u008b\u001e\u0014\u00eaK\n)6\u00ae\u00fa\r\u00f6G\u00de\u0002.\u0097)\u00f1lU\u00a7I\u00d8\u00b5\u00cd-\u00cb'\u00a6\u009e8ev\u0085\u00e9\u008f\u00dc\u000e\u00b6\u00b0;\u00fb\u0019g\u00af.\\Ct\u0000\u00a2\u00ca\u00f6\u00b30}P\u00c8\u00ed\u009f2\u00af\u009b\u00d1\u00c8\u0012\u00efj\",v\u0011Yw\u00f8/g\u00e4\u00f3i\u00c8\u0095H\u00b7\u00e3\u0013^n\u008b\u00a7&\u00a6\u0098\u0000\u00adDr[\u00f70\u00e3\u0092\t\u0093\u0018Ch\u00ad\u0017A$Au\u0018\u00cf\u008e\u00e3\u00b8\u000f\u00f4\u00aem\u008d\u00c4\u009e\u0091\u0018\u00c8\u00bc\u0081\u00b4{AGZ M\u00ed,\u00e7o\u00be\u00e7\u00fbUP\u00f2!>\u0000:\u007fH\u00ebj\u0017\u00e1\u0004C\u00a2~\u008b\u001f\u00f4\u00a44\u001a\u000e\u0097\u00ef2\u00abE\u0082p\u00e2\u00c5\u00b2\tY3\u0097@\u00ea8\u0005\u00deW\u0085~\u00b9U\u00b29u\u0092I\u0099\u0089\u00fbO\u0090\u00b7.u\u00e1n\u009f\u00c9T\u0087z}\u0091\u0002d".getBytes("ISO_8859_1");
        Object[] v1 = "\u00b6W\u00be\u008d\u009fV]W".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 1009550616;
                case 1 -> 1633304748;
                case 2 -> 1362323154;
                case 3 -> -1188627546;
                case 4 -> 1236836408;
                case 5 -> -1625361238;
                case 6 -> -1131526891;
                case 7 -> 1415970990;
                case 8 -> -1882199887;
                case 9 -> -1368759144;
                case 10 -> 835643353;
                case 11 -> 1362802246;
                case 12 -> 1251204106;
                case 13 -> -1123642661;
                case 14 -> 376410212;
                case 15 -> -1229856221;
                case 16 -> -981911169;
                case 17 -> 242881601;
                case 18 -> -1555687211;
                case 19 -> -2025997324;
                case 20 -> -51651972;
                case 21 -> -127900109;
                case 22 -> 2062031979;
                case 23 -> -1850092570;
                case 24 -> -2037004103;
                case 25 -> -1649353323;
                case 26 -> 1356204304;
                case 27 -> 1014786317;
                case 28 -> -1744493432;
                case 29 -> -677913624;
                case 30 -> -227419174;
                case 31 -> -1879348651;
                case 32 -> 385087703;
                case 33 -> -1902368253;
                case 34 -> 1304407316;
                case 35 -> -1574199705;
                case 36 -> 456130878;
                case 37 -> 503620263;
                case 38 -> -1959043191;
                case 39 -> -1859857775;
                case 40 -> 256903605;
                case 41 -> -1005552787;
                case 42 -> 149942128;
                case 43 -> 1392372299;
                case 44 -> 1044866818;
                case 45 -> -841550774;
                case 46 -> -491628897;
                case 47 -> -562019810;
                case 48 -> -1614827258;
                case 49 -> 868822684;
                case 50 -> -1356134613;
                case 51 -> 880919080;
                case 52 -> -684998868;
                case 53 -> -165977489;
                case 54 -> -2139730766;
                case 55 -> 11108219;
                case 56 -> -922318596;
                case 57 -> 1426642634;
                case 58 -> -355126649;
                case 59 -> 1247467525;
                case 60 -> -907839300;
                case 61 -> 1110979638;
                case 62 -> -1989295616;
                case 63 -> -1346407958;
                case 64 -> 320684969;
                case 65 -> 1153181313;
                case 66 -> -105731885;
                case 67 -> 363359616;
                case 68 -> -464820819;
                case 69 -> -897163560;
                case 70 -> -1359505769;
                case 71 -> -1954297532;
                case 72 -> 108379005;
                case 73 -> 920742648;
                case 74 -> 37286861;
                case 75 -> 1395311857;
                case 76 -> 2038494277;
                case 77 -> 937950257;
                case 78 -> 57850306;
                case 79 -> -988106106;
                case 80 -> 348507027;
                case 81 -> 1127647769;
                case 82 -> 1800111396;
                case 83 -> -352740041;
                case 84 -> 745550497;
                case 85 -> -427924291;
                case 86 -> -1969867107;
                case 87 -> -1470326176;
                case 88 -> -1386022107;
                case 89 -> -1720734910;
                case 90 -> -1166168825;
                case 91 -> -1394753682;
                case 92 -> 472881029;
                case 93 -> 1440860344;
                case 94 -> -246184284;
                case 95 -> -18086870;
                case 96 -> -260508089;
                case 97 -> -1351070131;
                case 98 -> 640930674;
                case 99 -> 77568220;
                case 100 -> -1877758716;
                case 101 -> -545496124;
                case 102 -> -700630495;
                case 103 -> -1686017174;
                case 104 -> -744170660;
                case 105 -> 176231161;
                case 106 -> -1707211319;
                case 107 -> 702343633;
                case 108 -> 1420067746;
                case 109 -> 1575697681;
                case 110 -> 1890316542;
                case 111 -> -132171232;
                case 112 -> -1849732726;
                case 113 -> -639896083;
                case 114 -> 1724241981;
                case 115 -> 1865907757;
                case 116 -> 903802406;
                case 117 -> 713456534;
                case 118 -> 840669059;
                case 119 -> -1239429393;
                case 120 -> -287345293;
                case 121 -> -1192677067;
                case 122 -> 849975275;
                case 123 -> 1022296846;
                case 124 -> 1718327916;
                case 125 -> -1737278242;
                case 126 -> 846924420;
                case 127 -> -78672833;
                case 128 -> 820025022;
                case 129 -> -1818844856;
                case 130 -> 329170356;
                case 131 -> -214444317;
                case 132 -> 783675852;
                case 133 -> -555675893;
                case 134 -> -714607468;
                case 135 -> 461701987;
                case 136 -> -1410024873;
                case 137 -> -684475039;
                case 138 -> -541734359;
                case 139 -> 1759575654;
                case 140 -> -234043483;
                case 141 -> 911535954;
                case 142 -> 462489166;
                case 143 -> -1167514222;
                case 144 -> 1779302530;
                case 145 -> -811851753;
                case 146 -> -451322885;
                case 147 -> -82108577;
                case 148 -> 1932977200;
                case 149 -> -953952647;
                case 150 -> -2135392429;
                case 151 -> -1788770421;
                case 152 -> -1020738847;
                case 153 -> 1325048446;
                case 154 -> 908238233;
                case 155 -> 728927479;
                case 156 -> 1160073250;
                case 157 -> -377562282;
                case 158 -> 470876673;
                case 159 -> 1909372475;
                case 160 -> -1279223302;
                case 161 -> -2069430131;
                case 162 -> -1591932108;
                case 163 -> -1722916722;
                case 164 -> 2142075512;
                case 165 -> 565372574;
                case 166 -> -168903498;
                case 167 -> 1074831406;
                case 168 -> 1576672738;
                case 169 -> 903877682;
                case 170 -> 1012103689;
                case 171 -> -1132024149;
                case 172 -> 594880344;
                case 173 -> 897445494;
                case 174 -> 721869533;
                case 175 -> 1610810234;
                case 176 -> 1766558275;
                case 177 -> 1633983912;
                case 178 -> 675314330;
                case 179 -> 652458612;
                case 180 -> 326777075;
                case 181 -> -1315190034;
                case 182 -> -2101914680;
                case 183 -> 400815318;
                case 184 -> -475127408;
                case 185 -> -1255367730;
                case 186 -> -889453631;
                case 187 -> 983058234;
                case 188 -> 769669599;
                case 189 -> 955028032;
                case 190 -> -1827604361;
                case 191 -> -1160350467;
                case 192 -> -559781089;
                case 193 -> 600126399;
                case 194 -> 1363178992;
                case 195 -> 873002063;
                case 196 -> -655505725;
                case 197 -> 14061410;
                case 198 -> 1788731721;
                case 199 -> -1334635597;
                case 200 -> 1100037465;
                case 201 -> 1427187924;
                case 202 -> -1298078896;
                case 203 -> 494053466;
                case 204 -> 1281605204;
                case 205 -> -255476737;
                case 206 -> -48357007;
                case 207 -> -1961318688;
                case 208 -> 844338316;
                case 209 -> -1536169903;
                case 210 -> -808797765;
                case 211 -> -1019080805;
                case 212 -> -90685172;
                case 213 -> -185937303;
                case 214 -> 1035258604;
                case 215 -> -1628501444;
                case 216 -> 65750214;
                case 217 -> -594731171;
                case 218 -> -2098421552;
                case 219 -> 137241895;
                case 220 -> -1073772260;
                case 221 -> 916190302;
                case 222 -> -432060141;
                case 223 -> 399375023;
                case 224 -> -759796689;
                case 225 -> -413473806;
                case 226 -> -1550006841;
                case 227 -> 141022115;
                case 228 -> -351500259;
                case 229 -> 385406028;
                case 230 -> 1758529050;
                case 231 -> 1618604976;
                case 232 -> -727202329;
                case 233 -> 922250341;
                case 234 -> 282617461;
                case 235 -> 1399889856;
                case 236 -> -1047307334;
                case 237 -> -88835992;
                case 238 -> 1837981960;
                case 239 -> -907467019;
                case 240 -> -347227675;
                case 241 -> -1031316977;
                case 242 -> -856249161;
                case 243 -> 610951707;
                case 244 -> -468218567;
                case 245 -> 807831899;
                case 246 -> -1940261937;
                case 247 -> -981302587;
                case 248 -> 884101865;
                case 249 -> 271684239;
                case 250 -> 413719830;
                case 251 -> -386786613;
                case 252 -> -760206108;
                case 253 -> 2064005110;
                case 254 -> -1490868320;
                case 255 -> -1316437230;
                default -> 794685668;
            });
        } while (v2 != 344);
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
            Object[] objectArray = new Object[11];
            v1 = objectArray;
            EnumType_0OI = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        O0o = "BlurConfig";
        EventBusApi = 5000L;
        HudElement = 250L;
        PacketEvent = MinecraftClient.getInstance();
        HelpCommand = Identifier.of((String)"clap", (String)"blur");
        OOo = new Pool(4);
        GuiSupport_OOI = new Pool(4);
        OOi = new Std140SizeCalculator().putVec2().putFloat().get();
        Ooi = Integer.MIN_VALUE;
        KeystrokesHudElement = Integer.MIN_VALUE;
    }

    private static boolean OoI() {
        try {
            if (OoO == null) {
                OoO = RenderSupport_00ii_0.ConfigSupport_OII();
            }
            Oi0 = OoO != null;
            OoI = !Oi0;
            return Oi0;
        }
        catch (Throwable v0) {
            RenderSupport_00ii_0.0Oo("Failed to prepare post processing blur", v0);
            ConfigSupport_0OO = System.currentTimeMillis() + 250L;
            RenderSupport_00ii_0.Oi0();
            Ooi = Integer.MIN_VALUE;
            OoI = true;
            Oi0 = false;
            return false;
        }
    }

    private static boolean Ooi(Framebuffer param0, int param1) {
        return RenderSupport_00ii_0.KeystrokesHudElement(param0, param1, OOo);
    }

    private static void ConfigSupport_0OO(Framebuffer param0) {
        if (param0 == ConfigSupport_O0I) {
            Oio = false;
        }
        if (param0 == O0i) {
            OiI = false;
        }
    }

    public static boolean OOi() {
        return Oio && ConfigSupport_O0I != null;
    }

    public static boolean O0o() {
        int v0 = PacketEvent.getWindow().getFramebufferWidth();
        int v1 = PacketEvent.getWindow().getFramebufferHeight();
        int v2 = PacketEvent.getWindow().getScaledWidth();
        int v3 = PacketEvent.getWindow().getScaledHeight();
        int v4 = PacketEvent.getWindow().getScaleFactor();
        if (v0 <= 0 || v1 <= 0) {
            return false;
        }
        if (v2 <= 0 || v3 <= 0 || v4 <= 0) {
            return false;
        }
        if (ConfigSupport_O0I != null && O0i != null && ConfigSupport_OI0 == v0 && OIo == v1 && ConfigSupport_OII == v2 && RenderSupport_oii_4 == v3 && OiO == v4) {
            return true;
        }
        RenderSupport_00ii_0.Ooo();
        ConfigSupport_OI0 = v0;
        OIo = v1;
        ConfigSupport_OII = v2;
        RenderSupport_oii_4 = v3;
        OiO = v4;
        ConfigSupport_O0I = new SimpleFramebuffer("clap/blur", v0, v1, false);
        RenderSupport_00ii_0.EnumType_0OI((Framebuffer)ConfigSupport_O0I);
        O0i = new SimpleFramebuffer("clap/glow", v0, v1, false);
        RenderSupport_00ii_0.EnumType_0OI((Framebuffer)O0i);
        RenderSupport_00oi_0.OiO(v0, v1, v2, v3, ConfigSupport_O0I.method_30277().getLabel(), RenderSupport_00oi_0.OOo);
        RenderSupport_00oi_0.OiO(v0, v1, v2, v3, O0i.method_30277().getLabel(), RenderSupport_00oi_0.GuiSupport_OOI);
        return true;
    }

    private static void EnumType_0OI(Framebuffer param0) {
        if (param0 == null) {
            return;
        }
        CommandEncoder v1 = RenderSystem.getDevice().createCommandEncoder();
        v1.clearColorTexture(param0.getColorAttachment(), 0);
        if (param0.useDepthAttachment) {
            v1.clearDepthTexture(param0.getDepthAttachment(), 1.0);
        }
    }

    private static void OiO(boolean param0) {
        if (param0) {
            RenderSupport_00ii_0.Oio();
        } else {
            RenderSupport_00ii_0.Oi0();
        }
    }

    private static PostEffectProcessor OIo(boolean param0) {
        long v1 = System.currentTimeMillis();
        if (OoI && v1 < ConfigSupport_0OO) {
            return null;
        }
        try {
            if (param0) {
                if (Oo0 == null) {
                    Oo0 = RenderSupport_00ii_0.ConfigSupport_OII();
                }
                return Oo0;
            }
            if (OoO == null) {
                OoO = RenderSupport_00ii_0.ConfigSupport_OII();
            }
            Oi0 = OoO != null;
            OoI = !Oi0;
            return OoO;
        }
        catch (Throwable v3) {
            RenderSupport_00ii_0.0Oo("Failed to prepare post processing blur", v3);
            ConfigSupport_0OO = System.currentTimeMillis() + 250L;
            OoI = true;
            RenderSupport_00ii_0.OiO(param0);
            return null;
        }
    }

    private static void 0Oo(String param0, Throwable param1) {
        long v2 = System.currentTimeMillis();
        if (v2 < DataRecord_0O0) {
            ++0Oo;
            return;
        }
        if (0Oo > 0) {
            NativeEntrypointBridge.OOo.warn("{} ({} similar warnings suppressed)", (Object)param0, (Object)0Oo, (Object)param1);
            0Oo = 0;
        } else {
            NativeEntrypointBridge.OOo.warn(param0, param1);
        }
        DataRecord_0O0 = v2 + 5000L;
    }

    public static boolean GuiSupport_OOI() {
        return Oi0 && RenderSupport_00ii_0.O0o();
    }

    private static PostEffectProcessor ConfigSupport_OII() throws Exception {
        ShaderLoader v0 = PacketEvent.getShaderLoader();
        ShaderLoaderAccessor v1 = (ShaderLoaderAccessor)v0;
        PostEffectPipeline v2 = RenderSupport_00ii_0.RenderSupport_oii_4(HelpCommand);
        if (v2 == null) {
            return v0.loadPostEffect(HelpCommand, Set.of(PostEffectProcessor.MAIN));
        }
        TextureManager v3 = v1.clap$getTextureManager();
        ProjectionMatrix2 v4 = v1.clap$getPostChainProjectionMatrixBuffer();
        return PostEffectProcessor.parseEffect((PostEffectPipeline)v2, (TextureManager)v3, Set.of(PostEffectProcessor.MAIN), (Identifier)HelpCommand, (ProjectionMatrix2)v4);
    }

    public static void OOo() {
        if (!RenderSupport_00ii_0.O0o()) {
            return;
        }
    }

    public static void EventBusApi() {
        if (!RenderSupport_00ii_0.O0o()) {
            return;
        }
        PostProcessingModule v0 = PostProcessingModule.IoIo();
        if (v0 == null || !v0.Iooi()) {
            RenderSupport_00ii_0.EnumType_0OI((Framebuffer)O0i);
            OiI = false;
            Oii = false;
            return;
        }
        if (!Oii) {
            OiI = false;
            return;
        }
        OiI = RenderSupport_00ii_0.KeystrokesHudElement((Framebuffer)O0i, v0.IoI0(), GuiSupport_OOI);
        Oii = false;
    }

    public static boolean OoO() {
        return OiI && O0i != null;
    }

    private static PostEffectPipeline RenderSupport_oii_4(Identifier param0) throws Exception {
        Identifier v1 = Identifier.of((String)param0.getNamespace(), (String)("post_effect/" + param0.getPath() + ".json"));
        Optional v2 = PacketEvent.getResourceManager().method_14486(v1);
        if (v2.isEmpty()) {
            return null;
        }
        try (BufferedReader v3 = ((Resource)v2.get()).getReader();){
            JsonElement v4 = StrictJsonParser.parse((Reader)v3);
            PostEffectPipeline v5 = (PostEffectPipeline)PostEffectPipeline.CODEC.parse((DynamicOps)JsonOps.INSTANCE, (Object)v4).getOrThrow(param1 -> new IllegalStateException("Failed to parse post chain " + String.valueOf(param0) + ": " + param1));
            return v5;
        }
    }

    public static void Oo0() {
        Oii = true;
    }

    public static void HelpCommand(boolean param0, int param1) {
        if (!RenderSupport_00ii_0.O0o()) {
            return;
        }
        if (!param0) {
            RenderSupport_00ii_0.EnumType_0OI((Framebuffer)ConfigSupport_O0I);
            Oio = false;
            return;
        }
        Framebuffer v2 = PacketEvent.getFramebuffer();
        RenderSystem.getDevice().createCommandEncoder().copyTextureToTexture(v2.getColorAttachment(), ConfigSupport_O0I.method_30277(), 0, 0, 0, 0, 0, RenderSupport_00ii_0.ConfigSupport_O0I.field_1482, RenderSupport_00ii_0.ConfigSupport_O0I.field_1481);
        Oio = RenderSupport_00ii_0.Ooi((Framebuffer)ConfigSupport_O0I, param1);
    }

    public static SimpleFramebuffer O0i() {
        return O0i;
    }

    public static void ConfigSupport_O0I() {
        if (RenderSupport_00ii_0.O0o()) {
            RenderSupport_00ii_0.EnumType_0OI((Framebuffer)O0i);
            OiI = false;
            Oii = false;
        }
    }

    private static boolean DataRecord_0O0(Throwable param0) {
        for (Throwable v1 = param0; v1 != null; v1 = v1.getCause()) {
            if (!(v1 instanceof IllegalStateException) || v1.getMessage() == null || !v1.getMessage().contains("Buffer already closed")) continue;
            return true;
        }
        return false;
    }

    private RenderSupport_00ii_0() {
    }

    private static boolean KeystrokesHudElement(Framebuffer param0, int param1, Pool param2) {
        long v3 = System.currentTimeMillis();
        if (v3 < ConfigSupport_0OO) {
            RenderSupport_00ii_0.ConfigSupport_0OO(param0);
            return false;
        }
        try {
            PostEffectProcessor v5 = RenderSupport_00ii_0.OIo(param0 == O0i);
            if (v5 == null) {
                return false;
            }
            RenderSupport_00ii_0.ConfigSupport_OI0(v5, param1, param0 == O0i);
            v5.render(param0, (ObjectAllocator)param2);
            return true;
        }
        catch (Throwable v5) {
            RenderSupport_00ii_0.ConfigSupport_0OO(param0);
            ConfigSupport_0OO = System.currentTimeMillis() + 250L;
            param2.clear();
            if (RenderSupport_00ii_0.DataRecord_0O0(v5)) {
                RenderSupport_00ii_0.OiO(param0 == O0i);
                RenderSupport_00ii_0.0Oo("Failed to render post processing blur; resetting closed post chain", v5);
                return false;
            }
            RenderSupport_00ii_0.0Oo("Failed to render post processing blur; resetting post chain", v5);
            RenderSupport_00ii_0.OiO(param0 == O0i);
            return false;
        }
    }

    private static void Oi0() {
        if (OoO != null) {
            OoO.close();
            OoO = null;
        }
        Ooi = Integer.MIN_VALUE;
        Oi0 = false;
        OoI = false;
    }

    public static void PacketEvent() {
        PostProcessingModule v0 = PostProcessingModule.IoIo();
        if (v0 == null) {
            RenderSupport_00ii_0.HelpCommand(false, 0);
            return;
        }
        RenderSupport_00ii_0.HelpCommand(v0.IooI(), v0.IoIO());
    }

    private static ByteBuffer Oii(float param0, float param1, int param2) {
        try (MemoryStack v3 = MemoryStack.stackPush();){
            ByteBuffer v4 = Std140Builder.onStack((MemoryStack)v3, (int)OOi).putVec2(param0, param1).putFloat((float)param2).get();
            ByteBuffer v5 = ByteBuffer.allocateDirect(OOi);
            v5.put(v4);
            v5.flip();
            return v5;
        }
    }

    private static void Ooo() {
        RenderSupport_00oi_0.Oi0();
        Oio = false;
        OiI = false;
        Oii = false;
        if (ConfigSupport_O0I != null) {
            ConfigSupport_O0I.method_1238();
            ConfigSupport_O0I = null;
        }
        if (O0i != null) {
            O0i.method_1238();
            O0i = null;
        }
        OOo.clear();
        GuiSupport_OOI.clear();
        RenderSupport_00ii_0.OiI();
        Ooi = Integer.MIN_VALUE;
        KeystrokesHudElement = Integer.MIN_VALUE;
        ConfigSupport_OI0 = 0;
        OIo = 0;
        ConfigSupport_OII = 0;
        RenderSupport_oii_4 = 0;
        OiO = 0;
    }

    public static void HudElement() {
        OOo.decrementLifespan();
        GuiSupport_OOI.decrementLifespan();
    }

    private static void Oio() {
        if (Oo0 != null) {
            Oo0.close();
            Oo0 = null;
        }
        KeystrokesHudElement = Integer.MIN_VALUE;
    }
}

