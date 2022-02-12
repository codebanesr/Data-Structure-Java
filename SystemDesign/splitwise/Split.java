@Data
public abstract class Split {
    private User user;
    double amount;
}


class EqualSplit extends Split {
    EqualSplit(User user) {
        super(user);
    }
}

class ExactSplit extends Split {
    ExactSplit(User user, int amount) {
        super(user);
        this.amount = amount;
    }
}

@Data
class PercentSplit extends Split {
    double percent;

    PercentSplit(User user) {
        super(user);
    }
}