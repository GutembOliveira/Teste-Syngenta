import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Hotel {
    public double valorEstadia;
    public int classificacao;
    public double taxaSemNormal;
    public double taxaFimNormal;
    public double taxaSemFidelidade;
    public double taxaFimFidelidade;
    public String nome;

    public Hotel() {
    }

    public Hotel(int classificacao, double taxaSemNormal,
            double taxaSemFidelidade,
            double taxaFimFidelidade,
            double taxaFimNormal,
            String Nome) {
        this.classificacao = classificacao;
        this.taxaSemNormal = taxaSemNormal;
        this.taxaFimNormal = taxaFimNormal;
        this.taxaSemFidelidade = taxaSemFidelidade;
        this.taxaFimFidelidade = taxaFimFidelidade;
        this.nome = Nome;

    }

    public void get() {

    }

    public float CalculaEstadia(int tipoCliente, List<Date> datas) {
        float valorTotal = 0;

        for (Date dia : datas) {

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dia);
            int diaDaSemana = calendar.get(Calendar.DAY_OF_WEEK);
            if (tipoCliente == 1) {
                if ((diaDaSemana != 6) && (diaDaSemana != 7))
                    valorTotal += taxaSemNormal;
                else
                    valorTotal += taxaFimNormal;
            }
            if (tipoCliente == 2) {
                if ((diaDaSemana != 6) && (diaDaSemana != 7))
                    valorTotal += taxaSemFidelidade;
                else
                    valorTotal += taxaFimFidelidade;
            }
        }
        this.valorEstadia = valorTotal;
        return valorTotal;
    }

}
