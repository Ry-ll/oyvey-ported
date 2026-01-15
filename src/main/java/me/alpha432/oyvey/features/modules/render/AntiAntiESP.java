package com.aetherx.client.modules.render;

import com.aetherx.client.modules.Module;
import net.minecraft.entity.player.PlayerEntity;

public class AntiAntiESP extends Module {
    public AntiAntiESP() { super("AntiAntiESP"); }

    @Override
    public void onTick() {
        if (!isEnabled() || mc.world == null) return;

        // Esta función desactiva el "Culling" (el juego deja de renderizar lo que no ves)
        // Forzamos a que el motor de renderizado ignore la oclusión del servidor
        for (PlayerEntity player : mc.world.getPlayers()) {
            if (player == mc.player) continue;
            
            // Forzamos a que la entidad siempre sea considerada "en vista" para el motor local
            player.ignoreCameraFrustum = true; 
        }
    }
}
