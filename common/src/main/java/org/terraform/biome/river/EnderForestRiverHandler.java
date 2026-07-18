package org.terraform.biome.river;

import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.jetbrains.annotations.NotNull;
import org.terraform.biome.BiomeHandler;
import org.terraform.biome.custombiomes.CustomBiomeType;
import org.terraform.coregen.populatordata.PopulatorDataAbstract;
import org.terraform.data.TerraformWorld;
import org.terraform.utils.GenUtils;

import java.util.Random;

public class EnderForestRiverHandler extends BiomeHandler {

    @Override
    public boolean isOcean() {
        return true;
    }

    @Override
    public @NotNull Biome getBiome() {
        return Biome.RIVER;
    }

    @Override
    public @NotNull CustomBiomeType getCustomBiome() {
        return CustomBiomeType.ENDER_FOREST;
    }

    @Override
    public Material @NotNull [] getSurfaceCrust(@NotNull Random rand) {
        return new Material[] {
                GenUtils.randChoice(rand, Material.END_STONE, Material.END_STONE, Material.GRAVEL, Material.OBSIDIAN),
                Material.END_STONE,
                Material.END_STONE,
                GenUtils.randChoice(rand, Material.END_STONE, Material.STONE),
                GenUtils.randChoice(rand, Material.END_STONE, Material.STONE)
        };
    }

    @Override
    public void populateSmallItems(@NotNull TerraformWorld world,
                                   @NotNull Random random,
                                   int rawX,
                                   int surfaceY,
                                   int rawZ,
                                   @NotNull PopulatorDataAbstract data) {
    }

    @Override
    public void populateLargeItems(@NotNull TerraformWorld tw, Random random, @NotNull PopulatorDataAbstract data) {

    }
}
