/**
 *
 * @author Carl and GuoHao
 * @version 1.0
 */package game;

public class Other {

    /**
     * 
     * @param value
     * @param player
     * @return 
     */
    static String opportunity(int value, int player) {
        String message = "";
        double amount = Start.amount(player);
        amount = amount - 200;
        Properties.update(player, amount); 
        switch (value){
            case 1:
                amount = amount + 50;
                Properties.update(player, amount); 
                message += "Description :  Bank pays you divided of £50\n";
                message += "Action :  Bank pays player £50\n";
                break;
            case 2:
                amount = amount + 100;
                Properties.update(player, amount); 
                message += "Description :  You have won a lip sync battle. Collect £100\n";
                message += "Action :  Bank pays player £100\n";
                break;
            case 3:
                // level
                Level.updateLevel(25, player); //update player level
                message += "Description :  Advance to Turing Heights\n";
                message += "Action :  Player token moves forwards to Turing Heights\n";
                break;
            case 4:
           //             amount = amount - 200;
           // Properties.update(player, amount);
                Level.updateLevel(40, player); //update player level
                message += "Description :  Advance to Han Xin Gardens. If you pass GO, collect £200\n";
                message += "Action : Player moves token \n";
                break;
            case 5:
                amount = amount - 15;
                Properties.update(player, amount); 
                message += "Description :  Fined £15 for speeding\n";
                message += "Action :  Player puts £15 on free parking\n";
                break;
            case 6:
                amount = amount - 150;
                Properties.update(player, amount); 
                message += "Description : Pay university fees of £150 \n";
                message += "Action :  Player pays £150 to the bank\n";
                break;
            case 7:
                Level.updateLevel(16, player); //update player level
                message += "Description : Take a trip to Hove station. If you pass GO collect £200 \n";
                message += "Action :  Player moves token\n";
                //Player moves token
                break;
            case 8:
                amount = amount + 150;
                Properties.update(player, amount); 
                message += "Description :  Loan matures, collect £150\n";
                message += "Action :  Bank pays £150 to the player\n";
                break;
            case 9:
                amount = amount - 155;
                Properties.update(player, amount); 
                message += " Description : You are assessed for repairs, £40/house, £115/hotel\n";
                message += " Player pays money to the bank \n";
                break;
            case 10:
                Level.updateLevel(1, player); //update player level
                message += "Description :  Advance to GO\n";
                message += "Action :  Player moves token\n";
                break;
            case 11:
                amount = amount - 125;
                Properties.update(player, amount);
                message += "Description :  You are assessed for repairs, £25/house, £100/hotel\n";
                message += "Action :  Player pays money to the bank\n";
                break;
            case 12:
                int location = Level.playerLevel(player);
                if (location < 0){
                    location += 40;
                }
                location = location -3;
                Level.updateLevel(location, player); //update player level
                message += "Description : Go back 3 spaces \n";
                message += "Action :  Player moves token \n";
                break;
            case 13:
                Level.updateLevel(12, player); //update player level
                message += "Description : Advance to Skywalker Drive. If you pass GO collect £200 \n";
                message += "Action :  Player moves token \n";
                break;
            case 14:
                amount = amount - 200;
                Properties.update(player, amount); 
                message += "Description : Go to jail. Do not pass GO, do not collect £200 \n";
                message += "Action :  As the card says\n";
                break;
            case 15:
                amount = amount + 20;
                Properties.update(player, amount);                 
                message += "Description :  Drunk in charge of a skateboard. Fine £20\n";
                message += "Action :  Player puts £20 on free parking\n";
                break;
            case 16:
                amount = amount - 200;
                Properties.update(player, amount);                 
                message += "Description : Get out of jail free \n";
                message += "Action :  Retained by the player until needed. No resale or trade value \n";
                break;
        }
        return message;
    }

    static String potLuck(int value, int player) {
        String message = "";
        int players = Start.Count();
        double amount = Start.amount(player);    
        switch (value){
            case 1:
                amount = amount + 100;
                Properties.update(player, amount); 
                message += "Description : You inherit £100 \n";
                message += "Action :  Bank pays player £100\n";
                break;
            case 2:
                amount = amount + 20;
                Properties.update(player, amount); 
                message += "Description : You have won 2nd prize in a beauty contest, collect £20\n";
                message += "Action :  Bank pays player £20 \n";
                break;
            case 3:
                Level.updateLevel(2, player); //update player level
                message += "Description :  Go back to Crapper Street\n";
                message += "Action :  Player token moves backwards to Crapper Street\n";
                break;
            case 4:
                amount = amount + 20;
                Properties.update(player, amount); 
                message += "Description :  Student loan refund. Collect £20\n";
                message += "Action :  Bank pays player £20\n";
                break;
            case 5:
                amount = amount + 200;
                Properties.update(player, amount); 
                message += "Description :  Bank error in your favour. Collect £200\n";
                message += "Action :  Bank pays player £200\n";
                break;
            case 6:
                amount = amount - 100;
                Properties.update(player, amount); 
                message += "Description :  Pay bill for text books of £100\n";
                message += "Action :  Player pays £100 to the bank\n";
                break;
            case 7:
                amount = amount - 50;
                Properties.update(player, amount); 
                message += "Description :  Mega late night taxi bill pay £50\n";
                message += "Action :  Player pays £50 to the bank\n";
                break;
            case 8:
                // amount = amount - 200;
                // Properties.update(player, amount); 
                message += " Description : Advance to go\n";
                message += " Action : Player moves forwards to GO\n";
                break;
            case 9:
                amount = amount + 50;
                Properties.update(player, amount);
                message += "Description :  From sale of Bitcoin you get £50\n";
                message += "Action : Bank pays player £50 \n";
                break;
            case 10:    
                amount = amount - 10;
                Properties.update(player, amount);
                message += "Description :  Pay a £10 fine or take opportunity knocks\n";
                message += "Action :  If fine paid, player puts £10 on free parking \n";
                break;
            case 11:    
                amount = amount - 50;
                Properties.update(player, amount); 
                message += "Description :  Pay insurance fee of £50\n";
                message += "Action :  Player puts £50 on free parking\n";
                break;
            case 12:
                amount = amount + 100;
                Properties.update(player, amount); 
                message += "Description :  Savings bond matures, collect £100\n";
                message += "Action :  \n";
                break;
            case 13:
                // go to jail
                // amount = amount - 200;
                // Properties.update(player, amount); 
                Level.updateLevel(31, player); //update player level
                message += "Description :  Go to jail. Do not pass GO, do not collect £200\n";
                message += "Action :  \n";
                break;
            case 14:
                amount = amount + 25;
                Properties.update(player, amount);                 
                message += "Description :  Received interest on shares of £25\n";
                message += "Action :  Bank pays player £25\n";
                break;
            case 15:
                int pay = players * 10;
                amount = amount + pay;
                Properties.update(player, amount);                 
                message += "Description : It's your birthday. Collect £10 from each player \n";
                message += "Action : Player receives £10 from each player \n";
                break;
            case 16:
                message += "Description :  Get out of jail free\n";
                message += "Action : Retained by the player until needed. No resale or trade value \n";
                break;
        }
        return message;
    }  
}
