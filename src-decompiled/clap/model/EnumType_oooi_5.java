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
 * Renamed from psx.Hyk.OooI
 */
final class EnumType_oooi_5
extends Enum {
    public static final /* enum */ EnumType_oooi_5 I0o;
    private static final /* synthetic */ EnumType_oooi_5[] NetworkSupport_i0i_2;
    public static final /* enum */ EnumType_oooi_5 EnumType_I00;
    public static final /* enum */ EnumType_oooi_5 IrcCommand;
    static Object IoO;

    public static EnumType_oooi_5[] values() {
        return (EnumType_oooi_5[])NetworkSupport_i0i_2.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_oooi_5() {
        void param2;
        void param1;
    }

    public static EnumType_oooi_5 valueOf(String param0) {
        return Enum.valueOf(EnumType_oooi_5.class, param0);
    }

    static {
        byte[] v0 = "\u00b3\u008a\u00fd\u0006\u00bbQ=\u00ad\u00b3\u00aa} \u0016\u0007*\u0092f#^{\u00d9\u001d\u00c4P\u00c5)7\u0094\u0080J9:\u00b9d\u00d6\u0095*\u000f\u00ef\u00c3\u009eH\u009c=-\u00b7\u0013w^F\u001cM\u00e2\u00d7\u00a3\u00eb\u00cele\u00f2l6\u001a\u00cd\u00ab\u0081\u00a18\u0013\u00aerSl\u00adD.\u0085\u00f5\u00efr".getBytes("ISO_8859_1");
        Object[] v1 = "\u00f9\u00c1+]\u0091l\u008e\u00db".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -973182419;
                case 1 -> -89839405;
                case 2 -> -845512011;
                case 3 -> 1236927528;
                case 4 -> 689565186;
                case 5 -> -1992326023;
                case 6 -> -911437140;
                case 7 -> -1208965620;
                case 8 -> -1433116043;
                case 9 -> 73314531;
                case 10 -> -648754853;
                case 11 -> 1322378003;
                case 12 -> -1610318920;
                case 13 -> -1202078197;
                case 14 -> 1923007753;
                case 15 -> 926585808;
                case 16 -> 1748622364;
                case 17 -> 342908027;
                case 18 -> 1067277121;
                case 19 -> 1318396284;
                case 20 -> 1684565678;
                case 21 -> -1398498442;
                case 22 -> -1303461841;
                case 23 -> 611985316;
                case 24 -> -2051231329;
                case 25 -> -1677529600;
                case 26 -> 150479019;
                case 27 -> -340224144;
                case 28 -> -563163877;
                case 29 -> -1608800323;
                case 30 -> -1389059038;
                case 31 -> -410757532;
                case 32 -> 544440326;
                case 33 -> -119441971;
                case 34 -> -1421932689;
                case 35 -> 1880390607;
                case 36 -> -1907936248;
                case 37 -> -1722506708;
                case 38 -> -205764210;
                case 39 -> -1293383460;
                case 40 -> -1119822535;
                case 41 -> 765140657;
                case 42 -> 1405163326;
                case 43 -> 1417560299;
                case 44 -> -1717606646;
                case 45 -> -694054291;
                case 46 -> -1540163903;
                case 47 -> 2042105176;
                case 48 -> 1818087229;
                case 49 -> -1436415350;
                case 50 -> -297708908;
                case 51 -> 147719719;
                case 52 -> -1895351536;
                case 53 -> 1051781670;
                case 54 -> -440275207;
                case 55 -> 312610411;
                case 56 -> -209347009;
                case 57 -> -80133795;
                case 58 -> -1761646237;
                case 59 -> -537814502;
                case 60 -> 1920649823;
                case 61 -> 576568250;
                case 62 -> -482359545;
                case 63 -> -2006574959;
                case 64 -> -883101147;
                case 65 -> 1883482850;
                case 66 -> 20200312;
                case 67 -> -567343025;
                case 68 -> -1819476027;
                case 69 -> -1616773510;
                case 70 -> -1142777813;
                case 71 -> -706791720;
                case 72 -> -1104264270;
                case 73 -> -582608309;
                case 74 -> 1588341827;
                case 75 -> 167295291;
                case 76 -> -2098436840;
                case 77 -> 1104995055;
                case 78 -> -685969387;
                case 79 -> 304715118;
                case 80 -> -548039913;
                case 81 -> 1571712581;
                case 82 -> -2140585211;
                case 83 -> -906680235;
                case 84 -> -1170451269;
                case 85 -> 266286675;
                case 86 -> -1473272572;
                case 87 -> 1604633565;
                case 88 -> 1677034572;
                case 89 -> -1565410907;
                case 90 -> 997663288;
                case 91 -> -853795594;
                case 92 -> 779903893;
                case 93 -> 342874978;
                case 94 -> 893020863;
                case 95 -> -959155981;
                case 96 -> -1630556569;
                case 97 -> -1319926884;
                case 98 -> -1738882575;
                case 99 -> -200572778;
                case 100 -> 309867056;
                case 101 -> -1841674400;
                case 102 -> -1529528915;
                case 103 -> -2073965137;
                case 104 -> 39474462;
                case 105 -> 510136589;
                case 106 -> -154662745;
                case 107 -> -1258963933;
                case 108 -> -2080801463;
                case 109 -> -2141643041;
                case 110 -> -1401119214;
                case 111 -> 935293584;
                case 112 -> -1787993909;
                case 113 -> -958151430;
                case 114 -> 445066672;
                case 115 -> 2110500077;
                case 116 -> -1145665598;
                case 117 -> -1594961209;
                case 118 -> -111501961;
                case 119 -> -835595007;
                case 120 -> -1205817322;
                case 121 -> -1157004263;
                case 122 -> 162785106;
                case 123 -> -1434182504;
                case 124 -> -1657353263;
                case 125 -> 2138986990;
                case 126 -> -1808354308;
                case 127 -> -63023858;
                case 128 -> 1874179828;
                case 129 -> -1823850447;
                case 130 -> -1077906535;
                case 131 -> -1079846124;
                case 132 -> 824706690;
                case 133 -> -386534559;
                case 134 -> -795448444;
                case 135 -> -1782394695;
                case 136 -> -1314493809;
                case 137 -> -1377339960;
                case 138 -> -68787623;
                case 139 -> -1151247732;
                case 140 -> -1445097898;
                case 141 -> -73532302;
                case 142 -> -1906777930;
                case 143 -> 456642128;
                case 144 -> 1328775495;
                case 145 -> -458567842;
                case 146 -> -588299820;
                case 147 -> 2048581335;
                case 148 -> 250869521;
                case 149 -> -1050815493;
                case 150 -> 1951859904;
                case 151 -> 1625242058;
                case 152 -> 873202322;
                case 153 -> 574936454;
                case 154 -> -1887500128;
                case 155 -> 1558068949;
                case 156 -> -1840051805;
                case 157 -> 1661521388;
                case 158 -> 1372764982;
                case 159 -> 1256301480;
                case 160 -> -1545068289;
                case 161 -> -551246886;
                case 162 -> 256531241;
                case 163 -> -1689831470;
                case 164 -> -569898895;
                case 165 -> 1738881533;
                case 166 -> 62835362;
                case 167 -> 932979685;
                case 168 -> 70348510;
                case 169 -> -170214938;
                case 170 -> -555572733;
                case 171 -> -335459616;
                case 172 -> 1605519777;
                case 173 -> 517961130;
                case 174 -> 304712321;
                case 175 -> -677333206;
                case 176 -> -2012064203;
                case 177 -> 1868092708;
                case 178 -> -1526602103;
                case 179 -> 2039885106;
                case 180 -> -1283712361;
                case 181 -> 1243288968;
                case 182 -> -1185646235;
                case 183 -> -517257783;
                case 184 -> -964235395;
                case 185 -> -543104357;
                case 186 -> -780105926;
                case 187 -> 1802095323;
                case 188 -> -707135099;
                case 189 -> 1406407270;
                case 190 -> 960663699;
                case 191 -> 1124932686;
                case 192 -> -615967127;
                case 193 -> -1414203943;
                case 194 -> -950092979;
                case 195 -> -1526344223;
                case 196 -> -1333127193;
                case 197 -> -381545164;
                case 198 -> 365392710;
                case 199 -> 961613640;
                case 200 -> 884072318;
                case 201 -> 433739421;
                case 202 -> -1936988585;
                case 203 -> -1072241123;
                case 204 -> -326225160;
                case 205 -> -1771059467;
                case 206 -> 1751212958;
                case 207 -> -333831801;
                case 208 -> -1712696166;
                case 209 -> 1568775951;
                case 210 -> -1420445954;
                case 211 -> -1346557078;
                case 212 -> -1340490977;
                case 213 -> 423113897;
                case 214 -> -2073554637;
                case 215 -> 259962434;
                case 216 -> 1174765908;
                case 217 -> -395974880;
                case 218 -> -995550104;
                case 219 -> -300765757;
                case 220 -> 346966923;
                case 221 -> 2078034036;
                case 222 -> -178637693;
                case 223 -> 1365402458;
                case 224 -> 769512918;
                case 225 -> 716505728;
                case 226 -> 1301219199;
                case 227 -> -1895228813;
                case 228 -> -1361024704;
                case 229 -> -1407039066;
                case 230 -> 1314125124;
                case 231 -> 1083196648;
                case 232 -> -1479552790;
                case 233 -> -1806513458;
                case 234 -> 361692900;
                case 235 -> 369175351;
                case 236 -> 1988011068;
                case 237 -> 808547006;
                case 238 -> 1492658099;
                case 239 -> -1097342884;
                case 240 -> -1247018554;
                case 241 -> 428440560;
                case 242 -> 2128707524;
                case 243 -> 1975357879;
                case 244 -> -1156253615;
                case 245 -> -828664530;
                case 246 -> -246000276;
                case 247 -> -64050508;
                case 248 -> 578442444;
                case 249 -> -1246158303;
                case 250 -> -996396567;
                case 251 -> 882079474;
                case 252 -> -1777958582;
                case 253 -> 2068239036;
                case 254 -> 1134009485;
                case 255 -> 1981285111;
                default -> 2129178721;
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
            Object[] objectArray = new Object[3];
            v1 = objectArray;
            IoO = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        EnumType_I00 = new EnumType_oooi_5("DoNotChange", 0);
        I0o = new EnumType_oooi_5("ForceSprint", 1);
        IrcCommand = new EnumType_oooi_5("ForceNoSprint", 2);
        NetworkSupport_i0i_2 = EnumType_oooi_5.ConfigSupport_OII();
    }

    private static /* synthetic */ EnumType_oooi_5[] ConfigSupport_OII() {
        return new EnumType_oooi_5[]{EnumType_I00, I0o, IrcCommand};
    }
}

