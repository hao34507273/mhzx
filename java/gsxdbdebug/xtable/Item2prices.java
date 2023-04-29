/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.Channels;
/*    */ import xbean.Prices;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Item2prices
/*    */ {
/*    */   public static Prices get(Long key)
/*    */   {
/* 12 */     return (Prices)_Tables_.getInstance().item2prices.get(key);
/*    */   }
/*    */   
/*    */   public static Prices get(Long key, Prices value)
/*    */   {
/* 17 */     return (Prices)_Tables_.getInstance().item2prices.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Prices value)
/*    */   {
/* 22 */     _Tables_.getInstance().item2prices.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().item2prices.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Prices value)
/*    */   {
/* 32 */     return _Tables_.getInstance().item2prices.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().item2prices.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, Prices> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().item2prices.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Prices> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().item2prices;
/*    */   }
/*    */   
/*    */   public static Prices select(Long key)
/*    */   {
/* 52 */     (Prices)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Prices get(Prices v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Channels> selectPrice2channels(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, Channels> get(Prices v)
/*    */       {
/* 67 */         return v.getPrice2channelsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Item2prices.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */