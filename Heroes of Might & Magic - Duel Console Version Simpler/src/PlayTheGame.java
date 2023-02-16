import ConsoleFormatters.ConsoleFormatting;
import Parent_Classes.*;
import Spells.*;
import Units.*;

import java.awt.*;
import java.util.*;

public class PlayTheGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%100s", ConsoleFormatters.ConsoleFormatting.BLUE_BRIGHT + "Welcome to the Heroes of Might & Magic - Duel version!\n" + ConsoleFormatters.ConsoleFormatting.RESET);
        System.out.printf("%110s", ConsoleFormatters.ConsoleFormatting.BLUE_BRIGHT +  "Before you can begin playing the actual game, please choose a difficulty!\n" + ConsoleFormatters.ConsoleFormatting.RESET);
        System.out.printf("%100s", ConsoleFormatters.ConsoleFormatting.RED_UNDERLINED +  "Note: For the rest of the game, you can control everything by writing the right word or character shown " +
                "in the corresponding bracket!\n" + ConsoleFormatters.ConsoleFormatting.RESET);
        System.out.printf("%98s", ConsoleFormatters.ConsoleFormatting.RED_UNDERLINED +  "You can write everything with lowercase characters.\n" + ConsoleFormatters.ConsoleFormatting.RESET);
        System.out.println();

        System.out.printf("%64s", ConsoleFormatters.ConsoleFormatting.GREEN_BOLD_BRIGHT + "Easy (E)" + ConsoleFormatters.ConsoleFormatting.RESET);
        System.out.printf("%22s", ConsoleFormatters.ConsoleFormatting.YELLOW_BOLD_BRIGHT + "Medium (M)" + ConsoleFormatters.ConsoleFormatting.RESET);
        System.out.printf("%20s", ConsoleFormatters.ConsoleFormatting.RED_BOLD_BRIGHT + "Hard (H)" + ConsoleFormatters.ConsoleFormatting.RESET);
        System.out.println("\n");

        Hero player1 = new Hero(0, 1);
        Hero player2 = new Hero(0, 2);

        //Nehézség kiválasztása
        player1 = setDifficulty(player1, scanner);

        printHeroWithGoldAmountText(player1);

        System.out.println("Now you are able to spend gold on your hero's attributes only if you want to. Yes (Y) or No (N)");
        System.out.println("Note: all of the attributes are capped at 10 points");

        //Hős képességpontjainak vásárlása
        buyHeroAttributePoints(player1, scanner);

        //Ellenfél képességeine kiosztása
        int points = 6;
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

        printHeroWithGoldAmountText(player1);

        //Varázslatok vásárlása
        System.out.println("Do you want to buy spells? Yes (Y) or No (N)");
        buySpells(player1, player2, scanner);

        //Ellenfél egységei
        {
            /*
            Peasant peasant = new Peasant(2);
            peasant.setInitialUnitCount(4);
            Marksman marksman = new Marksman(2);
            marksman.setInitialUnitCount(12);
            Footman footman = new Footman(2);
            footman.setInitialUnitCount(10);
            Griffin griffin = new Griffin(2);
            griffin.setInitialUnitCount(6);
            Inquisitor inquisitor = new Inquisitor(2);
            inquisitor.setInitialUnitCount(4);
            Cavalier cavalier = new Cavalier(2);
            cavalier.setInitialUnitCount(2);
            Seraph seraph = new Seraph(2);
            seraph.setInitialUnitCount(1);
            player2.addUnit(peasant);
            player2.addUnit(marksman);
            player2.addUnit(footman);
            player2.addUnit(griffin);
            player2.addUnit(inquisitor);
            player2.addUnit(cavalier);
            player2.addUnit(seraph);
             */


            Marksman marksman = new Marksman(2);
            marksman.setInitialUnitCount(2);
            Griffin griffin = new Griffin(2);
            griffin.setInitialUnitCount(10);
            Seraph seraph = new Seraph(2);
            seraph.setInitialUnitCount(1);
            player2.addUnit(marksman);
            player2.addUnit(griffin);
            player2.addUnit(seraph);
        }

        //Egységek vásárlása
        System.out.println("Press Enter to continue!");
        scanner.nextLine();

        System.out.println("You can choose from the following units:\n");
        ArrayList<Unit> unitList = new ArrayList<>();
        Peasant peasant = new Peasant(1);
        Marksman marksman = new Marksman(1);
        Footman footman = new Footman(1);
        Griffin griffin = new Griffin(1);
        Inquisitor inquisitor = new Inquisitor(1);
        Cavalier cavalier = new Cavalier(1);
        Seraph seraph = new Seraph(1);

        unitList.add(peasant);
        unitList.add(marksman);
        unitList.add(footman);
        unitList.add(griffin);
        unitList.add(inquisitor);
        unitList.add(cavalier);
        unitList.add(seraph);

        for (Unit unit:unitList) {
            System.out.println(unit + "\n");
        }

        printHeroWithGoldAmountText(player1);
        printSpells(player1);

        buyUnits(unitList, player1, scanner);
        for (Unit unit:unitList) {
            System.out.println(unit.getName() + ": " + unit.getUnitCount());
        }
        System.out.println();

        printHeroWithGoldAmountText(player1);

        System.out.println("Your army:");
        unitList.removeIf(unit -> unit.getUnitCount() == 0);
        for (Unit unit:unitList) {
            player1.addUnit(unit);
        }

        for (Unit unit:player1.getUnits()) {
            System.out.println(unit.getName() + ": " + unit.getUnitCount());
        }
        System.out.println();

        Peasant peasant3 = new Peasant(1);
        Marksman marksman3 = new Marksman(1);
        Footman footman3 = new Footman(1);
        Griffin griffin3 = new Griffin(1);
        Inquisitor inquisitor3 = new Inquisitor(1);
        Cavalier cavalier3 = new Cavalier(1);
        Seraph seraph3 = new Seraph(1);
        ArrayList<Unit> possibleUnits = new ArrayList<>();
        possibleUnits.add(peasant3);
        possibleUnits.add(marksman3);
        possibleUnits.add(footman3);
        possibleUnits.add(griffin3);
        possibleUnits.add(inquisitor3);
        possibleUnits.add(cavalier3);
        possibleUnits.add(seraph3);



        //Egységek buffolása a hős alapján
        for (Unit unit:player1.getUnits()) {
            unit.setInitiative(unit.getInitiative() + player1.getMorale());
        }
        for (Unit unit:player2.getUnits()) {
            unit.setInitiative(unit.getInitiative() + player2.getMorale());
        }
        //Támadás, mega többi is kell majd még -> azok majd combat közben
        player1.setMana(10 * player1.getKnowledge());

        player2.setMana(10 * player1.getKnowledge());
        ArrayList<Unit> allUnits = new ArrayList<>();
        allUnits.addAll(player1.getUnits());
        allUnits.addAll(player2.getUnits());

        Unit[][] battlefield = new Unit[12][10];
        Collections.sort(allUnits, new UnitComparator());
        Collections.sort(player1.getSpells(), new SpellComparator());
        drawTheBattleField(battlefield, possibleUnits);
        placeTheUnits(battlefield, player1.getUnits(), scanner);
        placeEnemyUnits(battlefield, player2.getUnits());
        System.out.println("The enemy army:");
        player2.printUnitNamesAndQuantity();
        System.out.println("Enemy spells:");
        player2.printSpellNames();
        System.out.println("Enemy attributes");
        System.out.println(player2);



        battle(battlefield, player1, player2, scanner, allUnits, possibleUnits);


        /*System.out.print(ConsoleFormatters.ConsoleFormatting.CLEAR_CONSOLE); //Nem akar működni
        System.out.flush();*/

        /*System.out.println(ConsoleFormatters.ConsoleFormatting.GREEN_BACKGROUND + "This text has a green background but default text!" + ConsoleFormatters.ConsoleFormatting.RESET);
        System.out.println(ConsoleFormatters.ConsoleFormatting.RED + "This text has red text but a default background!" + ConsoleFormatters.ConsoleFormatting.RESET);
        System.out.println(ConsoleFormatters.ConsoleFormatting.RED + ConsoleFormatters.ConsoleFormatting.GREEN_BACKGROUND +
                "This text has a green background and red text!" + ConsoleFormatters.ConsoleFormatting.RESET);*/ //Előbb kell a háttér


    }

    private static void battle(Unit[][] battlefield, Hero player1, Hero player2, Scanner scanner, ArrayList<Unit> allUnits, ArrayList<Unit> possibleUnits) {
        System.out.println("Press Enter to continue");
        scanner.nextLine();
        System.out.println("Unit order:");
        for (Unit unit : allUnits) {
            if (!unit.isFallen()) {
                System.out.print((unit.getTeam() == 1? ConsoleFormatting.BLUE : ConsoleFormatting.RED) + unit.getName() + ConsoleFormatting.RESET + " ");
            }
        }
        System.out.println();
        System.out.println("Good luck!\n");
        boolean player1Wins = false;
        boolean player2Wins = false;
        int round = 1;
        for (int i = 0; !(player1Wins || player2Wins); i++) {
            //Megnézni, hogy nyert-e már valaki
            boolean player1HasUnit = false;
            boolean player2HasUnit = false;

            for (Unit unit:allUnits) {
                if (unit.getTeam() == 1 && !unit.isFallen()){
                    player1HasUnit = true;
                } else if (unit.getTeam() == 2 && !unit.isFallen()){
                    player2HasUnit = true;
                }
            }

            player1Wins = !player2HasUnit;
            player2Wins = !player1HasUnit;

            if (player1Wins && !player2Wins){
                drawTheBattleFieldForBattle(battlefield, possibleUnits, new ArrayList<>(), allUnits, new ArrayList<>(), allUnits.get(i));
                System.out.println("Congratulations! You won!");
                return;
            } else if (!player1Wins && player2Wins){
                drawTheBattleFieldForBattle(battlefield, possibleUnits, new ArrayList<>(), allUnits, new ArrayList<>(), allUnits.get(i));
                System.out.println("You lost the battle!");
                return;
            } else if (player1Wins && player2Wins){
                drawTheBattleFieldForBattle(battlefield, possibleUnits, new ArrayList<>(), allUnits, new ArrayList<>(), allUnits.get(i));
                System.out.println("Wow, that's a draw!");
                return;
            }

            if (i == 0){
                System.out.println("Round " + round);
                player1.setCastedASpell(false);
            }

            //Egy egység hova mehet
            ArrayList<Point> possibleMovesList = new ArrayList<>();
            ArrayList<Point> possibleAttackFieldsList = new ArrayList<>();
            allUnits.get(i).possibleMoves(battlefield, possibleMovesList, possibleAttackFieldsList, allUnits.get(i).getPosition(), allUnits.get(i).getSpeed());

            Set<Point> set = new HashSet<>(possibleMovesList);
            possibleMovesList.clear();
            possibleMovesList.addAll(set);
            possibleMovesList.remove(allUnits.get(i).getPosition());
            set = new HashSet<>(possibleAttackFieldsList);
            possibleAttackFieldsList.clear();
            possibleAttackFieldsList.addAll(set);

            /*for (Point point : possibleMovesList) {
                System.out.println((char)(point.x + 'A') + " " + point.y);
            }*/

            if (!allUnits.get(i).isFallen()){

                drawTheBattleFieldForBattle(battlefield, possibleUnits, possibleMovesList, allUnits, possibleAttackFieldsList, allUnits.get(i));

                if (allUnits.get(i).getTeam() == 1){
                    System.out.println(ConsoleFormatting.BLUE + allUnits.get(i).getName() + ConsoleFormatting.RESET + "'s action");

                    //Támadni szeretne-e a hős
                    if (!player1.isAttacked() && !player1.isCastedASpell()) {
                        System.out.println("Would you like to attack with your hero? Yes (Y) or No (N)");
                        Scanner attackScanner = new Scanner(System.in);
                        while (true) {
                            boolean isDone = false;
                            switch (attackScanner.nextLine().toUpperCase()) {
                                case "YES", "Y" -> {
                                    player1.setAttacked(true);
                                    Set<Unit> attackableEnemies = new HashSet<>();
                                    for (int k = 0; k <= 11; k++) {
                                        for (int j = 0; j <= 9; j++) {
                                            if (battlefield[k][j] != null && battlefield[k][j].getTeam() != allUnits.get(i).getTeam() && !battlefield[k][j].isFallen()) {
                                                attackableEnemies.add(battlefield[k][j]);
                                            }
                                        }
                                    }
                                    System.out.println("Which enemy you want to attack?");
                                    Scanner attackedUnitScanner = new Scanner(System.in);
                                    boolean rightValue = false;
                                    while (true) {
                                        String scannedUnit = attackedUnitScanner.nextLine().toUpperCase();
                                        for (Unit unit : attackableEnemies) {
                                            if ((unit.getName().toUpperCase().equals(scannedUnit) || (scannedUnit.length() == 1 && unit.getName().toUpperCase().charAt(0) == scannedUnit.charAt(0)))) {
                                                unit.takeDamage(player1.getAttack() * 10);
                                                rightValue = true;
                                            }
                                        }
                                        if (!rightValue) {
                                            typoMessage();
                                        } else {
                                            break;
                                        }
                                    }
                                    isDone = true;
                                }
                                case "NO", "N" -> isDone = true;
                                default -> typoMessage();
                            }
                            if (isDone) {
                                break;
                            }
                        }
                    }

                    //Varázsolni akar-e a játékos
                    if (!player1.isAttacked() && !player1.isCastedASpell()) {
                        if (!player1.isCastedASpell() && player1.getSpells().size() > 0 && player1.getMana() >= player1.getSpells().get(0).getMana()){
                            boolean isSpellCastDone = false;
                            do {
                                System.out.println("Would you like to use a spell? Yes (Y) or No (N)");
                                Scanner spellScanner = new Scanner(System.in);
                                switch (spellScanner.nextLine().toUpperCase()) {
                                    case "YES", "Y" -> {
                                        System.out.println("Write the name or the first letter of the spell you want to use!");
                                        System.out.println("Your spells that you can cast with your current mana:");
                                        for (Spell spell : player1.getSpells()) {
                                            if (player1.getMana() >= spell.getMana()) {
                                                System.out.print(spell.getName() + " (" + spell.getName().charAt(0) + ") ");
                                            }
                                        }
                                        System.out.println();

                                        player1.setCastedASpell(true);

                                        while (true) {
                                            String wantedSpell = spellScanner.nextLine().toUpperCase();
                                            boolean isDone = false;
                                            for (Spell spell : player1.getSpells()) {
                                                if ((player1.getMana() >= spell.getMana()) && ((wantedSpell.length() == 1 && spell.getName().charAt(0) == wantedSpell.charAt(0)) || wantedSpell.equalsIgnoreCase(spell.getName()))) {
                                                    player1.setMana(player1.getMana() - spell.getMana());
                                                    System.out.println("Current mana: " + player1.getMana());
                                                    switch (spell.getName()) {
                                                        case "Lightning Bolt":
                                                            while (true) {
                                                                System.out.println("Which enemy you want to strike with Lightning Bolt?");
                                                                Scanner unitScanner = new Scanner(System.in);
                                                                String wantedUnit = unitScanner.nextLine().toUpperCase();
                                                                boolean isDone1 = false;
                                                                for (Unit unit : player2.getUnits()) {
                                                                    if (!unit.isFallen() && (wantedUnit.length() == 1 && unit.getName().charAt(0) == wantedUnit.charAt(0)) || wantedUnit.equalsIgnoreCase(unit.getName())) {
                                                                        //System.out.println("Player 2 unit before:" + unit.getUnitCount() + " " + unit.getRemainingHealth() + "\n");
                                                                        //System.out.println("Battlefield unit before:" + battlefield[unit.getPosition().x][unit.getPosition().y].getUnitCount() + " " + battlefield[unit.getPosition().x][unit.getPosition().y].getRemainingHealth() + "\n");

                                                                        spell.castToUnit(player1, unit);

                                                                        //System.out.println("Player 2 unit after:" + unit.getUnitCount() + " " + unit.getRemainingHealth() + "\n");
                                                                        //System.out.println("Battlefield unit after:" + battlefield[unit.getPosition().x][unit.getPosition().y].getUnitCount() + " " + battlefield[unit.getPosition().x][unit.getPosition().y].getRemainingHealth() + "\n");

                                                                        isDone1 = true;
                                                                    }
                                                                }
                                                                if (isDone1) {
                                                                    break;
                                                                } else {
                                                                    typoMessage();
                                                                }
                                                            }
                                                            break;
                                                        case "Fireball":
                                                        case "Circle of Winter":
                                                            while (true) {
                                                                System.out.println("Where should the centre of the spell be? (A0-L9)");
                                                                System.out.println("Note: only the first two characters will count.");
                                                                Scanner fieldScanner = new Scanner(System.in);
                                                                String wantedField = fieldScanner.nextLine().toUpperCase();

                                                                //Legalább 2 hosszú-e a string
                                                                if (wantedField.length() < 2) {
                                                                    typoMessage();
                                                                    continue;
                                                                }

                                                                Point coordinate = new Point(0, 0);
                                                                coordinate.x = wantedField.charAt(1) - '0';
                                                                coordinate.y = wantedField.charAt(0) - 'A';

                                                                if (!(0 <= coordinate.x && coordinate.x <= 9 && 0 <= coordinate.y && coordinate.y <= 11)) {
                                                                    typoMessage();
                                                                    //continue;
                                                                } else {
                                                                    spell.castToField(battlefield, player1, coordinate);
                                                                    break;
                                                                }
                                                            }
                                                            break;
                                                        case "Resurrection":
                                                            while (true) {
                                                                System.out.println("Which friendly unit you want to resurrect?");
                                                                Scanner unitScanner = new Scanner(System.in);
                                                                String wantedUnit = unitScanner.nextLine().toUpperCase();
                                                                boolean isDone1 = false;
                                                                for (Unit unit : player1.getUnits()) {
                                                                    if ((wantedUnit.length() == 1 && unit.getName().charAt(0) == wantedUnit.charAt(0)) || wantedUnit.equalsIgnoreCase(unit.getName())) {
                                                                        if (battlefield[unit.getPosition().x][unit.getPosition().y] == unit) {

                                                                            //System.out.println("Player 2 unit before:" + unit.getUnitCount() + " " + unit.getRemainingHealth() + "\n");
                                                                            //System.out.println("Battlefield unit before:" + battlefield[unit.getPosition().x][unit.getPosition().y].getUnitCount() + " " + battlefield[unit.getPosition().x][unit.getPosition().y].getRemainingHealth() + "\n");

                                                                            spell.castToUnit(player1, unit);

                                                                            //System.out.println("Player 2 unit after:" + unit.getUnitCount() + " " + unit.getRemainingHealth() + "\n");
                                                                            //System.out.println("Battlefield unit after:" + battlefield[unit.getPosition().x][unit.getPosition().y].getUnitCount() + " " + battlefield[unit.getPosition().x][unit.getPosition().y].getRemainingHealth() + "\n");
                                                                            isDone1 = true;
                                                                        } else {
                                                                            System.out.println("You can't resurrect that unit!");
                                                                        }
                                                                    }
                                                                }
                                                                if (isDone1) {
                                                                    break;
                                                                } else {
                                                                    typoMessage();
                                                                }
                                                            }
                                                            break;
                                                        case "Teleport":
                                                            while (true) {
                                                                System.out.println("From where you want to teleport a unit?");
                                                                System.out.println("Note: only the first two characters will count.");
                                                                Scanner fieldScannerFrom = new Scanner(System.in);
                                                                String wantedFieldFrom = fieldScannerFrom.nextLine().toUpperCase();

                                                                //Legalább 2 hosszú-e a string
                                                                if (wantedFieldFrom.length() < 2) {
                                                                    typoMessage();
                                                                    continue;
                                                                }

                                                                //Erre hiábt ad
                                                                //System.out.println(battlefield[9][11]);

                                                                //Erre nem
                                                                //System.out.println(battlefield[11][9]);

                                                                Point coordinateFrom = new Point(0, 0);
                                                                coordinateFrom.x = wantedFieldFrom.charAt(1) - '0';
                                                                coordinateFrom.y = wantedFieldFrom.charAt(0) - 'A';

                                                                if (!(0 <= coordinateFrom.x && coordinateFrom.x <= 9 && 0 <= coordinateFrom.y && coordinateFrom.y <= 11)) {
                                                                    typoMessage();
                                                                    //continue;
                                                                } else if (battlefield[coordinateFrom.y][coordinateFrom.x] == null || battlefield[coordinateFrom.y][coordinateFrom.x].isFallen() || battlefield[coordinateFrom.y][coordinateFrom.x].getTeam() != 1) {
                                                                    System.err.println("There is no unit you can teleport!");
                                                                } else {
                                                                    while (true) {
                                                                        //System.err.println(battlefield[coordinateFrom.y][coordinateFrom.x].getName());
                                                                        System.out.println("To where you want to teleport a unit?");
                                                                        System.out.println("Note: only the first two characters will count.");
                                                                        Scanner fieldScannerTo = new Scanner(System.in);
                                                                        String wantedFieldTo = fieldScannerTo.nextLine().toUpperCase();

                                                                        //Legalább 2 hosszú-e a string
                                                                        if (wantedFieldTo.length() < 2) {
                                                                            typoMessage();
                                                                            continue;
                                                                        }

                                                                        Point coordinateTo = new Point(0, 0);
                                                                        coordinateTo.x = wantedFieldTo.charAt(1) - '0';
                                                                        coordinateTo.y = wantedFieldTo.charAt(0) - 'A';

                                                                        if (!(0 <= coordinateTo.x && coordinateTo.x <= 9 && 0 <= coordinateTo.y && coordinateTo.y <= 11)) {
                                                                            typoMessage();
                                                                            //continue;
                                                                        } else if (coordinateFrom.x == coordinateTo.x && coordinateFrom.y == coordinateTo.y) {
                                                                            System.err.println("That's where your unit is standing right now, wrong field!");
                                                                            //continue;
                                                                        } else if (!(battlefield[coordinateTo.y][coordinateTo.x] == null || battlefield[coordinateTo.y][coordinateTo.x].isFallen())) {
                                                                            System.err.println("There is a unit, wrong field!");
                                                                            //continue;
                                                                        } else {
                                                                            //System.out.println(battlefield[coordinateFrom.y][coordinateFrom.x].getName());
                                                                            //System.out.println(battlefield[coordinateFrom.y][coordinateFrom.x].getPosition());
                                                                            battlefield[coordinateFrom.y][coordinateFrom.x].move(battlefield, new Point(coordinateFrom.y, coordinateFrom.x), new Point(coordinateTo.y, coordinateTo.x));
                                                                            //System.out.println(battlefield[coordinateFrom.y][coordinateFrom.x].getPosition());
                                                                            //System.out.println(battlefield[coordinateFrom.y][coordinateFrom.x].getName());

                                                                            //System.err.println(battlefield[coordinateFrom.y][coordinateFrom.x]);
                                                                            //System.err.println(battlefield[coordinateTo.y][coordinateTo.x]);


                                                                            possibleMovesList.clear();
                                                                            possibleAttackFieldsList.clear();
                                                                            allUnits.get(i).possibleMoves(battlefield, possibleMovesList, possibleAttackFieldsList, allUnits.get(i).getPosition(), allUnits.get(i).getSpeed());

                                                                            set = new HashSet<>(possibleMovesList);
                                                                            possibleMovesList.clear();
                                                                            possibleMovesList.addAll(set);
                                                                            possibleMovesList.remove(allUnits.get(i).getPosition());
                                                                            set = new HashSet<>(possibleAttackFieldsList);
                                                                            possibleAttackFieldsList.clear();
                                                                            possibleAttackFieldsList.addAll(set);

                                                                            drawTheBattleFieldForBattle(battlefield, possibleUnits, possibleMovesList, allUnits, possibleAttackFieldsList, allUnits.get(i));
                                                                            break;
                                                                        }
                                                                    }
                                                                    break;
                                                                }
                                                            }
                                                            break;
                                                        default:
                                                            typoMessage();
                                                            break;
                                                    }
                                                    isDone = true;
                                                    break;
                                                }
                                            }
                                            if (isDone) {
                                                break;
                                            } else {
                                                typoMessage();
                                            }
                                        }
                                        isSpellCastDone = true;
                                    }
                                    case "NO", "N" -> isSpellCastDone = true;
                                    default -> typoMessage();
                                }
                            } while (!isSpellCastDone);
                        }
                    }

                    //Egységgel mit szeretnénk csinálni?
                    {
                        boolean didTakeAction = false;
                        do {
                            possibleMovesList.clear();
                            possibleAttackFieldsList.clear();
                            allUnits.get(i).possibleMoves(battlefield, possibleMovesList, possibleAttackFieldsList, allUnits.get(i).getPosition(), allUnits.get(i).getSpeed());

                            set = new HashSet<>(possibleMovesList);
                            possibleMovesList.clear();
                            possibleMovesList.addAll(set);
                            possibleMovesList.remove(allUnits.get(i).getPosition());
                            set = new HashSet<>(possibleAttackFieldsList);
                            possibleAttackFieldsList.clear();
                            possibleAttackFieldsList.addAll(set);

                            boolean canMove = false;
                            boolean canAttack = false;
                            String whatCanTheUnitDo = "";
                            if (!possibleMovesList.isEmpty()) {
                                whatCanTheUnitDo += "Move (M) ";
                                canMove = true;
                            }
                            if (!possibleAttackFieldsList.isEmpty()) {
                                whatCanTheUnitDo += "Attack (A) ";
                                canAttack = true;
                            }
                            if (allUnits.get(i).getClass().getSimpleName().equals("Marksman") || allUnits.get(i).getClass().getSimpleName().equals("Inquisitor")) {
                                boolean canShoot = true;
                                for (int k = Math.max(0, allUnits.get(i).getPosition().x - 1); k <= Math.min(allUnits.get(i).getPosition().x + 1, 11); k++) {
                                    for (int j = Math.max(0, allUnits.get(i).getPosition().y - 1); j <= Math.min(allUnits.get(i).getPosition().y + 1, 9); j++) {
                                        if (battlefield[k][j] != null && battlefield[k][j].getTeam() != allUnits.get(i).getTeam() && !battlefield[k][j].isFallen()) {
                                            canShoot = false;
                                            break;
                                        }
                                    }
                                }
                                if (canShoot) {
                                    whatCanTheUnitDo += "Ranged Attack (R) ";
                                }
                            }
                            if (allUnits.get(i).getClass().getSimpleName().equals("Seraph")) {
                                boolean canResurrect = false;
                                for (Unit[] units:battlefield) {
                                    for (Unit unit:units) {
                                        if (unit != null && unit.getTeam() == allUnits.get(i).getTeam() && unit != allUnits.get(i)) {
                                            canResurrect = true;
                                            break;
                                        }
                                    }
                                }
                                if (canResurrect) {
                                    whatCanTheUnitDo += "Bless Allies (B) ";
                                }
                            }
                            whatCanTheUnitDo += "Wait (W)";
                            System.out.println("What do you want to do with the " + ConsoleFormatting.BLUE + allUnits.get(i).getName() + ConsoleFormatting.RESET + " unit?");
                            System.out.println(whatCanTheUnitDo);
                            Scanner actionScanner = new Scanner(System.in);
                            switch (actionScanner.nextLine().toUpperCase()) {
                                case "MOVE", "M":
                                    if (canMove) {
                                        if (allUnits.get(i).getClass().getSimpleName().equals("Footman")) {
                                            Footman footman = (Footman) allUnits.get(i);
                                            footman.setWaitedLastTurn(false);
                                        }

                                        System.out.println("Where should the unit move? (A0-L9)");
                                        System.out.println("Note: only the first two characters will count.");
                                        while (true) {
                                            String wantedField = actionScanner.nextLine().toUpperCase();

                                            //Legalább 2 hosszú-e a string
                                            if (wantedField.length() < 2) {
                                                typoMessage();
                                                continue;
                                            }

                                            Point coordinate = new Point(0, 0);
                                            coordinate.x = wantedField.charAt(1) - '0';
                                            coordinate.y = wantedField.charAt(0) - 'A';

                                            if (!(0 <= coordinate.x && coordinate.x <= 9 && 0 <= coordinate.y && coordinate.y <= 11)) {
                                                typoMessage();
                                                continue;
                                            }

                                            if (coordinate.x == allUnits.get(i).getPosition().y && coordinate.y == allUnits.get(i).getPosition().x) {
                                                System.err.println("That's where your unit is standing right now, wrong field!");
                                                continue;
                                            }

                                            if (!(battlefield[coordinate.y][coordinate.x] == null || battlefield[coordinate.y][coordinate.x].isFallen())) {
                                                System.err.println("There is a unit, wrong field!");
                                                continue;
                                            }

                                            boolean rightCoordinate = false;
                                            for (Point point:possibleMovesList) {
                                                if (point.x == coordinate.y && point.y == coordinate.x) {
                                                    rightCoordinate = true;
                                                    break;
                                                }
                                            }
                                            //System.out.println(coordinate);

                                            if (!rightCoordinate) {
                                                typoMessage();
                                                continue;
                                            }

                                            allUnits.get(i).move(battlefield, allUnits.get(i).getPosition(), new Point(coordinate.y, coordinate.x));
                                            didTakeAction = true;

                                            possibleMovesList.clear();
                                            possibleAttackFieldsList.clear();
                                            allUnits.get(i).possibleMoves(battlefield, possibleMovesList, possibleAttackFieldsList, allUnits.get(i).getPosition(), allUnits.get(i).getSpeed());

                                            set = new HashSet<>(possibleMovesList);
                                            possibleMovesList.clear();
                                            possibleMovesList.addAll(set);
                                            possibleMovesList.remove(allUnits.get(i).getPosition());
                                            set = new HashSet<>(possibleAttackFieldsList);
                                            possibleAttackFieldsList.clear();
                                            possibleAttackFieldsList.addAll(set);

                                            drawTheBattleFieldForBattle(battlefield, possibleUnits, possibleMovesList, allUnits, possibleAttackFieldsList, allUnits.get(i));
                                            break;
                                        }
                                    } else {
                                        typoMessage();
                                    }
                                    break;
                                case "ATTACK", "A":
                                    if (canAttack) {
                                        if (allUnits.get(i).getClass().getSimpleName().equals("Footman")) {
                                            Footman footman = (Footman) allUnits.get(i);
                                            footman.setWaitedLastTurn(false);
                                        }

                                        //Meghatározni, hogy melyik egységet támadja meg
                                        Unit attackedUnit = allUnits.get(i);

                                        Set<Unit> attackableEnemies = new HashSet<>();
                                        for (Point point:possibleAttackFieldsList) {
                                            for (int k = Math.max(0, point.x - 1); k <= Math.min(point.x + 1, 11); k++) {
                                                for (int j = Math.max(0, point.y - 1); j <= Math.min(point.y + 1, 9); j++) {
                                                    if (battlefield[k][j] != null && battlefield[k][j].getTeam() != allUnits.get(i).getTeam() && !battlefield[k][j].isFallen()){
                                                        attackableEnemies.add(battlefield[k][j]);
                                                    }
                                                }
                                            }
                                        }

                                        System.out.println("Which enemy you want to attack?");
                                        Scanner attackedUnitScanner = new Scanner(System.in);
                                        boolean rightValue = false;
                                        while (true) {
                                            String scannedUnit = attackedUnitScanner.nextLine().toUpperCase();
                                            for (Unit unit:attackableEnemies) {
                                                if ((unit.getName().toUpperCase().equals(scannedUnit) || (scannedUnit.length() == 1 && unit.getName().toUpperCase().charAt(0) == scannedUnit.charAt(0)))) {
                                                    attackedUnit = unit;
                                                    rightValue = true;
                                                }
                                            }
                                            if (!rightValue) {
                                                typoMessage();
                                            } else {
                                                break;
                                            }
                                        }

                                        //System.out.println(attackedUnit.getPosition() + " enemy position");

                                        Set<Point> possibleAttackFieldsListHelp = new HashSet<>();
                                        for (Point point:possibleAttackFieldsList) {
                                            for (int k = Math.max(0, attackedUnit.getPosition().x - 1); k <= Math.min(attackedUnit.getPosition().x + 1, 11); k++) {
                                                for (int j = Math.max(0, attackedUnit.getPosition().y - 1); j <= Math.min(attackedUnit.getPosition().y + 1, 9); j++) {
                                                    if (k == point.x && j == point.y) {
                                                        possibleAttackFieldsListHelp.add(point);
                                                        //System.out.println(point);
                                                    }
                                                    //System.out.println(getName() + " zone: " + (char)(j + 'A') + " " + i);
                                                }
                                            }
                                        }
                                        if ((Math.abs(allUnits.get(i).getPosition().x - attackedUnit.getPosition().x) <= 1) && (Math.abs(allUnits.get(i).getPosition().y - attackedUnit.getPosition().y) <= 1)) {
                                            possibleAttackFieldsListHelp.add(allUnits.get(i).getPosition());
                                        }

                                        possibleAttackFieldsList = new ArrayList<>(possibleAttackFieldsListHelp);

                                        drawTheBattleFieldForBattle(battlefield, possibleUnits, new ArrayList<>(), allUnits, possibleAttackFieldsList, allUnits.get(i));

                                        //Melyik mezőről támadjon
                                        System.out.println("From where you want to attack? (A0-L9)");
                                        System.out.println("Note: only the first two characters will count.");

                                        while (true) {
                                            String wantedField = actionScanner.nextLine().toUpperCase();

                                            //Legalább 2 hosszú-e a string
                                            if (wantedField.length() < 2) {
                                                typoMessage();
                                                continue;
                                            }

                                            Point coordinate = new Point(0, 0);
                                            coordinate.x = wantedField.charAt(1) - '0';
                                            coordinate.y = wantedField.charAt(0) - 'A';

                                            if (!(0 <= coordinate.x && coordinate.x <= 9 && 0 <= coordinate.y && coordinate.y <= 11)) {
                                                typoMessage();
                                                continue;
                                            }

                                            if (!(coordinate.x == allUnits.get(i).getPosition().y && coordinate.y == allUnits.get(i).getPosition().x)) {
                                                if (!(battlefield[coordinate.y][coordinate.x] == null || battlefield[coordinate.y][coordinate.x].isFallen())) {
                                                    System.err.println("There is a unit, wrong field!");
                                                    continue;
                                                }
                                            }

                                            boolean rightCoordinate = false;
                                            for (Point point:possibleAttackFieldsList) {
                                                if (point.x == coordinate.y && point.y == coordinate.x) {
                                                    rightCoordinate = true;
                                                    break;
                                                }
                                            }
                                            //System.out.println(coordinate);

                                            if (!rightCoordinate) {
                                                typoMessage();
                                                continue;
                                            }

                                            //System.out.println(coordinate);
                                            if (!possibleAttackFieldsList.contains(new Point(coordinate.y, coordinate.x))) {
                                                typoMessage();
                                                continue;
                                            }

                                            if (!(coordinate.x == allUnits.get(i).getPosition().y && coordinate.y == allUnits.get(i).getPosition().x)) {
                                                allUnits.get(i).move(battlefield, allUnits.get(i).getPosition(), new Point(coordinate.y, coordinate.x));

                                                possibleMovesList.clear();
                                                possibleAttackFieldsList.clear();
                                                allUnits.get(i).possibleMoves(battlefield, possibleMovesList, possibleAttackFieldsList, allUnits.get(i).getPosition(), allUnits.get(i).getSpeed());

                                                set = new HashSet<>(possibleMovesList);
                                                possibleMovesList.clear();
                                                possibleMovesList.addAll(set);
                                                possibleMovesList.remove(allUnits.get(i).getPosition());
                                                set = new HashSet<>(possibleAttackFieldsList);
                                                possibleAttackFieldsList.clear();
                                                possibleAttackFieldsList.addAll(set);

                                                drawTheBattleFieldForBattle(battlefield, possibleUnits, possibleMovesList, allUnits, possibleAttackFieldsList, allUnits.get(i));
                                            }

                                            allUnits.get(i).attack(battlefield, player1, player2, attackedUnit);

                                            didTakeAction = true;

                                            break;
                                        }
                                        break;
                                    } else {
                                        typoMessage();
                                    }
                                    break;
                                case "RANGED ATTACK", "R":
                                    if (allUnits.get(i).getClass().getSimpleName().equals("Marksman") || allUnits.get(i).getClass().getSimpleName().equals("Inquisitor")) {
                                        Set<Unit> attackableEnemies = new HashSet<>();
                                        for (Unit[] units:battlefield) {
                                            for (Unit unit:units) {
                                                if (unit != null && !unit.isFallen() && unit.getTeam() != allUnits.get(i).getTeam()) {
                                                    attackableEnemies.add(unit);
                                                }
                                            }
                                        }
                                        System.out.println("Which enemy you want to shoot?");
                                        while (true) {
                                            Scanner unitScanner = new Scanner(System.in);
                                            String wantedUnit = unitScanner.nextLine().toUpperCase();
                                            boolean isDone1 = false;
                                            for (Unit unit : attackableEnemies) {
                                                if (!unit.isFallen() && (wantedUnit.length() == 1 && unit.getName().charAt(0) == wantedUnit.charAt(0)) || wantedUnit.equalsIgnoreCase(unit.getName())) {
                                                    if (allUnits.get(i).getClass().getSimpleName().equals("Marksman")) {
                                                        Marksman marksman = (Marksman) allUnits.get(i);
                                                        marksman.attackRanged(battlefield, player1, player2, unit);
                                                    } else if (allUnits.get(i).getClass().getSimpleName().equals("Inquisitor")) {
                                                        Inquisitor inquisitor = (Inquisitor) allUnits.get(i);
                                                        inquisitor.attackRanged(battlefield, player1, player2, unit);
                                                    } else {
                                                        typoMessage();
                                                        break;
                                                    }
                                                    isDone1 = true;
                                                }
                                            }
                                            if (isDone1) {
                                                break;
                                            } else {
                                                typoMessage();
                                            }
                                        }

                                        didTakeAction = true;
                                    } else {
                                        typoMessage();
                                    }
                                    break;
                                case "BLESS ALLIES", "B":
                                    if (allUnits.get(i).getClass().getSimpleName().equals("Seraph")) {
                                        Set<Unit> blessableEnemies = new HashSet<>();
                                        for (Unit[] units:battlefield) {
                                            for (Unit unit:units) {
                                                if (unit != null && unit.getTeam() == allUnits.get(i).getTeam() && unit != allUnits.get(i)) {
                                                    blessableEnemies.add(unit);
                                                }
                                            }
                                        }
                                        System.out.println("Which ally you want to bless?");
                                        while (true) {
                                            Scanner unitScanner = new Scanner(System.in);
                                            String wantedUnit = unitScanner.nextLine().toUpperCase();
                                            boolean isDone1 = false;
                                            for (Unit unit : blessableEnemies) {
                                                if ((wantedUnit.length() == 1 && unit.getName().charAt(0) == wantedUnit.charAt(0)) || wantedUnit.equalsIgnoreCase(unit.getName())) {
                                                    if (allUnits.get(i).getClass().getSimpleName().equals("Seraph")) {
                                                        Seraph seraph = (Seraph) allUnits.get(i);
                                                        seraph.RessurectAllies(battlefield, unit);
                                                    } else {
                                                        typoMessage();
                                                        break;
                                                    }
                                                    isDone1 = true;
                                                }
                                            }
                                            if (isDone1) {
                                                break;
                                            } else {
                                                typoMessage();
                                            }
                                        }
                                        didTakeAction = true;
                                    } else {
                                        typoMessage();
                                    }
                                    break;
                                case "WAIT", "W":
                                    didTakeAction = true;
                                    if (allUnits.get(i).getClass().getSimpleName().equals("Footman")) {
                                        Footman footman = (Footman) allUnits.get(i);
                                        footman.setWaitedLastTurn(true);
                                    }
                                    break;
                                default:
                                    typoMessage();
                                    break;
                            }
                        } while (!didTakeAction);
                    }
                } else {
                    //System.out.println((allUnits.get(i).getTeam() == 1 ? ConsoleFormatting.BLUE : ConsoleFormatting.RED) + allUnits.get(i).getName() + ConsoleFormatting.RESET);
                    //scanner.nextLine();

                    //Ellenfél lépése
                    //Ellenfél varázsol, ha tud
                    if (!player2.isAttacked() && !player2.isCastedASpell()) {
                        if (!player2.isCastedASpell() && player2.getSpells().size() > 0 && player2.getMana() >= player2.getSpells().get(0).getMana()) {
                            //Ha tud Circle of Winter castolni, akkor megteszi
                            if (player2.getMana() >= player2.getSpells().get(2).getMana()) {
                                int attackValue = 0;
                                Point whereToStrike = new Point(0, 0);
                                for (int j = 0; j < 12; j++) {
                                    for (int k = 0; k < 10; k++) {
                                        int attackValueTemporary = 0;
                                        boolean thereWasAnAlly = false;
                                        for (int l = Math.max(0, j - 1); l <= Math.min(j + 1, 11); l++) {
                                            for (int m = Math.max(0, k - 1); m <= Math.min(k + 1, 9); m++) {
                                                if (!(j == l && k == m)) {
                                                    if (battlefield[l][m] != null) {
                                                        if (battlefield[l][m].getTeam() != 2) {
                                                            int currentAllHealth;
                                                            if (battlefield[l][m].getUnitCount() > 0) {
                                                                currentAllHealth = (battlefield[l][m].getHealth() * (battlefield[l][m].getUnitCount() - 1) + battlefield[l][m].getRemainingHealth());
                                                            } else {
                                                                currentAllHealth = battlefield[l][m].getRemainingHealth();
                                                            }

                                                            attackValueTemporary += Math.min(player2.getSpellPower() * 35, currentAllHealth);
                                                        } else {
                                                            thereWasAnAlly = true;
                                                            break;
                                                        }
                                                    }

                                                }

                                            }
                                            if (thereWasAnAlly) {
                                                break;
                                            }

                                        }
                                        if (attackValue < attackValueTemporary && !thereWasAnAlly) {
                                            attackValue = attackValueTemporary;
                                            whereToStrike = new Point(j, k);
                                        }
                                    }
                                }
                                player2.setCastedASpell(true);
                                System.out.println(ConsoleFormatting.RED + "Enemy " + ConsoleFormatting.RESET + "casted " + player2.getSpells().get(2).getName() + " on " + ((char) (whereToStrike.x + 'A')) + whereToStrike.y);
                                player2.getSpells().get(2).castToField(battlefield, player2, new Point(whereToStrike.y, whereToStrike.x));
                                player2.setMana(player2.getMana() - player2.getSpells().get(2).getMana());
                            } else {
                                //Ha tud fireballt meg lightning boltot is castolni, akkor megnézi, hogy melyikkel jár jobban
                                if (player2.getMana() >= player2.getSpells().get(1).getMana()) {
                                    //Lightning Bolt legoptimálisabb csapása
                                    int attackLightningBolt = 0;
                                    Point pointLightningBolt = new Point(0, 0);
                                    int attackValueTemporaryLightningBolt = 0;
                                    Point pointTemporaryLightningBolt = new Point(0, 0);
                                    int attackMarksman = 0;
                                    Point pointMarksman = new Point(0, 0);
                                    int attackInquisitor = 0;
                                    Point pointInquisitor = new Point(0, 0);
                                    for (Unit[] units : battlefield) {
                                        for (Unit unit : units) {
                                            if (unit != null && !unit.isFallen() && unit.getTeam() == 1) {
                                                int currentAllHealth;
                                                if (unit.getUnitCount() > 0) {
                                                    currentAllHealth = (unit.getHealth() * (unit.getUnitCount() - 1) + unit.getRemainingHealth());
                                                } else {
                                                    currentAllHealth = unit.getRemainingHealth();
                                                }

                                                if (unit.getClass().getSimpleName().equals("Marksman")) {
                                                    attackMarksman += Math.min(player2.getSpellPower() * 20, currentAllHealth);
                                                    pointMarksman = unit.getPosition();
                                                } else if (unit.getClass().getSimpleName().equals("Inquisitor")) {
                                                    attackInquisitor += Math.min(player2.getSpellPower() * 20, currentAllHealth);
                                                    pointInquisitor = unit.getPosition();
                                                } else {
                                                    attackValueTemporaryLightningBolt = Math.min(player2.getSpellPower() * 20, currentAllHealth);
                                                    pointTemporaryLightningBolt = unit.getPosition();
                                                }
                                            }
                                        }
                                    }
                                    if (attackMarksman > 0 && attackMarksman > attackInquisitor) {
                                        attackLightningBolt = attackMarksman;
                                        pointLightningBolt = pointMarksman;
                                    } else if (attackInquisitor > 0 && attackInquisitor > attackMarksman) {
                                        attackLightningBolt = attackInquisitor;
                                        pointLightningBolt = pointInquisitor;
                                    } else {
                                        attackLightningBolt = attackValueTemporaryLightningBolt;
                                        pointLightningBolt = pointTemporaryLightningBolt;
                                    }

                                    int finalAttack = attackLightningBolt;
                                    Point finalPoint = new Point(pointLightningBolt.x, pointLightningBolt.y);

                                    for (int j = 0; j < 12; j++) {
                                        for (int k = 0; k < 10; k++) {
                                            int attackValueTemporaryFireBall = 0;
                                            boolean thereWasAnAlly = false;
                                            for (int l = Math.max(0, j - 1); l <= Math.min(j + 1, 11); l++) {
                                                for (int m = Math.max(0, k - 1); m <= Math.min(k + 1, 9); m++) {
                                                    if (battlefield[l][m] != null) {
                                                        if (battlefield[l][m].getTeam() != 2) {
                                                            int currentAllHealth;
                                                            if (battlefield[l][m].getUnitCount() > 0) {
                                                                currentAllHealth = (battlefield[l][m].getHealth() * (battlefield[l][m].getUnitCount() - 1) + battlefield[l][m].getRemainingHealth());
                                                            } else {
                                                                currentAllHealth = battlefield[l][m].getRemainingHealth();
                                                            }

                                                            attackValueTemporaryFireBall += Math.min(player2.getSpellPower() * 35, currentAllHealth);
                                                        } else {
                                                            thereWasAnAlly = true;
                                                            break;
                                                        }
                                                    }
                                                }
                                                if (thereWasAnAlly) {
                                                    break;
                                                }

                                            }
                                            if (finalAttack < attackValueTemporaryFireBall && !thereWasAnAlly) {
                                                finalAttack = attackValueTemporaryFireBall;
                                                finalPoint = new Point(j, k);
                                            }
                                        }
                                    }
                                    player2.setCastedASpell(true);
                                    if (attackLightningBolt == finalAttack) {
                                        System.out.println(ConsoleFormatting.RED + "Enemy " + ConsoleFormatting.RESET + "casted " + player2.getSpells().get(0).getName() + " on " + ConsoleFormatting.BLUE + battlefield[finalPoint.x][finalPoint.y].getName() + ConsoleFormatting.RESET);
                                        player2.getSpells().get(0).castToUnit(player2, battlefield[finalPoint.x][finalPoint.y]);
                                        player2.setMana(player2.getMana() - player2.getSpells().get(0).getMana());
                                    } else {
                                        System.out.println(ConsoleFormatting.RED + "Enemy " + ConsoleFormatting.RESET + "casted " + player2.getSpells().get(1).getName() + " on " + ((char) (finalPoint.x + 'A')) + finalPoint.y);
                                        player2.getSpells().get(1).castToField(battlefield, player2, new Point(finalPoint.y, finalPoint.x));
                                        player2.setMana(player2.getMana() - player2.getSpells().get(1).getMana());
                                    }
                                } else if (player2.getMana() >= player2.getSpells().get(0).getMana()) {
                                    //Ha csak Lightning Bolt mehet
                                    Unit attackedUnit = allUnits.get(0);
                                    for (Unit[] units : battlefield) {
                                        boolean isDone = false;
                                        for (Unit unit : units) {
                                            if (unit != null && !unit.isFallen() && unit.getTeam() == 1) {
                                                if (unit.getClass().getSimpleName().equals("Marksman")) {
                                                    attackedUnit = unit;
                                                    isDone = true;
                                                    break;
                                                } else if (unit.getClass().getSimpleName().equals("Inquisitor")) {
                                                    attackedUnit = unit;
                                                    isDone = true;
                                                    break;
                                                } else {
                                                    attackedUnit = unit;
                                                    isDone = true;
                                                    break;
                                                }
                                            }
                                        }
                                        if (isDone) {
                                            break;
                                        }
                                    }

                                    player2.setCastedASpell(true);
                                    System.out.println(ConsoleFormatting.RED + "Enemy " + ConsoleFormatting.RESET + "casted " + player2.getSpells().get(0).getName() + " on " + ConsoleFormatting.BLUE + battlefield[attackedUnit.getPosition().x][attackedUnit.getPosition().y].getName() + ConsoleFormatting.RESET);
                                    player2.getSpells().get(0).castToUnit(player2, battlefield[attackedUnit.getPosition().x][attackedUnit.getPosition().y]);
                                    player2.setMana(player2.getMana() - player2.getSpells().get(0).getMana());
                                }
                            }
                        } else {
                            //Egyébként támad
                            Unit attackedUnit = allUnits.get(0);
                            for (Unit[] units : battlefield) {
                                boolean isDone = false;
                                for (Unit unit : units) {
                                    if (unit != null && !unit.isFallen() && unit.getTeam() == 1) {
                                        if (unit.getClass().getSimpleName().equals("Marksman")) {
                                            attackedUnit = unit;
                                            isDone = true;
                                            break;
                                        } else if (unit.getClass().getSimpleName().equals("Inquisitor")) {
                                            attackedUnit = unit;
                                            isDone = true;
                                            break;
                                        } else {
                                            attackedUnit = unit;
                                            isDone = true;
                                            break;
                                        }
                                    }
                                }
                                if (isDone) {
                                    break;
                                }
                            }

                            player2.setAttacked(true);
                            System.out.println(ConsoleFormatting.RED + "Enemy " + ConsoleFormatting.RESET + "attacked " + ConsoleFormatting.BLUE + battlefield[attackedUnit.getPosition().x][attackedUnit.getPosition().y].getName() + ConsoleFormatting.RESET);
                            battlefield[attackedUnit.getPosition().x][attackedUnit.getPosition().y].takeDamage(player2.getAttack() * 10);
                        }
                    }

                    //Ha az ellenfél hős megvan, akkor az ellenfél egysége aktívkodik
                    if (allUnits.get(i).getClass().getSimpleName().equals("Marksman") || allUnits.get(i).getClass().getSimpleName().equals("Inquisitor")) {
                        //Ha ranged és tud lőni
                        boolean canShoot = true;
                        for (int k = Math.max(0, allUnits.get(i).getPosition().x - 1); k <= Math.min(allUnits.get(i).getPosition().x + 1, 11); k++) {
                            for (int j = Math.max(0, allUnits.get(i).getPosition().y - 1); j <= Math.min(allUnits.get(i).getPosition().y + 1, 9); j++) {
                                if (battlefield[k][j] != null && battlefield[k][j].getTeam() != allUnits.get(i).getTeam() && !battlefield[k][j].isFallen()) {
                                    canShoot = false;
                                    break;
                                }
                            }
                            if (!canShoot) {
                                break;
                            }
                        }
                        if (canShoot) {
                            Unit attackedUnit = allUnits.get(0);
                            for (Unit[] units : battlefield) {
                                boolean isDone = false;
                                for (Unit unit : units) {
                                    if (unit != null && !unit.isFallen() && unit.getTeam() == 1) {
                                        if (unit.getClass().getSimpleName().equals("Marksman")) {
                                            attackedUnit = unit;
                                            isDone = true;
                                            break;
                                        } else if (unit.getClass().getSimpleName().equals("Inquisitor")) {
                                            attackedUnit = unit;
                                            isDone = true;
                                            break;
                                        } else {
                                            attackedUnit = unit;
                                            isDone = true;
                                            break;
                                        }
                                    }
                                }
                                if (isDone) {
                                    break;
                                }
                            }

                            //System.out.println(ConsoleFormatting.RED + allUnits.get(i).getName() + ConsoleFormatting.RESET + " attacked " + ConsoleFormatting.BLUE + battlefield[attackedUnit.getPosition().x][attackedUnit.getPosition().y].getName() + ConsoleFormatting.RESET);
                            if (allUnits.get(i).getClass().getSimpleName().equals("Marksman")) {
                                Marksman marksman = (Marksman) allUnits.get(i);
                                marksman.attackRanged(battlefield, player2, player1, battlefield[attackedUnit.getPosition().x][attackedUnit.getPosition().y]);
                            } else if (allUnits.get(i).getClass().getSimpleName().equals("Inquisitor")) {
                                Inquisitor inquisitor = (Inquisitor) allUnits.get(i);
                                inquisitor.attackRanged(battlefield, player2, player1, battlefield[attackedUnit.getPosition().x][attackedUnit.getPosition().y]);
                            } else {
                                System.out.println("Enemy has waited");
                                //break;
                            }
                        } else {
                            boolean canAttack = !possibleAttackFieldsList.isEmpty();

                            if (canAttack) {
                                if (!(possibleAttackFieldsList.get(0).x == allUnits.get(i).getPosition().x && possibleAttackFieldsList.get(0).y == allUnits.get(i).getPosition().y)) {
                                    allUnits.get(i).move(battlefield, new Point(allUnits.get(i).getPosition().x, allUnits.get(i).getPosition().y), possibleAttackFieldsList.get(0));
                                }
                                boolean foundAnEnemy = false;
                                for (int k = Math.max(0, allUnits.get(i).getPosition().x - 1); k <= Math.min(allUnits.get(i).getPosition().x + 1, 11); k++) {
                                    for (int j = Math.max(0, allUnits.get(i).getPosition().y - 1); j <= Math.min(allUnits.get(i).getPosition().y + 1, 9); j++) {
                                        if (battlefield[k][j] != null && battlefield[k][j].getTeam() != allUnits.get(i).getTeam() && !battlefield[k][j].isFallen()) {
                                            allUnits.get(i).attack(battlefield, player2, player1, battlefield[k][j]);
                                            foundAnEnemy = true;
                                            break;
                                        }
                                    }
                                    if (foundAnEnemy) {
                                        break;
                                    }
                                }
                            } else {
                                System.out.println(ConsoleFormatting.RED + allUnits.get(i).getName() + ConsoleFormatting.RESET + " has waited");
                            }
                        }
                    } else {
                        boolean canMove = false;
                        boolean canAttack = false;
                        if (!possibleMovesList.isEmpty()) {
                            canMove = true;
                        }
                        if (!possibleAttackFieldsList.isEmpty()) {
                            canAttack = true;
                        }

                        if (canAttack) {
                            if (!(possibleAttackFieldsList.get(0).x == allUnits.get(i).getPosition().x && possibleAttackFieldsList.get(0).y == allUnits.get(i).getPosition().y)) {
                                allUnits.get(i).move(battlefield, new Point(allUnits.get(i).getPosition().x, allUnits.get(i).getPosition().y), possibleAttackFieldsList.get(0));
                                System.out.println(ConsoleFormatting.RED + allUnits.get(i).getName() + ConsoleFormatting.RESET + " moved to attack");
                                drawTheBattleFieldForBattle(battlefield, possibleUnits, new ArrayList<>(), allUnits, new ArrayList<>(), allUnits.get(i));
                            }
                            boolean foundAnEnemy = false;
                            for (int k = Math.max(0, allUnits.get(i).getPosition().x - 1); k <= Math.min(allUnits.get(i).getPosition().x + 1, 11); k++) {
                                for (int j = Math.max(0, allUnits.get(i).getPosition().y - 1); j <= Math.min(allUnits.get(i).getPosition().y + 1, 9); j++) {
                                    if (battlefield[k][j] != null && battlefield[k][j].getTeam() != allUnits.get(i).getTeam() && !battlefield[k][j].isFallen()) {
                                        allUnits.get(i).attack(battlefield, player2, player1, battlefield[k][j]);
                                        foundAnEnemy = true;
                                        break;
                                    }
                                }
                                if (foundAnEnemy) {
                                    break;
                                }
                            }
                        } else {
                            if (!canMove) {
                                if (allUnits.get(i).getClass().getSimpleName().equals("Footman")) {
                                    Footman footman = (Footman) allUnits.get(i);
                                    footman.setWaitedLastTurn(true);
                                }
                                System.out.println(ConsoleFormatting.RED + allUnits.get(i).getName() + ConsoleFormatting.RESET + " has waited");
                            } else {
                                if (allUnits.get(i).getClass().getSimpleName().equals("Footman")) {
                                    Footman footman = (Footman) allUnits.get(i);
                                    footman.setWaitedLastTurn(false);
                                }

                                Random rnd = new Random();
                                Point whereToMove = possibleMovesList.get(rnd.nextInt(possibleMovesList.size()));
                                System.out.println(ConsoleFormatting.RED + allUnits.get(i).getName() + ConsoleFormatting.RESET + " moved");
                                allUnits.get(i).move(battlefield, allUnits.get(i).getPosition(), whereToMove);
                                drawTheBattleFieldForBattle(battlefield, possibleUnits, new ArrayList<>(), allUnits, new ArrayList<>(), allUnits.get(i));
                            }
                        }
                    }

                    System.out.println("Press enter to continue the battle!");
                    scanner.nextLine();
                }



                //System.out.println(ConsoleFormatting.RED + allUnits.get(i).getName() + ConsoleFormatting.RESET + "'s action");
                //System.out.println("The enemy will also do something eventually!");
                //System.out.println(player2.getMana());
                //System.out.println("End of action, press enter");

                //scanner.nextLine();
            }

            //scanner.nextLine();

            //System.out.println("i before change: " + i);
            if (i == allUnits.size() - 1){
                i = -1;
                round++;
                player1.setAttacked(false);
                player1.setCastedASpell(false);
                player2.setAttacked(false);
                player2.setCastedASpell(false);

                System.out.println("Unit order:");
                for (Unit unit : allUnits) {
                    if (!unit.isFallen()) {
                        System.out.print((unit.getTeam() == 1? ConsoleFormatting.BLUE : ConsoleFormatting.RED) + unit.getName() + ConsoleFormatting.RESET + " ");
                    }
                }
                System.out.println();
            }
            //System.out.println("i after change: " + i);
        }
    }

    private static void drawTheBattleFieldForBattle(Unit[][] battlefield, ArrayList<Unit> possibleUnits, ArrayList<Point> possibleMovesList, ArrayList<Unit> allUnits, ArrayList<Point> possibleAttackFieldsList, Unit unit) {
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
                //System.out.println(currentCoordinate);
                //System.out.println(allUnits.get(i).getPosition());
                if (possibleAttackFieldsList.contains(currentCoordinate) && !(battlefield[currentCoordinate.x][currentCoordinate.y] != null && battlefield[currentCoordinate.x][currentCoordinate.y].isFallen()) && (battlefield[j][i] != unit)){
                    System.out.print("| " + (ConsoleFormatting.RED_UNDERLINED + "x" + ConsoleFormatting.RESET) + " |");
                    //System.out.println(currentCoordinate);
                } else if (possibleMovesList.contains(currentCoordinate) && !(battlefield[currentCoordinate.x][currentCoordinate.y] != null && battlefield[currentCoordinate.x][currentCoordinate.y].isFallen())){
                    System.out.print("| " + (ConsoleFormatting.GREEN + "x" + ConsoleFormatting.RESET) + " |");
                } else {
                    String text = " ";
                    String background = "";
                    String unitName = "";
                    if (battlefield[j][i] != null){
                        unitName = battlefield[j][i].getName();
                        if (battlefield[j][i] == unit) {
                            text = ConsoleFormatting.WHITE_BRIGHT;
                            if (battlefield[j][i].getTeam() == 1) {
                                background = ConsoleFormatting.BLUE_BACKGROUND;
                            }
                            else{
                                background = ConsoleFormatting.RED_BACKGROUND;
                            }
                        } else if (!battlefield[j][i].isFallen()){
                            if (battlefield[j][i].getTeam() == 1) {
                                text = ConsoleFormatting.BLUE;
                            }
                            else{
                                text = ConsoleFormatting.RED;
                            }
                            background = "";
                        } else{
                            if (battlefield[j][i].getTeam() == 1) {
                                text = ConsoleFormatting.YELLOW_BRIGHT;
                            }
                            else{
                                text = ConsoleFormatting.PURPLE;
                            }
                            background = "";
                        }

                        /*if (battlefield[j][i] == unit && battlefield[j][i].getTeam() == 1) {
                            text = ConsoleFormatters.ConsoleFormatting.BLUE + battlefield[j][i].getName().charAt(0) + ConsoleFormatters.ConsoleFormatting.RESET;
                        }
                        else if (battlefield[j][i].getTeam() == 1){
                            text = ConsoleFormatters.ConsoleFormatting.BLUE + battlefield[j][i].getName().charAt(0) + ConsoleFormatters.ConsoleFormatting.RESET;
                        } else {
                            text = ConsoleFormatters.ConsoleFormatting.RED + battlefield[j][i].getName().charAt(0) + ConsoleFormatters.ConsoleFormatting.RESET;
                        }*/
                        ///battlefield[j][i].setPosition(new Point(j, i));
                    }
                    System.out.print("| " + text + background + (unitName.equals("")? "":unitName.charAt(0)) + ConsoleFormatting.RESET + " |");
                }
            }

            //Oldalra kiírja az egységek neveit és rövidítéseit
            if (i < possibleUnits.size()){
                System.out.print("   " + ConsoleFormatting.WHITE_BACKGROUND + ConsoleFormatting.BLACK_BOLD + possibleUnits.get(i).getName().charAt(0) + " — " + possibleUnits.get(i).getName() + ConsoleFormatting.RESET);
            }

            System.out.println();
        }

        for (int i = 0; i < n + 1; i++) {
            System.out.print(row1);
        }
        System.out.println();
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
        for (int i = 0; i < units.size(); i++) {
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

            //Legalább 2 hosszú-e a string
            if (stringCoordinate.length() < 2) {
                typoMessage();
                continue;
            }

            Point coordinate = new Point(0,0);
            coordinate.x = stringCoordinate.charAt(0) - 'A';
            coordinate.y = stringCoordinate.charAt(1) - '0';

            if (!(0 <= coordinate.x && coordinate.x <= 1 && 0 <= coordinate.y && coordinate.y <= 9)){
                typoMessage();
                continue;
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
                System.out.print("| " + (ConsoleFormatting.BLUE + c + ConsoleFormatting.RESET) + " |");
            }

            if (i < possibleUnits.size()){
                System.out.print("   " + ConsoleFormatting.WHITE_BACKGROUND + ConsoleFormatting.BLACK_BOLD + possibleUnits.get(i).getName().charAt(0) + " — " + possibleUnits.get(i).getName() + ConsoleFormatting.RESET);
            }

            System.out.println();
        }

        for (int i = 0; i < n + 1; i++) {
            System.out.print(row1);
        }
        System.out.println();
    }

    private static void occupiedFieldMessage() { System.err.println("This field is occupied, type another field!"); }

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
                                    System.err.println("You cant't buy more of this! You have reached 10 points");
                                    continue;
                                }
                                player1.setAttack(player1.getAttack() + 1);
                                player1.setGold(player1.getGold() - currentAttributeCost);
                                currentAttributeCost = (int) Math.ceil(currentAttributeCost * 1.1d);
                                printHeroWithGoldAmountText(player1);
                            }
                            case "D", "DEFENSE" -> {
                                if (player1.getDefense() > 9) {
                                    System.err.println("You cant't buy more of this! You have reached 10 points");
                                    continue;
                                }
                                player1.setDefense(player1.getDefense() + 1);
                                player1.setGold(player1.getGold() - currentAttributeCost);
                                currentAttributeCost = (int) Math.ceil(currentAttributeCost * 1.1d);
                                printHeroWithGoldAmountText(player1);
                            }
                            case "S", "SPELLPOWER", "SPELL POWER" -> {
                                if (player1.getSpellPower() > 9) {
                                    System.err.println("You cant't buy more of this! You have reached 10 points");
                                    continue;
                                }
                                player1.setSpellPower(player1.getSpellPower() + 1);
                                player1.setGold(player1.getGold() - currentAttributeCost);
                                currentAttributeCost = (int) Math.ceil(currentAttributeCost * 1.1d);
                                printHeroWithGoldAmountText(player1);
                            }
                            case "K", "KNOWLEDGE" -> {
                                if (player1.getKnowledge() > 9) {
                                    System.err.println("You cant't buy more of this! You have reached 10 points");
                                    continue;
                                }
                                player1.setKnowledge(player1.getKnowledge() + 1);
                                player1.setGold(player1.getGold() - currentAttributeCost);
                                currentAttributeCost = (int) Math.ceil(currentAttributeCost * 1.1d);
                                printHeroWithGoldAmountText(player1);
                            }
                            case "M", "MORALE" -> {
                                if (player1.getMorale() > 9) {
                                    System.err.println("You cant't buy more of this! You have reached 10 points");
                                    continue;
                                }
                                player1.setMorale(player1.getMorale() + 1);
                                player1.setGold(player1.getGold() - currentAttributeCost);
                                currentAttributeCost = (int) Math.ceil(currentAttributeCost * 1.1d);
                                printHeroWithGoldAmountText(player1);
                            }
                            case "L", "LUCK" -> {
                                if (player1.getLuck() > 9) {
                                    System.err.println("You cant't buy more of this! You have reached 10 points");
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
                    player1 = new Hero(1300 * 1, 1);
                    return player1;
                }
                case "M", "MEDIUM" -> {
                    System.out.println("Medium difficulty");
                    player1 = new Hero(1000 * 1, 1);
                    return player1;
                }
                case "H", "HARD" -> {
                    System.out.println("Hard difficulty");
                    player1 = new Hero(700 * 1, 1);
                    return player1;
                }
                default -> typoMessage();
            }
        }
    }

    static void typoMessage(){ System.err.println("There must be a typo, try again!"); }

    static void wrongNumberMessage(){ System.err.println("Unfortunately that won't work with that number, try again!"); }

    static void printHeroWithGoldAmountText(Hero player1){ System.out.println("The hero's current attributes:\n" + player1 + "\n"); }
}
