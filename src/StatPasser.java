import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Graph;

import java.util.Arrays;

public class StatPasser {
    private Graph g;
    private BreadthFirstPaths bfp;
    private Iterable<Integer> solution;
    private boolean hs;
    /*
    1: Monster
    2: Water 1
    3: Bug
    4: Flying
    5: Field
    6: Fairy
    7: Grass
    8: Human-Like
    9: Water 3
    10: Mineral
    11: Amorphous
    12: Water 2
    13: Dragon
     */




    public StatPasser(String start, String end, Pokemon[] dex) {

        /*for (Monster m : FRLGrdex) {
            System.out.println(m.getName());
        }*/

        hs = false;
        String printable = "Path is: ";
        g = new Graph(dex.length + 20);

        if(start.toUpperCase().equals("PICHU")){
            start = "pikachu";
        }
        else if (start.toUpperCase().equals("CLEFFA")) {
            start = "Clefairy";
        }
        else if (start.toUpperCase().equals("IGGLYBUFF")) {
            start = "jigglypuff";
        }
        else if (start.toUpperCase().equals("TOGEPI")) {
            start = "togetic";
        }
        else if (start.toUpperCase().equals("TYROGUE")) {
            start = "Hitmonlee";
        }
        else if (start.toUpperCase().equals("SMOOCHUM")) {
            start = "Jynx";
        }
        else if (start.toUpperCase().equals("ELEKID")) {
            start = "Electabuzz";
        }
        else if (start.toUpperCase().equals("MAGBY")) {
            start = "Magmar";
        }
        else if (start.toUpperCase().equals("Azurill")) {
            start = "Marill";
        }
        else if (start.toUpperCase().equals("WYNAUT")) {
            start = "Wobbuffet";
        }
        else if (start.toUpperCase().equals("BUDEW")) {
            start = "Roselia";
        }
        else if (start.toUpperCase().equals("CHINGLING")) {
            start = "Chimecho";
        }
        else if (start.toUpperCase().equals("BONSLY")) {
            start = "Sudowoodo";
        }
        else if (start.toUpperCase().equals("MIME JR.")) {
            start = "Mr. Mime";
        }
        else if (start.toUpperCase().equals("HAPPINY")) {
            start = "Chansey";
        }
        else if (start.toUpperCase().equals("MUNCHLAX")) {
            start = "Snorlax";
        }
        else if (start.toUpperCase().equals("RIOLU")) {
            start = "Lucario";
        }
        else if (start.toUpperCase().equals("MANTYKE")) {
            start = "Mantine";
        }
        else if (start.toUpperCase().equals("TOXEL")) {
            start = "Toxtricity";
        }

        if(end.toUpperCase().equals("PICHU")){
            end = "pikachu";
        }
        else if (end.toUpperCase().equals("CLEFFA")) {
            end = "Clefairy";
        }
        else if (end.toUpperCase().equals("IGGLYBUFF")) {
            end = "jigglypuff";
        }
        else if (end.toUpperCase().equals("TOGEPI")) {
            end = "togetic";
        }
        else if (end.toUpperCase().equals("TYROGUE")) {
            end = "Hitmonlee";
        }
        else if (end.toUpperCase().equals("SMOOCHUM")) {
            end = "Jynx";
        }
        else if (end.toUpperCase().equals("ELEKID")) {
            end = "Electabuzz";
        }
        else if (end.toUpperCase().equals("MAGBY")) {
            end = "Magmar";
        }
        else if (end.toUpperCase().equals("Azurill")) {
            end = "Marill";
        }
        else if (end.toUpperCase().equals("WYNAUT")) {
            end = "Wobbuffet";
        }
        else if (end.toUpperCase().equals("BUDEW")) {
            end = "Roselia";
        }
        else if (end.toUpperCase().equals("CHINGLING")) {
            end = "Chimecho";
        }
        else if (end.toUpperCase().equals("BONSLY")) {
            end = "Sudowoodo";
        }
        else if (end.toUpperCase().equals("MIME JR.")) {
            end = "Mr. Mime";
        }
        else if (end.toUpperCase().equals("HAPPINY")) {
            end = "Chansey";
        }
        else if (end.toUpperCase().equals("MUNCHLAX")) {
            end = "Snorlax";
        }
        else if (end.toUpperCase().equals("RIOLU")) {
            end = "Lucario";
        }
        else if (end.toUpperCase().equals("MANTYKE")) {
            end = "Mantine";
        }
        else if (end.toUpperCase().equals("TOXEL")) {
            end = "Toxtricity";
        }

        if (!verify(start, true, dex) || !verify(end, false, dex)) {
            throw new IllegalArgumentException();
        } else if (start.toUpperCase().equals("DITTO")) {
            //find ending monster
            for (Pokemon m : dex) {
                if (m.getName().toUpperCase().equals(end.toUpperCase())) {
                    if(m.getEggGroup1().equals("Undiscovered")){
                        throw new IllegalArgumentException();
                    }
                    break;
                }
            }
            printable = "Ditto + " + end;
        } else {
            Arrays.sort(dex);

            /*for (Monster m : FRLGrdex) {
                System.out.println(m.getName());
            }*/

            for (int i = 0; i < dex.length; i++) {
                for (String eggGroup : dex[i].getEggGroups()) {
                    if (eggGroup == null) {
                        //do nothing
                    } else if (eggGroup.equals("Monster")) {
                        g.addEdge(i + 14, 1);
                    } else if (eggGroup.equals("Water 1")) {
                        g.addEdge(i + 14, 2);
                    } else if (eggGroup.equals("Bug")) {
                        g.addEdge(i + 14, 3);
                    } else if (eggGroup.equals("Flying")) {
                        g.addEdge(i + 14, 4);
                    } else if (eggGroup.equals("Field")) {
                        g.addEdge(i + 14, 5);
                    } else if (eggGroup.equals("Fairy")) {
                        g.addEdge(i + 14, 6);
                    } else if (eggGroup.equals("Grass")) {
                        g.addEdge(i + 14, 7);
                    } else if (eggGroup.equals("Human-Like")) {
                        g.addEdge(i + 14, 8);
                    } else if (eggGroup.equals("Water 3")) {
                        g.addEdge(i + 14, 9);
                    } else if (eggGroup.equals("Mineral")) {
                        g.addEdge(i + 14, 10);
                    } else if (eggGroup.equals("Amorphous")) {
                        g.addEdge(i + 14, 11);
                    } else if (eggGroup.equals("Water 2")) {
                        g.addEdge(i + 14, 12);
                    } else if (eggGroup.equals("Dragon")) {
                        g.addEdge(i + 14, 13);
                    }
                }
            }

            //find starting monster
            int index = 0;
            for (Pokemon m : dex) {
                if (m.getName().toUpperCase().equals(start.toUpperCase())) {
                    break;
                }
                index++;
            }
            bfp = new BreadthFirstPaths(g, index + 14);
            //find ending monster
            index = 0;
            for (Pokemon m : dex) {
                if (m.getName().toUpperCase().equals(end.toUpperCase())) {
                    end = m.getName();
                    break;
                }
                index++;
            }
            solution = bfp.pathTo(index + 14);
            if (solution == null) {
                hs = false;
            } else {
                hs = true;
            }
            if (hs) {
                int skip = 0;
                for (Integer inte : solution) {
                    if (skip == 0){
                        printable += dex[inte - 14].getName() +"\n"+ dex[inte - 14].getName()+ "♂ + ";
                    }
                    else if (skip % 2 == 0) {
                        printable += dex[inte - 14].getName() +"♀\n"+ dex[inte - 14].getName()+ "♂ + ";
                    }
                    skip++;
                }
            }
        }
        if (printable.equals("Path is: ")) {
            System.out.print("There is no solution");
            printable = "";
        }
        if(!start.toUpperCase().equals("DITTO")){
            printable = printable.substring(0, printable.lastIndexOf("\n"))+" =\n"+end;
        }
        System.out.print(printable);

    }

    public boolean verify(String s, boolean start, Pokemon[] dex) {
        boolean passed = false;
        for (Pokemon m : dex) {
            if (m.getName().toUpperCase().equals(s.toUpperCase())) {
                passed = true;
                if(m.getMaleRatio() == 0.0 && !m.getName().toUpperCase().equals("DITTO")){
                    passed = false;
                }
                else if(m.getMaleRatio()== 100.0 && !start){
                    passed = false;
                } else if (m.getMaleRatio() == -100.0 && start) {
                    passed = false;
                }
                break;
            }
        }
        return passed;
    }

    public static void main(String[] args) {
        StatPasser statPasser = new StatPasser("meowscarada", "bombirdier", Pokedexes.SVDLCdex);
    }
}