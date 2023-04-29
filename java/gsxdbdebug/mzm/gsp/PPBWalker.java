/*     */ package mzm.gsp;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.OctetsInputStream;
/*     */ import xdb.LoggerMySQL;
/*     */ import xdb.Storage;
/*     */ import xdb.TTable;
/*     */ 
/*     */ 
/*     */ public abstract class PPBWalker<K, V>
/*     */ {
/*     */   private final ConnectionProxy connProxy;
/*     */   private final TTable<K, V> table;
/*     */   
/*     */   public static void info(String log)
/*     */   {
/*  23 */     System.out.println(log);
/*     */   }
/*     */   
/*     */   public static void warn(String log)
/*     */   {
/*  28 */     System.err.println(log);
/*     */   }
/*     */   
/*     */   public static void warn(String log, Throwable t)
/*     */   {
/*  33 */     System.err.println(log);
/*  34 */     t.printStackTrace(System.err);
/*  35 */     System.err.println();
/*     */   }
/*     */   
/*     */   public static void error(String log)
/*     */   {
/*  40 */     System.err.println(log);
/*     */   }
/*     */   
/*     */   public static void error(String log, Throwable t)
/*     */   {
/*  45 */     System.err.println(log);
/*  46 */     t.printStackTrace(System.err);
/*  47 */     System.err.println();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public PPBWalker(ConnectionProxy connProxy, TTable<K, V> table)
/*     */   {
/*  55 */     this.connProxy = connProxy;
/*  56 */     this.table = table;
/*     */   }
/*     */   
/*     */   public boolean walk() throws Exception
/*     */   {
/*  61 */     Statement stmt = null;
/*     */     try
/*     */     {
/*  64 */       int cursor = 0;
/*     */       for (;;)
/*     */       {
/*  67 */         stmt = getStatement(stmt);
/*  68 */         if (stmt == null)
/*     */         {
/*  70 */           return false;
/*     */         }
/*     */         
/*  73 */         int result = doWalk(stmt, cursor);
/*  74 */         boolean bool2; if (result == -1)
/*     */         {
/*  76 */           return false;
/*     */         }
/*  78 */         if (result == 0)
/*     */         {
/*  80 */           return true;
/*     */         }
/*  82 */         if (result == 1)
/*     */         {
/*  84 */           cursor++;
/*     */         } else {
/*  86 */           if (result != 2)
/*     */             break;
/*  88 */           closeStatement(stmt);
/*  89 */           stmt = null;
/*     */           
/*  91 */           this.connProxy.closeConnection();
/*     */ 
/*     */         }
/*     */         
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/*     */ 
/* 102 */       if (stmt != null)
/*     */       {
/* 104 */         closeStatement(stmt);
/*     */       }
/*     */     }
/* 107 */     return false;
/*     */   }
/*     */   
/*     */   public abstract boolean onRecord(K paramK, V paramV);
/*     */   
/*     */   private Statement getStatement(Statement stmt)
/*     */   {
/* 114 */     if (stmt != null)
/*     */     {
/* 116 */       return stmt;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/* 123 */       return this.connProxy.getConnection().createStatement();
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 127 */       while (LoggerMySQL.isSpecialMySQLError(e))
/*     */       {
/* 129 */         this.connProxy.closeConnection();
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 134 */       error("[ppbtools]PPBWalker.getStatement@get statement failed", e);
/*     */     }
/* 136 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void closeStatement(Statement stmt)
/*     */   {
/* 144 */     if (stmt != null)
/*     */     {
/*     */       try
/*     */       {
/* 148 */         stmt.close();
/*     */       }
/*     */       catch (SQLException e) {}
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int doWalk(Statement stmt, int cursor)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/* 169 */       ResultSet rs = stmt.executeQuery(String.format("SELECT id, value FROM %s LIMIT %d, 1", new Object[] { this.table.getName(), Integer.valueOf(cursor) }));
/*     */       
/*     */       try
/*     */       {
/* 173 */         if (!rs.next())
/*     */         {
/* 175 */           return 0;
/*     */         }
/*     */         
/* 178 */         byte[] key = rs.getBytes(1);
/* 179 */         byte[] rawValue = rs.getBytes(2);
/* 180 */         byte[] value = Storage.uncompress(rawValue, rawValue.length);
/*     */         
/* 182 */         K k = this.table.unmarshalKeyWithPPB(CodedInputStream.newInstance(OctetsInputStream.wrap(Octets.wrap(key, key.length))));
/*     */         
/* 184 */         V v = this.table.unmarshalValueWithPPB(CodedInputStream.newInstance(OctetsInputStream.wrap(Octets.wrap(value, value.length))));
/*     */         
/*     */         int j;
/* 187 */         if (!onRecord(k, v))
/*     */         {
/* 189 */           return -1;
/*     */         }
/*     */         
/* 192 */         return 1;
/*     */       }
/*     */       finally
/*     */       {
/* 196 */         if (rs != null)
/*     */         {
/* 198 */           rs.close();
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       String log;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 213 */       return -1;
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 204 */       if (LoggerMySQL.isSpecialMySQLError(e))
/*     */       {
/* 206 */         return 2;
/*     */       }
/*     */       
/* 209 */       log = String.format("[ppbtools]PPBWalker.doWalk@walk table failed|table=%s|cursor=%d", new Object[] { this.table.getName(), Integer.valueOf(cursor) });
/*     */       
/* 211 */       error(log, e);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\PPBWalker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */