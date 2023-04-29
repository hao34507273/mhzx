/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.ExchangeDataHandlerInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class User2exchange_data_handler_info
/*    */ {
/*    */   public static ExchangeDataHandlerInfo get(String key)
/*    */   {
/* 12 */     return (ExchangeDataHandlerInfo)_Tables_.getInstance().user2exchange_data_handler_info.get(key);
/*    */   }
/*    */   
/*    */   public static ExchangeDataHandlerInfo get(String key, ExchangeDataHandlerInfo value)
/*    */   {
/* 17 */     return (ExchangeDataHandlerInfo)_Tables_.getInstance().user2exchange_data_handler_info.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(String key, ExchangeDataHandlerInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().user2exchange_data_handler_info.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(String key)
/*    */   {
/* 27 */     _Tables_.getInstance().user2exchange_data_handler_info.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(String key, ExchangeDataHandlerInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().user2exchange_data_handler_info.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(String key)
/*    */   {
/* 37 */     return _Tables_.getInstance().user2exchange_data_handler_info.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<String, ExchangeDataHandlerInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().user2exchange_data_handler_info.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<String, ExchangeDataHandlerInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().user2exchange_data_handler_info;
/*    */   }
/*    */   
/*    */   public static ExchangeDataHandlerInfo select(String key)
/*    */   {
/* 52 */     (ExchangeDataHandlerInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public ExchangeDataHandlerInfo get(ExchangeDataHandlerInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Long> selectSn_list(String key)
/*    */   {
/* 63 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Long> get(ExchangeDataHandlerInfo v)
/*    */       {
/* 67 */         return v.getSn_listAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\User2exchange_data_handler_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */