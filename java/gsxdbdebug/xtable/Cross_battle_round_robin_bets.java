/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.CrossBattleRoundRobinBet;
/*    */ import xbean.RoundRobinRoundBetInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Cross_battle_round_robin_bets
/*    */ {
/*    */   public static CrossBattleRoundRobinBet get(Long key)
/*    */   {
/* 12 */     return (CrossBattleRoundRobinBet)_Tables_.getInstance().cross_battle_round_robin_bets.get(key);
/*    */   }
/*    */   
/*    */   public static CrossBattleRoundRobinBet get(Long key, CrossBattleRoundRobinBet value)
/*    */   {
/* 17 */     return (CrossBattleRoundRobinBet)_Tables_.getInstance().cross_battle_round_robin_bets.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, CrossBattleRoundRobinBet value)
/*    */   {
/* 22 */     _Tables_.getInstance().cross_battle_round_robin_bets.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().cross_battle_round_robin_bets.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, CrossBattleRoundRobinBet value)
/*    */   {
/* 32 */     return _Tables_.getInstance().cross_battle_round_robin_bets.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().cross_battle_round_robin_bets.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, CrossBattleRoundRobinBet> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().cross_battle_round_robin_bets.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, CrossBattleRoundRobinBet> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().cross_battle_round_robin_bets;
/*    */   }
/*    */   
/*    */   public static CrossBattleRoundRobinBet select(Long key)
/*    */   {
/* 52 */     (CrossBattleRoundRobinBet)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public CrossBattleRoundRobinBet get(CrossBattleRoundRobinBet v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<RoundRobinRoundBetInfo> selectRound_bet_infos(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<RoundRobinRoundBetInfo> get(CrossBattleRoundRobinBet v)
/*    */       {
/* 67 */         return v.getRound_bet_infosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Cross_battle_round_robin_bets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */