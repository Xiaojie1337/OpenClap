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

public final class EnumType_0O00
extends Enum {
    public static final /* enum */ EnumType_0O00 World;
    public static final /* enum */ EnumType_0O00 Gui;
    private static final /* synthetic */ EnumType_0O00[] $VALUES;
    static Object PacketEvent;

    public static EnumType_0O00[] values() {
        return (EnumType_0O00[])$VALUES.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EnumType_0O00() {
        void param2;
        void param1;
    }

    public static EnumType_0O00 valueOf(String param0) {
        return Enum.valueOf(EnumType_0O00.class, param0);
    }

    static {
        byte[] v0 = "S\b\u00b6\u00fe\u00ef\u00e1\u00a9\u00e7\u00c0\u001d\u00c2\u00b3\u0096q\u00b1\u00dd\u00f2\u00e6\u0007\u00d8\u00bc\u00ee\u0010\t\u0001\u00a9a\u009a\u00ba\f_\u0096u\\\u00ab\u00aa\u00bc ?f\u00c6\f\u00de-\u009d'n\u001b".getBytes("ISO_8859_1");
        Object[] v1 = "L\u009d\u009fV.\u00fc.\\".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -822956926;
                case 1 -> -1266734500;
                case 2 -> -1919688941;
                case 3 -> 211858586;
                case 4 -> 345017044;
                case 5 -> 1489023995;
                case 6 -> 2015929780;
                case 7 -> -2118058762;
                case 8 -> -2037683816;
                case 9 -> 81921225;
                case 10 -> -362458265;
                case 11 -> -1089319989;
                case 12 -> 932888746;
                case 13 -> 809976875;
                case 14 -> 1383030173;
                case 15 -> 313258411;
                case 16 -> 622338938;
                case 17 -> 1086347564;
                case 18 -> -555747629;
                case 19 -> -865071360;
                case 20 -> 1744914262;
                case 21 -> -1019613873;
                case 22 -> -1033697934;
                case 23 -> -1878301496;
                case 24 -> -133651718;
                case 25 -> 1057499671;
                case 26 -> -922317039;
                case 27 -> 163281601;
                case 28 -> 1826846500;
                case 29 -> 77225360;
                case 30 -> -211934231;
                case 31 -> 1368552217;
                case 32 -> -2087813419;
                case 33 -> -1379681782;
                case 34 -> -338556311;
                case 35 -> -256972667;
                case 36 -> 1831899655;
                case 37 -> 1270278909;
                case 38 -> -1314241289;
                case 39 -> -1739488550;
                case 40 -> -1781205060;
                case 41 -> 1788291217;
                case 42 -> -1344173943;
                case 43 -> 1126258117;
                case 44 -> 145567270;
                case 45 -> 760941809;
                case 46 -> 332193614;
                case 47 -> -125099963;
                case 48 -> 1747217993;
                case 49 -> 736776878;
                case 50 -> -848787317;
                case 51 -> -2143884674;
                case 52 -> -2012402406;
                case 53 -> 1646341431;
                case 54 -> 1759723110;
                case 55 -> 1934801679;
                case 56 -> -1445765466;
                case 57 -> 637078783;
                case 58 -> 1661802104;
                case 59 -> -1440197674;
                case 60 -> -1675345395;
                case 61 -> -1631598642;
                case 62 -> -1193313119;
                case 63 -> -1587601018;
                case 64 -> 723973090;
                case 65 -> -1002198545;
                case 66 -> 27793032;
                case 67 -> 715844467;
                case 68 -> 1651445822;
                case 69 -> 1147916884;
                case 70 -> 733516123;
                case 71 -> 1404752692;
                case 72 -> -1065015322;
                case 73 -> 1696190672;
                case 74 -> 18453947;
                case 75 -> -1690060536;
                case 76 -> 729205980;
                case 77 -> -1196784592;
                case 78 -> 2095017657;
                case 79 -> 977020486;
                case 80 -> -526748940;
                case 81 -> 1111072936;
                case 82 -> 111356676;
                case 83 -> -703646203;
                case 84 -> -841909729;
                case 85 -> 86793632;
                case 86 -> 948644679;
                case 87 -> 1928279824;
                case 88 -> 1918176687;
                case 89 -> 1455238197;
                case 90 -> -2122681311;
                case 91 -> -87561091;
                case 92 -> 650163358;
                case 93 -> 428575480;
                case 94 -> -525450897;
                case 95 -> 1625010061;
                case 96 -> 970441200;
                case 97 -> 533740593;
                case 98 -> 109417540;
                case 99 -> 51764819;
                case 100 -> -944701033;
                case 101 -> -1442345672;
                case 102 -> 1067899341;
                case 103 -> -875540149;
                case 104 -> 1439057558;
                case 105 -> -1964481157;
                case 106 -> -529282749;
                case 107 -> 410042901;
                case 108 -> -1239695300;
                case 109 -> 798507774;
                case 110 -> 519841822;
                case 111 -> 371089888;
                case 112 -> 1217214446;
                case 113 -> 1098478809;
                case 114 -> -576450075;
                case 115 -> 488574274;
                case 116 -> -1852989631;
                case 117 -> -17683753;
                case 118 -> 1354422966;
                case 119 -> 1215223046;
                case 120 -> 461869484;
                case 121 -> -950002083;
                case 122 -> 1636556066;
                case 123 -> -1055142492;
                case 124 -> 1775478156;
                case 125 -> -984217628;
                case 126 -> 2051182944;
                case 127 -> -820292258;
                case 128 -> 1143193628;
                case 129 -> -1904407869;
                case 130 -> 59758704;
                case 131 -> 183325607;
                case 132 -> 227592083;
                case 133 -> -79309971;
                case 134 -> 1469476213;
                case 135 -> 129307074;
                case 136 -> 359286764;
                case 137 -> 926557903;
                case 138 -> -1853834269;
                case 139 -> 1941352348;
                case 140 -> -1614932903;
                case 141 -> 108590100;
                case 142 -> 1048751976;
                case 143 -> 681796818;
                case 144 -> -1299716082;
                case 145 -> -1292611449;
                case 146 -> 539898034;
                case 147 -> -1794245971;
                case 148 -> -791187569;
                case 149 -> -710290542;
                case 150 -> -2127995030;
                case 151 -> -1610333608;
                case 152 -> -1455592439;
                case 153 -> -494712089;
                case 154 -> -255735964;
                case 155 -> -295604758;
                case 156 -> 783733077;
                case 157 -> -1172916980;
                case 158 -> -272101483;
                case 159 -> -1036485069;
                case 160 -> -1789465051;
                case 161 -> -1738932071;
                case 162 -> 1439955681;
                case 163 -> 1995788333;
                case 164 -> -1671420096;
                case 165 -> 600829619;
                case 166 -> 566796767;
                case 167 -> -2084184960;
                case 168 -> 1888272270;
                case 169 -> -1694948579;
                case 170 -> 1869431809;
                case 171 -> -2000374471;
                case 172 -> 692041731;
                case 173 -> -1355982430;
                case 174 -> 1584342786;
                case 175 -> 91812918;
                case 176 -> 2087703647;
                case 177 -> 1638795641;
                case 178 -> -1989851968;
                case 179 -> 802094724;
                case 180 -> 765272433;
                case 181 -> -1559941279;
                case 182 -> -172568083;
                case 183 -> -319757647;
                case 184 -> 105105179;
                case 185 -> -891819658;
                case 186 -> 600960734;
                case 187 -> 278673992;
                case 188 -> -935012019;
                case 189 -> -1736565089;
                case 190 -> -1708137053;
                case 191 -> -553727103;
                case 192 -> -1628935110;
                case 193 -> -131244169;
                case 194 -> 830002762;
                case 195 -> -402501313;
                case 196 -> -1750447584;
                case 197 -> -2036941744;
                case 198 -> -722415637;
                case 199 -> -192728905;
                case 200 -> -1019942747;
                case 201 -> -759414222;
                case 202 -> -462126801;
                case 203 -> 494205895;
                case 204 -> -821789144;
                case 205 -> -725858996;
                case 206 -> -51626909;
                case 207 -> -1380774703;
                case 208 -> 1533439145;
                case 209 -> 1973275578;
                case 210 -> 1971308881;
                case 211 -> 6983485;
                case 212 -> -1775807798;
                case 213 -> 1762305469;
                case 214 -> 859720299;
                case 215 -> -1158754971;
                case 216 -> -360419502;
                case 217 -> -476508917;
                case 218 -> -1365683909;
                case 219 -> 278894610;
                case 220 -> -115654054;
                case 221 -> -535830594;
                case 222 -> -968704843;
                case 223 -> -308997772;
                case 224 -> -1059291524;
                case 225 -> -114443316;
                case 226 -> -1510928765;
                case 227 -> 541279319;
                case 228 -> -1967800334;
                case 229 -> 1026339483;
                case 230 -> 92689044;
                case 231 -> -965001995;
                case 232 -> 116891939;
                case 233 -> -2118042585;
                case 234 -> 38917161;
                case 235 -> 911646168;
                case 236 -> 1135877352;
                case 237 -> 1810669450;
                case 238 -> 15014783;
                case 239 -> 1660279404;
                case 240 -> 11225849;
                case 241 -> -1276636164;
                case 242 -> 1450771224;
                case 243 -> -691497800;
                case 244 -> 370868420;
                case 245 -> -605080466;
                case 246 -> -446175013;
                case 247 -> -56963798;
                case 248 -> 2049430214;
                case 249 -> 503683426;
                case 250 -> -1660013392;
                case 251 -> -1122444557;
                case 252 -> 584872925;
                case 253 -> 1513925142;
                case 254 -> -1431124033;
                case 255 -> -886614226;
                default -> -349794775;
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
        World = new EnumType_0O00("World", 0);
        Gui = new EnumType_0O00("Gui", 1);
        $VALUES = EnumType_0O00.$values();
    }

    private static /* synthetic */ EnumType_0O00[] $values() {
        return new EnumType_0O00[]{World, Gui};
    }
}

