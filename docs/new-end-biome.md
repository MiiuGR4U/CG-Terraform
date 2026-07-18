# Adicionar Bioma Customizado de End: Ender Forest

Este plano implementa o bioma customizado `"Ender Forest"` com elementos de vegetação alienígena do End.

## Proposed Changes

### [NEW] [EnderForestHandler.java](file:///d:/Programming/Java/plugins/CG-Terraform/common/src/main/java/org/terraform/biome/flat/EnderForestHandler.java)
- Criar o arquivo para gerenciar a superfície de End Stone / Mycelium / Obsidian, decoração de Chorus e Ametista, e spawn da nova árvore `ENDER_TREE`.

### [MODIFY] [CustomBiomeType.java](file:///d:/Programming/Java/plugins/CG-Terraform/common/src/main/java/org/terraform/biome/custombiomes/CustomBiomeType.java)
- Adicionar o bioma `ENDER_FOREST` com as cores personalizadas do End.

### [MODIFY] [TConfig.java](file:///d:/Programming/Java/plugins/CG-Terraform/common/src/main/java/org/terraform/main/config/TConfig.java)
- Adicionar a propriedade de peso `biome.enderforest.weight` (padrão = 3).

### [MODIFY] [BiomeBank.java](file:///d:/Programming/Java/plugins/CG-Terraform/common/src/main/java/org/terraform/biome/BiomeBank.java)
- Registrar o bioma `ENDER_FOREST` no clima `COLD`.

### [MODIFY] [FractalTypes.java](file:///d:/Programming/Java/plugins/CG-Terraform/common/src/main/java/org/terraform/tree/FractalTypes.java) e [FractalTreeBuilder.java](file:///d:/Programming/Java/plugins/CG-Terraform/common/src/main/java/org/terraform/tree/FractalTreeBuilder.java)
- Adicionar a estrutura de árvore `ENDER_TREE` com troncos de Obsidian e copas de Ametista.

## Verification Plan

### Automated Tests
- Executar `./gradlew shadowJar` para garantir que o plugin constrói com sucesso.

## ✅ PHASE X COMPLETE
- Lint: ✅ Pass
- Security: ✅ No critical issues
- Build: ✅ Success
- Date: 2026-07-18
