package Parent_Classes;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Spell {
    private String name;
    private int cost;
    private int mana;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*Lehet egy classban kellene minden varászlatot megcsinálni
    statikus metódusokkal. Viszont akkor lehet mindig switch ciklussal
    kellene végigrohanni ezen a classon, ha egy adott spellt akarunk
    használni. Bár ezt szét lehetne szedni a 9 típusra, és esetlegesen
    úgy származtatni.
     */

    public Spell(){
        String[][] s = readTheData();

        //Mindegyik egységre vonatkozó adatok
        for (String[] strings : s) {
            switch (strings[0]) {
                case "name" -> this.name = strings[1];
                case "cost" -> this.cost = Integer.parseInt(strings[1]);
                case "mana" -> this.mana = Integer.parseInt(strings[1]);
                case "description" -> this.description = strings[1];
            }
        }
    }

    private String[][] readTheData()
    {
        File whereToSearch = new File("src/Data_Folder/Spell_Folder");
        File dataFile = findFile(whereToSearch, this.getClass().getSimpleName());

        int i = 0;
        try (Scanner scanner = new Scanner(dataFile)) {
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String[][] s = new String[i][2];
        i = 0;
        try (Scanner scanner = new Scanner(dataFile)) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(": ", 2);

                s[i][0] = data[0];
                s[i][1] = data[1];
                //System.out.println(s[i][0] + " " + s[i][1]);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return s;
    }


    //Rekurzívan megkeressük a megfelelő txt fájlt - mappákba mászunk bele, ezért kell így
    private static File findFile(File dir, String name) {
        File result = null;
        File[] dirlist  = dir.listFiles();

        for (File file : dirlist) {
            if (file.isDirectory()) {
                result = findFile(file, name);
                if (result != null) break; // Rekurzív keresés sikeres, kiugrunk a ciklusból
            } else if (file.getName().matches(name)) {
                return file; // Visszaadjuk a fájlt
            }
        }
        return result; // Ha semmit nem találtunk, akkor nullt ad vissza - nem kellene h megtörténjen
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\n" +
                "Cost: " + this.cost + "\n" +
                "Mana: " + this.mana + "\n" +
                "Description: " + this.description;
    }

    public void castToUnit(Hero player, Unit unit) {

    }

    public void castToField(Unit[][] battlefield, Hero player, Point centre) {

    }
}
