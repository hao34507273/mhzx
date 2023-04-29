/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.Activity2Vigor;
/*    */ import xbean.RoleVigorHistory;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2vigor
/*    */ {
/*    */   public static Activity2Vigor get(Long key)
/*    */   {
/* 12 */     return (Activity2Vigor)_Tables_.getInstance().role2vigor.get(key);
/*    */   }
/*    */   
/*    */   public static Activity2Vigor get(Long key, Activity2Vigor value)
/*    */   {
/* 17 */     return (Activity2Vigor)_Tables_.getInstance().role2vigor.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Activity2Vigor value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2vigor.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2vigor.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Activity2Vigor value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2vigor.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2vigor.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, Activity2Vigor> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2vigor.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Activity2Vigor> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2vigor;
/*    */   }
/*    */   
/*    */   public static Activity2Vigor select(Long key)
/*    */   {
/* 52 */     (Activity2Vigor)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Activity2Vigor get(Activity2Vigor v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, RoleVigorHistory> selectAwardvigorhistorymap(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, RoleVigorHistory> get(Activity2Vigor v)
/*    */       {
/* 67 */         return v.getAwardvigorhistorymapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2vigor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */