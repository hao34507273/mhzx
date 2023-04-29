/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.ItemUseCount;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2itemusecount
/*    */ {
/*    */   public static ItemUseCount get(Long key)
/*    */   {
/* 12 */     return (ItemUseCount)_Tables_.getInstance().role2itemusecount.get(key);
/*    */   }
/*    */   
/*    */   public static ItemUseCount get(Long key, ItemUseCount value)
/*    */   {
/* 17 */     return (ItemUseCount)_Tables_.getInstance().role2itemusecount.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ItemUseCount value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2itemusecount.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2itemusecount.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ItemUseCount value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2itemusecount.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2itemusecount.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, ItemUseCount> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2itemusecount.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ItemUseCount> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2itemusecount;
/*    */   }
/*    */   
/*    */   public static ItemUseCount select(Long key)
/*    */   {
/* 52 */     (ItemUseCount)getTable().select(key, new TField()
/*    */     {
/*    */       public ItemUseCount get(ItemUseCount v)
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
/*    */       public Long get(ItemUseCount v)
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
/*    */       public Map<Integer, Integer> get(ItemUseCount v)
/*    */       {
/* 78 */         return v.getId2countAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2itemusecount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */