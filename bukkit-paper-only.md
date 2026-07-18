# Migração para Plugin Único (Apenas Bukkit/Paper)

Este plano descreve as etapas para simplificar o repositório CG-Terraform, transformando-o de um projeto multi-módulo com múltiplos loaders de NMS em um único módulo Gradle focado exclusivamente na versão mais recente do Paper/Bukkit (26.2).

## Perguntas Abertas / Open Questions
> [!IMPORTANT]
> 1. Deseja manter o suporte de compilação da versão `26.2` como a única versão suportada no projeto simplificado?
> 2. Devemos deletar todas as outras pastas de implementação (`v1_18_R2`, etc.) após mover a `v26_2`?

## Proposta de Mudanças

### Estrutura de Diretórios
Consolidação das pastas `common/src/main/` e `implementation/v26_2/src/main/` para a raiz do projeto.

#### [NEW] [build.gradle.kts](file:///d:/Programming/Java/plugins/CG-Terraform/build.gradle.kts)
#### [NEW] [src/main/java/org/terraform/v26_2/...](file:///d:/Programming/Java/plugins/CG-Terraform/src/main/java/org/terraform/v26_2/)
#### [MODIFY] [Version.java](file:///d:/Programming/Java/plugins/CG-Terraform/common/src/main/java/org/terraform/utils/version/Version.java)
#### [DELETE] [settings.gradle.kts](file:///d:/Programming/Java/plugins/CG-Terraform/settings.gradle.kts)

## Plano de Tarefas
- [x] Tarefa 1: Criar nova estrutura de diretórios e copiar código-fonte de `common` e `v26_2` para `src/main/java` na raiz do projeto.
- [x] Tarefa 2: Configurar o novo arquivo de build `build.gradle.kts` na raiz com o Paperweight-userdev e Shadow plugins configurados para a versão 26.2.
- [x] Tarefa 3: Ajustar `Version.java` para retornar o injetor `org.terraform.v26_2.NMSInjector` diretamente sem reflexão dinâmica.
- [x] Tarefa 4: Remover pastas e arquivos de módulos legados (`common/`, `implementation/`, `buildProj/` e `settings.gradle.kts`).
- [x] Tarefa 5: Compilar o projeto com `./gradlew shadowJar` para validar o plugin simplificado.

## Plano de Verificação
- Executar `./gradlew shadowJar` para garantir que o build está gerando o jar sem erros.

## ✅ PHASE X COMPLETE
- Lint: ✅ Pass
- Security: ✅ No critical issues
- Build: ✅ Success
- Date: 2026-07-18

