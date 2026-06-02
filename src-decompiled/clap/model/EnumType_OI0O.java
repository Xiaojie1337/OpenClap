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

public final class EnumType_OI0O
extends Enum {
    public static final /* enum */ EnumType_OI0O Setting;
    public static final /* enum */ EnumType_OI0O RenderSupport_io0_2;
    private static final /* synthetic */ EnumType_OI0O[] iOo;
    static Object iOI;

    public static EnumType_OI0O[] values() {
        return (EnumType_OI0O[])iOo.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_OI0O() {
        void param2;
        void param1;
    }

    public static EnumType_OI0O valueOf(String param0) {
        return Enum.valueOf(EnumType_OI0O.class, param0);
    }

    static {
        byte[] v0 = "\u00e6\u00d1<\u00a4U\u001c\u00fe\u00f4~\u0004b\u00b9\u0014\u0084\u00f7\u008dU\u001eQ\u00ab\u00a7W\u00ca\u00eb\u00c5%\u00ee\\\u00f8\u008aH\u00b7\u00c9\u007f1\u00cd\u009cn*\u0095*\u00d8U#\u000e\u00f1\u0082b|\u000f\u00da\u0081\u00c2\u00b6\u008a\u00de".getBytes("ISO_8859_1");
        Object[] v1 = "?\u009b\u00fcd\u0005\u00fa\u001e\u00a0".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -785089762;
                case 1 -> 1105782168;
                case 2 -> -325700688;
                case 3 -> 796786094;
                case 4 -> 1618888940;
                case 5 -> -1132564589;
                case 6 -> -1295817743;
                case 7 -> 1009706149;
                case 8 -> 5979118;
                case 9 -> 690423799;
                case 10 -> -1367224350;
                case 11 -> -522561100;
                case 12 -> 2015078727;
                case 13 -> -1802883842;
                case 14 -> 1851959742;
                case 15 -> 918838545;
                case 16 -> -474628341;
                case 17 -> 1371994318;
                case 18 -> 843434657;
                case 19 -> -64137139;
                case 20 -> -1583889584;
                case 21 -> 1243410271;
                case 22 -> -1030774942;
                case 23 -> 6910790;
                case 24 -> -2074843918;
                case 25 -> 1876173344;
                case 26 -> 2022115099;
                case 27 -> 1973414108;
                case 28 -> 1435500749;
                case 29 -> -1442079355;
                case 30 -> 2079768209;
                case 31 -> 1350657206;
                case 32 -> -325055514;
                case 33 -> 1509067654;
                case 34 -> 1642201409;
                case 35 -> -1216088259;
                case 36 -> 1857809091;
                case 37 -> 761370675;
                case 38 -> -556498122;
                case 39 -> 1764118362;
                case 40 -> -1028588586;
                case 41 -> -1005623043;
                case 42 -> -1856903724;
                case 43 -> -1969019278;
                case 44 -> -1123969241;
                case 45 -> 1156856835;
                case 46 -> -160872032;
                case 47 -> 1234770050;
                case 48 -> 359746938;
                case 49 -> 1042156207;
                case 50 -> 397783352;
                case 51 -> 1656380543;
                case 52 -> 1115594474;
                case 53 -> 2071441543;
                case 54 -> 660355452;
                case 55 -> -388295332;
                case 56 -> -194186491;
                case 57 -> 773524592;
                case 58 -> 136670736;
                case 59 -> 2045517244;
                case 60 -> 243770728;
                case 61 -> 518980493;
                case 62 -> 769606735;
                case 63 -> -2049205975;
                case 64 -> -999209969;
                case 65 -> 1775231750;
                case 66 -> -1727434644;
                case 67 -> -181160811;
                case 68 -> 1759540695;
                case 69 -> -1550738556;
                case 70 -> 950414891;
                case 71 -> -1646051588;
                case 72 -> -1520558991;
                case 73 -> 1779478219;
                case 74 -> 1109765494;
                case 75 -> -1021105299;
                case 76 -> 1169073214;
                case 77 -> 1535111244;
                case 78 -> 570601495;
                case 79 -> -987296467;
                case 80 -> -1479896766;
                case 81 -> -831627980;
                case 82 -> 1544233417;
                case 83 -> 91626891;
                case 84 -> -924267270;
                case 85 -> 1877058079;
                case 86 -> -524837193;
                case 87 -> 1890414252;
                case 88 -> 56569658;
                case 89 -> 228011029;
                case 90 -> 564216053;
                case 91 -> -1656534444;
                case 92 -> -163293109;
                case 93 -> 1095159843;
                case 94 -> 710223679;
                case 95 -> -1141970172;
                case 96 -> -116929867;
                case 97 -> -1142988091;
                case 98 -> -1732673101;
                case 99 -> -522779992;
                case 100 -> -1998334324;
                case 101 -> 1986448064;
                case 102 -> -382721243;
                case 103 -> 1474085689;
                case 104 -> -1906385280;
                case 105 -> -961777477;
                case 106 -> -757143032;
                case 107 -> -1719638921;
                case 108 -> 1413997911;
                case 109 -> 160829796;
                case 110 -> -1740215129;
                case 111 -> 473386161;
                case 112 -> -638286999;
                case 113 -> 1622954328;
                case 114 -> 735296698;
                case 115 -> 651911758;
                case 116 -> 2118429898;
                case 117 -> -1769102998;
                case 118 -> -811447504;
                case 119 -> 660481834;
                case 120 -> 710076574;
                case 121 -> 545473673;
                case 122 -> -1485889244;
                case 123 -> 207725545;
                case 124 -> 1476255969;
                case 125 -> 56464491;
                case 126 -> 1276049359;
                case 127 -> 335823041;
                case 128 -> -337484195;
                case 129 -> -15085377;
                case 130 -> 1422718805;
                case 131 -> 1028400458;
                case 132 -> -1708433829;
                case 133 -> 1621429568;
                case 134 -> -2060443271;
                case 135 -> -1888378543;
                case 136 -> -737205373;
                case 137 -> 2071272800;
                case 138 -> -1459511237;
                case 139 -> 839892957;
                case 140 -> 1328043920;
                case 141 -> -2039907802;
                case 142 -> 1968082642;
                case 143 -> -2042816643;
                case 144 -> -2108539417;
                case 145 -> 585341139;
                case 146 -> 398715034;
                case 147 -> 838756377;
                case 148 -> -1014037866;
                case 149 -> -2077810704;
                case 150 -> -1905540324;
                case 151 -> 816292105;
                case 152 -> 2046857505;
                case 153 -> 621276456;
                case 154 -> -859900158;
                case 155 -> 1121407688;
                case 156 -> 1818421833;
                case 157 -> 1945433824;
                case 158 -> -126957299;
                case 159 -> -2096908756;
                case 160 -> 302057029;
                case 161 -> 1724664563;
                case 162 -> 1283349652;
                case 163 -> -548416744;
                case 164 -> -804535130;
                case 165 -> -1579819032;
                case 166 -> 477884050;
                case 167 -> -372091807;
                case 168 -> -1177784205;
                case 169 -> -1123551495;
                case 170 -> -265938460;
                case 171 -> -320920915;
                case 172 -> 631428737;
                case 173 -> 1100029167;
                case 174 -> 835300600;
                case 175 -> -998251434;
                case 176 -> -1118240820;
                case 177 -> -1798227534;
                case 178 -> -1553412285;
                case 179 -> 1750524068;
                case 180 -> -1940589057;
                case 181 -> 514597086;
                case 182 -> -125530415;
                case 183 -> -991236214;
                case 184 -> -2083306449;
                case 185 -> 1421185935;
                case 186 -> 141422297;
                case 187 -> -401443338;
                case 188 -> 1926956860;
                case 189 -> -882921256;
                case 190 -> 261370566;
                case 191 -> 891198617;
                case 192 -> 524728926;
                case 193 -> 793919266;
                case 194 -> 697956876;
                case 195 -> 1640445603;
                case 196 -> 88809582;
                case 197 -> -727560535;
                case 198 -> 1515410037;
                case 199 -> 669714076;
                case 200 -> -443027623;
                case 201 -> -184086595;
                case 202 -> 761979495;
                case 203 -> -1723899155;
                case 204 -> 1036265371;
                case 205 -> 1789000293;
                case 206 -> -1148395324;
                case 207 -> -1002086997;
                case 208 -> -1250809042;
                case 209 -> -1346532024;
                case 210 -> 349856053;
                case 211 -> 1015672595;
                case 212 -> -2101997244;
                case 213 -> -1102627186;
                case 214 -> 55588503;
                case 215 -> 781834013;
                case 216 -> 2081078186;
                case 217 -> 2029941615;
                case 218 -> 1761113467;
                case 219 -> -110551325;
                case 220 -> -1815565061;
                case 221 -> 228298834;
                case 222 -> 1299075256;
                case 223 -> 242841529;
                case 224 -> -1965311974;
                case 225 -> 131036417;
                case 226 -> -525343500;
                case 227 -> -955650347;
                case 228 -> -459083677;
                case 229 -> -97714572;
                case 230 -> 917641592;
                case 231 -> 1380817823;
                case 232 -> 1320709861;
                case 233 -> -384609081;
                case 234 -> 1944505354;
                case 235 -> 911101234;
                case 236 -> 1796533780;
                case 237 -> 1305029734;
                case 238 -> 1059440433;
                case 239 -> -1644470136;
                case 240 -> 64834000;
                case 241 -> 845562624;
                case 242 -> 91049742;
                case 243 -> -634115017;
                case 244 -> 1415988758;
                case 245 -> -1020680741;
                case 246 -> 1744259546;
                case 247 -> -996092437;
                case 248 -> 350050066;
                case 249 -> -995056673;
                case 250 -> -915652482;
                case 251 -> -1054649438;
                case 252 -> 197865885;
                case 253 -> -1049921453;
                case 254 -> -1681014078;
                case 255 -> -925499641;
                default -> -326149863;
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
            iOI = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        Setting = new EnumType_OI0O("Normal", 0);
        RenderSupport_io0_2 = new EnumType_OI0O("SprintOnly", 1);
        iOo = EnumType_OI0O.Oi0();
    }

    private static /* synthetic */ EnumType_OI0O[] Oi0() {
        return new EnumType_OI0O[]{Setting, RenderSupport_io0_2};
    }
}

