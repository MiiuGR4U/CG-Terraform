# Alternância entre Estruturas Vanilla e Modificadas

Este plano implementa chaves de configuração no arquivo `config.yml` do plugin, permitindo que o administrador do servidor escolha, para cada estrutura principal, se deseja utilizar a versão vanilla (geração nativa do Minecraft) ou a versão modificada do plugin.

## Proposed Changes

### [NEW] [GenericVanillaStructurePopulator.java](file:///d:/Programming/Java/plugins/CG-Terraform/common/src/main/java/org/terraform/structure/GenericVanillaStructurePopulator.java)
- Criar um populator genérico para estruturas vanilla, estendendo `VanillaStructurePopulator` e permitindo definir a chave do Minecraft, biomas permitidos e status de ativação.

### [MODIFY] [TConfig.java](file:///d:/Programming/Java/plugins/CG-Terraform/common/src/main/java/org/terraform/main/config/TConfig.java)
- Adicionar chaves booleanas para selecionar o modo vanilla para cada estrutura:
  - `structures.pyramid.use-vanilla`
  - `structures.stronghold.use-vanilla`
  - `structures.mansion.use-vanilla`
  - `structures.village.use-vanilla`
  - `structures.monument.use-vanilla`
  - `structures.ancientcity.use-vanilla`
  - `structures.outpost.use-vanilla`
  - `structures.mineshaft.use-vanilla`

### [MODIFY] [StructureRegistry.java](file:///d:/Programming/Java/plugins/CG-Terraform/common/src/main/java/org/terraform/structure/StructureRegistry.java)
- Na rotina de registro (`init()`), verificar os booleanos `use-vanilla` da configuração:
  - Se for `true`, registrar uma instância de `GenericVanillaStructurePopulator` com a chave correspondente do Minecraft.
  - Se for `false`, registrar o populator customizado padrão (ex: `PyramidPopulator`, `VillagePopulator`).

## Verification Plan

### Automated Tests
- Executar `./gradlew shadowJar` para garantir que o plugin compila sem erros.

## ✅ PHASE X COMPLETE
- Lint: ✅ Pass
- Security: ✅ No critical issues
- Build: ✅ Success
- Date: 2026-07-18
