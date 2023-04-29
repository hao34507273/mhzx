/*    */ package xtable;
/*    */ 
/*    */ import xbean.ShoppingGroupSessionInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Shopping_group_session_info
/*    */ {
/*    */   public static ShoppingGroupSessionInfo get(Long key)
/*    */   {
/* 12 */     return (ShoppingGroupSessionInfo)_Tables_.getInstance().shopping_group_session_info.get(key);
/*    */   }
/*    */   
/*    */   public static ShoppingGroupSessionInfo get(Long key, ShoppingGroupSessionInfo value)
/*    */   {
/* 17 */     return (ShoppingGroupSessionInfo)_Tables_.getInstance().shopping_group_session_info.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ShoppingGroupSessionInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().shopping_group_session_info.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().shopping_group_session_info.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ShoppingGroupSessionInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().shopping_group_session_info.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().shopping_group_session_info.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, ShoppingGroupSessionInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().shopping_group_session_info.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ShoppingGroupSessionInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().shopping_group_session_info;
/*    */   }
/*    */   
/*    */   public static ShoppingGroupSessionInfo select(Long key)
/*    */   {
/* 52 */     (ShoppingGroupSessionInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public ShoppingGroupSessionInfo get(ShoppingGroupSessionInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectSession_id(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(ShoppingGroupSessionInfo v)
/*    */       {
/* 67 */         return Long.valueOf(v.getSession_id());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Shopping_group_session_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */