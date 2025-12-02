import Utilitats.UtilitatsConsola;

char card(int card) {
    switch (card) {
        case 1, 13:  {
            return 'A';
        }
        case 2, 3, 4, 5, 6, 7, 8, 9: {
            return (char) ((char) card + 48);
        }
        case 10: {
            return 'J';
        }
        case 11: {
            return 'Q';
        }
        default: {
            return 'K';
        }
    }
}

int valuation(char valor) {
    switch (valor) {
        case 'A': {
            return 11;
        }
        case 'J','Q','K': {
            return 10;
        }
        default: {
            return (int) ((int)valor - 48);
        }
    }
}

void main() {
    int money = 100;
    while (money > 0) {
        boolean win = true;
        IO.println("Tens "+money+"$");
        int bet;

        try {
            bet = UtilitatsConsola.llegirSencer("Quant vols apostar?: ");
        } catch (Exception e) {
            continue;
        }


        if (bet > money) {
            IO.println("Has apostat més doblers dels que tens.");
            continue;
        } else if (bet < 1) {
            IO.println("Has d'apostar al manco 1$.");
            continue;
        }

        
        int card1 = 1 + (int)(Math.random()*(13-1)+1);
        int card2 = 1 + (int)(Math.random()*(13-1)+1);

        IO.println("Carta 1: "+card(card1));
        IO.println("Carta 2: "+card(card2));

        int totalValue = valuation(card(card1)) + valuation(card(card2));
        IO.println("Valor total actualment: "+totalValue);

        boolean more = true;

        while(more && totalValue <= 21) {

            try {
                if (UtilitatsConsola.llegirSencer("Vols més cartes? (0 és no i 1 és si) ") == 0) {
                    more = false;
                } else {
                    int cartaExtra = 1 + (int)(Math.random()*(13-1)+1);
                    IO.println(card(cartaExtra));
                    totalValue = totalValue + valuation(card(cartaExtra));
                    IO.println("Valor total actualment: "+totalValue);
                }
            } catch (Exception e) {
                continue;
            }
        }

        if(totalValue>21) {
            win = false;
        }

        int dealerValue = 0;
        totalValue = 21;

        while(dealerValue < totalValue && dealerValue < 17) {
            int cartaExtra = 1 + (int)(Math.random()*(13-1)+1);
            IO.println(card(cartaExtra));
            dealerValue = dealerValue + valuation(card(cartaExtra));
            IO.println("Valor actual del dealer: "+dealerValue);            
        }

        if(dealerValue<=21 && dealerValue>=totalValue){
            win = false;
        }

        if(win) {
            IO.println("Has guanyat "+bet+"$");
            money = money+bet;
        } else {
            IO.println("Has perdut "+bet+"$");
            money = money - bet;
        }
    }
    IO.println("L'has perdut tot.");
}
