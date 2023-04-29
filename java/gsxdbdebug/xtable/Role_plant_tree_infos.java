/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.PlantTreeInfo;
/*    */ import xbean.RolePlantTreeInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role_plant_tree_infos
/*    */ {
/*    */   public static RolePlantTreeInfo get(Long key)
/*    */   {
/* 12 */     return (RolePlantTreeInfo)_Tables_.getInstance().role_plant_tree_infos.get(key);
/*    */   }
/*    */   
/*    */   public static RolePlantTreeInfo get(Long key, RolePlantTreeInfo value)
/*    */   {
/* 17 */     return (RolePlantTreeInfo)_Tables_.getInstance().role_plant_tree_infos.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RolePlantTreeInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role_plant_tree_infos.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role_plant_tree_infos.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RolePlantTreeInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role_plant_tree_infos.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role_plant_tree_infos.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RolePlantTreeInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role_plant_tree_infos.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RolePlantTreeInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role_plant_tree_infos;
/*    */   }
/*    */   
/*    */   public static RolePlantTreeInfo select(Long key)
/*    */   {
/* 52 */     (RolePlantTreeInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RolePlantTreeInfo get(RolePlantTreeInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, PlantTreeInfo> selectPlant_tree_infos(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, PlantTreeInfo> get(RolePlantTreeInfo v)
/*    */       {
/* 67 */         return v.getPlant_tree_infosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role_plant_tree_infos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */