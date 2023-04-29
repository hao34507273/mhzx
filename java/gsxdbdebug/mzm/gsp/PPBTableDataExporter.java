/*     */ package mzm.gsp;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.grc.main.AccountRecallInfo;
/*     */ import xbean.GangTeam;
/*     */ import xbean.Properties;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class PPBTableDataExporter
/*     */ {
/*     */   private static xtable._Tables_ tables;
/*     */   
/*     */   private static void usage()
/*     */   {
/*  18 */     System.err.println("usage: java -jar PPBTableDataExporter.jar SQLURL SQLUser SQLPassword [-e|--e table [-e|--e table]*]");
/*  19 */     System.err.println("table: " + validExportTables.toString());
/*     */   }
/*     */   
/*     */ 
/*  23 */   private static final Set<String> exportTables = new java.util.HashSet();
/*  24 */   private static final Set<String> validExportTables = new java.util.LinkedHashSet();
/*     */   
/*     */   static {
/*  27 */     validExportTables.add("role_basic");
/*  28 */     validExportTables.add("gang");
/*  29 */     validExportTables.add("corps");
/*  30 */     validExportTables.add("gang_team");
/*  31 */     validExportTables.add("recall");
/*     */   }
/*     */   
/*     */   public static void main(String[] args)
/*     */   {
/*  36 */     ConnectionProxy connectionProxy = null;
/*     */     try
/*     */     {
/*  39 */       xdb.util.Dbx.load("./");
/*     */       
/*  41 */       tables = new xtable._Tables_();
/*     */       
/*  43 */       String sqlURL = args[0];
/*  44 */       String sqlUser = args[1];
/*  45 */       String sqlPassword = args[2];
/*  46 */       if ((sqlURL == null) || (sqlUser == null) || (sqlPassword == null))
/*     */       {
/*  48 */         usage(); return;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*  53 */       int argsLen = args.length;
/*  54 */       for (int i = 3; i < argsLen; i++)
/*     */       {
/*  56 */         if (("-e".equalsIgnoreCase(args[i])) || ("--e".equalsIgnoreCase(args[i])))
/*     */         {
/*  58 */           exportTables.add(args[(++i)].toLowerCase());
/*     */         }
/*     */       }
/*     */       
/*  62 */       if (exportTables.isEmpty())
/*     */       {
/*  64 */         usage(); return;
/*     */       }
/*     */       
/*     */ 
/*  68 */       for (String tableName : exportTables)
/*     */       {
/*  70 */         if (!validExportTables.contains(tableName))
/*     */         {
/*  72 */           usage(); return;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*  77 */       connectionProxy = new ConnectionProxy(sqlURL, sqlUser, sqlPassword);
/*  78 */       export(connectionProxy);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  82 */       usage();
/*     */       
/*  84 */       PPBWalker.error("export error", e);
/*     */     }
/*     */     finally
/*     */     {
/*  88 */       if (connectionProxy != null)
/*     */       {
/*  90 */         connectionProxy.closeConnection();
/*     */       }
/*     */     }
/*     */     
/*  94 */     PPBWalker.info("export finished");
/*     */   }
/*     */   
/*     */   static TTable<?, ?> getTable(Class<?> clazz)
/*     */   {
/*  99 */     return (TTable)tables.getTable(clazz.getSimpleName().toLowerCase());
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
/*     */   static void export(ConnectionProxy connectionProxy)
/*     */     throws Exception
/*     */   {
/* 126 */     int ZONEID_MASK = 4095;
/*     */     
/* 128 */     if (exportTables.contains("role_basic"))
/*     */     {
/* 130 */       final PrintStream ps = new PrintStream("role_basic.txt", "UTF-8");
/*     */       
/* 132 */       TTable<Long, xbean.Basic> xtabaleBasic = getTable(xtable.Basic.class);
/* 133 */       new PPBWalker(connectionProxy, xtabaleBasic)
/*     */       {
/*     */ 
/*     */         public boolean onRecord(Long key, xbean.Basic v)
/*     */         {
/* 138 */           int zoneid = (int)(key.longValue() & 0xFFF);
/* 139 */           ps.println(String.format("%d|%s|%d|%s", new Object[] { Integer.valueOf(zoneid), v.getUser_id(), key, v.getName() }));
/* 140 */           return true;
/*     */         }
/* 142 */       }.walk();
/* 143 */       ps.close();
/*     */     }
/*     */     
/* 146 */     if (exportTables.contains("gang"))
/*     */     {
/* 148 */       final PrintStream ps = new PrintStream("gang.txt", "UTF-8");
/*     */       
/* 150 */       TTable<Long, xbean.Gang> xtabaleGang = getTable(xtable.Gang.class);
/* 151 */       new PPBWalker(connectionProxy, xtabaleGang)
/*     */       {
/*     */ 
/*     */         public boolean onRecord(Long key, xbean.Gang v)
/*     */         {
/* 156 */           int zoneid = (int)(key.longValue() & 0xFFF);
/* 157 */           ps.println(String.format("%d|%d|%s", new Object[] { Integer.valueOf(zoneid), key, v.getName() }));
/* 158 */           return true;
/*     */         }
/* 160 */       }.walk();
/* 161 */       ps.close();
/*     */     }
/*     */     
/* 164 */     if (exportTables.contains("corps"))
/*     */     {
/* 166 */       final PrintStream ps = new PrintStream("corps.txt", "UTF-8");
/*     */       
/* 168 */       TTable<Long, xbean.Corps> xtabaleBasic = getTable(xtable.Corps.class);
/* 169 */       new PPBWalker(connectionProxy, xtabaleBasic)
/*     */       {
/*     */ 
/*     */         public boolean onRecord(Long key, xbean.Corps v)
/*     */         {
/* 174 */           int zoneid = (int)(key.longValue() & 0xFFF);
/* 175 */           ps.println(String.format("%d|%d|%s", new Object[] { Integer.valueOf(zoneid), key, v.getCorpsname() }));
/* 176 */           return true;
/*     */         }
/* 178 */       }.walk();
/* 179 */       ps.close();
/*     */     }
/*     */     
/* 182 */     if (exportTables.contains("gang_team"))
/*     */     {
/* 184 */       final PrintStream ps = new PrintStream("gang_team.txt", "UTF-8");
/*     */       
/* 186 */       TTable<Long, xbean.Gang> xtabaleGang = getTable(xtable.Gang.class);
/* 187 */       new PPBWalker(connectionProxy, xtabaleGang)
/*     */       {
/*     */ 
/*     */         public boolean onRecord(Long key, xbean.Gang v)
/*     */         {
/* 192 */           int zoneid = (int)(key.longValue() & 0xFFF);
/* 193 */           for (Map.Entry<Long, GangTeam> entry : v.getTeamsAsData().entrySet())
/*     */           {
/* 195 */             ps.println(String.format("%d|%d|%d|%s", new Object[] { Integer.valueOf(zoneid), key, entry.getKey(), ((GangTeam)entry.getValue()).getName() }));
/*     */           }
/* 197 */           return true;
/*     */         }
/* 199 */       }.walk();
/* 200 */       ps.close();
/*     */     }
/*     */     
/* 203 */     if (exportTables.contains("recall"))
/*     */     {
/* 205 */       final Map<Long, AccountRecallInfo> roles = new java.util.HashMap();
/*     */       
/* 207 */       TTable<Long, Properties> xtabaleRole2Properties = getTable(xtable.Role2properties.class);
/* 208 */       new PPBWalker(connectionProxy, xtabaleRole2Properties)
/*     */       {
/*     */ 
/*     */         public boolean onRecord(Long key, Properties v)
/*     */         {
/* 213 */           AccountRecallInfo accountRecallInfo = new AccountRecallInfo();
/* 214 */           accountRecallInfo.loginTime = v.getLastlogintime();
/* 215 */           accountRecallInfo.maxLevel = v.getLevel();
/* 216 */           roles.put(key, accountRecallInfo);
/* 217 */           return true;
/*     */         }
/*     */         
/* 220 */       }.walk();
/* 221 */       final Map<String, AccountRecallInfo> openids = new java.util.HashMap();
/*     */       
/* 223 */       TTable<String, xbean.User> xtabaleUser = getTable(xtable.User.class);
/* 224 */       new PPBWalker(connectionProxy, xtabaleUser)
/*     */       {
/*     */ 
/*     */         public boolean onRecord(String key, xbean.User v)
/*     */         {
/* 229 */           String openid = mzm.gsp.util.CommonUtils.getOpenId(key);
/* 230 */           for (java.util.Iterator i$ = v.getRoleidsAsData().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */             
/* 232 */             AccountRecallInfo accountRecallInfo = (AccountRecallInfo)roles.get(Long.valueOf(roleid));
/* 233 */             if (accountRecallInfo != null)
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/* 238 */               AccountRecallInfo target = (AccountRecallInfo)openids.get(openid);
/* 239 */               if (target == null)
/*     */               {
/* 241 */                 target = new AccountRecallInfo();
/* 242 */                 openids.put(openid, target);
/*     */               }
/* 244 */               if (accountRecallInfo.loginTime > target.loginTime)
/*     */               {
/* 246 */                 target.loginTime = accountRecallInfo.loginTime;
/*     */               }
/* 248 */               if (accountRecallInfo.maxLevel > target.maxLevel)
/*     */               {
/* 250 */                 target.maxLevel = accountRecallInfo.maxLevel;
/*     */               }
/*     */             }
/*     */           }
/* 254 */           return true;
/*     */         }
/*     */         
/* 257 */       }.walk();
/* 258 */       PrintStream ps = new PrintStream("recall.txt", "UTF-8");
/* 259 */       for (Map.Entry<String, AccountRecallInfo> entry : openids.entrySet())
/*     */       {
/* 261 */         AccountRecallInfo value = (AccountRecallInfo)entry.getValue();
/* 262 */         ps.println(String.format("%s|%d|%d", new Object[] { entry.getKey(), Long.valueOf(value.loginTime), Integer.valueOf(value.maxLevel) }));
/*     */       }
/* 264 */       ps.close();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\PPBTableDataExporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */