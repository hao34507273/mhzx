/*    */ package xtable;
/*    */ 
/*    */ import xbean.DailyGiftInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class User2dailygift
/*    */ {
/*    */   public static DailyGiftInfo get(String key)
/*    */   {
/* 12 */     return (DailyGiftInfo)_Tables_.getInstance().user2dailygift.get(key);
/*    */   }
/*    */   
/*    */   public static DailyGiftInfo get(String key, DailyGiftInfo value)
/*    */   {
/* 17 */     return (DailyGiftInfo)_Tables_.getInstance().user2dailygift.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(String key, DailyGiftInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().user2dailygift.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(String key)
/*    */   {
/* 27 */     _Tables_.getInstance().user2dailygift.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(String key, DailyGiftInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().user2dailygift.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(String key)
/*    */   {
/* 37 */     return _Tables_.getInstance().user2dailygift.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<String, DailyGiftInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().user2dailygift.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<String, DailyGiftInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().user2dailygift;
/*    */   }
/*    */   
/*    */   public static DailyGiftInfo select(String key)
/*    */   {
/* 52 */     (DailyGiftInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public DailyGiftInfo get(DailyGiftInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectReceive_time(String key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(DailyGiftInfo v)
/*    */       {
/* 67 */         return Long.valueOf(v.getReceive_time());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\User2dailygift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */