/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Position
 *  net.minecraft.util.math.Vec3d
 */
package clap.render;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.Key;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Vec3d;
import clap.event.EventBusApi;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from psx.Hyk.0OoO
 */
public class RenderSupport_0ooo_1
implements EventBusApi {
    private static final Random Ii00;
    static Object Ii0o;
    private static volatile /* synthetic */ long __k__gH4it;

    public static double O0IiO(double param0, double param2, double param4) {
        return param0 < param2 ? param2 : Math.min(param0, param4);
    }

    public static float EnumType_0OI(float param0, float param1, float param2) {
        return param0 < param1 ? param1 : Math.min(param0, param2);
    }

    public static int O0II0(int param0, int param1) {
        return param0 + Ii00.nextInt(param1 - param0 + 1);
    }

    public static Vec3d O0iOi(float param0) {
        return new Vec3d(Math.cos(RenderSupport_0ooo_1.O0i0i(param0 + 90.0f)), 0.0, Math.sin(RenderSupport_0ooo_1.O0i0i(param0 + 90.0f)));
    }

    public static Vec3d O0iOO(Vec3d param0, int param1) {
        return new Vec3d(RenderSupport_0ooo_1.O0iOo(param0.x, param1), RenderSupport_0ooo_1.O0iOo(param0.y, param1), RenderSupport_0ooo_1.O0iOo(param0.z, param1));
    }

    public static double O0Iii(double param0) {
        return MathHelper.wrapDegrees((double)param0);
    }

    public static float O0IiI(float param0) {
        return MathHelper.wrapDegrees((float)param0);
    }

    public static boolean O0ioI(Vec3d param0, Vec3d param1) {
        return RenderSupport_0ooo_1.O0ioi(param0, param1);
    }

    public static int O0IIi(int param0, int param1, int param2) {
        return param0 < param1 ? param1 : Math.min(param0, param2);
    }

    public static float O0III(float param0, float param1) {
        return MathHelper.clamp((float)(param0 + Ii00.nextFloat() * param1), (float)param0, (float)param1);
    }

    public static boolean O0ioi(Vec3d param0, Vec3d param1) {
        BlockPos v2 = BlockPos.ofFloored((Position)param0);
        BlockPos v3 = BlockPos.ofFloored((double)param1.x, (double)param0.y, (double)param1.z);
        return v2.equals((Object)v3);
    }

    public static float O0Iio(float param0) {
        return MathHelper.cos((double)param0);
    }

    public static double O0ioO(double param0, double param2) {
        return (double)Math.round(param0 * param2) / param2;
    }

    public static double O0IIo(double param0, double param2) {
        return MathHelper.clamp((double)(param0 + Ii00.nextDouble() * param2), (double)param0, (double)param2);
    }

    public static List O0ioo(Entity param0) {
        ArrayList<Vec3d> v1 = new ArrayList<Vec3d>();
        Box v2 = param0.method_5829();
        double v3 = param0.getY();
        double v5 = RenderSupport_0ooo_1.O0iOo(v2.minX, 0);
        double v7 = RenderSupport_0ooo_1.O0iOo(v2.minZ, 0);
        double v9 = RenderSupport_0ooo_1.O0iOo(v2.maxX, 0);
        double v11 = RenderSupport_0ooo_1.O0iOo(v2.maxZ, 0);
        if (v5 != v9) {
            v1.add(new Vec3d(v5, v3, v7));
            v1.add(new Vec3d(v9, v3, v7));
            if (v7 != v11) {
                v1.add(new Vec3d(v5, v3, v11));
                v1.add(new Vec3d(v9, v3, v11));
                return v1;
            }
        } else if (v7 != v11) {
            v1.add(new Vec3d(v5, v3, v7));
            v1.add(new Vec3d(v5, v3, v11));
            return v1;
        }
        v1.add(param0.method_73189());
        return v1;
    }

    public static double[] O0io0(double param0) {
        float v2 = RenderSupport_0ooo_1.ConfigSupport_OI0.player.input.getMovementInput().y;
        float v3 = RenderSupport_0ooo_1.ConfigSupport_OI0.player.input.getMovementInput().x;
        float v4 = RenderSupport_0ooo_1.ConfigSupport_OI0.player.field_5982 + (RenderSupport_0ooo_1.ConfigSupport_OI0.player.method_36454() - RenderSupport_0ooo_1.ConfigSupport_OI0.player.field_5982) * ConfigSupport_OI0.getRenderTickCounter().getTickProgress(false);
        if (v2 != 0.0f) {
            if (v3 > 0.0f) {
                v4 += (float)(v2 > 0.0f ? -45 : 45);
            } else if (v3 < 0.0f) {
                v4 += (float)(v2 > 0.0f ? 45 : -45);
            }
            v3 = 0.0f;
            if (v2 > 0.0f) {
                v2 = 1.0f;
            } else if (v2 < 0.0f) {
                v2 = -1.0f;
            }
        }
        double v5 = Math.sin(Math.toRadians(v4 + 90.0f));
        double v7 = Math.cos(Math.toRadians(v4 + 90.0f));
        double v9 = (double)v2 * param0 * v7 + (double)v3 * param0 * v5;
        double v11 = (double)v2 * param0 * v5 - (double)v3 * param0 * v7;
        return new double[]{v9, v11};
    }

    public static double O0i0I(double param0) {
        return param0 * (double)57.29578f;
    }

    static {
        __k__gH4it = RenderSupport_0ooo_1.__k__gH4it((long)8563425133669117457L);
        __rP__gH4it0 = new String[]{"\u9883\u7f0d\ua111\uf4fe\u73af\uf109\u5899\ua3dd\u99ed\u7e57", "\u9883\u7f18\ua108", "\u9893\u7f1c\ua111\uf482\u73af\uf10e\u596c"};
        __rP__gH4it1 = new String[]{"\u9847\u7fd6\ua192\uf41c\u7379\uf103\u58fc\ua39f"};
        __rP__gH4it2 = new String[]{"\u986f\u7fe0\ua1be\uf4f1\u7320\uf1b3\u58cf\ua3e2\u99ac\u7ea1\ua04e\uf572\u7298\uf0ce\u5900\ua315\u9e6f\u79ff\ua733\uf264\u750b\uf7ed\u5e4f\ua446\u9f10\u78dc\ua6a8\uf3c0\u740a\uf6f7\u5fe7\ua581\u9c98\u7b2c\ua5d6\uf0d7\u77f6\uf5ae\u5c07\ua619\u9d8b\u7a94\ua478\uf11e\u766f\uf465\u5d5c\ua73b\u9d2e\u75ca\uabf2\ufeff\u7960\ufb47\u523a\ua821\u9271\u74d5\uaa37\uffbc\u78a5\ufabe\u5317\ua9df\u93f0\u77a0\ua9ef\ufc94\u7bdd\uf939\u507f\uaa54\u908f\u763b\ua838\ufdcb\u7a14\uf8ed\u51b7\uab9a\u91fe\u7679\uaff9\ufa0c\u7dfb\uff17\u568b\uac1b\u9687\u7171\uae85\ufbc0\u7ca7\ufe6f\u5791\uadf0", "\u9896\u7f05\ua111\uf487\u73a6"};
        __rP__gH4it3 = new String[]{"\u9881\u7f0f\ua117\uf4f8\u73ad\uf10b\u5967\ua3e3\u99ef\u7e55", "\u9895\u7f02\ua112\uf497\u73cf\uf16a\u5908\ua3e2\u9989\u7e04\ua00a\uf5e3\u72b1\uf070\u5e22\ua4b1\u9ea5\u793e\ua73f\uf2cf"};
        byte[] v0 = "\u00ce\u0097\u000fy\u00dc\u00abt\u001f\u0005\u00de\u00f7\u00f2l\u00de\u00b3\u0010\u00fe\u00f8\u00b2\u001c\u00c7\u0085\u00c4K\u0089\u00d3!\u00b0\u00ce\u0097d\u0094\u0019;G\u00bf*\u00d6\u009c\u0004\u0002\u008b\u00e1~\u00bb\u0015\u00cf\u001e_\u00ed\u0013\u00a7L\u000f\u00d1\f\b\u00fa\u00de\u00ec\u0081\u00fe\u00f4\u00ea\u0091\u0097\u001e\u00dc\u00e1a\u0084i\u00e6\u0004\u00c1\u008b \u00bdD\u00df\u00af\u00be84\u00f7\u00bf@V\u00de\u00beL\u00f0\u00a3\u00cfR\u00a5".getBytes("ISO_8859_1");
        Object[] v1 = "\u008c\u008f\u00cd\u00be\u00ef\rQx".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 560701689;
                case 1 -> 422703931;
                case 2 -> -168985363;
                case 3 -> -279411960;
                case 4 -> 1196254683;
                case 5 -> -696421329;
                case 6 -> -1422734540;
                case 7 -> 2098144866;
                case 8 -> -247955381;
                case 9 -> -1819325457;
                case 10 -> -1740814164;
                case 11 -> 204591888;
                case 12 -> 455518664;
                case 13 -> 1862716620;
                case 14 -> -1672775298;
                case 15 -> 1784164126;
                case 16 -> -1486561636;
                case 17 -> -882888190;
                case 18 -> -907476391;
                case 19 -> -793037049;
                case 20 -> 1901299743;
                case 21 -> -193904974;
                case 22 -> -925729417;
                case 23 -> -600174350;
                case 24 -> -711960434;
                case 25 -> -1624909603;
                case 26 -> -115378501;
                case 27 -> -1588711952;
                case 28 -> 1978377175;
                case 29 -> 261874745;
                case 30 -> 135963060;
                case 31 -> 1298771180;
                case 32 -> 592731243;
                case 33 -> -1108485168;
                case 34 -> 825974723;
                case 35 -> -1450898889;
                case 36 -> -419235784;
                case 37 -> 149940101;
                case 38 -> -1120726138;
                case 39 -> 1716493294;
                case 40 -> -2303919;
                case 41 -> 1343982723;
                case 42 -> 1496580328;
                case 43 -> -1547150437;
                case 44 -> 110034885;
                case 45 -> 1461851018;
                case 46 -> 1891539282;
                case 47 -> -902098080;
                case 48 -> 326646642;
                case 49 -> 1314804474;
                case 50 -> -677543495;
                case 51 -> -738732191;
                case 52 -> -764933967;
                case 53 -> 937590207;
                case 54 -> 1200071441;
                case 55 -> 1138320285;
                case 56 -> -1699167991;
                case 57 -> -1721297580;
                case 58 -> -1335679498;
                case 59 -> -2028937506;
                case 60 -> 1805711733;
                case 61 -> -1137953408;
                case 62 -> 1117462029;
                case 63 -> -1628177807;
                case 64 -> -1375661933;
                case 65 -> -449922859;
                case 66 -> -878359891;
                case 67 -> 66357837;
                case 68 -> -1011920752;
                case 69 -> 1982270459;
                case 70 -> 1156851229;
                case 71 -> 2075589936;
                case 72 -> 966143479;
                case 73 -> 1390388965;
                case 74 -> -664453864;
                case 75 -> 2075087190;
                case 76 -> 991788074;
                case 77 -> 47016130;
                case 78 -> -1845330815;
                case 79 -> -301828845;
                case 80 -> 328249637;
                case 81 -> 615805325;
                case 82 -> 686349858;
                case 83 -> 837038687;
                case 84 -> -624853210;
                case 85 -> -37213861;
                case 86 -> -678047439;
                case 87 -> -913833305;
                case 88 -> 776429885;
                case 89 -> 1331527213;
                case 90 -> -100659445;
                case 91 -> -935495158;
                case 92 -> 900853015;
                case 93 -> -1976393816;
                case 94 -> -587734913;
                case 95 -> 297216158;
                case 96 -> 1594688753;
                case 97 -> -859849045;
                case 98 -> -778700675;
                case 99 -> 1376063500;
                case 100 -> -814536218;
                case 101 -> 2134411859;
                case 102 -> -1606460353;
                case 103 -> 582624102;
                case 104 -> -1839490496;
                case 105 -> 2082373344;
                case 106 -> 70785494;
                case 107 -> -1756997230;
                case 108 -> 387384009;
                case 109 -> 1941975948;
                case 110 -> 36021665;
                case 111 -> -821734636;
                case 112 -> -1882795522;
                case 113 -> 201475561;
                case 114 -> -58904284;
                case 115 -> -1189369877;
                case 116 -> -1521969571;
                case 117 -> 1485999724;
                case 118 -> 535386162;
                case 119 -> -616876626;
                case 120 -> -1588601252;
                case 121 -> -496059943;
                case 122 -> -1837766617;
                case 123 -> 990460090;
                case 124 -> 1887341309;
                case 125 -> 213085977;
                case 126 -> 570926774;
                case 127 -> -127473876;
                case 128 -> -1963683439;
                case 129 -> 943301934;
                case 130 -> -1668195912;
                case 131 -> 1334299766;
                case 132 -> 399348584;
                case 133 -> 1541132394;
                case 134 -> -1781105120;
                case 135 -> -1697692342;
                case 136 -> 1083428195;
                case 137 -> -1533739044;
                case 138 -> -425762358;
                case 139 -> 673234424;
                case 140 -> 974472826;
                case 141 -> 591930266;
                case 142 -> 1598655650;
                case 143 -> -773549948;
                case 144 -> -1316929616;
                case 145 -> 639502034;
                case 146 -> -421870770;
                case 147 -> -205670204;
                case 148 -> 209798643;
                case 149 -> -313739039;
                case 150 -> -278135137;
                case 151 -> -1811241126;
                case 152 -> -765300369;
                case 153 -> 1325625614;
                case 154 -> -601548988;
                case 155 -> 672003720;
                case 156 -> 144224393;
                case 157 -> 811742003;
                case 158 -> -1286004392;
                case 159 -> -951989177;
                case 160 -> -953211187;
                case 161 -> -1709922301;
                case 162 -> 2078184264;
                case 163 -> -1390209933;
                case 164 -> -1755974802;
                case 165 -> -2103702338;
                case 166 -> -1631728442;
                case 167 -> -1376779531;
                case 168 -> -1334900072;
                case 169 -> 382473176;
                case 170 -> -117205434;
                case 171 -> -2069402283;
                case 172 -> 335598086;
                case 173 -> 2126194851;
                case 174 -> 1277991937;
                case 175 -> 1162670874;
                case 176 -> 672051785;
                case 177 -> -1968802711;
                case 178 -> -109440392;
                case 179 -> -1873801915;
                case 180 -> 1589959593;
                case 181 -> -867271813;
                case 182 -> 1825503623;
                case 183 -> -1858967781;
                case 184 -> -345643505;
                case 185 -> -564570397;
                case 186 -> 28882748;
                case 187 -> 762065668;
                case 188 -> 2084442725;
                case 189 -> -1198277092;
                case 190 -> 675083925;
                case 191 -> -950841565;
                case 192 -> -1991687403;
                case 193 -> 767199424;
                case 194 -> -97387453;
                case 195 -> 1974755810;
                case 196 -> 1819672663;
                case 197 -> 302658404;
                case 198 -> -1668941631;
                case 199 -> -904176745;
                case 200 -> 742467650;
                case 201 -> 426421479;
                case 202 -> -1255346879;
                case 203 -> 398129364;
                case 204 -> 2030765279;
                case 205 -> -2065073967;
                case 206 -> -441174690;
                case 207 -> 1773741586;
                case 208 -> -1035995460;
                case 209 -> 160747269;
                case 210 -> -956968540;
                case 211 -> -476024358;
                case 212 -> -1216611434;
                case 213 -> -1964085994;
                case 214 -> -212535353;
                case 215 -> 1880418976;
                case 216 -> -730751179;
                case 217 -> -380298774;
                case 218 -> -1785685975;
                case 219 -> 1525486671;
                case 220 -> 1641167103;
                case 221 -> 489695636;
                case 222 -> -103825511;
                case 223 -> -1833579061;
                case 224 -> 1526628084;
                case 225 -> -2103932758;
                case 226 -> 1079452366;
                case 227 -> -860729161;
                case 228 -> -182204127;
                case 229 -> -1158742347;
                case 230 -> 2090215869;
                case 231 -> 64468333;
                case 232 -> -1176792778;
                case 233 -> 176668528;
                case 234 -> -483569621;
                case 235 -> -917137540;
                case 236 -> -1163391960;
                case 237 -> 76516580;
                case 238 -> -982078765;
                case 239 -> -2110539825;
                case 240 -> -587076478;
                case 241 -> -1630609754;
                case 242 -> -1003166388;
                case 243 -> 61264563;
                case 244 -> 2102958910;
                case 245 -> 506718266;
                case 246 -> 479992320;
                case 247 -> 1966933584;
                case 248 -> 463966373;
                case 249 -> 1817473657;
                case 250 -> 774585204;
                case 251 -> 119824271;
                case 252 -> -1286046581;
                case 253 -> 1235537583;
                case 254 -> 1006898023;
                case 255 -> -640383236;
                default -> 592675682;
            });
        } while (v2 != 96);
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
            Ii0o = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        Ii00 = new Random();
    }

    public static Map O0i00(Map param0, boolean param1) {
        LinkedList v2 = new LinkedList(param0.entrySet());
        if (param1) {
            v2.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        } else {
            v2.sort(Map.Entry.comparingByValue());
        }
        LinkedHashMap v3 = new LinkedHashMap();
        for (Map.Entry entry : v2) {
            v3.put(entry.getKey(), (Comparable)entry.getValue());
        }
        return v3;
    }

    public static float[] O0iIO(Vec3d param0, Vec3d param1) {
        double v2 = param1.x - param0.x;
        double v4 = (param1.y - param0.y) * -1.0;
        double v6 = param1.z - param0.z;
        double v8 = Math.sqrt(v2 * v2 + v6 * v6);
        return new float[]{(float)MathHelper.wrapDegrees((double)(Math.toDegrees(Math.atan2(v6, v2)) - 90.0)), (float)MathHelper.wrapDegrees((double)Math.toDegrees(Math.atan2(v4, v8)))};
    }

    public static float O0iOI(float param0) {
        float v1 = param0 % 360.0f;
        if (v1 >= 180.0f) {
            v1 -= 360.0f;
        }
        if (v1 < -180.0f) {
            v1 += 360.0f;
        }
        return v1;
    }

    public static float O0Ii0(float param0) {
        return MathHelper.sin((double)param0);
    }

    public static double O0iO0(double param0) {
        return param0 * param0;
    }

    public static double O0iOo(double param0, int param2) {
        if (param2 < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal v3 = BigDecimal.valueOf(param0);
        v3 = v3.setScale(param2, RoundingMode.FLOOR);
        return v3.doubleValue();
    }

    public static float O0i0O(float param0, int param1) {
        if (param1 < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal v2 = BigDecimal.valueOf(param0);
        v2 = v2.setScale(param1, RoundingMode.FLOOR);
        return v2.floatValue();
    }

    public static String O0i0o() {
        Calendar v0 = Calendar.getInstance();
        int v1 = v0.get(11);
        if (v1 < 12) {
            return "Good Morning ";
        }
        if (v1 < 16) {
            return "Good Afternoon ";
        }
        if (v1 < 21) {
            return "Good Evening ";
        }
        return "Good Night ";
    }

    public static double O0i0i(double param0) {
        return param0 * 0.01745329238474369;
    }
}

