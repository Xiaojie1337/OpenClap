/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Converter
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonPrimitive
 */
package clap.config;

import com.google.common.base.Converter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/*
 * Renamed from clap.module.client.NotificationsModule
 */
public class ConfigSupport_oioo_3
extends Converter {
    private final Class PacketEvent;
    static Object HelpCommand;
    private static volatile /* synthetic */ long __k__gH4it;

    static {
        __k__gH4it = ConfigSupport_oioo_3.__k__gH4it((long)-5692043540524175855L);
        __rP__gH4it0 = new String[]{"\uf525\u9cee\u4311\u16ca\u91e9\u9d5d\ue8f6\u4092\uf42a\u9dee\u42a3\u1789\u9085\u9c9b\ue966\u4158\uf7a2\u9e86\u4121\u14a1\u9328\u9ff5\ueabb\u4237\uf6ee\u9f46\u400b\u15a7\u9215\u9e8e\uebfa\u4354\uf140\u98b5\u4701\u1208\u9555\u99c1\uec0a\u4466\uf1eb\u9931\u46c0\u13a2\u949f\u98cf\ued38\u45d9", "\uf564\u9cd3\u43cb\u165e\u91e1"};
        __rP__gH4it1 = new String[]{"\uf571\u9cdf\u43cb\u162b\u91f8\u9d5c\ue83c\u4062\uf46f\u9db5", "\uf573\u9cd1\u43c5\u1629\u91fa\u9d5a\ue83a\u4060\uf46d\u9dab", "\uf571\u9cc6\u43da"};
        __rP__gH4it2 = new String[]{"\uf5c1\u9c1f\u43ff\u1647\u9114\u9d9e\ue822\u40aa"};
        __rP__gH4it3 = new String[]{"\uf567\u9cd0\u43b0\u1672\u9168\u9d0f\ue825\u405d\uf58b\u9de6\u42a8\u1706\u9016\u9c15\ue90f\u411e\uf4b7\u9ecc\u419d\u142a", "\uf561\u9cd2\u43d3\u1643\u91e8\u9d4f\ue821"};
        byte[] v0 = "&\u001b\u0092\u00b7\"0\u00f0\u00c0\u0011c(\u00fcF\u00feh\u0002\u0091\u0003\u00b2\u00cc\u00f3\u0088\u00adu\u00c5\u00db\u0090\u00c2\u00c6\u00fb\u00e4\u001ec \u00e2U~\u008cl\u00140\u009c+\u00f7\u00bc\u008aV\u00a3".getBytes("ISO_8859_1");
        Object[] v1 = "\u00f8\u0090z<\u00d5\u00f9*\u00f6".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 278458408;
                case 1 -> 2090989274;
                case 2 -> 442413103;
                case 3 -> -459558009;
                case 4 -> 1155003308;
                case 5 -> -1208633140;
                case 6 -> -1031047281;
                case 7 -> 2120267117;
                case 8 -> 997610440;
                case 9 -> -171243235;
                case 10 -> 409132110;
                case 11 -> -217059006;
                case 12 -> -1467016877;
                case 13 -> -1679989748;
                case 14 -> -1796497398;
                case 15 -> -1468530071;
                case 16 -> 1279735813;
                case 17 -> 141674291;
                case 18 -> -37268972;
                case 19 -> 1543975061;
                case 20 -> 1620263912;
                case 21 -> 147961895;
                case 22 -> 1142438553;
                case 23 -> -219491369;
                case 24 -> -333608963;
                case 25 -> -1245984218;
                case 26 -> 422075855;
                case 27 -> -891102484;
                case 28 -> 1685113224;
                case 29 -> -88513613;
                case 30 -> -1392504950;
                case 31 -> -1345795295;
                case 32 -> -1761785849;
                case 33 -> 100782240;
                case 34 -> 2064501530;
                case 35 -> -807673761;
                case 36 -> 1003673670;
                case 37 -> -1030823665;
                case 38 -> -1125629891;
                case 39 -> 1708800111;
                case 40 -> 1732517547;
                case 41 -> 1032296182;
                case 42 -> -565261613;
                case 43 -> 1577657452;
                case 44 -> 643060486;
                case 45 -> 661234418;
                case 46 -> 1595657950;
                case 47 -> 1758268604;
                case 48 -> 1578243003;
                case 49 -> 950191535;
                case 50 -> -484466345;
                case 51 -> -862748520;
                case 52 -> -854126931;
                case 53 -> 483868771;
                case 54 -> -1408107306;
                case 55 -> -807901770;
                case 56 -> 697154571;
                case 57 -> 673378173;
                case 58 -> 2050173975;
                case 59 -> -583445308;
                case 60 -> 1922781624;
                case 61 -> -1032404962;
                case 62 -> 1679126324;
                case 63 -> 219718896;
                case 64 -> -350379606;
                case 65 -> 1863097037;
                case 66 -> -526765007;
                case 67 -> -1400658046;
                case 68 -> -359551095;
                case 69 -> 755493031;
                case 70 -> 917910448;
                case 71 -> -1373234858;
                case 72 -> -386857819;
                case 73 -> -1292280239;
                case 74 -> 944410507;
                case 75 -> -632367584;
                case 76 -> 1621176005;
                case 77 -> -1923045725;
                case 78 -> 2005957526;
                case 79 -> -1666696929;
                case 80 -> 1735517796;
                case 81 -> 1219433024;
                case 82 -> -1669852742;
                case 83 -> -1417095428;
                case 84 -> 442220151;
                case 85 -> -1510309776;
                case 86 -> -1473099928;
                case 87 -> -1947769853;
                case 88 -> 544894386;
                case 89 -> 113247781;
                case 90 -> -1943449128;
                case 91 -> 1615266918;
                case 92 -> -304415106;
                case 93 -> 604642285;
                case 94 -> -1372994359;
                case 95 -> 513754126;
                case 96 -> -278426279;
                case 97 -> 809914852;
                case 98 -> -1464713839;
                case 99 -> 2073397190;
                case 100 -> 465523019;
                case 101 -> 1565708752;
                case 102 -> -1551463198;
                case 103 -> -1231834756;
                case 104 -> 1382223272;
                case 105 -> -1710477549;
                case 106 -> 285112099;
                case 107 -> 1151483486;
                case 108 -> -1735702369;
                case 109 -> 673731229;
                case 110 -> -279465736;
                case 111 -> -844486490;
                case 112 -> 1384041774;
                case 113 -> 1689480261;
                case 114 -> 366316743;
                case 115 -> 1529168190;
                case 116 -> -1768598016;
                case 117 -> -11511231;
                case 118 -> -1158638877;
                case 119 -> 780786290;
                case 120 -> 1031498910;
                case 121 -> -1498554729;
                case 122 -> -1635584715;
                case 123 -> -752290999;
                case 124 -> 1326045635;
                case 125 -> 1740011794;
                case 126 -> -402747428;
                case 127 -> 1627667780;
                case 128 -> 1565799522;
                case 129 -> 689501697;
                case 130 -> 1485564789;
                case 131 -> -292314540;
                case 132 -> -1648923455;
                case 133 -> -1708925088;
                case 134 -> 1656322651;
                case 135 -> 617101561;
                case 136 -> -2098571863;
                case 137 -> -355574681;
                case 138 -> -1201863052;
                case 139 -> 890550064;
                case 140 -> 10457898;
                case 141 -> -949138582;
                case 142 -> 179890161;
                case 143 -> -484319233;
                case 144 -> -899057281;
                case 145 -> 1966839550;
                case 146 -> -468078008;
                case 147 -> 1566012902;
                case 148 -> -242897451;
                case 149 -> -372705423;
                case 150 -> 1949844810;
                case 151 -> -1765231683;
                case 152 -> 2034213128;
                case 153 -> 785566586;
                case 154 -> -587762578;
                case 155 -> 882724459;
                case 156 -> 1559641755;
                case 157 -> -96558609;
                case 158 -> 1926481719;
                case 159 -> -956398835;
                case 160 -> 918704034;
                case 161 -> -1087991920;
                case 162 -> -1630603402;
                case 163 -> 1948368603;
                case 164 -> 796950940;
                case 165 -> -1922851562;
                case 166 -> -1240980769;
                case 167 -> -645870000;
                case 168 -> 702221402;
                case 169 -> 1224915072;
                case 170 -> 2026697163;
                case 171 -> 1038729441;
                case 172 -> -1893968324;
                case 173 -> 1322581402;
                case 174 -> -1090579578;
                case 175 -> 755942232;
                case 176 -> -1219153933;
                case 177 -> -1223403799;
                case 178 -> -1788029001;
                case 179 -> -857683023;
                case 180 -> 1542876801;
                case 181 -> -1893613166;
                case 182 -> 510836725;
                case 183 -> 612745145;
                case 184 -> -1247345756;
                case 185 -> -1745705427;
                case 186 -> -2094571811;
                case 187 -> -1100650929;
                case 188 -> 18668824;
                case 189 -> 471277369;
                case 190 -> 951179340;
                case 191 -> -1999212488;
                case 192 -> -330289533;
                case 193 -> 245047905;
                case 194 -> -1837183690;
                case 195 -> 1034372513;
                case 196 -> 1925572243;
                case 197 -> -408889529;
                case 198 -> -988898668;
                case 199 -> 1851028996;
                case 200 -> -1641581220;
                case 201 -> 749904005;
                case 202 -> 156443370;
                case 203 -> 1132002084;
                case 204 -> 1965763449;
                case 205 -> -1783655125;
                case 206 -> -582838149;
                case 207 -> 404922461;
                case 208 -> -1355691788;
                case 209 -> -1541572545;
                case 210 -> 2124939285;
                case 211 -> 259472955;
                case 212 -> -332195303;
                case 213 -> -438868050;
                case 214 -> -1198436079;
                case 215 -> 717075342;
                case 216 -> -1344494964;
                case 217 -> 499173634;
                case 218 -> 759592910;
                case 219 -> -106451068;
                case 220 -> 23247736;
                case 221 -> 295191866;
                case 222 -> 498310940;
                case 223 -> -588791475;
                case 224 -> -1196051440;
                case 225 -> -1417756878;
                case 226 -> -1360752573;
                case 227 -> -1108261844;
                case 228 -> 1657914818;
                case 229 -> -1534943454;
                case 230 -> 768995579;
                case 231 -> -1133111979;
                case 232 -> -1963333005;
                case 233 -> -1145049120;
                case 234 -> 1555871936;
                case 235 -> 1829777874;
                case 236 -> -1155858194;
                case 237 -> 128583147;
                case 238 -> 1781747658;
                case 239 -> 180594405;
                case 240 -> -610946599;
                case 241 -> -1390687308;
                case 242 -> -2051085593;
                case 243 -> 1088908841;
                case 244 -> -947715443;
                case 245 -> -166207918;
                case 246 -> -1122549477;
                case 247 -> -1429592219;
                case 248 -> 124821457;
                case 249 -> -1594747639;
                case 250 -> -976898057;
                case 251 -> -1403927362;
                case 252 -> 516895167;
                case 253 -> 1412441850;
                case 254 -> -565153580;
                case 255 -> 421763509;
                default -> -1323411316;
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
            Object[] objectArray = new Object[2];
            v1 = objectArray;
            HelpCommand = objectArray;
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

    public JsonElement HudElement(Enum param1) {
        JsonObject v2 = new JsonObject();
        v2.addProperty("ordinal", (Number)param1.ordinal());
        v2.addProperty("name", param1.name());
        return v2;
    }

    public static String OOi(Enum param0) {
        return Character.toUpperCase(param0.name().charAt(0)) + param0.name().toLowerCase().substring(1);
    }

    public ConfigSupport_oioo_3(Class param1) {
        this.PacketEvent = param1;
    }

    private Enum O0o(int param1) {
        Enum[] v2 = (Enum[])this.PacketEvent.getEnumConstants();
        if (param1 < 0 || param1 >= v2.length) {
            return null;
        }
        return v2[param1];
    }

    public Enum EventBusApi(JsonElement param1) {
        block10: {
            if (param1 == null || param1.isJsonNull()) {
                return null;
            }
            try {
                Enum v3;
                if (!param1.isJsonObject()) break block10;
                JsonObject v2 = param1.getAsJsonObject();
                if (v2.has("ordinal") && (v3 = this.O0o(v2.get("ordinal").getAsInt())) != null) {
                    return v3;
                }
                if (v2.has("name") && (v3 = this.ConfigSupport_O0I(v2.get("name").getAsString())) != null) {
                    return v3;
                }
                return null;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                return null;
            }
        }
        JsonPrimitive v2 = param1.getAsJsonPrimitive();
        if (v2.isNumber()) {
            return this.O0o(v2.getAsInt());
        }
        String v3 = v2.getAsString();
        Enum v4 = this.ConfigSupport_O0I(v3);
        if (v4 != null) {
            return v4;
        }
        try {
            return this.O0o(Integer.parseInt(v3));
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    private Enum ConfigSupport_O0I(String param1) {
        for (Enum v5 : (Enum[])this.PacketEvent.getEnumConstants()) {
            if (!v5.name().equals(param1)) continue;
            return v5;
        }
        for (Enum v5 : (Enum[])this.PacketEvent.getEnumConstants()) {
            if (!v5.name().equalsIgnoreCase(param1)) continue;
            return v5;
        }
        return null;
    }

    public static Enum GuiSupport_OOI(Enum param0) {
        int v1 = ConfigSupport_oioo_3.OOo(param0);
        for (int v2 = 0; v2 < ((Enum[])param0.getDeclaringClass().getEnumConstants()).length; ++v2) {
            Enum v3 = ((Enum[])param0.getDeclaringClass().getEnumConstants())[v2];
            if (v2 != v1 + 1) {
                continue;
            }
            return v3;
        }
        return ((Enum[])param0.getDeclaringClass().getEnumConstants())[0];
    }

    public static int OOo(Enum param0) {
        for (int v1 = 0; v1 < ((Enum[])param0.getDeclaringClass().getEnumConstants()).length; ++v1) {
            Enum v2 = ((Enum[])param0.getDeclaringClass().getEnumConstants())[v1];
            if (!v2.name().equalsIgnoreCase(param0.name())) {
                continue;
            }
            return v1;
        }
        return -1;
    }
}

