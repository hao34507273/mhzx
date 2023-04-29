/*    */ package xtable;
/*    */ 
/*    */ import xbean.Role2ChangeModelCardSessionInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2changemodelcardsessioninfo
/*    */ {
/*    */   public static Role2ChangeModelCardSessionInfo get(Long key)
/*    */   {
/* 12 */     return (Role2ChangeModelCardSessionInfo)_Tables_.getInstance().role2changemodelcardsessioninfo.get(key);
/*    */   }
/*    */   
/*    */   public static Role2ChangeModelCardSessionInfo get(Long key, Role2ChangeModelCardSessionInfo value)
/*    */   {
/* 17 */     return (Role2ChangeModelCardSessionInfo)_Tables_.getInstance().role2changemodelcardsessioninfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Role2ChangeModelCardSessionInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2changemodelcardsessioninfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2changemodelcardsessioninfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Role2ChangeModelCardSessionInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2changemodelcardsessioninfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2changemodelcardsessioninfo.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, Role2ChangeModelCardSessionInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2changemodelcardsessioninfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Role2ChangeModelCardSessionInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2changemodelcardsessioninfo;
/*    */   }
/*    */   
/*    */   public static Role2ChangeModelCardSessionInfo select(Long key)
/*    */   {
/* 52 */     (Role2ChangeModelCardSessionInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public Role2ChangeModelCardSessionInfo get(Role2ChangeModelCardSessionInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectMain_session_id(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(Role2ChangeModelCardSessionInfo v)
/*    */       {
/* 67 */         return Long.valueOf(v.getMain_session_id());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectExpire_notify_session_id(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(Role2ChangeModelCardSessionInfo v)
/*    */       {
/* 78 */         return Long.valueOf(v.getExpire_notify_session_id());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2changemodelcardsessioninfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */