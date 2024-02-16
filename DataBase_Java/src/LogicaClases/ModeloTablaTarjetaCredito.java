/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicaClases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import poo_gestiontarjetascredito.Movimiento;
import poo_gestiontarjetascredito.TarjetaCredito;

public class ModeloTablaTarjetaCredito extends AbstractTableModel implements Serializable {

    private ArrayList<TarjetaCredito> listaTarjeta = new ArrayList<>();
    private String[] nombreColumnas = {"Indice", "Numero Tarjeta", "Titular", "NIF", "Limite"};

    public boolean añadirTarjetaCredito(TarjetaCredito tarjeta) {
        boolean esAñadido = false;
        if (!this.listaTarjeta.contains(tarjeta)) {
            this.listaTarjeta.add(new TarjetaCredito(tarjeta));
            esAñadido = true;
        }
        return esAñadido;
    }

    public void añadirTarjetasArrayList(ArrayList<TarjetaCredito> tarjeta) {
        for (int i = 0; i < tarjeta.size(); i++) {
            this.añadirTarjetaCredito(tarjeta.get(i));
        }
    }

    public void añadirTarjetasList(List<TarjetaCredito> tarjeta) {
        for (int i = 0; i < tarjeta.size(); i++) {
            this.añadirTarjetaCredito(tarjeta.get(i));
        }
    }

    public boolean eliminarTarjetaCredito(int indice) {
        boolean esEliminado = false;
        if (indice >= 0 && indice < this.listaTarjeta.size()) {
            this.listaTarjeta.remove(indice);
            esEliminado = true;
        }
        return esEliminado;
    }

    public TarjetaCredito getTarjeta(int indice) {
        TarjetaCredito tarjeta = null;
        if (indice >= 0 && indice < this.listaTarjeta.size()) {
            tarjeta = this.listaTarjeta.get(indice);
        }
        return tarjeta;
    }

    public boolean setPin(int indice, String Pin) {
        boolean esModificado = false;
        if (Funciones.Funciones.ValidarNumeroPin(Pin) && indice >= 0 && indice < this.listaTarjeta.size()) {
            this.listaTarjeta.get(indice).setPin(Pin);
            esModificado = true;
        }
        return esModificado;
    }

    public boolean realizarPago(int indice, double cantidad, String concepto) {
        boolean esPagado = false;
        if (indice >= 0 && indice <= this.listaTarjeta.size()) {
            if (cantidad > 0 && !concepto.isBlank()) {
                if (this.listaTarjeta.get(indice).pagar(cantidad, concepto)) {
                    esPagado = true;
                }
            }
        }
        return esPagado;
    }

    public double gastoTarjeta(int indice) {
        double gasto = 0;
        if (indice >= 0 && indice < this.listaTarjeta.size()) {
            gasto = this.listaTarjeta.get(indice).gastado();
        }
        return gasto;
    }

    public double gastoTotal() {
        double gastoTotal = 0;
        for (int i = 0; i < this.listaTarjeta.size(); i++) {
            gastoTotal += this.listaTarjeta.get(i).gastado();
        }
        return gastoTotal;
    }

    public String movimientosTarjeta(int indice, int numeroMovimientos) {
        String movimiento = "";
        ArrayList<Movimiento> lista = new ArrayList<>();
        if (indice >= 0 && indice < this.listaTarjeta.size()) {
            int cantidadMovimientos = this.listaTarjeta.get(indice).numeroMovimientos();
            if (numeroMovimientos <= cantidadMovimientos) {
                lista = this.listaTarjeta.get(indice).movimientos(numeroMovimientos);
                for (int i = 0; i < lista.size(); i++) {
                    movimiento = movimiento + lista.get(i);
                }
            }
        }
        return movimiento;
    }

    public boolean existeIndice(int fila) {
        return fila >= 0 && fila < this.listaTarjeta.size();
    }

    @Override
    public int getRowCount() {
        return this.listaTarjeta.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int index) {
        return this.nombreColumnas[index];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TarjetaCredito tarjeta = this.listaTarjeta.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0 -> {
                value = rowIndex;
            }
            case 1 -> {
                value = tarjeta.getNumeroTarjeta();
            }
            case 2 -> {
                value = tarjeta.getTitular();
            }
            case 3 -> {
                value = tarjeta.getNif();
            }
            case 4 -> {
                value = tarjeta.getLimite();
            }
        }
        return value;
    }

}
