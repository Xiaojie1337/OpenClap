/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.fluid.FluidState
 *  net.minecraft.item.Item
 *  net.minecraft.item.Items
 *  net.minecraft.registry.tag.FluidTags
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.BlockView
 *  net.minecraft.world.RaycastContext
 *  net.minecraft.world.RaycastContext$FluidHandling
 *  net.minecraft.world.RaycastContext$ShapeType
 */
package clap.module.player;

import java.security.Key;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.BlockView;
import net.minecraft.world.RaycastContext;
import clap.mixin.KeyBindingAccessor;
import clap.config.ConfigSupport_O0IO;
import clap.core.module.Module;
import clap.model.DataRecord_00i_0;
import clap.model.EnumType_iii_0;
import clap.setting.Setting;
import clap.config.ConfigSupport_oiio_2;
import clap.config.ConfigSupport_oio_5;
import clap.core.module.ModuleCategory;
import clap.model.EnumType_oo0i_0;
import clap.event.EventHandler;
import clap.config.ConfigSupport_oooo_3;
import skidonion.loader.0ooo;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class AutoMlgModule
extends Module {
    private boolean OO0i;
    private int NetworkSupport_OO00;
    private float OOoI;
    private static final int EnumType_ii0_2;
    private static final int iio;
    private BlockPos OOOi;
    private Vec3d PostProcessingModule;
    private final Setting DataRecord_0io_2 = this.OOi0o("FallCheck", 3.0, 1.0, 10.0);
    private int OO0o;
    private static final int iiI;
    private final Setting ioO = this.OOi0o("Range", 4.5, 2.0, 6.0);
    private final Setting Module;
    private BlockHitResult OOOo;
    private boolean FontRenderer;
    private EnumType_oo0i_0 EnumType_OOO0;
    private final Setting iii = this.OOi0o("RotateSpeed", 180, 20, 180);
    private float EventHandler;
    private boolean OOoO;
    private float OOoi;
    private int DataRecord_OO0O;
    private float DataRecord_OOI0;
    private final Setting KeepSprintModule;
    private float OOoo;
    private int NetworkSupport_o0o_0 = -1;
    private float Manager;
    static Object OOIo;
    private static volatile /* synthetic */ long __k__gH4it;
    private static /* synthetic */ String[] __p__gH4it;
    private static /* synthetic */ Object[][] __c__J7Um6;

    @Override
    public void 0oI() {
        0ooo.0Oo().0Oo(this);
        this.SettingContainer();
    }

    private int O0ii(boolean param1) {
        Vec3d v2 = AutoMlgModule.ConfigSupport_OI0.player.method_18798();
        double v3 = Math.max(Math.abs(v2.x), Math.abs(v2.z));
        double v5 = param1 ? 4.0 : 20.0;
        return MathHelper.clamp((int)((int)Math.ceil(v3 * v5) + 1), (int)1, (int)6);
    }

    private DataRecord_00i_0 NetworkSupport_o0oi_2(boolean param12) {
        int v2 = Math.max(1, this.O0ii(param12));
        int v3 = Math.max(2, this.XrayModule(param12));
        BlockPos v4 = AutoMlgModule.ConfigSupport_OI0.player.method_24515();
        ArrayList<BlockPos> v5 = new ArrayList<BlockPos>();
        for (int v6 = -v2; v6 <= v2; ++v6) {
            for (int v7 = -v2; v7 <= v2; ++v7) {
                for (int v8 = 0; v8 <= v3; ++v8) {
                    BlockPos v9 = v4.add(v6, -v8, v7);
                    if (!this.O0iO(v9) || !this.O0i0(v9.up())) continue;
                    v5.add(v9.toImmutable());
                }
            }
        }
        return v5.stream().sorted(Comparator.comparingDouble(param1 -> Vec3d.ofCenter((Vec3i)param1.up()).squaredDistanceTo(this.CriticalsModule((BlockPos)param1))).thenComparingDouble(param0 -> -param0.method_10264())).map(param2 -> this.O0oi((BlockPos)param2, param12)).filter(param0 -> param0 != null).findFirst().orElse(null);
    }

    private void RenderSupport_oooo_2(BlockHitResult param1, Vec3d param2, EnumType_oo0i_0 param3) {
        this.OOOo = param1;
        this.PostProcessingModule = param2;
        this.DataRecord_OO0O = 0;
        this.NetworkSupport_OO00 = 0;
        this.OoO0(param2);
        this.EnumType_OOO0 = param3;
    }

    private DataRecord_00i_0 O0oi(BlockPos param12, boolean param2) {
        if (!AutoMlgModule.ConfigSupport_OI0.world.method_8320(param12).method_26206((BlockView)AutoMlgModule.ConfigSupport_OI0.world, param12, Direction.UP)) {
            return null;
        }
        return this.RenderSupport_O0I0(param12).stream().filter(param3 -> {
            if (!param2) {
                return true;
            }
            if (!this.IrcManager((Vec3d)param3)) {
                return false;
            }
            BlockHitResult v4 = this.Oo0O((Vec3d)param3, RaycastContext.FluidHandling.NONE);
            return v4.method_17783() == HitResult.Type.BLOCK && v4.getBlockPos().equals((Object)param12) && v4.getSide() == Direction.UP;
        }).min(Comparator.comparingDouble(this::O0Io)).map(param1 -> new DataRecord_00i_0(new BlockHitResult(param1, Direction.UP, param12, false), (Vec3d)param1)).orElse(null);
    }

    @EventHandler
    public void AutoMlgModule(ConfigSupport_oio_5 param1) {
        if (AutoMlgModule.iooI() || !this.EnumType_o0o0_0()) {
            return;
        }
        param1.Oo0(0.0f);
        param1.OoI(0.0f);
        AutoMlgModule.ConfigSupport_OI0.player.method_5728(false);
    }

    @EventHandler
    public void 0oi(ConfigSupport_O0IO param1) {
        if (param1.0Oi() != EnumType_iii_0.OiO) {
            return;
        }
        if (AutoMlgModule.iooI() || AutoMlgModule.ConfigSupport_OI0.interactionManager == null || AutoMlgModule.ConfigSupport_OI0.currentScreen != null || AutoMlgModule.ConfigSupport_OI0.player.method_68878()) {
            this.Oooi();
            return;
        }
        if (this.FontRenderer) {
            if (0ooo.EnumType_0OI() != null) {
                0ooo.0Oi().HelpCommand(this, this.OOoI, this.OOoi, 180.0f);
            }
            return;
        }
        switch (this.EnumType_OOO0.ordinal()) {
            case 0: {
                this.O0Oo();
                break;
            }
            case 1: 
            case 4: {
                this.O0Oi();
                break;
            }
            case 2: {
                this.AntiBotModule();
                break;
            }
            case 3: {
                this.GuiSupport_O000();
                break;
            }
            case 5: {
                this.EnumType_O00I();
            }
        }
    }

    public void OOii() {
        if (!this.OOoO || AutoMlgModule.iooI()) {
            this.OOoO = false;
            this.OO0i = false;
            return;
        }
        AutoMlgModule.ConfigSupport_OI0.player.method_36456(this.EventHandler);
        AutoMlgModule.ConfigSupport_OI0.player.method_36457(this.OOoo);
        AutoMlgModule.ConfigSupport_OI0.gameRenderer.updateCrosshairTarget(ConfigSupport_OI0.getRenderTickCounter().getTickProgress(false));
        this.OOoO = false;
        this.OO0i = false;
    }

    private boolean O0iO(BlockPos param1) {
        return AutoMlgModule.ConfigSupport_OI0.world.method_8320(param1).method_26206((BlockView)AutoMlgModule.ConfigSupport_OI0.world, param1, Direction.UP);
    }

    private boolean GuiComponent() {
        if (this.EnumType_OOO0 == EnumType_oo0i_0.0Io) {
            DataRecord_00i_0 v1 = this.NetworkSupport_o0oi_2(true);
            if (v1 == null) {
                return false;
            }
            this.OOOo = v1.RenderSupport_0I0();
            this.PostProcessingModule = v1.0Io();
            return true;
        }
        if (this.EnumType_OOO0 == EnumType_oo0i_0.DataRecord_0io_2) {
            BlockPos v1 = this.ConfigSupport_O0IO();
            if (v1 == null) {
                return false;
            }
            Vec3d v2 = this.EnumType_O0II(v1);
            this.OOOo = new BlockHitResult(v2, Direction.UP, v1, false);
            this.PostProcessingModule = v2;
            return true;
        }
        return this.PostProcessingModule != null;
    }

    private void OoO0(Vec3d param1) {
        this.ConfigSupport_oooi_3(param1, ((Integer)this.iii.HelpCommand()).intValue());
    }

    private void Oo0i() {
        this.OOoI = 0ooo.Kernel32SnapshotApi().ConfigSupport_OI0();
        this.OOoi = 0ooo.StorageEspModule().OIo();
    }

    private boolean O0Ii(BlockPos param1) {
        FluidState v2 = AutoMlgModule.ConfigSupport_OI0.world.method_8316(param1);
        return v2.isIn(FluidTags.WATER) && v2.isStill();
    }

    private int XrayModule(boolean param1) {
        double v2 = Math.max(0.0, AutoMlgModule.ConfigSupport_OI0.player.field_6017);
        double v4 = Math.abs(AutoMlgModule.ConfigSupport_OI0.player.method_18798().y);
        int v6 = param1 ? (int)Math.ceil((Double)this.ioO.HelpCommand()) : 128;
        return MathHelper.clamp((int)((int)Math.ceil(v2 + v4 * 3.0 + 2.0)), (int)2, (int)v6);
    }

    private boolean RenderSupport_o0oo_1() {
        return this.FontRenderer || this.EnumType_OOO0 != EnumType_oo0i_0.RenderSupport_0I0 || this.O00i();
    }

    public AutoMlgModule() {
        super("AutoMLG", "Automatically places and retrieves water before landing.", ModuleCategory.ioo);
        this.Module = this.OOi00("Pickup", true);
        this.KeepSprintModule = this.OOi00("SwapBack", true);
        this.EnumType_OOO0 = EnumType_oo0i_0.RenderSupport_0I0;
    }

    private void OoIO() {
        if (AutoMlgModule.ConfigSupport_OI0.options != null) {
            AutoMlgModule.ConfigSupport_OI0.options.useKey.setPressed(false);
        }
    }

    private void OooO() {
        if (!this.OOoO) {
            this.EventHandler = AutoMlgModule.ConfigSupport_OI0.player.method_36454();
            this.OOoo = AutoMlgModule.ConfigSupport_OI0.player.method_36455();
        }
        this.OOoO = true;
        AutoMlgModule.ConfigSupport_OI0.player.method_36456(this.OOoI);
        AutoMlgModule.ConfigSupport_OI0.player.method_36457(this.OOoi);
    }

    private boolean O0oo() {
        return AutoMlgModule.ConfigSupport_OI0.player.method_5799() || AutoMlgModule.ConfigSupport_OI0.player.method_24828() || AutoMlgModule.ConfigSupport_OI0.player.field_6017 == 0.0 || AutoMlgModule.ConfigSupport_OI0.player.method_18798().y >= -0.02;
    }

    private boolean IrcManager(Vec3d param1) {
        return AutoMlgModule.ConfigSupport_OI0.player.method_33571().distanceTo(param1) <= Math.min((Double)this.ioO.HelpCommand(), AutoMlgModule.ConfigSupport_OI0.player.method_55754());
    }

    private int Ooo0(Item param1) {
        for (int v2 = 0; v2 < 9; ++v2) {
            if (!AutoMlgModule.ConfigSupport_OI0.player.method_31548().method_5438(v2).isOf(param1)) continue;
            return v2;
        }
        return -1;
    }

    static {
        __k__gH4it = AutoMlgModule.__k__gH4it(8057844007608249873L);
        __rP__gH4it0 = new String[]{"\u31e1\ue40e\u3aea\u6fbe\ue8c1"};
        __rP__gH4it1 = new String[0];
        __rP__gH4it2 = new String[]{"\u31e2\ue40d\u3ad1\u6f52\ue888\u242f\u6485\u3988\u32ce\ue77b\u39c9\u6c26\uebf6\u2735\u67af\u3acb\u33f2\ue651\u38fc\u6d0a"};
        __rP__gH4it3 = new String[]{"\u3181\ue4b3\u3a40\u6cb8\uebf7\u27a9\u67d4\u3aff\u32fe\ue7bf\u3954\u6ce0\uea69\u2630\u6693\u3b38\u33df\ue6f4\u3887\u6d0c\uedd5\u2146\u616b\u3c41\u3407\ue1c2\u3f90\u6a55\ueccc\u2004\u6068\u3dd1\u35d6\ue09b\u3e8a\u6b11\uef2f\u231f\u63a3\u3e78\u3662\ue33d\u3db6\u68e4\uef4c\u2202\u624b\u3f2d\u377f\ue2d1\u3c0e\u6944\ueed8\u5dd4\u1dd5\u4084\u4880\u9d81\u438c\u1691\u913f\u5c89\u1ca0\u41db\u49e3\u9c01\u42f4\u179b\u9009\u5f76\u1fe3\u4267\u4ae2\u9fa4\u4139\u141c\u93fc\u5ff4\u1e7d\u436a\u4bf9\u9e85\u40ac\u15ef\u92b6\u5e65\u19e1\u44ea\u4caa\u995d\u47c3\u12cf\u952f\u59ce\u1859\u4591\u4dc1\u9823\u468e\u13ec\u947d\u587b\u1ba8\u464e\u4e38\u9bc5\u45ce\u10e6\u9713\u5b20\u1b53\u47ce\u4fe4\u9a83\u44d8\u117f\u96b8\u5adb\u1a47\u48b2\u40a4\u9597\u4bb9\u1e34\u99ec\u55ae\u1575\u49e3\u41b8\u94c4\u4af2\u1f14\u9883\u5444\u14a3\u4aa7\u428c\u97f6\u492a\u1c6e\u9b35\u57c4\u1759\u4ad6\u4334\u9659\u48d1\u1dd8\u9af9\u567f\u1688\u4bdb", "\u31f4\ue402\u3aea\u6fcb\ue8d8\u243c\u64dc\u3a77\u32ea\ue768", "\u31db\ue4f3\u3a49\u6f15\ue864\u2422\u6408\u3a93", "\u31f6\ue40c\u3ae4\u6fc9\ue8da\u243a\u64da\u3a75\u32e8\ue776", "\u31f4\ue41b\u3afb", "\u31e4\ue40f\u3af2\u6fa3\ue8c8\u242f\u64c1"};
        __p__gH4it = new String[]{"\ue237\ue25c\ue281\ue2a6\ue2cb\ue2f0\ue315\ue33a\ue35f\ue384", "\uedfc\uee21\uee46\uee6b\uee90\ueeb5\ueeda\ueeff\uef24\uef49\uef6e\uef93\uefb8\uefdd\uf002\uf027\uf04c\uf071\uf096", "\ue9c9\ue9ee\uea13\uea38\uea5d\uea82\ueaa7\ueacc\ueaf1\ueb16\ueb3b\ueb60\ueb85", "\ue496\ue4bb\ue4e0\ue505\ue52a\ue54f\ue574\ue599\ue5be\ue5e3", "\uf063\uf088\uf0ad\uf0d2\uf0f7\uf11c\uf141\uf166\uf18b\uf1b0\uf1d5\uf1fa\uf21f\uf244\uf269", "\ued28\ued4d\ued72\ued97\uedbc\uede1\uee06\uee2b\uee50\uee75\uee9a\ueebf\ueee4\uef09", "\ue8f5\ue91a\ue93f\ue964\ue989\ue9ae\ue9d3\ue9f8\uea1d\uea42\uea67\uea8c\ueab1\uead6\ueafb\ueb20\ueb45\ueb6a\ueb8f", "\uebc2\uebe7\uec0c\uec31\uec56\uec7b\ueca0\uecc5\uecea\ued0f\ued34\ued59\ued7e\ueda3\uedc8\ueded\uee12\uee37", "\uf78f\uf7b4\uf7d9\uf7fe\ue023\ue048\ue06d\ue092\ue0b7\ue0dc\ue101\ue126", "\uec54\uec79\uec9e\uecc3\uece8\ued0d\ued32\ued57\ued7c\ueda1\uedc6", "\ue821\ue846\ue86b\ue890\ue8b5\ue8da\ue8ff\ue924\ue949\ue96e\ue993\ue9b8\ue9dd\uea02\uea27\uea4c\uea71", "\uf2ee\uf313\uf338\uf35d\uf382\uf3a7\uf3cc\uf3f1\uf416\uf43b\uf460\uf485\uf4aa\uf4cf", "\ueebb\ueee0\uef05\uef2a\uef4f\uef74\uef99\uefbe\uefe3", "\uea80\ueaa5\ueaca\ueaef\ueb14\ueb39\ueb5e\ueb83\ueba8\uebcd\uebf2", "\uf74d\uf772\uf797\uf7bc\uf7e1\ue006\ue02b\ue050\ue075\ue09a\ue0bf\ue0e4\ue109\ue12e", "\uf31a\uf33f\uf364\uf389\uf3ae\uf3d3\uf3f8\uf41d\uf442\uf467\uf48c\uf4b1", "\uede7\uee0c\uee31\uee56\uee7b\ueea0\ueec5\ueeea\uef0f\uef34\uef59\uef7e\uefa3\uefc8\uefed\uf012\uf037\uf05c", "\ue9ac\ue9d1\ue9f6\uea1b\uea40\uea65\uea8a\ueaaf\uead4\ueaf9\ueb1e", "\uee79\uee9e\ueec3\ueee8\uef0d\uef32\uef57\uef7c\uefa1\uefc6\uefeb\uf010\uf035", "\ue246\ue26b\ue290\ue2b5\ue2da\ue2ff\ue324\ue349\ue36e\ue393\ue3b8\ue3dd\ue402\ue427", "\uf513\uf538\uf55d\uf582\uf5a7\uf5cc\uf5f1\uf616\uf63b\uf660\uf685", "\uf0d8\uf0fd\uf122\uf147\uf16c\uf191\uf1b6\uf1db\uf200", "\ueda5\uedca\uedef\uee14\uee39\uee5e\uee83\ueea8\ueecd\ueef2", "\ue972\ue997\ue9bc\ue9e1\uea06\uea2b\uea50\uea75\uea9a\ueabf\ueae4\ueb09\ueb2e\ueb53", "\uec3f\uec64\uec89\uecae\uecd3\uecf8\ued1d\ued42\ued67", "\uf004\uf029\uf04e\uf073\uf098\uf0bd\uf0e2\uf107\uf12c\uf151\uf176\uf19b\uf1c0\uf1e5", "\uebd1\uebf6\uec1b\uec40\uec65\uec8a\uecaf\uecd4\uecf9", "\ue09e\ue0c3\ue0e8\ue10d\ue132\ue157\ue17c\ue1a1\ue1c6\ue1eb\ue210\ue235\ue25a\ue27f", "\ue46b\ue490\ue4b5\ue4da\ue4ff\ue524\ue549\ue56e\ue593\ue5b8\ue5dd\ue602\ue627\ue64c\ue671\ue696\ue6bb", "\uf730\uf755\uf77a\uf79f\uf7c4\uf7e9\ue00e\ue033\ue058\ue07d\ue0a2\ue0c7\ue0ec\ue111\ue136\ue15b\ue180\ue1a5", "\ue2fd\ue322\ue347\ue36c\ue391\ue3b6\ue3db\ue400\ue425\ue44a\ue46f\ue494\ue4b9\ue4de\ue503\ue528\ue54d", "\uf7ca\uf7ef\ue014\ue039\ue05e\ue083\ue0a8\ue0cd", "\ue397\ue3bc\ue3e1\ue406\ue42b\ue450\ue475\ue49a\ue4bf\ue4e4\ue509\ue52e\ue553\ue578\ue59d\ue5c2\ue5e7\ue60c\ue631", "\uf65c\uf681\uf6a6\uf6cb\uf6f0\uf715\uf73a\uf75f\uf784\uf7a9\uf7ce\uf7f3\ue018\ue03d", "\uf229\uf24e\uf273\uf298\uf2bd\uf2e2\uf307\uf32c\uf351", "\uf6f6\uf71b\uf740\uf765\uf78a\uf7af\uf7d4\uf7f9\ue01e\ue043\ue068\ue08d\ue0b2\ue0d7", "\ueac3\ueae8\ueb0d\ueb32\ueb57\ueb7c\ueba1\uebc6\uebeb\uec10\uec35", "\uf588\uf5ad\uf5d2\uf5f7\uf61c\uf641\uf666\uf68b\uf6b0\uf6d5\uf6fa\uf71f", "\ue955\ue97a\ue99f\ue9c4\ue9e9\uea0e\uea33\uea58\uea7d\ueaa2\ueac7\ueaec\ueb11\ueb36\ueb5b\ueb80\ueba5", "\uf522\uf547\uf56c\uf591\uf5b6\uf5db\uf600\uf625\uf64a\uf66f\uf694\uf6b9\uf6de\uf703\uf728\uf74d\uf772", "\uf1ef\uf214\uf239\uf25e\uf283\uf2a8\uf2cd\uf2f2\uf317\uf33c\uf361\uf386\uf3ab\uf3d0", "\uf5b4\uf5d9\uf5fe\uf623\uf648\uf66d\uf692\uf6b7\uf6dc\uf701\uf726\uf74b\uf770\uf795\uf7ba\uf7df\ue004\ue029", "\uf081\uf0a6\uf0cb\uf0f0\uf115\uf13a\uf15f\uf184\uf1a9\uf1ce\uf1f3\uf218\uf23d", "\ue44e\ue473\ue498\ue4bd\ue4e2\ue507\ue52c\ue551\ue576\ue59b\ue5c0\ue5e5\ue60a\ue62f\ue654\ue679\ue69e\ue6c3", "\uf11b\uf140\uf165\uf18a\uf1af\uf1d4\uf1f9\uf21e\uf243\uf268\uf28d\uf2b2\uf2d7", "\uece0\ued05\ued2a\ued4f\ued74\ued99\uedbe\uede3\uee08", "\ue7ad\ue7d2\ue7f7\ue81c\ue841\ue866\ue88b\ue8b0", "\uf37a\uf39f\uf3c4\uf3e9\uf40e\uf433\uf458\uf47d\uf4a2\uf4c7\uf4ec\uf511\uf536\uf55b\uf580", "\ue847\ue86c\ue891\ue8b6\ue8db\ue900\ue925\ue94a", "\ue40c\ue431\ue456\ue47b\ue4a0\ue4c5\ue4ea\ue50f\ue534", "\ue6d9\ue6fe\ue723\ue748\ue76d\ue792\ue7b7\ue7dc\ue801", "\ue2a6\ue2cb\ue2f0\ue315\ue33a\ue35f\ue384\ue3a9\ue3ce\ue3f3\ue418\ue43d\ue462\ue487\ue4ac\ue4d1\ue4f6\ue51b", "\ue673\ue698\ue6bd\ue6e2\ue707\ue72c\ue751\ue776\ue79b\ue7c0\ue7e5\ue80a\ue82f\ue854\ue879\ue89e\ue8c3\ue8e8\ue90d", "\uf338\uf35d\uf382\uf3a7\uf3cc\uf3f1\uf416\uf43b\uf460\uf485\uf4aa\uf4cf\uf4f4\uf519\uf53e\uf563\uf588\uf5ad\uf5d2", "\ue705\ue72a\ue74f\ue774\ue799\ue7be\ue7e3\ue808\ue82d\ue852\ue877\ue89c\ue8c1\ue8e6\ue90b", "\ue9d2\ue9f7\uea1c\uea41\uea66\uea8b\ueab0\uead5\ueafa\ueb1f\ueb44\ueb69\ueb8e\uebb3\uebd8\uebfd\uec22", "\ue59f\ue5c4\ue5e9\ue60e\ue633\ue658\ue67d\ue6a2\ue6c7\ue6ec\ue711", "\uea64\uea89\ueaae\uead3\ueaf8\ueb1d\ueb42\ueb67\ueb8c\uebb1\uebd6\uebfb\uec20\uec45\uec6a\uec8f\uecb4", "\uee31\uee56\uee7b\ueea0\ueec5\ueeea\uef0f\uef34\uef59\uef7e\uefa3\uefc8\uefed\uf012\uf037\uf05c\uf081", "\ue8fe\ue923\ue948\ue96d\ue992\ue9b7\ue9dc\uea01\uea26\uea4b\uea70\uea95\ueaba\ueadf", "\ue4cb\ue4f0\ue515\ue53a\ue55f\ue584\ue5a9\ue5ce\ue5f3", "\uf190\uf1b5\uf1da\uf1ff\uf224\uf249\uf26e\uf293\uf2b8\uf2dd\uf302\uf327\uf34c\uf371\uf396\uf3bb", "\ue55d\ue582\ue5a7\ue5cc\ue5f1\ue616\ue63b\ue660\ue685\ue6aa\ue6cf\ue6f4\ue719\ue73e\ue763", "\ue02a\ue04f\ue074\ue099\ue0be\ue0e3\ue108\ue12d\ue152\ue177\ue19c\ue1c1\ue1e6\ue20b\ue230", "\uebf7\uec1c\uec41\uec66\uec8b\uecb0\uecd5\uecfa\ued1f\ued44\ued69\ued8e\uedb3\uedd8\uedfd\uee22\uee47", "\uefbc\uefe1\uf006\uf02b\uf050\uf075\uf09a\uf0bf\uf0e4\uf109\uf12e\uf153\uf178\uf19d\uf1c2\uf1e7", "\ue489\ue4ae\ue4d3\ue4f8\ue51d\ue542\ue567\ue58c\ue5b1\ue5d6\ue5fb\ue620\ue645", "\ue856\ue87b\ue8a0\ue8c5\ue8ea\ue90f\ue934\ue959\ue97e\ue9a3\ue9c8\ue9ed\uea12\uea37\uea5c\uea81\ueaa6\ueacb", "\ue323\ue348\ue36d\ue392\ue3b7\ue3dc\ue401\ue426\ue44b\ue470\ue495\ue4ba\ue4df\ue504\ue529", "\ue6e8\ue70d\ue732\ue757\ue77c\ue7a1\ue7c6\ue7eb\ue810\ue835\ue85a\ue87f\ue8a4\ue8c9\ue8ee\ue913\ue938\ue95d", "\uf3b5\uf3da\uf3ff\uf424\uf449\uf46e\uf493\uf4b8\uf4dd\uf502", "\uef82\uefa7\uefcc\ueff1\uf016\uf03b\uf060\uf085\uf0aa\uf0cf\uf0f4\uf119\uf13e\uf163\uf188\uf1ad\uf1d2", "\ue24f\ue274\ue299\ue2be\ue2e3\ue308\ue32d\ue352\ue377\ue39c\ue3c1\ue3e6", "\uee14\uee39\uee5e\uee83\ueea8\ueecd\ueef2\uef17\uef3c\uef61\uef86\uefab\uefd0\ueff5\uf01a\uf03f", "\ue2e1\ue306\ue32b\ue350\ue375\ue39a\ue3bf\ue3e4\ue409\ue42e\ue453\ue478\ue49d", "\ueeae\ueed3\ueef8\uef1d\uef42\uef67\uef8c\uefb1\uefd6\ueffb\uf020\uf045\uf06a\uf08f", "\uf17b\uf1a0\uf1c5\uf1ea\uf20f\uf234\uf259\uf27e\uf2a3\uf2c8\uf2ed\uf312\uf337", "\ued40\ued65\ued8a\uedaf\uedd4\uedf9\uee1e\uee43\uee68\uee8d\ueeb2\ueed7\ueefc\uef21\uef46", "\ue90d\ue932\ue957\ue97c\ue9a1\ue9c6\ue9eb\uea10\uea35\uea5a\uea7f\ueaa4\ueac9", "\ue5da\ue5ff\ue624\ue649\ue66e\ue693\ue6b8\ue6dd\ue702\ue727\ue74c\ue771\ue796\ue7bb\ue7e0\ue805\ue82a\ue84f\ue874", "\uf1a7\uf1cc\uf1f1\uf216\uf23b\uf260\uf285\uf2aa\uf2cf\uf2f4\uf319\uf33e\uf363\uf388\uf3ad\uf3d2\uf3f7\uf41c", "\ue46c\ue491\ue4b6\ue4db\ue500\ue525\ue54a\ue56f\ue594\ue5b9\ue5de\ue603", "\uf039\uf05e\uf083\uf0a8\uf0cd\uf0f2\uf117\uf13c\uf161", "\ue506\ue52b\ue550\ue575\ue59a\ue5bf\ue5e4\ue609\ue62e\ue653\ue678\ue69d\ue6c2\ue6e7\ue70c\ue731\ue756\ue77b", "\ue0d3\ue0f8\ue11d\ue142\ue167\ue18c\ue1b1\ue1d6\ue1fb\ue220\ue245\ue26a\ue28f\ue2b4\ue2d9\ue2fe\ue323\ue348\ue36d", "\ue398\ue3bd\ue3e2\ue407\ue42c\ue451\ue476\ue49b\ue4c0", "\uf765\uf78a\uf7af\uf7d4\uf7f9\ue01e\ue043\ue068\ue08d", "\uf432\uf457\uf47c\uf4a1\uf4c6\uf4eb\uf510\uf535\uf55a", "\ue7ff\ue824\ue849\ue86e\ue893\ue8b8\ue8dd\ue902\ue927\ue94c\ue971\ue996\ue9bb\ue9e0\uea05\uea2a\uea4f", "\ueac4\ueae9\ueb0e\ueb33\ueb58\ueb7d\ueba2\uebc7\uebec\uec11\uec36\uec5b\uec80\ueca5\uecca\uecef\ued14\ued39\ued5e", "\uf691\uf6b6\uf6db\uf700\uf725\uf74a\uf76f\uf794\uf7b9\uf7de\ue003\ue028\ue04d\ue072", "\uea5e\uea83\ueaa8\ueacd\ueaf2\ueb17\ueb3c\ueb61\ueb86\uebab", "\uf72b\uf750\uf775\uf79a\uf7bf\uf7e4\ue009\ue02e\ue053\ue078\ue09d\ue0c2\ue0e7\ue10c\ue131\ue156\ue17b", "\ueaf0\ueb15\ueb3a\ueb5f\ueb84\ueba9\uebce\uebf3\uec18\uec3d\uec62\uec87\uecac\uecd1", "\uf5bd\uf5e2\uf607\uf62c\uf651\uf676\uf69b\uf6c0\uf6e5\uf70a\uf72f\uf754\uf779\uf79e\uf7c3\uf7e8", "\ue98a\ue9af\ue9d4\ue9f9\uea1e\uea43\uea68\uea8d\ueab2\uead7\ueafc\ueb21\ueb46\ueb6b"};
        __c__J7Um6 = new Object[][]{{"\ue883\ue8a8\ue8cd\ue8f2\ue917\ue93c\ue961\ue986\ue9ab\ue9d0\ue9f5\uea1a\uea3f\uea64\uea89", 911695130614589896L, "\uefa1\uefc6\uefeb\uf010\uf035\uf05a\uf07f\uf0a4\uf0c9\uf0ee\uf113\uf138", 826173568, "\uf6bf\uf6e4\uf709\uf72e\uf753\uf778\uf79d\uf7c2\uf7e7\ue00c\ue031\ue056", true, "\ue5dd\ue602\ue627\ue64c\ue671\ue696\ue6bb\ue6e0\ue705\ue72a\ue74f\ue774\ue799\ue7be\ue7e3\ue808\ue82d\ue852", true, "\uecfb\ued20\ued45\ued6a\ued8f\uedb4\uedd9\uedfe\uee23\uee48\uee6d\uee92\ueeb7\ueedc\uef01\uef26", true, "\uf419\uf43e\uf463\uf488\uf4ad\uf4d2\uf4f7\uf51c\uf541\uf566", true}, {"\ue984\ue9a9\ue9ce\ue9f3\uea18\uea3d\uea62\uea87\ueaac\uead1\ueaf6\ueb1b\ueb40\ueb65\ueb8a\uebaf\uebd4", 911695130614655433L, "\uf0a2\uf0c7\uf0ec\uf111\uf136\uf15b\uf180\uf1a5\uf1ca\uf1ef\uf214\uf239\uf25e\uf283\uf2a8\uf2cd", 2136583719, "\uf7c0\uf7e5\ue00a\ue02f\ue054\ue079\ue09e\ue0c3\ue0e8\ue10d\ue132\ue157\ue17c\ue1a1\ue1c6\ue1eb", false, "\ue6de\ue703\ue728\ue74d\ue772\ue797\ue7bc\ue7e1\ue806\ue82b\ue850\ue875\ue89a", false, "\uedfc\uee21\uee46\uee6b\uee90\ueeb5\ueeda\ueeff\uef24\uef49\uef6e\uef93", false, "\uf51a\uf53f\uf564\uf589\uf5ae\uf5d3\uf5f8\uf61d\uf642", false}, {"\uea85\ueaaa\ueacf\ueaf4\ueb19\ueb3e\ueb63\ueb88\uebad\uebd2\uebf7\uec1c", 911695130614720970L, "\uf1a3\uf1c8\uf1ed\uf212\uf237\uf25c\uf281\uf2a6\uf2cb\uf2f0\uf315\uf33a", -1376655922, "\ue0c1\ue0e6\ue10b\ue130\ue155\ue17a\ue19f\ue1c4\ue1e9\ue20e\ue233\ue258\ue27d\ue2a2\ue2c7\ue2ec\ue311\ue336", true, "\ue7df\ue804\ue829\ue84e\ue873\ue898\ue8bd\ue8e2\ue907\ue92c\ue951\ue976\ue99b\ue9c0\ue9e5\uea0a", true, "\ueefd\uef22\uef47\uef6c\uef91\uefb6\uefdb\uf000\uf025\uf04a", true, "\uf61b\uf640\uf665\uf68a\uf6af\uf6d4\uf6f9\uf71e\uf743\uf768\uf78d\uf7b2\uf7d7\uf7fc", true}, {"\ueb86\uebab\uebd0\uebf5\uec1a\uec3f\uec64\uec89\uecae\uecd3\uecf8\ued1d\ued42\ued67\ued8c\uedb1", 911695130614786507L, "\uf2a4\uf2c9\uf2ee\uf313\uf338\uf35d\uf382\uf3a7\uf3cc\uf3f1\uf416\uf43b\uf460\uf485\uf4aa\uf4cf", -636929163, "\ue1c2\ue1e7\ue20c\ue231\ue256\ue27b\ue2a0\ue2c5\ue2ea\ue30f\ue334\ue359\ue37e", false, "\ue8e0\ue905\ue92a\ue94f\ue974\ue999\ue9be\ue9e3\uea08\uea2d\uea52\uea77", false, "\ueffe\uf023\uf048\uf06d\uf092\uf0b7\uf0dc\uf101\uf126", false, "\uf71c\uf741\uf766\uf78b\uf7b0\uf7d5\uf7fa\ue01f\ue044\ue069\ue08e", false}, {"\uec87\uecac\uecd1\uecf6\ued1b\ued40\ued65\ued8a\uedaf\uedd4\uedf9\uee1e", 911695130614852044L, "\uf3a5\uf3ca\uf3ef\uf414\uf439\uf45e\uf483\uf4a8\uf4cd\uf4f2\uf517\uf53c\uf561\uf586\uf5ab\uf5d0\uf5f5\uf61a", 144798236, "\ue2c3\ue2e8\ue30d\ue332\ue357\ue37c\ue3a1\ue3c6\ue3eb\ue410\ue435\ue45a\ue47f\ue4a4\ue4c9\ue4ee", true, "\ue9e1\uea06\uea2b\uea50\uea75\uea9a\ueabf\ueae4\ueb09\ueb2e", true, "\uf0ff\uf124\uf149\uf16e\uf193\uf1b8\uf1dd\uf202\uf227\uf24c\uf271\uf296\uf2bb\uf2e0", true, "\ue01d\ue042\ue067\ue08c\ue0b1\ue0d6\ue0fb\ue120\ue145", true}, {"\ued88\uedad\uedd2\uedf7\uee1c\uee41\uee66\uee8b\ueeb0\ueed5\ueefa\uef1f\uef44\uef69\uef8e\uefb3", 911695130614917581L, "\uf4a6\uf4cb\uf4f0\uf515\uf53a\uf55f\uf584\uf5a9\uf5ce\uf5f3\uf618\uf63d\uf662", -1187477053, "\ue3c4\ue3e9\ue40e\ue433\ue458\ue47d\ue4a2\ue4c7\ue4ec\ue511\ue536\ue55b", false, "\ueae2\ueb07\ueb2c\ueb51\ueb76\ueb9b\uebc0\uebe5\uec0a", false, "\uf200\uf225\uf24a\uf26f\uf294\uf2b9\uf2de\uf303\uf328\uf34d\uf372", false, "\ue11e\ue143\ue168\ue18d\ue1b2\ue1d7\ue1fc\ue221", false}, {"\uee89\ueeae\ueed3\ueef8\uef1d\uef42\uef67\uef8c\uefb1\uefd6\ueffb\uf020\uf045\uf06a\uf08f\uf0b4\uf0d9\uf0fe", 911695130614983118L, "\uf5a7\uf5cc\uf5f1\uf616\uf63b\uf660\uf685\uf6aa\uf6cf\uf6f4\uf719\uf73e\uf763\uf788\uf7ad\uf7d2", -414134422, "\ue4c5\ue4ea\ue50f\ue534\ue559\ue57e\ue5a3\ue5c8\ue5ed\ue612", true, "\uebe3\uec08\uec2d\uec52\uec77\uec9c\uecc1\uece6\ued0b\ued30\ued55\ued7a\ued9f\uedc4", true, "\uf301\uf326\uf34b\uf370\uf395\uf3ba\uf3df\uf404\uf429", true, "\ue21f\ue244\ue269\ue28e\ue2b3\ue2d8\ue2fd\ue322\ue347\ue36c\ue391\ue3b6\ue3db\ue400\ue425", true}, {"\uef8a\uefaf\uefd4\ueff9\uf01e\uf043\uf068\uf08d\uf0b2\uf0d7\uf0fc\uf121\uf146", 911695130615048655L, "\uf6a8\uf6cd\uf6f2\uf717\uf73c\uf761\uf786\uf7ab\uf7d0\uf7f5\ue01a\ue03f", 367527441, "\ue5c6\ue5eb\ue610\ue635\ue65a\ue67f\ue6a4\ue6c9\ue6ee", false, "\uece4\ued09\ued2e\ued53\ued78\ued9d\uedc2\uede7\uee0c\uee31\uee56", false, "\uf402\uf427\uf44c\uf471\uf496\uf4bb\uf4e0\uf505", false, "\ue320\ue345\ue36a\ue38f\ue3b4\ue3d9\ue3fe\ue423\ue448\ue46d\ue492\ue4b7\ue4dc\ue501\ue526\ue54b\ue570", false}, {"\uf08b\uf0b0\uf0d5\uf0fa\uf11f\uf144\uf169\uf18e\uf1b3\uf1d8\uf1fd\uf222\uf247\uf26c\uf291\uf2b6", 911695130615114192L, "\uf7a9\uf7ce\uf7f3\ue018\ue03d\ue062\ue087\ue0ac\ue0d1\ue0f6", 1107320248, "\ue6c7\ue6ec\ue711\ue736\ue75b\ue780\ue7a5\ue7ca\ue7ef\ue814\ue839\ue85e\ue883\ue8a8", true, "\uede5\uee0a\uee2f\uee54\uee79\uee9e\ueec3\ueee8\uef0d", true, "\uf503\uf528\uf54d\uf572\uf597\uf5bc\uf5e1\uf606\uf62b\uf650\uf675\uf69a\uf6bf\uf6e4\uf709", true, "\ue421\ue446\ue46b\ue490\ue4b5\ue4da\ue4ff\ue524\ue549\ue56e\ue593\ue5b8", true}, {"\uf18c\uf1b1\uf1d6\uf1fb\uf220\uf245\uf26a\uf28f\uf2b4\uf2d9\uf2fe\uf323", 911695130615179729L, "\ue0aa\ue0cf\ue0f4\ue119\ue13e\ue163\ue188\ue1ad\ue1d2", -258239649, "\ue7c8\ue7ed\ue812\ue837\ue85c\ue881\ue8a6\ue8cb\ue8f0\ue915\ue93a", false, "\ueee6\uef0b\uef30\uef55\uef7a\uef9f\uefc4\uefe9", false, "\uf604\uf629\uf64e\uf673\uf698\uf6bd\uf6e2\uf707\uf72c\uf751\uf776\uf79b\uf7c0\uf7e5\ue00a\ue02f\ue054", false, "\ue522\ue547\ue56c\ue591\ue5b6\ue5db\ue600\ue625\ue64a\ue66f\ue694\ue6b9\ue6de\ue703\ue728\ue74d", false}, {"\uf28d\uf2b2\uf2d7\uf2fc\uf321\uf346\uf36b\uf390\uf3b5\uf3da", 911695130615245266L, "\ue1ab\ue1d0\ue1f5\ue21a\ue23f\ue264\ue289\ue2ae\ue2d3\ue2f8\ue31d\ue342\ue367\ue38c", 557033990, "\ue8c9\ue8ee\ue913\ue938\ue95d\ue982\ue9a7\ue9cc\ue9f1", true, "\uefe7\uf00c\uf031\uf056\uf07b\uf0a0\uf0c5\uf0ea\uf10f\uf134\uf159\uf17e\uf1a3\uf1c8\uf1ed", true, "\uf705\uf72a\uf74f\uf774\uf799\uf7be\uf7e3\ue008\ue02d\ue052\ue077\ue09c", true, "\ue623\ue648\ue66d\ue692\ue6b7\ue6dc\ue701\ue726\ue74b\ue770\ue795\ue7ba", true}, {"\uf38e\uf3b3\uf3d8\uf3fd\uf422\uf447\uf46c\uf491\uf4b6", 911695130615310803L, "\ue2ac\ue2d1\ue2f6\ue31b\ue340\ue365\ue38a\ue3af\ue3d4\ue3f9\ue41e", 1867243949, "\ue9ca\ue9ef\uea14\uea39\uea5e\uea83\ueaa8\ueacd", false, "\uf0e8\uf10d\uf132\uf157\uf17c\uf1a1\uf1c6\uf1eb\uf210\uf235\uf25a\uf27f\uf2a4\uf2c9\uf2ee\uf313\uf338", false, "\ue006\ue02b\ue050\ue075\ue09a\ue0bf\ue0e4\ue109\ue12e\ue153\ue178\ue19d\ue1c2\ue1e7\ue20c\ue231", false, "\ue724\ue749\ue76e\ue793\ue7b8\ue7dd\ue802\ue827\ue84c\ue871\ue896\ue8bb\ue8e0\ue905\ue92a\ue94f", false}, {"\uf48f\uf4b4\uf4d9\uf4fe\uf523\uf548\uf56d\uf592\uf5b7\uf5dc\uf601\uf626\uf64b\uf670", 911695130615376340L, "\ue3ad\ue3d2\ue3f7\ue41c\ue441\ue466\ue48b\ue4b0\ue4d5", -1646057644, "\ueacb\ueaf0\ueb15\ueb3a\ueb5f\ueb84\ueba9\uebce\uebf3\uec18\uec3d\uec62\uec87\uecac\uecd1", true, "\uf1e9\uf20e\uf233\uf258\uf27d\uf2a2\uf2c7\uf2ec\uf311\uf336\uf35b\uf380", true, "\ue107\ue12c\ue151\ue176\ue19b\ue1c0\ue1e5\ue20a\ue22f\ue254\ue279\ue29e", true, "\ue825\ue84a\ue86f\ue894\ue8b9\ue8de\ue903\ue928\ue94d\ue972\ue997\ue9bc\ue9e1\uea06\uea2b\uea50\uea75\uea9a", true}, {"\uf590\uf5b5\uf5da\uf5ff\uf624\uf649\uf66e\uf693\uf6b8\uf6dd\uf702", 911695130615441877L, "\ue4ae\ue4d3\ue4f8\ue51d\ue542\ue567\ue58c\ue5b1", -897876229, "\uebcc\uebf1\uec16\uec3b\uec60\uec85\uecaa\ueccf\uecf4\ued19\ued3e\ued63\ued88\uedad\uedd2\uedf7\uee1c", false, "\uf2ea\uf30f\uf334\uf359\uf37e\uf3a3\uf3c8\uf3ed\uf412\uf437\uf45c\uf481\uf4a6\uf4cb\uf4f0\uf515", false, "\ue208\ue22d\ue252\ue277\ue29c\ue2c1\ue2e6\ue30b\ue330\ue355\ue37a\ue39f\ue3c4\ue3e9\ue40e\ue433", false, "\ue926\ue94b\ue970\ue995\ue9ba\ue9df\uea04\uea29\uea4e\uea73\uea98\ueabd\ueae2", false}, {"\uf691\uf6b6\uf6db\uf700\uf725\uf74a\uf76f\uf794\uf7b9", 911695130615507414L, "\ue5af\ue5d4\ue5f9\ue61e\ue643\ue668\ue68d\ue6b2\ue6d7\ue6fc\ue721\ue746\ue76b\ue790\ue7b5", 2022880674, "\ueccd\uecf2\ued17\ued3c\ued61\ued86\uedab\uedd0\uedf5\uee1a\uee3f\uee64", true, "\uf3eb\uf410\uf435\uf45a\uf47f\uf4a4\uf4c9\uf4ee\uf513\uf538\uf55d\uf582", true, "\ue309\ue32e\ue353\ue378\ue39d\ue3c2\ue3e7\ue40c\ue431\ue456\ue47b\ue4a0\ue4c5\ue4ea\ue50f\ue534\ue559\ue57e", true, "\uea27\uea4c\uea71\uea96\ueabb\ueae0\ueb05\ueb2a\ueb4f\ueb74\ueb99\uebbe\uebe3\uec08\uec2d\uec52", true}, {"\uf792\uf7b7\uf7dc\ue001\ue026\ue04b\ue070\ue095", 911695130615572951L, "\ue6b0\ue6d5\ue6fa\ue71f\ue744\ue769\ue78e\ue7b3\ue7d8\ue7fd\ue822\ue847\ue86c\ue891\ue8b6\ue8db\ue900", -1456813239, "\uedce\uedf3\uee18\uee3d\uee62\uee87\ueeac\ueed1\ueef6\uef1b\uef40\uef65\uef8a\uefaf\uefd4\ueff9", false, "\uf4ec\uf511\uf536\uf55b\uf580\uf5a5\uf5ca\uf5ef\uf614\uf639\uf65e\uf683\uf6a8\uf6cd\uf6f2\uf717", false, "\ue40a\ue42f\ue454\ue479\ue49e\ue4c3\ue4e8\ue50d\ue532\ue557\ue57c\ue5a1\ue5c6", false, "\ueb28\ueb4d\ueb72\ueb97\uebbc\uebe1\uec06\uec2b\uec50\uec75\uec9a\uecbf", false}, {"\ue093\ue0b8\ue0dd\ue102\ue127\ue14c\ue171\ue196\ue1bb\ue1e0\ue205\ue22a\ue24f\ue274\ue299", 911695130615638488L, "\ue7b1\ue7d6\ue7fb\ue820\ue845\ue86a\ue88f\ue8b4\ue8d9\ue8fe\ue923\ue948", -683539728, "\ueecf\ueef4\uef19\uef3e\uef63\uef88\uefad\uefd2\ueff7\uf01c\uf041\uf066", true, "\uf5ed\uf612\uf637\uf65c\uf681\uf6a6\uf6cb\uf6f0\uf715\uf73a\uf75f\uf784\uf7a9\uf7ce\uf7f3\ue018\ue03d\ue062", true, "\ue50b\ue530\ue555\ue57a\ue59f\ue5c4\ue5e9\ue60e\ue633\ue658\ue67d\ue6a2\ue6c7\ue6ec\ue711\ue736", true, "\uec29\uec4e\uec73\uec98\uecbd\uece2\ued07\ued2c\ued51\ued76", true}, {"\ue194\ue1b9\ue1de\ue203\ue228\ue24d\ue272\ue297\ue2bc\ue2e1\ue306\ue32b\ue350\ue375\ue39a\ue3bf\ue3e4", 911695130615704025L, "\ue8b2\ue8d7\ue8fc\ue921\ue946\ue96b\ue990\ue9b5\ue9da\ue9ff\uea24\uea49\uea6e\uea93\ueab8\ueadd", 98195863, "\uefd0\ueff5\uf01a\uf03f\uf064\uf089\uf0ae\uf0d3\uf0f8\uf11d\uf142\uf167\uf18c\uf1b1\uf1d6\uf1fb", false, "\uf6ee\uf713\uf738\uf75d\uf782\uf7a7\uf7cc\uf7f1\ue016\ue03b\ue060\ue085\ue0aa", false, "\ue60c\ue631\ue656\ue67b\ue6a0\ue6c5\ue6ea\ue70f\ue734\ue759\ue77e\ue7a3", false, "\ued2a\ued4f\ued74\ued99\uedbe\uede3\uee08\uee2d\uee52", false}, {"\ue295\ue2ba\ue2df\ue304\ue329\ue34e\ue373\ue398\ue3bd\ue3e2\ue407\ue42c", 911695130615769562L, "\ue9b3\ue9d8\ue9fd\uea22\uea47\uea6c\uea91\ueab6\ueadb\ueb00\ueb25\ueb4a", -1300914370, "\uf0d1\uf0f6\uf11b\uf140\uf165\uf18a\uf1af\uf1d4\uf1f9\uf21e\uf243\uf268\uf28d\uf2b2\uf2d7\uf2fc\uf321\uf346", true, "\uf7ef\ue014\ue039\ue05e\ue083\ue0a8\ue0cd\ue0f2\ue117\ue13c\ue161\ue186\ue1ab\ue1d0\ue1f5\ue21a", true, "\ue70d\ue732\ue757\ue77c\ue7a1\ue7c6\ue7eb\ue810\ue835\ue85a", true, "\uee2b\uee50\uee75\uee9a\ueebf\ueee4\uef09\uef2e\uef53\uef78\uef9d\uefc2\uefe7\uf00c", true}, {"\ue396\ue3bb\ue3e0\ue405\ue42a\ue44f\ue474\ue499\ue4be\ue4e3\ue508\ue52d\ue552\ue577\ue59c\ue5c1", 911695130615835099L, "\ueab4\uead9\ueafe\ueb23\ueb48\ueb6d\ueb92\uebb7\uebdc\uec01\uec26\uec4b\uec70\uec95\uecba\uecdf", -527575323, "\uf1d2\uf1f7\uf21c\uf241\uf266\uf28b\uf2b0\uf2d5\uf2fa\uf31f\uf344\uf369\uf38e", false, "\ue0f0\ue115\ue13a\ue15f\ue184\ue1a9\ue1ce\ue1f3\ue218\ue23d\ue262\ue287", false, "\ue80e\ue833\ue858\ue87d\ue8a2\ue8c7\ue8ec\ue911\ue936", false, "\uef2c\uef51\uef76\uef9b\uefc0\uefe5\uf00a\uf02f\uf054\uf079\uf09e", false}, {"\ue497\ue4bc\ue4e1\ue506\ue52b\ue550\ue575\ue59a\ue5bf\ue5e4\ue609\ue62e", 911695130615900636L, "\uebb5\uebda\uebff\uec24\uec49\uec6e\uec93\uecb8\uecdd\ued02\ued27\ued4c\ued71\ued96\uedbb\uede0\uee05\uee2a", 287698316, "\uf2d3\uf2f8\uf31d\uf342\uf367\uf38c\uf3b1\uf3d6\uf3fb\uf420\uf445\uf46a\uf48f\uf4b4\uf4d9\uf4fe", true, "\ue1f1\ue216\ue23b\ue260\ue285\ue2aa\ue2cf\ue2f4\ue319\ue33e", true, "\ue90f\ue934\ue959\ue97e\ue9a3\ue9c8\ue9ed\uea12\uea37\uea5c\uea81\ueaa6\ueacb\ueaf0", true, "\uf02d\uf052\uf077\uf09c\uf0c1\uf0e6\uf10b\uf130\uf155", true}, {"\ue598\ue5bd\ue5e2\ue607\ue62c\ue651\ue676\ue69b\ue6c0\ue6e5\ue70a\ue72f\ue754\ue779\ue79e\ue7c3", 911695130615966173L, "\uecb6\uecdb\ued00\ued25\ued4a\ued6f\ued94\uedb9\uedde\uee03\uee28\uee4d\uee72", 1606230835, "\uf3d4\uf3f9\uf41e\uf443\uf468\uf48d\uf4b2\uf4d7\uf4fc\uf521\uf546\uf56b", false, "\ue2f2\ue317\ue33c\ue361\ue386\ue3ab\ue3d0\ue3f5\ue41a", false, "\uea10\uea35\uea5a\uea7f\ueaa4\ueac9\ueaee\ueb13\ueb38\ueb5d\ueb82", false, "\uf12e\uf153\uf178\uf19d\uf1c2\uf1e7\uf20c\uf231", false}, {"\ue699\ue6be\ue6e3\ue708\ue72d\ue752\ue777\ue79c\ue7c1\ue7e6\ue80b\ue830\ue855\ue87a\ue89f\ue8c4\ue8e9\ue90e", 911695130616031710L, "\uedb7\ueddc\uee01\uee26\uee4b\uee70\uee95\ueeba\ueedf\uef04\uef29\uef4e\uef73\uef98\uefbd\uefe2", -1915389222, "\uf4d5\uf4fa\uf51f\uf544\uf569\uf58e\uf5b3\uf5d8\uf5fd\uf622", true, "\ue3f3\ue418\ue43d\ue462\ue487\ue4ac\ue4d1\ue4f6\ue51b\ue540\ue565\ue58a\ue5af\ue5d4", true, "\ueb11\ueb36\ueb5b\ueb80\ueba5\uebca\uebef\uec14\uec39", true, "\uf22f\uf254\uf279\uf29e\uf2c3\uf2e8\uf30d\uf332\uf357\uf37c\uf3a1\uf3c6\uf3eb\uf410\uf435", true}, {"\ue79a\ue7bf\ue7e4\ue809\ue82e\ue853\ue878\ue89d\ue8c2\ue8e7\ue90c\ue931\ue956", 911695130616097247L, "\ueeb8\ueedd\uef02\uef27\uef4c\uef71\uef96\uefbb\uefe0\uf005\uf02a\uf04f", 980201857, "\uf5d6\uf5fb\uf620\uf645\uf66a\uf68f\uf6b4\uf6d9\uf6fe", false, "\ue4f4\ue519\ue53e\ue563\ue588\ue5ad\ue5d2\ue5f7\ue61c\ue641\ue666", false, "\uec12\uec37\uec5c\uec81\ueca6\ueccb\uecf0\ued15", false, "\uf330\uf355\uf37a\uf39f\uf3c4\uf3e9\uf40e\uf433\uf458\uf47d\uf4a2\uf4c7\uf4ec\uf511\uf536\uf55b\uf580", false}, {"\ue89b\ue8c0\ue8e5\ue90a\ue92f\ue954\ue979\ue99e\ue9c3\ue9e8\uea0d\uea32\uea57\uea7c\ueaa1\ueac6", 911695130616162784L, "\uefb9\uefde\uf003\uf028\uf04d\uf072\uf097\uf0bc\uf0e1\uf106", 1753544488, "\uf6d7\uf6fc\uf721\uf746\uf76b\uf790\uf7b5\uf7da\uf7ff\ue024\ue049\ue06e\ue093\ue0b8", true, "\ue5f5\ue61a\ue63f\ue664\ue689\ue6ae\ue6d3\ue6f8\ue71d", true, "\ued13\ued38\ued5d\ued82\ueda7\uedcc\uedf1\uee16\uee3b\uee60\uee85\ueeaa\ueecf\ueef4\uef19", true, "\uf431\uf456\uf47b\uf4a0\uf4c5\uf4ea\uf50f\uf534\uf559\uf57e\uf5a3\uf5c8", true}, {"\ue99c\ue9c1\ue9e6\uea0b\uea30\uea55\uea7a\uea9f\ueac4\ueae9\ueb0e\ueb33", 911695130616228321L, "\uf0ba\uf0df\uf104\uf129\uf14e\uf173\uf198\uf1bd\uf1e2", -1726214449, "\uf7d8\uf7fd\ue022\ue047\ue06c\ue091\ue0b6\ue0db\ue100\ue125\ue14a", false, "\ue6f6\ue71b\ue740\ue765\ue78a\ue7af\ue7d4\ue7f9", false, "\uee14\uee39\uee5e\uee83\ueea8\ueecd\ueef2\uef17\uef3c\uef61\uef86\uefab\uefd0\ueff5\uf01a\uf03f\uf064", false, "\uf532\uf557\uf57c\uf5a1\uf5c6\uf5eb\uf610\uf635\uf65a\uf67f\uf6a4\uf6c9\uf6ee\uf713\uf738\uf75d", false}, {"\uea9d\ueac2\ueae7\ueb0c\ueb31\ueb56\ueb7b\ueba0\uebc5\uebea", 911695130616293858L, "\uf1bb\uf1e0\uf205\uf22a\uf24f\uf274\uf299\uf2be\uf2e3\uf308\uf32d\uf352\uf377\uf39c", -944487306, "\ue0d9\ue0fe\ue123\ue148\ue16d\ue192\ue1b7\ue1dc\ue201", true, "\ue7f7\ue81c\ue841\ue866\ue88b\ue8b0\ue8d5\ue8fa\ue91f\ue944\ue969\ue98e\ue9b3\ue9d8\ue9fd", true, "\uef15\uef3a\uef5f\uef84\uefa9\uefce\ueff3\uf018\uf03d\uf062\uf087\uf0ac", true, "\uf633\uf658\uf67d\uf6a2\uf6c7\uf6ec\uf711\uf736\uf75b\uf780\uf7a5\uf7ca", true}, {"\ueb9e\uebc3\uebe8\uec0d\uec32\uec57\uec7c\ueca1\uecc6", 911695130616359395L, "\uf2bc\uf2e1\uf306\uf32b\uf350\uf375\uf39a\uf3bf\uf3e4\uf409\uf42e", 1976539933, "\ue1da\ue1ff\ue224\ue249\ue26e\ue293\ue2b8\ue2dd", false, "\ue8f8\ue91d\ue942\ue967\ue98c\ue9b1\ue9d6\ue9fb\uea20\uea45\uea6a\uea8f\ueab4\uead9\ueafe\ueb23\ueb48", false, "\uf016\uf03b\uf060\uf085\uf0aa\uf0cf\uf0f4\uf119\uf13e\uf163\uf188\uf1ad\uf1d2\uf1f7\uf21c\uf241", false, "\uf734\uf759\uf77e\uf7a3\uf7c8\uf7ed\ue012\ue037\ue05c\ue081\ue0a6\ue0cb\ue0f0\ue115\ue13a\ue15f", false}, {"\uec9f\uecc4\uece9\ued0e\ued33\ued58\ued7d\ueda2\uedc7\uedec\uee11\uee36\uee5b\uee80", 911695130616424932L, "\uf3bd\uf3e2\uf407\uf42c\uf451\uf476\uf49b\uf4c0\uf4e5", -1570254140, "\ue2db\ue300\ue325\ue34a\ue36f\ue394\ue3b9\ue3de\ue403\ue428\ue44d\ue472\ue497\ue4bc\ue4e1", true, "\ue9f9\uea1e\uea43\uea68\uea8d\ueab2\uead7\ueafc\ueb21\ueb46\ueb6b\ueb90", true, "\uf117\uf13c\uf161\uf186\uf1ab\uf1d0\uf1f5\uf21a\uf23f\uf264\uf289\uf2ae", true, "\ue035\ue05a\ue07f\ue0a4\ue0c9\ue0ee\ue113\ue138\ue15d\ue182\ue1a7\ue1cc\ue1f1\ue216\ue23b\ue260\ue285\ue2aa", true}, {"\ueda0\uedc5\uedea\uee0f\uee34\uee59\uee7e\ueea3\ueec8\ueeed\uef12", 911695130616490469L, "\uf4be\uf4e3\uf508\uf52d\uf552\uf577\uf59c\uf5c1", -788535189, "\ue3dc\ue401\ue426\ue44b\ue470\ue495\ue4ba\ue4df\ue504\ue529\ue54e\ue573\ue598\ue5bd\ue5e2\ue607\ue62c", false, "\ueafa\ueb1f\ueb44\ueb69\ueb8e\uebb3\uebd8\uebfd\uec22\uec47\uec6c\uec91\uecb6\uecdb\ued00\ued25", false, "\uf218\uf23d\uf262\uf287\uf2ac\uf2d1\uf2f6\uf31b\uf340\uf365\uf38a\uf3af\uf3d4\uf3f9\uf41e\uf443", false, "\ue136\ue15b\ue180\ue1a5\ue1ca\ue1ef\ue214\ue239\ue25e\ue283\ue2a8\ue2cd\ue2f2", false}, {"\ueea1\ueec6\ueeeb\uef10\uef35\uef5a\uef7f\uefa4\uefc9", 911695130616556006L, "\uf5bf\uf5e4\uf609\uf62e\uf653\uf678\uf69d\uf6c2\uf6e7\uf70c\uf731\uf756\uf77b\uf7a0\uf7c5", 18296594, "\ue4dd\ue502\ue527\ue54c\ue571\ue596\ue5bb\ue5e0\ue605\ue62a\ue64f\ue674", true, "\uebfb\uec20\uec45\uec6a\uec8f\uecb4\uecd9\uecfe\ued23\ued48\ued6d\ued92", true, "\uf319\uf33e\uf363\uf388\uf3ad\uf3d2\uf3f7\uf41c\uf441\uf466\uf48b\uf4b0\uf4d5\uf4fa\uf51f\uf544\uf569\uf58e", true, "\ue237\ue25c\ue281\ue2a6\ue2cb\ue2f0\ue315\ue33a\ue35f\ue384\ue3a9\ue3ce\ue3f3\ue418\ue43d\ue462", true}, {"\uefa2\uefc7\uefec\uf011\uf036\uf05b\uf080\uf0a5", 911695130616621543L, "\uf6c0\uf6e5\uf70a\uf72f\uf754\uf779\uf79e\uf7c3\uf7e8\ue00d\ue032\ue057\ue07c\ue0a1\ue0c6\ue0eb\ue110", 1336895161, "\ue5de\ue603\ue628\ue64d\ue672\ue697\ue6bc\ue6e1\ue706\ue72b\ue750\ue775\ue79a\ue7bf\ue7e4\ue809", false, "\uecfc\ued21\ued46\ued6b\ued90\uedb5\uedda\uedff\uee24\uee49\uee6e\uee93\ueeb8\ueedd\uef02\uef27", false, "\uf41a\uf43f\uf464\uf489\uf4ae\uf4d3\uf4f8\uf51d\uf542\uf567\uf58c\uf5b1\uf5d6", false, "\ue338\ue35d\ue382\ue3a7\ue3cc\ue3f1\ue416\ue43b\ue460\ue485\ue4aa\ue4cf", false}, {"\uf0a3\uf0c8\uf0ed\uf112\uf137\uf15c\uf181\uf1a6\uf1cb\uf1f0\uf215\uf23a\uf25f\uf284\uf2a9", 911695130616687080L, "\uf7c1\uf7e6\ue00b\ue030\ue055\ue07a\ue09f\ue0c4\ue0e9\ue10e\ue133\ue158", -37307296, "\ue6df\ue704\ue729\ue74e\ue773\ue798\ue7bd\ue7e2\ue807\ue82c\ue851\ue876", true, "\uedfd\uee22\uee47\uee6c\uee91\ueeb6\ueedb\uef00\uef25\uef4a\uef6f\uef94\uefb9\uefde\uf003\uf028\uf04d\uf072", true, "\uf51b\uf540\uf565\uf58a\uf5af\uf5d4\uf5f9\uf61e\uf643\uf668\uf68d\uf6b2\uf6d7\uf6fc\uf721\uf746", true, "\ue439\ue45e\ue483\ue4a8\ue4cd\ue4f2\ue517\ue53c\ue561\ue586", true}, {"\uf1a4\uf1c9\uf1ee\uf213\uf238\uf25d\uf282\uf2a7\uf2cc\uf2f1\uf316\uf33b\uf360\uf385\uf3aa\uf3cf\uf3f4", 911695130616752617L, "\ue0c2\ue0e7\ue10c\ue131\ue156\ue17b\ue1a0\ue1c5\ue1ea\ue20f\ue234\ue259\ue27e\ue2a3\ue2c8\ue2ed", 710865671, "\ue7e0\ue805\ue82a\ue84f\ue874\ue899\ue8be\ue8e3\ue908\ue92d\ue952\ue977\ue99c\ue9c1\ue9e6\uea0b", false, "\ueefe\uef23\uef48\uef6d\uef92\uefb7\uefdc\uf001\uf026\uf04b\uf070\uf095\uf0ba", false, "\uf61c\uf641\uf666\uf68b\uf6b0\uf6d5\uf6fa\uf71f\uf744\uf769\uf78e\uf7b3", false, "\ue53a\ue55f\ue584\ue5a9\ue5ce\ue5f3\ue618\ue63d\ue662", false}, {"\uf2a5\uf2ca\uf2ef\uf314\uf339\uf35e\uf383\uf3a8\uf3cd\uf3f2\uf417\uf43c", 911695130616818154L, "\ue1c3\ue1e8\ue20d\ue232\ue257\ue27c\ue2a1\ue2c6\ue2eb\ue310\ue335\ue35a", 1492519598, "\ue8e1\ue906\ue92b\ue950\ue975\ue99a\ue9bf\ue9e4\uea09\uea2e\uea53\uea78\uea9d\ueac2\ueae7\ueb0c\ueb31\ueb56", true, "\uefff\uf024\uf049\uf06e\uf093\uf0b8\uf0dd\uf102\uf127\uf14c\uf171\uf196\uf1bb\uf1e0\uf205\uf22a", true, "\uf71d\uf742\uf767\uf78c\uf7b1\uf7d6\uf7fb\ue020\ue045\ue06a", true, "\ue63b\ue660\ue685\ue6aa\ue6cf\ue6f4\ue719\ue73e\ue763\ue788\ue7ad\ue7d2\ue7f7\ue81c", true}, {"\uf3a6\uf3cb\uf3f0\uf415\uf43a\uf45f\uf484\uf4a9\uf4ce\uf4f3\uf518\uf53d\uf562\uf587\uf5ac\uf5d1", 911695130616883691L, "\ue2c4\ue2e9\ue30e\ue333\ue358\ue37d\ue3a2\ue3c7\ue3ec\ue411\ue436\ue45b\ue480\ue4a5\ue4ca\ue4ef", -1995554731, "\ue9e2\uea07\uea2c\uea51\uea76\uea9b\ueac0\ueae5\ueb0a\ueb2f\ueb54\ueb79\ueb9e", false, "\uf100\uf125\uf14a\uf16f\uf194\uf1b9\uf1de\uf203\uf228\uf24d\uf272\uf297", false, "\ue01e\ue043\ue068\ue08d\ue0b2\ue0d7\ue0fc\ue121\ue146", false, "\ue73c\ue761\ue786\ue7ab\ue7d0\ue7f5\ue81a\ue83f\ue864\ue889\ue8ae", false}, {"\uf4a7\uf4cc\uf4f1\uf516\uf53b\uf560\uf585\uf5aa\uf5cf\uf5f4\uf619\uf63e", 911695130616949228L, "\ue3c5\ue3ea\ue40f\ue434\ue459\ue47e\ue4a3\ue4c8\ue4ed\ue512\ue537\ue55c\ue581\ue5a6\ue5cb\ue5f0\ue615\ue63a", 933857276, "\ueae3\ueb08\ueb2d\ueb52\ueb77\ueb9c\uebc1\uebe6\uec0b\uec30\uec55\uec7a\uec9f\uecc4\uece9\ued0e", true, "\uf201\uf226\uf24b\uf270\uf295\uf2ba\uf2df\uf304\uf329\uf34e", true, "\ue11f\ue144\ue169\ue18e\ue1b3\ue1d8\ue1fd\ue222\ue247\ue26c\ue291\ue2b6\ue2db\ue300", true, "\ue83d\ue862\ue887\ue8ac\ue8d1\ue8f6\ue91b\ue940\ue965", true}, {"\uf5a8\uf5cd\uf5f2\uf617\uf63c\uf661\uf686\uf6ab\uf6d0\uf6f5\uf71a\uf73f\uf764\uf789\uf7ae\uf7d3", 911695130617014765L, "\ue4c6\ue4eb\ue510\ue535\ue55a\ue57f\ue5a4\ue5c9\ue5ee\ue613\ue638\ue65d\ue682", 1707204259, "\uebe4\uec09\uec2e\uec53\uec78\uec9d\uecc2\uece7\ued0c\ued31\ued56\ued7b", false, "\uf302\uf327\uf34c\uf371\uf396\uf3bb\uf3e0\uf405\uf42a", false, "\ue220\ue245\ue26a\ue28f\ue2b4\ue2d9\ue2fe\ue323\ue348\ue36d\ue392", false, "\ue93e\ue963\ue988\ue9ad\ue9d2\ue9f7\uea1c\uea41", false}, {"\uf6a9\uf6ce\uf6f3\uf718\uf73d\uf762\uf787\uf7ac\uf7d1\uf7f6\ue01b\ue040\ue065\ue08a\ue0af\ue0d4\ue0f9\ue11e", 911695130617080302L, "\ue5c7\ue5ec\ue611\ue636\ue65b\ue680\ue6a5\ue6ca\ue6ef\ue714\ue739\ue75e\ue783\ue7a8\ue7cd\ue7f2", -1839655862, "\uece5\ued0a\ued2f\ued54\ued79\ued9e\uedc3\uede8\uee0d\uee32", true, "\uf403\uf428\uf44d\uf472\uf497\uf4bc\uf4e1\uf506\uf52b\uf550\uf575\uf59a\uf5bf\uf5e4", true, "\ue321\ue346\ue36b\ue390\ue3b5\ue3da\ue3ff\ue424\ue449", true, "\uea3f\uea64\uea89\ueaae\uead3\ueaf8\ueb1d\ueb42\ueb67\ueb8c\uebb1\uebd6\uebfb\uec20\uec45", true}, {"\uf7aa\uf7cf\uf7f4\ue019\ue03e\ue063\ue088\ue0ad\ue0d2\ue0f7\ue11c\ue141\ue166", 911695130617145839L, "\ue6c8\ue6ed\ue712\ue737\ue75c\ue781\ue7a6\ue7cb\ue7f0\ue815\ue83a\ue85f", -1057936399, "\uede6\uee0b\uee30\uee55\uee7a\uee9f\ueec4\ueee9\uef0e", false, "\uf504\uf529\uf54e\uf573\uf598\uf5bd\uf5e2\uf607\uf62c\uf651\uf676", false, "\ue422\ue447\ue46c\ue491\ue4b6\ue4db\ue500\ue525", false, "\ueb40\ueb65\ueb8a\uebaf\uebd4\uebf9\uec1e\uec43\uec68\uec8d\uecb2\uecd7\uecfc\ued21\ued46\ued6b\ued90", false}, {"\ue0ab\ue0d0\ue0f5\ue11a\ue13f\ue164\ue189\ue1ae\ue1d3\ue1f8\ue21d\ue242\ue267\ue28c\ue2b1\ue2d6", 911695130617211376L, "\ue7c9\ue7ee\ue813\ue838\ue85d\ue882\ue8a7\ue8cc\ue8f1\ue916", 1896440472, "\ueee7\uef0c\uef31\uef56\uef7b\uefa0\uefc5\uefea\uf00f\uf034\uf059\uf07e\uf0a3\uf0c8", true, "\uf605\uf62a\uf64f\uf674\uf699\uf6be\uf6e3\uf708\uf72d", true, "\ue523\ue548\ue56d\ue592\ue5b7\ue5dc\ue601\ue626\ue64b\ue670\ue695\ue6ba\ue6df\ue704\ue729", true, "\uec41\uec66\uec8b\uecb0\uecd5\uecfa\ued1f\ued44\ued69\ued8e\uedb3\uedd8", true}, {"\ue1ac\ue1d1\ue1f6\ue21b\ue240\ue265\ue28a\ue2af\ue2d4\ue2f9\ue31e\ue343", 911695130617276913L, "\ue8ca\ue8ef\ue914\ue939\ue95e\ue983\ue9a8\ue9cd\ue9f2", -1079986113, "\uefe8\uf00d\uf032\uf057\uf07c\uf0a1\uf0c6\uf0eb\uf110\uf135\uf15a", false, "\uf706\uf72b\uf750\uf775\uf79a\uf7bf\uf7e4\ue009", false, "\ue624\ue649\ue66e\ue693\ue6b8\ue6dd\ue702\ue727\ue74c\ue771\ue796\ue7bb\ue7e0\ue805\ue82a\ue84f\ue874", false, "\ued42\ued67\ued8c\uedb1\uedd6\uedfb\uee20\uee45\uee6a\uee8f\ueeb4\ueed9\ueefe\uef23\uef48\uef6d", false}, {"\ue2ad\ue2d2\ue2f7\ue31c\ue341\ue366\ue38b\ue3b0\ue3d5\ue3fa", 911695130617342450L, "\ue9cb\ue9f0\uea15\uea3a\uea5f\uea84\ueaa9\ueace\ueaf3\ueb18\ueb3d\ueb62\ueb87\uebac", -331808794, "\uf0e9\uf10e\uf133\uf158\uf17d\uf1a2\uf1c7\uf1ec\uf211", true, "\ue007\ue02c\ue051\ue076\ue09b\ue0c0\ue0e5\ue10a\ue12f\ue154\ue179\ue19e\ue1c3\ue1e8\ue20d", true, "\ue725\ue74a\ue76f\ue794\ue7b9\ue7de\ue803\ue828\ue84d\ue872\ue897\ue8bc", true, "\uee43\uee68\uee8d\ueeb2\ueed7\ueefc\uef21\uef46\uef6b\uef90\uefb5\uefda", true}, {"\ue3ae\ue3d3\ue3f8\ue41d\ue442\ue467\ue48c\ue4b1\ue4d6", 911695130617407987L, "\ueacc\ueaf1\ueb16\ueb3b\ueb60\ueb85\uebaa\uebcf\uebf4\uec19\uec3e", 441464461, "\uf1ea\uf20f\uf234\uf259\uf27e\uf2a3\uf2c8\uf2ed", false, "\ue108\ue12d\ue152\ue177\ue19c\ue1c1\ue1e6\ue20b\ue230\ue255\ue27a\ue29f\ue2c4\ue2e9\ue30e\ue333\ue358", false, "\ue826\ue84b\ue870\ue895\ue8ba\ue8df\ue904\ue929\ue94e\ue973\ue998\ue9bd\ue9e2\uea07\uea2c\uea51", false, "\uef44\uef69\uef8e\uefb3\uefd8\ueffd\uf022\uf047\uf06c\uf091\uf0b6\uf0db\uf100\uf125\uf14a\uf16f", false}, {"\ue4af\ue4d4\ue4f9\ue51e\ue543\ue568\ue58d\ue5b2\ue5d7\ue5fc\ue621\ue646\ue66b\ue690", 911695130617473524L, "\uebcd\uebf2\uec17\uec3c\uec61\uec86\uecab\uecd0\uecf5", 1223183412, "\uf2eb\uf310\uf335\uf35a\uf37f\uf3a4\uf3c9\uf3ee\uf413\uf438\uf45d\uf482\uf4a7\uf4cc\uf4f1", true, "\ue209\ue22e\ue253\ue278\ue29d\ue2c2\ue2e7\ue30c\ue331\ue356\ue37b\ue3a0", true, "\ue927\ue94c\ue971\ue996\ue9bb\ue9e0\uea05\uea2a\uea4f\uea74\uea99\ueabe", true, "\uf045\uf06a\uf08f\uf0b4\uf0d9\uf0fe\uf123\uf148\uf16d\uf192\uf1b7\uf1dc\uf201\uf226\uf24b\uf270\uf295\uf2ba", true}, {"\ue5b0\ue5d5\ue5fa\ue61f\ue644\ue669\ue68e\ue6b3\ue6d8\ue6fd\ue722", 911695130617539061L, "\uecce\uecf3\ued18\ued3d\ued62\ued87\uedac\uedd1", -117210149, "\uf3ec\uf411\uf436\uf45b\uf480\uf4a5\uf4ca\uf4ef\uf514\uf539\uf55e\uf583\uf5a8\uf5cd\uf5f2\uf617\uf63c", false, "\ue30a\ue32f\ue354\ue379\ue39e\ue3c3\ue3e8\ue40d\ue432\ue457\ue47c\ue4a1\ue4c6\ue4eb\ue510\ue535", false, "\uea28\uea4d\uea72\uea97\ueabc\ueae1\ueb06\ueb2b\ueb50\ueb75\ueb9a\uebbf\uebe4\uec09\uec2e\uec53", false, "\uf146\uf16b\uf190\uf1b5\uf1da\uf1ff\uf224\uf249\uf26e\uf293\uf2b8\uf2dd\uf302", false}, {"\ue6b1\ue6d6\ue6fb\ue720\ue745\ue76a\ue78f\ue7b4\ue7d9", 911695130617604598L, "\uedcf\uedf4\uee19\uee3e\uee63\uee88\ueead\ueed2\ueef7\uef1c\uef41\uef66\uef8b\uefb0\uefd5", 664525442, "\uf4ed\uf512\uf537\uf55c\uf581\uf5a6\uf5cb\uf5f0\uf615\uf63a\uf65f\uf684", true, "\ue40b\ue430\ue455\ue47a\ue49f\ue4c4\ue4e9\ue50e\ue533\ue558\ue57d\ue5a2", true, "\ueb29\ueb4e\ueb73\ueb98\uebbd\uebe2\uec07\uec2c\uec51\uec76\uec9b\uecc0\uece5\ued0a\ued2f\ued54\ued79\ued9e", true, "\uf247\uf26c\uf291\uf2b6\uf2db\uf300\uf325\uf34a\uf36f\uf394\uf3b9\uf3de\uf403\uf428\uf44d\uf472", true}, {"\ue7b2\ue7d7\ue7fc\ue821\ue846\ue86b\ue890\ue8b5", 911695130617670135L, "\ueed0\ueef5\uef1a\uef3f\uef64\uef89\uefae\uefd3\ueff8\uf01d\uf042\uf067\uf08c\uf0b1\uf0d6\uf0fb\uf120", 1412632617, "\uf5ee\uf613\uf638\uf65d\uf682\uf6a7\uf6cc\uf6f1\uf716\uf73b\uf760\uf785\uf7aa\uf7cf\uf7f4\ue019", false, "\ue50c\ue531\ue556\ue57b\ue5a0\ue5c5\ue5ea\ue60f\ue634\ue659\ue67e\ue6a3\ue6c8\ue6ed\ue712\ue737", false, "\uec2a\uec4f\uec74\uec99\uecbe\uece3\ued08\ued2d\ued52\ued77\ued9c\uedc1\uede6", false, "\uf348\uf36d\uf392\uf3b7\uf3dc\uf401\uf426\uf44b\uf470\uf495\uf4ba\uf4df", false}, {"\ue8b3\ue8d8\ue8fd\ue922\ue947\ue96c\ue991\ue9b6\ue9db\uea00\uea25\uea4a\uea6f\uea94\ueab9", 911695130617735672L, "\uefd1\ueff6\uf01b\uf040\uf065\uf08a\uf0af\uf0d4\uf0f9\uf11e\uf143\uf168", -2108991536, "\uf6ef\uf714\uf739\uf75e\uf783\uf7a8\uf7cd\uf7f2\ue017\ue03c\ue061\ue086", true, "\ue60d\ue632\ue657\ue67c\ue6a1\ue6c6\ue6eb\ue710\ue735\ue75a\ue77f\ue7a4\ue7c9\ue7ee\ue813\ue838\ue85d\ue882", true, "\ued2b\ued50\ued75\ued9a\uedbf\uede4\uee09\uee2e\uee53\uee78\uee9d\ueec2\ueee7\uef0c\uef31\uef56", true, "\uf449\uf46e\uf493\uf4b8\uf4dd\uf502\uf527\uf54c\uf571\uf596", true}, {"\ue9b4\ue9d9\ue9fe\uea23\uea48\uea6d\uea92\ueab7\ueadc\ueb01\ueb26\ueb4b\ueb70\ueb95\uebba\uebdf\uec04", 911695130617801209L, "\uf0d2\uf0f7\uf11c\uf141\uf166\uf18b\uf1b0\uf1d5\uf1fa\uf21f\uf244\uf269\uf28e\uf2b3\uf2d8\uf2fd", 820211063, "\uf7f0\ue015\ue03a\ue05f\ue084\ue0a9\ue0ce\ue0f3\ue118\ue13d\ue162\ue187\ue1ac\ue1d1\ue1f6\ue21b", false, "\ue70e\ue733\ue758\ue77d\ue7a2\ue7c7\ue7ec\ue811\ue836\ue85b\ue880\ue8a5\ue8ca", false, "\uee2c\uee51\uee76\uee9b\ueec0\ueee5\uef0a\uef2f\uef54\uef79\uef9e\uefc3", false, "\uf54a\uf56f\uf594\uf5b9\uf5de\uf603\uf628\uf64d\uf672", false}, {"\ueab5\ueada\ueaff\ueb24\ueb49\ueb6e\ueb93\uebb8\uebdd\uec02\uec27\uec4c", 911695130617866746L, "\uf1d3\uf1f8\uf21d\uf242\uf267\uf28c\uf2b1\uf2d6\uf2fb\uf320\uf345\uf36a", 1635427358, "\ue0f1\ue116\ue13b\ue160\ue185\ue1aa\ue1cf\ue1f4\ue219\ue23e\ue263\ue288\ue2ad\ue2d2\ue2f7\ue31c\ue341\ue366", true, "\ue80f\ue834\ue859\ue87e\ue8a3\ue8c8\ue8ed\ue912\ue937\ue95c\ue981\ue9a6\ue9cb\ue9f0\uea15\uea3a", true, "\uef2d\uef52\uef77\uef9c\uefc1\uefe6\uf00b\uf030\uf055\uf07a", true, "\uf64b\uf670\uf695\uf6ba\uf6df\uf704\uf729\uf74e\uf773\uf798\uf7bd\uf7e2\ue007\ue02c", true}, {"\uebb6\uebdb\uec00\uec25\uec4a\uec6f\uec94\uecb9\uecde\ued03\ued28\ued4d\ued72\ued97\uedbc\uede1", 911695130617932283L, "\uf2d4\uf2f9\uf31e\uf343\uf368\uf38d\uf3b2\uf3d7\uf3fc\uf421\uf446\uf46b\uf490\uf4b5\uf4da\uf4ff", -1349321787, "\ue1f2\ue217\ue23c\ue261\ue286\ue2ab\ue2d0\ue2f5\ue31a\ue33f\ue364\ue389\ue3ae", false, "\ue910\ue935\ue95a\ue97f\ue9a4\ue9c9\ue9ee\uea13\uea38\uea5d\uea82\ueaa7", false, "\uf02e\uf053\uf078\uf09d\uf0c2\uf0e7\uf10c\uf131\uf156", false, "\uf74c\uf771\uf796\uf7bb\uf7e0\ue005\ue02a\ue04f\ue074\ue099\ue0be", false}, {"\uecb7\uecdc\ued01\ued26\ued4b\ued70\ued95\uedba\ueddf\uee04\uee29\uee4e", 911695130617997820L, "\uf3d5\uf3fa\uf41f\uf444\uf469\uf48e\uf4b3\uf4d8\uf4fd\uf522\uf547\uf56c\uf591\uf5b6\uf5db\uf600\uf625\uf64a", -601214612, "\ue2f3\ue318\ue33d\ue362\ue387\ue3ac\ue3d1\ue3f6\ue41b\ue440\ue465\ue48a\ue4af\ue4d4\ue4f9\ue51e", true, "\uea11\uea36\uea5b\uea80\ueaa5\ueaca\ueaef\ueb14\ueb39\ueb5e", true, "\uf12f\uf154\uf179\uf19e\uf1c3\uf1e8\uf20d\uf232\uf257\uf27c\uf2a1\uf2c6\uf2eb\uf310", true, "\ue04d\ue072\ue097\ue0bc\ue0e1\ue106\ue12b\ue150\ue175", true}, {"\uedb8\ueddd\uee02\uee27\uee4c\uee71\uee96\ueebb\ueee0\uef05\uef2a\uef4f\uef74\uef99\uefbe\uefe3", 911695130618063357L, "\uf4d6\uf4fb\uf520\uf545\uf56a\uf58f\uf5b4\uf5d9\uf5fe\uf623\uf648\uf66d\uf692", 172115987, "\ue3f4\ue419\ue43e\ue463\ue488\ue4ad\ue4d2\ue4f7\ue51c\ue541\ue566\ue58b", false, "\ueb12\ueb37\ueb5c\ueb81\ueba6\uebcb\uebf0\uec15\uec3a", false, "\uf230\uf255\uf27a\uf29f\uf2c4\uf2e9\uf30e\uf333\uf358\uf37d\uf3a2", false, "\ue14e\ue173\ue198\ue1bd\ue1e2\ue207\ue22c\ue251", false}, {"\ueeb9\ueede\uef03\uef28\uef4d\uef72\uef97\uefbc\uefe1\uf006\uf02b\uf050\uf075\uf09a\uf0bf\uf0e4\uf109\uf12e", 911695130618128894L, "\uf5d7\uf5fc\uf621\uf646\uf66b\uf690\uf6b5\uf6da\uf6ff\uf724\uf749\uf76e\uf793\uf7b8\uf7dd\ue002", -1193439302, "\ue4f5\ue51a\ue53f\ue564\ue589\ue5ae\ue5d3\ue5f8\ue61d\ue642", true, "\uec13\uec38\uec5d\uec82\ueca7\ueccc\uecf1\ued16\ued3b\ued60\ued85\uedaa\uedcf\uedf4", true, "\uf331\uf356\uf37b\uf3a0\uf3c5\uf3ea\uf40f\uf434\uf459", true, "\ue24f\ue274\ue299\ue2be\ue2e3\ue308\ue32d\ue352\ue377\ue39c\ue3c1\ue3e6\ue40b\ue430\ue455", true}, {"\uefba\uefdf\uf004\uf029\uf04e\uf073\uf098\uf0bd\uf0e2\uf107\uf12c\uf151\uf176", 911695130618194431L, "\uf6d8\uf6fd\uf722\uf747\uf76c\uf791\uf7b6\uf7db\ue000\ue025\ue04a\ue06f", -378157727, "\ue5f6\ue61b\ue640\ue665\ue68a\ue6af\ue6d4\ue6f9\ue71e", false, "\ued14\ued39\ued5e\ued83\ueda8\uedcd\uedf2\uee17\uee3c\uee61\uee86", false, "\uf432\uf457\uf47c\uf4a1\uf4c6\uf4eb\uf510\uf535", false, "\ue350\ue375\ue39a\ue3bf\ue3e4\ue409\ue42e\ue453\ue478\ue49d\ue4c2\ue4e7\ue50c\ue531\ue556\ue57b\ue5a0", false}, {"\uf0bb\uf0e0\uf105\uf12a\uf14f\uf174\uf199\uf1be\uf1e3\uf208\uf22d\uf252\uf277\uf29c\uf2c1\uf2e6", 911695130618259968L, "\uf7d9\uf7fe\ue023\ue048\ue06d\ue092\ue0b7\ue0dc\ue101\ue126", 395123720, "\ue6f7\ue71c\ue741\ue766\ue78b\ue7b0\ue7d5\ue7fa\ue81f\ue844\ue869\ue88e\ue8b3\ue8d8", true, "\uee15\uee3a\uee5f\uee84\ueea9\ueece\ueef3\uef18\uef3d", true, "\uf533\uf558\uf57d\uf5a2\uf5c7\uf5ec\uf611\uf636\uf65b\uf680\uf6a5\uf6ca\uf6ef\uf714\uf739", true, "\ue451\ue476\ue49b\ue4c0\ue4e5\ue50a\ue52f\ue554\ue579\ue59e\ue5c3\ue5e8", true}, {"\uf1bc\uf1e1\uf206\uf22b\uf250\uf275\uf29a\uf2bf\uf2e4\uf309\uf32e\uf353", 911695130618325505L, "\ue0da\ue0ff\ue124\ue149\ue16e\ue193\ue1b8\ue1dd\ue202", 1143296943, "\ue7f8\ue81d\ue842\ue867\ue88c\ue8b1\ue8d6\ue8fb\ue920\ue945\ue96a", false, "\uef16\uef3b\uef60\uef85\uefaa\uefcf\ueff4\uf019", false, "\uf634\uf659\uf67e\uf6a3\uf6c8\uf6ed\uf712\uf737\uf75c\uf781\uf7a6\uf7cb\uf7f0\ue015\ue03a\ue05f\ue084", false, "\ue552\ue577\ue59c\ue5c1\ue5e6\ue60b\ue630\ue655\ue67a\ue69f\ue6c4\ue6e9\ue70e\ue733\ue758\ue77d", false}, {"\uf2bd\uf2e2\uf307\uf32c\uf351\uf376\uf39b\uf3c0\uf3e5\uf40a", 911695130618391042L, "\ue1db\ue200\ue225\ue24a\ue26f\ue294\ue2b9\ue2de\ue303\ue328\ue34d\ue372\ue397\ue3bc", -222467754, "\ue8f9\ue91e\ue943\ue968\ue98d\ue9b2\ue9d7\ue9fc\uea21", true, "\uf017\uf03c\uf061\uf086\uf0ab\uf0d0\uf0f5\uf11a\uf13f\uf164\uf189\uf1ae\uf1d3\uf1f8\uf21d", true, "\uf735\uf75a\uf77f\uf7a4\uf7c9\uf7ee\ue013\ue038\ue05d\ue082\ue0a7\ue0cc", true, "\ue653\ue678\ue69d\ue6c2\ue6e7\ue70c\ue731\ue756\ue77b\ue7a0\ue7c5\ue7ea", true}, {"\uf3be\uf3e3\uf408\uf42d\uf452\uf477\uf49c\uf4c1\uf4e6", 911695130618456579L, "\ue2dc\ue301\ue326\ue34b\ue370\ue395\ue3ba\ue3df\ue404\ue429\ue44e", 550805757, "\ue9fa\uea1f\uea44\uea69\uea8e\ueab3\uead8\ueafd", false, "\uf118\uf13d\uf162\uf187\uf1ac\uf1d1\uf1f6\uf21b\uf240\uf265\uf28a\uf2af\uf2d4\uf2f9\uf31e\uf343\uf368", false, "\ue036\ue05b\ue080\ue0a5\ue0ca\ue0ef\ue114\ue139\ue15e\ue183\ue1a8\ue1cd\ue1f2\ue217\ue23c\ue261", false, "\ue754\ue779\ue79e\ue7c3\ue7e8\ue80d\ue832\ue857\ue87c\ue8a1\ue8c6\ue8eb\ue910\ue935\ue95a\ue97f", false}, {"\uf4bf\uf4e4\uf509\uf52e\uf553\uf578\uf59d\uf5c2\uf5e7\uf60c\uf631\uf656\uf67b\uf6a0", 911695130618522116L, "\ue3dd\ue402\ue427\ue44c\ue471\ue496\ue4bb\ue4e0\ue505", 1366091684, "\ueafb\ueb20\ueb45\ueb6a\ueb8f\uebb4\uebd9\uebfe\uec23\uec48\uec6d\uec92\uecb7\uecdc\ued01", true, "\uf219\uf23e\uf263\uf288\uf2ad\uf2d2\uf2f7\uf31c\uf341\uf366\uf38b\uf3b0", true, "\ue137\ue15c\ue181\ue1a6\ue1cb\ue1f0\ue215\ue23a\ue25f\ue284\ue2a9\ue2ce", true, "\ue855\ue87a\ue89f\ue8c4\ue8e9\ue90e\ue933\ue958\ue97d\ue9a2\ue9c7\ue9ec\uea11\uea36\uea5b\uea80\ueaa5\ueaca", true}, {"\uf5c0\uf5e5\uf60a\uf62f\uf654\uf679\uf69e\uf6c3\uf6e8\uf70d\uf732", 911695130618587653L, "\ue4de\ue503\ue528\ue54d\ue572\ue597\ue5bc\ue5e1", -1618723509, "\uebfc\uec21\uec46\uec6b\uec90\uecb5\uecda\uecff\ued24\ued49\ued6e\ued93\uedb8\ueddd\uee02\uee27\uee4c", false, "\uf31a\uf33f\uf364\uf389\uf3ae\uf3d3\uf3f8\uf41d\uf442\uf467\uf48c\uf4b1\uf4d6\uf4fb\uf520\uf545", false, "\ue238\ue25d\ue282\ue2a7\ue2cc\ue2f1\ue316\ue33b\ue360\ue385\ue3aa\ue3cf\ue3f4\ue419\ue43e\ue463", false, "\ue956\ue97b\ue9a0\ue9c5\ue9ea\uea0f\uea34\uea59\uea7e\ueaa3\ueac8\ueaed\ueb12", false}, {"\uf6c1\uf6e6\uf70b\uf730\uf755\uf77a\uf79f\uf7c4\uf7e9", 911695130618653190L, "\ue5df\ue604\ue629\ue64e\ue673\ue698\ue6bd\ue6e2\ue707\ue72c\ue751\ue776\ue79b\ue7c0\ue7e5", -870550286, "\uecfd\ued22\ued47\ued6c\ued91\uedb6\ueddb\uee00\uee25\uee4a\uee6f\uee94", true, "\uf41b\uf440\uf465\uf48a\uf4af\uf4d4\uf4f9\uf51e\uf543\uf568\uf58d\uf5b2", true, "\ue339\ue35e\ue383\ue3a8\ue3cd\ue3f2\ue417\ue43c\ue461\ue486\ue4ab\ue4d0\ue4f5\ue51a\ue53f\ue564\ue589\ue5ae", true, "\uea57\uea7c\ueaa1\ueac6\ueaeb\ueb10\ueb35\ueb5a\ueb7f\ueba4\uebc9\uebee\uec13\uec38\uec5d\uec82", true}, {"\uf7c2\uf7e7\ue00c\ue031\ue056\ue07b\ue0a0\ue0c5", 911695130618718727L, "\ue6e0\ue705\ue72a\ue74f\ue774\ue799\ue7be\ue7e3\ue808\ue82d\ue852\ue877\ue89c\ue8c1\ue8e6\ue90b\ue930", 2058849177, "\uedfe\uee23\uee48\uee6d\uee92\ueeb7\ueedc\uef01\uef26\uef4b\uef70\uef95\uefba\uefdf\uf004\uf029", false, "\uf51c\uf541\uf566\uf58b\uf5b0\uf5d5\uf5fa\uf61f\uf644\uf669\uf68e\uf6b3\uf6d8\uf6fd\uf722\uf747", false, "\ue43a\ue45f\ue484\ue4a9\ue4ce\ue4f3\ue518\ue53d\ue562\ue587\ue5ac\ue5d1\ue5f6", false, "\ueb58\ueb7d\ueba2\uebc7\uebec\uec11\uec36\uec5b\uec80\ueca5\uecca\uecef", false}, {"\ue0c3\ue0e8\ue10d\ue132\ue157\ue17c\ue1a1\ue1c6\ue1eb\ue210\ue235\ue25a\ue27f\ue2a4\ue2c9", 911695130618784264L, "\ue7e1\ue806\ue82b\ue850\ue875\ue89a\ue8bf\ue8e4\ue909\ue92e\ue953\ue978", -1462779584, "\ueeff\uef24\uef49\uef6e\uef93\uefb8\uefdd\uf002\uf027\uf04c\uf071\uf096", true, "\uf61d\uf642\uf667\uf68c\uf6b1\uf6d6\uf6fb\uf720\uf745\uf76a\uf78f\uf7b4\uf7d9\uf7fe\ue023\ue048\ue06d\ue092", true, "\ue53b\ue560\ue585\ue5aa\ue5cf\ue5f4\ue619\ue63e\ue663\ue688\ue6ad\ue6d2\ue6f7\ue71c\ue741\ue766", true, "\uec59\uec7e\ueca3\uecc8\ueced\ued12\ued37\ued5c\ued81\ueda6", true}, {"\ue1c4\ue1e9\ue20e\ue233\ue258\ue27d\ue2a2\ue2c7\ue2ec\ue311\ue336\ue35b\ue380\ue3a5\ue3ca\ue3ef\ue414", 911695130618849801L, "\ue8e2\ue907\ue92c\ue951\ue976\ue99b\ue9c0\ue9e5\uea0a\uea2f\uea54\uea79\uea9e\ueac3\ueae8\ueb0d", -647554841, "\uf000\uf025\uf04a\uf06f\uf094\uf0b9\uf0de\uf103\uf128\uf14d\uf172\uf197\uf1bc\uf1e1\uf206\uf22b", false, "\uf71e\uf743\uf768\uf78d\uf7b2\uf7d7\uf7fc\ue021\ue046\ue06b\ue090\ue0b5\ue0da", false, "\ue63c\ue661\ue686\ue6ab\ue6d0\ue6f5\ue71a\ue73f\ue764\ue789\ue7ae\ue7d3", false, "\ued5a\ued7f\ueda4\uedc9\uedee\uee13\uee38\uee5d\uee82", false}, {"\ue2c5\ue2ea\ue30f\ue334\ue359\ue37e\ue3a3\ue3c8\ue3ed\ue412\ue437\ue45c", 911695130618915338L, "\ue9e3\uea08\uea2d\uea52\uea77\uea9c\ueac1\ueae6\ueb0b\ueb30\ueb55\ueb7a", 134176654, "\uf101\uf126\uf14b\uf170\uf195\uf1ba\uf1df\uf204\uf229\uf24e\uf273\uf298\uf2bd\uf2e2\uf307\uf32c\uf351\uf376", true, "\ue01f\ue044\ue069\ue08e\ue0b3\ue0d8\ue0fd\ue122\ue147\ue16c\ue191\ue1b6\ue1db\ue200\ue225\ue24a", true, "\ue73d\ue762\ue787\ue7ac\ue7d1\ue7f6\ue81b\ue840\ue865\ue88a", true, "\uee5b\uee80\ueea5\ueeca\ueeef\uef14\uef39\uef5e\uef83\uefa8\uefcd\ueff2\uf017\uf03c", true}, {"\ue3c6\ue3eb\ue410\ue435\ue45a\ue47f\ue4a4\ue4c9\ue4ee\ue513\ue538\ue55d\ue582\ue5a7\ue5cc\ue5f1", 911695130618980875L, "\ueae4\ueb09\ueb2e\ueb53\ueb78\ueb9d\uebc2\uebe7\uec0c\uec31\uec56\uec7b\ueca0\uecc5\uecea\ued0f", -1273588427, "\uf202\uf227\uf24c\uf271\uf296\uf2bb\uf2e0\uf305\uf32a\uf34f\uf374\uf399\uf3be", false, "\ue120\ue145\ue16a\ue18f\ue1b4\ue1d9\ue1fe\ue223\ue248\ue26d\ue292\ue2b7", false, "\ue83e\ue863\ue888\ue8ad\ue8d2\ue8f7\ue91c\ue941\ue966", false, "\uef5c\uef81\uefa6\uefcb\ueff0\uf015\uf03a\uf05f\uf084\uf0a9\uf0ce", false}, {"\ue4c7\ue4ec\ue511\ue536\ue55b\ue580\ue5a5\ue5ca\ue5ef\ue614\ue639\ue65e", 911695130619046412L, "\uebe5\uec0a\uec2f\uec54\uec79\uec9e\uecc3\uece8\ued0d\ued32\ued57\ued7c\ueda1\uedc6\uedeb\uee10\uee35\uee5a", -491868964, "\uf303\uf328\uf34d\uf372\uf397\uf3bc\uf3e1\uf406\uf42b\uf450\uf475\uf49a\uf4bf\uf4e4\uf509\uf52e", true, "\ue221\ue246\ue26b\ue290\ue2b5\ue2da\ue2ff\ue324\ue349\ue36e", true, "\ue93f\ue964\ue989\ue9ae\ue9d3\ue9f8\uea1d\uea42\uea67\uea8c\ueab1\uead6\ueafb\ueb20", true, "\uf05d\uf082\uf0a7\uf0cc\uf0f1\uf116\uf13b\uf160\uf185", true}, {"\ue5c8\ue5ed\ue612\ue637\ue65c\ue681\ue6a6\ue6cb\ue6f0\ue715\ue73a\ue75f\ue784\ue7a9\ue7ce\ue7f3", 911695130619111949L, "\uece6\ued0b\ued30\ued55\ued7a\ued9f\uedc4\uede9\uee0e\uee33\uee58\uee7d\ueea2", 281469827, "\uf404\uf429\uf44e\uf473\uf498\uf4bd\uf4e2\uf507\uf52c\uf551\uf576\uf59b", false, "\ue322\ue347\ue36c\ue391\ue3b6\ue3db\ue400\ue425\ue44a", false, "\uea40\uea65\uea8a\ueaaf\uead4\ueaf9\ueb1e\ueb43\ueb68\ueb8d\uebb2", false, "\uf15e\uf183\uf1a8\uf1cd\uf1f2\uf217\uf23c\uf261", false}, {"\ue6c9\ue6ee\ue713\ue738\ue75d\ue782\ue7a7\ue7cc\ue7f1\ue816\ue83b\ue860\ue885\ue8aa\ue8cf\ue8f4\ue919\ue93e", 911695130619177486L, "\uede7\uee0c\uee31\uee56\uee7b\ueea0\ueec5\ueeea\uef0f\uef34\uef59\uef7e\uefa3\uefc8\uefed\uf012", 1096694058, "\uf505\uf52a\uf54f\uf574\uf599\uf5be\uf5e3\uf608\uf62d\uf652", true, "\ue423\ue448\ue46d\ue492\ue4b7\ue4dc\ue501\ue526\ue54b\ue570\ue595\ue5ba\ue5df\ue604", true, "\ueb41\ueb66\ueb8b\uebb0\uebd5\uebfa\uec1f\uec44\uec69", true, "\uf25f\uf284\uf2a9\uf2ce\uf2f3\uf318\uf33d\uf362\uf387\uf3ac\uf3d1\uf3f6\uf41b\uf440\uf465", true}, {"\ue7ca\ue7ef\ue814\ue839\ue85e\ue883\ue8a8\ue8cd\ue8f2\ue917\ue93c\ue961\ue986", 911695130619243023L, "\ueee8\uef0d\uef32\uef57\uef7c\uefa1\uefc6\uefeb\uf010\uf035\uf05a\uf07f", -1879674671, "\uf606\uf62b\uf650\uf675\uf69a\uf6bf\uf6e4\uf709\uf72e", false, "\ue524\ue549\ue56e\ue593\ue5b8\ue5dd\ue602\ue627\ue64c\ue671\ue696", false, "\uec42\uec67\uec8c\uecb1\uecd6\uecfb\ued20\ued45", false, "\uf360\uf385\uf3aa\uf3cf\uf3f4\uf419\uf43e\uf463\uf488\uf4ad\uf4d2\uf4f7\uf51c\uf541\uf566\uf58b\uf5b0", false}, {"\ue8cb\ue8f0\ue915\ue93a\ue95f\ue984\ue9a9\ue9ce\ue9f3\uea18\uea3d\uea62\uea87\ueaac\uead1\ueaf6", 911695130619308560L, "\uefe9\uf00e\uf033\uf058\uf07d\uf0a2\uf0c7\uf0ec\uf111\uf136", 1007793784, "\uf707\uf72c\uf751\uf776\uf79b\uf7c0\uf7e5\ue00a\ue02f\ue054\ue079\ue09e\ue0c3\ue0e8", true, "\ue625\ue64a\ue66f\ue694\ue6b9\ue6de\ue703\ue728\ue74d", true, "\ued43\ued68\ued8d\uedb2\uedd7\uedfc\uee21\uee46\uee6b\uee90\ueeb5\ueeda\ueeff\uef24\uef49", true, "\uf461\uf486\uf4ab\uf4d0\uf4f5\uf51a\uf53f\uf564\uf589\uf5ae\uf5d3\uf5f8", true}, {"\ue9cc\ue9f1\uea16\uea3b\uea60\uea85\ueaaa\ueacf\ueaf4\ueb19\ueb3e\ueb63", 911695130619374097L, "\uf0ea\uf10f\uf134\uf159\uf17e\uf1a3\uf1c8\uf1ed\uf212", 1789512991, "\ue008\ue02d\ue052\ue077\ue09c\ue0c1\ue0e6\ue10b\ue130\ue155\ue17a", false, "\ue726\ue74b\ue770\ue795\ue7ba\ue7df\ue804\ue829", false, "\uee44\uee69\uee8e\ueeb3\ueed8\ueefd\uef22\uef47\uef6c\uef91\uefb6\uefdb\uf000\uf025\uf04a\uf06f\uf094", false, "\uf562\uf587\uf5ac\uf5d1\uf5f6\uf61b\uf640\uf665\uf68a\uf6af\uf6d4\uf6f9\uf71e\uf743\uf768\uf78d", false}, {"\ueacd\ueaf2\ueb17\ueb3c\ueb61\ueb86\uebab\uebd0\uebf5\uec1a", 911695130619439634L, "\uf1eb\uf210\uf235\uf25a\uf27f\uf2a4\uf2c9\uf2ee\uf313\uf338\uf35d\uf382\uf3a7\uf3cc", -1732180794, "\ue109\ue12e\ue153\ue178\ue19d\ue1c2\ue1e7\ue20c\ue231", true, "\ue827\ue84c\ue871\ue896\ue8bb\ue8e0\ue905\ue92a\ue94f\ue974\ue999\ue9be\ue9e3\uea08\uea2d", true, "\uef45\uef6a\uef8f\uefb4\uefd9\ueffe\uf023\uf048\uf06d\uf092\uf0b7\uf0dc", true, "\uf663\uf688\uf6ad\uf6d2\uf6f7\uf71c\uf741\uf766\uf78b\uf7b0\uf7d5\uf7fa", true}, {"\uebce\uebf3\uec18\uec3d\uec62\uec87\uecac\uecd1\uecf6", 911695130619505171L, "\uf2ec\uf311\uf336\uf35b\uf380\uf3a5\uf3ca\uf3ef\uf414\uf439\uf45e", -916891027, "\ue20a\ue22f\ue254\ue279\ue29e\ue2c3\ue2e8\ue30d", false, "\ue928\ue94d\ue972\ue997\ue9bc\ue9e1\uea06\uea2b\uea50\uea75\uea9a\ueabf\ueae4\ueb09\ueb2e\ueb53\ueb78", false, "\uf046\uf06b\uf090\uf0b5\uf0da\uf0ff\uf124\uf149\uf16e\uf193\uf1b8\uf1dd\uf202\uf227\uf24c\uf271", false, "\uf764\uf789\uf7ae\uf7d3\uf7f8\ue01d\ue042\ue067\ue08c\ue0b1\ue0d6\ue0fb\ue120\ue145\ue16a\ue18f", false}, {"\ueccf\uecf4\ued19\ued3e\ued63\ued88\uedad\uedd2\uedf7\uee1c\uee41\uee66\uee8b\ueeb0", 911695130619570708L, "\uf3ed\uf412\uf437\uf45c\uf481\uf4a6\uf4cb\uf4f0\uf515", 2012254484, "\ue30b\ue330\ue355\ue37a\ue39f\ue3c4\ue3e9\ue40e\ue433\ue458\ue47d\ue4a2\ue4c7\ue4ec\ue511", true, "\uea29\uea4e\uea73\uea98\ueabd\ueae2\ueb07\ueb2c\ueb51\ueb76\ueb9b\uebc0", true, "\uf147\uf16c\uf191\uf1b6\uf1db\uf200\uf225\uf24a\uf26f\uf294\uf2b9\uf2de", true, "\ue065\ue08a\ue0af\ue0d4\ue0f9\ue11e\ue143\ue168\ue18d\ue1b2\ue1d7\ue1fc\ue221\ue246\ue26b\ue290\ue2b5\ue2da", true}, {"\uedd0\uedf5\uee1a\uee3f\uee64\uee89\ueeae\ueed3\ueef8\uef1d\uef42", 911695130619636245L, "\uf4ee\uf513\uf538\uf55d\uf582\uf5a7\uf5cc\uf5f1", -1542936389, "\ue40c\ue431\ue456\ue47b\ue4a0\ue4c5\ue4ea\ue50f\ue534\ue559\ue57e\ue5a3\ue5c8\ue5ed\ue612\ue637\ue65c", false, "\ueb2a\ueb4f\ueb74\ueb99\uebbe\uebe3\uec08\uec2d\uec52\uec77\uec9c\uecc1\uece6\ued0b\ued30\ued55", false, "\uf248\uf26d\uf292\uf2b7\uf2dc\uf301\uf326\uf34b\uf370\uf395\uf3ba\uf3df\uf404\uf429\uf44e\uf473", false, "\ue166\ue18b\ue1b0\ue1d5\ue1fa\ue21f\ue244\ue269\ue28e\ue2b3\ue2d8\ue2fd\ue322", false}, {"\ueed1\ueef6\uef1b\uef40\uef65\uef8a\uefaf\uefd4\ueff9", 911695130619701782L, "\uf5ef\uf614\uf639\uf65e\uf683\uf6a8\uf6cd\uf6f2\uf717\uf73c\uf761\uf786\uf7ab\uf7d0\uf7f5", -761205150, "\ue50d\ue532\ue557\ue57c\ue5a1\ue5c6\ue5eb\ue610\ue635\ue65a\ue67f\ue6a4", true, "\uec2b\uec50\uec75\uec9a\uecbf\uece4\ued09\ued2e\ued53\ued78\ued9d\uedc2", true, "\uf349\uf36e\uf393\uf3b8\uf3dd\uf402\uf427\uf44c\uf471\uf496\uf4bb\uf4e0\uf505\uf52a\uf54f\uf574\uf599\uf5be", true, "\ue267\ue28c\ue2b1\ue2d6\ue2fb\ue320\ue345\ue36a\ue38f\ue3b4\ue3d9\ue3fe\ue423\ue448\ue46d\ue492", true}, {"\uefd2\ueff7\uf01c\uf041\uf066\uf08b\uf0b0\uf0d5", 911695130619767319L, "\uf6f0\uf715\uf73a\uf75f\uf784\uf7a9\uf7ce\uf7f3\ue018\ue03d\ue062\ue087\ue0ac\ue0d1\ue0f6\ue11b\ue140", 54011145, "\ue60e\ue633\ue658\ue67d\ue6a2\ue6c7\ue6ec\ue711\ue736\ue75b\ue780\ue7a5\ue7ca\ue7ef\ue814\ue839", false, "\ued2c\ued51\ued76\ued9b\uedc0\uede5\uee0a\uee2f\uee54\uee79\uee9e\ueec3\ueee8\uef0d\uef32\uef57", false, "\uf44a\uf46f\uf494\uf4b9\uf4de\uf503\uf528\uf54d\uf572\uf597\uf5bc\uf5e1\uf606", false, "\ue368\ue38d\ue3b2\ue3d7\ue3fc\ue421\ue446\ue46b\ue490\ue4b5\ue4da\ue4ff", false}, {"\uf0d3\uf0f8\uf11d\uf142\uf167\uf18c\uf1b1\uf1d6\uf1fb\uf220\uf245\uf26a\uf28f\uf2b4\uf2d9", 911695130619832856L, "\uf7f1\ue016\ue03b\ue060\ue085\ue0aa\ue0cf\ue0f4\ue119\ue13e\ue163\ue188", -1320125264, "\ue70f\ue734\ue759\ue77e\ue7a3\ue7c8\ue7ed\ue812\ue837\ue85c\ue881\ue8a6", true, "\uee2d\uee52\uee77\uee9c\ueec1\ueee6\uef0b\uef30\uef55\uef7a\uef9f\uefc4\uefe9\uf00e\uf033\uf058\uf07d\uf0a2", true, "\uf54b\uf570\uf595\uf5ba\uf5df\uf604\uf629\uf64e\uf673\uf698\uf6bd\uf6e2\uf707\uf72c\uf751\uf776", true, "\ue469\ue48e\ue4b3\ue4d8\ue4fd\ue522\ue547\ue56c\ue591\ue5b6", true}, {"\uf1d4\uf1f9\uf21e\uf243\uf268\uf28d\uf2b2\uf2d7\uf2fc\uf321\uf346\uf36b\uf390\uf3b5\uf3da\uf3ff\uf424", 911695130619898393L, "\ue0f2\ue117\ue13c\ue161\ue186\ue1ab\ue1d0\ue1f5\ue21a\ue23f\ue264\ue289\ue2ae\ue2d3\ue2f8\ue31d", -1330601, "\ue810\ue835\ue85a\ue87f\ue8a4\ue8c9\ue8ee\ue913\ue938\ue95d\ue982\ue9a7\ue9cc\ue9f1\uea16\uea3b", false, "\uef2e\uef53\uef78\uef9d\uefc2\uefe7\uf00c\uf031\uf056\uf07b\uf0a0\uf0c5\uf0ea", false, "\uf64c\uf671\uf696\uf6bb\uf6e0\uf705\uf72a\uf74f\uf774\uf799\uf7be\uf7e3", false, "\ue56a\ue58f\ue5b4\ue5d9\ue5fe\ue623\ue648\ue66d\ue692", false}, {"\uf2d5\uf2fa\uf31f\uf344\uf369\uf38e\uf3b3\uf3d8\uf3fd\uf422\uf447\uf46c", 911695130619963930L, "\ue1f3\ue218\ue23d\ue262\ue287\ue2ac\ue2d1\ue2f6\ue31b\ue340\ue365\ue38a", 738445822, "\ue911\ue936\ue95b\ue980\ue9a5\ue9ca\ue9ef\uea14\uea39\uea5e\uea83\ueaa8\ueacd\ueaf2\ueb17\ueb3c\ueb61\ueb86", true, "\uf02f\uf054\uf079\uf09e\uf0c3\uf0e8\uf10d\uf132\uf157\uf17c\uf1a1\uf1c6\uf1eb\uf210\uf235\uf25a", true, "\uf74d\uf772\uf797\uf7bc\uf7e1\ue006\ue02b\ue050\ue075\ue09a", true, "\ue66b\ue690\ue6b5\ue6da\ue6ff\ue724\ue749\ue76e\ue793\ue7b8\ue7dd\ue802\ue827\ue84c", true}, {"\uf3d6\uf3fb\uf420\uf445\uf46a\uf48f\uf4b4\uf4d9\uf4fe\uf523\uf548\uf56d\uf592\uf5b7\uf5dc\uf601", 911695130620029467L, "\ue2f4\ue319\ue33e\ue363\ue388\ue3ad\ue3d2\ue3f7\ue41c\ue441\ue466\ue48b\ue4b0\ue4d5\ue4fa\ue51f", 1520107685, "\uea12\uea37\uea5c\uea81\ueaa6\ueacb\ueaf0\ueb15\ueb3a\ueb5f\ueb84\ueba9\uebce", false, "\uf130\uf155\uf17a\uf19f\uf1c4\uf1e9\uf20e\uf233\uf258\uf27d\uf2a2\uf2c7", false, "\ue04e\ue073\ue098\ue0bd\ue0e2\ue107\ue12c\ue151\ue176", false, "\ue76c\ue791\ue7b6\ue7db\ue800\ue825\ue84a\ue86f\ue894\ue8b9\ue8de", false}, {"\uf4d7\uf4fc\uf521\uf546\uf56b\uf590\uf5b5\uf5da\uf5ff\uf624\uf649\uf66e", 911695130620095004L, "\ue3f5\ue41a\ue43f\ue464\ue489\ue4ae\ue4d3\ue4f8\ue51d\ue542\ue567\ue58c\ue5b1\ue5d6\ue5fb\ue620\ue645\ue66a", -1959573940, "\ueb13\ueb38\ueb5d\ueb82\ueba7\uebcc\uebf1\uec16\uec3b\uec60\uec85\uecaa\ueccf\uecf4\ued19\ued3e", true, "\uf231\uf256\uf27b\uf2a0\uf2c5\uf2ea\uf30f\uf334\uf359\uf37e", true, "\ue14f\ue174\ue199\ue1be\ue1e3\ue208\ue22d\ue252\ue277\ue29c\ue2c1\ue2e6\ue30b\ue330", true, "\ue86d\ue892\ue8b7\ue8dc\ue901\ue926\ue94b\ue970\ue995", true}, {"\uf5d8\uf5fd\uf622\uf647\uf66c\uf691\uf6b6\uf6db\uf700\uf725\uf74a\uf76f\uf794\uf7b9\uf7de\ue003", 911695130620160541L, "\ue4f6\ue51b\ue540\ue565\ue58a\ue5af\ue5d4\ue5f9\ue61e\ue643\ue668\ue68d\ue6b2", 961191411, "\uec14\uec39\uec5e\uec83\ueca8\ueccd\uecf2\ued17\ued3c\ued61\ued86\uedab", false, "\uf332\uf357\uf37c\uf3a1\uf3c6\uf3eb\uf410\uf435\uf45a", false, "\ue250\ue275\ue29a\ue2bf\ue2e4\ue309\ue32e\ue353\ue378\ue39d\ue3c2", false, "\ue96e\ue993\ue9b8\ue9dd\uea02\uea27\uea4c\uea71", false}, {"\uf6d9\uf6fe\uf723\uf748\uf76d\uf792\uf7b7\uf7dc\ue001\ue026\ue04b\ue070\ue095\ue0ba\ue0df\ue104\ue129\ue14e", 911695130620226078L, "\ue5f7\ue61c\ue641\ue666\ue68b\ue6b0\ue6d5\ue6fa\ue71f\ue744\ue769\ue78e\ue7b3\ue7d8\ue7fd\ue822", 1742918810, "\ued15\ued3a\ued5f\ued84\ueda9\uedce\uedf3\uee18\uee3d\uee62", true, "\uf433\uf458\uf47d\uf4a2\uf4c7\uf4ec\uf511\uf536\uf55b\uf580\uf5a5\uf5ca\uf5ef\uf614", true, "\ue351\ue376\ue39b\ue3c0\ue3e5\ue40a\ue42f\ue454\ue479", true, "\uea6f\uea94\ueab9\ueade\ueb03\ueb28\ueb4d\ueb72\ueb97\uebbc\uebe1\uec06\uec2b\uec50\uec75", true}, {"\uf7da\uf7ff\ue024\ue049\ue06e\ue093\ue0b8\ue0dd\ue102\ue127\ue14c\ue171\ue196", 911695130620291615L, "\ue6f8\ue71d\ue742\ue767\ue78c\ue7b1\ue7d6\ue7fb\ue820\ue845\ue86a\ue88f", -1803883967, "\uee16\uee3b\uee60\uee85\ueeaa\ueecf\ueef4\uef19\uef3e", false, "\uf534\uf559\uf57e\uf5a3\uf5c8\uf5ed\uf612\uf637\uf65c\uf681\uf6a6", false, "\ue452\ue477\ue49c\ue4c1\ue4e6\ue50b\ue530\ue555", false, "\ueb70\ueb95\uebba\uebdf\uec04\uec29\uec4e\uec73\uec98\uecbd\uece2\ued07\ued2c\ued51\ued76\ued9b\uedc0", false}, {"\ue0db\ue100\ue125\ue14a\ue16f\ue194\ue1b9\ue1de\ue203\ue228\ue24d\ue272\ue297\ue2bc\ue2e1\ue306", 911695130620357152L, "\ue7f9\ue81e\ue843\ue868\ue88d\ue8b2\ue8d7\ue8fc\ue921\ue946", -1030610456, "\uef17\uef3c\uef61\uef86\uefab\uefd0\ueff5\uf01a\uf03f\uf064\uf089\uf0ae\uf0d3\uf0f8", true, "\uf635\uf65a\uf67f\uf6a4\uf6c9\uf6ee\uf713\uf738\uf75d", true, "\ue553\ue578\ue59d\ue5c2\ue5e7\ue60c\ue631\ue656\ue67b\ue6a0\ue6c5\ue6ea\ue70f\ue734\ue759", true, "\uec71\uec96\uecbb\uece0\ued05\ued2a\ued4f\ued74\ued99\uedbe\uede3\uee08", true}, {"\ue1dc\ue201\ue226\ue24b\ue270\ue295\ue2ba\ue2df\ue304\ue329\ue34e\ue373", 911695130620422689L, "\ue8fa\ue91f\ue944\ue969\ue98e\ue9b3\ue9d8\ue9fd\uea22", 1932163215, "\uf018\uf03d\uf062\uf087\uf0ac\uf0d1\uf0f6\uf11b\uf140\uf165\uf18a", false, "\uf736\uf75b\uf780\uf7a5\uf7ca\uf7ef\ue014\ue039", false, "\ue654\ue679\ue69e\ue6c3\ue6e8\ue70d\ue732\ue757\ue77c\ue7a1\ue7c6\ue7eb\ue810\ue835\ue85a\ue87f\ue8a4", false, "\ued72\ued97\uedbc\uede1\uee06\uee2b\uee50\uee75\uee9a\ueebf\ueee4\uef09\uef2e\uef53\uef78\uef9d", false}, {"\ue2dd\ue302\ue327\ue34c\ue371\ue396\ue3bb\ue3e0\ue405\ue42a", 911695130620488226L, "\ue9fb\uea20\uea45\uea6a\uea8f\ueab4\uead9\ueafe\ueb23\ueb48\ueb6d\ueb92\uebb7\uebdc", -1589264842, "\uf119\uf13e\uf163\uf188\uf1ad\uf1d2\uf1f7\uf21c\uf241", true, "\ue037\ue05c\ue081\ue0a6\ue0cb\ue0f0\ue115\ue13a\ue15f\ue184\ue1a9\ue1ce\ue1f3\ue218\ue23d", true, "\ue755\ue77a\ue79f\ue7c4\ue7e9\ue80e\ue833\ue858\ue87d\ue8a2\ue8c7\ue8ec", true, "\uee73\uee98\ueebd\ueee2\uef07\uef2c\uef51\uef76\uef9b\uefc0\uefe5\uf00a", true}, {"\ue3de\ue403\ue428\ue44d\ue472\ue497\ue4bc\ue4e1\ue506", 911695130620553763L, "\ueafc\ueb21\ueb46\ueb6b\ueb90\uebb5\uebda\uebff\uec24\uec49\uec6e", -270666275, "\uf21a\uf23f\uf264\uf289\uf2ae\uf2d3\uf2f8\uf31d", false, "\ue138\ue15d\ue182\ue1a7\ue1cc\ue1f1\ue216\ue23b\ue260\ue285\ue2aa\ue2cf\ue2f4\ue319\ue33e\ue363\ue388", false, "\ue856\ue87b\ue8a0\ue8c5\ue8ea\ue90f\ue934\ue959\ue97e\ue9a3\ue9c8\ue9ed\uea12\uea37\uea5c\uea81", false, "\uef74\uef99\uefbe\uefe3\uf008\uf02d\uf052\uf077\uf09c\uf0c1\uf0e6\uf10b\uf130\uf155\uf17a\uf19f", false}, {"\ue4df\ue504\ue529\ue54e\ue573\ue598\ue5bd\ue5e2\ue607\ue62c\ue651\ue676\ue69b\ue6c0", 911695130620619300L, "\uebfd\uec22\uec47\uec6c\uec91\uecb6\uecdb\ued00\ued25", 477432964, "\uf31b\uf340\uf365\uf38a\uf3af\uf3d4\uf3f9\uf41e\uf443\uf468\uf48d\uf4b2\uf4d7\uf4fc\uf521", true, "\ue239\ue25e\ue283\ue2a8\ue2cd\ue2f2\ue317\ue33c\ue361\ue386\ue3ab\ue3d0", true, "\ue957\ue97c\ue9a1\ue9c6\ue9eb\uea10\uea35\uea5a\uea7f\ueaa4\ueac9\ueaee", true, "\uf075\uf09a\uf0bf\uf0e4\uf109\uf12e\uf153\uf178\uf19d\uf1c2\uf1e7\uf20c\uf231\uf256\uf27b\uf2a0\uf2c5\uf2ea", true}, {"\ue5e0\ue605\ue62a\ue64f\ue674\ue699\ue6be\ue6e3\ue708\ue72d\ue752", 911695130620684837L, "\uecfe\ued23\ued48\ued6d\ued92\uedb7\ueddc\uee01", 1250771499, "\uf41c\uf441\uf466\uf48b\uf4b0\uf4d5\uf4fa\uf51f\uf544\uf569\uf58e\uf5b3\uf5d8\uf5fd\uf622\uf647\uf66c", false, "\ue33a\ue35f\ue384\ue3a9\ue3ce\ue3f3\ue418\ue43d\ue462\ue487\ue4ac\ue4d1\ue4f6\ue51b\ue540\ue565", false, "\uea58\uea7d\ueaa2\ueac7\ueaec\ueb11\ueb36\ueb5b\ueb80\ueba5\uebca\uebef\uec14\uec39\uec5e\uec83", false, "\uf176\uf19b\uf1c0\uf1e5\uf20a\uf22f\uf254\uf279\uf29e\uf2c3\uf2e8\uf30d\uf332", false}, {"\ue6e1\ue706\ue72b\ue750\ue775\ue79a\ue7bf\ue7e4\ue809", 911695130620750374L, "\uedff\uee24\uee49\uee6e\uee93\ueeb8\ueedd\uef02\uef27\uef4c\uef71\uef96\uefbb\uefe0\uf005", -81487406, "\uf51d\uf542\uf567\uf58c\uf5b1\uf5d6\uf5fb\uf620\uf645\uf66a\uf68f\uf6b4", true, "\ue43b\ue460\ue485\ue4aa\ue4cf\ue4f4\ue519\ue53e\ue563\ue588\ue5ad\ue5d2", true, "\ueb59\ueb7e\ueba3\uebc8\uebed\uec12\uec37\uec5c\uec81\ueca6\ueccb\uecf0\ued15\ued3a\ued5f\ued84\ueda9\uedce", true, "\uf277\uf29c\uf2c1\uf2e6\uf30b\uf330\uf355\uf37a\uf39f\uf3c4\uf3e9\uf40e\uf433\uf458\uf47d\uf4a2", true}, {"\ue7e2\ue807\ue82c\ue851\ue876\ue89b\ue8c0\ue8e5", 911695130620815911L, "\uef00\uef25\uef4a\uef6f\uef94\uefb9\uefde\uf003\uf028\uf04d\uf072\uf097\uf0bc\uf0e1\uf106\uf12b\uf150", 700243833, "\uf61e\uf643\uf668\uf68d\uf6b2\uf6d7\uf6fc\uf721\uf746\uf76b\uf790\uf7b5\uf7da\uf7ff\ue024\ue049", false, "\ue53c\ue561\ue586\ue5ab\ue5d0\ue5f5\ue61a\ue63f\ue664\ue689\ue6ae\ue6d3\ue6f8\ue71d\ue742\ue767", false, "\uec5a\uec7f\ueca4\uecc9\uecee\ued13\ued38\ued5d\ued82\ueda7\uedcc\uedf1\uee16", false, "\uf378\uf39d\uf3c2\uf3e7\uf40c\uf431\uf456\uf47b\uf4a0\uf4c5\uf4ea\uf50f", false}};
        byte[] v0 = "\u00afsz\u00bd\u0084<\u00aa \u00d8wV\u001d\"\u00dd\u00d5\u001f\u00c1D\u008d\u00f9\u0096\u00a3%n\u0011z\u0082\u00b8\u0097\u00f9>\u00e6\u00d8;\u0090\u00f4|\u00ea\u00fdGd\u0095\u00d49\u00e7\u00cfm*\u0081Ad\u0091{\u0011\u00fb\u008bv\u0019\u00fe\\\u0084T\u0096\u00cc\r\u0081\u008e^\u00ba\u00a3\u00ddx\u0004,{\u00a1w\u00d9{\r'\u00f5\u00e6Z5@\u00ef\u0085|%\u0091b\u00b4\u00f3O\u00e6\u000fC\u00d4I\u00eeN\u00b61\u00fe\u00adl{\u00f8-\u00b5\u0089Z\u00d3r\u00ea[\u00de\u00a9\u00fd\u0012\u00cf\u000b\u00b9\u0017\u00b3\u0083\u00b4\u0016\u0084H\u0091pQ]\u00f8*\u00be\u00a8\u0013\u00fe\u00a9\u009fq\u00aai[\u00ad:\u001aFt".getBytes("ISO_8859_1");
        Object[] v1 = "g\u00a1\u00ed\u008e\u0085%\u00e0\u00da".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 1496627723;
                case 1 -> 1639784839;
                case 2 -> 203051491;
                case 3 -> -1577565609;
                case 4 -> 1013954548;
                case 5 -> 50735108;
                case 6 -> 1706120021;
                case 7 -> 2120351372;
                case 8 -> -432840886;
                case 9 -> -1115409826;
                case 10 -> -1921609405;
                case 11 -> -679595987;
                case 12 -> 835213376;
                case 13 -> -1247098790;
                case 14 -> -1302409882;
                case 15 -> 704314096;
                case 16 -> 1045448962;
                case 17 -> -2313670;
                case 18 -> 784197017;
                case 19 -> 42300034;
                case 20 -> -450845584;
                case 21 -> 348572831;
                case 22 -> 485723743;
                case 23 -> -1293234521;
                case 24 -> -312704945;
                case 25 -> 593587843;
                case 26 -> 1501782779;
                case 27 -> -365449603;
                case 28 -> 1778918842;
                case 29 -> -1578617054;
                case 30 -> -1978821126;
                case 31 -> -1210358768;
                case 32 -> 1985424906;
                case 33 -> -1547610646;
                case 34 -> 1814937003;
                case 35 -> 666925953;
                case 36 -> -2069863008;
                case 37 -> -1203070835;
                case 38 -> -1684436866;
                case 39 -> -156570680;
                case 40 -> -1385120581;
                case 41 -> 789832969;
                case 42 -> -198092687;
                case 43 -> -1639992584;
                case 44 -> 2145979483;
                case 45 -> 645128471;
                case 46 -> -1085208984;
                case 47 -> -568277071;
                case 48 -> 1227388462;
                case 49 -> 1792861878;
                case 50 -> -1949343784;
                case 51 -> -557608676;
                case 52 -> 1212125579;
                case 53 -> -450523361;
                case 54 -> 973015935;
                case 55 -> 1918330004;
                case 56 -> -582564143;
                case 57 -> -1252425741;
                case 58 -> -1058278353;
                case 59 -> -478892351;
                case 60 -> 653556833;
                case 61 -> -2082725619;
                case 62 -> 473720551;
                case 63 -> 933547050;
                case 64 -> 1219886395;
                case 65 -> -2064609499;
                case 66 -> -892507048;
                case 67 -> 140360213;
                case 68 -> 1981297781;
                case 69 -> -262743153;
                case 70 -> 831929312;
                case 71 -> -955510290;
                case 72 -> -42227248;
                case 73 -> -1461690612;
                case 74 -> -53044764;
                case 75 -> -881258342;
                case 76 -> -1511956225;
                case 77 -> -1277042625;
                case 78 -> 1733335869;
                case 79 -> 1182895081;
                case 80 -> 1884585698;
                case 81 -> 931372741;
                case 82 -> -728880216;
                case 83 -> -1460790236;
                case 84 -> -145827395;
                case 85 -> -1638098824;
                case 86 -> -600365189;
                case 87 -> 1049354291;
                case 88 -> 1807012530;
                case 89 -> 1741140040;
                case 90 -> 965024008;
                case 91 -> 1537773275;
                case 92 -> 1642539312;
                case 93 -> 473327090;
                case 94 -> -953301806;
                case 95 -> 772529621;
                case 96 -> -131096279;
                case 97 -> -324120322;
                case 98 -> 99491072;
                case 99 -> -441231783;
                case 100 -> 884448970;
                case 101 -> 568044100;
                case 102 -> -1502388519;
                case 103 -> -868932494;
                case 104 -> 176564436;
                case 105 -> -1426819302;
                case 106 -> 922240354;
                case 107 -> 117538101;
                case 108 -> 620029619;
                case 109 -> -1404230748;
                case 110 -> -1245134370;
                case 111 -> 536979346;
                case 112 -> 769788953;
                case 113 -> -902257258;
                case 114 -> 876514144;
                case 115 -> 881771956;
                case 116 -> -1495317228;
                case 117 -> 1406896390;
                case 118 -> 2112714817;
                case 119 -> 1940515879;
                case 120 -> -285469104;
                case 121 -> 876241740;
                case 122 -> 1977516622;
                case 123 -> -1258152838;
                case 124 -> -1614000218;
                case 125 -> 1396804158;
                case 126 -> 1814349676;
                case 127 -> -1309921461;
                case 128 -> -483298018;
                case 129 -> -1911739021;
                case 130 -> 1896355224;
                case 131 -> 1127996855;
                case 132 -> -1166524383;
                case 133 -> -1298787719;
                case 134 -> -994792568;
                case 135 -> -366196018;
                case 136 -> -993419613;
                case 137 -> -1739023818;
                case 138 -> 454578626;
                case 139 -> 2054808709;
                case 140 -> -385821127;
                case 141 -> -86975780;
                case 142 -> -275713691;
                case 143 -> -1883870101;
                case 144 -> 1139716043;
                case 145 -> -1392518262;
                case 146 -> -2087631869;
                case 147 -> 1526428253;
                case 148 -> -366230144;
                case 149 -> -203729081;
                case 150 -> 312760471;
                case 151 -> -2018596269;
                case 152 -> -635803354;
                case 153 -> -1043690291;
                case 154 -> -41884136;
                case 155 -> 1766775789;
                case 156 -> -103106724;
                case 157 -> 1952968106;
                case 158 -> 694799109;
                case 159 -> 1081561635;
                case 160 -> 603569135;
                case 161 -> -253177481;
                case 162 -> 287906438;
                case 163 -> 1169362617;
                case 164 -> 785308433;
                case 165 -> 940143296;
                case 166 -> 1304927889;
                case 167 -> -594010682;
                case 168 -> 67688018;
                case 169 -> 158123229;
                case 170 -> -151341667;
                case 171 -> 473358619;
                case 172 -> 1780353273;
                case 173 -> 88411053;
                case 174 -> -1302403040;
                case 175 -> -227531762;
                case 176 -> 376035636;
                case 177 -> 320025762;
                case 178 -> -1388994254;
                case 179 -> -109036441;
                case 180 -> 654011452;
                case 181 -> 714624912;
                case 182 -> -490674692;
                case 183 -> -2126729628;
                case 184 -> -860354474;
                case 185 -> 32880113;
                case 186 -> -775945622;
                case 187 -> -479919316;
                case 188 -> -340407362;
                case 189 -> 2125314893;
                case 190 -> 977038917;
                case 191 -> -2093037931;
                case 192 -> -556165617;
                case 193 -> 268433949;
                case 194 -> 1241938242;
                case 195 -> -1883251455;
                case 196 -> -1760734039;
                case 197 -> -1657175839;
                case 198 -> 641038071;
                case 199 -> -200692561;
                case 200 -> -1676542815;
                case 201 -> 1396869868;
                case 202 -> 1794600814;
                case 203 -> -1221933421;
                case 204 -> 1195572198;
                case 205 -> 255365231;
                case 206 -> -1254578274;
                case 207 -> 960760457;
                case 208 -> 232186037;
                case 209 -> 830257661;
                case 210 -> -1016369559;
                case 211 -> 1284076430;
                case 212 -> 579039620;
                case 213 -> 1787563271;
                case 214 -> 675086870;
                case 215 -> -1687813684;
                case 216 -> -869690673;
                case 217 -> 1115159007;
                case 218 -> -477326664;
                case 219 -> 1435336368;
                case 220 -> -628122250;
                case 221 -> 975894999;
                case 222 -> -1211788053;
                case 223 -> -482475274;
                case 224 -> -646508349;
                case 225 -> 202275271;
                case 226 -> 2081358492;
                case 227 -> -1147243721;
                case 228 -> 1606726572;
                case 229 -> -1385937944;
                case 230 -> -2099955255;
                case 231 -> 1078360913;
                case 232 -> -633298323;
                case 233 -> -1007217985;
                case 234 -> -129204410;
                case 235 -> 802134190;
                case 236 -> -639250052;
                case 237 -> -1578428714;
                case 238 -> -1444514444;
                case 239 -> 1393970706;
                case 240 -> -2096169132;
                case 241 -> -323975996;
                case 242 -> 1184169973;
                case 243 -> 667785059;
                case 244 -> -1488376247;
                case 245 -> -1717074895;
                case 246 -> -329689638;
                case 247 -> -1770643245;
                case 248 -> 628230675;
                case 249 -> 874908604;
                case 250 -> -632923592;
                case 251 -> 216919339;
                case 252 -> -716513115;
                case 253 -> -1836744731;
                case 254 -> -1157012325;
                case 255 -> 1759800872;
                default -> -619768600;
            });
        } while (v2 != 152);
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
            Object[] objectArray = new Object[7];
            v1 = objectArray;
            OOIo = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        iiI = 10;
        iio = 200;
        EnumType_ii0_2 = 128;
    }

    private void OooI() {
        this.OOOo = null;
        this.PostProcessingModule = null;
        this.DataRecord_OO0O = 0;
        this.NetworkSupport_OO00 = 0;
    }

    private Vec3d EnumType_O0II(BlockPos param1) {
        double v2 = MathHelper.clamp((double)AutoMlgModule.ConfigSupport_OI0.player.method_23317(), (double)((double)param1.method_10263() + 0.2), (double)((double)param1.method_10263() + 0.8));
        double v4 = MathHelper.clamp((double)AutoMlgModule.ConfigSupport_OI0.player.method_23321(), (double)((double)param1.method_10260() + 0.2), (double)((double)param1.method_10260() + 0.8));
        return new Vec3d(v2, (double)param1.method_10264() + 0.5, v4);
    }

    private void ConfigSupport_oooi_3(Vec3d param1, float param2) {
        float[] v3 = this.ScaledDrawContext(param1);
        this.Manager = v3[0];
        this.DataRecord_OOI0 = v3[1];
        0ooo.ConfigSupport_00o_0().HelpCommand(this, this.Manager, this.DataRecord_OOI0, param2);
    }

    private void GuiSupport_O000() {
        ++this.OO0o;
        if (!this.O0oo()) {
            if (this.OO0o > 40) {
                this.Oooi();
            }
            return;
        }
        if (!this.O00o() && this.OO0o > 60) {
            this.Oooi();
        }
    }

    private boolean OoOi() {
        return Math.abs(MathHelper.wrapDegrees((float)(this.Manager - 0ooo.DataRecord_00I().ConfigSupport_OI0()))) <= 8.0f && Math.abs(this.DataRecord_OOI0 - 0ooo.00i().OIo()) <= 8.0f;
    }

    private Vec3d CriticalsModule(BlockPos param1) {
        Vec3d v2 = AutoMlgModule.ConfigSupport_OI0.player.method_18798();
        Vec3d v3 = new Vec3d(v2.x, 0.0, v2.z);
        double v4 = v3.length();
        double v6 = (double)param1.method_10264() + 1.0;
        double v8 = Math.max(0.0, AutoMlgModule.ConfigSupport_OI0.player.method_23318() - v6);
        double v10 = Math.max(0.08, -v2.y);
        double v12 = MathHelper.clamp((double)(v8 / v10 + 0.75), (double)1.0, (double)20.0);
        Vec3d v14 = new Vec3d(AutoMlgModule.ConfigSupport_OI0.player.method_23317(), v6, AutoMlgModule.ConfigSupport_OI0.player.method_23321());
        if (v4 < 0.03) {
            return v14.add(v2.x * v12, 0.0, v2.z * v12);
        }
        double v15 = MathHelper.clamp((double)(v4 * v12), (double)0.35, (double)6.0);
        return v14.add(v3.normalize().multiply(v15));
    }

    private BlockHitResult PacketSendEvent(float param1, float param2, double param3, RaycastContext.FluidHandling param5) {
        Vec3d v6 = AutoMlgModule.ConfigSupport_OI0.player.method_33571();
        Vec3d v7 = Vec3d.fromPolar((float)param2, (float)param1);
        return AutoMlgModule.ConfigSupport_OI0.world.method_17742(new RaycastContext(v6, v6.add(v7.multiply(param3)), RaycastContext.ShapeType.OUTLINE, param5, (Entity)AutoMlgModule.ConfigSupport_OI0.player));
    }

    private boolean EnumType_o0o0_0() {
        if (this.OOOo == null || this.PostProcessingModule == null) {
            return false;
        }
        if (this.EnumType_OOO0 != EnumType_oo0i_0.0Io && this.EnumType_OOO0 != EnumType_oo0i_0.ConfigSupport_0II) {
            return false;
        }
        double v1 = (double)this.OOOo.getBlockPos().method_10264() + 1.0;
        double v3 = AutoMlgModule.ConfigSupport_OI0.player.method_23318() - v1;
        return v3 <= 8.0 || this.IrcManager(this.PostProcessingModule);
    }

    private void DataRecord_I0O() {
        if (((Boolean)this.KeepSprintModule.HelpCommand()).booleanValue() && this.NetworkSupport_o0o_0 >= 0 && this.NetworkSupport_o0o_0 < 9) {
            AutoMlgModule.ConfigSupport_OI0.player.method_31548().setSelectedSlot(this.NetworkSupport_o0o_0);
            AutoMlgModule.ConfigSupport_OI0.interactionManager.syncSelectedSlot();
        }
        this.NetworkSupport_o0o_0 = -1;
    }

    private void O0Oi() {
        int v1;
        if (this.PostProcessingModule == null) {
            this.Oooi();
            return;
        }
        if (this.EnumType_OOO0 == EnumType_oo0i_0.0Io && !this.IrcManager(this.PostProcessingModule)) {
            this.OoOo();
        } else {
            this.OoO0(this.PostProcessingModule);
        }
        this.NetworkSupport_OO00 = this.OoOi() ? this.NetworkSupport_OO00 + 1 : 0;
        ++this.DataRecord_OO0O;
        int n = v1 = this.EnumType_OOO0 == EnumType_oo0i_0.0Io ? 200 : 10;
        if (this.DataRecord_OO0O > v1) {
            this.Oooi();
        }
    }

    private void Oooi() {
        this.OoIO();
        this.FontRenderer = false;
        this.OO0i = false;
        this.OOoO = false;
        this.OooI();
        this.OOOi = null;
        this.OO0o = 0;
        this.EnumType_OOO0 = EnumType_oo0i_0.RenderSupport_0I0;
        this.DataRecord_I0O();
        0ooo.0oO().0Oo(this);
    }

    private void O0Oo() {
        if (!this.O00i()) {
            return;
        }
        int v1 = this.Ooo0(Items.WATER_BUCKET);
        if (v1 == -1) {
            return;
        }
        DataRecord_00i_0 v2 = this.NetworkSupport_o0oi_2(false);
        if (v2 == null) {
            return;
        }
        this.Oooo(v1);
        this.RenderSupport_oooo_2(v2.RenderSupport_0I0(), v2.0Io(), EnumType_oo0i_0.0Io);
    }

    private float[] ScaledDrawContext(Vec3d param1) {
        Vec3d v2 = param1.subtract(AutoMlgModule.ConfigSupport_OI0.player.method_33571());
        double v3 = Math.sqrt(v2.x * v2.x + v2.z * v2.z);
        float v5 = v3 <= 0.35 ? (0ooo.0o0() != null ? 0ooo.SpawnerFinderModule().OiO(AutoMlgModule.ConfigSupport_OI0.player.method_36454()) : AutoMlgModule.ConfigSupport_OI0.player.method_36454()) : (float)MathHelper.wrapDegrees((double)(Math.toDegrees(Math.atan2(v2.z, v2.x)) - 90.0));
        float v6 = (float)MathHelper.clamp((double)(-Math.toDegrees(Math.atan2(v2.y, v3))), (double)-90.0, (double)90.0);
        return new float[]{v5, v6};
    }

    private void Oooo(int param1) {
        if (param1 < 0 || param1 > 8) {
            return;
        }
        if (this.NetworkSupport_o0o_0 == -1) {
            this.NetworkSupport_o0o_0 = AutoMlgModule.ConfigSupport_OI0.player.method_31548().getSelectedSlot();
        }
        if (AutoMlgModule.ConfigSupport_OI0.player.method_31548().getSelectedSlot() != param1) {
            AutoMlgModule.ConfigSupport_OI0.player.method_31548().setSelectedSlot(param1);
            AutoMlgModule.ConfigSupport_OI0.interactionManager.syncSelectedSlot();
        }
    }

    private boolean O0i0(BlockPos param1) {
        return AutoMlgModule.ConfigSupport_OI0.world.method_8316(param1).isEmpty() && (AutoMlgModule.ConfigSupport_OI0.world.method_8320(param1).method_26215() || AutoMlgModule.ConfigSupport_OI0.world.method_8320(param1).method_45474());
    }

    private BlockHitResult Oo0O(Vec3d param1, RaycastContext.FluidHandling param2) {
        float[] v3 = this.ScaledDrawContext(param1);
        return this.PacketSendEvent(v3[0], v3[1], Math.min((Double)this.ioO.HelpCommand(), AutoMlgModule.ConfigSupport_OI0.player.method_55754()), param2);
    }

    private void OoOo() {
        this.Manager = 0ooo.0oI() != null ? 0ooo.0oi().OiO(AutoMlgModule.ConfigSupport_OI0.player.method_36454()) : AutoMlgModule.ConfigSupport_OI0.player.method_36454();
        this.DataRecord_OOI0 = 90.0f;
        0ooo.AutoMlgModule().HelpCommand(this, this.Manager, this.DataRecord_OOI0, ((Integer)this.iii.HelpCommand()).intValue());
    }

    @EventHandler
    public void EnumType_O0OO(ConfigSupport_oooo_3 param1) {
        if (this.OO0i) {
            this.OO0i = false;
            return;
        }
        if (this.RenderSupport_o0oo_1()) {
            param1.DataRecord_0O0();
        }
    }

    private boolean O00i() {
        return !AutoMlgModule.ConfigSupport_OI0.player.method_5799() && AutoMlgModule.ConfigSupport_OI0.player.method_18798().y < -0.2 && AutoMlgModule.ConfigSupport_OI0.player.field_6017 >= (Double)this.DataRecord_0io_2.HelpCommand() && this.Ooo0(Items.WATER_BUCKET) != -1 && this.NetworkSupport_o0oi_2(false) != null;
    }

    private List RenderSupport_O0I0(BlockPos param1) {
        double v2 = (double)param1.method_10264() + 1.0;
        double v4 = MathHelper.clamp((double)AutoMlgModule.ConfigSupport_OI0.player.method_23317(), (double)((double)param1.method_10263() + 0.25), (double)((double)param1.method_10263() + 0.75));
        double v6 = MathHelper.clamp((double)AutoMlgModule.ConfigSupport_OI0.player.method_23321(), (double)((double)param1.method_10260() + 0.25), (double)((double)param1.method_10260() + 0.75));
        return List.of(new Vec3d(v4, v2, v6), new Vec3d((double)param1.method_10263() + 0.5, v2, (double)param1.method_10260() + 0.5), new Vec3d(v4, v2, (double)param1.method_10260() + 0.5), new Vec3d((double)param1.method_10263() + 0.5, v2, v6), new Vec3d((double)param1.method_10263() + 0.3, v2, (double)param1.method_10260() + 0.3), new Vec3d((double)param1.method_10263() + 0.7, v2, (double)param1.method_10260() + 0.3), new Vec3d((double)param1.method_10263() + 0.3, v2, (double)param1.method_10260() + 0.7), new Vec3d((double)param1.method_10263() + 0.7, v2, (double)param1.method_10260() + 0.7));
    }

    private double O0Io(Vec3d param1) {
        float[] v2 = this.ScaledDrawContext(param1);
        float v3 = 0ooo.RenderSupport_0I0() != null ? 0ooo.0Io().OiO(AutoMlgModule.ConfigSupport_OI0.player.method_36454()) : AutoMlgModule.ConfigSupport_OI0.player.method_36454();
        float v4 = 0ooo.ConfigSupport_0II() != null ? 0ooo.ChestStealerModule().Oi0(AutoMlgModule.ConfigSupport_OI0.player.method_36455()) : AutoMlgModule.ConfigSupport_OI0.player.method_36455();
        double v5 = Math.abs(MathHelper.wrapDegrees((float)(v2[0] - v3)));
        double v7 = Math.abs(v2[1] - v4);
        return v5 * 0.25 + v7 + AutoMlgModule.ConfigSupport_OI0.player.method_33571().distanceTo(param1) * 0.05;
    }

    @Override
    public void ConfigSupport_oi0_2() {
        this.SettingContainer();
    }

    private BlockPos ConfigSupport_O0IO() {
        if (this.OOOi != null && this.O0Ii(this.OOOi) && this.IrcManager(this.EnumType_O0II(this.OOOi))) {
            return this.OOOi;
        }
        int v1 = (int)Math.ceil((Double)this.ioO.HelpCommand());
        BlockPos v2 = this.OOOi != null ? this.OOOi : AutoMlgModule.ConfigSupport_OI0.player.method_24515();
        return BlockPos.stream((BlockPos)v2.add(-v1, -v1, -v1), (BlockPos)v2.add(v1, v1, v1)).map(BlockPos::toImmutable).filter(this::O0Ii).filter(param1 -> AutoMlgModule.ConfigSupport_OI0.player.method_33571().distanceTo(this.EnumType_O0II((BlockPos)param1)) <= (Double)this.ioO.HelpCommand()).filter(param1 -> {
            BlockHitResult v2 = this.Oo0O(this.EnumType_O0II((BlockPos)param1), RaycastContext.FluidHandling.SOURCE_ONLY);
            return v2.method_17783() == HitResult.Type.BLOCK && v2.getBlockPos().equals(param1);
        }).min(Comparator.comparingDouble(param1 -> AutoMlgModule.ConfigSupport_OI0.player.method_33571().squaredDistanceTo(this.EnumType_O0II((BlockPos)param1)))).orElse(null);
    }

    private void SettingContainer() {
        this.OoIO();
        this.EnumType_OOO0 = EnumType_oo0i_0.RenderSupport_0I0;
        this.OOOo = null;
        this.PostProcessingModule = null;
        this.OOOi = null;
        this.NetworkSupport_o0o_0 = -1;
        this.DataRecord_OO0O = 0;
        this.NetworkSupport_OO00 = 0;
        this.OO0o = 0;
        this.FontRenderer = false;
        this.OO0i = false;
        this.OOoO = false;
        this.OOoI = 0.0f;
        this.OOoi = 0.0f;
        this.Manager = 0.0f;
        this.DataRecord_OOI0 = 0.0f;
    }

    private void AntiBotModule() {
        BlockPos v1;
        ++this.OO0o;
        BlockPos blockPos = v1 = this.OOOo != null ? this.OOOo.getBlockPos().offset(this.OOOo.getSide()) : null;
        if (AutoMlgModule.ConfigSupport_OI0.player.method_6047().isOf(Items.BUCKET) || v1 != null && AutoMlgModule.ConfigSupport_OI0.world.method_8316(v1).isIn(FluidTags.WATER)) {
            this.OOOi = v1;
            this.OooI();
            this.OO0o = 0;
            if (!((Boolean)this.Module.HelpCommand()).booleanValue()) {
                this.EnumType_OOO0 = EnumType_oo0i_0.RenderSupport_0I0;
                this.DataRecord_I0O();
                return;
            }
            if (this.O0oo() && this.O00o()) {
                return;
            }
            this.EnumType_OOO0 = EnumType_oo0i_0.ChestStealerModule;
            return;
        }
        if (this.OO0o > 4) {
            this.Oooi();
        }
    }

    public void MoveFixModule() {
        if (this.EnumType_OOO0 != EnumType_oo0i_0.0Io && this.EnumType_OOO0 != EnumType_oo0i_0.DataRecord_0io_2) {
            return;
        }
        if (AutoMlgModule.iooI() || AutoMlgModule.ConfigSupport_OI0.interactionManager == null || AutoMlgModule.ConfigSupport_OI0.currentScreen != null || AutoMlgModule.ConfigSupport_OI0.player.method_68878()) {
            this.Oooi();
            return;
        }
        if (!this.GuiComponent()) {
            return;
        }
        this.ConfigSupport_oooi_3(this.PostProcessingModule, 180.0f);
        if (!this.OoOi()) {
            return;
        }
        if (this.EnumType_OOO0 == EnumType_oo0i_0.0Io && !AutoMlgModule.ConfigSupport_OI0.player.method_6047().isOf(Items.WATER_BUCKET)) {
            this.Oooi();
            return;
        }
        if (this.EnumType_OOO0 == EnumType_oo0i_0.DataRecord_0io_2 && !AutoMlgModule.ConfigSupport_OI0.player.method_6047().isOf(Items.BUCKET)) {
            this.Oooi();
            return;
        }
        this.Oo0i();
        this.OooO();
        AutoMlgModule.ConfigSupport_OI0.gameRenderer.updateCrosshairTarget(ConfigSupport_OI0.getRenderTickCounter().getTickProgress(false));
        KeyBindingAccessor v1 = (KeyBindingAccessor)AutoMlgModule.ConfigSupport_OI0.options.useKey;
        this.OO0i = true;
        v1.clap$setClickCount(v1.clap$getClickCount() + 1);
        this.FontRenderer = true;
        this.OO0o = 0;
        this.DataRecord_OO0O = 0;
        this.NetworkSupport_OO00 = 0;
        this.EnumType_OOO0 = this.EnumType_OOO0 == EnumType_oo0i_0.0Io ? EnumType_oo0i_0.ConfigSupport_0II : EnumType_oo0i_0.KeepSprintModule;
    }

    private boolean O00o() {
        int v1 = this.Ooo0(Items.BUCKET);
        if (v1 == -1) {
            return false;
        }
        BlockPos v2 = this.ConfigSupport_O0IO();
        if (v2 == null) {
            return false;
        }
        Vec3d v3 = this.EnumType_O0II(v2);
        this.Oooo(v1);
        this.RenderSupport_oooo_2(new BlockHitResult(v3, Direction.UP, v2, false), v3, EnumType_oo0i_0.DataRecord_0io_2);
        return true;
    }

    private void EnumType_O00I() {
        ++this.OO0o;
        if (AutoMlgModule.ConfigSupport_OI0.player.method_6047().isOf(Items.WATER_BUCKET)) {
            this.OOOi = null;
            this.OooI();
            this.DataRecord_I0O();
            this.EnumType_OOO0 = EnumType_oo0i_0.RenderSupport_0I0;
            this.OO0o = 0;
            return;
        }
        if (this.OO0o > 8) {
            this.Oooi();
        }
    }

    @EventHandler
    public void SprintResetModule(ConfigSupport_oiio_2 param1) {
        if (AutoMlgModule.iooI()) {
            return;
        }
        if (this.FontRenderer && 0ooo.DataRecord_0io_2() != null && 0ooo.KeepSprintModule().ConfigSupport_0OO(this)) {
            param1.RenderSupport_0I0(this.OOoI);
            param1.ConfigSupport_0II(this.OOoi);
            this.FontRenderer = false;
            0ooo.0io().0Oo(this);
            return;
        }
        if (this.PostProcessingModule == null || 0ooo.0iI() == null || !0ooo.0ii().ConfigSupport_0OO(this)) {
            return;
        }
        param1.RenderSupport_0I0(0ooo.oOO().ConfigSupport_OI0());
        param1.ConfigSupport_0II(0ooo.FastWebModule().OIo());
    }
}

