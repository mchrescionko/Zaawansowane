package drzewaBinarne;

import javax.imageio.metadata.IIOInvalidTreeException;

import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {

        Integer[] drzewo = new Integer[100];


//        Scanner scanner = new Scanner(System.in);
//        while(true){
//            drzewo = drzewo(scanner.nextInt(), drzewo);
//            System.out.println();
//            System.out.println("aktualizacja");
//            System.out.println();
//            for (int i=0;i< drzewo.length;i++) {
//                System.out.print(drzewo[i]+ " ");
//            }
//
//        }
        drzewo[0] = 0;
        drzewo[1] = 1;
        drzewo[2] = 2;
        drzewo[3] = 3;
        drzewo[4] = 4;
        drzewo[5] = 5;
        drzewo[6] = 6;
        drzewo[7] = 7;
        drzewo[8] = 8;
        drzewo[9] = 9;
        drzewo[10] = 10;
        drzewo[11] = 11;
        drzewo[12] = 12;
        drzewo[13] = 13;
        drzewo[14] = 14;
        preOrder(drzewo);
//        postOrder(drzewo);
//        drzewo = usuniecieMinimalnego(drzewo);
//        System.out.println();
//        postOrder(drzewo);
//        System.out.println("now2y");
        drzewo = usuniecieKorzenia(drzewo);
        System.out.println("nowy");
        preOrder(drzewo);
//        System.out.println("PReorder:");
//        preOrder(drzewo);




    }

    public static Integer[] rozszerzanieDrzewa(Integer[] drzewo, int i){

            Integer[] drzewoNowe = new Integer[drzewo.length];
            for (int j = 0; j < drzewo.length; j++) {
                drzewoNowe[j] = drzewo[j];
            }
            drzewo = new Integer[i + 1];
            for (int j = 0; j < drzewoNowe.length; j++) {
                drzewo[j] = drzewoNowe[j];
            }
        return drzewo;
    }

    public static Integer[] usuniecieKorzenia(Integer[] drzewo) {
        Integer[] drzewo1 = new Integer [drzewo.length+1];
        for(int i = 0;i<drzewo.length-1;i++){
            if(drzewo[i+1]!=null){
                drzewo1=dodanieWezla(drzewo1, drzewo[i+1]);
            }

        }
        return drzewo1;
    }

    public static Integer[] dodanieWezla(Integer[] drzewo, int x) {
        boolean result = true;
        int i = 0;
        while (result) {
            if (i >= drzewo.length) {
                Integer[] drzewoNowe = new Integer[drzewo.length];
                for (int j = 0; j < drzewo.length; j++) {
                    drzewoNowe[j] = drzewo[j];
                }
                drzewo = new Integer[i + 1];
                for (int j = 0; j < drzewoNowe.length; j++) {
                    drzewo[j] = drzewoNowe[j];
                }
            }
            if (drzewo[i] != null) {
                if (drzewo[i] <= x) {
                    i = 2*i+1;
                }else{
                    i = 2*i+2;
                }
            } else {
                drzewo[i] = x;
                result = false;
            }
        }
        return drzewo;
    }


    public static Integer[] drzewo(int x, Integer[] drzewo) {
        int i = 0;
        boolean result = true;
        while (result) {
            if (i >= drzewo.length) {
                Integer[] drzewoNowe = new Integer[drzewo.length];
                for (int j = 0; j < drzewo.length; j++) {
                    drzewoNowe[j] = drzewo[j];
                }
                drzewo = new Integer[i + 1];
                for (int j = 0; j < drzewoNowe.length; j++) {
                    drzewo[j] = drzewoNowe[j];
                }
            }
            if (drzewo[i] == null) {
                drzewo[i] = x;
                System.out.println(i);
                return drzewo;
            } else if (x > drzewo[i]) {
                i = 2 * i + 2;
            } else {
                i = 2 * i + 1;
            }
        }
        return drzewo;
    }


    public static void preOrder(Integer[] drzewo) {
        boolean result = true;
        boolean result2;
        int i = 0;
        while (result) {
            if (drzewo[i] != null) {
                System.out.println(drzewo[i]);
                if(2 * i + 2>drzewo.length){
                    drzewo=rozszerzanieDrzewa(drzewo,2 * i + 2);
                }
                if (drzewo[2 * i + 1] != null) {
                    i = 2 * i + 1;
                } else if (drzewo[2 * i + 2] != null) {
                    i = 2 * i + 2;
                } else {
                    result2 = true;
                    while (result2) {
                        if (i % 2 != 0) {
                            i = i + 1;
                            result2 = false;
                        } else {
                            i = (i - 1) / 2;
                            if (i == 0) {
                                result = false;
                                result2 = false;
                            }
                        }
                    }
                }
            } else {
                result2 = true;
                while (result2) {
                    if (i % 2 != 0) {
                        i = i + 1;
                        result2 = false;
                    } else {
                        i = (i - 1) / 2;
                        if (i == 0) {
                            result = false;
                            result2 = false;
                        }
                    }
                }

            }
        }
    }

    public static void inOrder(Integer[] drzewo) {
        boolean result = true;
        boolean result2;
        int i = 0;
        while (result) {
            if (drzewo[i] != null) {
                if (drzewo[2 * i + 1] != null) {
                    i = 2 * i + 1;
                } else if (drzewo[2 * i + 2] != null) {
                    System.out.println(drzewo[i]);
                    i = 2 * i + 2;
                } else {
                    System.out.println(drzewo[i]);
                    result2 = true;
                    while (result2) {
                        if (i % 2 == 1) {
                            System.out.println(drzewo[(i - 1) / 2]);
                            i = (i - 1) / 2;
                            if (drzewo[i * 2 + 2] != null) {
                                i = i * 2 + 2;
                                result2 = false;
                            }
                        } else {
                            i = i / 2 - 1;
                            if (i == 0) {
                                result = false;
                            }
                        }
                    }
                }
            } else {
                result2 = true;
                while (result2) {
                    if (i % 2 != 0) {
                        i = i + 1;
                        if (drzewo[i] != null) {
                            System.out.println(drzewo[(i - 1) / 2]);
                        }
                        result2 = false;
                    } else {
                        i = (i - 1) / 2;
                        if (i == 0) {
                            result = false;
                        }
                    }
                }
            }
        }
    }


    public static void postOrder(Integer[] drzewo) {
        boolean result = true;
        boolean result2;
        int i = 0;
        while (result) {
            if (drzewo[2 * i + 1] != null) {
                i = 2 * i + 1;
            } else if (drzewo[2 * i + 2] != null) {
                i = 2 * i + 2;
            } else {
                System.out.println(drzewo[i]);
                result2 = true;
                while (result2) {
                    if (i % 2 == 1) {
                        if (drzewo[i + 1] != null) {
                            i = i + 1;
                            result2 = false;
                        } else {
                            i = (i - 1) / 2;
                            System.out.println(drzewo[i]);
                        }
                    } else {
                        i = (i - 1) / 2;
                        System.out.println(drzewo[i]);
                        if (i == 0) {
                            result2 = false;
                            result = false;
                        }
                    }
                }
            }
        }
    }

    public static Integer[] usuniecieMinimalnego(Integer[] drzewo) {
        int najmniejszy = 0;
        boolean result = true;
        boolean result2;
        int i = 0;
        while (result) {
            if (drzewo[2 * i + 1] != null) {
                i = 2 * i + 1;
            } else if (drzewo[2 * i + 2] != null) {
                i = 2 * i + 2;
            } else {
                if (drzewo[najmniejszy] > drzewo[i]) {
                    najmniejszy = i;
                }
                result2 = true;
                while (result2) {
                    if (i % 2 == 1) {
                        if (drzewo[i + 1] != null) {
                            i = i + 1;
                            result2 = false;
                        } else {
                            i = (i - 1) / 2;
                            if (drzewo[najmniejszy] > drzewo[i]) {
                                najmniejszy = i;
                            }
                            ;
                        }
                    } else {
                        i = (i - 1) / 2;
                        if (drzewo[najmniejszy] > drzewo[i]) {
                            najmniejszy = i;
                        }
                        ;
                        if (i == 0) {
                            result2 = false;
                            result = false;
                        }
                    }
                }
            }
        }
        Integer[] nowaTablica = new Integer[drzewo.length];
        for (int j = 0; j < drzewo.length; j++) {
            if (j != najmniejszy && drzewo[j] != null) {
                nowaTablica[j] = drzewo[j];
            }
        }
        return nowaTablica;
    }


}
