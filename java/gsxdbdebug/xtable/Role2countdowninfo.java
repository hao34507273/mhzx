/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.CountDownInfo;
/*    */ import xbean.RoleCountDownInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2countdowninfo
/*    */ {
/*    */   public static RoleCountDownInfo get(Long key)
/*    */   {
/* 12 */     return (RoleCountDownInfo)_Tables_.getInstance().role2countdowninfo.get(key);
/*    */   }
/*    */   
/*    */   public static RoleCountDownInfo get(Long key, RoleCountDownInfo value)
/*    */   {
/* 17 */     return (RoleCountDownInfo)_Tables_.getInstance().role2countdowninfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleCountDownInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2countdowninfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2countdowninfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleCountDownInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2countdowninfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2countdowninfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleCountDownInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2countdowninfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleCountDownInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2countdowninfo;
/*    */   }
/*    */   
/*    */   public static RoleCountDownInfo select(Long key)
/*    */   {
/* 52 */     (RoleCountDownInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleCountDownInfo get(RoleCountDownInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, CountDownInfo> selectCount_down_infos(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, CountDownInfo> get(RoleCountDownInfo v)
/*    */       {
/* 67 */         return v.getCount_down_infosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2countdowninfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */