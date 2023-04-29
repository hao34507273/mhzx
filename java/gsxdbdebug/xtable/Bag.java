/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.Item;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Bag
/*    */ {
/*    */   public static xbean.Bag get(Long key)
/*    */   {
/* 12 */     return (xbean.Bag)_Tables_.getInstance().bag.get(key);
/*    */   }
/*    */   
/*    */   public static xbean.Bag get(Long key, xbean.Bag value)
/*    */   {
/* 17 */     return (xbean.Bag)_Tables_.getInstance().bag.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, xbean.Bag value)
/*    */   {
/* 22 */     _Tables_.getInstance().bag.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().bag.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, xbean.Bag value)
/*    */   {
/* 32 */     return _Tables_.getInstance().bag.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().bag.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, xbean.Bag> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().bag.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, xbean.Bag> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().bag;
/*    */   }
/*    */   
/*    */   public static xbean.Bag select(Long key)
/*    */   {
/* 52 */     (xbean.Bag)getTable().select(key, new TField()
/*    */     {
/*    */       public xbean.Bag get(xbean.Bag v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static String selectBagname(Long key)
/*    */   {
/* 63 */     (String)getTable().select(key, new TField()
/*    */     {
/*    */       public String get(xbean.Bag v)
/*    */       {
/* 67 */         return v.getBagname();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectCapacity(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(xbean.Bag v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getCapacity());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Item> selectItems(Long key)
/*    */   {
/* 85 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Item> get(xbean.Bag v)
/*    */       {
/* 89 */         return v.getItemsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Bag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */