package model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import useful.PriceUseful;

public class Package {

    private final String local;
    private final String imagem;
    private final int dias;
    private final BigDecimal preco;

    public Package(String local, String imagem, int dias, BigDecimal preco) {
        this.local = local;
        this.imagem = imagem;
        this.dias = dias;
        this.preco = preco;
    }

    public String getLocal() {
        return local;
    }

    public String getImagem() {
        return imagem;
    }

    public int getDias() {
        return dias;
    }

   public String getPreco() {
       return PriceUseful.putPrice(preco);

    }

}