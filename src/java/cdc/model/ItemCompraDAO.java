package cdc.model;

import cdc.util.ConnectionDAO;
import cdc.util.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author erik
 */
public class ItemCompraDAO implements DAO {

    Connection conn;

    public ItemCompraDAO() {
        try {
            this.conn = ConnectionDAO.getConnection();
        } catch (Exception e) {
        }
    }

    @Override
    public void atualizar(Object ob) throws Exception {
        ItemCompra ic = (ItemCompra) ob;
        PreparedStatement ps = null;
        Connection conn = null;

        if (ic == null) {
            throw new Exception("O valor passado não pode ser nulo!");
        }
        try {
            String sql = "update ItemCompra set idCompraItemCompra = ?, idProdutoItemCompra = ? where idItemCompra = ?";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            //ps.setInt(1, ic.getIdCompraItemCompra());
            ps.setInt(2, ic.getIdProdutoItemCompra());
            ps.setInt(3, ic.getIdItemCompra());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    @Override
    public void excluir(Object ob) throws Exception {
        ItemCompra ic = (ItemCompra) ob;
        PreparedStatement ps = null;
        Connection conn = null;

        if (ic == null) {
            throw new Exception("O valor passado não pode ser nulo!");
        }
        try {
            String sql = "delete from ItemCompra where idItemCompra = ?";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ic.getIdItemCompra());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    @Override
    public List listaTodos() throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = this.conn;
            ps = conn.prepareStatement("select * from ItemCompra");
            rs = ps.executeQuery();
            List<ItemCompra> list = new ArrayList<ItemCompra>();
            while (rs.next()) {
                //list.add(new ItemCompra(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
            }
            return list;
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    @Override
    public List procura(Object ob) throws Exception {
        return null;
    }

    @Override
    public void salvar(Object ob) throws Exception {
        ItemCompra ic = (ItemCompra) ob;
        Connection conn = null;
        PreparedStatement ps = null;

        if (ic == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }

        try {
            String sql = "insert into ItemCompra (idProdutoItemCompra, idUsuarioItemCompra) values (?,?)";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ic.getIdProdutoItemCompra());
            ps.setInt(2, ic.getIdUsuarioItemCompra());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public void salvarProdutoNoCarrinho(String idPro, String idUsu) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;

        if (idPro == null || idUsu == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }

        try {
            String sql = "insert into ItemCompra (idProdutoItemCompra, idUsuarioItemCompra) values (?,?)";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setString(1, idPro);
            ps.setString(2, idUsu);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public void excluirPromo(int id) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;

        if (id == 0) {
            throw new Exception("O valor passado não pode ser nulo!");
        }

        try {
            String sql = "delete from ItemCompra where idProdutoItemCompra = ?";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public List listaIntemDoCarrinho(String idUsu) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT * "
                    + "FROM  ItemCompra "
                    + "INNER JOIN Produto "
                    + "ON (ItemCompra.idProdutoItemCompra = Produto.idProduto) "
                    + "INNER JOIN ImagemDeProduto "
                    + "ON (ImagemDeProduto.idProduto = Produto.idProduto) "
                    + "WHERE ItemCompra.idUsuarioItemCompra= '" + idUsu + "'"
                    + "ORDER BY `ItemCompra`.`idItemCompra` ASC");
            rs = ps.executeQuery();

            List list = new ArrayList();
            while (rs.next()) {
                list.add(new ItemCompra(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getFloat(6), rs.getString(7),
                        rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getString(11),
                        rs.getString(12), rs.getString(13), rs.getInt(14)));
            }
            return list;
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public void excluirDocarrinho(String idItemCompra) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;

        if (idItemCompra == null) {
            throw new Exception("O valor passado não pode ser nulo!");
        }
        try {
            String sql = "delete from ItemCompra where idProdutoItemCompra = '" + idItemCompra + "'";
            conn = this.conn;
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public List somaPrecoItensCarrinho(String idUsuario) throws Exception{
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = this.conn;

            ps = conn.prepareStatement("SELECT SUM(Produto.precoProduto) FROM ItemCompra INNER JOIN Produto "
                    + "ON (ItemCompra.idProdutoItemCompra = Produto.idProduto) INNER JOIN ImagemDeProduto "
                    + "ON (ImagemDeProduto.idProduto = Produto.idProduto) "
                    + "WHERE ItemCompra.idUsuarioItemCompra= "+idUsuario);

            rs = ps.executeQuery();
            
            List list = new ArrayList();
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            return list;
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }
}
