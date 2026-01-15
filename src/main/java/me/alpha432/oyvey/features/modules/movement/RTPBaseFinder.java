package me.ryll.oyvey.features.modules.movement;

import me.ryll.oyvey.features.modules.Module;
import net.minecraft.block.Blocks;
import net.minecraft.text.Text;

public class BaseFinder extends Module {
    public BaseFinder() {
        super("BaseFinder", "RTP y baja a la capa 0 para buscar bases.", Category.MOVEMENT, true, false, false);
    }

    @Override
    public void onEnable() {
        if (nullCheck()) return;
        mc.player.networkHandler.sendCommand("rtp east");
        mc.player.sendMessage(Text.of("§b[AetherX] §fBuscando base en el Este..."), false);
    }

    @Override
    public void onTick() {
        if (nullCheck()) return;

        if (mc.player.getY() > 0) {
            // Seguridad: si hay lava abajo, se detiene
            if (mc.world.getBlockState(mc.player.getBlockPos().down()).getBlock() == Blocks.LAVA) {
                mc.player.sendMessage(Text.of("§c[!] Lava detectada. Deteniendo."), true);
                this.disable();
                return;
            }
            mc.options.sneakKey.setPressed(true);
        } else {
            mc.options.sneakKey.setPressed(false);
            mc.player.sendMessage(Text.of("§a[!] Capa 0 alcanzada."), false);
            this.disable();
        }
    }
}
