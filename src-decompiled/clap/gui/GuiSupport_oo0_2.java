/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.DrawContext
 *  org.lwjgl.glfw.GLFW
 */
package clap.gui;

import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.gui.DrawContext;
import org.lwjgl.glfw.GLFW;
import clap.network.NetworkSupport_00OI;
import clap.gui.screen.AuthScreen;

/*
 * Renamed from psx.Hyk.oo0
 */
final class GuiSupport_oo0_2 {
    private final boolean HelpCommand;
    private final String PacketEvent;
    final /* synthetic */ AuthScreen O0o;
    private float EventBusApi;
    private float GuiSupport_OOI;
    private float OOi;
    private String OOo = "";
    private float HudElement;
    static Object ConfigSupport_O0I;
    private static volatile /* synthetic */ long __k__gH4it;

    static {
        __k__gH4it = GuiSupport_oo0_2.__k__gH4it((long)1260399456654716433L);
        __rP__gH4it0 = new String[]{"\u9a69\uadbf\u73aa\u260b\ua118\uf17c\uec00\u7076\u8577\uacd5"};
        __rP__gH4it1 = new String[]{"\u9ac5\ub210\u7387\u2662\ua109\uf121\uecae\u7075\u857e\uadb3\u730a\u2706\ua0be\uf035\uedd5\u715e\u84c4\uacb9\u7258\u24bf\ua3d3\uf31c\ueec6\u7253\u8790\uaf66\u714a\u250c\ua274\uf2ef\uefbb\u7378\u86fb\uae01\u7009\u22b1\ua5bb\uf543\ue808\u74e4\u8197\ua978\u77f0\u225e\ua40b\uf40d\ue975\u751e", "\u9a6b\uadb1\u73a4\u2609\ua11a\uf17a\uec06\u7074\u8575\uaccb", "\u9ae1\uada2\u73cf\u268a\ua169\uf11f\uecec\u7016", "\u9a7b\uadac\u73ac\u2661\ua10a\uf169\uec1b"};
        __rP__gH4it2 = new String[]{"\u9a7e\uadb1\u73b4\u2660\ua103"};
        __rP__gH4it3 = new String[]{"\u9a7d\uadb2\u73af\u266c\ua14a\uf1ed\uec5f\u700f\u8551\uad44\u7287\u2768\ua034\uf0f7\ued75\u714c\u846d\uac6e\u71a2\u2454", "\u9a6b\uada4\u73bd"};
        byte[] v0 = "\u00dc\u0007[A`\u00aeRu\u001f\u009c.\u001d\u00df\u00b2!V\u00ad\u009et\u00ac\u00aa\u0083*C\u00e1Y~\u0007\u0005x_`\u008265\u00b2\u00f2\u00ac\u00d4\u0004\u00d67\u00f4\u00a5J\u00ea\u00a1\u00f6".getBytes("ISO_8859_1");
        Object[] v1 = "\u00c2O%\u00dfJZ\u00deX".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 2033073680;
                case 1 -> -1160075064;
                case 2 -> -381403352;
                case 3 -> 821535827;
                case 4 -> 262723483;
                case 5 -> 522503508;
                case 6 -> -1361298924;
                case 7 -> -430485628;
                case 8 -> -1408171707;
                case 9 -> -940529176;
                case 10 -> -43365560;
                case 11 -> -1030740468;
                case 12 -> 1601063589;
                case 13 -> 1155018822;
                case 14 -> -1774713596;
                case 15 -> -1003149510;
                case 16 -> 1847046159;
                case 17 -> -641359949;
                case 18 -> 721220299;
                case 19 -> 135488425;
                case 20 -> -1067777337;
                case 21 -> 2083726034;
                case 22 -> 1271422311;
                case 23 -> 1553035622;
                case 24 -> 348746492;
                case 25 -> -1795178869;
                case 26 -> -1382494165;
                case 27 -> 1695524355;
                case 28 -> -1832703593;
                case 29 -> -1294925266;
                case 30 -> 1493252770;
                case 31 -> 2119961528;
                case 32 -> -886768736;
                case 33 -> -1968637265;
                case 34 -> -775492288;
                case 35 -> -652792977;
                case 36 -> -946307302;
                case 37 -> 1489772277;
                case 38 -> -1889341735;
                case 39 -> -854253377;
                case 40 -> -533187378;
                case 41 -> -745843125;
                case 42 -> -1912321365;
                case 43 -> 60325481;
                case 44 -> -532778967;
                case 45 -> -1740489145;
                case 46 -> -1353163143;
                case 47 -> 1677398017;
                case 48 -> -695254906;
                case 49 -> -115719414;
                case 50 -> -1657189531;
                case 51 -> 2033348088;
                case 52 -> 1666875323;
                case 53 -> -869839870;
                case 54 -> -441315789;
                case 55 -> 2094853619;
                case 56 -> -1709914525;
                case 57 -> -897906767;
                case 58 -> -892672896;
                case 59 -> 677741930;
                case 60 -> -1411712635;
                case 61 -> -333970110;
                case 62 -> 1753742395;
                case 63 -> -1802272668;
                case 64 -> -1690463658;
                case 65 -> 1014906652;
                case 66 -> 1001365229;
                case 67 -> -1513805116;
                case 68 -> -1532101928;
                case 69 -> -417415540;
                case 70 -> 193742657;
                case 71 -> 90366720;
                case 72 -> -812023360;
                case 73 -> -1147377527;
                case 74 -> -1020107157;
                case 75 -> 1510616569;
                case 76 -> 417516283;
                case 77 -> 1939619021;
                case 78 -> -619139161;
                case 79 -> 365340446;
                case 80 -> -1054620717;
                case 81 -> 1732738087;
                case 82 -> -1119013008;
                case 83 -> -1230436384;
                case 84 -> -1120961522;
                case 85 -> -1362718426;
                case 86 -> -1400841812;
                case 87 -> 141201799;
                case 88 -> -420714718;
                case 89 -> -2044485394;
                case 90 -> 2076541921;
                case 91 -> -942828912;
                case 92 -> -48961107;
                case 93 -> 40901602;
                case 94 -> 426996094;
                case 95 -> -799940950;
                case 96 -> 2062891291;
                case 97 -> 586735298;
                case 98 -> 242515464;
                case 99 -> -1260495743;
                case 100 -> -484772595;
                case 101 -> 738754550;
                case 102 -> -1955328957;
                case 103 -> -1435558612;
                case 104 -> -497290398;
                case 105 -> 711980263;
                case 106 -> 308619676;
                case 107 -> 48859460;
                case 108 -> 685713316;
                case 109 -> -334904945;
                case 110 -> -742921289;
                case 111 -> 70163421;
                case 112 -> -2043954828;
                case 113 -> -1846791919;
                case 114 -> 1051868302;
                case 115 -> -1231207848;
                case 116 -> -1729131063;
                case 117 -> -649892788;
                case 118 -> 1257209847;
                case 119 -> -994748948;
                case 120 -> -1401951965;
                case 121 -> 135552621;
                case 122 -> -1722953394;
                case 123 -> -978471727;
                case 124 -> 1907094847;
                case 125 -> 263569460;
                case 126 -> -1681471653;
                case 127 -> 1154909576;
                case 128 -> 2053257848;
                case 129 -> 1876737210;
                case 130 -> -1726157194;
                case 131 -> -1580555075;
                case 132 -> 1705472150;
                case 133 -> -152110083;
                case 134 -> 707164529;
                case 135 -> 112945;
                case 136 -> -909236177;
                case 137 -> -282848334;
                case 138 -> -32452518;
                case 139 -> 159812725;
                case 140 -> 725888549;
                case 141 -> 672968156;
                case 142 -> -2139095882;
                case 143 -> 1319861810;
                case 144 -> -452741846;
                case 145 -> -1439314796;
                case 146 -> -752348103;
                case 147 -> -1244573482;
                case 148 -> 1250139981;
                case 149 -> -1874650562;
                case 150 -> 1269708061;
                case 151 -> 1223857306;
                case 152 -> -1913424336;
                case 153 -> 1573068140;
                case 154 -> -511597188;
                case 155 -> -320309346;
                case 156 -> -45814523;
                case 157 -> 1196208814;
                case 158 -> 892674104;
                case 159 -> 1183037961;
                case 160 -> -296881375;
                case 161 -> -383432730;
                case 162 -> -689208809;
                case 163 -> 2111768089;
                case 164 -> -2090090464;
                case 165 -> 954438494;
                case 166 -> 1525299805;
                case 167 -> 1325270139;
                case 168 -> 801133783;
                case 169 -> -2097487184;
                case 170 -> -2053682115;
                case 171 -> 706663668;
                case 172 -> 1101617350;
                case 173 -> -1471733809;
                case 174 -> 978303905;
                case 175 -> 878299007;
                case 176 -> -2069340294;
                case 177 -> -1032701433;
                case 178 -> -304173631;
                case 179 -> 210077702;
                case 180 -> 1591865161;
                case 181 -> -863002995;
                case 182 -> -1523801206;
                case 183 -> -15462541;
                case 184 -> 1524222866;
                case 185 -> -539837636;
                case 186 -> 910265087;
                case 187 -> 536808530;
                case 188 -> 1500017650;
                case 189 -> 1058141587;
                case 190 -> -1137995183;
                case 191 -> -903830070;
                case 192 -> 1263457881;
                case 193 -> -1894290024;
                case 194 -> 1359479076;
                case 195 -> -1581274444;
                case 196 -> 982158358;
                case 197 -> -1177195440;
                case 198 -> -74812212;
                case 199 -> 719630229;
                case 200 -> 450772465;
                case 201 -> -1616084573;
                case 202 -> -768458339;
                case 203 -> -1384143874;
                case 204 -> -1540951789;
                case 205 -> -1337098780;
                case 206 -> 488962793;
                case 207 -> -943992349;
                case 208 -> -917474096;
                case 209 -> 480374184;
                case 210 -> 1671441041;
                case 211 -> 475686378;
                case 212 -> -246935611;
                case 213 -> -1597391230;
                case 214 -> -228334025;
                case 215 -> -842405700;
                case 216 -> 1030633311;
                case 217 -> 15014841;
                case 218 -> 1486536671;
                case 219 -> 1630750589;
                case 220 -> 134021207;
                case 221 -> -1722953260;
                case 222 -> 1608197861;
                case 223 -> -1927588768;
                case 224 -> -1780324112;
                case 225 -> -1286364575;
                case 226 -> 489253141;
                case 227 -> -675160102;
                case 228 -> 1206571605;
                case 229 -> 1321430638;
                case 230 -> 1403042834;
                case 231 -> -1604988797;
                case 232 -> -2012659974;
                case 233 -> 1723405465;
                case 234 -> -1596126689;
                case 235 -> -1113071435;
                case 236 -> 911219902;
                case 237 -> 1371042072;
                case 238 -> -425297304;
                case 239 -> -1417946806;
                case 240 -> 2131149790;
                case 241 -> 705289014;
                case 242 -> 1744494671;
                case 243 -> -684554633;
                case 244 -> 628418243;
                case 245 -> 1612383285;
                case 246 -> -660566293;
                case 247 -> -343627813;
                case 248 -> 1589551573;
                case 249 -> -311614049;
                case 250 -> -1590609937;
                case 251 -> -1817600211;
                case 252 -> 448847730;
                case 253 -> -1884958554;
                case 254 -> 1027791452;
                case 255 -> -2033535221;
                default -> -410565370;
            });
        } while (v2 != 48);
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
            Object[] objectArray = new Object[5];
            v1 = objectArray;
            ConfigSupport_O0I = objectArray;
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

    private void OOo(int param1) {
        if (this.O0o() && param1 == 86) {
            this.OOi();
            return;
        }
        if (this.O0o() && param1 == 67) {
            this.HudElement();
            return;
        }
        if (param1 == 259 && !this.OOo.isEmpty()) {
            this.OOo = this.OOo.substring(0, this.OOo.length() - 1);
        }
        if (param1 == 261) {
            this.OOo = "";
        }
    }

    private boolean HelpCommand(double param1, double param3) {
        return this.O0o.Ooio(param1, param3, this.GuiSupport_OOI, this.OOi, this.HudElement, this.EventBusApi);
    }

    private boolean O0o() {
        long v1 = AuthScreen.OIoO(this.O0o).getWindow().getHandle();
        return GLFW.glfwGetKey((long)v1, (int)341) == 1 || GLFW.glfwGetKey((long)v1, (int)345) == 1 || GLFW.glfwGetKey((long)v1, (int)343) == 1 || GLFW.glfwGetKey((long)v1, (int)347) == 1;
    }

    private GuiSupport_oo0_2(AuthScreen param1, String param2) {
        this(param1, param2, false);
    }

    private void OOi() {
        if (AuthScreen.OIOi(this.O0o) == null || AuthScreen.EnumType_OI0O((AuthScreen)this.O0o).keyboard == null) {
            return;
        }
        this.EventBusApi(AuthScreen.RotationModule((AuthScreen)this.O0o).keyboard.getClipboard());
    }

    private void EventBusApi(String param1) {
        if (param1 == null || param1.isEmpty()) {
            return;
        }
        String v2 = param1.replace("\r", "").replace("\n", "");
        int v3 = 64 - this.OOo.length();
        if (v3 <= 0) {
            return;
        }
        this.OOo = this.OOo + v2.substring(0, Math.min(v3, v2.length()));
    }

    private void GuiSupport_OOI(int param1) {
        if (Character.isISOControl(param1)) {
            return;
        }
        this.EventBusApi(new String(Character.toChars(param1)));
    }

    private void HudElement() {
        if (AuthScreen.OI0o(this.O0o) == null || AuthScreen.CameraClipModule((AuthScreen)this.O0o).keyboard == null || this.OOo.isEmpty()) {
            return;
        }
        AuthScreen.OI0i((AuthScreen)this.O0o).keyboard.setClipboard(this.OOo);
    }

    private void PacketEvent(DrawContext param1, float param2, float param3, float param4, boolean param5) {
        boolean v6;
        this.GuiSupport_OOI = param2;
        this.OOi = param3;
        this.HudElement = param4;
        this.EventBusApi = 36.0f;
        param1.fill(Math.round(param2), Math.round(param3), Math.round(param2 + param4), Math.round(param3 + this.EventBusApi), param5 ? -283105224 : -669442260);
        param1.drawStrokedRectangle(Math.round(param2), Math.round(param3), Math.round(param4), Math.round(this.EventBusApi), param5 ? -1518553089 : 945515394);
        boolean bl = v6 = this.OOo.isEmpty() && !param5;
        String v7 = v6 ? this.PacketEvent : (this.HelpCommand ? "*".repeat(this.OOo.length()) : this.OOo);
        this.O0o.oIO(param1, NetworkSupport_00OI.OoO(29), v7 + (param5 && this.O0o.0ii() ? "_" : ""), param2 + 10.0f, param3 + 9.0f, v6 ? -8615269 : -722949);
    }

    private GuiSupport_oo0_2(AuthScreen param1, String param2, boolean param3) {
        this.O0o = param1;
        this.PacketEvent = param2;
        this.HelpCommand = param3;
    }
}

