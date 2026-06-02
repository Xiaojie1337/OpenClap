/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.mojang.brigadier.CommandDispatcher
 *  com.mojang.brigadier.builder.LiteralArgumentBuilder
 *  com.mojang.brigadier.exceptions.CommandSyntaxException
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package clap.command.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import java.security.Key;
import java.security.MessageDigest;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import clap.network.NetworkSupport_000O;
import clap.command.impl.TranslateCommand;
import clap.command.impl.IrcCommand;
import clap.command.impl.HelpCommand;
import clap.command.impl.BindCommand;
import clap.command.impl.ToggleCommand;
import clap.setting.SettingContainer;
import clap.command.impl.PrefixCommand;
import clap.event.Listener;
import clap.command.impl.FriendCommand;
import clap.command.impl.ConfigCommand;
import clap.command.Command;
import skidonion.loader.0ooo;

/*
 * Renamed from clap.module.movement.MoveFixModule
 */
public class CommandsCommand
extends Listener
implements SettingContainer {
    private static final Logger o0Io;
    private final Map o0Ii;
    private final CommandDispatcher o0II = new CommandDispatcher();
    private String o0i0 = ".";
    private final List o0iO;
    static Object o0io;
    private static volatile /* synthetic */ long __k__gH4it;

    public void IiIO(String param1) {
        String v2 = this.Iiii(param1);
        if (v2.isBlank()) {
            Command.Oiii("Use {green}%shelp {reset}to see available commands.", "general", this.o0i0);
            return;
        }
        try {
            this.o0II.execute(v2, (Object)this);
        }
        catch (CommandSyntaxException v3) {
            Command.Oiii("{red} %s", "general", v3.getRawMessage().getString());
        }
    }

    public List Iii0() {
        return this.o0iO;
    }

    @Override
    public String OIoi() {
        return "commands.json";
    }

    public Command IiIi(String param1) {
        if (param1 == null) {
            return null;
        }
        return (Command)this.o0Ii.get(param1.toLowerCase(Locale.ROOT));
    }

    public void RotationModule() {
        this.IiI0(new BindCommand());
        this.IiI0(new ConfigCommand());
        this.IiI0(new NetworkSupport_000O());
        this.IiI0(new FriendCommand());
        this.IiI0(new HelpCommand());
        this.IiI0(new IrcCommand());
        this.IiI0(new PrefixCommand());
        this.IiI0(new TranslateCommand());
        this.IiI0(new ToggleCommand());
        o0Io.info("Registered {} commands", (Object)this.o0iO.size());
        0ooo.CriticalsModule().PacketEvent(this);
    }

    public String IiII() {
        return this.o0i0;
    }

    public Set IiiO() {
        return this.o0Ii.keySet();
    }

    public boolean IiiI(String param1) {
        return param1 != null && !this.o0i0.isEmpty() && param1.startsWith(this.o0i0);
    }

    public void IiI0(Command param1) {
        this.o0iO.add(param1);
        for (String v5 : param1.RenderSupport_oiii_5()) {
            String v6 = v5.toLowerCase(Locale.ROOT);
            this.o0Ii.put(v6, param1);
            LiteralArgumentBuilder v7 = Command.ConfigSupport_0OOO(v6);
            param1.PacketEvent(v7);
            this.o0II.register(v7);
        }
    }

    static {
        __k__gH4it = CommandsCommand.__k__gH4it(-6006096454060347887L);
        __rP__gH4it0 = new String[]{"\u874a\ud5f6\u0a53\u5ce6\udb2b\ufb67\u2515\u0a39\u8499\ud6df\u0943\u5c29\uda2e\ufaf4\u24de\u0ba1\u8597\ud791\u085e\u5d56\udd23\ufd7f\u23b1\u0cd9\u82f0\ud041\u0f21\u5a44\udc64\ufc4a\u222a\u0d90\u833d\ud126\u0e57\u5b6b\udce3\uffcb\u21ab\u0ecb\u80b5\ud260\u0df3\u5803\udf05\ufee2\u20a9\u0f77\u811a\ud30c\u0c8b\u597e\ude3a\ue176\u3ff6\u10e0\u9e49\ucc0c\u137c\u461d\uc125\ue0b0\u3e61\u119a\u9f6e\ucdd0\u1262\u4767\uc07a\ue0e5\u3dc5\u1296\u9c51\ucea0\u11ff\u4468\uc388\ue3ca\u3c2e\u1313\u9dc1\ucf5f\u108d\u4516\uc208\ue263\u3b29\u14b9\u9a66\uc8b1\u17da\u4259\uc5ac\ue512\u3aab\u15e8\u9baa\uc9ff\u16e4\u43b4\uc452\ue4bb\u3aff\u16a9\u9810\uca54\u158d\u40d2\uc7ec\ue785\u39cc\u17c7\u9956\ucb13\u141a\u4137\uc6b0\ue621\u38cc\u18e7\u96fd\uc44f\u1b72\u4e0c\uc9b0\ue94e\u377c\u19c4\u97a1\uc529\u1a57\u4f72\uc8fa\ue878\u36f0\u1999\u9412\uc652\u19e4\u4c82\ucb4b\ueb62\u35ae\u1a54\u9544\uc75f\u18ab\u4d51\ucade\ueacc\u3400\u1bb7\u92e0\uc0ef\u1f34\u4aeb\ucd67\uedf3\u33f4\u1c36\u9384\uc142\u1e5a\u4b2c\ucc63\uec0a\u32a9\u1db2", "\u8732\ud5f1\u0ad6\u5f54\ud882\uf825\u2667\u09f4\u842e\ud6f7\u09ce\u5c20\udbec\ufb2f\u255d\u0aa7\u8502\ud7cd\u08fb\u5d0c", "\u8724\ud5e7\u0ac4"};
        __rP__gH4it1 = new String[]{"\u8726\ud5fc\u0ad3\u5f03\ud810\uf874\u2678\u09cd\u87c8\ud6a6"};
        __rP__gH4it2 = new String[]{"\u8724\ud5c2\u0aad\u5f01\ud812\uf872\u267e\u09cf\u87ca\ud6a8"};
        __rP__gH4it3 = new String[]{"\u8754\ud533\u0a41\u5fe4\ud84f\uf898\u26d4\u09bd", "\u8734\ud5ef\u0ad5\u5f49\ud8e2\uf841\u2603", "\u8731\ud5f2\u0add\u5f48\ud8eb"};
        byte[] v0 = "\u0084\u00ban\u00e5b\u0088\u00b9jo\u00ebF\u00d2o\u0013z\u00fai\u00adS\u00a5z\u0080\r\u009a\u0016e4\u00af5\u00bd\u009e\u00db\u00d3\nJ\u0088J\u0004g\u00b8\u00a3t\u0096\u00d8\u00a4%m\f\u0004\u0010\u00e6\u00ad\u0083\u00a9*\u0083O\b\t\u00d6\u0094g\u00b5\u00f1`\u00dc\u001f\u00a4\u00f3\u00ca)\u0085gT\u00ba\u00d3\t\u00ed\u00ca\b\u00ff\u00a3\u00c0\u00a5\u0091\\\u00d5\u00ba@U\u008f\u00f2=%_\u00e3\u0084\u0013\u00b9\u0017\u00bb\u00b4\u00f3\u009aF\u0080(I\r\u0082\u00c8\u00fc\b\u00cf\u00b7\u00a4I>\u00d0\u00c4\u00bb\u008b\u00c7\u0087AYh\u00ef\u00ef\u00e5\u00ea\u00f13\u0017\u00dcJd\u00e6a\u00f9\u008a\u0005\u008a\u008f:\u00e3&\"\u0007\u00b3<t\u0086K\u00a1\u0080\u00b6\u0084\u00c0\u00fd\u00ea\u00ee\u00c7OJE\u00e5A".getBytes("ISO_8859_1");
        Object[] v1 = "8\u009d\u00a2\u00b9d\u00d5\u009eH".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -279708141;
                case 1 -> 1107240896;
                case 2 -> -1661452272;
                case 3 -> -1333866471;
                case 4 -> 1267644507;
                case 5 -> -1505128776;
                case 6 -> 856733509;
                case 7 -> -1908432619;
                case 8 -> 948245343;
                case 9 -> 554295467;
                case 10 -> 1011124434;
                case 11 -> 1334956564;
                case 12 -> -1181513067;
                case 13 -> -253343171;
                case 14 -> -659540874;
                case 15 -> -958098067;
                case 16 -> 1857084749;
                case 17 -> -259850240;
                case 18 -> -1946009471;
                case 19 -> 1501177132;
                case 20 -> -2024288769;
                case 21 -> 678732883;
                case 22 -> 1685185483;
                case 23 -> -1318723027;
                case 24 -> 806245220;
                case 25 -> 388927546;
                case 26 -> 1252055795;
                case 27 -> 1116150909;
                case 28 -> 1873408706;
                case 29 -> 2032442281;
                case 30 -> -1049548541;
                case 31 -> 1069203310;
                case 32 -> 1865950164;
                case 33 -> -726775097;
                case 34 -> -2079264317;
                case 35 -> -1067548834;
                case 36 -> 2053967241;
                case 37 -> 498305465;
                case 38 -> 1242272822;
                case 39 -> 1592011370;
                case 40 -> -974521658;
                case 41 -> 990466607;
                case 42 -> -699344604;
                case 43 -> -1612957286;
                case 44 -> 131089426;
                case 45 -> -2065242828;
                case 46 -> 2081934549;
                case 47 -> 1372250098;
                case 48 -> -181624548;
                case 49 -> -817726030;
                case 50 -> -1400079284;
                case 51 -> -1316285738;
                case 52 -> -1089334125;
                case 53 -> -1234267409;
                case 54 -> 2006245425;
                case 55 -> 423059127;
                case 56 -> 603645606;
                case 57 -> -1908463067;
                case 58 -> 1374324864;
                case 59 -> 13139528;
                case 60 -> -1200003976;
                case 61 -> 110149345;
                case 62 -> -527706457;
                case 63 -> 202768278;
                case 64 -> -995535048;
                case 65 -> -1182749268;
                case 66 -> 107015794;
                case 67 -> 971339995;
                case 68 -> -982621188;
                case 69 -> -230599133;
                case 70 -> 1511888333;
                case 71 -> 930681719;
                case 72 -> 144362420;
                case 73 -> -42843313;
                case 74 -> 1898623206;
                case 75 -> -1680445674;
                case 76 -> 1826439554;
                case 77 -> -813235310;
                case 78 -> -705225699;
                case 79 -> -636805221;
                case 80 -> 1896595953;
                case 81 -> 961388153;
                case 82 -> -440859902;
                case 83 -> 306464246;
                case 84 -> 223128599;
                case 85 -> -665862529;
                case 86 -> 1621493016;
                case 87 -> 1390614917;
                case 88 -> 1526629894;
                case 89 -> 1859648647;
                case 90 -> -247875829;
                case 91 -> 487609390;
                case 92 -> -1722669412;
                case 93 -> -132715177;
                case 94 -> -393781167;
                case 95 -> 669827952;
                case 96 -> 1536307262;
                case 97 -> 645518012;
                case 98 -> -1878197585;
                case 99 -> -90336164;
                case 100 -> -1907481204;
                case 101 -> -1359014262;
                case 102 -> -1169500645;
                case 103 -> 1549208581;
                case 104 -> -514954520;
                case 105 -> -495780103;
                case 106 -> 1002727521;
                case 107 -> 577814988;
                case 108 -> 412747806;
                case 109 -> 1329668042;
                case 110 -> 323232360;
                case 111 -> 733644270;
                case 112 -> -701624511;
                case 113 -> 304978063;
                case 114 -> -1148886131;
                case 115 -> 2113509692;
                case 116 -> -745416749;
                case 117 -> -736944748;
                case 118 -> 923063772;
                case 119 -> 1659495743;
                case 120 -> -311258590;
                case 121 -> 1425097891;
                case 122 -> 1105775238;
                case 123 -> -174642144;
                case 124 -> 925096421;
                case 125 -> -1821854072;
                case 126 -> -352817067;
                case 127 -> -73490618;
                case 128 -> -544589052;
                case 129 -> -1049026601;
                case 130 -> -323883211;
                case 131 -> -668388919;
                case 132 -> -1882198003;
                case 133 -> 372183590;
                case 134 -> 402441332;
                case 135 -> 1416857504;
                case 136 -> 361967434;
                case 137 -> 1445868449;
                case 138 -> 737602800;
                case 139 -> 1539341200;
                case 140 -> 1363203098;
                case 141 -> 1961253475;
                case 142 -> -1758415989;
                case 143 -> 1524597674;
                case 144 -> 759516961;
                case 145 -> -1408727911;
                case 146 -> -275497114;
                case 147 -> -163549104;
                case 148 -> -1360457749;
                case 149 -> -1329936136;
                case 150 -> -596432205;
                case 151 -> 1092769012;
                case 152 -> 1296882752;
                case 153 -> -2074565564;
                case 154 -> -1157252961;
                case 155 -> -1794926886;
                case 156 -> -1454517678;
                case 157 -> -1551938585;
                case 158 -> 1179419433;
                case 159 -> -430610455;
                case 160 -> 2036332372;
                case 161 -> -805576581;
                case 162 -> -385960060;
                case 163 -> -891997532;
                case 164 -> 703174552;
                case 165 -> 1261155454;
                case 166 -> 1480336145;
                case 167 -> -351094076;
                case 168 -> -191305680;
                case 169 -> 1555887626;
                case 170 -> 2036055726;
                case 171 -> -472780066;
                case 172 -> 1523619187;
                case 173 -> 1740666558;
                case 174 -> 161773047;
                case 175 -> -1989946663;
                case 176 -> 1205812279;
                case 177 -> 1810062699;
                case 178 -> -1119400783;
                case 179 -> 1862380642;
                case 180 -> 578879418;
                case 181 -> -1666057165;
                case 182 -> -1597034309;
                case 183 -> -1427455651;
                case 184 -> -1318474763;
                case 185 -> 322117856;
                case 186 -> 380373981;
                case 187 -> 901523201;
                case 188 -> -1886839856;
                case 189 -> -1992457500;
                case 190 -> 1187244982;
                case 191 -> 1685533838;
                case 192 -> -1717380996;
                case 193 -> 1876902501;
                case 194 -> -917613757;
                case 195 -> -919930105;
                case 196 -> 183312797;
                case 197 -> -1790342475;
                case 198 -> -1645541301;
                case 199 -> -226910456;
                case 200 -> 687527313;
                case 201 -> 1630584391;
                case 202 -> -1926827133;
                case 203 -> -965051302;
                case 204 -> 1534520767;
                case 205 -> -2102141318;
                case 206 -> 716629192;
                case 207 -> -1912181295;
                case 208 -> 1097827158;
                case 209 -> -1226570484;
                case 210 -> 718885882;
                case 211 -> -1299466781;
                case 212 -> -547780535;
                case 213 -> 758061804;
                case 214 -> 1254975182;
                case 215 -> -161790433;
                case 216 -> -304760131;
                case 217 -> 2105483944;
                case 218 -> -329325736;
                case 219 -> -700876760;
                case 220 -> -455970457;
                case 221 -> 1158796553;
                case 222 -> -865350039;
                case 223 -> 1461216234;
                case 224 -> -802339476;
                case 225 -> 1495423349;
                case 226 -> 356636217;
                case 227 -> -729647282;
                case 228 -> -1246574931;
                case 229 -> 1001998631;
                case 230 -> -184623656;
                case 231 -> 1201665217;
                case 232 -> 931769085;
                case 233 -> -1382717910;
                case 234 -> -419351611;
                case 235 -> -869633221;
                case 236 -> -1124453007;
                case 237 -> 174169246;
                case 238 -> -349614037;
                case 239 -> -62025127;
                case 240 -> 1297729175;
                case 241 -> -1466744782;
                case 242 -> -277335025;
                case 243 -> -1230735454;
                case 244 -> 686669232;
                case 245 -> -157964081;
                case 246 -> 95592974;
                case 247 -> 1719125474;
                case 248 -> 957888578;
                case 249 -> 563509413;
                case 250 -> -2140999057;
                case 251 -> 1582835040;
                case 252 -> -1890302739;
                case 253 -> -107453698;
                case 254 -> 1981293819;
                case 255 -> -328362017;
                default -> 816749357;
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
            Object[] objectArray = new Object[9];
            v1 = objectArray;
            o0io = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        o0Io = LogManager.getLogger((String)"Commands");
    }

    public void IiIo(String param1) {
        if (param1 == null) {
            return;
        }
        String v2 = param1.trim();
        if (v2.isEmpty()) {
            return;
        }
        this.o0i0 = v2;
    }

    @Override
    public void OIoI(JsonElement param1) {
        if (param1 == null || !param1.isJsonObject()) {
            return;
        }
        JsonObject v2 = param1.getAsJsonObject();
        if (v2.has("prefix")) {
            this.IiIo(v2.get("prefix").getAsString());
        }
    }

    public CommandDispatcher Iiio() {
        return this.o0II;
    }

    public CommandsCommand() {
        super("Commands");
        this.o0Ii = new LinkedHashMap();
        this.o0iO = new LinkedList();
    }

    @Override
    public JsonElement OIoo() {
        JsonObject v1 = new JsonObject();
        v1.addProperty("prefix", this.o0i0);
        return v1;
    }

    public String Iiii(String param1) {
        if (!this.IiiI(param1)) {
            return "";
        }
        return param1.substring(this.o0i0.length()).trim();
    }
}

