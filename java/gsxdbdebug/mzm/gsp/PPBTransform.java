/*     */ package mzm.gsp;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.PreparedStatement;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Storage;
/*     */ import xdb.TTable;
/*     */ import xdb.Table;
/*     */ import xdb.TableSys;
/*     */ import xdb.Tables;
/*     */ import xdb.Xdb;
/*     */ import xdb.util.AutoKeys;
/*     */ import xdb.util.UniqNameConf;
/*     */ 
/*     */ public class PPBTransform
/*     */ {
/*     */   public static void prepareTransform(String tmpDataDir)
/*     */   {
/*  28 */     for (final Table table : Xdb.getInstance().getTables().getTables())
/*     */     {
/*     */       try
/*     */       {
/*  32 */         final FileOutputStream fos = new FileOutputStream(new File(tmpDataDir, table.getName()));
/*     */         
/*  34 */         if (table.getName().equals("_sys_"))
/*     */         {
/*  36 */           TableSys tableSys = (TableSys)table;
/*     */           
/*     */ 
/*  39 */           OctetsStream kos = new OctetsStream().marshal("xdb.util.AutoKeys." + String.valueOf(Xdb.getInstance().getConf().getUniqNameConf().getLocalId()), "UTF-16LE");
/*     */           
/*     */ 
/*     */ 
/*  43 */           marshal(fos, kos.size());
/*  44 */           fos.write(kos.array(), 0, kos.size());
/*     */           
/*     */ 
/*     */ 
/*  48 */           OctetsStream vos = tableSys.getAutoKeys().encodeValue(0L);
/*  49 */           byte[] compressed_value = Storage.compress(vos.array(), vos.size());
/*  50 */           marshal(fos, compressed_value.length);
/*  51 */           fos.write(compressed_value, 0, compressed_value.length);
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*  56 */           TTable<?, ?> tTable = (TTable)table;
/*  57 */           tTable.walk(new xdb.Storage.IWalk()
/*     */           {
/*     */ 
/*     */             public boolean onRecord(byte[] key, byte[] data)
/*     */             {
/*     */               try
/*     */               {
/*  64 */                 Object k = this.val$tTable.unmarshalKeyWithFixFormat(OctetsStream.wrap(Octets.wrap(key, key.length)));
/*  65 */                 Object v = this.val$tTable.unmarshalValueWithFixFormat(OctetsStream.wrap(Octets.wrap(data, data.length)));
/*     */                 
/*     */ 
/*     */ 
/*  69 */                 OctetsStream kos = this.val$tTable.marshalKeyUnchecked(k, true);
/*  70 */                 PPBTransform.marshal(fos, kos.size());
/*  71 */                 fos.write(kos.array(), 0, kos.size());
/*     */                 
/*     */ 
/*     */ 
/*  75 */                 OctetsStream vos = this.val$tTable.marshalValueUnchecked(v, true);
/*  76 */                 byte[] compressed_value = Storage.compress(vos.array(), vos.size());
/*  77 */                 PPBTransform.marshal(fos, compressed_value.length);
/*  78 */                 fos.write(compressed_value, 0, compressed_value.length);
/*     */ 
/*     */               }
/*     */               catch (Exception e)
/*     */               {
/*  83 */                 GameServer.logger().error("walk table error|table_name=" + table.getName(), e);
/*     */               }
/*     */               
/*  86 */               return true;
/*     */             }
/*     */           });
/*     */         }
/*  90 */         fos.close();
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/*  94 */         GameServer.logger().error("walk table error|table_name=" + table.getName(), e);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static void main(String[] args)
/*     */   {
/* 101 */     transform(args[0], args[1], args[2], args[3]);
/*     */   }
/*     */   
/*     */   public static void transform(String tmpDataDir, String url, String user, String password)
/*     */   {
/*     */     try
/*     */     {
/* 108 */       Connection conn = DriverManager.getConnection(url, user, password);
/*     */       
/* 110 */       File[] files = new File(tmpDataDir).listFiles();
/*     */       
/* 112 */       byte[] kbuff = new byte['Ѐ'];
/* 113 */       byte[] vbuff = new byte[33554432];
/*     */       try
/*     */       {
/* 116 */         for (File file : files)
/*     */         {
/* 118 */           FileInputStream fis = new FileInputStream(file);
/* 119 */           while (fis.available() > 0)
/*     */           {
/* 121 */             int keyLen = unmarshalInt32(fis);
/* 122 */             fis.read(kbuff, 0, keyLen);
/* 123 */             int valueLen = unmarshalInt32(fis);
/* 124 */             fis.read(vbuff, 0, valueLen);
/* 125 */             String hexKey = xdb.util.Misc.bytesToHexString(kbuff, 0, keyLen);
/*     */             for (;;)
/*     */             {
/* 128 */               PreparedStatement stmt = conn.prepareStatement(getRemoteReplaceSQL(file.getName(), hexKey));
/*     */               try
/*     */               {
/* 131 */                 stmt.setBlob(1, new java.io.ByteArrayInputStream(vbuff, 0, valueLen));
/* 132 */                 stmt.executeUpdate();
/*     */ 
/*     */               }
/*     */               catch (Exception e)
/*     */               {
/* 137 */                 GameServer.logger().error(e);
/*     */                 
/*     */ 
/*     */ 
/*     */ 
/* 142 */                 if (stmt != null)
/*     */                 {
/* 144 */                   stmt.close();
/*     */                 }
/*     */               }
/*     */               finally
/*     */               {
/* 142 */                 if (stmt == null) {}
/*     */               }
/*     */             }
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 150 */           fis.close();
/*     */         }
/*     */       }
/*     */       finally
/*     */       {
/* 155 */         conn.close();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 160 */       GameServer.logger().error(e);
/*     */     }
/*     */   }
/*     */   
/*     */   static String getRemoteReplaceSQL(String storageName, String key)
/*     */   {
/* 166 */     StringBuffer sb = new StringBuffer();
/* 167 */     sb.append("REPLACE INTO ").append(storageName).append(" VALUES(0x").append(key).append(", ?)");
/* 168 */     return sb.toString();
/*     */   }
/*     */   
/*     */   static OutputStream marshal(OutputStream os, int x) throws IOException
/*     */   {
/* 173 */     os.write((byte)(x >> 24));
/* 174 */     os.write((byte)(x >> 16));
/* 175 */     os.write((byte)(x >> 8));
/* 176 */     os.write((byte)x);
/*     */     
/* 178 */     return os;
/*     */   }
/*     */   
/*     */   static int unmarshalInt32(InputStream is) throws IOException
/*     */   {
/* 183 */     int b0 = is.read();
/* 184 */     int b1 = is.read();
/* 185 */     int b2 = is.read();
/* 186 */     int b3 = is.read();
/* 187 */     return (b0 & 0xFF) << 24 | (b1 & 0xFF) << 16 | (b2 & 0xFF) << 8 | (b3 & 0xFF) << 0;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\PPBTransform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */