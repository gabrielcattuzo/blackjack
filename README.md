# Blackjack

## Descrição
Este repositório contém um projeto de implementação interativa do jogo "21" (conhecido como Blackjack) desenvolvido na linguagem Java. O objetivo é simular uma partida de Blackjack com funcionalidades básicas do jogo, incluindo gerenciamento de cartas, participantes e lógica de pontuação.

## Funcionalidades
- **Gerenciamento de Cartas**: Classe para representar cartas individuais e um baralho completo.
- **Participantes**: Representação de jogadores e dealer, com controle de mãos e pontuações.
- **Lógica do Jogo**: Implementação das regras básicas do Blackjack, incluindo distribuição de cartas, verificação de vitórias e empates.
- **Interface Interativa**: Possibilita jogadas como "hit" (pedir carta) e "stand" (parar), simulando uma partida real.

## Estrutura do Projeto
- `Carta.java`: Classe que representa uma carta do baralho, com atributos como naipe e valor.
- `BaralhoCartas.java`: Classe responsável por gerenciar o baralho, incluindo embaralhamento e distribuição de cartas.
- `Participante.java`: Classe base para jogadores e dealer, controlando a mão atual e pontuação.
- `PartidaBlackjack.java`: Classe principal que orquestra a partida, aplicando as regras do jogo.

## Tecnologias Utilizadas
- **Linguagem**: Java
- **Disciplina**: Orientado a Objetos

## Como Utilizar?
- Abrir o terminal do Desktop, e execute:
- git clone https://github.com/gabrielcattuzo/blackjack
- Abrir o terminal no diretório Blackjack
- Compilar o código via comando: javac PartidaBlackjack.java e após isso -> java PartidaBlackjack