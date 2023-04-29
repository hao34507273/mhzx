/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.BanquestInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2banquestinfo
/*     */ {
/*     */   public static BanquestInfo get(Long key)
/*     */   {
/*  12 */     return (BanquestInfo)_Tables_.getInstance().role2banquestinfo.get(key);
/*     */   }
/*     */   
/*     */   public static BanquestInfo get(Long key, BanquestInfo value)
/*     */   {
/*  17 */     return (BanquestInfo)_Tables_.getInstance().role2banquestinfo.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, BanquestInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2banquestinfo.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2banquestinfo.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, BanquestInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2banquestinfo.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2banquestinfo.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, BanquestInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2banquestinfo.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, BanquestInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2banquestinfo;
/*     */   }
/*     */   
/*     */   public static BanquestInfo select(Long key)
/*     */   {
/*  52 */     (BanquestInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public BanquestInfo get(BanquestInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, Integer> selectOwndishes(Long key)
/*     */   {
/*  63 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Integer> get(BanquestInfo v)
/*     */       {
/*  67 */         return v.getOwndishesAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectHoldcount(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(BanquestInfo v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getHoldcount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectHoldbanqueststate(Long key)
/*     */   {
/*  85 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(BanquestInfo v)
/*     */       {
/*  89 */         return Boolean.valueOf(v.getHoldbanqueststate());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLastbanqueststarttime(Long key)
/*     */   {
/*  96 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(BanquestInfo v)
/*     */       {
/* 100 */         return Long.valueOf(v.getLastbanqueststarttime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectDishescount(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(BanquestInfo v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getDishescount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.SingleBanquestInfo> selectJoinbanquestinfo(Long key)
/*     */   {
/* 118 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, xbean.SingleBanquestInfo> get(BanquestInfo v)
/*     */       {
/* 122 */         return v.getJoinbanquestinfoAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectFristjoinbanquesttime(Long key)
/*     */   {
/* 129 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(BanquestInfo v)
/*     */       {
/* 133 */         return Long.valueOf(v.getFristjoinbanquesttime());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2banquestinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */