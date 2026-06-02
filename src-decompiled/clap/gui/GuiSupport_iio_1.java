/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.RenderPipelines
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.network.AbstractClientPlayerEntity
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.util.Identifier
 */
package clap.gui;

import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.Identifier;
import clap.render.RenderSupport_OIIO;
import clap.model.EnumType_OIO0;
import clap.render.FontRenderer;
import clap.model.DataRecord_OO0O;
import clap.model.DataRecord_00o0_0;
import clap.config.ConfigSupport_oii0_1;
import clap.gui.screen.ClickGuiScreen;

/*
 * Renamed from psx.Hyk.IiO
 */
final class GuiSupport_iio_1 {
    private static final float PacketEvent;
    private static final float HelpCommand;
    static Object OOo;
    private static volatile /* synthetic */ long __k__gH4it;

    void PacketEvent(DrawContext param1, ClickGuiScreen param2, int param3, int param4, float param5, float param6, float param7, float param8) {
        float v9 = param6;
        for (EnumType_OIO0 v13 : EnumType_OIO0.values()) {
            int v18;
            boolean v17;
            if (v13 == EnumType_OIO0.Iio) {
                v9 += 8.0f;
            }
            DataRecord_OO0O v14 = new DataRecord_OO0O(param5, v9, param7, 26.0f);
            boolean v15 = param2.I0o() == v13;
            boolean v16 = v14.0iI(param3, param4);
            boolean bl = v17 = v13 == EnumType_OIO0.Iio;
            int n = v15 ? RenderSupport_OIIO.O0i : (v18 = v16 ? RenderSupport_OIIO.OoO : 0);
            if (v18 != 0) {
                param2.oii().OOo(v14.0ii(), v14.oOO(), v14.FastWebModule(), v14.oOo(), 7.0f, v18);
            }
            if (v17) {
                param2.oii().OoO(v14.0ii() + 10.0f, v14.oOO() + 10.0f, 18.0f, 6.0f, v15 ? RenderSupport_OIIO.SpawnerFinderModule : 810443896, 0x28FFFFFF);
            }
            String v19 = this.OOo(v13);
            float v20 = v17 ? v14.0ii() + 36.0f : (v19 == null ? v14.0ii() + 9.0f : v14.0ii() + 29.0f);
            float v21 = v14.FastWebModule() - (v17 ? 42.0f : (v19 == null ? 28.0f : 39.0f));
            String v22 = param2.oII(v17 ? RenderSupport_OIIO.KeepSprintModule : RenderSupport_OIIO.DataRecord_0io_2, v13.WatermarkHudElement, v21);
            float v23 = v14.oOO() + (v14.oOo() - param2.oIo(v17 ? RenderSupport_OIIO.KeepSprintModule : RenderSupport_OIIO.DataRecord_0io_2)) * 0.5f - 0.5f;
            int v24 = v15 ? -722947 : (v17 ? -1429284376 : -588647425);
            param2.O0o(() -> {
                if (v19 != null) {
                    FontRenderer v10 = v13 == EnumType_OIO0.GuiSupport_III ? RenderSupport_OIIO.0iI : RenderSupport_OIIO.0io;
                    float v11 = v14.oOO() + (v14.oOo() - param2.oIo(v10)) * 0.5f - 0.5f + 3.0f;
                    float v12 = v14.0ii() + 8.0f + (v13 == EnumType_OIO0.GuiSupport_III ? -2.0f : 0.0f);
                    param2.oIO(param1, v10, v19, v12, v11, v24);
                }
                param2.oIO(param1, v17 ? RenderSupport_OIIO.KeepSprintModule : RenderSupport_OIIO.DataRecord_0io_2, v22, v20, v23, v24);
            });
            param2.IOo().add(new DataRecord_00o0_0(v13, v14));
            v9 += 31.0f;
        }
        float v10 = param6 + param8 - 54.0f;
        param2.oii().OOo(param5, v10, param7, 44.0f, 9.0f, RenderSupport_OIIO.Ooo);
        String v11 = param2.oiI();
        param2.O0o(() -> {
            this.HelpCommand(param1, param5 + 10.0f, v10 + 10.0f, 24);
            param2.oIO(param1, RenderSupport_OIIO.DataRecord_0io_2, param2.oII(RenderSupport_OIIO.DataRecord_0io_2, v11, param7 - 58.0f), param5 + 44.0f, v10 + 9.0f, ConfigSupport_oii0_1.Oo0());
        });
    }

    private String OOo(EnumType_OIO0 param1) {
        return switch (param1) {
            case EnumType_OIO0.ItemTagsModule -> "B";
            case EnumType_OIO0.ConfigSupport_II0 -> "C";
            case EnumType_OIO0.IIi -> "D";
            case EnumType_OIO0.RenderSupport_iio_5 -> "P";
            case EnumType_OIO0.GuiSupport_III -> "S";
            case EnumType_OIO0.IiO -> "M";
            default -> null;
        };
    }

    private void HelpCommand(DrawContext param1, float param2, float param3, int param4) {
        ClientPlayerEntity v52 = MinecraftClient.getInstance().player;
        if (v52 instanceof AbstractClientPlayerEntity) {
            ClientPlayerEntity v6 = v52;
            int v52 = Math.round(param2);
            int v7 = Math.round(param3);
            Identifier v8 = v6.method_52814().body().texturePath();
            param1.drawTexture(RenderPipelines.GUI_TEXTURED, v8, v52, v7, 8.0f, 8.0f, param4, param4, 8, 8, 64, 64);
            param1.drawTexture(RenderPipelines.GUI_TEXTURED, v8, v52, v7, 40.0f, 8.0f, param4, param4, 8, 8, 64, 64);
        }
    }

    GuiSupport_iio_1() {
    }

    static {
        __k__gH4it = GuiSupport_iio_1.__k__gH4it((long)3675546991254826513L);
        __rP__gH4it0 = new String[]{"\u0f71\u63db\ubdc0\ue841\u6f99\u7938\uda4e\ubea2\u0e7d\u62dd\ubcd8\ue935\u6ee7\u7822\udb64\ubfe1\u7141\u1dc7\uc38d\u9639", "\u0f72\u63c4\ubddb\ue871\u6f10"};
        __rP__gH4it1 = new String[0];
        __rP__gH4it2 = new String[]{"\u0f65\u63ca\ubdd5\ue83a\u6feb\u794d\uda31\ubebf\u0e7b\u62a0"};
        __rP__gH4it3 = new String[]{"\u0fb7\u6399\ubde0\ue8da\u6f98\u7917\uda96\ubf73\u0e6b\u6299\ubca2\ue939\u6e0c\u783e\udba0\uc03a\u71e8\u1d3e\uc37d\u9633\u119b\u0706\ua4a6\uc16f\u708e\u1c0b\uc2c1\u97d2\u108d\u0636\ua5d4\uc1f3\u73a6\u1f67\uc1f5\u9437\u13c7\u05ce\ua6a6\uc231\u7273\u1ef7\uc0e7\u9565\u12c6\u04f6\ua77e\uc344\u75d7\u19f8\uc76e\u92b8\u1563\u038c\ua05f\uc493", "\u0f67\u63c8\ubddb\ue834\u6fe9\u794f\uda37\ubeb9\u0e79\u62a2", "\u0f8c\u6332\ubdbc\ue8ca\u6fdb\u79e5\udab4\ube8e", "\u0f67\u63d1\ubdca", "\u0f77\u63d9\ubda3\ue870\u6f19\u7978\uda4a"};
        byte[] v0 = "\u00aa\u007fKLz\u0015\u00a3\u0006~g\u0011\u00b7\u00f6$\u008dW\u00e5\u00c8\u00c6\u00b5i\u0014\u0083\n\u008b\u0085B\u00acG\\\u00c9n\u009b\u00e1~A\u0005\u00ac\u00b3\u00a4Fit\u000b\u001c\u008cs\u00c9\u00fan\u00f5\u00de\u00b1\u00feZ\u0016".getBytes("ISO_8859_1");
        Object[] v1 = "\u00a3\u00aa)\u00ae\u000b\u0091\u00b7\t".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1406790686;
                case 1 -> -2047699082;
                case 2 -> -857944011;
                case 3 -> 2135885556;
                case 4 -> 1482121750;
                case 5 -> 2021720573;
                case 6 -> -2072320801;
                case 7 -> -1412098499;
                case 8 -> -1734993445;
                case 9 -> 1803437134;
                case 10 -> -1985854652;
                case 11 -> -1303477096;
                case 12 -> 766739943;
                case 13 -> -1168570492;
                case 14 -> -580220113;
                case 15 -> -633487022;
                case 16 -> 940747709;
                case 17 -> -1894178834;
                case 18 -> 331225452;
                case 19 -> -1513530604;
                case 20 -> 1921519565;
                case 21 -> -1996795638;
                case 22 -> 1282193151;
                case 23 -> 1686407337;
                case 24 -> -412872688;
                case 25 -> -107819364;
                case 26 -> -915748849;
                case 27 -> -1261823872;
                case 28 -> 1905702595;
                case 29 -> 1811912414;
                case 30 -> -1843365542;
                case 31 -> -1340015207;
                case 32 -> 1365646610;
                case 33 -> -349832166;
                case 34 -> -1344230698;
                case 35 -> 1927343754;
                case 36 -> -1205937183;
                case 37 -> -305860061;
                case 38 -> -757616681;
                case 39 -> -675234633;
                case 40 -> -222818020;
                case 41 -> -418518198;
                case 42 -> -2059530653;
                case 43 -> -1268813784;
                case 44 -> 786100902;
                case 45 -> 1094345715;
                case 46 -> -325329865;
                case 47 -> -277591807;
                case 48 -> 1113065828;
                case 49 -> 1523081485;
                case 50 -> -1431477858;
                case 51 -> 727784254;
                case 52 -> 1360165187;
                case 53 -> -272066320;
                case 54 -> -247325958;
                case 55 -> -341456703;
                case 56 -> 990642178;
                case 57 -> -331490933;
                case 58 -> -897884919;
                case 59 -> 2020258686;
                case 60 -> -641563502;
                case 61 -> -734588535;
                case 62 -> -245362307;
                case 63 -> -331121320;
                case 64 -> -608542543;
                case 65 -> -414578012;
                case 66 -> 571429909;
                case 67 -> -592811923;
                case 68 -> 2099171886;
                case 69 -> -1465479669;
                case 70 -> 1295255071;
                case 71 -> -1329062028;
                case 72 -> 387195303;
                case 73 -> 408863344;
                case 74 -> -1544060839;
                case 75 -> -1289562209;
                case 76 -> 183334648;
                case 77 -> 1459276262;
                case 78 -> -1865287032;
                case 79 -> 621476458;
                case 80 -> -1791854777;
                case 81 -> -1623521863;
                case 82 -> -1166317274;
                case 83 -> 1967837315;
                case 84 -> -1535175801;
                case 85 -> 206408019;
                case 86 -> 2032652790;
                case 87 -> 1241636881;
                case 88 -> -1677058851;
                case 89 -> -370111213;
                case 90 -> 1332107324;
                case 91 -> 1458303708;
                case 92 -> -2025480158;
                case 93 -> -918224690;
                case 94 -> 531272595;
                case 95 -> 954134652;
                case 96 -> 1842746433;
                case 97 -> 363956017;
                case 98 -> -503587067;
                case 99 -> 1951012293;
                case 100 -> 1263256206;
                case 101 -> -899188527;
                case 102 -> 1925101702;
                case 103 -> -1573641221;
                case 104 -> 1859917671;
                case 105 -> 1746972697;
                case 106 -> -532125343;
                case 107 -> 618497966;
                case 108 -> 1527691094;
                case 109 -> -1396289208;
                case 110 -> 288194874;
                case 111 -> -167333106;
                case 112 -> 1848409810;
                case 113 -> 1897773419;
                case 114 -> 759161717;
                case 115 -> 1143607859;
                case 116 -> -662910127;
                case 117 -> -1533390137;
                case 118 -> 1463380642;
                case 119 -> 1425820678;
                case 120 -> 2134885081;
                case 121 -> -1438122448;
                case 122 -> -1185125211;
                case 123 -> 696048229;
                case 124 -> 421159312;
                case 125 -> 1957381594;
                case 126 -> -333209376;
                case 127 -> -2046030523;
                case 128 -> -325873460;
                case 129 -> 380734358;
                case 130 -> 1471094308;
                case 131 -> -1768224983;
                case 132 -> 1636798125;
                case 133 -> 379381900;
                case 134 -> 1731499106;
                case 135 -> 1868389579;
                case 136 -> -307665317;
                case 137 -> 2054976887;
                case 138 -> -2053841110;
                case 139 -> 480984882;
                case 140 -> -1893711625;
                case 141 -> 763046051;
                case 142 -> -1281780534;
                case 143 -> -63010970;
                case 144 -> -183974220;
                case 145 -> 1063026863;
                case 146 -> -1350482281;
                case 147 -> 1441001156;
                case 148 -> -338627351;
                case 149 -> 1830794129;
                case 150 -> -1297516746;
                case 151 -> -312657120;
                case 152 -> -1658390673;
                case 153 -> 3609576;
                case 154 -> -1718513371;
                case 155 -> -641177969;
                case 156 -> -2143681069;
                case 157 -> 441111937;
                case 158 -> 1013078622;
                case 159 -> -878001861;
                case 160 -> 1968591320;
                case 161 -> 56328902;
                case 162 -> -153507064;
                case 163 -> 16696699;
                case 164 -> -733250752;
                case 165 -> -1467373794;
                case 166 -> 103968916;
                case 167 -> 429265412;
                case 168 -> 840901460;
                case 169 -> -1609719166;
                case 170 -> -425903388;
                case 171 -> 1695068520;
                case 172 -> 914587525;
                case 173 -> 1145277611;
                case 174 -> 677238966;
                case 175 -> -377111528;
                case 176 -> 245637415;
                case 177 -> -1453543283;
                case 178 -> 48679872;
                case 179 -> -2023168870;
                case 180 -> 1331251266;
                case 181 -> -930545166;
                case 182 -> -225210532;
                case 183 -> 867930546;
                case 184 -> 2129945573;
                case 185 -> 2105575546;
                case 186 -> -399572417;
                case 187 -> 855605950;
                case 188 -> -52515981;
                case 189 -> 964541419;
                case 190 -> -2138870983;
                case 191 -> -1593037624;
                case 192 -> -1385367175;
                case 193 -> 1178021176;
                case 194 -> -1576672785;
                case 195 -> -106477118;
                case 196 -> 819606719;
                case 197 -> 1568151224;
                case 198 -> 126297256;
                case 199 -> 51659889;
                case 200 -> -1618212515;
                case 201 -> 1272748976;
                case 202 -> 888150342;
                case 203 -> -1487042567;
                case 204 -> -774125893;
                case 205 -> 2016400369;
                case 206 -> 649099053;
                case 207 -> 1574292458;
                case 208 -> 1222082647;
                case 209 -> -97062320;
                case 210 -> -1846906293;
                case 211 -> -1551963652;
                case 212 -> 1846403095;
                case 213 -> 2090214735;
                case 214 -> -1697755394;
                case 215 -> 971432941;
                case 216 -> 1152996067;
                case 217 -> 1529932920;
                case 218 -> -1673183461;
                case 219 -> -1896288;
                case 220 -> -456828246;
                case 221 -> 1127289885;
                case 222 -> -1740964759;
                case 223 -> -241392884;
                case 224 -> 1785941358;
                case 225 -> 1492951029;
                case 226 -> -1899372087;
                case 227 -> 1692467489;
                case 228 -> 168936451;
                case 229 -> 1947477833;
                case 230 -> -1266315796;
                case 231 -> -824466756;
                case 232 -> -259230252;
                case 233 -> 240687788;
                case 234 -> -111387491;
                case 235 -> 545676415;
                case 236 -> -1378857396;
                case 237 -> -590322901;
                case 238 -> -1169678496;
                case 239 -> 444097493;
                case 240 -> 1599732231;
                case 241 -> -923711536;
                case 242 -> -997524273;
                case 243 -> 1586193964;
                case 244 -> 1577270613;
                case 245 -> -604660555;
                case 246 -> -105033067;
                case 247 -> -1320059213;
                case 248 -> 612742299;
                case 249 -> 655925760;
                case 250 -> 616434271;
                case 251 -> -171055174;
                case 252 -> -1301284787;
                case 253 -> 1694438258;
                case 254 -> -1461272780;
                case 255 -> 1317907617;
                default -> 867448168;
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
            Object[] objectArray = new Object[6];
            v1 = objectArray;
            OOo = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        HelpCommand = -2.0f;
        PacketEvent = 3.0f;
    }
}

