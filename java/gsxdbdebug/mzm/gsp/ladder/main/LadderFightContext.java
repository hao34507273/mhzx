/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.crossserver.main.RoamedMatchContext;
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ 
/*    */ public class LadderFightContext
/*    */   implements FightContext
/*    */ {
/*    */   public final int rankA;
/*    */   public final int rankB;
/* 14 */   public Map<Long, Integer> role2DisPlayRankMap = new HashMap();
/*    */   public final RoamedMatchContext roamedMatchContext;
/*    */   
/*    */   public LadderFightContext(RoamedMatchContext roamedMatchContext)
/*    */   {
/* 19 */     this.rankA = roamedMatchContext.getMatchRanking();
/* 20 */     this.rankB = roamedMatchContext.getOpponentsMatchRanking();
/* 21 */     this.roamedMatchContext = roamedMatchContext;
/*    */   }
/*    */   
/*    */   public boolean isRecordEnable()
/*    */   {
/* 26 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\LadderFightContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */