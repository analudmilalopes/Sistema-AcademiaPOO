# 🏋️ Sistema-Academia-POO

**Foco em praticar conceitos de POO🤝**


### 27 de Abril:
**Criação do Projeto**

* Criei a estrutura inicial do projeto
* Implementei as classes principais 
* * `Aluno`
* * `Recepcionista`
* * `Gerente`
* Criação de enums:

  * `TipoPlano`
  * `MetodoPagamento`

### 02 de Maio:
**Início da modelagem do sistema**

* Criação da classe Pessoa para aplicação de herança
* Refatoração das classes Aluno, Recepcionista e Gerente
* Adição de tratamento de erro no menu
* Implementação do menu principal:
  * `Cadastrar`
  * `Login`
  * `Sair`


### 03 de Maio:
**Camada de Service**

* Criação do `PlanoService`
* Início do `AlunoService`
* Aplicação de injeção de dependência no service de plano
* Refatoração de métodos desnecessários

### 04 de Maio:
**Finalizando service**
* Finalização do `AlunoService`
* Uso de Stream com Filter para otimização de busca

### 05 de Maio:
**Controller e Repository**

* Criação do `GerenteController` com menu completo
* Criação da `TelaSecundaria` para exibição dos planos
* Adição de remoção de aluno por CPF
* Refatoração: Recepcionista e Gerente recebem o Service

### 06 de Maio:
**Fluxo de cadastro e pagamento do Aluno**
* Criação da `TelaTerciaria` com menu de pagamento
* Implementação do termo de adesão com dados do aluno
* Fluxo completo: cadastro → escolha de plano → pagamento
* ID do aluno gerado automaticamente

### 07 de Maio:
**Desenvolvendo arquitetura**

* Organizando as classes em camadas:
* `model`
* `repository`
* `service`
* `controller`

### 12 de Maio:
**Arrumando bugs de cadastro**

* Correções:
* `loops que encerravam o menu incorretamente`
*  `leitura da entrada do nome do aluno`
* `ajuste do fluxo após pagamento efetuado`

### 13 de Maio:
**Melhorias na busca e organização**

* Implementação de busca de alunos por tipo de plano
* Melhorias visuais no menu do gerente
* Uso de `Stream`


### 16 de Maio:
**Controller Aluno e correções**

* Criação do `AlunoController`
* Criação do `PagamentoRepository`
* Implementação do cálculo de IMC
* Refatoração da leitura de entrada
* Adição de peso e altura no cadastro do aluno
* Implementação de loops no controller do gerente
* Correções:
* `bugs nos menus`
* `switch case`
* `ajuste do fluxo de cadastro e pagamento`


### 18 de Maio:
**Correções de validação e bugs**
* Correções:
* `cálculo de IMC`
* `validação de nomes e números decimais`


### 19 de Maio:
**Controller recepcionista e correções**

* Criação do `RecepcionistaController`
* Integração da recepcionista na `TelaInicial` e `Main`
* Implementação da visualização de dados do pagamento
* Adição de recomendação de cardio baseada no IMC
* Melhorias visuais nos dados do aluno e treino semanal
* Correções:
* `lógica de IMC alto`
* `salvamento do pagamento no repositório`
* `validação de CPF e nome no login`

### 20 de Maio:
**Refatoração e arquivo txt**

* Refatorações:
  * `java.awt` removido do `LeitorEntrada`
  * `AlunoService` duplicado removido de `Gerente` e `Recepcionista`
  * Login atualizado para usar `Optional`
* Criação do `AlunoRepositoryArquivo` com:
* leitura, escrita e remoção de alunos em `alunos.txt`

# FIM DO PROJETO!💫
### 21 de Maio:

* Substituindo `null` por `Optional` nas buscar do `AlunoService`
* Correções:
  * Verificação de existência do cpf antes de pedir altura e peso
  * Busca pelo nome passa a ter insensitive
  * Contador do ID sincronizado com o arquivo `alunos.txt`
  * `try catch` na mostrar busca por tipo diferente de plano em `GerenteController`[
  * adicionando `alunos.txt` ao `.gitignore`
