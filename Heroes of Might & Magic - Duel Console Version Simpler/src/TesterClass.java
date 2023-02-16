import ConsoleFormatters.ConsoleFormatting;
import Parent_Classes.Hero;
import Parent_Classes.Spell;
import Parent_Classes.Unit;
import Parent_Classes.UnitComparator;
import Spells.*;
import Units.*;

import java.awt.*;
import java.util.*;

public class TesterClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%100s", ConsoleFormatters.ConsoleFormatting.BLUE_BRIGHT + "Welcome to the Heroes of Might & Magic - Duel version!\n" + ConsoleFormatters.ConsoleFormatting.RESET);
        System.out.printf("%110s", ConsoleFormatters.ConsoleFormatting.BLUE_BRIGHT +  "Before you can begin playing the actual game, please choose a difficulty!\n" + ConsoleFormatters.ConsoleFormatting.RESET);
        System.out.printf("%100s", ConsoleFormatting.RED_UNDERLINED +  "Note: For the rest of the game, you can control everything by writing the right word or character shown " +
                "in the corresponding bracket!\n" + ConsoleFormatters.ConsoleFormatting.RESET);
        System.out.printf("%98s", ConsoleFormatters.ConsoleFormatting.RED_UNDERLINED +  "You can write everything with lowercase characters.\n" + ConsoleFormatters.ConsoleFormatting.RESET);
        System.out.println();

        System.out.printf("%64s", ConsoleFormatters.ConsoleFormatting.GREEN_BOLD_BRIGHT + "Easy (E)" + ConsoleFormatters.ConsoleFormatting.RESET);
        System.out.printf("%22s", ConsoleFormatters.ConsoleFormatting.YELLOW_BOLD_BRIGHT + "Medium (M)" + ConsoleFormatters.ConsoleFormatting.RESET);
        System.out.printf("%20s", ConsoleFormatters.ConsoleFormatting.RED_BOLD_BRIGHT + "Hard (H)" + ConsoleFormatters.ConsoleFormatting.RESET);
        System.out.println("\n");

        Hero player1 = new Hero(3, 2, 2, 2, 3, 4, 50, 1, false, 0);
        Hero player2 = new Hero(1, 1, 1, 1, 1, 1, 50, 2, false, 0);

        //Ellenfél képességeine kiosztása
        int points = 10;
        Random rand = new Random();
        for (int i = 0; i < points; i++) {
            int upgrade = rand.nextInt(6);
            switch (upgrade) {
                case 0 -> player2.setAttack(player2.getAttack() + 1);
                case 1 -> player2.setDefense(player2.getDefense() + 1);
                case 2 -> player2.setSpellPower(player2.getSpellPower() + 1);
                case 3 -> player2.setKnowledge(player2.getKnowledge() + 1);
                case 4 -> player2.setLuck(player2.getLuck() + 1);
                case 5 -> player2.setMorale(player2.getMorale() + 1);
            }
        }

        //Varázslatok vásárlása
        Fireball fireball = new Fireball();
        LightningBolt lightningBolt = new LightningBolt();
        CircleofWinter circleofWinter = new CircleofWinter();
        Resurrection resurrection = new Resurrection();
        Teleport teleport = new Teleport();
        ArrayList<Spell> spells = new ArrayList<>();
        spells.add(fireball);
        spells.add(lightningBolt);
        spells.add(circleofWinter);
        spells.add(resurrection);
        spells.add(teleport);
        player1.addSpell(lightningBolt);
        player1.addSpell(fireball);
        player1.addSpell(resurrection);
        player1.addSpell(circleofWinter);
        player1.addSpell(teleport);
        player2.addSpell(lightningBolt);
        player2.addSpell(fireball);
        player2.addSpell(resurrection);
        player2.addSpell(circleofWinter);

        //Egységek
        Peasant peasant1 = new Peasant(1);
        peasant1.setInitialUnitCount(20);
        peasant1.setPosition(new Point(1, 9));
        Marksman marksman1 = new Marksman(1);
        marksman1.setInitialUnitCount(12);
        marksman1.setPosition(new Point(0, 9));
        Footman footman1 = new Footman(1);
        footman1.setInitialUnitCount(10);
        footman1.setPosition(new Point(1, 8));
        Griffin griffin1 = new Griffin(1);
        griffin1.setInitialUnitCount(6);
        griffin1.setPosition(new Point(1, 5));
        Inquisitor inquisitor1 = new Inquisitor(1);
        inquisitor1.setInitialUnitCount(4);
        inquisitor1.setPosition(new Point(0, 8));
        Cavalier cavalier1 = new Cavalier(1);
        cavalier1.setInitialUnitCount(2);
        cavalier1.setPosition(new Point(1, 6));
        Seraph seraph1 = new Seraph(1);
        seraph1.setInitialUnitCount(1);
        seraph1.setPosition(new Point(1, 7));

        player1.addUnit(peasant1);
        player1.addUnit(marksman1);
        player1.addUnit(footman1);
        player1.addUnit(griffin1);
        player1.addUnit(inquisitor1);
        player1.addUnit(cavalier1);
        player1.addUnit(seraph1);


        Peasant peasant2 = new Peasant(2);
        peasant2.setInitialUnitCount(20);
        Marksman marksman2 = new Marksman(2);
        marksman2.setInitialUnitCount(12);
        Footman footman2 = new Footman(2);
        footman2.setInitialUnitCount(10);
        Griffin griffin2 = new Griffin(2);
        griffin2.setInitialUnitCount(6);
        Inquisitor inquisitor2 = new Inquisitor(2);
        inquisitor2.setInitialUnitCount(4);
        Cavalier cavalier2 = new Cavalier(2);
        cavalier2.setInitialUnitCount(2);
        Seraph seraph2 = new Seraph(2);
        seraph2.setInitialUnitCount(2);
        player2.addUnit(peasant2);
        player2.addUnit(marksman2);
        player2.addUnit(footman2);
        player2.addUnit(griffin2);
        player2.addUnit(inquisitor2);
        player2.addUnit(cavalier2);
        player2.addUnit(seraph2);

        //Kell majd
        ArrayList<Unit> possibleUnits = new ArrayList<>();
        possibleUnits.add(peasant1);
        possibleUnits.add(marksman1);
        possibleUnits.add(footman1);
        possibleUnits.add(griffin1);
        possibleUnits.add(inquisitor1);
        possibleUnits.add(cavalier1);
        possibleUnits.add(seraph1);

        /*for (Unit unit:unitList1) {
            System.out.println(unit.getName() + ": " + unit.getUnitCount());
        }
        System.out.println();*/


        //Csatamező megrajzolása
        Unit[][] battlefield = new Unit[12][10];
        battlefield[1][9] = peasant1;
        battlefield[1][8] = footman1;
        battlefield[1][7] = seraph1;
        battlefield[1][6] = cavalier1;
        battlefield[1][5] = griffin1;
        battlefield[0][9] = marksman1;
        battlefield[0][8] = inquisitor1;

        //placeTheUnits(battlefield, unitList1, scanner);

        //Kell
        for (Unit unit:player1.getUnits()) {
            unit.setInitiative(unit.getInitiative() + player1.getMorale());
        }
        for (Unit unit:player2.getUnits()) {
            unit.setInitiative(unit.getInitiative() + player2.getMorale());
        }
        player1.setMana(player1.getMana() + 10 * player1.getKnowledge());
        player2.setMana(player2.getMana() + 10 * player1.getKnowledge());
        ArrayList<Unit> allUnits = new ArrayList<>();
        allUnits.addAll(player1.getUnits());
        allUnits.addAll(player2.getUnits());

        //System.out.println(allUnits.size());

        //Saját játékos kiírása
        /*System.out.println("You:");
        System.out.println(player1 + "\n");
        System.out.println("Your army:");
        //player1.printUnitNamesAndQuantity();
        for (Unit unit:player1.getUnits()) {
            System.out.println(unit + "\n");
        }
        System.out.println();
        System.out.println("Your spells:");
        player2.printSpellNames();
        System.out.println();
        System.out.println();*/

        //Ellenfél kiírása
        /*System.out.println("Your opponent:");
        System.out.println(player2 + "\n");
        System.out.println("Enemy army:");
        //player2.printUnitNamesAndQuantity();
        for (Unit unit:player2.getUnits()) {
            System.out.println(unit + "\n");
        }
        System.out.println();
        System.out.println("Enemy spells:");
        player2.printSpellNames();
        System.out.println();*/

        placeEnemyUnits(battlefield, player2.getUnits());

        /*for (Unit unit:allUnits
             ) {
            System.out.println(unit.getName() + " " + unit.getTeam());
        }

        scanner.nextLine();*/

        //A két hős mindenének kiírása
        /*System.out.println();
        System.out.println();
        System.out.println(player1);
        System.out.println();
        for (Unit unit:player1.getUnits()) {
            System.out.println(unit + "\n" + "Team: " + unit.getTeam() + "\n");
        }
        System.out.println();
        printSpells(player1);
        System.out.println();

        System.out.println(player2);
        System.out.println();
        for (Unit unit:player2.getUnits()) {
            System.out.println(unit + "\n" + "Team: " + unit.getTeam() + "\n");
        }
        System.out.println();
        printSpells(player2);
        System.out.println();

        scanner.nextLine();*/


        Collections.sort(allUnits, new UnitComparator());

        drawTheBattleField(battlefield, possibleUnits);

        battle(battlefield, player1, player2, scanner, allUnits, possibleUnits);





        /*System.out.print(ConsoleFormatters.ConsoleFormatting.CLEAR_CONSOLE); //Nem akar működni
        System.out.flush();*/

        /*System.out.println(ConsoleFormatters.ConsoleFormatting.GREEN_BACKGROUND + "This text has a green background but default text!" + ConsoleFormatters.ConsoleFormatting.RESET);
        System.out.println(ConsoleFormatters.ConsoleFormatting.RED + "This text has red text but a default background!" + ConsoleFormatters.ConsoleFormatting.RESET);
        System.out.println(ConsoleFormatters.ConsoleFormatting.RED + ConsoleFormatters.ConsoleFormatting.GREEN_BACKGROUND +
                "This text has a green background and red text!" + ConsoleFormatters.ConsoleFormatting.RESET);*/ //Előbb kell a háttér


    }

    private static void placeEnemyUnits(Unit[][] battlefield, ArrayList<Unit> units) {
        Random rand = new Random();
        ArrayList<Point> meleeCoordinates = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            meleeCoordinates.add(new Point(10, i));
        }
        ArrayList<Point> rangedCoordinates = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            rangedCoordinates.add(new Point(11, i));
        }

        for (int i = 0; i < 10 - 5; i++) {
            meleeCoordinates.remove(meleeCoordinates.get(rand.nextInt(meleeCoordinates.size())));
        }

        for (int i = 0; i < 10 - 2; i++) {
            rangedCoordinates.remove(rangedCoordinates.get(rand.nextInt(rangedCoordinates.size())));
        }

        int placedRangedUnits = 0;
        int placedMeleeUnits = 0;
        for (int i = 0; i < 7; i++) {
            if (units.get(i).getName().equalsIgnoreCase("MARKSMAN") || units.get(i).getName().equalsIgnoreCase("INQUISITOR")){
                units.get(i).setPosition(rangedCoordinates.get(placedRangedUnits));
                placedRangedUnits++;
            }
            else{
                units.get(i).setPosition(meleeCoordinates.get(placedMeleeUnits));
                placedMeleeUnits++;
            }

            battlefield[units.get(i).getPosition().x][units.get(i).getPosition().y] = units.get(i);
        }
    }

    private static void battle(Unit[][] battlefield, Hero player1, Hero player2, Scanner scanner, ArrayList<Unit> allUnits, ArrayList<Unit> possibleUnits) {
        System.out.println("Press Enter to continue");
        System.out.println("Good luck!\n");
        boolean player1Wins = false;
        boolean player2Wins = false;
        for (int i = 0; !(player1Wins || player2Wins); i++) {
            //Megnézni, hogy nyert-e már valaki
            boolean player1HasUnit = false;
            boolean player2HasUnit = false;

            for (Unit unit:allUnits) {
                if (unit.getTeam() == 1){
                    player1HasUnit = true;
                }else{
                    player2HasUnit = true;
                }
            }

            player1Wins = !player2HasUnit;
            player2Wins = !player1HasUnit;

            if (player1Wins && !player2Wins){
                System.out.println("Congratulations! You won!");
                return;
            }
            else if (!player1Wins && player2Wins){
                System.out.println("You lost the battle!");
                return;
            }
            else if (player1Wins && player2Wins){
                System.out.println("Wow, that's a draw!");
                return;
            }

            //Egy egység hova mehet
            ArrayList<Point> possibleMovesList = new ArrayList<>();
            ArrayList<Point> possibleAttackFieldsList = new ArrayList<>();
            allUnits.get(i).possibleMoves(battlefield, possibleMovesList, possibleAttackFieldsList, allUnits.get(i).getPosition(), allUnits.get(i).getSpeed());

            Set<Point> set = new HashSet<>(possibleMovesList);
            possibleMovesList.clear();
            possibleMovesList.addAll(set);
            possibleMovesList.remove(allUnits.get(i).getPosition());

            /*for (Point point : possibleMovesList) {
                System.out.println((char)(point.x + 'A') + " " + point.y);
            }*/

            drawTheBattleFieldForBattle(battlefield, possibleUnits, possibleMovesList, allUnits);

            System.out.println(allUnits.get(i).getName());

            if (i == allUnits.size() - 1){
                i = -1;
            }

            scanner.nextLine();
        }
    }

    private static void printSpells(Hero player1) {
        System.out.println("Your spells:");
        for (Spell spell:player1.getSpells()) {
            System.out.println(spell + "\n");
        }
        System.out.println();
    }

    private static void buySpells(Hero player1, Hero player2, Scanner scanner) {
        Fireball fireball = new Fireball();
        LightningBolt lightningBolt = new LightningBolt();
        CircleofWinter circleofWinter = new CircleofWinter();
        Resurrection resurrection = new Resurrection();
        Teleport teleport = new Teleport();
        ArrayList<Spell> spells = new ArrayList<>();
        spells.add(fireball);
        spells.add(lightningBolt);
        spells.add(circleofWinter);
        spells.add(resurrection);
        spells.add(teleport);
        //Ellenfél varázslatai
        player2.addSpell(lightningBolt);
        player2.addSpell(fireball);
        player2.addSpell(resurrection);
        player2.addSpell(circleofWinter);
        while(true){
            switch (scanner.nextLine().toUpperCase()){
                case "Y","YES":
                    while (true){
                        if (player1.getGold() < 5){
                            System.out.println("You have not enough gold to buy spells! \n" +
                                    "Now you will go to the army making section!");
                            return;
                        }

                        System.out.println("Which spell do you want to buy?");
                        for (Spell spell:spells) {
                            //System.out.println(spell.getName() + " (" + spell.getName().charAt(0) + ") ");
                            System.out.println(spell + "\n(" + spell.getName().charAt(0) + ")\n");
                        }
                        System.out.println("Nothing (N)");

                        Scanner spellScanner = new Scanner(System.in);
                        String scannedSpell = spellScanner.nextLine().toUpperCase();
                        boolean rightValue = false;
                        for (int i = 0; i < spells.size(); i++) {
                            if (spells.get(i).getName().toUpperCase().equals(scannedSpell) || (scannedSpell.length() == 1 && spells.get(i).getName().toUpperCase().charAt(0) == scannedSpell.charAt(0))){
                                player1.addSpell(spells.get(i));
                                player1.setGold(player1.getGold() - spells.get(i).getCost());
                                spells.remove(spells.get(i));
                                rightValue = true;

                                System.out.println("Bought spells: ");
                                for (Spell spell:player1.getSpells()) {
                                    System.out.print(spell.getName() + "\n");
                                }
                                System.out.println("Remaining gold: " + player1.getGold());

                                break;
                            }
                        }
                        if (scannedSpell.equals("N") || scannedSpell.equals("NOTHING")){
                            System.out.println("Now you will go to the army making section!");
                            return;
                        }else if (!rightValue){
                            typoMessage();
                        }
                    }
                case "N","NO":
                    System.out.println("Now you will go to the army making section!");
                    return;
                default:
                    typoMessage();
            }
        }
    }

    private static void placeTheUnits(Unit[][] battlefield, ArrayList<Unit> unitList, Scanner scanner) {
        int i = 0;
        while (i < unitList.size()){
            System.out.println("Where would you like to place your " + unitList.get(i).getName() + "? (A0-B9)");
            System.out.println("Note: only the first two characters will count.");
            String stringCoordinate = scanner.nextLine().toUpperCase();
            Point coordinate = new Point(0,0);
            coordinate.x = stringCoordinate.charAt(0) - 'A';
            coordinate.y = stringCoordinate.charAt(1) - '0';

            if (!(0 <= coordinate.x && coordinate.x <= 1 && 0 <= coordinate.y && coordinate.y <= 9)){
                typoMessage();
            }
            else{
                if (battlefield[coordinate.x][coordinate.y] == null){
                    battlefield[coordinate.x][coordinate.y] = unitList.get(i);
                    unitList.get(i).setPosition(new Point(coordinate.x, coordinate.y));
                    i++;
                }
                else{
                    occupiedFieldMessage();
                }
            }
            drawTheBattleField(battlefield, unitList);
        }
    }

    private static void drawTheBattleFieldForBattle(Unit[][] battlefield, ArrayList<Unit> possibleUnits, ArrayList<Point> possibleMovesList, ArrayList<Unit> allUnits) {
        int n = 12;
        int m = 10;
        String row1 = "—————";
        String row2 = "|   |";

        //System.out.print(row1);
        for (int i = 0; i < n + 1; i++) {
            System.out.print(row1);
        }
        System.out.println();
        System.out.print(row2);
        for (int i = 0; i < n; i++) {
            System.out.print("| " + ((char)((int)('A') + i)) + " |");
        }
        System.out.println();

        for (int i = 0; i < m; i++) {
            System.out.print(row1);
            for (int j = 0; j < n; j++) {
                System.out.print(row1);
            }
            System.out.println();

            System.out.print("| " + i + " |");
            for (int j = 0; j < n; j++) {
                Point currentCoordinate = new Point(j, i);
                if (possibleMovesList.contains(currentCoordinate)){
                    System.out.print("| " + (ConsoleFormatters.ConsoleFormatting.GREEN + "x" + ConsoleFormatters.ConsoleFormatting.RESET) + " |");
                } else {
                    String s;
                    if (battlefield[j][i] == null){
                        s = " ";
                    } else {
                        if (battlefield[j][i].getTeam() == 1){
                            s = ConsoleFormatters.ConsoleFormatting.BLUE + battlefield[j][i].getName().charAt(0) + ConsoleFormatters.ConsoleFormatting.RESET;
                        } else {
                            s = ConsoleFormatters.ConsoleFormatting.RED + battlefield[j][i].getName().charAt(0) + ConsoleFormatters.ConsoleFormatting.RESET;
                        }
                        ///battlefield[j][i].setPosition(new Point(j, i));
                    }
                    System.out.print("| " + s + " |");
                }
            }

            //Oldalra kiírja az egységek neveit és rövidítéseit
            if (i < possibleUnits.size()){
                System.out.print("   " + possibleUnits.get(i).getName().charAt(0) + " — " + possibleUnits.get(i).getName());
            }

            System.out.println();
        }

        for (int i = 0; i < n + 1; i++) {
            System.out.print(row1);
        }
        System.out.println();
    }

    private static void drawTheBattleField(Unit[][] battlefield, ArrayList<Unit> possibleUnits) {
        int n = 12;
        int m = 10;
        String row1 = "—————";
        String row2 = "|   |";

        //System.out.print(row1);
        for (int i = 0; i < n + 1; i++) {
            System.out.print(row1);
        }
        System.out.println();
        System.out.print(row2);
        for (int i = 0; i < n; i++) {
            System.out.print("| " + ((char)((int)('A') + i)) + " |");
        }
        System.out.println();

        for (int i = 0; i < m; i++) {
            System.out.print(row1);
            for (int j = 0; j < n; j++) {
                System.out.print(row1);
            }
            System.out.println();

            System.out.print("| " + i + " |");
            for (int j = 0; j < n; j++) {
                char c;
                if (battlefield[j][i] == null || battlefield[j][i].getTeam() == 2){
                    c = ' ';
                }
                else{
                    c = battlefield[j][i].getName().charAt(0);
                }
                System.out.print("| " + (ConsoleFormatters.ConsoleFormatting.BLUE + c + ConsoleFormatters.ConsoleFormatting.RESET) + " |");
            }

            if (i < possibleUnits.size()){
                System.out.print("   " + possibleUnits.get(i).getName().charAt(0) + " — " + possibleUnits.get(i).getName());
            }

            System.out.println();
        }

        for (int i = 0; i < n + 1; i++) {
            System.out.print(row1);
        }
        System.out.println();
    }

    private static void occupiedFieldMessage() {
        System.err.println("This field is occupied, type another field!");
    }

    private static void buyUnits(ArrayList<Unit> unitList, Hero player1, Scanner scanner) {
        while (true){
            if (player1.getGold() < 2){
                System.out.println("You have spent all of your gold!");
                System.out.println("It's time to go to the battlefield!");
                return;
            }

            System.out.println("Your army:");
            for (Unit unit:unitList) {
                System.out.println(unit.getName() + ": " + unit.getUnitCount());
            }
            System.out.println();

            System.out.println("What unit do you want to buy?");
            System.out.println("Note: You will always buy the maximum possible amount!");
            System.out.println("Peasant (P), Marksman (M), Footman (F), Griffin (G)");
            System.out.println("Inquisitor (I), Cavalier (C), Seraph (S), Nothing (N)");
            System.out.println("Remaining gold: " + player1.getGold());

            int i = -1;
            boolean ok = false;
            while (!ok){
                String s = scanner.nextLine().toUpperCase();
                i = -1;
                switch (s) {
                    case "P", "PEASANT":
                        for (int j = 0; j < unitList.size(); j++) {
                            if (unitList.get(j).getName().equals("Peasant")){
                                i = j;
                                ok = true;
                                break;
                            }
                        }
                        break;
                    case "M", "MARKSMAN":
                        for (int j = 0; j < unitList.size(); j++) {
                            if (unitList.get(j).getName().equals("Marksman")){
                                i = j;
                                ok = true;
                                break;
                            }
                        }
                        break;
                    case "F", "FOOTMAN":
                        for (int j = 0; j < unitList.size(); j++) {
                            if (unitList.get(j).getName().equals("Footman")){
                                i = j;
                                ok = true;
                                break;
                            }
                        }
                        break;
                    case "G", "GRIFFIN":
                        for (int j = 0; j < unitList.size(); j++) {
                            if (unitList.get(j).getName().equals("Griffin")){
                                i = j;
                                ok = true;
                                break;
                            }
                        }
                        break;
                    case "I", "INQUISITOR":
                        for (int j = 0; j < unitList.size(); j++) {
                            if (unitList.get(j).getName().equals("Inquisitor")){
                                i = j;
                                ok = true;
                                break;
                            }
                        }
                        break;
                    case "C", "CAVALIER":
                        for (int j = 0; j < unitList.size(); j++) {
                            if (unitList.get(j).getName().equals("Cavalier")){
                                i = j;
                                ok = true;
                                break;
                            }
                        }
                        break;
                    case "S", "SERAPH":
                        for (int j = 0; j < unitList.size(); j++) {
                            if (unitList.get(j).getName().equals("Seraph")){
                                i = j;
                                ok = true;
                                break;
                            }
                        }
                        break;
                    case "N", "NOTHING":
                        i = -1;

                        int sum = 0;
                        for (Unit unit : unitList) {
                            sum += unit.getUnitCount();
                        }
                        if (sum == 0){
                            System.err.println("You must buy at least one unit!");
                        }
                        else{
                            ok = true;
                        }
                        break;
                    default:
                        i = -1;
                        typoMessage();
                        //scanner.next(); // Rossz inputnál scanner clear
                        break;
                }
            }

            if (i != -1){
                System.out.println("How many " + unitList.get(i).getName() + "(s) do you want to buy? /NUMBER/");
                int unitsAmount;
                Scanner unitAmountScanner = new Scanner(System.in);
                while (true){
                    try {
                        unitsAmount = unitAmountScanner.nextInt();
                        if (unitsAmount < 0){
                            wrongNumberMessage();
                        }
                        else{
                            break;
                        }
                    }
                    catch (Exception e){
                        System.err.println("That's not a number! Try again!");
                        unitAmountScanner.next(); // Rossz inputnál scanner clear
                    }
                }

                unitsAmount = Math.min(unitsAmount, player1.getGold() / unitList.get(i).getCost());
                unitList.get(i).setUnitCount(unitList.get(i).getUnitCount() + unitsAmount);
                player1.setGold(player1.getGold() - unitsAmount * unitList.get(i).getCost());
                System.out.println("You have bought " + unitsAmount + " " + unitList.get(i).getName() + "(s)");
            }
            else{
                System.out.println("It's time to go to the battlefield!");
                return;
            }
        }
    }

    private static void buyHeroAttributePoints(Hero player1, Scanner scanner) {
        int currentAttributeCost = 5;

        while(true){
            switch (scanner.nextLine().toUpperCase()){
                case "Y","YES":
                    while (true){
                        if (player1.getGold() - currentAttributeCost < 5){
                            System.out.println("You have not enough gold to buy attributes! \n" +
                                    "Now you will go to the spell buying section!");
                            return;
                        }

                        System.out.println("The next point will cost " + currentAttributeCost + " gold");
                        System.out.println("What attribute point you want to buy?");
                        System.out.println("Attack (A), Defense (D), Spell Power (S)\n" +
                                "Knowledge (K), Morale (M), Luck (L), Nothing (N)");

                        Scanner attributeScanner = new Scanner(System.in);
                        String attribute = attributeScanner.nextLine();
                        switch (attribute.toUpperCase()) {
                            case "A", "ATTACK" -> {
                                if (player1.getAttack() > 9) {
                                    System.out.println("You cant't buy more of this! You have reached 10 points");
                                    continue;
                                }
                                player1.setAttack(player1.getAttack() + 1);
                                player1.setGold(player1.getGold() - currentAttributeCost);
                                currentAttributeCost = (int) Math.ceil(currentAttributeCost * 1.1d);
                                printHeroWithGoldAmountText(player1);
                            }
                            case "D", "DEFENSE" -> {
                                if (player1.getDefense() > 9) {
                                    System.out.println("You cant't buy more of this! You have reached 10 points");
                                    continue;
                                }
                                player1.setDefense(player1.getDefense() + 1);
                                player1.setGold(player1.getGold() - currentAttributeCost);
                                currentAttributeCost = (int) Math.ceil(currentAttributeCost * 1.1d);
                                printHeroWithGoldAmountText(player1);
                            }
                            case "S", "SPELLPOWER", "SPELL POWER" -> {
                                if (player1.getSpellPower() > 9) {
                                    System.out.println("You cant't buy more of this! You have reached 10 points");
                                    continue;
                                }
                                player1.setSpellPower(player1.getSpellPower() + 1);
                                player1.setGold(player1.getGold() - currentAttributeCost);
                                currentAttributeCost = (int) Math.ceil(currentAttributeCost * 1.1d);
                                printHeroWithGoldAmountText(player1);
                            }
                            case "K", "KNOWLEDGE" -> {
                                if (player1.getKnowledge() > 9) {
                                    System.out.println("You cant't buy more of this! You have reached 10 points");
                                    continue;
                                }
                                player1.setKnowledge(player1.getKnowledge() + 1);
                                player1.setGold(player1.getGold() - currentAttributeCost);
                                currentAttributeCost = (int) Math.ceil(currentAttributeCost * 1.1d);
                                printHeroWithGoldAmountText(player1);
                            }
                            case "M", "MORALE" -> {
                                if (player1.getMorale() > 9) {
                                    System.out.println("You cant't buy more of this! You have reached 10 points");
                                    continue;
                                }
                                player1.setMorale(player1.getMorale() + 1);
                                player1.setGold(player1.getGold() - currentAttributeCost);
                                currentAttributeCost = (int) Math.ceil(currentAttributeCost * 1.1d);
                                printHeroWithGoldAmountText(player1);
                            }
                            case "L", "LUCK" -> {
                                if (player1.getLuck() > 9) {
                                    System.out.println("You cant't buy more of this! You have reached 10 points");
                                    continue;
                                }
                                player1.setLuck(player1.getLuck() + 1);
                                player1.setGold(player1.getGold() - currentAttributeCost);
                                currentAttributeCost = (int) Math.ceil(currentAttributeCost * 1.1d);
                                printHeroWithGoldAmountText(player1);
                            }
                            case "N", "NOTHING" -> {
                                System.out.println("Now you will go to the spell buying section!");
                                return;
                            }
                            default -> typoMessage();
                        }
                    }
                case "N","NO":
                    System.out.println("Now you will go to the spell buying section!");
                    return;
                default:
                    typoMessage();
            }
        }
    }

    private static Hero setDifficulty(Hero player1, Scanner scanner) {
        while (true){
            String difficulty = scanner.nextLine();
            switch (difficulty.toUpperCase()) {
                case "E", "EASY" -> {
                    System.out.println("Easy difficulty");
                    player1 = new Hero(1300 * 2, 1);
                    return player1;
                }
                case "M", "MEDIUM" -> {
                    System.out.println("Medium difficulty");
                    player1 = new Hero(1000 * 2, 1);
                    return player1;
                }
                case "H", "HARD" -> {
                    System.out.println("Hard difficulty");
                    player1 = new Hero(700 * 2, 1);
                    return player1;
                }
                default -> typoMessage();
            }
        }
    }

    static void typoMessage(){
        System.err.println("There must be a typo, try again!");
    }

    static void wrongNumberMessage(){
        System.err.println("Unfortunately that won't work with that number, try again!");
    }

    static void printHeroWithGoldAmountText(Hero player1){
        System.out.println("The hero's current attributes:\n" + player1 + "\n");
    }
}