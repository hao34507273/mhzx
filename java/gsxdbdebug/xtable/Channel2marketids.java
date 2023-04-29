/*     */ package xtable;
/*     */ 
/*     */ import java.util.List;
/*     */ import xbean.MarketIds;
/*     */ import xdb.TTable;
/*     */ import xdb.util.AutoKey;
/*     */ 
/*     */ public class Channel2marketids
/*     */ {
/*     */   public static AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().channel2marketids.getAutoKey();
/*     */   }
/*     */   
/*     */   public static AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().channel2marketids.getAutoKey(localid);
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
/*     */   public static Long insert(MarketIds value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, MarketIds value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static MarketIds get(Long key)
/*     */   {
/*  46 */     return (MarketIds)_Tables_.getInstance().channel2marketids.get(key);
/*     */   }
/*     */   
/*     */   public static MarketIds get(Long key, MarketIds value)
/*     */   {
/*  51 */     return (MarketIds)_Tables_.getInstance().channel2marketids.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, MarketIds value)
/*     */   {
/*  56 */     _Tables_.getInstance().channel2marketids.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, MarketIds value)
/*     */   {
/*  61 */     _Tables_.getInstance().channel2marketids.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().channel2marketids.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, MarketIds value)
/*     */   {
/*  71 */     return _Tables_.getInstance().channel2marketids.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, MarketIds value)
/*     */   {
/*  76 */     return _Tables_.getInstance().channel2marketids.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().channel2marketids.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, MarketIds> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().channel2marketids.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, MarketIds> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().channel2marketids;
/*     */   }
/*     */   
/*     */   public static MarketIds select(Long key)
/*     */   {
/*  96 */     (MarketIds)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public MarketIds get(MarketIds v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Long> selectMarket_ids(Long key)
/*     */   {
/* 107 */     (List)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public List<Long> get(MarketIds v)
/*     */       {
/* 111 */         return v.getMarket_idsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Channel2marketids.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */