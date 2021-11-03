package com.javaGG.springMVCBoard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.spi.DirStateFactory.Result;
import javax.sql.DataSource;

import com.javaGG.springMVCBoard.dto.BDto;

public class BDao {	
	
	DataSource dataSource;
	
	public BDao() {
		// super();
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<BDto> list(){
		
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			String query = "select * from smvc_board order by bGroup desc, bStep";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				
				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				dtos.add(dto);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dtos;
	}
	
	public void write(String bName, String bTitle, String bContent) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String query="insert into smvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (smvc_board_seq.nextval, ?, ?, ?, 0, smvc_board_seq.currval, 0, 0 )";
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			
			int rn = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				try {
					if(pstmt != null) pstmt.cancel();
					if(conn != null) conn.close();
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		}
	}
	
	public BDto contentView(String strID) {
        
        BDto dto = new BDto();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
        conn = dataSource.getConnection();
        String query = "select * from smvc_board where bId = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, Integer.parseInt(strID));
        rs = (ResultSet) pstmt.executeQuery();
        
        while (rs.next()) {
           int bId = rs.getInt("bId");
           String bName = rs.getString("bName");
           String bTitle = rs.getString("bTitle");
           String bContent = rs.getString("bContent");
           Timestamp bDate = rs.getTimestamp("bDate");
           int bHit = rs.getInt("bHit");
           int bGroup = rs.getInt("bGroup");
           int bStep = rs.getInt("bStep");
           int bIndent = rs.getInt("bIndent");
           
           dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);           
        }      
        
     } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
     } finally {
    	 
    	 try {
    		 if(rs != null) rs.close(); 
        	 if(pstmt != null) pstmt.close();
             if(conn != null) conn.close();
    	 } catch (Exception e2) {
                 // TODO Auto-generated catch block
                 e2.printStackTrace();
    	 }
     }
        return dto;
	}
	
	public void modify(String bId, String bName, String bTitle, String bContent) {
		
	}
	
	public void delete(String bId) {
		
	}
	
	public BDto reply_View(String strID) {
		
		BDto dto = new BDto();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
        conn = dataSource.getConnection();
        String query = "select * from smvc_board where bId = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, Integer.parseInt(strID));
        rs = (ResultSet) pstmt.executeQuery();
        
        while (rs.next()) {
           int bId = rs.getInt("bId");
           String bName = rs.getString("bName");
           String bTitle = rs.getString("bTitle");
           String bContent = rs.getString("bContent");
           Timestamp bDate = rs.getTimestamp("bDate");
           int bHit = rs.getInt("bHit");
           int bGroup = rs.getInt("bGroup");
           int bStep = rs.getInt("bStep");
           int bIndent = rs.getInt("bIndent");
           
           dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);           
        }      
        
     } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
     } finally {
           try {        	   
        	   if(rs != null) rs.close(); 
        	   if(pstmt != null) pstmt.close();
               if(conn != null) conn.close();
           } catch (Exception e2) {
                 // TODO Auto-generated catch block
                 e2.printStackTrace();
              }
     	}
        return dto;
	}
	
	public void reply(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep, String bIndent) {

	      
	      replyShape(bGroup, bStep);
	      
	      Connection conn = null;
	      PreparedStatement pstmt = null;

	      try {
	         conn = dataSource.getConnection();
	         String query="insert into smvc_board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) values (smvc_board_seq.nextval, ?, ?, ?,?,?, ? )";
	         pstmt = conn.prepareStatement(query);

	         pstmt.setString(1, bName);
	         pstmt.setString(2, bTitle);
	         pstmt.setString(3, bContent);
	         pstmt.setInt(4, Integer.parseInt(bGroup));
	         pstmt.setInt(5, Integer.parseInt(bStep)+1);
	         pstmt.setInt(6, Integer.parseInt(bIndent)+1);

	         int rn = pstmt.executeUpdate();

	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {         
	         try {
	            if(pstmt != null) pstmt.close();
	            if(conn != null) conn.close();
	         } catch (Exception e2) {
	            // TODO Auto-generated catch block
	            e2.printStackTrace();
	         }
	      }
	   
	   }
	
	public void replyShape(String strGroup, String strStep) {
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      try {
	         conn = dataSource.getConnection();
	         String query="update smvc_board set bStep = bStep+1 where bGroup = ? and bStep > ?";
	         pstmt = conn.prepareStatement(query);

	         pstmt.setInt(1,Integer.parseInt(strGroup));
	         pstmt.setInt(2,Integer.parseInt(strStep));
	         

	         int rn = pstmt.executeUpdate();

	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {         
	         try {
	            if(pstmt != null) pstmt.close();
	            if(conn != null) conn.close();
	         } catch (Exception e2) {
	            // TODO Auto-generated catch block
	            e2.printStackTrace();
	         }
	      }	      
   }
}
