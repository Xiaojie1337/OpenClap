/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.VertexFormat$DrawMode
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.entity.AbstractFurnaceBlockEntity
 *  net.minecraft.block.entity.BarrelBlockEntity
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.entity.BrewingStandBlockEntity
 *  net.minecraft.block.entity.ChestBlockEntity
 *  net.minecraft.block.entity.DispenserBlockEntity
 *  net.minecraft.block.entity.DropperBlockEntity
 *  net.minecraft.block.entity.EnderChestBlockEntity
 *  net.minecraft.block.entity.HopperBlockEntity
 *  net.minecraft.block.entity.ShulkerBoxBlockEntity
 *  net.minecraft.block.entity.TrappedChestBlockEntity
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  net.minecraft.client.render.BufferBuilder
 *  net.minecraft.client.render.Camera
 *  net.minecraft.client.render.Tessellator
 *  net.minecraft.client.render.VertexFormats
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.util.math.MatrixStack$Entry
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.vehicle.ChestMinecartEntity
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket
 *  net.minecraft.network.packet.s2c.play.BlockEventS2CPacket
 *  net.minecraft.network.packet.s2c.play.BlockUpdateS2CPacket
 *  net.minecraft.network.packet.s2c.play.ChunkDataS2CPacket
 *  net.minecraft.network.packet.s2c.play.ChunkDeltaUpdateS2CPacket
 *  net.minecraft.util.hit.EntityHitResult
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.ChunkPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.chunk.WorldChunk
 */
package clap.module.render;

import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import java.security.Key;
import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BarrelBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BrewingStandBlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.entity.DispenserBlockEntity;
import net.minecraft.block.entity.DropperBlockEntity;
import net.minecraft.block.entity.EnderChestBlockEntity;
import net.minecraft.block.entity.HopperBlockEntity;
import net.minecraft.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.block.entity.TrappedChestBlockEntity;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.vehicle.ChestMinecartEntity;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.BlockEventS2CPacket;
import net.minecraft.network.packet.s2c.play.BlockUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.ChunkDataS2CPacket;
import net.minecraft.network.packet.s2c.play.ChunkDeltaUpdateS2CPacket;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.chunk.WorldChunk;
import clap.core.module.Module;
import clap.model.DataRecord_0oi_0;
import clap.render.RenderSupport_0ooi_1;
import clap.setting.Setting;
import clap.gui.GuiSupport_oi0o_0;
import clap.render.RenderSupport_oiii_5;
import clap.core.module.ModuleCategory;
import clap.event.network.PacketSendEvent;
import clap.event.EventHandler;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class StorageEspModule
extends Module {
    private final Setting Io0;
    private final List RenderSupport_iio_5;
    private final Set IiO;
    private final Setting IOo = this.OOi0o("Range", 96, 16, 256);
    private final Setting ItemTagsModule;
    private static final int oIi;
    private final ArrayDeque GuiSupport_III;
    private int RenderSupport_io0_2;
    private static final int WatermarkHudElement;
    private final Setting Ioi;
    private long Iio;
    private int IiI = -1;
    private static final int oii;
    private final Setting DataRecord_I0O;
    private static final int oiI;
    private static final int RenderSupport_oio_2;
    private boolean iOI;
    private static final float oi0;
    private final Setting IOi;
    private static final int oio;
    private final Setting Ioo;
    private final Setting IrcCommand;
    private int Setting;
    private final Set IIi;
    private long Ii0;
    private final Setting IoI;
    private final Setting NetworkSupport_i0i_2;
    private int Iii = -1;
    private static final int ConfigSupport_IO0;
    private final Map ConfigSupport_II0;
    private final Setting I0o;
    private static final int oII;
    private final Setting IoO;
    private final Setting SprintModule = this.OOi00("Outline", true);
    private final Setting EnumType_I00;
    private static final int oIo;
    private long iOo;
    static Object iOi;

    private Color IoI(Color param1, int param2) {
        return new Color(param1.getRed(), param1.getGreen(), param1.getBlue(), Math.max(0, Math.min(255, param2)));
    }

    private void IiO(int param1, int param2) {
        if (this.IIi.isEmpty() || StorageEspModule.ConfigSupport_OI0.world == null || StorageEspModule.ConfigSupport_OI0.player == null) {
            return;
        }
        BlockPos v3 = StorageEspModule.ConfigSupport_OI0.player.method_24515();
        int v4 = param1 * param1;
        ArrayList v5 = new ArrayList(this.IIi);
        Iterator v6 = v5.iterator();
        while (v6.hasNext()) {
            long v7 = (Long)v6.next();
            WorldChunk v9 = StorageEspModule.ConfigSupport_OI0.world.getChunkManager().method_12126(ChunkPos.getPackedX((long)v7), ChunkPos.getPackedZ((long)v7), false);
            if (v9 != null) {
                this.IIi(v9, v3, v4, param2);
            }
            this.IIi.remove(v7);
        }
    }

    private void GuiSupport_III(int param1, int param2) {
        Long v6;
        if (this.GuiSupport_III.isEmpty() || param2 == 0 || StorageEspModule.ConfigSupport_OI0.world == null || StorageEspModule.ConfigSupport_OI0.player == null) {
            return;
        }
        BlockPos v3 = StorageEspModule.ConfigSupport_OI0.player.method_24515();
        int v4 = param1 * param1;
        for (int v5 = 0; v5 < 12 && (v6 = (Long)this.GuiSupport_III.poll()) != null; ++v5) {
            WorldChunk v7 = StorageEspModule.ConfigSupport_OI0.world.getChunkManager().method_12126(ChunkPos.getPackedX((long)v6), ChunkPos.getPackedZ((long)v6), false);
            if (v7 == null) continue;
            this.IIi(v7, v3, v4, param2);
        }
    }

    private void ioO(ChunkPos param1) {
        this.IIi.add(param1.toLong());
    }

    private void Ii0(int param1, int param2) {
        this.ConfigSupport_II0.entrySet().removeIf(param0 -> ((DataRecord_0oi_0)param0.getValue()).Oii != -1);
        if ((param2 & 1) == 0 || StorageEspModule.ConfigSupport_OI0.world == null || StorageEspModule.ConfigSupport_OI0.player == null) {
            return;
        }
        double v3 = (double)param1 * (double)param1;
        for (Entity v6 : StorageEspModule.ConfigSupport_OI0.world.getEntities()) {
            if (!(v6 instanceof ChestMinecartEntity) || this.iI0(v6.method_73189(), StorageEspModule.ConfigSupport_OI0.player.method_73189()) > v3) continue;
            BlockPos v7 = BlockPos.ofFloored((double)v6.getX(), (double)v6.getY(), (double)v6.getZ());
            long v8 = this.NoHurtCamModule(v6.method_5628());
            this.ConfigSupport_II0.put(v8, new DataRecord_0oi_0(v8, v7, 1, v6.method_5628(), v6.method_5829()));
        }
    }

    private void PotionEffectsHudElement(BufferBuilder param1, MatrixStack.Entry param2, float param3, float param4, float param5, float param6, float param7, float param8, int param9) {
        this.iIi(param1, param2, param3, param4, param5, param6, param4, param5, param6, param4, param8, param3, param4, param8, param9);
        this.iIi(param1, param2, param3, param7, param5, param3, param7, param8, param6, param7, param8, param6, param7, param5, param9);
        this.iIi(param1, param2, param3, param4, param5, param3, param7, param5, param6, param7, param5, param6, param4, param5, param9);
        this.iIi(param1, param2, param6, param4, param5, param6, param7, param5, param6, param7, param8, param6, param4, param8, param9);
        this.iIi(param1, param2, param3, param4, param8, param6, param4, param8, param6, param7, param8, param3, param7, param8, param9);
        this.iIi(param1, param2, param3, param4, param5, param3, param4, param8, param3, param7, param8, param3, param7, param5, param9);
    }

    private double iIO(BlockPos param1, Vec3d param2) {
        double v3 = (double)param1.method_10263() + 0.5 - param2.method_10216();
        double v5 = (double)param1.method_10264() + 0.5 - param2.method_10214();
        double v7 = (double)param1.method_10260() + 0.5 - param2.method_10215();
        return v3 * v3 + v5 * v5 + v7 * v7;
    }

    private boolean iOi(BlockEntity param1, int param2, int param3) {
        if (param1 instanceof ChestBlockEntity || param1 instanceof TrappedChestBlockEntity || param1 instanceof EnderChestBlockEntity || param1 instanceof BarrelBlockEntity) {
            return param2 == 1 && param3 > 0;
        }
        if (param1 instanceof ShulkerBoxBlockEntity) {
            return param2 == 1 && param3 == 1;
        }
        return false;
    }

    private boolean i0i() {
        if (StorageEspModule.ConfigSupport_OI0.world == null) {
            return false;
        }
        long v1 = System.identityHashCode(StorageEspModule.ConfigSupport_OI0.world);
        if (this.iOo == Long.MIN_VALUE) {
            this.iOo = v1;
            return false;
        }
        if (this.iOo != v1) {
            this.iOo = v1;
            return true;
        }
        return false;
    }

    private void Iio(int param1, int param22) {
        this.RenderSupport_iio_5.clear();
        if (StorageEspModule.ConfigSupport_OI0.player == null || this.ConfigSupport_II0.isEmpty() || param22 == 0) {
            return;
        }
        Vec3d v3 = StorageEspModule.ConfigSupport_OI0.player.method_73189();
        double v4 = (double)param1 * (double)param1;
        for (DataRecord_0oi_0 v7 : this.ConfigSupport_II0.values()) {
            if (!this.i00(v7.OiI, param22) || ((Boolean)this.DataRecord_I0O.HelpCommand()).booleanValue() && this.IiO.contains(v7.Oi0) || v7.Oii == -1 && !this.i0I(v7.Oio) || this.iIO(v7.Oio, v3) > v4) continue;
            this.RenderSupport_iio_5.add(v7);
        }
        this.RenderSupport_iio_5.sort(Comparator.comparingDouble(param2 -> this.iIO(param2.Oio, v3)));
        if (this.RenderSupport_iio_5.size() > 256) {
            this.RenderSupport_iio_5.subList(256, this.RenderSupport_iio_5.size()).clear();
        }
    }

    private void iOo() {
        boolean v1 = StorageEspModule.ConfigSupport_OI0.currentScreen instanceof HandledScreen;
        if (!v1 || this.iOI) {
            this.iOI = v1;
            return;
        }
        this.iOI = true;
        HitResult v2 = StorageEspModule.ConfigSupport_OI0.crosshairTarget;
        if (v2 instanceof EntityHitResult) {
            EntityHitResult v3 = (EntityHitResult)v2;
            this.iOI(v3.getEntity());
        }
    }

    @Override
    public void ConfigSupport_II0(RenderSupport_0ooi_1 param1) {
        if (StorageEspModule.iooI() || this.RenderSupport_iio_5.isEmpty()) {
            return;
        }
        this.IiI(param1.0ii());
    }

    static {
        byte[] v0 = "\u00f8\u00a6\u0086\u00feg\u00b0\u0015\u00c2\u00e6\u00b920@\u0085\u0018\u008d\u009a\f\u00c1\u00dc4\u00b7\u00beIzQ+\u00ee\u009f\u0001\u00e9%\u00c8`\u00ac\u00cbk\u00ce)\u00ce\u00de\u00dd\u00cdj\u00d5R\u00e8\u00c3;\u00bd\u0098\u0019\u00adn\u00d1\u00ee\u001b@\u00e9d\u00bb\u0003\u00eb\u00ba?\u00eb\u00f0oeU\u0096CF\u00b7\u00a2&u\u008a\u00ac/\u0012)\u00f6\u00ec\u00dd\u00c5\u00fd\u008f\u00fc\tV\u0012@\u0014\u0018w<)\u0011\u00b6\u0085*\u00a9h\u00af\"-\"A\u0012ukQk\u00f4\u00fe\u00f2\u001c\u00fc\u00a2) \u00f0\u008b\u00fehu\"\r\u00e7#MBx0*\u000f\u00d5?\u00f9\u0082\u001b\u00d5\u00ab\u008a\u008e7\u00ef\u0084\u009eF\u00e53\u00f9\u00c7a\\\u0097q\u00c7RQ\u00df\u00acu\u00f7?J\u00dd\u00c2\u00ea\u00c0L\u0003h\u008d#\u0083\u0082\u00a8\u00dasx9X\u00ca\u00a5\u008b\u000f\u009a\u00cd\t\u008ex\u008b{\u00be\u00e0\u001e\u00fb\u00ce\"\u0006\u00af\u009d\u00d2\bt\u0097\u001b\u00c1\u0019>\u001b\u00c5\u001e\u00b7N\u0007\u0081BFL\u001c\u000b)\u0091\u00c8\u00ff\u00ac1\u0015".getBytes("ISO_8859_1");
        Object[] v1 = ";\u0093\u0004\u0013\u009d\u00f6Vw".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1240858307;
                case 1 -> 976797933;
                case 2 -> 1496346621;
                case 3 -> -551599593;
                case 4 -> 1265695575;
                case 5 -> -1063283014;
                case 6 -> -309252356;
                case 7 -> -690604856;
                case 8 -> 1876478848;
                case 9 -> 664088965;
                case 10 -> -383753317;
                case 11 -> -744125093;
                case 12 -> -1822900938;
                case 13 -> -1435349386;
                case 14 -> -1734762910;
                case 15 -> -291861330;
                case 16 -> -108211711;
                case 17 -> -2146719554;
                case 18 -> 612208878;
                case 19 -> -404920929;
                case 20 -> 439428223;
                case 21 -> 249599793;
                case 22 -> -605371307;
                case 23 -> -1153963265;
                case 24 -> -1064318804;
                case 25 -> -1571347873;
                case 26 -> 354596232;
                case 27 -> -498628654;
                case 28 -> 578388046;
                case 29 -> 76715498;
                case 30 -> -1711855335;
                case 31 -> 447915844;
                case 32 -> -1002325987;
                case 33 -> -674447603;
                case 34 -> 1672870757;
                case 35 -> 195482124;
                case 36 -> -1078286973;
                case 37 -> 1407799030;
                case 38 -> -1964528381;
                case 39 -> 73803794;
                case 40 -> -524916021;
                case 41 -> 1551761135;
                case 42 -> 362247155;
                case 43 -> -889195631;
                case 44 -> 1046390542;
                case 45 -> -536768984;
                case 46 -> -249458460;
                case 47 -> -1481015522;
                case 48 -> 1174659990;
                case 49 -> 1971238549;
                case 50 -> 1022307468;
                case 51 -> 1953067796;
                case 52 -> 370841871;
                case 53 -> 172459977;
                case 54 -> -665515135;
                case 55 -> -128362432;
                case 56 -> 389280170;
                case 57 -> -1476858028;
                case 58 -> 1228720764;
                case 59 -> -1771697564;
                case 60 -> -1055104456;
                case 61 -> 1675974214;
                case 62 -> -778667913;
                case 63 -> -1252967883;
                case 64 -> -1138046960;
                case 65 -> 251167357;
                case 66 -> 1359659681;
                case 67 -> 247678782;
                case 68 -> 644785811;
                case 69 -> 1603683442;
                case 70 -> 759433507;
                case 71 -> -1986129831;
                case 72 -> -904614547;
                case 73 -> -518485079;
                case 74 -> 1604784089;
                case 75 -> -1791589268;
                case 76 -> -498813795;
                case 77 -> -1113003578;
                case 78 -> 1236931674;
                case 79 -> 1578372719;
                case 80 -> -2043890105;
                case 81 -> 1920773365;
                case 82 -> -1945924039;
                case 83 -> 926036085;
                case 84 -> -1692364718;
                case 85 -> 456789801;
                case 86 -> -1407719647;
                case 87 -> 1437719624;
                case 88 -> -286355148;
                case 89 -> 1656758632;
                case 90 -> 1612698618;
                case 91 -> 1974297628;
                case 92 -> -1090190022;
                case 93 -> 1693610565;
                case 94 -> 1050096822;
                case 95 -> 918229931;
                case 96 -> -402299664;
                case 97 -> 834969794;
                case 98 -> -492919967;
                case 99 -> 1389872946;
                case 100 -> 2015742157;
                case 101 -> -321828797;
                case 102 -> 1043860219;
                case 103 -> 875827853;
                case 104 -> -1651917712;
                case 105 -> 696978594;
                case 106 -> 1718153391;
                case 107 -> -1561080994;
                case 108 -> 1690808528;
                case 109 -> -1983013675;
                case 110 -> 398678463;
                case 111 -> 614011696;
                case 112 -> 1935704999;
                case 113 -> 1719663528;
                case 114 -> 511731739;
                case 115 -> 1624321016;
                case 116 -> -1572669380;
                case 117 -> 2002286603;
                case 118 -> -1301933924;
                case 119 -> 871015370;
                case 120 -> -573763194;
                case 121 -> -890895506;
                case 122 -> 1449368103;
                case 123 -> -1683896183;
                case 124 -> 123311384;
                case 125 -> -1576410797;
                case 126 -> 1818673627;
                case 127 -> 141121602;
                case 128 -> 1351108724;
                case 129 -> -716709600;
                case 130 -> 430285688;
                case 131 -> -786247960;
                case 132 -> -28075570;
                case 133 -> -1375560085;
                case 134 -> 1555553172;
                case 135 -> 580577066;
                case 136 -> 166642141;
                case 137 -> -1524865020;
                case 138 -> 127627479;
                case 139 -> 743712748;
                case 140 -> 1267968244;
                case 141 -> 1254938890;
                case 142 -> 1114142307;
                case 143 -> -93160019;
                case 144 -> -535296573;
                case 145 -> -200915007;
                case 146 -> 172002816;
                case 147 -> 775440519;
                case 148 -> 831881081;
                case 149 -> 1472561708;
                case 150 -> -382360135;
                case 151 -> -55152413;
                case 152 -> 1575542374;
                case 153 -> 1834588414;
                case 154 -> -1447719725;
                case 155 -> -1151975072;
                case 156 -> -813137000;
                case 157 -> -212300079;
                case 158 -> -1329700023;
                case 159 -> 352141007;
                case 160 -> 1853010281;
                case 161 -> -1731115733;
                case 162 -> -1074141302;
                case 163 -> 1710762076;
                case 164 -> 1274571599;
                case 165 -> -828768034;
                case 166 -> 1377569935;
                case 167 -> -505685097;
                case 168 -> -1926108313;
                case 169 -> -2137113887;
                case 170 -> 1656983885;
                case 171 -> 308268420;
                case 172 -> 1496707672;
                case 173 -> 101041787;
                case 174 -> -169778623;
                case 175 -> 169823308;
                case 176 -> -235045585;
                case 177 -> 1446668446;
                case 178 -> -208274657;
                case 179 -> -1083457194;
                case 180 -> -445539605;
                case 181 -> 1332764634;
                case 182 -> 717367271;
                case 183 -> 1798020016;
                case 184 -> 2008639857;
                case 185 -> -1666608346;
                case 186 -> 1752874214;
                case 187 -> 1399238052;
                case 188 -> 1421510087;
                case 189 -> -2072880713;
                case 190 -> 1399146466;
                case 191 -> 31069190;
                case 192 -> 220094904;
                case 193 -> -904790509;
                case 194 -> 167623505;
                case 195 -> -906298631;
                case 196 -> 2001950132;
                case 197 -> 1876466256;
                case 198 -> -1339846442;
                case 199 -> -2140090617;
                case 200 -> 1462267141;
                case 201 -> -438906172;
                case 202 -> 357496224;
                case 203 -> 92586786;
                case 204 -> -1961942246;
                case 205 -> 1273199793;
                case 206 -> 1068824878;
                case 207 -> 2106431241;
                case 208 -> -855724451;
                case 209 -> 1671326094;
                case 210 -> -341063062;
                case 211 -> -751033966;
                case 212 -> -89619846;
                case 213 -> -1906395573;
                case 214 -> 1343126416;
                case 215 -> 152965051;
                case 216 -> -43636750;
                case 217 -> 1592680255;
                case 218 -> -1166942260;
                case 219 -> 1727118410;
                case 220 -> 977573156;
                case 221 -> 1994134976;
                case 222 -> -1091405115;
                case 223 -> 1035941820;
                case 224 -> -569270886;
                case 225 -> 1715958024;
                case 226 -> -780300611;
                case 227 -> -1336428405;
                case 228 -> 345256574;
                case 229 -> 1385893111;
                case 230 -> -1745502301;
                case 231 -> 371079446;
                case 232 -> -44007980;
                case 233 -> 938160514;
                case 234 -> 800450277;
                case 235 -> 1896932849;
                case 236 -> -129689367;
                case 237 -> -1863906849;
                case 238 -> -201655076;
                case 239 -> 1731495858;
                case 240 -> 794746882;
                case 241 -> 766872849;
                case 242 -> 669531685;
                case 243 -> -402634272;
                case 244 -> 1505047206;
                case 245 -> -1846107853;
                case 246 -> -1134105741;
                case 247 -> 1635338541;
                case 248 -> -686255693;
                case 249 -> -1733027403;
                case 250 -> 1649758485;
                case 251 -> 999486936;
                case 252 -> 152694437;
                case 253 -> -1852470469;
                case 254 -> 982445879;
                case 255 -> 1684151449;
                default -> 1032925156;
            });
        } while (v2 != 232);
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
            Object[] objectArray = new Object[16];
            v1 = objectArray;
            iOi = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        ConfigSupport_IO0 = 5;
        WatermarkHudElement = 4;
        oii = 3;
        oiI = 2;
        oio = 1;
        oi0 = 1.5f;
        RenderSupport_oio_2 = 256;
        oIi = 12;
        oII = 200;
        oIo = 2000;
    }

    private void iiO() {
        this.ConfigSupport_II0.clear();
        this.RenderSupport_iio_5.clear();
        this.GuiSupport_III.clear();
        this.IIi.clear();
        this.IiO.clear();
        this.Ii0 = 0L;
        this.Iio = 0L;
        this.IiI = -1;
        this.Iii = -1;
        this.Setting = Integer.MIN_VALUE;
        this.RenderSupport_io0_2 = Integer.MIN_VALUE;
        this.iOo = StorageEspModule.ConfigSupport_OI0.world == null ? Long.MIN_VALUE : (long)System.identityHashCode(StorageEspModule.ConfigSupport_OI0.world);
        this.iOI = false;
    }

    @Override
    public void 0oI() {
        this.iiO();
    }

    private int ioi(BlockPos param1, BlockPos param2) {
        int v3 = param1.method_10263() - param2.method_10263();
        int v4 = param1.method_10264() - param2.method_10264();
        int v5 = param1.method_10260() - param2.method_10260();
        return v3 * v3 + v4 * v4 + v5 * v5;
    }

    @Override
    public void ConfigSupport_oi0_2() {
        this.iiO();
    }

    private Color i0o(int param1) {
        return switch (param1) {
            case 1 -> {
                if (((Boolean)this.EnumType_I00.HelpCommand()).booleanValue()) {
                    yield (Color)this.Io0.HelpCommand();
                }
                yield null;
            }
            case 2 -> {
                if (((Boolean)this.I0o.HelpCommand()).booleanValue()) {
                    yield (Color)this.Ioo.HelpCommand();
                }
                yield null;
            }
            case 3 -> {
                if (((Boolean)this.IrcCommand.HelpCommand()).booleanValue()) {
                    yield (Color)this.IoI.HelpCommand();
                }
                yield null;
            }
            case 4 -> {
                if (((Boolean)this.NetworkSupport_i0i_2.HelpCommand()).booleanValue()) {
                    yield (Color)this.Ioi.HelpCommand();
                }
                yield null;
            }
            case 5 -> {
                if (((Boolean)this.IoO.HelpCommand()).booleanValue()) {
                    yield (Color)this.ItemTagsModule.HelpCommand();
                }
                yield null;
            }
            default -> null;
        };
    }

    private int WorldTimeModule() {
        int v1 = 0;
        if (((Boolean)this.EnumType_I00.HelpCommand()).booleanValue()) {
            v1 = 1;
        }
        if (((Boolean)this.I0o.HelpCommand()).booleanValue()) {
            v1 |= 2;
        }
        if (((Boolean)this.IrcCommand.HelpCommand()).booleanValue()) {
            v1 |= 4;
        }
        if (((Boolean)this.NetworkSupport_i0i_2.HelpCommand()).booleanValue()) {
            v1 |= 8;
        }
        if (((Boolean)this.IoO.HelpCommand()).booleanValue()) {
            v1 |= 0x10;
        }
        return v1;
    }

    private void Iii(BlockPos param1, BlockState param2) {
        if (param1 == null) {
            return;
        }
        long v3 = this.ioo(param1.asLong());
        if (param2 == null || param2.method_26215() || !param2.method_26227().isEmpty()) {
            this.ConfigSupport_II0.remove(v3);
            return;
        }
        if (StorageEspModule.ConfigSupport_OI0.world == null) {
            return;
        }
        BlockEntity v5 = StorageEspModule.ConfigSupport_OI0.world.method_8321(param1);
        if (v5 == null) {
            this.ioO(new ChunkPos(param1));
            return;
        }
        int v6 = this.RenderSupport_io0_2(v5, this.WorldTimeModule());
        if (v6 == 0) {
            this.ConfigSupport_II0.remove(v3);
            return;
        }
        this.ConfigSupport_II0.put(v3, new DataRecord_0oi_0(v3, param1.toImmutable(), v6, -1, null));
    }

    private long ioo(long param1) {
        return param1;
    }

    @Override
    public void SpawnerFinderModule() {
        if (StorageEspModule.iooI()) {
            this.iiO();
            return;
        }
        if (this.i0i()) {
            this.iiO();
        }
        this.iOo();
        int v1 = (Integer)this.IOo.HelpCommand();
        int v2 = this.WorldTimeModule();
        BlockPos v3 = StorageEspModule.ConfigSupport_OI0.player.method_24515();
        int v4 = v3.method_10263() >> 4;
        int v5 = v3.method_10260() >> 4;
        if (v1 != this.IiI || v2 != this.Iii) {
            this.IiI = v1;
            this.Iii = v2;
            this.Ii0 = 0L;
            this.GuiSupport_III.clear();
        }
        if (v4 != this.Setting || v5 != this.RenderSupport_io0_2) {
            this.Setting = v4;
            this.RenderSupport_io0_2 = v5;
            if (this.GuiSupport_III.isEmpty()) {
                this.Ii0 = 0L;
            }
        }
        long v6 = System.currentTimeMillis();
        if (this.Ii0 == 0L || v6 - this.Ii0 >= 2000L) {
            this.Ii0 = v6;
            this.RenderSupport_iio_5(v1, v2);
        }
        this.GuiSupport_III(v1, v2);
        this.IiO(v1, v2);
        if (this.Iio == 0L || v6 - this.Iio >= 200L) {
            this.Iio = v6;
            this.Ii0(v1, v2);
        }
        this.Iio(v1, v2);
    }

    private void io0(long param1) {
        this.IIi.add(param1);
    }

    private int RenderSupport_io0_2(BlockEntity param1, int param2) {
        if ((param2 & 1) != 0 && (param1 instanceof ChestBlockEntity || param1 instanceof TrappedChestBlockEntity)) {
            return 1;
        }
        if ((param2 & 2) != 0 && param1 instanceof EnderChestBlockEntity) {
            return 2;
        }
        if ((param2 & 4) != 0 && param1 instanceof ShulkerBoxBlockEntity) {
            return 3;
        }
        if ((param2 & 8) != 0 && param1 instanceof BarrelBlockEntity) {
            return 4;
        }
        if ((param2 & 0x10) != 0 && (param1 instanceof HopperBlockEntity || param1 instanceof DispenserBlockEntity || param1 instanceof DropperBlockEntity || param1 instanceof AbstractFurnaceBlockEntity || param1 instanceof BrewingStandBlockEntity)) {
            return 5;
        }
        return 0;
    }

    private boolean i0I(BlockPos param1) {
        if (StorageEspModule.ConfigSupport_OI0.world == null) {
            return false;
        }
        ChunkPos v2 = new ChunkPos(param1);
        return StorageEspModule.ConfigSupport_OI0.world.getChunkManager().method_12126(v2.x, v2.z, false) != null;
    }

    private void iIi(BufferBuilder param1, MatrixStack.Entry param2, float param3, float param4, float param5, float param6, float param7, float param8, float param9, float param10, float param11, float param12, float param13, float param14, int param15) {
        param1.method_56824(param2, param3, param4, param5).color(param15);
        param1.method_56824(param2, param6, param7, param8).color(param15);
        param1.method_56824(param2, param9, param10, param11).color(param15);
        param1.method_56824(param2, param12, param13, param14).color(param15);
    }

    private void iOI(Entity param1) {
        if (!(param1 instanceof ChestMinecartEntity)) {
            return;
        }
        long v2 = this.NoHurtCamModule(param1.method_5628());
        this.IiO.add(v2);
        this.ConfigSupport_II0.remove(v2);
    }

    private void RenderSupport_iio_5(int param12, int param2) {
        this.ConfigSupport_II0.entrySet().removeIf(param1 -> ((DataRecord_0oi_0)param1.getValue()).Oii == -1 && !this.i0I(((DataRecord_0oi_0)param1.getValue()).Oio));
        if (param2 == 0 || StorageEspModule.ConfigSupport_OI0.world == null || StorageEspModule.ConfigSupport_OI0.player == null) {
            this.RenderSupport_iio_5.clear();
            this.GuiSupport_III.clear();
            return;
        }
        BlockPos v3 = StorageEspModule.ConfigSupport_OI0.player.method_24515();
        int v4 = Math.max(1, param12 + 15 >> 4);
        int v5 = v3.method_10263() >> 4;
        int v6 = v3.method_10260() >> 4;
        this.GuiSupport_III.clear();
        for (int v7 = v5 - v4; v7 <= v5 + v4; ++v7) {
            for (int v8 = v6 - v4; v8 <= v6 + v4; ++v8) {
                this.GuiSupport_III.offer(ChunkPos.toLong((int)v7, (int)v8));
            }
        }
    }

    private double iI0(Vec3d param1, Vec3d param2) {
        double v3 = param1.method_10216() - param2.method_10216();
        double v5 = param1.method_10214() - param2.method_10214();
        double v7 = param1.method_10215() - param2.method_10215();
        return v3 * v3 + v5 * v5 + v7 * v7;
    }

    @EventHandler
    public void RenderSupport_0I0(PacketSendEvent param1) {
        if (StorageEspModule.iooI()) {
            return;
        }
        Packet v2 = param1.PacketEvent();
        if (v2 instanceof BlockUpdateS2CPacket) {
            BlockUpdateS2CPacket v3 = (BlockUpdateS2CPacket)v2;
            this.Iii(v3.getPos(), v3.getState());
        } else {
            v2 = param1.PacketEvent();
            if (v2 instanceof ChunkDeltaUpdateS2CPacket) {
                ChunkDeltaUpdateS2CPacket v4 = (ChunkDeltaUpdateS2CPacket)v2;
                v4.visitUpdates(this::Iii);
            } else {
                v2 = param1.PacketEvent();
                if (v2 instanceof BlockEventS2CPacket) {
                    BlockEventS2CPacket v5 = (BlockEventS2CPacket)v2;
                    this.Setting(v5);
                } else {
                    v2 = param1.PacketEvent();
                    if (v2 instanceof BlockEntityUpdateS2CPacket) {
                        BlockEntityUpdateS2CPacket v6 = (BlockEntityUpdateS2CPacket)v2;
                        this.ioO(new ChunkPos(v6.getPos()));
                    } else {
                        v2 = param1.PacketEvent();
                        if (v2 instanceof ChunkDataS2CPacket) {
                            ChunkDataS2CPacket v7 = (ChunkDataS2CPacket)v2;
                            this.io0(ChunkPos.toLong((int)v7.getChunkX(), (int)v7.getChunkZ()));
                        }
                    }
                }
            }
        }
    }

    public StorageEspModule() {
        super("StorageESP", "Highlights nearby storage block entities.", ModuleCategory.ioO);
        this.IOi = this.OOi00("Fill", true);
        this.DataRecord_I0O = this.OOi00("IgnoreOpened", true);
        this.EnumType_I00 = this.OOi00("Chest", true);
        this.I0o = this.OOi00("EnderChest", true);
        this.IrcCommand = this.OOi00("Shulker", true);
        this.NetworkSupport_i0i_2 = this.OOi00("Barrel", true);
        this.IoO = this.OOi00("Other", true);
        this.Io0 = this.OOioo("ChestColor", 235, 156, 82, 180);
        this.Ioo = this.OOioo("EnderColor", 173, 86, 255, 180);
        this.IoI = this.OOioo("ShulkerColor", 255, 94, 160, 180);
        this.Ioi = this.OOioo("BarrelColor", 170, 111, 66, 180);
        this.ItemTagsModule = this.OOioo("OtherColor", 160, 160, 160, 180);
        this.ConfigSupport_II0 = new ConcurrentHashMap();
        this.RenderSupport_iio_5 = new ArrayList();
        this.GuiSupport_III = new ArrayDeque();
        this.IIi = ConcurrentHashMap.newKeySet();
        this.IiO = ConcurrentHashMap.newKeySet();
        this.Setting = Integer.MIN_VALUE;
        this.RenderSupport_io0_2 = Integer.MIN_VALUE;
        this.iOo = Long.MIN_VALUE;
        this.Io0.00i(param1 -> (Boolean)this.EnumType_I00.HelpCommand());
        this.Ioo.00i(param1 -> (Boolean)this.I0o.HelpCommand());
        this.IoI.00i(param1 -> (Boolean)this.IrcCommand.HelpCommand());
        this.Ioi.00i(param1 -> (Boolean)this.NetworkSupport_i0i_2.HelpCommand());
        this.ItemTagsModule.00i(param1 -> (Boolean)this.IoO.HelpCommand());
    }

    private void iIo(BufferBuilder param1, MatrixStack.Entry param2, DataRecord_0oi_0 param3, Vec3d param4, Color param5) {
        float v6 = (float)(param3.OiI() - param4.method_10216());
        float v7 = (float)(param3.Oii() - param4.method_10214());
        float v8 = (float)(param3.ConfigSupport_0OO() - param4.method_10215());
        float v9 = (float)(param3.DataRecord_0O0() - param4.method_10216());
        float v10 = (float)(param3.0Oo() - param4.method_10214());
        float v11 = (float)(param3.EnumType_0OI() - param4.method_10215());
        this.PotionEffectsHudElement(param1, param2, v6, v7, v8, v9, v10, v11, param5.getRGB());
    }

    private void IiI(MatrixStack param1) {
        Color v9;
        boolean v6;
        BufferBuilder v5;
        Camera v2 = StorageEspModule.ConfigSupport_OI0.gameRenderer.getCamera();
        Vec3d v3 = v2.method_71156();
        MatrixStack.Entry v4 = param1.peek();
        if (((Boolean)this.IOi.HelpCommand()).booleanValue()) {
            v5 = Tessellator.getInstance().begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR);
            v6 = false;
            for (DataRecord_0oi_0 v8 : this.RenderSupport_iio_5) {
                v9 = this.i0o(v8.OiI);
                if (v9 == null) continue;
                this.iIo(v5, v4, v8, v3, this.IoI(v9, Math.min(120, v9.getAlpha() / 2 + 25)));
                v6 = true;
            }
            if (v6) {
                RenderSupport_oiii_5.PacketEvent().draw(v5.end());
            }
        }
        if (((Boolean)this.SprintModule.HelpCommand()).booleanValue()) {
            v5 = Tessellator.getInstance().begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR);
            v6 = false;
            for (DataRecord_0oi_0 v8 : this.RenderSupport_iio_5) {
                v9 = this.i0o(v8.OiI);
                if (v9 == null) continue;
                GuiSupport_oi0o_0.OOIi0(v5, v4, v8.ConfigSupport_0OO != null ? v8.ConfigSupport_0OO : new Box(v8.Oio), v9.getRGB(), 1.5f);
                v6 = true;
            }
            if (v6) {
                RenderSupport_oiii_5.PacketEvent().draw(v5.end());
            }
        }
    }

    private void Setting(BlockEventS2CPacket param1) {
        int v5;
        if (!((Boolean)this.DataRecord_I0O.HelpCommand()).booleanValue() || param1 == null || StorageEspModule.ConfigSupport_OI0.world == null) {
            return;
        }
        BlockPos v2 = param1.getPos();
        if (v2 == null) {
            return;
        }
        BlockEntity v3 = StorageEspModule.ConfigSupport_OI0.world.method_8321(v2);
        if (v3 == null) {
            return;
        }
        if (this.RenderSupport_io0_2(v3, this.WorldTimeModule()) == 0) {
            return;
        }
        int v4 = param1.getType();
        if (this.iOi(v3, v4, v5 = param1.getData())) {
            long v6 = this.ioo(v2.asLong());
            this.IiO.add(v6);
            this.ConfigSupport_II0.remove(v6);
        }
    }

    private void IIi(WorldChunk param1, BlockPos param2, int param32, int param4) {
        HashSet<Long> v5 = new HashSet<Long>();
        for (BlockEntity v7 : param1.getBlockEntities().values()) {
            BlockPos v9;
            int v8 = this.RenderSupport_io0_2(v7, param4);
            if (v8 == 0 || this.ioi(v9 = v7.getPos(), param2) > param32) continue;
            long v10 = this.ioo(v9.asLong());
            v5.add(v10);
            this.ConfigSupport_II0.put(v10, new DataRecord_0oi_0(v10, v9.toImmutable(), v8, -1, null));
        }
        long v12 = param1.method_12004().toLong();
        this.ConfigSupport_II0.entrySet().removeIf(param3 -> ((DataRecord_0oi_0)param3.getValue()).Oii == -1 && new ChunkPos(((DataRecord_0oi_0)param3.getValue()).Oio).toLong() == v12 && !v5.contains(param3.getKey()));
    }

    private long NoHurtCamModule(int param1) {
        return Long.MIN_VALUE + (long)param1;
    }

    private boolean i00(int param1, int param2) {
        return switch (param1) {
            case 1 -> {
                if ((param2 & 1) != 0) {
                    yield true;
                }
                yield false;
            }
            case 2 -> {
                if ((param2 & 2) != 0) {
                    yield true;
                }
                yield false;
            }
            case 3 -> {
                if ((param2 & 4) != 0) {
                    yield true;
                }
                yield false;
            }
            case 4 -> {
                if ((param2 & 8) != 0) {
                    yield true;
                }
                yield false;
            }
            case 5 -> {
                if ((param2 & 0x10) != 0) {
                    yield true;
                }
                yield false;
            }
            default -> false;
        };
    }
}

