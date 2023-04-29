/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.CrossBattleKnockoutOwnServerActivityInfo;
/*    */ import xbean.CrossBattleOwnServerKnockoutInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Cross_battle_knockout_own_server
/*    */ {
/*    */   public static CrossBattleKnockoutOwnServerActivityInfo get(Long key)
/*    */   {
/* 12 */     return (CrossBattleKnockoutOwnServerActivityInfo)_Tables_.getInstance().cross_battle_knockout_own_server.get(key);
/*    */   }
/*    */   
/*    */   public static CrossBattleKnockoutOwnServerActivityInfo get(Long key, CrossBattleKnockoutOwnServerActivityInfo value)
/*    */   {
/* 17 */     return (CrossBattleKnockoutOwnServerActivityInfo)_Tables_.getInstance().cross_battle_knockout_own_server.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, CrossBattleKnockoutOwnServerActivityInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().cross_battle_knockout_own_server.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().cross_battle_knockout_own_server.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, CrossBattleKnockoutOwnServerActivityInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().cross_battle_knockout_own_server.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().cross_battle_knockout_own_server.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, CrossBattleKnockoutOwnServerActivityInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().cross_battle_knockout_own_server.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, CrossBattleKnockoutOwnServerActivityInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().cross_battle_knockout_own_server;
/*    */   }
/*    */   
/*    */   public static CrossBattleKnockoutOwnServerActivityInfo select(Long key)
/*    */   {
/* 52 */     (CrossBattleKnockoutOwnServerActivityInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public CrossBattleKnockoutOwnServerActivityInfo get(CrossBattleKnockoutOwnServerActivityInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, CrossBattleOwnServerKnockoutInfo> selectKnockout_info_map(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, CrossBattleOwnServerKnockoutInfo> get(CrossBattleKnockoutOwnServerActivityInfo v)
/*    */       {
/* 67 */         return v.getKnockout_info_mapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Cross_battle_knockout_own_server.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */