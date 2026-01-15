package com.aetherx.client.modules.render;

import com.aetherx.client.modules.Module;
import net.minecraft.block.entity.SpawnerBlockEntity;
import net.minecraft.entity.passive.AnimalEntity;

public class FarmFinder extends Module {
    public FarmFinder() { super("FarmFinder"); }

    @Override
    public void onTick() {
        if (!isEnabled() || mc.world == null) return;
        
        // Busca entidades pasivas (vacas, ovejas) para granjas
        mc.world.getEntities().forEach(entity -> {
            if (entity instanceof AnimalEntity) {
                // Lógica de resaltado
            }
        });
    }
}
