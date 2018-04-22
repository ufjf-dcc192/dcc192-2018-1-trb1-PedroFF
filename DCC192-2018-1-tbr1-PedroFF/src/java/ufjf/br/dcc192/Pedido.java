
package ufjf.br.dcc192;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javafx.util.converter.LocalDateTimeStringConverter;


public class Pedido {
    private LocalTime horaAbertura = LocalTime.now();
    private String horaAbriu;
    private String horaFechou;
    private LocalTime horaFechamento;
    private int numPedido = 0;
    private List<Produto> itens;
    private String descricao;
    private boolean conta; // enquanto for true, podem ser adicionados mais itens ao pedido.
    private double valorFinal;
    
    public Pedido() {
        this.numPedido = numPedido++;
        horaAbriu = horaAbertura.toString();
        this.descricao = "Descrição do Pedido";
        this.conta = true;
    }
    

    public List<Produto> getProduto() {
        return itens;
    }

    public void setItens(List<Produto> itens) {
        this.itens = itens;
    }

    public boolean getConta() {
        return conta;
    }

    public void setConta(boolean conta) {
        this.conta = conta;
    }

    public LocalTime getHoraAbertura() {
        return horaAbertura;
    }

    public LocalTime getHoraFechamento() {
        return horaFechamento;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setHoraFechamento(LocalTime horaFechamento) {
        this.horaFechamento = horaFechamento;
    }
    
    
    @Override
    public String toString() {
        if (this.conta == false){ 
            
            return "Pedido "+this.numPedido+ " || Hora de Abertura: " + this.horaAbriu + " || Hora que Fechou: " +horaFechamento.toString();
            
        }else{
            return "Pedido "+this.numPedido+ " || Hora de Abertura: " + this.horaAbriu;
        }
    }

    public double getValorFinal() {
        return valorFinal;
    }

    private void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }
    
    void acrescentaFinal(Double preco, Pedido p1){
        p1.setValorFinal(p1.getValorFinal() + preco);
    }
}

