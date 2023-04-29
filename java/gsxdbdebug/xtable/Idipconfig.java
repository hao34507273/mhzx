/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.IdipConfigInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Idipconfig
/*     */ {
/*     */   public static IdipConfigInfo get(Long key)
/*     */   {
/*  12 */     return (IdipConfigInfo)_Tables_.getInstance().idipconfig.get(key);
/*     */   }
/*     */   
/*     */   public static IdipConfigInfo get(Long key, IdipConfigInfo value)
/*     */   {
/*  17 */     return (IdipConfigInfo)_Tables_.getInstance().idipconfig.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, IdipConfigInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().idipconfig.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().idipconfig.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, IdipConfigInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().idipconfig.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().idipconfig.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, IdipConfigInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().idipconfig.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, IdipConfigInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().idipconfig;
/*     */   }
/*     */   
/*     */   public static IdipConfigInfo select(Long key)
/*     */   {
/*  52 */     (IdipConfigInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public IdipConfigInfo get(IdipConfigInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.RoleRankForbid> selectRank_forbids(Long key)
/*     */   {
/*  63 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, xbean.RoleRankForbid> get(IdipConfigInfo v)
/*     */       {
/*  67 */         return v.getRank_forbidsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.IdipForbidInfo> selectZero_profits(Long key)
/*     */   {
/*  74 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, xbean.IdipForbidInfo> get(IdipConfigInfo v)
/*     */       {
/*  78 */         return v.getZero_profitsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.RolePlayForbid> selectPlay_forbids(Long key)
/*     */   {
/*  85 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, xbean.RolePlayForbid> get(IdipConfigInfo v)
/*     */       {
/*  89 */         return v.getPlay_forbidsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.RoleInfoForbid> selectInfo_forbids(Long key)
/*     */   {
/*  96 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, xbean.RoleInfoForbid> get(IdipConfigInfo v)
/*     */       {
/* 100 */         return v.getInfo_forbidsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.IdipNTimesAwardInfo> selectN_times_award(Long key)
/*     */   {
/* 107 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.IdipNTimesAwardInfo> get(IdipConfigInfo v)
/*     */       {
/* 111 */         return v.getN_times_awardAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.Set<Long> selectNotices(Long key)
/*     */   {
/* 118 */     (java.util.Set)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.Set<Long> get(IdipConfigInfo v)
/*     */       {
/* 122 */         return v.getNoticesAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.Set<Long> selectMarquees(Long key)
/*     */   {
/* 129 */     (java.util.Set)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.Set<Long> get(IdipConfigInfo v)
/*     */       {
/* 133 */         return v.getMarqueesAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.HideItemInfo> selectHide_items(Long key)
/*     */   {
/* 140 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.HideItemInfo> get(IdipConfigInfo v)
/*     */       {
/* 144 */         return v.getHide_itemsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Idipconfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */