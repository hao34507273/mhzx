/*     */ package xtable;
/*     */ 
/*     */ import java.util.List;
/*     */ import xbean.DrawAndGuessInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Drawandguess_info
/*     */ {
/*     */   public static xdb.util.AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().drawandguess_info.getAutoKey();
/*     */   }
/*     */   
/*     */   public static xdb.util.AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().drawandguess_info.getAutoKey(localid);
/*     */   }
/*     */   
/*     */   public static Long nextKey()
/*     */   {
/*  22 */     return (Long)getAutoKey().next();
/*     */   }
/*     */   
/*     */   public static Long nextKey(int localid)
/*     */   {
/*  27 */     return (Long)getAutoKey(localid).next();
/*     */   }
/*     */   
/*     */   public static Long insert(DrawAndGuessInfo value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, DrawAndGuessInfo value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static DrawAndGuessInfo get(Long key)
/*     */   {
/*  46 */     return (DrawAndGuessInfo)_Tables_.getInstance().drawandguess_info.get(key);
/*     */   }
/*     */   
/*     */   public static DrawAndGuessInfo get(Long key, DrawAndGuessInfo value)
/*     */   {
/*  51 */     return (DrawAndGuessInfo)_Tables_.getInstance().drawandguess_info.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, DrawAndGuessInfo value)
/*     */   {
/*  56 */     _Tables_.getInstance().drawandguess_info.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, DrawAndGuessInfo value)
/*     */   {
/*  61 */     _Tables_.getInstance().drawandguess_info.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().drawandguess_info.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, DrawAndGuessInfo value)
/*     */   {
/*  71 */     return _Tables_.getInstance().drawandguess_info.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, DrawAndGuessInfo value)
/*     */   {
/*  76 */     return _Tables_.getInstance().drawandguess_info.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().drawandguess_info.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, DrawAndGuessInfo> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().drawandguess_info.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, DrawAndGuessInfo> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().drawandguess_info;
/*     */   }
/*     */   
/*     */   public static Long selectSession_id(Long key)
/*     */   {
/*  96 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(DrawAndGuessInfo v)
/*     */       {
/* 100 */         return Long.valueOf(v.getSession_id());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectStart_time(Long key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(DrawAndGuessInfo v)
/*     */       {
/* 111 */         return Long.valueOf(v.getStart_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCfg_id(Long key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(DrawAndGuessInfo v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getCfg_id());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectDrawer_id(Long key)
/*     */   {
/* 129 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(DrawAndGuessInfo v)
/*     */       {
/* 133 */         return Long.valueOf(v.getDrawer_id());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Long> selectAll_roleids(Long key)
/*     */   {
/* 140 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<Long> get(DrawAndGuessInfo v)
/*     */       {
/* 144 */         return v.getAll_roleidsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Long> selectSuc_roleids(Long key)
/*     */   {
/* 151 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<Long> get(DrawAndGuessInfo v)
/*     */       {
/* 155 */         return v.getSuc_roleidsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.Map<Long, Long> selectRoleids2answer_time(Long key)
/*     */   {
/* 162 */     (java.util.Map)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.Map<Long, Long> get(DrawAndGuessInfo v)
/*     */       {
/* 166 */         return v.getRoleids2answer_timeAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Drawandguess_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */