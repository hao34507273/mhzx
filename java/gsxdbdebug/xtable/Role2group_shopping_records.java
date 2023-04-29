/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.RoleGroupShoppingRecord;
/*    */ import xbean.RoleGroupShoppingRecords;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2group_shopping_records
/*    */ {
/*    */   public static RoleGroupShoppingRecords get(Long key)
/*    */   {
/* 12 */     return (RoleGroupShoppingRecords)_Tables_.getInstance().role2group_shopping_records.get(key);
/*    */   }
/*    */   
/*    */   public static RoleGroupShoppingRecords get(Long key, RoleGroupShoppingRecords value)
/*    */   {
/* 17 */     return (RoleGroupShoppingRecords)_Tables_.getInstance().role2group_shopping_records.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleGroupShoppingRecords value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2group_shopping_records.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2group_shopping_records.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleGroupShoppingRecords value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2group_shopping_records.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2group_shopping_records.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleGroupShoppingRecords> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2group_shopping_records.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleGroupShoppingRecords> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2group_shopping_records;
/*    */   }
/*    */   
/*    */   public static RoleGroupShoppingRecords select(Long key)
/*    */   {
/* 52 */     (RoleGroupShoppingRecords)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleGroupShoppingRecords get(RoleGroupShoppingRecords v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, RoleGroupShoppingRecord> selectRecords(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, RoleGroupShoppingRecord> get(RoleGroupShoppingRecords v)
/*    */       {
/* 67 */         return v.getRecordsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2group_shopping_records.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */