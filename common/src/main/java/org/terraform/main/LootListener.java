package org.terraform.main;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.LootGenerateEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.terraform.coregen.bukkit.TerraformGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LootListener implements Listener {

    private final Random rand = new Random();

    @EventHandler
    public void onLootGenerate(LootGenerateEvent event) {
        // Only modify loot in TerraformGenerator generated worlds
        if (!(event.getWorld().getGenerator() instanceof TerraformGenerator)) {
            return;
        }

        List<ItemStack> loot = event.getLoot();
        List<ItemStack> newLoot = new ArrayList<>();

        for (ItemStack item : loot) {
            if (item == null || item.getType() == Material.AIR) {
                continue;
            }

            Material type = item.getType();
            String name = type.name();

            // 1. Netherite items, scraps, ingots & templates -> Remove completely
            if (name.contains("NETHERITE") || name.contains("UPGRADE_TEMPLATE")) {
                continue;
            }

            // 2. Diamond gear -> Downgrade to Iron (Hoplite/UHC style)
            if (name.startsWith("DIAMOND_")) {
                if (name.endsWith("HELMET")) {
                    item.setType(Material.IRON_HELMET);
                } else if (name.endsWith("CHESTPLATE")) {
                    item.setType(Material.IRON_CHESTPLATE);
                } else if (name.endsWith("LEGGINGS")) {
                    item.setType(Material.IRON_LEGGINGS);
                } else if (name.endsWith("BOOTS")) {
                    item.setType(Material.IRON_BOOTS);
                } else if (name.endsWith("SWORD")) {
                    item.setType(Material.IRON_SWORD);
                } else if (name.endsWith("AXE")) {
                    item.setType(Material.IRON_AXE);
                } else if (name.endsWith("PICKAXE")) {
                    item.setType(Material.IRON_PICKAXE);
                } else if (name.endsWith("SHOVEL")) {
                    item.setType(Material.IRON_SHOVEL);
                } else if (name.endsWith("HOE")) {
                    item.setType(Material.IRON_HOE);
                }
            }

            // 3. Raw materials reduction (Diamonds, Emeralds, Iron, Gold)
            if (type == Material.DIAMOND) {
                item.setAmount(1); // Maximum of 1 diamond per slot
            } else if (type == Material.EMERALD) {
                item.setAmount(Math.min(item.getAmount(), 2));
            } else if (type == Material.IRON_INGOT || type == Material.RAW_IRON || type == Material.IRON_BLOCK) {
                if (type == Material.IRON_BLOCK) {
                    item.setType(Material.IRON_INGOT);
                    item.setAmount(rand.nextInt(3) + 1);
                } else {
                    item.setAmount(Math.min(item.getAmount(), 3));
                }
            } else if (type == Material.GOLD_INGOT || type == Material.RAW_GOLD || type == Material.GOLD_BLOCK) {
                if (type == Material.GOLD_BLOCK) {
                    item.setType(Material.GOLD_INGOT);
                    item.setAmount(rand.nextInt(3) + 1);
                } else {
                    item.setAmount(Math.min(item.getAmount(), 4));
                }
            }

            // 4. Golden Apples & Golden Carrots -> Limit/Downgrade
            if (type == Material.GOLDEN_APPLE) {
                item.setAmount(1); // Max 1 golden apple
            } else if (type == Material.GOLDEN_CARROT) {
                item.setAmount(Math.min(item.getAmount(), 2));
            }

            // 5. Enchanted Books -> Downgrade levels (max II)
            if (type == Material.ENCHANTED_BOOK) {
                ItemMeta meta = item.getItemMeta();
                if (meta instanceof EnchantmentStorageMeta storageMeta) {
                    for (Enchantment ench : new ArrayList<>(storageMeta.getStoredEnchants().keySet())) {
                        int level = storageMeta.getStoredEnchantLevel(ench);
                        if (ench.getKey().getKey().contains("protection")
                                || ench.getKey().getKey().contains("sharpness")
                                || ench.getKey().getKey().contains("power")
                                || ench.getKey().getKey().contains("efficiency")
                                || level > 2) {
                            storageMeta.removeStoredEnchant(ench);
                            storageMeta.addStoredEnchant(ench, Math.min(level, 2), true);
                        }
                    }
                    item.setItemMeta(storageMeta);
                }
            }

            // 6. Trial keys, heavy cores, maces, wind charges -> Remove
            if (name.contains("TRIAL_KEY") || name.equals("HEAVY_CORE") || name.equals("MACE") || name.contains("WIND_CHARGE")) {
                continue;
            }

            newLoot.add(item);
        }

        event.setLoot(newLoot);
    }
}
