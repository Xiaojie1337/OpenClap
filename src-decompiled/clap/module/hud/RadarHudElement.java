/*
 * Decompiled with CFR 0.152.
 */
package clap.module.hud;

import java.awt.Color;
import java.security.Key;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import clap.gui.hud.HudElement;
import clap.module.render.PostProcessingModule;
import clap.render.RenderSupport_00oi_0;
import clap.gui.GuiSupport_0oo_2;
import clap.setting.Setting;
import clap.config.ConfigSupport_oio0_2;
import clap.render.ScaledDrawContext;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from psx.Hyk.Oooo
 */
public class RadarHudElement
extends HudElement {
    public Setting IOo0;
    public Setting RenderSupport_oiii_5;
    private static final int IO0i;
    private long OooI;
    public Setting 0oI;
    public Setting IOoo;
    public Setting IOIO;
    public Setting 0oi;
    private final Map IOoO = new HashMap();
    public Setting ioO;
    public Setting IOoi;
    public Setting IOoI;
    static Object IOI0;
    private static volatile /* synthetic */ long __k__gH4it;

    static {
        __k__gH4it = RadarHudElement.__k__gH4it(-5686143947676586479L);
        __rP__gH4it0 = new String[]{"\u8681\uef05\u3791\u627d\ue52e\u9db6\u81e2\u3411\u81ef\ue85f", "\u8691\uef10\u3791\u6205\ue52e\u9d8d\u8117"};
        __rP__gH4it1 = new String[]{"\u86eb\uefe5\u30bf\u65c3\ue296\u9def\u8115\u34bf\u81cf\ue8da\u3781\u6210\ue501\u9cc9\u80c6\u3534\u800e\ue96a\u3653\u63b2\ue45d\u9cfd\u8376\u3685\u834b\ueaea\u35de\u6012\ue7d3\u9fcc\u826b\u3772\u82b0\uebf3\u3434\u61c2\ue682\u9e64\u8d69\u38be\u8d8d\ue47b\u3b27\u6ec1\ue991\u9146\u8c1c\u39db\u8c7b\ue526\u3aad\u6ffd\ue807\u9003\u8c68\u3ab4\u8f96\ue616\u399d\u6cd6\uebef\u936b\u8f40\u3b18\u8e65\ue7a6\u3855\u6df9\uea7e\u92d9\u8e1d\u3c86\u896f\ue093\u3f34\u6a62\ued61\u95ac\u89f0\u3d8f\u8887\ue13b\u3e4b\u6b6f\uecb9\u9452\u88a4\u3d2b\u8bfb\ue2f5\u3d1c\u68f5\uef9f\u973a\u8b07\u3eae\u8af7\ue360\u3c8a\u693c\uee64\u9614\u8a52\u3fe3\uf5c0\u9c1f\u43bb\u1619\u9124\ue98f\uf53f\u40cf\uf585\u9dea\u4244\u174b\u9082\ue88c\uf477\u4179\uf43e\u9e34\u41d0\u145f\u93af\uebe0\uf751\u4297\uf757\u9fba\u40c6\u15bf\u9216\uea3b\uf604\u432f\uf635\u9818\u4734\u12da\u95f5\uedd2\uf1ab\u4466\uf170\u986b\u46b7\u138c\u94fe\ueca3\uf016\u4533\uf0a6\u99fb\u4583\u10ee\u9746\uef30\uf319\u46ab", "\u8683\uef03\u3797\u627f\ue52c\u9d88\u811c\u3413\u81ed\ue859", "\u8697\uef0e\u3792\u6210\ue54e\u9de9\u8173\u3422\u818b\ue808\u368a\u6364\ue430\u9cf3\u8059\u3561\u80a7\ue932\u35bf\u6048", "\u8694\uef0d\u3791\u6204\ue527"};
        __rP__gH4it2 = new String[0];
        __rP__gH4it3 = new String[]{"\u86c9\uefd3\u376f\u6205\ue5e1\u9de7\u8174\u34b9", "\u8681\uef18\u3788"};
        byte[] v0 = "\u0088\u00de\u00ce\f+4\u0095B\u00a4\u00e9\u00f8\u00d7\u00b4\u001aN\u00c1]\u00a1\u0012\r\u00d0\u00d6\u00c6\b\u0010)\u0097\u00a5V\u00ef\u00d3\u00f7\u00f3(em\u001f_\u00c9#\u00c6\u00a8~f\u0004u\u00b4NH\u00cd\fb\u00ea\b8\u0019\u00ad\u00f54A\nh\u0018\u00bdF]\u00e4v\u0083\u00c2];D`\u008d\u00e5\u0094\u00bf\u00b8:\u0094\u00b0\u00ca\u0010t9\u00d4f\u00e0v\u0095\u0082ZY\u007f\u00eb\u00f4\u00fb\u001bS\u00b9o2\u00be\u00cb\u008c\"~\u00f1\u00fcW\u009avA\u00a5\u0014\u00af\u00c7g\u0014\u00c5\u00979\b\u008a\u00a3I\u00f2\u00b4\u00017\u00f0+`\u0004R\u00de\u00ab\u00cd\u009d\u00c0\u0081\u00a3\u0013\u00a3 v\u00b3\u00f3\b&>}\u00b8J\u00d9C\u0093!\u00ae".getBytes("ISO_8859_1");
        Object[] v1 = "\u0000\u0082\u00b0$\u00f6V\u00a2\u0092".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 1781739953;
                case 1 -> 1703138419;
                case 2 -> -809245919;
                case 3 -> -325875685;
                case 4 -> -1491819476;
                case 5 -> 2094905342;
                case 6 -> -631908303;
                case 7 -> 1668730939;
                case 8 -> -755098815;
                case 9 -> 1469573656;
                case 10 -> -1300901698;
                case 11 -> 1243334253;
                case 12 -> 634505574;
                case 13 -> 1694574561;
                case 14 -> 887685730;
                case 15 -> 9434209;
                case 16 -> 403029386;
                case 17 -> 1502608956;
                case 18 -> 2121803921;
                case 19 -> -1126050053;
                case 20 -> 1579619788;
                case 21 -> 1201893101;
                case 22 -> 1209054154;
                case 23 -> -2052411070;
                case 24 -> -36381337;
                case 25 -> -1914698198;
                case 26 -> 438869860;
                case 27 -> 1057616656;
                case 28 -> -1079056009;
                case 29 -> -574377552;
                case 30 -> 1600015911;
                case 31 -> -1598885537;
                case 32 -> -2134639495;
                case 33 -> 705204708;
                case 34 -> -737219398;
                case 35 -> -1368000219;
                case 36 -> -1093791204;
                case 37 -> 51479792;
                case 38 -> 1496530668;
                case 39 -> -1950745333;
                case 40 -> -1807569917;
                case 41 -> 1042370900;
                case 42 -> -1518606698;
                case 43 -> 1038902619;
                case 44 -> -819441608;
                case 45 -> 1422358815;
                case 46 -> -576489256;
                case 47 -> -297746222;
                case 48 -> -285096814;
                case 49 -> -1292093684;
                case 50 -> -2055344057;
                case 51 -> 1081237841;
                case 52 -> 1714594721;
                case 53 -> -837337250;
                case 54 -> 330455157;
                case 55 -> 1859527433;
                case 56 -> 826823136;
                case 57 -> -480044833;
                case 58 -> 1669643911;
                case 59 -> -1674911076;
                case 60 -> -1647480163;
                case 61 -> 1288263025;
                case 62 -> 1206109128;
                case 63 -> -2055509808;
                case 64 -> 1375561233;
                case 65 -> -2093881723;
                case 66 -> 843996521;
                case 67 -> -900935277;
                case 68 -> 1645246750;
                case 69 -> -621655051;
                case 70 -> -1671717325;
                case 71 -> -75454410;
                case 72 -> -2043628066;
                case 73 -> 1565489363;
                case 74 -> 620205155;
                case 75 -> -1442690113;
                case 76 -> -1867345346;
                case 77 -> -1797287850;
                case 78 -> -402286803;
                case 79 -> -1446294010;
                case 80 -> -970196910;
                case 81 -> -809048728;
                case 82 -> -515271495;
                case 83 -> -1807553893;
                case 84 -> 330776915;
                case 85 -> 77452355;
                case 86 -> 1602173162;
                case 87 -> 1924707480;
                case 88 -> -1437126654;
                case 89 -> -746362217;
                case 90 -> -207686379;
                case 91 -> 251340715;
                case 92 -> -867427681;
                case 93 -> -692390150;
                case 94 -> 2143179261;
                case 95 -> 688833099;
                case 96 -> -1720079936;
                case 97 -> -881793970;
                case 98 -> 1106903686;
                case 99 -> 907198278;
                case 100 -> 369095443;
                case 101 -> -567964690;
                case 102 -> -139612971;
                case 103 -> 296527066;
                case 104 -> 690084550;
                case 105 -> 1292031778;
                case 106 -> -1792647603;
                case 107 -> 1898198813;
                case 108 -> -977410311;
                case 109 -> 2001462972;
                case 110 -> -80079475;
                case 111 -> -236089087;
                case 112 -> 540937686;
                case 113 -> -1838938025;
                case 114 -> -1879053325;
                case 115 -> 1425498829;
                case 116 -> -885644407;
                case 117 -> 2094841787;
                case 118 -> 2139729867;
                case 119 -> 686791346;
                case 120 -> -1020273921;
                case 121 -> 1288742529;
                case 122 -> -1774645336;
                case 123 -> -1609497624;
                case 124 -> 111055945;
                case 125 -> 717971947;
                case 126 -> 1566022405;
                case 127 -> 640717877;
                case 128 -> -270241496;
                case 129 -> 467467852;
                case 130 -> 893009165;
                case 131 -> 434730606;
                case 132 -> 2012565322;
                case 133 -> 2121885808;
                case 134 -> 1001255030;
                case 135 -> -1405941053;
                case 136 -> 398177767;
                case 137 -> 78301967;
                case 138 -> -1695229731;
                case 139 -> -1130599136;
                case 140 -> -1473325302;
                case 141 -> -584574891;
                case 142 -> 1920467186;
                case 143 -> -1306705614;
                case 144 -> 1414015083;
                case 145 -> -498137184;
                case 146 -> -2017239160;
                case 147 -> -115097947;
                case 148 -> 268055063;
                case 149 -> 202586119;
                case 150 -> -911806538;
                case 151 -> 1669615284;
                case 152 -> -1422810566;
                case 153 -> -286631241;
                case 154 -> -240063453;
                case 155 -> 376389065;
                case 156 -> 1258604052;
                case 157 -> -807959761;
                case 158 -> 383948759;
                case 159 -> -1311426110;
                case 160 -> 348446336;
                case 161 -> 859180180;
                case 162 -> 1086456366;
                case 163 -> -1544836096;
                case 164 -> 434639065;
                case 165 -> -620319828;
                case 166 -> 1090569565;
                case 167 -> 655242265;
                case 168 -> -403978;
                case 169 -> -527985612;
                case 170 -> -1525109456;
                case 171 -> -1203063425;
                case 172 -> -1876220044;
                case 173 -> 235595764;
                case 174 -> 498907162;
                case 175 -> 767155067;
                case 176 -> -570759787;
                case 177 -> 1468836671;
                case 178 -> -1995575497;
                case 179 -> 1033762443;
                case 180 -> 1325534131;
                case 181 -> 1824265998;
                case 182 -> -211223345;
                case 183 -> -832664178;
                case 184 -> -1233727118;
                case 185 -> -465438342;
                case 186 -> -1969586086;
                case 187 -> -602464746;
                case 188 -> 1488243196;
                case 189 -> -1740083139;
                case 190 -> 630558886;
                case 191 -> -153890654;
                case 192 -> -448297275;
                case 193 -> 98978523;
                case 194 -> -1196893487;
                case 195 -> 754916734;
                case 196 -> -606572827;
                case 197 -> 240303736;
                case 198 -> -1192994092;
                case 199 -> -1137720956;
                case 200 -> -382223705;
                case 201 -> 1877759913;
                case 202 -> 170564582;
                case 203 -> -1078567951;
                case 204 -> 1355008591;
                case 205 -> -395823063;
                case 206 -> -410652324;
                case 207 -> -1405182034;
                case 208 -> -1695460671;
                case 209 -> -819125654;
                case 210 -> 638267200;
                case 211 -> 584058857;
                case 212 -> 1726611610;
                case 213 -> 1496308581;
                case 214 -> -182931112;
                case 215 -> 800479599;
                case 216 -> 979280166;
                case 217 -> -992159036;
                case 218 -> -1671834440;
                case 219 -> -1818593800;
                case 220 -> -1962611367;
                case 221 -> -1359651320;
                case 222 -> -840686791;
                case 223 -> 848837273;
                case 224 -> -2146930414;
                case 225 -> 1996773111;
                case 226 -> -1572543664;
                case 227 -> 782665661;
                case 228 -> 1111053518;
                case 229 -> 896644010;
                case 230 -> -1029000318;
                case 231 -> -999123513;
                case 232 -> 1195039376;
                case 233 -> -1937695563;
                case 234 -> 1002468316;
                case 235 -> 2082483885;
                case 236 -> 832497551;
                case 237 -> -353168380;
                case 238 -> -544492386;
                case 239 -> 645173540;
                case 240 -> 1962603183;
                case 241 -> 1758330275;
                case 242 -> 2129806661;
                case 243 -> -83234179;
                case 244 -> 1825969707;
                case 245 -> -1622759710;
                case 246 -> -240141404;
                case 247 -> -913967236;
                case 248 -> 1998013512;
                case 249 -> 35010372;
                case 250 -> 1186792175;
                case 251 -> -559050132;
                case 252 -> -1852460404;
                case 253 -> -1123702045;
                case 254 -> 1287210080;
                case 255 -> 315956867;
                default -> 366812103;
            });
        } while (v2 != 160);
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
            IOI0 = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        IO0i = -1593835521;
    }

    private void OOOO0(float param1, float param2, float param3) {
        PostProcessingModule.IoiO(param1, param2, param3, param3, this.RenderSupport_oii_4((Integer)this.0oI.HelpCommand()), ((Color)this.0oi.HelpCommand()).getRGB());
    }

    private void OOOOO() {
        long v1 = System.currentTimeMillis();
        if (this.OooI == 0L) {
            this.OooI = v1;
        }
        float v3 = Math.min(0.05f, (float)(v1 - this.OooI) / 1000.0f);
        this.OooI = v1;
        float v4 = 1.0f - (float)Math.pow(0.0015f, v3);
        float v5 = v3 * 8.0f;
        for (ConfigSupport_oio0_2 v7 : this.IOoO.values()) {
            v7.HudElement = false;
        }
        double v8 = RadarHudElement.ConfigSupport_OI0.player.method_23317();
        double v10 = RadarHudElement.ConfigSupport_OI0.player.method_23321();
        float v12 = (Boolean)this.IOo0.HelpCommand() != false ? (float)Math.toRadians(RadarHudElement.ConfigSupport_OI0.player.method_36454()) : 0.0f;
        float v13 = (float)Math.sin(v12);
        float v14 = (float)Math.cos(v12);
        float v15 = (float)this.RenderSupport_oii_4((Integer)this.RenderSupport_oiii_5.HelpCommand()) / ((float)((Integer)this.ioO.HelpCommand()).intValue() * 2.0f);
        float v16 = (float)this.RenderSupport_oii_4((Integer)this.RenderSupport_oiii_5.HelpCommand()) / 2.0f - this.ConfigSupport_OII(7.0f);
        for (Object v18 : RadarHudElement.ConfigSupport_OI0.world.method_18456()) {
            UUID v282;
            ConfigSupport_oio0_2 v29;
            float v27;
            float v26;
            float v25;
            if (v18 == RadarHudElement.ConfigSupport_OI0.player) continue;
            double v19 = v18.method_23317() - v8;
            double v21 = v18.method_23321() - v10;
            float v23 = (float)v19 * v15;
            float v24 = (float)v21 * v15;
            if (((Boolean)this.IOo0.HelpCommand()).booleanValue()) {
                v25 = -v23 * v14 - v24 * v13;
                v26 = -v23 * v13 + v24 * v14;
                v23 = v25;
                v24 = -v26;
            }
            float f = (v25 = v23 * v23 + v24 * v24) > (v26 = v16 * v16) ? (float)Math.sqrt(v25) : (v27 = v25 == 0.0f ? 0.0f : v16);
            if (v25 > v26 && v27 > 0.0f) {
                float v282 = v16 / v27;
                v23 *= v282;
                v24 *= v282;
            }
            if ((v29 = (ConfigSupport_oio0_2)this.IOoO.get(v282 = v18.method_5667())) == null) {
                v29 = new ConfigSupport_oio0_2(v23, v24);
                this.IOoO.put(v282, v29);
            }
            v29.PacketEvent = this.oIoo(v29.PacketEvent, v23, v4);
            v29.HelpCommand = this.oIoo(v29.HelpCommand, v24, v4);
            v29.OOo = Math.min(1.0f, v29.OOo + v5);
            v29.GuiSupport_OOI = v18 == RadarHudElement.ConfigSupport_OI0.player;
            v29.OOi = v25 >= (v16 - 0.5f) * (v16 - 0.5f);
            v29.HudElement = true;
        }
        Iterator<Object> v17 = this.IOoO.entrySet().iterator();
        while (v17.hasNext()) {
            Object v18;
            v18 = (ConfigSupport_oio0_2)((Map.Entry)v17.next()).getValue();
            if (v18.HudElement) continue;
            v18.OOo -= v5;
            if (!(v18.OOo <= 0.01f)) continue;
            v17.remove();
        }
    }

    private int 0IOO(int param1, int param2) {
        return Math.max(0, Math.min(255, param2)) << 24 | param1 & 0xFFFFFF;
    }

    public RadarHudElement() {
        super("Radar", "Display nearby players", 110.0f, 110.0f);
        this.RenderSupport_oiii_5 = this.OOi0o("Size", 110, 70, 180);
        this.ioO = this.OOi0o("Range", 80, 20, 220);
        this.0oI = this.OOi0o("Radius", 6, 0, 18);
        this.IOo0 = this.OOi00("Rotate", true);
        this.IOoo = this.OOi00("ShowSelf", true);
        this.IOoI = this.OOi00("FadeEdge", true);
        this.0oi = this.OOioo("BackgroundColor", 18, 18, 24, 120);
        this.IOoi = this.OOioo("PlayerColor", 255, 95, 185, 255);
        this.IOIO = this.OOioo("SelfColor", 120, 190, 255, 255);
    }

    private void OOOOI(float param1, float param2) {
        RenderSupport_00oi_0.O0o(param1 - this.ConfigSupport_OII(2.0f), param2 - this.ConfigSupport_OII(2.0f), this.ConfigSupport_OII(4.0f), this.ConfigSupport_OII(4.0f), this.ConfigSupport_OII(2.0f), ((Color)this.IOIO.HelpCommand()).getRGB());
    }

    private float oIoo(float param1, float param2, float param3) {
        return param1 + (param2 - param1) * Math.max(0.0f, Math.min(1.0f, param3));
    }

    private void OOOOo(float param1, float param2, float param3) {
        float v4 = param3 / 2.0f;
        RenderSupport_00oi_0.O0o(param1 + v4 - this.ConfigSupport_OII(0.5f), param2 + this.ConfigSupport_OII(8.0f), this.ConfigSupport_OII(1.0f), param3 - this.ConfigSupport_OII(16.0f), 0.0f, -1593835521);
        RenderSupport_00oi_0.O0o(param1 + this.ConfigSupport_OII(8.0f), param2 + v4 - this.ConfigSupport_OII(0.5f), param3 - this.ConfigSupport_OII(16.0f), this.ConfigSupport_OII(1.0f), 0.0f, -1593835521);
    }

    private void OOOOi(float param1, float param2, float param3) {
        for (ConfigSupport_oio0_2 v5 : this.IOoO.values()) {
            if (v5.OOo <= 0.01f) continue;
            float v6 = v5.OOi && (Boolean)this.IOoI.HelpCommand() != false ? 0.65f : 1.0f;
            int v7 = v5.GuiSupport_OOI ? ((Color)this.IOIO.HelpCommand()).getRGB() : ((Color)this.IOoi.HelpCommand()).getRGB();
            int v8 = this.0IOO(v7, Math.round((float)(v7 >>> 24 & 0xFF) * v5.OOo * v6));
            float v9 = this.ConfigSupport_OII(v5.GuiSupport_OOI ? 4.0f : 5.0f);
            float v10 = param1 + v5.PacketEvent - v9 / 2.0f;
            float v11 = param2 + v5.HelpCommand - v9 / 2.0f;
            RenderSupport_00oi_0.O0o(v10, v11, v9, v9, v9 / 2.0f, v8);
        }
    }

    @Override
    protected void OoO(GuiSupport_0oo_2 param1) {
        if (RadarHudElement.iooI()) {
            return;
        }
        PostProcessingModule.Ioio(this.GuiSupport_OOI(), this.OOi(), this.RenderSupport_oii_4((Integer)this.RenderSupport_oiii_5.HelpCommand()), this.RenderSupport_oii_4((Integer)this.RenderSupport_oiii_5.HelpCommand()), this.RenderSupport_oii_4((Integer)this.0oI.HelpCommand()));
    }

    @Override
    protected void O0i(ScaledDrawContext param1) {
        super.O0i(param1);
        if (RadarHudElement.iooI()) {
            return;
        }
        this.OOOOO();
        float v2 = this.RenderSupport_oii_4((Integer)this.RenderSupport_oiii_5.HelpCommand());
        float v3 = this.GuiSupport_OOI();
        float v4 = this.OOi();
        float v5 = v3 + v2 / 2.0f;
        float v6 = v4 + v2 / 2.0f;
        this.OOOO0(v3, v4, v2);
        this.OOOOo(v3, v4, v2);
        if (((Boolean)this.IOoo.HelpCommand()).booleanValue()) {
            this.OOOOI(v5, v6);
        }
        this.OOOOi(v5, v6, v2);
        this.Oii(v3, v4, v2, v2);
    }
}

