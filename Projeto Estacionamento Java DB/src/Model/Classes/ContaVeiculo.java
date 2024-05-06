/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Classes;

import java.util.Calendar;

/**
 *
 * @author Gesley Rosa
 */
public class ContaVeiculo {
    private Integer id;
    private String placa_veiculo;
    private Calendar data_entrada;
    private Calendar data_saida;

    public ContaVeiculo() {
    }
    
    public ContaVeiculo(Integer id, String placa_veiculo, Calendar data_entrada, Calendar data_saida) {
        this.id = id;
        this.placa_veiculo = placa_veiculo;
        this.data_entrada = data_entrada;
        this.data_saida = data_saida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca_veiculo() {
        return placa_veiculo;
    }

    public void setPlaca_veiculo(String placa_veiculo) {
        this.placa_veiculo = placa_veiculo;
    }

    public Calendar getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Calendar data_entrada) {
        this.data_entrada = data_entrada;
    }

    public Calendar getData_saida() {
        return data_saida;
    }

    public void setData_saida(Calendar data_saida) {
        this.data_saida = data_saida;
    }
    
    @Override
    public String toString() {
        return "id=" + id + ", placa_veiculo=" + placa_veiculo + ", data_entrada=" + data_entrada + ", data_saida=" + data_saida;
    }
   
}
