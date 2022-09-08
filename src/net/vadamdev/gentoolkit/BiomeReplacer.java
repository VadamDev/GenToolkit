package net.vadamdev.gentoolkit;

import net.minecraft.server.v1_8_R3.BiomeBase;
import net.vadamdev.gentoolkit.utils.BiomeDictionnary;

import java.util.Arrays;

/**
 * @author VadamDev
 * @since 07/09/2022
 */
public class BiomeReplacer {
    private final BiomeBase[] biomes;
    private final BiomeBase[] biomesCopy;

    public BiomeReplacer() {
        this.biomes = BiomeBase.getBiomes();
        this.biomesCopy = Arrays.copyOf(biomes, biomes.length);
    }

    public void swapBiomes(BiomeDictionnary from, BiomeDictionnary to) {
        if(biomes[from.getId()] != null)
            biomes[from.getId()] = biomesCopy[to.getId()];
    }

    public void replaceAll(BiomeDictionnary to) {
        for (int i = 0; i < biomes.length; i++) {
            if(i != to.getId() && biomes[i] != null)
                biomes[i] = biomesCopy[to.getId()];
        }
    }
}
