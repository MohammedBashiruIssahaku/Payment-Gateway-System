package Bashiru.com.Payment.Gateway.System.DTO;

/**
 * Data Transfer Object (DTO) for account balance details.
 * Represents the balance information returned by the MTN MoMo API, including
 * available funds and the currency type.
 * @param availableBalance the current available balance in the account
 * @param currency the currency in which the balance is expressed
 */
public record AccountBalanceDto(
        String availableBalance,
        String currency
)
{
}
