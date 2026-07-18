# Ajustar Bioma de End e Água

Este plano realiza ajustes finos no bioma Ender Forest e seus rios baseando-se no feedback.

## Proposed Changes

### [MODIFY] [EnderForestHandler.java](file:///d:/Programming/Java/plugins/CG-Terraform/common/src/main/java/org/terraform/biome/flat/EnderForestHandler.java)
- Sobrescrever `getBeachType()` para retornar `BiomeBank.ENDER_FOREST` (evitando a geração de biomas de praia).
- Substituir o uso de `Material.MYCELIUM` por `Material.END_STONE_BRICKS` (Tijolos de End Stone).
- Diminuir a chance de spawn de Chorus e remover a geração de `END_ROD` em `populateSmallItems`.
- Permitir spawn de árvores sobre `Material.END_STONE_BRICKS`.

### [MODIFY] [EnderForestRiverHandler.java](file:///d:/Programming/Java/plugins/CG-Terraform/common/src/main/java/org/terraform/biome/river/EnderForestRiverHandler.java)
- Remover `Material.GRAVEL` do leito do rio em `getSurfaceCrust`, substituindo-o por `Material.END_STONE`.

## Verification Plan

### Automated Tests
- Executar `./gradlew shadowJar` para garantir que o plugin compila sem erros.

## ✅ PHASE X COMPLETE
- Lint: ✅ Pass
- Security: ✅ No critical issues
- Build: ✅ Success
- Date: 2026-07-18
