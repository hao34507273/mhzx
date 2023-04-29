/*     */ package xtable;
/*     */ 
/*     */ import xbean.CoupleRide;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ import xdb.util.AutoKey;
/*     */ 
/*     */ public class Coupleride
/*     */ {
/*     */   public static AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().coupleride.getAutoKey();
/*     */   }
/*     */   
/*     */   public static AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().coupleride.getAutoKey(localid);
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
/*     */   public static Long insert(CoupleRide value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, CoupleRide value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static CoupleRide get(Long key)
/*     */   {
/*  46 */     return (CoupleRide)_Tables_.getInstance().coupleride.get(key);
/*     */   }
/*     */   
/*     */   public static CoupleRide get(Long key, CoupleRide value)
/*     */   {
/*  51 */     return (CoupleRide)_Tables_.getInstance().coupleride.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, CoupleRide value)
/*     */   {
/*  56 */     _Tables_.getInstance().coupleride.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, CoupleRide value)
/*     */   {
/*  61 */     _Tables_.getInstance().coupleride.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().coupleride.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, CoupleRide value)
/*     */   {
/*  71 */     return _Tables_.getInstance().coupleride.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, CoupleRide value)
/*     */   {
/*  76 */     return _Tables_.getInstance().coupleride.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().coupleride.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, CoupleRide> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().coupleride.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, CoupleRide> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().coupleride;
/*     */   }
/*     */   
/*     */   public static CoupleRide select(Long key)
/*     */   {
/*  96 */     (CoupleRide)getTable().select(key, new TField()
/*     */     {
/*     */       public CoupleRide get(CoupleRide v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectRolea(Long key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(CoupleRide v)
/*     */       {
/* 111 */         return Long.valueOf(v.getRolea());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectRoleb(Long key)
/*     */   {
/* 118 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(CoupleRide v)
/*     */       {
/* 122 */         return Long.valueOf(v.getRoleb());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Coupleride.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */