package com.brasiljug.eda.order;

import com.brasiljug.eda.service.*;
import com.brasiljug.eda.service.response.OrderResponse;
import com.brasiljug.eda.service.response.PaymentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {

    private final PaymentService paymentService;
    private final InventoryService inventoryService;
    private final SellerService sellerService;
    private final ShippingService shippingService;
    private final NotificationService notificationService;
    private final AnalyticsService analyticsService;

    public OrderResponse processOrder(Order order) {
        try {
            // Processa pagamento
            PaymentResponse payment = paymentService.processPayment(order);
            if (!payment.isSuccess()) {
                throw new RuntimeException("Falha no pagamento");
            }
            order.setStatus("PAID");

            // Verifica inventário
            boolean hasStock = inventoryService.checkStock(order.getItems());
            if (!hasStock) {
                inventoryService.buyItems(order.getItems());
            } else {
                // Atualiza estoque
                inventoryService.updateStock(order.getItems());
            }

            // Notifica vendedor
            sellerService.notifySale(order);

            // Cria entrega
            shippingService.createShipping(order);

            // Envia email para cliente
            notificationService.sendOrderConfirmation(order);

            // Atualiza análise de vendas
            analyticsService.updateSalesAnalytics(order);

            return new OrderResponse(order.getId(), "SUCCESS");

        } catch (Exception e) {
            throw new RuntimeException("Erro no processamento", e);
        }
    }

}
