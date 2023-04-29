/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.CrossBattleKnockoutActivityLocalInfo;
/*    */ import xbean.CrossBattleKnockoutLocalRankInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Cross_battle_knockout_local
/*    */ {
/*    */   public static CrossBattleKnockoutActivityLocalInfo get(Long key)
/*    */   {
/* 12 */     return (CrossBattleKnockoutActivityLocalInfo)_Tables_.getInstance().cross_battle_knockout_local.get(key);
/*    */   }
/*    */   
/*    */   public static CrossBattleKnockoutActivityLocalInfo get(Long key, CrossBattleKnockoutActivityLocalInfo value)
/*    */   {
/* 17 */     return (CrossBattleKnockoutActivityLocalInfo)_Tables_.getInstance().cross_battle_knockout_local.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, CrossBattleKnockoutActivityLocalInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().cross_battle_knockout_local.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().cross_battle_knockout_local.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, CrossBattleKnockoutActivityLocalInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().cross_battle_knockout_local.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().cross_battle_knockout_local.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, CrossBattleKnockoutActivityLocalInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().cross_battle_knockout_local.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, CrossBattleKnockoutActivityLocalInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().cross_battle_knockout_local;
/*    */   }
/*    */   
/*    */   public static CrossBattleKnockoutActivityLocalInfo select(Long key)
/*    */   {
/* 52 */     (CrossBattleKnockoutActivityLocalInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public CrossBattleKnockoutActivityLocalInfo get(CrossBattleKnockoutActivityLocalInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, xbean.CrossBattleKnockoutLocalInfo> selectKnockout_info_map(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, xbean.CrossBattleKnockoutLocalInfo> get(CrossBattleKnockoutActivityLocalInfo v)
/*    */       {
/* 67 */         return v.getKnockout_info_mapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, CrossBattleKnockoutLocalRankInfo> selectAward_server_info_map(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, CrossBattleKnockoutLocalRankInfo> get(CrossBattleKnockoutActivityLocalInfo v)
/*    */       {
/* 78 */         return v.getAward_server_info_mapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Cross_battle_knockout_local.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */