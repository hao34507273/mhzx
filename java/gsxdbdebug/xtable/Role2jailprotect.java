/*    */ package xtable;
/*    */ 
/*    */ import xbean.JailProtectInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2jailprotect
/*    */ {
/*    */   public static JailProtectInfo get(Long key)
/*    */   {
/* 12 */     return (JailProtectInfo)_Tables_.getInstance().role2jailprotect.get(key);
/*    */   }
/*    */   
/*    */   public static JailProtectInfo get(Long key, JailProtectInfo value)
/*    */   {
/* 17 */     return (JailProtectInfo)_Tables_.getInstance().role2jailprotect.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, JailProtectInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2jailprotect.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2jailprotect.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, JailProtectInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2jailprotect.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2jailprotect.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, JailProtectInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2jailprotect.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, JailProtectInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2jailprotect;
/*    */   }
/*    */   
/*    */   public static JailProtectInfo select(Long key)
/*    */   {
/* 52 */     (JailProtectInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public JailProtectInfo get(JailProtectInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectSessionid(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(JailProtectInfo v)
/*    */       {
/* 67 */         return Long.valueOf(v.getSessionid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectLeavejailtimestamp(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(JailProtectInfo v)
/*    */       {
/* 78 */         return Long.valueOf(v.getLeavejailtimestamp());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2jailprotect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */