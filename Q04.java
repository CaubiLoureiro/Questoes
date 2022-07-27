import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Q04 {

    private static HashMap<String, Float> leitor(String fileName) throws IOException {
        float faturamento;
        String estado, linha;

        BufferedReader buff = new BufferedReader(new FileReader(fileName));
        HashMap<String, Float> dic = new HashMap<String, Float>();

        while (true) {
            linha = buff.readLine();

            if (linha != null) {

                faturamento = Float.parseFloat(linha.split(" R\\$")[1].replace(".", "").replace(",", "."));
                estado = linha.split(" ")[0];
                dic.put(estado, faturamento);

            } else {
                break;
            }
        }
        buff.close();
        return dic;
    }


    private static float total(HashMap<String, Float> dic){
        float total = 0;
        Set<String> chaves = dic.keySet();
        for(String chave : chaves){
            total += dic.get(chave);
        }

        return total;
    }


    private static HashMap<String, Float> percentual(HashMap<String, Float> dic, float total){
        HashMap<String, Float> percentuais = new HashMap<String, Float>();

        dic.forEach((key, value)->percentuais.put(key, dic.get(key)*100 / total));

        return percentuais;
    }


    private static void printPercentual(HashMap<String, Float> percentuais){

        percentuais.forEach((key, value)->System.out.printf("%s: %.2f%s\n", key, value, "%"));

    }


    public static void main( String args[]){
        float total;
        HashMap<String, Float> dic, percentuais;
        final String nameFile = "ArquivosEntrada/FaturamentoMensal.txt";

        try {
            dic = leitor(nameFile);
            total = total(dic);
            percentuais = percentual(dic, total);
            printPercentual(percentuais);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}

