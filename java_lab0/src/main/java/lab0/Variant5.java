package lab0;

public class Variant5 {

    public static int[] iftask(int a, int b, int c){
        int[] res =  new int[2] ;

        if (a > 0)
            res[0] += 1;
        else res[1] += 1;

        if (b > 0)
            res[0] += 1;
        else res[1] += 1;

        if (c > 0)
            res[0] += 1;
        else res[1] += 1;
        return res;
    }

    //    Дано целое число N (> 0), являющееся некоторой степенью числа 2: N = 2K. Найти целое число K — показатель этой степени.
    public static int whiletask(int n){
        if(n < 0){
            throw new IllegalArgumentException("n > 0");
        }
        int k = 0;
        while (n >= 2){
            ++k;
            n/=2;
        }
        return k;
    }

//    Даны целые положительные числа M, N, число D и набор из M чисел. Сформировать матрицу размера M ґ N,
//    у которой первый столбец совпадает с исходным набором чисел, а элементы каждого следующего столбца
//    равны сумме соответствующего элемента предыдущего столбца и числа D (в результате каждая строка
//    матрицы будет содержать элементы арифметической прогрессии).

    public static int[][] matrixtask(int [] array, int n, int m, int d){
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++){
            matrix[i][0] = array[i];
        }

        for(int i = 0;i < m;++i){
            for(int j=1; j < n ;++j){
                matrix[i][j] = matrix[i][j-1] + d;
            }
        }
        return matrix;
    }
//
//
    public static int inttask(int a, int b){
        if(b > a){
            throw new IllegalArgumentException("a > b");
        }
        return a % b;
    }
//
//
    //      Дано вещественное число — цена 1 кг конфет. Вывести стоимость 0.1, 0.2, … , 1 кг конфет.
    public static double[] fortask(double c){
        double[] res =  new double[10];
        double m;
        int i = 0;
        for(m = 0.1; m < 1.1;  m += 0.1){
            res[i] = c * m;
            i++;
        }
        return  res;
    }

//
//
    //    Арифметические действия над числами пронумерованы следующим образом: 1 — сложение, 2 — вычитание, 3 — умножение, 4 — деление.
//    Дан номер действия N (целое число в диапазоне 1–4) и вещественные числа A и B (В не равно 0). Выполнить над
//    числами указанное действие и вывести результат.
    public static double casetask(int n, double a, double b){
        if(!(n > 0 && n < 5)){
            throw new IllegalArgumentException("n > 0 and n <= 4");
        }
        if((int)b == 0){
            throw new IllegalArgumentException("b =! 0");
        }
        double res = 0;
        switch (n) {
            case 1:
                res = a+b;
                break;
            case 2:
                res = a-b;
                break;
            case 3:
                res = a*b;
                break;
            case 4:
                res = a/b;
                break;
        }
        return res;
    }
//
//
    //Даны два целых числа: A, B. Проверить истинность высказывания: «Справедливы неравенства A і 0 или B < –2».
    public static boolean booltask(int a, int b){
        if(a >= 0 && b < -2) return true;
        else return false;
    }
//

    //     Дано целое число N (> 2). Сформировать и вывести целочисленный массив размера N, содержащий N
//     первых элементов последовательности чисел Фибоначчи FK:
//
//F1 = 1,        F2 = 1,        FK = FK–2 + FK–1,    K = 3, 4, … .
    public static int[] arraytask(int n){
        if(n < 2){
            throw new IllegalArgumentException("n > 2");
        }
        int[] arr =  new int[n];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < n; i++){
            arr[i] = arr[i-1] + arr[i - 2];
        }
        return arr;
    }

}