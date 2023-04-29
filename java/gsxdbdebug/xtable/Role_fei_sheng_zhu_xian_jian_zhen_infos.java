/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.FeiShengZhuXianJianZhenInfo;
/*    */ import xbean.RoleFeiShengZhuXianJianZhenInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role_fei_sheng_zhu_xian_jian_zhen_infos
/*    */ {
/*    */   public static RoleFeiShengZhuXianJianZhenInfo get(Long key)
/*    */   {
/* 12 */     return (RoleFeiShengZhuXianJianZhenInfo)_Tables_.getInstance().role_fei_sheng_zhu_xian_jian_zhen_infos.get(key);
/*    */   }
/*    */   
/*    */   public static RoleFeiShengZhuXianJianZhenInfo get(Long key, RoleFeiShengZhuXianJianZhenInfo value)
/*    */   {
/* 17 */     return (RoleFeiShengZhuXianJianZhenInfo)_Tables_.getInstance().role_fei_sheng_zhu_xian_jian_zhen_infos.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleFeiShengZhuXianJianZhenInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role_fei_sheng_zhu_xian_jian_zhen_infos.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role_fei_sheng_zhu_xian_jian_zhen_infos.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleFeiShengZhuXianJianZhenInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role_fei_sheng_zhu_xian_jian_zhen_infos.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role_fei_sheng_zhu_xian_jian_zhen_infos.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleFeiShengZhuXianJianZhenInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role_fei_sheng_zhu_xian_jian_zhen_infos.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleFeiShengZhuXianJianZhenInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role_fei_sheng_zhu_xian_jian_zhen_infos;
/*    */   }
/*    */   
/*    */   public static RoleFeiShengZhuXianJianZhenInfo select(Long key)
/*    */   {
/* 52 */     (RoleFeiShengZhuXianJianZhenInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleFeiShengZhuXianJianZhenInfo get(RoleFeiShengZhuXianJianZhenInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, FeiShengZhuXianJianZhenInfo> selectFei_sheng_zhu_xian_jian_zhen_infos(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, FeiShengZhuXianJianZhenInfo> get(RoleFeiShengZhuXianJianZhenInfo v)
/*    */       {
/* 67 */         return v.getFei_sheng_zhu_xian_jian_zhen_infosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role_fei_sheng_zhu_xian_jian_zhen_infos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */