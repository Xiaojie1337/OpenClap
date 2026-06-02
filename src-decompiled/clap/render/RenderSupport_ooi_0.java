/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.text.Style
 *  net.minecraft.text.Text
 *  net.minecraft.util.Formatting
 */
package clap.render;

import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import clap.event.EventBusApi;
import clap.command.Command;
import skidonion.loader.0ooo;

/*
 * Renamed from psx.Hyk.OOi
 */
public class RenderSupport_ooi_0 {
    static Object PacketEvent;
    private static volatile /* synthetic */ long __k__gH4it;

    public static void PacketEvent(Text param0, String param1) {
        RenderSupport_ooi_0.HelpCommand((Text)Text.empty().setStyle(Style.EMPTY.withColor(Formatting.GRAY)).append("<").append(RenderSupport_ooi_0.OOi()).append(">").append(" ").append(param0), param1);
    }

    public static void OOo(String param0) {
        if (Command.iooI()) {
            return;
        }
        EventBusApi.ConfigSupport_OI0.inGameHud.getChatHud().addToMessageHistory(param0);
    }

    public static Text OOi() {
        return Text.empty().withColor(0ooo.PacketEvent().GuiSupport_OOI()).append("Clap");
    }

    public static void HelpCommand(Text param0, String param1) {
        if (Command.iooI()) {
            return;
        }
        EventBusApi.ConfigSupport_OI0.inGameHud.getChatHud().addMessage(param0);
    }

    public static void GuiSupport_OOI(String param0) {
        if (Command.iooI()) {
            return;
        }
        String v1 = EventBusApi.ConfigSupport_OI0.player != null ? EventBusApi.ConfigSupport_OI0.player.method_7334().name() : "Player";
        EventBusApi.ConfigSupport_OI0.inGameHud.getChatHud().addMessage((Text)Text.literal((String)("<" + v1 + "> " + param0)));
    }

    static {
        __k__gH4it = RenderSupport_ooi_0.__k__gH4it((long)3534536506188230161L);
        __rP__gH4it0 = new String[]{"\u3fb3\u5674\u88c1\udd91\u5ad5\u38e5\ude9c\u8be9", "\u3f91\u56fd\u88a2\udd67\u5a7f\u381a\ude58\u8bbd\u3e8d\u51fb\u8fba\uda13\u5d01\u3f00\ud972\u8c8e\u3981\u5121\u8eaf\udb5f", "\u3f87\u56e7\u88b8"};
        __rP__gH4it1 = new String[]{"\u3f87\u56f2\u88a1\udd0e\u5a1f\u3879\ude29\u8ba2\u3e89\u5188", "\u3f92\u56fa\u88a1\udd77\u5a16"};
        __rP__gH4it2 = new String[]{"\u3f97\u56e3\u88a1\udd72\u5a1f\u387e\ude3c"};
        __rP__gH4it3 = new String[]{"\u3f1f\u575d\u886b\udd96\u5a1b\u3819\ude25\u8bf8\u3e11\u565d\u888a\udac8\u5d43\u3fba\ud9ae\u8c25\u39ed\u5118\u8f67\udbbb\u5ca9\u3e43\ud841\u8de8\u383d\u509c\u8e08\ud85a\u5f95\u3d71\udb59\u8e10\u3bd6\u5396\u8ddd\ud999\u5e6b\u3c04\udaf3\u8fa3\u3ae7\u52ae\u8c28\ud9b4\u41ce\u23ae\uc5b8\u90be\u25d5\u4d71\u9319\uc69b\u4014\u2253\uc4a8\u91eb", "\u3f85\u56f0\u88a7\udd08\u5a1d\u387b\ude37\u8bbc\u3e8b\u518a"};
        byte[] v0 = "\u00e2\r\u00b2\u00b6\u000f\u00a9\u00162\u00945\u00ab\u00d0/2e\u00e7`xN\u00ab\u00cd\u00c3\u00822\u00a8\u00e49R\u00e9\u00e9\u0082\u00c2K\u00e6\u00e4\u0099\u001f\u0094 \u0089B\u00a6)L\u0082FS\u009cxq\u0010kP\u00b3K\u00d1".getBytes("ISO_8859_1");
        Object[] v1 = "|\u00d2.\u00c3\u00f3\u00bb\u0081q".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 231283892;
                case 1 -> 1112046655;
                case 2 -> -62444963;
                case 3 -> 1934552578;
                case 4 -> -242591692;
                case 5 -> 577838822;
                case 6 -> -1181083102;
                case 7 -> -2133699068;
                case 8 -> -1554928580;
                case 9 -> 134092693;
                case 10 -> 1188587129;
                case 11 -> -652799371;
                case 12 -> 1139179855;
                case 13 -> 1003202559;
                case 14 -> 2078258911;
                case 15 -> -242521254;
                case 16 -> -1805629129;
                case 17 -> 1904114785;
                case 18 -> -343765859;
                case 19 -> -1326408689;
                case 20 -> 1585931884;
                case 21 -> 2061955952;
                case 22 -> 1107292856;
                case 23 -> -77322184;
                case 24 -> -503416962;
                case 25 -> -1194831051;
                case 26 -> 1160685677;
                case 27 -> -878050062;
                case 28 -> 792155830;
                case 29 -> -1152548625;
                case 30 -> -1431842712;
                case 31 -> 430784523;
                case 32 -> 1535739273;
                case 33 -> 1727661849;
                case 34 -> 578386919;
                case 35 -> -346805463;
                case 36 -> 653644462;
                case 37 -> 1887410490;
                case 38 -> 514421386;
                case 39 -> 1830821674;
                case 40 -> 1316845851;
                case 41 -> 936194784;
                case 42 -> -44753053;
                case 43 -> 1390439262;
                case 44 -> 196149628;
                case 45 -> -1439782655;
                case 46 -> 1153665950;
                case 47 -> 960698764;
                case 48 -> 2105382454;
                case 49 -> 1638420478;
                case 50 -> -762660761;
                case 51 -> 1988455687;
                case 52 -> 495302865;
                case 53 -> 1310971669;
                case 54 -> -113648462;
                case 55 -> 372338437;
                case 56 -> 1388078359;
                case 57 -> -1061109234;
                case 58 -> 252591245;
                case 59 -> 1895093827;
                case 60 -> 1674057846;
                case 61 -> 871100946;
                case 62 -> 1817230564;
                case 63 -> 1903239907;
                case 64 -> -467313625;
                case 65 -> -116969317;
                case 66 -> 357975703;
                case 67 -> -1733573982;
                case 68 -> 2086056392;
                case 69 -> 2007152375;
                case 70 -> -1694648005;
                case 71 -> -473918735;
                case 72 -> 166333229;
                case 73 -> -1613225139;
                case 74 -> 824834662;
                case 75 -> -270005201;
                case 76 -> 1442462652;
                case 77 -> -361278221;
                case 78 -> -1386265174;
                case 79 -> -184158747;
                case 80 -> 2052382739;
                case 81 -> -475331117;
                case 82 -> 1821834190;
                case 83 -> 822897500;
                case 84 -> -724311509;
                case 85 -> 12866258;
                case 86 -> -422744527;
                case 87 -> 583701871;
                case 88 -> -1744604302;
                case 89 -> -180789305;
                case 90 -> -1660850139;
                case 91 -> -394437932;
                case 92 -> 2115771640;
                case 93 -> -19611962;
                case 94 -> -1147818408;
                case 95 -> 1626072392;
                case 96 -> 1642752051;
                case 97 -> -1428654367;
                case 98 -> 729814210;
                case 99 -> 1681970853;
                case 100 -> -290188842;
                case 101 -> 1857070714;
                case 102 -> 1353958872;
                case 103 -> -680761679;
                case 104 -> -1094393583;
                case 105 -> 1946103971;
                case 106 -> -1879678610;
                case 107 -> 1089136176;
                case 108 -> 239834640;
                case 109 -> 445312030;
                case 110 -> 572107471;
                case 111 -> 1401836457;
                case 112 -> 802258970;
                case 113 -> -1204663989;
                case 114 -> 849264886;
                case 115 -> 44102590;
                case 116 -> -1491225620;
                case 117 -> -525705127;
                case 118 -> -866614755;
                case 119 -> -1113446017;
                case 120 -> -788598032;
                case 121 -> 701553378;
                case 122 -> 1811336774;
                case 123 -> 2017327761;
                case 124 -> 1216723883;
                case 125 -> -1226296657;
                case 126 -> -21188730;
                case 127 -> -399312884;
                case 128 -> 1860833887;
                case 129 -> 1786458112;
                case 130 -> -1488997465;
                case 131 -> -1646166228;
                case 132 -> 552531781;
                case 133 -> 488484376;
                case 134 -> 1798237988;
                case 135 -> 947553471;
                case 136 -> 1699716793;
                case 137 -> -1676807333;
                case 138 -> 1074037610;
                case 139 -> 1400069193;
                case 140 -> -908009513;
                case 141 -> 253447403;
                case 142 -> 560759940;
                case 143 -> -79218098;
                case 144 -> -355241715;
                case 145 -> 510368534;
                case 146 -> -1890011821;
                case 147 -> -2098833157;
                case 148 -> -685121539;
                case 149 -> 1073942116;
                case 150 -> 594047545;
                case 151 -> -1262620335;
                case 152 -> 1765758656;
                case 153 -> -946980660;
                case 154 -> -1044338879;
                case 155 -> 1094948215;
                case 156 -> 1483387499;
                case 157 -> 169881808;
                case 158 -> 686279939;
                case 159 -> 1554086832;
                case 160 -> -2086966535;
                case 161 -> 1486587744;
                case 162 -> 2062955328;
                case 163 -> 214485387;
                case 164 -> 1652836692;
                case 165 -> 127280190;
                case 166 -> 2024478354;
                case 167 -> 1141508872;
                case 168 -> 1975650995;
                case 169 -> -806003959;
                case 170 -> 16470373;
                case 171 -> -1985787872;
                case 172 -> 615138685;
                case 173 -> -1182736435;
                case 174 -> 1974903485;
                case 175 -> 1421239956;
                case 176 -> -1957604222;
                case 177 -> 2105560979;
                case 178 -> -1540567369;
                case 179 -> 101834301;
                case 180 -> 52166889;
                case 181 -> -60784744;
                case 182 -> -7594135;
                case 183 -> 1969284084;
                case 184 -> -2044970352;
                case 185 -> 1805308661;
                case 186 -> 1581715524;
                case 187 -> -1644724912;
                case 188 -> -1345969295;
                case 189 -> 1240084878;
                case 190 -> 208083381;
                case 191 -> 566379295;
                case 192 -> -293789353;
                case 193 -> -998344276;
                case 194 -> 781118113;
                case 195 -> 220771306;
                case 196 -> 1062130053;
                case 197 -> -241666929;
                case 198 -> -187786556;
                case 199 -> -1339273824;
                case 200 -> 1915489838;
                case 201 -> 1493543297;
                case 202 -> -1919909338;
                case 203 -> 519960104;
                case 204 -> -951165917;
                case 205 -> -2104187008;
                case 206 -> -1072834462;
                case 207 -> 1374045446;
                case 208 -> -1468371894;
                case 209 -> 1393527718;
                case 210 -> 1864778363;
                case 211 -> 821346517;
                case 212 -> 683054043;
                case 213 -> -1697388734;
                case 214 -> 1634069721;
                case 215 -> -1766510917;
                case 216 -> -854173011;
                case 217 -> 1794921301;
                case 218 -> -1380327192;
                case 219 -> 1835628915;
                case 220 -> 1202361850;
                case 221 -> 813776581;
                case 222 -> 1040885449;
                case 223 -> 523885215;
                case 224 -> 1152879770;
                case 225 -> -1392781316;
                case 226 -> 1710322196;
                case 227 -> 984887460;
                case 228 -> 407453063;
                case 229 -> 873406446;
                case 230 -> -2076417454;
                case 231 -> 890163420;
                case 232 -> 156744278;
                case 233 -> -131566183;
                case 234 -> -1103458294;
                case 235 -> -634247229;
                case 236 -> -1775494520;
                case 237 -> 445266247;
                case 238 -> -737084552;
                case 239 -> 852491041;
                case 240 -> 1842914013;
                case 241 -> -425177996;
                case 242 -> -773485492;
                case 243 -> 1510353901;
                case 244 -> -224594404;
                case 245 -> 2030539467;
                case 246 -> 2059256506;
                case 247 -> 24522646;
                case 248 -> 54106334;
                case 249 -> -1152467766;
                case 250 -> -71125823;
                case 251 -> -879115108;
                case 252 -> 63172520;
                case 253 -> 1531442906;
                case 254 -> 158633603;
                case 255 -> 1940945970;
                default -> -876697791;
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
            Object[] objectArray = new Object[5];
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
    }
}

