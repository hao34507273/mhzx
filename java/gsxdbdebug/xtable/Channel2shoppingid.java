/*     */ package xtable;
/*     */ 
/*     */ import java.util.List;
/*     */ import xbean.ShoppingIds;
/*     */ import xdb.TTable;
/*     */ import xdb.util.AutoKey;
/*     */ 
/*     */ public class Channel2shoppingid
/*     */ {
/*     */   public static AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().channel2shoppingid.getAutoKey();
/*     */   }
/*     */   
/*     */   public static AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().channel2shoppingid.getAutoKey(localid);
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
/*     */   public static Long insert(ShoppingIds value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, ShoppingIds value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static ShoppingIds get(Long key)
/*     */   {
/*  46 */     return (ShoppingIds)_Tables_.getInstance().channel2shoppingid.get(key);
/*     */   }
/*     */   
/*     */   public static ShoppingIds get(Long key, ShoppingIds value)
/*     */   {
/*  51 */     return (ShoppingIds)_Tables_.getInstance().channel2shoppingid.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, ShoppingIds value)
/*     */   {
/*  56 */     _Tables_.getInstance().channel2shoppingid.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, ShoppingIds value)
/*     */   {
/*  61 */     _Tables_.getInstance().channel2shoppingid.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().channel2shoppingid.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, ShoppingIds value)
/*     */   {
/*  71 */     return _Tables_.getInstance().channel2shoppingid.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, ShoppingIds value)
/*     */   {
/*  76 */     return _Tables_.getInstance().channel2shoppingid.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().channel2shoppingid.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, ShoppingIds> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().channel2shoppingid.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, ShoppingIds> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().channel2shoppingid;
/*     */   }
/*     */   
/*     */   public static ShoppingIds select(Long key)
/*     */   {
/*  96 */     (ShoppingIds)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public ShoppingIds get(ShoppingIds v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Long> selectShoppingids(Long key)
/*     */   {
/* 107 */     (List)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public List<Long> get(ShoppingIds v)
/*     */       {
/* 111 */         return v.getShoppingidsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Channel2shoppingid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */