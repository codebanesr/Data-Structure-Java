class Product {
    int expiry, name;
    double discount, price;
}

@AllArgsConstructor @Getter @Setter
class Bucket<P extends Product> {
    P product;
    double price;
}
public interface IVendingMachine {
    boolean reset();
    double selectItemAndGetPrice();
    boolean refund();
    Bucket collectItemAndChange();
}


class SimpleVendingMachine implements IVendingMachine{

}

class VendingMachineFactory {
    IVendingMachine createVendingMachine(String code) {

        return null;
    }
}


class NotFoundException extends Exception {
    NotFoundException(String message) {
        super(message);
    }
}


class ProductExpiredException extends Exception {
    ProductExpiredException(String message) {
        super(message);
    }
}