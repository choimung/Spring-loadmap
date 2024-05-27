package hello.proxy.app.v2;

public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepositoryV3;

    public OrderServiceV3(OrderRepositoryV3 orderRepositoryV3) {
        this.orderRepositoryV3 = orderRepositoryV3;
    }

    public void orderItem(String itemId) {
        orderRepositoryV3.save(itemId);
    }
}
