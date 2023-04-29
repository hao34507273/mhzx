/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FightMonsterDeadRoundContext
/*    */ {
/*    */   final int fightCfgId;
/*    */   final Map<Integer, List<Integer>> mounsterCfgId2DeadRounds;
/*    */   
/*    */   public FightMonsterDeadRoundContext(int fightCfgId, Map<Integer, List<Integer>> mounsterCfgId2DeadRounds)
/*    */   {
/* 16 */     this.fightCfgId = fightCfgId;
/* 17 */     this.mounsterCfgId2DeadRounds = mounsterCfgId2DeadRounds;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\FightMonsterDeadRoundContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */