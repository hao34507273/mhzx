/*    */ package xtable;
/*    */ 
/*    */ import xbean.LoginStatus;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Loginstatus
/*    */ {
/*    */   public static LoginStatus get(Long key)
/*    */   {
/* 12 */     return (LoginStatus)_Tables_.getInstance().loginstatus.get(key);
/*    */   }
/*    */   
/*    */   public static LoginStatus get(Long key, LoginStatus value)
/*    */   {
/* 17 */     return (LoginStatus)_Tables_.getInstance().loginstatus.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, LoginStatus value)
/*    */   {
/* 22 */     _Tables_.getInstance().loginstatus.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().loginstatus.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, LoginStatus value)
/*    */   {
/* 32 */     return _Tables_.getInstance().loginstatus.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().loginstatus.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, LoginStatus> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().loginstatus.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, LoginStatus> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().loginstatus;
/*    */   }
/*    */   
/*    */   public static LoginStatus select(Long key)
/*    */   {
/* 52 */     (LoginStatus)getTable().select(key, new TField()
/*    */     {
/*    */       public LoginStatus get(LoginStatus v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectStatus(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(LoginStatus v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getStatus());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Loginstatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */