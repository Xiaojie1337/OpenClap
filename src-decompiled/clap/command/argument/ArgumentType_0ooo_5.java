/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.arguments.BoolArgumentType
 *  com.mojang.brigadier.arguments.StringArgumentType
 *  com.mojang.brigadier.builder.LiteralArgumentBuilder
 *  com.mojang.brigadier.context.CommandContext
 */
package clap.command.argument;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import java.awt.Color;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import clap.core.module.Module;
import clap.command.argument.ArgumentType_0oo0_2;
import clap.model.DataRecord_i0i_0;
import clap.command.argument.ArgumentType_iii_3;
import clap.setting.Setting;
import clap.command.Command;

/*
 * Renamed from clap.render.RenderSupport_0ooo_1
 */
public class ArgumentType_0ooo_5
extends Command {
    private final Module Iioo;
    static Object PacketEvent;
    private static volatile /* synthetic */ long __k__gH4it;

    private void Oooii(LiteralArgumentBuilder param1, Setting param2) {
        Class<?> v3 = ((Number)param2.EnumType_0OI()).getClass();
        param1.then(ArgumentType_0ooo_5.ConfigSupport_0OOO(param2.PacketEvent().toLowerCase()).then(ArgumentType_0ooo_5.RenderSupport_0OO0("value", DataRecord_i0i_0.IiI(v3, DataRecord_i0i_0.IiO((Number)param2.EventBusApi(), (Number)param2.ConfigSupport_O0I()))).executes(param3 -> {
            param2.OOo(DataRecord_i0i_0.Ii0(v3, param3, "value"));
            return this.OoIO0(param2);
        })));
    }

    private void OoIOO(LiteralArgumentBuilder param1, Setting param22) {
        param1.then(ArgumentType_0ooo_5.ConfigSupport_0OOO(param22.PacketEvent().toLowerCase()).then(ArgumentType_0ooo_5.RenderSupport_0OO0("value", (ArgumentType)BoolArgumentType.bool()).executes(param2 -> {
            param22.OOo(BoolArgumentType.getBool((CommandContext)param2, (String)"value"));
            return this.OoIO0(param22);
        })));
    }

    public ArgumentType_0ooo_5(Module param1) {
        super(new String[]{param1.iooi().toLowerCase()});
        this.OiiO("Command line configuration implementation for \"" + param1.iooi() + "\"");
        this.Iioo = param1;
    }

    @Override
    public void PacketEvent(LiteralArgumentBuilder param1) {
        for (Setting v3 : this.Iioo.ioIO()) {
            Class<?> v4 = v3.EnumType_0OI().getClass();
            if (Boolean.class.isAssignableFrom(v4)) {
                this.OoIOO(param1, v3);
                continue;
            }
            if (Number.class.isAssignableFrom(v4)) {
                this.Oooii(param1, v3);
                continue;
            }
            if (Enum.class.isAssignableFrom(v4)) {
                this.OooiI(param1, v3);
                continue;
            }
            if (String.class.isAssignableFrom(v4)) {
                this.Oooio(param1, v3);
                continue;
            }
            if (!Color.class.isAssignableFrom(v4)) continue;
            this.Oooi0(param1, v3);
        }
    }

    static {
        __k__gH4it = ArgumentType_0ooo_5.__k__gH4it(8531141410693312017L);
        __rP__gH4it0 = new String[]{"\u0b84\ued2c\u33f1\u66de\ue1cf\u2329\u66f9\u3091\u0aaa\uec36", "\u0b84\ued39\u33e8", "\u0b91\ued24\u33f1\u66a7\ue1c6"};
        __rP__gH4it1 = new String[]{"\u0bbb\ued08\u3320\u6690\ue105\u22b8\u675e\u31f8\u0a69\uec43\u32bd\u67c3\ue0c0\u2199\u64c0\u3209\u09e4\uef86\u3166\u648e\ue360\u201d\u65a7\u338f\u08a8\uee9b\u30b5\u65f2\ue271\u20ef\u62fe\u3438\u0f8e\ue9ac\u371c\u628e\ue571\u2710\u63bc\u35b7\u0e1f\ue88b\u3690\u6320\ue4d8\u26a4\u60d6\u3694\u0d79\ueb97\u35b6\u6048\ue7ea\u2517\u616c\u3720\u0ce6\ueae2\u3412\u6141\ue694\u2440\u61fb\u38c2\u031c\ue516\u3b89\u6e04\ue990\u2b3f\u6e16\u39c5\u021c\ue4b9\u3ae1\u6f4a\ue8c1\u2a5e\u6fcd\u3abc\u0151\ue747\u3920\u6c9d\ueb18\u29a7\u6c31\u3a44"};
        __rP__gH4it2 = new String[]{"\u0bb3\ued42\u33a9\u66b7\ue1cf\u237a\u6623\u30c5", "\u0b86\ued2e\u33f7\u66d8\ue1cd\u232b\u66c7\u316f\u0aa8\uec34", "\u0b92\ued23\u33f2\u66b7\ue1af\u234a\u66a8\u316e\u0a8e\uec25\u32ea\u67c3\ue0d1\u2250\u6782\u323d\u09a2\uef1f\u31df\u64ef", "\u0b94\ued3d\u33f1\u66a2\ue1cf\u232e\u66cc"};
        __rP__gH4it3 = new String[0];
        byte[] v0 = "%\u00a6I@\u00a1x}\u00e1\u00ef\u00f5\u00cc\u000b|A\u00fb\u0018j8\u001fN\u00d4\u00cd\u0094\u00e6\u001e\u00dd\u00f4J\u00fd\u00c7\u00f5Y0\u00e2U>\u00f50\u00bf\u00ce\u00b9\u00dd\u00c1\u0088D\u009c\u00cd\u00e5\u00d7\u00c9\u00ef\u00e8~'\u007fi0\u0084\u00b3\u00d9xH\u0010\u0083\u00c2x \u0094t?\u00f5\u009c\u00da\u00cfP\u00c2=F6\u00ed\u009f9\u0099\u001d\u00ec\u00b7\u00c2\u00ed".getBytes("ISO_8859_1");
        Object[] v1 = "\u007f:\u001659\u0014\u00een".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 1349610586;
                case 1 -> 797349810;
                case 2 -> -390610667;
                case 3 -> -1241034463;
                case 4 -> 1802307664;
                case 5 -> -1252884418;
                case 6 -> 1234729435;
                case 7 -> 839996139;
                case 8 -> -1314888391;
                case 9 -> 1291140259;
                case 10 -> -1528643463;
                case 11 -> 912813065;
                case 12 -> 2080448892;
                case 13 -> -1548754432;
                case 14 -> 1660792980;
                case 15 -> -1425211053;
                case 16 -> -916120253;
                case 17 -> 54228410;
                case 18 -> -2110256623;
                case 19 -> -1947234269;
                case 20 -> -1891834527;
                case 21 -> -1272469711;
                case 22 -> 1223187784;
                case 23 -> -187978652;
                case 24 -> -742939682;
                case 25 -> 868565165;
                case 26 -> 185841449;
                case 27 -> -572007520;
                case 28 -> 599440199;
                case 29 -> 556106693;
                case 30 -> -1232359209;
                case 31 -> -1168779177;
                case 32 -> -1323994817;
                case 33 -> 1668885171;
                case 34 -> 272421112;
                case 35 -> -770578830;
                case 36 -> 419121844;
                case 37 -> 1303298291;
                case 38 -> -1854764844;
                case 39 -> -317248187;
                case 40 -> -162138595;
                case 41 -> 1087992886;
                case 42 -> -1536797652;
                case 43 -> 1265258066;
                case 44 -> -1859517027;
                case 45 -> -1243167674;
                case 46 -> 1623439695;
                case 47 -> 142255767;
                case 48 -> 844606296;
                case 49 -> 1757051825;
                case 50 -> -1557972700;
                case 51 -> -1454506379;
                case 52 -> -2085400605;
                case 53 -> 808316141;
                case 54 -> 2048549051;
                case 55 -> 1810990183;
                case 56 -> 1980219354;
                case 57 -> -1998030472;
                case 58 -> -123760047;
                case 59 -> -421111218;
                case 60 -> 323889880;
                case 61 -> -103502364;
                case 62 -> -597407960;
                case 63 -> -1106174;
                case 64 -> 2038845226;
                case 65 -> -782854993;
                case 66 -> 2008070530;
                case 67 -> 1309093045;
                case 68 -> -1403291584;
                case 69 -> -1348661956;
                case 70 -> -1921492149;
                case 71 -> -1583121343;
                case 72 -> -1888932129;
                case 73 -> 1571896551;
                case 74 -> 1812891532;
                case 75 -> -337090293;
                case 76 -> -356726146;
                case 77 -> 1602513174;
                case 78 -> 1935094019;
                case 79 -> -1065435708;
                case 80 -> -178307808;
                case 81 -> -496116753;
                case 82 -> 1053271984;
                case 83 -> -1721384119;
                case 84 -> 1216660212;
                case 85 -> 1452248681;
                case 86 -> 239572829;
                case 87 -> 801592297;
                case 88 -> -139046216;
                case 89 -> 1907478594;
                case 90 -> 1933766029;
                case 91 -> 867043785;
                case 92 -> -1591540825;
                case 93 -> 714283813;
                case 94 -> 759250312;
                case 95 -> 1842156240;
                case 96 -> -880429574;
                case 97 -> -1649753978;
                case 98 -> -77608605;
                case 99 -> -1785962897;
                case 100 -> -1494371482;
                case 101 -> -986564050;
                case 102 -> -1302895207;
                case 103 -> -1987902298;
                case 104 -> -109107706;
                case 105 -> -1758317071;
                case 106 -> 1636285053;
                case 107 -> -55232373;
                case 108 -> -2094364382;
                case 109 -> -494032790;
                case 110 -> -1055544485;
                case 111 -> 1586108656;
                case 112 -> -1314360262;
                case 113 -> 685149336;
                case 114 -> -1883052644;
                case 115 -> -910084878;
                case 116 -> -84316474;
                case 117 -> -1956836873;
                case 118 -> 1023465910;
                case 119 -> 385260050;
                case 120 -> 1719641789;
                case 121 -> -1750912749;
                case 122 -> 186755396;
                case 123 -> -188761761;
                case 124 -> -1648185216;
                case 125 -> -1888711076;
                case 126 -> 1387120952;
                case 127 -> -1051033738;
                case 128 -> -1672759475;
                case 129 -> -2076036865;
                case 130 -> 1393382010;
                case 131 -> 596339060;
                case 132 -> -1274364270;
                case 133 -> -356978733;
                case 134 -> -501195410;
                case 135 -> 1356758829;
                case 136 -> -274998783;
                case 137 -> -531556694;
                case 138 -> -1269706593;
                case 139 -> 172647479;
                case 140 -> -540180543;
                case 141 -> 1285795413;
                case 142 -> 90472609;
                case 143 -> -1938555009;
                case 144 -> -197700266;
                case 145 -> -318564248;
                case 146 -> 1207077028;
                case 147 -> -1580967074;
                case 148 -> -1581045223;
                case 149 -> -1376145469;
                case 150 -> -1701626363;
                case 151 -> 1231670415;
                case 152 -> -1275074024;
                case 153 -> 23763724;
                case 154 -> 102509675;
                case 155 -> -898075940;
                case 156 -> 1093713801;
                case 157 -> -3793398;
                case 158 -> -1397365497;
                case 159 -> -856840497;
                case 160 -> 1133038420;
                case 161 -> -2013005552;
                case 162 -> -842682904;
                case 163 -> 647820161;
                case 164 -> -433716635;
                case 165 -> -2111068028;
                case 166 -> -751223134;
                case 167 -> 1464113428;
                case 168 -> 409217644;
                case 169 -> 1012639713;
                case 170 -> 30552699;
                case 171 -> 1349701545;
                case 172 -> 273354222;
                case 173 -> 1069415402;
                case 174 -> 602065963;
                case 175 -> -1429984322;
                case 176 -> -1956033538;
                case 177 -> 854171400;
                case 178 -> -456775200;
                case 179 -> 362214687;
                case 180 -> -157322853;
                case 181 -> 2132125134;
                case 182 -> 528098122;
                case 183 -> -673820583;
                case 184 -> 930426884;
                case 185 -> -1636031817;
                case 186 -> 744579098;
                case 187 -> 188444075;
                case 188 -> -959650507;
                case 189 -> -1181207154;
                case 190 -> 362303690;
                case 191 -> -1231930493;
                case 192 -> -1285042523;
                case 193 -> -1748253798;
                case 194 -> 1588605900;
                case 195 -> -1569566425;
                case 196 -> 753896366;
                case 197 -> -877743380;
                case 198 -> -665892655;
                case 199 -> 1035204234;
                case 200 -> 2086657216;
                case 201 -> 1695729654;
                case 202 -> 1785056047;
                case 203 -> -554398315;
                case 204 -> 116766867;
                case 205 -> -1612422106;
                case 206 -> 1016819250;
                case 207 -> 1442630653;
                case 208 -> -1015602187;
                case 209 -> -524167998;
                case 210 -> -1802410985;
                case 211 -> -166825458;
                case 212 -> -1460052033;
                case 213 -> -1951930670;
                case 214 -> -791598277;
                case 215 -> -532250061;
                case 216 -> 948006558;
                case 217 -> -1481904135;
                case 218 -> 1174450493;
                case 219 -> 1721505997;
                case 220 -> -1573586916;
                case 221 -> -240610960;
                case 222 -> 1719176327;
                case 223 -> 1674799325;
                case 224 -> -644874270;
                case 225 -> -1471952019;
                case 226 -> 2061583612;
                case 227 -> -1908437063;
                case 228 -> -2072639544;
                case 229 -> -2096483557;
                case 230 -> -1991705075;
                case 231 -> 1101343420;
                case 232 -> 1161533061;
                case 233 -> -2050725743;
                case 234 -> -1754068281;
                case 235 -> 1530586774;
                case 236 -> -902878672;
                case 237 -> -1511452458;
                case 238 -> -1053356656;
                case 239 -> 1491370767;
                case 240 -> 200740382;
                case 241 -> 56556876;
                case 242 -> 752737237;
                case 243 -> 2107111799;
                case 244 -> -1718896781;
                case 245 -> 484982129;
                case 246 -> -1983497888;
                case 247 -> -1079790936;
                case 248 -> 49053947;
                case 249 -> 1422409189;
                case 250 -> -914615500;
                case 251 -> 1703417260;
                case 252 -> -853084954;
                case 253 -> 147080665;
                case 254 -> 1024516043;
                case 255 -> -1836726174;
                default -> -1457061330;
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
            Object[] objectArray = new Object[3];
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

    private void OooiI(LiteralArgumentBuilder param1, Setting param22) {
        Class<?> v3 = ((Enum)param22.EnumType_0OI()).getClass();
        param1.then(ArgumentType_0ooo_5.ConfigSupport_0OOO(param22.PacketEvent().toLowerCase()).then(ArgumentType_0ooo_5.RenderSupport_0OO0("value", ArgumentType_0oo0_2.EnumType_oi0i_1(v3)).executes(param2 -> {
            param22.OOo(ArgumentType_0oo0_2.GuiSupport_oi0o_2(param2, "value"));
            return this.OoIO0(param22);
        })));
    }

    private int OoIO0(Setting param1) {
        return this.OiIO("Set %s.%s to %s", this.Iioo.iooi(), param1.PacketEvent(), param1.HelpCommand());
    }

    private void Oooio(LiteralArgumentBuilder param1, Setting param22) {
        param1.then(ArgumentType_0ooo_5.ConfigSupport_0OOO(param22.PacketEvent().toLowerCase()).then(ArgumentType_0ooo_5.RenderSupport_0OO0("value", (ArgumentType)StringArgumentType.greedyString()).executes(param2 -> {
            param22.OOo(StringArgumentType.getString((CommandContext)param2, (String)"value"));
            return this.OoIO0(param22);
        })));
    }

    private void Oooi0(LiteralArgumentBuilder param1, Setting param22) {
        param1.then(ArgumentType_0ooo_5.ConfigSupport_0OOO(param22.PacketEvent().toLowerCase()).then(ArgumentType_0ooo_5.RenderSupport_0OO0("value", ArgumentType_iii_3.OO0i()).executes(param2 -> {
            param22.OOo(ArgumentType_iii_3.FontRenderer(param2, "value"));
            Color v3 = (Color)param22.HelpCommand();
            return this.OiIO("Set %s.%s to RGB(%s, %s, %s)", this.Iioo.iooi(), param22.PacketEvent(), v3.getRed(), v3.getGreen(), v3.getBlue());
        })));
    }

    @Override
    public boolean Oiio() {
        return false;
    }
}

