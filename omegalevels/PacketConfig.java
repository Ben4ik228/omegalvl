/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Charsets
 *  cpw.mods.fml.common.network.simpleimpl.IMessage
 *  io.netty.buffer.ByteBuf
 */
package omegalevels;

import com.google.common.base.Charsets;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;
import java.nio.charset.Charset;

public class PacketConfig
implements IMessage {
    String jsonString;

    public PacketConfig() {
    }

    public PacketConfig(String jsonString) {
        this.jsonString = jsonString;
    }

    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.jsonString.getBytes(Charsets.UTF_8).length);
        buf.writeBytes(this.jsonString.getBytes(Charsets.UTF_8));
    }

    public void fromBytes(ByteBuf buf) {
        this.jsonString = new String(buf.readBytes(buf.readInt()).array(), Charsets.UTF_8);
    }
}

