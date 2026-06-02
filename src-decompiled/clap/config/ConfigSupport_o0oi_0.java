/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Converter
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonPrimitive
 *  net.minecraft.client.util.InputUtil
 */
package clap.config;

import com.google.common.base.Converter;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.util.InputUtil;
import clap.gui.GuiSupport_O000;

/*
 * Renamed from clap.gui.hud.HudElementi
 */
public class ConfigSupport_o0oi_0
extends Converter {
    static Object PacketEvent;
    private static volatile /* synthetic */ long __k__gH4it;

    public JsonElement PacketEvent(GuiSupport_O000 param1) {
        return new JsonPrimitive((Number)param1.iOIo());
    }

    static {
        __k__gH4it = ConfigSupport_o0oi_0.__k__gH4it((long)5876461295137451537L);
        __rP__gH4it0 = new String[]{"\u98d7\u31e3\uef71\ubb5e\u3c4f\ufea9\u1879\uedb2\u99f9\u30f9", "\u98d7\u31f6\uef68"};
        __rP__gH4it1 = new String[]{"\u982d\u31ad\uef66\ubaad\u3c17\ufedc\u1884\ued7c\u99d4\u305e\ueeda\ubb22\u3f1d\ufd12\u1bab\ueef9\u9ab4\u33dc\ued30\ub84b\u3e8e\ufce5\u1ae6\uefe7\u9bac\u3231\uec0a\ub98e\u210f\ue3d5\u0577\uf050\u849c\u2d82\uf339\ua6ad\u21eb\ue2d9\u0421\uf144\u858a\u2c09\uf2bd\ua7f7\u209f\ue1ce\u070b\uf2f1", "\u98c2\u31eb\uef71\ubb27\u3c46"};
        __rP__gH4it2 = new String[]{"\u9825\u3193\uefd9\ubbb8\u3c8c\ufece\u18bb\ued2c", "\u98d5\u31e1\uef77\ubb58\u3c4d\ufeab\u1847\ued4c\u99fb\u30fb", "\u98c1\u31ec\uef72\ubb37\u3c2f\ufeca\u1828\ued4d\u99dd\u30ea\uee6a\ub843\u3f51\ufdd0\u1b02\uee1e\u9af1\u33d0\ued5f\ub96f", "\u98c7\u31f2\uef71\ubb22\u3c4f\ufeae\u184c"};
        __rP__gH4it3 = new String[0];
        byte[] v0 = "\u0088dgU[4\u00cf\u00fey\u009f\u00d3\u00d2Y\u00f2\u00e8c\u0001\u0005!\u00a3\u00d2\u001d\u00bdu\u0011\u00e0\u0013n[%$\u00fa\u00d9kXuG\u0011\n\u00e6\u00c7\u00e8\u00d4';\u000e(K".getBytes("ISO_8859_1");
        Object[] v1 = "\u00ba$\u00e6\u00ba\u00fa \u00f6\u00a4".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -459205025;
                case 1 -> 1683639323;
                case 2 -> -57746794;
                case 3 -> 1394865762;
                case 4 -> -2002391898;
                case 5 -> -1834224469;
                case 6 -> -1752303272;
                case 7 -> -1998312382;
                case 8 -> -1168971475;
                case 9 -> 235842142;
                case 10 -> 1756917440;
                case 11 -> -518288160;
                case 12 -> 1288703426;
                case 13 -> 313599274;
                case 14 -> 237209074;
                case 15 -> -966060905;
                case 16 -> 256879228;
                case 17 -> -1227143991;
                case 18 -> 1932622643;
                case 19 -> 541216951;
                case 20 -> -596319930;
                case 21 -> 1423736609;
                case 22 -> -1476001141;
                case 23 -> -308220077;
                case 24 -> 1208589717;
                case 25 -> -140056740;
                case 26 -> -1705347391;
                case 27 -> -1373453512;
                case 28 -> 291071864;
                case 29 -> 71976423;
                case 30 -> 1050652522;
                case 31 -> -62528610;
                case 32 -> -973553081;
                case 33 -> -1851248350;
                case 34 -> -1430795843;
                case 35 -> -828248992;
                case 36 -> 51832008;
                case 37 -> 1542664498;
                case 38 -> -143503022;
                case 39 -> 96633992;
                case 40 -> -319683096;
                case 41 -> -1072155174;
                case 42 -> -2019969326;
                case 43 -> 1489413148;
                case 44 -> -1830513682;
                case 45 -> -44890694;
                case 46 -> -1425481898;
                case 47 -> 789138445;
                case 48 -> 2097413622;
                case 49 -> 1176728351;
                case 50 -> -701739356;
                case 51 -> 1211084194;
                case 52 -> -458231232;
                case 53 -> 652372084;
                case 54 -> -1295893103;
                case 55 -> 960748296;
                case 56 -> -1778697169;
                case 57 -> 76750454;
                case 58 -> -907970685;
                case 59 -> 742564195;
                case 60 -> 180721713;
                case 61 -> 327030938;
                case 62 -> 428280972;
                case 63 -> 452331995;
                case 64 -> 2079339029;
                case 65 -> 401126477;
                case 66 -> 2103901195;
                case 67 -> 90023754;
                case 68 -> -812866993;
                case 69 -> -1793760344;
                case 70 -> -608402453;
                case 71 -> -1300182766;
                case 72 -> -25125649;
                case 73 -> 484827696;
                case 74 -> -1214598393;
                case 75 -> 529924931;
                case 76 -> -1223252251;
                case 77 -> 775552471;
                case 78 -> 1527144618;
                case 79 -> 1345248241;
                case 80 -> 915834349;
                case 81 -> 1052425819;
                case 82 -> -1204898683;
                case 83 -> 567111142;
                case 84 -> 143015649;
                case 85 -> 124458295;
                case 86 -> 1789517202;
                case 87 -> -1321905406;
                case 88 -> 685691956;
                case 89 -> 525617467;
                case 90 -> -1410360161;
                case 91 -> -685229290;
                case 92 -> -309452615;
                case 93 -> 506842220;
                case 94 -> 1638122856;
                case 95 -> 139584169;
                case 96 -> -1118736354;
                case 97 -> 2139441205;
                case 98 -> -1260462066;
                case 99 -> 808345681;
                case 100 -> 2089470270;
                case 101 -> -175837263;
                case 102 -> 1875085608;
                case 103 -> -604961658;
                case 104 -> 1718415952;
                case 105 -> -905745343;
                case 106 -> 110310425;
                case 107 -> -1742655369;
                case 108 -> -805785343;
                case 109 -> -541456729;
                case 110 -> 190674126;
                case 111 -> -721033013;
                case 112 -> -989340188;
                case 113 -> 1232258741;
                case 114 -> 1938881536;
                case 115 -> 38797744;
                case 116 -> 608770503;
                case 117 -> -1268140598;
                case 118 -> -1385832337;
                case 119 -> 352205185;
                case 120 -> -1881573357;
                case 121 -> -554070662;
                case 122 -> -326314369;
                case 123 -> 41259436;
                case 124 -> 1398233934;
                case 125 -> 1691706627;
                case 126 -> 973571950;
                case 127 -> 1283174468;
                case 128 -> 136063865;
                case 129 -> -2078918587;
                case 130 -> -557176715;
                case 131 -> -630701591;
                case 132 -> -352264549;
                case 133 -> 1803307851;
                case 134 -> 1678172554;
                case 135 -> -1749191676;
                case 136 -> 1324051673;
                case 137 -> -1078861456;
                case 138 -> 319277952;
                case 139 -> -1498995945;
                case 140 -> -1969125962;
                case 141 -> -2074235436;
                case 142 -> 293898745;
                case 143 -> 417549469;
                case 144 -> 20923914;
                case 145 -> 2074672638;
                case 146 -> -1431520845;
                case 147 -> -1165111506;
                case 148 -> 695647120;
                case 149 -> 1959168382;
                case 150 -> 1223738575;
                case 151 -> 1668589528;
                case 152 -> -1700305921;
                case 153 -> 1430545087;
                case 154 -> 489085018;
                case 155 -> -868674523;
                case 156 -> 1714097378;
                case 157 -> -356222106;
                case 158 -> 1967260944;
                case 159 -> 265644282;
                case 160 -> 1093120905;
                case 161 -> -1738759940;
                case 162 -> -1548891939;
                case 163 -> -949589050;
                case 164 -> 101469500;
                case 165 -> -1516763949;
                case 166 -> -524252380;
                case 167 -> 949127997;
                case 168 -> -958883983;
                case 169 -> -1843289364;
                case 170 -> 1440468594;
                case 171 -> -36157284;
                case 172 -> 1487820117;
                case 173 -> 700454011;
                case 174 -> 502862835;
                case 175 -> 917543356;
                case 176 -> -533945271;
                case 177 -> -843011304;
                case 178 -> 1439613740;
                case 179 -> -217501179;
                case 180 -> 1258046095;
                case 181 -> 1014556488;
                case 182 -> -1230467578;
                case 183 -> -1385830012;
                case 184 -> -939658651;
                case 185 -> 442668620;
                case 186 -> -826074353;
                case 187 -> 808954802;
                case 188 -> -1829087019;
                case 189 -> 1137194999;
                case 190 -> -525143666;
                case 191 -> -655707404;
                case 192 -> -859504583;
                case 193 -> -281250947;
                case 194 -> 895154726;
                case 195 -> 1695871380;
                case 196 -> -2084936524;
                case 197 -> 1903213085;
                case 198 -> 695668523;
                case 199 -> 524873587;
                case 200 -> -1935990280;
                case 201 -> -542349271;
                case 202 -> 755194109;
                case 203 -> -1734311446;
                case 204 -> -951797855;
                case 205 -> 1348923120;
                case 206 -> 1149031;
                case 207 -> 357961835;
                case 208 -> -135627247;
                case 209 -> 1453124603;
                case 210 -> -1305922413;
                case 211 -> 1425700205;
                case 212 -> 1920445964;
                case 213 -> -442418754;
                case 214 -> -949959159;
                case 215 -> -2059370911;
                case 216 -> -1930582649;
                case 217 -> -1113044851;
                case 218 -> -1389306983;
                case 219 -> -2009681224;
                case 220 -> -1524643388;
                case 221 -> 375216770;
                case 222 -> -1596193436;
                case 223 -> -2024084391;
                case 224 -> -1604277399;
                case 225 -> -1984531013;
                case 226 -> -564053021;
                case 227 -> 1266342821;
                case 228 -> 785012429;
                case 229 -> 1865752890;
                case 230 -> 1905227092;
                case 231 -> 1762622240;
                case 232 -> -234496352;
                case 233 -> 1678719764;
                case 234 -> 657802927;
                case 235 -> -521068079;
                case 236 -> 2132060639;
                case 237 -> -1197701725;
                case 238 -> -1160813731;
                case 239 -> -249255385;
                case 240 -> 1038090718;
                case 241 -> -870666717;
                case 242 -> -1849332649;
                case 243 -> 5889050;
                case 244 -> 2121917381;
                case 245 -> -22872356;
                case 246 -> -1066109130;
                case 247 -> -1950475112;
                case 248 -> -180084417;
                case 249 -> 457829806;
                case 250 -> 456858101;
                case 251 -> -112855379;
                case 252 -> -891204660;
                case 253 -> -753781552;
                case 254 -> 515047126;
                case 255 -> 197339331;
                default -> -853216501;
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
            PacketEvent = objectArray;
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public GuiSupport_O000 HelpCommand(JsonElement param1) {
        if (param1 == null) return GuiSupport_O000.iOIO();
        if (param1.isJsonNull()) {
            return GuiSupport_O000.iOIO();
        }
        if (param1.isJsonPrimitive() && param1.getAsJsonPrimitive().isNumber()) {
            return new GuiSupport_O000(param1.getAsInt());
        }
        String v2 = param1.getAsString();
        if (v2.equalsIgnoreCase("None")) {
            return GuiSupport_O000.iOIO();
        }
        if (v2.toLowerCase().startsWith("mouse ")) {
            try {
                return GuiSupport_O000.iOI0(Integer.parseInt(v2.substring(6)));
            }
            catch (Exception exception) {}
        }
        int v3 = -1;
        try {
            v3 = InputUtil.fromTranslationKey((String)v2.toUpperCase()).getCode();
        }
        catch (Exception exception) {}
        if (v3 != 0) return new GuiSupport_O000(v3);
        return GuiSupport_O000.iOIO();
    }
}

