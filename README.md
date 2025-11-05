# Desafio: Implementação de Arquitetura Orientada a Eventos (EDA)

## 🎯 Objetivo
Refatorar um sistema monolítico de marketplace para uma arquitetura orientada a eventos, 
aplicando os princípios de EDA e escolhendo entre RabbitMQ (Filas) ou Kafka (Tópicos).

## 🏗️ Sistema Atual
Sistema monolítico onde todos os serviços são chamados de forma síncrona:
- Verificação de inventário
- Processamento de pagamento
- Atualização de estoque
- Notificação de vendedor
- Criação de entrega
- Envio de confirmações
- Atualização de analytics

## 📋 Requisitos

### Funcionais
- Processamento assíncrono de pedidos
- Operação independente dos serviços
- Escalabilidade independente dos serviços

### Específicos
1. **Pagamento**
    - Se o pagamento falhar não deve prosseguir com o pedido
   
2. **Inventário**
    - Se não houver estoque deve solicitar reabastecimento

3. **Analytics**
    - Faz a persistência de dados históricos

4. **Notificações**
    - Notifica o vendedor e o cliente sobre o status do pedido

## 🛠️ Tarefas

1. Escolher entre RabbitMQ ou Kafka
2. Implementar produtores e consumidores (pode ser na mesma aplicação para simplificar)
3. Implementar tratamento de falhas
4. Garantir idempotência - (garantir que o evento não seja processado duas vezes)

