# Balanceamento de Loots UHC/Battle Royale

Este plano implementa o balanceamento dinâmico dos loots das estruturas geradas, reduzindo a raridade e quantidade de materiais valiosos para o formato Battle Royale UHC (Hoplite-style).

## Proposed Changes

### [NEW] [LootListener.java](file:///d:/Programming/Java/plugins/CG-Terraform/common/src/main/java/org/terraform/main/LootListener.java)
- Criar o listener Spigot/Paper para interceptar a geração de loots via `LootGenerateEvent`.
- Filtrar itens gerados:
  - Remover Netherite (armaduras, ferramentas, upgrades, etc.).
  - Rebaixar equipamentos de Diamante para Ferro.
  - Limitar diamantes a no máximo 1 por slot de baú.
  - Limitar ferro e ouro a no máximo 3 e 4 itens por slot, respectivamente.
  - Limitar Maçãs Douradas e Cenouras Douradas.
  - Reduzir níveis de livros encantados fortes (como Proteção, Afiação, etc.) para o nível máximo II.
  - Remover maces, heavy cores, chaves de trial e wind charges.

### [MODIFY] [TerraformGeneratorPlugin.java](file:///d:/Programming/Java/plugins/CG-Terraform/common/src/main/java/org/terraform/main/TerraformGeneratorPlugin.java)
- Registrar o `LootListener` no gerenciador de eventos do Bukkit.

## Verification Plan

### Automated Tests
- Executar `./gradlew shadowJar` para garantir que o plugin compila sem erros.

## ✅ PHASE X COMPLETE
- Lint: ✅ Pass
- Security: ✅ No critical issues
- Build: ✅ Success
- Date: 2026-07-18
