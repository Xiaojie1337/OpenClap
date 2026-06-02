/*
 * Decompiled with CFR 0.152.
 */
package clap.model;

import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/*
 * Renamed from clap.model.EnumType_ii0_2
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class EnumType_ii0_2
extends Enum {
    public static final /* enum */ EnumType_ii0_2 DataRecord_00I;
    public static final /* enum */ EnumType_ii0_2 00i;
    private static final /* synthetic */ EnumType_ii0_2[] 0oO;
    static Object 0o0;

    public static EnumType_ii0_2[] values() {
        return (EnumType_ii0_2[])0oO.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_ii0_2() {
        void param2;
        void param1;
    }

    public static EnumType_ii0_2 valueOf(String param0) {
        return Enum.valueOf(EnumType_ii0_2.class, param0);
    }

    static {
        byte[] v0 = "Q\u0092\u009e\u00e6\u00be\u00e4\u00d8t]\u00fdl\u00d4\u00a1\u00cf\u001f\u00e68\u00c49\u0087\u00f1\u00b0V\u0005\u00d7P\u00efoi\u001c\u0088*7\u00a8n;\u00a8y\u00f5\u00acN7\u00f9\u00cb\u00f1H\u0004\u001cos\u0019\u001aH\u00b3*\u00b9".getBytes("ISO_8859_1");
        Object[] v1 = ";\u000f\u00f6A\u00a5\u00d6[\u0098".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 47700220;
                case 1 -> 679043283;
                case 2 -> -573580887;
                case 3 -> 721758401;
                case 4 -> 1082850381;
                case 5 -> 1371698847;
                case 6 -> 1093280501;
                case 7 -> -1923384786;
                case 8 -> -762964148;
                case 9 -> 653627173;
                case 10 -> 1379781081;
                case 11 -> -436761843;
                case 12 -> 1616690180;
                case 13 -> 1098620072;
                case 14 -> 532536970;
                case 15 -> 1176840716;
                case 16 -> 1686074913;
                case 17 -> -1567743479;
                case 18 -> 2130063054;
                case 19 -> 922287802;
                case 20 -> 1097541334;
                case 21 -> -1417655411;
                case 22 -> -1015684395;
                case 23 -> -915360036;
                case 24 -> -360957380;
                case 25 -> 675786753;
                case 26 -> -1018461727;
                case 27 -> 401782372;
                case 28 -> -1171990188;
                case 29 -> -855691768;
                case 30 -> 782245284;
                case 31 -> -1394496680;
                case 32 -> -913082302;
                case 33 -> 669999903;
                case 34 -> -1172858065;
                case 35 -> 1682689476;
                case 36 -> -2033621743;
                case 37 -> 1582143094;
                case 38 -> 490238271;
                case 39 -> -1962626467;
                case 40 -> 603406100;
                case 41 -> -73714152;
                case 42 -> 1098731857;
                case 43 -> 1593043401;
                case 44 -> -1209042137;
                case 45 -> -409131910;
                case 46 -> -942174805;
                case 47 -> 1246879478;
                case 48 -> -774025636;
                case 49 -> 243500239;
                case 50 -> -644798999;
                case 51 -> -1859147320;
                case 52 -> -865029347;
                case 53 -> 256884069;
                case 54 -> -353769242;
                case 55 -> -180500820;
                case 56 -> 748052672;
                case 57 -> 386917847;
                case 58 -> 163249788;
                case 59 -> -1970214035;
                case 60 -> -941828046;
                case 61 -> -110899001;
                case 62 -> -1390360866;
                case 63 -> -2006750118;
                case 64 -> -1391067419;
                case 65 -> 959537286;
                case 66 -> -454887995;
                case 67 -> -305864815;
                case 68 -> -657012736;
                case 69 -> -2068647789;
                case 70 -> -1404090853;
                case 71 -> -216990623;
                case 72 -> -2056457598;
                case 73 -> -1352407574;
                case 74 -> -189057961;
                case 75 -> 1092740744;
                case 76 -> 1828513997;
                case 77 -> 1341962489;
                case 78 -> 1814400658;
                case 79 -> 96555844;
                case 80 -> 184038701;
                case 81 -> 1240538548;
                case 82 -> -860299002;
                case 83 -> 757025278;
                case 84 -> -499178619;
                case 85 -> -168296103;
                case 86 -> -1636041835;
                case 87 -> 827088243;
                case 88 -> -45711933;
                case 89 -> -1387361401;
                case 90 -> 1166940472;
                case 91 -> 773896173;
                case 92 -> 1606711604;
                case 93 -> -589010866;
                case 94 -> 1092642888;
                case 95 -> -925353232;
                case 96 -> 1945523264;
                case 97 -> -1179584719;
                case 98 -> -365494250;
                case 99 -> 1111464506;
                case 100 -> -1027465201;
                case 101 -> 1263938258;
                case 102 -> 1498906589;
                case 103 -> -271237066;
                case 104 -> -2079407611;
                case 105 -> -282120076;
                case 106 -> 1877727894;
                case 107 -> -956547911;
                case 108 -> -169461785;
                case 109 -> 825639503;
                case 110 -> 696525090;
                case 111 -> 2089729576;
                case 112 -> 2073331120;
                case 113 -> -217180448;
                case 114 -> 713702049;
                case 115 -> -1912556471;
                case 116 -> 2084045776;
                case 117 -> 959505950;
                case 118 -> 430365378;
                case 119 -> -551904221;
                case 120 -> -396503398;
                case 121 -> -1810891055;
                case 122 -> 1330069174;
                case 123 -> 727690225;
                case 124 -> 1922024016;
                case 125 -> 1141656486;
                case 126 -> 799499387;
                case 127 -> -1951284084;
                case 128 -> 2103887587;
                case 129 -> -857646155;
                case 130 -> 2143082561;
                case 131 -> -1560743664;
                case 132 -> -855110781;
                case 133 -> 1688321168;
                case 134 -> -526762738;
                case 135 -> 2126207327;
                case 136 -> 1344808725;
                case 137 -> 1291632872;
                case 138 -> -2019282518;
                case 139 -> -437396754;
                case 140 -> 537575032;
                case 141 -> -797769885;
                case 142 -> 947144947;
                case 143 -> 806668248;
                case 144 -> -709689614;
                case 145 -> 27274771;
                case 146 -> 1875841355;
                case 147 -> 72316876;
                case 148 -> -690257160;
                case 149 -> -32108474;
                case 150 -> -773945188;
                case 151 -> -1302291657;
                case 152 -> 2106757941;
                case 153 -> -240274998;
                case 154 -> 154295332;
                case 155 -> -1838116231;
                case 156 -> 1405214091;
                case 157 -> 1475420208;
                case 158 -> -602153130;
                case 159 -> -899273942;
                case 160 -> -961083412;
                case 161 -> -2137959851;
                case 162 -> -619470985;
                case 163 -> -2071623686;
                case 164 -> 406113406;
                case 165 -> 2130769048;
                case 166 -> 2033378807;
                case 167 -> -2117331189;
                case 168 -> 820673021;
                case 169 -> -712617733;
                case 170 -> -273961793;
                case 171 -> -1367613076;
                case 172 -> -1112934531;
                case 173 -> 379815010;
                case 174 -> 315476443;
                case 175 -> 397904843;
                case 176 -> 2073215956;
                case 177 -> -1244286080;
                case 178 -> 1389381962;
                case 179 -> 691261311;
                case 180 -> 971666862;
                case 181 -> 2007037458;
                case 182 -> -528331451;
                case 183 -> 958030233;
                case 184 -> 952222215;
                case 185 -> -1712838007;
                case 186 -> 913762332;
                case 187 -> 428173221;
                case 188 -> -1542515021;
                case 189 -> 1978459509;
                case 190 -> -1099710157;
                case 191 -> 431622000;
                case 192 -> -640275610;
                case 193 -> 642070368;
                case 194 -> -1725794086;
                case 195 -> -1195657413;
                case 196 -> 1904625470;
                case 197 -> -1713769305;
                case 198 -> -1618927390;
                case 199 -> 1580809579;
                case 200 -> 19855404;
                case 201 -> 2061086791;
                case 202 -> -91341024;
                case 203 -> 158312551;
                case 204 -> -322599708;
                case 205 -> -893798995;
                case 206 -> 1517367279;
                case 207 -> -961635797;
                case 208 -> 313744643;
                case 209 -> -65041383;
                case 210 -> 589809449;
                case 211 -> 1458352451;
                case 212 -> 2038977684;
                case 213 -> 1847780690;
                case 214 -> 1305391759;
                case 215 -> 814870015;
                case 216 -> -1288612988;
                case 217 -> 1392575105;
                case 218 -> 1126816114;
                case 219 -> 2022267615;
                case 220 -> 348053002;
                case 221 -> 1817700969;
                case 222 -> 1516680855;
                case 223 -> -703962206;
                case 224 -> 617917838;
                case 225 -> 1636891037;
                case 226 -> -1234530725;
                case 227 -> -711095192;
                case 228 -> 1619921131;
                case 229 -> 1602727993;
                case 230 -> 10149048;
                case 231 -> -1477999714;
                case 232 -> 892913596;
                case 233 -> -739064749;
                case 234 -> -1976670531;
                case 235 -> 1375778971;
                case 236 -> 1996694961;
                case 237 -> 1893912247;
                case 238 -> 16369568;
                case 239 -> 1053751590;
                case 240 -> -1076447394;
                case 241 -> -972344925;
                case 242 -> 2056419250;
                case 243 -> -1640381590;
                case 244 -> -1336067471;
                case 245 -> 197065406;
                case 246 -> -1127249489;
                case 247 -> 661205250;
                case 248 -> -1647175313;
                case 249 -> -1345001446;
                case 250 -> 2103422013;
                case 251 -> -506802234;
                case 252 -> -2079471081;
                case 253 -> -1673341964;
                case 254 -> -1214239045;
                case 255 -> 1016511598;
                default -> 979790474;
            });
        } while (v2 != 56);
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
            0o0 = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        DataRecord_00I = new EnumType_ii0_2("ClickSlot", 0);
        00i = new EnumType_ii0_2("Packet", 1);
        0oO = EnumType_ii0_2.O0o();
    }

    private static /* synthetic */ EnumType_ii0_2[] O0o() {
        return new EnumType_ii0_2[]{DataRecord_00I, 00i};
    }
}

