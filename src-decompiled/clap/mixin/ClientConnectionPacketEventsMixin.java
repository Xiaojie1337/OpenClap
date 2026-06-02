/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelFutureListener
 *  io.netty.channel.ChannelHandlerContext
 *  net.minecraft.client.network.ClientPlayNetworkHandler
 *  net.minecraft.network.ClientConnection
 *  net.minecraft.network.NetworkSide
 *  net.minecraft.network.listener.PacketListener
 *  net.minecraft.network.packet.Packet
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  psx.Hyk.PacketReceiveEvent
 *  clap.event.network.PacketSendEvent
 */
package clap.mixin;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.NetworkSide;
import net.minecraft.network.listener.PacketListener;
import net.minecraft.network.packet.Packet;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import clap.event.EventBusApi;
import clap.event.network.PacketReceiveEvent;
import clap.event.network.PacketSendEvent;
import clap.event.Event;
import clap.config.ConfigSupport_oiii_4;

@Mixin(value={ClientConnection.class})
public class ClientConnectionPacketEventsMixin {
    @Shadow
    @Final
    private NetworkSide field_11643;
    @Shadow
    private volatile PacketListener field_11652;

    @Inject(method={"channelRead0"}, at={@At(value="HEAD")}, cancellable=true)
    public void channelRead0(ChannelHandlerContext param1, Packet param2, CallbackInfo param3) {
        PacketListener v4 = this.field_11652;
        if (!(v4 instanceof ClientPlayNetworkHandler)) {
            return;
        }
        try {
            if (EventBusApi.OIo.OOo((Event)new PacketSendEvent(param2, (ClientConnection)this))) {
                param3.cancel();
                return;
            }
        }
        catch (Exception exception) {}
        if (ConfigSupport_oiii_4.O0OiO()) {
            param3.cancel();
            ConfigSupport_oiii_4.O0Oi0(() -> param2.apply(v4));
            return;
        }
    }

    @Inject(method={"sendPacket"}, at={@At(value="HEAD")}, cancellable=true)
    private void sendPacket(Packet param1, ChannelFutureListener param2, boolean param3, CallbackInfo param4) {
        if (this.field_11643 != NetworkSide.CLIENTBOUND) {
            return;
        }
        try {
            if (EventBusApi.OIo.OOo((Event)new PacketReceiveEvent(param1))) {
                param4.cancel();
            }
        }
        catch (Exception exception) {}
    }
}

