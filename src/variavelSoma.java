public class variavelSoma {
    public static void main (String[] args){
        int indice = 13;
        int soma = 0;
        int k = 0;

        while (k<indice){
            k=k+1;
            soma=soma+k;
        }

        System.out.println("valor final é: "+soma);
    }
}