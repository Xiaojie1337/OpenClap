/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.VertexFormat$DrawMode
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.Blocks
 *  net.minecraft.client.render.BufferBuilder
 *  net.minecraft.client.render.Camera
 *  net.minecraft.client.render.Tessellator
 *  net.minecraft.client.render.VertexFormats
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.util.math.MatrixStack$Entry
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$Mutable
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.ChunkPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 *  net.minecraft.world.chunk.WorldChunk
 *  org.joml.Vector3fc
 */
package clap.module.render;

import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import java.security.Key;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraft.world.chunk.WorldChunk;
import org.joml.Vector3fc;
import clap.core.module.Module;
import clap.render.RenderSupport_0ooi_1;
import clap.setting.Setting;
import clap.gui.GuiSupport_oi0o_0;
import clap.render.RenderSupport_oiii_5;
import clap.core.module.ModuleCategory;
import clap.model.DataRecord_oioi_3;
import clap.event.network.PacketSendEvent;
import clap.config.ConfigSupport_ooo0_1;
import clap.event.EventHandler;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from psx.Hyk.i0I
 */
public class OreEspModule
extends Module {
    private final Setting ConfigSupport_0oo0_1;
    private final Setting RenderSupport_0ooo_1;
    private final Setting io0;
    private final Map 0ooI;
    private final Setting 0oOI;
    private final Setting 0oO0;
    private final Setting 0o0i;
    private final Map 0oIO;
    private final Setting ioO = this.OOi0o("Range", 32, 8, 96);
    private final Setting 0o0o;
    private final Setting 0oOi;
    private int 0ooi = -1;
    private Thread iIi;
    private int Iii = -1;
    private static final Map 0oOO;
    private final Setting NameTagsModule;
    private final Setting 0ooo;
    private long PotionEffectsHudElement;
    private final Setting ioi;
    private final Set 0oI0;
    private final Setting 0oOo;
    private final Setting ConfigSupport_0o0o_1;
    private final Setting StreamproofLogger;
    private volatile boolean iiO;
    static Object 0oIo;

    private void FontRenderer() {
        this.iiO = false;
        if (this.iIi != null && this.iIi.isAlive()) {
            this.iIi.interrupt();
        }
        this.iIi = null;
    }

    private void oi0o(int param1, int param2) {
        this.FontRenderer();
        this.iiO = true;
        this.iIi = new Thread(() -> {
            try {
                ClientWorld v3 = OreEspModule.ConfigSupport_OI0.world;
                if (v3 == null || OreEspModule.ConfigSupport_OI0.player == null) {
                    return;
                }
                BlockPos v4 = OreEspModule.ConfigSupport_OI0.player.method_24515();
                int v5 = v4.method_10263() >> 4;
                int v6 = v4.method_10260() >> 4;
                int v7 = param1 + 15 >> 4;
                int v8 = param1 * param1;
                ArrayList<ChunkPos> v9 = new ArrayList<ChunkPos>();
                for (int v10 = v5 - v7; v10 <= v5 + v7; ++v10) {
                    for (int v11 = v6 - v7; v11 <= v6 + v7; ++v11) {
                        v9.add(new ChunkPos(v10, v11));
                    }
                }
                v9.sort(Comparator.comparingInt(param2 -> {
                    int v3 = param2.x - v5;
                    int v4 = param2.z - v6;
                    return v3 * v3 + v4 * v4;
                }));
                for (ChunkPos v11 : v9) {
                    if (Thread.currentThread().isInterrupted() || !this.iiO) {
                        return;
                    }
                    if (OreEspModule.ConfigSupport_OI0.world != v3) {
                        return;
                    }
                    WorldChunk v12 = v3.method_8398().getWorldChunk(v11.x, v11.z, false);
                    if (v12 != null) {
                        Map v13 = this.oi0i((World)v3, v12, v4, v8, param2);
                        this.0ooI.putAll(v13);
                    }
                    Thread.sleep(2L);
                }
            }
            finally {
                this.iiO = false;
            }
        }, "OreESP-Scanner");
        this.iIi.setDaemon(true);
        this.iIi.start();
    }

    @Override
    public void 0oI() {
        this.0ooI.clear();
        this.0oI0.clear();
        this.0ooi = -1;
        this.Iii = -1;
        this.PotionEffectsHudElement = 0L;
        this.FontRenderer();
    }

    private boolean oiIO(Block param1, int param2) {
        if (param1 == Blocks.COAL_ORE || param1 == Blocks.DEEPSLATE_COAL_ORE) {
            return (param2 & 1) != 0;
        }
        if (param1 == Blocks.COPPER_ORE || param1 == Blocks.DEEPSLATE_COPPER_ORE) {
            return (param2 & 2) != 0;
        }
        if (param1 == Blocks.IRON_ORE || param1 == Blocks.DEEPSLATE_IRON_ORE) {
            return (param2 & 4) != 0;
        }
        if (param1 == Blocks.GOLD_ORE || param1 == Blocks.DEEPSLATE_GOLD_ORE) {
            return (param2 & 8) != 0;
        }
        if (param1 == Blocks.REDSTONE_ORE || param1 == Blocks.DEEPSLATE_REDSTONE_ORE) {
            return (param2 & 0x10) != 0;
        }
        if (param1 == Blocks.EMERALD_ORE || param1 == Blocks.DEEPSLATE_EMERALD_ORE) {
            return (param2 & 0x20) != 0;
        }
        if (param1 == Blocks.LAPIS_ORE || param1 == Blocks.DEEPSLATE_LAPIS_ORE) {
            return (param2 & 0x40) != 0;
        }
        if (param1 == Blocks.DIAMOND_ORE || param1 == Blocks.DEEPSLATE_DIAMOND_ORE) {
            return (param2 & 0x80) != 0;
        }
        return false;
    }

    private double oioo(BlockPos param1, Vec3d param2) {
        double v3 = (double)param1.method_10263() + 0.5 - param2.method_10216();
        double v5 = (double)param1.method_10264() + 0.5 - param2.method_10214();
        double v7 = (double)param1.method_10260() + 0.5 - param2.method_10215();
        return v3 * v3 + v5 * v5 + v7 * v7;
    }

    private boolean oio0(Block param1) {
        return this.oiIO(param1, this.WorldTimeModule());
    }

    private void oioO(MatrixStack param1) {
        Camera v2 = OreEspModule.ConfigSupport_OI0.gameRenderer.getCamera();
        Vec3d v3 = v2.method_71156();
        Vec3d v4 = this.oiIo(v2);
        MatrixStack.Entry v5 = param1.peek();
        Vec3d v6 = OreEspModule.ConfigSupport_OI0.player.method_73189();
        double v7 = (Integer)this.ioO.HelpCommand() * (Integer)this.ioO.HelpCommand();
        ArrayList<DataRecord_oioi_3> v9 = new ArrayList<DataRecord_oioi_3>();
        for (DataRecord_oioi_3 v11 : this.0ooI.values()) {
            if (!this.oio0(v11.OOoO) || !(this.oioo(v11.Oio, v6) <= v7)) continue;
            v9.add(v11);
        }
        v9.sort(Comparator.comparingDouble(param2 -> this.oioo(param2.Oio, v6)));
        BufferBuilder v10 = Tessellator.getInstance().begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR);
        int v11 = 0;
        boolean v12 = false;
        for (DataRecord_oioi_3 v14 : v9) {
            if (v11 >= (Integer)this.0oO0.HelpCommand()) break;
            if (this.oioI(v14.Oio)) {
                this.oioi(v14.Oio.asLong());
                continue;
            }
            Color v15 = v14.EventHandler;
            GuiSupport_oi0o_0.OOIi0(v10, v5, new Box(v14.Oio), this.IoI(v15, (Integer)this.ioi.HelpCommand()).getRGB(), ((Float)this.0oOo.HelpCommand()).floatValue());
            v12 = true;
            ++v11;
        }
        if (v12) {
            RenderSupport_oiii_5.PacketEvent().draw(v10.end());
        }
        if (!((Boolean)this.0oOI.HelpCommand()).booleanValue()) {
            return;
        }
        BufferBuilder v13 = Tessellator.getInstance().begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR);
        boolean v14 = false;
        v11 = 0;
        for (DataRecord_oioi_3 v16 : v9) {
            if (v11 >= (Integer)this.0oO0.HelpCommand()) break;
            if (this.oioI(v16.Oio)) continue;
            Vec3d v17 = Vec3d.ofCenter((Vec3i)v16.Oio).subtract(v3);
            v14 |= this.oiII(v13, v5, v4, v17, this.IoI(v16.EventHandler, (Integer)this.ioi.HelpCommand()).getRGB(), this.oiI0());
            ++v11;
        }
        if (v14) {
            RenderSupport_oiii_5.PacketEvent().draw(v13.end());
        }
    }

    @Override
    public void ConfigSupport_II0(RenderSupport_0ooi_1 param1) {
        if (OreEspModule.iooI() || this.0ooI.isEmpty()) {
            return;
        }
        this.oioO(param1.0ii());
    }

    @Override
    public void SpawnerFinderModule() {
        if (OreEspModule.iooI()) {
            this.0ooI.clear();
            this.0oI0.clear();
            this.0oIO.clear();
            this.PotionEffectsHudElement = 0L;
            this.FontRenderer();
            return;
        }
        int v1 = (Integer)this.ioO.HelpCommand();
        int v2 = this.WorldTimeModule();
        if (v1 != this.0ooi || v2 != this.Iii) {
            this.0ooi = v1;
            this.Iii = v2;
            this.PotionEffectsHudElement = 0L;
        }
        this.oi0I(v2);
        long v3 = System.currentTimeMillis();
        if (!(this.iiO || this.PotionEffectsHudElement != 0L && v3 - this.PotionEffectsHudElement < (long)((Integer)this.io0.HelpCommand()).intValue())) {
            this.PotionEffectsHudElement = v3;
            this.oi0o(v1, v2);
        }
    }

    private Map oi0i(World param1, WorldChunk param2, BlockPos param3, int param4, int param5) {
        HashMap<Long, DataRecord_oioi_3> v6 = new HashMap<Long, DataRecord_oioi_3>();
        int v7 = param1.method_31607();
        int v8 = param1.method_31600() - 1;
        int v9 = param2.method_12004().getStartX();
        int v10 = param2.method_12004().getStartZ();
        BlockPos.Mutable v11 = new BlockPos.Mutable();
        for (int v12 = v9; v12 < v9 + 16; ++v12) {
            int v13 = v12 - param3.method_10263();
            for (int v14 = v10; v14 < v10 + 16; ++v14) {
                int v15 = v14 - param3.method_10260();
                if (v13 * v13 + v15 * v15 > param4) continue;
                for (int v16 = v7; v16 <= v8; ++v16) {
                    int v17 = v16 - param3.method_10264();
                    if (v13 * v13 + v17 * v17 + v15 * v15 > param4) continue;
                    v11.set(v12, v16, v14);
                    Block v18 = param2.method_8320((BlockPos)v11).method_26204();
                    Color v19 = (Color)0oOO.get(v18);
                    if (v19 == null || !this.oiIO(v18, param5) || this.0oI0.contains(v11.method_10063())) continue;
                    BlockPos v20 = v11.method_10062();
                    v6.put(v20.asLong(), new DataRecord_oioi_3(v20, v18, v19));
                }
            }
        }
        return v6;
    }

    private Color IoI(Color param1, int param2) {
        return new Color(param1.getRed(), param1.getGreen(), param1.getBlue(), Math.max(0, Math.min(255, param2)));
    }

    @EventHandler
    public void RenderSupport_0I0(PacketSendEvent param1) {
        if (OreEspModule.iooI()) {
            return;
        }
        ConfigSupport_ooo0_1.PacketEvent(param1, this::Iii, this.0oIO);
    }

    private static void oiiO(Map param0, int param1, Block ... param2) {
        Color v3 = new Color(param1, true);
        for (Block v7 : param2) {
            param0.put(v7, v3);
        }
    }

    private static Map oiIi() {
        HashMap v0 = new HashMap();
        OreEspModule.oiiO(v0, -13355980, Blocks.COAL_ORE, Blocks.DEEPSLATE_COAL_ORE);
        OreEspModule.oiiO(v0, -29878, Blocks.COPPER_ORE, Blocks.DEEPSLATE_COPPER_ORE);
        OreEspModule.oiiO(v0, -2576246, Blocks.IRON_ORE, Blocks.DEEPSLATE_IRON_ORE);
        OreEspModule.oiiO(v0, -10163, Blocks.GOLD_ORE, Blocks.DEEPSLATE_GOLD_ORE);
        OreEspModule.oiiO(v0, -54742, Blocks.REDSTONE_ORE, Blocks.DEEPSLATE_REDSTONE_ORE);
        OreEspModule.oiiO(v0, -13959302, Blocks.EMERALD_ORE, Blocks.DEEPSLATE_EMERALD_ORE);
        OreEspModule.oiiO(v0, -13541889, Blocks.LAPIS_ORE, Blocks.DEEPSLATE_LAPIS_ORE);
        OreEspModule.oiiO(v0, -10487553, Blocks.DIAMOND_ORE, Blocks.DEEPSLATE_DIAMOND_ORE);
        return v0;
    }

    private boolean oiII(BufferBuilder param1, MatrixStack.Entry param2, Vec3d param3, Vec3d param4, int param5, float param6) {
        Vec3d v7 = param4.subtract(param3);
        if (v7.lengthSquared() < 1.0E-6) {
            return false;
        }
        Vec3d v8 = v7.crossProduct(new Vec3d(0.0, 1.0, 0.0));
        if (v8.lengthSquared() < 1.0E-6) {
            v8 = v7.crossProduct(new Vec3d(1.0, 0.0, 0.0));
        }
        v8 = v8.normalize().multiply((double)param6);
        this.iIi(param1, param2, (float)(param3.x - v8.x), (float)(param3.y - v8.y), (float)(param3.z - v8.z), (float)(param3.x + v8.x), (float)(param3.y + v8.y), (float)(param3.z + v8.z), (float)(param4.x + v8.x), (float)(param4.y + v8.y), (float)(param4.z + v8.z), (float)(param4.x - v8.x), (float)(param4.y - v8.y), (float)(param4.z - v8.z), param5);
        return true;
    }

    static {
        byte[] v0 = "\u00f8\u0087b\u00c0 \u008d\u00f1\u00c8\u00e0g\n\u0012\u000e\u00b2\u00b3\u009a\u0095?bK\u0087\u00b1\u00c6\u00bc<1\u00f2d\u009d,s\u001e\u00f7\u00fd\u00e27\u0095\u0007\u00863\u000f\"\u00cb\u0013&\u0011\u00c7CK\u008b\u009e\u0011\u00b7N\u00c9E\u00d4\u0017\u00a3\u0091\u00f6\u0098\u00c8'\u0093\u00e0u\u00db\u0096\u000e\u0014xQ\u00e7Hh_>\u0012\u00c3_\u00b5\u00ec\u0093\u00b7\u00c7r632TNV_\u0094\u00ed\u00fc\u00fc\u00d2H\u0086{]h\u00eaI\u000f<g\u00aa\u009d$8\u00ce\u00d6\u00a7\u00ca\u008e*\u00a8\u00e9\u00fc(>\u0087\u009e^\u00cf\u0086\u0004\u00b0\u00a5R\u001bid\u0000p>\u00a9\u00c39\u0081\u00d5\u00cd\u00e5fa#\b\u0003\u00ba\u00a4\u00db\u00ea\u0091SV\u000b4\u00c3\u00dbT\u0086}\u0095\u0018m\u00bfr\u00bb\u00a9Z\u001e\u00fe\u0090\u001d\u009e\u00c1\u00e8cs,\u00c9\u0006\u00d4\u00ed\u00b2\"\u0010\u00a0\u007fI\u00aeH\u00c6$\u00861\u00dar\u00d6o\u00e2\u00ba\u00c3\u00a134\u00e3r\u00e2S\u0007j9\u0085/\u0083D\u00f5\u00e3 \u001eB\u0013\u0083\fq\u00af\u00d3\u001e".getBytes("ISO_8859_1");
        Object[] v1 = "\u00c2\u00a1fY\t\u008d\u00dd\n".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 353574957;
                case 1 -> -23284826;
                case 2 -> -660459063;
                case 3 -> -1376913292;
                case 4 -> 567735184;
                case 5 -> -1666180498;
                case 6 -> 335916843;
                case 7 -> -1651729846;
                case 8 -> 950351442;
                case 9 -> 1876412198;
                case 10 -> -1647135355;
                case 11 -> 639761077;
                case 12 -> 943867586;
                case 13 -> 120605281;
                case 14 -> 682759876;
                case 15 -> 1660373819;
                case 16 -> -1354104527;
                case 17 -> -2134277267;
                case 18 -> 327780108;
                case 19 -> 191107457;
                case 20 -> -2083029580;
                case 21 -> -646525185;
                case 22 -> -723272;
                case 23 -> -401231062;
                case 24 -> -367666634;
                case 25 -> -160117431;
                case 26 -> -1184750286;
                case 27 -> -775969772;
                case 28 -> 1544131482;
                case 29 -> -662011527;
                case 30 -> 692488142;
                case 31 -> -68827869;
                case 32 -> 267644766;
                case 33 -> 1150315902;
                case 34 -> 367243382;
                case 35 -> 1532626515;
                case 36 -> -1398243947;
                case 37 -> -2136872245;
                case 38 -> 361681091;
                case 39 -> -1541313551;
                case 40 -> -1102663155;
                case 41 -> 1827271505;
                case 42 -> 749996763;
                case 43 -> -452724194;
                case 44 -> 541598242;
                case 45 -> -1405220379;
                case 46 -> -1323919665;
                case 47 -> 592327376;
                case 48 -> 1173740639;
                case 49 -> 147779599;
                case 50 -> 1163595324;
                case 51 -> 1854017708;
                case 52 -> -161617694;
                case 53 -> 492860734;
                case 54 -> -1929817214;
                case 55 -> -853487794;
                case 56 -> -821298664;
                case 57 -> 955676512;
                case 58 -> -561523053;
                case 59 -> -1332358591;
                case 60 -> 794216174;
                case 61 -> -1292447864;
                case 62 -> 19548834;
                case 63 -> -1847691960;
                case 64 -> 793088685;
                case 65 -> -1918568039;
                case 66 -> 1980369153;
                case 67 -> 705804521;
                case 68 -> -14159236;
                case 69 -> 2111142223;
                case 70 -> 6200701;
                case 71 -> -727322603;
                case 72 -> -1439445246;
                case 73 -> -1241225079;
                case 74 -> -504281328;
                case 75 -> -327026327;
                case 76 -> 1159468950;
                case 77 -> 970697539;
                case 78 -> 1869511563;
                case 79 -> -204824813;
                case 80 -> 1138017950;
                case 81 -> -353717878;
                case 82 -> 1401199098;
                case 83 -> -1741413151;
                case 84 -> 501161500;
                case 85 -> -384119128;
                case 86 -> -1308663287;
                case 87 -> -441765728;
                case 88 -> -926727491;
                case 89 -> -1769439669;
                case 90 -> -1056704277;
                case 91 -> 1722255024;
                case 92 -> -2096462457;
                case 93 -> 1880829190;
                case 94 -> -964074762;
                case 95 -> 1873689093;
                case 96 -> 828385056;
                case 97 -> -1346744283;
                case 98 -> 1600511679;
                case 99 -> 967863026;
                case 100 -> 1370770217;
                case 101 -> 462942241;
                case 102 -> -1140227673;
                case 103 -> -934373533;
                case 104 -> -1885903923;
                case 105 -> -1661606905;
                case 106 -> 159576021;
                case 107 -> 1691886135;
                case 108 -> -4037325;
                case 109 -> -380866820;
                case 110 -> -2081217083;
                case 111 -> -396255989;
                case 112 -> 1226993350;
                case 113 -> 940436085;
                case 114 -> -295589235;
                case 115 -> 1304682968;
                case 116 -> -1106982819;
                case 117 -> 1185728778;
                case 118 -> 590516641;
                case 119 -> 1795235520;
                case 120 -> -93693484;
                case 121 -> -1186591996;
                case 122 -> -1533792348;
                case 123 -> 262955932;
                case 124 -> -1017642632;
                case 125 -> -1180442175;
                case 126 -> 223506295;
                case 127 -> -1631372673;
                case 128 -> 7041235;
                case 129 -> -445562434;
                case 130 -> -858123112;
                case 131 -> 87059504;
                case 132 -> 55730517;
                case 133 -> -1867478723;
                case 134 -> 85356795;
                case 135 -> 1445593895;
                case 136 -> 1379690842;
                case 137 -> -669746440;
                case 138 -> -1032304571;
                case 139 -> 2064388570;
                case 140 -> -1589793313;
                case 141 -> 1224483392;
                case 142 -> 907867931;
                case 143 -> 410316533;
                case 144 -> 85666137;
                case 145 -> 667390852;
                case 146 -> 1945700535;
                case 147 -> -713109212;
                case 148 -> 106918256;
                case 149 -> -767267311;
                case 150 -> 1532613919;
                case 151 -> -1891756643;
                case 152 -> -1876881777;
                case 153 -> -263283826;
                case 154 -> 1665524906;
                case 155 -> 560627765;
                case 156 -> -1596862137;
                case 157 -> 968017594;
                case 158 -> -1367599385;
                case 159 -> 1888309006;
                case 160 -> -1493118045;
                case 161 -> -2094699316;
                case 162 -> -129116696;
                case 163 -> 1635058198;
                case 164 -> -160501089;
                case 165 -> -1912957388;
                case 166 -> 210820807;
                case 167 -> -1337259537;
                case 168 -> 1299186169;
                case 169 -> 477597625;
                case 170 -> -978756354;
                case 171 -> -424224787;
                case 172 -> -443483694;
                case 173 -> 5844146;
                case 174 -> 880105200;
                case 175 -> 2000487004;
                case 176 -> -1759645895;
                case 177 -> -4295122;
                case 178 -> 451854058;
                case 179 -> -1413451162;
                case 180 -> -1549235031;
                case 181 -> 1599132772;
                case 182 -> 1139385847;
                case 183 -> 955696780;
                case 184 -> 1650085964;
                case 185 -> -864027384;
                case 186 -> 1151878232;
                case 187 -> -134191337;
                case 188 -> 1206643796;
                case 189 -> 154749940;
                case 190 -> -1604910953;
                case 191 -> 1164444957;
                case 192 -> 1036868267;
                case 193 -> -1327020086;
                case 194 -> 639536402;
                case 195 -> -1999346843;
                case 196 -> 1990239023;
                case 197 -> 1577024221;
                case 198 -> 1218103174;
                case 199 -> 1576186938;
                case 200 -> -1813812116;
                case 201 -> 1563549918;
                case 202 -> 1835596531;
                case 203 -> 483325841;
                case 204 -> 264352945;
                case 205 -> -2001828521;
                case 206 -> 627617391;
                case 207 -> 691208748;
                case 208 -> 684612377;
                case 209 -> 1076573042;
                case 210 -> 2121670097;
                case 211 -> -2063846088;
                case 212 -> -1710986416;
                case 213 -> 849095546;
                case 214 -> 1310064018;
                case 215 -> -605875341;
                case 216 -> -230803609;
                case 217 -> -1573890129;
                case 218 -> 1442725123;
                case 219 -> 1328486332;
                case 220 -> -2122468677;
                case 221 -> 1397912576;
                case 222 -> 1608505824;
                case 223 -> 277126507;
                case 224 -> 1379120003;
                case 225 -> -1451877350;
                case 226 -> 294776644;
                case 227 -> -1281246484;
                case 228 -> 661256406;
                case 229 -> -644829824;
                case 230 -> -167860632;
                case 231 -> -1833287003;
                case 232 -> -930213057;
                case 233 -> 797669593;
                case 234 -> 2117514678;
                case 235 -> -1351455544;
                case 236 -> 786017763;
                case 237 -> 1526578140;
                case 238 -> 152595818;
                case 239 -> -696596332;
                case 240 -> 1094102363;
                case 241 -> -1789772218;
                case 242 -> 188987249;
                case 243 -> 482836802;
                case 244 -> 1749305518;
                case 245 -> 1365620091;
                case 246 -> 2095340723;
                case 247 -> -293071145;
                case 248 -> 1057749403;
                case 249 -> 1877483748;
                case 250 -> -1016035866;
                case 251 -> 681837389;
                case 252 -> 1011082237;
                case 253 -> -1382230186;
                case 254 -> 1796297768;
                case 255 -> 416550242;
                default -> 1173237943;
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
            Object[] objectArray = new Object[18];
            v1 = objectArray;
            0oIo = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        0oOO = OreEspModule.oiIi();
    }

    private float oiI0() {
        return Math.max(0.002f, Math.min(0.06f, ((Float)this.0oOi.HelpCommand()).floatValue() * 0.008f));
    }

    public OreEspModule() {
        super("OreESP", "Highlights overworld ores around you.", ModuleCategory.ioO);
        this.io0 = this.OOi0o("ScanDelay", 1000, 100, 5000);
        this.0oO0 = this.OOi0o("MaxRender", 1024, 64, 4096);
        this.0oOo = this.OOi0o("LineWidth", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(4.0f));
        this.0oOI = this.OOi00("Tracers", true);
        this.0oOi = this.OOi0o("TracerWidth", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(4.0f));
        this.ioi = this.OOi0o("Alpha", 210, 40, 255);
        this.ConfigSupport_0o0o_1 = this.OOi00("Coal", true);
        this.NameTagsModule = this.OOi00("Copper", true);
        this.0o0o = this.OOi00("Iron", true);
        this.StreamproofLogger = this.OOi00("Gold", true);
        this.0o0i = this.OOi00("Redstone", true);
        this.RenderSupport_0ooo_1 = this.OOi00("Emerald", true);
        this.ConfigSupport_0oo0_1 = this.OOi00("Lapis", true);
        this.0ooo = this.OOi00("Diamond", true);
        this.0ooI = new ConcurrentHashMap();
        this.0oIO = new ConcurrentHashMap();
        this.0oI0 = ConcurrentHashMap.newKeySet();
    }

    private void oioi(long param1) {
        if (this.0ooI.remove(param1) != null) {
            this.0oI0.add(param1);
        }
    }

    private void oi0I(int param1) {
        if (this.0oIO.isEmpty()) {
            return;
        }
        ClientWorld v2 = OreEspModule.ConfigSupport_OI0.world;
        if (v2 == null || OreEspModule.ConfigSupport_OI0.player == null) {
            return;
        }
        BlockPos v3 = OreEspModule.ConfigSupport_OI0.player.method_24515();
        int v4 = (Integer)this.ioO.HelpCommand() * (Integer)this.ioO.HelpCommand();
        for (Map.Entry entry : this.0oIO.entrySet()) {
            int v7 = (Integer)entry.getValue();
            if (v7 > 0) {
                entry.setValue(v7 - 1);
                continue;
            }
            long v8 = (Long)entry.getKey();
            WorldChunk v10 = v2.method_8398().getWorldChunk(ChunkPos.getPackedX((long)v8), ChunkPos.getPackedZ((long)v8), false);
            if (v10 == null) continue;
            this.0ooI.putAll(this.oi0i((World)v2, v10, v3, v4, param1));
            this.0oIO.remove(v8);
        }
    }

    private boolean oioI(BlockPos param1) {
        if (OreEspModule.ConfigSupport_OI0.world == null) {
            return false;
        }
        BlockState v2 = OreEspModule.ConfigSupport_OI0.world.method_8320(param1);
        return v2.method_26215() || !v2.method_26227().isEmpty();
    }

    private void Iii(BlockPos param1, BlockState param2) {
        if (param1 == null || param2 == null) {
            return;
        }
        long v3 = param1.asLong();
        if (param2.method_26215() || !param2.method_26227().isEmpty()) {
            this.oioi(v3);
            return;
        }
        Block v5 = param2.method_26204();
        Color v6 = (Color)0oOO.get(v5);
        if (v6 != null && this.oio0(v5) && !this.0oI0.contains(v3)) {
            this.0ooI.put(v3, new DataRecord_oioi_3(param1.toImmutable(), v5, v6));
        }
    }

    private int WorldTimeModule() {
        int v1 = 0;
        if (((Boolean)this.ConfigSupport_0o0o_1.HelpCommand()).booleanValue()) {
            v1 = 1;
        }
        if (((Boolean)this.NameTagsModule.HelpCommand()).booleanValue()) {
            v1 |= 2;
        }
        if (((Boolean)this.0o0o.HelpCommand()).booleanValue()) {
            v1 |= 4;
        }
        if (((Boolean)this.StreamproofLogger.HelpCommand()).booleanValue()) {
            v1 |= 8;
        }
        if (((Boolean)this.0o0i.HelpCommand()).booleanValue()) {
            v1 |= 0x10;
        }
        if (((Boolean)this.RenderSupport_0ooo_1.HelpCommand()).booleanValue()) {
            v1 |= 0x20;
        }
        if (((Boolean)this.ConfigSupport_0oo0_1.HelpCommand()).booleanValue()) {
            v1 |= 0x40;
        }
        if (((Boolean)this.0ooo.HelpCommand()).booleanValue()) {
            v1 |= 0x80;
        }
        return v1;
    }

    private Vec3d oiIo(Camera param1) {
        Vector3fc v2 = param1.getHorizontalPlane();
        return new Vec3d((double)v2.x(), (double)v2.y(), (double)v2.z()).multiply(0.35);
    }

    private void iIi(BufferBuilder param1, MatrixStack.Entry param2, float param3, float param4, float param5, float param6, float param7, float param8, float param9, float param10, float param11, float param12, float param13, float param14, int param15) {
        param1.method_56824(param2, param3, param4, param5).color(param15);
        param1.method_56824(param2, param6, param7, param8).color(param15);
        param1.method_56824(param2, param9, param10, param11).color(param15);
        param1.method_56824(param2, param12, param13, param14).color(param15);
    }
}

