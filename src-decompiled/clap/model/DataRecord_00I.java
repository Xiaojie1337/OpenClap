/*
 * Decompiled with CFR 0.152.
 */
package clap.model;

import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.lang.runtime.ObjectMethods;
import java.security.Key;
import java.security.MessageDigest;
import java.util.function.Consumer;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class DataRecord_00I
extends Record {
    private final Object DataRecord_0O0;
    private final int 0Oo;
    private final Consumer EnumType_0OI;
    static Object 0Oi;
    private static volatile /* synthetic */ long __k__gH4it;

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{DataRecord_00I.class, "host;priority;consumer", "DataRecord_0O0", "0Oo", "EnumType_0OI"}, this);
    }

    public Object 0o0() {
        return this.DataRecord_0O0;
    }

    public DataRecord_00I(Object param1, int param2, Consumer param3) {
        this.DataRecord_0O0 = param1;
        this.0Oo = param2;
        this.EnumType_0OI = param3;
    }

    public void 0oO(Object param1) {
        this.EnumType_0OI.accept(param1);
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{DataRecord_00I.class, "host;priority;consumer", "DataRecord_0O0", "0Oo", "EnumType_0OI"}, this);
    }

    @Override
    public final boolean equals(Object param1) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{DataRecord_00I.class, "host;priority;consumer", "DataRecord_0O0", "0Oo", "EnumType_0OI"}, this, param1);
    }

    static {
        __k__gH4it = DataRecord_00I.__k__gH4it((long)-805447364243362287L);
        __rP__gH4it0 = new String[]{"\u70e7\u9227\u4dfa\u18d4\u9fc9\u492f\u8cd7\u4fff\u71f9\u934d", "\u70e5\u9225\u4df4\u18da\u9fcb\u492d\u8cd1\u4ff9\u71fb\u934f", "\u70e7\u923e\u4deb"};
        __rP__gH4it1 = new String[]{"\u70d1\u920a\u4d18\u18f9\u9fdc\u484f\u8dcb\u4f8e\u719e\u93e7\u4c8c\u19b7\u9e0f\u572c\u920a\u50fa\u6e99\u8cb8\u536e\u06a1\u813c\u57ea\u9389\u51f9\u6fa0\u8d02\u526f\u0712\u80c8\u5685\u9089\u52cf\u6c36\u8ea4\u5130\u041e\u837b\u552a\u91a9\u53ae\u6dd6\u8f29\u5005\u0533\u8281\u5458\u960d\u548c\u6a28\u8838\u57c8\u028f\u85f2\u538d\u9664\u5599\u6bae\u89cb\u5610\u03f0\u84f6\u520a\u9763\u56d5\u6895\u8a80\u55c7\u00c0\u8704\u5138\u9480\u57f6\u6977\u8b9c\u546f\u012e\u86c0\u508b\u95cf\u584f"};
        __rP__gH4it2 = new String[]{"\u70f1\u9234\u4de1\u18a1\u9fb9\u4958\u8cae\u4fe4\u71fd\u9332\u4cf9\u19d5\u9ec7\u4842\u8d84\u50a7\u6ec1\u8c68\u53ec\u0619", "\u70f2\u922b\u4dfa\u1851\u9ff0"};
        __rP__gH4it3 = new String[]{"\u70e3\u92b6\u4da7\u18ac\u9f93\u4995\u8cef\u4fe4", "\u70f7\u9236\u4dc2\u1850\u9ff9\u4958\u8cea"};
        byte[] v0 = "$\u00bbj7f\u0095\u00e6\u0005s^\u00f6q\u00bd\u00fe/y|\u00f9,\u001f\u00b6\u00c0\u0094\u0002}K%\u00a4J\u00a7\u009c<\u00e3\u00f5b\u00b0\u00e1\u0010\u00a4E\u001bp_\u0095\u0013j\bo\u00edYj\u0011\u0018\u0087\u0099B\u0013\u00a2\u00baf\u0014\b\u0096\u0006 \u00f1uN\u00fe\"m=\u00da\u00e5\u00d5\u00a82\u0099*\u008c".getBytes("ISO_8859_1");
        Object[] v1 = "L\u00c1\u0013(c\u0081\f%".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 2087505571;
                case 1 -> 1635322698;
                case 2 -> -1631573769;
                case 3 -> 1377985163;
                case 4 -> 1690093986;
                case 5 -> -1106209551;
                case 6 -> -946949888;
                case 7 -> 540374595;
                case 8 -> 1928988844;
                case 9 -> -2128400347;
                case 10 -> 406351296;
                case 11 -> 1156224380;
                case 12 -> 90189639;
                case 13 -> 1789103758;
                case 14 -> -2121557480;
                case 15 -> -640261992;
                case 16 -> -1857825519;
                case 17 -> -1238138674;
                case 18 -> 1564339974;
                case 19 -> -485764401;
                case 20 -> 2105596402;
                case 21 -> 466596333;
                case 22 -> -1646749461;
                case 23 -> -1778661581;
                case 24 -> 665190782;
                case 25 -> -1808794054;
                case 26 -> 57450935;
                case 27 -> 740245293;
                case 28 -> -1954893080;
                case 29 -> 1454634779;
                case 30 -> 67381468;
                case 31 -> -2125271830;
                case 32 -> 1526970898;
                case 33 -> -935974406;
                case 34 -> -416873208;
                case 35 -> -1121979781;
                case 36 -> -1543995027;
                case 37 -> 546847521;
                case 38 -> -535836785;
                case 39 -> -577317097;
                case 40 -> 652872530;
                case 41 -> -1014695404;
                case 42 -> 345518740;
                case 43 -> 387907119;
                case 44 -> -932073560;
                case 45 -> 1996808480;
                case 46 -> 900893865;
                case 47 -> 535711585;
                case 48 -> -1915394290;
                case 49 -> 1263843591;
                case 50 -> -71860982;
                case 51 -> -50215836;
                case 52 -> 820779247;
                case 53 -> -1573562590;
                case 54 -> -1020900227;
                case 55 -> 715723051;
                case 56 -> -756267605;
                case 57 -> -68771792;
                case 58 -> 401581770;
                case 59 -> -1052468408;
                case 60 -> -948701936;
                case 61 -> 611276677;
                case 62 -> 71391388;
                case 63 -> -789158595;
                case 64 -> -255798697;
                case 65 -> -537506448;
                case 66 -> -431253664;
                case 67 -> -1040464349;
                case 68 -> 268159692;
                case 69 -> 269027620;
                case 70 -> -1126251973;
                case 71 -> 1282340150;
                case 72 -> -1595169003;
                case 73 -> 2029453617;
                case 74 -> -1085622078;
                case 75 -> 512540282;
                case 76 -> -74026967;
                case 77 -> 1026025839;
                case 78 -> -1881721537;
                case 79 -> -1383333117;
                case 80 -> 814847910;
                case 81 -> -137970718;
                case 82 -> -339817911;
                case 83 -> -405158403;
                case 84 -> 1379739353;
                case 85 -> 797082636;
                case 86 -> -838049401;
                case 87 -> -1721376148;
                case 88 -> 237407854;
                case 89 -> -255782554;
                case 90 -> 0x16556165;
                case 91 -> -1462121622;
                case 92 -> -762070824;
                case 93 -> 2075066848;
                case 94 -> -683085615;
                case 95 -> -665597768;
                case 96 -> 1962900607;
                case 97 -> -1990465358;
                case 98 -> 229562852;
                case 99 -> 718711125;
                case 100 -> -480464762;
                case 101 -> 583564094;
                case 102 -> 485953967;
                case 103 -> 1380379178;
                case 104 -> -612019491;
                case 105 -> -122161485;
                case 106 -> -1524306165;
                case 107 -> -976509460;
                case 108 -> -1232101138;
                case 109 -> -1435160601;
                case 110 -> 351243805;
                case 111 -> 385543109;
                case 112 -> -786756157;
                case 113 -> 936317466;
                case 114 -> 1688395866;
                case 115 -> 1654540548;
                case 116 -> 172191899;
                case 117 -> -1365807018;
                case 118 -> 820213581;
                case 119 -> -111829420;
                case 120 -> -922168184;
                case 121 -> -383100311;
                case 122 -> -1573841983;
                case 123 -> -1842640639;
                case 124 -> 1205782631;
                case 125 -> 1228110349;
                case 126 -> 1025661597;
                case 127 -> 378539710;
                case 128 -> -402775143;
                case 129 -> -750115938;
                case 130 -> -1844025997;
                case 131 -> -1050461451;
                case 132 -> -1639939395;
                case 133 -> -195820371;
                case 134 -> 1606355412;
                case 135 -> 1526915938;
                case 136 -> 1241319967;
                case 137 -> -1003897890;
                case 138 -> -726601804;
                case 139 -> -1611933897;
                case 140 -> -674091375;
                case 141 -> 2029498955;
                case 142 -> 1330967884;
                case 143 -> -1213199403;
                case 144 -> 1589672001;
                case 145 -> 1468596373;
                case 146 -> 191392551;
                case 147 -> 1141414875;
                case 148 -> 431400796;
                case 149 -> 357648498;
                case 150 -> 1055922164;
                case 151 -> 1155775763;
                case 152 -> -353397271;
                case 153 -> -454706608;
                case 154 -> 140256625;
                case 155 -> 1941693665;
                case 156 -> 1837545785;
                case 157 -> 1139063554;
                case 158 -> 1792632436;
                case 159 -> -7945128;
                case 160 -> -189778556;
                case 161 -> -850470890;
                case 162 -> 1051622585;
                case 163 -> -1067455236;
                case 164 -> -213003416;
                case 165 -> 1951074894;
                case 166 -> 675930743;
                case 167 -> 670835359;
                case 168 -> 1651134051;
                case 169 -> 2088463269;
                case 170 -> 865070774;
                case 171 -> -818950945;
                case 172 -> -575091070;
                case 173 -> -1784224674;
                case 174 -> -666489974;
                case 175 -> -1968965604;
                case 176 -> 1523484321;
                case 177 -> -1278248534;
                case 178 -> -764690898;
                case 179 -> 1048238298;
                case 180 -> -425148211;
                case 181 -> -1978390112;
                case 182 -> 606382721;
                case 183 -> 593349323;
                case 184 -> -2056137541;
                case 185 -> 557360278;
                case 186 -> -1328012546;
                case 187 -> 343687163;
                case 188 -> -1097080968;
                case 189 -> 2040279492;
                case 190 -> 2021672990;
                case 191 -> -1633416103;
                case 192 -> 596649648;
                case 193 -> -687040298;
                case 194 -> -2127822587;
                case 195 -> -1978595544;
                case 196 -> 362707647;
                case 197 -> -2106006222;
                case 198 -> -912672057;
                case 199 -> 874184373;
                case 200 -> -1731714605;
                case 201 -> -179089257;
                case 202 -> 752634791;
                case 203 -> 1355174483;
                case 204 -> 1085667865;
                case 205 -> 1940958605;
                case 206 -> 1248417763;
                case 207 -> 934076216;
                case 208 -> 1675751314;
                case 209 -> -1205393594;
                case 210 -> 1375916272;
                case 211 -> 687468869;
                case 212 -> 720893174;
                case 213 -> 374679925;
                case 214 -> -438075433;
                case 215 -> -2020776177;
                case 216 -> -1208805744;
                case 217 -> 706001984;
                case 218 -> 699447187;
                case 219 -> -1173926037;
                case 220 -> 901731961;
                case 221 -> 149863552;
                case 222 -> -130967729;
                case 223 -> -1363240530;
                case 224 -> -562991899;
                case 225 -> -324754379;
                case 226 -> 787381828;
                case 227 -> 599435017;
                case 228 -> -407792559;
                case 229 -> 1474224934;
                case 230 -> -69103159;
                case 231 -> 753983698;
                case 232 -> 1258753115;
                case 233 -> -461837780;
                case 234 -> 948667970;
                case 235 -> -1383823117;
                case 236 -> -830083959;
                case 237 -> -859609284;
                case 238 -> -1655832166;
                case 239 -> -707232257;
                case 240 -> -767989364;
                case 241 -> 430467004;
                case 242 -> 438254132;
                case 243 -> 1294445520;
                case 244 -> -1010777414;
                case 245 -> 1713655800;
                case 246 -> -322910115;
                case 247 -> -1554889098;
                case 248 -> -1003133601;
                case 249 -> -935207293;
                case 250 -> 1256045049;
                case 251 -> 2077958344;
                case 252 -> -657130010;
                case 253 -> -2013876060;
                case 254 -> 907169734;
                case 255 -> -1494108751;
                default -> -984448596;
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
            Object[] objectArray = new Object[2];
            v1 = objectArray;
            0Oi = objectArray;
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

    public int 0oi() {
        return this.0Oo;
    }

    public static DataRecord_00I 00i(Object param0, int param1, Method param2) {
        return new DataRecord_00I(param0, param1, DataRecord_00I.SpawnerFinderModule(param0, param2));
    }

    private static Consumer SpawnerFinderModule(Object param0, Method param1) {
        try {
            MethodHandles.Lookup v2 = MethodHandles.privateLookupIn(param0.getClass(), MethodHandles.lookup());
            CallSite v3 = LambdaMetafactory.metafactory(v2, "accept", MethodType.methodType(Consumer.class, param0.getClass()), MethodType.methodType(Void.TYPE, Object.class), v2.unreflect(param1), MethodType.methodType(Void.TYPE, param1.getParameterTypes()[0]));
            MethodHandle v4 = v3.getTarget();
            return v4.invoke(param0);
        }
        catch (Throwable v2) {
            throw new RuntimeException("Failed to build lambda from %s method".formatted(param1.getName()), v2);
        }
    }

    public Consumer AutoMlgModule() {
        return this.EnumType_0OI;
    }

    public Object 0oI() {
        return this.DataRecord_0O0;
    }
}

