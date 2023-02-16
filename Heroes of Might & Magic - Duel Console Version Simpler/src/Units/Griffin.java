package Units;

import Parent_Classes.Hero;
import Parent_Classes.Unit;

import java.awt.*;
import java.util.ArrayList;

public class Griffin extends Unit {
    public Griffin(int team){
        super(team);
    }

    @Override
    public void possibleMoves(Unit[][] battlefield, ArrayList<Point> possibleMovesList, ArrayList<Point> possibleAttackFieldsList, Point currentPosition, float speed) {
        if (battlefield[currentPosition.x][currentPosition.y] == null || battlefield[currentPosition.x][currentPosition.y].isFallen()){
            for (int i = Math.max(0, currentPosition.x - 1); i <= Math.min(currentPosition.x + 1, 11); i++) {
                for (int j = Math.max(0, currentPosition.y - 1); j <= Math.min(currentPosition.y + 1, 9); j++) {
                    if (battlefield[i][j] != null && battlefield[i][j].getTeam() != this.getTeam() && !battlefield[i][j].isFallen()){
                    /*System.out.println(this.getName() + " and team: " + this.getTeam());
                    System.out.println(currentPosition);
                    Scanner scanner = new Scanner(System.in);
                    scanner.nextLine();*/

                        possibleAttackFieldsList.add(currentPosition);
                    }

                    //System.out.println(getName() + " zone: " + (char)(j + 'A') + " " + i);
                }
            }

            possibleMovesList.add(currentPosition);
        }
        if (speed >= 1.42f) {
            //Jobbra Fel
            if (currentPosition.x + 1 <= 11 && currentPosition.y - 1 >= 0){
                if (battlefield[currentPosition.x + 1][currentPosition.y - 1] == null || battlefield[currentPosition.x + 1][currentPosition.y - 1].isFallen()){
                    possibleMoves(battlefield, possibleMovesList, possibleAttackFieldsList, new Point(currentPosition.x + 1, currentPosition.y - 1), speed - 1.42f);
                }
            }
            //Balra Fel
            if (currentPosition.x - 1 >= 0 && currentPosition.y - 1 >= 0){
                if (battlefield[currentPosition.x - 1][currentPosition.y - 1] == null || battlefield[currentPosition.x - 1][currentPosition.y - 1].isFallen()){
                    possibleMoves(battlefield, possibleMovesList, possibleAttackFieldsList, new Point(currentPosition.x - 1, currentPosition.y - 1), speed - 1.42f);
                }
            }
            //Jobbra Le
            if (currentPosition.x + 1 <= 11 && currentPosition.y + 1 <= 9){
                if (battlefield[currentPosition.x + 1][currentPosition.y + 1] == null || battlefield[currentPosition.x + 1][currentPosition.y + 1].isFallen()){
                    possibleMoves(battlefield, possibleMovesList, possibleAttackFieldsList, new Point(currentPosition.x + 1, currentPosition.y + 1), speed - 1.42f);
                }
            }
            //Balra Le
            if (currentPosition.x - 1 >= 0 && currentPosition.y + 1 <= 9){
                if (battlefield[currentPosition.x - 1][currentPosition.y + 1] == null || battlefield[currentPosition.x - 1][currentPosition.y + 1].isFallen()){
                    possibleMoves(battlefield, possibleMovesList, possibleAttackFieldsList, new Point(currentPosition.x - 1, currentPosition.y + 1), speed - 1.42f);
                }
            }
        }
        if (speed >= 1f){
            //Fel
            if (currentPosition.y - 1 >= 0){
                possibleMoves(battlefield, possibleMovesList, possibleAttackFieldsList, new Point(currentPosition.x, currentPosition.y - 1), speed - 1f);
            }
            //Jobbra
            if (currentPosition.x + 1 <= 11){
                possibleMoves(battlefield, possibleMovesList, possibleAttackFieldsList, new Point(currentPosition.x + 1, currentPosition.y), speed - 1f);
            }
            //Balra
            if (currentPosition.x - 1 >= 0){
                possibleMoves(battlefield, possibleMovesList, possibleAttackFieldsList, new Point(currentPosition.x - 1, currentPosition.y), speed - 1f);
            }
            //Le
            if (currentPosition.y + 1 <= 9){
                possibleMoves(battlefield, possibleMovesList, possibleAttackFieldsList, new Point(currentPosition.x, currentPosition.y + 1), speed - 1f);
            }
        }
    }

    @Override
    public void retaliate(Unit[][] battlefield, Hero allyHero, Hero enemyHero, Unit enemy) {
        super.retaliate(battlefield, allyHero, enemyHero, enemy);
        setRetailed(false);
    }
}
