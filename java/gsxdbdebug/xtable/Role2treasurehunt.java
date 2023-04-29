/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.Role2TreasureHuntInfo;
/*    */ import xbean.RoleTreasureHuntActivityInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2treasurehunt
/*    */ {
/*    */   public static Role2TreasureHuntInfo get(Long key)
/*    */   {
/* 12 */     return (Role2TreasureHuntInfo)_Tables_.getInstance().role2treasurehunt.get(key);
/*    */   }
/*    */   
/*    */   public static Role2TreasureHuntInfo get(Long key, Role2TreasureHuntInfo value)
/*    */   {
/* 17 */     return (Role2TreasureHuntInfo)_Tables_.getInstance().role2treasurehunt.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Role2TreasureHuntInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2treasurehunt.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2treasurehunt.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Role2TreasureHuntInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2treasurehunt.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2treasurehunt.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, Role2TreasureHuntInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2treasurehunt.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Role2TreasureHuntInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2treasurehunt;
/*    */   }
/*    */   
/*    */   public static Role2TreasureHuntInfo select(Long key)
/*    */   {
/* 52 */     (Role2TreasureHuntInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Role2TreasureHuntInfo get(Role2TreasureHuntInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, RoleTreasureHuntActivityInfo> selectTreasure_hunt_activity_map(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, RoleTreasureHuntActivityInfo> get(Role2TreasureHuntInfo v)
/*    */       {
/* 67 */         return v.getTreasure_hunt_activity_mapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2treasurehunt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */