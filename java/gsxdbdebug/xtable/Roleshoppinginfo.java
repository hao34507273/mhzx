/*     */ package xtable;
/*     */ 
/*     */ import xbean.Item;
/*     */ import xbean.ShoppingInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Roleshoppinginfo
/*     */ {
/*     */   public static xdb.util.AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().roleshoppinginfo.getAutoKey();
/*     */   }
/*     */   
/*     */   public static xdb.util.AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().roleshoppinginfo.getAutoKey(localid);
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
/*     */   public static Long insert(ShoppingInfo value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, ShoppingInfo value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static ShoppingInfo get(Long key)
/*     */   {
/*  46 */     return (ShoppingInfo)_Tables_.getInstance().roleshoppinginfo.get(key);
/*     */   }
/*     */   
/*     */   public static ShoppingInfo get(Long key, ShoppingInfo value)
/*     */   {
/*  51 */     return (ShoppingInfo)_Tables_.getInstance().roleshoppinginfo.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, ShoppingInfo value)
/*     */   {
/*  56 */     _Tables_.getInstance().roleshoppinginfo.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, ShoppingInfo value)
/*     */   {
/*  61 */     _Tables_.getInstance().roleshoppinginfo.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().roleshoppinginfo.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, ShoppingInfo value)
/*     */   {
/*  71 */     return _Tables_.getInstance().roleshoppinginfo.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, ShoppingInfo value)
/*     */   {
/*  76 */     return _Tables_.getInstance().roleshoppinginfo.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().roleshoppinginfo.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, ShoppingInfo> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().roleshoppinginfo.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, ShoppingInfo> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().roleshoppinginfo;
/*     */   }
/*     */   
/*     */   public static ShoppingInfo select(Long key)
/*     */   {
/*  96 */     (ShoppingInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public ShoppingInfo get(ShoppingInfo v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectTotalnum(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ShoppingInfo v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getTotalnum());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Item selectItem(Long key)
/*     */   {
/* 118 */     (Item)getTable().select(key, new TField()
/*     */     {
/*     */       public Item get(ShoppingInfo v)
/*     */       {
/* 122 */         return v.getItem().toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectRoleid(Long key)
/*     */   {
/* 129 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(ShoppingInfo v)
/*     */       {
/* 133 */         return Long.valueOf(v.getRoleid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPrice(Long key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ShoppingInfo v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getPrice());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectExpire(Long key)
/*     */   {
/* 151 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(ShoppingInfo v)
/*     */       {
/* 155 */         return Long.valueOf(v.getExpire());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Roleshoppinginfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */