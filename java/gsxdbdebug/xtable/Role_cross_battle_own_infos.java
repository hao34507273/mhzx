/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.CrossBattleOwnActivityInfo;
/*    */ import xbean.RoleCrossBattleOwnInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role_cross_battle_own_infos
/*    */ {
/*    */   public static RoleCrossBattleOwnInfo get(Long key)
/*    */   {
/* 12 */     return (RoleCrossBattleOwnInfo)_Tables_.getInstance().role_cross_battle_own_infos.get(key);
/*    */   }
/*    */   
/*    */   public static RoleCrossBattleOwnInfo get(Long key, RoleCrossBattleOwnInfo value)
/*    */   {
/* 17 */     return (RoleCrossBattleOwnInfo)_Tables_.getInstance().role_cross_battle_own_infos.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleCrossBattleOwnInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role_cross_battle_own_infos.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role_cross_battle_own_infos.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleCrossBattleOwnInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role_cross_battle_own_infos.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role_cross_battle_own_infos.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleCrossBattleOwnInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role_cross_battle_own_infos.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleCrossBattleOwnInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role_cross_battle_own_infos;
/*    */   }
/*    */   
/*    */   public static RoleCrossBattleOwnInfo select(Long key)
/*    */   {
/* 52 */     (RoleCrossBattleOwnInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleCrossBattleOwnInfo get(RoleCrossBattleOwnInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, CrossBattleOwnActivityInfo> selectCross_battle_own_activity_infos(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, CrossBattleOwnActivityInfo> get(RoleCrossBattleOwnInfo v)
/*    */       {
/* 67 */         return v.getCross_battle_own_activity_infosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role_cross_battle_own_infos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */