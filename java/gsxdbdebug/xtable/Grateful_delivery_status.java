/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.DeliveryStatus;
/*    */ import xbean.DeliveryStatuses;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Grateful_delivery_status
/*    */ {
/*    */   public static DeliveryStatuses get(Long key)
/*    */   {
/* 12 */     return (DeliveryStatuses)_Tables_.getInstance().grateful_delivery_status.get(key);
/*    */   }
/*    */   
/*    */   public static DeliveryStatuses get(Long key, DeliveryStatuses value)
/*    */   {
/* 17 */     return (DeliveryStatuses)_Tables_.getInstance().grateful_delivery_status.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, DeliveryStatuses value)
/*    */   {
/* 22 */     _Tables_.getInstance().grateful_delivery_status.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().grateful_delivery_status.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, DeliveryStatuses value)
/*    */   {
/* 32 */     return _Tables_.getInstance().grateful_delivery_status.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().grateful_delivery_status.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, DeliveryStatuses> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().grateful_delivery_status.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, DeliveryStatuses> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().grateful_delivery_status;
/*    */   }
/*    */   
/*    */   public static DeliveryStatuses select(Long key)
/*    */   {
/* 52 */     (DeliveryStatuses)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public DeliveryStatuses get(DeliveryStatuses v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectDate(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Integer get(DeliveryStatuses v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getDate());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, DeliveryStatus> selectStatuses(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, DeliveryStatus> get(DeliveryStatuses v)
/*    */       {
/* 78 */         return v.getStatusesAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Grateful_delivery_status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */