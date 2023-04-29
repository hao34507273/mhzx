/*     */ package xtable;
/*     */ 
/*     */ import xbean.ChineseValentineGame;
/*     */ import xbean.ChineseValentineRound;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Chinesevalentine
/*     */ {
/*     */   public static xdb.util.AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().chinesevalentine.getAutoKey();
/*     */   }
/*     */   
/*     */   public static xdb.util.AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().chinesevalentine.getAutoKey(localid);
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
/*     */   public static Long insert(ChineseValentineGame value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, ChineseValentineGame value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static ChineseValentineGame get(Long key)
/*     */   {
/*  46 */     return (ChineseValentineGame)_Tables_.getInstance().chinesevalentine.get(key);
/*     */   }
/*     */   
/*     */   public static ChineseValentineGame get(Long key, ChineseValentineGame value)
/*     */   {
/*  51 */     return (ChineseValentineGame)_Tables_.getInstance().chinesevalentine.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, ChineseValentineGame value)
/*     */   {
/*  56 */     _Tables_.getInstance().chinesevalentine.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, ChineseValentineGame value)
/*     */   {
/*  61 */     _Tables_.getInstance().chinesevalentine.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().chinesevalentine.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, ChineseValentineGame value)
/*     */   {
/*  71 */     return _Tables_.getInstance().chinesevalentine.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, ChineseValentineGame value)
/*     */   {
/*  76 */     return _Tables_.getInstance().chinesevalentine.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().chinesevalentine.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, ChineseValentineGame> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().chinesevalentine.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, ChineseValentineGame> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().chinesevalentine;
/*     */   }
/*     */   
/*     */   public static ChineseValentineGame select(Long key)
/*     */   {
/*  96 */     (ChineseValentineGame)getTable().select(key, new TField()
/*     */     {
/*     */       public ChineseValentineGame get(ChineseValentineGame v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectStarttime(Long key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(ChineseValentineGame v)
/*     */       {
/* 111 */         return Long.valueOf(v.getStarttime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.List<Long> selectRoleidlist(Long key)
/*     */   {
/* 118 */     (java.util.List)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.List<Long> get(ChineseValentineGame v)
/*     */       {
/* 122 */         return v.getRoleidlistAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static ChineseValentineRound selectRoundinfo(Long key)
/*     */   {
/* 129 */     (ChineseValentineRound)getTable().select(key, new TField()
/*     */     {
/*     */       public ChineseValentineRound get(ChineseValentineGame v)
/*     */       {
/* 133 */         return v.getRoundinfo().toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectRightcount(Long key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ChineseValentineGame v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getRightcount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectWrongcount(Long key)
/*     */   {
/* 151 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ChineseValentineGame v)
/*     */       {
/* 155 */         return Integer.valueOf(v.getWrongcount());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Chinesevalentine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */