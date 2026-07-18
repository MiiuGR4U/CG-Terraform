# Alterar Namespace dos Biomas Customizados para 'criasgamers'

Este plano visa alterar o namespace de identificação dos biomas customizados registrados pelo gerador, de `"terraformgenerator"` para `"criasgamers"`.

## Proposed Changes

### [MODIFY] [CustomBiomeType.java](file:///d:/Programming/Java/plugins/CG-Terraform/common/src/main/java/org/terraform/biome/custombiomes/CustomBiomeType.java)
- Alterar o prefixo da variável `key` nos construtores de `"terraformgenerator:"` para `"criasgamers:"`.

### [MODIFY] `CustomBiomeHandler.java` (nos 5 módulos de implementação)
Alterar o namespace passado para `ResourceLocation` / `Identifier` de `"terraformgenerator"` para `"criasgamers"` nos seguintes arquivos:
- [CustomBiomeHandler.java (v1_21_R5)](file:///d:/Programming/Java/plugins/CG-Terraform/implementation/v1_21_R5/src/main/java/org/terraform/v1_21_R5/CustomBiomeHandler.java)
- [CustomBiomeHandler.java (v1_21_R6)](file:///d:/Programming/Java/plugins/CG-Terraform/implementation/v1_21_R6/src/main/java/org/terraform/v1_21_R6/CustomBiomeHandler.java)
- [CustomBiomeHandler.java (v1_21_R7)](file:///d:/Programming/Java/plugins/CG-Terraform/implementation/v1_21_R7/src/main/java/org/terraform/v1_21_R7/CustomBiomeHandler.java)
- [CustomBiomeHandler.java (v26_1)](file:///d:/Programming/Java/plugins/CG-Terraform/implementation/v26_1/src/main/java/org/terraform/v26_1/CustomBiomeHandler.java)
- [CustomBiomeHandler.java (v26_2)](file:///d:/Programming/Java/plugins/CG-Terraform/implementation/v26_2/src/main/java/org/terraform/v26_2/CustomBiomeHandler.java)

## Verification Plan

### Automated Tests
- Executar `./gradlew shadowJar` para garantir que o plugin compila sem erros.

## ✅ PHASE X COMPLETE
- Lint: ✅ Pass
- Security: ✅ No critical issues
- Build: ✅ Success
- Date: 2026-07-18

