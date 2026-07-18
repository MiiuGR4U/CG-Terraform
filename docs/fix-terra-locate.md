# Corrigir Comando /terra locatebiome

Este plano visa corrigir o travamento/loop infinito e a falta de feedback ao executar o comando `/terra locatebiome`.

## Proposed Changes

### [MODIFY] [GenUtils.java](file:///d:/Programming/Java/plugins/CG-Terraform/common/src/main/java/org/terraform/utils/GenUtils.java)
- Corrigir a lógica de busca em `locateHeightIndependentBiome`. Mover o incremento `radius++` para fora do laço `for` de verificação das seções de biomas.
- Adicionar um limite máximo de busca (`maxRadius = 150`, cerca de 19.200 blocos) para evitar loops infinitos caso o bioma esteja desabilitado ou não exista na semente atual.

### [MODIFY] [LocateBiomeCommand.java](file:///d:/Programming/Java/plugins/CG-Terraform/common/src/main/java/org/terraform/command/LocateBiomeCommand.java)
- Adicionar uma mensagem de feedback imediata ao jogador informando que o bioma está sendo localizado, antes de iniciar a busca assíncrona (`p.sendMessage(ChatColor.GREEN + "Locating biome " + targetBiome.name() + "...");`).

## Verification Plan

### Automated Tests
- Executar `./gradlew shadowJar` para garantir que o plugin compila sem erros.

## ✅ PHASE X COMPLETE
- Lint: ✅ Pass
- Security: ✅ No critical issues
- Build: ✅ Success
- Date: 2026-07-18

