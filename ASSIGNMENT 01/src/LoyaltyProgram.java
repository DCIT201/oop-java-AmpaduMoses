import javax.naming.InsufficientResourcesException;

public interface LoyaltyProgram{
    void addPoints(int points);
    void redeemPoints(int points) throws InsufficientPointsException;
    int getPoints();
}
