/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.RenderPipelines
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.texture.AbstractTexture
 *  net.minecraft.client.texture.NativeImage
 *  net.minecraft.client.texture.TextureManager
 *  net.minecraft.util.Identifier
 */
package clap.render;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.security.Key;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.util.Identifier;
import clap.config.ConfigSupport_00I0;
import clap.config.ConfigSupport_0oi_2;
import clap.config.ConfigSupport_ioi_6;
import clap.core.NativeEntrypointBridge;
import clap.config.ConfigSupport_ooio_5;
import clap.render.texture.NamedNativeImageTexture;

public class FontRenderer {
    private int KeystrokesHudElement;
    private final int HudElement;
    private final Map O0o;
    private static final int OOo;
    private int OoI;
    private int Ooi;
    private static final int[] GuiSupport_OOI;
    private boolean Oo0;
    private final Set ConfigSupport_O0I;
    private int ConfigSupport_OI0;
    private final Identifier OOi;
    private final Map EventBusApi = new HashMap();
    private Identifier OIo;
    private boolean ConfigSupport_OII;
    private final Identifier O0i;
    private final Map OoO;
    private Font Ooo;
    private static final int PacketEvent;
    private static final int HelpCommand;
    static Object RenderSupport_oii_4;
    private static volatile /* synthetic */ long __k__gH4it;

    private void OoI() {
        if (this.OoO.isEmpty()) {
            return;
        }
        for (ConfigSupport_0oi_2 v2 : this.OoO.values()) {
            this.Ooi(v2);
        }
        this.OoO.clear();
    }

    private void Ooi(ConfigSupport_0oi_2 param1) {
        if (param1 != null && param1.PacketEvent != null) {
            MinecraftClient.getInstance().getTextureManager().destroyTexture(param1.PacketEvent);
        }
    }

    public FontRenderer(Identifier param1, int param2) {
        this.O0o = new ConfigSupport_00I0(this, 2048, 0.75f, true);
        this.ConfigSupport_O0I = new HashSet();
        this.OoO = new ConfigSupport_ooio_5(this, 512, 0.75f, true);
        this.OOi = param1;
        this.HudElement = param2;
        this.O0i = Identifier.of((String)("clap:font_atlas/" + this.OiO(param1.getPath()) + "_" + param2));
    }

    static {
        __k__gH4it = FontRenderer.__k__gH4it((long)-745416846865338863L);
        __rP__gH4it0 = new String[]{"\uc0ce\u2032\uff56\uaa24\u2d85\u9b72\ub34b\ufdb5\uc158\u218b\ufeb1\uab2b\u2c73\u9a22\ub290\ufebb\uc2ae\u220f\ufd60\ua820\u2f09\u9965\ub1cb\ufebe\uc370\u2372\ufcca\ua9aa\u2eed\u98a5\ub0c6\uff99\u3cf6\udcc5\u0339\u567f\ud1a2\u67e3\u4fee+\u3df8\uddac\u02bf\u57f1\ud0a1\u66a4\u4e72\u0166\u3e2c\udeb1\u015c\u5480\ud36a\u652b\u4d0d\u0210\u3ef8\udfcfg\u55ec\ud208\u64a7\u4cb9\u03ea\u3f49\ud8d4\u078e\u52c6\ud55a\u6372\u4b05\u0423\u38d8\ud925\u06b1\u53ea\ud49f\u62c6\u4a2e\u0543\u39a5\ud92d\u0510\u5098\ud738\u6102\u4937\u063e\u3aa4\uda61\u044b\u5143\ud6d8\u6065\u48fd\u07e5\u3b0b\udbec\u0b0b\u5e30\ud913\u6fc4\u477f\u0893\u3401\ud4c1\u0a59\u5f53\ud808\u6e82\u46e2\u0904\u35a6\ud5d3\u0ad3\u5c93\udbc8\u6d9c\u45f1\u0a96\u36e6\ud686\u09d2\u5d8b\udadc\u6c73\u4415\u0bbb\u3741\ud747\u0880\u5a43\udde0\u6bd3\u43e0\u0c9b\u3051\ud003\u0fe2\u5b52\udc70\u6a27\u4213\u0d02\u315d\ud12e\u0e7c\u5b01\udfe1\u691c\u416a\u0eb1\u324e\ud295\u0d21\u5823\udec0\u685e\u4049\u0f95\u33b5\ud349\u0c77\u5943\uc180\u7736\u5f4d\u1042\u2c05\uccef\u13ce\u465e\uc002\u76e9\u5ee9\u117e\u2d66\ucdac\u124a\u47cc\uc028\u7552\u5d5d\u1284\u2e4e\uce9a\u11b1\u44a9\uc329\u7418\u5c84\u1333\u2f86\ucffe\u1023\u45ef\uc27f\u7388\u5bca\u14f1\u2869\uc883\u1707\u42dd\uc517\u7235\u5a2b\u1581\u2902\uc9e1\u1685\u4332\uc45a\u727d\u5944\u1682\u2aad\uca65\u1504\u40df\uc7f2\u7120\u585d\u1768", "\uc0fe\u2097\ufe84\uab6a\u2c3b\u9a9d\ub2c1\ufdc4\uc1e0\u21fd", "\uc0e9\u2099\ufe8a\uab01\u2c20"};
        __rP__gH4it1 = new String[]{"\uc0fc\u2095\ufe8a\uab64\u2c39\u9a9f\ub2c7\ufdc2\uc1e2\u21ff", "\uc0ea\u20a6\uff71\uab31\u2c29\u9ac8\ub25e\ufdf9\uc186\u21a0\ufe69\ua845\u2f57\u99d2\ub174\ufeba\uc2ba\u229a\ufd5c\ua969", "\uc0fc\u208c\ufe9b"};
        __rP__gH4it2 = new String[]{"\uc043\u206c\ufe12\uab12\u2c03\u9a95\ub2f8\ufd15"};
        __rP__gH4it3 = new String[]{"\uc0ec\u2084\ufe92\uab00\u2c29\u9a88\ub2da"};
        byte[] v0 = "\u0090A\u00e4\u00aa\u007fh\u00c6\u00f3\u001e\u00f0\u000b\u00ad\u00810\u0015\u00f5\u00e0\f\u00e2^\u00c3\u000fv\b\u0006y@\u00dc/\u00c7s'\u0088\u00d6\u00ab\u0011x\u0099C\u008d\u009e\u00b7%\u0097s\u00d6\u00d7\u00c8B\u0092\u00be\u00de@a\u00d0\u0086n\u00e4\u008d\u00ba*\u00e5lt\u00d7\u00e7|\u0088`(\u00c8\u00a5^\u001eK\u00ac\u00ad\u0094\u00eb\u00cd+\u00ee\u00d2\u00a62\u00a8\u00ca\u00c8\u0012\u00aa\u0081u\u00da\u00c7\b\u001b\u00b5?\u00d9\u001e\t~\u0092u\u00a7\u001a\u0083u\u001a0\u0007\u00ea\b0\u00f1\u008d\u00a2\u0016\u00ec@0m\u00f8\u009d\u00be\u00f1\u0000e\u009f\u00b4\u00b2M\u009aI\u00ed]\u0097\u00f8\u00d8T\u0002\u00b5\u0016\u00cc\u0093\u00ad~\u00ff\u00ab\u00f6W\u0087\u00b8\u001e+\u00d5\u0082\u00bc|\u00abK\u00dae\u00ad\u00da\u00cc`d\u00e3t\u00d4\u00b8P\u001b\u00ccP\u0088\u000f(\u0012\u0082\u0098\u0000\u0092X1\u00db\u007f\u008b\u00da\u00d1-\u0098MQ!\u00c5R\u0087\u00f7o8}\u001b\u00a5\u00e7n\u008f\f\u00a2\u00c7\u008c\u00d0W9\u00f4\u009b.Nip\u0002(\u0016".getBytes("ISO_8859_1");
        Object[] v1 = "\u00f7\u00a9\u00d6&\u00031\u000b\u00e9".getBytes("ISO_8859_1");
        int v2 = 0;
        int v3 = v0.length;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -145064316;
                case 1 -> -1537534716;
                case 2 -> -1271160364;
                case 3 -> -1360550065;
                case 4 -> 654281867;
                case 5 -> -454733833;
                case 6 -> 1275852783;
                case 7 -> -317919273;
                case 8 -> -673968621;
                case 9 -> -1687549334;
                case 10 -> -1069627319;
                case 11 -> 502331426;
                case 12 -> -761352161;
                case 13 -> -542946599;
                case 14 -> 567976002;
                case 15 -> 494324458;
                case 16 -> -1009899795;
                case 17 -> 726180712;
                case 18 -> 23209752;
                case 19 -> -122172193;
                case 20 -> -1242491853;
                case 21 -> 4455387;
                case 22 -> -153995267;
                case 23 -> 948613220;
                case 24 -> 1597784335;
                case 25 -> 451167756;
                case 26 -> -1595541119;
                case 27 -> -79336242;
                case 28 -> 790406076;
                case 29 -> 694492351;
                case 30 -> -1206825316;
                case 31 -> 111090699;
                case 32 -> 680080206;
                case 33 -> 1077621936;
                case 34 -> -236845091;
                case 35 -> 1869750150;
                case 36 -> 1386392853;
                case 37 -> -1056760457;
                case 38 -> 1836890008;
                case 39 -> -1804745136;
                case 40 -> 292396570;
                case 41 -> 1508953891;
                case 42 -> -1309535550;
                case 43 -> -1513464283;
                case 44 -> -564829554;
                case 45 -> 712234922;
                case 46 -> -1485424395;
                case 47 -> 1980334243;
                case 48 -> 1374485701;
                case 49 -> 279789883;
                case 50 -> -1521266869;
                case 51 -> -1309157632;
                case 52 -> 407692439;
                case 53 -> 395416812;
                case 54 -> -1274719839;
                case 55 -> 801431386;
                case 56 -> 2109421439;
                case 57 -> -261986823;
                case 58 -> -2054884226;
                case 59 -> -916963588;
                case 60 -> -1539446716;
                case 61 -> 684746888;
                case 62 -> -1314648637;
                case 63 -> 609466370;
                case 64 -> -359869638;
                case 65 -> 1389365114;
                case 66 -> 1237177377;
                case 67 -> 229371958;
                case 68 -> -2083265519;
                case 69 -> -784870072;
                case 70 -> 1780607692;
                case 71 -> 1186030976;
                case 72 -> 68396240;
                case 73 -> 1172403006;
                case 74 -> -1463219193;
                case 75 -> 554067513;
                case 76 -> -1460611562;
                case 77 -> 1484439411;
                case 78 -> -61944819;
                case 79 -> 1435887420;
                case 80 -> 1084889277;
                case 81 -> 1908298426;
                case 82 -> 1411105203;
                case 83 -> -1687521234;
                case 84 -> -1158378154;
                case 85 -> 581417114;
                case 86 -> -1084226755;
                case 87 -> -1786525687;
                case 88 -> 133108437;
                case 89 -> -475472993;
                case 90 -> -734663959;
                case 91 -> 1572630008;
                case 92 -> -227701380;
                case 93 -> 439063323;
                case 94 -> 2000772151;
                case 95 -> -709304592;
                case 96 -> 47467750;
                case 97 -> 1812156581;
                case 98 -> 513813987;
                case 99 -> -923541201;
                case 100 -> 953516129;
                case 101 -> 908086355;
                case 102 -> -448509326;
                case 103 -> 193712054;
                case 104 -> -85895520;
                case 105 -> -283718864;
                case 106 -> -166146882;
                case 107 -> 330789720;
                case 108 -> 205206580;
                case 109 -> -1675477522;
                case 110 -> -52488440;
                case 111 -> -150966759;
                case 112 -> -1532159367;
                case 113 -> -1586142988;
                case 114 -> -440294284;
                case 115 -> 1405898599;
                case 116 -> 16527456;
                case 117 -> -903502094;
                case 118 -> -2006046119;
                case 119 -> 312272733;
                case 120 -> 1875901004;
                case 121 -> -1441691764;
                case 122 -> 811676534;
                case 123 -> 1409513185;
                case 124 -> 502255559;
                case 125 -> -1979285209;
                case 126 -> -701932815;
                case 127 -> -2016823685;
                case 128 -> -1127190522;
                case 129 -> 224715232;
                case 130 -> 1560853514;
                case 131 -> -91296961;
                case 132 -> -1180306619;
                case 133 -> 768388806;
                case 134 -> 431970088;
                case 135 -> 4617819;
                case 136 -> -1479782545;
                case 137 -> 373309597;
                case 138 -> 582053267;
                case 139 -> -689398387;
                case 140 -> -241481685;
                case 141 -> -1193385276;
                case 142 -> -1958143850;
                case 143 -> -193104155;
                case 144 -> -320829559;
                case 145 -> -1440807051;
                case 146 -> 1419944702;
                case 147 -> 1773482117;
                case 148 -> 1317343659;
                case 149 -> 664466386;
                case 150 -> -259562222;
                case 151 -> -2051004111;
                case 152 -> 1234271643;
                case 153 -> 404217319;
                case 154 -> 431172695;
                case 155 -> -598963362;
                case 156 -> -1424586454;
                case 157 -> -65540697;
                case 158 -> 698116206;
                case 159 -> 179723267;
                case 160 -> 615905062;
                case 161 -> -87776151;
                case 162 -> 683126483;
                case 163 -> 684866883;
                case 164 -> -52308704;
                case 165 -> -1812301693;
                case 166 -> -1900850575;
                case 167 -> 864699612;
                case 168 -> 883331402;
                case 169 -> -1229205567;
                case 170 -> -55570510;
                case 171 -> 654814889;
                case 172 -> 825655864;
                case 173 -> -1868099381;
                case 174 -> 1749553961;
                case 175 -> 312170152;
                case 176 -> 1370736468;
                case 177 -> -126551260;
                case 178 -> -209326391;
                case 179 -> -1925045147;
                case 180 -> -367027696;
                case 181 -> -935229489;
                case 182 -> -1878976174;
                case 183 -> 1707209301;
                case 184 -> -1591439728;
                case 185 -> 1437786856;
                case 186 -> 309212844;
                case 187 -> -1204907925;
                case 188 -> -1981595463;
                case 189 -> -885562396;
                case 190 -> 1414343351;
                case 191 -> 862838789;
                case 192 -> -885032100;
                case 193 -> -540240968;
                case 194 -> -1153452179;
                case 195 -> -145933893;
                case 196 -> -1515855646;
                case 197 -> 122584711;
                case 198 -> 221725393;
                case 199 -> 774477258;
                case 200 -> -48202082;
                case 201 -> 91228565;
                case 202 -> -162475347;
                case 203 -> 793716401;
                case 204 -> -1441597646;
                case 205 -> -160301167;
                case 206 -> 1830981568;
                case 207 -> 1481397830;
                case 208 -> 224208413;
                case 209 -> -1682439581;
                case 210 -> 346962288;
                case 211 -> -557881642;
                case 212 -> 925718609;
                case 213 -> -1799905064;
                case 214 -> 2086694701;
                case 215 -> 283449587;
                case 216 -> 951681190;
                case 217 -> 1202663880;
                case 218 -> 1455207860;
                case 219 -> -190701759;
                case 220 -> 2057902244;
                case 221 -> -1906883008;
                case 222 -> 1523747563;
                case 223 -> 170411031;
                case 224 -> -1838187777;
                case 225 -> -895828129;
                case 226 -> -208139270;
                case 227 -> 1945335221;
                case 228 -> -1703873260;
                case 229 -> 865002860;
                case 230 -> 1460335066;
                case 231 -> -1461044305;
                case 232 -> 1909120257;
                case 233 -> -458878344;
                case 234 -> 1438703741;
                case 235 -> -1842333450;
                case 236 -> 322526626;
                case 237 -> 1168947726;
                case 238 -> -1499703778;
                case 239 -> -202328942;
                case 240 -> -585378206;
                case 241 -> -1698040689;
                case 242 -> -1578386227;
                case 243 -> -632133893;
                case 244 -> -918356818;
                case 245 -> 498715801;
                case 246 -> 260854410;
                case 247 -> -1994070457;
                case 248 -> 809635637;
                case 249 -> -1375143091;
                case 250 -> -1526525054;
                case 251 -> -521435860;
                case 252 -> 1806621468;
                case 253 -> -2105619820;
                case 254 -> 521778534;
                case 255 -> 99647966;
                default -> 55728022;
            });
        } while (v2 != v3);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(2, (Key)SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec((byte[])v1)), new IvParameterSpec(new byte[8]));
        v0 = cipher.doFinal(v0);
        v3 = v0.length;
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
            Object[] objectArray = new Object[9];
            v1 = objectArray;
            RenderSupport_oii_4 = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        OOo = 2048;
        HelpCommand = 4;
        PacketEvent = 4;
        GuiSupport_OOI = new int[]{0, 170, 43520, 43690, 0xAA0000, 0xAA00AA, 0xFFAA00, 0xAAAAAA, 0x555555, 0x5555FF, 0x55FF55, 0x55FFFF, 0xFF5555, 0xFF55FF, 0xFFFF55, 0xFFFFFF};
    }

    private void O0o() {
        block12: {
            if (this.Oo0) {
                return;
            }
            try {
                MinecraftClient v1 = MinecraftClient.getInstance();
                try (InputStream v22 = v1.getResourceManager().open(this.OOi);){
                    Font v3 = Font.createFont(0, v22);
                    this.Ooo = v3.deriveFont(0, (float)this.HudElement * 4.0f);
                }
                catch (Exception v22) {
                    this.Ooo = new Font("SansSerif", 0, this.HudElement * 4);
                }
                this.O0i();
                this.Oo0 = true;
                this.ConfigSupport_OII = false;
            }
            catch (Throwable v1) {
                this.OIo = null;
                if (this.ConfigSupport_OII) break block12;
                NativeEntrypointBridge.OOo.error("[Font] Failed to initialize custom font {}", (Object)this.OOi, (Object)v1);
                this.ConfigSupport_OII = true;
            }
        }
    }

    private String OiO(String param1) {
        if (param1 == null || param1.isEmpty()) {
            return "unknown";
        }
        return param1.toLowerCase().replace('/', '_').replace('\\', '_').replace('.', '_');
    }

    public boolean HudElement(char param1) {
        this.O0o();
        return this.Oo0 && this.Ooo != null && this.Ooo.canDisplay(param1);
    }

    private List KeystrokesHudElement() {
        int v22;
        ArrayList<Character> v1 = new ArrayList<Character>(1024);
        for (v22 = 32; v22 <= 255; ++v22) {
            this.ConfigSupport_OI0(v1, (char)v22);
        }
        if (this.OIo()) {
            for (v22 = 57344; v22 <= 59647; ++v22) {
                this.ConfigSupport_OI0(v1, (char)v22);
            }
        }
        Iterator v22 = this.ConfigSupport_O0I.iterator();
        while (v22.hasNext()) {
            char v3 = ((Character)v22.next()).charValue();
            this.ConfigSupport_OI0(v1, v3);
        }
        if (v1.isEmpty()) {
            v1.add(Character.valueOf(' '));
        }
        return v1;
    }

    private boolean OIo() {
        String v1 = this.OOi.getPath();
        return v1 != null && v1.toLowerCase().contains("icon");
    }

    public void HelpCommand(DrawContext param1, String param2, float param3, float param4, int param5) {
        if (param2 == null || param2.isEmpty()) {
            return;
        }
        this.O0o();
        if (!this.Oo0) {
            return;
        }
        ConfigSupport_0oi_2 v6 = this.OoO(param2);
        if (v6 == null || v6.PacketEvent == null) {
            this.EventBusApi(param1, param2, param3, param4, param5);
            return;
        }
        float v7 = (float)Math.round(param3 * 4.0f) / 4.0f;
        float v8 = (float)Math.round(param4 * 4.0f) / 4.0f;
        param1.getMatrices().pushMatrix();
        param1.getMatrices().translate(v7, v8);
        param1.getMatrices().scale(0.25f, 0.25f);
        param1.drawTexture(RenderPipelines.GUI_TEXTURED, v6.PacketEvent, 0, 0, 0.0f, 0.0f, v6.HelpCommand, v6.OOo, v6.HelpCommand, v6.OOo, v6.HelpCommand, v6.OOo, param5);
        param1.getMatrices().popMatrix();
    }

    private BufferedImage Oo0(String param1) {
        BufferedImage v2 = new BufferedImage(1, 1, 2);
        Graphics2D v3 = v2.createGraphics();
        v3.setFont(this.Ooo);
        this.RenderSupport_oii_4(v3);
        FontMetrics v4 = v3.getFontMetrics();
        int v5 = Math.max(1, v4.stringWidth(param1));
        int v6 = Math.max(1, v4.getHeight());
        int v7 = v4.getAscent();
        v3.dispose();
        int v8 = v5 + 8;
        int v9 = v6 + 8;
        BufferedImage v10 = new BufferedImage(v8, v9, 2);
        Graphics2D v11 = v10.createGraphics();
        v11.setFont(this.Ooo);
        this.RenderSupport_oii_4(v11);
        v11.setComposite(AlphaComposite.Src);
        v11.setColor(new Color(255, 255, 255, 0));
        v11.fillRect(0, 0, v8, v9);
        v11.setComposite(AlphaComposite.SrcOver);
        v11.setColor(Color.WHITE);
        v11.drawString(param1, 4, 4 + v7);
        v11.dispose();
        return v10;
    }

    public void PacketEvent(DrawContext param1, String param2, float param3, float param4, int param5) {
        this.EventBusApi(param1, param2, param3, param4, param5);
    }

    private ConfigSupport_0oi_2 OoO(String param1) {
        ConfigSupport_0oi_2 v2 = (ConfigSupport_0oi_2)this.OoO.get(param1);
        if (v2 != null) {
            return v2;
        }
        try {
            BufferedImage v3 = this.Oo0(param1);
            NativeImage v4 = new NativeImage(v3.getWidth(), v3.getHeight(), true);
            for (int v5 = 0; v5 < v3.getWidth(); ++v5) {
                for (int v6 = 0; v6 < v3.getHeight(); ++v6) {
                    v4.setColorArgb(v5, v6, v3.getRGB(v5, v6));
                }
            }
            ConfigSupport_0oi_2 v5 = new ConfigSupport_0oi_2();
            v5.HelpCommand = v3.getWidth();
            v5.OOo = v3.getHeight();
            v5.PacketEvent = Identifier.of((String)("clap:font_cache/" + this.OiO(this.OOi.getPath()) + "_" + this.HudElement + "_" + Integer.toHexString(param1.hashCode()) + "_" + param1.length()));
            TextureManager v6 = MinecraftClient.getInstance().getTextureManager();
            v6.destroyTexture(v5.PacketEvent);
            v6.registerTexture(v5.PacketEvent, (AbstractTexture)new NamedNativeImageTexture("clap_font_text", v4));
            this.OoO.put(param1, v5);
            return v5;
        }
        catch (Throwable v3) {
            NativeEntrypointBridge.OOo.warn("[Font] Failed to build cached text texture for {}", (Object)param1, (Object)v3);
            return null;
        }
    }

    public int GuiSupport_OOI(String param1) {
        int v4;
        if (param1 == null || param1.isEmpty()) {
            return 0;
        }
        this.O0o();
        if (!this.Oo0) {
            return 0;
        }
        this.ConfigSupport_O0I(param1);
        Integer v2 = (Integer)this.O0o.get(param1);
        if (v2 != null) {
            return v2;
        }
        int v3 = 0;
        for (v4 = 0; v4 < param1.length(); ++v4) {
            char v5 = param1.charAt(v4);
            if (this.ConfigSupport_OII(param1, v4)) {
                ++v4;
                continue;
            }
            ConfigSupport_ioi_6 v6 = (ConfigSupport_ioi_6)this.EventBusApi.get(Character.valueOf(v5));
            if (v6 != null) {
                v3 += v6.OOi;
                continue;
            }
            if (v5 != ' ') continue;
            ConfigSupport_ioi_6 v7 = (ConfigSupport_ioi_6)this.EventBusApi.get(Character.valueOf(' '));
            v3 += v7 != null ? v7.OOi : this.Ooi / 4;
        }
        v4 = (int)Math.ceil((float)v3 / 4.0f);
        this.O0o.put(param1, v4);
        return v4;
    }

    public int OOi() {
        this.O0o();
        return this.Oo0 ? this.OoI : 0;
    }

    private void ConfigSupport_O0I(String param1) {
        if (param1 == null || param1.isEmpty() || this.Ooo == null) {
            return;
        }
        boolean v2 = false;
        for (int v3 = 0; v3 < param1.length(); ++v3) {
            if (this.ConfigSupport_OII(param1, v3)) {
                ++v3;
                continue;
            }
            char v4 = param1.charAt(v3);
            if (this.EventBusApi.containsKey(Character.valueOf(v4)) || !this.Ooo.canDisplay(v4) || !this.ConfigSupport_O0I.add(Character.valueOf(v4))) continue;
            v2 = true;
        }
        if (v2) {
            this.O0i();
            this.O0o.clear();
            this.OoI();
        }
    }

    private BufferedImage Ooo() {
        int v14;
        BufferedImage v1 = new BufferedImage(1, 1, 2);
        Graphics2D v2 = v1.createGraphics();
        v2.setFont(this.Ooo);
        this.RenderSupport_oii_4(v2);
        FontMetrics v3 = v2.getFontMetrics();
        this.Ooi = v3.getHeight();
        int v4 = 12;
        List v5 = this.KeystrokesHudElement();
        int v6 = 0;
        int v7 = 0;
        int v8 = this.Ooi + 8 + v4;
        int v9 = 0;
        int v10 = v8;
        Object v11 = v5.iterator();
        while (v11.hasNext()) {
            char v12 = ((Character)v11.next()).charValue();
            int v13 = Math.max(1, v3.charWidth(v12));
            v14 = v13 + 8;
            if (v6 + v14 + v4 > 2048) {
                v6 = 0;
                v7 += v8;
                v10 += v8;
            }
            v9 = Math.max(v9, v6 += v14 + v4);
        }
        v2.dispose();
        v11 = new BufferedImage(Math.max(16, v9), Math.max(16, v10), 2);
        Graphics2D v12 = ((BufferedImage)v11).createGraphics();
        v12.setFont(this.Ooo);
        this.RenderSupport_oii_4(v12);
        v12.setComposite(AlphaComposite.Src);
        v12.setColor(new Color(255, 255, 255, 0));
        v12.fillRect(0, 0, ((BufferedImage)v11).getWidth(), ((BufferedImage)v11).getHeight());
        v12.setComposite(AlphaComposite.SrcOver);
        v12.setColor(Color.WHITE);
        FontMetrics v13 = v12.getFontMetrics();
        v14 = v13.getAscent();
        v6 = 0;
        v7 = 0;
        Iterator v15 = v5.iterator();
        while (v15.hasNext()) {
            char v16 = ((Character)v15.next()).charValue();
            int v17 = Math.max(1, v13.charWidth(v16));
            int v18 = v17 + 8;
            if (v6 + v18 + v4 > 2048) {
                v6 = 0;
                v7 += v8;
            }
            v12.drawString(String.valueOf(v16), v6 + 4, v7 + 4 + v14);
            ConfigSupport_ioi_6 v19 = new ConfigSupport_ioi_6();
            v19.PacketEvent = v18;
            v19.HelpCommand = this.Ooi + 8;
            v19.OOo = v6;
            v19.GuiSupport_OOI = v7;
            v19.OOi = v17 + Math.max(1, 1);
            this.EventBusApi.put(Character.valueOf(v16), v19);
            v6 += v18 + v4;
        }
        v12.dispose();
        return v11;
    }

    private void ConfigSupport_OI0(List param1, char param2) {
        if (this.Ooo.canDisplay(param2) && !param1.contains(Character.valueOf(param2))) {
            param1.add(Character.valueOf(param2));
        }
    }

    private boolean ConfigSupport_OII(String param1, int param2) {
        if (param2 + 1 >= param1.length()) {
            return false;
        }
        char v3 = param1.charAt(param2);
        if (v3 != '\u00a7' && v3 != '\u6402') {
            return false;
        }
        char v4 = Character.toLowerCase(param1.charAt(param2 + 1));
        return "0123456789abcdefr".indexOf(v4) != -1;
    }

    public void OOo() {
        this.O0o();
    }

    private void EventBusApi(DrawContext param1, String param2, float param3, float param4, int param5) {
        if (param2 == null || param2.isEmpty()) {
            return;
        }
        this.O0o();
        if (!this.Oo0 || this.OIo == null) {
            return;
        }
        this.ConfigSupport_O0I(param2);
        int v6 = param5;
        int v7 = param5 >>> 24 & 0xFF;
        int v8 = 0;
        float v9 = (float)Math.round(param3 * 4.0f) / 4.0f;
        float v10 = (float)Math.round(param4 * 4.0f) / 4.0f;
        param1.getMatrices().pushMatrix();
        param1.getMatrices().translate(v9, v10);
        param1.getMatrices().scale(0.25f, 0.25f);
        for (int v11 = 0; v11 < param2.length(); ++v11) {
            char v12 = param2.charAt(v11);
            if (this.ConfigSupport_OII(param2, v11)) {
                char v13 = Character.toLowerCase(param2.charAt(v11 + 1));
                int v14 = "0123456789abcdef".indexOf(v13);
                if (v14 != -1) {
                    v6 = v7 << 24 | GuiSupport_OOI[v14];
                } else if (v13 == 'r') {
                    v6 = param5;
                }
                ++v11;
                continue;
            }
            ConfigSupport_ioi_6 v13 = (ConfigSupport_ioi_6)this.EventBusApi.get(Character.valueOf(v12));
            if (v13 == null) {
                if (v12 != ' ') continue;
                ConfigSupport_ioi_6 v14 = (ConfigSupport_ioi_6)this.EventBusApi.get(Character.valueOf(' '));
                v8 += v14 != null ? v14.OOi : this.Ooi / 4;
                continue;
            }
            param1.drawTexture(RenderPipelines.GUI_TEXTURED, this.OIo, v8 - 4, -4, (float)v13.OOo, (float)v13.GuiSupport_OOI, v13.PacketEvent, v13.HelpCommand, v13.PacketEvent, v13.HelpCommand, this.KeystrokesHudElement, this.ConfigSupport_OI0, v6);
            v8 += v13.OOi;
        }
        param1.getMatrices().popMatrix();
    }

    private void O0i() {
        this.EventBusApi.clear();
        BufferedImage v1 = this.Ooo();
        this.KeystrokesHudElement = v1.getWidth();
        this.ConfigSupport_OI0 = v1.getHeight();
        this.OoI = Math.max(1, this.Ooi / 4);
        NativeImage v2 = new NativeImage(this.KeystrokesHudElement, this.ConfigSupport_OI0, true);
        for (int v3 = 0; v3 < this.KeystrokesHudElement; ++v3) {
            for (int v4 = 0; v4 < this.ConfigSupport_OI0; ++v4) {
                v2.setColorArgb(v3, v4, v1.getRGB(v3, v4));
            }
        }
        NamedNativeImageTexture v3 = new NamedNativeImageTexture("clap_font_atlas", v2);
        TextureManager v4 = MinecraftClient.getInstance().getTextureManager();
        if (this.OIo != null) {
            v4.destroyTexture(this.OIo);
        }
        this.OIo = this.O0i;
        v4.registerTexture(this.OIo, (AbstractTexture)v3);
    }

    private void RenderSupport_oii_4(Graphics2D param1) {
        param1.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        param1.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        param1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        param1.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    }
}

