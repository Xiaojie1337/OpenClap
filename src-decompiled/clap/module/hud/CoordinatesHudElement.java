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
import clap.setting.Setting;
import clap.model.DataRecord_oio_3;
import clap.render.ScaledDrawContext;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class CoordinatesHudElement
extends HudElement {
    public Setting Ii0o = this.OOi00("Nether", false);
    private long EnumType_oi0i_1 = Long.MIN_VALUE;
    private static final float 00i;
    private DataRecord_oio_3 Ii0I;
    static Object Ii0i;
    private static volatile /* synthetic */ long __k__gH4it;

    private DataRecord_oio_3 O0iI0(FontRenderer param1) {
        int v10;
        int v9;
        long v2 = PostProcessingModule.IoIi();
        if (this.EnumType_oi0i_1 == v2 && this.Ii0I != null) {
            return this.Ii0I;
        }
        int v4 = CoordinatesHudElement.ConfigSupport_OI0.player.method_31477();
        int v5 = CoordinatesHudElement.ConfigSupport_OI0.player.method_31478();
        int v6 = CoordinatesHudElement.ConfigSupport_OI0.player.method_31479();
        String v7 = "X: " + v4 + " Y: " + v5 + " Z: " + v6;
        if (((Boolean)this.Ii0o.HelpCommand()).booleanValue()) {
            boolean v8 = CoordinatesHudElement.ConfigSupport_OI0.player.method_73183().getRegistryKey().getValue().getPath().equals("the_nether");
            v9 = v8 ? v4 * 8 : v4 / 8;
            v10 = v8 ? v6 * 8 : v6 / 8;
            v7 = v7 + " [" + v9 + ", " + v10 + "]";
        }
        float v8 = 0.5f * this.OIo();
        v9 = (int)this.GuiSupport_OOI();
        v10 = (int)this.OOi();
        int v11 = this.RenderSupport_oii_4(7);
        int v12 = this.RenderSupport_oii_4(5);
        int v13 = Math.round((float)param1.GuiSupport_OOI(v7) * v8);
        int v14 = Math.round((float)param1.OOi() * v8);
        this.EnumType_oi0i_1 = v2;
        this.Ii0I = new DataRecord_oio_3(v7, v8, v9, v10, v9 - v11, v10 - v12, v13 + v11 * 2, v14 + v12 * 2);
        return this.Ii0I;
    }

    @Override
    protected void O0i(ScaledDrawContext param1) {
        super.O0i(param1);
        if (CoordinatesHudElement.iooI()) {
            return;
        }
        FontRenderer v2 = NetworkSupport_00OI.OOo(20);
        DataRecord_oio_3 v3 = this.O0iI0(v2);
        PostProcessingModule.IoiO(v3.Ooo, v3.OoI, v3.Ooi, v3.KeystrokesHudElement, this.ConfigSupport_OII(8.0f), 0x60303030);
        RenderSupport_00oi_0.HudElement(() -> {
            param1.ConfigSupport_O0I().getMatrices().pushMatrix();
            param1.ConfigSupport_O0I().getMatrices().scale(param1.O0i, param1.O0i);
            v2.PacketEvent(param1.ConfigSupport_O0I(), param1.ConfigSupport_O0I, (float)param1.OoO / param1.O0i, (float)param1.Oo0 / param1.O0i, -1);
            param1.ConfigSupport_O0I().getMatrices().popMatrix();
        });
        this.Oii(v3.Ooo, v3.OoI, v3.Ooi, v3.KeystrokesHudElement);
    }

    public CoordinatesHudElement() {
        super("Coordinates", "Display coordinates", 150.0f, 20.0f);
    }

    static {
        __k__gH4it = CoordinatesHudElement.__k__gH4it(1213484364944371217L);
        __rP__gH4it0 = new String[]{"\u1445\u3f1e\ue142\ub4c7\u321f\u10ba\u81f8\ue32a\u1559\u3e18\ue05a\ub5b3\u3561\u17a0\u86d2\ue459\u1295\u3902\ue70f\ub2bf", "\u1446\u3f19\ue141\ub4d7\u3276"};
        __rP__gH4it1 = new String[0];
        __rP__gH4it2 = new String[]{"\u1451\u3f13\ue147\ub4a8\u327d\u10db\u8197\ue32b\u155f\u3e69"};
        __rP__gH4it3 = new String[]{"\u1480\u3f1f\ue00f\ub564\u3218\u1080\u81f0\ue3db\u156f\u3ed0\ue0f4\ub25f\u35bf\u1771\u8629\ue449\u1269\u39ec\ue7ce\ub3a5\u34d7\u168e\u875c\ue5ad\u13a6\u3811\ue61a\ub082\u378a\u159c\u847a\ue663\u105d\u3b78\ue521\ub136\u365f\u14b6\u8565\ue7d4\u1108\u3acd\ue485\ub176\u39b6\u1bb5\u8abf\ue80f\u1e1c\u3521\ueb58\ubef6\u38a4\u1a4e\u8bfa\ue9dc\u1fa1\u34a9\uea6b\ubf13\u3bd1\u1989\u88bc\uea5c\u1c62\u3740\ue9fa\ubc46\u3a0f\u18f5\u89e8\ueb9b\u1d37\u36b3\ue8ee\ubd67\u3a20\u1fba\u8e57\uec22\u1ae8\u3160\uef22\ubae6\u3dcf\u1ec6\u8ff8\uedf7", "\u1453\u3f11\ue141\ub4ae\u327f\u10d9\u8189\ue335\u155d\u3e6b", "\u14b2\u3fb0\ue1d4\ub480\u3260\u1071\u8173\ue344", "\u1453\u3f04\ue158", "\u1443\u3f00\ue141\ub4d2\u327f\u10de\u819c"};
        byte[] v0 = "\u00c9\f\u00d6D\f0\u0083&^\u00fb\u00d5G\u00d3\u00f9\u00a2\u00bcP\u00cf\u00e7\u00b5\u00b3\u000e\u00df@\u0087*+\u008a\u00f6\u0004\u00e1\u0086tK\u00186+&\u00f6\u00c9\u0019\u0086\u0084\u008e\u00fa]\u0014\u001a\u0005bQ\u0006\u00e0\u00aeY\u00d1\u00a0\u00f2z\u00fb\u008dq\u0007Yk\u0013\u00e3\u00a6[\u0005[\u00a6\u00c6\u00d8\u008f\u00bf\u008cr\u009c\u0017\u0011\u0003K6k\u0006;\u00da".getBytes("ISO_8859_1");
        Object[] v1 = "\u00a9\u00f5\u00dbr&\u008f\u00ceK".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 778348333;
                case 1 -> 845578291;
                case 2 -> 962579714;
                case 3 -> 0x7700CC;
                case 4 -> -156545860;
                case 5 -> -1772971254;
                case 6 -> -447558367;
                case 7 -> 1193869238;
                case 8 -> -1458000208;
                case 9 -> -1614778719;
                case 10 -> -1457896466;
                case 11 -> 749274784;
                case 12 -> 38044245;
                case 13 -> 130290277;
                case 14 -> -1623139183;
                case 15 -> 784775961;
                case 16 -> 478719689;
                case 17 -> 1497667792;
                case 18 -> -1193977821;
                case 19 -> -1053095805;
                case 20 -> -1879723957;
                case 21 -> 785898092;
                case 22 -> 739612053;
                case 23 -> 876382344;
                case 24 -> 1481650408;
                case 25 -> -1621005123;
                case 26 -> 1895100553;
                case 27 -> 14392273;
                case 28 -> 862841601;
                case 29 -> -1911339372;
                case 30 -> -845926443;
                case 31 -> 1095909509;
                case 32 -> -1324010974;
                case 33 -> 1599267493;
                case 34 -> -1016043283;
                case 35 -> 261235710;
                case 36 -> 1273206474;
                case 37 -> -487732218;
                case 38 -> -260987144;
                case 39 -> -199394712;
                case 40 -> -34232621;
                case 41 -> -1321929178;
                case 42 -> 878258088;
                case 43 -> 282958171;
                case 44 -> 1431485079;
                case 45 -> -465156254;
                case 46 -> 1587184260;
                case 47 -> 24404071;
                case 48 -> -524471000;
                case 49 -> -448778788;
                case 50 -> 0x1AA11AC;
                case 51 -> -1565268245;
                case 52 -> 1186512369;
                case 53 -> -560775254;
                case 54 -> -1434556200;
                case 55 -> -675673355;
                case 56 -> -1415752406;
                case 57 -> 1969365951;
                case 58 -> -55984995;
                case 59 -> -1696348103;
                case 60 -> -2119739217;
                case 61 -> 1679837314;
                case 62 -> -1605665862;
                case 63 -> -39422887;
                case 64 -> 341946714;
                case 65 -> -459000281;
                case 66 -> -2039906879;
                case 67 -> 1520127310;
                case 68 -> 1221127282;
                case 69 -> -1413077;
                case 70 -> 2101579796;
                case 71 -> -1158940348;
                case 72 -> 710598714;
                case 73 -> -1844299310;
                case 74 -> 137052719;
                case 75 -> 34921394;
                case 76 -> 204480119;
                case 77 -> 1508751152;
                case 78 -> -929746465;
                case 79 -> -1294178443;
                case 80 -> -1317443724;
                case 81 -> -921487397;
                case 82 -> -810009279;
                case 83 -> 1286392203;
                case 84 -> 462210143;
                case 85 -> -2081054749;
                case 86 -> -329093873;
                case 87 -> 997170913;
                case 88 -> 441652647;
                case 89 -> -446281832;
                case 90 -> 1861377285;
                case 91 -> -471759277;
                case 92 -> 2006984569;
                case 93 -> 910346080;
                case 94 -> 417300388;
                case 95 -> 1699595503;
                case 96 -> -871585306;
                case 97 -> 892695578;
                case 98 -> -1658152676;
                case 99 -> -2046799301;
                case 100 -> -1920299178;
                case 101 -> -1684563461;
                case 102 -> -1900856692;
                case 103 -> -608239826;
                case 104 -> 1516356518;
                case 105 -> 1609608708;
                case 106 -> 537267698;
                case 107 -> 1937803575;
                case 108 -> -1614011709;
                case 109 -> -327285178;
                case 110 -> 688083867;
                case 111 -> -39662490;
                case 112 -> -1891290654;
                case 113 -> 2095238986;
                case 114 -> 1895555440;
                case 115 -> 877623261;
                case 116 -> -2112679451;
                case 117 -> -2116530229;
                case 118 -> -489263811;
                case 119 -> -758064631;
                case 120 -> -455900585;
                case 121 -> -1330466191;
                case 122 -> -1414134109;
                case 123 -> -326188274;
                case 124 -> 372316708;
                case 125 -> 923724000;
                case 126 -> 515244085;
                case 127 -> -880443443;
                case 128 -> 697429619;
                case 129 -> 490886750;
                case 130 -> -790708938;
                case 131 -> 646408781;
                case 132 -> -1445833406;
                case 133 -> -328376516;
                case 134 -> -1430649004;
                case 135 -> -1984186783;
                case 136 -> -1909224507;
                case 137 -> 731778838;
                case 138 -> -1876625889;
                case 139 -> 768819719;
                case 140 -> -305180653;
                case 141 -> -1165992781;
                case 142 -> -697792145;
                case 143 -> 1318498629;
                case 144 -> 1230951598;
                case 145 -> -1142042012;
                case 146 -> -1686013587;
                case 147 -> -704702456;
                case 148 -> -1053523478;
                case 149 -> -276387554;
                case 150 -> 1930618219;
                case 151 -> 138213291;
                case 152 -> 1395491322;
                case 153 -> -1818590621;
                case 154 -> -49881600;
                case 155 -> -853060964;
                case 156 -> 1935213632;
                case 157 -> 1078416669;
                case 158 -> 1117452540;
                case 159 -> 1724323734;
                case 160 -> 2002824242;
                case 161 -> 1981373124;
                case 162 -> 130440386;
                case 163 -> 1766928428;
                case 164 -> 1906222465;
                case 165 -> -1377903398;
                case 166 -> 734662493;
                case 167 -> -786175491;
                case 168 -> 579028726;
                case 169 -> -1324393164;
                case 170 -> 1133731377;
                case 171 -> 897748329;
                case 172 -> -1900722420;
                case 173 -> -2108332983;
                case 174 -> -2036094764;
                case 175 -> -1928045945;
                case 176 -> -613096306;
                case 177 -> -2000756910;
                case 178 -> 581956119;
                case 179 -> 1641691835;
                case 180 -> 846956959;
                case 181 -> 1846544716;
                case 182 -> -161609792;
                case 183 -> -274672829;
                case 184 -> 1343671280;
                case 185 -> -571402371;
                case 186 -> 1739326391;
                case 187 -> -1607800193;
                case 188 -> -891892712;
                case 189 -> 1081032150;
                case 190 -> -1846896816;
                case 191 -> -173399024;
                case 192 -> 957702291;
                case 193 -> -1697791289;
                case 194 -> -520003474;
                case 195 -> -455433400;
                case 196 -> -954433833;
                case 197 -> -299094072;
                case 198 -> -1892148002;
                case 199 -> 913835960;
                case 200 -> 503831268;
                case 201 -> -263005685;
                case 202 -> -2026464366;
                case 203 -> -100085757;
                case 204 -> 1088862249;
                case 205 -> -1740157377;
                case 206 -> 1083750223;
                case 207 -> -1134087865;
                case 208 -> 811616593;
                case 209 -> 845044985;
                case 210 -> 429043804;
                case 211 -> -784543877;
                case 212 -> 913190543;
                case 213 -> 244961312;
                case 214 -> -151668955;
                case 215 -> -233246344;
                case 216 -> 149286313;
                case 217 -> 746329754;
                case 218 -> 212566982;
                case 219 -> 102704375;
                case 220 -> -473731084;
                case 221 -> -648261867;
                case 222 -> 1186676090;
                case 223 -> 2093375897;
                case 224 -> 280223104;
                case 225 -> 501847246;
                case 226 -> -44488985;
                case 227 -> 318712041;
                case 228 -> 1501654840;
                case 229 -> 758414335;
                case 230 -> 1084599725;
                case 231 -> -1902565703;
                case 232 -> -1007289200;
                case 233 -> 662834814;
                case 234 -> -505940206;
                case 235 -> 1311201438;
                case 236 -> -388797965;
                case 237 -> 1302056810;
                case 238 -> 1792733713;
                case 239 -> -164904030;
                case 240 -> -908181442;
                case 241 -> -628854952;
                case 242 -> -500987185;
                case 243 -> -448647818;
                case 244 -> 1575488949;
                case 245 -> -911121730;
                case 246 -> -1443262543;
                case 247 -> -225216551;
                case 248 -> 311183899;
                case 249 -> -1016763780;
                case 250 -> 399794822;
                case 251 -> -1303281782;
                case 252 -> 1261174029;
                case 253 -> -1345797235;
                case 254 -> -720928020;
                case 255 -> -1651135308;
                default -> -924759395;
            });
        } while (v2 != 88);
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
            Ii0i = objectArray;
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
        if (CoordinatesHudElement.iooI()) {
            return;
        }
        FontRenderer v2 = NetworkSupport_00OI.OOo(20);
        DataRecord_oio_3 v3 = this.O0iI0(v2);
        PostProcessingModule.Ioio(v3.Ooo, v3.OoI, v3.Ooi, v3.KeystrokesHudElement, this.ConfigSupport_OII(8.0f));
    }
}

