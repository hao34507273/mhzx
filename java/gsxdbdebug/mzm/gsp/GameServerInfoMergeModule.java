/*    */ package mzm.gsp;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Table;
/*    */ import xdb.Xdb;
/*    */ import xdb.XdbConf;
/*    */ import xtable.Gamesrv;
/*    */ import xtable.Notice;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GameServerInfoMergeModule
/*    */   implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 28 */     List<Table> tables = new ArrayList();
/* 29 */     tables.add(Gamesrv.getTable());
/*    */     
/*    */ 
/* 32 */     tables.add(Notice.getTable());
/*    */     
/* 34 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 40 */     if (!handleDuplicateRoleName())
/*    */     {
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     return new PGameServerInfoMerge().call();
/*    */   }
/*    */   
/*    */   private final boolean handleDuplicateRoleName()
/*    */   {
/*    */     try
/*    */     {
/* 52 */       Connection connection = Xdb.getInstance().getConf().getConnection();
/*    */       try
/*    */       {
/* 55 */         connection.setReadOnly(true);
/* 56 */         int num = 0;
/*    */         for (;;)
/*    */         {
/* 59 */           int result = handleDuplicateRoleName(connection, num);
/* 60 */           if (result == 1) {
/*    */             break;
/*    */           }
/*    */           
/* 64 */           if (result == -1)
/*    */           {
/* 66 */             return false;
/*    */           }
/*    */           
/* 69 */           num++;
/*    */         }
/*    */       }
/*    */       finally
/*    */       {
/* 74 */         connection.close();
/*    */       }
/*    */       
/* 77 */       return true;
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 81 */       MergeMain.logger().error("[gameserverinfo]GameServerInfoMergeModule.handleDuplicateRoleName@handle duplicate role name failed", e);
/*    */     }
/*    */     
/* 84 */     return false;
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   private final int handleDuplicateRoleName(Connection connection, int num)
/*    */     throws Exception
/*    */   {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: invokeinterface 21 1 0
/*    */     //   6: astore_3
/*    */     //   7: aload_3
/*    */     //   8: ldc 22
/*    */     //   10: iconst_1
/*    */     //   11: anewarray 23	java/lang/Object
/*    */     //   14: dup
/*    */     //   15: iconst_0
/*    */     //   16: iload_2
/*    */     //   17: invokestatic 24	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*    */     //   20: aastore
/*    */     //   21: invokestatic 25	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
/*    */     //   24: invokeinterface 26 2 0
/*    */     //   29: astore 4
/*    */     //   31: aload 4
/*    */     //   33: invokeinterface 27 1 0
/*    */     //   38: ifne +31 -> 69
/*    */     //   41: iconst_1
/*    */     //   42: istore 5
/*    */     //   44: aload 4
/*    */     //   46: ifnull +10 -> 56
/*    */     //   49: aload 4
/*    */     //   51: invokeinterface 28 1 0
/*    */     //   56: aload_3
/*    */     //   57: ifnull +9 -> 66
/*    */     //   60: aload_3
/*    */     //   61: invokeinterface 29 1 0
/*    */     //   66: iload 5
/*    */     //   68: ireturn
/*    */     //   69: aload 4
/*    */     //   71: iconst_1
/*    */     //   72: invokeinterface 30 2 0
/*    */     //   77: astore 5
/*    */     //   79: aload 4
/*    */     //   81: iconst_2
/*    */     //   82: invokeinterface 30 2 0
/*    */     //   87: astore 6
/*    */     //   89: aload 6
/*    */     //   91: aload 6
/*    */     //   93: arraylength
/*    */     //   94: invokestatic 31	xdb/Storage:uncompress	([BI)[B
/*    */     //   97: astore 7
/*    */     //   99: invokestatic 32	xtable/Name2roleid:getTable	()Lxdb/TTable;
/*    */     //   102: aload 5
/*    */     //   104: aload 5
/*    */     //   106: arraylength
/*    */     //   107: invokestatic 33	com/goldhuman/Common/Octets:wrap	([BI)Lcom/goldhuman/Common/Octets;
/*    */     //   110: invokestatic 34	ppbio/OctetsInputStream:wrap	(Lcom/goldhuman/Common/Octets;)Lppbio/OctetsInputStream;
/*    */     //   113: invokestatic 35	ppbio/CodedInputStream:newInstance	(Ljava/io/InputStream;)Lppbio/CodedInputStream;
/*    */     //   116: invokevirtual 36	xdb/TTable:unmarshalKeyWithPPB	(Lppbio/CodedInputStream;)Ljava/lang/Object;
/*    */     //   119: checkcast 37	java/lang/String
/*    */     //   122: astore 8
/*    */     //   124: invokestatic 32	xtable/Name2roleid:getTable	()Lxdb/TTable;
/*    */     //   127: aload 7
/*    */     //   129: aload 7
/*    */     //   131: arraylength
/*    */     //   132: invokestatic 33	com/goldhuman/Common/Octets:wrap	([BI)Lcom/goldhuman/Common/Octets;
/*    */     //   135: invokestatic 34	ppbio/OctetsInputStream:wrap	(Lcom/goldhuman/Common/Octets;)Lppbio/OctetsInputStream;
/*    */     //   138: invokestatic 35	ppbio/CodedInputStream:newInstance	(Ljava/io/InputStream;)Lppbio/CodedInputStream;
/*    */     //   141: invokevirtual 38	xdb/TTable:unmarshalValueWithPPB	(Lppbio/CodedInputStream;)Ljava/lang/Object;
/*    */     //   144: checkcast 39	java/lang/Long
/*    */     //   147: astore 9
/*    */     //   149: new 40	mzm/gsp/PHandleDuplicateRoleName
/*    */     //   152: dup
/*    */     //   153: aload 8
/*    */     //   155: aload 9
/*    */     //   157: invokevirtual 41	java/lang/Long:longValue	()J
/*    */     //   160: invokespecial 42	mzm/gsp/PHandleDuplicateRoleName:<init>	(Ljava/lang/String;J)V
/*    */     //   163: invokevirtual 43	mzm/gsp/PHandleDuplicateRoleName:call	()Z
/*    */     //   166: ifne +31 -> 197
/*    */     //   169: iconst_m1
/*    */     //   170: istore 10
/*    */     //   172: aload 4
/*    */     //   174: ifnull +10 -> 184
/*    */     //   177: aload 4
/*    */     //   179: invokeinterface 28 1 0
/*    */     //   184: aload_3
/*    */     //   185: ifnull +9 -> 194
/*    */     //   188: aload_3
/*    */     //   189: invokeinterface 29 1 0
/*    */     //   194: iload 10
/*    */     //   196: ireturn
/*    */     //   197: iconst_0
/*    */     //   198: istore 10
/*    */     //   200: aload 4
/*    */     //   202: ifnull +10 -> 212
/*    */     //   205: aload 4
/*    */     //   207: invokeinterface 28 1 0
/*    */     //   212: aload_3
/*    */     //   213: ifnull +9 -> 222
/*    */     //   216: aload_3
/*    */     //   217: invokeinterface 29 1 0
/*    */     //   222: iload 10
/*    */     //   224: ireturn
/*    */     //   225: astore 11
/*    */     //   227: aload 4
/*    */     //   229: ifnull +10 -> 239
/*    */     //   232: aload 4
/*    */     //   234: invokeinterface 28 1 0
/*    */     //   239: aload 11
/*    */     //   241: athrow
/*    */     //   242: astore 12
/*    */     //   244: aload_3
/*    */     //   245: ifnull +9 -> 254
/*    */     //   248: aload_3
/*    */     //   249: invokeinterface 29 1 0
/*    */     //   254: aload 12
/*    */     //   256: athrow
/*    */     //   257: astore_3
/*    */     //   258: aload_3
/*    */     //   259: invokestatic 45	xdb/LoggerMySQL:isSpecialMySQLError	(Ljava/sql/SQLException;)Z
/*    */     //   262: ifeq +6 -> 268
/*    */     //   265: goto -265 -> 0
/*    */     //   268: invokestatic 18	mzm/gsp/MergeMain:logger	()Lorg/apache/log4j/Logger;
/*    */     //   271: ldc 46
/*    */     //   273: iconst_1
/*    */     //   274: anewarray 23	java/lang/Object
/*    */     //   277: dup
/*    */     //   278: iconst_0
/*    */     //   279: iload_2
/*    */     //   280: invokestatic 24	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*    */     //   283: aastore
/*    */     //   284: invokestatic 25	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
/*    */     //   287: aload_3
/*    */     //   288: invokevirtual 20	org/apache/log4j/Logger:error	(Ljava/lang/Object;Ljava/lang/Throwable;)V
/*    */     //   291: iconst_m1
/*    */     //   292: ireturn
/*    */     // Line number table:
/*    */     //   Java source line #94	-> byte code offset #0
/*    */     //   Java source line #97	-> byte code offset #7
/*    */     //   Java source line #100	-> byte code offset #31
/*    */     //   Java source line #102	-> byte code offset #41
/*    */     //   Java source line #123	-> byte code offset #44
/*    */     //   Java source line #125	-> byte code offset #49
/*    */     //   Java source line #131	-> byte code offset #56
/*    */     //   Java source line #133	-> byte code offset #60
/*    */     //   Java source line #105	-> byte code offset #69
/*    */     //   Java source line #106	-> byte code offset #79
/*    */     //   Java source line #107	-> byte code offset #89
/*    */     //   Java source line #109	-> byte code offset #99
/*    */     //   Java source line #111	-> byte code offset #124
/*    */     //   Java source line #114	-> byte code offset #149
/*    */     //   Java source line #116	-> byte code offset #169
/*    */     //   Java source line #123	-> byte code offset #172
/*    */     //   Java source line #125	-> byte code offset #177
/*    */     //   Java source line #131	-> byte code offset #184
/*    */     //   Java source line #133	-> byte code offset #188
/*    */     //   Java source line #119	-> byte code offset #197
/*    */     //   Java source line #123	-> byte code offset #200
/*    */     //   Java source line #125	-> byte code offset #205
/*    */     //   Java source line #131	-> byte code offset #212
/*    */     //   Java source line #133	-> byte code offset #216
/*    */     //   Java source line #123	-> byte code offset #225
/*    */     //   Java source line #125	-> byte code offset #232
/*    */     //   Java source line #131	-> byte code offset #242
/*    */     //   Java source line #133	-> byte code offset #248
/*    */     //   Java source line #137	-> byte code offset #257
/*    */     //   Java source line #139	-> byte code offset #258
/*    */     //   Java source line #141	-> byte code offset #265
/*    */     //   Java source line #144	-> byte code offset #268
/*    */     //   Java source line #148	-> byte code offset #291
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	293	0	this	GameServerInfoMergeModule
/*    */     //   0	293	1	connection	Connection
/*    */     //   0	293	2	num	int
/*    */     //   6	243	3	stmt	java.sql.Statement
/*    */     //   257	31	3	e	java.sql.SQLException
/*    */     //   29	204	4	rs	java.sql.ResultSet
/*    */     //   77	28	5	key	byte[]
/*    */     //   87	5	6	rawValue	byte[]
/*    */     //   97	33	7	value	byte[]
/*    */     //   122	32	8	name	String
/*    */     //   147	9	9	roleid	Long
/*    */     //   170	53	10	j	int
/*    */     //   225	15	11	localObject1	Object
/*    */     //   242	13	12	localObject2	Object
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   31	44	225	finally
/*    */     //   69	172	225	finally
/*    */     //   197	200	225	finally
/*    */     //   225	227	225	finally
/*    */     //   7	56	242	finally
/*    */     //   69	184	242	finally
/*    */     //   197	212	242	finally
/*    */     //   225	244	242	finally
/*    */     //   0	66	257	java/sql/SQLException
/*    */     //   69	194	257	java/sql/SQLException
/*    */     //   197	222	257	java/sql/SQLException
/*    */     //   225	257	257	java/sql/SQLException
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\GameServerInfoMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */