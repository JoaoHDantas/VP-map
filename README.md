# 🎮 Projeto: Pixels para Valorant

---

## 🚩 Problema

Na atualidade, encontramos diversos tipos de jogos eletrônicos com cenário competitivo. Nesse caso, o presente projeto tem como alvo o jogo **Valorant**, amplamente conhecido pela sua complexidade e comunidade em constante expansão. No âmbito do jogo, existem diversas formas de surpreender os jogadores adversários, aumentando assim a chance de uma partida ser ganha pela sua equipe. Porém, tais mecânicas são difíceis de serem executadas, além de serem inúmeras. Dessa forma, o jogador precisa de algum meio para buscar tais informações, a fim de auxiliar seu time a alcançar a vitória e chegar mais perto do seu sonho competitivo.

---

## 💭 Proposta

A fim de resolver tal cenário, idealizou-se, com o presente projeto, o desenvolvimento de um sistema de **armazenamento, criação e listagem de mecânicas** do cenário do jogo Valorant, conhecidos como **“pixels”**. Os pixels, quando executados de forma correta, podem mudar o rumo de uma partida e levar seu time ao êxito.

Sendo assim, um sistema gratuito onde usuários podem interagir com publicações de pixels, criar e procurar suas preferências tornou-se extremamente necessário. Dessa forma, com o advento dessa tecnologia, será possível nivelar o jogo entre a comunidade iniciante, que sofre com maus hábitos de alguns dos jogadores mais experientes, e o restante dos usuários. 

O site não se limita apenas à experiência positiva de iniciantes: jogadores experientes poderão povoar o site com **“pixels” novos criados por eles**, ganhando pontos no **ranking de Fama** presente no site. Portanto, o projeto tende a beneficiar toda a comunidade do Valorant, tanto no âmbito prático (jogabilidade) quanto na interação social amigável entre os jogadores.

---

## 📑 Plano de Desenvolvimento

- Estamos construindo um site que consiste em criar uma comunidade em torno do jogo e da postagem de pixels para auxílio em partidas.
- O site vai te ajudar em uma busca rápida para encontrar pixels durante suas partidas e auxiliar no seu desempenho.
- Sim, o site poderia te ajudar a melhorar, te ensinando pixels que você não saiba para utilizar nas suas partidas.

### Etapas do Desenvolvimento:

1. Ideação
2. Modelagem
3. Prototipagem
4. Desenvolvimento
5. Correções
6. Manutenção

---

## 🔗 Protótipo de Interface

**Protótipo de Interface**: [Figma da equipe](https://www.figma.com/design/rmMTx6g9mzQjB9UHYzb0C8/valorant-Pixels?node-id=181-16&node-type=frame&t=SydzxYLeVI49q579-0)

---

## 🌐 UML

### Diagrama de Classes

- [Link do diagrama de classes UML](https://drive.google.com/file/d/1QnOB6101JIuNYfOu7Ek7QZRlXy1AVc5e/view?usp=sharing)

### Diagrama de Casos de Uso

- [Link do diagrama de casos de uso](https://drive.google.com/file/d/1T7DzE3-ilWJ2j26tL81DRc8X7jpvIuex/view?usp=sharing)

### Diagrama de Atividades

- [Link do diagrama de atividades](https://drive.google.com/file/d/1SRqIw0qOqRWuWbNMXBUYD8gOQj7SXnC2/view?usp=sharing)

---

## 🧪 Requisitos

### Requisitos Funcionais

- Realizar Login
- Postar Pixels
- Ver Pixels
- Editar Pixels
- Filtrar Pixels
- Abrir perfil
- Ver relatório de insígnias
- Ver relatório de pixels postados
- Adicionar pontuação de ranking por usuário
- Ver ranking de usuários
- Interagir com publicação
- Avaliar integridade da publicação

### Requisitos Não Funcionais

- Paleta de cores agradável
- Padrão de fontes definidas
- Segurança de informações
- Acessibilidade
- Facilidade de uso do sistema
- Alto desempenho
- Escalabilidade
- Disponibilidade
- Responsividade

---

## 🚧 Restrições do Sistema

- **Restrições de Postagens**: No início, o sistema terá pouca variedade de pixels disponíveis.
- **Restrição de Conhecimento**: O sistema possui um público-alvo bem definido e não é amplamente diversificado.

---

## 🎲 Padrão de projeto

- O padrão de projeto escolhido para o desenvolvimento das classes foi o Facade. Assim como o seu objetivo principal, esse padrão estrutural cria uma interface simplificada para a utilização de métodos do conjunto de classes:

![image](https://github.com/user-attachments/assets/34149c5f-1f19-4a1f-82d4-a4e9b19ee7e0)

Assim como pode ser visto na imagem acima, o sistema Facade tem o controle total sobre os métodos envolvendo os pixels e os agentes diretos. Dessa forma, a responsabilidade das classes Admin e User passam para o sistemaFacade.

---

## ⚙️ Tecnologias/Frameworks

- JUnit (Testes Unitários)
- Swing UI Designer (Interface de uso)
- MySQL (Banco de dados)

---

## 🧠 Refatorações no código:

- Extract Class: A classe User e a classe Admin continham informações referentes ao contato direto, sendo assim, realizando mais de uma tarefa ao mesmo tempo. Dessa forma, tal restrição estava em desacordo com o método SOLID, em seu primeiro princípio (Princípio da responsabilidade única). 
  #### Solução: Criação da classe contato
- Move Method: Os métodos referentes ao uso e a manipulação dos dados ainda estavam presos na classe User e Admin.
  #### Solução: Métodos foram todos movidos para a própria classe de contato, isolando suas funções.
- Move Field: Os atributos referentes ao uso e a manipulação dos dados ainda estavam presos na classe User e Admin.
  #### Solução: Atributos foram todos movidos para a própria classe de contato, isolando suas funções.
- Encapsulate Field: A maior parte dos atributos nas classes estavam públicos.
  #### Solução: Os atributos que revelam dados sensíveis foram encapsulados.

---

## 🛠️ Testes:

- Testes unitários com JUnit: Cada classe foi testada com seus métodos correspondentes, incluindo cada definição e retorno de informações de atributos da classe.

![image](https://github.com/user-attachments/assets/f596387d-209d-4599-beec-981aa1eae961)
### Teste de criação de ADMIN, validando a inserção de atributos e verificando a corresponência das informações.

![image](https://github.com/user-attachments/assets/acee47df-999c-4ab0-850c-3ed83ee08df2)
### Teste de criação de CONTATO, validando a inserção de atributos e verificando a corresponência das informações.

![image](https://github.com/user-attachments/assets/e99e7be6-b594-49dd-a10e-8b6c11823f99)
### Teste de criação de PIXEL, validando a inserção de atributos e verificando a corresponência das informações dentro de uma única chamada de teste.

Obs.: Todos os testes seguem o mesmo padrão e todas as classes criadas foram testadas com testes unitários.

![image](https://github.com/user-attachments/assets/22404ede-6c7f-4230-ae76-95406ef2f87f)

