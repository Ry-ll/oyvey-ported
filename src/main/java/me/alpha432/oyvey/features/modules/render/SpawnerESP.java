package me.ryll.oyvey.features.modules.render;

import me.ryll.oyvey.features.modules.Module;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.SpawnerBlockEntity;
import net.minecraft.text.Text;

public class SpawnerESP extends Module {
    public SpawnerESP() {
        super("SpawnerESP", "Detecta spawners en el rango cargado.", Category.RENDER, true, false, false);
    }

    @Override
    public void onTick() {
        if (nullCheck()) return;

        for (BlockEntity entity : mc.world.blockEntities) {
            if (entity instanceof SpawnerBlockEntity) {
                if (mc.player.age % 100 == 0) {
                    mc.player.sendMessage(Text.of("§d[AetherX] §aSpawner: §7" + entity.getPos().toShortString()), false);
                }
                // Aquí podrías añadir el renderizado de caja de OyVey si lo necesitas
            }
        }
    }
}
        // Esta función se conectará con tu clase de RenderUtils más adelante
        // para dibujar un cubo de color neón alrededor del spawner.
    }
}
