# Desafio: Implementação de Arquitetura Orientada a Eventos (EDA)

## 🎯 Objetivo
Refatorar um sistema monolítico de marketplace para uma arquitetura orientada a eventos, 
aplicando os princípios de EDA e escolhendo entre RabbitMQ (Filas) ou Kafka (Tópicos).

## 📦 Tecnologias Utilizadas

- **Java 25** - Linguagem de programação
- **Spring Boot 3.5.7** - Framework para aplicação
- **Gradle 8.14.3** - Gerenciador de build e dependências
- **Spring AMQP** - Integração com RabbitMQ
- **Spring Kafka** - Integração com Apache Kafka
- **Lombok** - Redução de código boilerplate
- **JUnit Platform** - Framework de testes

## 🚀 Como Executar

### Pré-requisitos
- Java 25 ou superior instalado
- Docker (opcional, para executar RabbitMQ ou Kafka localmente)

### Executar o projeto
```bash
# Compilar o projeto
./gradlew build

# Executar a aplicação
./gradlew bootRun

# Executar os testes
./gradlew test
```

## 🏗️ Sistema Atual

Este projeto contém uma implementação **monolítica** inicial de um sistema de marketplace, onde todos os serviços são chamados de forma **síncrona** através do `OrderService`:

### Serviços Implementados:
- **PaymentService** - Processamento de pagamento
- **InventoryService** - Verificação e atualização de inventário
- **SellerService** - Notificação de vendedor
- **ShippingService** - Criação de entrega
- **NotificationService** - Envio de confirmações ao cliente
- **AnalyticsService** - Atualização de analytics

### Estrutura do Código:
```
src/main/java/com/brasiljug/eda/
├── EdaApplication.java           # Classe principal Spring Boot
├── order/
│   ├── Order.java                # Modelo de pedido
│   ├── OrderItem.java            # Item do pedido
│   └── OrderService.java         # Orquestração SÍNCRONA atual
└── service/
    ├── PaymentService.java
    ├── InventoryService.java
    ├── SellerService.java
    ├── ShippingService.java
    ├── NotificationService.java
    ├── AnalyticsService.java
    └── response/                 # DTOs de resposta
```

**⚠️ Importante:** O código atual representa o **ponto de partida** do desafio. Todos os serviços são chamados sincronamente no método `OrderService.processOrder()`.

## 📋 Requisitos do Desafio

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

1. **Escolher entre RabbitMQ ou Kafka** (ou ambos!)
   - Já existem as dependências para ambos no projeto
   
2. **Implementar produtores e consumidores**
   - Pode ser na mesma aplicação para simplificar
   - Criar eventos para cada operação do fluxo
   
3. **Implementar tratamento de falhas**
   - Dead Letter Queue/Topics
   - Retry mechanisms
   - Circuit breaker (opcional)
   
4. **Garantir idempotência**
   - Garantir que o evento não seja processado duas vezes
   - Implementar mecanismos de deduplicação

## 💡 Próximos Passos

1. Escolha sua tecnologia de mensageria (RabbitMQ ou Kafka)
2. Configure o broker localmente (Docker recomendado)
3. Crie os eventos de domínio (OrderCreated, PaymentProcessed, etc.)
4. Refatore o `OrderService` para publicar eventos ao invés de chamar serviços diretamente
5. Implemente consumidores nos serviços para reagir aos eventos
6. Adicione tratamento de erros e retry logic
7. Implemente idempotência nos consumidores
8. Teste o fluxo completo

## 🤝 Como Contribuir

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/MinhaFeature`)
3. Commit suas mudanças (`git commit -m 'Adiciona MinhaFeature'`)
4. Push para a branch (`git push origin feature/MinhaFeature`)
5. Abra um Pull Request

## 📝 Licença

Este projeto é um desafio educacional da comunidade Brasil JUG.

