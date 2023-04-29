/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.CrossBattleKnockoutBet;
/*    */ import xbean.KnockoutTypeBetInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Cross_battle_konckout_bets
/*    */ {
/*    */   public static CrossBattleKnockoutBet get(Long key)
/*    */   {
/* 12 */     return (CrossBattleKnockoutBet)_Tables_.getInstance().cross_battle_konckout_bets.get(key);
/*    */   }
/*    */   
/*    */   public static CrossBattleKnockoutBet get(Long key, CrossBattleKnockoutBet value)
/*    */   {
/* 17 */     return (CrossBattleKnockoutBet)_Tables_.getInstance().cross_battle_konckout_bets.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, CrossBattleKnockoutBet value)
/*    */   {
/* 22 */     _Tables_.getInstance().cross_battle_konckout_bets.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().cross_battle_konckout_bets.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, CrossBattleKnockoutBet value)
/*    */   {
/* 32 */     return _Tables_.getInstance().cross_battle_konckout_bets.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().cross_battle_konckout_bets.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, CrossBattleKnockoutBet> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().cross_battle_konckout_bets.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, CrossBattleKnockoutBet> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().cross_battle_konckout_bets;
/*    */   }
/*    */   
/*    */   public static CrossBattleKnockoutBet select(Long key)
/*    */   {
/* 52 */     (CrossBattleKnockoutBet)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public CrossBattleKnockoutBet get(CrossBattleKnockoutBet v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, KnockoutTypeBetInfo> selectKnockout_type_bet_infos(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, KnockoutTypeBetInfo> get(CrossBattleKnockoutBet v)
/*    */       {
/* 67 */         return v.getKnockout_type_bet_infosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Cross_battle_konckout_bets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */