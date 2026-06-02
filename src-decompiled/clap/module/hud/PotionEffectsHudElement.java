/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gl.RenderPipelines
 *  net.minecraft.client.gui.hud.InGameHud
 *  net.minecraft.entity.effect.StatusEffect
 *  net.minecraft.entity.effect.StatusEffectInstance
 *  net.minecraft.entity.effect.StatusEffectUtil
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.text.Text
 */
package clap.module.hud;

import java.awt.Color;
import java.security.Key;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectUtil;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import clap.gui.screen.HudEditorScreen;
import clap.network.NetworkSupport_00OI;
import clap.gui.hud.HudElement;
import clap.render.FontRenderer;
import clap.module.render.PostProcessingModule;
import clap.render.RenderSupport_00oi_0;
import clap.gui.GuiSupport_0oo_2;
import clap.setting.Setting;
import clap.model.DataRecord_o0i_0;
import clap.model.DataRecord_oi0o_1;
import clap.render.ScaledDrawContext;

/*
 * Renamed from psx.Hyk.iIi
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class PotionEffectsHudElement
extends HudElement {
    private static final int 0IOO;
    private long EnumType_oi0i_1;
    private static final int 0oiI;
    private static final int 0oi0;
    public Setting 0oi;
    private static final int 0oio;
    public Setting 0oI;
    private static final float 00i;
    public Setting 0IOI = this.OOi00("Icons", true);
    private final List 0IOi;
    private static final int 0IOo;
    private static final int 0oii;
    private DataRecord_oi0o_1 0I0O;
    private static final int 0IO0;
    static Object 0I00;
    private static volatile /* synthetic */ long __k__gH4it;

    private String IO0I(int param1) {
        int v2 = param1 + 1;
        return switch (v2) {
            case 2 -> "II";
            case 3 -> "GuiSupport_III";
            case 4 -> "IV";
            case 5 -> "V";
            case 6 -> "VI";
            case 7 -> "VII";
            case 8 -> "VIII";
            case 9 -> "IX";
            case 10 -> "X";
            default -> Text.translatable((String)("enchantment.level." + v2)).getString();
        };
    }

    private List IO0O() {
        long v1 = PostProcessingModule.IoIi();
        if (this.EnumType_oi0i_1 == v1) {
            return this.0IOi;
        }
        this.EnumType_oi0i_1 = v1;
        this.0I0O = null;
        this.0IOi.clear();
        if (PotionEffectsHudElement.ConfigSupport_OI0.player == null) {
            return this.0IOi;
        }
        PotionEffectsHudElement.ConfigSupport_OI0.player.method_6026().stream().filter(StatusEffectInstance::shouldShowParticles).sorted(Comparator.comparing(param0 -> ((StatusEffect)param0.getEffectType().value()).getName().getString())).forEach(param1 -> this.0IOi.add(this.IO0o((StatusEffectInstance)param1)));
        return this.0IOi;
    }

    public PotionEffectsHudElement() {
        super("PotionEffects", "Display active potion effects", 130.0f, 28.0f);
        this.0oI = this.OOi0o("Radius", 8, 0, 18);
        this.0oi = this.OOioo("BackgroundColor", 48, 48, 48, 96);
        this.0IOi = new ArrayList();
        this.EnumType_oi0i_1 = Long.MIN_VALUE;
    }

    @Override
    protected void OoO(GuiSupport_0oo_2 param1) {
        if (PotionEffectsHudElement.iooI()) {
            return;
        }
        List v2 = this.IO0O();
        if (v2.isEmpty() && !(PotionEffectsHudElement.ConfigSupport_OI0.currentScreen instanceof HudEditorScreen)) {
            return;
        }
        DataRecord_oi0o_1 v3 = this.IO00(NetworkSupport_00OI.OOo(20), v2);
        PostProcessingModule.Ioio(v3.RenderSupport_ooo_0, v3.oo0, v3.ooo, v3.ooI, this.RenderSupport_oii_4((Integer)this.0oI.HelpCommand()));
    }

    private DataRecord_o0i_0 IO0o(StatusEffectInstance param1) {
        Object v2 = ((StatusEffect)param1.getEffectType().value()).getName().getString();
        if (param1.getAmplifier() > 0) {
            v2 = (String)v2 + " " + this.IO0I(param1.getAmplifier());
        }
        String v3 = StatusEffectUtil.getDurationText((StatusEffectInstance)param1, (float)1.0f, (float)(PotionEffectsHudElement.ConfigSupport_OI0.world == null ? 20.0f : PotionEffectsHudElement.ConfigSupport_OI0.world.method_54719().getTickRate())).getString();
        int v4 = 0xFF000000 | ((StatusEffect)param1.getEffectType().value()).getColor();
        return new DataRecord_o0i_0(param1, (String)v2, v3, v4);
    }

    private DataRecord_oi0o_1 IO0i(FontRenderer param1, List param2) {
        int v7;
        int v9;
        float v3 = 0.5f * this.OIo();
        int v4 = Math.round((float)param1.GuiSupport_OOI("No Effects") * v3);
        int v5 = Math.max(1, param2.size());
        ArrayList<DataRecord_o0i_0> v6 = new ArrayList<DataRecord_o0i_0>();
        for (DataRecord_o0i_0 v8 : param2) {
            v9 = Math.round((float)param1.GuiSupport_OOI(v8.HelpCommand()) * v3);
            int v10 = Math.round((float)param1.GuiSupport_OOI(v8.OOo()) * v3);
            v8 = new DataRecord_o0i_0(v8.PacketEvent(), v8.HelpCommand(), v8.OOo(), v8.GuiSupport_OOI(), v9, v10);
            v6.add(v8);
            v4 = Math.max(v4, v9 + this.RenderSupport_oii_4(4) + v10);
        }
        for (v7 = 0; v7 < v6.size(); ++v7) {
            param2.set(v7, (DataRecord_o0i_0)v6.get(v7));
        }
        v7 = (Boolean)this.0IOI.HelpCommand() != false && !param2.isEmpty() ? this.RenderSupport_oii_4(17) : 0;
        int v8 = v4 + v7 + this.RenderSupport_oii_4(6) * 2;
        v9 = v5 * this.RenderSupport_oii_4(15) + this.RenderSupport_oii_4(3) * 2;
        return new DataRecord_oi0o_1((int)this.GuiSupport_OOI() - this.RenderSupport_oii_4(6), (int)this.OOi() - this.RenderSupport_oii_4(3), v8, v9);
    }

    static {
        __k__gH4it = PotionEffectsHudElement.__k__gH4it(-3210316505233232367L);
        __rP__gH4it0 = new String[]{"\ufa00\u5749\u884a\udda1\u5aea\u0082\ueef3\u8c74\ufdca\u50c5\u8f97\uda21\u5da5\u0730\ue995\u8c3e\ufc5e\u51a7\u8e2a\udbda\u5c0d\u06de\ue8be\u8d7f\uff52\u524c\u8dec\ud820\u5f07\u056e\uebbe\u8ebc\ufeb5\u5311\u8c3d\ud953\u5e26\u0463\uea66\u8f28\ue175\u4ccf\u93f6\uc673\u4104\u1b9a\uf5d0\u90ed\ue183\u4d64\u92c9\uc769\u40ca\u1a95\uf4a3\u9149\ue035\u4e8b\u915c\uc42d\u43f9\u192d\uf749\u9260\ue3d2\u4f34\u9092\uc569\u42af\u1844\uf66d\u9367\ue220\u48c0\u9796\uc218\u459e\u1f9f\uf1be\u9412\ue5cb\u48d6\u9672\uc33b\u44d1\u1e9d\uf06e\u95f1\ue4d4\u49b2\u95b2\uc097\u47d9\u1dbb\uf35c\u9689\ue7ad\u4abe\u941b\uc1c1\u4602\u1ce2\uf2c1\u97a3\ue613\u4ba3\u9b2a\uced5\u49a0\u1366\ufd4e\u9875\ue9b2\u4425\u9bf7\ucf3e\u489a\u12a2\ufcc6\u9910\ue811\u452a\u9a32\ucc79\u4bfe\u1182\uff16\u9aca\ueb1d\u4642\u99fb\ucde4\u4a11\u1007\ufe10\u9bf7\uea08\u47f7\u98a8\ucd1f\u4d3a\u1703\uf9b0\u9c81\uedbb\u4005\u9fda\ucab3\u4c83\u16e0\uf8de\u9d2f\uec90\u4188\u9ef3\ucb74\u4f82\u153f\ufbbf\u9eb9\uefbd\u4252\u9d32\uc8db\u4e59\u140d\ufa35\u9f22", "\ufa12\u5785\u885f\uddc3\u5d1b\u07be\ue984\u8c21\ufd1e\u5093\u8f57\udab7\u5c65\u06a4\ue8ae\u8d62\ufc22\u51b9\u8e72\udbbb", "\ufa04\u5797\u884d"};
        __rP__gH4it1 = new String[0];
        __rP__gH4it2 = new String[]{"\ufa04\u578a\u8854\uddba\u5d6b\u07cd\ue9fd\u8c3e\ufd1a\u50e0", "\ufa54\u57b4\u8872\uddd4\u5d5f\u07cd\ue9df\u8c1b"};
        __rP__gH4it3 = new String[]{"\ufa06\u5788\u885a\uddb4\u5d69\u07cf\ue9fb\u8c38\ufd18\u50e2", "\ufa14\u579b\u885c\uddce\u5a9b\u07fa\ue980", "\ufa11\u57ba\u8824\uddf3\u5a92"};
        byte[] v0 = "\u00eeq\u00fe%\u001a\u0096\u009c\u0012,\u00f5+]m\\\u00c2\u00a0\u0080\u00ef\u00ae\u00ae\u00cd\u00ba\u00e1\u00e9\u0084\f`L\u00df\u0012\u00f92{I\u00a97\u00f6\u0017)\u00ae\u00b3\u009fj/,\u00d6\u00e7S\u00bd\f-=\u00ea\u00d1\u009c\u00ff\u0003\u00eb\u00b0a\u00c1qn\u00ce\u00fcLf-\u009f\u0010B\u00c1\u0006\u00b0j$\u00963\u00a9\u00cc\u00d5^\u00b6\u000f\u00d19q'\u00c22~\u00bb\u00c1\u0007[G\u00a3&\u00cf\u00e5\u0012V\u00cee\u00153\u00f6\u00c9\u00c8\u00ea\u00b9\u008b\u00cc\u008d\u00d3*\u00fa&9\u00e6g\u008a\u001eu\u0086\u001e\u00f1$s\u00fa\u00cf\u00e0a\u0093\u00ff\u0011nG\u0094\u00e3r\u00efg\u009f\u00e5\u00cd\u00deG\u00c3\u0004\u00019\u00c6H\u00ff\u0098\u00da\u00c3x\u00b7\u00f3\u008a&?\t\u00f9\u00fa$".getBytes("ISO_8859_1");
        Object[] v1 = "\u0018bh2\r?\u0016\u001f".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 207677735;
                case 1 -> 1915868741;
                case 2 -> 499084380;
                case 3 -> -1264319831;
                case 4 -> 366959602;
                case 5 -> -592470263;
                case 6 -> -1401448255;
                case 7 -> -1161577854;
                case 8 -> 233623017;
                case 9 -> -1908329318;
                case 10 -> 1725663513;
                case 11 -> -1558450611;
                case 12 -> 1552651045;
                case 13 -> 129139076;
                case 14 -> -912059857;
                case 15 -> 126410648;
                case 16 -> 982651146;
                case 17 -> 870267663;
                case 18 -> -1562040312;
                case 19 -> 1497203365;
                case 20 -> -1983033717;
                case 21 -> 1091855771;
                case 22 -> 1471617350;
                case 23 -> 1886091571;
                case 24 -> 484093340;
                case 25 -> 1073578868;
                case 26 -> -85196478;
                case 27 -> -1896246539;
                case 28 -> -1612179932;
                case 29 -> 1025706361;
                case 30 -> -1152610595;
                case 31 -> -849701488;
                case 32 -> 748440978;
                case 33 -> 1548019513;
                case 34 -> -291812779;
                case 35 -> -612549794;
                case 36 -> -1017164513;
                case 37 -> 641021944;
                case 38 -> 1228537456;
                case 39 -> -236349034;
                case 40 -> 1968489645;
                case 41 -> -1752929048;
                case 42 -> 1552473445;
                case 43 -> -5280974;
                case 44 -> 1792617408;
                case 45 -> 26317408;
                case 46 -> -127888269;
                case 47 -> -2079593434;
                case 48 -> 880019200;
                case 49 -> -1113165285;
                case 50 -> -2104202091;
                case 51 -> -35307992;
                case 52 -> -298302468;
                case 53 -> 1676719312;
                case 54 -> 1115296690;
                case 55 -> -1968930784;
                case 56 -> -910834255;
                case 57 -> 1537622943;
                case 58 -> 1112065358;
                case 59 -> -1059641739;
                case 60 -> 254647710;
                case 61 -> 1874108521;
                case 62 -> 217703201;
                case 63 -> 1284710760;
                case 64 -> -1242791456;
                case 65 -> -1321213612;
                case 66 -> -1049547871;
                case 67 -> -1960777188;
                case 68 -> 1539661453;
                case 69 -> -2144371463;
                case 70 -> -1017958671;
                case 71 -> -1003907567;
                case 72 -> -824162727;
                case 73 -> -1890307541;
                case 74 -> -1823166009;
                case 75 -> -2015991488;
                case 76 -> 430964439;
                case 77 -> 915645200;
                case 78 -> -466220214;
                case 79 -> -1103979965;
                case 80 -> 1092806534;
                case 81 -> 1195078789;
                case 82 -> -213272070;
                case 83 -> -1678295323;
                case 84 -> -1085663613;
                case 85 -> -697892434;
                case 86 -> 597015663;
                case 87 -> -1225484624;
                case 88 -> 1929105200;
                case 89 -> 1551894169;
                case 90 -> 1033073377;
                case 91 -> 130753278;
                case 92 -> -576408317;
                case 93 -> 9683982;
                case 94 -> -343278441;
                case 95 -> -1428538589;
                case 96 -> 1573741149;
                case 97 -> -1615103035;
                case 98 -> -1078235626;
                case 99 -> 2121345645;
                case 100 -> -988789340;
                case 101 -> -445622571;
                case 102 -> 1985828202;
                case 103 -> 1537925094;
                case 104 -> 2106977234;
                case 105 -> -1232075730;
                case 106 -> 769214648;
                case 107 -> 422302690;
                case 108 -> 468454782;
                case 109 -> -145181849;
                case 110 -> -195389790;
                case 111 -> -25382045;
                case 112 -> 141435215;
                case 113 -> -638049283;
                case 114 -> -2038803234;
                case 115 -> -214705557;
                case 116 -> 364654878;
                case 117 -> 11730808;
                case 118 -> 808142576;
                case 119 -> -506805313;
                case 120 -> -1171835482;
                case 121 -> -1050233399;
                case 122 -> -216306635;
                case 123 -> 1243342946;
                case 124 -> -154645158;
                case 125 -> 1098480590;
                case 126 -> -321308281;
                case 127 -> 1582877189;
                case 128 -> 577401531;
                case 129 -> 1181828598;
                case 130 -> 1063697197;
                case 131 -> -1240528014;
                case 132 -> 381984442;
                case 133 -> -509361825;
                case 134 -> -926603433;
                case 135 -> 1355732566;
                case 136 -> 234646802;
                case 137 -> 1241429505;
                case 138 -> -710432843;
                case 139 -> 1819542483;
                case 140 -> -1555579841;
                case 141 -> -1760996984;
                case 142 -> -920365142;
                case 143 -> 1832302145;
                case 144 -> 1443220156;
                case 145 -> -919324853;
                case 146 -> -886651719;
                case 147 -> -2034279811;
                case 148 -> -116465684;
                case 149 -> -694717692;
                case 150 -> -774413278;
                case 151 -> -121290396;
                case 152 -> 444826859;
                case 153 -> -577074289;
                case 154 -> 1801444244;
                case 155 -> -159494188;
                case 156 -> -1991066826;
                case 157 -> 1240752589;
                case 158 -> 900465115;
                case 159 -> -644257988;
                case 160 -> 792779003;
                case 161 -> -1724539336;
                case 162 -> -582747714;
                case 163 -> 652513880;
                case 164 -> -424745350;
                case 165 -> -1947611980;
                case 166 -> 995874612;
                case 167 -> 2002457048;
                case 168 -> 1291627831;
                case 169 -> 1284009242;
                case 170 -> -235300550;
                case 171 -> 1265028164;
                case 172 -> -1017261997;
                case 173 -> 1597023047;
                case 174 -> -338004116;
                case 175 -> -1696344210;
                case 176 -> 1788647547;
                case 177 -> -910214356;
                case 178 -> -389229074;
                case 179 -> 36437476;
                case 180 -> 1623937409;
                case 181 -> -1401407821;
                case 182 -> -1094431220;
                case 183 -> 1448838088;
                case 184 -> 2089774385;
                case 185 -> -1518724419;
                case 186 -> -129913673;
                case 187 -> 1080009329;
                case 188 -> 784316843;
                case 189 -> -1782405812;
                case 190 -> -1040139439;
                case 191 -> 41050051;
                case 192 -> -1161732566;
                case 193 -> 1257356771;
                case 194 -> -1199941886;
                case 195 -> 1974384075;
                case 196 -> 514162604;
                case 197 -> -697263093;
                case 198 -> -1444339242;
                case 199 -> -2002560268;
                case 200 -> 2009312375;
                case 201 -> -160389935;
                case 202 -> 526625874;
                case 203 -> 1937339062;
                case 204 -> 2108389318;
                case 205 -> 2023121604;
                case 206 -> -813228482;
                case 207 -> -2052588025;
                case 208 -> -2046171117;
                case 209 -> 1314557890;
                case 210 -> -1688628151;
                case 211 -> -343673718;
                case 212 -> -20603807;
                case 213 -> -1586218985;
                case 214 -> -2101624630;
                case 215 -> 1250437909;
                case 216 -> 576636046;
                case 217 -> 1614562632;
                case 218 -> -46821725;
                case 219 -> 1227858060;
                case 220 -> -70359795;
                case 221 -> -668202416;
                case 222 -> 1046598518;
                case 223 -> 1710207655;
                case 224 -> 1559392749;
                case 225 -> 1016966127;
                case 226 -> 1324959199;
                case 227 -> 1065836927;
                case 228 -> -615861925;
                case 229 -> -1290901484;
                case 230 -> 1019036221;
                case 231 -> 716419078;
                case 232 -> 77894168;
                case 233 -> 1234184841;
                case 234 -> 1753691040;
                case 235 -> -1515672474;
                case 236 -> -158187392;
                case 237 -> 1226365564;
                case 238 -> -1563853423;
                case 239 -> -1682848551;
                case 240 -> 711703464;
                case 241 -> -1456249187;
                case 242 -> 270227175;
                case 243 -> 575890652;
                case 244 -> 1381939375;
                case 245 -> 511671039;
                case 246 -> -113706693;
                case 247 -> 1081283546;
                case 248 -> 1828488170;
                case 249 -> -1096137225;
                case 250 -> -1200228579;
                case 251 -> -1230341169;
                case 252 -> -100450519;
                case 253 -> -2074351885;
                case 254 -> -231228269;
                case 255 -> -1455614004;
                default -> 1595024523;
            });
        } while (v2 != 168);
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
            Object[] objectArray = new Object[15];
            v1 = objectArray;
            0I00 = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        0IOo = -5592406;
        0IO0 = 4;
        0IOO = 5;
        0oii = 3;
        0oiI = 6;
        0oio = 15;
        0oi0 = 12;
        00i = 0.5f;
    }

    @Override
    protected void O0i(ScaledDrawContext param1) {
        int v5;
        super.O0i(param1);
        if (PotionEffectsHudElement.iooI()) {
            return;
        }
        List v2 = this.IO0O();
        if (v2.isEmpty() && !(PotionEffectsHudElement.ConfigSupport_OI0.currentScreen instanceof HudEditorScreen)) {
            return;
        }
        FontRenderer v3 = NetworkSupport_00OI.OOo(20);
        DataRecord_oi0o_1 v4 = this.IO00(v3, v2);
        PostProcessingModule.IoiO(v4.RenderSupport_ooo_0, v4.oo0, v4.ooo, v4.ooI, this.RenderSupport_oii_4((Integer)this.0oI.HelpCommand()), ((Color)this.0oi.HelpCommand()).getRGB());
        if (((Boolean)this.0IOI.HelpCommand()).booleanValue() && !v2.isEmpty()) {
            for (v5 = 0; v5 < v2.size(); ++v5) {
                StatusEffectInstance v6 = ((DataRecord_o0i_0)v2.get(v5)).PacketEvent();
                if (!v6.shouldShowIcon()) continue;
                int v7 = v4.RenderSupport_ooo_0 + this.RenderSupport_oii_4(6);
                int cfr_ignored_0 = v4.oo0 + this.RenderSupport_oii_4(3) + v5 * this.RenderSupport_oii_4(15) + this.RenderSupport_oii_4(2);
                param1.ConfigSupport_O0I().drawGuiTexture(RenderPipelines.GUI_TEXTURED, InGameHud.getEffectTexture((RegistryEntry)v6.getEffectType()), v7, (int)v2, this.RenderSupport_oii_4(12), this.RenderSupport_oii_4(12));
            }
        }
        v5 = v4.RenderSupport_ooo_0 + this.RenderSupport_oii_4(6) + ((Boolean)this.0IOI.HelpCommand() != false && !v2.isEmpty() ? this.RenderSupport_oii_4(17) : 0);
        int v6 = v4.oo0 + this.RenderSupport_oii_4(3) + this.RenderSupport_oii_4(2);
        float v7 = 0.5f * this.OIo();
        RenderSupport_00oi_0.HudElement(() -> {
            param1.ConfigSupport_O0I().getMatrices().pushMatrix();
            param1.ConfigSupport_O0I().getMatrices().scale(v7, v7);
            if (v2.isEmpty()) {
                v3.PacketEvent(param1.ConfigSupport_O0I(), "No Effects", (float)v5 / v7, (float)v6 / v7, -1);
            } else {
                for (int v7 = 0; v7 < v2.size(); ++v7) {
                    DataRecord_o0i_0 v8 = (DataRecord_o0i_0)v2.get(v7);
                    float v9 = v6 + v7 * this.RenderSupport_oii_4(15);
                    v3.PacketEvent(param1.ConfigSupport_O0I(), v8.HelpCommand(), (float)v5 / v7, v9 / v7, v8.GuiSupport_OOI());
                    v3.PacketEvent(param1.ConfigSupport_O0I(), v8.OOo(), (float)(v5 + v8.OOi() + this.RenderSupport_oii_4(4)) / v7, v9 / v7, -5592406);
                }
            }
            param1.ConfigSupport_O0I().getMatrices().popMatrix();
        });
        this.Oii(v4.RenderSupport_ooo_0, v4.oo0, v4.ooo, v4.ooI);
    }

    private DataRecord_oi0o_1 IO00(FontRenderer param1, List param2) {
        if (this.0I0O == null) {
            this.0I0O = this.IO0i(param1, param2);
        }
        return this.0I0O;
    }
}

