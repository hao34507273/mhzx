/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.LoginSumActivityInfos;
/*    */ import xbean.LoginSumInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2loginsumactivity
/*    */ {
/*    */   public static LoginSumActivityInfos get(Long key)
/*    */   {
/* 12 */     return (LoginSumActivityInfos)_Tables_.getInstance().role2loginsumactivity.get(key);
/*    */   }
/*    */   
/*    */   public static LoginSumActivityInfos get(Long key, LoginSumActivityInfos value)
/*    */   {
/* 17 */     return (LoginSumActivityInfos)_Tables_.getInstance().role2loginsumactivity.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, LoginSumActivityInfos value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2loginsumactivity.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2loginsumactivity.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, LoginSumActivityInfos value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2loginsumactivity.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2loginsumactivity.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, LoginSumActivityInfos> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2loginsumactivity.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, LoginSumActivityInfos> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2loginsumactivity;
/*    */   }
/*    */   
/*    */   public static LoginSumActivityInfos select(Long key)
/*    */   {
/* 52 */     (LoginSumActivityInfos)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public LoginSumActivityInfos get(LoginSumActivityInfos v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, LoginSumInfo> selectLogin_sum_infos(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, LoginSumInfo> get(LoginSumActivityInfos v)
/*    */       {
/* 67 */         return v.getLogin_sum_infosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2loginsumactivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */