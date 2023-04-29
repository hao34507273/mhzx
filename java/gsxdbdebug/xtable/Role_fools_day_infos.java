/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.FoolsDayInfo;
/*    */ import xbean.RoleFoolsDayInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role_fools_day_infos
/*    */ {
/*    */   public static RoleFoolsDayInfo get(Long key)
/*    */   {
/* 12 */     return (RoleFoolsDayInfo)_Tables_.getInstance().role_fools_day_infos.get(key);
/*    */   }
/*    */   
/*    */   public static RoleFoolsDayInfo get(Long key, RoleFoolsDayInfo value)
/*    */   {
/* 17 */     return (RoleFoolsDayInfo)_Tables_.getInstance().role_fools_day_infos.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleFoolsDayInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role_fools_day_infos.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role_fools_day_infos.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleFoolsDayInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role_fools_day_infos.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role_fools_day_infos.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleFoolsDayInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role_fools_day_infos.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleFoolsDayInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role_fools_day_infos;
/*    */   }
/*    */   
/*    */   public static RoleFoolsDayInfo select(Long key)
/*    */   {
/* 52 */     (RoleFoolsDayInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleFoolsDayInfo get(RoleFoolsDayInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, FoolsDayInfo> selectFools_day_infos(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, FoolsDayInfo> get(RoleFoolsDayInfo v)
/*    */       {
/* 67 */         return v.getFools_day_infosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role_fools_day_infos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */