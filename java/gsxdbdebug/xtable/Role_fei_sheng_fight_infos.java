/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.FeiShengFightInfo;
/*    */ import xbean.RoleFeiShengFightInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role_fei_sheng_fight_infos
/*    */ {
/*    */   public static RoleFeiShengFightInfo get(Long key)
/*    */   {
/* 12 */     return (RoleFeiShengFightInfo)_Tables_.getInstance().role_fei_sheng_fight_infos.get(key);
/*    */   }
/*    */   
/*    */   public static RoleFeiShengFightInfo get(Long key, RoleFeiShengFightInfo value)
/*    */   {
/* 17 */     return (RoleFeiShengFightInfo)_Tables_.getInstance().role_fei_sheng_fight_infos.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleFeiShengFightInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role_fei_sheng_fight_infos.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role_fei_sheng_fight_infos.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleFeiShengFightInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role_fei_sheng_fight_infos.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role_fei_sheng_fight_infos.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleFeiShengFightInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role_fei_sheng_fight_infos.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleFeiShengFightInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role_fei_sheng_fight_infos;
/*    */   }
/*    */   
/*    */   public static RoleFeiShengFightInfo select(Long key)
/*    */   {
/* 52 */     (RoleFeiShengFightInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleFeiShengFightInfo get(RoleFeiShengFightInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, FeiShengFightInfo> selectFei_sheng_fight_infos(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, FeiShengFightInfo> get(RoleFeiShengFightInfo v)
/*    */       {
/* 67 */         return v.getFei_sheng_fight_infosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role_fei_sheng_fight_infos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */