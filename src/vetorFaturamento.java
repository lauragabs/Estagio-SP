import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

class VetorFaturamento {
    int dia;
    double faturamento;

    public VetorFaturamento(int dia, double faturamento) {
        this.dia = dia;
        this.faturamento = faturamento;
    }

    public VetorFaturamento() {
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public double getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(double faturamento) {
        this.faturamento = faturamento;
    }
}

class Distribuidora {
    public static void main(String[] args) {
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader("src/faturamento.json");

            Type faturamentoListType = new TypeToken<ArrayList<VetorFaturamento>>(){}.getType();
            List<VetorFaturamento> faturamentoList = gson.fromJson(reader, faturamentoListType);

            reader.close();

            double menorFaturamento = Double.MAX_VALUE;
            double maiorFaturamento = Double.MIN_VALUE;
            double somaFaturamento = 0.0;
            int diasComFaturamento = 0;

            for (VetorFaturamento f : faturamentoList) {
                if (f.faturamento > 0) {
                    if (f.faturamento < menorFaturamento) {
                        menorFaturamento = f.faturamento;
                    }
                    if (f.faturamento > maiorFaturamento) {
                        maiorFaturamento = f.faturamento;
                    }
                    somaFaturamento += f.faturamento;
                    diasComFaturamento++;
                }
            }

            for (VetorFaturamento f : faturamentoList) {
                if (f.faturamento < menorFaturamento) {
                    menorFaturamento = f.faturamento;
                }
            }

            double mediaMensal = somaFaturamento / diasComFaturamento;

            int diasAcimaDaMedia = 0;
            for (VetorFaturamento f : faturamentoList) {
                if (f.faturamento > mediaMensal) {
                    diasAcimaDaMedia++;
                }
            }

            System.out.println("Menor faturamento: " + menorFaturamento);
            System.out.println("Maior faturamento: " + maiorFaturamento);
            System.out.println("Número de dias com faturamento superior à média mensal: " + diasAcimaDaMedia);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
