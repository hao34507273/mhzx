/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.BountyInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2bounty
/*     */ {
/*     */   public static BountyInfo get(Long key)
/*     */   {
/*  12 */     return (BountyInfo)_Tables_.getInstance().role2bounty.get(key);
/*     */   }
/*     */   
/*     */   public static BountyInfo get(Long key, BountyInfo value)
/*     */   {
/*  17 */     return (BountyInfo)_Tables_.getInstance().role2bounty.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, BountyInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2bounty.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2bounty.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, BountyInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2bounty.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2bounty.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, BountyInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2bounty.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, BountyInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2bounty;
/*     */   }
/*     */   
/*     */   public static BountyInfo select(Long key)
/*     */   {
/*  52 */     (BountyInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public BountyInfo get(BountyInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectBountycount(Long key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(BountyInfo v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getBountycount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.BTaskInfo> selectTaskinfos(Long key)
/*     */   {
/*  74 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.BTaskInfo> get(BountyInfo v)
/*     */       {
/*  78 */         return v.getTaskinfosAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.BTaskData> selectDonetaskinfo(Long key)
/*     */   {
/*  85 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.BTaskData> get(BountyInfo v)
/*     */       {
/*  89 */         return v.getDonetaskinfoAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectUsedbirdnum(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(BountyInfo v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getUsedbirdnum());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectFreerefreshcount(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(BountyInfo v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getFreerefreshcount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPreguaranteecount(Long key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(BountyInfo v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getPreguaranteecount());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2bounty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */