/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.RoleCrossBattleBetProfitInfo;
/*    */ import xbean.RoleCrossBattleBetSeasonProfitInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role_cross_battle_bet_season_profot_infos
/*    */ {
/*    */   public static RoleCrossBattleBetSeasonProfitInfo get(Long key)
/*    */   {
/* 12 */     return (RoleCrossBattleBetSeasonProfitInfo)_Tables_.getInstance().role_cross_battle_bet_season_profot_infos.get(key);
/*    */   }
/*    */   
/*    */   public static RoleCrossBattleBetSeasonProfitInfo get(Long key, RoleCrossBattleBetSeasonProfitInfo value)
/*    */   {
/* 17 */     return (RoleCrossBattleBetSeasonProfitInfo)_Tables_.getInstance().role_cross_battle_bet_season_profot_infos.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleCrossBattleBetSeasonProfitInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role_cross_battle_bet_season_profot_infos.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role_cross_battle_bet_season_profot_infos.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleCrossBattleBetSeasonProfitInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role_cross_battle_bet_season_profot_infos.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role_cross_battle_bet_season_profot_infos.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleCrossBattleBetSeasonProfitInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role_cross_battle_bet_season_profot_infos.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleCrossBattleBetSeasonProfitInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role_cross_battle_bet_season_profot_infos;
/*    */   }
/*    */   
/*    */   public static RoleCrossBattleBetSeasonProfitInfo select(Long key)
/*    */   {
/* 52 */     (RoleCrossBattleBetSeasonProfitInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleCrossBattleBetSeasonProfitInfo get(RoleCrossBattleBetSeasonProfitInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, RoleCrossBattleBetProfitInfo> selectProfit_infos(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, RoleCrossBattleBetProfitInfo> get(RoleCrossBattleBetSeasonProfitInfo v)
/*    */       {
/* 67 */         return v.getProfit_infosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role_cross_battle_bet_season_profot_infos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */