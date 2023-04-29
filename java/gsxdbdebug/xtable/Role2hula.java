/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.HulaInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2hula
/*     */ {
/*     */   public static HulaInfo get(Long key)
/*     */   {
/*  12 */     return (HulaInfo)_Tables_.getInstance().role2hula.get(key);
/*     */   }
/*     */   
/*     */   public static HulaInfo get(Long key, HulaInfo value)
/*     */   {
/*  17 */     return (HulaInfo)_Tables_.getInstance().role2hula.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, HulaInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2hula.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2hula.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, HulaInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2hula.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2hula.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, HulaInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2hula.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, HulaInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2hula;
/*     */   }
/*     */   
/*     */   public static HulaInfo select(Long key)
/*     */   {
/*  52 */     (HulaInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public HulaInfo get(HulaInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPoint(Long key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(HulaInfo v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getPoint());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, Integer> selectDelete_type_2_count(Long key)
/*     */   {
/*  74 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Integer> get(HulaInfo v)
/*     */       {
/*  78 */         return v.getDelete_type_2_countAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, Integer> selectKill_monsterid_2_count(Long key)
/*     */   {
/*  85 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Integer> get(HulaInfo v)
/*     */       {
/*  89 */         return v.getKill_monsterid_2_countAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectWorldid(Long key)
/*     */   {
/*  96 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(HulaInfo v)
/*     */       {
/* 100 */         return Long.valueOf(v.getWorldid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, Integer> selectDelete_monsterid_2_count(Long key)
/*     */   {
/* 107 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Integer> get(HulaInfo v)
/*     */       {
/* 111 */         return v.getDelete_monsterid_2_countAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectTurnpoint(Long key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(HulaInfo v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getTurnpoint());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2hula.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */