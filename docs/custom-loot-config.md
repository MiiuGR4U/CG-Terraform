# Configuração Personalizada de Loot via .yml

Este plano implementa a leitura das regras de balanceamento de loots a partir de um arquivo `loot-rules.yml` na pasta de dados do plugin, permitindo fácil customização pelo administrador do servidor.

## Proposed Changes

### [NEW] `loot-rules.yml` (Arquivo de Configuração)
- Criar a configuração padrão contendo as listas de remoções (Netherite, maces), rebaixamentos (diamante para ferro), limites de quantidade (ferros, ouros, maçãs) e limites de nível de encantamento.

### [MODIFY] [TerraformGeneratorPlugin.java](file:///d:/Programming/Java/plugins/CG-Terraform/common/src/main/java/org/terraform/main/TerraformGeneratorPlugin.java)
- Carregar ou criar o arquivo `loot-rules.yml` na pasta do plugin ao iniciar (`onEnable`).

### [MODIFY] [LootListener.java](file:///d:/Programming/Java/plugins/CG-Terraform/common/src/main/java/org/terraform/main/LootListener.java)
- Atualizar a classe para ler as listas e limites a partir do arquivo de configuração carregado em memória, em vez de usar valores fixados (hardcoded).

## Verification Plan

### Automated Tests
- Executar `./gradlew shadowJar` para garantir que o plugin compila sem erros.

## ✅ PHASE X COMPLETE
- Lint: ✅ Pass
- Security: ✅ No critical issues
- Build: ✅ Success
- Date: 2026-07-18
