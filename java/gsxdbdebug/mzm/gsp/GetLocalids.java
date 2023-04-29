/*     */ package mzm.gsp;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.OctetsInputStream;
/*     */ import ppbio.OctetsOutputStream;
/*     */ import xbean.GameServerInfo;
/*     */ import xbean.Pod;
/*     */ import xdb.Storage;
/*     */ import xdb.util.Dbx;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GetLocalids
/*     */ {
/*     */   private static enum ExitCode
/*     */   {
/*  32 */     PRAMA_NUM_INVALID(1), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  37 */     PRAMA_INVALID(2), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  42 */     SQLException(3), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  47 */     Exception(4), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  52 */     LOCALID_INVALID(5), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  57 */     DATA_NOT_FOUND(6), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  62 */     KEY_AND_LOCALID_NOT_MATCH(8), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  67 */     ZONEID_DUPLICATE(7), 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  72 */     ZONEID_AND_LOCALID_NOT_MATCH(8);
/*     */     
/*     */ 
/*     */     public final int code;
/*     */     
/*     */ 
/*     */     private ExitCode(int code)
/*     */     {
/*  80 */       this.code = code;
/*     */     }
/*     */   }
/*     */   
/*     */   private static void usage()
/*     */   {
/*  86 */     System.err.println("Usage: java table MainZoneid SQLURL SQLUser SQLPassword");
/*  87 */     System.err.println("\ttable:_sys_, gamesrv");
/*     */   }
/*     */   
/*     */   private static Connection getConnection(String sqlURL, String sqlUser, String sqlPassword)
/*     */     throws SQLException
/*     */   {
/*  93 */     if ((sqlURL == null) || (sqlUser == null) || (sqlPassword == null))
/*     */     {
/*  95 */       return null;
/*     */     }
/*     */     
/*  98 */     return DriverManager.getConnection(sqlURL, sqlUser, sqlPassword);
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   private static int collectLocalID(Connection connection, int num, List<Integer> localids)
/*     */     throws Exception
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokeinterface 7 1 0
/*     */     //   6: astore_3
/*     */     //   7: aload_3
/*     */     //   8: ldc 8
/*     */     //   10: iconst_1
/*     */     //   11: anewarray 9	java/lang/Object
/*     */     //   14: dup
/*     */     //   15: iconst_0
/*     */     //   16: iload_1
/*     */     //   17: invokestatic 10	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   20: aastore
/*     */     //   21: invokestatic 11	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   24: invokeinterface 12 2 0
/*     */     //   29: astore 4
/*     */     //   31: aload 4
/*     */     //   33: invokeinterface 13 1 0
/*     */     //   38: ifne +31 -> 69
/*     */     //   41: iconst_1
/*     */     //   42: istore 5
/*     */     //   44: aload 4
/*     */     //   46: ifnull +10 -> 56
/*     */     //   49: aload 4
/*     */     //   51: invokeinterface 14 1 0
/*     */     //   56: aload_3
/*     */     //   57: ifnull +9 -> 66
/*     */     //   60: aload_3
/*     */     //   61: invokeinterface 15 1 0
/*     */     //   66: iload 5
/*     */     //   68: ireturn
/*     */     //   69: aload 4
/*     */     //   71: iconst_1
/*     */     //   72: invokeinterface 16 2 0
/*     */     //   77: astore 5
/*     */     //   79: aload 5
/*     */     //   81: invokestatic 17	com/goldhuman/Common/Marshal/OctetsStream:wrap	([B)Lcom/goldhuman/Common/Octets;
/*     */     //   84: invokestatic 18	com/goldhuman/Common/Marshal/OctetsStream:wrap	(Lcom/goldhuman/Common/Octets;)Lcom/goldhuman/Common/Marshal/OctetsStream;
/*     */     //   87: astore 6
/*     */     //   89: aload 6
/*     */     //   91: ldc 19
/*     */     //   93: invokevirtual 20	com/goldhuman/Common/Marshal/OctetsStream:unmarshal_String	(Ljava/lang/String;)Ljava/lang/String;
/*     */     //   96: astore 7
/*     */     //   98: aload_2
/*     */     //   99: aload 7
/*     */     //   101: ldc 21
/*     */     //   103: invokevirtual 22	java/lang/String:length	()I
/*     */     //   106: invokevirtual 23	java/lang/String:substring	(I)Ljava/lang/String;
/*     */     //   109: invokestatic 24	java/lang/Integer:parseInt	(Ljava/lang/String;)I
/*     */     //   112: invokestatic 10	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   115: invokeinterface 25 2 0
/*     */     //   120: pop
/*     */     //   121: iconst_0
/*     */     //   122: istore 8
/*     */     //   124: aload 4
/*     */     //   126: ifnull +10 -> 136
/*     */     //   129: aload 4
/*     */     //   131: invokeinterface 14 1 0
/*     */     //   136: aload_3
/*     */     //   137: ifnull +9 -> 146
/*     */     //   140: aload_3
/*     */     //   141: invokeinterface 15 1 0
/*     */     //   146: iload 8
/*     */     //   148: ireturn
/*     */     //   149: astore 9
/*     */     //   151: aload 4
/*     */     //   153: ifnull +10 -> 163
/*     */     //   156: aload 4
/*     */     //   158: invokeinterface 14 1 0
/*     */     //   163: aload 9
/*     */     //   165: athrow
/*     */     //   166: astore 10
/*     */     //   168: aload_3
/*     */     //   169: ifnull +9 -> 178
/*     */     //   172: aload_3
/*     */     //   173: invokeinterface 15 1 0
/*     */     //   178: aload 10
/*     */     //   180: athrow
/*     */     //   181: astore_3
/*     */     //   182: aload_3
/*     */     //   183: invokestatic 27	xdb/LoggerMySQL:isSpecialMySQLError	(Ljava/sql/SQLException;)Z
/*     */     //   186: ifeq +6 -> 192
/*     */     //   189: goto -189 -> 0
/*     */     //   192: aload_3
/*     */     //   193: getstatic 2	java/lang/System:err	Ljava/io/PrintStream;
/*     */     //   196: invokevirtual 28	java/sql/SQLException:printStackTrace	(Ljava/io/PrintStream;)V
/*     */     //   199: iconst_m1
/*     */     //   200: ireturn
/*     */     // Line number table:
/*     */     //   Java source line #108	-> byte code offset #0
/*     */     //   Java source line #111	-> byte code offset #7
/*     */     //   Java source line #114	-> byte code offset #31
/*     */     //   Java source line #116	-> byte code offset #41
/*     */     //   Java source line #129	-> byte code offset #44
/*     */     //   Java source line #131	-> byte code offset #49
/*     */     //   Java source line #137	-> byte code offset #56
/*     */     //   Java source line #139	-> byte code offset #60
/*     */     //   Java source line #119	-> byte code offset #69
/*     */     //   Java source line #121	-> byte code offset #79
/*     */     //   Java source line #122	-> byte code offset #89
/*     */     //   Java source line #123	-> byte code offset #98
/*     */     //   Java source line #125	-> byte code offset #121
/*     */     //   Java source line #129	-> byte code offset #124
/*     */     //   Java source line #131	-> byte code offset #129
/*     */     //   Java source line #137	-> byte code offset #136
/*     */     //   Java source line #139	-> byte code offset #140
/*     */     //   Java source line #129	-> byte code offset #149
/*     */     //   Java source line #131	-> byte code offset #156
/*     */     //   Java source line #137	-> byte code offset #166
/*     */     //   Java source line #139	-> byte code offset #172
/*     */     //   Java source line #143	-> byte code offset #181
/*     */     //   Java source line #145	-> byte code offset #182
/*     */     //   Java source line #147	-> byte code offset #189
/*     */     //   Java source line #150	-> byte code offset #192
/*     */     //   Java source line #152	-> byte code offset #199
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	201	0	connection	Connection
/*     */     //   0	201	1	num	int
/*     */     //   0	201	2	localids	List<Integer>
/*     */     //   6	167	3	stmt	Statement
/*     */     //   181	12	3	e	SQLException
/*     */     //   29	128	4	rs	ResultSet
/*     */     //   77	3	5	id	byte[]
/*     */     //   87	3	6	os	com.goldhuman.Common.Marshal.OctetsStream
/*     */     //   96	4	7	rawLocalID	String
/*     */     //   149	15	9	localObject1	Object
/*     */     //   166	13	10	localObject2	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   31	44	149	finally
/*     */     //   69	124	149	finally
/*     */     //   149	151	149	finally
/*     */     //   7	56	166	finally
/*     */     //   69	136	166	finally
/*     */     //   149	168	166	finally
/*     */     //   0	66	181	java/sql/SQLException
/*     */     //   69	146	181	java/sql/SQLException
/*     */     //   149	181	181	java/sql/SQLException
/*     */   }
/*     */   
/*     */   private static void collectLocalIDFromSys(int mainLocalid, String sqlURL, String sqlUser, String sqlPassword)
/*     */   {
/*     */     try
/*     */     {
/* 162 */       Connection connection = getConnection(sqlURL, sqlUser, sqlPassword);
/* 163 */       if (connection == null)
/*     */       {
/* 165 */         usage();
/*     */         
/* 167 */         System.exit(ExitCode.PRAMA_INVALID.code);
/*     */         
/* 169 */         return;
/*     */       }
/*     */       
/*     */       try
/*     */       {
/* 174 */         connection.setReadOnly(true);
/*     */         
/* 176 */         List<Integer> localids = new ArrayList();
/* 177 */         int num = 0;
/*     */         for (;;)
/*     */         {
/* 180 */           int result = collectLocalID(connection, num, localids);
/* 181 */           if (result == 1) {
/*     */             break;
/*     */           }
/*     */           
/* 185 */           if (result == -1)
/*     */           {
/* 187 */             usage();
/*     */             
/* 189 */             System.exit(ExitCode.SQLException.code); return;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/* 194 */           num++;
/*     */         }
/*     */         
/* 197 */         if (!localids.contains(Integer.valueOf(mainLocalid)))
/*     */         {
/* 199 */           System.err.println(String.format("data not found|main_zoneid=%d", new Object[] { Integer.valueOf(mainLocalid) }));
/*     */           
/* 201 */           System.exit(ExitCode.LOCALID_INVALID.code);
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 206 */           StringBuilder sbResult = new StringBuilder();
/* 207 */           sbResult.append(mainLocalid);
/* 208 */           for (Iterator i$ = localids.iterator(); i$.hasNext();) { int localid = ((Integer)i$.next()).intValue();
/*     */             
/* 210 */             if (mainLocalid != localid)
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/* 215 */               sbResult.append("|").append(localid);
/*     */             }
/*     */           }
/* 218 */           System.out.print(sbResult.toString());
/*     */         }
/*     */       }
/*     */       finally {
/* 222 */         connection.close();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 227 */       e.printStackTrace(System.err);
/*     */       
/* 229 */       System.exit(ExitCode.Exception.code);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static void collectLocalIDFromGameSrv(long mainLocalid, String sqlURL, String sqlUser, String sqlPassword)
/*     */   {
/*     */     try
/*     */     {
/* 238 */       Connection connection = getConnection(sqlURL, sqlUser, sqlPassword);
/* 239 */       if (connection == null)
/*     */       {
/* 241 */         usage();
/*     */         
/* 243 */         System.exit(ExitCode.PRAMA_INVALID.code);
/*     */         
/* 245 */         return;
/*     */       }
/*     */       
/*     */       try
/*     */       {
/* 250 */         connection.setReadOnly(true);
/*     */         
/*     */         try
/*     */         {
/* 254 */           Statement stmt = connection.createStatement();
/*     */           try
/*     */           {
/* 257 */             Octets octets = new Octets();
/* 258 */             OctetsOutputStream oos = OctetsOutputStream.wrap(octets);
/* 259 */             CodedOutputStream _output_ = CodedOutputStream.newInstance(oos);
/* 260 */             _output_.writeInt64NoTag(mainLocalid);
/* 261 */             _output_.flush();
/* 262 */             ResultSet rs = stmt.executeQuery(String.format("SELECT id, value FROM gamesrv where id=0x%s", new Object[] { CommonUtils.bytesToHexString(octets.getBytes()) }));
/*     */             
/*     */             try
/*     */             {
/* 266 */               if (!rs.next())
/*     */               {
/* 268 */                 System.err.println(String.format("data not found|main_localid=%d", new Object[] { Long.valueOf(mainLocalid) }));
/*     */                 
/* 270 */                 System.exit(ExitCode.DATA_NOT_FOUND.code);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 342 */                 if (rs != null)
/*     */                 {
/* 344 */                   rs.close();
/*     */                 }
/*     */                 
/*     */ 
/*     */ 
/*     */ 
/* 350 */                 if (stmt != null)
/*     */                 {
/* 352 */                   stmt.close();
/*     */                 }
/*     */               }
/*     */               else
/*     */               {
/* 275 */                 byte[] rawKey = rs.getBytes(1);
/* 276 */                 byte[] rawValue = rs.getBytes(2);
/* 277 */                 byte[] value = Storage.uncompress(rawValue, rawValue.length);
/* 278 */                 CodedInputStream cisKey = CodedInputStream.newInstance(OctetsInputStream.wrap(Octets.wrap(rawKey, rawKey.length)));
/*     */                 
/* 280 */                 long key = cisKey.readInt64();
/* 281 */                 GameServerInfo xGameServerInfo = Pod.newGameServerInfoData();
/* 282 */                 CodedInputStream cisValue = CodedInputStream.newInstance(OctetsInputStream.wrap(Octets.wrap(value, value.length)));
/*     */                 
/* 284 */                 cisValue.readMessage(xGameServerInfo);
/*     */                 
/* 286 */                 if (key != mainLocalid)
/*     */                 {
/* 288 */                   System.err.println(String.format("key and localid not match|main_localid=%d|key=%d", new Object[] { Long.valueOf(mainLocalid), Long.valueOf(key) }));
/*     */                   
/*     */ 
/* 291 */                   System.exit(ExitCode.KEY_AND_LOCALID_NOT_MATCH.code);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 342 */                   if (rs != null)
/*     */                   {
/* 344 */                     rs.close();
/*     */                   }
/*     */                   
/*     */ 
/*     */ 
/*     */ 
/* 350 */                   if (stmt != null)
/*     */                   {
/* 352 */                     stmt.close();
/*     */                   }
/*     */                 }
/*     */                 else
/*     */                 {
/* 296 */                   StringBuilder sbResult = new StringBuilder();
/* 297 */                   List<Long> zoneids = new ArrayList();
/* 298 */                   List<String> xZoneids = xGameServerInfo.getZoneids();
/* 299 */                   int len = xZoneids.size();
/* 300 */                   for (int i = 0; i < len; i++)
/*     */                   {
/* 302 */                     zoneids.add(Long.valueOf((String)xZoneids.get(i)));
/*     */                     
/* 304 */                     if (i > 0)
/*     */                     {
/* 306 */                       sbResult.append("|");
/*     */                     }
/* 308 */                     sbResult.append(zoneids.get(i));
/*     */                   }
/*     */                   
/*     */ 
/*     */ 
/* 313 */                   Set<Long> tmpZoneids = new HashSet(zoneids);
/* 314 */                   if (tmpZoneids.size() != zoneids.size())
/*     */                   {
/* 316 */                     System.err.println(String.format("zoneid duplicate|main_localid=%d|key=%d|tmp_zoneids=%s|zoneids=%s", new Object[] { Long.valueOf(mainLocalid), Long.valueOf(key), tmpZoneids, zoneids }));
/*     */                     
/*     */ 
/* 319 */                     System.exit(ExitCode.ZONEID_DUPLICATE.code);
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
/* 342 */                     if (rs != null)
/*     */                     {
/* 344 */                       rs.close();
/*     */                     }
/*     */                     
/*     */ 
/*     */ 
/*     */ 
/* 350 */                     if (stmt != null)
/*     */                     {
/* 352 */                       stmt.close();
/*     */                     }
/*     */                   }
/*     */                   else
/*     */                   {
/* 326 */                     long dbMainZoneid = ((Long)zoneids.get(0)).longValue();
/* 327 */                     if (dbMainZoneid != mainLocalid)
/*     */                     {
/* 329 */                       System.err.println(String.format("zoneid and localid not match|main_localid=%d|db_main_zoneid=%d", new Object[] { Long.valueOf(mainLocalid), Long.valueOf(dbMainZoneid) }));
/*     */                       
/*     */ 
/*     */ 
/* 333 */                       System.exit(ExitCode.ZONEID_AND_LOCALID_NOT_MATCH.code);
/*     */                       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 342 */                       if (rs != null)
/*     */                       {
/* 344 */                         rs.close();
/*     */                       }
/*     */                       
/*     */ 
/*     */ 
/*     */ 
/* 350 */                       if (stmt != null)
/*     */                       {
/* 352 */                         stmt.close();
/*     */                       }
/*     */                     }
/*     */                     else
/*     */                     {
/* 338 */                       System.out.print(sbResult.toString());
/*     */                     }
/*     */                     
/*     */                   }
/*     */                   
/*     */                 }
/*     */               }
/*     */             }
/*     */             finally {}
/*     */           }
/*     */           finally
/*     */           {
/* 350 */             if (stmt == null) {}
/*     */           }
/*     */           
/*     */ 
/*     */         }
/*     */         catch (SQLException e)
/*     */         {
/*     */ 
/* 358 */           e.printStackTrace(System.err);
/*     */           
/* 360 */           System.exit(ExitCode.SQLException.code);
/*     */         }
/*     */         
/*     */ 
/*     */       }
/*     */       finally
/*     */       {
/* 367 */         connection.close();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 372 */       e.printStackTrace(System.err);
/*     */       
/* 374 */       System.exit(ExitCode.Exception.code);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void main(String[] args)
/*     */   {
/* 380 */     if (args.length != 5)
/*     */     {
/* 382 */       usage();
/*     */       
/* 384 */       System.exit(ExitCode.PRAMA_NUM_INVALID.code);
/*     */       
/* 386 */       return;
/*     */     }
/*     */     
/* 389 */     if ("_sys_".equals(args[0]))
/*     */     {
/* 391 */       collectLocalIDFromSys(Integer.parseInt(args[1]), args[2], args[3], args[4]);
/*     */     }
/* 393 */     else if ("gamesrv".equals(args[0]))
/*     */     {
/* 395 */       Dbx.load("./");
/* 396 */       collectLocalIDFromGameSrv(Integer.parseInt(args[1]), args[2], args[3], args[4]);
/*     */     }
/*     */     else
/*     */     {
/* 400 */       usage();
/*     */       
/* 402 */       System.exit(ExitCode.PRAMA_INVALID.code);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\GetLocalids.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */