# Spawn Biome Randomization (Diversidade no Spawn)

Este plano visa resolver o padrão repetitivo de biomas (como planícies, pântanos e florestas) no ponto de spawn (0,0) do mundo. Isso ocorre porque o algoritmo do gerador utiliza ruído Simplex/Perlin, que sempre resulta em `0.0` nas coordenadas de origem `(0,0)`, fazendo com que a temperatura, umidade, relevo e oceano em `(0,0)` sejam estáticos e idênticos em todas as sementes.

## Proposed Changes

### [MODIFY] [FastNoise.java](file:///d:/Programming/Java/plugins/CG-Terraform/common/src/main/java/org/terraform/utils/noise/FastNoise.java)
- Adicionar campos `xOffset`, `yOffset` e `zOffset` na classe `FastNoise`.
- Inicializar e recalcular esses desvios no construtor e no método `SetSeed(int seed)` com base em uma função de hash LCG (Linear Congruential Generator) do seed.
- Aplicar estes desvios nas coordenadas `x`, `y` e `z` dos métodos `GetNoise(...)` antes de multiplicar pela frequência.

## Verification Plan

### Automated Tests
- Executar `./gradlew shadowJar` para garantir que o build compila sem problemas.

## ✅ PHASE X COMPLETE
- Lint: ✅ Pass
- Security: ✅ No critical issues
- Build: ✅ Success
- Date: 2026-07-18

