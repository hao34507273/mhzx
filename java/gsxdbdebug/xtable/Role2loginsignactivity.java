/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.LoginSignActivityInfos;
/*    */ import xbean.LoginSignInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2loginsignactivity
/*    */ {
/*    */   public static LoginSignActivityInfos get(Long key)
/*    */   {
/* 12 */     return (LoginSignActivityInfos)_Tables_.getInstance().role2loginsignactivity.get(key);
/*    */   }
/*    */   
/*    */   public static LoginSignActivityInfos get(Long key, LoginSignActivityInfos value)
/*    */   {
/* 17 */     return (LoginSignActivityInfos)_Tables_.getInstance().role2loginsignactivity.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, LoginSignActivityInfos value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2loginsignactivity.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2loginsignactivity.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, LoginSignActivityInfos value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2loginsignactivity.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2loginsignactivity.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, LoginSignActivityInfos> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2loginsignactivity.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, LoginSignActivityInfos> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2loginsignactivity;
/*    */   }
/*    */   
/*    */   public static LoginSignActivityInfos select(Long key)
/*    */   {
/* 52 */     (LoginSignActivityInfos)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public LoginSignActivityInfos get(LoginSignActivityInfos v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, LoginSignInfo> selectLogin_sign_infos(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, LoginSignInfo> get(LoginSignActivityInfos v)
/*    */       {
/* 67 */         return v.getLogin_sign_infosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2loginsignactivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */