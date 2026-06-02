/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.builder.LiteralArgumentBuilder
 */
package clap.command.impl;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import clap.gui.GuiSupport_O000;
import clap.config.ConfigSupport_OIOI;
import clap.core.module.Module;
import clap.model.DataRecord_0oio_0;
import clap.config.ConfigSupport_oioi_5;
import clap.event.EventHandler;
import clap.command.Command;

/*
 * Renamed from clap.command.impl.BindCommand
 */
public class BindCommand
extends Command {
    private Module Iioo;
    static Object IioI;
    private static volatile /* synthetic */ long __k__gH4it;

    public BindCommand() {
        super("bind", "setbind");
        this.OiiO("Sets a key bind for a module");
        OIo.PacketEvent(this);
    }

    @EventHandler
    public void O0iio(ConfigSupport_oioi_5 param1) {
        if (BindCommand.iooI() || this.Iioo == null || param1.0iI() == -1) {
            return;
        }
        if (param1.0iI() == 256) {
            this.Iioo = null;
            BindCommand.OiiI("Operation canceled.", "fail");
            return;
        }
        BindCommand.Oiii("Bind for {green} %s {} set to {green} %s", "general", this.Iioo.iooi(), ConfigSupport_OIOI.PacketEvent(param1.0iI()));
        this.Iioo.0ioI.OOo(new GuiSupport_O000(param1.0iI()));
        this.Iioo = null;
    }

    @Override
    public void PacketEvent(LiteralArgumentBuilder param12) {
        param12.then(BindCommand.RenderSupport_0OO0("module", DataRecord_0oio_0.IrcManager(true)).executes(param1 -> {
            this.Iioo = DataRecord_0oio_0.Oo0i(param1, "module");
            return this.OiIO("Press any key...", new Object[0]);
        }));
    }

    static {
        __k__gH4it = BindCommand.__k__gH4it(8613131378596245009L);
        __rP__gH4it0 = new String[]{"\uac9f\u4869\u96bd\uc37e\u4464\ue003\u5e99\u952a\uad93\u4b7f\u95b5\uc01a\u470a\ue309\u5db3\u9669\uaeaf\u4a55\u9490\uc126", "\uac89\u487f\u96af"};
        __rP__gH4it1 = new String[0];
        __rP__gH4it2 = new String[]{"\uac27\u498e\u97ea\uc213\u45d2\ue1c7\u5e3e\u95d0\uaddd\u4896\u96cb\uc33a\u4439\ue05a\u5d52\u9617\uae69\u4b56\u954b\uc0d5\u471b\ue3a8\u5c36\u97d2\uaf01\u4aa2\u94e8\uc1e5\u46ed\ue265\u5c45\u98ca\ua0e0\u45a6\u9bb9\uce03\u49ac\ued0f\u538c\u9977\ua115\u4479\u9ab8\ucfd8\u4868\uec53\u5241\u9a66\ua2ea\u47fe\u991d\ucc7c\u4b65\uef0e\u515d\u9b08\ua3ed\u46e6\u987c\ucdea\u4a75\ueed8\u5038\u9b1e\ua405\u4105\u9fc7\ucabb\u4dcf\ue912\u57d1\u9c65\ua521\u40b8\u9e2d\ucb65\u4c05\ue861\u56e9\u9d6d\ua6d1\u43e3\u9dd9\uc8f1\u4f45\ueb1c\u553b\u9e2d\ua779\u4209\u9c06\uc96f\u4e87\uea45\u5497\u9f72\ua75e\u7d0b\ua315\uf646\u716f\ud52e\u6b69\ua0fd\u9840\u7cab\ua22d\uf7ab\u7037\ud460\u6ac2\ua125\u9948\u7f64\ua165\uf469\u7308\ud708\u69e5\ua27a\u9a8b\u7e71\ua06c\uf572\u7299\ud6aa\u68bc\ua397\u9bbe\u7ef3\ua7e8\uf2f0\u75bf\ud18b\u6f3b\ua4cd\u9cba\u7929\ua6fc\uf327\u747e\ud09b\u6efa\ua5b4\u9def\u788c\ua5a9\uf0f9\u7767\ud3bf\u6dcd\ua666\u9e14\u7b76\ua45e\uf174\u762e\ud23e\u6cbe\ua776\u9ff8\u7af0\ua46e\ufebf\u79f1\udd76\u6334\ua8ec\u90dd\u7527\uabc8\uff76\u7803\udc19\u6270\ua94c\u91bb\u74d0\uaad2\ufc2c\u7bb1\udf68\u61bc\uaa08", "\uac89\u4866\u96be\uc317\u4404\ue060\u5ee8\u9535\uad97\u4b0c", "\uac5f\u4845\u961c\uc339\u44de\ue0f6\u5ef5\u95ef"};
        __rP__gH4it3 = new String[]{"\uac8b\u4860\u96b8\uc315\u4406\ue06e\u5ee6\u9537\uad95\u4b0a", "\uac99\u4873\u96be\uc36f\u4404\ue09b\u5edd", "\uac9c\u486a\u96be\uc36a\u440d"};
        byte[] v0 = "T\u00ca\u00ac\u00aa]\u00ee\\-\u00a6\u00da\u0085\u008b\u00be{(\u00f2\n\u0002\u001d|\u0084\u0091D?j\u00fe\u00b6DzT\u00cf\u001f\u00f3\u00c2\u001f\u009aC\u0006\u000e\u00aa\u000e\u0015\u0016I\u008fR\u00db\u00a3\u00e9\u008a\u00ab\u00f5\u009a\u0017\u00cf\u00c5\u00e6\u009a\u00c2k\u0082\u00c9\u0092+6\u0001A\u00c2\u0000{sX\u001a\u00b4\u00a3\u0014\u00c2\u0000SH\u00f2\u00f7O\u0098\u009ae\u0089\u0000R\u0015\u0098\u000eP4]g\u008d/\u00f3\u001f@g\u00ab\u00e0\u009b\u0087\u00c3\u00fa\u0010!\u0018 \u008bP\u0093 7Q7w@M\u00923\u00ae\u00fbV\u00e2M7.\u00c9\u00b0\"\u00d9\u00b0A\u00e52\u0016y:\u0000\u00d1\fX\u007f\u00d0x\u0006?\u000b\u00ff\u00aa\u0080U9\u008f\u00b4#k\u0014H\u00a6\u009e\u00ff6\u00b1F\u00cb\u00e6gd\u0098j\t8$\u00e4%\u00ce\u00f1\u00aeE".getBytes("ISO_8859_1");
        Object[] v1 = "\u009es\u00ecv\u00e3\u00ad)\u00ec".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1062574469;
                case 1 -> 1004561168;
                case 2 -> -2143055422;
                case 3 -> 875966726;
                case 4 -> -735106385;
                case 5 -> 1358146858;
                case 6 -> -209666228;
                case 7 -> -1465918086;
                case 8 -> 1851196855;
                case 9 -> -21094028;
                case 10 -> 516879021;
                case 11 -> -1567819102;
                case 12 -> 1579224476;
                case 13 -> 2092336826;
                case 14 -> 1449219080;
                case 15 -> -292290070;
                case 16 -> 141023079;
                case 17 -> 52484666;
                case 18 -> 2087265434;
                case 19 -> -1303987018;
                case 20 -> -858549573;
                case 21 -> 1218954390;
                case 22 -> 618108265;
                case 23 -> 1610018243;
                case 24 -> -1770221049;
                case 25 -> -1167102493;
                case 26 -> -2129379509;
                case 27 -> 2088955773;
                case 28 -> -1245156946;
                case 29 -> -2140909928;
                case 30 -> 370303706;
                case 31 -> -1726329520;
                case 32 -> -1491543201;
                case 33 -> 1521266008;
                case 34 -> -1088527897;
                case 35 -> 1330174997;
                case 36 -> 998589017;
                case 37 -> -2041850020;
                case 38 -> -949995354;
                case 39 -> 966316344;
                case 40 -> 1531722873;
                case 41 -> -93171047;
                case 42 -> 984010403;
                case 43 -> -1526536942;
                case 44 -> 104115102;
                case 45 -> -706308540;
                case 46 -> 1859875436;
                case 47 -> 158170398;
                case 48 -> 1509059272;
                case 49 -> -525991870;
                case 50 -> 565958438;
                case 51 -> -1746247596;
                case 52 -> -485212822;
                case 53 -> -1047128385;
                case 54 -> -43229602;
                case 55 -> 1584695512;
                case 56 -> -951722759;
                case 57 -> 1595561956;
                case 58 -> -2124704820;
                case 59 -> -1998193421;
                case 60 -> -116777077;
                case 61 -> -1008528398;
                case 62 -> -150267651;
                case 63 -> 804770161;
                case 64 -> 2059317829;
                case 65 -> -2087837792;
                case 66 -> -2099155477;
                case 67 -> 1604107739;
                case 68 -> 838586479;
                case 69 -> -1258659560;
                case 70 -> 2070628584;
                case 71 -> -1742153175;
                case 72 -> 846719696;
                case 73 -> 649819444;
                case 74 -> -458589054;
                case 75 -> -4226762;
                case 76 -> 297813749;
                case 77 -> -181735000;
                case 78 -> 1417386041;
                case 79 -> -576037840;
                case 80 -> 1888806959;
                case 81 -> 1701385219;
                case 82 -> 804958667;
                case 83 -> 1305156838;
                case 84 -> -1262001986;
                case 85 -> 628545077;
                case 86 -> 1667437191;
                case 87 -> -2121570047;
                case 88 -> 73485152;
                case 89 -> 1538238754;
                case 90 -> -1519596780;
                case 91 -> 1673854863;
                case 92 -> 433102858;
                case 93 -> 1468622620;
                case 94 -> 1877359404;
                case 95 -> 945166022;
                case 96 -> -31124162;
                case 97 -> 249902741;
                case 98 -> -126408571;
                case 99 -> 1689546546;
                case 100 -> 726351268;
                case 101 -> -1230739746;
                case 102 -> 828245727;
                case 103 -> 655606335;
                case 104 -> -236510726;
                case 105 -> -824146036;
                case 106 -> -1177592478;
                case 107 -> -1277537974;
                case 108 -> 909737503;
                case 109 -> -1957281276;
                case 110 -> 1672125224;
                case 111 -> 929621123;
                case 112 -> -90707732;
                case 113 -> -75057383;
                case 114 -> -1078550424;
                case 115 -> 854163011;
                case 116 -> -1649316195;
                case 117 -> 604725671;
                case 118 -> -573839939;
                case 119 -> -668308076;
                case 120 -> -463562179;
                case 121 -> 131384787;
                case 122 -> -226950185;
                case 123 -> -1866355003;
                case 124 -> -1554721590;
                case 125 -> -1664321181;
                case 126 -> -351668408;
                case 127 -> 168735658;
                case 128 -> 1107461155;
                case 129 -> -942197009;
                case 130 -> -1565950521;
                case 131 -> -1603341298;
                case 132 -> 240813628;
                case 133 -> -1195637209;
                case 134 -> -1697169924;
                case 135 -> 710670986;
                case 136 -> -156581027;
                case 137 -> -1824404012;
                case 138 -> -169555772;
                case 139 -> 644857373;
                case 140 -> 1409484103;
                case 141 -> 2406991;
                case 142 -> 1456898340;
                case 143 -> -2018083127;
                case 144 -> -361868884;
                case 145 -> -1969664371;
                case 146 -> 103090283;
                case 147 -> -2004650360;
                case 148 -> -1517129989;
                case 149 -> 506140398;
                case 150 -> -777078302;
                case 151 -> 1869616666;
                case 152 -> 896423561;
                case 153 -> 1495355321;
                case 154 -> 116410963;
                case 155 -> 1384359223;
                case 156 -> -248924528;
                case 157 -> 158596087;
                case 158 -> 1284943795;
                case 159 -> 201024527;
                case 160 -> 175427414;
                case 161 -> 570434838;
                case 162 -> 585877147;
                case 163 -> -1861636732;
                case 164 -> 1947810687;
                case 165 -> -615357967;
                case 166 -> 1153592914;
                case 167 -> 526685906;
                case 168 -> 257001692;
                case 169 -> -481636609;
                case 170 -> -878836608;
                case 171 -> -1729948302;
                case 172 -> -158949541;
                case 173 -> 1498287329;
                case 174 -> -719550340;
                case 175 -> 1592899454;
                case 176 -> -1636867925;
                case 177 -> 2112552741;
                case 178 -> -462831410;
                case 179 -> -258581904;
                case 180 -> 696253235;
                case 181 -> 487938569;
                case 182 -> 2079664821;
                case 183 -> -145978400;
                case 184 -> -1571037262;
                case 185 -> -1114557855;
                case 186 -> -1995725704;
                case 187 -> -1216716757;
                case 188 -> -371828655;
                case 189 -> -148102322;
                case 190 -> 2140207507;
                case 191 -> -1965553653;
                case 192 -> 1497046647;
                case 193 -> 807718128;
                case 194 -> 790943249;
                case 195 -> 337797998;
                case 196 -> 1532593011;
                case 197 -> -1595301620;
                case 198 -> -540947803;
                case 199 -> -837595387;
                case 200 -> 1398930566;
                case 201 -> 1482970400;
                case 202 -> -1986244094;
                case 203 -> -366967273;
                case 204 -> -380688357;
                case 205 -> 311914304;
                case 206 -> -1645010767;
                case 207 -> -1070842079;
                case 208 -> 1838196182;
                case 209 -> -878200588;
                case 210 -> -471789293;
                case 211 -> 1432413486;
                case 212 -> 977224461;
                case 213 -> -624715863;
                case 214 -> 676627433;
                case 215 -> 1612944996;
                case 216 -> 1552378970;
                case 217 -> 385259835;
                case 218 -> -1571354473;
                case 219 -> 798966976;
                case 220 -> 242211813;
                case 221 -> -1541953034;
                case 222 -> -536109170;
                case 223 -> -1457216836;
                case 224 -> -1661998190;
                case 225 -> -605766810;
                case 226 -> 880341205;
                case 227 -> 851001856;
                case 228 -> -777382472;
                case 229 -> -1354305983;
                case 230 -> 93862303;
                case 231 -> -1829601407;
                case 232 -> 1070890477;
                case 233 -> 1910927973;
                case 234 -> 209248721;
                case 235 -> 551495166;
                case 236 -> 1646431633;
                case 237 -> 1726325172;
                case 238 -> -774640163;
                case 239 -> -846402515;
                case 240 -> 421529039;
                case 241 -> 2098145585;
                case 242 -> 527023009;
                case 243 -> -1176161419;
                case 244 -> 798952013;
                case 245 -> 1530607957;
                case 246 -> 624412664;
                case 247 -> -244407223;
                case 248 -> 1256195801;
                case 249 -> 1466693581;
                case 250 -> 138109783;
                case 251 -> 725063286;
                case 252 -> 1597208941;
                case 253 -> -463352383;
                case 254 -> 38903984;
                case 255 -> -402171834;
                default -> 88278058;
            });
        } while (v2 != 184);
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
            Object[] objectArray = new Object[9];
            v1 = objectArray;
            IioI = objectArray;
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
}

