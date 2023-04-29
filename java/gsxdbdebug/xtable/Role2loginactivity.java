/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.LoginActivityInfos;
/*    */ import xbean.LoginInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2loginactivity
/*    */ {
/*    */   public static LoginActivityInfos get(Long key)
/*    */   {
/* 12 */     return (LoginActivityInfos)_Tables_.getInstance().role2loginactivity.get(key);
/*    */   }
/*    */   
/*    */   public static LoginActivityInfos get(Long key, LoginActivityInfos value)
/*    */   {
/* 17 */     return (LoginActivityInfos)_Tables_.getInstance().role2loginactivity.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, LoginActivityInfos value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2loginactivity.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2loginactivity.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, LoginActivityInfos value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2loginactivity.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2loginactivity.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, LoginActivityInfos> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2loginactivity.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, LoginActivityInfos> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2loginactivity;
/*    */   }
/*    */   
/*    */   public static LoginActivityInfos select(Long key)
/*    */   {
/* 52 */     (LoginActivityInfos)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public LoginActivityInfos get(LoginActivityInfos v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, LoginInfo> selectLogin_infos(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, LoginInfo> get(LoginActivityInfos v)
/*    */       {
/* 67 */         return v.getLogin_infosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2loginactivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */