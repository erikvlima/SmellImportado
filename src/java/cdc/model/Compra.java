package cdc.model;

/**
 *
 * @author erik
 */
public class Compra {
    
    private int idCompra;
    private float precoCompra;
    private float freteCompra;
    private int idUsuarioCompra;

    public Compra() {
    }

    public Compra(int idCompra, float precoCompra, float freteCompra, int idClienteCompra) {
        this.idCompra = idCompra;
        this.precoCompra = precoCompra;
        this.freteCompra = freteCompra;
        this.idUsuarioCompra = idClienteCompra;
    }

    public Compra(float precoCompra, float freteCompra) {
        this.precoCompra = precoCompra;
        this.freteCompra = freteCompra;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public float getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(float precoCompra) {
        this.precoCompra = precoCompra;
    }

    public float getFreteCompra() {
        return freteCompra;
    }

    public void setFreteCompra(float freteCompra) {
        this.freteCompra = freteCompra;
    }

    public int getIdUsuarioCompra() {
        return idUsuarioCompra;
    }

    public void setIdUsuarioCompra(int idUsuarioCompra) {
        this.idUsuarioCompra = idUsuarioCompra;
    }
    
    
    
}
