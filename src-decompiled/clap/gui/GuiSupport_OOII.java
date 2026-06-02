/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.sound.PositionedSoundInstance
 *  net.minecraft.client.sound.SoundInstance
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.sound.SoundEvents
 */
package clap.gui;

import java.awt.Color;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import clap.gui.GuiSupport_O000;
import clap.gui.component.GuiComponent;
import clap.setting.Setting;
import clap.gui.GuiSupport_oi0o_0;

public class GuiSupport_OOII
extends GuiComponent {
    private final Setting PacketEvent;
    private final MinecraftClient HelpCommand = MinecraftClient.getInstance();
    private boolean GuiSupport_OOI;
    static Object OOi;
    private static volatile /* synthetic */ long __k__gH4it;

    static {
        __k__gH4it = GuiSupport_OOII.__k__gH4it(5523342480063327761L);
        __rP__gH4it0 = new String[]{"\u7665\ue58e\u3bad\u6fce\ue846\u88e9\ubdb5\u39f9\u770a\ue49b\u3a3f\u6fe9\ueb28\u8bff\ube7e\u3a9c\u74c3\ue728\u39b9\u6c8d\uea46\u8abc\ubfc4\u3b48\u752c\ue65e\u38ef\u6d1f\ued2c\u8ddf\ub8a0\u3cff\u721a\ue120\u3f7f\u6abb\ued5a\u8c0e\ub9d2\u3d04\u73ce\ue0c1\u3e48\u6bbe\uecee\u8f1d\ubadc\u3e4b\u7081\ue390\u3dee\u681e\uef4c\u8e8c\ubba5\u3fec\u7140\ue26a\u3c9d\u6924\uee3d\uf1a9\uc451\u4086\u0e4f\u9d56\u4398\u1690\u912b\uf174\uc51c\u41a7", "\u76c5\ue5e2\u3a8c\u6f61\ue832\u8892\ubd1e\u3904\u77eb\ue488", "\u76d3\ue411\u3ab7\u6f74\ue862\u8805\ubd47\u397f\u77cf\ue717\u39af\u6c00\ueb0c\u8b0f\ube7d\u3a2c\u74e3\ue62d\u389a\u6d2c", "\u76d0\ue412\u3abc\u6f68\ue80b"};
        __rP__gH4it1 = new String[]{"\u7614\ue4a7\u3a92\u6ff9\ue806\u880d\ubd18\u39ce", "\u76d5\ue40f\u3ab4\u6f69\ue802\u8861\ubd23"};
        __rP__gH4it2 = new String[]{"\u76c7\ue41c\u3ab2\u6f63\ue830\u8894\ubd18\u3906\u77e9\ue486", "\u76c5\ue407\u3aa5"};
        __rP__gH4it3 = new String[0];
        byte[] v0 = "\u00aa\u0002\u0091\u00cd\u000f\u0006Y\u0001\u00fdo;\u0012i\u0018\u009al<\u00d4\u00b5~\u001fC8\u00a0\u00cb\u00ba\u00fb\u00f4}(T\u001f\u00f5\u00cccX\u00f3\u00c1^\u00dc\u00d9\u0015,eO\u00daX\u009b\u009eL\u0082\u00cd\u00f5S9$G\u00ae\u00e9\u00ef\u008c~\u00c5F@\u009a\u00e4S\u00a2[\u00b0\u001f".getBytes("ISO_8859_1");
        Object[] v1 = "\u0099\u00e9P\u00c4\r\u00a02\u00f0".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -743397267;
                case 1 -> -282647459;
                case 2 -> 532860661;
                case 3 -> 1860240954;
                case 4 -> -514874276;
                case 5 -> 1833157936;
                case 6 -> -1974039596;
                case 7 -> 2065356320;
                case 8 -> 2048539728;
                case 9 -> 1480834831;
                case 10 -> 923073879;
                case 11 -> 438487306;
                case 12 -> -168428031;
                case 13 -> -709891428;
                case 14 -> -367068531;
                case 15 -> -2031134313;
                case 16 -> -1754892901;
                case 17 -> -1292276720;
                case 18 -> -1096309821;
                case 19 -> -1209118751;
                case 20 -> -1866472032;
                case 21 -> 1803725459;
                case 22 -> 757589397;
                case 23 -> -1648180183;
                case 24 -> -644919632;
                case 25 -> 1745755365;
                case 26 -> -1529096627;
                case 27 -> 526027041;
                case 28 -> 1701016209;
                case 29 -> 1229810020;
                case 30 -> 2010470082;
                case 31 -> -1587766680;
                case 32 -> 1301995754;
                case 33 -> 1274973555;
                case 34 -> -1098806779;
                case 35 -> -856202598;
                case 36 -> 664226863;
                case 37 -> 1638658161;
                case 38 -> -38461329;
                case 39 -> -2094078754;
                case 40 -> -1074348547;
                case 41 -> 16756038;
                case 42 -> -1908570938;
                case 43 -> 322448100;
                case 44 -> 1048004390;
                case 45 -> -219581141;
                case 46 -> 875779385;
                case 47 -> 359693991;
                case 48 -> -986553350;
                case 49 -> 836356421;
                case 50 -> -785588896;
                case 51 -> -1101771553;
                case 52 -> -1389814098;
                case 53 -> -179537721;
                case 54 -> 1563774493;
                case 55 -> 784513880;
                case 56 -> -773148253;
                case 57 -> 419927653;
                case 58 -> 827854204;
                case 59 -> -1508354793;
                case 60 -> -223137261;
                case 61 -> -2079102356;
                case 62 -> 1776109261;
                case 63 -> -2005119170;
                case 64 -> 284719124;
                case 65 -> 180550467;
                case 66 -> -1605922127;
                case 67 -> -1117697770;
                case 68 -> 792159277;
                case 69 -> 2020356009;
                case 70 -> 1006141062;
                case 71 -> -386690776;
                case 72 -> -1221322361;
                case 73 -> 602520982;
                case 74 -> 106699277;
                case 75 -> -1405334703;
                case 76 -> -1325140812;
                case 77 -> 1290821186;
                case 78 -> -623248503;
                case 79 -> 1013056889;
                case 80 -> 1818242153;
                case 81 -> -756815179;
                case 82 -> 634145392;
                case 83 -> -421227864;
                case 84 -> 674003516;
                case 85 -> -412064658;
                case 86 -> 1185139904;
                case 87 -> 943406887;
                case 88 -> 17645662;
                case 89 -> -1426710976;
                case 90 -> -899020878;
                case 91 -> -2129022645;
                case 92 -> 597486130;
                case 93 -> 370633493;
                case 94 -> 859889810;
                case 95 -> 101781051;
                case 96 -> 294168509;
                case 97 -> -710305932;
                case 98 -> -1584308561;
                case 99 -> -1299698193;
                case 100 -> 651731992;
                case 101 -> 1681003762;
                case 102 -> 445739844;
                case 103 -> 1012858614;
                case 104 -> 1713919385;
                case 105 -> -2127293167;
                case 106 -> 1608707882;
                case 107 -> 507405293;
                case 108 -> -1680368033;
                case 109 -> 1780614474;
                case 110 -> -1014234135;
                case 111 -> 483861326;
                case 112 -> -645543944;
                case 113 -> -569798593;
                case 114 -> 749466143;
                case 115 -> 1952955987;
                case 116 -> 548640347;
                case 117 -> -481804829;
                case 118 -> -1839932318;
                case 119 -> -1458947382;
                case 120 -> 1299841899;
                case 121 -> -1727941180;
                case 122 -> -1524775960;
                case 123 -> -221757684;
                case 124 -> 890721822;
                case 125 -> -1544534740;
                case 126 -> -1282527886;
                case 127 -> -1618668185;
                case 128 -> -1075010083;
                case 129 -> 1119567508;
                case 130 -> 733415159;
                case 131 -> -1649257463;
                case 132 -> 396495500;
                case 133 -> 8792524;
                case 134 -> 2070065605;
                case 135 -> -591569127;
                case 136 -> -523764756;
                case 137 -> -1071181698;
                case 138 -> -1568647800;
                case 139 -> -932119435;
                case 140 -> -1213160434;
                case 141 -> 1453407952;
                case 142 -> 520939829;
                case 143 -> -328752682;
                case 144 -> -1566298250;
                case 145 -> -1285213334;
                case 146 -> 553550647;
                case 147 -> -1453310331;
                case 148 -> -62959836;
                case 149 -> 799917181;
                case 150 -> 1172104905;
                case 151 -> -787436925;
                case 152 -> 536577846;
                case 153 -> -950169646;
                case 154 -> -1325635300;
                case 155 -> 1127084861;
                case 156 -> 1154807425;
                case 157 -> -465614597;
                case 158 -> -855729306;
                case 159 -> 689191340;
                case 160 -> -688279584;
                case 161 -> -339836798;
                case 162 -> -1618064825;
                case 163 -> -503523508;
                case 164 -> -173353130;
                case 165 -> -1101666119;
                case 166 -> 2139279263;
                case 167 -> -515179679;
                case 168 -> -1372055470;
                case 169 -> -632603462;
                case 170 -> 2045822117;
                case 171 -> -932973436;
                case 172 -> 344074367;
                case 173 -> 1478513492;
                case 174 -> 1919716539;
                case 175 -> -1760961551;
                case 176 -> 1828283279;
                case 177 -> -1314652317;
                case 178 -> 1613056952;
                case 179 -> 1837389751;
                case 180 -> 2010761721;
                case 181 -> 1543810645;
                case 182 -> 717565915;
                case 183 -> -1538481682;
                case 184 -> 1370872372;
                case 185 -> 217191459;
                case 186 -> -244433106;
                case 187 -> -626060005;
                case 188 -> -831123661;
                case 189 -> -637913151;
                case 190 -> -1309082389;
                case 191 -> -1843011775;
                case 192 -> 973800708;
                case 193 -> -1021205496;
                case 194 -> -1190359992;
                case 195 -> 1280680843;
                case 196 -> -781413978;
                case 197 -> 494780604;
                case 198 -> 1123960955;
                case 199 -> 1456353186;
                case 200 -> 1600143138;
                case 201 -> 1670601344;
                case 202 -> -1411328292;
                case 203 -> 926842631;
                case 204 -> 1193677017;
                case 205 -> 1319829849;
                case 206 -> 1225339124;
                case 207 -> 1441579914;
                case 208 -> 64120319;
                case 209 -> -1720724913;
                case 210 -> -103661798;
                case 211 -> 943202251;
                case 212 -> 436759978;
                case 213 -> 809805527;
                case 214 -> -20060294;
                case 215 -> -1829550605;
                case 216 -> -1959226723;
                case 217 -> -637083302;
                case 218 -> 807187928;
                case 219 -> 1103380976;
                case 220 -> -1447384688;
                case 221 -> -72005698;
                case 222 -> 462652830;
                case 223 -> -425262413;
                case 224 -> 1683221971;
                case 225 -> 635741146;
                case 226 -> 1810420174;
                case 227 -> -1871348801;
                case 228 -> -1439367016;
                case 229 -> -1286400207;
                case 230 -> -1583777269;
                case 231 -> 1378970325;
                case 232 -> -696482504;
                case 233 -> 797335761;
                case 234 -> 651119122;
                case 235 -> -1946607357;
                case 236 -> 1477380040;
                case 237 -> 1114666496;
                case 238 -> 261193121;
                case 239 -> -1152262426;
                case 240 -> 1079852069;
                case 241 -> -304529410;
                case 242 -> -114690133;
                case 243 -> -1073249310;
                case 244 -> -2051152777;
                case 245 -> 1778600312;
                case 246 -> -315613956;
                case 247 -> 1988808777;
                case 248 -> -1802451530;
                case 249 -> 2079114413;
                case 250 -> -2007738106;
                case 251 -> -2051774066;
                case 252 -> 162828775;
                case 253 -> -940759857;
                case 254 -> -384446300;
                case 255 -> 90452482;
                default -> -382619822;
            });
        } while (v2 != 72);
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
            Object[] objectArray = new Object[1];
            v1 = objectArray;
            OOi = objectArray;
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

    @Override
    public void OOo(double param1, double param3, int param5) {
        if (this.Ooo((int)param1, (int)param3)) {
            if (param5 == 0) {
                this.GuiSupport_OOI = !this.GuiSupport_OOI;
                this.OoO();
            } else if (param5 == 1) {
                GuiSupport_O000 v6 = GuiSupport_O000.iOIO();
                v6.iOiO(((GuiSupport_O000)this.PacketEvent.HelpCommand()).iOIi());
                this.PacketEvent.OOo(v6);
                this.GuiSupport_OOI = false;
                this.OoO();
            } else if (this.GuiSupport_OOI) {
                this.PacketEvent.OOo(this.O0i(param5));
                this.GuiSupport_OOI = false;
                this.OoO();
            }
        } else if (this.GuiSupport_OOI) {
            this.GuiSupport_OOI = false;
        }
    }

    @Override
    public String HelpCommand(int param1, int param2) {
        if (!this.Ooo(param1, param2)) {
            return null;
        }
        String v3 = this.PacketEvent.Oi0();
        return v3 == null || v3.isEmpty() ? null : v3;
    }

    private void OoO() {
        this.HelpCommand.getSoundManager().play((SoundInstance)PositionedSoundInstance.ui((RegistryEntry)SoundEvents.UI_BUTTON_CLICK, (float)1.0f));
    }

    public GuiSupport_OOII(Setting param1, float param2, float param3, float param4, float param5) {
        super(param2, param3, param4, param5);
        this.PacketEvent = param1;
    }

    public boolean O0o(int param1) {
        if (!this.GuiSupport_OOI || param1 == 0 || param1 == 1) {
            return false;
        }
        this.PacketEvent.OOo(this.O0i(param1));
        this.GuiSupport_OOI = false;
        this.OoO();
        return true;
    }

    private GuiSupport_O000 O0i(int param1) {
        GuiSupport_O000 v2 = GuiSupport_O000.iOI0(param1);
        v2.iOiO(((GuiSupport_O000)this.PacketEvent.HelpCommand()).iOIi());
        return v2;
    }

    @Override
    public void EventBusApi(int param1, int param2, int param3) {
        if (!this.GuiSupport_OOI) {
            return;
        }
        if (param1 == 256) {
            this.GuiSupport_OOI = false;
            return;
        }
        if (param1 == 261 || param1 == 259) {
            GuiSupport_O000 v4 = GuiSupport_O000.iOIO();
            v4.iOiO(((GuiSupport_O000)this.PacketEvent.HelpCommand()).iOIi());
            this.PacketEvent.OOo(v4);
            this.GuiSupport_OOI = false;
            return;
        }
        GuiSupport_O000 v4 = new GuiSupport_O000(param1);
        v4.iOiO(((GuiSupport_O000)this.PacketEvent.HelpCommand()).iOIi());
        this.PacketEvent.OOo(v4);
        this.GuiSupport_OOI = false;
        this.OoO();
    }

    public boolean ConfigSupport_O0I() {
        return this.GuiSupport_OOI;
    }

    private String HudElement(GuiSupport_O000 param1) {
        return param1.IoOO();
    }

    @Override
    public void PacketEvent(DrawContext param1, int param2, int param3, float param4) {
        Color v5 = this.GuiSupport_OOI ? new Color(100, 60, 60, 220) : (this.Ooo(param2, param3) ? new Color(70, 70, 70, 220) : new Color(55, 55, 55, 220));
        GuiSupport_oi0o_0.OOoiO(param1, (float)this.OOi, this.HudElement, (float)(this.OOi + this.EventBusApi), this.HudElement + this.O0o, v5.getRGB());
        String v6 = this.GuiSupport_OOI ? "Press a key or mouse button..." : "Bind: " + this.HudElement((GuiSupport_O000)this.PacketEvent.HelpCommand()) + " [" + ((GuiSupport_O000)this.PacketEvent.HelpCommand()).iOIi().name() + "]";
        int v7 = this.GuiSupport_OOI ? -39322 : -1;
        param1.drawText(this.HelpCommand.textRenderer, v6, (int)(this.OOi + 5.0f), (int)(this.HudElement + this.O0o / 2.0f - 4.0f), v7, true);
    }
}

