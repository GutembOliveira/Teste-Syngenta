import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class testeTaxaHoteis {

    public static void main(String[] args) {

        Hotel hotel1 = new Hotel(3, 110.0, 80.0, 80.0, 90.0, "Lakewood");
        Hotel hotel2 = new Hotel(4, 160.0, 110.0, 60.0, 50.0, "Bridgewood");
        Hotel hotel3 = new Hotel(5, 220.0, 100.0, 150.0, 40.0, "Ridgewood");
        List<Date> datas = new LinkedList<Date>();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(" ______________________________________________________\n");
            System.out.println("|                    Hotéis Disponiveis              ");
            System.out.println("|\n|\n|Calculo da estadia mais barata\n");
            System.out.println("|Qual o tipo de cliente?\n|[1]-Regular\n|[2]-Reward");
            int cliente = scanner.nextInt();
            int opcao = 0;
            while (opcao != 2) {
                System.out.println("[1]-Inserir data-------------  Numero de datas adicionadas:" + datas.size());
                System.out.println("[2]-Calcular estadia");
                System.out.println("[3]-Mudar o tipo de cliente");
                opcao = scanner.nextInt();
                scanner.nextLine();

                if (opcao == 1) {
                    try {
                        System.out.println("Digite uma data a ser inserida\n");
                        String tempData = scanner.nextLine();
                        System.out.println("\n" + tempData + "\n");

                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        Date date = new SimpleDateFormat("dd/mm/yyyy")
                                .parse(tempData);
                        formato.format(date);
                        System.out.println("Data Inserida: " + formato.format(date));
                        datas.add(date);
                    } catch (ParseException exc) {
                        System.out.println("data informada em formato errado!");
                    }
                }
                if (opcao == 3) {
                    System.out.println("|Qual o tipo de cliente?\n|[1]-Regular\n|[2]-Reward");
                    cliente = scanner.nextInt();
                }
            }
            String maisBarato = CalculaMenorValor(hotel1, hotel2, hotel3, datas, cliente);
            System.out.println("A estadia mais barata é em: " + maisBarato);
        }
    }

    public static String CalculaMenorValor(Hotel h1, Hotel h2, Hotel h3, List<Date> datas, int tipoCliente) {
        h1.CalculaEstadia(tipoCliente, datas);
        h2.CalculaEstadia(tipoCliente, datas);
        h3.CalculaEstadia(tipoCliente, datas);
        Hotel maisBarato = h1;
        if (h2.valorEstadia < maisBarato.valorEstadia)
            maisBarato = h2;
        else if (h2.valorEstadia == maisBarato.valorEstadia) {
            if (h2.classificacao > maisBarato.classificacao)
                maisBarato = h2;
        }

        if (h3.valorEstadia < maisBarato.valorEstadia)
            maisBarato = h3;
        else if (h3.valorEstadia == maisBarato.valorEstadia) {
            if (h3.classificacao > maisBarato.classificacao)
                maisBarato = h3;
        }
        return maisBarato.nome + "Pelo preço de: " + "R$" + maisBarato.valorEstadia;
    }

}
