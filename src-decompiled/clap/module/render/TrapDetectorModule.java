/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.AbstractSignBlock
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.Blocks
 *  net.minecraft.block.PistonBlock
 *  net.minecraft.block.PistonExtensionBlock
 *  net.minecraft.block.PistonHeadBlock
 *  net.minecraft.block.WallSignBlock
 *  net.minecraft.block.enums.PistonType
 *  net.minecraft.client.gl.RenderPipelines
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.s2c.play.BlockUpdateS2CPacket
 *  net.minecraft.network.packet.s2c.play.ChunkDataS2CPacket
 *  net.minecraft.network.packet.s2c.play.ChunkDeltaUpdateS2CPacket
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.state.property.Properties
 *  net.minecraft.state.property.Property
 *  net.minecraft.util.Identifier
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$Mutable
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Direction$Type
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.Heightmap$Type
 *  net.minecraft.world.World
 *  net.minecraft.world.chunk.WorldChunk
 *  org.joml.Vector3f
 */
package clap.module.render;

import java.awt.Color;
import java.security.Key;
import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
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
import net.minecraft.block.AbstractSignBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PistonBlock;
import net.minecraft.block.PistonExtensionBlock;
import net.minecraft.block.PistonHeadBlock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.enums.PistonType;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.ChunkDataS2CPacket;
import net.minecraft.network.packet.s2c.play.ChunkDeltaUpdateS2CPacket;
import net.minecraft.registry.RegistryKey;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import net.minecraft.world.chunk.WorldChunk;
import org.joml.Vector3f;
import clap.network.NetworkSupport_00OI;
import clap.model.EnumType_O00I;
import clap.render.FontRenderer;
import clap.model.DataRecord_OOI0;
import clap.core.module.Module;
import clap.model.DataRecord_0o0o_2;
import clap.render.RenderSupport_0ooi_1;
import clap.setting.Setting;
import clap.gui.GuiSupport_oi0o_0;
import clap.render.RenderSupport_oiio_4;
import clap.core.module.ModuleCategory;
import clap.event.network.PacketSendEvent;
import clap.render.ScaledDrawContext;
import clap.event.EventHandler;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from psx.Hyk.IOo
 */
public class TrapDetectorModule
extends Module {
    private final Setting OiiO;
    private final Setting Oii0;
    private static final int i00;
    private volatile Thread iIi;
    private static final int ConfigSupport_oii0_1;
    private volatile boolean iiO;
    private static final float Oioi;
    private final Setting Oiio;
    private final Set IIi;
    private static final int OioO;
    private final Setting OiII;
    private static final int Oi0i;
    private final Setting OiIo;
    private static final float Oioo;
    private static final float NetworkSupport_oioi_6;
    private final Setting ioO = this.OOi0o("Range", 64, 16, 128);
    private final Setting RenderSupport_oiii_5;
    private final Map OiiI;
    private RegistryKey iIo;
    private static final Identifier Oio0;
    private static final int OiIO;
    private final Setting io0 = this.OOi0o("ScanDelay", 2, 1, 15).ConfigSupport_00o_0("s");
    private long PotionEffectsHudElement;
    static Object Oiii;
    private static volatile /* synthetic */ long __k__gH4it;
    private static /* synthetic */ String[] __p__gH4it;
    private static /* synthetic */ Object[][] __c__J7Um6;

    private void SettingContainer() {
        this.OiiI.clear();
        this.IIi.clear();
        this.iIo = TrapDetectorModule.ConfigSupport_OI0.world == null ? null : TrapDetectorModule.ConfigSupport_OI0.world.method_27983();
        this.PotionEffectsHudElement = 0L;
    }

    private void OOoI() {
        this.FontRenderer();
        this.iIo = null;
        this.OiiI.clear();
        this.IIi.clear();
    }

    private boolean 0iiI(DataRecord_0o0o_2 param1, DataRecord_0o0o_2 param2) {
        return Math.abs(param1.ConfigSupport_oooi_3.method_10263() - param2.ConfigSupport_oooi_3.method_10263()) <= 5 && Math.abs(param1.ConfigSupport_oooi_3.method_10260() - param2.ConfigSupport_oooi_3.method_10260()) <= 5 && Math.abs(param1.ConfigSupport_oooi_3.method_10264() - param2.ConfigSupport_oooi_3.method_10264()) <= 8;
    }

    private void oOO0(BlockPos param1) {
        if (param1 == null) {
            return;
        }
        this.IIi.add(BlockPos.asLong((int)(param1.method_10263() >> 4), (int)0, (int)(param1.method_10260() >> 4)));
    }

    @EventHandler
    public void RenderSupport_0I0(PacketSendEvent param12) {
        if (TrapDetectorModule.iooI()) {
            return;
        }
        Packet v2 = param12.PacketEvent();
        if (v2 instanceof BlockUpdateS2CPacket) {
            BlockUpdateS2CPacket v3 = (BlockUpdateS2CPacket)v2;
            this.oOO0(v3.getPos());
        } else {
            v2 = param12.PacketEvent();
            if (v2 instanceof ChunkDeltaUpdateS2CPacket) {
                ChunkDeltaUpdateS2CPacket v4 = (ChunkDeltaUpdateS2CPacket)v2;
                v4.visitUpdates((param1, param2) -> this.oOO0((BlockPos)param1));
            } else {
                v2 = param12.PacketEvent();
                if (v2 instanceof ChunkDataS2CPacket) {
                    ChunkDataS2CPacket v5 = (ChunkDataS2CPacket)v2;
                    this.IIi.add(BlockPos.asLong((int)v5.getChunkX(), (int)0, (int)v5.getChunkZ()));
                }
            }
        }
    }

    private void FontRenderer() {
        this.iiO = false;
        if (this.iIi != null && this.iIi.isAlive()) {
            this.iIi.interrupt();
        }
        this.iIi = null;
    }

    private void 0iii(ScaledDrawContext param1, float param2, float param3, double param4) {
        float v6 = ((Double)this.RenderSupport_oiii_5.HelpCommand()).floatValue();
        int v7 = Math.max(8, Math.round(24.0f * v6));
        float v8 = param2 - (float)v7 / 2.0f;
        float v9 = param3 - (float)v7 / 2.0f - 6.0f;
        param1.ConfigSupport_O0I().getMatrices().pushMatrix();
        param1.ConfigSupport_O0I().getMatrices().translate(v8, v9);
        param1.ConfigSupport_O0I().drawTexture(RenderPipelines.GUI_TEXTURED, Oio0, 0, 0, 0.0f, 0.0f, v7, v7, v7, v7);
        param1.ConfigSupport_O0I().getMatrices().popMatrix();
        if (((Boolean)this.OiiO.HelpCommand()).booleanValue()) {
            this.oOOO(param1, param2, v9 + (float)v7 + 2.0f, param4);
        }
    }

    static {
        __k__gH4it = TrapDetectorModule.__k__gH4it(1225571072930213393L);
        __rP__gH4it0 = new String[]{"\u4533\u6dc1\ub31e\ue683\u61db\ubb7e\ub444\ub101\u443f\u6cd7\ub216\ue7f7\u60a5\uba64\ub76e\ub242\u4703\u6ffd\ub133\ue4fb", "\u4535\u6ddf\ub31d\ue68e\u61db\ubb3a\ub5c0"};
        __rP__gH4it1 = new String[]{"\u459e\u6de9\ub370\ue694\u6178\ubb8d\ub465\ub166", "\u4527\u6dcc\ub31b\ue6f4\u61a9\ubb0f\ub43b\ub118\u4439\u6ca6", "\u4525\u6dd3\ub30c", "\u4530\u6dfe\ub3e5\ue6b3\u61d2"};
        __rP__gH4it2 = new String[]{"\u4409\u6c29\ub26f\ue752\u60f1\uba22\ub751\ub271\u47df\u6fda\ub169\ue414\u63f7\ub91e\ub719\ub3ad\u4642\u6e75\ub0ed\ue553\u625c\ub85b\ub695\ub453\u41a3\u69dc\ub709\ue246\u653b\ubf16\ub164\ub5c4\u40fd\u6869\ub6c7\ue3f0\u643e\ube3d\ub0a5\ub6ba\u4328\u6b2d\ub5cf\ue042\u677b\ubdf8\ub31a\ub692\u421a\u6aa3\ub4a6\ue1e5\u6672\ubcef\ub210\ub7f5\u4d56\u6579\ubbe9\uee80\u6942\ub351\ubd7f\ub876\u4c22\u64c9\uba66\uef3b\u6810\ub2a2\ubcc6\ub995\u4f5b\u679e\ub98c\uec8f\u6bf0\ub18e\ubf32\uba15\u4f0e\u66b9\ub87c\ueda0\u6ad9\ub036\ube48\ubbf5\u4ef0\u61b0\ubfcb\ueaea\u6d2f\ub7b9\ub96c\ubc9f\u49bc\u60c7\ube91\ueb29\u6c34\ub613\ub8e2\ubdbe\u48d9\u6363\ubd16\ue845\u6fdb\ub5b6\ubb0e\ube05\u4bd2\u635d\ubc1b\ue997\u6e8b\ub44b\uba9d\ubfad\u4ae1\u628b\uc320\u968f\u11a2\ucbc8\uc513\uc0f7\u356c\u1d77\uc25d\u9773\u1052\ucaa9\uc481\uc1cd\u34f5\u1c6b\uc1c5\u94bd\u13fd\uc9f0\uc783\uc250\u37ad\u1fcf\uc193\u954b\u128a\uc841\uc677\uc387\u3665\u1e2d\uc0a7\u920b\u158f\ucfdb\uc16c\uc4df\u3114\u1986\uc72e\u939d\u1463\ucebf\uc021\uc523\u3089\u1803\uc651\u9301\u1720\ucd38\uc359\uc640\u33b1\u1b9b\uc5c0\u90ec\u163e\uccc1\uc2de\uc7b2\u32d7\u1a0b\uc410\u9109\u19d6\uc353\ucd03\uc8f1\u3d5e\u1577\ucb85\u9eb7\u1841\uc211\ucc30\uc9ea\u3c5f\u14c6\uca15\u9f5c\u1834\uc1d4\ucfe5\ucaa5\u3ff4\u17cc\uc92e\u9c82\u1b0e\uc0ed\uce47\ucb56\u3ec2\u169a\uc855\u9d53\u1a77\uc781\uc92f\ucc07\u39e8\u1173\ucf4b\u9a86\u1dce\uc645\uc89b\ucd6e\u38ee\u10a4\uce1f\u9bf2\u1cf7\uc683\ucbe5\ucef6\u3b56\u1374\ucd10\u9868\u1f00\uc5aa\uca85\ucf86\u3a4a\u123d\uccc8\u9977\u1ea0\uc433\ud5bd\ud067\u2537\u0d5f\ud371\u86fa\u01d1\udbd6\ud4ae\ud1ce"};
        __rP__gH4it3 = new String[]{"\u4525\u6dce\ub315\ue6fa\u61ab\ubb0d\ub43d\ub11e\u443b\u6ca4"};
        __p__gH4it = new String[]{"\uee3c\uee61\uee86\ueeab\ueed0\ueef5\uef1a\uef3f\uef64\uef89\uefae\uefd3\ueff8", "\uf1f7\uf21c\uf241\uf266\uf28b\uf2b0\uf2d5\uf2fa\uf31f\uf344\uf369\uf38e\uf3b3", "\uedd2\uedf7\uee1c\uee41\uee66\uee8b\ueeb0\ueed5\ueefa\uef1f\uef44\uef69\uef8e\uefb3\uefd8\ueffd\uf022", "\ue89d\ue8c2\ue8e7\ue90c\ue931\ue956\ue97b\ue9a0\ue9c5", "\uec58\uec7d\ueca2\uecc7\uecec\ued11\ued36\ued5b\ued80", "\uf133\uf158\uf17d\uf1a2\uf1c7\uf1ec\uf211\uf236\uf25b\uf280\uf2a5\uf2ca\uf2ef\uf314\uf339\uf35e\uf383\uf3a8", "\ue4fe\ue523\ue548\ue56d\ue592\ue5b7\ue5dc\ue601\ue626\ue64b\ue670\ue695\ue6ba\ue6df\ue704", "\ue7b9\ue7de\ue803\ue828\ue84d\ue872\ue897\ue8bc\ue8e1\ue906\ue92b\ue950\ue975\ue99a", "\uf384\uf3a9\uf3ce\uf3f3\uf418\uf43d\uf462\uf487\uf4ac\uf4d1\uf4f6", "\ue05f\ue084\ue0a9\ue0ce\ue0f3\ue118\ue13d\ue162\ue187\ue1ac\ue1d1\ue1f6\ue21b\ue240\ue265\ue28a\ue2af", "\uf41a\uf43f\uf464\uf489\uf4ae\uf4d3\uf4f8\uf51d\uf542", "\ueee5\uef0a\uef2f\uef54\uef79\uef9e\uefc3\uefe8\uf00d\uf032\uf057\uf07c\uf0a1", "\ueac0\ueae5\ueb0a\ueb2f\ueb54\ueb79\ueb9e\uebc3\uebe8\uec0d\uec32\uec57\uec7c\ueca1\uecc6\ueceb\ued10\ued35\ued5a", "\uee7b\ueea0\ueec5\ueeea\uef0f\uef34\uef59\uef7e\uefa3\uefc8\uefed\uf012\uf037\uf05c\uf081", "\ue346\ue36b\ue390\ue3b5\ue3da\ue3ff\ue424\ue449\ue46e\ue493\ue4b8\ue4dd\ue502\ue527\ue54c\ue571\ue596\ue5bb", "\uef21\uef46\uef6b\uef90\uefb5\uefda\uefff\uf024", "\ue1ec\ue211\ue236\ue25b\ue280\ue2a5\ue2ca\ue2ef\ue314", "\ue5a7\ue5cc\ue5f1\ue616\ue63b\ue660\ue685\ue6aa\ue6cf\ue6f4\ue719\ue73e\ue763\ue788\ue7ad\ue7d2\ue7f7", "\ue282\ue2a7\ue2cc\ue2f1\ue316\ue33b\ue360\ue385\ue3aa", "\ue64d\ue672\ue697\ue6bc\ue6e1\ue706\ue72b\ue750\ue775\ue79a\ue7bf\ue7e4\ue809", "\ue108\ue12d\ue152\ue177\ue19c\ue1c1\ue1e6\ue20b\ue230\ue255\ue27a\ue29f\ue2c4", "\uece3\ued08\ued2d\ued52\ued77\ued9c\uedc1\uede6\uee0b\uee30\uee55\uee7a\uee9f\ueec4\ueee9\uef0e\uef33", "\ue1ae\ue1d3\ue1f8\ue21d\ue242\ue267\ue28c\ue2b1\ue2d6\ue2fb", "\ued69\ued8e\uedb3\uedd8\uedfd\uee22\uee47\uee6c\uee91\ueeb6\ueedb\uef00\uef25\uef4a\uef6f\uef94\uefb9\uefde", "\uf034\uf059\uf07e\uf0a3\uf0c8\uf0ed\uf112\uf137\uf15c\uf181", "\uf40f\uf434\uf459\uf47e\uf4a3\uf4c8\uf4ed\uf512", "\ue7ca\ue7ef\ue814\ue839\ue85e\ue883\ue8a8\ue8cd\ue8f2", "\uec95\uecba\uecdf\ued04\ued29\ued4e\ued73\ued98\uedbd\uede2\uee07\uee2c\uee51\uee76\uee9b\ueec0\ueee5", "\ue870\ue895\ue8ba\ue8df\ue904\ue929\ue94e\ue973\ue998\ue9bd\ue9e2", "\ueb2b\ueb50\ueb75\ueb9a\uebbf\uebe4\uec09\uec2e\uec53\uec78\uec9d\uecc2\uece7\ued0c\ued31\ued56\ued7b\ueda0", "\ueef6\uef1b\uef40\uef65\uef8a\uefaf\uefd4\ueff9\uf01e\uf043\uf068\uf08d\uf0b2\uf0d7\uf0fc\uf121\uf146", "\ue3d1\ue3f6\ue41b\ue440\ue465\ue48a\ue4af\ue4d4\ue4f9\ue51e\ue543\ue568", "\uf79c\uf7c1\uf7e6\ue00b\ue030\ue055\ue07a\ue09f\ue0c4\ue0e9\ue10e\ue133", "\uea57\uea7c\ueaa1\ueac6\ueaeb\ueb10\ueb35\ueb5a", "\uf632\uf657\uf67c\uf6a1\uf6c6\uf6eb\uf710\uf735\uf75a\uf77f\uf7a4\uf7c9\uf7ee\ue013\ue038\ue05d\ue082", "\uf2fd\uf322\uf347\uf36c\uf391\uf3b6\uf3db\uf400\uf425\uf44a\uf46f\uf494\uf4b9\uf4de\uf503\uf528\uf54d", "\ueeb8\ueedd\uef02\uef27\uef4c\uef71\uef96\uefbb\uefe0\uf005\uf02a\uf04f\uf074", "\ue993\ue9b8\ue9dd\uea02\uea27\uea4c\uea71\uea96\ueabb\ueae0\ueb05\ueb2a", "\ued5e\ued83\ueda8\uedcd\uedf2\uee17\uee3c\uee61\uee86", "\ue119\ue13e\ue163\ue188\ue1ad\ue1d2\ue1f7\ue21c\ue241", "\ue5e4\ue609\ue62e\ue653\ue678\ue69d\ue6c2\ue6e7\ue70c\ue731\ue756\ue77b\ue7a0\ue7c5\ue7ea\ue80f\ue834", "\ue1bf\ue1e4\ue209\ue22e\ue253\ue278\ue29d\ue2c2", "\uec7a\uec9f\uecc4\uece9\ued0e\ued33\ued58\ued7d\ueda2\uedc7\uedec\uee11\uee36", "\uf045\uf06a\uf08f\uf0b4\uf0d9\uf0fe\uf123\uf148\uf16d", "\ue520\ue545\ue56a\ue58f\ue5b4\ue5d9\ue5fe\ue623\ue648\ue66d\ue692\ue6b7\ue6dc\ue701\ue726", "\ue8db\ue900\ue925\ue94a\ue96f\ue994\ue9b9\ue9de\uea03\uea28\uea4d\uea72\uea97\ueabc\ueae1\ueb06\ueb2b", "\ueba6\uebcb\uebf0\uec15\uec3a\uec5f\uec84\ueca9\uecce\uecf3\ued18\ued3d", "\uef81\uefa6\uefcb\ueff0\uf015\uf03a\uf05f\uf084\uf0a9\uf0ce\uf0f3", "\uec4c\uec71\uec96\uecbb\uece0\ued05\ued2a\ued4f\ued74\ued99\uedbe\uede3\uee08\uee2d\uee52", "\ue807\ue82c\ue851\ue876\ue89b\ue8c0\ue8e5\ue90a\ue92f\ue954\ue979\ue99e\ue9c3\ue9e8\uea0d\uea32\uea57\uea7c\ueaa1", "\ueae2\ueb07\ueb2c\ueb51\ueb76\ueb9b\uebc0\uebe5\uec0a", "\ueead\ueed2\ueef7\uef1c\uef41\uef66\uef8b\uefb0\uefd5\ueffa\uf01f\uf044\uf069", "\ue268\ue28d\ue2b2\ue2d7\ue2fc\ue321\ue346\ue36b\ue390\ue3b5\ue3da\ue3ff\ue424", "\ue743\ue768\ue78d\ue7b2\ue7d7\ue7fc\ue821\ue846\ue86b\ue890\ue8b5\ue8da\ue8ff\ue924\ue949\ue96e\ue993\ue9b8\ue9dd", "\uf30e\uf333\uf358\uf37d\uf3a2\uf3c7\uf3ec\uf411\uf436\uf45b\uf480\uf4a5\uf4ca\uf4ef\uf514", "\uf5c9\uf5ee\uf613\uf638\uf65d\uf682\uf6a7\uf6cc\uf6f1\uf716\uf73b\uf760\uf785\uf7aa\uf7cf\uf7f4\ue019", "\uf194\uf1b9\uf1de\uf203\uf228\uf24d\uf272\uf297", "\uee6f\uee94\ueeb9\ueede\uef03\uef28\uef4d\uef72\uef97\uefbc\uefe1\uf006\uf02b\uf050\uf075", "\ue22a\ue24f\ue274\ue299\ue2be\ue2e3\ue308\ue32d\ue352\ue377\ue39c\ue3c1\ue3e6\ue40b\ue430\ue455\ue47a", "\uf4f5\uf51a\uf53f\uf564\uf589\uf5ae\uf5d3\uf5f8\uf61d\uf642\uf667\uf68c\uf6b1\uf6d6\uf6fb\uf720\uf745", "\ue8d0\ue8f5\ue91a\ue93f\ue964\ue989\ue9ae\ue9d3\ue9f8\uea1d\uea42\uea67\uea8c\ueab1\uead6", "\ue58b\ue5b0\ue5d5\ue5fa\ue61f\ue644\ue669\ue68e\ue6b3\ue6d8\ue6fd\ue722\ue747\ue76c\ue791\ue7b6", "\ue956\ue97b\ue9a0\ue9c5\ue9ea\uea0f\uea34\uea59\uea7e\ueaa3\ueac8\ueaed\ueb12\ueb37\ueb5c\ueb81\ueba6\uebcb\uebf0", "\ue431\ue456\ue47b\ue4a0\ue4c5\ue4ea\ue50f\ue534\ue559\ue57e\ue5a3\ue5c8\ue5ed\ue612\ue637\ue65c\ue681\ue6a6\ue6cb", "\uf7fc\ue021\ue046\ue06b\ue090\ue0b5\ue0da\ue0ff\ue124\ue149\ue16e\ue193\ue1b8\ue1dd", "\uf3b7\uf3dc\uf401\uf426\uf44b\uf470\uf495\uf4ba\uf4df\uf504", "\ue892\ue8b7\ue8dc\ue901\ue926\ue94b\ue970\ue995\ue9ba", "\uec5d\uec82\ueca7\ueccc\uecf1\ued16\ued3b\ued60\ued85\uedaa\uedcf\uedf4\uee19\uee3e\uee63\uee88\ueead", "\uef18\uef3d\uef62\uef87\uefac\uefd1\ueff6\uf01b\uf040\uf065\uf08a\uf0af\uf0d4", "\uf2f3\uf318\uf33d\uf362\uf387\uf3ac\uf3d1\uf3f6\uf41b\uf440\uf465\uf48a\uf4af\uf4d4\uf4f9\uf51e\uf543\uf568", "\ue7be\ue7e3\ue808\ue82d\ue852\ue877\ue89c\ue8c1\ue8e6\ue90b", "\ue379\ue39e\ue3c3\ue3e8\ue40d\ue432\ue457\ue47c\ue4a1\ue4c6\ue4eb\ue510\ue535\ue55a\ue57f\ue5a4\ue5c9", "\uf644\uf669\uf68e\uf6b3\uf6d8\uf6fd\uf722\uf747\uf76c\uf791\uf7b6", "\uea1f\uea44\uea69\uea8e\ueab3\uead8\ueafd\ueb22\ueb47\ueb6c\ueb91\uebb6\uebdb\uec00\uec25\uec4a\uec6f\uec94", "\ueeda\ueeff\uef24\uef49\uef6e\uef93\uefb8\uefdd\uf002", "\ueaa5\ueaca\ueaef\ueb14\ueb39\ueb5e\ueb83\ueba8\uebcd\uebf2\uec17\uec3c\uec61", "\uf580\uf5a5\uf5ca\uf5ef\uf614\uf639\uf65e\uf683\uf6a8\uf6cd\uf6f2\uf717\uf73c\uf761\uf786\uf7ab\uf7d0\uf7f5\ue01a", "\ue93b\ue960\ue985\ue9aa\ue9cf\ue9f4\uea19\uea3e\uea63\uea88\ueaad", "\uf506\uf52b\uf550\uf575\uf59a\uf5bf\uf5e4\uf609\uf62e\uf653\uf678\uf69d\uf6c2", "\uf1e1\uf206\uf22b\uf250\uf275\uf29a\uf2bf\uf2e4\uf309\uf32e\uf353\uf378\uf39d\uf3c2\uf3e7\uf40c\uf431\uf456\uf47b", "\uedac\uedd1\uedf6\uee1b\uee40\uee65\uee8a\ueeaf\ueed4\ueef9\uef1e\uef43\uef68\uef8d\uefb2\uefd7\ueffc", "\ue067\ue08c\ue0b1\ue0d6\ue0fb\ue120\ue145\ue16a\ue18f\ue1b4\ue1d9\ue1fe\ue223\ue248\ue26d\ue292\ue2b7\ue2dc", "\ue442\ue467\ue48c\ue4b1\ue4d6\ue4fb\ue520\ue545\ue56a", "\ue90d\ue932\ue957\ue97c\ue9a1\ue9c6\ue9eb\uea10\uea35\uea5a\uea7f\ueaa4\ueac9\ueaee\ueb13\ueb38\ueb5d", "\uf4c8\uf4ed\uf512\uf537\uf55c\uf581\uf5a6\uf5cb\uf5f0\uf615\uf63a\uf65f\uf684", "\uf7a3\uf7c8\uf7ed\ue012\ue037\ue05c\ue081\ue0a6\ue0cb\ue0f0\ue115\ue13a\ue15f\ue184\ue1a9\ue1ce\ue1f3", "\uf36e\uf393\uf3b8\uf3dd\uf402\uf427\uf44c\uf471\uf496\uf4bb\uf4e0\uf505\uf52a\uf54f\uf574\uf599\uf5be", "\ue029\ue04e\ue073\ue098\ue0bd\ue0e2\ue107\ue12c\ue151\ue176\ue19b\ue1c0\ue1e5", "\uf3f4\uf419\uf43e\uf463\uf488\uf4ad\uf4d2\uf4f7\uf51c\uf541\uf566\uf58b\uf5b0\uf5d5", "\ueecf\ueef4\uef19\uef3e\uef63\uef88\uefad\uefd2\ueff7\uf01c\uf041\uf066\uf08b\uf0b0\uf0d5\uf0fa\uf11f", "\uf28a\uf2af\uf2d4\uf2f9\uf31e\uf343\uf368\uf38d\uf3b2\uf3d7\uf3fc\uf421\uf446\uf46b", "\uf655\uf67a\uf69f\uf6c4\uf6e9\uf70e\uf733\uf758\uf77d\uf7a2\uf7c7\uf7ec\ue011", "\ue330\ue355\ue37a\ue39f\ue3c4\ue3e9\ue40e\ue433\ue458\ue47d\ue4a2", "\uf6eb\uf710\uf735\uf75a\uf77f\uf7a4\uf7c9\uf7ee\ue013\ue038\ue05d\ue082\ue0a7\ue0cc", "\ue9b6\ue9db\uea00\uea25\uea4a\uea6f\uea94\ueab9\ueade\ueb03\ueb28\ueb4d\ueb72\ueb97\uebbc\uebe1", "\uf591\uf5b6\uf5db\uf600\uf625\uf64a\uf66f\uf694\uf6b9\uf6de\uf703\uf728\uf74d\uf772"};
        __c__J7Um6 = new Object[][]{{"\uf488\uf4ad\uf4d2\uf4f7\uf51c\uf541\uf566\uf58b", 1479903010467454441L, "\ue3a6\ue3cb\ue3f0\ue415\ue43a\ue45f\ue484\ue4a9\ue4ce\ue4f3\ue518\ue53d\ue562\ue587", 1341080715, "\ueac4\ueae9\ueb0e\ueb33\ueb58\ueb7d\ueba2\uebc7\uebec\uec11\uec36\uec5b", false, "\uf1e2\uf207\uf22c\uf251\uf276\uf29b\uf2c0\uf2e5\uf30a\uf32f\uf354\uf379\uf39e\uf3c3\uf3e8\uf40d\uf432\uf457", false, "\ue100\ue125\ue14a\ue16f\ue194\ue1b9\ue1de\ue203\ue228\ue24d\ue272\ue297\ue2bc\ue2e1\ue306\ue32b", false, "\ue81e\ue843\ue868\ue88d\ue8b2\ue8d7\ue8fc\ue921\ue946\ue96b\ue990\ue9b5\ue9da", false}, {"\uf589\uf5ae\uf5d3\uf5f8\uf61d\uf642\uf667\uf68c", 1479903010467519978L, "\ue4a7\ue4cc\ue4f1\ue516\ue53b\ue560\ue585\ue5aa\ue5cf\ue5f4\ue619\ue63e\ue663\ue688\ue6ad\ue6d2\ue6f7", 25723436, "\uebc5\uebea\uec0f\uec34\uec59\uec7e\ueca3\uecc8\ueced\ued12\ued37\ued5c\ued81\ueda6\uedcb\uedf0", true, "\uf2e3\uf308\uf32d\uf352\uf377\uf39c\uf3c1\uf3e6\uf40b\uf430\uf455\uf47a\uf49f", true, "\ue201\ue226\ue24b\ue270\ue295\ue2ba\ue2df\ue304\ue329\ue34e\ue373\ue398\ue3bd\ue3e2\ue407\ue42c\ue451\ue476", true, "\ue91f\ue944\ue969\ue98e\ue9b3\ue9d8\ue9fd\uea22\uea47\uea6c\uea91\ueab6\ueadb\ueb00\ueb25\ueb4a", true}, {"\uf68a\uf6af\uf6d4\uf6f9\uf71e\uf743\uf768\uf78d\uf7b2\uf7d7\uf7fc\ue021\ue046\ue06b", 1479903010467585515L, "\ue5a8\ue5cd\ue5f2\ue617\ue63c\ue661\ue686\ue6ab\ue6d0\ue6f5\ue71a\ue73f", -752825915, "\uecc6\ueceb\ued10\ued35\ued5a\ued7f\ueda4\uedc9\uedee\uee13\uee38\uee5d\uee82\ueea7\ueecc\ueef1\uef16\uef3b", false, "\uf3e4\uf409\uf42e\uf453\uf478\uf49d\uf4c2\uf4e7\uf50c\uf531\uf556\uf57b\uf5a0\uf5c5\uf5ea\uf60f", false, "\ue302\ue327\ue34c\ue371\ue396\ue3bb\ue3e0\ue405\ue42a\ue44f\ue474\ue499\ue4be", false, "\uea20\uea45\uea6a\uea8f\ueab4\uead9\ueafe\ueb23\ueb48\ueb6d\ueb92\uebb7", false}, {"\uf78b\uf7b0\uf7d5\uf7fa\ue01f\ue044\ue069\ue08e\ue0b3\ue0d8\ue0fd\ue122\ue147\ue16c\ue191\ue1b6\ue1db", 1479903010467651052L, "\ue6a9\ue6ce\ue6f3\ue718\ue73d\ue762\ue787\ue7ac\ue7d1\ue7f6\ue81b\ue840\ue865\ue88a\ue8af\ue8d4", -1529342082, "\uedc7\uedec\uee11\uee36\uee5b\uee80\ueea5\ueeca\ueeef\uef14\uef39\uef5e\uef83", true, "\uf4e5\uf50a\uf52f\uf554\uf579\uf59e\uf5c3\uf5e8\uf60d\uf632\uf657\uf67c\uf6a1\uf6c6\uf6eb\uf710\uf735\uf75a", true, "\ue403\ue428\ue44d\ue472\ue497\ue4bc\ue4e1\ue506\ue52b\ue550\ue575\ue59a\ue5bf\ue5e4\ue609\ue62e", true, "\ueb21\ueb46\ueb6b\ueb90\uebb5\uebda\uebff\uec24\uec49\uec6e", true}, {"\ue08c\ue0b1\ue0d6\ue0fb\ue120\ue145\ue16a\ue18f\ue1b4\ue1d9\ue1fe\ue223", 1479903010467716589L, "\ue7aa\ue7cf\ue7f4\ue819\ue83e\ue863\ue888\ue8ad\ue8d2\ue8f7\ue91c\ue941\ue966\ue98b\ue9b0\ue9d5\ue9fa\uea1f", 1987075607, "\ueec8\ueeed\uef12\uef37\uef5c\uef81\uefa6\uefcb\ueff0\uf015\uf03a\uf05f\uf084\uf0a9\uf0ce\uf0f3", false, "\uf5e6\uf60b\uf630\uf655\uf67a\uf69f\uf6c4\uf6e9\uf70e\uf733\uf758\uf77d\uf7a2", false, "\ue504\ue529\ue54e\ue573\ue598\ue5bd\ue5e2\ue607\ue62c\ue651\ue676\ue69b", false, "\uec22\uec47\uec6c\uec91\uecb6\uecdb\ued00\ued25\ued4a", false}, {"\ue18d\ue1b2\ue1d7\ue1fc\ue221\ue246\ue26b\ue290\ue2b5\ue2da\ue2ff\ue324\ue349\ue36e\ue393\ue3b8", 1479903010467782126L, "\ue8ab\ue8d0\ue8f5\ue91a\ue93f\ue964\ue989\ue9ae\ue9d3\ue9f8\uea1d\uea42\uea67", -940988984, "\uefc9\uefee\uf013\uf038\uf05d\uf082\uf0a7\uf0cc\uf0f1\uf116\uf13b\uf160\uf185\uf1aa\uf1cf\uf1f4\uf219\uf23e", true, "\uf6e7\uf70c\uf731\uf756\uf77b\uf7a0\uf7c5\uf7ea\ue00f\ue034\ue059\ue07e\ue0a3\ue0c8\ue0ed\ue112", true, "\ue605\ue62a\ue64f\ue674\ue699\ue6be\ue6e3\ue708\ue72d\ue752", true, "\ued23\ued48\ued6d\ued92\uedb7\ueddc\uee01\uee26\uee4b\uee70\uee95\ueeba\ueedf\uef04", true}, {"\ue28e\ue2b3\ue2d8\ue2fd\ue322\ue347\ue36c\ue391\ue3b6\ue3db\ue400\ue425\ue44a\ue46f\ue494\ue4b9\ue4de\ue503", 1479903010467847663L, "\ue9ac\ue9d1\ue9f6\uea1b\uea40\uea65\uea8a\ueaaf\uead4\ueaf9\ueb1e\ueb43\ueb68\ueb8d\uebb2\uebd7", -1719540895, "\uf0ca\uf0ef\uf114\uf139\uf15e\uf183\uf1a8\uf1cd\uf1f2\uf217\uf23c\uf261\uf286", false, "\uf7e8\ue00d\ue032\ue057\ue07c\ue0a1\ue0c6\ue0eb\ue110\ue135\ue15a\ue17f", false, "\ue706\ue72b\ue750\ue775\ue79a\ue7bf\ue7e4\ue809\ue82e", false, "\uee24\uee49\uee6e\uee93\ueeb8\ueedd\uef02\uef27", false}, {"\ue38f\ue3b4\ue3d9\ue3fe\ue423\ue448\ue46d\ue492\ue4b7\ue4dc\ue501\ue526\ue54b", 1479903010467913200L, "\ueaad\uead2\ueaf7\ueb1c\ueb41\ueb66\ueb8b\uebb0\uebd5\uebfa\uec1f\uec44\uec69\uec8e\uecb3\uecd8\uecfd\ued22", 1798908442, "\uf1cb\uf1f0\uf215\uf23a\uf25f\uf284\uf2a9\uf2ce\uf2f3\uf318\uf33d\uf362\uf387\uf3ac\uf3d1\uf3f6", true, "\ue0e9\ue10e\ue133\ue158\ue17d\ue1a2\ue1c7\ue1ec\ue211\ue236", true, "\ue807\ue82c\ue851\ue876\ue89b\ue8c0\ue8e5\ue90a\ue92f\ue954\ue979\ue99e\ue9c3\ue9e8", true, "\uef25\uef4a\uef6f\uef94\uefb9\uefde\uf003\uf028", true}, {"\ue490\ue4b5\ue4da\ue4ff\ue524\ue549\ue56e\ue593\ue5b8\ue5dd\ue602\ue627\ue64c\ue671\ue696\ue6bb", 1479903010467978737L, "\uebae\uebd3\uebf8\uec1d\uec42\uec67\uec8c\uecb1\uecd6\uecfb\ued20\ued45\ued6a", 1020359091, "\uf2cc\uf2f1\uf316\uf33b\uf360\uf385\uf3aa\uf3cf\uf3f4\uf419\uf43e\uf463", false, "\ue1ea\ue20f\ue234\ue259\ue27e\ue2a3\ue2c8\ue2ed\ue312", false, "\ue908\ue92d\ue952\ue977\ue99c\ue9c1\ue9e6\uea0b", false, "\uf026\uf04b\uf070\uf095\uf0ba\uf0df\uf104\uf129\uf14e\uf173\uf198\uf1bd\uf1e2\uf207", false}, {"\ue591\ue5b6\ue5db\ue600\ue625\ue64a\ue66f\ue694\ue6b9\ue6de\ue703\ue728\ue74d\ue772\ue797\ue7bc\ue7e1\ue806", 1479903010468044274L, "\uecaf\uecd4\uecf9\ued1e\ued43\ued68\ued8d\uedb2\uedd7\uedfc\uee21\uee46\uee6b\uee90\ueeb5\ueeda", -1907703980, "\uf3cd\uf3f2\uf417\uf43c\uf461\uf486\uf4ab\uf4d0\uf4f5\uf51a", true, "\ue2eb\ue310\ue335\ue35a\ue37f\ue3a4\ue3c9\ue3ee\ue413\ue438\ue45d\ue482\ue4a7\ue4cc", true, "\uea09\uea2e\uea53\uea78\uea9d\ueac2\ueae7\ueb0c", true, "\uf127\uf14c\uf171\uf196\uf1bb\uf1e0\uf205\uf22a\uf24f\uf274\uf299\uf2be\uf2e3\uf308\uf32d\uf352\uf377", true}, {"\ue692\ue6b7\ue6dc\ue701\ue726\ue74b\ue770\ue795\ue7ba\ue7df\ue804\ue829\ue84e", 1479903010468109811L, "\uedb0\uedd5\uedfa\uee1f\uee44\uee69\uee8e\ueeb3\ueed8\ueefd\uef22\uef47", 1608680973, "\uf4ce\uf4f3\uf518\uf53d\uf562\uf587\uf5ac\uf5d1\uf5f6", false, "\ue3ec\ue411\ue436\ue45b\ue480\ue4a5\ue4ca\ue4ef", false, "\ueb0a\ueb2f\ueb54\ueb79\ueb9e\uebc3\uebe8\uec0d\uec32\uec57\uec7c\ueca1\uecc6\ueceb", false, "\uf228\uf24d\uf272\uf297\uf2bc\uf2e1\uf306\uf32b\uf350\uf375\uf39a\uf3bf", false}, {"\ue793\ue7b8\ue7dd\ue802\ue827\ue84c\ue871\ue896\ue8bb\ue8e0\ue905\ue92a\ue94f\ue974\ue999\ue9be", 1479903010468175348L, "\ueeb1\ueed6\ueefb\uef20\uef45\uef6a\uef8f\uefb4\uefd9\ueffe", 295357862, "\uf5cf\uf5f4\uf619\uf63e\uf663\uf688\uf6ad\uf6d2\uf6f7\uf71c\uf741\uf766\uf78b\uf7b0", true, "\ue4ed\ue512\ue537\ue55c\ue581\ue5a6\ue5cb\ue5f0", true, "\uec0b\uec30\uec55\uec7a\uec9f\uecc4\uece9\ued0e\ued33\ued58\ued7d\ueda2\uedc7\uedec\uee11\uee36\uee5b", true, "\uf329\uf34e\uf373\uf398\uf3bd\uf3e2\uf407\uf42c\uf451\uf476\uf49b\uf4c0\uf4e5\uf50a\uf52f\uf554", true}, {"\ue894\ue8b9\ue8de\ue903\ue928\ue94d\ue972\ue997\ue9bc\ue9e1\uea06\uea2b", 1479903010468240885L, "\uefb2\uefd7\ueffc\uf021\uf046\uf06b\uf090\uf0b5\uf0da", -483259553, "\uf6d0\uf6f5\uf71a\uf73f\uf764\uf789\uf7ae\uf7d3", false, "\ue5ee\ue613\ue638\ue65d\ue682\ue6a7\ue6cc\ue6f1\ue716\ue73b\ue760\ue785\ue7aa\ue7cf", false, "\ued0c\ued31\ued56\ued7b\ueda0\uedc5\uedea\uee0f\uee34\uee59\uee7e\ueea3", false, "\uf42a\uf44f\uf474\uf499\uf4be\uf4e3\uf508\uf52d\uf552\uf577\uf59c\uf5c1\uf5e6\uf60b\uf630\uf655\uf67a\uf69f", false}, {"\ue995\ue9ba\ue9df\uea04\uea29\uea4e\uea73\uea98\ueabd\ueae2", 1479903010468306422L, "\uf0b3\uf0d8\uf0fd\uf122\uf147\uf16c\uf191\uf1b6\uf1db\uf200\uf225\uf24a\uf26f\uf294", -1263906064, "\uf7d1\uf7f6\ue01b\ue040\ue065\ue08a\ue0af\ue0d4", true, "\ue6ef\ue714\ue739\ue75e\ue783\ue7a8\ue7cd\ue7f2\ue817\ue83c\ue861\ue886\ue8ab\ue8d0\ue8f5\ue91a\ue93f", true, "\uee0d\uee32\uee57\uee7c\ueea1\ueec6\ueeeb\uef10\uef35\uef5a\uef7f\uefa4\uefc9\uefee\uf013\uf038", true, "\uf52b\uf550\uf575\uf59a\uf5bf\uf5e4\uf609\uf62e\uf653\uf678\uf69d\uf6c2\uf6e7", true}, {"\uea96\ueabb\ueae0\ueb05\ueb2a\ueb4f\ueb74\ueb99\uebbe", 1479903010468371959L, "\uf1b4\uf1d9\uf1fe\uf223\uf248\uf26d\uf292\uf2b7", 105093545, "\ue0d2\ue0f7\ue11c\ue141\ue166\ue18b\ue1b0\ue1d5\ue1fa\ue21f\ue244\ue269\ue28e\ue2b3", false, "\ue7f0\ue815\ue83a\ue85f\ue884\ue8a9\ue8ce\ue8f3\ue918\ue93d\ue962\ue987", false, "\uef0e\uef33\uef58\uef7d\uefa2\uefc7\uefec\uf011\uf036\uf05b\uf080\uf0a5\uf0ca\uf0ef\uf114\uf139\uf15e\uf183", false, "\uf62c\uf651\uf676\uf69b\uf6c0\uf6e5\uf70a\uf72f\uf754\uf779\uf79e\uf7c3\uf7e8\ue00d\ue032\ue057", false}, {"\ueb97\uebbc\uebe1\uec06\uec2b\uec50\uec75\uec9a\uecbf\uece4\ued09\ued2e\ued53\ued78", 1479903010468437496L, "\uf2b5\uf2da\uf2ff\uf324\uf349\uf36e\uf393\uf3b8", -671357118, "\ue1d3\ue1f8\ue21d\ue242\ue267\ue28c\ue2b1\ue2d6\ue2fb\ue320\ue345\ue36a\ue38f\ue3b4\ue3d9\ue3fe\ue423", true, "\ue8f1\ue916\ue93b\ue960\ue985\ue9aa\ue9cf\ue9f4\uea19\uea3e\uea63\uea88\ueaad\uead2\ueaf7\ueb1c", true, "\uf00f\uf034\uf059\uf07e\uf0a3\uf0c8\uf0ed\uf112\uf137\uf15c\uf181\uf1a6\uf1cb", true, "\uf72d\uf752\uf777\uf79c\uf7c1\uf7e6\ue00b\ue030\ue055\ue07a\ue09f\ue0c4\ue0e9\ue10e\ue133\ue158\ue17d\ue1a2", true}, {"\uec98\uecbd\uece2\ued07\ued2c\ued51\ued76\ued9b", 1479903010468503033L, "\uf3b6\uf3db\uf400\uf425\uf44a\uf46f\uf494\uf4b9\uf4de\uf503\uf528\uf54d\uf572\uf597", -1449971973, "\ue2d4\ue2f9\ue31e\ue343\ue368\ue38d\ue3b2\ue3d7\ue3fc\ue421\ue446\ue46b", false, "\ue9f2\uea17\uea3c\uea61\uea86\ueaab\uead0\ueaf5\ueb1a\ueb3f\ueb64\ueb89\uebae\uebd3\uebf8\uec1d\uec42\uec67", false, "\uf110\uf135\uf15a\uf17f\uf1a4\uf1c9\uf1ee\uf213\uf238\uf25d\uf282\uf2a7\uf2cc\uf2f1\uf316\uf33b", false, "\ue02e\ue053\ue078\ue09d\ue0c2\ue0e7\ue10c\ue131\ue156\ue17b\ue1a0\ue1c5\ue1ea", false}, {"\ued99\uedbe\uede3\uee08\uee2d\uee52\uee77\uee9c", 1479903010468568570L, "\uf4b7\uf4dc\uf501\uf526\uf54b\uf570\uf595\uf5ba\uf5df\uf604\uf629\uf64e\uf673\uf698\uf6bd\uf6e2\uf707", 2064348572, "\ue3d5\ue3fa\ue41f\ue444\ue469\ue48e\ue4b3\ue4d8\ue4fd\ue522\ue547\ue56c\ue591\ue5b6\ue5db\ue600", true, "\ueaf3\ueb18\ueb3d\ueb62\ueb87\uebac\uebd1\uebf6\uec1b\uec40\uec65\uec8a\uecaf", true, "\uf211\uf236\uf25b\uf280\uf2a5\uf2ca\uf2ef\uf314\uf339\uf35e\uf383\uf3a8\uf3cd\uf3f2\uf417\uf43c\uf461\uf486", true, "\ue12f\ue154\ue179\ue19e\ue1c3\ue1e8\ue20d\ue232\ue257\ue27c\ue2a1\ue2c6\ue2eb\ue310\ue335\ue35a", true}, {"\uee9a\ueebf\ueee4\uef09\uef2e\uef53\uef78\uef9d\uefc2\uefe7\uf00c\uf031\uf056\uf07b", 1479903010468634107L, "\uf5b8\uf5dd\uf602\uf627\uf64c\uf671\uf696\uf6bb\uf6e0\uf705\uf72a\uf74f", -861621451, "\ue4d6\ue4fb\ue520\ue545\ue56a\ue58f\ue5b4\ue5d9\ue5fe\ue623\ue648\ue66d\ue692\ue6b7\ue6dc\ue701\ue726\ue74b", false, "\uebf4\uec19\uec3e\uec63\uec88\uecad\uecd2\uecf7\ued1c\ued41\ued66\ued8b\uedb0\uedd5\uedfa\uee1f", false, "\uf312\uf337\uf35c\uf381\uf3a6\uf3cb\uf3f0\uf415\uf43a\uf45f\uf484\uf4a9\uf4ce", false, "\ue230\ue255\ue27a\ue29f\ue2c4\ue2e9\ue30e\ue333\ue358\ue37d\ue3a2\ue3c7", false}, {"\uef9b\uefc0\uefe5\uf00a\uf02f\uf054\uf079\uf09e\uf0c3\uf0e8\uf10d\uf132\uf157\uf17c\uf1a1\uf1c6\uf1eb", 1479903010468699644L, "\uf6b9\uf6de\uf703\uf728\uf74d\uf772\uf797\uf7bc\uf7e1\ue006\ue02b\ue050\ue075\ue09a\ue0bf\ue0e4", -1638073618, "\ue5d7\ue5fc\ue621\ue646\ue66b\ue690\ue6b5\ue6da\ue6ff\ue724\ue749\ue76e\ue793", true, "\uecf5\ued1a\ued3f\ued64\ued89\uedae\uedd3\uedf8\uee1d\uee42\uee67\uee8c\ueeb1\ueed6\ueefb\uef20\uef45\uef6a", true, "\uf413\uf438\uf45d\uf482\uf4a7\uf4cc\uf4f1\uf516\uf53b\uf560\uf585\uf5aa\uf5cf\uf5f4\uf619\uf63e", true, "\ue331\ue356\ue37b\ue3a0\ue3c5\ue3ea\ue40f\ue434\ue459\ue47e", true}, {"\uf09c\uf0c1\uf0e6\uf10b\uf130\uf155\uf17a\uf19f\uf1c4\uf1e9\uf20e\uf233", 1479903010468765181L, "\uf7ba\uf7df\ue004\ue029\ue04e\ue073\ue098\ue0bd\ue0e2\ue107\ue12c\ue151\ue176\ue19b\ue1c0\ue1e5\ue20a\ue22f", 1878311303, "\ue6d8\ue6fd\ue722\ue747\ue76c\ue791\ue7b6\ue7db\ue800\ue825\ue84a\ue86f\ue894\ue8b9\ue8de\ue903", false, "\uedf6\uee1b\uee40\uee65\uee8a\ueeaf\ueed4\ueef9\uef1e\uef43\uef68\uef8d\uefb2", false, "\uf514\uf539\uf55e\uf583\uf5a8\uf5cd\uf5f2\uf617\uf63c\uf661\uf686\uf6ab", false, "\ue432\ue457\ue47c\ue4a1\ue4c6\ue4eb\ue510\ue535\ue55a", false}, {"\uf19d\uf1c2\uf1e7\uf20c\uf231\uf256\uf27b\uf2a0\uf2c5\uf2ea\uf30f\uf334\uf359\uf37e\uf3a3\uf3c8", 1479903010468830718L, "\ue0bb\ue0e0\ue105\ue12a\ue14f\ue174\ue199\ue1be\ue1e3\ue208\ue22d\ue252\ue277", 560729912, "\ue7d9\ue7fe\ue823\ue848\ue86d\ue892\ue8b7\ue8dc\ue901\ue926\ue94b\ue970\ue995\ue9ba\ue9df\uea04\uea29\uea4e", true, "\ueef7\uef1c\uef41\uef66\uef8b\uefb0\uefd5\ueffa\uf01f\uf044\uf069\uf08e\uf0b3\uf0d8\uf0fd\uf122", true, "\uf615\uf63a\uf65f\uf684\uf6a9\uf6ce\uf6f3\uf718\uf73d\uf762", true, "\ue533\ue558\ue57d\ue5a2\ue5c7\ue5ec\ue611\ue636\ue65b\ue680\ue6a5\ue6ca\ue6ef\ue714", true}, {"\uf29e\uf2c3\uf2e8\uf30d\uf332\uf357\uf37c\uf3a1\uf3c6\uf3eb\uf410\uf435\uf45a\uf47f\uf4a4\uf4c9\uf4ee\uf513", 1479903010468896255L, "\ue1bc\ue1e1\ue206\ue22b\ue250\ue275\ue29a\ue2bf\ue2e4\ue309\ue32e\ue353\ue378\ue39d\ue3c2\ue3e7", -217819439, "\ue8da\ue8ff\ue924\ue949\ue96e\ue993\ue9b8\ue9dd\uea02\uea27\uea4c\uea71\uea96", false, "\ueff8\uf01d\uf042\uf067\uf08c\uf0b1\uf0d6\uf0fb\uf120\uf145\uf16a\uf18f", false, "\uf716\uf73b\uf760\uf785\uf7aa\uf7cf\uf7f4\ue019\ue03e", false, "\ue634\ue659\ue67e\ue6a3\ue6c8\ue6ed\ue712\ue737", false}, {"\uf39f\uf3c4\uf3e9\uf40e\uf433\uf458\uf47d\uf4a2\uf4c7\uf4ec\uf511\uf536\uf55b", 1479903010468961792L, "\ue2bd\ue2e2\ue307\ue32c\ue351\ue376\ue39b\ue3c0\ue3e5\ue40a\ue42f\ue454\ue479\ue49e\ue4c3\ue4e8\ue50d\ue532", 1153277322, "\ue9db\uea00\uea25\uea4a\uea6f\uea94\ueab9\ueade\ueb03\ueb28\ueb4d\ueb72\ueb97\uebbc\uebe1\uec06", true, "\uf0f9\uf11e\uf143\uf168\uf18d\uf1b2\uf1d7\uf1fc\uf221\uf246", true, "\ue017\ue03c\ue061\ue086\ue0ab\ue0d0\ue0f5\ue11a\ue13f\ue164\ue189\ue1ae\ue1d3\ue1f8", true, "\ue735\ue75a\ue77f\ue7a4\ue7c9\ue7ee\ue813\ue838", true}, {"\uf4a0\uf4c5\uf4ea\uf50f\uf534\uf559\uf57e\uf5a3\uf5c8\uf5ed\uf612\uf637\uf65c\uf681\uf6a6\uf6cb", 1479903010469027329L, "\ue3be\ue3e3\ue408\ue42d\ue452\ue477\ue49c\ue4c1\ue4e6\ue50b\ue530\ue555\ue57a", 374725411, "\ueadc\ueb01\ueb26\ueb4b\ueb70\ueb95\uebba\uebdf\uec04\uec29\uec4e\uec73", false, "\uf1fa\uf21f\uf244\uf269\uf28e\uf2b3\uf2d8\uf2fd\uf322", false, "\ue118\ue13d\ue162\ue187\ue1ac\ue1d1\ue1f6\ue21b", false, "\ue836\ue85b\ue880\ue8a5\ue8ca\ue8ef\ue914\ue939\ue95e\ue983\ue9a8\ue9cd\ue9f2\uea17", false}, {"\uf5a1\uf5c6\uf5eb\uf610\uf635\uf65a\uf67f\uf6a4\uf6c9\uf6ee\uf713\uf738\uf75d\uf782\uf7a7\uf7cc\uf7f1\ue016", 1479903010469092866L, "\ue4bf\ue4e4\ue509\ue52e\ue553\ue578\ue59d\ue5c2\ue5e7\ue60c\ue631\ue656\ue67b\ue6a0\ue6c5\ue6ea", -405986620, "\uebdd\uec02\uec27\uec4c\uec71\uec96\uecbb\uece0\ued05\ued2a", true, "\uf2fb\uf320\uf345\uf36a\uf38f\uf3b4\uf3d9\uf3fe\uf423\uf448\uf46d\uf492\uf4b7\uf4dc", true, "\ue219\ue23e\ue263\ue288\ue2ad\ue2d2\ue2f7\ue31c", true, "\ue937\ue95c\ue981\ue9a6\ue9cb\ue9f0\uea15\uea3a\uea5f\uea84\ueaa9\ueace\ueaf3\ueb18\ueb3d\ueb62\ueb87", true}, {"\uf6a2\uf6c7\uf6ec\uf711\uf736\uf75b\uf780\uf7a5\uf7ca\uf7ef\ue014\ue039\ue05e", 1479903010469158403L, "\ue5c0\ue5e5\ue60a\ue62f\ue654\ue679\ue69e\ue6c3\ue6e8\ue70d\ue732\ue757", -1184536451, "\uecde\ued03\ued28\ued4d\ued72\ued97\uedbc\uede1\uee06", false, "\uf3fc\uf421\uf446\uf46b\uf490\uf4b5\uf4da\uf4ff", false, "\ue31a\ue33f\ue364\ue389\ue3ae\ue3d3\ue3f8\ue41d\ue442\ue467\ue48c\ue4b1\ue4d6\ue4fb", false, "\uea38\uea5d\uea82\ueaa7\ueacc\ueaf1\ueb16\ueb3b\ueb60\ueb85\uebaa\uebcf", false}, {"\uf7a3\uf7c8\uf7ed\ue012\ue037\ue05c\ue081\ue0a6\ue0cb\ue0f0\ue115\ue13a\ue15f\ue184\ue1a9\ue1ce", 1479903010469223940L, "\ue6c1\ue6e6\ue70b\ue730\ue755\ue77a\ue79f\ue7c4\ue7e9\ue80e", 186562326, "\ueddf\uee04\uee29\uee4e\uee73\uee98\ueebd\ueee2\uef07\uef2c\uef51\uef76\uef9b\uefc0", true, "\uf4fd\uf522\uf547\uf56c\uf591\uf5b6\uf5db\uf600", true, "\ue41b\ue440\ue465\ue48a\ue4af\ue4d4\ue4f9\ue51e\ue543\ue568\ue58d\ue5b2\ue5d7\ue5fc\ue621\ue646\ue66b", true, "\ueb39\ueb5e\ueb83\ueba8\uebcd\uebf2\uec17\uec3c\uec61\uec86\uecab\uecd0\uecf5\ued1a\ued3f\ued64", true}, {"\ue0a4\ue0c9\ue0ee\ue113\ue138\ue15d\ue182\ue1a7\ue1cc\ue1f1\ue216\ue23b", 1479903010469289477L, "\ue7c2\ue7e7\ue80c\ue831\ue856\ue87b\ue8a0\ue8c5\ue8ea", -591986993, "\ueee0\uef05\uef2a\uef4f\uef74\uef99\uefbe\uefe3", false, "\uf5fe\uf623\uf648\uf66d\uf692\uf6b7\uf6dc\uf701\uf726\uf74b\uf770\uf795\uf7ba\uf7df", false, "\ue51c\ue541\ue566\ue58b\ue5b0\ue5d5\ue5fa\ue61f\ue644\ue669\ue68e\ue6b3", false, "\uec3a\uec5f\uec84\ueca9\uecce\uecf3\ued18\ued3d\ued62\ued87\uedac\uedd1\uedf6\uee1b\uee40\uee65\uee8a\ueeaf", false}, {"\ue1a5\ue1ca\ue1ef\ue214\ue239\ue25e\ue283\ue2a8\ue2cd\ue2f2", 1479903010469355014L, "\ue8c3\ue8e8\ue90d\ue932\ue957\ue97c\ue9a1\ue9c6\ue9eb\uea10\uea35\uea5a\uea7f\ueaa4", -1372666784, "\uefe1\uf006\uf02b\uf050\uf075\uf09a\uf0bf\uf0e4", true, "\uf6ff\uf724\uf749\uf76e\uf793\uf7b8\uf7dd\ue002\ue027\ue04c\ue071\ue096\ue0bb\ue0e0\ue105\ue12a\ue14f", true, "\ue61d\ue642\ue667\ue68c\ue6b1\ue6d6\ue6fb\ue720\ue745\ue76a\ue78f\ue7b4\ue7d9\ue7fe\ue823\ue848", true, "\ued3b\ued60\ued85\uedaa\uedcf\uedf4\uee19\uee3e\uee63\uee88\ueead\ueed2\ueef7", true}, {"\ue2a6\ue2cb\ue2f0\ue315\ue33a\ue35f\ue384\ue3a9\ue3ce", 1479903010469420551L, "\ue9c4\ue9e9\uea0e\uea33\uea58\uea7d\ueaa2\ueac7", 2143683353, "\uf0e2\uf107\uf12c\uf151\uf176\uf19b\uf1c0\uf1e5\uf20a\uf22f\uf254\uf279\uf29e\uf2c3", false, "\ue000\ue025\ue04a\ue06f\ue094\ue0b9\ue0de\ue103\ue128\ue14d\ue172\ue197", false, "\ue71e\ue743\ue768\ue78d\ue7b2\ue7d7\ue7fc\ue821\ue846\ue86b\ue890\ue8b5\ue8da\ue8ff\ue924\ue949\ue96e\ue993", false, "\uee3c\uee61\uee86\ueeab\ueed0\ueef5\uef1a\uef3f\uef64\uef89\uefae\uefd3\ueff8\uf01d\uf042\uf067", false}, {"\ue3a7\ue3cc\ue3f1\ue416\ue43b\ue460\ue485\ue4aa\ue4cf\ue4f4\ue519\ue53e\ue563\ue588", 1479903010469486088L, "\ueac5\ueaea\ueb0f\ueb34\ueb59\ueb7e\ueba3\uebc8", 830360242, "\uf1e3\uf208\uf22d\uf252\uf277\uf29c\uf2c1\uf2e6\uf30b\uf330\uf355\uf37a\uf39f\uf3c4\uf3e9\uf40e\uf433", true, "\ue101\ue126\ue14b\ue170\ue195\ue1ba\ue1df\ue204\ue229\ue24e\ue273\ue298\ue2bd\ue2e2\ue307\ue32c", true, "\ue81f\ue844\ue869\ue88e\ue8b3\ue8d8\ue8fd\ue922\ue947\ue96c\ue991\ue9b6\ue9db", true, "\uef3d\uef62\uef87\uefac\uefd1\ueff6\uf01b\uf040\uf065\uf08a\uf0af\uf0d4\uf0f9\uf11e\uf143\uf168\uf18d\uf1b2", true}, {"\ue4a8\ue4cd\ue4f2\ue517\ue53c\ue561\ue586\ue5ab", 1479903010469551625L, "\uebc6\uebeb\uec10\uec35\uec5a\uec7f\ueca4\uecc9\uecee\ued13\ued38\ued5d\ued82\ueda7", -2095607701, "\uf2e4\uf309\uf32e\uf353\uf378\uf39d\uf3c2\uf3e7\uf40c\uf431\uf456\uf47b", false, "\ue202\ue227\ue24c\ue271\ue296\ue2bb\ue2e0\ue305\ue32a\ue34f\ue374\ue399\ue3be\ue3e3\ue408\ue42d\ue452\ue477", false, "\ue920\ue945\ue96a\ue98f\ue9b4\ue9d9\ue9fe\uea23\uea48\uea6d\uea92\ueab7\ueadc\ueb01\ueb26\ueb4b", false, "\uf03e\uf063\uf088\uf0ad\uf0d2\uf0f7\uf11c\uf141\uf166\uf18b\uf1b0\uf1d5\uf1fa", false}, {"\ue5a9\ue5ce\ue5f3\ue618\ue63d\ue662\ue687\ue6ac", 1479903010469617162L, "\uecc7\uecec\ued11\ued36\ued5b\ued80\ueda5\uedca\uedef\uee14\uee39\uee5e\uee83\ueea8\ueecd\ueef2\uef17", 1418714892, "\uf3e5\uf40a\uf42f\uf454\uf479\uf49e\uf4c3\uf4e8\uf50d\uf532\uf557\uf57c\uf5a1\uf5c6\uf5eb\uf610", true, "\ue303\ue328\ue34d\ue372\ue397\ue3bc\ue3e1\ue406\ue42b\ue450\ue475\ue49a\ue4bf", true, "\uea21\uea46\uea6b\uea90\ueab5\ueada\ueaff\ueb24\ueb49\ueb6e\ueb93\uebb8\uebdd\uec02\uec27\uec4c\uec71\uec96", true, "\uf13f\uf164\uf189\uf1ae\uf1d3\uf1f8\uf21d\uf242\uf267\uf28c\uf2b1\uf2d6\uf2fb\uf320\uf345\uf36a", true}, {"\ue6aa\ue6cf\ue6f4\ue719\ue73e\ue763\ue788\ue7ad\ue7d2\ue7f7\ue81c\ue841\ue866\ue88b", 1479903010469682699L, "\uedc8\ueded\uee12\uee37\uee5c\uee81\ueea6\ueecb\ueef0\uef15\uef3a\uef5f", 640100005, "\uf4e6\uf50b\uf530\uf555\uf57a\uf59f\uf5c4\uf5e9\uf60e\uf633\uf658\uf67d\uf6a2\uf6c7\uf6ec\uf711\uf736\uf75b", false, "\ue404\ue429\ue44e\ue473\ue498\ue4bd\ue4e2\ue507\ue52c\ue551\ue576\ue59b\ue5c0\ue5e5\ue60a\ue62f", false, "\ueb22\ueb47\ueb6c\ueb91\uebb6\uebdb\uec00\uec25\uec4a\uec6f\uec94\uecb9\uecde", false, "\uf240\uf265\uf28a\uf2af\uf2d4\uf2f9\uf31e\uf343\uf368\uf38d\uf3b2\uf3d7", false}, {"\ue7ab\ue7d0\ue7f5\ue81a\ue83f\ue864\ue889\ue8ae\ue8d3\ue8f8\ue91d\ue942\ue967\ue98c\ue9b1\ue9d6\ue9fb", 1479903010469748236L, "\ueec9\ueeee\uef13\uef38\uef5d\uef82\uefa7\uefcc\ueff1\uf016\uf03b\uf060\uf085\uf0aa\uf0cf\uf0f4", -136352674, "\uf5e7\uf60c\uf631\uf656\uf67b\uf6a0\uf6c5\uf6ea\uf70f\uf734\uf759\uf77e\uf7a3", true, "\ue505\ue52a\ue54f\ue574\ue599\ue5be\ue5e3\ue608\ue62d\ue652\ue677\ue69c\ue6c1\ue6e6\ue70b\ue730\ue755\ue77a", true, "\uec23\uec48\uec6d\uec92\uecb7\uecdc\ued01\ued26\ued4b\ued70\ued95\uedba\ueddf\uee04\uee29\uee4e", true, "\uf341\uf366\uf38b\uf3b0\uf3d5\uf3fa\uf41f\uf444\uf469\uf48e", true}, {"\ue8ac\ue8d1\ue8f6\ue91b\ue940\ue965\ue98a\ue9af\ue9d4\ue9f9\uea1e\uea43", 1479903010469813773L, "\uefca\uefef\uf014\uf039\uf05e\uf083\uf0a8\uf0cd\uf0f2\uf117\uf13c\uf161\uf186\uf1ab\uf1d0\uf1f5\uf21a\uf23f", 1232645111, "\uf6e8\uf70d\uf732\uf757\uf77c\uf7a1\uf7c6\uf7eb\ue010\ue035\ue05a\ue07f\ue0a4\ue0c9\ue0ee\ue113", false, "\ue606\ue62b\ue650\ue675\ue69a\ue6bf\ue6e4\ue709\ue72e\ue753\ue778\ue79d\ue7c2", false, "\ued24\ued49\ued6e\ued93\uedb8\ueddd\uee02\uee27\uee4c\uee71\uee96\ueebb", false, "\uf442\uf467\uf48c\uf4b1\uf4d6\uf4fb\uf520\uf545\uf56a", false}, {"\ue9ad\ue9d2\ue9f7\uea1c\uea41\uea66\uea8b\ueab0\uead5\ueafa\ueb1f\ueb44\ueb69\ueb8e\uebb3\uebd8", 1479903010469879310L, "\uf0cb\uf0f0\uf115\uf13a\uf15f\uf184\uf1a9\uf1ce\uf1f3\uf218\uf23d\uf262\uf287", 454095528, "\uf7e9\ue00e\ue033\ue058\ue07d\ue0a2\ue0c7\ue0ec\ue111\ue136\ue15b\ue180\ue1a5\ue1ca\ue1ef\ue214\ue239\ue25e", true, "\ue707\ue72c\ue751\ue776\ue79b\ue7c0\ue7e5\ue80a\ue82f\ue854\ue879\ue89e\ue8c3\ue8e8\ue90d\ue932", true, "\uee25\uee4a\uee6f\uee94\ueeb9\ueede\uef03\uef28\uef4d\uef72", true, "\uf543\uf568\uf58d\uf5b2\uf5d7\uf5fc\uf621\uf646\uf66b\uf690\uf6b5\uf6da\uf6ff\uf724", true}, {"\ueaae\uead3\ueaf8\ueb1d\ueb42\ueb67\ueb8c\uebb1\uebd6\uebfb\uec20\uec45\uec6a\uec8f\uecb4\uecd9\uecfe\ued23", 1479903010469944847L, "\uf1cc\uf1f1\uf216\uf23b\uf260\uf285\uf2aa\uf2cf\uf2f4\uf319\uf33e\uf363\uf388\uf3ad\uf3d2\uf3f7", -326617023, "\ue0ea\ue10f\ue134\ue159\ue17e\ue1a3\ue1c8\ue1ed\ue212\ue237\ue25c\ue281\ue2a6", false, "\ue808\ue82d\ue852\ue877\ue89c\ue8c1\ue8e6\ue90b\ue930\ue955\ue97a\ue99f", false, "\uef26\uef4b\uef70\uef95\uefba\uefdf\uf004\uf029\uf04e", false, "\uf644\uf669\uf68e\uf6b3\uf6d8\uf6fd\uf722\uf747", false}, {"\uebaf\uebd4\uebf9\uec1e\uec43\uec68\uec8d\uecb2\uecd7\uecfc\ued21\ued46\ued6b", 1479903010470010384L, "\uf2cd\uf2f2\uf317\uf33c\uf361\uf386\uf3ab\uf3d0\uf3f5\uf41a\uf43f\uf464\uf489\uf4ae\uf4d3\uf4f8\uf51d\uf542", -1105197062, "\ue1eb\ue210\ue235\ue25a\ue27f\ue2a4\ue2c9\ue2ee\ue313\ue338\ue35d\ue382\ue3a7\ue3cc\ue3f1\ue416", true, "\ue909\ue92e\ue953\ue978\ue99d\ue9c2\ue9e7\uea0c\uea31\uea56", true, "\uf027\uf04c\uf071\uf096\uf0bb\uf0e0\uf105\uf12a\uf14f\uf174\uf199\uf1be\uf1e3\uf208", true, "\uf745\uf76a\uf78f\uf7b4\uf7d9\uf7fe\ue023\ue048", true}, {"\uecb0\uecd5\uecfa\ued1f\ued44\ued69\ued8e\uedb3\uedd8\uedfd\uee22\uee47\uee6c\uee91\ueeb6\ueedb", 1479903010470075921L, "\uf3ce\uf3f3\uf418\uf43d\uf462\uf487\uf4ac\uf4d1\uf4f6\uf51b\uf540\uf565\uf58a", 265834131, "\ue2ec\ue311\ue336\ue35b\ue380\ue3a5\ue3ca\ue3ef\ue414\ue439\ue45e\ue483", false, "\uea0a\uea2f\uea54\uea79\uea9e\ueac3\ueae8\ueb0d\ueb32", false, "\uf128\uf14d\uf172\uf197\uf1bc\uf1e1\uf206\uf22b", false, "\ue046\ue06b\ue090\ue0b5\ue0da\ue0ff\ue124\ue149\ue16e\ue193\ue1b8\ue1dd\ue202\ue227", false}, {"\uedb1\uedd6\uedfb\uee20\uee45\uee6a\uee8f\ueeb4\ueed9\ueefe\uef23\uef48\uef6d\uef92\uefb7\uefdc\uf001\uf026", 1479903010470141458L, "\uf4cf\uf4f4\uf519\uf53e\uf563\uf588\uf5ad\uf5d2\uf5f7\uf61c\uf641\uf666\uf68b\uf6b0\uf6d5\uf6fa", -1049521100, "\ue3ed\ue412\ue437\ue45c\ue481\ue4a6\ue4cb\ue4f0\ue515\ue53a", true, "\ueb0b\ueb30\ueb55\ueb7a\ueb9f\uebc4\uebe9\uec0e\uec33\uec58\uec7d\ueca2\uecc7\uecec", true, "\uf229\uf24e\uf273\uf298\uf2bd\uf2e2\uf307\uf32c", true, "\ue147\ue16c\ue191\ue1b6\ue1db\ue200\ue225\ue24a\ue26f\ue294\ue2b9\ue2de\ue303\ue328\ue34d\ue372\ue397", true}, {"\ueeb2\ueed7\ueefc\uef21\uef46\uef6b\uef90\uefb5\uefda\uefff\uf024\uf049\uf06e", 1479903010470206995L, "\uf5d0\uf5f5\uf61a\uf63f\uf664\uf689\uf6ae\uf6d3\uf6f8\uf71d\uf742\uf767", -1830169619, "\ue4ee\ue513\ue538\ue55d\ue582\ue5a7\ue5cc\ue5f1\ue616", false, "\uec0c\uec31\uec56\uec7b\ueca0\uecc5\uecea\ued0f", false, "\uf32a\uf34f\uf374\uf399\uf3be\uf3e3\uf408\uf42d\uf452\uf477\uf49c\uf4c1\uf4e6\uf50b", false, "\ue248\ue26d\ue292\ue2b7\ue2dc\ue301\ue326\ue34b\ue370\ue395\ue3ba\ue3df", false}, {"\uefb3\uefd8\ueffd\uf022\uf047\uf06c\uf091\uf0b6\uf0db\uf100\uf125\uf14a\uf16f\uf194\uf1b9\uf1de", 1479903010470272532L, "\uf6d1\uf6f6\uf71b\uf740\uf765\uf78a\uf7af\uf7d4\uf7f9\ue01e", 1686182534, "\ue5ef\ue614\ue639\ue65e\ue683\ue6a8\ue6cd\ue6f2\ue717\ue73c\ue761\ue786\ue7ab\ue7d0", true, "\ued0d\ued32\ued57\ued7c\ueda1\uedc6\uedeb\uee10", true, "\uf42b\uf450\uf475\uf49a\uf4bf\uf4e4\uf509\uf52e\uf553\uf578\uf59d\uf5c2\uf5e7\uf60c\uf631\uf656\uf67b", true, "\ue349\ue36e\ue393\ue3b8\ue3dd\ue402\ue427\ue44c\ue471\ue496\ue4bb\ue4e0\ue505\ue52a\ue54f\ue574", true}, {"\uf0b4\uf0d9\uf0fe\uf123\uf148\uf16d\uf192\uf1b7\uf1dc\uf201\uf226\uf24b", 1479903010470338069L, "\uf7d2\uf7f7\ue01c\ue041\ue066\ue08b\ue0b0\ue0d5\ue0fa", 909729855, "\ue6f0\ue715\ue73a\ue75f\ue784\ue7a9\ue7ce\ue7f3", false, "\uee0e\uee33\uee58\uee7d\ueea2\ueec7\ueeec\uef11\uef36\uef5b\uef80\uefa5\uefca\uefef", false, "\uf52c\uf551\uf576\uf59b\uf5c0\uf5e5\uf60a\uf62f\uf654\uf679\uf69e\uf6c3", false, "\ue44a\ue46f\ue494\ue4b9\ue4de\ue503\ue528\ue54d\ue572\ue597\ue5bc\ue5e1\ue606\ue62b\ue650\ue675\ue69a\ue6bf", false}, {"\uf1b5\uf1da\uf1ff\uf224\uf249\uf26e\uf293\uf2b8\uf2dd\uf302", 1479903010470403606L, "\ue0d3\ue0f8\ue11d\ue142\ue167\ue18c\ue1b1\ue1d6\ue1fb\ue220\ue245\ue26a\ue28f\ue2b4", -2016235568, "\ue7f1\ue816\ue83b\ue860\ue885\ue8aa\ue8cf\ue8f4", true, "\uef0f\uef34\uef59\uef7e\uefa3\uefc8\uefed\uf012\uf037\uf05c\uf081\uf0a6\uf0cb\uf0f0\uf115\uf13a\uf15f", true, "\uf62d\uf652\uf677\uf69c\uf6c1\uf6e6\uf70b\uf730\uf755\uf77a\uf79f\uf7c4\uf7e9\ue00e\ue033\ue058", true, "\ue54b\ue570\ue595\ue5ba\ue5df\ue604\ue629\ue64e\ue673\ue698\ue6bd\ue6e2\ue707", true}, {"\uf2b6\uf2db\uf300\uf325\uf34a\uf36f\uf394\uf3b9\uf3de", 1479903010470469143L, "\ue1d4\ue1f9\ue21e\ue243\ue268\ue28d\ue2b2\ue2d7", 1498085001, "\ue8f2\ue917\ue93c\ue961\ue986\ue9ab\ue9d0\ue9f5\uea1a\uea3f\uea64\uea89\ueaae\uead3", false, "\uf010\uf035\uf05a\uf07f\uf0a4\uf0c9\uf0ee\uf113\uf138\uf15d\uf182\uf1a7", false, "\uf72e\uf753\uf778\uf79d\uf7c2\uf7e7\ue00c\ue031\ue056\ue07b\ue0a0\ue0c5\ue0ea\ue10f\ue134\ue159\ue17e\ue1a3", false, "\ue64c\ue671\ue696\ue6bb\ue6e0\ue705\ue72a\ue74f\ue774\ue799\ue7be\ue7e3\ue808\ue82d\ue852\ue877", false}, {"\uf3b7\uf3dc\uf401\uf426\uf44b\uf470\uf495\uf4ba\uf4df\uf504\uf529\uf54e\uf573\uf598", 1479903010470534680L, "\ue2d5\ue2fa\ue31f\ue344\ue369\ue38e\ue3b3\ue3d8", 719469602, "\ue9f3\uea18\uea3d\uea62\uea87\ueaac\uead1\ueaf6\ueb1b\ueb40\ueb65\ueb8a\uebaf\uebd4\uebf9\uec1e\uec43", true, "\uf111\uf136\uf15b\uf180\uf1a5\uf1ca\uf1ef\uf214\uf239\uf25e\uf283\uf2a8\uf2cd\uf2f2\uf317\uf33c", true, "\ue02f\ue054\ue079\ue09e\ue0c3\ue0e8\ue10d\ue132\ue157\ue17c\ue1a1\ue1c6\ue1eb", true, "\ue74d\ue772\ue797\ue7bc\ue7e1\ue806\ue82b\ue850\ue875\ue89a\ue8bf\ue8e4\ue909\ue92e\ue953\ue978\ue99d\ue9c2", true}, {"\uf4b8\uf4dd\uf502\uf527\uf54c\uf571\uf596\uf5bb", 1479903010470600217L, "\ue3d6\ue3fb\ue420\ue445\ue46a\ue48f\ue4b4\ue4d9\ue4fe\ue523\ue548\ue56d\ue592\ue5b7", -56984613, "\ueaf4\ueb19\ueb3e\ueb63\ueb88\uebad\uebd2\uebf7\uec1c\uec41\uec66\uec8b", false, "\uf212\uf237\uf25c\uf281\uf2a6\uf2cb\uf2f0\uf315\uf33a\uf35f\uf384\uf3a9\uf3ce\uf3f3\uf418\uf43d\uf462\uf487", false, "\ue130\ue155\ue17a\ue19f\ue1c4\ue1e9\ue20e\ue233\ue258\ue27d\ue2a2\ue2c7\ue2ec\ue311\ue336\ue35b", false, "\ue84e\ue873\ue898\ue8bd\ue8e2\ue907\ue92c\ue951\ue976\ue99b\ue9c0\ue9e5\uea0a", false}, {"\uf5b9\uf5de\uf603\uf628\uf64d\uf672\uf697\uf6bc", 1479903010470665754L, "\ue4d7\ue4fc\ue521\ue546\ue56b\ue590\ue5b5\ue5da\ue5ff\ue624\ue649\ue66e\ue693\ue6b8\ue6dd\ue702\ue727", 1311916412, "\uebf5\uec1a\uec3f\uec64\uec89\uecae\uecd3\uecf8\ued1d\ued42\ued67\ued8c\uedb1\uedd6\uedfb\uee20", true, "\uf313\uf338\uf35d\uf382\uf3a7\uf3cc\uf3f1\uf416\uf43b\uf460\uf485\uf4aa\uf4cf", true, "\ue231\ue256\ue27b\ue2a0\ue2c5\ue2ea\ue30f\ue334\ue359\ue37e\ue3a3\ue3c8\ue3ed\ue412\ue437\ue45c\ue481\ue4a6", true, "\ue94f\ue974\ue999\ue9be\ue9e3\uea08\uea2d\uea52\uea77\uea9c\ueac1\ueae6\ueb0b\ueb30\ueb55\ueb7a", true}, {"\uf6ba\uf6df\uf704\uf729\uf74e\uf773\uf798\uf7bd\uf7e2\ue007\ue02c\ue051\ue076\ue09b", 1479903010470731291L, "\ue5d8\ue5fd\ue622\ue647\ue66c\ue691\ue6b6\ue6db\ue700\ue725\ue74a\ue76f", 531335189, "\uecf6\ued1b\ued40\ued65\ued8a\uedaf\uedd4\uedf9\uee1e\uee43\uee68\uee8d\ueeb2\ueed7\ueefc\uef21\uef46\uef6b", false, "\uf414\uf439\uf45e\uf483\uf4a8\uf4cd\uf4f2\uf517\uf53c\uf561\uf586\uf5ab\uf5d0\uf5f5\uf61a\uf63f", false, "\ue332\ue357\ue37c\ue3a1\ue3c6\ue3eb\ue410\ue435\ue45a\ue47f\ue4a4\ue4c9\ue4ee", false, "\uea50\uea75\uea9a\ueabf\ueae4\ueb09\ueb2e\ueb53\ueb78\ueb9d\uebc2\uebe7", false}, {"\uf7bb\uf7e0\ue005\ue02a\ue04f\ue074\ue099\ue0be\ue0e3\ue108\ue12d\ue152\ue177\ue19c\ue1c1\ue1e6\ue20b", 1479903010470796828L, "\ue6d9\ue6fe\ue723\ue748\ue76d\ue792\ue7b7\ue7dc\ue801\ue826\ue84b\ue870\ue895\ue8ba\ue8df\ue904", -784082994, "\uedf7\uee1c\uee41\uee66\uee8b\ueeb0\ueed5\ueefa\uef1f\uef44\uef69\uef8e\uefb3", true, "\uf515\uf53a\uf55f\uf584\uf5a9\uf5ce\uf5f3\uf618\uf63d\uf662\uf687\uf6ac\uf6d1\uf6f6\uf71b\uf740\uf765\uf78a", true, "\ue433\ue458\ue47d\ue4a2\ue4c7\ue4ec\ue511\ue536\ue55b\ue580\ue5a5\ue5ca\ue5ef\ue614\ue639\ue65e", true, "\ueb51\ueb76\ueb9b\uebc0\uebe5\uec0a\uec2f\uec54\uec79\uec9e", true}, {"\ue0bc\ue0e1\ue106\ue12b\ue150\ue175\ue19a\ue1bf\ue1e4\ue209\ue22e\ue253", 1479903010470862365L, "\ue7da\ue7ff\ue824\ue849\ue86e\ue893\ue8b8\ue8dd\ue902\ue927\ue94c\ue971\ue996\ue9bb\ue9e0\uea05\uea2a\uea4f", -1560601241, "\ueef8\uef1d\uef42\uef67\uef8c\uefb1\uefd6\ueffb\uf020\uf045\uf06a\uf08f\uf0b4\uf0d9\uf0fe\uf123", false, "\uf616\uf63b\uf660\uf685\uf6aa\uf6cf\uf6f4\uf719\uf73e\uf763\uf788\uf7ad\uf7d2", false, "\ue534\ue559\ue57e\ue5a3\ue5c8\ue5ed\ue612\ue637\ue65c\ue681\ue6a6\ue6cb", false, "\uec52\uec77\uec9c\uecc1\uece6\ued0b\ued30\ued55\ued7a", false}, {"\ue1bd\ue1e2\ue207\ue22c\ue251\ue276\ue29b\ue2c0\ue2e5\ue30a\ue32f\ue354\ue379\ue39e\ue3c3\ue3e8", 1479903010470927902L, "\ue8db\ue900\ue925\ue94a\ue96f\ue994\ue9b9\ue9de\uea03\uea28\uea4d\uea72\uea97", 1955816472, "\ueff9\uf01e\uf043\uf068\uf08d\uf0b2\uf0d7\uf0fc\uf121\uf146\uf16b\uf190\uf1b5\uf1da\uf1ff\uf224\uf249\uf26e", true, "\uf717\uf73c\uf761\uf786\uf7ab\uf7d0\uf7f5\ue01a\ue03f\ue064\ue089\ue0ae\ue0d3\ue0f8\ue11d\ue142", true, "\ue635\ue65a\ue67f\ue6a4\ue6c9\ue6ee\ue713\ue738\ue75d\ue782", true, "\ued53\ued78\ued9d\uedc2\uede7\uee0c\uee31\uee56\uee7b\ueea0\ueec5\ueeea\uef0f\uef34", true}, {"\ue2be\ue2e3\ue308\ue32d\ue352\ue377\ue39c\ue3c1\ue3e6\ue40b\ue430\ue455\ue47a\ue49f\ue4c4\ue4e9\ue50e\ue533", 1479903010470993439L, "\ue9dc\uea01\uea26\uea4b\uea70\uea95\ueaba\ueadf\ueb04\ueb29\ueb4e\ueb73\ueb98\uebbd\uebe2\uec07", -972250191, "\uf0fa\uf11f\uf144\uf169\uf18e\uf1b3\uf1d8\uf1fd\uf222\uf247\uf26c\uf291\uf2b6", false, "\ue018\ue03d\ue062\ue087\ue0ac\ue0d1\ue0f6\ue11b\ue140\ue165\ue18a\ue1af", false, "\ue736\ue75b\ue780\ue7a5\ue7ca\ue7ef\ue814\ue839\ue85e", false, "\uee54\uee79\uee9e\ueec3\ueee8\uef0d\uef32\uef57", false}, {"\ue3bf\ue3e4\ue409\ue42e\ue453\ue478\ue49d\ue4c2\ue4e7\ue50c\ue531\ue556\ue57b", 1479903010471058976L, "\ueadd\ueb02\ueb27\ueb4c\ueb71\ueb96\uebbb\uebe0\uec05\uec2a\uec4f\uec74\uec99\uecbe\uece3\ued08\ued2d\ued52", -1750800022, "\uf1fb\uf220\uf245\uf26a\uf28f\uf2b4\uf2d9\uf2fe\uf323\uf348\uf36d\uf392\uf3b7\uf3dc\uf401\uf426", true, "\ue119\ue13e\ue163\ue188\ue1ad\ue1d2\ue1f7\ue21c\ue241\ue266", true, "\ue837\ue85c\ue881\ue8a6\ue8cb\ue8f0\ue915\ue93a\ue95f\ue984\ue9a9\ue9ce\ue9f3\uea18", true, "\uef55\uef7a\uef9f\uefc4\uefe9\uf00e\uf033\uf058", true}, {"\ue4c0\ue4e5\ue50a\ue52f\ue554\ue579\ue59e\ue5c3\ue5e8\ue60d\ue632\ue657\ue67c\ue6a1\ue6c6\ue6eb", 1479903010471124513L, "\uebde\uec03\uec28\uec4d\uec72\uec97\uecbc\uece1\ued06\ued2b\ued50\ued75\ued9a", 1767649283, "\uf2fc\uf321\uf346\uf36b\uf390\uf3b5\uf3da\uf3ff\uf424\uf449\uf46e\uf493", false, "\ue21a\ue23f\ue264\ue289\ue2ae\ue2d3\ue2f8\ue31d\ue342", false, "\ue938\ue95d\ue982\ue9a7\ue9cc\ue9f1\uea16\uea3b", false, "\uf056\uf07b\uf0a0\uf0c5\uf0ea\uf10f\uf134\uf159\uf17e\uf1a3\uf1c8\uf1ed\uf212\uf237", false}, {"\ue5c1\ue5e6\ue60b\ue630\ue655\ue67a\ue69f\ue6c4\ue6e9\ue70e\ue733\ue758\ue77d\ue7a2\ue7c7\ue7ec\ue811\ue836", 1479903010471190050L, "\uecdf\ued04\ued29\ued4e\ued73\ued98\uedbd\uede2\uee07\uee2c\uee51\uee76\uee9b\ueec0\ueee5\uef0a", 989101988, "\uf3fd\uf422\uf447\uf46c\uf491\uf4b6\uf4db\uf500\uf525\uf54a", true, "\ue31b\ue340\ue365\ue38a\ue3af\ue3d4\ue3f9\ue41e\ue443\ue468\ue48d\ue4b2\ue4d7\ue4fc", true, "\uea39\uea5e\uea83\ueaa8\ueacd\ueaf2\ueb17\ueb3c", true, "\uf157\uf17c\uf1a1\uf1c6\uf1eb\uf210\uf235\uf25a\uf27f\uf2a4\uf2c9\uf2ee\uf313\uf338\uf35d\uf382\uf3a7", true}, {"\ue6c2\ue6e7\ue70c\ue731\ue756\ue77b\ue7a0\ue7c5\ue7ea\ue80f\ue834\ue859\ue87e", 1479903010471255587L, "\uede0\uee05\uee2a\uee4f\uee74\uee99\ueebe\ueee3\uef08\uef2d\uef52\uef77", -1939061411, "\uf4fe\uf523\uf548\uf56d\uf592\uf5b7\uf5dc\uf601\uf626", false, "\ue41c\ue441\ue466\ue48b\ue4b0\ue4d5\ue4fa\ue51f", false, "\ueb3a\ueb5f\ueb84\ueba9\uebce\uebf3\uec18\uec3d\uec62\uec87\uecac\uecd1\uecf6\ued1b", false, "\uf258\uf27d\uf2a2\uf2c7\uf2ec\uf311\uf336\uf35b\uf380\uf3a5\uf3ca\uf3ef", false}, {"\ue7c3\ue7e8\ue80d\ue832\ue857\ue87c\ue8a1\ue8c6\ue8eb\ue910\ue935\ue95a\ue97f\ue9a4\ue9c9\ue9ee", 1479903010471321124L, "\ueee1\uef06\uef2b\uef50\uef75\uef9a\uefbf\uefe4\uf009\uf02e", 1577422070, "\uf5ff\uf624\uf649\uf66e\uf693\uf6b8\uf6dd\uf702\uf727\uf74c\uf771\uf796\uf7bb\uf7e0", true, "\ue51d\ue542\ue567\ue58c\ue5b1\ue5d6\ue5fb\ue620", true, "\uec3b\uec60\uec85\uecaa\ueccf\uecf4\ued19\ued3e\ued63\ued88\uedad\uedd2\uedf7\uee1c\uee41\uee66\uee8b", true, "\uf359\uf37e\uf3a3\uf3c8\uf3ed\uf412\uf437\uf45c\uf481\uf4a6\uf4cb\uf4f0\uf515\uf53a\uf55f\uf584", true}, {"\ue8c4\ue8e9\ue90e\ue933\ue958\ue97d\ue9a2\ue9c7\ue9ec\uea11\uea36\uea5b", 1479903010471386661L, "\uefe2\uf007\uf02c\uf051\uf076\uf09b\uf0c0\uf0e5\uf10a", 800967599, "\uf700\uf725\uf74a\uf76f\uf794\uf7b9\uf7de\ue003", false, "\ue61e\ue643\ue668\ue68d\ue6b2\ue6d7\ue6fc\ue721\ue746\ue76b\ue790\ue7b5\ue7da\ue7ff", false, "\ued3c\ued61\ued86\uedab\uedd0\uedf5\uee1a\uee3f\uee64\uee89\ueeae\ueed3", false, "\uf45a\uf47f\uf4a4\uf4c9\uf4ee\uf513\uf538\uf55d\uf582\uf5a7\uf5cc\uf5f1\uf616\uf63b\uf660\uf685\uf6aa\uf6cf", false}, {"\ue9c5\ue9ea\uea0f\uea34\uea59\uea7e\ueaa3\ueac8\ueaed\ueb12", 1479903010471452198L, "\uf0e3\uf108\uf12d\uf152\uf177\uf19c\uf1c1\uf1e6\uf20b\uf230\uf255\uf27a\uf29f\uf2c4", -514518720, "\ue001\ue026\ue04b\ue070\ue095\ue0ba\ue0df\ue104", true, "\ue71f\ue744\ue769\ue78e\ue7b3\ue7d8\ue7fd\ue822\ue847\ue86c\ue891\ue8b6\ue8db\ue900\ue925\ue94a\ue96f", true, "\uee3d\uee62\uee87\ueeac\ueed1\ueef6\uef1b\uef40\uef65\uef8a\uefaf\uefd4\ueff9\uf01e\uf043\uf068", true, "\uf55b\uf580\uf5a5\uf5ca\uf5ef\uf614\uf639\uf65e\uf683\uf6a8\uf6cd\uf6f2\uf717", true}, {"\ueac6\ueaeb\ueb10\ueb35\ueb5a\ueb7f\ueba4\uebc9\uebee", 1479903010471517735L, "\uf1e4\uf209\uf22e\uf253\uf278\uf29d\uf2c2\uf2e7", -1295165191, "\ue102\ue127\ue14c\ue171\ue196\ue1bb\ue1e0\ue205\ue22a\ue24f\ue274\ue299\ue2be\ue2e3", false, "\ue820\ue845\ue86a\ue88f\ue8b4\ue8d9\ue8fe\ue923\ue948\ue96d\ue992\ue9b7", false, "\uef3e\uef63\uef88\uefad\uefd2\ueff7\uf01c\uf041\uf066\uf08b\uf0b0\uf0d5\uf0fa\uf11f\uf144\uf169\uf18e\uf1b3", false, "\uf65c\uf681\uf6a6\uf6cb\uf6f0\uf715\uf73a\uf75f\uf784\uf7a9\uf7ce\uf7f3\ue018\ue03d\ue062\ue087", false}, {"\uebc7\uebec\uec11\uec36\uec5b\uec80\ueca5\uecca\uecef\ued14\ued39\ued5e\ued83\ueda8", 1479903010471583272L, "\uf2e5\uf30a\uf32f\uf354\uf379\uf39e\uf3c3\uf3e8", 73836434, "\ue203\ue228\ue24d\ue272\ue297\ue2bc\ue2e1\ue306\ue32b\ue350\ue375\ue39a\ue3bf\ue3e4\ue409\ue42e\ue453", true, "\ue921\ue946\ue96b\ue990\ue9b5\ue9da\ue9ff\uea24\uea49\uea6e\uea93\ueab8\ueadd\ueb02\ueb27\ueb4c", true, "\uf03f\uf064\uf089\uf0ae\uf0d3\uf0f8\uf11d\uf142\uf167\uf18c\uf1b1\uf1d6\uf1fb", true, "\uf75d\uf782\uf7a7\uf7cc\uf7f1\ue016\ue03b\ue060\ue085\ue0aa\ue0cf\ue0f4\ue119\ue13e\ue163\ue188\ue1ad\ue1d2", true}, {"\uecc8\ueced\ued12\ued37\ued5c\ued81\ueda6\uedcb", 1479903010471648809L, "\uf3e6\uf40b\uf430\uf455\uf47a\uf49f\uf4c4\uf4e9\uf50e\uf533\uf558\uf57d\uf5a2\uf5c7", -702616245, "\ue304\ue329\ue34e\ue373\ue398\ue3bd\ue3e2\ue407\ue42c\ue451\ue476\ue49b", false, "\uea22\uea47\uea6c\uea91\ueab6\ueadb\ueb00\ueb25\ueb4a\ueb6f\ueb94\uebb9\uebde\uec03\uec28\uec4d\uec72\uec97", false, "\uf140\uf165\uf18a\uf1af\uf1d4\uf1f9\uf21e\uf243\uf268\uf28d\uf2b2\uf2d7\uf2fc\uf321\uf346\uf36b", false, "\ue05e\ue083\ue0a8\ue0cd\ue0f2\ue117\ue13c\ue161\ue186\ue1ab\ue1d0\ue1f5\ue21a", false}, {"\uedc9\uedee\uee13\uee38\uee5d\uee82\ueea7\ueecc", 1479903010471714346L, "\uf4e7\uf50c\uf531\uf556\uf57b\uf5a0\uf5c5\uf5ea\uf60f\uf634\uf659\uf67e\uf6a3\uf6c8\uf6ed\uf712\uf737", -1481231124, "\ue405\ue42a\ue44f\ue474\ue499\ue4be\ue4e3\ue508\ue52d\ue552\ue577\ue59c\ue5c1\ue5e6\ue60b\ue630", true, "\ueb23\ueb48\ueb6d\ueb92\uebb7\uebdc\uec01\uec26\uec4b\uec70\uec95\uecba\uecdf", true, "\uf241\uf266\uf28b\uf2b0\uf2d5\uf2fa\uf31f\uf344\uf369\uf38e\uf3b3\uf3d8\uf3fd\uf422\uf447\uf46c\uf491\uf4b6", true, "\ue15f\ue184\ue1a9\ue1ce\ue1f3\ue218\ue23d\ue262\ue287\ue2ac\ue2d1\ue2f6\ue31b\ue340\ue365\ue38a", true}, {"\ueeca\ueeef\uef14\uef39\uef5e\uef83\uefa8\uefcd\ueff2\uf017\uf03c\uf061\uf086\uf0ab", 1479903010471779883L, "\uf5e8\uf60d\uf632\uf657\uf67c\uf6a1\uf6c6\uf6eb\uf710\uf735\uf75a\uf77f", 2033087365, "\ue506\ue52b\ue550\ue575\ue59a\ue5bf\ue5e4\ue609\ue62e\ue653\ue678\ue69d\ue6c2\ue6e7\ue70c\ue731\ue756\ue77b", false, "\uec24\uec49\uec6e\uec93\uecb8\uecdd\ued02\ued27\ued4c\ued71\ued96\uedbb\uede0\uee05\uee2a\uee4f", false, "\uf342\uf367\uf38c\uf3b1\uf3d6\uf3fb\uf420\uf445\uf46a\uf48f\uf4b4\uf4d9\uf4fe", false, "\ue260\ue285\ue2aa\ue2cf\ue2f4\ue319\ue33e\ue363\ue388\ue3ad\ue3d2\ue3f7", false}, {"\uefcb\ueff0\uf015\uf03a\uf05f\uf084\uf0a9\uf0ce\uf0f3\uf118\uf13d\uf162\uf187\uf1ac\uf1d1\uf1f6\uf21b", 1479903010471845420L, "\uf6e9\uf70e\uf733\uf758\uf77d\uf7a2\uf7c7\uf7ec\ue011\ue036\ue05b\ue080\ue0a5\ue0ca\ue0ef\ue114", -892880578, "\ue607\ue62c\ue651\ue676\ue69b\ue6c0\ue6e5\ue70a\ue72f\ue754\ue779\ue79e\ue7c3", true, "\ued25\ued4a\ued6f\ued94\uedb9\uedde\uee03\uee28\uee4d\uee72\uee97\ueebc\ueee1\uef06\uef2b\uef50\uef75\uef9a", true, "\uf443\uf468\uf48d\uf4b2\uf4d7\uf4fc\uf521\uf546\uf56b\uf590\uf5b5\uf5da\uf5ff\uf624\uf649\uf66e", true, "\ue361\ue386\ue3ab\ue3d0\ue3f5\ue41a\ue43f\ue464\ue489\ue4ae", true}, {"\uf0cc\uf0f1\uf116\uf13b\uf160\uf185\uf1aa\uf1cf\uf1f4\uf219\uf23e\uf263", 1479903010471910957L, "\uf7ea\ue00f\ue034\ue059\ue07e\ue0a3\ue0c8\ue0ed\ue112\ue137\ue15c\ue181\ue1a6\ue1cb\ue1f0\ue215\ue23a\ue25f", -1669365545, "\ue708\ue72d\ue752\ue777\ue79c\ue7c1\ue7e6\ue80b\ue830\ue855\ue87a\ue89f\ue8c4\ue8e9\ue90e\ue933", false, "\uee26\uee4b\uee70\uee95\ueeba\ueedf\uef04\uef29\uef4e\uef73\uef98\uefbd\uefe2", false, "\uf544\uf569\uf58e\uf5b3\uf5d8\uf5fd\uf622\uf647\uf66c\uf691\uf6b6\uf6db", false, "\ue462\ue487\ue4ac\ue4d1\ue4f6\ue51b\ue540\ue565\ue58a", false}, {"\uf1cd\uf1f2\uf217\uf23c\uf261\uf286\uf2ab\uf2d0\uf2f5\uf31a\uf33f\uf364\uf389\uf3ae\uf3d3\uf3f8", 1479903010471976494L, "\ue0eb\ue110\ue135\ue15a\ue17f\ue1a4\ue1c9\ue1ee\ue213\ue238\ue25d\ue282\ue2a7", 1847054216, "\ue809\ue82e\ue853\ue878\ue89d\ue8c2\ue8e7\ue90c\ue931\ue956\ue97b\ue9a0\ue9c5\ue9ea\uea0f\uea34\uea59\uea7e", true, "\uef27\uef4c\uef71\uef96\uefbb\uefe0\uf005\uf02a\uf04f\uf074\uf099\uf0be\uf0e3\uf108\uf12d\uf152", true, "\uf645\uf66a\uf68f\uf6b4\uf6d9\uf6fe\uf723\uf748\uf76d\uf792", true, "\ue563\ue588\ue5ad\ue5d2\ue5f7\ue61c\ue641\ue666\ue68b\ue6b0\ue6d5\ue6fa\ue71f\ue744", true}, {"\uf2ce\uf2f3\uf318\uf33d\uf362\uf387\uf3ac\uf3d1\uf3f6\uf41b\uf440\uf465\uf48a\uf4af\uf4d4\uf4f9\uf51e\uf543", 1479903010472042031L, "\ue1ec\ue211\ue236\ue25b\ue280\ue2a5\ue2ca\ue2ef\ue314\ue339\ue35e\ue383\ue3a8\ue3cd\ue3f2\ue417", 1066341665, "\ue90a\ue92f\ue954\ue979\ue99e\ue9c3\ue9e8\uea0d\uea32\uea57\uea7c\ueaa1\ueac6", false, "\uf028\uf04d\uf072\uf097\uf0bc\uf0e1\uf106\uf12b\uf150\uf175\uf19a\uf1bf", false, "\uf746\uf76b\uf790\uf7b5\uf7da\uf7ff\ue024\ue049\ue06e", false, "\ue664\ue689\ue6ae\ue6d3\ue6f8\ue71d\ue742\ue767", false}, {"\uf3cf\uf3f4\uf419\uf43e\uf463\uf488\uf4ad\uf4d2\uf4f7\uf51c\uf541\uf566\uf58b", 1479903010472107568L, "\ue2ed\ue312\ue337\ue35c\ue381\ue3a6\ue3cb\ue3f0\ue415\ue43a\ue45f\ue484\ue4a9\ue4ce\ue4f3\ue518\ue53d\ue562", -249078566, "\uea0b\uea30\uea55\uea7a\uea9f\ueac4\ueae9\ueb0e\ueb33\ueb58\ueb7d\ueba2\uebc7\uebec\uec11\uec36", true, "\uf129\uf14e\uf173\uf198\uf1bd\uf1e2\uf207\uf22c\uf251\uf276", true, "\ue047\ue06c\ue091\ue0b6\ue0db\ue100\ue125\ue14a\ue16f\ue194\ue1b9\ue1de\ue203\ue228", true, "\ue765\ue78a\ue7af\ue7d4\ue7f9\ue81e\ue843\ue868", true}, {"\uf4d0\uf4f5\uf51a\uf53f\uf564\uf589\uf5ae\uf5d3\uf5f8\uf61d\uf642\uf667\uf68c\uf6b1\uf6d6\uf6fb", 1479903010472173105L, "\ue3ee\ue413\ue438\ue45d\ue482\ue4a7\ue4cc\ue4f1\ue516\ue53b\ue560\ue585\ue5aa", 1119918707, "\ueb0c\ueb31\ueb56\ueb7b\ueba0\uebc5\uebea\uec0f\uec34\uec59\uec7e\ueca3", false, "\uf22a\uf24f\uf274\uf299\uf2be\uf2e3\uf308\uf32d\uf352", false, "\ue148\ue16d\ue192\ue1b7\ue1dc\ue201\ue226\ue24b", false, "\ue866\ue88b\ue8b0\ue8d5\ue8fa\ue91f\ue944\ue969\ue98e\ue9b3\ue9d8\ue9fd\uea22\uea47", false}, {"\uf5d1\uf5f6\uf61b\uf640\uf665\uf68a\uf6af\uf6d4\uf6f9\uf71e\uf743\uf768\uf78d\uf7b2\uf7d7\uf7fc\ue021\ue046", 1479903010472238642L, "\ue4ef\ue514\ue539\ue55e\ue583\ue5a8\ue5cd\ue5f2\ue617\ue63c\ue661\ue686\ue6ab\ue6d0\ue6f5\ue71a", 343466260, "\uec0d\uec32\uec57\uec7c\ueca1\uecc6\ueceb\ued10\ued35\ued5a", true, "\uf32b\uf350\uf375\uf39a\uf3bf\uf3e4\uf409\uf42e\uf453\uf478\uf49d\uf4c2\uf4e7\uf50c", true, "\ue249\ue26e\ue293\ue2b8\ue2dd\ue302\ue327\ue34c", true, "\ue967\ue98c\ue9b1\ue9d6\ue9fb\uea20\uea45\uea6a\uea8f\ueab4\uead9\ueafe\ueb23\ueb48\ueb6d\ueb92\uebb7", true}, {"\uf6d2\uf6f7\uf71c\uf741\uf766\uf78b\uf7b0\uf7d5\uf7fa\ue01f\ue044\ue069\ue08e", 1479903010472304179L, "\ue5f0\ue615\ue63a\ue65f\ue684\ue6a9\ue6ce\ue6f3\ue718\ue73d\ue762\ue787", -435148595, "\ued0e\ued33\ued58\ued7d\ueda2\uedc7\uedec\uee11\uee36", false, "\uf42c\uf451\uf476\uf49b\uf4c0\uf4e5\uf50a\uf52f", false, "\ue34a\ue36f\ue394\ue3b9\ue3de\ue403\ue428\ue44d\ue472\ue497\ue4bc\ue4e1\ue506\ue52b", false, "\uea68\uea8d\ueab2\uead7\ueafc\ueb21\ueb46\ueb6b\ueb90\uebb5\uebda\uebff", false}, {"\uf7d3\uf7f8\ue01d\ue042\ue067\ue08c\ue0b1\ue0d6\ue0fb\ue120\ue145\ue16a\ue18f\ue1b4\ue1d9\ue1fe", 1479903010472369716L, "\ue6f1\ue716\ue73b\ue760\ue785\ue7aa\ue7cf\ue7f4\ue819\ue83e", -1215793562, "\uee0f\uee34\uee59\uee7e\ueea3\ueec8\ueeed\uef12\uef37\uef5c\uef81\uefa6\uefcb\ueff0", true, "\uf52d\uf552\uf577\uf59c\uf5c1\uf5e6\uf60b\uf630", true, "\ue44b\ue470\ue495\ue4ba\ue4df\ue504\ue529\ue54e\ue573\ue598\ue5bd\ue5e2\ue607\ue62c\ue651\ue676\ue69b", true, "\ueb69\ueb8e\uebb3\uebd8\uebfd\uec22\uec47\uec6c\uec91\uecb6\uecdb\ued00\ued25\ued4a\ued6f\ued94", true}, {"\ue0d4\ue0f9\ue11e\ue143\ue168\ue18d\ue1b2\ue1d7\ue1fc\ue221\ue246\ue26b", 1479903010472435253L, "\ue7f2\ue817\ue83c\ue861\ue886\ue8ab\ue8d0\ue8f5\ue91a", 153206047, "\uef10\uef35\uef5a\uef7f\uefa4\uefc9\uefee\uf013", false, "\uf62e\uf653\uf678\uf69d\uf6c2\uf6e7\uf70c\uf731\uf756\uf77b\uf7a0\uf7c5\uf7ea\ue00f", false, "\ue54c\ue571\ue596\ue5bb\ue5e0\ue605\ue62a\ue64f\ue674\ue699\ue6be\ue6e3", false, "\uec6a\uec8f\uecb4\uecd9\uecfe\ued23\ued48\ued6d\ued92\uedb7\ueddc\uee01\uee26\uee4b\uee70\uee95\ueeba\ueedf", false}, {"\ue1d5\ue1fa\ue21f\ue244\ue269\ue28e\ue2b3\ue2d8\ue2fd\ue322", 1479903010472500790L, "\ue8f3\ue918\ue93d\ue962\ue987\ue9ac\ue9d1\ue9f6\uea1b\uea40\uea65\uea8a\ueaaf\uead4", -623278928, "\uf011\uf036\uf05b\uf080\uf0a5\uf0ca\uf0ef\uf114", true, "\uf72f\uf754\uf779\uf79e\uf7c3\uf7e8\ue00d\ue032\ue057\ue07c\ue0a1\ue0c6\ue0eb\ue110\ue135\ue15a\ue17f", true, "\ue64d\ue672\ue697\ue6bc\ue6e1\ue706\ue72b\ue750\ue775\ue79a\ue7bf\ue7e4\ue809\ue82e\ue853\ue878", true, "\ued6b\ued90\uedb5\uedda\uedff\uee24\uee49\uee6e\uee93\ueeb8\ueedd\uef02\uef27", true}, {"\ue2d6\ue2fb\ue320\ue345\ue36a\ue38f\ue3b4\ue3d9\ue3fe", 1479903010472566327L, "\ue9f4\uea19\uea3e\uea63\uea88\ueaad\uead2\ueaf7", -1401830807, "\uf112\uf137\uf15c\uf181\uf1a6\uf1cb\uf1f0\uf215\uf23a\uf25f\uf284\uf2a9\uf2ce\uf2f3", false, "\ue030\ue055\ue07a\ue09f\ue0c4\ue0e9\ue10e\ue133\ue158\ue17d\ue1a2\ue1c7", false, "\ue74e\ue773\ue798\ue7bd\ue7e2\ue807\ue82c\ue851\ue876\ue89b\ue8c0\ue8e5\ue90a\ue92f\ue954\ue979\ue99e\ue9c3", false, "\uee6c\uee91\ueeb6\ueedb\uef00\uef25\uef4a\uef6f\uef94\uefb9\uefde\uf003\uf028\uf04d\uf072\uf097", false}, {"\ue3d7\ue3fc\ue421\ue446\ue46b\ue490\ue4b5\ue4da\ue4ff\ue524\ue549\ue56e\ue593\ue5b8", 1479903010472631864L, "\ueaf5\ueb1a\ueb3f\ueb64\ueb89\uebae\uebd3\uebf8", 2112424194, "\uf213\uf238\uf25d\uf282\uf2a7\uf2cc\uf2f1\uf316\uf33b\uf360\uf385\uf3aa\uf3cf\uf3f4\uf419\uf43e\uf463", true, "\ue131\ue156\ue17b\ue1a0\ue1c5\ue1ea\ue20f\ue234\ue259\ue27e\ue2a3\ue2c8\ue2ed\ue312\ue337\ue35c", true, "\ue84f\ue874\ue899\ue8be\ue8e3\ue908\ue92d\ue952\ue977\ue99c\ue9c1\ue9e6\uea0b", true, "\uef6d\uef92\uefb7\uefdc\uf001\uf026\uf04b\uf070\uf095\uf0ba\uf0df\uf104\uf129\uf14e\uf173\uf198\uf1bd\uf1e2", true}, {"\ue4d8\ue4fd\ue522\ue547\ue56c\ue591\ue5b6\ue5db", 1479903010472697401L, "\uebf6\uec1b\uec40\uec65\uec8a\uecaf\uecd4\uecf9\ued1e\ued43\ued68\ued8d\uedb2\uedd7", -813608773, "\uf314\uf339\uf35e\uf383\uf3a8\uf3cd\uf3f2\uf417\uf43c\uf461\uf486\uf4ab", false, "\ue232\ue257\ue27c\ue2a1\ue2c6\ue2eb\ue310\ue335\ue35a\ue37f\ue3a4\ue3c9\ue3ee\ue413\ue438\ue45d\ue482\ue4a7", false, "\ue950\ue975\ue99a\ue9bf\ue9e4\uea09\uea2e\uea53\uea78\uea9d\ueac2\ueae7\ueb0c\ueb31\ueb56\ueb7b", false, "\uf06e\uf093\uf0b8\uf0dd\uf102\uf127\uf14c\uf171\uf196\uf1bb\uf1e0\uf205\uf22a", false}, {"\ue5d9\ue5fe\ue623\ue648\ue66d\ue692\ue6b7\ue6dc", 1479903010472762938L, "\uecf7\ued1c\ued41\ued66\ued8b\uedb0\uedd5\uedfa\uee1f\uee44\uee69\uee8e\ueeb3\ueed8\ueefd\uef22\uef47", -2126864804, "\uf415\uf43a\uf45f\uf484\uf4a9\uf4ce\uf4f3\uf518\uf53d\uf562\uf587\uf5ac\uf5d1\uf5f6\uf61b\uf640", true, "\ue333\ue358\ue37d\ue3a2\ue3c7\ue3ec\ue411\ue436\ue45b\ue480\ue4a5\ue4ca\ue4ef", true, "\uea51\uea76\uea9b\ueac0\ueae5\ueb0a\ueb2f\ueb54\ueb79\ueb9e\uebc3\uebe8\uec0d\uec32\uec57\uec7c\ueca1\uecc6", true, "\uf16f\uf194\uf1b9\uf1de\uf203\uf228\uf24d\uf272\uf297\uf2bc\uf2e1\uf306\uf32b\uf350\uf375\uf39a", true}, {"\ue6da\ue6ff\ue724\ue749\ue76e\ue793\ue7b8\ue7dd\ue802\ue827\ue84c\ue871\ue896\ue8bb", 1479903010472828475L, "\uedf8\uee1d\uee42\uee67\uee8c\ueeb1\ueed6\ueefb\uef20\uef45\uef6a\uef8f", 1389553141, "\uf516\uf53b\uf560\uf585\uf5aa\uf5cf\uf5f4\uf619\uf63e\uf663\uf688\uf6ad\uf6d2\uf6f7\uf71c\uf741\uf766\uf78b", false, "\ue434\ue459\ue47e\ue4a3\ue4c8\ue4ed\ue512\ue537\ue55c\ue581\ue5a6\ue5cb\ue5f0\ue615\ue63a\ue65f", false, "\ueb52\ueb77\ueb9c\uebc1\uebe6\uec0b\uec30\uec55\uec7a\uec9f\uecc4\uece9\ued0e", false, "\uf270\uf295\uf2ba\uf2df\uf304\uf329\uf34e\uf373\uf398\uf3bd\uf3e2\uf407", false}, {"\ue7db\ue800\ue825\ue84a\ue86f\ue894\ue8b9\ue8de\ue903\ue928\ue94d\ue972\ue997\ue9bc\ue9e1\uea06\uea2b", 1479903010472894012L, "\ueef9\uef1e\uef43\uef68\uef8d\uefb2\uefd7\ueffc\uf021\uf046\uf06b\uf090\uf0b5\uf0da\uf0ff\uf124", 608840878, "\uf617\uf63c\uf661\uf686\uf6ab\uf6d0\uf6f5\uf71a\uf73f\uf764\uf789\uf7ae\uf7d3", true, "\ue535\ue55a\ue57f\ue5a4\ue5c9\ue5ee\ue613\ue638\ue65d\ue682\ue6a7\ue6cc\ue6f1\ue716\ue73b\ue760\ue785\ue7aa", true, "\uec53\uec78\uec9d\uecc2\uece7\ued0c\ued31\ued56\ued7b\ueda0\uedc5\uedea\uee0f\uee34\uee59\uee7e", true, "\uf371\uf396\uf3bb\uf3e0\uf405\uf42a\uf44f\uf474\uf499\uf4be", true}, {"\ue8dc\ue901\ue926\ue94b\ue970\ue995\ue9ba\ue9df\uea04\uea29\uea4e\uea73", 1479903010472959549L, "\ueffa\uf01f\uf044\uf069\uf08e\uf0b3\uf0d8\uf0fd\uf122\uf147\uf16c\uf191\uf1b6\uf1db\uf200\uf225\uf24a\uf26f", -169711033, "\uf718\uf73d\uf762\uf787\uf7ac\uf7d1\uf7f6\ue01b\ue040\ue065\ue08a\ue0af\ue0d4\ue0f9\ue11e\ue143", false, "\ue636\ue65b\ue680\ue6a5\ue6ca\ue6ef\ue714\ue739\ue75e\ue783\ue7a8\ue7cd\ue7f2", false, "\ued54\ued79\ued9e\uedc3\uede8\uee0d\uee32\uee57\uee7c\ueea1\ueec6\ueeeb", false, "\uf472\uf497\uf4bc\uf4e1\uf506\uf52b\uf550\uf575\uf59a", false}, {"\ue9dd\uea02\uea27\uea4c\uea71\uea96\ueabb\ueae0\ueb05\ueb2a\ueb4f\ueb74\ueb99\uebbe\uebe3\uec08", 1479903010473025086L, "\uf0fb\uf120\uf145\uf16a\uf18f\uf1b4\uf1d9\uf1fe\uf223\uf248\uf26d\uf292\uf2b7", 1201385976, "\ue019\ue03e\ue063\ue088\ue0ad\ue0d2\ue0f7\ue11c\ue141\ue166\ue18b\ue1b0\ue1d5\ue1fa\ue21f\ue244\ue269\ue28e", true, "\ue737\ue75c\ue781\ue7a6\ue7cb\ue7f0\ue815\ue83a\ue85f\ue884\ue8a9\ue8ce\ue8f3\ue918\ue93d\ue962", true, "\uee55\uee7a\uee9f\ueec4\ueee9\uef0e\uef33\uef58\uef7d\uefa2", true, "\uf573\uf598\uf5bd\uf5e2\uf607\uf62c\uf651\uf676\uf69b\uf6c0\uf6e5\uf70a\uf72f\uf754", true}, {"\ueade\ueb03\ueb28\ueb4d\ueb72\ueb97\uebbc\uebe1\uec06\uec2b\uec50\uec75\uec9a\uecbf\uece4\ued09\ued2e\ued53", 1479903010473090623L, "\uf1fc\uf221\uf246\uf26b\uf290\uf2b5\uf2da\uf2ff\uf324\uf349\uf36e\uf393\uf3b8\uf3dd\uf402\uf427", 422836369, "\ue11a\ue13f\ue164\ue189\ue1ae\ue1d3\ue1f8\ue21d\ue242\ue267\ue28c\ue2b1\ue2d6", false, "\ue838\ue85d\ue882\ue8a7\ue8cc\ue8f1\ue916\ue93b\ue960\ue985\ue9aa\ue9cf", false, "\uef56\uef7b\uefa0\uefc5\uefea\uf00f\uf034\uf059\uf07e", false, "\uf674\uf699\uf6be\uf6e3\uf708\uf72d\uf752\uf777", false}, {"\uebdf\uec04\uec29\uec4e\uec73\uec98\uecbd\uece2\ued07\ued2c\ued51\ued76\ued9b", 1479903010473156160L, "\uf2fd\uf322\uf347\uf36c\uf391\uf3b6\uf3db\uf400\uf425\uf44a\uf46f\uf494\uf4b9\uf4de\uf503\uf528\uf54d\uf572", -357841334, "\ue21b\ue240\ue265\ue28a\ue2af\ue2d4\ue2f9\ue31e\ue343\ue368\ue38d\ue3b2\ue3d7\ue3fc\ue421\ue446", true, "\ue939\ue95e\ue983\ue9a8\ue9cd\ue9f2\uea17\uea3c\uea61\uea86", true, "\uf057\uf07c\uf0a1\uf0c6\uf0eb\uf110\uf135\uf15a\uf17f\uf1a4\uf1c9\uf1ee\uf213\uf238", true, "\uf775\uf79a\uf7bf\uf7e4\ue009\ue02e\ue053\ue078", true}, {"\uece0\ued05\ued2a\ued4f\ued74\ued99\uedbe\uede3\uee08\uee2d\uee52\uee77\uee9c\ueec1\ueee6\uef0b", 1479903010473221697L, "\uf3fe\uf423\uf448\uf46d\uf492\uf4b7\uf4dc\uf501\uf526\uf54b\uf570\uf595\uf5ba", -1136456221, "\ue31c\ue341\ue366\ue38b\ue3b0\ue3d5\ue3fa\ue41f\ue444\ue469\ue48e\ue4b3", false, "\uea3a\uea5f\uea84\ueaa9\ueace\ueaf3\ueb18\ueb3d\ueb62", false, "\uf158\uf17d\uf1a2\uf1c7\uf1ec\uf211\uf236\uf25b", false, "\ue076\ue09b\ue0c0\ue0e5\ue10a\ue12f\ue154\ue179\ue19e\ue1c3\ue1e8\ue20d\ue232\ue257", false}, {"\uede1\uee06\uee2b\uee50\uee75\uee9a\ueebf\ueee4\uef09\uef2e\uef53\uef78\uef9d\uefc2\uefe7\uf00c\uf031\uf056", 1479903010473287234L, "\uf4ff\uf524\uf549\uf56e\uf593\uf5b8\uf5dd\uf602\uf627\uf64c\uf671\uf696\uf6bb\uf6e0\uf705\uf72a", 234574980, "\ue41d\ue442\ue467\ue48c\ue4b1\ue4d6\ue4fb\ue520\ue545\ue56a", true, "\ueb3b\ueb60\ueb85\uebaa\uebcf\uebf4\uec19\uec3e\uec63\uec88\uecad\uecd2\uecf7\ued1c", true, "\uf259\uf27e\uf2a3\uf2c8\uf2ed\uf312\uf337\uf35c", true, "\ue177\ue19c\ue1c1\ue1e6\ue20b\ue230\ue255\ue27a\ue29f\ue2c4\ue2e9\ue30e\ue333\ue358\ue37d\ue3a2\ue3c7", true}, {"\ueee2\uef07\uef2c\uef51\uef76\uef9b\uefc0\uefe5\uf00a\uf02f\uf054\uf079\uf09e", 1479903010473352771L, "\uf600\uf625\uf64a\uf66f\uf694\uf6b9\uf6de\uf703\uf728\uf74d\uf772\uf797", -543911363, "\ue51e\ue543\ue568\ue58d\ue5b2\ue5d7\ue5fc\ue621\ue646", false, "\uec3c\uec61\uec86\uecab\uecd0\uecf5\ued1a\ued3f", false, "\uf35a\uf37f\uf3a4\uf3c9\uf3ee\uf413\uf438\uf45d\uf482\uf4a7\uf4cc\uf4f1\uf516\uf53b", false, "\ue278\ue29d\ue2c2\ue2e7\ue30c\ue331\ue356\ue37b\ue3a0\ue3c5\ue3ea\ue40f", false}, {"\uefe3\uf008\uf02d\uf052\uf077\uf09c\uf0c1\uf0e6\uf10b\uf130\uf155\uf17a\uf19f\uf1c4\uf1e9\uf20e", 1479903010473418308L, "\uf701\uf726\uf74b\uf770\uf795\uf7ba\uf7df\ue004\ue029\ue04e", -1861428778, "\ue61f\ue644\ue669\ue68e\ue6b3\ue6d8\ue6fd\ue722\ue747\ue76c\ue791\ue7b6\ue7db\ue800", true, "\ued3d\ued62\ued87\uedac\uedd1\uedf6\uee1b\uee40", true, "\uf45b\uf480\uf4a5\uf4ca\uf4ef\uf514\uf539\uf55e\uf583\uf5a8\uf5cd\uf5f2\uf617\uf63c\uf661\uf686\uf6ab", true, "\ue379\ue39e\ue3c3\ue3e8\ue40d\ue432\ue457\ue47c\ue4a1\ue4c6\ue4eb\ue510\ue535\ue55a\ue57f\ue5a4", true}, {"\uf0e4\uf109\uf12e\uf153\uf178\uf19d\uf1c2\uf1e7\uf20c\uf231\uf256\uf27b", 1479903010473483845L, "\ue002\ue027\ue04c\ue071\ue096\ue0bb\ue0e0\ue105\ue12a", 1654923407, "\ue720\ue745\ue76a\ue78f\ue7b4\ue7d9\ue7fe\ue823", false, "\uee3e\uee63\uee88\ueead\ueed2\ueef7\uef1c\uef41\uef66\uef8b\uefb0\uefd5\ueffa\uf01f", false, "\uf55c\uf581\uf5a6\uf5cb\uf5f0\uf615\uf63a\uf65f\uf684\uf6a9\uf6ce\uf6f3", false, "\ue47a\ue49f\ue4c4\ue4e9\ue50e\ue533\ue558\ue57d\ue5a2\ue5c7\ue5ec\ue611\ue636\ue65b\ue680\ue6a5\ue6ca\ue6ef", false}, {"\uf1e5\uf20a\uf22f\uf254\uf279\uf29e\uf2c3\uf2e8\uf30d\uf332", 1479903010473549382L, "\ue103\ue128\ue14d\ue172\ue197\ue1bc\ue1e1\ue206\ue22b\ue250\ue275\ue29a\ue2bf\ue2e4", 878472736, "\ue821\ue846\ue86b\ue890\ue8b5\ue8da\ue8ff\ue924", true, "\uef3f\uef64\uef89\uefae\uefd3\ueff8\uf01d\uf042\uf067\uf08c\uf0b1\uf0d6\uf0fb\uf120\uf145\uf16a\uf18f", true, "\uf65d\uf682\uf6a7\uf6cc\uf6f1\uf716\uf73b\uf760\uf785\uf7aa\uf7cf\uf7f4\ue019\ue03e\ue063\ue088", true, "\ue57b\ue5a0\ue5c5\ue5ea\ue60f\ue634\ue659\ue67e\ue6a3\ue6c8\ue6ed\ue712\ue737", true}, {"\uf2e6\uf30b\uf330\uf355\uf37a\uf39f\uf3c4\uf3e9\uf40e", 1479903010473614919L, "\ue204\ue229\ue24e\ue273\ue298\ue2bd\ue2e2\ue307", -2047494695, "\ue922\ue947\ue96c\ue991\ue9b6\ue9db\uea00\uea25\uea4a\uea6f\uea94\ueab9\ueade\ueb03", false, "\uf040\uf065\uf08a\uf0af\uf0d4\uf0f9\uf11e\uf143\uf168\uf18d\uf1b2\uf1d7", false, "\uf75e\uf783\uf7a8\uf7cd\uf7f2\ue017\ue03c\ue061\ue086\ue0ab\ue0d0\ue0f5\ue11a\ue13f\ue164\ue189\ue1ae\ue1d3", false, "\ue67c\ue6a1\ue6c6\ue6eb\ue710\ue735\ue75a\ue77f\ue7a4\ue7c9\ue7ee\ue813\ue838\ue85d\ue882\ue8a7", false}, {"\uf3e7\uf40c\uf431\uf456\uf47b\uf4a0\uf4c5\uf4ea\uf50f\uf534\uf559\uf57e\uf5a3\uf5c8", 1479903010473680456L, "\ue305\ue32a\ue34f\ue374\ue399\ue3be\ue3e3\ue408", 1466823538, "\uea23\uea48\uea6d\uea92\ueab7\ueadc\ueb01\ueb26\ueb4b\ueb70\ueb95\uebba\uebdf\uec04\uec29\uec4e\uec73", true, "\uf141\uf166\uf18b\uf1b0\uf1d5\uf1fa\uf21f\uf244\uf269\uf28e\uf2b3\uf2d8\uf2fd\uf322\uf347\uf36c", true, "\ue05f\ue084\ue0a9\ue0ce\ue0f3\ue118\ue13d\ue162\ue187\ue1ac\ue1d1\ue1f6\ue21b", true, "\ue77d\ue7a2\ue7c7\ue7ec\ue811\ue836\ue85b\ue880\ue8a5\ue8ca\ue8ef\ue914\ue939\ue95e\ue983\ue9a8\ue9cd\ue9f2", true}};
        byte[] v0 = "f\u00b5:\u00f6a\u0016^W\u00b8N4\u0088\u001f\u0012\u00ee\u00b3]\u00d9H\u00c7\u00bc_jE\u00b4x\u00a4\u00ca\u00c3\n\u0083\u00ca\u00f2\u00d5rt\u00ce)J\u00bc/\u0099r>\u00b3\u0094\u00cdl%o#\u0091\u00b2\u008b\u00cf\u0003a\u00bdd\u00ec\u009a-\u00b8\u0098\r\u0015\u00f3_\u00c0\u00d6\ts|J\u0011\u00d3\u00d8\u00c2\u0085\u00cb\u00d1U\u0099\u00f4\u00f9r\u00f7#'T&\u00a6\u0017\u00e5\u00cbQs;dm\u0004GMx\u001e\u0097\u00eby\u00d3\u001a\u0099\u00bb-Q\u00de\u00a3\u008b\u00ef\u0002\u001b\u0016\u008f\u00ed\u00a3\u00bat\u0094Y\u0083k\u0088WB\u001d\u000ek\u0012\u007f\u0018\u00a1\u0095|\u00f4\u00ce2\u00e3\u00b6_\u00ea\u00c5\b\u0011\u00f2\t\u008a\u0007\u00f7G\u000bQ\u009b\u00ba\u001b\u0099\u0013+N\u00a5\u000e7l\u00fdh\u00d4\u000e>\u000e\u00d7\u00c5\u0018~%\u0081\u00c4`O\u001d\u00e5\u008e\u00afD\u009f\u00f1+\u0090S\u0011\u00e5\u007f\u008c\u00f8\u0092\b\u0080\u009c\u0018\u00d2\u00fb\u00ab\u00a0KV\u00ae)x\u0000\u0095\u00fe8\u009f\u00cf]\bI\u00a7\u000f>B~\u0091\u00b4(\u00a9\u00d0bN\u007f\u00af\u00f2\u00c8)\u00f8U\u00dc\u0080\u008e\u009a\u00b0=\u00b9\u0085\u00db8\u000f\u00baIX\u00c3$^A\u00e2\u00a1\u00e8".getBytes("ISO_8859_1");
        Object[] v1 = "\u00f3{+2\u00ea\u00bflB".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 1045323844;
                case 1 -> -209362957;
                case 2 -> -1262306740;
                case 3 -> -1263828306;
                case 4 -> -1491103130;
                case 5 -> 569343766;
                case 6 -> -1084100834;
                case 7 -> -1928186695;
                case 8 -> -717469964;
                case 9 -> 265201170;
                case 10 -> -532783222;
                case 11 -> 1786431867;
                case 12 -> -1871355344;
                case 13 -> -1974918360;
                case 14 -> -386343260;
                case 15 -> 545405398;
                case 16 -> 1248239564;
                case 17 -> -1546682995;
                case 18 -> 1901780370;
                case 19 -> -1628759056;
                case 20 -> 608320238;
                case 21 -> 2060601308;
                case 22 -> -1799740085;
                case 23 -> -1643211263;
                case 24 -> -177972143;
                case 25 -> -1963929078;
                case 26 -> -978069767;
                case 27 -> 1736058199;
                case 28 -> -1669648325;
                case 29 -> -1528151643;
                case 30 -> -2145133289;
                case 31 -> -1274456031;
                case 32 -> 206441807;
                case 33 -> 1714338947;
                case 34 -> 501048042;
                case 35 -> -1139215176;
                case 36 -> -620806841;
                case 37 -> -1836657163;
                case 38 -> 1912328934;
                case 39 -> -127725491;
                case 40 -> 1950956538;
                case 41 -> 1428376901;
                case 42 -> 132875574;
                case 43 -> 2028609577;
                case 44 -> 1441888931;
                case 45 -> -87566833;
                case 46 -> 566504642;
                case 47 -> 223544054;
                case 48 -> 783813533;
                case 49 -> -1058571125;
                case 50 -> 1954446813;
                case 51 -> 225214654;
                case 52 -> 615297184;
                case 53 -> 1974587982;
                case 54 -> 2066865403;
                case 55 -> 1403315087;
                case 56 -> -1790494101;
                case 57 -> -1216605007;
                case 58 -> 1411242991;
                case 59 -> -1005291557;
                case 60 -> 153761844;
                case 61 -> 115461175;
                case 62 -> -301013874;
                case 63 -> -2083639034;
                case 64 -> -464233006;
                case 65 -> -1163084919;
                case 66 -> -907252840;
                case 67 -> 731237064;
                case 68 -> 854991981;
                case 69 -> 1598818944;
                case 70 -> 1580361024;
                case 71 -> -919795283;
                case 72 -> 1214676883;
                case 73 -> -1851848909;
                case 74 -> -671157185;
                case 75 -> 1365247884;
                case 76 -> 1108001642;
                case 77 -> -430443772;
                case 78 -> 1383629890;
                case 79 -> 1158849266;
                case 80 -> -1062011111;
                case 81 -> -1602248180;
                case 82 -> -387989924;
                case 83 -> 722436796;
                case 84 -> -1053986999;
                case 85 -> -1830094828;
                case 86 -> 887364368;
                case 87 -> 830162746;
                case 88 -> -1377251773;
                case 89 -> -2046853427;
                case 90 -> -1056379137;
                case 91 -> -1026238292;
                case 92 -> -391731172;
                case 93 -> 1563727109;
                case 94 -> -783008527;
                case 95 -> 899016456;
                case 96 -> -776212028;
                case 97 -> 1116936428;
                case 98 -> 845132142;
                case 99 -> 2031423000;
                case 100 -> -76577374;
                case 101 -> -1706207065;
                case 102 -> -1015577186;
                case 103 -> -528663978;
                case 104 -> -655665008;
                case 105 -> -106573439;
                case 106 -> 1660564672;
                case 107 -> -205245852;
                case 108 -> -97619311;
                case 109 -> -486865885;
                case 110 -> 803684625;
                case 111 -> -1463521500;
                case 112 -> 1186662322;
                case 113 -> 1899187797;
                case 114 -> -1749388254;
                case 115 -> 574397285;
                case 116 -> -1197653942;
                case 117 -> 1059829457;
                case 118 -> -141273050;
                case 119 -> 1102670859;
                case 120 -> -1105425874;
                case 121 -> -797380732;
                case 122 -> 981979705;
                case 123 -> 311733205;
                case 124 -> -1691189333;
                case 125 -> 804923856;
                case 126 -> -1880090296;
                case 127 -> -1853972588;
                case 128 -> 838843405;
                case 129 -> -1028566118;
                case 130 -> 1127317760;
                case 131 -> 867511393;
                case 132 -> 1680356451;
                case 133 -> -632488498;
                case 134 -> -847592549;
                case 135 -> 358506305;
                case 136 -> 2072371159;
                case 137 -> 252439769;
                case 138 -> 1094959562;
                case 139 -> 95565747;
                case 140 -> -2143695075;
                case 141 -> 73602610;
                case 142 -> 966914270;
                case 143 -> 200924569;
                case 144 -> 839975005;
                case 145 -> -346905883;
                case 146 -> 73000736;
                case 147 -> 673754038;
                case 148 -> 884178886;
                case 149 -> -790689499;
                case 150 -> 1622100;
                case 151 -> 1328915162;
                case 152 -> 1718202594;
                case 153 -> -890270374;
                case 154 -> 1203190723;
                case 155 -> 748829064;
                case 156 -> -374550402;
                case 157 -> 572757608;
                case 158 -> 454288253;
                case 159 -> 1644536693;
                case 160 -> 259327992;
                case 161 -> 809808398;
                case 162 -> -718233889;
                case 163 -> -1857947467;
                case 164 -> -1937205246;
                case 165 -> 1494431695;
                case 166 -> 689137029;
                case 167 -> -663036901;
                case 168 -> -1942683176;
                case 169 -> 310893985;
                case 170 -> 1253116413;
                case 171 -> -834956821;
                case 172 -> -1340852966;
                case 173 -> -1299923874;
                case 174 -> 1109677226;
                case 175 -> -357267112;
                case 176 -> -1676862152;
                case 177 -> -1097562694;
                case 178 -> 216192376;
                case 179 -> 1859581705;
                case 180 -> -1595924909;
                case 181 -> -553716482;
                case 182 -> 902050409;
                case 183 -> -1248403588;
                case 184 -> -1819977881;
                case 185 -> -1251623530;
                case 186 -> -121121731;
                case 187 -> -989680083;
                case 188 -> 497794999;
                case 189 -> -1869778593;
                case 190 -> -707774878;
                case 191 -> 1718181821;
                case 192 -> 1627746128;
                case 193 -> -282444942;
                case 194 -> 357187743;
                case 195 -> -457792148;
                case 196 -> -989943021;
                case 197 -> -1564455487;
                case 198 -> 1445618612;
                case 199 -> 1354676137;
                case 200 -> 709001331;
                case 201 -> 371486304;
                case 202 -> -586124609;
                case 203 -> 984194695;
                case 204 -> -1840704356;
                case 205 -> 824773429;
                case 206 -> 1409180203;
                case 207 -> -1203227932;
                case 208 -> -396827557;
                case 209 -> -1060593582;
                case 210 -> -1206030992;
                case 211 -> 1075520934;
                case 212 -> -165306052;
                case 213 -> 1759936326;
                case 214 -> -892321849;
                case 215 -> -361317772;
                case 216 -> 1842113329;
                case 217 -> 1858808382;
                case 218 -> -469222711;
                case 219 -> -2085348397;
                case 220 -> 781617377;
                case 221 -> 571593346;
                case 222 -> 415163143;
                case 223 -> 504063235;
                case 224 -> -1360468789;
                case 225 -> 286309551;
                case 226 -> 1490292858;
                case 227 -> 2109722344;
                case 228 -> -2057831187;
                case 229 -> 1444841669;
                case 230 -> 916744880;
                case 231 -> 1895405687;
                case 232 -> -96669142;
                case 233 -> 817016041;
                case 234 -> 800281084;
                case 235 -> 1816109145;
                case 236 -> 60944767;
                case 237 -> 1484758203;
                case 238 -> 1946044116;
                case 239 -> 1195162230;
                case 240 -> 204025887;
                case 241 -> 1569284839;
                case 242 -> -1338026987;
                case 243 -> -1046790031;
                case 244 -> -67951979;
                case 245 -> 1327740015;
                case 246 -> 1506226476;
                case 247 -> 1065578105;
                case 248 -> -1916949336;
                case 249 -> 1760478511;
                case 250 -> 1877933815;
                case 251 -> -2031127401;
                case 252 -> -2084604121;
                case 253 -> -929409658;
                case 254 -> -760418845;
                case 255 -> -321754656;
                default -> -1671451845;
            });
        } while (v2 != 264);
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
            Oiii = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        ConfigSupport_oii0_1 = 64;
        OiIO = 64;
        Oioi = 2.0f;
        NetworkSupport_oioi_6 = 12.0f;
        Oioo = 24.0f;
        OioO = 8;
        Oi0i = 5;
        i00 = 3;
        Oio0 = Identifier.of((String)"clap:icon/warning.png");
    }

    private boolean 0iI0(World param1, int param2, int param3, int param4, int param5, int param6) {
        int v7 = (param2 + param3) / 2;
        int v8 = (param5 + param6) / 2;
        int v9 = Math.max(param1.method_31607(), param4 - 16);
        int v10 = 0;
        int v11 = 0;
        int v12 = 0;
        BlockPos.Mutable v13 = new BlockPos.Mutable();
        for (int v14 = param4 - 1; v14 >= v9; --v14) {
            v13.set(v7, v14, v8);
            BlockState v15 = param1.method_8320((BlockPos)v13);
            if (!v15.method_26215() && !v15.method_26227().isEmpty() || !v15.method_26215() && v15.method_26216()) break;
            ++v10;
            for (Direction v17 : Direction.Type.HORIZONTAL) {
                v13.set(v7 + v17.getOffsetX(), v14, v8 + v17.getOffsetZ());
                ++v12;
                BlockState v18 = param1.method_8320((BlockPos)v13);
                if (v18.method_26215() || !v18.method_26227().isEmpty()) continue;
                ++v11;
            }
        }
        return v10 >= 4 && v12 > 0 && (double)v11 / (double)v12 >= 0.45;
    }

    private void oOOO(ScaledDrawContext param1, float param2, float param3, double param4) {
        float v6 = ((Double)this.RenderSupport_oiii_5.HelpCommand()).floatValue();
        int v7 = Math.max(6, Math.round(12.0f * v6));
        FontRenderer v8 = NetworkSupport_00OI.GuiSupport_OOI(v7);
        String v9 = "Trap";
        String v10 = "[";
        String v11 = Math.round(param4) + "m";
        String v12 = "]";
        int v13 = v8.GuiSupport_OOI(v9);
        int v14 = v8.GuiSupport_OOI(v10);
        int v15 = v8.GuiSupport_OOI(v11);
        int v16 = v8.GuiSupport_OOI(v12);
        int v17 = v13 + v14 + v15 + v16;
        float v18 = param2 - (float)v17 / 2.0f;
        param1.ConfigSupport_O0I().getMatrices().pushMatrix();
        v8.PacketEvent(param1.ConfigSupport_O0I(), v9, v18, param3, -41892);
        v8.PacketEvent(param1.ConfigSupport_O0I(), v10, v18 += (float)v13, param3, -6645094);
        v8.PacketEvent(param1.ConfigSupport_O0I(), v11, v18 += (float)v14, param3, -1);
        v8.PacketEvent(param1.ConfigSupport_O0I(), v12, v18 += (float)v15, param3, -6645094);
        param1.ConfigSupport_O0I().getMatrices().popMatrix();
    }

    private boolean 0ioi(int param1, int param2, int param3, boolean param4, boolean param5) {
        int v6 = (Integer)this.OiIo.HelpCommand();
        if (param1 < v6 || !param4) {
            return false;
        }
        if (param3 >= v6) {
            return true;
        }
        return param2 >= v6 && param5;
    }

    private void OO0o() {
        Thread v1;
        if (TrapDetectorModule.iooI() || this.iiO) {
            return;
        }
        this.iiO = true;
        this.iIi = v1 = new Thread(() -> {
            try {
                ClientWorld v1 = TrapDetectorModule.ConfigSupport_OI0.world;
                if (v1 == null || TrapDetectorModule.ConfigSupport_OI0.player == null) {
                    return;
                }
                RegistryKey v2 = v1.getRegistryKey();
                Map v3 = this.0ioO((World)v1);
                if (!Thread.currentThread().isInterrupted() && this.iiO && Thread.currentThread() == this.iIi && TrapDetectorModule.ConfigSupport_OI0.world == v1 && TrapDetectorModule.ConfigSupport_OI0.world.method_27983() == v2) {
                    this.0i0I((World)v1, v3);
                }
            }
            finally {
                if (Thread.currentThread() == this.iIi) {
                    this.iiO = false;
                }
            }
        }, "TrapDetector-Scanner");
        this.iIi.setDaemon(true);
        this.iIi.start();
    }

    private Map 0ioO(World param1) {
        BlockPos v2 = TrapDetectorModule.ConfigSupport_OI0.player.method_24515();
        int v3 = (Integer)this.ioO.HelpCommand();
        int v4 = v3 * v3;
        int v5 = Math.max(param1.method_31607(), v2.method_10264() - 64);
        int v6 = Math.min(param1.method_31600() - 1, v2.method_10264() - 2);
        if (v6 < v5) {
            return Map.of();
        }
        HashMap<BlockPos, DataRecord_OOI0> v7 = new HashMap<BlockPos, DataRecord_OOI0>();
        HashMap<Long, List> v8 = new HashMap<Long, List>();
        BlockPos.Mutable v9 = new BlockPos.Mutable();
        int v10 = Math.max(1, v3 + 15 >> 4);
        int v11 = v2.method_10263() >> 4;
        int v12 = v2.method_10260() >> 4;
        for (int v13 = v11 - v10; v13 <= v11 + v10; ++v13) {
            for (int v14 = v12 - v10; v14 <= v12 + v10; ++v14) {
                if (Thread.currentThread().isInterrupted() || !this.iiO) {
                    return Map.of();
                }
                WorldChunk v15 = param1.method_8398().getWorldChunk(v13, v14, false);
                if (v15 == null) continue;
                int v16 = v15.method_12004().getStartX();
                int v17 = v15.method_12004().getStartZ();
                for (int v18 = v16; v18 < v16 + 16; ++v18) {
                    int v19 = v18 - v2.method_10263();
                    for (int v20 = v17; v20 < v17 + 16; ++v20) {
                        int v21 = v20 - v2.method_10260();
                        if (v19 * v19 + v21 * v21 > v4) continue;
                        for (int v22 = v5; v22 <= v6; ++v22) {
                            v9.set(v18, v22, v20);
                            BlockState v23 = v15.method_8320((BlockPos)v9);
                            EnumType_O00I v24 = this.0iII(v23);
                            if (v24 == null) continue;
                            BlockPos v25 = v9.method_10062();
                            v7.put(v25, new DataRecord_OOI0(v25, v24, v23));
                            if (v24 != EnumType_O00I.o00) continue;
                            v8.computeIfAbsent(this.oOOi(v18, v20), param0 -> new ArrayList()).add(v22);
                        }
                    }
                }
            }
        }
        if (v7.isEmpty()) {
            return Map.of();
        }
        HashMap<BlockPos, DataRecord_0o0o_2> v13 = new HashMap<BlockPos, DataRecord_0o0o_2>();
        HashSet v14 = new HashSet();
        for (BlockPos v16 : v7.keySet()) {
            Set v17;
            DataRecord_0o0o_2 v18;
            if (v14.contains(v16) || (v18 = this.0ioI(v17 = this.0ioo(v16, v7, v14), v7, v8, param1)) == null) continue;
            v13.put(v18.ConfigSupport_oooi_3, v18);
        }
        return this.0iio(v13);
    }

    @Override
    public void ConfigSupport_oi0_2() {
        this.SettingContainer();
        this.PotionEffectsHudElement = System.currentTimeMillis();
        this.OO0o();
    }

    @Override
    public void 0oI() {
        this.FontRenderer();
        this.SettingContainer();
    }

    private void 0io0(World param1, int param22, int param3) {
        DataRecord_0o0o_2 v202;
        if (param1 == null || TrapDetectorModule.ConfigSupport_OI0.player == null) {
            return;
        }
        WorldChunk v4 = param1.method_8398().getWorldChunk(param22, param3, false);
        if (v4 == null) {
            return;
        }
        BlockPos v5 = TrapDetectorModule.ConfigSupport_OI0.player.method_24515();
        int v6 = (Integer)this.ioO.HelpCommand();
        int v7 = v6 * v6;
        int v8 = Math.max(param1.method_31607(), v5.method_10264() - 64);
        int v9 = Math.min(param1.method_31600() - 1, v5.method_10264() - 2);
        if (v9 < v8) {
            return;
        }
        HashMap<BlockPos, DataRecord_OOI0> v10 = new HashMap<BlockPos, DataRecord_OOI0>();
        HashMap<Long, List> v11 = new HashMap<Long, List>();
        BlockPos.Mutable v12 = new BlockPos.Mutable();
        int v13 = v4.method_12004().getStartX();
        int v14 = v4.method_12004().getStartZ();
        for (int v15 = v13; v15 < v13 + 16; ++v15) {
            int v16 = v15 - v5.method_10263();
            for (int v17 = v14; v17 < v14 + 16; ++v17) {
                int v18 = v17 - v5.method_10260();
                if (v16 * v16 + v18 * v18 > v7) continue;
                for (int v19 = v8; v19 <= v9; ++v19) {
                    v12.set(v15, v19, v17);
                    v202 = v4.method_8320((BlockPos)v12);
                    EnumType_O00I v21 = this.0iII((BlockState)v202);
                    if (v21 == null) continue;
                    BlockPos v22 = v12.method_10062();
                    v10.put(v22, new DataRecord_OOI0(v22, v21, (BlockState)v202));
                    if (v21 != EnumType_O00I.o00) continue;
                    v11.computeIfAbsent(this.oOOi(v15, v17), param0 -> new ArrayList()).add(v19);
                }
            }
        }
        HashMap<BlockPos, DataRecord_0o0o_2> v15 = new HashMap<BlockPos, DataRecord_0o0o_2>();
        HashSet v16 = new HashSet();
        for (BlockPos v18 : v10.keySet()) {
            Set v19;
            if (v16.contains(v18) || (v202 = this.0ioI(v19 = this.0ioo(v18, v10, v16), v10, v11, param1)) == null) continue;
            v15.put(v202.ConfigSupport_oooi_3, v202);
        }
        Map v17 = this.0iio(v15);
        this.OiiI.entrySet().removeIf(param4 -> this.oOOo((DataRecord_0o0o_2)param4.getValue(), param22, param3) && v17.values().stream().noneMatch(param2 -> this.0iiI((DataRecord_0o0o_2)param4.getValue(), (DataRecord_0o0o_2)param2)));
        for (DataRecord_0o0o_2 v19 : v17.values()) {
            boolean v202 = this.OiiI.values().stream().anyMatch(param2 -> this.0iiI((DataRecord_0o0o_2)param2, v19));
            if (v202) continue;
            this.OiiI.put(v19.ConfigSupport_oooi_3, v19);
        }
    }

    private Set 0ioo(BlockPos param1, Map param2, Set param3) {
        HashSet<BlockPos> v4 = new HashSet<BlockPos>();
        ArrayDeque<BlockPos> v5 = new ArrayDeque<BlockPos>();
        v5.add(param1);
        param3.add(param1);
        while (!v5.isEmpty()) {
            if (Thread.currentThread().isInterrupted() || !this.iiO) {
                return v4;
            }
            BlockPos v6 = (BlockPos)v5.poll();
            v4.add(v6);
            for (int v7 = -3; v7 <= 3; ++v7) {
                for (int v8 = -3; v8 <= 3; ++v8) {
                    for (int v9 = -3; v9 <= 3; ++v9) {
                        BlockPos v10;
                        if (v7 == 0 && v8 == 0 && v9 == 0 || param3.contains(v10 = v6.add(v7, v8, v9)) || !param2.containsKey(v10)) continue;
                        param3.add(v10);
                        v5.add(v10);
                    }
                }
            }
        }
        return v4;
    }

    private double iI0(Vec3d param1, Vec3d param2) {
        double v3 = param1.method_10216() - param2.method_10216();
        double v5 = param1.method_10214() - param2.method_10214();
        double v7 = param1.method_10215() - param2.method_10215();
        return v3 * v3 + v5 * v5 + v7 * v7;
    }

    private void 0iiO(BlockState param1, BlockPos param2, Map param3) {
        if (param1.method_28498((Property)Properties.FACING)) {
            param3.put(param2, (Direction)param1.method_11654((Property)Properties.FACING));
        }
    }

    private Map 0iio(Map param1) {
        if (param1.isEmpty()) {
            return param1;
        }
        HashMap<BlockPos, DataRecord_0o0o_2> v2 = new HashMap<BlockPos, DataRecord_0o0o_2>();
        for (DataRecord_0o0o_2 v4 : param1.values()) {
            BlockPos v5 = null;
            for (Map.Entry v7 : v2.entrySet()) {
                if (!this.0iiI(v4, (DataRecord_0o0o_2)v7.getValue())) continue;
                v5 = (BlockPos)v7.getKey();
                break;
            }
            if (v5 == null) {
                v2.put(v4.ConfigSupport_oooi_3, v4);
                continue;
            }
            DataRecord_0o0o_2 v6 = (DataRecord_0o0o_2)v2.get(v5);
            if (v4.Oo0i <= v6.Oo0i && !(v4.ScaledDrawContext > v6.ScaledDrawContext)) continue;
            v2.remove(v5);
            v2.put(v4.ConfigSupport_oooi_3, v4);
        }
        return v2;
    }

    private EnumType_O00I 0iII(BlockState param1) {
        Block v2 = param1.method_26204();
        if (v2 instanceof AbstractSignBlock) {
            return EnumType_O00I.o00;
        }
        if (v2 == Blocks.STICKY_PISTON) {
            return EnumType_O00I.o0I;
        }
        if (v2 == Blocks.PISTON) {
            return EnumType_O00I.NetworkSupport_o0o_0;
        }
        if (v2 instanceof PistonHeadBlock || v2 instanceof PistonExtensionBlock) {
            if (param1.method_28498((Property)Properties.PISTON_TYPE) && param1.method_11654((Property)Properties.PISTON_TYPE) == PistonType.STICKY) {
                return EnumType_O00I.RenderSupport_ooo_0;
            }
            return EnumType_O00I.SettingContainer;
        }
        return null;
    }

    @Override
    public void DataRecord_OO0O(ScaledDrawContext param1) {
        if (TrapDetectorModule.iooI() || this.OiiI.isEmpty()) {
            return;
        }
        Vec3d v2 = TrapDetectorModule.ConfigSupport_OI0.player.method_73189();
        double v3 = (double)((Integer)this.ioO.HelpCommand()).intValue() * (double)((Integer)this.ioO.HelpCommand()).intValue();
        ArrayList v5 = new ArrayList(this.OiiI.values());
        v5.sort((param2, param3) -> Double.compare(this.iI0(param2.OoOi, v2), this.iI0(param3.OoOi, v2)));
        int v6 = 0;
        for (DataRecord_0o0o_2 v8 : v5) {
            Vector3f v9;
            if (v6 >= 64) break;
            if (this.iI0(v8.OoOi, v2) > v3 || (v9 = RenderSupport_oiio_4.O0OII(new Vec3d(v8.PacketSendEvent, v8.ScaledDrawContext, v8.IrcManager))) == null) continue;
            double v10 = Math.sqrt(this.iI0(v8.OoOi, v2));
            this.0iii(param1, v9.x, v9.y, v10);
            ++v6;
        }
    }

    private void 0i0I(World param1, Map param22) {
        boolean v6;
        HashMap<BlockPos, DataRecord_0o0o_2> v3 = new HashMap<BlockPos, DataRecord_0o0o_2>(this.OiiI);
        for (DataRecord_0o0o_2 v5 : new ArrayList(v3.values())) {
            v6 = param22.values().stream().anyMatch(param2 -> this.0iiI(v5, (DataRecord_0o0o_2)param2));
            if (v6 || this.oOOI(param1, v5)) continue;
            v3.remove(v5.ConfigSupport_oooi_3);
        }
        for (DataRecord_0o0o_2 v5 : param22.values()) {
            v6 = v3.values().stream().anyMatch(param2 -> this.0iiI((DataRecord_0o0o_2)param2, v5));
            if (v6) continue;
            v3.put(v5.ConfigSupport_oooi_3, v5);
        }
        this.OiiI.clear();
        this.OiiI.putAll(v3);
    }

    private long oOOi(int param1, int param2) {
        return (long)param1 << 32 ^ (long)param2 & 0xFFFFFFFFL;
    }

    @Override
    public void SpawnerFinderModule() {
        if (TrapDetectorModule.iooI()) {
            this.OOoI();
            return;
        }
        if (this.i0i()) {
            this.OiiI.clear();
            this.PotionEffectsHudElement = System.currentTimeMillis();
            this.OO0o();
            return;
        }
        this.0i0i();
        long v1 = System.currentTimeMillis();
        if (!this.iiO && v1 - this.PotionEffectsHudElement >= (long)((Integer)this.io0.HelpCommand()).intValue() * 1000L) {
            this.PotionEffectsHudElement = v1;
            this.OO0o();
        }
    }

    @Override
    public void ConfigSupport_II0(RenderSupport_0ooi_1 param1) {
        if (TrapDetectorModule.iooI() || this.OiiI.isEmpty() || !((Boolean)this.Oii0.HelpCommand()).booleanValue()) {
            return;
        }
        MatrixStack v2 = param1.0ii();
        Vec3d v3 = TrapDetectorModule.ConfigSupport_OI0.player.method_73189();
        double v4 = (double)((Integer)this.ioO.HelpCommand()).intValue() * (double)((Integer)this.ioO.HelpCommand()).intValue();
        int v6 = 0;
        ArrayList v7 = new ArrayList(this.OiiI.values());
        v7.sort((param2, param3) -> Double.compare(this.iI0(param2.OoOi, v3), this.iI0(param3.OoOi, v3)));
        for (DataRecord_0o0o_2 v9 : v7) {
            if (v6 >= 64) break;
            if (this.iI0(v9.OoOi, v3) > v4) continue;
            GuiSupport_oi0o_0.OOIII(v2, v9.Oo0O, (Color)this.Oiio.HelpCommand(), 2.0f);
            ++v6;
        }
    }

    private int 0iIo(List param1) {
        if (param1 == null || param1.isEmpty()) {
            return 0;
        }
        param1.sort(Integer::compareTo);
        int v2 = 1;
        int v3 = 1;
        int v4 = (Integer)param1.get(0);
        for (int v5 = 1; v5 < param1.size(); ++v5) {
            int v6 = (Integer)param1.get(v5);
            if (v6 == v4) continue;
            v3 = v6 - v4 <= 1 ? ++v3 : 1;
            v2 = Math.max(v2, v3);
            v4 = v6;
        }
        return v2;
    }

    private int 0ii0(Map param1, double param2, double param4) {
        int v6 = 0;
        for (Map.Entry v8 : param1.entrySet()) {
            double v13;
            BlockPos v10;
            double v11;
            double v15;
            Direction v9 = (Direction)v8.getValue();
            if (v9.getAxis().isVertical() || (v15 = (v11 = param2 - ((double)(v10 = (BlockPos)v8.getKey()).method_10263() + 0.5)) * v11 + (v13 = param4 - ((double)v10.method_10260() + 0.5)) * v13) < 1.0E-6) continue;
            double v17 = 1.0 / Math.sqrt(v15);
            double v19 = (double)v9.getOffsetX() * (v11 * v17) + (double)v9.getOffsetZ() * (v13 * v17);
            if (!(v19 >= 0.55)) continue;
            ++v6;
        }
        return v6;
    }

    private double 0iIO(World param1, double param2, double param4, int param6) {
        int v7 = (int)Math.floor(param2);
        int v8 = (int)Math.floor(param4);
        int v9 = param1.method_8624(Heightmap.Type.WORLD_SURFACE, v7, v8);
        int v10 = Math.max(param6 + 1, v9 + 1);
        int v11 = Math.min(param1.method_31600() - 4, v9 + 8);
        BlockPos.Mutable v12 = new BlockPos.Mutable();
        for (int v13 = v10; v13 <= v11; ++v13) {
            v12.set(v7, v13, v8);
            BlockState v14 = param1.method_8320((BlockPos)v12);
            v12.set(v7, v13 + 1, v8);
            BlockState v15 = param1.method_8320((BlockPos)v12);
            if (!v14.method_26215() || !v15.method_26215()) continue;
            return (float)v13 + 2.0f;
        }
        return (float)v10 + 2.0f;
    }

    private DataRecord_0o0o_2 0ioI(Set param1, Map param2, Map param3, World param4) {
        boolean v39;
        if (param1.isEmpty()) {
            return null;
        }
        int v5 = 0;
        int v6 = 0;
        int v7 = 0;
        int v8 = 0;
        int v9 = 0;
        int v10 = 0;
        int v11 = 0;
        int v12 = Integer.MAX_VALUE;
        int v13 = Integer.MAX_VALUE;
        int v14 = Integer.MAX_VALUE;
        int v15 = Integer.MIN_VALUE;
        int v16 = Integer.MIN_VALUE;
        int v17 = Integer.MIN_VALUE;
        double v18 = 0.0;
        double v20 = 0.0;
        double v22 = 0.0;
        HashMap v24 = new HashMap();
        for (BlockPos v26 : param1) {
            DataRecord_OOI0 v27 = (DataRecord_OOI0)param2.get(v26);
            if (v27 == null) continue;
            switch (v27.WorldTimeModule.ordinal()) {
                case 0: {
                    ++v5;
                    if (v27.i00.method_26204() instanceof WallSignBlock) {
                        ++v6;
                    }
                    v11 = Math.max(v11, this.0iIo((List)param3.get(this.oOOi(v26.method_10263(), v26.method_10260()))));
                    break;
                }
                case 1: {
                    ++v7;
                    if (this.0iIi(v27.i00)) {
                        ++v10;
                    }
                    this.0iiO(v27.i00, v26, v24);
                    break;
                }
                case 2: {
                    ++v8;
                    if (this.0iIi(v27.i00)) {
                        ++v10;
                    }
                    this.0iiO(v27.i00, v26, v24);
                    break;
                }
                case 3: {
                    ++v9;
                    this.0iiO(v27.i00, v26, v24);
                    break;
                }
                case 4: {
                    ++v8;
                    ++v9;
                    this.0iiO(v27.i00, v26, v24);
                }
            }
            v12 = Math.min(v12, v26.method_10263());
            v13 = Math.min(v13, v26.method_10264());
            v14 = Math.min(v14, v26.method_10260());
            v15 = Math.max(v15, v26.method_10263());
            v16 = Math.max(v16, v26.method_10264());
            v17 = Math.max(v17, v26.method_10260());
            v18 += (double)v26.method_10263() + 0.5;
            v20 += (double)v26.method_10264() + 0.5;
            v22 += (double)v26.method_10260() + 0.5;
        }
        int v25 = v7 + v8;
        int v26 = v15 - v12 + 1;
        int v27 = v16 - v13 + 1;
        int v28 = v17 - v14 + 1;
        double v29 = (double)(v12 + v15 + 1) * 0.5;
        double v31 = (double)(v14 + v17 + 1) * 0.5;
        int v33 = this.0ii0(v24, v29, v31);
        boolean v34 = v26 <= 7 && v28 <= 7 && v27 <= 8;
        boolean v35 = this.0iI0(param4, v12, v15, v13, v14, v17);
        boolean v36 = v11 >= (Integer)this.OiIo.HelpCommand() || this.0ioi(v5, v6, v27, v34, v35);
        boolean v37 = v25 >= (Integer)this.OiII.HelpCommand() && v34 && (v8 > 0 || v10 > 0 || v9 > 0 || v33 > 0 || v35);
        boolean v38 = v5 >= 2 && v25 >= 1 && v34 && (v35 || v10 > 0 || v9 > 0 || v8 > 0);
        boolean bl = v39 = v8 >= 1 && (v10 > 0 || v9 > 0) && v35;
        if (!(v36 || v37 || v38 || v39)) {
            return null;
        }
        int v40 = Math.max(1, param1.size());
        Vec3d v41 = new Vec3d(v18 / (double)v40, v20 / (double)v40, v22 / (double)v40);
        double v46 = this.0iIO(param4, v29, v31, v16);
        BlockPos v48 = new BlockPos((int)Math.floor(v29), v16 + 1, (int)Math.floor(v31));
        Box v49 = new Box((double)v12, (double)v13, (double)v14, (double)v15 + 1.0, (double)v16 + 1.0, (double)v17 + 1.0);
        int v50 = v5 + v25 * 2 + v9 * 2 + v10 * 2 + (v35 ? 3 : 0);
        return new DataRecord_0o0o_2(v48, v41, v49, v29, v46, v31, v50);
    }

    private boolean i0i() {
        if (TrapDetectorModule.ConfigSupport_OI0.world == null) {
            return false;
        }
        RegistryKey v1 = TrapDetectorModule.ConfigSupport_OI0.world.method_27983();
        if (this.iIo == null) {
            this.iIo = v1;
            return false;
        }
        if (!this.iIo.equals(v1)) {
            this.iIo = v1;
            return true;
        }
        return false;
    }

    public TrapDetectorModule() {
        super("TrapDetector", "Marks likely underground traps made from vertical sign stacks or pistons.", ModuleCategory.ioO);
        this.OiIo = this.OOi0o("MinSigns", 3, 2, 12);
        this.OiII = this.OOi0o("MinPistons", 2, 1, 8);
        this.RenderSupport_oiii_5 = this.OOi0o("Size", 0.9, 0.5, 2.0);
        this.OiiO = this.OOi00("ShowLabel", true);
        this.Oii0 = this.OOi00("ShowBox", true);
        this.Oiio = this.OOioo("BoxColor", 255, 80, 35, 170);
        this.OiiI = new ConcurrentHashMap();
        this.IIi = ConcurrentHashMap.newKeySet();
    }

    private boolean oOOI(World param1, DataRecord_0o0o_2 param2) {
        Object v16;
        Object v15;
        HashMap<BlockPos, DataRecord_OOI0> v3 = new HashMap<BlockPos, DataRecord_OOI0>();
        HashMap<Long, List> v4 = new HashMap<Long, List>();
        BlockPos.Mutable v5 = new BlockPos.Mutable();
        int v6 = (int)Math.floor(param2.Oo0O.minX) - 1;
        int v7 = (int)Math.ceil(param2.Oo0O.maxX) + 1;
        int v8 = (int)Math.floor(param2.Oo0O.minY) - 2;
        int v9 = (int)Math.ceil(param2.Oo0O.maxY) + 2;
        int v10 = (int)Math.floor(param2.Oo0O.minZ) - 1;
        int v11 = (int)Math.ceil(param2.Oo0O.maxZ) + 1;
        for (int v12 = v6; v12 <= v7; ++v12) {
            for (int v13 = v8; v13 <= v9; ++v13) {
                for (int v14 = v10; v14 <= v11; ++v14) {
                    v5.set(v12, v13, v14);
                    v15 = param1.method_8320((BlockPos)v5);
                    v16 = this.0iII((BlockState)v15);
                    if (v16 == null) continue;
                    BlockPos v17 = v5.method_10062();
                    v3.put(v17, new DataRecord_OOI0(v17, (EnumType_O00I)((Object)v16), (BlockState)v15));
                    if (v16 != EnumType_O00I.o00) continue;
                    v4.computeIfAbsent(this.oOOi(v12, v14), param0 -> new ArrayList()).add(v13);
                }
            }
        }
        if (v3.isEmpty()) {
            return false;
        }
        HashSet v12 = new HashSet();
        for (BlockPos v14 : v3.keySet()) {
            if (v12.contains(v14) || (v16 = this.0ioI((Set)(v15 = this.0ioo(v14, v3, v12)), v3, v4, param1)) == null || !this.0iiI(param2, (DataRecord_0o0o_2)v16)) continue;
            return true;
        }
        return false;
    }

    private boolean oOOo(DataRecord_0o0o_2 param1, int param2, int param3) {
        int v4 = param1.ConfigSupport_oooi_3.method_10263() >> 4;
        int v5 = param1.ConfigSupport_oooi_3.method_10260() >> 4;
        return v4 == param2 && v5 == param3;
    }

    private boolean 0iIi(BlockState param1) {
        return param1.method_26204() instanceof PistonBlock && param1.method_28498((Property)PistonBlock.EXTENDED) && Boolean.TRUE.equals(param1.method_11654((Property)PistonBlock.EXTENDED));
    }

    private void 0i0i() {
        if (this.IIi.isEmpty() || TrapDetectorModule.ConfigSupport_OI0.world == null || TrapDetectorModule.ConfigSupport_OI0.player == null) {
            return;
        }
        int v1 = (Integer)this.ioO.HelpCommand();
        int v2 = v1 * v1;
        BlockPos v3 = TrapDetectorModule.ConfigSupport_OI0.player.method_24515();
        ArrayList v4 = new ArrayList(this.IIi);
        Iterator v5 = v4.iterator();
        while (v5.hasNext()) {
            int v13;
            long v6 = (Long)v5.next();
            int v8 = BlockPos.unpackLongX((long)v6);
            int v9 = BlockPos.unpackLongZ((long)v6);
            int v10 = (v8 << 4) + 8;
            int v11 = (v9 << 4) + 8;
            int v12 = v10 - v3.method_10263();
            if (v12 * v12 + (v13 = v11 - v3.method_10260()) * v13 > v2 + 512) {
                this.IIi.remove(v6);
                continue;
            }
            this.0io0((World)TrapDetectorModule.ConfigSupport_OI0.world, v8, v9);
            this.IIi.remove(v6);
        }
    }
}

