/*     */ package xtable;
/*     */ 
/*     */ import xbean.AwardTotalData;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ import xdb.TTableCache;
/*     */ 
/*     */ public class Role2totaldata
/*     */ {
/*     */   public static AwardTotalData get(Long key)
/*     */   {
/*  12 */     return (AwardTotalData)_Tables_.getInstance().role2totaldata.get(key);
/*     */   }
/*     */   
/*     */   public static AwardTotalData get(Long key, AwardTotalData value)
/*     */   {
/*  17 */     return (AwardTotalData)_Tables_.getInstance().role2totaldata.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, AwardTotalData value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2totaldata.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2totaldata.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, AwardTotalData value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2totaldata.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2totaldata.remove(key);
/*     */   }
/*     */   
/*     */   public static TTableCache<Long, AwardTotalData> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2totaldata.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, AwardTotalData> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2totaldata;
/*     */   }
/*     */   
/*     */   public static AwardTotalData select(Long key)
/*     */   {
/*  52 */     (AwardTotalData)getTable().select(key, new TField()
/*     */     {
/*     */       public AwardTotalData get(AwardTotalData v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectStarttime(Long key)
/*     */   {
/*  63 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(AwardTotalData v)
/*     */       {
/*  67 */         return Long.valueOf(v.getStarttime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectYuanbao(Long key)
/*     */   {
/*  74 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(AwardTotalData v)
/*     */       {
/*  78 */         return Long.valueOf(v.getYuanbao());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectGold(Long key)
/*     */   {
/*  85 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(AwardTotalData v)
/*     */       {
/*  89 */         return Long.valueOf(v.getGold());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectSilver(Long key)
/*     */   {
/*  96 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(AwardTotalData v)
/*     */       {
/* 100 */         return Long.valueOf(v.getSilver());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectGoldingot(Long key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(AwardTotalData v)
/*     */       {
/* 111 */         return Long.valueOf(v.getGoldingot());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectRoleexp(Long key)
/*     */   {
/* 118 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(AwardTotalData v)
/*     */       {
/* 122 */         return Long.valueOf(v.getRoleexp());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectPetexp(Long key)
/*     */   {
/* 129 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(AwardTotalData v)
/*     */       {
/* 133 */         return Long.valueOf(v.getPetexp());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectRolestartlv(Long key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(AwardTotalData v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getRolestartlv());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2totaldata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */