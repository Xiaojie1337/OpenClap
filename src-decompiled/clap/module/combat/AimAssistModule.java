/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.mob.HostileEntity
 *  net.minecraft.entity.mob.MobEntity
 *  net.minecraft.entity.passive.AnimalEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.AxeItem
 *  net.minecraft.item.Item
 *  net.minecraft.item.Items
 *  net.minecraft.item.MaceItem
 *  net.minecraft.item.TridentItem
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.RaycastContext
 *  net.minecraft.world.RaycastContext$FluidHandling
 *  net.minecraft.world.RaycastContext$ShapeType
 */
package clap.module.combat;

import java.security.Key;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.MaceItem;
import net.minecraft.item.TridentItem;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import clap.render.RenderSupport_0I0;
import clap.module.combat.AntiBotModule;
import clap.config.ConfigSupport_OIII;
import clap.core.module.Module;
import clap.setting.Setting;
import clap.core.module.ModuleCategory;
import clap.event.EventHandler;
import skidonion.loader.0ooo;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from psx.Hyk.OooO
 */
public class AimAssistModule
extends Module {
    private static final float oiIo;
    private final Setting oiII = this.OOi0o("HorizontalSpeed", 31, 0, 100).ConfigSupport_00o_0("%");
    private static final float oiI0;
    private float IO0o;
    private int IOO0;
    private float IO0O;
    private final Setting oOiI;
    private long IOOo;
    private final Setting oiiI;
    private boolean 0Oo0;
    private final Setting oiiO;
    private final Setting oOII;
    private final Setting oOio;
    private final Setting oii0;
    private final Setting oiio;
    private final Setting o0OO;
    private final Setting oiii;
    private boolean IOOI;
    private float IO00;
    private float IOOi;
    private final Setting KbDelayModule;
    private final Setting oiIi = this.OOi00("VerticalAim", true);
    private final Setting 0OOi;
    private final Setting oOii;
    private final Setting IOOO;
    private int IO0I = -1;
    private final Setting o0O0;
    private static final float oiIO;
    private LivingEntity o00o;
    private final Setting ioO;
    static Object IO0i;
    private static volatile /* synthetic */ long __k__gH4it;
    private static /* synthetic */ String[] __p__gH4it;
    private static /* synthetic */ Object[][] __c__J7Um6;

    /*
     * Enabled aggressive block sorting
     */
    @EventHandler
    public void ii00(ConfigSupport_OIII param1) {
        List v2;
        if (!AimAssistModule.iooI() && AimAssistModule.ConfigSupport_OI0.currentScreen == null && this.IIoO()) {
            v2 = this.IIiI((Double)this.ioO.HelpCommand());
            if (v2.isEmpty()) {
                this.ii0I();
                return;
            }
        } else {
            this.ii0I();
            return;
        }
        LivingEntity v3 = this.iioO(v2);
        if (v3 != null) {
            this.o00o = v3;
            this.ii0o(this.o00o, param1.StorageEspModule(), param1.ConfigSupport_00o_0());
            if (0ooo.AutoCollectWaterModule() == null) return;
            if (!0ooo.EnumType_OIO0().Oii()) return;
            0ooo.OIOo().0Oo(this);
            return;
        }
        this.ii0I();
    }

    /*
     * Enabled aggressive block sorting
     */
    private void ii0o(LivingEntity param1, float param2, float param3) {
        float v18;
        float[] cfr_ignored_0 = new float[0];
        float[] v4 = this.iiIi(param1, param3);
        float v5 = AimAssistModule.ConfigSupport_OI0.player.method_36454();
        float v6 = AimAssistModule.ConfigSupport_OI0.player.method_36455();
        float v7 = MathHelper.wrapDegrees((float)(v4[0] - v5));
        float v8 = v4[1] - v6;
        float v9 = (float)Math.sqrt(v7 * v7 + v8 * v8);
        float v10 = this.ii0i(((Integer)this.oiio.HelpCommand()).intValue(), 45.0f);
        float v11 = this.ii0i(((Integer)this.oiII.HelpCommand()).intValue(), 90.0f);
        float v12 = this.ii0i(((Integer)this.oiiO.HelpCommand()).intValue(), 90.0f);
        float v13 = 1.0f - (float)Math.exp(-v10 * Math.max(0.001f, param2));
        float v14 = MathHelper.lerp((float)Math.min(1.0f, v9 / 18.0f), (float)(1.0f - ((Float)this.oii0.HelpCommand()).floatValue() * 0.65f), (float)1.0f);
        float v15 = v11 * Math.max(0.001f, param2) * 20.0f;
        float v16 = v12 * Math.max(0.001f, param2) * 20.0f;
        float v17 = MathHelper.clamp((float)(v7 * (v13 *= v14)), (float)(-v15), (float)v15);
        float f = v18 = (Boolean)this.oiIi.HelpCommand() != false ? MathHelper.clamp((float)(v8 * v13), (float)(-v16), (float)v16) : 0.0f;
        if (Math.abs(v7) < 0.03f) {
            v17 = v7;
        }
        if (((Boolean)this.oiIi.HelpCommand()).booleanValue() && Math.abs(v8) < 0.03f) {
            v18 = v8;
        }
        AimAssistModule.ConfigSupport_OI0.player.method_36456(v5 + v17);
        AimAssistModule.ConfigSupport_OI0.player.method_36457(MathHelper.clamp((float)(v6 + v18), (float)-90.0f, (float)90.0f));
        this.iiIo();
    }

    @Override
    public void 0oI() {
        this.o00o = null;
        this.IOO0 = 0;
        this.IOOo = 0L;
        this.IOOI = false;
        this.IO00 = 0.0f;
        this.IO0o = 0.0f;
        this.0Oo0 = false;
        this.IO0I = -1;
        if (0ooo.ConfigSupport_OIOI() != null) {
            0ooo.OIOi().0Oo(this);
        }
    }

    private Vec3d oOO(Vec3d param1, Box param2) {
        return new Vec3d(MathHelper.clamp((double)param1.x, (double)param2.minX, (double)param2.maxX), MathHelper.clamp((double)param1.y, (double)param2.minY, (double)param2.maxY), MathHelper.clamp((double)param1.z, (double)param2.minZ, (double)param2.maxZ));
    }

    /*
     * Enabled aggressive block sorting
     */
    private Vec3d iii0(LivingEntity param1, Vec3d param2, float param3, double param4) {
        double[] v18;
        Vec3d v19;
        double[] dArray;
        double[] v16;
        Vec3d v17;
        double[] dArray2;
        double[] cfr_ignored_0 = new double[0];
        double[] cfr_ignored_1 = new double[0];
        Box v6 = param1.method_5829();
        Vec3d v7 = param1.method_30950(param3);
        Vec3d v8 = param1.method_73189();
        Vec3d v9 = v7.subtract(v8);
        double v10 = param4 * param4;
        double v12 = (v6.minX + v6.maxX) * 0.5;
        double v14 = (v6.minZ + v6.maxZ) * 0.5;
        if (Math.abs(param1.method_18798().y) > 0.08) {
            double[] dArray3 = new double[2];
            dArray3[0] = 0.82;
            dArray2 = dArray3;
            dArray3[1] = 0.72;
        } else {
            double[] dArray4 = new double[2];
            dArray4[0] = 0.9;
            dArray2 = dArray4;
            dArray4[1] = 0.8;
        }
        if ((v17 = this.iiio(param2, v12, v14, v6, v9, v10, v16 = dArray2)) != null) {
            return v17;
        }
        if (Math.abs(param1.method_18798().y) > 0.08) {
            double[] dArray5 = new double[3];
            dArray5[0] = 0.6;
            dArray5[1] = 0.48;
            dArray = dArray5;
            dArray5[2] = 0.32;
        } else {
            double[] dArray6 = new double[3];
            dArray6[0] = 0.68;
            dArray6[1] = 0.52;
            dArray = dArray6;
            dArray6[2] = 0.32;
        }
        if ((v19 = this.iiio(param2, v12, v14, v6, v9, v10, v18 = dArray)) != null) return v19;
        return this.oOO(param2, v6.offset(v9).expand((double)param1.method_5871()));
    }

    private float[] IiOI(LivingEntity param1) {
        return this.iiII(param1);
    }

    private double iiIO(LivingEntity param1, float param2, float param3) {
        float[] cfr_ignored_0 = new float[0];
        float[] v4 = this.IiOI(param1);
        float v5 = Math.abs(MathHelper.wrapDegrees((float)(v4[0] - param2)));
        float v6 = Math.abs(v4[1] - param3);
        return Math.sqrt((double)(v5 * v5) + (double)(v6 * v6) * 0.55);
    }

    /*
     * Handled impossible loop by adding 'first' condition
     * Enabled aggressive block sorting
     */
    private Vec3d iiio(Vec3d param1, double param2, double param4, Box param6, Vec3d param7, double param8, double[] param10) {
        double[] cfr_ignored_1 = new double[0];
        Vec3d v11 = null;
        Vec3d v12 = null;
        double v13 = Double.MAX_VALUE;
        double[] v15 = param10;
        int v16 = v15.length;
        int v17 = 0;
        boolean bl = true;
        while (true) {
            double v21;
            Vec3d v20;
            if (!bl || (bl = false) || !true) {
                ++v17;
            }
            if (v17 < v16) {
                double v18 = v15[v17];
                v20 = new Vec3d(param2, param6.minY + param6.getLengthY() * v18, param4).add(param7);
                if (param1.squaredDistanceTo(v20) > param8) {
                    continue;
                }
            } else {
                Vec3d vec3d;
                if (v12 == null) {
                    vec3d = v11;
                    return vec3d;
                }
                vec3d = v12;
                return vec3d;
            }
            if (v11 == null) {
                v11 = v20;
            }
            if (!this.iiii(param1, v20) || !((v21 = this.iiiI(param1, v20, AimAssistModule.ConfigSupport_OI0.player.method_36454(), AimAssistModule.ConfigSupport_OI0.player.method_36455())) < v13)) continue;
            v13 = v21;
            v12 = v20;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private LivingEntity iioO(List param1) {
        boolean v16;
        double v7;
        double v9;
        if (param1.isEmpty()) {
            return null;
        }
        this.iiI0();
        param1.sort(Comparator.comparingDouble(this::iio0));
        LivingEntity v2 = (LivingEntity)param1.getFirst();
        if (((Boolean)this.IOOO.HelpCommand()).booleanValue() && this.o00o != null && param1.contains(this.o00o)) {
            return this.o00o;
        }
        if (this.o00o == null || !param1.contains(this.o00o)) {
            this.IOO0 = 0;
            this.IOOo = System.currentTimeMillis();
            return v2;
        }
        if (v2 == this.o00o) {
            this.IOO0 = 0;
            return this.o00o;
        }
        double v3 = this.iio0(this.o00o);
        double v5 = this.iio0(v2);
        if (v5 + (v9 = this.iioI(v3, v7 = this.iioi(v2))) >= v3) {
            this.IOO0 = 0;
            return this.o00o;
        }
        ++this.IOO0;
        long v11 = (long)((Integer)this.oiiI.HelpCommand()).intValue() * 50L;
        long v13 = System.currentTimeMillis();
        boolean v15 = v11 <= 0L || v13 - this.IOOo >= v11;
        boolean bl = v16 = v7 >= 1.5 && v5 <= v3 + 8.0;
        if (!v15 && !v16) {
            return this.o00o;
        }
        this.IOO0 = 0;
        this.IOOo = v13;
        return v2;
    }

    private float ii0i(float param1, float param2) {
        return MathHelper.clamp((float)param1, (float)0.0f, (float)100.0f) / 100.0f * param2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean IIii(LivingEntity param1, double param2) {
        Vec3d v5;
        if (param1 == AimAssistModule.ConfigSupport_OI0.player) return false;
        if (!param1.method_5805()) return false;
        if (param1.method_31481()) {
            return false;
        }
        if (!((Boolean)this.o0OO.HelpCommand()).booleanValue() && param1.method_5767()) {
            return false;
        }
        if (!AimAssistModule.ConfigSupport_OI0.player.method_6057((Entity)param1)) {
            return false;
        }
        Vec3d v4 = AimAssistModule.ConfigSupport_OI0.player.method_33571();
        if (v4.distanceTo(v5 = this.oOO(v4, param1.method_5829().expand((double)param1.method_5871()))) > param2) {
            return false;
        }
        if (!this.IioO((Entity)param1, ((Integer)this.oOII.HelpCommand()).intValue())) {
            return false;
        }
        if (!(param1 instanceof PlayerEntity)) {
            if (param1 instanceof AnimalEntity) {
                return (Boolean)this.oOii.HelpCommand();
            }
        } else {
            PlayerEntity v6 = (PlayerEntity)param1;
            if (!((Boolean)this.oOio.HelpCommand()).booleanValue()) {
                return false;
            }
            if (0ooo.EnumType_OI0O() != null && 0ooo.RotationModule().iIoO(v6)) {
                return false;
            }
            if (((Boolean)this.KbDelayModule.HelpCommand()).booleanValue() && RenderSupport_0I0.OIOi(v6)) {
                return false;
            }
            if (((Boolean)this.o0O0.HelpCommand()).booleanValue() && 0ooo.OI0o() != null && 0ooo.CameraClipModule().CameraClipModule(v6)) {
                return false;
            }
            AntiBotModule v7 = AntiBotModule.iOoo();
            if (v7 == null) return true;
            if (!v7.iOoI((Entity)v6)) return true;
            return false;
        }
        if (param1 instanceof HostileEntity) return (Boolean)this.oOiI.HelpCommand();
        if (!(param1 instanceof MobEntity)) return (Boolean)this.oOiI.HelpCommand();
        return (Boolean)this.oOiI.HelpCommand();
    }

    /*
     * Enabled aggressive block sorting
     */
    private double iioi(LivingEntity param1) {
        if (this.o00o == null) return 0.0;
        if (!this.IOOI) {
            return 0.0;
        }
        double v2 = Math.sqrt(this.IO00 * this.IO00 + this.IO0o * this.IO0o);
        if (v2 < 0.08) return 0.0;
        if (!(v2 > 35.0)) {
            float v4 = AimAssistModule.ConfigSupport_OI0.player.method_36454();
            float v5 = AimAssistModule.ConfigSupport_OI0.player.method_36455();
            float v6 = v4 - this.IO00;
            float v7 = v5 - this.IO0o;
            double v8 = this.iiIO(param1, v4, v5);
            double v10 = this.iiIO(param1, v6, v7);
            double v12 = this.iiIO(this.o00o, v4, v5);
            double v14 = this.iiIO(this.o00o, v6, v7);
            double v16 = v10 - v8;
            double v18 = v12 - v14;
            if (!(v16 <= 0.03)) return MathHelper.clamp((double)(v16 * 1.7 + Math.max(0.0, v18) * 1.2 + v2 * 0.18), (double)0.0, (double)12.0);
            return 0.0;
        }
        return 0.0;
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean IIoO() {
        if (((Boolean)this.oiii.HelpCommand()).booleanValue()) {
            boolean v1 = AimAssistModule.ConfigSupport_OI0.options.attackKey.isPressed();
            boolean v2 = v1 && !this.0Oo0;
            this.0Oo0 = v1;
            if (!v1) {
                this.IO0I = -1;
                return false;
            }
            if (v2) {
                this.IO0I = AimAssistModule.ConfigSupport_OI0.player.field_6012;
                return false;
            }
            if (this.IO0I == AimAssistModule.ConfigSupport_OI0.player.field_6012) {
                return false;
            }
        } else {
            this.0Oo0 = false;
            this.IO0I = -1;
        }
        if ((Boolean)this.0OOi.HelpCommand() == false) return true;
        if (this.o0O0()) return true;
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean o0O0() {
        Item v1 = AimAssistModule.ConfigSupport_OI0.player.method_6047().getItem();
        if (v1 == Items.WOODEN_SWORD) return true;
        if (v1 == Items.COPPER_SWORD) return true;
        if (v1 == Items.STONE_SWORD) return true;
        if (v1 == Items.GOLDEN_SWORD) return true;
        if (v1 == Items.IRON_SWORD) return true;
        if (v1 == Items.DIAMOND_SWORD) return true;
        if (v1 == Items.NETHERITE_SWORD) return true;
        if (v1 instanceof AxeItem) return true;
        if (v1 instanceof MaceItem) return true;
        if (!(v1 instanceof TridentItem)) return false;
        return true;
    }

    private void iiIo() {
        this.IOOi = AimAssistModule.ConfigSupport_OI0.player.method_36454();
        this.IO0O = AimAssistModule.ConfigSupport_OI0.player.method_36455();
        this.IOOI = true;
        this.IO00 = 0.0f;
        this.IO0o = 0.0f;
    }

    private double iio0(LivingEntity param1) {
        float[] cfr_ignored_0 = new float[0];
        double v2 = this.iioo(param1);
        double v4 = Math.max(0.1, (Double)this.ioO.HelpCommand());
        if (v2 > v4) {
            return Double.MAX_VALUE;
        }
        float[] v6 = this.IiOI(param1);
        float v7 = Math.abs(MathHelper.wrapDegrees((float)(v6[0] - AimAssistModule.ConfigSupport_OI0.player.method_36454())));
        float v8 = Math.abs(v6[1] - AimAssistModule.ConfigSupport_OI0.player.method_36455());
        double v9 = (double)(v7 * v7) + (double)(v8 * v8) * 0.55;
        double v11 = v2 / v4 * 18.0;
        return v9 + v11;
    }

    private double iiiI(Vec3d param1, Vec3d param2, float param3, float param4) {
        float[] cfr_ignored_0 = new float[0];
        float[] v5 = this.iiiO(param1, param2);
        float v6 = Math.abs(MathHelper.wrapDegrees((float)(v5[0] - param3)));
        float v7 = Math.abs(v5[1] - param4);
        return Math.sqrt((double)(v6 * v6) + (double)(v7 * v7) * 0.55);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean IioO(Entity param1, float param2) {
        float[] cfr_ignored_0 = new float[0];
        float[] v3 = this.IiOI((LivingEntity)param1);
        float v4 = Math.abs(MathHelper.wrapDegrees((float)(v3[0] - AimAssistModule.ConfigSupport_OI0.player.method_36454())));
        if (!(v4 <= param2)) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean iiii(Vec3d param1, Vec3d param2) {
        if (AimAssistModule.ConfigSupport_OI0.world == null) return false;
        if (AimAssistModule.ConfigSupport_OI0.player == null) {
            return false;
        }
        BlockHitResult v3 = AimAssistModule.ConfigSupport_OI0.world.method_17742(new RaycastContext(param1, param2, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, (Entity)AimAssistModule.ConfigSupport_OI0.player));
        if (v3.getType() == HitResult.Type.MISS) return true;
        if (!(v3.getPos().squaredDistanceTo(param1) >= param2.squaredDistanceTo(param1) - 0.01)) return false;
        return true;
    }

    private float[] iiII(LivingEntity param1) {
        return this.iiIi(param1, 1.0f);
    }

    private void ii0I() {
        this.o00o = null;
        this.IOOI = false;
        this.IO00 = 0.0f;
        this.IO0o = 0.0f;
        if (0ooo.OI0i() != null) {
            0ooo.OIoO().0Oo(this);
        }
    }

    private double iioo(LivingEntity param1) {
        Vec3d v2 = AimAssistModule.ConfigSupport_OI0.player.method_33571();
        Vec3d v3 = this.iii0(param1, v2, 1.0f, (Double)this.ioO.HelpCommand());
        return v2.distanceTo(v3);
    }

    private void iiI0() {
        float v1 = AimAssistModule.ConfigSupport_OI0.player.method_36454();
        float v2 = AimAssistModule.ConfigSupport_OI0.player.method_36455();
        if (!this.IOOI) {
            this.IOOi = v1;
            this.IO0O = v2;
            this.IO00 = 0.0f;
            this.IO0o = 0.0f;
            this.IOOI = true;
            return;
        }
        this.IO00 = MathHelper.wrapDegrees((float)(v1 - this.IOOi));
        this.IO0o = v2 - this.IO0O;
        this.IOOi = v1;
        this.IO0O = v2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private double iioI(double param1, double param3) {
        double v5 = (Integer)this.oiiI.HelpCommand() <= 0 ? 0.6 : Math.max(2.5, param1 * 0.08);
        return Math.max(0.0, v5 - param3 * 2.2);
    }

    static {
        __k__gH4it = AimAssistModule.__k__gH4it(-5686144085115539951L);
        __rP__gH4it0 = new String[]{"\ua7c2\ucec1\u113a\u44f9\uc3e4\ufbb3\ua6ed\u135f\ua62f\ucf74\u1021\u4591\uc283\ufaef\ua6ab\u144a\ua124\uc83b\u1725\u42df\uc5f0\ufd98\ua18c\u155f\ua0ba\uc999\u1658\u43a7\uc437\ufc1a\ua0bd\u16c3\ua3cb\uca1e\u1554\u40b7\uc7f9\uff0b\ua372\u1717\ua2b1\ucb44\u14df\u4133\uc68e\ufe0f\ua28d\u17f4\uad8a\uc435\u1bbd\u4e41\uc9e1\uf13f\uade2\u182d\uacb0\uc555\u1ad7\u4f5b\uc8c6\uf08d\uac18\u19ea\uafe2\uc6b2\u192d\u4cc4\ucbeb\uf38a\uaf05\u1ab8\uaf49\uc7a2\u1860\u4d7d\uca5b\uf2ea\uae98\u1b79\uae79\uc0a4\u1f4a\u4a66\ucd79\uf5cf\ua90f\u1cfe\ua984\uc15d\u1ebf\u4b64\ucc58\uf450\ua87d\u1de0\ua8f9\uc289\u1d1d\u48fd\ucff1\uf763\uabf9\u1ee6\uab40\uc257\u1ce6\u4931\uce56\uf665\uaafb\u1f90\uaaf3\uc37e\u2349\u76e9\uf1ba\uc930\u9588\u20e5\u958a\ufc46\u22cb\u7754\uf07e\uc899\u9421\u2137\u94b2\ufdb0\u214c\u74bb\uf33d\ucb71\u9747\u2200\u9705\ufef9\u21f7\u757a\uf22a\uca98\u96ff\u23ac\u968b\uffe1\u20b3\u72f6\uf5f2\ucd5b\u9109\u24db\u91dc\uf803\u278a\u73b5\uf4be\ucc20\u90d8\u25ae\u9001\uf9ac\u2698\u70d6\uf706\ucfb6\u93f2\u26e2\u934e\ufaba\u2580\u7004\uf65b\uce7b\u92c0\u2799\u9293\ufbc9\u243d\u71c9\uf93b\uc1fe\u9d4a\u28a9\u9d1d\uf4a1\u2b85\u7e94\uf85f\uc0f1\u9c1c\u297e\u9c1d\uf57f\u2a2d\u7fa9\ufb7c\uc3fb\u9fe4\u2a1c\u9f44\uf630\u295c\u7c07\ufbc1\uc283\u9edd\u2bdf\u9e4d\uf79b\u28df\u7daa\ufae0\uc59e\u9904\u2cc0\u9931\uf037\u2fd7\u7a65\ufd37\uc4de\u985b\u2d6f\u98aa\uf132\u2e44\u7b76\ufc69\uc7fa\u9bd7\u2ec4\u9b5b\uf2b0\u2dae\u78b5\uff59\uc796\u9af8\u2ff4\u9a5a\uf336\u2c64\u79c9\ufed0\uc683\u8533\u3087\u8524\uecfa\u33d1\u66ba\ue1d4\ud9be\u8499\u31f8\u8456\ued27\u323b\u6725\ue058\ud84a\u8722\u32e4\u870c\ueeba\u3168\u641a\ue330\udb4e\u87da\u3394\u8656\uefe4\u30c2\u654b\ue240\uda08\u8665\u34f9\u8151\ue846\u37b7\u62ea\ue501\udd08\u81a2\u350a\u800f\ue9d5\u36de\u634f\ue4a8\udc71\u80d7\u36ee", "\ua626\ucf2b\u10cc\u45ce\uc2e8\ufd1a\ua1b6\u1477"};
        __rP__gH4it1 = new String[0];
        __rP__gH4it2 = new String[]{"\ua623\ucf63\u1037\u459f\uc28c\ufde8\ua1fc\u14b3\ua10d\uc8f9", "\ua621\ucf78\u1028", "\ua634\ucf6d\u1031\u45e4\uc287"};
        __rP__gH4it3 = new String[]{"\ua621\ucf65\u1031\u459d\uc28e\ufa16\ua1c2\u14b1\ua10f\uc8ff", "\ua637\ucf6e\u1032\u45f0\uc2ee\ufd89\ua193\u14c2\ua12b\uc868\u172a\u4284\uc590\ufc93\ua0b9\u1581\ua007\uc952\u161f\u43a8", "\ua631\ucf70\u1031\u45e5\uc28e\ufded\ua1f7"};
        __p__gH4it = new String[]{"\ue6ad\ue6d2\ue6f7\ue71c\ue741\ue766\ue78b\ue7b0\ue7d5\ue7fa\ue81f\ue844\ue869\ue88e\ue8b3", "\uf206\uf22b\uf250\uf275\uf29a\uf2bf\uf2e4\uf309\uf32e\uf353\uf378\uf39d\uf3c2\uf3e7\uf40c\uf431", "\uf563\uf588\uf5ad\uf5d2\uf5f7\uf61c\uf641\uf666\uf68b\uf6b0\uf6d5\uf6fa\uf71f\uf744", "\ue8ac\ue8d1\ue8f6\ue91b\ue940\ue965\ue98a\ue9af\ue9d4\ue9f9\uea1e\uea43", "\uec09\uec2e\uec53\uec78\uec9d\uecc2\uece7\ued0c\ued31\ued56\ued7b\ueda0\uedc5\uedea\uee0f\uee34\uee59", "\ue962\ue987\ue9ac\ue9d1\ue9f6\uea1b\uea40\uea65\uea8a\ueaaf\uead4\ueaf9\ueb1e\ueb43\ueb68\ueb8d\uebb2", "\uf4af\uf4d4\uf4f9\uf51e\uf543\uf568\uf58d\uf5b2\uf5d7\uf5fc", "\uf008\uf02d\uf052\uf077\uf09c\uf0c1\uf0e6\uf10b\uf130\uf155\uf17a\uf19f\uf1c4\uf1e9", "\uf355\uf37a\uf39f\uf3c4\uf3e9\uf40e\uf433\uf458\uf47d", "\ue8ae\ue8d3\ue8f8\ue91d\ue942\ue967\ue98c\ue9b1\ue9d6\ue9fb\uea20\uea45\uea6a\uea8f\ueab4\uead9", "\uf40b\uf430\uf455\uf47a\uf49f\uf4c4\uf4e9\uf50e\uf533\uf558", "\ue754\ue779\ue79e\ue7c3\ue7e8\ue80d\ue832\ue857", "\ueab1\uead6\ueafb\ueb20\ueb45\ueb6a\ueb8f\uebb4\uebd9\uebfe\uec23\uec48\uec6d\uec92\uecb7\uecdc\ued01\ued26\ued4b", "\ue60a\ue62f\ue654\ue679\ue69e\ue6c3\ue6e8\ue70d\ue732\ue757\ue77c\ue7a1\ue7c6\ue7eb\ue810\ue835", "\ue357\ue37c\ue3a1\ue3c6\ue3eb\ue410\ue435\ue45a\ue47f\ue4a4\ue4c9", "\ue6b0\ue6d5\ue6fa\ue71f\ue744\ue769\ue78e\ue7b3\ue7d8\ue7fd\ue822\ue847\ue86c\ue891\ue8b6\ue8db", "\uf1fd\uf222\uf247\uf26c\uf291\uf2b6\uf2db\uf300\uf325\uf34a\uf36f", "\uf556\uf57b\uf5a0\uf5c5\uf5ea\uf60f\uf634\uf659", "\ueab3\uead8\ueafd\ueb22\ueb47\ueb6c\ueb91\uebb6\uebdb\uec00\uec25\uec4a\uec6f\uec94", "\uf5fc\uf621\uf646\uf66b\uf690\uf6b5\uf6da\uf6ff", "\ue959\ue97e\ue9a3\ue9c8\ue9ed\uea12\uea37\uea5c\uea81", "\uf4b2\uf4d7\uf4fc\uf521\uf546\uf56b\uf590\uf5b5\uf5da\uf5ff\uf624\uf649\uf66e\uf693", "\uf1ff\uf224\uf249\uf26e\uf293\uf2b8\uf2dd\uf302\uf327\uf34c\uf371\uf396\uf3bb\uf3e0\uf405\uf42a\uf44f\uf474\uf499", "\ue558\ue57d\ue5a2\ue5c7\ue5ec\ue611\ue636\ue65b\ue680\ue6a5\ue6ca\ue6ef\ue714\ue739", "\ue0a5\ue0ca\ue0ef\ue114\ue139\ue15e\ue183\ue1a8\ue1cd\ue1f2\ue217\ue23c\ue261\ue286\ue2ab\ue2d0", "\uf3fe\uf423\uf448\uf46d\uf492\uf4b7\uf4dc\uf501\uf526\uf54b\uf570\uf595\uf5ba\uf5df\uf604\uf629\uf64e", "\uef5b\uef80\uefa5\uefca\uefef\uf014\uf039\uf05e\uf083\uf0a8", "\ueca4\uecc9\uecee\ued13\ued38\ued5d\ued82\ueda7", "\ue001\ue026\ue04b\ue070\ue095\ue0ba\ue0df\ue104\ue129\ue14e\ue173\ue198\ue1bd\ue1e2\ue207", "\ueb5a\ueb7f\ueba4\uebc9\uebee\uec13\uec38\uec5d\uec82\ueca7\ueccc\uecf1\ued16", "\ue6a7\ue6cc\ue6f1\ue716\ue73b\ue760\ue785\ue7aa\ue7cf\ue7f4\ue819\ue83e\ue863\ue888\ue8ad\ue8d2", "\ue400\ue425\ue44a\ue46f\ue494\ue4b9\ue4de\ue503", "\uef4d\uef72\uef97\uefbc\uefe1\uf006\uf02b\uf050\uf075\uf09a\uf0bf\uf0e4\uf109\uf12e\uf153\uf178\uf19d\uf1c2", "\uf2a6\uf2cb\uf2f0\uf315\uf33a\uf35f\uf384\uf3a9\uf3ce\uf3f3\uf418\uf43d\uf462", "\uee03\uee28\uee4d\uee72\uee97\ueebc\ueee1\uef06\uef2b\uef50\uef75\uef9a\uefbf\uefe4", "\ue34c\ue371\ue396\ue3bb\ue3e0\ue405\ue42a\ue44f", "\ue6a9\ue6ce\ue6f3\ue718\ue73d\ue762\ue787\ue7ac\ue7d1", "\ue202\ue227\ue24c\ue271\ue296\ue2bb\ue2e0\ue305\ue32a\ue34f\ue374\ue399\ue3be\ue3e3\ue408\ue42d\ue452\ue477\ue49c", "\uf54f\uf574\uf599\uf5be\uf5e3\uf608\uf62d\uf652\uf677\uf69c\uf6c1\uf6e6", "\ue0a8\ue0cd\ue0f2\ue117\ue13c\ue161\ue186\ue1ab\ue1d0\ue1f5\ue21a\ue23f\ue264\ue289\ue2ae\ue2d3\ue2f8", "\uedf5\uee1a\uee3f\uee64\uee89\ueeae\ueed3\ueef8\uef1d\uef42\uef67\uef8c\uefb1\uefd6\ueffb", "\ue14e\ue173\ue198\ue1bd\ue1e2\ue207\ue22c\ue251\ue276\ue29b\ue2c0\ue2e5\ue30a\ue32f\ue354\ue379\ue39e", "\ue4ab\ue4d0\ue4f5\ue51a\ue53f\ue564\ue589\ue5ae\ue5d3\ue5f8", "\ue7f4\ue819\ue83e\ue863\ue888\ue8ad\ue8d2\ue8f7\ue91c\ue941\ue966\ue98b\ue9b0\ue9d5\ue9fa\uea1f", "\uf551\uf576\uf59b\uf5c0\uf5e5\uf60a\uf62f\uf654\uf679\uf69e\uf6c3\uf6e8\uf70d\uf732\uf757", "\ue8aa\ue8cf\ue8f4\ue919\ue93e\ue963\ue988\ue9ad\ue9d2\ue9f7", "\uf3f7\uf41c\uf441\uf466\uf48b\uf4b0\uf4d5\uf4fa\uf51f\uf544\uf569\uf58e\uf5b3\uf5d8\uf5fd\uf622\uf647", "\uef50\uef75\uef9a\uefbf\uefe4\uf009\uf02e\uf053\uf078\uf09d\uf0c2\uf0e7\uf10c\uf131\uf156\uf17b\uf1a0\uf1c5\uf1ea", "\uf49d\uf4c2\uf4e7\uf50c\uf531\uf556\uf57b\uf5a0\uf5c5\uf5ea\uf60f\uf634\uf659", "\uf7f6\ue01b\ue040\ue065\ue08a\ue0af\ue0d4\ue0f9\ue11e\ue143\ue168\ue18d\ue1b2\ue1d7\ue1fc\ue221\ue246\ue26b", "\uf353\uf378\uf39d\uf3c2\uf3e7\uf40c\uf431\uf456\uf47b\uf4a0", "\uee9c\ueec1\ueee6\uef0b\uef30\uef55\uef7a\uef9f", "\ue1f9\ue21e\ue243\ue268\ue28d\ue2b2\ue2d7\ue2fc\ue321\ue346\ue36b\ue390\ue3b5\ue3da\ue3ff\ue424\ue449", "\ue752\ue777\ue79c\ue7c1\ue7e6\ue80b\ue830\ue855\ue87a\ue89f\ue8c4\ue8e9\ue90e\ue933\ue958\ue97d", "\uea9f\ueac4\ueae9\ueb0e\ueb33\ueb58\ueb7d\ueba2\uebc7\uebec\uec11\uec36\uec5b\uec80", "\ue5f8\ue61d\ue642\ue667\ue68c\ue6b1\ue6d6\ue6fb\ue720", "\ue945\ue96a\ue98f\ue9b4\ue9d9\ue9fe\uea23\uea48\uea6d\uea92\ueab7\ueadc\ueb01\ueb26", "\uf69e\uf6c3\uf6e8\uf70d\uf732\uf757\uf77c\uf7a1\uf7c6\uf7eb\ue010\ue035\ue05a\ue07f", "\ue9fb\uea20\uea45\uea6a\uea8f\ueab4\uead9\ueafe\ueb23\ueb48\ueb6d\ueb92\uebb7\uebdc", "\ue544\ue569\ue58e\ue5b3\ue5d8\ue5fd\ue622\ue647", "\uf0a1\uf0c6\uf0eb\uf110\uf135\uf15a\uf17f\uf1a4\uf1c9\uf1ee\uf213\uf238\uf25d\uf282\uf2a7", "\uedfa\uee1f\uee44\uee69\uee8e\ueeb3\ueed8\ueefd\uef22\uef47\uef6c", "\ue947\ue96c\ue991\ue9b6\ue9db\uea00\uea25\uea4a\uea6f\uea94", "\ue4a0\ue4c5\ue4ea\ue50f\ue534\ue559\ue57e\ue5a3\ue5c8\ue5ed\ue612", "\uf7ed\ue012\ue037\ue05c\ue081\ue0a6\ue0cb\ue0f0\ue115\ue13a\ue15f\ue184", "\ueb46\ueb6b\ueb90\uebb5\uebda\uebff\uec24\uec49\uec6e\uec93\uecb8", "\uf0a3\uf0c8\uf0ed\uf112\uf137\uf15c\uf181\uf1a6\uf1cb\uf1f0", "\ue3ec\ue411\ue436\ue45b\ue480\ue4a5\ue4ca\ue4ef\ue514\ue539\ue55e\ue583\ue5a8\ue5cd\ue5f2\ue617", "\ue749\ue76e\ue793\ue7b8\ue7dd\ue802\ue827\ue84c\ue871", "\ueaa2\ueac7\ueaec\ueb11\ueb36\ueb5b\ueb80\ueba5\uebca", "\uefef\uf014\uf039\uf05e\uf083\uf0a8\uf0cd\uf0f2\uf117\uf13c\uf161", "\ueb48\ueb6d\ueb92\uebb7\uebdc\uec01\uec26\uec4b\uec70\uec95\uecba\uecdf\ued04\ued29\ued4e\ued73\ued98", "\uf695\uf6ba\uf6df\uf704\uf729\uf74e\uf773\uf798\uf7bd", "\ue9ee\uea13\uea38\uea5d\uea82\ueaa7\ueacc\ueaf1\ueb16\ueb3b\ueb60", "\uf74b\uf770\uf795\uf7ba\uf7df\ue004\ue029\ue04e\ue073\ue098\ue0bd\ue0e2\ue107\ue12c\ue151\ue176\ue19b\ue1c0", "\uf294\uf2b9\uf2de\uf303\uf328\uf34d\uf372\uf397\uf3bc\uf3e1\uf406\uf42b\uf450\uf475\uf49a\uf4bf", "\uf5f1\uf616\uf63b\uf660\uf685\uf6aa\uf6cf\uf6f4\uf719\uf73e\uf763\uf788\uf7ad\uf7d2\uf7f7", "\uf14a\uf16f\uf194\uf1b9\uf1de\uf203\uf228\uf24d\uf272\uf297\uf2bc\uf2e1", "\ue497\ue4bc\ue4e1\ue506\ue52b\ue550\ue575\ue59a\ue5bf\ue5e4\ue609\ue62e", "\uf1f0\uf215\uf23a\uf25f\uf284\uf2a9\uf2ce\uf2f3\uf318\uf33d\uf362", "\uf53d\uf562\uf587\uf5ac\uf5d1\uf5f6\uf61b\uf640\uf665\uf68a\uf6af", "\ue896\ue8bb\ue8e0\ue905\ue92a\ue94f\ue974\ue999\ue9be\ue9e3\uea08\uea2d\uea52\uea77\uea9c\ueac1\ueae6\ueb0b\ueb30", "\ue3f3\ue418\ue43d\ue462\ue487\ue4ac\ue4d1\ue4f6\ue51b\ue540", "\ue93c\ue961\ue986\ue9ab\ue9d0\ue9f5\uea1a\uea3f\uea64\uea89\ueaae\uead3\ueaf8\ueb1d\ueb42\ueb67", "\uec99\uecbe\uece3\ued08\ued2d\ued52\ued77\ued9c\uedc1", "\ueff2\uf017\uf03c\uf061\uf086\uf0ab\uf0d0\uf0f5\uf11a\uf13f\uf164\uf189\uf1ae\uf1d3\uf1f8\uf21d\uf242\uf267", "\uf33f\uf364\uf389\uf3ae\uf3d3\uf3f8\uf41d\uf442", "\uf098\uf0bd\uf0e2\uf107\uf12c\uf151\uf176\uf19b\uf1c0", "\uf3e5\uf40a\uf42f\uf454\uf479\uf49e\uf4c3\uf4e8\uf50d\uf532\uf557\uf57c\uf5a1\uf5c6\uf5eb\uf610", "\uef3e\uef63\uef88\uefad\uefd2\ueff7\uf01c\uf041\uf066\uf08b\uf0b0\uf0d5", "\uf29b\uf2c0\uf2e5\uf30a\uf32f\uf354\uf379\uf39e\uf3c3\uf3e8\uf40d\uf432\uf457", "\uf5e4\uf609\uf62e\uf653\uf678\uf69d\uf6c2\uf6e7", "\uf341\uf366\uf38b\uf3b0\uf3d5\uf3fa\uf41f\uf444\uf469\uf48e\uf4b3\uf4d8\uf4fd\uf522\uf547", "\uf69a\uf6bf\uf6e4\uf709\uf72e\uf753\uf778\uf79d\uf7c2\uf7e7\ue00c\ue031\ue056\ue07b\ue0a0\ue0c5\ue0ea", "\uf1e7\uf20c\uf231\uf256\uf27b\uf2a0\uf2c5\uf2ea\uf30f", "\uf540\uf565\uf58a\uf5af\uf5d4\uf5f9\uf61e\uf643\uf668\uf68d"};
        __c__J7Um6 = new Object[][]{{"\uecf9\ued1e\ued43\ued68\ued8d\uedb2\uedd7\uedfc\uee21\uee46\uee6b\uee90\ueeb5\ueeda\ueeff\uef24\uef49", -296539873109887994L, "\uf417\uf43c\uf461\uf486\uf4ab\uf4d0\uf4f5\uf51a\uf53f\uf564\uf589\uf5ae\uf5d3\uf5f8", -268722950, "\ue335\ue35a\ue37f\ue3a4\ue3c9\ue3ee\ue413\ue438\ue45d\ue482\ue4a7\ue4cc\ue4f1\ue516\ue53b", true, "\uea53\uea78\uea9d\ueac2\ueae7\ueb0c\ueb31\ueb56\ueb7b\ueba0\uebc5\uebea\uec0f\uec34\uec59", true, "\uf171\uf196\uf1bb\uf1e0\uf205\uf22a\uf24f\uf274\uf299\uf2be\uf2e3\uf308", true, "\ue08f\ue0b4\ue0d9\ue0fe\ue123\ue148\ue16d\ue192\ue1b7\ue1dc\ue201\ue226\ue24b\ue270\ue295", true}, {"\uedfa\uee1f\uee44\uee69\uee8e\ueeb3\ueed8\ueefd", -296539873109822457L, "\uf518\uf53d\uf562\uf587\uf5ac\uf5d1\uf5f6\uf61b\uf640\uf665\uf68a", -1583588771, "\ue436\ue45b\ue480\ue4a5\ue4ca\ue4ef\ue514\ue539\ue55e\ue583\ue5a8", false, "\ueb54\ueb79\ueb9e\uebc3\uebe8\uec0d\uec32\uec57\uec7c\ueca1\uecc6\ueceb\ued10\ued35\ued5a\ued7f\ueda4", false, "\uf272\uf297\uf2bc\uf2e1\uf306\uf32b\uf350\uf375\uf39a\uf3bf", false, "\ue190\ue1b5\ue1da\ue1ff\ue224\ue249\ue26e\ue293\ue2b8\ue2dd\ue302", false}, {"\ueefb\uef20\uef45\uef6a\uef8f\uefb4\uefd9\ueffe\uf023\uf048\uf06d\uf092\uf0b7\uf0dc", -296539873109756920L, "\uf619\uf63e\uf663\uf688\uf6ad\uf6d2\uf6f7\uf71c\uf741\uf766\uf78b\uf7b0\uf7d5\uf7fa\ue01f", 1932792244, "\ue537\ue55c\ue581\ue5a6\ue5cb\ue5f0\ue615\ue63a\ue65f\ue684\ue6a9\ue6ce\ue6f3\ue718\ue73d", true, "\uec55\uec7a\uec9f\uecc4\uece9\ued0e\ued33\ued58\ued7d\ueda2\uedc7\uedec", true, "\uf373\uf398\uf3bd\uf3e2\uf407\uf42c\uf451\uf476\uf49b\uf4c0\uf4e5\uf50a\uf52f\uf554\uf579", true, "\ue291\ue2b6\ue2db\ue300\ue325\ue34a\ue36f\ue394\ue3b9", true}, {"\ueffc\uf021\uf046\uf06b\uf090\uf0b5\uf0da\uf0ff\uf124\uf149\uf16e", -296539873109691383L, "\uf71a\uf73f\uf764\uf789\uf7ae\uf7d3\uf7f8\ue01d\ue042\ue067\ue08c", 80531215, "\ue638\ue65d\ue682\ue6a7\ue6cc\ue6f1\ue716\ue73b\ue760\ue785\ue7aa\ue7cf\ue7f4\ue819\ue83e\ue863\ue888", false, "\ued56\ued7b\ueda0\uedc5\uedea\uee0f\uee34\uee59\uee7e\ueea3", false, "\uf474\uf499\uf4be\uf4e3\uf508\uf52d\uf552\uf577\uf59c\uf5c1\uf5e6", false, "\ue392\ue3b7\ue3dc\ue401\ue426\ue44b\ue470\ue495", false}, {"\uf0fd\uf122\uf147\uf16c\uf191\uf1b6\uf1db\uf200\uf225\uf24a\uf26f\uf294\uf2b9\uf2de\uf303", -296539873109625846L, "\ue01b\ue040\ue065\ue08a\ue0af\ue0d4\ue0f9\ue11e\ue143\ue168\ue18d\ue1b2\ue1d7\ue1fc\ue221", -698055066, "\ue739\ue75e\ue783\ue7a8\ue7cd\ue7f2\ue817\ue83c\ue861\ue886\ue8ab\ue8d0", true, "\uee57\uee7c\ueea1\ueec6\ueeeb\uef10\uef35\uef5a\uef7f\uefa4\uefc9\uefee\uf013\uf038\uf05d", true, "\uf575\uf59a\uf5bf\uf5e4\uf609\uf62e\uf653\uf678\uf69d", true, "\ue493\ue4b8\ue4dd\ue502\ue527\ue54c\ue571\ue596\ue5bb\ue5e0\ue605\ue62a\ue64f\ue674", true}, {"\uf1fe\uf223\uf248\uf26d\uf292\uf2b7\uf2dc\uf301\uf326\uf34b\uf370", -296539873109560309L, "\ue11c\ue141\ue166\ue18b\ue1b0\ue1d5\ue1fa\ue21f\ue244\ue269\ue28e\ue2b3\ue2d8\ue2fd\ue322\ue347\ue36c", 1744666041, "\ue83a\ue85f\ue884\ue8a9\ue8ce\ue8f3\ue918\ue93d\ue962\ue987", false, "\uef58\uef7d\uefa2\uefc7\uefec\uf011\uf036\uf05b\uf080\uf0a5\uf0ca", false, "\uf676\uf69b\uf6c0\uf6e5\uf70a\uf72f\uf754\uf779", false, "\ue594\ue5b9\ue5de\ue603\ue628\ue64d\ue672\ue697\ue6bc\ue6e1\ue706", false}, {"\uf2ff\uf324\uf349\uf36e\uf393\uf3b8\uf3dd\uf402\uf427\uf44c\uf471\uf496\uf4bb\uf4e0\uf505", -296539873109494772L, "\ue21d\ue242\ue267\ue28c\ue2b1\ue2d6\ue2fb\ue320\ue345\ue36a\ue38f\ue3b4", 966081296, "\ue93b\ue960\ue985\ue9aa\ue9cf\ue9f4\uea19\uea3e\uea63\uea88\ueaad\uead2\ueaf7\ueb1c\ueb41", true, "\uf059\uf07e\uf0a3\uf0c8\uf0ed\uf112\uf137\uf15c\uf181", true, "\uf777\uf79c\uf7c1\uf7e6\ue00b\ue030\ue055\ue07a\ue09f\ue0c4\ue0e9\ue10e\ue133\ue158", true, "\ue695\ue6ba\ue6df\ue704\ue729\ue74e\ue773\ue798\ue7bd\ue7e2\ue807\ue82c\ue851\ue876\ue89b\ue8c0\ue8e5", true}, {"\uf400\uf425\uf44a\uf46f\uf494\uf4b9\uf4de\uf503\uf528\uf54d\uf572\uf597\uf5bc\uf5e1\uf606\uf62b\uf650", -296539873109429235L, "\ue31e\ue343\ue368\ue38d\ue3b2\ue3d7\ue3fc\ue421\ue446\ue46b", -886181269, "\uea3c\uea61\uea86\ueaab\uead0\ueaf5\ueb1a\ueb3f\ueb64\ueb89\uebae", false, "\uf15a\uf17f\uf1a4\uf1c9\uf1ee\uf213\uf238\uf25d", false, "\ue078\ue09d\ue0c2\ue0e7\ue10c\ue131\ue156\ue17b\ue1a0\ue1c5\ue1ea", false, "\ue796\ue7bb\ue7e0\ue805\ue82a\ue84f\ue874\ue899", false}, {"\uf501\uf526\uf54b\uf570\uf595\uf5ba\uf5df\uf604\uf629\uf64e\uf673\uf698", -296539873109363698L, "\ue41f\ue444\ue469\ue48e\ue4b3\ue4d8\ue4fd\ue522\ue547\ue56c\ue591\ue5b6\ue5db\ue600\ue625", -1664767550, "\ueb3d\ueb62\ueb87\uebac\uebd1\uebf6\uec1b\uec40\uec65", true, "\uf25b\uf280\uf2a5\uf2ca\uf2ef\uf314\uf339\uf35e\uf383\uf3a8\uf3cd\uf3f2\uf417\uf43c", true, "\ue179\ue19e\ue1c3\ue1e8\ue20d\ue232\ue257\ue27c\ue2a1\ue2c6\ue2eb\ue310\ue335\ue35a\ue37f\ue3a4\ue3c9", true, "\ue897\ue8bc\ue8e1\ue906\ue92b\ue950\ue975\ue99a\ue9bf\ue9e4\uea09\uea2e\uea53\uea78", true}, {"\uf602\uf627\uf64c\uf671\uf696\uf6bb\uf6e0\uf705\uf72a\uf74f", -296539873109298161L, "\ue520\ue545\ue56a\ue58f\ue5b4\ue5d9\ue5fe\ue623\ue648\ue66d\ue692", 777938725, "\uec3e\uec63\uec88\uecad\uecd2\uecf7\ued1c\ued41", false, "\uf35c\uf381\uf3a6\uf3cb\uf3f0\uf415\uf43a\uf45f\uf484\uf4a9\uf4ce", false, "\ue27a\ue29f\ue2c4\ue2e9\ue30e\ue333\ue358\ue37d", false, "\ue998\ue9bd\ue9e2\uea07\uea2c\uea51\uea76\uea9b\ueac0\ueae5\ueb0a", false}, {"\uf703\uf728\uf74d\uf772\uf797\uf7bc\uf7e1\ue006\ue02b\ue050\ue075\ue09a\ue0bf\ue0e4\ue109", -296539873109232624L, "\ue621\ue646\ue66b\ue690\ue6b5\ue6da\ue6ff\ue724\ue749", -631172, "\ued3f\ued64\ued89\uedae\uedd3\uedf8\uee1d\uee42\uee67\uee8c\ueeb1\ueed6\ueefb\uef20", true, "\uf45d\uf482\uf4a7\uf4cc\uf4f1\uf516\uf53b\uf560\uf585\uf5aa\uf5cf\uf5f4\uf619\uf63e\uf663\uf688\uf6ad", true, "\ue37b\ue3a0\ue3c5\ue3ea\ue40f\ue434\ue459\ue47e\ue4a3\ue4c8\ue4ed\ue512\ue537\ue55c", true, "\uea99\ueabe\ueae3\ueb08\ueb2d\ueb52\ueb77\ueb9c\uebc1\uebe6\uec0b\uec30\uec55\uec7a\uec9f", true}, {"\ue004\ue029\ue04e\ue073\ue098\ue0bd\ue0e2\ue107\ue12c\ue151\ue176", -296539873109167087L, "\ue722\ue747\ue76c\ue791\ue7b6\ue7db\ue800\ue825", -1316088361, "\uee40\uee65\uee8a\ueeaf\ueed4\ueef9\uef1e\uef43\uef68\uef8d\uefb2", false, "\uf55e\uf583\uf5a8\uf5cd\uf5f2\uf617\uf63c\uf661", false, "\ue47c\ue4a1\ue4c6\ue4eb\ue510\ue535\ue55a\ue57f\ue5a4\ue5c9\ue5ee", false, "\ueb9a\uebbf\uebe4\uec09\uec2e\uec53\uec78\uec9d\uecc2\uece7\ued0c", false}, {"\ue105\ue12a\ue14f\ue174\ue199\ue1be\ue1e3\ue208\ue22d", -296539873109101550L, "\ue823\ue848\ue86d\ue892\ue8b7\ue8dc\ue901\ue926\ue94b\ue970\ue995\ue9ba\ue9df\uea04", 1126617902, "\uef41\uef66\uef8b\uefb0\uefd5\ueffa\uf01f\uf044\uf069\uf08e\uf0b3\uf0d8\uf0fd\uf122\uf147\uf16c\uf191", true, "\uf65f\uf684\uf6a9\uf6ce\uf6f3\uf718\uf73d\uf762\uf787\uf7ac\uf7d1\uf7f6\ue01b\ue040", true, "\ue57d\ue5a2\ue5c7\ue5ec\ue611\ue636\ue65b\ue680\ue6a5\ue6ca\ue6ef\ue714\ue739\ue75e\ue783", true, "\uec9b\uecc0\uece5\ued0a\ued2f\ued54\ued79\ued9e\uedc3\uede8\uee0d\uee32\uee57\uee7c\ueea1", true}, {"\ue206\ue22b\ue250\ue275\ue29a\ue2bf\ue2e4\ue309", -296539873109036013L, "\ue924\ue949\ue96e\ue993\ue9b8\ue9dd\uea02\uea27\uea4c\uea71\uea96", 348031617, "\uf042\uf067\uf08c\uf0b1\uf0d6\uf0fb\uf120\uf145", false, "\uf760\uf785\uf7aa\uf7cf\uf7f4\ue019\ue03e\ue063\ue088\ue0ad\ue0d2", false, "\ue67e\ue6a3\ue6c8\ue6ed\ue712\ue737\ue75c\ue781\ue7a6\ue7cb\ue7f0", false, "\ued9c\uedc1\uede6\uee0b\uee30\uee55\uee7a\uee9f\ueec4\ueee9\uef0e\uef33\uef58\uef7d\uefa2\uefc7\uefec", false}, {"\ue307\ue32c\ue351\ue376\ue39b\ue3c0\ue3e5\ue40a\ue42f\ue454\ue479\ue49e\ue4c3\ue4e8", -296539873108970476L, "\uea25\uea4a\uea6f\uea94\ueab9\ueade\ueb03\ueb28\ueb4d\ueb72\ueb97\uebbc\uebe1\uec06\uec2b\uec50\uec75", -1504230952, "\uf143\uf168\uf18d\uf1b2\uf1d7\uf1fc\uf221\uf246\uf26b\uf290\uf2b5\uf2da\uf2ff\uf324", true, "\ue061\ue086\ue0ab\ue0d0\ue0f5\ue11a\ue13f\ue164\ue189\ue1ae\ue1d3\ue1f8\ue21d\ue242\ue267", true, "\ue77f\ue7a4\ue7c9\ue7ee\ue813\ue838\ue85d\ue882\ue8a7\ue8cc\ue8f1\ue916\ue93b\ue960\ue985", true, "\uee9d\ueec2\ueee7\uef0c\uef31\uef56\uef7b\uefa0\uefc5\uefea\uf00f\uf034", true}, {"\ue408\ue42d\ue452\ue477\ue49c\ue4c1\ue4e6\ue50b\ue530\ue555\ue57a", -296539873108904939L, "\ueb26\ueb4b\ueb70\ueb95\uebba\uebdf\uec04\uec29", 2012167987, "\uf244\uf269\uf28e\uf2b3\uf2d8\uf2fd\uf322\uf347\uf36c\uf391\uf3b6", false, "\ue162\ue187\ue1ac\ue1d1\ue1f6\ue21b\ue240\ue265\ue28a\ue2af\ue2d4", false, "\ue880\ue8a5\ue8ca\ue8ef\ue914\ue939\ue95e\ue983\ue9a8\ue9cd\ue9f2\uea17\uea3c\uea61\uea86\ueaab\uead0", false, "\uef9e\uefc3\uefe8\uf00d\uf032\uf057\uf07c\uf0a1\uf0c6\uf0eb", false}, {"\ue509\ue52e\ue553\ue578\ue59d\ue5c2\ue5e7\ue60c\ue631\ue656\ue67b\ue6a0\ue6c5\ue6ea\ue70f\ue734\ue759", -296539873108839402L, "\uec27\uec4c\uec71\uec96\uecbb\uece0\ued05\ued2a\ued4f\ued74\ued99\uedbe\uede3\uee08", 159905418, "\uf345\uf36a\uf38f\uf3b4\uf3d9\uf3fe\uf423\uf448\uf46d\uf492\uf4b7\uf4dc\uf501\uf526\uf54b", true, "\ue263\ue288\ue2ad\ue2d2\ue2f7\ue31c\ue341\ue366\ue38b\ue3b0\ue3d5\ue3fa\ue41f\ue444\ue469", true, "\ue981\ue9a6\ue9cb\ue9f0\uea15\uea3a\uea5f\uea84\ueaa9\ueace\ueaf3\ueb18", true, "\uf09f\uf0c4\uf0e9\uf10e\uf133\uf158\uf17d\uf1a2\uf1c7\uf1ec\uf211\uf236\uf25b\uf280\uf2a5", true}, {"\ue60a\ue62f\ue654\ue679\ue69e\ue6c3\ue6e8\ue70d", -296539873108773865L, "\ued28\ued4d\ued72\ued97\uedbc\uede1\uee06\uee2b\uee50\uee75\uee9a", -618680851, "\uf446\uf46b\uf490\uf4b5\uf4da\uf4ff\uf524\uf549\uf56e\uf593\uf5b8", false, "\ue364\ue389\ue3ae\ue3d3\ue3f8\ue41d\ue442\ue467\ue48c\ue4b1\ue4d6\ue4fb\ue520\ue545\ue56a\ue58f\ue5b4", false, "\uea82\ueaa7\ueacc\ueaf1\ueb16\ueb3b\ueb60\ueb85\uebaa\uebcf", false, "\uf1a0\uf1c5\uf1ea\uf20f\uf234\uf259\uf27e\uf2a3\uf2c8\uf2ed\uf312", false}, {"\ue70b\ue730\ue755\ue77a\ue79f\ue7c4\ue7e9\ue80e\ue833\ue858\ue87d\ue8a2\ue8c7\ue8ec", -296539873108708328L, "\uee29\uee4e\uee73\uee98\ueebd\ueee2\uef07\uef2c\uef51\uef76\uef9b\uefc0\uefe5\uf00a\uf02f", 1823501124, "\uf547\uf56c\uf591\uf5b6\uf5db\uf600\uf625\uf64a\uf66f\uf694\uf6b9\uf6de\uf703\uf728\uf74d", true, "\ue465\ue48a\ue4af\ue4d4\ue4f9\ue51e\ue543\ue568\ue58d\ue5b2\ue5d7\ue5fc", true, "\ueb83\ueba8\uebcd\uebf2\uec17\uec3c\uec61\uec86\uecab\uecd0\uecf5\ued1a\ued3f\ued64\ued89", true, "\uf2a1\uf2c6\uf2eb\uf310\uf335\uf35a\uf37f\uf3a4\uf3c9", true}, {"\ue80c\ue831\ue856\ue87b\ue8a0\ue8c5\ue8ea\ue90f\ue934\ue959\ue97e", -296539873108642791L, "\uef2a\uef4f\uef74\uef99\uefbe\uefe3\uf008\uf02d\uf052\uf077\uf09c", 1044914847, "\uf648\uf66d\uf692\uf6b7\uf6dc\uf701\uf726\uf74b\uf770\uf795\uf7ba\uf7df\ue004\ue029\ue04e\ue073\ue098", false, "\ue566\ue58b\ue5b0\ue5d5\ue5fa\ue61f\ue644\ue669\ue68e\ue6b3", false, "\uec84\ueca9\uecce\uecf3\ued18\ued3d\ued62\ued87\uedac\uedd1\uedf6", false, "\uf3a2\uf3c7\uf3ec\uf411\uf436\uf45b\uf480\uf4a5", false}, {"\ue90d\ue932\ue957\ue97c\ue9a1\ue9c6\ue9eb\uea10\uea35\uea5a\uea7f\ueaa4\ueac9\ueaee\ueb13", -296539873108577254L, "\uf02b\uf050\uf075\uf09a\uf0bf\uf0e4\uf109\uf12e\uf153\uf178\uf19d\uf1c2\uf1e7\uf20c\uf231", -807396874, "\uf749\uf76e\uf793\uf7b8\uf7dd\ue002\ue027\ue04c\ue071\ue096\ue0bb\ue0e0", true, "\ue667\ue68c\ue6b1\ue6d6\ue6fb\ue720\ue745\ue76a\ue78f\ue7b4\ue7d9\ue7fe\ue823\ue848\ue86d", true, "\ued85\uedaa\uedcf\uedf4\uee19\uee3e\uee63\uee88\ueead", true, "\uf4a3\uf4c8\uf4ed\uf512\uf537\uf55c\uf581\uf5a6\uf5cb\uf5f0\uf615\uf63a\uf65f\uf684", true}, {"\uea0e\uea33\uea58\uea7d\ueaa2\ueac7\ueaec\ueb11\ueb36\ueb5b\ueb80", -296539873108511717L, "\uf12c\uf151\uf176\uf19b\uf1c0\uf1e5\uf20a\uf22f\uf254\uf279\uf29e\uf2c3\uf2e8\uf30d\uf332\uf357\uf37c", -2122786999, "\ue04a\ue06f\ue094\ue0b9\ue0de\ue103\ue128\ue14d\ue172\ue197", false, "\ue768\ue78d\ue7b2\ue7d7\ue7fc\ue821\ue846\ue86b\ue890\ue8b5\ue8da", false, "\uee86\ueeab\ueed0\ueef5\uef1a\uef3f\uef64\uef89", false, "\uf5a4\uf5c9\uf5ee\uf613\uf638\uf65d\uf682\uf6a7\uf6cc\uf6f1\uf716", false}, {"\ueb0f\ueb34\ueb59\ueb7e\ueba3\uebc8\uebed\uec12\uec37\uec5c\uec81\ueca6\ueccb\uecf0\ued15", -296539873108446180L, "\uf22d\uf252\uf277\uf29c\uf2c1\uf2e6\uf30b\uf330\uf355\uf37a\uf39f\uf3c4", 1393594016, "\ue14b\ue170\ue195\ue1ba\ue1df\ue204\ue229\ue24e\ue273\ue298\ue2bd\ue2e2\ue307\ue32c\ue351", true, "\ue869\ue88e\ue8b3\ue8d8\ue8fd\ue922\ue947\ue96c\ue991", true, "\uef87\uefac\uefd1\ueff6\uf01b\uf040\uf065\uf08a\uf0af\uf0d4\uf0f9\uf11e\uf143\uf168", true, "\uf6a5\uf6ca\uf6ef\uf714\uf739\uf75e\uf783\uf7a8\uf7cd\uf7f2\ue017\ue03c\ue061\ue086\ue0ab\ue0d0\ue0f5", true}, {"\uec10\uec35\uec5a\uec7f\ueca4\uecc9\uecee\ued13\ued38\ued5d\ued82\ueda7\uedcc\uedf1\uee16\uee3b\uee60", -296539873108380643L, "\uf32e\uf353\uf378\uf39d\uf3c2\uf3e7\uf40c\uf431\uf456\uf47b", -458668549, "\ue24c\ue271\ue296\ue2bb\ue2e0\ue305\ue32a\ue34f\ue374\ue399\ue3be", false, "\ue96a\ue98f\ue9b4\ue9d9\ue9fe\uea23\uea48\uea6d", false, "\uf088\uf0ad\uf0d2\uf0f7\uf11c\uf141\uf166\uf18b\uf1b0\uf1d5\uf1fa", false, "\uf7a6\uf7cb\uf7f0\ue015\ue03a\ue05f\ue084\ue0a9", false}, {"\ued11\ued36\ued5b\ued80\ueda5\uedca\uedef\uee14\uee39\uee5e\uee83\ueea8", -296539873108315106L, "\uf42f\uf454\uf479\uf49e\uf4c3\uf4e8\uf50d\uf532\uf557\uf57c\uf5a1\uf5c6\uf5eb\uf610\uf635", -1237253294, "\ue34d\ue372\ue397\ue3bc\ue3e1\ue406\ue42b\ue450\ue475", true, "\uea6b\uea90\ueab5\ueada\ueaff\ueb24\ueb49\ueb6e\ueb93\uebb8\uebdd\uec02\uec27\uec4c", true, "\uf189\uf1ae\uf1d3\uf1f8\uf21d\uf242\uf267\uf28c\uf2b1\uf2d6\uf2fb\uf320\uf345\uf36a\uf38f\uf3b4\uf3d9", true, "\ue0a7\ue0cc\ue0f1\ue116\ue13b\ue160\ue185\ue1aa\ue1cf\ue1f4\ue219\ue23e\ue263\ue288", true}, {"\uee12\uee37\uee5c\uee81\ueea6\ueecb\ueef0\uef15\uef3a\uef5f", -296539873108249569L, "\uf530\uf555\uf57a\uf59f\uf5c4\uf5e9\uf60e\uf633\uf658\uf67d\uf6a2", 1205467829, "\ue44e\ue473\ue498\ue4bd\ue4e2\ue507\ue52c\ue551", false, "\ueb6c\ueb91\uebb6\uebdb\uec00\uec25\uec4a\uec6f\uec94\uecb9\uecde", false, "\uf28a\uf2af\uf2d4\uf2f9\uf31e\uf343\uf368\uf38d", false, "\ue1a8\ue1cd\ue1f2\ue217\ue23c\ue261\ue286\ue2ab\ue2d0\ue2f5\ue31a", false}, {"\uef13\uef38\uef5d\uef82\uefa7\uefcc\ueff1\uf016\uf03b\uf060\uf085\uf0aa\uf0cf\uf0f4\uf119", -296539873108184032L, "\uf631\uf656\uf67b\uf6a0\uf6c5\uf6ea\uf70f\uf734\uf759", 426881036, "\ue54f\ue574\ue599\ue5be\ue5e3\ue608\ue62d\ue652\ue677\ue69c\ue6c1\ue6e6\ue70b\ue730", true, "\uec6d\uec92\uecb7\uecdc\ued01\ued26\ued4b\ued70\ued95\uedba\ueddf\uee04\uee29\uee4e\uee73\uee98\ueebd", true, "\uf38b\uf3b0\uf3d5\uf3fa\uf41f\uf444\uf469\uf48e\uf4b3\uf4d8\uf4fd\uf522\uf547\uf56c", true, "\ue2a9\ue2ce\ue2f3\ue318\ue33d\ue362\ue387\ue3ac\ue3d1\ue3f6\ue41b\ue440\ue465\ue48a\ue4af", true}, {"\uf014\uf039\uf05e\uf083\uf0a8\uf0cd\uf0f2\uf117\uf13c\uf161\uf186", -296539873108118495L, "\uf732\uf757\uf77c\uf7a1\uf7c6\uf7eb\ue010\ue035", -1425379481, "\ue650\ue675\ue69a\ue6bf\ue6e4\ue709\ue72e\ue753\ue778\ue79d\ue7c2", false, "\ued6e\ued93\uedb8\ueddd\uee02\uee27\uee4c\uee71", false, "\uf48c\uf4b1\uf4d6\uf4fb\uf520\uf545\uf56a\uf58f\uf5b4\uf5d9\uf5fe", false, "\ue3aa\ue3cf\ue3f4\ue419\ue43e\ue463\ue488\ue4ad\ue4d2\ue4f7\ue51c", false}, {"\uf115\uf13a\uf15f\uf184\uf1a9\uf1ce\uf1f3\uf218\uf23d", -296539873108052958L, "\ue033\ue058\ue07d\ue0a2\ue0c7\ue0ec\ue111\ue136\ue15b\ue180\ue1a5\ue1ca\ue1ef\ue214", 2091001534, "\ue751\ue776\ue79b\ue7c0\ue7e5\ue80a\ue82f\ue854\ue879\ue89e\ue8c3\ue8e8\ue90d\ue932\ue957\ue97c\ue9a1", true, "\uee6f\uee94\ueeb9\ueede\uef03\uef28\uef4d\uef72\uef97\uefbc\uefe1\uf006\uf02b\uf050", true, "\uf58d\uf5b2\uf5d7\uf5fc\uf621\uf646\uf66b\uf690\uf6b5\uf6da\uf6ff\uf724\uf749\uf76e\uf793", true, "\ue4ab\ue4d0\ue4f5\ue51a\ue53f\ue564\ue589\ue5ae\ue5d3\ue5f8\ue61d\ue642\ue667\ue68c\ue6b1", true}, {"\uf216\uf23b\uf260\uf285\uf2aa\uf2cf\uf2f4\uf319", -296539873107987421L, "\ue134\ue159\ue17e\ue1a3\ue1c8\ue1ed\ue212\ue237\ue25c\ue281\ue2a6", 238689297, "\ue852\ue877\ue89c\ue8c1\ue8e6\ue90b\ue930\ue955", false, "\uef70\uef95\uefba\uefdf\uf004\uf029\uf04e\uf073\uf098\uf0bd\uf0e2", false, "\uf68e\uf6b3\uf6d8\uf6fd\uf722\uf747\uf76c\uf791\uf7b6\uf7db\ue000", false, "\ue5ac\ue5d1\ue5f6\ue61b\ue640\ue665\ue68a\ue6af\ue6d4\ue6f9\ue71e\ue743\ue768\ue78d\ue7b2\ue7d7\ue7fc", false}, {"\uf317\uf33c\uf361\uf386\uf3ab\uf3d0\uf3f5\uf41a\uf43f\uf464\uf489\uf4ae\uf4d3\uf4f8", -296539873107921884L, "\ue235\ue25a\ue27f\ue2a4\ue2c9\ue2ee\ue313\ue338\ue35d\ue382\ue3a7\ue3cc\ue3f1\ue416\ue43b\ue460\ue485", -539829400, "\ue953\ue978\ue99d\ue9c2\ue9e7\uea0c\uea31\uea56\uea7b\ueaa0\ueac5\ueaea\ueb0f\ueb34", true, "\uf071\uf096\uf0bb\uf0e0\uf105\uf12a\uf14f\uf174\uf199\uf1be\uf1e3\uf208\uf22d\uf252\uf277", true, "\uf78f\uf7b4\uf7d9\uf7fe\ue023\ue048\ue06d\ue092\ue0b7\ue0dc\ue101\ue126\ue14b\ue170\ue195", true, "\ue6ad\ue6d2\ue6f7\ue71c\ue741\ue766\ue78b\ue7b0\ue7d5\ue7fa\ue81f\ue844", true}, {"\uf418\uf43d\uf462\uf487\uf4ac\uf4d1\uf4f6\uf51b\uf540\uf565\uf58a", -296539873107856347L, "\ue336\ue35b\ue380\ue3a5\ue3ca\ue3ef\ue414\ue439", -1855286589, "\uea54\uea79\uea9e\ueac3\ueae8\ueb0d\ueb32\ueb57\ueb7c\ueba1\uebc6", false, "\uf172\uf197\uf1bc\uf1e1\uf206\uf22b\uf250\uf275\uf29a\uf2bf\uf2e4", false, "\ue090\ue0b5\ue0da\ue0ff\ue124\ue149\ue16e\ue193\ue1b8\ue1dd\ue202\ue227\ue24c\ue271\ue296\ue2bb\ue2e0", false, "\ue7ae\ue7d3\ue7f8\ue81d\ue842\ue867\ue88c\ue8b1\ue8d6\ue8fb", false}, {"\uf519\uf53e\uf563\uf588\uf5ad\uf5d2\uf5f7\uf61c\uf641\uf666\uf68b\uf6b0\uf6d5\uf6fa\uf71f\uf744\uf769", -296539873107790810L, "\ue437\ue45c\ue481\ue4a6\ue4cb\ue4f0\ue515\ue53a\ue55f\ue584\ue5a9\ue5ce\ue5f3\ue618", 587417626, "\ueb55\ueb7a\ueb9f\uebc4\uebe9\uec0e\uec33\uec58\uec7d\ueca2\uecc7\uecec\ued11\ued36\ued5b", true, "\uf273\uf298\uf2bd\uf2e2\uf307\uf32c\uf351\uf376\uf39b\uf3c0\uf3e5\uf40a\uf42f\uf454\uf479", true, "\ue191\ue1b6\ue1db\ue200\ue225\ue24a\ue26f\ue294\ue2b9\ue2de\ue303\ue328", true, "\ue8af\ue8d4\ue8f9\ue91e\ue943\ue968\ue98d\ue9b2\ue9d7\ue9fc\uea21\uea46\uea6b\uea90\ueab5", true}, {"\uf61a\uf63f\uf664\uf689\uf6ae\uf6d3\uf6f8\uf71d", -296539873107725273L, "\ue538\ue55d\ue582\ue5a7\ue5cc\ue5f1\ue616\ue63b\ue660\ue685\ue6aa", -191166595, "\uec56\uec7b\ueca0\uecc5\uecea\ued0f\ued34\ued59\ued7e\ueda3\uedc8", false, "\uf374\uf399\uf3be\uf3e3\uf408\uf42d\uf452\uf477\uf49c\uf4c1\uf4e6\uf50b\uf530\uf555\uf57a\uf59f\uf5c4", false, "\ue292\ue2b7\ue2dc\ue301\ue326\ue34b\ue370\ue395\ue3ba\ue3df", false, "\ue9b0\ue9d5\ue9fa\uea1f\uea44\uea69\uea8e\ueab3\uead8\ueafd\ueb22", false}, {"\uf71b\uf740\uf765\uf78a\uf7af\uf7d4\uf7f9\ue01e\ue043\ue068\ue08d\ue0b2\ue0d7\ue0fc", -296539873107659736L, "\ue639\ue65e\ue683\ue6a8\ue6cd\ue6f2\ue717\ue73c\ue761\ue786\ue7ab\ue7d0\ue7f5\ue81a\ue83f", -2043412780, "\ued57\ued7c\ueda1\uedc6\uedeb\uee10\uee35\uee5a\uee7f\ueea4\ueec9\ueeee\uef13\uef38\uef5d", true, "\uf475\uf49a\uf4bf\uf4e4\uf509\uf52e\uf553\uf578\uf59d\uf5c2\uf5e7\uf60c", true, "\ue393\ue3b8\ue3dd\ue402\ue427\ue44c\ue471\ue496\ue4bb\ue4e0\ue505\ue52a\ue54f\ue574\ue599", true, "\ueab1\uead6\ueafb\ueb20\ueb45\ueb6a\ueb8f\uebb4\uebd9", true}, {"\ue01c\ue041\ue066\ue08b\ue0b0\ue0d5\ue0fa\ue11f\ue144\ue169\ue18e", -296539873107594199L, "\ue73a\ue75f\ue784\ue7a9\ue7ce\ue7f3\ue818\ue83d\ue862\ue887\ue8ac", 1472967727, "\uee58\uee7d\ueea2\ueec7\ueeec\uef11\uef36\uef5b\uef80\uefa5\uefca\uefef\uf014\uf039\uf05e\uf083\uf0a8", false, "\uf576\uf59b\uf5c0\uf5e5\uf60a\uf62f\uf654\uf679\uf69e\uf6c3", false, "\ue494\ue4b9\ue4de\ue503\ue528\ue54d\ue572\ue597\ue5bc\ue5e1\ue606", false, "\uebb2\uebd7\uebfc\uec21\uec46\uec6b\uec90\uecb5", false}, {"\ue11d\ue142\ue167\ue18c\ue1b1\ue1d6\ue1fb\ue220\ue245\ue26a\ue28f\ue2b4\ue2d9\ue2fe\ue323", -296539873107528662L, "\ue83b\ue860\ue885\ue8aa\ue8cf\ue8f4\ue919\ue93e\ue963\ue988\ue9ad\ue9d2\ue9f7\uea1c\uea41", -378768506, "\uef59\uef7e\uefa3\uefc8\uefed\uf012\uf037\uf05c\uf081\uf0a6\uf0cb\uf0f0", true, "\uf677\uf69c\uf6c1\uf6e6\uf70b\uf730\uf755\uf77a\uf79f\uf7c4\uf7e9\ue00e\ue033\ue058\ue07d", true, "\ue595\ue5ba\ue5df\ue604\ue629\ue64e\ue673\ue698\ue6bd", true, "\uecb3\uecd8\uecfd\ued22\ued47\ued6c\ued91\uedb6\ueddb\uee00\uee25\uee4a\uee6f\uee94", true}, {"\ue21e\ue243\ue268\ue28d\ue2b2\ue2d7\ue2fc\ue321\ue346\ue36b\ue390", -296539873107463125L, "\ue93c\ue961\ue986\ue9ab\ue9d0\ue9f5\uea1a\uea3f\uea64\uea89\ueaae\uead3\ueaf8\ueb1d\ueb42\ueb67\ueb8c", -1157354791, "\uf05a\uf07f\uf0a4\uf0c9\uf0ee\uf113\uf138\uf15d\uf182\uf1a7", false, "\uf778\uf79d\uf7c2\uf7e7\ue00c\ue031\ue056\ue07b\ue0a0\ue0c5\ue0ea", false, "\ue696\ue6bb\ue6e0\ue705\ue72a\ue74f\ue774\ue799", false, "\uedb4\uedd9\uedfe\uee23\uee48\uee6d\uee92\ueeb7\ueedc\uef01\uef26", false}, {"\ue31f\ue344\ue369\ue38e\ue3b3\ue3d8\ue3fd\ue422\ue447\ue46c\ue491\ue4b6\ue4db\ue500\ue525", -296539873107397588L, "\uea3d\uea62\uea87\ueaac\uead1\ueaf6\ueb1b\ueb40\ueb65\ueb8a\uebaf\uebd4", 1285349424, "\uf15b\uf180\uf1a5\uf1ca\uf1ef\uf214\uf239\uf25e\uf283\uf2a8\uf2cd\uf2f2\uf317\uf33c\uf361", true, "\ue079\ue09e\ue0c3\ue0e8\ue10d\ue132\ue157\ue17c\ue1a1", true, "\ue797\ue7bc\ue7e1\ue806\ue82b\ue850\ue875\ue89a\ue8bf\ue8e4\ue909\ue92e\ue953\ue978", true, "\ueeb5\ueeda\ueeff\uef24\uef49\uef6e\uef93\uefb8\uefdd\uf002\uf027\uf04c\uf071\uf096\uf0bb\uf0e0\uf105", true}, {"\ue420\ue445\ue46a\ue48f\ue4b4\ue4d9\ue4fe\ue523\ue548\ue56d\ue592\ue5b7\ue5dc\ue601\ue626\ue64b\ue670", -296539873107332051L, "\ueb3e\ueb63\ueb88\uebad\uebd2\uebf7\uec1c\uec41\uec66\uec8b", 506781579, "\uf25c\uf281\uf2a6\uf2cb\uf2f0\uf315\uf33a\uf35f\uf384\uf3a9\uf3ce", false, "\ue17a\ue19f\ue1c4\ue1e9\ue20e\ue233\ue258\ue27d", false, "\ue898\ue8bd\ue8e2\ue907\ue92c\ue951\ue976\ue99b\ue9c0\ue9e5\uea0a", false, "\uefb6\uefdb\uf000\uf025\uf04a\uf06f\uf094\uf0b9", false}, {"\ue521\ue546\ue56b\ue590\ue5b5\ue5da\ue5ff\ue624\ue649\ue66e\ue693\ue6b8", -296539873107266514L, "\uec3f\uec64\uec89\uecae\uecd3\uecf8\ued1d\ued42\ued67\ued8c\uedb1\uedd6\uedfb\uee20\uee45", -1345546526, "\uf35d\uf382\uf3a7\uf3cc\uf3f1\uf416\uf43b\uf460\uf485", true, "\ue27b\ue2a0\ue2c5\ue2ea\ue30f\ue334\ue359\ue37e\ue3a3\ue3c8\ue3ed\ue412\ue437\ue45c", true, "\ue999\ue9be\ue9e3\uea08\uea2d\uea52\uea77\uea9c\ueac1\ueae6\ueb0b\ueb30\ueb55\ueb7a\ueb9f\uebc4\uebe9", true, "\uf0b7\uf0dc\uf101\uf126\uf14b\uf170\uf195\uf1ba\uf1df\uf204\uf229\uf24e\uf273\uf298", true}, {"\ue622\ue647\ue66c\ue691\ue6b6\ue6db\ue700\ue725\ue74a\ue76f", -296539873107200977L, "\ued40\ued65\ued8a\uedaf\uedd4\uedf9\uee1e\uee43\uee68\uee8d\ueeb2", 1634028613, "\uf45e\uf483\uf4a8\uf4cd\uf4f2\uf517\uf53c\uf561", false, "\ue37c\ue3a1\ue3c6\ue3eb\ue410\ue435\ue45a\ue47f\ue4a4\ue4c9\ue4ee", false, "\uea9a\ueabf\ueae4\ueb09\ueb2e\ueb53\ueb78\ueb9d", false, "\uf1b8\uf1dd\uf202\uf227\uf24c\uf271\uf296\uf2bb\uf2e0\uf305\uf32a", false}, {"\ue723\ue748\ue76d\ue792\ue7b7\ue7dc\ue801\ue826\ue84b\ue870\ue895\ue8ba\ue8df\ue904\ue929", -296539873107135440L, "\uee41\uee66\uee8b\ueeb0\ueed5\ueefa\uef1f\uef44\uef69", 855444380, "\uf55f\uf584\uf5a9\uf5ce\uf5f3\uf618\uf63d\uf662\uf687\uf6ac\uf6d1\uf6f6\uf71b\uf740", true, "\ue47d\ue4a2\ue4c7\ue4ec\ue511\ue536\ue55b\ue580\ue5a5\ue5ca\ue5ef\ue614\ue639\ue65e\ue683\ue6a8\ue6cd", true, "\ueb9b\uebc0\uebe5\uec0a\uec2f\uec54\uec79\uec9e\uecc3\uece8\ued0d\ued32\ued57\ued7c", true, "\uf2b9\uf2de\uf303\uf328\uf34d\uf372\uf397\uf3bc\uf3e1\uf406\uf42b\uf450\uf475\uf49a\uf4bf", true}, {"\ue824\ue849\ue86e\ue893\ue8b8\ue8dd\ue902\ue927\ue94c\ue971\ue996", -296539873107069903L, "\uef42\uef67\uef8c\uefb1\uefd6\ueffb\uf020\uf045", -996818185, "\uf660\uf685\uf6aa\uf6cf\uf6f4\uf719\uf73e\uf763\uf788\uf7ad\uf7d2", false, "\ue57e\ue5a3\ue5c8\ue5ed\ue612\ue637\ue65c\ue681", false, "\uec9c\uecc1\uece6\ued0b\ued30\ued55\ued7a\ued9f\uedc4\uede9\uee0e", false, "\uf3ba\uf3df\uf404\uf429\uf44e\uf473\uf498\uf4bd\uf4e2\uf507\uf52c", false}, {"\ue925\ue94a\ue96f\ue994\ue9b9\ue9de\uea03\uea28\uea4d", -296539873107004366L, "\uf043\uf068\uf08d\uf0b2\uf0d7\uf0fc\uf121\uf146\uf16b\uf190\uf1b5\uf1da\uf1ff\uf224", -1775388594, "\uf761\uf786\uf7ab\uf7d0\uf7f5\ue01a\ue03f\ue064\ue089\ue0ae\ue0d3\ue0f8\ue11d\ue142\ue167\ue18c\ue1b1", true, "\ue67f\ue6a4\ue6c9\ue6ee\ue713\ue738\ue75d\ue782\ue7a7\ue7cc\ue7f1\ue816\ue83b\ue860", true, "\ued9d\uedc2\uede7\uee0c\uee31\uee56\uee7b\ueea0\ueec5\ueeea\uef0f\uef34\uef59\uef7e\uefa3", true, "\uf4bb\uf4e0\uf505\uf52a\uf54f\uf574\uf599\uf5be\uf5e3\uf608\uf62d\uf652\uf677\uf69c\uf6c1", true}, {"\uea26\uea4b\uea70\uea95\ueaba\ueadf\ueb04\ueb29", -296539873106938829L, "\uf144\uf169\uf18e\uf1b3\uf1d8\uf1fd\uf222\uf247\uf26c\uf291\uf2b6", 667318177, "\ue062\ue087\ue0ac\ue0d1\ue0f6\ue11b\ue140\ue165", false, "\ue780\ue7a5\ue7ca\ue7ef\ue814\ue839\ue85e\ue883\ue8a8\ue8cd\ue8f2", false, "\uee9e\ueec3\ueee8\uef0d\uef32\uef57\uef7c\uefa1\uefc6\uefeb\uf010", false, "\uf5bc\uf5e1\uf606\uf62b\uf650\uf675\uf69a\uf6bf\uf6e4\uf709\uf72e\uf753\uf778\uf79d\uf7c2\uf7e7\ue00c", false}, {"\ueb27\ueb4c\ueb71\ueb96\uebbb\uebe0\uec05\uec2a\uec4f\uec74\uec99\uecbe\uece3\ued08", -296539873106873292L, "\uf245\uf26a\uf28f\uf2b4\uf2d9\uf2fe\uf323\uf348\uf36d\uf392\uf3b7\uf3dc\uf401\uf426\uf44b\uf470\uf495", -111268104, "\ue163\ue188\ue1ad\ue1d2\ue1f7\ue21c\ue241\ue266\ue28b\ue2b0\ue2d5\ue2fa\ue31f\ue344", true, "\ue881\ue8a6\ue8cb\ue8f0\ue915\ue93a\ue95f\ue984\ue9a9\ue9ce\ue9f3\uea18\uea3d\uea62\uea87", true, "\uef9f\uefc4\uefe9\uf00e\uf033\uf058\uf07d\uf0a2\uf0c7\uf0ec\uf111\uf136\uf15b\uf180\uf1a5", true, "\uf6bd\uf6e2\uf707\uf72c\uf751\uf776\uf79b\uf7c0\uf7e5\ue00a\ue02f\ue054", true}, {"\uec28\uec4d\uec72\uec97\uecbc\uece1\ued06\ued2b\ued50\ued75\ued9a", -296539873106807755L, "\uf346\uf36b\uf390\uf3b5\uf3da\uf3ff\uf424\uf449", -1963531181, "\ue264\ue289\ue2ae\ue2d3\ue2f8\ue31d\ue342\ue367\ue38c\ue3b1\ue3d6", false, "\ue982\ue9a7\ue9cc\ue9f1\uea16\uea3b\uea60\uea85\ueaaa\ueacf\ueaf4", false, "\uf0a0\uf0c5\uf0ea\uf10f\uf134\uf159\uf17e\uf1a3\uf1c8\uf1ed\uf212\uf237\uf25c\uf281\uf2a6\uf2cb\uf2f0", false, "\uf7be\uf7e3\ue008\ue02d\ue052\ue077\ue09c\ue0c1\ue0e6\ue10b", false}, {"\ued29\ued4e\ued73\ued98\uedbd\uede2\uee07\uee2c\uee51\uee76\uee9b\ueec0\ueee5\uef0a\uef2f\uef54\uef79", -296539873106742218L, "\uf447\uf46c\uf491\uf4b6\uf4db\uf500\uf525\uf54a\uf56f\uf594\uf5b9\uf5de\uf603\uf628", 1552851882, "\ue365\ue38a\ue3af\ue3d4\ue3f9\ue41e\ue443\ue468\ue48d\ue4b2\ue4d7\ue4fc\ue521\ue546\ue56b", true, "\uea83\ueaa8\ueacd\ueaf2\ueb17\ueb3c\ueb61\ueb86\uebab\uebd0\uebf5\uec1a\uec3f\uec64\uec89", true, "\uf1a1\uf1c6\uf1eb\uf210\uf235\uf25a\uf27f\uf2a4\uf2c9\uf2ee\uf313\uf338", true, "\ue0bf\ue0e4\ue109\ue12e\ue153\ue178\ue19d\ue1c2\ue1e7\ue20c\ue231\ue256\ue27b\ue2a0\ue2c5", true}, {"\uee2a\uee4f\uee74\uee99\ueebe\ueee3\uef08\uef2d", -296539873106676681L, "\uf548\uf56d\uf592\uf5b7\uf5dc\uf601\uf626\uf64b\uf670\uf695\uf6ba", -299460339, "\ue466\ue48b\ue4b0\ue4d5\ue4fa\ue51f\ue544\ue569\ue58e\ue5b3\ue5d8", false, "\ueb84\ueba9\uebce\uebf3\uec18\uec3d\uec62\uec87\uecac\uecd1\uecf6\ued1b\ued40\ued65\ued8a\uedaf\uedd4", false, "\uf2a2\uf2c7\uf2ec\uf311\uf336\uf35b\uf380\uf3a5\uf3ca\uf3ef", false, "\ue1c0\ue1e5\ue20a\ue22f\ue254\ue279\ue29e\ue2c3\ue2e8\ue30d\ue332", false}, {"\uef2b\uef50\uef75\uef9a\uefbf\uefe4\uf009\uf02e\uf053\uf078\uf09d\uf0c2\uf0e7\uf10c", -296539873106611144L, "\uf649\uf66e\uf693\uf6b8\uf6dd\uf702\uf727\uf74c\uf771\uf796\uf7bb\uf7e0\ue005\ue02a\ue04f", -1077981084, "\ue567\ue58c\ue5b1\ue5d6\ue5fb\ue620\ue645\ue66a\ue68f\ue6b4\ue6d9\ue6fe\ue723\ue748\ue76d", true, "\uec85\uecaa\ueccf\uecf4\ued19\ued3e\ued63\ued88\uedad\uedd2\uedf7\uee1c", true, "\uf3a3\uf3c8\uf3ed\uf412\uf437\uf45c\uf481\uf4a6\uf4cb\uf4f0\uf515\uf53a\uf55f\uf584\uf5a9", true, "\ue2c1\ue2e6\ue30b\ue330\ue355\ue37a\ue39f\ue3c4\ue3e9", true}, {"\uf02c\uf051\uf076\uf09b\uf0c0\uf0e5\uf10a\uf12f\uf154\uf179\uf19e", -296539873106545607L, "\uf74a\uf76f\uf794\uf7b9\uf7de\ue003\ue028\ue04d\ue072\ue097\ue0bc", 1901531071, "\ue668\ue68d\ue6b2\ue6d7\ue6fc\ue721\ue746\ue76b\ue790\ue7b5\ue7da\ue7ff\ue824\ue849\ue86e\ue893\ue8b8", false, "\ued86\uedab\uedd0\uedf5\uee1a\uee3f\uee64\uee89\ueeae\ueed3", false, "\uf4a4\uf4c9\uf4ee\uf513\uf538\uf55d\uf582\uf5a7\uf5cc\uf5f1\uf616", false, "\ue3c2\ue3e7\ue40c\ue431\ue456\ue47b\ue4a0\ue4c5", false}, {"\uf12d\uf152\uf177\uf19c\uf1c1\uf1e6\uf20b\uf230\uf255\uf27a\uf29f\uf2c4\uf2e9\uf30e\uf333", -296539873106480070L, "\ue04b\ue070\ue095\ue0ba\ue0df\ue104\ue129\ue14e\ue173\ue198\ue1bd\ue1e2\ue207\ue22c\ue251", 49267990, "\ue769\ue78e\ue7b3\ue7d8\ue7fd\ue822\ue847\ue86c\ue891\ue8b6\ue8db\ue900", true, "\uee87\ueeac\ueed1\ueef6\uef1b\uef40\uef65\uef8a\uefaf\uefd4\ueff9\uf01e\uf043\uf068\uf08d", true, "\uf5a5\uf5ca\uf5ef\uf614\uf639\uf65e\uf683\uf6a8\uf6cd", true, "\ue4c3\ue4e8\ue50d\ue532\ue557\ue57c\ue5a1\ue5c6\ue5eb\ue610\ue635\ue65a\ue67f\ue6a4", true}, {"\uf22e\uf253\uf278\uf29d\uf2c2\uf2e7\uf30c\uf331\uf356\uf37b\uf3a0", -296539873106414533L, "\ue14c\ue171\ue196\ue1bb\ue1e0\ue205\ue22a\ue24f\ue274\ue299\ue2be\ue2e3\ue308\ue32d\ue352\ue377\ue39c", -729301911, "\ue86a\ue88f\ue8b4\ue8d9\ue8fe\ue923\ue948\ue96d\ue992\ue9b7", false, "\uef88\uefad\uefd2\ueff7\uf01c\uf041\uf066\uf08b\uf0b0\uf0d5\uf0fa", false, "\uf6a6\uf6cb\uf6f0\uf715\uf73a\uf75f\uf784\uf7a9", false, "\ue5c4\ue5e9\ue60e\ue633\ue658\ue67d\ue6a2\ue6c7\ue6ec\ue711\ue736", false}, {"\uf32f\uf354\uf379\uf39e\uf3c3\uf3e8\uf40d\uf432\uf457\uf47c\uf4a1\uf4c6\uf4eb\uf510\uf535", -296539873106348996L, "\ue24d\ue272\ue297\ue2bc\ue2e1\ue306\ue32b\ue350\ue375\ue39a\ue3bf\ue3e4", 1712880576, "\ue96b\ue990\ue9b5\ue9da\ue9ff\uea24\uea49\uea6e\uea93\ueab8\ueadd\ueb02\ueb27\ueb4c\ueb71", true, "\uf089\uf0ae\uf0d3\uf0f8\uf11d\uf142\uf167\uf18c\uf1b1", true, "\uf7a7\uf7cc\uf7f1\ue016\ue03b\ue060\ue085\ue0aa\ue0cf\ue0f4\ue119\ue13e\ue163\ue188", true, "\ue6c5\ue6ea\ue70f\ue734\ue759\ue77e\ue7a3\ue7c8\ue7ed\ue812\ue837\ue85c\ue881\ue8a6\ue8cb\ue8f0\ue915", true}, {"\uf430\uf455\uf47a\uf49f\uf4c4\uf4e9\uf50e\uf533\uf558\uf57d\uf5a2\uf5c7\uf5ec\uf611\uf636\uf65b\uf680", -296539873106283459L, "\ue34e\ue373\ue398\ue3bd\ue3e2\ue407\ue42c\ue451\ue476\ue49b", 934293787, "\uea6c\uea91\ueab6\ueadb\ueb00\ueb25\ueb4a\ueb6f\ueb94\uebb9\uebde", false, "\uf18a\uf1af\uf1d4\uf1f9\uf21e\uf243\uf268\uf28d", false, "\ue0a8\ue0cd\ue0f2\ue117\ue13c\ue161\ue186\ue1ab\ue1d0\ue1f5\ue21a", false, "\ue7c6\ue7eb\ue810\ue835\ue85a\ue87f\ue8a4\ue8c9", false}, {"\uf531\uf556\uf57b\uf5a0\uf5c5\uf5ea\uf60f\uf634\uf659\uf67e\uf6a3\uf6c8", -296539873106217922L, "\ue44f\ue474\ue499\ue4be\ue4e3\ue508\ue52d\ue552\ue577\ue59c\ue5c1\ue5e6\ue60b\ue630\ue655", -917968782, "\ueb6d\ueb92\uebb7\uebdc\uec01\uec26\uec4b\uec70\uec95", true, "\uf28b\uf2b0\uf2d5\uf2fa\uf31f\uf344\uf369\uf38e\uf3b3\uf3d8\uf3fd\uf422\uf447\uf46c", true, "\ue1a9\ue1ce\ue1f3\ue218\ue23d\ue262\ue287\ue2ac\ue2d1\ue2f6\ue31b\ue340\ue365\ue38a\ue3af\ue3d4\ue3f9", true, "\ue8c7\ue8ec\ue911\ue936\ue95b\ue980\ue9a5\ue9ca\ue9ef\uea14\uea39\uea5e\uea83\ueaa8", true}, {"\uf632\uf657\uf67c\uf6a1\uf6c6\uf6eb\uf710\uf735\uf75a\uf77f", -296539873106152385L, "\ue550\ue575\ue59a\ue5bf\ue5e4\ue609\ue62e\ue653\ue678\ue69d\ue6c2", -1696553003, "\uec6e\uec93\uecb8\uecdd\ued02\ued27\ued4c\ued71", false, "\uf38c\uf3b1\uf3d6\uf3fb\uf420\uf445\uf46a\uf48f\uf4b4\uf4d9\uf4fe", false, "\ue2aa\ue2cf\ue2f4\ue319\ue33e\ue363\ue388\ue3ad", false, "\ue9c8\ue9ed\uea12\uea37\uea5c\uea81\ueaa6\ueacb\ueaf0\ueb15\ueb3a", false}, {"\uf733\uf758\uf77d\uf7a2\uf7c7\uf7ec\ue011\ue036\ue05b\ue080\ue0a5\ue0ca\ue0ef\ue114\ue139", -296539873106086848L, "\ue651\ue676\ue69b\ue6c0\ue6e5\ue70a\ue72f\ue754\ue779", 746102060, "\ued6f\ued94\uedb9\uedde\uee03\uee28\uee4d\uee72\uee97\ueebc\ueee1\uef06\uef2b\uef50", true, "\uf48d\uf4b2\uf4d7\uf4fc\uf521\uf546\uf56b\uf590\uf5b5\uf5da\uf5ff\uf624\uf649\uf66e\uf693\uf6b8\uf6dd", true, "\ue3ab\ue3d0\ue3f5\ue41a\ue43f\ue464\ue489\ue4ae\ue4d3\ue4f8\ue51d\ue542\ue567\ue58c", true, "\ueac9\ueaee\ueb13\ueb38\ueb5d\ueb82\ueba7\uebcc\uebf1\uec16\uec3b\uec60\uec85\uecaa\ueccf", true}, {"\ue034\ue059\ue07e\ue0a3\ue0c8\ue0ed\ue112\ue137\ue15c\ue181\ue1a6", -296539873106021311L, "\ue752\ue777\ue79c\ue7c1\ue7e6\ue80b\ue830\ue855", -32418681, "\uee70\uee95\ueeba\ueedf\uef04\uef29\uef4e\uef73\uef98\uefbd\uefe2", false, "\uf58e\uf5b3\uf5d8\uf5fd\uf622\uf647\uf66c\uf691", false, "\ue4ac\ue4d1\ue4f6\ue51b\ue540\ue565\ue58a\ue5af\ue5d4\ue5f9\ue61e", false, "\uebca\uebef\uec14\uec39\uec5e\uec83\ueca8\ueccd\uecf2\ued17\ued3c", false}, {"\ue135\ue15a\ue17f\ue1a4\ue1c9\ue1ee\ue213\ue238\ue25d", -296539873105955774L, "\ue853\ue878\ue89d\ue8c2\ue8e7\ue90c\ue931\ue956\ue97b\ue9a0\ue9c5\ue9ea\uea0f\uea34", -1884744738, "\uef71\uef96\uefbb\uefe0\uf005\uf02a\uf04f\uf074\uf099\uf0be\uf0e3\uf108\uf12d\uf152\uf177\uf19c\uf1c1", true, "\uf68f\uf6b4\uf6d9\uf6fe\uf723\uf748\uf76d\uf792\uf7b7\uf7dc\ue001\ue026\ue04b\ue070", true, "\ue5ad\ue5d2\ue5f7\ue61c\ue641\ue666\ue68b\ue6b0\ue6d5\ue6fa\ue71f\ue744\ue769\ue78e\ue7b3", true, "\ueccb\uecf0\ued15\ued3a\ued5f\ued84\ueda9\uedce\uedf3\uee18\uee3d\uee62\uee87\ueeac\ueed1", true}, {"\ue236\ue25b\ue280\ue2a5\ue2ca\ue2ef\ue314\ue339", -296539873105890237L, "\ue954\ue979\ue99e\ue9c3\ue9e8\uea0d\uea32\uea57\uea7c\ueaa1\ueac6", 1094830385, "\uf072\uf097\uf0bc\uf0e1\uf106\uf12b\uf150\uf175", false, "\uf790\uf7b5\uf7da\uf7ff\ue024\ue049\ue06e\ue093\ue0b8\ue0dd\ue102", false, "\ue6ae\ue6d3\ue6f8\ue71d\ue742\ue767\ue78c\ue7b1\ue7d6\ue7fb\ue820", false, "\uedcc\uedf1\uee16\uee3b\uee60\uee85\ueeaa\ueecf\ueef4\uef19\uef3e\uef63\uef88\uefad\uefd2\ueff7\uf01c", false}, {"\ue337\ue35c\ue381\ue3a6\ue3cb\ue3f0\ue415\ue43a\ue45f\ue484\ue4a9\ue4ce\ue4f3\ue518", -296539873105824700L, "\uea55\uea7a\uea9f\ueac4\ueae9\ueb0e\ueb33\ueb58\ueb7d\ueba2\uebc7\uebec\uec11\uec36\uec5b\uec80\ueca5", 316244104, "\uf173\uf198\uf1bd\uf1e2\uf207\uf22c\uf251\uf276\uf29b\uf2c0\uf2e5\uf30a\uf32f\uf354", true, "\ue091\ue0b6\ue0db\ue100\ue125\ue14a\ue16f\ue194\ue1b9\ue1de\ue203\ue228\ue24d\ue272\ue297", true, "\ue7af\ue7d4\ue7f9\ue81e\ue843\ue868\ue88d\ue8b2\ue8d7\ue8fc\ue921\ue946\ue96b\ue990\ue9b5", true, "\ueecd\ueef2\uef17\uef3c\uef61\uef86\uefab\uefd0\ueff5\uf01a\uf03f\uf064", true}, {"\ue438\ue45d\ue482\ue4a7\ue4cc\ue4f1\ue516\ue53b\ue560\ue585\ue5aa", -296539873105759163L, "\ueb56\ueb7b\ueba0\uebc5\uebea\uec0f\uec34\uec59", -1536000029, "\uf274\uf299\uf2be\uf2e3\uf308\uf32d\uf352\uf377\uf39c\uf3c1\uf3e6", false, "\ue192\ue1b7\ue1dc\ue201\ue226\ue24b\ue270\ue295\ue2ba\ue2df\ue304", false, "\ue8b0\ue8d5\ue8fa\ue91f\ue944\ue969\ue98e\ue9b3\ue9d8\ue9fd\uea22\uea47\uea6c\uea91\ueab6\ueadb\ueb00", false, "\uefce\ueff3\uf018\uf03d\uf062\uf087\uf0ac\uf0d1\uf0f6\uf11b", false}, {"\ue539\ue55e\ue583\ue5a8\ue5cd\ue5f2\ue617\ue63c\ue661\ue686\ue6ab\ue6d0\ue6f5\ue71a\ue73f\ue764\ue789", -296539873105693626L, "\uec57\uec7c\ueca1\uecc6\ueceb\ued10\ued35\ued5a\ued7f\ueda4\uedc9\uedee\uee13\uee38", 1980380474, "\uf375\uf39a\uf3bf\uf3e4\uf409\uf42e\uf453\uf478\uf49d\uf4c2\uf4e7\uf50c\uf531\uf556\uf57b", true, "\ue293\ue2b8\ue2dd\ue302\ue327\ue34c\ue371\ue396\ue3bb\ue3e0\ue405\ue42a\ue44f\ue474\ue499", true, "\ue9b1\ue9d6\ue9fb\uea20\uea45\uea6a\uea8f\ueab4\uead9\ueafe\ueb23\ueb48", true, "\uf0cf\uf0f4\uf119\uf13e\uf163\uf188\uf1ad\uf1d2\uf1f7\uf21c\uf241\uf266\uf28b\uf2b0\uf2d5", true}, {"\ue63a\ue65f\ue684\ue6a9\ue6ce\ue6f3\ue718\ue73d", -296539873105628089L, "\ued58\ued7d\ueda2\uedc7\uedec\uee11\uee36\uee5b\uee80\ueea5\ueeca", 128117917, "\uf476\uf49b\uf4c0\uf4e5\uf50a\uf52f\uf554\uf579\uf59e\uf5c3\uf5e8", false, "\ue394\ue3b9\ue3de\ue403\ue428\ue44d\ue472\ue497\ue4bc\ue4e1\ue506\ue52b\ue550\ue575\ue59a\ue5bf\ue5e4", false, "\ueab2\uead7\ueafc\ueb21\ueb46\ueb6b\ueb90\uebb5\uebda\uebff", false, "\uf1d0\uf1f5\uf21a\uf23f\uf264\uf289\uf2ae\uf2d3\uf2f8\uf31d\uf342", false}, {"\ue73b\ue760\ue785\ue7aa\ue7cf\ue7f4\ue819\ue83e\ue863\ue888\ue8ad\ue8d2\ue8f7\ue91c", -296539873105562552L, "\uee59\uee7e\ueea3\ueec8\ueeed\uef12\uef37\uef5c\uef81\uefa6\uefcb\ueff0\uf015\uf03a\uf05f", -650466316, "\uf577\uf59c\uf5c1\uf5e6\uf60b\uf630\uf655\uf67a\uf69f\uf6c4\uf6e9\uf70e\uf733\uf758\uf77d", true, "\ue495\ue4ba\ue4df\ue504\ue529\ue54e\ue573\ue598\ue5bd\ue5e2\ue607\ue62c", true, "\uebb3\uebd8\uebfd\uec22\uec47\uec6c\uec91\uecb6\uecdb\ued00\ued25\ued4a\ued6f\ued94\uedb9", true, "\uf2d1\uf2f6\uf31b\uf340\uf365\uf38a\uf3af\uf3d4\uf3f9", true}, {"\ue83c\ue861\ue886\ue8ab\ue8d0\ue8f5\ue91a\ue93f\ue964\ue989\ue9ae", -296539873105497015L, "\uef5a\uef7f\uefa4\uefc9\uefee\uf013\uf038\uf05d\uf082\uf0a7\uf0cc", 1792237903, "\uf678\uf69d\uf6c2\uf6e7\uf70c\uf731\uf756\uf77b\uf7a0\uf7c5\uf7ea\ue00f\ue034\ue059\ue07e\ue0a3\ue0c8", false, "\ue596\ue5bb\ue5e0\ue605\ue62a\ue64f\ue674\ue699\ue6be\ue6e3", false, "\uecb4\uecd9\uecfe\ued23\ued48\ued6d\ued92\uedb7\ueddc\uee01\uee26", false, "\uf3d2\uf3f7\uf41c\uf441\uf466\uf48b\uf4b0\uf4d5", false}, {"\ue93d\ue962\ue987\ue9ac\ue9d1\ue9f6\uea1b\uea40\uea65\uea8a\ueaaf\uead4\ueaf9\ueb1e\ueb43", -296539873105431478L, "\uf05b\uf080\uf0a5\uf0ca\uf0ef\uf114\uf139\uf15e\uf183\uf1a8\uf1cd\uf1f2\uf217\uf23c\uf261", 1013668006, "\uf779\uf79e\uf7c3\uf7e8\ue00d\ue032\ue057\ue07c\ue0a1\ue0c6\ue0eb\ue110", true, "\ue697\ue6bc\ue6e1\ue706\ue72b\ue750\ue775\ue79a\ue7bf\ue7e4\ue809\ue82e\ue853\ue878\ue89d", true, "\uedb5\uedda\uedff\uee24\uee49\uee6e\uee93\ueeb8\ueedd", true, "\uf4d3\uf4f8\uf51d\uf542\uf567\uf58c\uf5b1\uf5d6\uf5fb\uf620\uf645\uf66a\uf68f\uf6b4", true}, {"\uea3e\uea63\uea88\ueaad\uead2\ueaf7\ueb1c\ueb41\ueb66\ueb8b\uebb0", -296539873105365941L, "\uf15c\uf181\uf1a6\uf1cb\uf1f0\uf215\uf23a\uf25f\uf284\uf2a9\uf2ce\uf2f3\uf318\uf33d\uf362\uf387\uf3ac", -838658055, "\ue07a\ue09f\ue0c4\ue0e9\ue10e\ue133\ue158\ue17d\ue1a2\ue1c7", false, "\ue798\ue7bd\ue7e2\ue807\ue82c\ue851\ue876\ue89b\ue8c0\ue8e5\ue90a", false, "\ueeb6\ueedb\uef00\uef25\uef4a\uef6f\uef94\uefb9", false, "\uf5d4\uf5f9\uf61e\uf643\uf668\uf68d\uf6b2\uf6d7\uf6fc\uf721\uf746", false}, {"\ueb3f\ueb64\ueb89\uebae\uebd3\uebf8\uec1d\uec42\uec67\uec8c\uecb1\uecd6\uecfb\ued20\ued45", -296539873105300404L, "\uf25d\uf282\uf2a7\uf2cc\uf2f1\uf316\uf33b\uf360\uf385\uf3aa\uf3cf\uf3f4", -1617179312, "\ue17b\ue1a0\ue1c5\ue1ea\ue20f\ue234\ue259\ue27e\ue2a3\ue2c8\ue2ed\ue312\ue337\ue35c\ue381", true, "\ue899\ue8be\ue8e3\ue908\ue92d\ue952\ue977\ue99c\ue9c1", true, "\uefb7\uefdc\uf001\uf026\uf04b\uf070\uf095\uf0ba\uf0df\uf104\uf129\uf14e\uf173\uf198", true, "\uf6d5\uf6fa\uf71f\uf744\uf769\uf78e\uf7b3\uf7d8\uf7fd\ue022\ue047\ue06c\ue091\ue0b6\ue0db\ue100\ue125", true}, {"\uec40\uec65\uec8a\uecaf\uecd4\uecf9\ued1e\ued43\ued68\ued8d\uedb2\uedd7\uedfc\uee21\uee46\uee6b\uee90", -296539873105234867L, "\uf35e\uf383\uf3a8\uf3cd\uf3f2\uf417\uf43c\uf461\uf486\uf4ab", 1362330795, "\ue27c\ue2a1\ue2c6\ue2eb\ue310\ue335\ue35a\ue37f\ue3a4\ue3c9\ue3ee", false, "\ue99a\ue9bf\ue9e4\uea09\uea2e\uea53\uea78\uea9d", false, "\uf0b8\uf0dd\uf102\uf127\uf14c\uf171\uf196\uf1bb\uf1e0\uf205\uf22a", false, "\uf7d6\uf7fb\ue020\ue045\ue06a\ue08f\ue0b4\ue0d9", false}, {"\ued41\ued66\ued8b\uedb0\uedd5\uedfa\uee1f\uee44\uee69\uee8e\ueeb3\ueed8", -296539873105169330L, "\uf45f\uf484\uf4a9\uf4ce\uf4f3\uf518\uf53d\uf562\uf587\uf5ac\uf5d1\uf5f6\uf61b\uf640\uf665", -489405950, "\ue37d\ue3a2\ue3c7\ue3ec\ue411\ue436\ue45b\ue480\ue4a5", true, "\uea9b\ueac0\ueae5\ueb0a\ueb2f\ueb54\ueb79\ueb9e\uebc3\uebe8\uec0d\uec32\uec57\uec7c", true, "\uf1b9\uf1de\uf203\uf228\uf24d\uf272\uf297\uf2bc\uf2e1\uf306\uf32b\uf350\uf375\uf39a\uf3bf\uf3e4\uf409", true, "\ue0d7\ue0fc\ue121\ue146\ue16b\ue190\ue1b5\ue1da\ue1ff\ue224\ue249\ue26e\ue293\ue2b8", true}, {"\uee42\uee67\uee8c\ueeb1\ueed6\ueefb\uef20\uef45\uef6a\uef8f", -296539873105103793L, "\uf560\uf585\uf5aa\uf5cf\uf5f4\uf619\uf63e\uf663\uf688\uf6ad\uf6d2", -1267975835, "\ue47e\ue4a3\ue4c8\ue4ed\ue512\ue537\ue55c\ue581", false, "\ueb9c\uebc1\uebe6\uec0b\uec30\uec55\uec7a\uec9f\uecc4\uece9\ued0e", false, "\uf2ba\uf2df\uf304\uf329\uf34e\uf373\uf398\uf3bd", false, "\ue1d8\ue1fd\ue222\ue247\ue26c\ue291\ue2b6\ue2db\ue300\ue325\ue34a", false}, {"\uef43\uef68\uef8d\uefb2\uefd7\ueffc\uf021\uf046\uf06b\uf090\uf0b5\uf0da\uf0ff\uf124\uf149", -296539873105038256L, "\uf661\uf686\uf6ab\uf6d0\uf6f5\uf71a\uf73f\uf764\uf789", 1174728892, "\ue57f\ue5a4\ue5c9\ue5ee\ue613\ue638\ue65d\ue682\ue6a7\ue6cc\ue6f1\ue716\ue73b\ue760", true, "\uec9d\uecc2\uece7\ued0c\ued31\ued56\ued7b\ueda0\uedc5\uedea\uee0f\uee34\uee59\uee7e\ueea3\ueec8\ueeed", true, "\uf3bb\uf3e0\uf405\uf42a\uf44f\uf474\uf499\uf4be\uf4e3\uf508\uf52d\uf552\uf577\uf59c", true, "\ue2d9\ue2fe\ue323\ue348\ue36d\ue392\ue3b7\ue3dc\ue401\ue426\ue44b\ue470\ue495\ue4ba\ue4df", true}, {"\uf044\uf069\uf08e\uf0b3\uf0d8\uf0fd\uf122\uf147\uf16c\uf191\uf1b6", -296539873104972719L, "\uf762\uf787\uf7ac\uf7d1\uf7f6\ue01b\ue040\ue065", 396144151, "\ue680\ue6a5\ue6ca\ue6ef\ue714\ue739\ue75e\ue783\ue7a8\ue7cd\ue7f2", false, "\ued9e\uedc3\uede8\uee0d\uee32\uee57\uee7c\ueea1", false, "\uf4bc\uf4e1\uf506\uf52b\uf550\uf575\uf59a\uf5bf\uf5e4\uf609\uf62e", false, "\ue3da\ue3ff\ue424\ue449\ue46e\ue493\ue4b8\ue4dd\ue502\ue527\ue54c", false}, {"\uf145\uf16a\uf18f\uf1b4\uf1d9\uf1fe\uf223\uf248\uf26d", -296539873104907182L, "\ue063\ue088\ue0ad\ue0d2\ue0f7\ue11c\ue141\ue166\ue18b\ue1b0\ue1d5\ue1fa\ue21f\ue244", -1456118418, "\ue781\ue7a6\ue7cb\ue7f0\ue815\ue83a\ue85f\ue884\ue8a9\ue8ce\ue8f3\ue918\ue93d\ue962\ue987\ue9ac\ue9d1", true, "\uee9f\ueec4\ueee9\uef0e\uef33\uef58\uef7d\uefa2\uefc7\uefec\uf011\uf036\uf05b\uf080", true, "\uf5bd\uf5e2\uf607\uf62c\uf651\uf676\uf69b\uf6c0\uf6e5\uf70a\uf72f\uf754\uf779\uf79e\uf7c3", true, "\ue4db\ue500\ue525\ue54a\ue56f\ue594\ue5b9\ue5de\ue603\ue628\ue64d\ue672\ue697\ue6bc\ue6e1", true}, {"\uf246\uf26b\uf290\uf2b5\uf2da\uf2ff\uf324\uf349", -296539873104841645L, "\ue164\ue189\ue1ae\ue1d3\ue1f8\ue21d\ue242\ue267\ue28c\ue2b1\ue2d6", 2060278977, "\ue882\ue8a7\ue8cc\ue8f1\ue916\ue93b\ue960\ue985", false, "\uefa0\uefc5\uefea\uf00f\uf034\uf059\uf07e\uf0a3\uf0c8\uf0ed\uf112", false, "\uf6be\uf6e3\uf708\uf72d\uf752\uf777\uf79c\uf7c1\uf7e6\ue00b\ue030", false, "\ue5dc\ue601\ue626\ue64b\ue670\ue695\ue6ba\ue6df\ue704\ue729\ue74e\ue773\ue798\ue7bd\ue7e2\ue807\ue82c", false}, {"\uf347\uf36c\uf391\uf3b6\uf3db\uf400\uf425\uf44a\uf46f\uf494\uf4b9\uf4de\uf503\uf528", -296539873104776108L, "\ue265\ue28a\ue2af\ue2d4\ue2f9\ue31e\ue343\ue368\ue38d\ue3b2\ue3d7\ue3fc\ue421\ue446\ue46b\ue490\ue4b5", 207952408, "\ue983\ue9a8\ue9cd\ue9f2\uea17\uea3c\uea61\uea86\ueaab\uead0\ueaf5\ueb1a\ueb3f\ueb64", true, "\uf0a1\uf0c6\uf0eb\uf110\uf135\uf15a\uf17f\uf1a4\uf1c9\uf1ee\uf213\uf238\uf25d\uf282\uf2a7", true, "\uf7bf\uf7e4\ue009\ue02e\ue053\ue078\ue09d\ue0c2\ue0e7\ue10c\ue131\ue156\ue17b\ue1a0\ue1c5", true, "\ue6dd\ue702\ue727\ue74c\ue771\ue796\ue7bb\ue7e0\ue805\ue82a\ue84f\ue874", true}, {"\uf448\uf46d\uf492\uf4b7\uf4dc\uf501\uf526\uf54b\uf570\uf595\uf5ba", -296539873104710571L, "\ue366\ue38b\ue3b0\ue3d5\ue3fa\ue41f\ue444\ue469", -570568333, "\uea84\ueaa9\ueace\ueaf3\ueb18\ueb3d\ueb62\ueb87\uebac\uebd1\uebf6", false, "\uf1a2\uf1c7\uf1ec\uf211\uf236\uf25b\uf280\uf2a5\uf2ca\uf2ef\uf314", false, "\ue0c0\ue0e5\ue10a\ue12f\ue154\ue179\ue19e\ue1c3\ue1e8\ue20d\ue232\ue257\ue27c\ue2a1\ue2c6\ue2eb\ue310", false, "\ue7de\ue803\ue828\ue84d\ue872\ue897\ue8bc\ue8e1\ue906\ue92b", false}, {"\uf549\uf56e\uf593\uf5b8\uf5dd\uf602\uf627\uf64c\uf671\uf696\uf6bb\uf6e0\uf705\uf72a\uf74f\uf774\uf799", -296539873104645034L, "\ue467\ue48c\ue4b1\ue4d6\ue4fb\ue520\ue545\ue56a\ue58f\ue5b4\ue5d9\ue5fe\ue623\ue648", 1872070858, "\ueb85\uebaa\uebcf\uebf4\uec19\uec3e\uec63\uec88\uecad\uecd2\uecf7\ued1c\ued41\ued66\ued8b", true, "\uf2a3\uf2c8\uf2ed\uf312\uf337\uf35c\uf381\uf3a6\uf3cb\uf3f0\uf415\uf43a\uf45f\uf484\uf4a9", true, "\ue1c1\ue1e6\ue20b\ue230\ue255\ue27a\ue29f\ue2c4\ue2e9\ue30e\ue333\ue358", true, "\ue8df\ue904\ue929\ue94e\ue973\ue998\ue9bd\ue9e2\uea07\uea2c\uea51\uea76\uea9b\ueac0\ueae5", true}, {"\uf64a\uf66f\uf694\uf6b9\uf6de\uf703\uf728\uf74d", -296539873104579497L, "\ue568\ue58d\ue5b2\ue5d7\ue5fc\ue621\ue646\ue66b\ue690\ue6b5\ue6da", 556680749, "\uec86\uecab\uecd0\uecf5\ued1a\ued3f\ued64\ued89\uedae\uedd3\uedf8", false, "\uf3a4\uf3c9\uf3ee\uf413\uf438\uf45d\uf482\uf4a7\uf4cc\uf4f1\uf516\uf53b\uf560\uf585\uf5aa\uf5cf\uf5f4", false, "\ue2c2\ue2e7\ue30c\ue331\ue356\ue37b\ue3a0\ue3c5\ue3ea\ue40f", false, "\ue9e0\uea05\uea2a\uea4f\uea74\uea99\ueabe\ueae3\ueb08\ueb2d\ueb52", false}, {"\uf74b\uf770\uf795\uf7ba\uf7df\ue004\ue029\ue04e\ue073\ue098\ue0bd\ue0e2\ue107\ue12c", -296539873104513960L, "\ue669\ue68e\ue6b3\ue6d8\ue6fd\ue722\ue747\ue76c\ue791\ue7b6\ue7db\ue800\ue825\ue84a\ue86f", -221889148, "\ued87\uedac\uedd1\uedf6\uee1b\uee40\uee65\uee8a\ueeaf\ueed4\ueef9\uef1e\uef43\uef68\uef8d", true, "\uf4a5\uf4ca\uf4ef\uf514\uf539\uf55e\uf583\uf5a8\uf5cd\uf5f2\uf617\uf63c", true, "\ue3c3\ue3e8\ue40d\ue432\ue457\ue47c\ue4a1\ue4c6\ue4eb\ue510\ue535\ue55a\ue57f\ue5a4\ue5c9", true, "\ueae1\ueb06\ueb2b\ueb50\ueb75\ueb9a\uebbf\uebe4\uec09", true}, {"\ue04c\ue071\ue096\ue0bb\ue0e0\ue105\ue12a\ue14f\ue174\ue199\ue1be", -296539873104448423L, "\ue76a\ue78f\ue7b4\ue7d9\ue7fe\ue823\ue848\ue86d\ue892\ue8b7\ue8dc", -2074151713, "\uee88\ueead\ueed2\ueef7\uef1c\uef41\uef66\uef8b\uefb0\uefd5\ueffa\uf01f\uf044\uf069\uf08e\uf0b3\uf0d8", false, "\uf5a6\uf5cb\uf5f0\uf615\uf63a\uf65f\uf684\uf6a9\uf6ce\uf6f3", false, "\ue4c4\ue4e9\ue50e\ue533\ue558\ue57d\ue5a2\ue5c7\ue5ec\ue611\ue636", false, "\uebe2\uec07\uec2c\uec51\uec76\uec9b\uecc0\uece5", false}, {"\ue14d\ue172\ue197\ue1bc\ue1e1\ue206\ue22b\ue250\ue275\ue29a\ue2bf\ue2e4\ue309\ue32e\ue353", -296539873104382886L, "\ue86b\ue890\ue8b5\ue8da\ue8ff\ue924\ue949\ue96e\ue993\ue9b8\ue9dd\uea02\uea27\uea4c\uea71", 1442230838, "\uef89\uefae\uefd3\ueff8\uf01d\uf042\uf067\uf08c\uf0b1\uf0d6\uf0fb\uf120", true, "\uf6a7\uf6cc\uf6f1\uf716\uf73b\uf760\uf785\uf7aa\uf7cf\uf7f4\ue019\ue03e\ue063\ue088\ue0ad", true, "\ue5c5\ue5ea\ue60f\ue634\ue659\ue67e\ue6a3\ue6c8\ue6ed", true, "\uece3\ued08\ued2d\ued52\ued77\ued9c\uedc1\uede6\uee0b\uee30\uee55\uee7a\uee9f\ueec4", true}, {"\ue24e\ue273\ue298\ue2bd\ue2e2\ue307\ue32c\ue351\ue376\ue39b\ue3c0", -296539873104317349L, "\ue96c\ue991\ue9b6\ue9db\uea00\uea25\uea4a\uea6f\uea94\ueab9\ueade\ueb03\ueb28\ueb4d\ueb72\ueb97\uebbc", -410031735, "\uf08a\uf0af\uf0d4\uf0f9\uf11e\uf143\uf168\uf18d\uf1b2\uf1d7", false, "\uf7a8\uf7cd\uf7f2\ue017\ue03c\ue061\ue086\ue0ab\ue0d0\ue0f5\ue11a", false, "\ue6c6\ue6eb\ue710\ue735\ue75a\ue77f\ue7a4\ue7c9", false, "\uede4\uee09\uee2e\uee53\uee78\uee9d\ueec2\ueee7\uef0c\uef31\uef56", false}, {"\ue34f\ue374\ue399\ue3be\ue3e3\ue408\ue42d\ue452\ue477\ue49c\ue4c1\ue4e6\ue50b\ue530\ue555", -296539873104251812L, "\uea6d\uea92\ueab7\ueadc\ueb01\ueb26\ueb4b\ueb70\ueb95\uebba\uebdf\uec04", -1188618016, "\uf18b\uf1b0\uf1d5\uf1fa\uf21f\uf244\uf269\uf28e\uf2b3\uf2d8\uf2fd\uf322\uf347\uf36c\uf391", true, "\ue0a9\ue0ce\ue0f3\ue118\ue13d\ue162\ue187\ue1ac\ue1d1", true, "\ue7c7\ue7ec\ue811\ue836\ue85b\ue880\ue8a5\ue8ca\ue8ef\ue914\ue939\ue95e\ue983\ue9a8", true, "\ueee5\uef0a\uef2f\uef54\uef79\uef9e\uefc3\uefe8\uf00d\uf032\uf057\uf07c\uf0a1\uf0c6\uf0eb\uf110\uf135", true}, {"\ue450\ue475\ue49a\ue4bf\ue4e4\ue509\ue52e\ue553\ue578\ue59d\ue5c2\ue5e7\ue60c\ue631\ue656\ue67b\ue6a0", -296539873104186275L, "\ueb6e\ueb93\uebb8\uebdd\uec02\uec27\uec4c\uec71\uec96\uecbb", 1254039099, "\uf28c\uf2b1\uf2d6\uf2fb\uf320\uf345\uf36a\uf38f\uf3b4\uf3d9\uf3fe", false, "\ue1aa\ue1cf\ue1f4\ue219\ue23e\ue263\ue288\ue2ad", false, "\ue8c8\ue8ed\ue912\ue937\ue95c\ue981\ue9a6\ue9cb\ue9f0\uea15\uea3a", false, "\uefe6\uf00b\uf030\uf055\uf07a\uf09f\uf0c4\uf0e9", false}, {"\ue551\ue576\ue59b\ue5c0\ue5e5\ue60a\ue62f\ue654\ue679\ue69e\ue6c3\ue6e8", -296539873104120738L, "\uec6f\uec94\uecb9\uecde\ued03\ued28\ued4d\ued72\ued97\uedbc\uede1\uee06\uee2b\uee50\uee75", 475518354, "\uf38d\uf3b2\uf3d7\uf3fc\uf421\uf446\uf46b\uf490\uf4b5", true, "\ue2ab\ue2d0\ue2f5\ue31a\ue33f\ue364\ue389\ue3ae\ue3d3\ue3f8\ue41d\ue442\ue467\ue48c", true, "\ue9c9\ue9ee\uea13\uea38\uea5d\uea82\ueaa7\ueacc\ueaf1\ueb16\ueb3b\ueb60\ueb85\uebaa\uebcf\uebf4\uec19", true, "\uf0e7\uf10c\uf131\uf156\uf17b\uf1a0\uf1c5\uf1ea\uf20f\uf234\uf259\uf27e\uf2a3\uf2c8", true}, {"\ue652\ue677\ue69c\ue6c1\ue6e6\ue70b\ue730\ue755\ue77a\ue79f", -296539873104055201L, "\ued70\ued95\uedba\ueddf\uee04\uee29\uee4e\uee73\uee98\ueebd\ueee2", -1376809739, "\uf48e\uf4b3\uf4d8\uf4fd\uf522\uf547\uf56c\uf591", false, "\ue3ac\ue3d1\ue3f6\ue41b\ue440\ue465\ue48a\ue4af\ue4d4\ue4f9\ue51e", false, "\ueaca\ueaef\ueb14\ueb39\ueb5e\ueb83\ueba8\uebcd", false, "\uf1e8\uf20d\uf232\uf257\uf27c\uf2a1\uf2c6\uf2eb\uf310\uf335\uf35a", false}, {"\ue753\ue778\ue79d\ue7c2\ue7e7\ue80c\ue831\ue856\ue87b\ue8a0\ue8c5\ue8ea\ue90f\ue934\ue959", -296539873103989664L, "\uee71\uee96\ueebb\ueee0\uef05\uef2a\uef4f\uef74\uef99", 2139114060, "\uf58f\uf5b4\uf5d9\uf5fe\uf623\uf648\uf66d\uf692\uf6b7\uf6dc\uf701\uf726\uf74b\uf770", true, "\ue4ad\ue4d2\ue4f7\ue51c\ue541\ue566\ue58b\ue5b0\ue5d5\ue5fa\ue61f\ue644\ue669\ue68e\ue6b3\ue6d8\ue6fd", true, "\uebcb\uebf0\uec15\uec3a\uec5f\uec84\ueca9\uecce\uecf3\ued18\ued3d\ued62\ued87\uedac", true, "\uf2e9\uf30e\uf333\uf358\uf37d\uf3a2\uf3c7\uf3ec\uf411\uf436\uf45b\uf480\uf4a5\uf4ca\uf4ef", true}, {"\ue854\ue879\ue89e\ue8c3\ue8e8\ue90d\ue932\ue957\ue97c\ue9a1\ue9c6", -296539873103924127L, "\uef72\uef97\uefbc\uefe1\uf006\uf02b\uf050\uf075", 823656871, "\uf690\uf6b5\uf6da\uf6ff\uf724\uf749\uf76e\uf793\uf7b8\uf7dd\ue002", false, "\ue5ae\ue5d3\ue5f8\ue61d\ue642\ue667\ue68c\ue6b1", false, "\ueccc\uecf1\ued16\ued3b\ued60\ued85\uedaa\uedcf\uedf4\uee19\uee3e", false, "\uf3ea\uf40f\uf434\uf459\uf47e\uf4a3\uf4c8\uf4ed\uf512\uf537\uf55c", false}, {"\ue955\ue97a\ue99f\ue9c4\ue9e9\uea0e\uea33\uea58\uea7d", -296539873103858590L, "\uf073\uf098\uf0bd\uf0e2\uf107\uf12c\uf151\uf176\uf19b\uf1c0\uf1e5\uf20a\uf22f\uf254", -1028589314, "\uf791\uf7b6\uf7db\ue000\ue025\ue04a\ue06f\ue094\ue0b9\ue0de\ue103\ue128\ue14d\ue172\ue197\ue1bc\ue1e1", true, "\ue6af\ue6d4\ue6f9\ue71e\ue743\ue768\ue78d\ue7b2\ue7d7\ue7fc\ue821\ue846\ue86b\ue890", true, "\uedcd\uedf2\uee17\uee3c\uee61\uee86\ueeab\ueed0\ueef5\uef1a\uef3f\uef64\uef89\uefae\uefd3", true, "\uf4eb\uf510\uf535\uf55a\uf57f\uf5a4\uf5c9\uf5ee\uf613\uf638\uf65d\uf682\uf6a7\uf6cc\uf6f1", true}, {"\uea56\uea7b\ueaa0\ueac5\ueaea\ueb0f\ueb34\ueb59", -296539873103793053L, "\uf174\uf199\uf1be\uf1e3\uf208\uf22d\uf252\uf277\uf29c\uf2c1\uf2e6", -1807174063, "\ue092\ue0b7\ue0dc\ue101\ue126\ue14b\ue170\ue195", false, "\ue7b0\ue7d5\ue7fa\ue81f\ue844\ue869\ue88e\ue8b3\ue8d8\ue8fd\ue922", false, "\ueece\ueef3\uef18\uef3d\uef62\uef87\uefac\uefd1\ueff6\uf01b\uf040", false, "\uf5ec\uf611\uf636\uf65b\uf680\uf6a5\uf6ca\uf6ef\uf714\uf739\uf75e\uf783\uf7a8\uf7cd\uf7f2\ue017\ue03c", false}, {"\ueb57\ueb7c\ueba1\uebc6\uebeb\uec10\uec35\uec5a\uec7f\ueca4\uecc9\uecee\ued13\ued38", -296539873103727516L, "\uf275\uf29a\uf2bf\uf2e4\uf309\uf32e\uf353\uf378\uf39d\uf3c2\uf3e7\uf40c\uf431\uf456\uf47b\uf4a0\uf4c5", 635530664, "\ue193\ue1b8\ue1dd\ue202\ue227\ue24c\ue271\ue296\ue2bb\ue2e0\ue305\ue32a\ue34f\ue374", true, "\ue8b1\ue8d6\ue8fb\ue920\ue945\ue96a\ue98f\ue9b4\ue9d9\ue9fe\uea23\uea48\uea6d\uea92\ueab7", true, "\uefcf\ueff4\uf019\uf03e\uf063\uf088\uf0ad\uf0d2\uf0f7\uf11c\uf141\uf166\uf18b\uf1b0\uf1d5", true, "\uf6ed\uf712\uf737\uf75c\uf781\uf7a6\uf7cb\uf7f0\ue015\ue03a\ue05f\ue084", true}, {"\uec58\uec7d\ueca2\uecc7\uecec\ued11\ued36\ued5b\ued80\ueda5\uedca", -296539873103661979L, "\uf376\uf39b\uf3c0\uf3e5\uf40a\uf42f\uf454\uf479", -143054077, "\ue294\ue2b9\ue2de\ue303\ue328\ue34d\ue372\ue397\ue3bc\ue3e1\ue406", false, "\ue9b2\ue9d7\ue9fc\uea21\uea46\uea6b\uea90\ueab5\ueada\ueaff\ueb24", false, "\uf0d0\uf0f5\uf11a\uf13f\uf164\uf189\uf1ae\uf1d3\uf1f8\uf21d\uf242\uf267\uf28c\uf2b1\uf2d6\uf2fb\uf320", false, "\uf7ee\ue013\ue038\ue05d\ue082\ue0a7\ue0cc\ue0f1\ue116\ue13b", false}};
        byte[] v0 = "\u0089\u0012c^q\u0080\u0005\u00ca\u001c\u009f\u0080\u000en\u00e4\u00bb\u00e7\u001f\u00d8\u008cH\u0015\u009b\u0094\u00fa\u0099b\u00e9(\u00ca\u0001\u00bd~\u00e0\u00ed\u00ed0\f\u0018z\u00a2\u00a2\u00cf^LCd\u00bd\u00b9\u0091\u00b646$\\\u00dah\u00b3\u00ceF4\u001b\u00f68\u00b7\u00e9!\u00b4\u00a3>\u00f9-\u00ed\u00ba\t\u0081\"v\u00a1\u00c8\u0014\u0082\u0007\u00a31\\\u008cW\u009bg\u00e6N+e\u000b=\u009d\u0012:\u00e4\u00ba\u00c40\u00b1\u0093\u0093\u001c'\u000e[\u00ce\u008b\u009d(=\u0080\u00de\u00bf\u0093\u00f0\u00e0I\u001d\u001a{c\"A*y\u00e3\u0095\u009c(\u00c2/\u0015\u00b6\u0092\u00d6eG\u0013o\u00810\u0082\u009a\u00e1\u0097\u00d8\u0091\u00fe\u007fx\u00bb\u00ba\u00c3\u00bbX\u0093\u00aa\u00df\u00a1\u00d1s%z\u00d7\u00dd\u00b1\u0081\u00fb\u0016\u0090pT\b\u00ca4>~\u001d\u00f2l\u009e\u00ba\u0094{\u0002\n\u00bc\u00a3\u0096l4N)\bL\u00c97\u001b=\u00d8lH\r26\u00b8\u00b6}E]\u00dc%R\f\u00a6\u00aa\u008a\u0005\u009b\u0092\u00c1\u0001=\u00b1\u00dc)\u001f1\b{\u00ef\n\u00d4\u00bd\by\u0001\u00f5-~U\u00a0\u00cb\u0002g!\u0080\u0015I\u0085ye\u001d\u00f4b\u0082\u00cdy\u00caq?Q\u00c9\u0085\u00ddE\u00ca9m\u0007k\u00dc\u00a5\u000b}\\r\u00bd\u0006e\u00fc\u0013\u00a2\u00b7$&g\u00c8]b\u00df[".getBytes("ISO_8859_1");
        Object[] v1 = "O\u001a\u00b3\u000f_\u00cb@\u00fc".getBytes("ISO_8859_1");
        int v2 = 0;
        do {
            v0[v2++] = (byte)(switch (v0[v2] & 0xFF) {
                case 0 -> -1939098130;
                case 1 -> -1681367560;
                case 2 -> -201749055;
                case 3 -> 89015000;
                case 4 -> 1772905672;
                case 5 -> -1948896186;
                case 6 -> -1665925872;
                case 7 -> 2063225354;
                case 8 -> -1066540380;
                case 9 -> -552126103;
                case 10 -> -1517734205;
                case 11 -> -779567156;
                case 12 -> 713738227;
                case 13 -> -335318082;
                case 14 -> -548514391;
                case 15 -> -523760855;
                case 16 -> -2008622083;
                case 17 -> 1503244791;
                case 18 -> -1122406060;
                case 19 -> 1110986900;
                case 20 -> 289925292;
                case 21 -> 2009956868;
                case 22 -> 3750829;
                case 23 -> -786764221;
                case 24 -> -2094898059;
                case 25 -> -1640925667;
                case 26 -> -1545945116;
                case 27 -> -1939078334;
                case 28 -> 1396737567;
                case 29 -> 231310768;
                case 30 -> -1992392584;
                case 31 -> -842548386;
                case 32 -> 221295738;
                case 33 -> -1789217659;
                case 34 -> -1146196120;
                case 35 -> -1578594914;
                case 36 -> -1882035687;
                case 37 -> 793396336;
                case 38 -> -1501918660;
                case 39 -> 277540530;
                case 40 -> 1772553954;
                case 41 -> 2121269824;
                case 42 -> -816175573;
                case 43 -> -849992412;
                case 44 -> -1996617618;
                case 45 -> -916157462;
                case 46 -> 1626087655;
                case 47 -> -1724827859;
                case 48 -> 369805795;
                case 49 -> 1124966345;
                case 50 -> 1542488243;
                case 51 -> 912662940;
                case 52 -> 90943128;
                case 53 -> -793261213;
                case 54 -> -1233496755;
                case 55 -> 1499777451;
                case 56 -> -1886825457;
                case 57 -> 1663960150;
                case 58 -> 520142285;
                case 59 -> 1192914228;
                case 60 -> -1363786234;
                case 61 -> -2043342742;
                case 62 -> -501056863;
                case 63 -> -1612091212;
                case 64 -> 1767780767;
                case 65 -> 970571493;
                case 66 -> 1969191351;
                case 67 -> 647547324;
                case 68 -> 2031986874;
                case 69 -> 140398176;
                case 70 -> 188753025;
                case 71 -> -1806598454;
                case 72 -> -1316359215;
                case 73 -> -1148936443;
                case 74 -> -23430361;
                case 75 -> -516693953;
                case 76 -> -469600931;
                case 77 -> 163048718;
                case 78 -> -1088340774;
                case 79 -> -344620010;
                case 80 -> 1197187503;
                case 81 -> 410139646;
                case 82 -> -1452698437;
                case 83 -> 1620321587;
                case 84 -> 751669032;
                case 85 -> 577157708;
                case 86 -> 207104570;
                case 87 -> -63381315;
                case 88 -> -175198780;
                case 89 -> -558122138;
                case 90 -> -978418234;
                case 91 -> 170560569;
                case 92 -> 1613042520;
                case 93 -> 942937635;
                case 94 -> -746715660;
                case 95 -> 56955759;
                case 96 -> -671122275;
                case 97 -> 1355871718;
                case 98 -> -120192046;
                case 99 -> -1252587531;
                case 100 -> 261156170;
                case 101 -> -445480635;
                case 102 -> -447293393;
                case 103 -> -1264194154;
                case 104 -> -751271296;
                case 105 -> -1500586484;
                case 106 -> -106184603;
                case 107 -> -1376985717;
                case 108 -> 1408301192;
                case 109 -> -1669566991;
                case 110 -> -762709924;
                case 111 -> 770738480;
                case 112 -> -1436949153;
                case 113 -> -666547849;
                case 114 -> -923565029;
                case 115 -> -1560361369;
                case 116 -> -1352225118;
                case 117 -> -2100860415;
                case 118 -> -446666259;
                case 119 -> 31397704;
                case 120 -> -1910654664;
                case 121 -> 1682306163;
                case 122 -> -1269210668;
                case 123 -> -1256397038;
                case 124 -> 1402234893;
                case 125 -> -1547332372;
                case 126 -> -1707389047;
                case 127 -> 1422619783;
                case 128 -> -704984463;
                case 129 -> 953608405;
                case 130 -> -779425445;
                case 131 -> 1382976761;
                case 132 -> 1263808597;
                case 133 -> 688874092;
                case 134 -> 263485091;
                case 135 -> -139290176;
                case 136 -> -223874593;
                case 137 -> -1918753648;
                case 138 -> -947159268;
                case 139 -> 844217709;
                case 140 -> 155721649;
                case 141 -> -1164986838;
                case 142 -> 1402660328;
                case 143 -> 53137696;
                case 144 -> -1887306827;
                case 145 -> 16556411;
                case 146 -> -1399476142;
                case 147 -> -1922391129;
                case 148 -> -421113138;
                case 149 -> 111954566;
                case 150 -> 641565665;
                case 151 -> -1275672947;
                case 152 -> 1184246518;
                case 153 -> -1096901571;
                case 154 -> 1998299209;
                case 155 -> -1572029915;
                case 156 -> 836920620;
                case 157 -> -1213964792;
                case 158 -> -910832766;
                case 159 -> 838818560;
                case 160 -> 1095971930;
                case 161 -> -827902187;
                case 162 -> 0xB88B8A;
                case 163 -> -1306014175;
                case 164 -> -2146006841;
                case 165 -> -929052329;
                case 166 -> -1222339877;
                case 167 -> 2042517463;
                case 168 -> -1641881435;
                case 169 -> -318413169;
                case 170 -> -500872324;
                case 171 -> -467479142;
                case 172 -> 609099003;
                case 173 -> 1109935278;
                case 174 -> -1609377584;
                case 175 -> -681321090;
                case 176 -> 2037264283;
                case 177 -> 1923100285;
                case 178 -> 2139224143;
                case 179 -> -380727638;
                case 180 -> -929831421;
                case 181 -> -486073432;
                case 182 -> -160911399;
                case 183 -> 1111538687;
                case 184 -> 114168797;
                case 185 -> -354929657;
                case 186 -> 1954977333;
                case 187 -> -832965770;
                case 188 -> 1692782338;
                case 189 -> 532749719;
                case 190 -> 1370239556;
                case 191 -> 1849655548;
                case 192 -> 1030403705;
                case 193 -> -381904346;
                case 194 -> 812436555;
                case 195 -> 594705249;
                case 196 -> 57685183;
                case 197 -> 808117046;
                case 198 -> 1819968787;
                case 199 -> -1737069710;
                case 200 -> 952850222;
                case 201 -> -1802686222;
                case 202 -> -106645359;
                case 203 -> -2047201095;
                case 204 -> 95602066;
                case 205 -> -1748014699;
                case 206 -> 560786067;
                case 207 -> -350478408;
                case 208 -> -1785155733;
                case 209 -> 627306841;
                case 210 -> -1046035325;
                case 211 -> -1560441576;
                case 212 -> -399443572;
                case 213 -> -1289554546;
                case 214 -> -1025775450;
                case 215 -> -731302445;
                case 216 -> -1072436677;
                case 217 -> 1210044433;
                case 218 -> 695506978;
                case 219 -> -57461051;
                case 220 -> -728756742;
                case 221 -> 1488734847;
                case 222 -> 1697808209;
                case 223 -> -751791518;
                case 224 -> 1615081522;
                case 225 -> -353707455;
                case 226 -> -677702370;
                case 227 -> 395277024;
                case 228 -> -1404791882;
                case 229 -> -1962004380;
                case 230 -> 935553841;
                case 231 -> 188256567;
                case 232 -> -836976958;
                case 233 -> -2114608656;
                case 234 -> -926458290;
                case 235 -> 976587215;
                case 236 -> -1741581079;
                case 237 -> -1940173964;
                case 238 -> -732792610;
                case 239 -> 1788805191;
                case 240 -> -1105359381;
                case 241 -> 893517136;
                case 242 -> -1807680450;
                case 243 -> -1882137952;
                case 244 -> -1814348023;
                case 245 -> 1675510404;
                case 246 -> -2117866729;
                case 247 -> 1221716762;
                case 248 -> 623938780;
                case 249 -> -1130948085;
                case 250 -> -1243938090;
                case 251 -> 1482676683;
                case 252 -> -586208173;
                case 253 -> 140523028;
                case 254 -> -1029443431;
                case 255 -> 786903535;
                default -> -1463457780;
            });
        } while (v2 != 296);
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
            Object[] objectArray = new Object[21];
            v1 = objectArray;
            IO0i = objectArray;
            v3 = v2;
            v2 = 0;
            do {
                v4 = v0[v2++] & 0xFF | (v0[v2++] & 0xFF) << 8;
                byte[] v52 = new byte[v4];
                System.arraycopy(v0, v2, v52, 0, v4);
                v1[v6++] = (byte)new String(v52, "UTF-8").intern();
            } while ((v2 += v4) != v3);
        }
        oiIo = 45.0f;
        oiI0 = 90.0f;
        oiIO = 90.0f;
    }

    private float[] iiIi(LivingEntity param1, float param2) {
        Vec3d v3 = AimAssistModule.ConfigSupport_OI0.player.method_5836(param2);
        Vec3d v4 = this.iii0(param1, v3, param2, (Double)this.ioO.HelpCommand());
        return this.iiiO(v3, v4);
    }

    public AimAssistModule() {
        super("AimAssist", "Smoothly assists your aim on nearby targets.", ModuleCategory.i0I);
        this.oiiO = this.OOi0o("VerticalSpeed", 23, 0, 100).ConfigSupport_00o_0("%");
        this.oii0 = this.OOi0o("Slowdown", Float.valueOf(0.35f), Float.valueOf(0.1f), Float.valueOf(0.9f));
        this.oiio = this.OOi0o("Response", 40, 0, 100).ConfigSupport_00o_0("%");
        this.ioO = this.OOi0o("Range", 4.5, 2.0, 6.0);
        this.oOII = this.OOi0o("FOV", 85, 10, 90);
        this.oiiI = this.OOi0o("SwitchDelay", 8, 0, 40).ConfigSupport_00o_0("tick");
        this.oiii = this.OOi00("OnlyAttackKey", false);
        this.0OOi = this.OOi00("OnlyWeapon", true);
        this.IOOO = this.OOi00("LockTarget", true);
        this.oOio = this.OOi00("Players", true);
        this.oOiI = this.OOi00("Mobs", false);
        this.oOii = this.OOi00("Animals", false);
        this.o0OO = this.OOi00("Invisibles", false);
        this.KbDelayModule = this.OOi00("IgnoreTeam", true);
        this.o0O0 = this.OOi00("IgnoreFriends", true);
        this.oiiO.00i(param1 -> (Boolean)this.oiIi.HelpCommand());
    }

    private float[] iiiO(Vec3d param1, Vec3d param2) {
        double v3 = param2.x - param1.x;
        double v5 = param2.y - param1.y;
        double v7 = param2.z - param1.z;
        double v9 = Math.sqrt(v3 * v3 + v7 * v7);
        float v11 = (float)(Math.toDegrees(Math.atan2(v7, v3)) - 90.0);
        float v12 = (float)(-Math.toDegrees(Math.atan2(v5, v9)));
        return new float[]{MathHelper.wrapDegrees((float)v11), MathHelper.clamp((float)v12, (float)-90.0f, (float)90.0f)};
    }

    private List IIiI(double param1) {
        ArrayList<LivingEntity> v3 = new ArrayList<LivingEntity>();
        Box v4 = AimAssistModule.ConfigSupport_OI0.player.method_5829().expand(param1 + 1.0);
        Iterator v5 = AimAssistModule.ConfigSupport_OI0.world.method_8335((Entity)AimAssistModule.ConfigSupport_OI0.player, v4).iterator();
        while (v5.hasNext()) {
            LivingEntity v7;
            Entity v6 = (Entity)v5.next();
            if (!(v6 instanceof LivingEntity) || !this.IIii(v7 = (LivingEntity)v6, param1)) continue;
            v3.add(v7);
        }
        return v3;
    }
}

