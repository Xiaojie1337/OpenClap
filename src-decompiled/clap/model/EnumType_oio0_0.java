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
 * Renamed from psx.Hyk.OIo0
 */
final class EnumType_oio0_0
extends Enum {
    public static final /* enum */ EnumType_oio0_0 iOI;
    public static final /* enum */ EnumType_oio0_0 WorldTimeModule;
    public static final /* enum */ EnumType_oio0_0 iOi;
    private static final /* synthetic */ EnumType_oio0_0[] i0o;
    public static final /* enum */ EnumType_oio0_0 i00;
    static Object i0I;

    public static EnumType_oio0_0[] values() {
        return (EnumType_oio0_0[])i0o.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_oio0_0() {
        void param2;
        void param1;
    }

    public static EnumType_oio0_0 valueOf(String param0) {
        return Enum.valueOf(EnumType_oio0_0.class, param0);
    }

    static {
        byte[] v0 = "\u00970\u00c2\u00f3\u00cayK\u00de\u00bb8\u0016\u00c4\t\u00f5\u00b7%\u00f9y.\u009d\u00ea\u0019\u00a9\u00e2L\u00ab\u00a4-\u00a8\"m2\u00c5\u009a\u00b8\u001du\u00fd\u00fb\u0013\u00fb\u008d\u00bf`\u00d0\u008e\u00ad\u0095\u00e1\u008a\u00c6tc\u00ad\u0002O\u0087A~\u00b7\u00a8\u00f9e9\u00f3\u00a6P\u00e6\u00c5\u0085\u0089,\u0002.\u00e0\u00c4\u0002\u00ea@\u00d1".getBytes("ISO_8859_1");
        Object[] v1 = "\u00d5\u000eOO\u0083z\u00fa`".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -790160483;
                case 1 -> 8819830;
                case 2 -> -272901185;
                case 3 -> -1331412468;
                case 4 -> -2014363513;
                case 5 -> 1075257250;
                case 6 -> -43714918;
                case 7 -> -1901501757;
                case 8 -> -624362777;
                case 9 -> -355317393;
                case 10 -> -1401671637;
                case 11 -> 652101217;
                case 12 -> -116707003;
                case 13 -> 1624129419;
                case 14 -> 1518977955;
                case 15 -> 782961748;
                case 16 -> -242658727;
                case 17 -> 352115621;
                case 18 -> -148623873;
                case 19 -> -333655052;
                case 20 -> 1653166142;
                case 21 -> 749969198;
                case 22 -> -615890217;
                case 23 -> -62352856;
                case 24 -> -995178752;
                case 25 -> -837234732;
                case 26 -> 14075880;
                case 27 -> -1065868513;
                case 28 -> -693951411;
                case 29 -> 1974056783;
                case 30 -> 1636443518;
                case 31 -> 675659050;
                case 32 -> 765261861;
                case 33 -> -239377931;
                case 34 -> 88794851;
                case 35 -> 1348030447;
                case 36 -> 208066410;
                case 37 -> -1625789673;
                case 38 -> 1313214624;
                case 39 -> 1891527222;
                case 40 -> 1906865304;
                case 41 -> 2029239127;
                case 42 -> 1563204830;
                case 43 -> -1040141906;
                case 44 -> -986005662;
                case 45 -> -644798238;
                case 46 -> 2010876908;
                case 47 -> 1890061968;
                case 48 -> -981838958;
                case 49 -> 360873171;
                case 50 -> 1972397368;
                case 51 -> -91420471;
                case 52 -> -820415110;
                case 53 -> -1436004477;
                case 54 -> -1650190721;
                case 55 -> -1408169303;
                case 56 -> 1982158566;
                case 57 -> -1593076904;
                case 58 -> -1394442169;
                case 59 -> -1681033510;
                case 60 -> -1408728978;
                case 61 -> 714995609;
                case 62 -> -365609093;
                case 63 -> -452473916;
                case 64 -> -2037477438;
                case 65 -> -415474900;
                case 66 -> 700207898;
                case 67 -> -613922723;
                case 68 -> -1249145324;
                case 69 -> -1179649278;
                case 70 -> 769119618;
                case 71 -> 408141384;
                case 72 -> 34319958;
                case 73 -> 1998593450;
                case 74 -> 475126704;
                case 75 -> 455119859;
                case 76 -> -384420023;
                case 77 -> 439310717;
                case 78 -> 1527259409;
                case 79 -> 2087326539;
                case 80 -> -1084700899;
                case 81 -> -1256403044;
                case 82 -> 2137601855;
                case 83 -> -1723556175;
                case 84 -> 1757305894;
                case 85 -> 254991780;
                case 86 -> 1997615940;
                case 87 -> 4738807;
                case 88 -> -783828878;
                case 89 -> 1548889426;
                case 90 -> 1510880787;
                case 91 -> -1483793632;
                case 92 -> 565251609;
                case 93 -> -1694423618;
                case 94 -> -1592443455;
                case 95 -> 320776657;
                case 96 -> 1825249554;
                case 97 -> -78307312;
                case 98 -> -1217133695;
                case 99 -> -1778044147;
                case 100 -> -131333274;
                case 101 -> -259265647;
                case 102 -> 169149285;
                case 103 -> -252425588;
                case 104 -> -1640056286;
                case 105 -> -1115589696;
                case 106 -> 112644387;
                case 107 -> -426025112;
                case 108 -> 1325244788;
                case 109 -> 43426935;
                case 110 -> -1194830599;
                case 111 -> 1269777307;
                case 112 -> -1039157561;
                case 113 -> -10757362;
                case 114 -> 1483712510;
                case 115 -> 1839928882;
                case 116 -> -1093822403;
                case 117 -> 1554150247;
                case 118 -> -1134978490;
                case 119 -> -349543789;
                case 120 -> 1462112777;
                case 121 -> -1044493091;
                case 122 -> -62116287;
                case 123 -> -1165803184;
                case 124 -> 1471154354;
                case 125 -> -1694933011;
                case 126 -> 22442725;
                case 127 -> -901588712;
                case 128 -> 1806823575;
                case 129 -> 214475356;
                case 130 -> 1427938779;
                case 131 -> -2103603654;
                case 132 -> -708494845;
                case 133 -> 1752362099;
                case 134 -> 1416060272;
                case 135 -> 1242017131;
                case 136 -> -1757524995;
                case 137 -> -1194355508;
                case 138 -> 1443472730;
                case 139 -> -784170618;
                case 140 -> -941102354;
                case 141 -> 1640755433;
                case 142 -> 1050704376;
                case 143 -> 1333066191;
                case 144 -> 791366872;
                case 145 -> -524026422;
                case 146 -> -1802942;
                case 147 -> 1822844955;
                case 148 -> -978576095;
                case 149 -> -1616131698;
                case 150 -> 1333612649;
                case 151 -> -2090532728;
                case 152 -> 619849819;
                case 153 -> 1993110199;
                case 154 -> 1640165685;
                case 155 -> 952700363;
                case 156 -> 2016447509;
                case 157 -> -240069381;
                case 158 -> 416920744;
                case 159 -> 2007044609;
                case 160 -> -942370145;
                case 161 -> 285943823;
                case 162 -> 341412833;
                case 163 -> 1604471085;
                case 164 -> 1736743868;
                case 165 -> 102646710;
                case 166 -> -1720079995;
                case 167 -> 658258649;
                case 168 -> 1977202983;
                case 169 -> 164244651;
                case 170 -> -473578657;
                case 171 -> -1385868026;
                case 172 -> 883221141;
                case 173 -> -754632861;
                case 174 -> 317875972;
                case 175 -> 597804779;
                case 176 -> 574282910;
                case 177 -> 2072503815;
                case 178 -> 1606043195;
                case 179 -> -555418231;
                case 180 -> 642794860;
                case 181 -> -1761398861;
                case 182 -> 1342594612;
                case 183 -> -1023306159;
                case 184 -> 2040620764;
                case 185 -> 1990063198;
                case 186 -> 1446989092;
                case 187 -> -1755146676;
                case 188 -> -1254646031;
                case 189 -> -1326463168;
                case 190 -> 818306233;
                case 191 -> -805028402;
                case 192 -> 1457038383;
                case 193 -> 192695775;
                case 194 -> -780600438;
                case 195 -> 1381091701;
                case 196 -> 306836042;
                case 197 -> 1595132373;
                case 198 -> -368462728;
                case 199 -> -1913587478;
                case 200 -> 752156976;
                case 201 -> 1773320456;
                case 202 -> 220584438;
                case 203 -> -321180227;
                case 204 -> 2015313606;
                case 205 -> 801342948;
                case 206 -> -972064412;
                case 207 -> 1605332746;
                case 208 -> 87218656;
                case 209 -> 1631754556;
                case 210 -> -54045755;
                case 211 -> 1378334275;
                case 212 -> 1992543822;
                case 213 -> -1904834394;
                case 214 -> 1549455565;
                case 215 -> 55526331;
                case 216 -> -1265706860;
                case 217 -> 150141489;
                case 218 -> 1738953299;
                case 219 -> 1824450504;
                case 220 -> 1332093707;
                case 221 -> 1639354993;
                case 222 -> 656165295;
                case 223 -> 520059094;
                case 224 -> -262542411;
                case 225 -> 698416790;
                case 226 -> 1411768818;
                case 227 -> -1098783059;
                case 228 -> -475435667;
                case 229 -> 528477049;
                case 230 -> 347753168;
                case 231 -> -811621380;
                case 232 -> 67813929;
                case 233 -> 1405522130;
                case 234 -> 2014698381;
                case 235 -> -401780706;
                case 236 -> -1298229264;
                case 237 -> 384630323;
                case 238 -> 877301944;
                case 239 -> 72673847;
                case 240 -> -36774276;
                case 241 -> 833712308;
                case 242 -> -1476938212;
                case 243 -> -141826944;
                case 244 -> -609887904;
                case 245 -> -280540529;
                case 246 -> -468797446;
                case 247 -> -1244864863;
                case 248 -> 1293758906;
                case 249 -> -1104903252;
                case 250 -> -882419911;
                case 251 -> -1908145835;
                case 252 -> 633005590;
                case 253 -> -2049466748;
                case 254 -> -112862297;
                case 255 -> 1930958597;
                default -> -137603938;
            });
        } while (v2 != 80);
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
            Object[] objectArray = new Object[4];
            v1 = objectArray;
            i0I = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        iOI = new EnumType_oio0_0("NONE", 0);
        iOi = new EnumType_oio0_0("SATURATION_BRIGHTNESS", 1);
        WorldTimeModule = new EnumType_oio0_0("HUE", 2);
        i00 = new EnumType_oio0_0("ALPHA", 3);
        i0o = EnumType_oio0_0.Oio();
    }

    private static /* synthetic */ EnumType_oio0_0[] Oio() {
        return new EnumType_oio0_0[]{iOI, iOi, WorldTimeModule, i00};
    }
}

