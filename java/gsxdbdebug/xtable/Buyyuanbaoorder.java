/*     */ package xtable;
/*     */ 
/*     */ import xbean.BuyYuanBaoOrder;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ import xdb.util.AutoKey;
/*     */ 
/*     */ public class Buyyuanbaoorder
/*     */ {
/*     */   public static AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().buyyuanbaoorder.getAutoKey();
/*     */   }
/*     */   
/*     */   public static AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().buyyuanbaoorder.getAutoKey(localid);
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
/*     */   public static Long insert(BuyYuanBaoOrder value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, BuyYuanBaoOrder value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static BuyYuanBaoOrder get(Long key)
/*     */   {
/*  46 */     return (BuyYuanBaoOrder)_Tables_.getInstance().buyyuanbaoorder.get(key);
/*     */   }
/*     */   
/*     */   public static BuyYuanBaoOrder get(Long key, BuyYuanBaoOrder value)
/*     */   {
/*  51 */     return (BuyYuanBaoOrder)_Tables_.getInstance().buyyuanbaoorder.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, BuyYuanBaoOrder value)
/*     */   {
/*  56 */     _Tables_.getInstance().buyyuanbaoorder.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, BuyYuanBaoOrder value)
/*     */   {
/*  61 */     _Tables_.getInstance().buyyuanbaoorder.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().buyyuanbaoorder.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, BuyYuanBaoOrder value)
/*     */   {
/*  71 */     return _Tables_.getInstance().buyyuanbaoorder.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, BuyYuanBaoOrder value)
/*     */   {
/*  76 */     return _Tables_.getInstance().buyyuanbaoorder.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().buyyuanbaoorder.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, BuyYuanBaoOrder> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().buyyuanbaoorder.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, BuyYuanBaoOrder> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().buyyuanbaoorder;
/*     */   }
/*     */   
/*     */   public static BuyYuanBaoOrder select(Long key)
/*     */   {
/*  96 */     (BuyYuanBaoOrder)getTable().select(key, new TField()
/*     */     {
/*     */       public BuyYuanBaoOrder get(BuyYuanBaoOrder v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectUserid(Long key)
/*     */   {
/* 107 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(BuyYuanBaoOrder v)
/*     */       {
/* 111 */         return v.getUserid();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectRoleid(Long key)
/*     */   {
/* 118 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(BuyYuanBaoOrder v)
/*     */       {
/* 122 */         return Long.valueOf(v.getRoleid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectServername(Long key)
/*     */   {
/* 129 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(BuyYuanBaoOrder v)
/*     */       {
/* 133 */         return v.getServername();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectCashnum(Long key)
/*     */   {
/* 140 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(BuyYuanBaoOrder v)
/*     */       {
/* 144 */         return Long.valueOf(v.getCashnum());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectYuanbaonum(Long key)
/*     */   {
/* 151 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(BuyYuanBaoOrder v)
/*     */       {
/* 155 */         return Long.valueOf(v.getYuanbaonum());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectBuytime(Long key)
/*     */   {
/* 162 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(BuyYuanBaoOrder v)
/*     */       {
/* 166 */         return Long.valueOf(v.getBuytime());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Buyyuanbaoorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */