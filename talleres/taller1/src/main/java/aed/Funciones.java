package aed;

class Funciones {
    int cuadrado(int x) {
        return x * x;
    }

    double distancia(double x, double y) {
        return Math.sqrt(x * x + y * y) ;
    }

    boolean esPar(int n) {
        boolean res = n % 2 == 0 ? true : false; //ternary op ftw
        return res;

    }

    boolean esBisiesto(int n) {
        boolean res =  n % 4 == 0 ? (n % 100 != 0 ? true : (n % 400 == 0 ? true : false)) : false;
        return res;
    }

    int factorialIterativo(int n) {
        int res = 1; 
        for(int i = 1; i < n; n--){
            res = res * n;
        }
        return res;
    }

    int factorialRecursivo(int n){
        if (n == 0) return 1;
        return n * factorialRecursivo(n - 1);
    }

    boolean esPrimo(int n) {
        switch (n) {
            case 0:
            case 1:
                return false;
            case 2:
            case 3: 
                return true;
            default:
                if (n % 2 == 0 || n % 3 == 0) return false;
                for(int i = 5; i <= Math.floor(Math.sqrt(n)); i += 6){ //algebra 1 lore
                     if (n % i == 0 || (n % (i + 2)) == 0) return false;
                }
                break;
        }
        return true;
    }

    int sumatoria(int[] numeros) {
        int res = 0;
        for (int i = 0; i < numeros.length; i++){
            res += numeros[i];
        }
        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        for (int i = 0; i < numeros.length; i++){
            if (numeros[i] == buscado) return i; 
        }
        return 0;
    }

    boolean tienePrimo(int[] numeros) {
        for (int i = 0; i < numeros.length; i++){
            if (esPrimo(numeros[i]) == true) return true;
        }
        return false;
    }

    boolean todosPares(int[] numeros) {
        for (int i = 0; i < numeros.length; i++){
            if (esPar(numeros[i]) == false) return false;
        }
        return true;
    }

    boolean esPrefijo(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        char arr1[s1.length];
        
        for (int i = 0; i < s1.length(); i++){
            arr1[i] = s1[i];
        }
        for (int i = 0; i < s1.length(); i++){
            if (s1[i] != s2[i]) return false;
        }
        return false;
    }

    boolean esSufijo(String s1, String s2) {
        // COMPLETAR
        return false;
    }
}
