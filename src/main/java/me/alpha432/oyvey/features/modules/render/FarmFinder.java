package me.ryll.oyvey.features.modules.render;

import me.ryll.oyvey.features.modules.Module;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.text.Text;

public class FarmFinder extends Module {
    // Puedes cambiar Blocks.NETHER_WART por Blocks.WHEAT, Blocks.CARROTS, etc.
    private final Block targetCrop = Blocks.NETHER_WART; 
    private final int range = 24; // Radio de búsqueda ajustado al bypass de Donut SMP

    public FarmFinder() {
        super("FarmFinder", "Busca cultivos específicos en un rango cercano.", Category.RENDER, true, false, false);
    }

    @Override
    public void onTick() {
        if (nullCheck() || mc.player.age % 20 != 0) return; // Escaneo cada 1 segundo para evitar lag

        BlockPos pPos = mc.player.getBlockPos();

        for (int x = -range; x <= range; x++) {
            for (int y = -range; y <= range; y++) {
                for (int z = -range; z <= range; z++) {
                    BlockPos checkPos = pPos.add(x, y, z);
                    if (mc.world.getBlockState(checkPos).getBlock() == targetCrop) {
                        // Alerta visual en el chat al encontrar el cultivo
                        mc.player.sendMessage(Text.of("§6[AetherX] §e" + targetCrop.getName().getString() + " encontrado en: " + checkPos.toShortString()), false);
                        return; // Frenamos para no spamear el chat si hay muchos
                    }
                }
            }
        }
    }
}
