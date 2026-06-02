/*
 * Decompiled with CFR 0.152.
 */
package clap.module.hud;

import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import clap.network.NetworkSupport_00OI;
import clap.gui.hud.HudElement;
import clap.render.FontRenderer;
import clap.module.render.PostProcessingModule;
import clap.render.RenderSupport_00oi_0;
import clap.gui.GuiSupport_0oo_2;
import clap.render.ScaledDrawContext;
import clap.model.DataRecord_ooi_2;

/*
 * Renamed from psx.Hyk.0Oo
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class FpsHudElement
extends HudElement {
    private float ooi;
    private float oIO;
    private DataRecord_ooi_2 ooo;
    private static final float 00i;
    private float ConfigSupport_oi0_2;
    private int ooI = Integer.MIN_VALUE;
    static Object oIo;
    private static volatile /* synthetic */ long __k__gH4it;

    private DataRecord_ooi_2 Ioi(FontRenderer param1) {
        int v2 = ConfigSupport_OI0.getCurrentFps();
        float v3 = this.OIo();
        float v4 = this.GuiSupport_OOI();
        float v5 = this.OOi();
        if (this.ooo != null && this.ooI == v2 && this.ooi == v3 && this.oIO == v4 && this.ConfigSupport_oi0_2 == v5) {
            return this.ooo;
        }
        String v6 = "FPS: " + v2;
        float v7 = 0.5f * v3;
        int v8 = (int)v4;
        int v9 = (int)v5;
        int v10 = this.RenderSupport_oii_4(7);
        int v11 = this.RenderSupport_oii_4(5);
        int v12 = Math.round((float)param1.GuiSupport_OOI(v6) * v7);
        int v13 = Math.round((float)param1.OOi() * v7);
        this.ooI = v2;
        this.ooi = v3;
        this.oIO = v4;
        this.ConfigSupport_oi0_2 = v5;
        this.ooo = new DataRecord_ooi_2(v6, v7, v8, v9, v8 - v10, v9 - v11, v12 + v10 * 2, v13 + v11 * 2);
        return this.ooo;
    }

    @Override
    protected void O0i(ScaledDrawContext param1) {
        super.O0i(param1);
        FontRenderer v2 = NetworkSupport_00OI.OOo(20);
        DataRecord_ooi_2 v3 = this.Ioi(v2);
        PostProcessingModule.IoiO(v3.Ooo, v3.OoI, v3.Ooi, v3.KeystrokesHudElement, this.ConfigSupport_OII(8.0f), 0x60303030);
        RenderSupport_00oi_0.HudElement(() -> {
            param1.ConfigSupport_O0I().getMatrices().pushMatrix();
            param1.ConfigSupport_O0I().getMatrices().scale(param1.O0i, param1.O0i);
            v2.PacketEvent(param1.ConfigSupport_O0I(), param1.ConfigSupport_O0I, (float)param1.OoO / param1.O0i, (float)param1.Oo0 / param1.O0i, -1);
            param1.ConfigSupport_O0I().getMatrices().popMatrix();
        });
        this.Oii(v3.Ooo, v3.OoI, v3.Ooi, v3.KeystrokesHudElement);
    }

    public FpsHudElement() {
        super("FPS", "Display FPS", 150.0f, 40.0f);
        this.ooi = Float.NaN;
        this.oIO = Float.NaN;
        this.ConfigSupport_oi0_2 = Float.NaN;
    }

    static {
        __k__gH4it = FpsHudElement.__k__gH4it(8201964375414664721L);
        __rP__gH4it0 = new String[]{"\uc044\u2967\uf783\ua22b\u25a8\u7ddb\ub39f\uf415\uc0f8\u2843\uf6f8\ua3a1\u2493\u7c6e\ub2d1\uf507\uc13b\u2b19\uf532\ua0e1\u2736\u7fbc\ub1e2\uf6aa\uc202\u2aff\uf497\ua1e3\u26f9\u7efd\ub0dd\uf7d3\uc340\u25a7\ufb76\uaeb6\u295e\u7167\ubfc7\uf8f6\ucc03\u25a8\ufa2d\uafee\u28c8\u705a\ube66\uf9c8\ucd07\u24fa\uf927\uac22\u2b70\u730f\ubd14\ufae8"};
        __rP__gH4it1 = new String[]{"\uc0ef\u293c\uf7e0\ua2b4\u25d7"};
        __rP__gH4it2 = new String[]{"\uc0fa\u2934\uf7e0\ua2cd\u25de\u7d26\ub352\uf573\uc1f4\u284e", "\uc063\u2925\uf751\ua267\u25e2\u7dc0\ub3c3\uf5ac", "\uc0f8\u2932\uf7e6\ua2cf\u25dc\u7d38\ub34c\uf571\uc1f6\u2848", "\uc0fa\u2929\uf7f9", "\uc0ea\u2921\uf7e0\ua2b5\u25de\u7d3d\ub347"};
        __rP__gH4it3 = new String[]{"\uc0ec\u293f\uf7e3\ua2a0\u25be\u7d59\ub323\uf560\uc1f0\u2839\uf6fb\ua3d4\u24c0\u7c43\ub209\uf623\uc2fc\u2b63\uf5ee\ua018"};
        byte[] v0 = "\u00c4u\u001bL}\u00a8\u00d7\u00b2\u0080i\u0018\u00fe\u00be%\u00e1\u0098K;\u00da\u00b6\u0013\u00ff\u00da=j\u00c5g\u00ac\u00c4\u00a6\u00fd\\ \u0095\u008e\u00f1k4\u00efq[b\u00ed\u00d1\u00c5\u00f1v7W8\u00ef\u0015u\u00ac\f\u001f".getBytes("ISO_8859_1");
        Object[] v1 = "\u00d1E\u00ff\u00f6\u0005\u00c1\u00a5\u00e5".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -990907880;
                case 1 -> -365792961;
                case 2 -> 1926860100;
                case 3 -> -2085221922;
                case 4 -> -616276236;
                case 5 -> -749061697;
                case 6 -> 401923213;
                case 7 -> 596861695;
                case 8 -> -1339898590;
                case 9 -> 2111872832;
                case 10 -> 261002209;
                case 11 -> 549293095;
                case 12 -> -1265530493;
                case 13 -> -1628093754;
                case 14 -> -1303598648;
                case 15 -> -1363979101;
                case 16 -> -529753410;
                case 17 -> 1149560357;
                case 18 -> 2028176633;
                case 19 -> -173305287;
                case 20 -> 27423961;
                case 21 -> -573699245;
                case 22 -> -1785633699;
                case 23 -> -2033658616;
                case 24 -> -983991394;
                case 25 -> -1498630910;
                case 26 -> -645101561;
                case 27 -> 226228457;
                case 28 -> 454969444;
                case 29 -> 1484023700;
                case 30 -> 1502135604;
                case 31 -> 778980944;
                case 32 -> 456179610;
                case 33 -> -1424251126;
                case 34 -> 93359977;
                case 35 -> -1632485346;
                case 36 -> -1274087916;
                case 37 -> 65828230;
                case 38 -> -608662808;
                case 39 -> 813926219;
                case 40 -> -1648733722;
                case 41 -> 1344376110;
                case 42 -> -235650676;
                case 43 -> -1144101621;
                case 44 -> -1943773089;
                case 45 -> 571502865;
                case 46 -> 1824885564;
                case 47 -> -364412560;
                case 48 -> 1257653772;
                case 49 -> -1560511350;
                case 50 -> -1377323429;
                case 51 -> 1867793734;
                case 52 -> 1556012314;
                case 53 -> 984583590;
                case 54 -> -491611901;
                case 55 -> -1650594730;
                case 56 -> 1136706190;
                case 57 -> 616101985;
                case 58 -> 1560347087;
                case 59 -> -1926784623;
                case 60 -> -1269103149;
                case 61 -> -1040457504;
                case 62 -> 1042888128;
                case 63 -> -1352522155;
                case 64 -> 1570517246;
                case 65 -> -935190033;
                case 66 -> 1498253087;
                case 67 -> 960397560;
                case 68 -> -1925656067;
                case 69 -> -2129043035;
                case 70 -> 1815482591;
                case 71 -> -806761988;
                case 72 -> -434386265;
                case 73 -> -644611707;
                case 74 -> -213635123;
                case 75 -> 1642893877;
                case 76 -> 1834485924;
                case 77 -> -572525051;
                case 78 -> -1323082924;
                case 79 -> -1374105312;
                case 80 -> -307729349;
                case 81 -> 1782699642;
                case 82 -> 1021467036;
                case 83 -> 843615766;
                case 84 -> -953942455;
                case 85 -> -282948687;
                case 86 -> 1952116905;
                case 87 -> -1079425279;
                case 88 -> -1399210670;
                case 89 -> 1942126776;
                case 90 -> -327308734;
                case 91 -> -814837488;
                case 92 -> 594059790;
                case 93 -> -485669551;
                case 94 -> 2021277549;
                case 95 -> -1685552286;
                case 96 -> 987604371;
                case 97 -> -1137381590;
                case 98 -> -1424709855;
                case 99 -> -1985946386;
                case 100 -> 1449844617;
                case 101 -> -1653818894;
                case 102 -> 100798558;
                case 103 -> 1567358692;
                case 104 -> -542632756;
                case 105 -> -1366381937;
                case 106 -> 287841073;
                case 107 -> 143208261;
                case 108 -> -1556199818;
                case 109 -> -1678754153;
                case 110 -> 843848951;
                case 111 -> -1946176697;
                case 112 -> -1276832457;
                case 113 -> -1016699755;
                case 114 -> 744970276;
                case 115 -> -534989849;
                case 116 -> 967970931;
                case 117 -> 515458424;
                case 118 -> 934308025;
                case 119 -> 89132160;
                case 120 -> 795294594;
                case 121 -> -875782023;
                case 122 -> -1481032173;
                case 123 -> 1776578187;
                case 124 -> -328241831;
                case 125 -> 1271514444;
                case 126 -> -956007292;
                case 127 -> -2024708504;
                case 128 -> 2114736702;
                case 129 -> 1810129836;
                case 130 -> -1771301659;
                case 131 -> -1263776316;
                case 132 -> 1445142607;
                case 133 -> -2078032534;
                case 134 -> 1440637874;
                case 135 -> -2069422211;
                case 136 -> 659711615;
                case 137 -> 1462631987;
                case 138 -> 1922447467;
                case 139 -> -623197965;
                case 140 -> -439587157;
                case 141 -> 1772862418;
                case 142 -> -1337621942;
                case 143 -> 403454361;
                case 144 -> -1474879889;
                case 145 -> 1823857878;
                case 146 -> 368153391;
                case 147 -> 368238762;
                case 148 -> 1938513412;
                case 149 -> 622885677;
                case 150 -> 2142974529;
                case 151 -> 318736427;
                case 152 -> 461069603;
                case 153 -> -1516671569;
                case 154 -> 1404823542;
                case 155 -> 1946363060;
                case 156 -> 277366654;
                case 157 -> 1404670748;
                case 158 -> 214252550;
                case 159 -> 1452635342;
                case 160 -> -182108972;
                case 161 -> -460057099;
                case 162 -> 1634068938;
                case 163 -> 704819238;
                case 164 -> -1110529230;
                case 165 -> -1539363047;
                case 166 -> 996415063;
                case 167 -> -544126565;
                case 168 -> 475680304;
                case 169 -> 428225717;
                case 170 -> 1796943291;
                case 171 -> 475998729;
                case 172 -> -1758106211;
                case 173 -> -1817386864;
                case 174 -> -1507920201;
                case 175 -> 824711619;
                case 176 -> 1823226280;
                case 177 -> -668452961;
                case 178 -> -2006131206;
                case 179 -> 1564287448;
                case 180 -> -928102034;
                case 181 -> -374246463;
                case 182 -> -963660347;
                case 183 -> 336537719;
                case 184 -> -1104045162;
                case 185 -> 1968948085;
                case 186 -> -995539128;
                case 187 -> 237833201;
                case 188 -> 1435935722;
                case 189 -> -1919031861;
                case 190 -> 1301840739;
                case 191 -> -239602670;
                case 192 -> 478495105;
                case 193 -> -87236262;
                case 194 -> 363475885;
                case 195 -> 1230423409;
                case 196 -> 1390652113;
                case 197 -> 211114453;
                case 198 -> 682453152;
                case 199 -> 1843117339;
                case 200 -> -1056592710;
                case 201 -> -992655319;
                case 202 -> -349956762;
                case 203 -> 1952298240;
                case 204 -> -1237073331;
                case 205 -> -1307564490;
                case 206 -> 886805874;
                case 207 -> 1119398979;
                case 208 -> -1173427221;
                case 209 -> 1792258872;
                case 210 -> 2009071549;
                case 211 -> -1518376100;
                case 212 -> 1167017197;
                case 213 -> 1677981717;
                case 214 -> 1266191330;
                case 215 -> -828211185;
                case 216 -> -433537354;
                case 217 -> -1503051924;
                case 218 -> -192253362;
                case 219 -> -1850810777;
                case 220 -> -2094887685;
                case 221 -> -1941768240;
                case 222 -> 664995778;
                case 223 -> 868798999;
                case 224 -> 258150050;
                case 225 -> 1246684652;
                case 226 -> -427756343;
                case 227 -> -793890547;
                case 228 -> -1392813211;
                case 229 -> 954467707;
                case 230 -> -1627402834;
                case 231 -> 1700061016;
                case 232 -> -2141539108;
                case 233 -> -38470457;
                case 234 -> -582451533;
                case 235 -> 577310872;
                case 236 -> 95649580;
                case 237 -> 1170606888;
                case 238 -> -883150371;
                case 239 -> -12521100;
                case 240 -> 1637912035;
                case 241 -> 1566494781;
                case 242 -> 961983706;
                case 243 -> -955149166;
                case 244 -> -1481451536;
                case 245 -> -780117840;
                case 246 -> 237011361;
                case 247 -> 1351305404;
                case 248 -> -1954749048;
                case 249 -> 1475101469;
                case 250 -> 1192751456;
                case 251 -> -373179012;
                case 252 -> 338861703;
                case 253 -> 2018641722;
                case 254 -> 1237071323;
                case 255 -> -1851351337;
                default -> 1028204877;
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
            oIo = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        00i = 0.5f;
    }

    @Override
    protected void OoO(GuiSupport_0oo_2 param1) {
        FontRenderer v2 = NetworkSupport_00OI.OOo(20);
        DataRecord_ooi_2 v3 = this.Ioi(v2);
        PostProcessingModule.Ioio(v3.Ooo, v3.OoI, v3.Ooi, v3.KeystrokesHudElement, this.ConfigSupport_OII(8.0f));
    }
}

