/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.Bag;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2changemodelcardbag
/*    */ {
/*    */   public static Bag get(Long key)
/*    */   {
/* 12 */     return (Bag)_Tables_.getInstance().role2changemodelcardbag.get(key);
/*    */   }
/*    */   
/*    */   public static Bag get(Long key, Bag value)
/*    */   {
/* 17 */     return (Bag)_Tables_.getInstance().role2changemodelcardbag.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Bag value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2changemodelcardbag.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2changemodelcardbag.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Bag value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2changemodelcardbag.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2changemodelcardbag.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, Bag> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2changemodelcardbag.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Bag> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2changemodelcardbag;
/*    */   }
/*    */   
/*    */   public static Bag select(Long key)
/*    */   {
/* 52 */     (Bag)getTable().select(key, new TField()
/*    */     {
/*    */       public Bag get(Bag v)
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
/*    */       public String get(Bag v)
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
/*    */       public Integer get(Bag v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getCapacity());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, xbean.Item> selectItems(Long key)
/*    */   {
/* 85 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, xbean.Item> get(Bag v)
/*    */       {
/* 89 */         return v.getItemsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2changemodelcardbag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */