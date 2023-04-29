/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.ApplyInfoMap;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2apply
/*     */ {
/*     */   public static ApplyInfoMap get(Long key)
/*     */   {
/*  12 */     return (ApplyInfoMap)_Tables_.getInstance().role2apply.get(key);
/*     */   }
/*     */   
/*     */   public static ApplyInfoMap get(Long key, ApplyInfoMap value)
/*     */   {
/*  17 */     return (ApplyInfoMap)_Tables_.getInstance().role2apply.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, ApplyInfoMap value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2apply.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2apply.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, ApplyInfoMap value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2apply.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2apply.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, ApplyInfoMap> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2apply.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, ApplyInfoMap> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2apply;
/*     */   }
/*     */   
/*     */   public static ApplyInfoMap select(Long key)
/*     */   {
/*  52 */     (ApplyInfoMap)getTable().select(key, new TField()
/*     */     {
/*     */       public ApplyInfoMap get(ApplyInfoMap v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.ApplyInfo> selectApplymap(Long key)
/*     */   {
/*  63 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, xbean.ApplyInfo> get(ApplyInfoMap v)
/*     */       {
/*  67 */         return v.getApplymapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectCleardatatime(Long key)
/*     */   {
/*  74 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(ApplyInfoMap v)
/*     */       {
/*  78 */         return Long.valueOf(v.getCleardatatime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectApplyaddcount(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ApplyInfoMap v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getApplyaddcount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectApplyaddrefusecount(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ApplyInfoMap v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getApplyaddrefusecount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectRefusebanchecktime(Long key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(ApplyInfoMap v)
/*     */       {
/* 111 */         return Long.valueOf(v.getRefusebanchecktime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, Integer> selectRefusecountmap(Long key)
/*     */   {
/* 118 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, Integer> get(ApplyInfoMap v)
/*     */       {
/* 122 */         return v.getRefusecountmapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2apply.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */