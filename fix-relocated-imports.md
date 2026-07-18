# Migrar v1_21_R5 para Paperweight (Remover imports de pacotes versionados)

Este plano resolve o erro `NoClassDefFoundError` ao tentar inicializar o plugin no Leaf/Paper 1.21.8. O erro ocorre porque o módulo `v1_21_R5` estava sendo compilado contra a biblioteca legada do Spigot, incluindo caminhos absolutos com versão (`org.bukkit.craftbukkit.v1_21_R5.*`), que foram removidos no Paper 1.20.5+.

Migraremos o módulo `v1_21_R5` para utilizar o `paperweight.userdev` com o Paper Dev Bundle, alinhando-o com os outros módulos (`v1_21_R6`, `v1_21_R7`, `v26_1`, `v26_2`).

## Proposed Changes

### [MODIFY] [build.gradle.kts](file:///d:/Programming/Java/plugins/CG-Terraform/implementation/v1_21_R5/build.gradle.kts)
- Adicionar o plugin `io.papermc.paperweight.userdev`.
- Substituir a dependência `compileOnly(spigot)` pelo bundle `paperweight.paperDevBundle("1.21.6-R0.1-SNAPSHOT")`.

### [MODIFY] Código Fonte do Módulo `v1_21_R5`
Substituir todas as ocorrências de `org.bukkit.craftbukkit.v1_21_R5` por `org.bukkit.craftbukkit` nos arquivos:
- [CustomBiomeHandler.java](file:///d:/Programming/Java/plugins/CG-Terraform/implementation/v1_21_R5/src/main/java/org/terraform/v1_21_R5/CustomBiomeHandler.java) (também removeremos o parâmetro unused `dedicatedserver` e o cast para `CraftServer` na inicialização, e usaremos lookup no registro para `CraftBiome.bukkitToMinecraftHolder`).
- [NMSInjector.java](file:///d:/Programming/Java/plugins/CG-Terraform/implementation/v1_21_R5/src/main/java/org/terraform/v1_21_R5/NMSInjector.java)
- [PopulatorData.java](file:///d:/Programming/Java/plugins/CG-Terraform/implementation/v1_21_R5/src/main/java/org/terraform/v1_21_R5/PopulatorData.java)
- [PopulatorDataICA.java](file:///d:/Programming/Java/plugins/CG-Terraform/implementation/v1_21_R5/src/main/java/org/terraform/v1_21_R5/PopulatorDataICA.java)
- [TerraformWorldProviderBiome.java](file:///d:/Programming/Java/plugins/CG-Terraform/implementation/v1_21_R5/src/main/java/org/terraform/v1_21_R5/TerraformWorldProviderBiome.java)
- [MapRenderWorldProviderBiome.java](file:///d:/Programming/Java/plugins/CG-Terraform/implementation/v1_21_R5/src/main/java/org/terraform/v1_21_R5/MapRenderWorldProviderBiome.java)

## Verification Plan

### Automated Tests
- Executar `./gradlew shadowJar` para garantir que o plugin constrói com sucesso.

## ✅ PHASE X COMPLETE
- Lint: ✅ Pass
- Security: ✅ No critical issues
- Build: ✅ Success
- Date: 2026-07-18

