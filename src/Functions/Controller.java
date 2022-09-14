package Functions;
import Table.Table;

import java.util.Scanner;


public class Controller {


    public static void entrada(){

        String tabelaObjetivo[][];
        String tabelaEmbaralhada[][];
        Object [] retorno;
        boolean y;

        y = false;
        tabelaObjetivo = Table.gerarTabela();

        System.out.println("Tabela objetivo:");
        Exibi.exibirTabela(tabelaObjetivo);
        System.out.println("\n");


        tabelaEmbaralhada = Embaralha.embaralhar(tabelaObjetivo);

        while(y == false){
            System.out.println("Tabela embaralhada:");
            Exibi.exibirTabela(tabelaEmbaralhada);
            System.out.println("\n");

            Scanner s = new Scanner(System.in);
            System.out.println("Inserir numero: \n");
            String i = s.next();

            retorno = jogar(i, tabelaEmbaralhada);
            if((boolean) retorno[1] == true){
                System.out.println("Você chegou ao objetivo! \n");
                Exibi.exibirTabela((String[][]) retorno[0]);
                y = true;
            }else{
                y = (boolean) retorno[1];
                tabelaEmbaralhada = (String[][]) retorno[0];
            }

        }

    }

    public static Object [] jogar(String insert, String tabelaEmbaralhada[][]){
        int [] index  = Busca.buscarIndexEspaco(tabelaEmbaralhada);
        boolean resultado = Verificador.verificarSeGanhou(tabelaEmbaralhada);
        String [][] arrayModificado = Movimentar.mover(insert, index, tabelaEmbaralhada);
        Object[] retorno = new Object[2];

        if(resultado == false){
            retorno[0] = arrayModificado;
            retorno[1] = false;
            return retorno;
        }else{
            retorno[0] = arrayModificado;
            retorno[1] = true;
            return retorno;
        }

    }

}
