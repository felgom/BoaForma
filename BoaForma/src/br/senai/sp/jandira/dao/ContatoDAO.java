package br.senai.sp.jandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.senai.sp.jandira.dbUtils.Conexao;
import br.senai.sp.jandira.model.Cliente;

public class ContatoDAO {
	private Cliente cliente;
	private PreparedStatement stm;
	private ResultSet rs;
	
	public void gravar(){
		String sql = "INSERT INTO Academia(nome, dtNasc, peso, altura, nvAtividade, imc, tmb, fcm, sexo)"
				+ "VALUES(?, ? , ?, ?, ?, ?, ?, ?, ?)";
		
		
		stm = null;
		
		try {
			stm = Conexao.abrirConexao().prepareStatement(sql);
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getDtNasc());
			stm.setInt(3, cliente.getPeso());
			stm.setInt(4, cliente.getAltura());
			stm.setString(5, cliente.getNivelAtividade());
			stm.setDouble(6, cliente.getImc());
			stm.setDouble(7, cliente.getTmb());
			stm.setDouble(8, cliente.getFcm());
			stm.setString(9, cliente.getSexo());
			stm.execute();
			
			JOptionPane.showMessageDialog(null, "Contato gravado com sucelso", "Gravação", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
				
	}

	public void atualizar(int id){
		String sql = "UPDATE Academia SET nome = ?, dtNasc = ?, peso = ?, altura = ?, nvAtividade = ?, imc = ?, tmb = ? WHERE id = ?";
		
		
		stm = null;
		
		try {
			stm = Conexao.abrirConexao().prepareStatement(sql);
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getDtNasc());
			stm.setDouble(3, cliente.getPeso());
			stm.setDouble(4, cliente.getAltura());
			stm.setString(5, cliente.getNivelAtividade());
			stm.setDouble(6, cliente.getImc());
			stm.setDouble(7, cliente.getTmb());
			stm.setDouble(8, cliente.getFcm());
			stm.setString(9, cliente.getSexo());
			stm.execute();
			
			JOptionPane.showMessageDialog(null, "Contato editado com sucelso", "Edição", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void excluir(int id){
		String sql = "DELETE FROM Academia WHERE id = ?";
		
		
		stm = null;
		
		try {
			stm = Conexao.abrirConexao().prepareStatement(sql);
			stm.setInt(1, id);
			
			stm.execute();
			
			JOptionPane.showMessageDialog(null, "Contato deletado com sucelso", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public Cliente getCliente(int id){
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		cliente = new Cliente();
		String sql ="SELECT * FROM contatos WHERE id = ?";
		try{
			stm = Conexao.abrirConexao().prepareStatement(sql);
			stm.setInt(1, id);
			rs = stm.executeQuery();
			rs.next();
			cliente = new Cliente();
			cliente.setId(rs.getInt("id"));
			cliente.setNome(rs.getString("nome"));
			cliente.setDtNasc(df.format(rs.getString("dtNasc")));
			cliente.setPeso(rs.getInt("peso"));
			cliente.setAltura(rs.getInt("altura"));
			cliente.setNivelAtividade(rs.getString("nvAtividade"));
			cliente.setImc(rs.getDouble("imc"));
			cliente.setFcm(rs.getDouble("fcm"));
			cliente.setTmb(rs.getDouble("tmb"));
			cliente.setSexo(rs.getString("sexo"));
			
			stm = Conexao.abrirConexao().prepareStatement(sql);
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getDtNasc());
			stm.setDouble(3, cliente.getPeso());
			stm.setDouble(4, cliente.getAltura());
			stm.setString(5, cliente.getNivelAtividade());
			stm.setDouble(6, cliente.getImc());
			stm.setDouble(7, cliente.getTmb());
			stm.setDouble(8, cliente.getFcm());
			stm.setString(9, cliente.getSexo());
			stm.execute();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		return cliente;
	}
	public ArrayList<Cliente> getClientes(){
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		String sql = "SELECT * FROM contatos ORDER BY nome";
		
		stm = null;	
		rs= null;
		
		try{
			stm = Conexao.abrirConexao().prepareStatement(sql);
			rs = stm.executeQuery();
			
			while(rs.next()){
				cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setDtNasc(rs.getString("dtNasc"));
				cliente.setPeso(rs.getInt("peso"));
				cliente.setAltura(rs.getInt("altura"));
				cliente.setNivelAtividade(rs.getString("nvAtividade"));
				cliente.setImc(rs.getDouble("imc"));
				cliente.setFcm(rs.getDouble("fcm"));
				cliente.setTmb(rs.getDouble("tmb"));
				cliente.setSexo(rs.getString("sexo"));
				
				clientes.add(cliente);
			}
			Conexao.abrirConexao().close();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
				
		return clientes;
		
	}
	public void setContato(Cliente contato) {
		this.cliente = contato;
	}
	
}
