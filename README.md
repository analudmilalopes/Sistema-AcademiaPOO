# 🏋️ Sistema-Academia-POO

Projeto focado para aprimorar Java com Orientação a Objetos.

## ✍️ Evolução do Projeto

**27/Abr/2026: Criação do Projeto**
Desenvolvimento inicial do sistema com foco em praticar conceitos de POO.

* Criei a estrutura inicial do projeto
* Implementei as classes principais (Aluno, Recepcionista e Gerente)
* Criação de enums:

  * `TipoPlano`
  * `MetodoPagamento`

**02/Mai/2026:  Início da modelagem do sistema**

* Criação da classe Pessoa para aplicação de herança 
* Refatoração das classes Aluno, Recepcionista e Gerente
* Implementação do menu principal:
  * `Cadastrar`
  * `Login`
  * `Sair`
* Adição de tratamento de erro no menu

**03/Mai/2026: Camada de Service**
* Criação do `PlanoService`
* Início do `AlunoService`
* Aplicação de injeção de dependência no service de plano
* Refatoração de métodos desnecessários

**04/Mai/2026: Finalizando Aluno Service**
* Finalização do `AlunoService`
* Uso de Stream com Filter para otimização de busca

**05/Mai/2026: Controller e Repository**
* Criação do `GerenteController` com menu completo
* Adição de remoção de aluno por CPF
* Refatoração: Recepcionista e Gerente recebem o Service
* Criação da `TelaSecundaria` para exibição dos planos

**06/Mai/2026: Fluxo de cadastro e pagamento do Aluno**
* Criação da `TelaTerciaria` com menu de pagamento
* Implementação do termo de adesão com dados do aluno
* Fluxo completo: cadastro → escolha de plano → pagamento
* ID do aluno gerado automaticamente