package org.terraform.biome.flat;

import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.jetbrains.annotations.NotNull;
import org.terraform.biome.BiomeBank;
import org.terraform.biome.BiomeHandler;
import org.terraform.biome.custombiomes.CustomBiomeType;
import org.terraform.coregen.populatordata.PopulatorDataAbstract;
import org.terraform.data.SimpleLocation;
import org.terraform.data.TerraformWorld;
import org.terraform.small_items.PlantBuilder;
import org.terraform.tree.FractalTreeBuilder;
import org.terraform.tree.FractalTypes;
import org.terraform.utils.BlockUtils;
import org.terraform.utils.GenUtils;

import java.util.Random;

public class EnderForestHandler extends BiomeHandler {

    @Override
    public boolean isOcean() {
        return false;
    }

    @Override
    public @NotNull Biome getBiome() {
        return Biome.END_HIGHLANDS;
    }

    @Override
    public @NotNull CustomBiomeType getCustomBiome() {
        return CustomBiomeType.ENDER_FOREST;
    }

    @Override
    public Material @NotNull [] getSurfaceCrust(@NotNull Random rand) {
        return new Material[] {
                GenUtils.randChoice(rand, Material.END_STONE, Material.END_STONE, Material.END_STONE, Material.END_STONE_BRICKS),
                Material.END_STONE,
                Material.END_STONE,
                GenUtils.randChoice(rand, Material.END_STONE, Material.STONE),
                GenUtils.randChoice(rand, Material.END_STONE, Material.STONE)
        };
    }

    @Override
    public void populateSmallItems(TerraformWorld world,
                                   @NotNull Random random,
                                   int rawX,
                                   int surfaceY,
                                   int rawZ,
                                   @NotNull PopulatorDataAbstract data)
    {
        Material surface = data.getType(rawX, surfaceY, rawZ);
        if (surface == Material.END_STONE || surface == Material.END_STONE_BRICKS) {
            if (GenUtils.chance(random, 1, 20)) {
                if (GenUtils.chance(random, 1, 2)) {
                    data.setType(rawX, surfaceY + 1, rawZ, Material.CHORUS_FLOWER);
                } else {
                    data.setType(rawX, surfaceY + 1, rawZ, Material.ALLIUM);
                }
            } else if (GenUtils.chance(random, 1, 40)) {
                data.setType(rawX, surfaceY + 1, rawZ, Material.AMETHYST_CLUSTER);
            }
        }
    }

    @Override
    public void populateLargeItems(@NotNull TerraformWorld tw, Random random, @NotNull PopulatorDataAbstract data) {
        SimpleLocation[] trees = GenUtils.randomObjectPositions(tw, data.getChunkX(), data.getChunkZ(), 16);

        for (SimpleLocation sLoc : trees) {
            int treeY = GenUtils.getHighestGround(data, sLoc.getX(), sLoc.getZ());
            sLoc = sLoc.getAtY(treeY);

            Material base = data.getType(sLoc.getX(), sLoc.getY(), sLoc.getZ());
            if (tw.getBiomeBank(sLoc.getX(), sLoc.getZ()) == BiomeBank.ENDER_FOREST
                && (base == Material.END_STONE || base == Material.END_STONE_BRICKS || BlockUtils.isDirtLike(base)))
            {
                new FractalTreeBuilder(FractalTypes.Tree.ENDER_TREE).build(tw,
                        data,
                        sLoc.getX(),
                        sLoc.getY(),
                        sLoc.getZ()
                );
            }
        }
    }

    @Override
    public @NotNull BiomeBank getBeachType() {
        return BiomeBank.ENDER_FOREST;
    }

    @Override
    public @NotNull BiomeBank getRiverType() {
        return BiomeBank.ENDER_FOREST_RIVER;
    }
}
