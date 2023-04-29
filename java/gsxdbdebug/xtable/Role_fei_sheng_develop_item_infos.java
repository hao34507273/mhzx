/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.FeiShengDevelopItemInfo;
/*    */ import xbean.RoleFeiShengDevelopItemInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role_fei_sheng_develop_item_infos
/*    */ {
/*    */   public static RoleFeiShengDevelopItemInfo get(Long key)
/*    */   {
/* 12 */     return (RoleFeiShengDevelopItemInfo)_Tables_.getInstance().role_fei_sheng_develop_item_infos.get(key);
/*    */   }
/*    */   
/*    */   public static RoleFeiShengDevelopItemInfo get(Long key, RoleFeiShengDevelopItemInfo value)
/*    */   {
/* 17 */     return (RoleFeiShengDevelopItemInfo)_Tables_.getInstance().role_fei_sheng_develop_item_infos.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleFeiShengDevelopItemInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role_fei_sheng_develop_item_infos.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role_fei_sheng_develop_item_infos.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleFeiShengDevelopItemInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role_fei_sheng_develop_item_infos.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role_fei_sheng_develop_item_infos.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleFeiShengDevelopItemInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role_fei_sheng_develop_item_infos.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleFeiShengDevelopItemInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role_fei_sheng_develop_item_infos;
/*    */   }
/*    */   
/*    */   public static RoleFeiShengDevelopItemInfo select(Long key)
/*    */   {
/* 52 */     (RoleFeiShengDevelopItemInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleFeiShengDevelopItemInfo get(RoleFeiShengDevelopItemInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, FeiShengDevelopItemInfo> selectFei_sheng_develop_item_infos(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, FeiShengDevelopItemInfo> get(RoleFeiShengDevelopItemInfo v)
/*    */       {
/* 67 */         return v.getFei_sheng_develop_item_infosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role_fei_sheng_develop_item_infos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */