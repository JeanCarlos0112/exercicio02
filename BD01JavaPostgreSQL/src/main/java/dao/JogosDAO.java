package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Jogos;

public class JogosDAO extends DAO {
	
	public JogosDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}
	
	
	public boolean insert(Jogos jogos) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO jogos (codigo, nome, empresa, quantidade) "
				       + "VALUES ("+jogos.getCodigo()+ ", '" + jogos.getNome() + "', '"  
				       + jogos.getEmpresa() + "', '" + jogos.getQuantidade() + "');";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	
	public Jogos get(int codigo) {
	    Jogos jogo = null;
	    
	    try {
	        Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	        String sql = "SELECT * FROM jogos WHERE codigo=" + codigo;
	        System.out.println(sql);
	        ResultSet rs = st.executeQuery(sql);    
	        if (rs.next()) {            
	            jogo = new Jogos(rs.getInt("codigo"), rs.getString("nome"), rs.getString("empresa"), rs.getInt("quantidade"));
	        }
	        st.close();
	    } catch (Exception e) {
	        System.err.println(e.getMessage());
	    }
	    return jogo;
	}
	
	
	public List<Jogos> get() {
		return get("");
	}

	
	public List<Jogos> getOrderByCodigo() {
		return get("codigo");		
	}
	
	
	public List<Jogos> getOrderByNome() {
		return get("nome");		
	}
	
	
	public List<Jogos> getOrderByEmpresa() {
		return get("empresa");		
	}
	
	
	private List<Jogos> get(String orderBy) {	
	
		List<Jogos> jogos = new ArrayList<Jogos>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM jogos" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Jogos u = new Jogos(rs.getInt("codigo"), rs.getString("nome"), rs.getString("empresa"), rs.getInt("quantidade"));
	        	jogos.add(u);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return jogos;
	}


	public List<Jogos> getQuantidade() {
	    List<Jogos> jogos = new ArrayList<Jogos>();
	    
	    try {
	        Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	        String sql = "SELECT * FROM jogos WHERE quantidade >= 150";
	        System.out.println(sql);
	        ResultSet rs = st.executeQuery(sql);               
	        while (rs.next()) {                    
	            Jogos u = new Jogos(rs.getInt("codigo"), rs.getString("nome"), rs.getString("empresa"), rs.getInt("quantidade"));
	            jogos.add(u);
	        }
	        st.close();
	    } catch (Exception e) {
	        System.err.println(e.getMessage());
	    }
	    return jogos;
	}
	
	
	public boolean update(Jogos jogos) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE jogos SET nome = '" + jogos.getNome() + "', empresa = '"  
				       + jogos.getEmpresa() + "', quantidade = '" + jogos.getQuantidade() + "'"
					   + " WHERE codigo = " + jogos.getCodigo();
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean delete(int codigo) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM jogos WHERE codigo = " + codigo;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
}