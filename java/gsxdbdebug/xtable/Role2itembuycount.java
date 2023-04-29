/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.ItemBuyCount;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2itembuycount
/*    */ {
/*    */   public static ItemBuyCount get(Long key)
/*    */   {
/* 12 */     return (ItemBuyCount)_Tables_.getInstance().role2itembuycount.get(key);
/*    */   }
/*    */   
/*    */   public static ItemBuyCount get(Long key, ItemBuyCount value)
/*    */   {
/* 17 */     return (ItemBuyCount)_Tables_.getInstance().role2itembuycount.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ItemBuyCount value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2itembuycount.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2itembuycount.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ItemBuyCount value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2itembuycount.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2itembuycount.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, ItemBuyCount> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2itembuycount.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ItemBuyCount> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2itembuycount;
/*    */   }
/*    */   
/*    */   public static ItemBuyCount select(Long key)
/*    */   {
/* 52 */     (ItemBuyCount)getTable().select(key, new TField()
/*    */     {
/*    */       public ItemBuyCount get(ItemBuyCount v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectCleartime(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(ItemBuyCount v)
/*    */       {
/* 67 */         return Long.valueOf(v.getCleartime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectId2count(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(ItemBuyCount v)
/*    */       {
/* 78 */         return v.getId2countAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2itembuycount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */