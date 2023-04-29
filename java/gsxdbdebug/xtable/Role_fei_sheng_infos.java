/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.FeiShengInfo;
/*    */ import xbean.RoleFeiShengInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role_fei_sheng_infos
/*    */ {
/*    */   public static RoleFeiShengInfo get(Long key)
/*    */   {
/* 12 */     return (RoleFeiShengInfo)_Tables_.getInstance().role_fei_sheng_infos.get(key);
/*    */   }
/*    */   
/*    */   public static RoleFeiShengInfo get(Long key, RoleFeiShengInfo value)
/*    */   {
/* 17 */     return (RoleFeiShengInfo)_Tables_.getInstance().role_fei_sheng_infos.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleFeiShengInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role_fei_sheng_infos.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role_fei_sheng_infos.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleFeiShengInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role_fei_sheng_infos.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role_fei_sheng_infos.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleFeiShengInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role_fei_sheng_infos.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleFeiShengInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role_fei_sheng_infos;
/*    */   }
/*    */   
/*    */   public static RoleFeiShengInfo select(Long key)
/*    */   {
/* 52 */     (RoleFeiShengInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleFeiShengInfo get(RoleFeiShengInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, FeiShengInfo> selectFei_sheng_infos(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, FeiShengInfo> get(RoleFeiShengInfo v)
/*    */       {
/* 67 */         return v.getFei_sheng_infosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role_fei_sheng_infos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */