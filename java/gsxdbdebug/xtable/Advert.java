/*     */ package xtable;
/*     */ 
/*     */ import xbean.AdvertInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ import xdb.util.AutoKey;
/*     */ 
/*     */ public class Advert
/*     */ {
/*     */   public static AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().advert.getAutoKey();
/*     */   }
/*     */   
/*     */   public static AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().advert.getAutoKey(localid);
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
/*     */   public static Long insert(AdvertInfo value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, AdvertInfo value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static AdvertInfo get(Long key)
/*     */   {
/*  46 */     return (AdvertInfo)_Tables_.getInstance().advert.get(key);
/*     */   }
/*     */   
/*     */   public static AdvertInfo get(Long key, AdvertInfo value)
/*     */   {
/*  51 */     return (AdvertInfo)_Tables_.getInstance().advert.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, AdvertInfo value)
/*     */   {
/*  56 */     _Tables_.getInstance().advert.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, AdvertInfo value)
/*     */   {
/*  61 */     _Tables_.getInstance().advert.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().advert.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, AdvertInfo value)
/*     */   {
/*  71 */     return _Tables_.getInstance().advert.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, AdvertInfo value)
/*     */   {
/*  76 */     return _Tables_.getInstance().advert.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().advert.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, AdvertInfo> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().advert.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, AdvertInfo> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().advert;
/*     */   }
/*     */   
/*     */   public static AdvertInfo select(Long key)
/*     */   {
/*  96 */     (AdvertInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public AdvertInfo get(AdvertInfo v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectAdverttype(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(AdvertInfo v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getAdverttype());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectRelease_timestamp(Long key)
/*     */   {
/* 118 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(AdvertInfo v)
/*     */       {
/* 122 */         return Long.valueOf(v.getRelease_timestamp());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectContent(Long key)
/*     */   {
/* 129 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(AdvertInfo v)
/*     */       {
/* 133 */         return v.getContent();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectIstop(Long key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(AdvertInfo v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getIstop());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Advert.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */