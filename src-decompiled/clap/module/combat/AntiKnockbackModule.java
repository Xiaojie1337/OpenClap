/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  net.minecraft.client.gui.screen.ingame.InventoryScreen
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.client.util.InputUtil
 *  net.minecraft.client.util.InputUtil$Key
 *  net.minecraft.client.util.InputUtil$Type
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.decoration.ArmorStandEntity
 *  net.minecraft.entity.effect.StatusEffects
 *  net.minecraft.entity.mob.MobEntity
 *  net.minecraft.entity.passive.AnimalEntity
 *  net.minecraft.entity.passive.VillagerEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.network.listener.ClientPlayPacketListener
 *  net.minecraft.network.listener.PacketListener
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.s2c.play.CloseScreenS2CPacket
 *  net.minecraft.network.packet.s2c.play.DeathMessageS2CPacket
 *  net.minecraft.network.packet.s2c.play.EntityAnimationS2CPacket
 *  net.minecraft.network.packet.s2c.play.EntityDamageS2CPacket
 *  net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket
 *  net.minecraft.network.packet.s2c.play.GameMessageS2CPacket
 *  net.minecraft.network.packet.s2c.play.HealthUpdateS2CPacket
 *  net.minecraft.network.packet.s2c.play.PlaySoundFromEntityS2CPacket
 *  net.minecraft.network.packet.s2c.play.PlaySoundS2CPacket
 *  net.minecraft.network.packet.s2c.play.PlayerPositionLookS2CPacket
 *  net.minecraft.network.packet.s2c.play.SubtitleS2CPacket
 *  net.minecraft.network.packet.s2c.play.TeamS2CPacket
 *  net.minecraft.network.packet.s2c.play.TitleFadeS2CPacket
 *  net.minecraft.network.packet.s2c.play.TitleS2CPacket
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  org.lwjgl.glfw.GLFW
 */
package clap.module.combat;

import java.security.Key;
import java.security.MessageDigest;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.listener.PacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.CloseScreenS2CPacket;
import net.minecraft.network.packet.s2c.play.DeathMessageS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityAnimationS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityDamageS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import net.minecraft.network.packet.s2c.play.HealthUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.PlaySoundFromEntityS2CPacket;
import net.minecraft.network.packet.s2c.play.PlaySoundS2CPacket;
import net.minecraft.network.packet.s2c.play.PlayerPositionLookS2CPacket;
import net.minecraft.network.packet.s2c.play.SubtitleS2CPacket;
import net.minecraft.network.packet.s2c.play.TeamS2CPacket;
import net.minecraft.network.packet.s2c.play.TitleFadeS2CPacket;
import net.minecraft.network.packet.s2c.play.TitleS2CPacket;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;
import clap.config.ConfigSupport_O0IO;
import clap.core.module.Module;
import clap.model.EnumType_iii_0;
import clap.setting.Setting;
import clap.config.ConfigSupport_oio_5;
import clap.core.module.ModuleCategory;
import clap.event.network.PacketSendEvent;
import clap.event.EventHandler;
import skidonion.loader.0ooo;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from psx.Hyk.OoO
 */
public class AntiKnockbackModule
extends Module {
    private final Setting OiO = this.OOi00("BufferCorrect", true);
    private boolean DataRecord_0O0;
    private float ConfigSupport_00o_0;
    private boolean Oii;
    private static final double RenderSupport_oii_4;
    private final Queue OiI;
    private boolean ConfigSupport_0OO;
    private boolean EnumType_0OI;
    private final Setting Oi0 = this.OOi0o("BufferTick", 4, 0, 10);
    private float DataRecord_00I;
    private final Setting Oio = this.OOi00("JumpReset", true);
    private int StorageEspModule = -1;
    private boolean 0Oo;
    private static final double ConfigSupport_OII;
    private int Kernel32SnapshotApi = -1;
    private int 0Oi;
    static Object 00i;
    private static volatile /* synthetic */ long __k__gH4it;
    private static /* synthetic */ String[] __p__gH4it;
    private static /* synthetic */ Object[][] __c__J7Um6;

    private void o0I() {
        if (AntiKnockbackModule.ConfigSupport_OI0.options == null) {
            return;
        }
        if (this.0Oo || this.Oii) {
            AntiKnockbackModule.ConfigSupport_OI0.options.jumpKey.setPressed(this.NetworkSupport_o0o_0(AntiKnockbackModule.ConfigSupport_OI0.options.jumpKey));
            AntiKnockbackModule.ConfigSupport_OI0.options.forwardKey.setPressed(this.NetworkSupport_o0o_0(AntiKnockbackModule.ConfigSupport_OI0.options.forwardKey));
        }
    }

    private int RenderSupport_ooi_1(double param1, double param3) {
        double v5 = Math.hypot(param1 * 8000.0, param3 * 8000.0);
        int v7 = (int)Math.round(6.43153527E-4 * v5 + 2.9419087136);
        return MathHelper.clamp((int)v7, (int)1, (int)10);
    }

    private Vec3d 0ii(LivingEntity param1) {
        return this.oOO(AntiKnockbackModule.ConfigSupport_OI0.player.method_33571(), param1.method_5829().expand((double)param1.method_5871()));
    }

    @Override
    public void 0oI() {
        this.o0O();
        this.o0I();
        this.SettingContainer();
        0ooo.OOo().0Oo(this);
    }

    private boolean NetworkSupport_o0o_0(KeyBinding param1) {
        if (param1 == null || param1.isUnbound() || ConfigSupport_OI0.getWindow() == null) {
            return false;
        }
        InputUtil.Key v2 = InputUtil.fromTranslationKey((String)param1.getBoundKeyTranslationKey());
        long v3 = ConfigSupport_OI0.getWindow().getHandle();
        if (v2.getCategory() == InputUtil.Type.MOUSE) {
            return GLFW.glfwGetMouseButton((long)v3, (int)v2.getCode()) == 1;
        }
        return GLFW.glfwGetKey((long)v3, (int)v2.getCode()) == 1;
    }

    private float oOo(Vec3d param1) {
        Vec3d v2 = AntiKnockbackModule.ConfigSupport_OI0.player.method_33571();
        double v3 = param1.x - v2.x;
        double v5 = param1.y - v2.y;
        double v7 = param1.z - v2.z;
        double v9 = Math.sqrt(v3 * v3 + v7 * v7);
        return MathHelper.clamp((float)((float)(-(MathHelper.atan2((double)v5, (double)v9) * 57.2957763671875))), (float)-90.0f, (float)90.0f);
    }

    @Override
    public void SpawnerFinderModule() {
        if (AntiKnockbackModule.iooI()) {
            this.SettingContainer();
            return;
        }
        if (this.Kernel32SnapshotApi >= 0) {
            ++this.Kernel32SnapshotApi;
        }
        if (this.StorageEspModule >= 0) {
            ++this.StorageEspModule;
        }
        if (this.Kernel32SnapshotApi >= 10) {
            this.EnumType_0OI = false;
            this.DataRecord_0O0 = false;
            this.Kernel32SnapshotApi = -1;
        }
        if (this.Kernel32SnapshotApi >= this.0Oi) {
            this.EnumType_0OI = false;
            this.DataRecord_0O0 = false;
        }
        if (((Boolean)this.Oio.HelpCommand()).booleanValue()) {
            this.ChestStealerModule();
        }
        if (this.ConfigSupport_0OO || this.0Oo) {
            this.DataRecord_0O0 = true;
        }
        if (this.EnumType_0OI && this.DataRecord_0io_2()) {
            this.DataRecord_0O0 = true;
        }
    }

    private LivingEntity KeepSprintModule(double param1) {
        if (AntiKnockbackModule.ConfigSupport_OI0.world == null || AntiKnockbackModule.ConfigSupport_OI0.player == null) {
            return null;
        }
        LivingEntity v3 = null;
        double v4 = param1;
        Box v6 = AntiKnockbackModule.ConfigSupport_OI0.player.method_5829().expand(param1 + 1.0);
        for (Entity v8 : AntiKnockbackModule.ConfigSupport_OI0.world.method_8335((Entity)AntiKnockbackModule.ConfigSupport_OI0.player, v6)) {
            double v10;
            LivingEntity v9;
            if (!(v8 instanceof LivingEntity) || !this.0iI(v9 = (LivingEntity)v8) || !((v10 = AntiKnockbackModule.ConfigSupport_OI0.player.method_33571().distanceTo(this.oOO(AntiKnockbackModule.ConfigSupport_OI0.player.method_33571(), v9.method_5829().expand((double)v9.method_5871())))) <= v4)) continue;
            v4 = v10;
            v3 = v9;
        }
        return v3;
    }

    @EventHandler
    public void 0oi(ConfigSupport_O0IO param1) {
        if (param1.0Oi() != EnumType_iii_0.Oi0 || AntiKnockbackModule.iooI()) {
            return;
        }
        if (!this.ConfigSupport_0OO) {
            return;
        }
        if (this.StorageEspModule >= (Integer)this.Oi0.HelpCommand() || AntiKnockbackModule.ConfigSupport_OI0.player.method_5624() || AntiKnockbackModule.ConfigSupport_OI0.player.method_6059(StatusEffects.SLOWNESS) || AntiKnockbackModule.ConfigSupport_OI0.player.method_24828() || !this.DataRecord_0io_2()) {
            this.o0O();
            this.EnumType_0OI = true;
            this.Kernel32SnapshotApi = 0;
            this.ConfigSupport_0II();
            this.ConfigSupport_0OO = false;
            this.StorageEspModule = -1;
        }
    }

    @EventHandler
    public void RenderSupport_0I0(PacketSendEvent param1) {
        EntityVelocityUpdateS2CPacket v3;
        if (AntiKnockbackModule.iooI()) {
            return;
        }
        Packet v2 = param1.PacketEvent();
        if (v2 instanceof EntityVelocityUpdateS2CPacket && (v3 = (EntityVelocityUpdateS2CPacket)v2).getEntityId() == AntiKnockbackModule.ConfigSupport_OI0.player.method_5628()) {
            this.0Io(v3);
        }
        if (this.ConfigSupport_0OO && !this.o00(v2)) {
            PacketListener packetListener = v3 = param1.Kernel32SnapshotApi() == null ? null : param1.Kernel32SnapshotApi().getPacketListener();
            if (v3 instanceof ClientPlayPacketListener) {
                ClientPlayPacketListener v4 = (ClientPlayPacketListener)v3;
                param1.DataRecord_0O0();
                this.OiI.offer(() -> this.oOi(v2, v4));
            }
        }
    }

    private void 0Io(EntityVelocityUpdateS2CPacket param1) {
        Vec3d v2 = param1.getVelocity();
        double v3 = v2.y;
        double v5 = new Vec3d(v2.x, 0.0, v2.z).length();
        if (v3 <= 0.0 || v5 < 0.1 || AntiKnockbackModule.ConfigSupport_OI0.player.method_6101() || AntiKnockbackModule.ConfigSupport_OI0.player.method_5799() || AntiKnockbackModule.ConfigSupport_OI0.player.method_5771()) {
            return;
        }
        Vec3d v7 = new Vec3d(v2.x, 0.0, v2.z).normalize().multiply(-1.0);
        this.0Oi = this.RenderSupport_ooi_1(v2.x, v2.z);
        Vec3d v8 = AntiKnockbackModule.ConfigSupport_OI0.player.method_73189().add(v7.x, 0.0, v7.z);
        this.ConfigSupport_00o_0 = this.FastWebModule(v8);
        float f = this.DataRecord_00I = 0ooo.GuiSupport_OOI() != null ? 0ooo.OOi().OIo() : AntiKnockbackModule.ConfigSupport_OI0.player.method_36455();
        if (this.ConfigSupport_0OO) {
            return;
        }
        if (((Boolean)this.OiO.HelpCommand()).booleanValue() && (Integer)this.Oi0.HelpCommand() != 0 && this.DataRecord_0io_2()) {
            if (AntiKnockbackModule.ConfigSupport_OI0.player.method_5624()) {
                this.EnumType_0OI = true;
                this.Kernel32SnapshotApi = 0;
                this.ConfigSupport_0II();
            } else {
                this.ConfigSupport_0OO = true;
                this.StorageEspModule = 0;
            }
            return;
        }
        this.EnumType_0OI = true;
        this.Kernel32SnapshotApi = 0;
        this.ConfigSupport_0II();
    }

    private boolean o00(Packet param1) {
        EntityAnimationS2CPacket v2;
        return param1 instanceof HealthUpdateS2CPacket || param1 instanceof PlayerPositionLookS2CPacket || param1 instanceof PlaySoundS2CPacket || param1 instanceof PlaySoundFromEntityS2CPacket || param1 instanceof GameMessageS2CPacket || param1 instanceof DeathMessageS2CPacket || param1 instanceof CloseScreenS2CPacket || param1 instanceof EntityDamageS2CPacket || param1 instanceof TitleS2CPacket || param1 instanceof SubtitleS2CPacket || param1 instanceof TitleFadeS2CPacket || param1 instanceof TeamS2CPacket || param1 instanceof EntityAnimationS2CPacket && (v2 = (EntityAnimationS2CPacket)param1).getEntityId() != AntiKnockbackModule.ConfigSupport_OI0.player.method_5628();
    }

    private void ConfigSupport_0II() {
        if (!((Boolean)this.Oio.HelpCommand()).booleanValue() || !AntiKnockbackModule.ConfigSupport_OI0.player.method_24828() || 0ooo.HudElement() == null) {
            return;
        }
        LivingEntity v1 = this.KeepSprintModule(3.2);
        float v2 = this.DataRecord_00I;
        if (v1 != null) {
            v2 = this.oOo(this.0ii(v1));
        }
        0ooo.EventBusApi().HelpCommand(this, this.ConfigSupport_00o_0, v2, 180.0f);
        this.DataRecord_0O0 = true;
    }

    private void ChestStealerModule() {
        if (AntiKnockbackModule.ConfigSupport_OI0.currentScreen instanceof InventoryScreen || AntiKnockbackModule.ConfigSupport_OI0.currentScreen instanceof HandledScreen) {
            return;
        }
        if (this.Kernel32SnapshotApi >= 0) {
            this.0Oo = true;
            if (this.Kernel32SnapshotApi <= 2 && AntiKnockbackModule.ConfigSupport_OI0.player.method_24828()) {
                AntiKnockbackModule.ConfigSupport_OI0.options.jumpKey.setPressed(true);
            }
            if (this.Kernel32SnapshotApi <= 3) {
                AntiKnockbackModule.ConfigSupport_OI0.options.forwardKey.setPressed(true);
                this.Oii = true;
            }
        }
        if (this.Kernel32SnapshotApi >= 4 && this.Kernel32SnapshotApi <= 9) {
            AntiKnockbackModule.ConfigSupport_OI0.options.jumpKey.setPressed(this.NetworkSupport_o0o_0(AntiKnockbackModule.ConfigSupport_OI0.options.jumpKey));
            if (this.Oii) {
                AntiKnockbackModule.ConfigSupport_OI0.options.forwardKey.setPressed(this.NetworkSupport_o0o_0(AntiKnockbackModule.ConfigSupport_OI0.options.forwardKey));
                this.Oii = false;
            }
            this.0Oo = false;
        }
    }

    @EventHandler
    public void AutoMlgModule(ConfigSupport_oio_5 param1) {
        if (this.0Oo || this.ConfigSupport_0OO || this.DataRecord_0O0) {
            param1.Oo0(1.0f);
        }
    }

    public AntiKnockbackModule() {
        super("AntiKnockback", "Ports Fuliki Hypixel BufferCorrect and RotationJumpReset.", ModuleCategory.i0I);
        this.OiI = new ConcurrentLinkedQueue();
        this.Oi0.00i(param1 -> (Boolean)this.OiO.HelpCommand());
    }

    static {
        __k__gH4it = AntiKnockbackModule.__k__gH4it(1228749322959449617L);
        __rP__gH4it0 = new String[]{"\uf3db\udb73\u056c\u512d\ud635\u38ac\uff22\u07aa\uf2f7\uda05\u0444\u51a9\ud97b\u37b6\uf008\u08e9\ufdcb\ud52f\u0b61\u5e95", "\uf3dd\udb69\u056f\u513c\ud655\u38b4\uff66"};
        __rP__gH4it1 = new String[]{"\uf303\udb3f\u0562\u51b8\ud684\u3870\uff0a\u0713"};
        __rP__gH4it2 = new String[]{"\uf3cd\udb78\u056f\u5140\ud655\u38b3\uff73\u0759\uf2d3\uda12", "\uf3cf\udb7a\u0569\u5146\ud657\u38b1\uff7d\u0757\uf2d1\uda10", "\uf3cd\udb61\u057e"};
        __rP__gH4it3 = new String[]{"\uf3d1\udb94\u0520\u5041\ud73c\u39da\ufed0\u0798\uf2bf\udac7\u0411\u51e6\ud63b\u3890\ufff8\u076a\ufdd1\ud55e\u0b7e\u5e22\ud9fb\u37a2\uf013\u0843\ufc4a\ud4de\u0a6c\u5f8e\ud84a\u3672\uf134\u09cb\uffa4\ud71a\u09ef\u5c6a\udbba\u3542\uf2d1\u0ac9\ufef6\ud6fa\u0866\u5d28\udac2\u34a7\uf34e\u0bde\ufe3d\ud186\u0fc2\u5a7f\udd83\u339d\uf449\u0c12\uf9fa\ud0bd\u0ec0\u5b6d\udc7b\u32a2\uf50c\u0de3\uf8d0\ud333\u0d8d\u5843\udf90\u31a8\uf67d\u0e92\ufb80\ud29b\u0cdc\u593a\ude6b\u30e2\uf7ba\u0f00\ufa62\ud218\u130b\u46ff\uc1bf\u2f4f\ue853\u10bc\ue5db\ucd15\u1255\u47f6\uc02f\u2eca\ue97f\u11af\ue4c9\ucc72\u11af\u44c7\uc30b\u2dbe\ueaa2\u121d\ue79a\ucff4\u10bf\u4574\uc2a7\u2cb0\ueb14\u1357\ue6ae\uce08\u1003\u4263\uc55a\u2b0c\uecbc\u14ac\ue128\uc91c\u17d3\u43bb\uc46c\u2a3c\uedd3\u1538\ue073\uc8fe\u16ef\u4030\uc728\u292e\ueeed\u165d\ue3bf\ucbd0\u15d1\u41b1\uc61b\u2844\uef14\u1796\ue2a5\uca12\u14a8\u41b9\uc9c3\u278b\ue0c6\u18aa", "\uf3d8\udb74\u056f\u513d\ud65c"};
        __p__gH4it = new String[]{"\ue3c6\ue3eb\ue410\ue435\ue45a\ue47f\ue4a4\ue4c9\ue4ee\ue513", "\uf36d\uf392\uf3b7\uf3dc\uf401\uf426\uf44b\uf470\uf495\uf4ba\uf4df\uf504\uf529\uf54e\uf573\uf598\uf5bd\uf5e2", "\ue738\ue75d\ue782\ue7a7\ue7cc\ue7f1\ue816\ue83b", "\ue707\ue72c\ue751\ue776\ue79b\ue7c0\ue7e5\ue80a\ue82f\ue854\ue879", "\ue2f2\ue317\ue33c\ue361\ue386\ue3ab\ue3d0\ue3f5\ue41a\ue43f\ue464\ue489\ue4ae\ue4d3\ue4f8\ue51d\ue542\ue567\ue58c", "\uf6b9\uf6de\uf703\uf728\uf74d\uf772\uf797\uf7bc\uf7e1\ue006\ue02b", "\ue684\ue6a9\ue6ce\ue6f3\ue718\ue73d\ue762\ue787\ue7ac", "\ue233\ue258\ue27d\ue2a2\ue2c7\ue2ec\ue311\ue336", "\ue1fe\ue223\ue248\ue26d\ue292\ue2b7\ue2dc\ue301\ue326\ue34b\ue370\ue395", "\uf5c5\uf5ea\uf60f\uf634\uf659\uf67e\uf6a3\uf6c8\uf6ed\uf712", "\ue9b0\ue9d5\ue9fa\uea1f\uea44\uea69\uea8e\ueab3\uead8\ueafd\ueb22\ueb47", "\ue17f\ue1a4\ue1c9\ue1ee\ue213\ue238\ue25d\ue282\ue2a7\ue2cc\ue2f1\ue316\ue33b\ue360\ue385", "\ued4a\ued6f\ued94\uedb9\uedde\uee03\uee28\uee4d\uee72\uee97\ueebc\ueee1\uef06", "\uecf1\ued16\ued3b\ued60\ued85\uedaa\uedcf\uedf4\uee19\uee3e\uee63\uee88\ueead\ueed2", "\uf0bc\uf0e1\uf106\uf12b\uf150\uf175\uf19a\uf1bf\uf1e4\uf209\uf22e\uf253", "\uec8b\uecb0\uecd5\uecfa\ued1f\ued44\ued69\ued8e\uedb3\uedd8\uedfd\uee22\uee47\uee6c\uee91\ueeb6\ueedb\uef00", "\uf456\uf47b\uf4a0\uf4c5\uf4ea\uf50f\uf534\uf559\uf57e\uf5a3\uf5c8\uf5ed\uf612\uf637", "\uf03d\uf062\uf087\uf0ac\uf0d1\uf0f6\uf11b\uf140\uf165\uf18a", "\ue408\ue42d\ue452\ue477\ue49c\ue4c1\ue4e6\ue50b\ue530\ue555\ue57a\ue59f", "\uebd7\uebfc\uec21\uec46\uec6b\uec90\uecb5\uecda\uecff\ued24\ued49\ued6e\ued93\uedb8\ueddd", "\uf782\uf7a7\uf7cc\uf7f1\ue016\ue03b\ue060\ue085\ue0aa\ue0cf\ue0f4", "\ue749\ue76e\ue793\ue7b8\ue7dd\ue802\ue827\ue84c\ue871\ue896\ue8bb\ue8e0", "\ue314\ue339\ue35e\ue383\ue3a8\ue3cd\ue3f2\ue417\ue43c\ue461\ue486\ue4ab\ue4d0\ue4f5\ue51a\ue53f", "\uf703\uf728\uf74d\uf772\uf797\uf7bc\uf7e1\ue006\ue02b\ue050\ue075\ue09a\ue0bf\ue0e4\ue109\ue12e", "\ueece\ueef3\uef18\uef3d\uef62\uef87\uefac\uefd1\ueff6", "\uea95\ueaba\ueadf\ueb04\ueb29\ueb4e\ueb73\ueb98\uebbd\uebe2\uec07\uec2c\uec51\uec76\uec9b", "\ue240\ue265\ue28a\ue2af\ue2d4\ue2f9\ue31e\ue343\ue368\ue38d\ue3b2\ue3d7", "\uee0f\uee34\uee59\uee7e\ueea3\ueec8\ueeed\uef12\uef37\uef5c\uef81", "\ue1da\ue1ff\ue224\ue249\ue26e\ue293\ue2b8\ue2dd\ue302", "\ue1c1\ue1e6\ue20b\ue230\ue255\ue27a\ue29f\ue2c4\ue2e9\ue30e\ue333", "\ued8c\uedb1\uedd6\uedfb\uee20\uee45\uee6a\uee8f\ueeb4\ueed9\ueefe", "\ue95b\ue980\ue9a5\ue9ca\ue9ef\uea14\uea39\uea5e\uea83\ueaa8\ueacd\ueaf2\ueb17\ueb3c\ueb61\ueb86\uebab\uebd0", "\ue926\ue94b\ue970\ue995\ue9ba\ue9df\uea04\uea29\uea4e\uea73\uea98\ueabd\ueae2\ueb07\ueb2c", "\ueccd\uecf2\ued17\ued3c\ued61\ued86\uedab\uedd0\uedf5\uee1a\uee3f\uee64\uee89\ueeae\ueed3", "\ue498\ue4bd\ue4e2\ue507\ue52c\ue551\ue576\ue59b\ue5c0\ue5e5\ue60a\ue62f\ue654\ue679\ue69e\ue6c3", "\ue067\ue08c\ue0b1\ue0d6\ue0fb\ue120\ue145\ue16a\ue18f\ue1b4\ue1d9", "\uec52\uec77\uec9c\uecc1\uece6\ued0b\ued30\ued55\ued7a\ued9f\uedc4\uede9\uee0e\uee33\uee58", "\uec19\uec3e\uec63\uec88\uecad\uecd2\uecf7\ued1c\ued41\ued66\ued8b\uedb0\uedd5\uedfa\uee1f\uee44\uee69", "\uf7e4\ue009\ue02e\ue053\ue078\ue09d\ue0c2\ue0e7\ue10c\ue131\ue156\ue17b\ue1a0\ue1c5\ue1ea", "\uf793\uf7b8\uf7dd\ue002\ue027\ue04c\ue071\ue096\ue0bb\ue0e0\ue105\ue12a\ue14f\ue174\ue199\ue1be\ue1e3\ue208\ue22d", "\ueb5e\ueb83\ueba8\uebcd\uebf2\uec17\uec3c\uec61\uec86\uecab\uecd0\uecf5\ued1a\ued3f\ued64\ued89\uedae\uedd3", "\ue725\ue74a\ue76f\ue794\ue7b9\ue7de\ue803\ue828\ue84d\ue872\ue897", "\ue710\ue735\ue75a\ue77f\ue7a4\ue7c9\ue7ee\ue813\ue838\ue85d\ue882\ue8a7", "\uf2df\uf304\uf329\uf34e\uf373\uf398\uf3bd\uf3e2\uf407\uf42c\uf451\uf476\uf49b\uf4c0\uf4e5", "\ueeaa\ueecf\ueef4\uef19\uef3e\uef63\uef88\uefad\uefd2\ueff7\uf01c\uf041\uf066", "\ue651\ue676\ue69b\ue6c0\ue6e5\ue70a\ue72f\ue754\ue779\ue79e\ue7c3\ue7e8", "\ue21c\ue241\ue266\ue28b\ue2b0\ue2d5\ue2fa\ue31f\ue344\ue369", "\ue9eb\uea10\uea35\uea5a\uea7f\ueaa4\ueac9\ueaee\ueb13\ueb38\ueb5d\ueb82\ueba7\uebcc\uebf1\uec16\uec3b", "\uedb6\ueddb\uee00\uee25\uee4a\uee6f\uee94\ueeb9\ueede\uef03\uef28\uef4d\uef72\uef97\uefbc\uefe1", "\ue19d\ue1c2\ue1e7\ue20c\ue231\ue256\ue27b\ue2a0\ue2c5\ue2ea\ue30f\ue334", "\ue168\ue18d\ue1b2\ue1d7\ue1fc\ue221\ue246\ue26b", "\ued37\ued5c\ued81\ueda6\uedcb\uedf0\uee15\uee3a\uee5f\uee84\ueea9", "\ue4e2\ue507\ue52c\ue551\ue576\ue59b\ue5c0\ue5e5\ue60a\ue62f\ue654\ue679\ue69e\ue6c3\ue6e8", "\uf0a9\uf0ce\uf0f3\uf118\uf13d\uf162\uf187\uf1ac\uf1d1\uf1f6\uf21b\uf240\uf265\uf28a", "\ue474\ue499\ue4be\ue4e3\ue508\ue52d\ue552\ue577\ue59c\ue5c1\ue5e6\ue60b\ue630\ue655\ue67a\ue69f\ue6c4", "\ue463\ue488\ue4ad\ue4d2\ue4f7\ue51c\ue541\ue566\ue58b\ue5b0\ue5d5", "\ue02e\ue053\ue078\ue09d\ue0c2\ue0e7\ue10c\ue131\ue156\ue17b\ue1a0\ue1c5\ue1ea\ue20f\ue234", "\uebf5\uec1a\uec3f\uec64\uec89\uecae\uecd3\uecf8", "\ue3a0\ue3c5\ue3ea\ue40f\ue434\ue459\ue47e\ue4a3\ue4c8\ue4ed\ue512\ue537\ue55c\ue581\ue5a6\ue5cb", "\ue76f\ue794\ue7b9\ue7de\ue803\ue828\ue84d\ue872\ue897\ue8bc\ue8e1", "\ue73a\ue75f\ue784\ue7a9\ue7ce\ue7f3\ue818\ue83d\ue862", "\uf321\uf346\uf36b\uf390\uf3b5\uf3da\uf3ff\uf424\uf449\uf46e\uf493\uf4b8\uf4dd\uf502\uf527\uf54c\uf571", "\ueeec\uef11\uef36\uef5b\uef80\uefa5\uefca\uefef\uf014\uf039\uf05e\uf083\uf0a8\uf0cd\uf0f2\uf117\uf13c", "\uf6bb\uf6e0\uf705\uf72a\uf74f\uf774\uf799\uf7be\uf7e3\ue008\ue02d\ue052\ue077", "\uf286\uf2ab\uf2d0\uf2f5\uf31a\uf33f\uf364\uf389\uf3ae\uf3d3\uf3f8\uf41d\uf442", "\uea2d\uea52\uea77\uea9c\ueac1\ueae6\ueb0b\ueb30\ueb55\ueb7a\ueb9f\uebc4\uebe9\uec0e\uec33\uec58\uec7d", "\uedf8\uee1d\uee42\uee67\uee8c\ueeb1\ueed6\ueefb", "\ue1c7\ue1ec\ue211\ue236\ue25b\ue280\ue2a5\ue2ca\ue2ef\ue314\ue339\ue35e\ue383\ue3a8\ue3cd\ue3f2\ue417\ue43c\ue461", "\ue9b2\ue9d7\ue9fc\uea21\uea46\uea6b\uea90\ueab5\ueada\ueaff\ueb24\ueb49\ueb6e\ueb93\uebb8", "\uf579\uf59e\uf5c3\uf5e8\uf60d\uf632\uf657\uf67c\uf6a1\uf6c6\uf6eb", "\ue144\ue169\ue18e\ue1b3\ue1d8\ue1fd\ue222\ue247", "\uf0f3\uf118\uf13d\uf162\uf187\uf1ac\uf1d1\uf1f6\uf21b\uf240\uf265\uf28a\uf2af\uf2d4\uf2f9\uf31e\uf343\uf368\uf38d", "\uecbe\uece3\ued08\ued2d\ued52\ued77\ued9c\uedc1", "\uec85\uecaa\ueccf\uecf4\ued19\ued3e\ued63\ued88\uedad\uedd2\uedf7\uee1c\uee41", "\ue870\ue895\ue8ba\ue8df\ue904\ue929\ue94e\ue973", "\uf43f\uf464\uf489\uf4ae\uf4d3\uf4f8\uf51d\uf542\uf567\uf58c\uf5b1", "\uf40a\uf42f\uf454\uf479\uf49e\uf4c3\uf4e8\uf50d\uf532", "\uefb1\uefd6\ueffb\uf020\uf045\uf06a\uf08f\uf0b4\uf0d9\uf0fe\uf123\uf148\uf16d\uf192\uf1b7\uf1dc\uf201\uf226", "\ue77c\ue7a1\ue7c6\ue7eb\ue810\ue835\ue85a\ue87f\ue8a4\ue8c9\ue8ee\ue913\ue938\ue95d\ue982\ue9a7\ue9cc\ue9f1\uea16", "\uf34b\uf370\uf395\uf3ba\uf3df\uf404\uf429\uf44e\uf473", "\uef16\uef3b\uef60\uef85\uefaa\uefcf\ueff4\uf019\uf03e\uf063\uf088\uf0ad\uf0d2\uf0f7\uf11c\uf141\uf166\uf18b", "\ue6fd\ue722\ue747\ue76c\ue791\ue7b6\ue7db\ue800\ue825", "\ue2c8\ue2ed\ue312\ue337\ue35c\ue381\ue3a6\ue3cb\ue3f0\ue415\ue43a\ue45f\ue484\ue4a9\ue4ce\ue4f3", "\uee97\ueebc\ueee1\uef06\uef2b\uef50\uef75\uef9a\uefbf\uefe4\uf009\uf02e\uf053\uf078\uf09d\uf0c2\uf0e7\uf10c\uf131", "\uee42\uee67\uee8c\ueeb1\ueed6\ueefb\uef20\uef45\uef6a\uef8f\uefb4\uefd9\ueffe\uf023\uf048", "\uf209\uf22e\uf253\uf278\uf29d\uf2c2\uf2e7\uf30c\uf331\uf356\uf37b\uf3a0", "\ue9d4\ue9f9\uea1e\uea43\uea68\uea8d\ueab2\uead7\ueafc\ueb21\ueb46\ueb6b\ueb90\uebb5\uebda", "\ue5c3\ue5e8\ue60d\ue632\ue657\ue67c\ue6a1\ue6c6\ue6eb\ue710\ue735\ue75a\ue77f\ue7a4\ue7c9\ue7ee\ue813\ue838\ue85d", "\uf18e\uf1b3\uf1d8\uf1fd\uf222\uf247\uf26c\uf291\uf2b6\uf2db\uf300\uf325\uf34a", "\ue955\ue97a\ue99f\ue9c4\ue9e9\uea0e\uea33\uea58\uea7d\ueaa2", "\uf500\uf525\uf54a\uf56f\uf594\uf5b9\uf5de\uf603\uf628\uf64d\uf672\uf697\uf6bc\uf6e1\uf706", "\uf4cf\uf4f4\uf519\uf53e\uf563\uf588\uf5ad\uf5d2\uf5f7\uf61c\uf641\uf666\uf68b\uf6b0\uf6d5\uf6fa\uf71f\uf744\uf769", "\uf09a\uf0bf\uf0e4\uf109\uf12e\uf153\uf178\uf19d\uf1c2\uf1e7\uf20c\uf231\uf256\uf27b\uf2a0\uf2c5\uf2ea", "\uec81\ueca6\ueccb\uecf0\ued15\ued3a\ued5f\ued84\ueda9\uedce\uedf3\uee18\uee3d\uee62\uee87", "\uec4c\uec71\uec96\uecbb\uece0\ued05\ued2a\ued4f\ued74\ued99\uedbe\uede3\uee08\uee2d", "\ue01b\ue040\ue065\ue08a\ue0af\ue0d4\ue0f9\ue11e\ue143\ue168\ue18d\ue1b2\ue1d7\ue1fc\ue221\ue246"};
        __c__J7Um6 = new Object[][]{{"\uea12\uea37\uea5c\uea81\ueaa6\ueacb\ueaf0\ueb15\ueb3a\ueb5f\ueb84\ueba9\uebce\uebf3\uec18\uec3d\uec62\uec87", 1478815255627183531L, "\uf130\uf155\uf17a\uf19f\uf1c4\uf1e9\uf20e\uf233\uf258\uf27d\uf2a2\uf2c7\uf2ec\uf311\uf336\uf35b", 1340094993, "\ue04e\ue073\ue098\ue0bd\ue0e2\ue107\ue12c\ue151\ue176\ue19b\ue1c0\ue1e5\ue20a", false, "\ue76c\ue791\ue7b6\ue7db\ue800\ue825\ue84a\ue86f\ue894\ue8b9\ue8de\ue903", false, "\uee8a\ueeaf\ueed4\ueef9\uef1e\uef43\uef68\uef8d\uefb2\uefd7\ueffc\uf021\uf046\uf06b\uf090\uf0b5\uf0da\uf0ff", false, "\uf5a8\uf5cd\uf5f2\uf617\uf63c\uf661\uf686\uf6ab\uf6d0\uf6f5", false}, {"\ueb13\ueb38\ueb5d\ueb82\ueba7\uebcc\uebf1\uec16\uec3b\uec60\uec85\uecaa\ueccf", 1478815255627249068L, "\uf231\uf256\uf27b\uf2a0\uf2c5\uf2ea\uf30f\uf334\uf359\uf37e\uf3a3\uf3c8\uf3ed\uf412\uf437\uf45c\uf481\uf4a6", 25689270, "\ue14f\ue174\ue199\ue1be\ue1e3\ue208\ue22d\ue252\ue277\ue29c\ue2c1\ue2e6\ue30b\ue330\ue355\ue37a", true, "\ue86d\ue892\ue8b7\ue8dc\ue901\ue926\ue94b\ue970\ue995\ue9ba\ue9df\uea04\uea29\uea4e\uea73\uea98", true, "\uef8b\uefb0\uefd5\ueffa\uf01f\uf044\uf069\uf08e\uf0b3\uf0d8\uf0fd\uf122\uf147", true, "\uf6a9\uf6ce\uf6f3\uf718\uf73d\uf762\uf787\uf7ac\uf7d1\uf7f6\ue01b\ue040\ue065\ue08a\ue0af", true}, {"\uec14\uec39\uec5e\uec83\ueca8\ueccd\uecf2\ued17\ued3c\ued61\ued86\uedab\uedd0\uedf5\uee1a\uee3f", 1478815255627314605L, "\uf332\uf357\uf37c\uf3a1\uf3c6\uf3eb\uf410\uf435\uf45a\uf47f\uf4a4\uf4c9\uf4ee", -751847585, "\ue250\ue275\ue29a\ue2bf\ue2e4\ue309\ue32e\ue353\ue378\ue39d\ue3c2\ue3e7", false, "\ue96e\ue993\ue9b8\ue9dd\uea02\uea27\uea4c\uea71\uea96\ueabb\ueae0\ueb05\ueb2a\ueb4f\ueb74\ueb99\uebbe\uebe3", false, "\uf08c\uf0b1\uf0d6\uf0fb\uf120\uf145\uf16a\uf18f\uf1b4\uf1d9", false, "\uf7aa\uf7cf\uf7f4\ue019\ue03e\ue063\ue088\ue0ad\ue0d2\ue0f7\ue11c", false}, {"\ued15\ued3a\ued5f\ued84\ueda9\uedce\uedf3\uee18\uee3d\uee62\uee87\ueeac\ueed1\ueef6\uef1b\uef40\uef65\uef8a", 1478815255627380142L, "\uf433\uf458\uf47d\uf4a2\uf4c7\uf4ec\uf511\uf536\uf55b\uf580\uf5a5\uf5ca\uf5ef\uf614\uf639\uf65e", -1529386524, "\ue351\ue376\ue39b\ue3c0\ue3e5\ue40a\ue42f\ue454\ue479\ue49e\ue4c3\ue4e8\ue50d\ue532\ue557\ue57c", true, "\uea6f\uea94\ueab9\ueade\ueb03\ueb28\ueb4d\ueb72\ueb97\uebbc\uebe1\uec06\uec2b", true, "\uf18d\uf1b2\uf1d7\uf1fc\uf221\uf246\uf26b\uf290\uf2b5\uf2da\uf2ff\uf324\uf349\uf36e\uf393", true, "\ue0ab\ue0d0\ue0f5\ue11a\ue13f\ue164\ue189\ue1ae\ue1d3", true}, {"\uee16\uee3b\uee60\uee85\ueeaa\ueecf\ueef4\uef19\uef3e\uef63\uef88\uefad\uefd2", 1478815255627445679L, "\uf534\uf559\uf57e\uf5a3\uf5c8\uf5ed\uf612\uf637\uf65c\uf681\uf6a6\uf6cb", 1988042893, "\ue452\ue477\ue49c\ue4c1\ue4e6\ue50b\ue530\ue555\ue57a\ue59f\ue5c4\ue5e9\ue60e\ue633\ue658\ue67d\ue6a2\ue6c7", false, "\ueb70\ueb95\uebba\uebdf\uec04\uec29\uec4e\uec73\uec98\uecbd", false, "\uf28e\uf2b3\uf2d8\uf2fd\uf322\uf347\uf36c\uf391\uf3b6\uf3db\uf400", false, "\ue1ac\ue1d1\ue1f6\ue21b\ue240\ue265\ue28a\ue2af", false}, {"\uef17\uef3c\uef61\uef86\uefab\uefd0\ueff5\uf01a\uf03f\uf064\uf089\uf0ae\uf0d3\uf0f8\uf11d\uf142", 1478815255627511216L, "\uf635\uf65a\uf67f\uf6a4\uf6c9\uf6ee\uf713\uf738\uf75d\uf782\uf7a7\uf7cc\uf7f1\ue016\ue03b\ue060", -941171886, "\ue553\ue578\ue59d\ue5c2\ue5e7\ue60c\ue631\ue656\ue67b\ue6a0\ue6c5\ue6ea\ue70f", true, "\uec71\uec96\uecbb\uece0\ued05\ued2a\ued4f\ued74\ued99\uedbe\uede3\uee08\uee2d\uee52\uee77", true, "\uf38f\uf3b4\uf3d9\uf3fe\uf423\uf448\uf46d\uf492\uf4b7", true, "\ue2ad\ue2d2\ue2f7\ue31c\ue341\ue366\ue38b\ue3b0", true}, {"\uf018\uf03d\uf062\uf087\uf0ac\uf0d1\uf0f6\uf11b\uf140\uf165\uf18a\uf1af", 1478815255627576753L, "\uf736\uf75b\uf780\uf7a5\uf7ca\uf7ef\ue014\ue039\ue05e\ue083\ue0a8\ue0cd\ue0f2\ue117\ue13c\ue161\ue186\ue1ab", -1718706693, "\ue654\ue679\ue69e\ue6c3\ue6e8\ue70d\ue732\ue757\ue77c\ue7a1", false, "\ued72\ued97\uedbc\uede1\uee06\uee2b\uee50\uee75\uee9a\ueebf\ueee4", false, "\uf490\uf4b5\uf4da\uf4ff\uf524\uf549\uf56e\uf593", false, "\ue3ae\ue3d3\ue3f8\ue41d\ue442\ue467\ue48c\ue4b1\ue4d6\ue4fb\ue520\ue545\ue56a\ue58f\ue5b4\ue5d9\ue5fe\ue623", false}, {"\uf119\uf13e\uf163\uf188\uf1ad\uf1d2\uf1f7\uf21c\uf241\uf266\uf28b\uf2b0\uf2d5\uf2fa\uf31f\uf344", 1478815255627642290L, "\ue037\ue05c\ue081\ue0a6\ue0cb\ue0f0\ue115\ue13a\ue15f\ue184\ue1a9\ue1ce\ue1f3", 1798722688, "\ue755\ue77a\ue79f\ue7c4\ue7e9\ue80e\ue833\ue858\ue87d\ue8a2\ue8c7\ue8ec\ue911\ue936\ue95b", true, "\uee73\uee98\ueebd\ueee2\uef07\uef2c\uef51\uef76\uef9b", true, "\uf591\uf5b6\uf5db\uf600\uf625\uf64a\uf66f\uf694", true, "\ue4af\ue4d4\ue4f9\ue51e\ue543\ue568\ue58d\ue5b2\ue5d7\ue5fc\ue621\ue646\ue66b", true}, {"\uf21a\uf23f\uf264\uf289\uf2ae\uf2d3\uf2f8\uf31d\uf342\uf367\uf38c\uf3b1\uf3d6\uf3fb\uf420\uf445\uf46a\uf48f", 1478815255627707827L, "\ue138\ue15d\ue182\ue1a7\ue1cc\ue1f1\ue216\ue23b\ue260\ue285", 1021185833, "\ue856\ue87b\ue8a0\ue8c5\ue8ea\ue90f\ue934\ue959\ue97e\ue9a3\ue9c8", false, "\uef74\uef99\uefbe\uefe3\uf008\uf02d\uf052\uf077", false, "\uf692\uf6b7\uf6dc\uf701\uf726\uf74b\uf770\uf795\uf7ba\uf7df\ue004\ue029\ue04e\ue073\ue098\ue0bd\ue0e2\ue107", false, "\ue5b0\ue5d5\ue5fa\ue61f\ue644\ue669\ue68e\ue6b3\ue6d8\ue6fd\ue722\ue747\ue76c\ue791\ue7b6\ue7db", false}, {"\uf31b\uf340\uf365\uf38a\uf3af\uf3d4\uf3f9\uf41e\uf443\uf468\uf48d\uf4b2\uf4d7", 1478815255627773364L, "\ue239\ue25e\ue283\ue2a8\ue2cd\ue2f2\ue317\ue33c\ue361\ue386\ue3ab\ue3d0\ue3f5\ue41a\ue43f", -1908031026, "\ue957\ue97c\ue9a1\ue9c6\ue9eb\uea10\uea35\uea5a\uea7f", true, "\uf075\uf09a\uf0bf\uf0e4\uf109\uf12e\uf153\uf178", true, "\uf793\uf7b8\uf7dd\ue002\ue027\ue04c\ue071\ue096\ue0bb\ue0e0\ue105\ue12a\ue14f", true, "\ue6b1\ue6d6\ue6fb\ue720\ue745\ue76a\ue78f\ue7b4\ue7d9\ue7fe\ue823\ue848\ue86d\ue892\ue8b7\ue8dc\ue901\ue926", true}, {"\uf41c\uf441\uf466\uf48b\uf4b0\uf4d5\uf4fa\uf51f\uf544\uf569", 1478815255627838901L, "\ue33a\ue35f\ue384\ue3a9\ue3ce\ue3f3\ue418\ue43d\ue462\ue487\ue4ac", 1609431191, "\uea58\uea7d\ueaa2\ueac7\ueaec\ueb11\ueb36\ueb5b", false, "\uf176\uf19b\uf1c0\uf1e5\uf20a\uf22f\uf254\uf279\uf29e\uf2c3\uf2e8\uf30d\uf332\uf357\uf37c\uf3a1\uf3c6\uf3eb", false, "\ue094\ue0b9\ue0de\ue103\ue128\ue14d\ue172\ue197\ue1bc\ue1e1\ue206\ue22b\ue250\ue275\ue29a\ue2bf", false, "\ue7b2\ue7d7\ue7fc\ue821\ue846\ue86b\ue890\ue8b5\ue8da\ue8ff\ue924\ue949\ue96e", false}, {"\uf51d\uf542\uf567\uf58c\uf5b1\uf5d6\uf5fb\uf620\uf645\uf66a\uf68f\uf6b4\uf6d9\uf6fe\uf723", 1478815255627904438L, "\ue43b\ue460\ue485\ue4aa\ue4cf\ue4f4\ue519\ue53e\ue563", 295023420, "\ueb59\ueb7e\ueba3\uebc8\uebed\uec12\uec37\uec5c", true, "\uf277\uf29c\uf2c1\uf2e6\uf30b\uf330\uf355\uf37a\uf39f\uf3c4\uf3e9\uf40e\uf433", true, "\ue195\ue1ba\ue1df\ue204\ue229\ue24e\ue273\ue298\ue2bd\ue2e2\ue307\ue32c\ue351\ue376\ue39b\ue3c0\ue3e5\ue40a", true, "\ue8b3\ue8d8\ue8fd\ue922\ue947\ue96c\ue991\ue9b6\ue9db\uea00\uea25\uea4a\uea6f\uea94\ueab9\ueade", true}, {"\uf61e\uf643\uf668\uf68d\uf6b2\uf6d7\uf6fc\uf721\uf746\uf76b\uf790", 1478815255627969975L, "\ue53c\ue561\ue586\ue5ab\ue5d0\ue5f5\ue61a\ue63f", -482511419, "\uec5a\uec7f\ueca4\uecc9\uecee\ued13\ued38\ued5d\ued82\ueda7\uedcc\uedf1\uee16\uee3b\uee60\uee85\ueeaa\ueecf", false, "\uf378\uf39d\uf3c2\uf3e7\uf40c\uf431\uf456\uf47b\uf4a0\uf4c5\uf4ea\uf50f\uf534\uf559\uf57e\uf5a3", false, "\ue296\ue2bb\ue2e0\ue305\ue32a\ue34f\ue374\ue399\ue3be\ue3e3\ue408\ue42d\ue452", false, "\ue9b4\ue9d9\ue9fe\uea23\uea48\uea6d\uea92\ueab7\ueadc\ueb01\ueb26\ueb4b", false}, {"\uf71f\uf744\uf769\uf78e\uf7b3\uf7d8\uf7fd\ue022\ue047", 1478815255628035512L, "\ue63d\ue662\ue687\ue6ac\ue6d1\ue6f6\ue71b\ue740", -1264243606, "\ued5b\ued80\ueda5\uedca\uedef\uee14\uee39\uee5e\uee83\ueea8\ueecd\ueef2\uef17", true, "\uf479\uf49e\uf4c3\uf4e8\uf50d\uf532\uf557\uf57c\uf5a1\uf5c6\uf5eb\uf610\uf635\uf65a\uf67f\uf6a4\uf6c9\uf6ee", true, "\ue397\ue3bc\ue3e1\ue406\ue42b\ue450\ue475\ue49a\ue4bf\ue4e4\ue509\ue52e\ue553\ue578\ue59d\ue5c2", true, "\ueab5\ueada\ueaff\ueb24\ueb49\ueb6e\ueb93\uebb8\uebdd\uec02\uec27\uec4c\uec71\uec96\uecbb\uece0", true}, {"\ue020\ue045\ue06a\ue08f\ue0b4\ue0d9\ue0fe\ue123", 1478815255628101049L, "\ue73e\ue763\ue788\ue7ad\ue7d2\ue7f7\ue81c\ue841\ue866\ue88b\ue8b0\ue8d5\ue8fa\ue91f\ue944\ue969\ue98e\ue9b3", 105703219, "\uee5c\uee81\ueea6\ueecb\ueef0\uef15\uef3a\uef5f\uef84\uefa9\uefce\ueff3\uf018\uf03d\uf062\uf087", false, "\uf57a\uf59f\uf5c4\uf5e9\uf60e\uf633\uf658\uf67d\uf6a2\uf6c7\uf6ec\uf711\uf736", false, "\ue498\ue4bd\ue4e2\ue507\ue52c\ue551\ue576\ue59b\ue5c0\ue5e5\ue60a\ue62f", false, "\uebb6\uebdb\uec00\uec25\uec4a\uec6f\uec94\uecb9\uecde\ued03\ued28\ued4d\ued72\ued97\uedbc\uede1\uee06\uee2b", false}, {"\ue121\ue146\ue16b\ue190\ue1b5\ue1da\ue1ff\ue224", 1478815255628166586L, "\ue83f\ue864\ue889\ue8ae\ue8d3\ue8f8\ue91d\ue942\ue967\ue98c\ue9b1\ue9d6\ue9fb", -671835688, "\uef5d\uef82\uefa7\uefcc\ueff1\uf016\uf03b\uf060\uf085\uf0aa\uf0cf\uf0f4\uf119\uf13e\uf163\uf188\uf1ad\uf1d2", true, "\uf67b\uf6a0\uf6c5\uf6ea\uf70f\uf734\uf759\uf77e\uf7a3\uf7c8\uf7ed\ue012\ue037\ue05c\ue081\ue0a6", true, "\ue599\ue5be\ue5e3\ue608\ue62d\ue652\ue677\ue69c\ue6c1\ue6e6\ue70b\ue730\ue755\ue77a\ue79f\ue7c4", true, "\uecb7\uecdc\ued01\ued26\ued4b\ued70\ued95\uedba\ueddf\uee04\uee29\uee4e\uee73", true}, {"\ue222\ue247\ue26c\ue291\ue2b6\ue2db\ue300\ue325\ue34a\ue36f\ue394\ue3b9\ue3de\ue403\ue428\ue44d\ue472\ue497", 1478815255628232123L, "\ue940\ue965\ue98a\ue9af\ue9d4\ue9f9\uea1e\uea43\uea68\uea8d\ueab2\uead7\ueafc\ueb21\ueb46\ueb6b", -1449373599, "\uf05e\uf083\uf0a8\uf0cd\uf0f2\uf117\uf13c\uf161\uf186\uf1ab\uf1d0\uf1f5\uf21a", false, "\uf77c\uf7a1\uf7c6\uf7eb\ue010\ue035\ue05a\ue07f\ue0a4\ue0c9\ue0ee\ue113", false, "\ue69a\ue6bf\ue6e4\ue709\ue72e\ue753\ue778\ue79d\ue7c2\ue7e7\ue80c\ue831\ue856\ue87b\ue8a0\ue8c5\ue8ea\ue90f", false, "\uedb8\ueddd\uee02\uee27\uee4c\uee71\uee96\ueebb\ueee0\uef05", false}, {"\ue323\ue348\ue36d\ue392\ue3b7\ue3dc\ue401\ue426\ue44b\ue470\ue495\ue4ba\ue4df", 1478815255628297660L, "\uea41\uea66\uea8b\ueab0\uead5\ueafa\ueb1f\ueb44\ueb69\ueb8e\uebb3\uebd8\uebfd\uec22\uec47\uec6c\uec91\uecb6", 2063862534, "\uf15f\uf184\uf1a9\uf1ce\uf1f3\uf218\uf23d\uf262\uf287\uf2ac\uf2d1\uf2f6\uf31b\uf340\uf365\uf38a", true, "\ue07d\ue0a2\ue0c7\ue0ec\ue111\ue136\ue15b\ue180\ue1a5\ue1ca\ue1ef\ue214\ue239\ue25e\ue283\ue2a8", true, "\ue79b\ue7c0\ue7e5\ue80a\ue82f\ue854\ue879\ue89e\ue8c3\ue8e8\ue90d\ue932\ue957", true, "\ueeb9\ueede\uef03\uef28\uef4d\uef72\uef97\uefbc\uefe1\uf006\uf02b\uf050\uf075\uf09a\uf0bf", true}, {"\ue424\ue449\ue46e\ue493\ue4b8\ue4dd\ue502\ue527\ue54c\ue571\ue596\ue5bb\ue5e0\ue605\ue62a\ue64f", 1478815255628363197L, "\ueb42\ueb67\ueb8c\uebb1\uebd6\uebfb\uec20\uec45\uec6a\uec8f\uecb4\uecd9\uecfe", -861155921, "\uf260\uf285\uf2aa\uf2cf\uf2f4\uf319\uf33e\uf363\uf388\uf3ad\uf3d2\uf3f7", false, "\ue17e\ue1a3\ue1c8\ue1ed\ue212\ue237\ue25c\ue281\ue2a6\ue2cb\ue2f0\ue315\ue33a\ue35f\ue384\ue3a9\ue3ce\ue3f3", false, "\ue89c\ue8c1\ue8e6\ue90b\ue930\ue955\ue97a\ue99f\ue9c4\ue9e9", false, "\uefba\uefdf\uf004\uf029\uf04e\uf073\uf098\uf0bd\uf0e2\uf107\uf12c", false}, {"\ue525\ue54a\ue56f\ue594\ue5b9\ue5de\ue603\ue628\ue64d\ue672\ue697\ue6bc\ue6e1\ue706\ue72b\ue750\ue775\ue79a", 1478815255628428734L, "\uec43\uec68\uec8d\uecb2\uecd7\uecfc\ued21\ued46\ued6b\ued90\uedb5\uedda\uedff\uee24\uee49\uee6e", -1638693772, "\uf361\uf386\uf3ab\uf3d0\uf3f5\uf41a\uf43f\uf464\uf489\uf4ae\uf4d3\uf4f8\uf51d\uf542\uf567\uf58c", true, "\ue27f\ue2a4\ue2c9\ue2ee\ue313\ue338\ue35d\ue382\ue3a7\ue3cc\ue3f1\ue416\ue43b", true, "\ue99d\ue9c2\ue9e7\uea0c\uea31\uea56\uea7b\ueaa0\ueac5\ueaea\ueb0f\ueb34\ueb59\ueb7e\ueba3", true, "\uf0bb\uf0e0\uf105\uf12a\uf14f\uf174\uf199\uf1be\uf1e3", true}, {"\ue626\ue64b\ue670\ue695\ue6ba\ue6df\ue704\ue729\ue74e\ue773\ue798\ue7bd\ue7e2", 1478815255628494271L, "\ued44\ued69\ued8e\uedb3\uedd8\uedfd\uee22\uee47\uee6c\uee91\ueeb6\ueedb", 1878769437, "\uf462\uf487\uf4ac\uf4d1\uf4f6\uf51b\uf540\uf565\uf58a\uf5af\uf5d4\uf5f9\uf61e\uf643\uf668\uf68d\uf6b2\uf6d7", false, "\ue380\ue3a5\ue3ca\ue3ef\ue414\ue439\ue45e\ue483\ue4a8\ue4cd", false, "\uea9e\ueac3\ueae8\ueb0d\ueb32\ueb57\ueb7c\ueba1\uebc6\uebeb\uec10", false, "\uf1bc\uf1e1\uf206\uf22b\uf250\uf275\uf29a\uf2bf", false}, {"\ue727\ue74c\ue771\ue796\ue7bb\ue7e0\ue805\ue82a\ue84f\ue874\ue899\ue8be\ue8e3\ue908\ue92d\ue952", 1478815255628559808L, "\uee45\uee6a\uee8f\ueeb4\ueed9\ueefe\uef23\uef48\uef6d\uef92\uefb7\uefdc\uf001\uf026\uf04b\uf070", 560165282, "\uf563\uf588\uf5ad\uf5d2\uf5f7\uf61c\uf641\uf666\uf68b\uf6b0\uf6d5\uf6fa\uf71f", true, "\ue481\ue4a6\ue4cb\ue4f0\ue515\ue53a\ue55f\ue584\ue5a9\ue5ce\ue5f3\ue618\ue63d\ue662\ue687", true, "\ueb9f\uebc4\uebe9\uec0e\uec33\uec58\uec7d\ueca2\uecc7", true, "\uf2bd\uf2e2\uf307\uf32c\uf351\uf376\uf39b\uf3c0", true}, {"\ue828\ue84d\ue872\ue897\ue8bc\ue8e1\ue906\ue92b\ue950\ue975\ue99a\ue9bf", 1478815255628625345L, "\uef46\uef6b\uef90\uefb5\uefda\uefff\uf024\uf049\uf06e\uf093\uf0b8\uf0dd\uf102\uf127\uf14c\uf171\uf196\uf1bb", -217372597, "\uf664\uf689\uf6ae\uf6d3\uf6f8\uf71d\uf742\uf767\uf78c\uf7b1", false, "\ue582\ue5a7\ue5cc\ue5f1\ue616\ue63b\ue660\ue685\ue6aa\ue6cf\ue6f4", false, "\ueca0\uecc5\uecea\ued0f\ued34\ued59\ued7e\ueda3", false, "\uf3be\uf3e3\uf408\uf42d\uf452\uf477\uf49c\uf4c1\uf4e6\uf50b\uf530\uf555\uf57a\uf59f\uf5c4\uf5e9\uf60e\uf633", false}, {"\ue929\ue94e\ue973\ue998\ue9bd\ue9e2\uea07\uea2c\uea51\uea76\uea9b\ueac0\ueae5\ueb0a\ueb2f\ueb54", 1478815255628690882L, "\uf047\uf06c\uf091\uf0b6\uf0db\uf100\uf125\uf14a\uf16f\uf194\uf1b9\uf1de\uf203", 1152574224, "\uf765\uf78a\uf7af\uf7d4\uf7f9\ue01e\ue043\ue068\ue08d\ue0b2\ue0d7\ue0fc\ue121\ue146\ue16b", true, "\ue683\ue6a8\ue6cd\ue6f2\ue717\ue73c\ue761\ue786\ue7ab", true, "\ueda1\uedc6\uedeb\uee10\uee35\uee5a\uee7f\ueea4", true, "\uf4bf\uf4e4\uf509\uf52e\uf553\uf578\uf59d\uf5c2\uf5e7\uf60c\uf631\uf656\uf67b", true}, {"\uea2a\uea4f\uea74\uea99\ueabe\ueae3\ueb08\ueb2d\ueb52\ueb77\ueb9c\uebc1\uebe6\uec0b\uec30\uec55\uec7a\uec9f", 1478815255628756419L, "\uf148\uf16d\uf192\uf1b7\uf1dc\uf201\uf226\uf24b\uf270\uf295", 375039417, "\ue066\ue08b\ue0b0\ue0d5\ue0fa\ue11f\ue144\ue169\ue18e\ue1b3\ue1d8", false, "\ue784\ue7a9\ue7ce\ue7f3\ue818\ue83d\ue862\ue887", false, "\ueea2\ueec7\ueeec\uef11\uef36\uef5b\uef80\uefa5\uefca\uefef\uf014\uf039\uf05e\uf083\uf0a8\uf0cd\uf0f2\uf117", false, "\uf5c0\uf5e5\uf60a\uf62f\uf654\uf679\uf69e\uf6c3\uf6e8\uf70d\uf732\uf757\uf77c\uf7a1\uf7c6\uf7eb", false}, {"\ueb2b\ueb50\ueb75\ueb9a\uebbf\uebe4\uec09\uec2e\uec53\uec78\uec9d\uecc2\uece7", 1478815255628821956L, "\uf249\uf26e\uf293\uf2b8\uf2dd\uf302\uf327\uf34c\uf371\uf396\uf3bb\uf3e0\uf405\uf42a\uf44f", -406692770, "\ue167\ue18c\ue1b1\ue1d6\ue1fb\ue220\ue245\ue26a\ue28f", true, "\ue885\ue8aa\ue8cf\ue8f4\ue919\ue93e\ue963\ue988", true, "\uefa3\uefc8\uefed\uf012\uf037\uf05c\uf081\uf0a6\uf0cb\uf0f0\uf115\uf13a\uf15f", true, "\uf6c1\uf6e6\uf70b\uf730\uf755\uf77a\uf79f\uf7c4\uf7e9\ue00e\ue033\ue058\ue07d\ue0a2\ue0c7\ue0ec\ue111\ue136", true}, {"\uec2c\uec51\uec76\uec9b\uecc0\uece5\ued0a\ued2f\ued54\ued79", 1478815255628887493L, "\uf34a\uf36f\uf394\uf3b9\uf3de\uf403\uf428\uf44d\uf472\uf497\uf4bc", -1184229657, "\ue268\ue28d\ue2b2\ue2d7\ue2fc\ue321\ue346\ue36b", false, "\ue986\ue9ab\ue9d0\ue9f5\uea1a\uea3f\uea64\uea89\ueaae\uead3\ueaf8\ueb1d\ueb42\ueb67\ueb8c\uebb1\uebd6\uebfb", false, "\uf0a4\uf0c9\uf0ee\uf113\uf138\uf15d\uf182\uf1a7\uf1cc\uf1f1\uf216\uf23b\uf260\uf285\uf2aa\uf2cf", false, "\uf7c2\uf7e7\ue00c\ue031\ue056\ue07b\ue0a0\ue0c5\ue0ea\ue10f\ue134\ue159\ue17e", false}, {"\ued2d\ued52\ued77\ued9c\uedc1\uede6\uee0b\uee30\uee55\uee7a\uee9f\ueec4\ueee9\uef0e\uef33", 1478815255628953030L, "\uf44b\uf470\uf495\uf4ba\uf4df\uf504\uf529\uf54e\uf573", 185715084, "\ue369\ue38e\ue3b3\ue3d8\ue3fd\ue422\ue447\ue46c", true, "\uea87\ueaac\uead1\ueaf6\ueb1b\ueb40\ueb65\ueb8a\uebaf\uebd4\uebf9\uec1e\uec43", true, "\uf1a5\uf1ca\uf1ef\uf214\uf239\uf25e\uf283\uf2a8\uf2cd\uf2f2\uf317\uf33c\uf361\uf386\uf3ab\uf3d0\uf3f5\uf41a", true, "\ue0c3\ue0e8\ue10d\ue132\ue157\ue17c\ue1a1\ue1c6\ue1eb\ue210\ue235\ue25a\ue27f\ue2a4\ue2c9\ue2ee", true}, {"\uee2e\uee53\uee78\uee9d\ueec2\ueee7\uef0c\uef31\uef56\uef7b\uefa0", 1478815255629018567L, "\uf54c\uf571\uf596\uf5bb\uf5e0\uf605\uf62a\uf64f", -591822763, "\ue46a\ue48f\ue4b4\ue4d9\ue4fe\ue523\ue548\ue56d\ue592\ue5b7\ue5dc\ue601\ue626\ue64b\ue670\ue695\ue6ba\ue6df", false, "\ueb88\uebad\uebd2\uebf7\uec1c\uec41\uec66\uec8b\uecb0\uecd5\uecfa\ued1f\ued44\ued69\ued8e\uedb3", false, "\uf2a6\uf2cb\uf2f0\uf315\uf33a\uf35f\uf384\uf3a9\uf3ce\uf3f3\uf418\uf43d\uf462", false, "\ue1c4\ue1e9\ue20e\ue233\ue258\ue27d\ue2a2\ue2c7\ue2ec\ue311\ue336\ue35b", false}, {"\uef2f\uef54\uef79\uef9e\uefc3\uefe8\uf00d\uf032\uf057", 1478815255629084104L, "\uf64d\uf672\uf697\uf6bc\uf6e1\uf706\uf72b\uf750", -1373521158, "\ue56b\ue590\ue5b5\ue5da\ue5ff\ue624\ue649\ue66e\ue693\ue6b8\ue6dd\ue702\ue727", true, "\uec89\uecae\uecd3\uecf8\ued1d\ued42\ued67\ued8c\uedb1\uedd6\uedfb\uee20\uee45\uee6a\uee8f\ueeb4\ueed9\ueefe", true, "\uf3a7\uf3cc\uf3f1\uf416\uf43b\uf460\uf485\uf4aa\uf4cf\uf4f4\uf519\uf53e\uf563\uf588\uf5ad\uf5d2", true, "\ue2c5\ue2ea\ue30f\ue334\ue359\ue37e\ue3a3\ue3c8\ue3ed\ue412\ue437\ue45c\ue481\ue4a6\ue4cb\ue4f0", true}, {"\uf030\uf055\uf07a\uf09f\uf0c4\uf0e9\uf10e\uf133", 1478815255629149641L, "\uf74e\uf773\uf798\uf7bd\uf7e2\ue007\ue02c\ue051\ue076\ue09b\ue0c0\ue0e5\ue10a\ue12f\ue154\ue179\ue19e\ue1c3", 2143911299, "\ue66c\ue691\ue6b6\ue6db\ue700\ue725\ue74a\ue76f\ue794\ue7b9\ue7de\ue803\ue828\ue84d\ue872\ue897", false, "\ued8a\uedaf\uedd4\uedf9\uee1e\uee43\uee68\uee8d\ueeb2\ueed7\ueefc\uef21\uef46", false, "\uf4a8\uf4cd\uf4f2\uf517\uf53c\uf561\uf586\uf5ab\uf5d0\uf5f5\uf61a\uf63f", false, "\ue3c6\ue3eb\ue410\ue435\ue45a\ue47f\ue4a4\ue4c9\ue4ee\ue513\ue538\ue55d\ue582\ue5a7\ue5cc\ue5f1\ue616\ue63b", false}, {"\uf131\uf156\uf17b\uf1a0\uf1c5\uf1ea\uf20f\uf234", 1478815255629215178L, "\ue04f\ue074\ue099\ue0be\ue0e3\ue108\ue12d\ue152\ue177\ue19c\ue1c1\ue1e6\ue20b", 829502504, "\ue76d\ue792\ue7b7\ue7dc\ue801\ue826\ue84b\ue870\ue895\ue8ba\ue8df\ue904\ue929\ue94e\ue973\ue998\ue9bd\ue9e2", true, "\uee8b\ueeb0\ueed5\ueefa\uef1f\uef44\uef69\uef8e\uefb3\uefd8\ueffd\uf022\uf047\uf06c\uf091\uf0b6", true, "\uf5a9\uf5ce\uf5f3\uf618\uf63d\uf662\uf687\uf6ac\uf6d1\uf6f6\uf71b\uf740\uf765\uf78a\uf7af\uf7d4", true, "\ue4c7\ue4ec\ue511\ue536\ue55b\ue580\ue5a5\ue5ca\ue5ef\ue614\ue639\ue65e\ue683", true}, {"\uf232\uf257\uf27c\uf2a1\uf2c6\uf2eb\uf310\uf335\uf35a\uf37f\uf3a4\uf3c9\uf3ee\uf413\uf438\uf45d\uf482\uf4a7", 1478815255629280715L, "\ue150\ue175\ue19a\ue1bf\ue1e4\ue209\ue22e\ue253\ue278\ue29d\ue2c2\ue2e7\ue30c\ue331\ue356\ue37b", -2095517967, "\ue86e\ue893\ue8b8\ue8dd\ue902\ue927\ue94c\ue971\ue996\ue9bb\ue9e0\uea05\uea2a", false, "\uef8c\uefb1\uefd6\ueffb\uf020\uf045\uf06a\uf08f\uf0b4\uf0d9\uf0fe\uf123", false, "\uf6aa\uf6cf\uf6f4\uf719\uf73e\uf763\uf788\uf7ad\uf7d2\uf7f7\ue01c\ue041\ue066\ue08b\ue0b0\ue0d5\ue0fa\ue11f", false, "\ue5c8\ue5ed\ue612\ue637\ue65c\ue681\ue6a6\ue6cb\ue6f0\ue715", false}, {"\uf333\uf358\uf37d\uf3a2\uf3c7\uf3ec\uf411\uf436\uf45b\uf480\uf4a5\uf4ca\uf4ef", 1478815255629346252L, "\ue251\ue276\ue29b\ue2c0\ue2e5\ue30a\ue32f\ue354\ue379\ue39e\ue3c3\ue3e8\ue40d\ue432\ue457\ue47c\ue4a1\ue4c6", 1417716118, "\ue96f\ue994\ue9b9\ue9de\uea03\uea28\uea4d\uea72\uea97\ueabc\ueae1\ueb06\ueb2b\ueb50\ueb75\ueb9a", true, "\uf08d\uf0b2\uf0d7\uf0fc\uf121\uf146\uf16b\uf190\uf1b5\uf1da\uf1ff\uf224\uf249\uf26e\uf293\uf2b8", true, "\uf7ab\uf7d0\uf7f5\ue01a\ue03f\ue064\ue089\ue0ae\ue0d3\ue0f8\ue11d\ue142\ue167", true, "\ue6c9\ue6ee\ue713\ue738\ue75d\ue782\ue7a7\ue7cc\ue7f1\ue816\ue83b\ue860\ue885\ue8aa\ue8cf", true}, {"\uf434\uf459\uf47e\uf4a3\uf4c8\uf4ed\uf512\uf537\uf55c\uf581\uf5a6\uf5cb\uf5f0\uf615\uf63a\uf65f", 1478815255629411789L, "\ue352\ue377\ue39c\ue3c1\ue3e6\ue40b\ue430\ue455\ue47a\ue49f\ue4c4\ue4e9\ue50e", 640178239, "\uea70\uea95\ueaba\ueadf\ueb04\ueb29\ueb4e\ueb73\ueb98\uebbd\uebe2\uec07", false, "\uf18e\uf1b3\uf1d8\uf1fd\uf222\uf247\uf26c\uf291\uf2b6\uf2db\uf300\uf325\uf34a\uf36f\uf394\uf3b9\uf3de\uf403", false, "\ue0ac\ue0d1\ue0f6\ue11b\ue140\ue165\ue18a\ue1af\ue1d4\ue1f9", false, "\ue7ca\ue7ef\ue814\ue839\ue85e\ue883\ue8a8\ue8cd\ue8f2\ue917\ue93c", false}, {"\uf535\uf55a\uf57f\uf5a4\uf5c9\uf5ee\uf613\uf638\uf65d\uf682\uf6a7\uf6cc\uf6f1\uf716\uf73b\uf760\uf785\uf7aa", 1478815255629477326L, "\ue453\ue478\ue49d\ue4c2\ue4e7\ue50c\ue531\ue556\ue57b\ue5a0\ue5c5\ue5ea\ue60f\ue634\ue659\ue67e", -137358652, "\ueb71\ueb96\uebbb\uebe0\uec05\uec2a\uec4f\uec74\uec99\uecbe\uece3\ued08\ued2d\ued52\ued77\ued9c", true, "\uf28f\uf2b4\uf2d9\uf2fe\uf323\uf348\uf36d\uf392\uf3b7\uf3dc\uf401\uf426\uf44b", true, "\ue1ad\ue1d2\ue1f7\ue21c\ue241\ue266\ue28b\ue2b0\ue2d5\ue2fa\ue31f\ue344\ue369\ue38e\ue3b3", true, "\ue8cb\ue8f0\ue915\ue93a\ue95f\ue984\ue9a9\ue9ce\ue9f3", true}, {"\uf636\uf65b\uf680\uf6a5\uf6ca\uf6ef\uf714\uf739\uf75e\uf783\uf7a8\uf7cd\uf7f2", 1478815255629542863L, "\ue554\ue579\ue59e\ue5c3\ue5e8\ue60d\ue632\ue657\ue67c\ue6a1\ue6c6\ue6eb", 1232590189, "\uec72\uec97\uecbc\uece1\ued06\ued2b\ued50\ued75\ued9a\uedbf\uede4\uee09\uee2e\uee53\uee78\uee9d\ueec2\ueee7", false, "\uf390\uf3b5\uf3da\uf3ff\uf424\uf449\uf46e\uf493\uf4b8\uf4dd", false, "\ue2ae\ue2d3\ue2f8\ue31d\ue342\ue367\ue38c\ue3b1\ue3d6\ue3fb\ue420", false, "\ue9cc\ue9f1\uea16\uea3b\uea60\uea85\ueaaa\ueacf", false}, {"\uf737\uf75c\uf781\uf7a6\uf7cb\uf7f0\ue015\ue03a\ue05f\ue084\ue0a9\ue0ce\ue0f3\ue118\ue13d\ue162", 1478815255629608400L, "\ue655\ue67a\ue69f\ue6c4\ue6e9\ue70e\ue733\ue758\ue77d\ue7a2\ue7c7\ue7ec\ue811\ue836\ue85b\ue880", 455052338, "\ued73\ued98\uedbd\uede2\uee07\uee2c\uee51\uee76\uee9b\ueec0\ueee5\uef0a\uef2f", true, "\uf491\uf4b6\uf4db\uf500\uf525\uf54a\uf56f\uf594\uf5b9\uf5de\uf603\uf628\uf64d\uf672\uf697", true, "\ue3af\ue3d4\ue3f9\ue41e\ue443\ue468\ue48d\ue4b2\ue4d7", true, "\ueacd\ueaf2\ueb17\ueb3c\ueb61\ueb86\uebab\uebd0", true}, {"\ue038\ue05d\ue082\ue0a7\ue0cc\ue0f1\ue116\ue13b\ue160\ue185\ue1aa\ue1cf", 1478815255629673937L, "\ue756\ue77b\ue7a0\ue7c5\ue7ea\ue80f\ue834\ue859\ue87e\ue8a3\ue8c8\ue8ed\ue912\ue937\ue95c\ue981\ue9a6\ue9cb", -326678821, "\uee74\uee99\ueebe\ueee3\uef08\uef2d\uef52\uef77\uef9c\uefc1", false, "\uf592\uf5b7\uf5dc\uf601\uf626\uf64b\uf670\uf695\uf6ba\uf6df\uf704", false, "\ue4b0\ue4d5\ue4fa\ue51f\ue544\ue569\ue58e\ue5b3", false, "\uebce\uebf3\uec18\uec3d\uec62\uec87\uecac\uecd1\uecf6\ued1b\ued40\ued65\ued8a\uedaf\uedd4\uedf9\uee1e\uee43", false}, {"\ue139\ue15e\ue183\ue1a8\ue1cd\ue1f2\ue217\ue23c\ue261\ue286\ue2ab\ue2d0\ue2f5\ue31a\ue33f\ue364", 1478815255629739474L, "\ue857\ue87c\ue8a1\ue8c6\ue8eb\ue910\ue935\ue95a\ue97f\ue9a4\ue9c9\ue9ee\uea13", -1104184992, "\uef75\uef9a\uefbf\uefe4\uf009\uf02e\uf053\uf078\uf09d\uf0c2\uf0e7\uf10c\uf131\uf156\uf17b", true, "\uf693\uf6b8\uf6dd\uf702\uf727\uf74c\uf771\uf796\uf7bb", true, "\ue5b1\ue5d6\ue5fb\ue620\ue645\ue66a\ue68f\ue6b4", true, "\ueccf\uecf4\ued19\ued3e\ued63\ued88\uedad\uedd2\uedf7\uee1c\uee41\uee66\uee8b", true}, {"\ue23a\ue25f\ue284\ue2a9\ue2ce\ue2f3\ue318\ue33d\ue362\ue387\ue3ac\ue3d1\ue3f6\ue41b\ue440\ue465\ue48a\ue4af", 1478815255629805011L, "\ue958\ue97d\ue9a2\ue9c7\ue9ec\uea11\uea36\uea5b\uea80\ueaa5", 265760777, "\uf076\uf09b\uf0c0\uf0e5\uf10a\uf12f\uf154\uf179\uf19e\uf1c3\uf1e8", false, "\uf794\uf7b9\uf7de\ue003\ue028\ue04d\ue072\ue097", false, "\ue6b2\ue6d7\ue6fc\ue721\ue746\ue76b\ue790\ue7b5\ue7da\ue7ff\ue824\ue849\ue86e\ue893\ue8b8\ue8dd\ue902\ue927", false, "\uedd0\uedf5\uee1a\uee3f\uee64\uee89\ueeae\ueed3\ueef8\uef1d\uef42\uef67\uef8c\uefb1\uefd6\ueffb", false}, {"\ue33b\ue360\ue385\ue3aa\ue3cf\ue3f4\ue419\ue43e\ue463\ue488\ue4ad\ue4d2\ue4f7", 1478815255629870548L, "\uea59\uea7e\ueaa3\ueac8\ueaed\ueb12\ueb37\ueb5c\ueb81\ueba6\uebcb\uebf0\uec15\uec3a\uec5f", -1048646994, "\uf177\uf19c\uf1c1\uf1e6\uf20b\uf230\uf255\uf27a\uf29f", true, "\ue095\ue0ba\ue0df\ue104\ue129\ue14e\ue173\ue198", true, "\ue7b3\ue7d8\ue7fd\ue822\ue847\ue86c\ue891\ue8b6\ue8db\ue900\ue925\ue94a\ue96f", true, "\ueed1\ueef6\uef1b\uef40\uef65\uef8a\uefaf\uefd4\ueff9\uf01e\uf043\uf068\uf08d\uf0b2\uf0d7\uf0fc\uf121\uf146", true}, {"\ue43c\ue461\ue486\ue4ab\ue4d0\ue4f5\ue51a\ue53f\ue564\ue589", 1478815255629936085L, "\ueb5a\ueb7f\ueba4\uebc9\uebee\uec13\uec38\uec5d\uec82\ueca7\ueccc", -1830376073, "\uf278\uf29d\uf2c2\uf2e7\uf30c\uf331\uf356\uf37b", false, "\ue196\ue1bb\ue1e0\ue205\ue22a\ue24f\ue274\ue299\ue2be\ue2e3\ue308\ue32d\ue352\ue377\ue39c\ue3c1\ue3e6\ue40b", false, "\ue8b4\ue8d9\ue8fe\ue923\ue948\ue96d\ue992\ue9b7\ue9dc\uea01\uea26\uea4b\uea70\uea95\ueaba\ueadf", false, "\uefd2\ueff7\uf01c\uf041\uf066\uf08b\uf0b0\uf0d5\uf0fa\uf11f\uf144\uf169\uf18e", false}, {"\ue53d\ue562\ue587\ue5ac\ue5d1\ue5f6\ue61b\ue640\ue665\ue68a\ue6af\ue6d4\ue6f9\ue71e\ue743", 1478815255630001622L, "\uec5b\uec80\ueca5\uecca\uecef\ued14\ued39\ued5e\ued83", 1687053340, "\uf379\uf39e\uf3c3\uf3e8\uf40d\uf432\uf457\uf47c", true, "\ue297\ue2bc\ue2e1\ue306\ue32b\ue350\ue375\ue39a\ue3bf\ue3e4\ue409\ue42e\ue453", true, "\ue9b5\ue9da\ue9ff\uea24\uea49\uea6e\uea93\ueab8\ueadd\ueb02\ueb27\ueb4c\ueb71\ueb96\uebbb\uebe0\uec05\uec2a", true, "\uf0d3\uf0f8\uf11d\uf142\uf167\uf18c\uf1b1\uf1d6\uf1fb\uf220\uf245\uf26a\uf28f\uf2b4\uf2d9\uf2fe", true}, {"\ue63e\ue663\ue688\ue6ad\ue6d2\ue6f7\ue71c\ue741\ue766\ue78b\ue7b0", 1478815255630067159L, "\ued5c\ued81\ueda6\uedcb\uedf0\uee15\uee3a\uee5f", 909516453, "\uf47a\uf49f\uf4c4\uf4e9\uf50e\uf533\uf558\uf57d\uf5a2\uf5c7\uf5ec\uf611\uf636\uf65b\uf680\uf6a5\uf6ca\uf6ef", false, "\ue398\ue3bd\ue3e2\ue407\ue42c\ue451\ue476\ue49b\ue4c0\ue4e5\ue50a\ue52f\ue554\ue579\ue59e\ue5c3", false, "\ueab6\ueadb\ueb00\ueb25\ueb4a\ueb6f\ueb94\uebb9\uebde\uec03\uec28\uec4d\uec72", false, "\uf1d4\uf1f9\uf21e\uf243\uf268\uf28d\uf2b2\uf2d7\uf2fc\uf321\uf346\uf36b", false}, {"\ue73f\ue764\ue789\ue7ae\ue7d3\ue7f8\ue81d\ue842\ue867", 1478815255630132696L, "\uee5d\uee82\ueea7\ueecc\ueef1\uef16\uef3b\uef60", -2015506102, "\uf57b\uf5a0\uf5c5\uf5ea\uf60f\uf634\uf659\uf67e\uf6a3\uf6c8\uf6ed\uf712\uf737", true, "\ue499\ue4be\ue4e3\ue508\ue52d\ue552\ue577\ue59c\ue5c1\ue5e6\ue60b\ue630\ue655\ue67a\ue69f\ue6c4\ue6e9\ue70e", true, "\uebb7\uebdc\uec01\uec26\uec4b\uec70\uec95\uecba\uecdf\ued04\ued29\ued4e\ued73\ued98\uedbd\uede2", true, "\uf2d5\uf2fa\uf31f\uf344\uf369\uf38e\uf3b3\uf3d8\uf3fd\uf422\uf447\uf46c\uf491\uf4b6\uf4db\uf500", true}, {"\ue840\ue865\ue88a\ue8af\ue8d4\ue8f9\ue91e\ue943", 1478815255630198233L, "\uef5e\uef83\uefa8\uefcd\ueff2\uf017\uf03c\uf061\uf086\uf0ab\uf0d0\uf0f5\uf11a\uf13f\uf164\uf189\uf1ae\uf1d3", 1497729043, "\uf67c\uf6a1\uf6c6\uf6eb\uf710\uf735\uf75a\uf77f\uf7a4\uf7c9\uf7ee\ue013\ue038\ue05d\ue082\ue0a7", false, "\ue59a\ue5bf\ue5e4\ue609\ue62e\ue653\ue678\ue69d\ue6c2\ue6e7\ue70c\ue731\ue756", false, "\uecb8\uecdd\ued02\ued27\ued4c\ued71\ued96\uedbb\uede0\uee05\uee2a\uee4f", false, "\uf3d6\uf3fb\uf420\uf445\uf46a\uf48f\uf4b4\uf4d9\uf4fe\uf523\uf548\uf56d\uf592\uf5b7\uf5dc\uf601\uf626\uf64b", false}, {"\ue941\ue966\ue98b\ue9b0\ue9d5\ue9fa\uea1f\uea44", 1478815255630263770L, "\uf05f\uf084\uf0a9\uf0ce\uf0f3\uf118\uf13d\uf162\uf187\uf1ac\uf1d1\uf1f6\uf21b", 720192184, "\uf77d\uf7a2\uf7c7\uf7ec\ue011\ue036\ue05b\ue080\ue0a5\ue0ca\ue0ef\ue114\ue139\ue15e\ue183\ue1a8\ue1cd\ue1f2", true, "\ue69b\ue6c0\ue6e5\ue70a\ue72f\ue754\ue779\ue79e\ue7c3\ue7e8\ue80d\ue832\ue857\ue87c\ue8a1\ue8c6", true, "\uedb9\uedde\uee03\uee28\uee4d\uee72\uee97\ueebc\ueee1\uef06\uef2b\uef50\uef75\uef9a\uefbf\uefe4", true, "\uf4d7\uf4fc\uf521\uf546\uf56b\uf590\uf5b5\uf5da\uf5ff\uf624\uf649\uf66e\uf693", true}, {"\uea42\uea67\uea8c\ueab1\uead6\ueafb\ueb20\ueb45\ueb6a\ueb8f\uebb4\uebd9\uebfe\uec23\uec48\uec6d\uec92\uecb7", 1478815255630329307L, "\uf160\uf185\uf1aa\uf1cf\uf1f4\uf219\uf23e\uf263\uf288\uf2ad\uf2d2\uf2f7\uf31c\uf341\uf366\uf38b", -57342655, "\ue07e\ue0a3\ue0c8\ue0ed\ue112\ue137\ue15c\ue181\ue1a6\ue1cb\ue1f0\ue215\ue23a", false, "\ue79c\ue7c1\ue7e6\ue80b\ue830\ue855\ue87a\ue89f\ue8c4\ue8e9\ue90e\ue933", false, "\ueeba\ueedf\uef04\uef29\uef4e\uef73\uef98\uefbd\uefe2\uf007\uf02c\uf051\uf076\uf09b\uf0c0\uf0e5\uf10a\uf12f", false, "\uf5d8\uf5fd\uf622\uf647\uf66c\uf691\uf6b6\uf6db\uf700\uf725", false}, {"\ueb43\ueb68\ueb8d\uebb2\uebd7\uebfc\uec21\uec46\uec6b\uec90\uecb5\uecda\uecff", 1478815255630394844L, "\uf261\uf286\uf2ab\uf2d0\uf2f5\uf31a\uf33f\uf364\uf389\uf3ae\uf3d3\uf3f8\uf41d\uf442\uf467\uf48c\uf4b1\uf4d6", 1312636902, "\ue17f\ue1a4\ue1c9\ue1ee\ue213\ue238\ue25d\ue282\ue2a7\ue2cc\ue2f1\ue316\ue33b\ue360\ue385\ue3aa", true, "\ue89d\ue8c2\ue8e7\ue90c\ue931\ue956\ue97b\ue9a0\ue9c5\ue9ea\uea0f\uea34\uea59\uea7e\ueaa3\ueac8", true, "\uefbb\uefe0\uf005\uf02a\uf04f\uf074\uf099\uf0be\uf0e3\uf108\uf12d\uf152\uf177", true, "\uf6d9\uf6fe\uf723\uf748\uf76d\uf792\uf7b7\uf7dc\ue001\ue026\ue04b\ue070\ue095\ue0ba\ue0df", true}, {"\uec44\uec69\uec8e\uecb3\uecd8\uecfd\ued22\ued47\ued6c\ued91\uedb6\ueddb\uee00\uee25\uee4a\uee6f", 1478815255630460381L, "\uf362\uf387\uf3ac\uf3d1\uf3f6\uf41b\uf440\uf465\uf48a\uf4af\uf4d4\uf4f9\uf51e", 530904719, "\ue280\ue2a5\ue2ca\ue2ef\ue314\ue339\ue35e\ue383\ue3a8\ue3cd\ue3f2\ue417", false, "\ue99e\ue9c3\ue9e8\uea0d\uea32\uea57\uea7c\ueaa1\ueac6\ueaeb\ueb10\ueb35\ueb5a\ueb7f\ueba4\uebc9\uebee\uec13", false, "\uf0bc\uf0e1\uf106\uf12b\uf150\uf175\uf19a\uf1bf\uf1e4\uf209", false, "\uf7da\uf7ff\ue024\ue049\ue06e\ue093\ue0b8\ue0dd\ue102\ue127\ue14c", false}, {"\ued45\ued6a\ued8f\uedb4\uedd9\uedfe\uee23\uee48\uee6d\uee92\ueeb7\ueedc\uef01\uef26\uef4b\uef70\uef95\uefba", 1478815255630525918L, "\uf463\uf488\uf4ad\uf4d2\uf4f7\uf51c\uf541\uf566\uf58b\uf5b0\uf5d5\uf5fa\uf61f\uf644\uf669\uf68e", -783505068, "\ue381\ue3a6\ue3cb\ue3f0\ue415\ue43a\ue45f\ue484\ue4a9\ue4ce\ue4f3\ue518\ue53d\ue562\ue587\ue5ac", true, "\uea9f\ueac4\ueae9\ueb0e\ueb33\ueb58\ueb7d\ueba2\uebc7\uebec\uec11\uec36\uec5b", true, "\uf1bd\uf1e2\uf207\uf22c\uf251\uf276\uf29b\uf2c0\uf2e5\uf30a\uf32f\uf354\uf379\uf39e\uf3c3", true, "\ue0db\ue100\ue125\ue14a\ue16f\ue194\ue1b9\ue1de\ue203", true}, {"\uee46\uee6b\uee90\ueeb5\ueeda\ueeff\uef24\uef49\uef6e\uef93\uefb8\uefdd\uf002", 1478815255630591455L, "\uf564\uf589\uf5ae\uf5d3\uf5f8\uf61d\uf642\uf667\uf68c\uf6b1\uf6d6\uf6fb", -1561041923, "\ue482\ue4a7\ue4cc\ue4f1\ue516\ue53b\ue560\ue585\ue5aa\ue5cf\ue5f4\ue619\ue63e\ue663\ue688\ue6ad\ue6d2\ue6f7", false, "\ueba0\uebc5\uebea\uec0f\uec34\uec59\uec7e\ueca3\uecc8\ueced", false, "\uf2be\uf2e3\uf308\uf32d\uf352\uf377\uf39c\uf3c1\uf3e6\uf40b\uf430", false, "\ue1dc\ue201\ue226\ue24b\ue270\ue295\ue2ba\ue2df", false}, {"\uef47\uef6c\uef91\uefb6\uefdb\uf000\uf025\uf04a\uf06f\uf094\uf0b9\uf0de\uf103\uf128\uf14d\uf172", 1478815255630656992L, "\uf665\uf68a\uf6af\uf6d4\uf6f9\uf71e\uf743\uf768\uf78d\uf7b2\uf7d7\uf7fc\ue021\ue046\ue06b\ue090", 1956387458, "\ue583\ue5a8\ue5cd\ue5f2\ue617\ue63c\ue661\ue686\ue6ab\ue6d0\ue6f5\ue71a\ue73f", true, "\ueca1\uecc6\ueceb\ued10\ued35\ued5a\ued7f\ueda4\uedc9\uedee\uee13\uee38\uee5d\uee82\ueea7", true, "\uf3bf\uf3e4\uf409\uf42e\uf453\uf478\uf49d\uf4c2\uf4e7", true, "\ue2dd\ue302\ue327\ue34c\ue371\ue396\ue3bb\ue3e0", true}, {"\uf048\uf06d\uf092\uf0b7\uf0dc\uf101\uf126\uf14b\uf170\uf195\uf1ba\uf1df", 1478815255630722529L, "\uf766\uf78b\uf7b0\uf7d5\uf7fa\ue01f\ue044\ue069\ue08e\ue0b3\ue0d8\ue0fd\ue122\ue147\ue16c\ue191\ue1b6\ue1db", -972825301, "\ue684\ue6a9\ue6ce\ue6f3\ue718\ue73d\ue762\ue787\ue7ac\ue7d1", false, "\ueda2\uedc7\uedec\uee11\uee36\uee5b\uee80\ueea5\ueeca\ueeef\uef14", false, "\uf4c0\uf4e5\uf50a\uf52f\uf554\uf579\uf59e\uf5c3", false, "\ue3de\ue403\ue428\ue44d\ue472\ue497\ue4bc\ue4e1\ue506\ue52b\ue550\ue575\ue59a\ue5bf\ue5e4\ue609\ue62e\ue653", false}, {"\uf149\uf16e\uf193\uf1b8\uf1dd\uf202\uf227\uf24c\uf271\uf296\uf2bb\uf2e0\uf305\uf32a\uf34f\uf374", 1478815255630788066L, "\ue067\ue08c\ue0b1\ue0d6\ue0fb\ue120\ue145\ue16a\ue18f\ue1b4\ue1d9\ue1fe\ue223", -1750362128, "\ue785\ue7aa\ue7cf\ue7f4\ue819\ue83e\ue863\ue888\ue8ad\ue8d2\ue8f7\ue91c\ue941\ue966\ue98b", true, "\ueea3\ueec8\ueeed\uef12\uef37\uef5c\uef81\uefa6\uefcb", true, "\uf5c1\uf5e6\uf60b\uf630\uf655\uf67a\uf69f\uf6c4", true, "\ue4df\ue504\ue529\ue54e\ue573\ue598\ue5bd\ue5e2\ue607\ue62c\ue651\ue676\ue69b", true}, {"\uf24a\uf26f\uf294\uf2b9\uf2de\uf303\uf328\uf34d\uf372\uf397\uf3bc\uf3e1\uf406\uf42b\uf450\uf475\uf49a\uf4bf", 1478815255630853603L, "\ue168\ue18d\ue1b2\ue1d7\ue1fc\ue221\ue246\ue26b\ue290\ue2b5", 1767067289, "\ue886\ue8ab\ue8d0\ue8f5\ue91a\ue93f\ue964\ue989\ue9ae\ue9d3\ue9f8", false, "\uefa4\uefc9\uefee\uf013\uf038\uf05d\uf082\uf0a7", false, "\uf6c2\uf6e7\uf70c\uf731\uf756\uf77b\uf7a0\uf7c5\uf7ea\ue00f\ue034\ue059\ue07e\ue0a3\ue0c8\ue0ed\ue112\ue137", false, "\ue5e0\ue605\ue62a\ue64f\ue674\ue699\ue6be\ue6e3\ue708\ue72d\ue752\ue777\ue79c\ue7c1\ue7e6\ue80b", false}, {"\uf34b\uf370\uf395\uf3ba\uf3df\uf404\uf429\uf44e\uf473\uf498\uf4bd\uf4e2\uf507", 1478815255630919140L, "\ue269\ue28e\ue2b3\ue2d8\ue2fd\ue322\ue347\ue36c\ue391\ue3b6\ue3db\ue400\ue425\ue44a\ue46f", 989528382, "\ue987\ue9ac\ue9d1\ue9f6\uea1b\uea40\uea65\uea8a\ueaaf", true, "\uf0a5\uf0ca\uf0ef\uf114\uf139\uf15e\uf183\uf1a8", true, "\uf7c3\uf7e8\ue00d\ue032\ue057\ue07c\ue0a1\ue0c6\ue0eb\ue110\ue135\ue15a\ue17f", true, "\ue6e1\ue706\ue72b\ue750\ue775\ue79a\ue7bf\ue7e4\ue809\ue82e\ue853\ue878\ue89d\ue8c2\ue8e7\ue90c\ue931\ue956", true}, {"\uf44c\uf471\uf496\uf4bb\uf4e0\uf505\uf52a\uf54f\uf574\uf599", 1478815255630984677L, "\ue36a\ue38f\ue3b4\ue3d9\ue3fe\ue423\ue448\ue46d\ue492\ue4b7\ue4dc", -1939653689, "\uea88\ueaad\uead2\ueaf7\ueb1c\ueb41\ueb66\ueb8b", false, "\uf1a6\uf1cb\uf1f0\uf215\uf23a\uf25f\uf284\uf2a9\uf2ce\uf2f3\uf318\uf33d\uf362\uf387\uf3ac\uf3d1\uf3f6\uf41b", false, "\ue0c4\ue0e9\ue10e\ue133\ue158\ue17d\ue1a2\ue1c7\ue1ec\ue211\ue236\ue25b\ue280\ue2a5\ue2ca\ue2ef", false, "\ue7e2\ue807\ue82c\ue851\ue876\ue89b\ue8c0\ue8e5\ue90a\ue92f\ue954\ue979\ue99e", false}, {"\uf54d\uf572\uf597\uf5bc\uf5e1\uf606\uf62b\uf650\uf675\uf69a\uf6bf\uf6e4\uf709\uf72e\uf753", 1478815255631050214L, "\ue46b\ue490\ue4b5\ue4da\ue4ff\ue524\ue549\ue56e\ue593", 1577775724, "\ueb89\uebae\uebd3\uebf8\uec1d\uec42\uec67\uec8c", true, "\uf2a7\uf2cc\uf2f1\uf316\uf33b\uf360\uf385\uf3aa\uf3cf\uf3f4\uf419\uf43e\uf463", true, "\ue1c5\ue1ea\ue20f\ue234\ue259\ue27e\ue2a3\ue2c8\ue2ed\ue312\ue337\ue35c\ue381\ue3a6\ue3cb\ue3f0\ue415\ue43a", true, "\ue8e3\ue908\ue92d\ue952\ue977\ue99c\ue9c1\ue9e6\uea0b\uea30\uea55\uea7a\uea9f\ueac4\ueae9\ueb0e", true}, {"\uf64e\uf673\uf698\uf6bd\uf6e2\uf707\uf72c\uf751\uf776\uf79b\uf7c0", 1478815255631115751L, "\ue56c\ue591\ue5b6\ue5db\ue600\ue625\ue64a\ue66f", 800240949, "\uec8a\uecaf\uecd4\uecf9\ued1e\ued43\ued68\ued8d\uedb2\uedd7\uedfc\uee21\uee46\uee6b\uee90\ueeb5\ueeda\ueeff", false, "\uf3a8\uf3cd\uf3f2\uf417\uf43c\uf461\uf486\uf4ab\uf4d0\uf4f5\uf51a\uf53f\uf564\uf589\uf5ae\uf5d3", false, "\ue2c6\ue2eb\ue310\ue335\ue35a\ue37f\ue3a4\ue3c9\ue3ee\ue413\ue438\ue45d\ue482", false, "\ue9e4\uea09\uea2e\uea53\uea78\uea9d\ueac2\ueae7\ueb0c\ueb31\ueb56\ueb7b", false}, {"\uf74f\uf774\uf799\uf7be\uf7e3\ue008\ue02d\ue052\ue077", 1478815255631181288L, "\ue66d\ue692\ue6b7\ue6dc\ue701\ue726\ue74b\ue770", -514166822, "\ued8b\uedb0\uedd5\uedfa\uee1f\uee44\uee69\uee8e\ueeb3\ueed8\ueefd\uef22\uef47", true, "\uf4a9\uf4ce\uf4f3\uf518\uf53d\uf562\uf587\uf5ac\uf5d1\uf5f6\uf61b\uf640\uf665\uf68a\uf6af\uf6d4\uf6f9\uf71e", true, "\ue3c7\ue3ec\ue411\ue436\ue45b\ue480\ue4a5\ue4ca\ue4ef\ue514\ue539\ue55e\ue583\ue5a8\ue5cd\ue5f2", true, "\ueae5\ueb0a\ueb2f\ueb54\ueb79\ueb9e\uebc3\uebe8\uec0d\uec32\uec57\uec7c\ueca1\uecc6\ueceb\ued10", true}, {"\ue050\ue075\ue09a\ue0bf\ue0e4\ue109\ue12e\ue153", 1478815255631246825L, "\ue76e\ue793\ue7b8\ue7dd\ue802\ue827\ue84c\ue871\ue896\ue8bb\ue8e0\ue905\ue92a\ue94f\ue974\ue999\ue9be\ue9e3", -1295899037, "\uee8c\ueeb1\ueed6\ueefb\uef20\uef45\uef6a\uef8f\uefb4\uefd9\ueffe\uf023\uf048\uf06d\uf092\uf0b7", false, "\uf5aa\uf5cf\uf5f4\uf619\uf63e\uf663\uf688\uf6ad\uf6d2\uf6f7\uf71c\uf741\uf766", false, "\ue4c8\ue4ed\ue512\ue537\ue55c\ue581\ue5a6\ue5cb\ue5f0\ue615\ue63a\ue65f", false, "\uebe6\uec0b\uec30\uec55\uec7a\uec9f\uecc4\uece9\ued0e\ued33\ued58\ued7d\ueda2\uedc7\uedec\uee11\uee36\uee5b", false}, {"\ue151\ue176\ue19b\ue1c0\ue1e5\ue20a\ue22f\ue254", 1478815255631312362L, "\ue86f\ue894\ue8b9\ue8de\ue903\ue928\ue94d\ue972\ue997\ue9bc\ue9e1\uea06\uea2b", 74045704, "\uef8d\uefb2\uefd7\ueffc\uf021\uf046\uf06b\uf090\uf0b5\uf0da\uf0ff\uf124\uf149\uf16e\uf193\uf1b8\uf1dd\uf202", true, "\uf6ab\uf6d0\uf6f5\uf71a\uf73f\uf764\uf789\uf7ae\uf7d3\uf7f8\ue01d\ue042\ue067\ue08c\ue0b1\ue0d6", true, "\ue5c9\ue5ee\ue613\ue638\ue65d\ue682\ue6a7\ue6cc\ue6f1\ue716\ue73b\ue760\ue785\ue7aa\ue7cf\ue7f4", true, "\uece7\ued0c\ued31\ued56\ued7b\ueda0\uedc5\uedea\uee0f\uee34\uee59\uee7e\ueea3", true}, {"\ue252\ue277\ue29c\ue2c1\ue2e6\ue30b\ue330\ue355\ue37a\ue39f\ue3c4\ue3e9\ue40e\ue433\ue458\ue47d\ue4a2\ue4c7", 1478815255631377899L, "\ue970\ue995\ue9ba\ue9df\uea04\uea29\uea4e\uea73\uea98\ueabd\ueae2\ueb07\ueb2c\ueb51\ueb76\ueb9b", -703491119, "\uf08e\uf0b3\uf0d8\uf0fd\uf122\uf147\uf16c\uf191\uf1b6\uf1db\uf200\uf225\uf24a", false, "\uf7ac\uf7d1\uf7f6\ue01b\ue040\ue065\ue08a\ue0af\ue0d4\ue0f9\ue11e\ue143", false, "\ue6ca\ue6ef\ue714\ue739\ue75e\ue783\ue7a8\ue7cd\ue7f2\ue817\ue83c\ue861\ue886\ue8ab\ue8d0\ue8f5\ue91a\ue93f", false, "\uede8\uee0d\uee32\uee57\uee7c\ueea1\ueec6\ueeeb\uef10\uef35", false}, {"\ue353\ue378\ue39d\ue3c2\ue3e7\ue40c\ue431\ue456\ue47b\ue4a0\ue4c5\ue4ea\ue50f", 1478815255631443436L, "\uea71\uea96\ueabb\ueae0\ueb05\ueb2a\ueb4f\ueb74\ueb99\uebbe\uebe3\uec08\uec2d\uec52\uec77\uec9c\uecc1\uece6", -1481029002, "\uf18f\uf1b4\uf1d9\uf1fe\uf223\uf248\uf26d\uf292\uf2b7\uf2dc\uf301\uf326\uf34b\uf370\uf395\uf3ba", true, "\ue0ad\ue0d2\ue0f7\ue11c\ue141\ue166\ue18b\ue1b0\ue1d5\ue1fa\ue21f\ue244\ue269\ue28e\ue2b3\ue2d8", true, "\ue7cb\ue7f0\ue815\ue83a\ue85f\ue884\ue8a9\ue8ce\ue8f3\ue918\ue93d\ue962\ue987", true, "\ueee9\uef0e\uef33\uef58\uef7d\uefa2\uefc7\uefec\uf011\uf036\uf05b\uf080\uf0a5\uf0ca\uf0ef", true}, {"\ue454\ue479\ue49e\ue4c3\ue4e8\ue50d\ue532\ue557\ue57c\ue5a1\ue5c6\ue5eb\ue610\ue635\ue65a\ue67f", 1478815255631508973L, "\ueb72\ueb97\uebbc\uebe1\uec06\uec2b\uec50\uec75\uec9a\uecbf\uece4\ued09\ued2e", 2032209183, "\uf290\uf2b5\uf2da\uf2ff\uf324\uf349\uf36e\uf393\uf3b8\uf3dd\uf402\uf427", false, "\ue1ae\ue1d3\ue1f8\ue21d\ue242\ue267\ue28c\ue2b1\ue2d6\ue2fb\ue320\ue345\ue36a\ue38f\ue3b4\ue3d9\ue3fe\ue423", false, "\ue8cc\ue8f1\ue916\ue93b\ue960\ue985\ue9aa\ue9cf\ue9f4\uea19", false, "\uefea\uf00f\uf034\uf059\uf07e\uf0a3\uf0c8\uf0ed\uf112\uf137\uf15c", false}, {"\ue555\ue57a\ue59f\ue5c4\ue5e9\ue60e\ue633\ue658\ue67d\ue6a2\ue6c7\ue6ec\ue711\ue736\ue75b\ue780\ue7a5\ue7ca", 1478815255631574510L, "\uec73\uec98\uecbd\uece2\ued07\ued2c\ued51\ued76\ued9b\uedc0\uede5\uee0a\uee2f\uee54\uee79\uee9e", -892811356, "\uf391\uf3b6\uf3db\uf400\uf425\uf44a\uf46f\uf494\uf4b9\uf4de\uf503\uf528\uf54d\uf572\uf597\uf5bc", true, "\ue2af\ue2d4\ue2f9\ue31e\ue343\ue368\ue38d\ue3b2\ue3d7\ue3fc\ue421\ue446\ue46b", true, "\ue9cd\ue9f2\uea17\uea3c\uea61\uea86\ueaab\uead0\ueaf5\ueb1a\ueb3f\ueb64\ueb89\uebae\uebd3", true, "\uf0eb\uf110\uf135\uf15a\uf17f\uf1a4\uf1c9\uf1ee\uf213", true}, {"\ue656\ue67b\ue6a0\ue6c5\ue6ea\ue70f\ue734\ue759\ue77e\ue7a3\ue7c8\ue7ed\ue812", 1478815255631640047L, "\ued74\ued99\uedbe\uede3\uee08\uee2d\uee52\uee77\uee9c\ueec1\ueee6\uef0b", -1670316467, "\uf492\uf4b7\uf4dc\uf501\uf526\uf54b\uf570\uf595\uf5ba\uf5df\uf604\uf629\uf64e\uf673\uf698\uf6bd\uf6e2\uf707", false, "\ue3b0\ue3d5\ue3fa\ue41f\ue444\ue469\ue48e\ue4b3\ue4d8\ue4fd", false, "\ueace\ueaf3\ueb18\ueb3d\ueb62\ueb87\uebac\uebd1\uebf6\uec1b\uec40", false, "\uf1ec\uf211\uf236\uf25b\uf280\uf2a5\uf2ca\uf2ef", false}, {"\ue757\ue77c\ue7a1\ue7c6\ue7eb\ue810\ue835\ue85a\ue87f\ue8a4\ue8c9\ue8ee\ue913\ue938\ue95d\ue982", 1478815255631705584L, "\uee75\uee9a\ueebf\ueee4\uef09\uef2e\uef53\uef78\uef9d\uefc2\uefe7\uf00c\uf031\uf056\uf07b\uf0a0", 1847111954, "\uf593\uf5b8\uf5dd\uf602\uf627\uf64c\uf671\uf696\uf6bb\uf6e0\uf705\uf72a\uf74f", true, "\ue4b1\ue4d6\ue4fb\ue520\ue545\ue56a\ue58f\ue5b4\ue5d9\ue5fe\ue623\ue648\ue66d\ue692\ue6b7", true, "\uebcf\uebf4\uec19\uec3e\uec63\uec88\uecad\uecd2\uecf7", true, "\uf2ed\uf312\uf337\uf35c\uf381\uf3a6\uf3cb\uf3f0", true}, {"\ue858\ue87d\ue8a2\ue8c7\ue8ec\ue911\ue936\ue95b\ue980\ue9a5\ue9ca\ue9ef", 1478815255631771121L, "\uef76\uef9b\uefc0\uefe5\uf00a\uf02f\uf054\uf079\uf09e\uf0c3\uf0e8\uf10d\uf132\uf157\uf17c\uf1a1\uf1c6\uf1eb", 1065380795, "\uf694\uf6b9\uf6de\uf703\uf728\uf74d\uf772\uf797\uf7bc\uf7e1", false, "\ue5b2\ue5d7\ue5fc\ue621\ue646\ue66b\ue690\ue6b5\ue6da\ue6ff\ue724", false, "\uecd0\uecf5\ued1a\ued3f\ued64\ued89\uedae\uedd3", false, "\uf3ee\uf413\uf438\uf45d\uf482\uf4a7\uf4cc\uf4f1\uf516\uf53b\uf560\uf585\uf5aa\uf5cf\uf5f4\uf619\uf63e\uf663", false}, {"\ue959\ue97e\ue9a3\ue9c8\ue9ed\uea12\uea37\uea5c\uea81\ueaa6\ueacb\ueaf0\ueb15\ueb3a\ueb5f\ueb84", 1478815255631836658L, "\uf077\uf09c\uf0c1\uf0e6\uf10b\uf130\uf155\uf17a\uf19f\uf1c4\uf1e9\uf20e\uf233", -249028032, "\uf795\uf7ba\uf7df\ue004\ue029\ue04e\ue073\ue098\ue0bd\ue0e2\ue107\ue12c\ue151\ue176\ue19b", true, "\ue6b3\ue6d8\ue6fd\ue722\ue747\ue76c\ue791\ue7b6\ue7db", true, "\uedd1\uedf6\uee1b\uee40\uee65\uee8a\ueeaf\ueed4", true, "\uf4ef\uf514\uf539\uf55e\uf583\uf5a8\uf5cd\uf5f2\uf617\uf63c\uf661\uf686\uf6ab", true}, {"\uea5a\uea7f\ueaa4\ueac9\ueaee\ueb13\ueb38\ueb5d\ueb82\ueba7\uebcc\uebf1\uec16\uec3b\uec60\uec85\uecaa\ueccf", 1478815255631902195L, "\uf178\uf19d\uf1c2\uf1e7\uf20c\uf231\uf256\uf27b\uf2a0\uf2c5", 1120920809, "\ue096\ue0bb\ue0e0\ue105\ue12a\ue14f\ue174\ue199\ue1be\ue1e3\ue208", false, "\ue7b4\ue7d9\ue7fe\ue823\ue848\ue86d\ue892\ue8b7", false, "\ueed2\ueef7\uef1c\uef41\uef66\uef8b\uefb0\uefd5\ueffa\uf01f\uf044\uf069\uf08e\uf0b3\uf0d8\uf0fd\uf122\uf147", false, "\uf5f0\uf615\uf63a\uf65f\uf684\uf6a9\uf6ce\uf6f3\uf718\uf73d\uf762\uf787\uf7ac\uf7d1\uf7f6\ue01b", false}, {"\ueb5b\ueb80\ueba5\uebca\uebef\uec14\uec39\uec5e\uec83\ueca8\ueccd\uecf2\ued17", 1478815255631967732L, "\uf279\uf29e\uf2c3\uf2e8\uf30d\uf332\uf357\uf37c\uf3a1\uf3c6\uf3eb\uf410\uf435\uf45a\uf47f", 343383950, "\ue197\ue1bc\ue1e1\ue206\ue22b\ue250\ue275\ue29a\ue2bf", true, "\ue8b5\ue8da\ue8ff\ue924\ue949\ue96e\ue993\ue9b8", true, "\uefd3\ueff8\uf01d\uf042\uf067\uf08c\uf0b1\uf0d6\uf0fb\uf120\uf145\uf16a\uf18f", true, "\uf6f1\uf716\uf73b\uf760\uf785\uf7aa\uf7cf\uf7f4\ue019\ue03e\ue063\ue088\ue0ad\ue0d2\ue0f7\ue11c\ue141\ue166", true}, {"\uec5c\uec81\ueca6\ueccb\uecf0\ued15\ued3a\ued5f\ued84\ueda9", 1478815255632033269L, "\uf37a\uf39f\uf3c4\uf3e9\uf40e\uf433\uf458\uf47d\uf4a2\uf4c7\uf4ec", -434153897, "\ue298\ue2bd\ue2e2\ue307\ue32c\ue351\ue376\ue39b", false, "\ue9b6\ue9db\uea00\uea25\uea4a\uea6f\uea94\ueab9\ueade\ueb03\ueb28\ueb4d\ueb72\ueb97\uebbc\uebe1\uec06\uec2b", false, "\uf0d4\uf0f9\uf11e\uf143\uf168\uf18d\uf1b2\uf1d7\uf1fc\uf221\uf246\uf26b\uf290\uf2b5\uf2da\uf2ff", false, "\uf7f2\ue017\ue03c\ue061\ue086\ue0ab\ue0d0\ue0f5\ue11a\ue13f\ue164\ue189\ue1ae", false}, {"\ued5d\ued82\ueda7\uedcc\uedf1\uee16\uee3b\uee60\uee85\ueeaa\ueecf\ueef4\uef19\uef3e\uef63", 1478815255632098806L, "\uf47b\uf4a0\uf4c5\uf4ea\uf50f\uf534\uf559\uf57e\uf5a3", -1215887108, "\ue399\ue3be\ue3e3\ue408\ue42d\ue452\ue477\ue49c", true, "\ueab7\ueadc\ueb01\ueb26\ueb4b\ueb70\ueb95\uebba\uebdf\uec04\uec29\uec4e\uec73", true, "\uf1d5\uf1fa\uf21f\uf244\uf269\uf28e\uf2b3\uf2d8\uf2fd\uf322\uf347\uf36c\uf391\uf3b6\uf3db\uf400\uf425\uf44a", true, "\ue0f3\ue118\ue13d\ue162\ue187\ue1ac\ue1d1\ue1f6\ue21b\ue240\ue265\ue28a\ue2af\ue2d4\ue2f9\ue31e", true}, {"\uee5e\uee83\ueea8\ueecd\ueef2\uef17\uef3c\uef61\uef86\uefab\uefd0", 1478815255632164343L, "\uf57c\uf5a1\uf5c6\uf5eb\uf610\uf635\uf65a\uf67f", 154059653, "\ue49a\ue4bf\ue4e4\ue509\ue52e\ue553\ue578\ue59d\ue5c2\ue5e7\ue60c\ue631\ue656\ue67b\ue6a0\ue6c5\ue6ea\ue70f", false, "\uebb8\uebdd\uec02\uec27\uec4c\uec71\uec96\uecbb\uece0\ued05\ued2a\ued4f\ued74\ued99\uedbe\uede3", false, "\uf2d6\uf2fb\uf320\uf345\uf36a\uf38f\uf3b4\uf3d9\uf3fe\uf423\uf448\uf46d\uf492", false, "\ue1f4\ue219\ue23e\ue263\ue288\ue2ad\ue2d2\ue2f7\ue31c\ue341\ue366\ue38b", false}, {"\uef5f\uef84\uefa9\uefce\ueff3\uf018\uf03d\uf062\uf087", 1478815255632229880L, "\uf67d\uf6a2\uf6c7\uf6ec\uf711\uf736\uf75b\uf780", -623445462, "\ue59b\ue5c0\ue5e5\ue60a\ue62f\ue654\ue679\ue69e\ue6c3\ue6e8\ue70d\ue732\ue757", true, "\uecb9\uecde\ued03\ued28\ued4d\ued72\ued97\uedbc\uede1\uee06\uee2b\uee50\uee75\uee9a\ueebf\ueee4\uef09\uef2e", true, "\uf3d7\uf3fc\uf421\uf446\uf46b\uf490\uf4b5\uf4da\uf4ff\uf524\uf549\uf56e\uf593\uf5b8\uf5dd\uf602", true, "\ue2f5\ue31a\ue33f\ue364\ue389\ue3ae\ue3d3\ue3f8\ue41d\ue442\ue467\ue48c\ue4b1\ue4d6\ue4fb\ue520", true}, {"\uf060\uf085\uf0aa\uf0cf\uf0f4\uf119\uf13e\uf163", 1478815255632295417L, "\uf77e\uf7a3\uf7c8\uf7ed\ue012\ue037\ue05c\ue081\ue0a6\ue0cb\ue0f0\ue115\ue13a\ue15f\ue184\ue1a9\ue1ce\ue1f3", -1400980237, "\ue69c\ue6c1\ue6e6\ue70b\ue730\ue755\ue77a\ue79f\ue7c4\ue7e9\ue80e\ue833\ue858\ue87d\ue8a2\ue8c7", false, "\uedba\ueddf\uee04\uee29\uee4e\uee73\uee98\ueebd\ueee2\uef07\uef2c\uef51\uef76", false, "\uf4d8\uf4fd\uf522\uf547\uf56c\uf591\uf5b6\uf5db\uf600\uf625\uf64a\uf66f", false, "\ue3f6\ue41b\ue440\ue465\ue48a\ue4af\ue4d4\ue4f9\ue51e\ue543\ue568\ue58d\ue5b2\ue5d7\ue5fc\ue621\ue646\ue66b", false}, {"\uf161\uf186\uf1ab\uf1d0\uf1f5\uf21a\uf23f\uf264", 1478815255632360954L, "\ue07f\ue0a4\ue0c9\ue0ee\ue113\ue138\ue15d\ue182\ue1a7\ue1cc\ue1f1\ue216\ue23b", 2112255896, "\ue79d\ue7c2\ue7e7\ue80c\ue831\ue856\ue87b\ue8a0\ue8c5\ue8ea\ue90f\ue934\ue959\ue97e\ue9a3\ue9c8\ue9ed\uea12", true, "\ueebb\ueee0\uef05\uef2a\uef4f\uef74\uef99\uefbe\uefe3\uf008\uf02d\uf052\uf077\uf09c\uf0c1\uf0e6", true, "\uf5d9\uf5fe\uf623\uf648\uf66d\uf692\uf6b7\uf6dc\uf701\uf726\uf74b\uf770\uf795\uf7ba\uf7df\ue004", true, "\ue4f7\ue51c\ue541\ue566\ue58b\ue5b0\ue5d5\ue5fa\ue61f\ue644\ue669\ue68e\ue6b3", true}, {"\uf262\uf287\uf2ac\uf2d1\uf2f6\uf31b\uf340\uf365\uf38a\uf3af\uf3d4\uf3f9\uf41e\uf443\uf468\uf48d\uf4b2\uf4d7", 1478815255632426491L, "\ue180\ue1a5\ue1ca\ue1ef\ue214\ue239\ue25e\ue283\ue2a8\ue2cd\ue2f2\ue317\ue33c\ue361\ue386\ue3ab", -812765663, "\ue89e\ue8c3\ue8e8\ue90d\ue932\ue957\ue97c\ue9a1\ue9c6\ue9eb\uea10\uea35\uea5a", false, "\uefbc\uefe1\uf006\uf02b\uf050\uf075\uf09a\uf0bf\uf0e4\uf109\uf12e\uf153", false, "\uf6da\uf6ff\uf724\uf749\uf76e\uf793\uf7b8\uf7dd\ue002\ue027\ue04c\ue071\ue096\ue0bb\ue0e0\ue105\ue12a\ue14f", false, "\ue5f8\ue61d\ue642\ue667\ue68c\ue6b1\ue6d6\ue6fb\ue720\ue745", false}, {"\uf363\uf388\uf3ad\uf3d2\uf3f7\uf41c\uf441\uf466\uf48b\uf4b0\uf4d5\uf4fa\uf51f", 1478815255632492028L, "\ue281\ue2a6\ue2cb\ue2f0\ue315\ue33a\ue35f\ue384\ue3a9\ue3ce\ue3f3\ue418\ue43d\ue462\ue487\ue4ac\ue4d1\ue4f6", -2127175482, "\ue99f\ue9c4\ue9e9\uea0e\uea33\uea58\uea7d\ueaa2\ueac7\ueaec\ueb11\ueb36\ueb5b\ueb80\ueba5\uebca", true, "\uf0bd\uf0e2\uf107\uf12c\uf151\uf176\uf19b\uf1c0\uf1e5\uf20a\uf22f\uf254\uf279\uf29e\uf2c3\uf2e8", true, "\uf7db\ue000\ue025\ue04a\ue06f\ue094\ue0b9\ue0de\ue103\ue128\ue14d\ue172\ue197", true, "\ue6f9\ue71e\ue743\ue768\ue78d\ue7b2\ue7d7\ue7fc\ue821\ue846\ue86b\ue890\ue8b5\ue8da\ue8ff", true}, {"\uf464\uf489\uf4ae\uf4d3\uf4f8\uf51d\uf542\uf567\uf58c\uf5b1\uf5d6\uf5fb\uf620\uf645\uf66a\uf68f", 1478815255632557565L, "\ue382\ue3a7\ue3cc\ue3f1\ue416\ue43b\ue460\ue485\ue4aa\ue4cf\ue4f4\ue519\ue53e", 1390254959, "\ueaa0\ueac5\ueaea\ueb0f\ueb34\ueb59\ueb7e\ueba3\uebc8\uebed\uec12\uec37", false, "\uf1be\uf1e3\uf208\uf22d\uf252\uf277\uf29c\uf2c1\uf2e6\uf30b\uf330\uf355\uf37a\uf39f\uf3c4\uf3e9\uf40e\uf433", false, "\ue0dc\ue101\ue126\ue14b\ue170\ue195\ue1ba\ue1df\ue204\ue229", false, "\ue7fa\ue81f\ue844\ue869\ue88e\ue8b3\ue8d8\ue8fd\ue922\ue947\ue96c", false}, {"\uf565\uf58a\uf5af\uf5d4\uf5f9\uf61e\uf643\uf668\uf68d\uf6b2\uf6d7\uf6fc\uf721\uf746\uf76b\uf790\uf7b5\uf7da", 1478815255632623102L, "\ue483\ue4a8\ue4cd\ue4f2\ue517\ue53c\ue561\ue586\ue5ab\ue5d0\ue5f5\ue61a\ue63f\ue664\ue689\ue6ae", 608522804, "\ueba1\uebc6\uebeb\uec10\uec35\uec5a\uec7f\ueca4\uecc9\uecee\ued13\ued38\ued5d\ued82\ueda7\uedcc", true, "\uf2bf\uf2e4\uf309\uf32e\uf353\uf378\uf39d\uf3c2\uf3e7\uf40c\uf431\uf456\uf47b", true, "\ue1dd\ue202\ue227\ue24c\ue271\ue296\ue2bb\ue2e0\ue305\ue32a\ue34f\ue374\ue399\ue3be\ue3e3", true, "\ue8fb\ue920\ue945\ue96a\ue98f\ue9b4\ue9d9\ue9fe\uea23", true}, {"\uf666\uf68b\uf6b0\uf6d5\uf6fa\uf71f\uf744\uf769\uf78e\uf7b3\uf7d8\uf7fd\ue022", 1478815255632688639L, "\ue584\ue5a9\ue5ce\ue5f3\ue618\ue63d\ue662\ue687\ue6ac\ue6d1\ue6f6\ue71b", -169012003, "\ueca2\uecc7\uecec\ued11\ued36\ued5b\ued80\ueda5\uedca\uedef\uee14\uee39\uee5e\uee83\ueea8\ueecd\ueef2\uef17", false, "\uf3c0\uf3e5\uf40a\uf42f\uf454\uf479\uf49e\uf4c3\uf4e8\uf50d", false, "\ue2de\ue303\ue328\ue34d\ue372\ue397\ue3bc\ue3e1\ue406\ue42b\ue450", false, "\ue9fc\uea21\uea46\uea6b\uea90\ueab5\ueada\ueaff", false}, {"\uf767\uf78c\uf7b1\uf7d6\uf7fb\ue020\ue045\ue06a\ue08f\ue0b4\ue0d9\ue0fe\ue123\ue148\ue16d\ue192", 1478815255632754176L, "\ue685\ue6aa\ue6cf\ue6f4\ue719\ue73e\ue763\ue788\ue7ad\ue7d2\ue7f7\ue81c\ue841\ue866\ue88b\ue8b0", 1200934754, "\ueda3\uedc8\ueded\uee12\uee37\uee5c\uee81\ueea6\ueecb\ueef0\uef15\uef3a\uef5f", true, "\uf4c1\uf4e6\uf50b\uf530\uf555\uf57a\uf59f\uf5c4\uf5e9\uf60e\uf633\uf658\uf67d\uf6a2\uf6c7", true, "\ue3df\ue404\ue429\ue44e\ue473\ue498\ue4bd\ue4e2\ue507", true, "\ueafd\ueb22\ueb47\ueb6c\ueb91\uebb6\uebdb\uec00", true}, {"\ue068\ue08d\ue0b2\ue0d7\ue0fc\ue121\ue146\ue16b\ue190\ue1b5\ue1da\ue1ff", 1478815255632819713L, "\ue786\ue7ab\ue7d0\ue7f5\ue81a\ue83f\ue864\ue889\ue8ae\ue8d3\ue8f8\ue91d\ue942\ue967\ue98c\ue9b1\ue9d6\ue9fb", 423396875, "\ueea4\ueec9\ueeee\uef13\uef38\uef5d\uef82\uefa7\uefcc\ueff1", false, "\uf5c2\uf5e7\uf60c\uf631\uf656\uf67b\uf6a0\uf6c5\uf6ea\uf70f\uf734", false, "\ue4e0\ue505\ue52a\ue54f\ue574\ue599\ue5be\ue5e3", false, "\uebfe\uec23\uec48\uec6d\uec92\uecb7\uecdc\ued01\ued26\ued4b\ued70\ued95\uedba\ueddf\uee04\uee29\uee4e\uee73", false}, {"\ue169\ue18e\ue1b3\ue1d8\ue1fd\ue222\ue247\ue26c\ue291\ue2b6\ue2db\ue300\ue325\ue34a\ue36f\ue394", 1478815255632885250L, "\ue887\ue8ac\ue8d1\ue8f6\ue91b\ue940\ue965\ue98a\ue9af\ue9d4\ue9f9\uea1e\uea43", -358303536, "\uefa5\uefca\uefef\uf014\uf039\uf05e\uf083\uf0a8\uf0cd\uf0f2\uf117\uf13c\uf161\uf186\uf1ab", true, "\uf6c3\uf6e8\uf70d\uf732\uf757\uf77c\uf7a1\uf7c6\uf7eb", true, "\ue5e1\ue606\ue62b\ue650\ue675\ue69a\ue6bf\ue6e4", true, "\uecff\ued24\ued49\ued6e\ued93\uedb8\ueddd\uee02\uee27\uee4c\uee71\uee96\ueebb", true}, {"\ue26a\ue28f\ue2b4\ue2d9\ue2fe\ue323\ue348\ue36d\ue392\ue3b7\ue3dc\ue401\ue426\ue44b\ue470\ue495\ue4ba\ue4df", 1478815255632950787L, "\ue988\ue9ad\ue9d2\ue9f7\uea1c\uea41\uea66\uea8b\ueab0\uead5", -1135840391, "\uf0a6\uf0cb\uf0f0\uf115\uf13a\uf15f\uf184\uf1a9\uf1ce\uf1f3\uf218", false, "\uf7c4\uf7e9\ue00e\ue033\ue058\ue07d\ue0a2\ue0c7", false, "\ue6e2\ue707\ue72c\ue751\ue776\ue79b\ue7c0\ue7e5\ue80a\ue82f\ue854\ue879\ue89e\ue8c3\ue8e8\ue90d\ue932\ue957", false, "\uee00\uee25\uee4a\uee6f\uee94\ueeb9\ueede\uef03\uef28\uef4d\uef72\uef97\uefbc\uefe1\uf006\uf02b", false}, {"\ue36b\ue390\ue3b5\ue3da\ue3ff\ue424\ue449\ue46e\ue493\ue4b8\ue4dd\ue502\ue527", 1478815255633016324L, "\uea89\ueaae\uead3\ueaf8\ueb1d\ueb42\ueb67\ueb8c\uebb1\uebd6\uebfb\uec20\uec45\uec6a\uec8f", 234105374, "\uf1a7\uf1cc\uf1f1\uf216\uf23b\uf260\uf285\uf2aa\uf2cf", true, "\ue0c5\ue0ea\ue10f\ue134\ue159\ue17e\ue1a3\ue1c8", true, "\ue7e3\ue808\ue82d\ue852\ue877\ue89c\ue8c1\ue8e6\ue90b\ue930\ue955\ue97a\ue99f", true, "\uef01\uef26\uef4b\uef70\uef95\uefba\uefdf\uf004\uf029\uf04e\uf073\uf098\uf0bd\uf0e2\uf107\uf12c\uf151\uf176", true}, {"\ue46c\ue491\ue4b6\ue4db\ue500\ue525\ue54a\ue56f\ue594\ue5b9", 1478815255633081861L, "\ueb8a\uebaf\uebd4\uebf9\uec1e\uec43\uec68\uec8d\uecb2\uecd7\uecfc", -543429465, "\uf2a8\uf2cd\uf2f2\uf317\uf33c\uf361\uf386\uf3ab", false, "\ue1c6\ue1eb\ue210\ue235\ue25a\ue27f\ue2a4\ue2c9\ue2ee\ue313\ue338\ue35d\ue382\ue3a7\ue3cc\ue3f1\ue416\ue43b", false, "\ue8e4\ue909\ue92e\ue953\ue978\ue99d\ue9c2\ue9e7\uea0c\uea31\uea56\uea7b\ueaa0\ueac5\ueaea\ueb0f", false, "\uf002\uf027\uf04c\uf071\uf096\uf0bb\uf0e0\uf105\uf12a\uf14f\uf174\uf199\uf1be", false}, {"\ue56d\ue592\ue5b7\ue5dc\ue601\ue626\ue64b\ue670\ue695\ue6ba\ue6df\ue704\ue729\ue74e\ue773", 1478815255633147398L, "\uec8b\uecb0\uecd5\uecfa\ued1f\ued44\ued69\ued8e\uedb3", -1862031540, "\uf3a9\uf3ce\uf3f3\uf418\uf43d\uf462\uf487\uf4ac", true, "\ue2c7\ue2ec\ue311\ue336\ue35b\ue380\ue3a5\ue3ca\ue3ef\ue414\ue439\ue45e\ue483", true, "\ue9e5\uea0a\uea2f\uea54\uea79\uea9e\ueac3\ueae8\ueb0d\ueb32\ueb57\ueb7c\ueba1\uebc6\uebeb\uec10\uec35\uec5a", true, "\uf103\uf128\uf14d\uf172\uf197\uf1bc\uf1e1\uf206\uf22b\uf250\uf275\uf29a\uf2bf\uf2e4\uf309\uf32e", true}, {"\ue66e\ue693\ue6b8\ue6dd\ue702\ue727\ue74c\ue771\ue796\ue7bb\ue7e0", 1478815255633212935L, "\ued8c\uedb1\uedd6\uedfb\uee20\uee45\uee6a\uee8f", 1655397909, "\uf4aa\uf4cf\uf4f4\uf519\uf53e\uf563\uf588\uf5ad\uf5d2\uf5f7\uf61c\uf641\uf666\uf68b\uf6b0\uf6d5\uf6fa\uf71f", false, "\ue3c8\ue3ed\ue412\ue437\ue45c\ue481\ue4a6\ue4cb\ue4f0\ue515\ue53a\ue55f\ue584\ue5a9\ue5ce\ue5f3", false, "\ueae6\ueb0b\ueb30\ueb55\ueb7a\ueb9f\uebc4\uebe9\uec0e\uec33\uec58\uec7d\ueca2", false, "\uf204\uf229\uf24e\uf273\uf298\uf2bd\uf2e2\uf307\uf32c\uf351\uf376\uf39b", false}, {"\ue76f\ue794\ue7b9\ue7de\ue803\ue828\ue84d\ue872\ue897", 1478815255633278472L, "\uee8d\ueeb2\ueed7\ueefc\uef21\uef46\uef6b\uef90", 877859002, "\uf5ab\uf5d0\uf5f5\uf61a\uf63f\uf664\uf689\uf6ae\uf6d3\uf6f8\uf71d\uf742\uf767", true, "\ue4c9\ue4ee\ue513\ue538\ue55d\ue582\ue5a7\ue5cc\ue5f1\ue616\ue63b\ue660\ue685\ue6aa\ue6cf\ue6f4\ue719\ue73e", true, "\uebe7\uec0c\uec31\uec56\uec7b\ueca0\uecc5\uecea\ued0f\ued34\ued59\ued7e\ueda3\uedc8\ueded\uee12", true, "\uf305\uf32a\uf34f\uf374\uf399\uf3be\uf3e3\uf408\uf42d\uf452\uf477\uf49c\uf4c1\uf4e6\uf50b\uf530", true}, {"\ue870\ue895\ue8ba\ue8df\ue904\ue929\ue94e\ue973", 1478815255633344009L, "\uef8e\uefb3\uefd8\ueffd\uf022\uf047\uf06c\uf091\uf0b6\uf0db\uf100\uf125\uf14a\uf16f\uf194\uf1b9\uf1de\uf203", -2047161533, "\uf6ac\uf6d1\uf6f6\uf71b\uf740\uf765\uf78a\uf7af\uf7d4\uf7f9\ue01e\ue043\ue068\ue08d\ue0b2\ue0d7", false, "\ue5ca\ue5ef\ue614\ue639\ue65e\ue683\ue6a8\ue6cd\ue6f2\ue717\ue73c\ue761\ue786", false, "\uece8\ued0d\ued32\ued57\ued7c\ueda1\uedc6\uedeb\uee10\uee35\uee5a\uee7f", false, "\uf406\uf42b\uf450\uf475\uf49a\uf4bf\uf4e4\uf509\uf52e\uf553\uf578\uf59d\uf5c2\uf5e7\uf60c\uf631\uf656\uf67b", false}, {"\ue971\ue996\ue9bb\ue9e0\uea05\uea2a\uea4f\uea74", 1478815255633409546L, "\uf08f\uf0b4\uf0d9\uf0fe\uf123\uf148\uf16d\uf192\uf1b7\uf1dc\uf201\uf226\uf24b", 1466076648, "\uf7ad\uf7d2\uf7f7\ue01c\ue041\ue066\ue08b\ue0b0\ue0d5\ue0fa\ue11f\ue144\ue169\ue18e\ue1b3\ue1d8\ue1fd\ue222", true, "\ue6cb\ue6f0\ue715\ue73a\ue75f\ue784\ue7a9\ue7ce\ue7f3\ue818\ue83d\ue862\ue887\ue8ac\ue8d1\ue8f6", true, "\uede9\uee0e\uee33\uee58\uee7d\ueea2\ueec7\ueeec\uef11\uef36\uef5b\uef80\uefa5\uefca\uefef\uf014", true, "\uf507\uf52c\uf551\uf576\uf59b\uf5c0\uf5e5\uf60a\uf62f\uf654\uf679\uf69e\uf6c3", true}};
        byte[] v0 = "\u00c6*\u0097\u00cb\u00c2\u00cc\te\u00a0q\u00aed\u00cd\u00fe\u0019o\u00f6\u0090\u00f9X5\u00c4\u00faNe\u0018\u00e3\u00fc\u008c\f\u00c5\u00de\u0093\u00c4x\u0000d4(\u00d4\u00c9,\u00f9J\u0014\u00e9\u00cf\u00fb\u00fah%%\u00ad\u00db\u00c0?5[/?]\u00fc\u009d\u00d6\u0007\u00cdz\t\u00ae\u00fe\u00e4\u00af_m#x]L\u001bE\u0085\u0016\u00cc\u00c5\u00b1\u00e9\u00fa\u00f14\u0013\u009a\u00c4)t\u00ce\u00fa>lx\u00ed\u0015\b\u001b@e\u00e2`V\u00b1>U2)&$y4\u008a\u00f5\u00c1\u00a7:\u00fc\u00a9\n\u00a2\u0082M\u00e4\u00c0\u00d8:V\u00b8\u00b4  \u00e6\u00ee\u00b3m\u00aau\u0013\u0002\\\u00afC\u008dm\u00af'".getBytes("ISO_8859_1");
        Object[] v1 = "\u0086\u0017C\u00a0\u00e8\u00f8M|".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> 1382101265;
                case 1 -> -1397388422;
                case 2 -> 1249192550;
                case 3 -> 2036959196;
                case 4 -> 1778333959;
                case 5 -> 1874707641;
                case 6 -> 1065943793;
                case 7 -> 165985082;
                case 8 -> 1355228842;
                case 9 -> -659351092;
                case 10 -> -701920188;
                case 11 -> -717275875;
                case 12 -> -838778348;
                case 13 -> -1574847482;
                case 14 -> -2044346104;
                case 15 -> -921938237;
                case 16 -> -666131907;
                case 17 -> -785055003;
                case 18 -> -1613521243;
                case 19 -> 745562752;
                case 20 -> -1860719978;
                case 21 -> 724529703;
                case 22 -> 693497644;
                case 23 -> -658125040;
                case 24 -> -609732188;
                case 25 -> -1735980406;
                case 26 -> 32554882;
                case 27 -> 1814633481;
                case 28 -> 2054243614;
                case 29 -> -438835371;
                case 30 -> -370453080;
                case 31 -> -248396978;
                case 32 -> 712180003;
                case 33 -> -1388321840;
                case 34 -> 33164023;
                case 35 -> 1259873953;
                case 36 -> 1261953927;
                case 37 -> -354819648;
                case 38 -> 1310282338;
                case 39 -> -1494814092;
                case 40 -> 348003395;
                case 41 -> 1832376896;
                case 42 -> 409388156;
                case 43 -> 861441696;
                case 44 -> -804631241;
                case 45 -> -752428195;
                case 46 -> 1833891;
                case 47 -> 1206355369;
                case 48 -> -1263886779;
                case 49 -> 2063110378;
                case 50 -> -1969577637;
                case 51 -> -358414604;
                case 52 -> 38699654;
                case 53 -> -784201369;
                case 54 -> 532152184;
                case 55 -> -1446582774;
                case 56 -> 1258862024;
                case 57 -> -172504277;
                case 58 -> 443143494;
                case 59 -> 69780621;
                case 60 -> 504780623;
                case 61 -> 550203416;
                case 62 -> -1696765947;
                case 63 -> 142749270;
                case 64 -> -446747602;
                case 65 -> -2077273745;
                case 66 -> -635635623;
                case 67 -> 1908012683;
                case 68 -> -1366271761;
                case 69 -> 1068042498;
                case 70 -> 553066732;
                case 71 -> -1009970082;
                case 72 -> 888419774;
                case 73 -> 719573585;
                case 74 -> 656324863;
                case 75 -> -602293168;
                case 76 -> 406782183;
                case 77 -> -1602226757;
                case 78 -> 1806782613;
                case 79 -> -19562431;
                case 80 -> 397512137;
                case 81 -> -1498617818;
                case 82 -> 683498229;
                case 83 -> -996032882;
                case 84 -> 359677474;
                case 85 -> 175096137;
                case 86 -> 1732282481;
                case 87 -> -457204834;
                case 88 -> -721558182;
                case 89 -> -1936711420;
                case 90 -> -1280700709;
                case 91 -> -728282169;
                case 92 -> -290500638;
                case 93 -> -1505641237;
                case 94 -> 997439738;
                case 95 -> -1705215192;
                case 96 -> 2045093625;
                case 97 -> -1069474279;
                case 98 -> 505418216;
                case 99 -> 684984537;
                case 100 -> -164961617;
                case 101 -> -847357156;
                case 102 -> 1444610196;
                case 103 -> -1277337916;
                case 104 -> 288160107;
                case 105 -> -354894547;
                case 106 -> 1675469109;
                case 107 -> -626773199;
                case 108 -> -230061033;
                case 109 -> 203074812;
                case 110 -> 1586316246;
                case 111 -> 1535470920;
                case 112 -> -1390072686;
                case 113 -> 2073384637;
                case 114 -> -195510648;
                case 115 -> -2130939829;
                case 116 -> -1327065940;
                case 117 -> 1773132974;
                case 118 -> 1767283003;
                case 119 -> 882645657;
                case 120 -> 1516198954;
                case 121 -> 1689651548;
                case 122 -> -1462126049;
                case 123 -> -412537287;
                case 124 -> -235862084;
                case 125 -> -76624593;
                case 126 -> -631667942;
                case 127 -> 1814168438;
                case 128 -> 462845732;
                case 129 -> 918755789;
                case 130 -> -1419402572;
                case 131 -> -1034316729;
                case 132 -> 895950384;
                case 133 -> -197019525;
                case 134 -> 585956290;
                case 135 -> 1460301735;
                case 136 -> 6981115;
                case 137 -> 1960139219;
                case 138 -> -1969067443;
                case 139 -> -1163394183;
                case 140 -> -1108872398;
                case 141 -> -456269320;
                case 142 -> -255767949;
                case 143 -> 1945851147;
                case 144 -> 1103580724;
                case 145 -> -55662240;
                case 146 -> 1377760269;
                case 147 -> -998103596;
                case 148 -> 1180011763;
                case 149 -> -1589158569;
                case 150 -> 1905636861;
                case 151 -> -1529481793;
                case 152 -> 269501135;
                case 153 -> 632652325;
                case 154 -> 1101586332;
                case 155 -> 1477611696;
                case 156 -> 2118200404;
                case 157 -> 1330178048;
                case 158 -> 118028344;
                case 159 -> -91619732;
                case 160 -> 1751890700;
                case 161 -> -903507342;
                case 162 -> -1449513491;
                case 163 -> -863111521;
                case 164 -> 1578893173;
                case 165 -> 1914816288;
                case 166 -> 621710974;
                case 167 -> 2079673029;
                case 168 -> -674788802;
                case 169 -> -972592795;
                case 170 -> -2058833187;
                case 171 -> -930750194;
                case 172 -> -916058682;
                case 173 -> 1749793880;
                case 174 -> 483577259;
                case 175 -> -422435721;
                case 176 -> -1955538702;
                case 177 -> -1748945308;
                case 178 -> -1476306559;
                case 179 -> 1956842206;
                case 180 -> -1034583696;
                case 181 -> -1325724395;
                case 182 -> 1159189066;
                case 183 -> -2013912360;
                case 184 -> 1884901586;
                case 185 -> -1236102473;
                case 186 -> -1271318913;
                case 187 -> -534169524;
                case 188 -> -1481621574;
                case 189 -> 2096797467;
                case 190 -> 1213544737;
                case 191 -> -295465930;
                case 192 -> 1801691745;
                case 193 -> -510828412;
                case 194 -> -1612814317;
                case 195 -> -790189150;
                case 196 -> -1831744241;
                case 197 -> -2109345042;
                case 198 -> 1613015106;
                case 199 -> 1794070382;
                case 200 -> -430879172;
                case 201 -> 685618045;
                case 202 -> 1005767873;
                case 203 -> 175187043;
                case 204 -> -250116586;
                case 205 -> -971790231;
                case 206 -> -322622565;
                case 207 -> 75344624;
                case 208 -> 103531871;
                case 209 -> -1519201385;
                case 210 -> 282754387;
                case 211 -> -221089610;
                case 212 -> -517134938;
                case 213 -> 356612065;
                case 214 -> 650075390;
                case 215 -> -954795629;
                case 216 -> -515713147;
                case 217 -> -321174909;
                case 218 -> -469226027;
                case 219 -> 1560710451;
                case 220 -> -1309436213;
                case 221 -> 794076419;
                case 222 -> -1611374448;
                case 223 -> 441954227;
                case 224 -> -199593757;
                case 225 -> 291888265;
                case 226 -> 1727086081;
                case 227 -> 736974822;
                case 228 -> 503062993;
                case 229 -> 1015048438;
                case 230 -> -392056630;
                case 231 -> 435970413;
                case 232 -> -438196009;
                case 233 -> -1646656372;
                case 234 -> -495730763;
                case 235 -> 1922156768;
                case 236 -> -2083398222;
                case 237 -> 56907236;
                case 238 -> -198986353;
                case 239 -> -1047749870;
                case 240 -> 1716331114;
                case 241 -> 1515773503;
                case 242 -> 756557023;
                case 243 -> -1326920552;
                case 244 -> 1753971945;
                case 245 -> 2004151337;
                case 246 -> -931057582;
                case 247 -> 442907342;
                case 248 -> -1880180582;
                case 249 -> -797335887;
                case 250 -> -572988499;
                case 251 -> -831938403;
                case 252 -> 123689576;
                case 253 -> -1522522440;
                case 254 -> -1693878383;
                case 255 -> -2119479590;
                default -> -1016824690;
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
            Object[] objectArray = new Object[5];
            v1 = objectArray;
            00i = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        RenderSupport_oii_4 = 11.0;
        ConfigSupport_OII = 3.2;
    }

    private Vec3d oOO(Vec3d param1, Box param2) {
        return new Vec3d(MathHelper.clamp((double)param1.x, (double)param2.minX, (double)param2.maxX), MathHelper.clamp((double)param1.y, (double)param2.minY, (double)param2.maxY), MathHelper.clamp((double)param1.z, (double)param2.minZ, (double)param2.maxZ));
    }

    private void SettingContainer() {
        this.ConfigSupport_0OO = false;
        this.DataRecord_0O0 = false;
        this.0Oo = false;
        this.EnumType_0OI = false;
        this.Oii = false;
        this.0Oi = 0;
        this.Kernel32SnapshotApi = -1;
        this.StorageEspModule = -1;
        this.ConfigSupport_00o_0 = 0.0f;
        this.DataRecord_00I = 0.0f;
    }

    private float FastWebModule(Vec3d param1) {
        Vec3d v2 = AntiKnockbackModule.ConfigSupport_OI0.player.method_33571();
        double v3 = param1.x - v2.x;
        double v5 = param1.z - v2.z;
        return (float)(MathHelper.atan2((double)v5, (double)v3) * 57.2957763671875) - 90.0f;
    }

    private void oOi(Packet param1, ClientPlayPacketListener param2) {
        param1.apply((PacketListener)param2);
    }

    private void o0O() {
        Runnable v1;
        while ((v1 = (Runnable)this.OiI.poll()) != null) {
            v1.run();
        }
    }

    private boolean DataRecord_0io_2() {
        return this.KeepSprintModule(3.2) != null || this.0io() != null;
    }

    private boolean 0iI(LivingEntity param1) {
        if (param1 == AntiKnockbackModule.ConfigSupport_OI0.player || param1 instanceof ArmorStandEntity || !param1.method_5805() || param1.method_31481()) {
            return false;
        }
        return param1 instanceof PlayerEntity || param1 instanceof MobEntity || param1 instanceof AnimalEntity || param1 instanceof VillagerEntity;
    }

    private LivingEntity 0io() {
        if (AntiKnockbackModule.ConfigSupport_OI0.world == null || AntiKnockbackModule.ConfigSupport_OI0.player == null) {
            return null;
        }
        LivingEntity v1 = null;
        double v2 = 0.0;
        Box v4 = AntiKnockbackModule.ConfigSupport_OI0.player.method_5829().expand(11.0);
        for (Entity v6 : AntiKnockbackModule.ConfigSupport_OI0.world.method_8335((Entity)AntiKnockbackModule.ConfigSupport_OI0.player, v4)) {
            double v8;
            LivingEntity v7;
            if (!(v6 instanceof LivingEntity) || !this.0iI(v7 = (LivingEntity)v6) || !((v8 = (double)AntiKnockbackModule.ConfigSupport_OI0.player.method_5739((Entity)v7)) > v2)) continue;
            v2 = v8;
            v1 = v7;
        }
        return v1;
    }
}

