/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.ExchangeUseItemInfo;
/*    */ import xbean.RoleExchangeUseItemInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role_exchange_use_item_infos
/*    */ {
/*    */   public static RoleExchangeUseItemInfo get(Long key)
/*    */   {
/* 12 */     return (RoleExchangeUseItemInfo)_Tables_.getInstance().role_exchange_use_item_infos.get(key);
/*    */   }
/*    */   
/*    */   public static RoleExchangeUseItemInfo get(Long key, RoleExchangeUseItemInfo value)
/*    */   {
/* 17 */     return (RoleExchangeUseItemInfo)_Tables_.getInstance().role_exchange_use_item_infos.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleExchangeUseItemInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role_exchange_use_item_infos.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role_exchange_use_item_infos.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleExchangeUseItemInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role_exchange_use_item_infos.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role_exchange_use_item_infos.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleExchangeUseItemInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role_exchange_use_item_infos.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleExchangeUseItemInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role_exchange_use_item_infos;
/*    */   }
/*    */   
/*    */   public static RoleExchangeUseItemInfo select(Long key)
/*    */   {
/* 52 */     (RoleExchangeUseItemInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleExchangeUseItemInfo get(RoleExchangeUseItemInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, ExchangeUseItemInfo> selectExchange_use_item_infos(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, ExchangeUseItemInfo> get(RoleExchangeUseItemInfo v)
/*    */       {
/* 67 */         return v.getExchange_use_item_infosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role_exchange_use_item_infos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */