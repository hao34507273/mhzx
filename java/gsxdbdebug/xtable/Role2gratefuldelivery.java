/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.RoleDeliveryRecord;
/*    */ import xbean.RoleDeliveryRecords;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2gratefuldelivery
/*    */ {
/*    */   public static RoleDeliveryRecords get(Long key)
/*    */   {
/* 12 */     return (RoleDeliveryRecords)_Tables_.getInstance().role2gratefuldelivery.get(key);
/*    */   }
/*    */   
/*    */   public static RoleDeliveryRecords get(Long key, RoleDeliveryRecords value)
/*    */   {
/* 17 */     return (RoleDeliveryRecords)_Tables_.getInstance().role2gratefuldelivery.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleDeliveryRecords value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2gratefuldelivery.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2gratefuldelivery.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleDeliveryRecords value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2gratefuldelivery.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2gratefuldelivery.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleDeliveryRecords> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2gratefuldelivery.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleDeliveryRecords> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2gratefuldelivery;
/*    */   }
/*    */   
/*    */   public static RoleDeliveryRecords select(Long key)
/*    */   {
/* 52 */     (RoleDeliveryRecords)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleDeliveryRecords get(RoleDeliveryRecords v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, RoleDeliveryRecord> selectRecords(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, RoleDeliveryRecord> get(RoleDeliveryRecords v)
/*    */       {
/* 67 */         return v.getRecordsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2gratefuldelivery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */