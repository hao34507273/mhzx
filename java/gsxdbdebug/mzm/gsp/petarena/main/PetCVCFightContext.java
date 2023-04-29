/*    */ package mzm.gsp.petarena.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ 
/*    */ public class PetCVCFightContext
/*    */   implements FightContext
/*    */ {
/*    */   public final RankInfo activeRankInfo;
/*    */   public final RankInfo passiveRankInfo;
/* 13 */   public final List<PetArenaFightInfo> activeInfos = new ArrayList();
/* 14 */   public final List<PetArenaFightInfo> passiveInfos = new ArrayList();
/*    */   
/*    */   public PetCVCFightContext(RankInfo activeRankInfo, RankInfo opponentRankInfo)
/*    */   {
/* 18 */     this.activeRankInfo = activeRankInfo;
/* 19 */     this.passiveRankInfo = opponentRankInfo;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isRecordEnable()
/*    */   {
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\PetCVCFightContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */