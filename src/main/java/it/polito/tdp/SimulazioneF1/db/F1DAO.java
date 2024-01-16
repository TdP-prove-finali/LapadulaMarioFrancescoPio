package it.polito.tdp.SimulazioneF1.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import it.polito.tdp.SimulazioneF1.model.*;



public class F1DAO {
	
	TreeMap<Integer, Scuderia> IdMapScuderie;
	TreeMap<Integer, Track> IdMapTracks;
	
	public HashMap<Integer, Scuderia> getAllScuderia(){
		
		final String sql = "SELECT * FROM costructors";
		
		HashMap<Integer, Scuderia> result = new HashMap<Integer, Scuderia>();
		this.IdMapScuderie = new TreeMap<Integer, Scuderia>();
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				Scuderia s = new Scuderia(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9), rs.getDouble(10), rs.getDouble(11), rs.getDouble(12), rs.getDouble(13), rs.getDouble(14), rs.getDouble(15));
				result.put(s.getId(), s);
			}
			
		conn.close();
		this.IdMapScuderie.putAll(result);
		return result;

		}catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public HashMap<Integer, Pilota> getAllPiloti(){
		
		final String sql = "SELECT * FROM drivers";
		
		HashMap<Integer, Pilota> result = new HashMap<Integer, Pilota>();
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				Pilota p = new Pilota(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(8), rs.getDouble(9), rs.getDouble(10), rs.getDouble(11), rs.getDouble(12), rs.getDouble(13), rs.getDouble(14), rs.getDouble(15),rs.getDouble(16));
				int scuderiaid = rs.getInt(5);
				Scuderia s = this.IdMapScuderie.get(scuderiaid);
				p.setS(s);
				result.put(p.getID(), p);				
			}
			
		conn.close();
		return result;

		}catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public HashMap<Integer, Track> getAllTracks(){
		
		final String sql = "SELECT * FROM tracks";
		
		HashMap<Integer, Track> result = new HashMap<Integer, Track>();
		this.IdMapTracks = new TreeMap<>();
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				Track t = new Track(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9), rs.getDouble(10), rs.getDouble(11), rs.getDouble(12), rs.getInt(13), rs.getDouble(14), rs.getInt(15));
				result.put(t.getId(),t);
			}
			
		conn.close();
		this.IdMapTracks.putAll(result);
		return result;

		}catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//calcolo indici di sorpasso per ogni circuito andando a moltiplicarli per un coefficiente di aggiustamento
	public void getIndiciSorpasso() {
		
		for(Track t : this.IdMapTracks.values()) {
			
			String sql = "SELECT SUM(v.t) / (SELECT COUNT(*) "
					+ "FROM overtake "
					+ "WHERE overtake.?<>0) "
					+ "FROM (SELECT overtake.?/Totale AS t "
					+ "FROM overtake "
					+ "GROUP BY Anno) AS v";
			
			try {
				Connection conn = DBConnect.getConnection();
				PreparedStatement st = conn.prepareStatement(sql);
				st.setInt(1, t.getId());
				st.setInt(2, t.getId());
				ResultSet rs = st.executeQuery();
				
				while (rs.next()) {
					t.setOverI(rs.getDouble(1)*8.225);
				}
				
			conn.close();

			}catch (SQLException e) {

				e.printStackTrace();
				throw new RuntimeException(e);
			}
			
		}
	}

}
