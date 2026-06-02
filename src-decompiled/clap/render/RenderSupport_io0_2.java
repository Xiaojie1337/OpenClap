/*
 * Decompiled with CFR 0.152.
 */
package clap.render;

import java.io.InputStream;
import java.nio.FloatBuffer;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import org.lwjgl.BufferUtils;
import clap.render.RenderSupport_00io_1;
import clap.module.client.streamproof.StreamproofLogger;
import clap.core.NativeEntrypointBridge;

/*
 * Renamed from psx.Hyk.io0
 */
public class RenderSupport_io0_2 {
    private final Map HelpCommand = new HashMap();
    private int GuiSupport_OOI = -1;
    private final int PacketEvent;
    private int OOo = -1;
    static Object OOi;
    private static volatile /* synthetic */ long __k__gH4it;

    public void OOo(String param1, float param2, float param3) {
        int v4 = this.OOi(param1);
        if (v4 != -1) {
            RenderSupport_00io_1.0oI(v4, param2, param3);
        }
    }

    static {
        __k__gH4it = RenderSupport_io0_2.__k__gH4it((long)3563081481607704081L);
        __rP__gH4it0 = new String[]{"\ud183\ub9cb\u67de\u3237\ub5e4\ud140\u6248\u64d8\ud09d\ub8a1", "\ud195\ub9c4\u67dd\u325e\ub584\ud123\u6239\u64c7\ud099\ub8d2\u66d5\u333a\ub4ea\ud029\u6313\u6584\ud3a5\ubbf8\u65f0\u3006"};
        __rP__gH4it1 = new String[]{"\ud116\ub91f\u6765\u32fa\ub562\ud117\u62d9\u6459"};
        __rP__gH4it2 = new String[]{"\ud13c\ub907\u67ab\u3208\ub44a\ud0cb\u634f\u65bd\ud071\ub8fe\u66e3\u332b\ub454\ud391\u6092\u6631\ud3fd\ubbe4\u65e4\u3063\ub798\ud2f2\u61b0\u679b\ud29b\uba07\u64dd\u3134\ub6f8\udddc\u6ed5\u68d6\udd23\ub506\u6bdc\u3e67\ub985\udccc\u6f92\u69ef\udc77\ub448\u6af4\u3f7d\ub860\udcc5\u6caa\u6a32\udfa9\ub7fc\u69ac\u3c47\ubb40\udf01\u6da9\u6b5f\udef3\ub6f3\u6868\u3d1c\uba5d\ude50\u6a9d\u6cb2\ud99f\ub147\u6f0e\u3a43\ubdaf\ud9c5\u6a6f\u6d92\ud810\ub085\u6e87\u3b3b\ubccc\ud8e3\u6b97\u6e49\udb55\ub3a4\u6d9a\u3853\ubff0\udbfd\u68ef\u6fa1\uda37\ub2ac\u6c35\u3999\ubec9\udae1\u69cc\u70c6\uc5f9\uaddc\u738c\u269a\ua168\uc5c4\u7640\u706d\uc47f\uacda\u7202\u2757\ua08f\uc4e0\u777e\u7122\uc7a4\uafe5\u716c\u245f\ua32c\uc719\u74cd\u72bb\uc646\uaedb\u705e\u250f\ua2ee\uc6e1\u75d4\u73e0", "\ud181\ub9cd\u67d8\u3235\ub5e6\ud14e\u6246\u64da\ud09f\ub8a7", "\ud193\ub9de\u67de\u324f\ub5e4\ud17b\u623d"};
        __rP__gH4it3 = new String[]{"\ud183\ub9d2\u67cf", "\ud196\ub9c7\u67de\u324a\ub5ed"};
        byte[] v0 = "}\u0016\u00b5\u00e9\u001d:\u00c5\u00e5\u00c8\u00d7\u0085\u00f2\u00fbX\u0010aL\u00c5\u008a\u00b2?3*\u00d32>\u00ab\u00fdG\u0005G\u0096\u00827\u00a2\u00a62\u001d8\u00d7\u00ee\u0081\u00b2\u00c4\u00ef\u00ec\b\u00028=\u00e2\u00f6\u00c7 \u0013wz*>\u00b5\u00c2i/\u0092\u001e\u0096P\u00e28\u00f4%\u008a\u00e9l!\u00a2#\u00ea\u00d5Y\u00a4E4\u00c2\u0017\u00fc\u00b5\u00a9\u00deU\u0083\u00106\u00f8\u009e\u00c6\u0018-2\u001b\u009f\u00d5*\u0095\u00a6S\u0084.@\u0089\u001c\u00d2ud\u00e2.\u00ebx\u00b7S\u008fB\u00c8f1\u0098\u00a6\u0000".getBytes("ISO_8859_1");
        Object[] v1 = "\u00dd\u0084\u00f5\u0095\u00bfl\u00a5\u00b7".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1961836703;
                case 1 -> -1736172029;
                case 2 -> -1129818083;
                case 3 -> 857783235;
                case 4 -> -283144477;
                case 5 -> 2070198675;
                case 6 -> 266599008;
                case 7 -> -1359152111;
                case 8 -> -1905047913;
                case 9 -> 1680701669;
                case 10 -> -1863785403;
                case 11 -> 1986740080;
                case 12 -> 1188835834;
                case 13 -> -774387143;
                case 14 -> -775513138;
                case 15 -> -1198925965;
                case 16 -> -1957667380;
                case 17 -> 845508712;
                case 18 -> -1709406754;
                case 19 -> 446052431;
                case 20 -> -1602253878;
                case 21 -> 1459698759;
                case 22 -> 613677462;
                case 23 -> -1337990864;
                case 24 -> 842358411;
                case 25 -> -421671289;
                case 26 -> 794843784;
                case 27 -> 1408651325;
                case 28 -> -897095646;
                case 29 -> 908667407;
                case 30 -> 2016773804;
                case 31 -> -736693626;
                case 32 -> -1820131703;
                case 33 -> -461033144;
                case 34 -> 476384167;
                case 35 -> -1631899649;
                case 36 -> 1223227160;
                case 37 -> -454925698;
                case 38 -> 299300242;
                case 39 -> 1966482453;
                case 40 -> -2017215101;
                case 41 -> 1083923933;
                case 42 -> -40159307;
                case 43 -> -313218026;
                case 44 -> -1887025190;
                case 45 -> 243604930;
                case 46 -> -853743016;
                case 47 -> -932599220;
                case 48 -> -1037503205;
                case 49 -> -846144725;
                case 50 -> -405736634;
                case 51 -> 1247532923;
                case 52 -> -1734124325;
                case 53 -> 114952330;
                case 54 -> -1798453694;
                case 55 -> 210336200;
                case 56 -> -1787792821;
                case 57 -> -842275278;
                case 58 -> 1381127971;
                case 59 -> 1286193719;
                case 60 -> -507721498;
                case 61 -> 1001362607;
                case 62 -> -1457621846;
                case 63 -> 1713029982;
                case 64 -> 2041878486;
                case 65 -> 1202497838;
                case 66 -> 1256133745;
                case 67 -> 663104319;
                case 68 -> 56747522;
                case 69 -> -1705794352;
                case 70 -> -1642769879;
                case 71 -> -1363786141;
                case 72 -> -269936636;
                case 73 -> 90886449;
                case 74 -> -754505307;
                case 75 -> -1273500499;
                case 76 -> 1257541556;
                case 77 -> -1020560294;
                case 78 -> 414524794;
                case 79 -> -33726484;
                case 80 -> 1980121915;
                case 81 -> 1151756302;
                case 82 -> -423585136;
                case 83 -> -1937687792;
                case 84 -> -143625207;
                case 85 -> 853806618;
                case 86 -> -1243472945;
                case 87 -> -517473531;
                case 88 -> -584786962;
                case 89 -> -87686071;
                case 90 -> 340278584;
                case 91 -> 877772832;
                case 92 -> -56886530;
                case 93 -> 1039437103;
                case 94 -> 842195724;
                case 95 -> 225791818;
                case 96 -> 2030860864;
                case 97 -> 1551648351;
                case 98 -> -1113613714;
                case 99 -> 1429764083;
                case 100 -> 2051320064;
                case 101 -> -663923332;
                case 102 -> -568340891;
                case 103 -> -653696904;
                case 104 -> 1324781593;
                case 105 -> 135178794;
                case 106 -> 339333794;
                case 107 -> 1243570644;
                case 108 -> 1734947163;
                case 109 -> -1454562881;
                case 110 -> -1505622189;
                case 111 -> -318676071;
                case 112 -> -1618483443;
                case 113 -> -885546307;
                case 114 -> -1616273108;
                case 115 -> -1910831833;
                case 116 -> 1265825641;
                case 117 -> -707359154;
                case 118 -> 2073351672;
                case 119 -> 1925768063;
                case 120 -> -431832666;
                case 121 -> 2126383460;
                case 122 -> -1469945861;
                case 123 -> 668453283;
                case 124 -> 1105278936;
                case 125 -> 1184889389;
                case 126 -> -1276448584;
                case 127 -> 1979300904;
                case 128 -> -1359775743;
                case 129 -> -618930967;
                case 130 -> 803096269;
                case 131 -> -714142239;
                case 132 -> -284707605;
                case 133 -> -447241525;
                case 134 -> 252306955;
                case 135 -> 1397811610;
                case 136 -> 1876541292;
                case 137 -> 2060341072;
                case 138 -> 935021708;
                case 139 -> -1882316171;
                case 140 -> 2126707099;
                case 141 -> 2004229319;
                case 142 -> 1763545085;
                case 143 -> -729671200;
                case 144 -> -309303599;
                case 145 -> 2015962868;
                case 146 -> -106842667;
                case 147 -> -132576594;
                case 148 -> 1078208723;
                case 149 -> 1197022757;
                case 150 -> -948595722;
                case 151 -> 133439381;
                case 152 -> -1946832207;
                case 153 -> 902260260;
                case 154 -> 1510289770;
                case 155 -> 1689455939;
                case 156 -> -195666424;
                case 157 -> -1031760771;
                case 158 -> 1488911474;
                case 159 -> -89118660;
                case 160 -> 1435912649;
                case 161 -> -369929284;
                case 162 -> 1343440146;
                case 163 -> -1898505476;
                case 164 -> 1841274553;
                case 165 -> -1863842140;
                case 166 -> 908844055;
                case 167 -> 973981764;
                case 168 -> 1901897700;
                case 169 -> 1990180659;
                case 170 -> 895530526;
                case 171 -> 1424620184;
                case 172 -> -1247848676;
                case 173 -> 1857441874;
                case 174 -> 792396177;
                case 175 -> 1776670341;
                case 176 -> 881273000;
                case 177 -> -255023150;
                case 178 -> -265812620;
                case 179 -> -1594863121;
                case 180 -> 2146201985;
                case 181 -> 1052616001;
                case 182 -> -1374569930;
                case 183 -> 1263931830;
                case 184 -> -47800289;
                case 185 -> -76471305;
                case 186 -> -1289028447;
                case 187 -> 1171419737;
                case 188 -> 1584722117;
                case 189 -> 1636166031;
                case 190 -> -828789419;
                case 191 -> 1197449303;
                case 192 -> -2019064002;
                case 193 -> -1018911042;
                case 194 -> -1635169483;
                case 195 -> -1856503104;
                case 196 -> -889118268;
                case 197 -> 1507546999;
                case 198 -> 383039133;
                case 199 -> -269853822;
                case 200 -> -2144884461;
                case 201 -> -100562668;
                case 202 -> -451005686;
                case 203 -> 1678076338;
                case 204 -> -746823687;
                case 205 -> 756774237;
                case 206 -> -619125858;
                case 207 -> -252255251;
                case 208 -> -1499825809;
                case 209 -> -1459951173;
                case 210 -> 976700912;
                case 211 -> -616229258;
                case 212 -> -314220580;
                case 213 -> -1162190887;
                case 214 -> 1025930144;
                case 215 -> -1693872047;
                case 216 -> -84024919;
                case 217 -> 337632471;
                case 218 -> 867576964;
                case 219 -> -41512804;
                case 220 -> 923276409;
                case 221 -> 2075810125;
                case 222 -> -515249043;
                case 223 -> -2028459327;
                case 224 -> 220311590;
                case 225 -> 801498987;
                case 226 -> -51409978;
                case 227 -> 1664965105;
                case 228 -> 985865524;
                case 229 -> -1206929322;
                case 230 -> -386121486;
                case 231 -> -746294777;
                case 232 -> -1178366458;
                case 233 -> 1557451618;
                case 234 -> 785967393;
                case 235 -> -1964399969;
                case 236 -> 333105500;
                case 237 -> 1160452063;
                case 238 -> 2125660906;
                case 239 -> 552435701;
                case 240 -> 1426164403;
                case 241 -> 942524474;
                case 242 -> -497570418;
                case 243 -> 1637141175;
                case 244 -> -1218731436;
                case 245 -> 1310973671;
                case 246 -> 1121102183;
                case 247 -> -991827820;
                case 248 -> -2140852760;
                case 249 -> 1265089920;
                case 250 -> 432221030;
                case 251 -> -1939098227;
                case 252 -> -20016198;
                case 253 -> 2067602603;
                case 254 -> 905242288;
                case 255 -> -1615020830;
                default -> -1324800252;
            });
        } while (v2 != 128);
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
            Object[] objectArray = new Object[3];
            v1 = objectArray;
            OOi = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
    }

    private int OOi(String param12) {
        return this.HelpCommand.computeIfAbsent(param12, param1 -> RenderSupport_00io_1.0o0(this.PacketEvent, param1));
    }

    private static String HudElement(String param0) throws Exception {
        try (InputStream v1 = RenderSupport_io0_2.class.getResourceAsStream(param0);){
            if (v1 == null) {
                throw new IllegalStateException("missing resource " + param0);
            }
            String v2 = new String(v1.readAllBytes(), StandardCharsets.UTF_8);
            return v2;
        }
    }

    public void GuiSupport_OOI() {
        if (this.PacketEvent == -1) {
            return;
        }
        if (this.OOo == -1) {
            float[] v1 = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f};
            FloatBuffer v2 = BufferUtils.createFloatBuffer(12);
            v2.put(v1).flip();
            this.OOo = RenderSupport_00io_1.O0o();
            this.GuiSupport_OOI = RenderSupport_00io_1.ConfigSupport_O0I();
            RenderSupport_00io_1.Kernel32SnapshotApi(this.OOo);
            RenderSupport_00io_1.StorageEspModule(34962, this.GuiSupport_OOI);
            RenderSupport_00io_1.ConfigSupport_00o_0(34962, v2, 35044);
            RenderSupport_00io_1.DataRecord_00I(0, 2, 5126, false, 8, 0L);
            RenderSupport_00io_1.00i(0);
            RenderSupport_00io_1.Kernel32SnapshotApi(0);
            RenderSupport_00io_1.StorageEspModule(34962, 0);
        }
        RenderSupport_00io_1.Kernel32SnapshotApi(this.OOo);
        RenderSupport_00io_1.0oO(4, 0, 6);
        RenderSupport_00io_1.Kernel32SnapshotApi(0);
    }

    public void PacketEvent() {
        if (this.PacketEvent == -1) {
            return;
        }
        RenderSupport_00io_1.OiI(this.PacketEvent);
        this.OOo("uResolution", StreamproofLogger.EventBusApi == null ? 1.0f : (float)StreamproofLogger.EventBusApi.getFramebufferWidth(), StreamproofLogger.EventBusApi == null ? 1.0f : (float)StreamproofLogger.EventBusApi.getFramebufferHeight());
    }

    public RenderSupport_io0_2(String param1) {
        int v2 = -1;
        try {
            String v3 = RenderSupport_io0_2.HudElement("/assets/streamproof/shaders/" + param1 + ".vert");
            String v4 = RenderSupport_io0_2.HudElement("/assets/streamproof/shaders/" + param1 + ".frag");
            int v5 = RenderSupport_00io_1.DataRecord_0O0(35633, v3, param1 + ".vert");
            int v6 = RenderSupport_00io_1.DataRecord_0O0(35632, v4, param1 + ".frag");
            v2 = RenderSupport_00io_1.Oii();
            if (!RenderSupport_00io_1.0Oo(v2, v5, v6)) {
                NativeEntrypointBridge.OOo.error("[Streamproof] shader link failed {}: {}", (Object)param1, (Object)RenderSupport_00io_1.PacketEvent);
                v2 = -1;
            }
            RenderSupport_00io_1.EnumType_0OI(v5);
            RenderSupport_00io_1.EnumType_0OI(v6);
        }
        catch (Throwable v3) {
            NativeEntrypointBridge.OOo.error("[Streamproof] failed to load shader {}", (Object)param1, (Object)v3);
        }
        this.PacketEvent = v2;
    }

    public void HelpCommand(String param1, int param2, int param3) {
        int v4 = this.OOi(param1);
        if (v4 == -1) {
            return;
        }
        RenderSupport_00io_1.OoO(param3, param2);
        RenderSupport_00io_1.SpawnerFinderModule(v4, param3);
    }
}

