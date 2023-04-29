/*     */ package xtable;
/*     */ 
/*     */ import xbean.DisableProtocolInfo;
/*     */ import xbean.GameServerInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Gamesrv
/*     */ {
/*     */   public static GameServerInfo get(Long key)
/*     */   {
/*  12 */     return (GameServerInfo)_Tables_.getInstance().gamesrv.get(key);
/*     */   }
/*     */   
/*     */   public static GameServerInfo get(Long key, GameServerInfo value)
/*     */   {
/*  17 */     return (GameServerInfo)_Tables_.getInstance().gamesrv.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, GameServerInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().gamesrv.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().gamesrv.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, GameServerInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().gamesrv.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().gamesrv.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, GameServerInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().gamesrv.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, GameServerInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().gamesrv;
/*     */   }
/*     */   
/*     */   public static GameServerInfo select(Long key)
/*     */   {
/*  52 */     (GameServerInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public GameServerInfo get(GameServerInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.List<String> selectZoneids(Long key)
/*     */   {
/*  63 */     (java.util.List)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.List<String> get(GameServerInfo v)
/*     */       {
/*  67 */         return v.getZoneidsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectDb_version(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(GameServerInfo v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getDb_version());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectTime_offset(Long key)
/*     */   {
/*  85 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(GameServerInfo v)
/*     */       {
/*  89 */         return Long.valueOf(v.getTime_offset());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectGsxdb_jar_md5(Long key)
/*     */   {
/*  96 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(GameServerInfo v)
/*     */       {
/* 100 */         return v.getGsxdb_jar_md5();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static DisableProtocolInfo selectDisable_protocol_info(Long key)
/*     */   {
/* 107 */     (DisableProtocolInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public DisableProtocolInfo get(GameServerInfo v)
/*     */       {
/* 111 */         return v.getDisable_protocol_info().toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.Map<Integer, xbean.ModuleFunSwitches> selectModule_fun_switches(Long key)
/*     */   {
/* 118 */     (java.util.Map)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.Map<Integer, xbean.ModuleFunSwitches> get(GameServerInfo v)
/*     */       {
/* 122 */         return v.getModule_fun_switchesAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectOpen_server_timestamp(Long key)
/*     */   {
/* 129 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(GameServerInfo v)
/*     */       {
/* 133 */         return Long.valueOf(v.getOpen_server_timestamp());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCreate_role_num(Long key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(GameServerInfo v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getCreate_role_num());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Gamesrv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */