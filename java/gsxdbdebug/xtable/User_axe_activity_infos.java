/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.AxeActivityInfo;
/*    */ import xbean.UserAxeActivityInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class User_axe_activity_infos
/*    */ {
/*    */   public static UserAxeActivityInfo get(String key)
/*    */   {
/* 12 */     return (UserAxeActivityInfo)_Tables_.getInstance().user_axe_activity_infos.get(key);
/*    */   }
/*    */   
/*    */   public static UserAxeActivityInfo get(String key, UserAxeActivityInfo value)
/*    */   {
/* 17 */     return (UserAxeActivityInfo)_Tables_.getInstance().user_axe_activity_infos.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(String key, UserAxeActivityInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().user_axe_activity_infos.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(String key)
/*    */   {
/* 27 */     _Tables_.getInstance().user_axe_activity_infos.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(String key, UserAxeActivityInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().user_axe_activity_infos.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(String key)
/*    */   {
/* 37 */     return _Tables_.getInstance().user_axe_activity_infos.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<String, UserAxeActivityInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().user_axe_activity_infos.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<String, UserAxeActivityInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().user_axe_activity_infos;
/*    */   }
/*    */   
/*    */   public static UserAxeActivityInfo select(String key)
/*    */   {
/* 52 */     (UserAxeActivityInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public UserAxeActivityInfo get(UserAxeActivityInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, AxeActivityInfo> selectAxe_activity_infos(String key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, AxeActivityInfo> get(UserAxeActivityInfo v)
/*    */       {
/* 67 */         return v.getAxe_activity_infosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\User_axe_activity_infos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */