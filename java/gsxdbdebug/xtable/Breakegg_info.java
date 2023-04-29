/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.BreakEggGameInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Breakegg_info
/*     */ {
/*     */   public static xdb.util.AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().breakegg_info.getAutoKey();
/*     */   }
/*     */   
/*     */   public static xdb.util.AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().breakegg_info.getAutoKey(localid);
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
/*     */   public static Long insert(BreakEggGameInfo value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, BreakEggGameInfo value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static BreakEggGameInfo get(Long key)
/*     */   {
/*  46 */     return (BreakEggGameInfo)_Tables_.getInstance().breakegg_info.get(key);
/*     */   }
/*     */   
/*     */   public static BreakEggGameInfo get(Long key, BreakEggGameInfo value)
/*     */   {
/*  51 */     return (BreakEggGameInfo)_Tables_.getInstance().breakegg_info.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, BreakEggGameInfo value)
/*     */   {
/*  56 */     _Tables_.getInstance().breakegg_info.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, BreakEggGameInfo value)
/*     */   {
/*  61 */     _Tables_.getInstance().breakegg_info.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().breakegg_info.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, BreakEggGameInfo value)
/*     */   {
/*  71 */     return _Tables_.getInstance().breakegg_info.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, BreakEggGameInfo value)
/*     */   {
/*  76 */     return _Tables_.getInstance().breakegg_info.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().breakegg_info.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, BreakEggGameInfo> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().breakegg_info.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, BreakEggGameInfo> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().breakegg_info;
/*     */   }
/*     */   
/*     */   public static BreakEggGameInfo select(Long key)
/*     */   {
/*  96 */     (BreakEggGameInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public BreakEggGameInfo get(BreakEggGameInfo v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectSession_id(Long key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(BreakEggGameInfo v)
/*     */       {
/* 111 */         return Long.valueOf(v.getSession_id());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectActivity_id(Long key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(BreakEggGameInfo v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getActivity_id());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectInviter_id(Long key)
/*     */   {
/* 129 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(BreakEggGameInfo v)
/*     */       {
/* 133 */         return Long.valueOf(v.getInviter_id());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.List<Long> selectRoleid_list(Long key)
/*     */   {
/* 140 */     (java.util.List)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.List<Long> get(BreakEggGameInfo v)
/*     */       {
/* 144 */         return v.getRoleid_listAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.List<Integer> selectReward_info_id(Long key)
/*     */   {
/* 151 */     (java.util.List)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.List<Integer> get(BreakEggGameInfo v)
/*     */       {
/* 155 */         return v.getReward_info_idAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.BreakEggInfo> selectIndex2break_egg_info(Long key)
/*     */   {
/* 162 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.BreakEggInfo> get(BreakEggGameInfo v)
/*     */       {
/* 166 */         return v.getIndex2break_egg_infoAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, Integer> selectRole_id2break_num(Long key)
/*     */   {
/* 173 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, Integer> get(BreakEggGameInfo v)
/*     */       {
/* 177 */         return v.getRole_id2break_numAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Breakegg_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */