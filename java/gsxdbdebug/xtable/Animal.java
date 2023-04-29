/*     */ package xtable;
/*     */ 
/*     */ import xbean.AdultStageInfo;
/*     */ import xbean.AnimalInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Animal
/*     */ {
/*     */   public static xdb.util.AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().animal.getAutoKey();
/*     */   }
/*     */   
/*     */   public static xdb.util.AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().animal.getAutoKey(localid);
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
/*     */   public static Long insert(AnimalInfo value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, AnimalInfo value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static AnimalInfo get(Long key)
/*     */   {
/*  46 */     return (AnimalInfo)_Tables_.getInstance().animal.get(key);
/*     */   }
/*     */   
/*     */   public static AnimalInfo get(Long key, AnimalInfo value)
/*     */   {
/*  51 */     return (AnimalInfo)_Tables_.getInstance().animal.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, AnimalInfo value)
/*     */   {
/*  56 */     _Tables_.getInstance().animal.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, AnimalInfo value)
/*     */   {
/*  61 */     _Tables_.getInstance().animal.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().animal.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, AnimalInfo value)
/*     */   {
/*  71 */     return _Tables_.getInstance().animal.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, AnimalInfo value)
/*     */   {
/*  76 */     return _Tables_.getInstance().animal.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().animal.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, AnimalInfo> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().animal.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, AnimalInfo> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().animal;
/*     */   }
/*     */   
/*     */   public static AnimalInfo select(Long key)
/*     */   {
/*  96 */     (AnimalInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public AnimalInfo get(AnimalInfo v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectStage(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(AnimalInfo v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getStage());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static xbean.EmbryoStageInfo selectEmbryo_info(Long key)
/*     */   {
/* 118 */     (xbean.EmbryoStageInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public xbean.EmbryoStageInfo get(AnimalInfo v)
/*     */       {
/* 122 */         return v.getEmbryo_info().toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static AdultStageInfo selectAdult_info(Long key)
/*     */   {
/* 129 */     (AdultStageInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public AdultStageInfo get(AnimalInfo v)
/*     */       {
/* 133 */         return v.getAdult_info().toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectName(Long key)
/*     */   {
/* 140 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(AnimalInfo v)
/*     */       {
/* 144 */         return v.getName();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectOwner(Long key)
/*     */   {
/* 151 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(AnimalInfo v)
/*     */       {
/* 155 */         return Long.valueOf(v.getOwner());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Animal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */