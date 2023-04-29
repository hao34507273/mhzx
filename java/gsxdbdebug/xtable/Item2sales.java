/*    */ package xtable;
/*    */ 
/*    */ import xbean.ItemSale;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Item2sales
/*    */ {
/*    */   public static ItemSale get(Long key)
/*    */   {
/* 12 */     return (ItemSale)_Tables_.getInstance().item2sales.get(key);
/*    */   }
/*    */   
/*    */   public static ItemSale get(Long key, ItemSale value)
/*    */   {
/* 17 */     return (ItemSale)_Tables_.getInstance().item2sales.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ItemSale value)
/*    */   {
/* 22 */     _Tables_.getInstance().item2sales.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().item2sales.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ItemSale value)
/*    */   {
/* 32 */     return _Tables_.getInstance().item2sales.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().item2sales.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, ItemSale> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().item2sales.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ItemSale> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().item2sales;
/*    */   }
/*    */   
/*    */   public static ItemSale select(Long key)
/*    */   {
/* 52 */     (ItemSale)getTable().select(key, new TField()
/*    */     {
/*    */       public ItemSale get(ItemSale v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectTotalsellnum(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(ItemSale v)
/*    */       {
/* 67 */         return Long.valueOf(v.getTotalsellnum());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectTotalsellmoney(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(ItemSale v)
/*    */       {
/* 78 */         return Long.valueOf(v.getTotalsellmoney());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectRecommendprice(Long key)
/*    */   {
/* 85 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(ItemSale v)
/*    */       {
/* 89 */         return Integer.valueOf(v.getRecommendprice());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectTotalgridnum(Long key)
/*    */   {
/* 96 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(ItemSale v)
/*    */       {
/* :0 */         return Integer.valueOf(v.getTotalgridnum());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Item2sales.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */