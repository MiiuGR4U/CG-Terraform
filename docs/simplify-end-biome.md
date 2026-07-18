# Simplificar Bioma de End e Adicionar Rios Roxos

Este plano visa tornar o bioma Ender Forest mais limpo/menos complexo, reduzir sua frequência de geração (espalhar menos) e adicionar rios de águas roxas dedicados a ele.

## Proposed Changes

### [MODIFY] [EnderForestHandler.java](file:///d:/Programming/Java/plugins/CG-Terraform/common/src/main/java/org/terraform/biome/flat/EnderForestHandler.java)
- Simplificar o `getSurfaceCrust` para remover blocos de Obsidian da superfície padrão do solo (ficando apenas End Stone e Mycelium).
- Sobrescrever `getRiverType()` para retornar `BiomeBank.ENDER_FOREST_RIVER`.

### [MODIFY] [TConfig.java](file:///d:/Programming/Java/plugins/CG-Terraform/common/src/main/java/org/terraform/main/config/TConfig.java)
- Reduzir o peso `biome.enderforest.weight` de `3` para `2` para espalhar menos o bioma (tornando-o mais raro).

### [MODIFY] [BiomeBank.java](file:///d:/Programming/Java/plugins/CG-Terraform/common/src/main/java/org/terraform/biome/BiomeBank.java)
- Registrar `ENDER_FOREST_RIVER` com o respectivo `EnderForestRiverHandler`.

### [NEW] [EnderForestRiverHandler.java](file:///d:/Programming/Java/plugins/CG-Terraform/common/src/main/java/org/terraform/biome/river/EnderForestRiverHandler.java)
- Criar a classe do rio da Ender Forest que herda as cores roxas da água do bioma customizado pai.

## Verification Plan

### Automated Tests
- Executar `./gradlew shadowJar` para garantir que o plugin compila sem erros.

## ✅ PHASE X COMPLETE
- Lint: ✅ Pass
- Security: ✅ No critical issues
- Build: ✅ Success
- Date: 2026-07-18
