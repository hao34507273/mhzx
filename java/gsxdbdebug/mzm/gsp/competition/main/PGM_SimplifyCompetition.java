/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import java.util.concurrent.atomic.AtomicBoolean;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ 
/*    */ public class PGM_SimplifyCompetition extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmid;
/*    */   private final String onOrOff;
/*    */   
/*    */   public PGM_SimplifyCompetition(long gmid, String onOrOff)
/*    */   {
/* 13 */     this.gmid = gmid;
/* 14 */     this.onOrOff = onOrOff;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     if (this.onOrOff == null) {
/* 21 */       GmManager.getInstance().sendResultToGM(this.gmid, "格式错误：.simplifycompetition on|off");
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     if (this.onOrOff.equals("on")) {
/* 26 */       CompetitionManager.simplified.getAndSet(true);
/* 27 */       GmManager.getInstance().sendResultToAll("简化帮派竞赛门槛on：匹配时，不限制帮派创建时间、帮派总人数、帮派活跃度、满足参与等级的玩家数量；参加时，不限制入帮时间");
/*    */ 
/*    */     }
/* 30 */     else if (this.onOrOff.equals("off")) {
/* 31 */       CompetitionManager.simplified.getAndSet(false);
/* 32 */       GmManager.getInstance().sendResultToAll("简化帮派竞赛门槛off");
/*    */     }
/*    */     else {
/* 35 */       GmManager.getInstance().sendResultToGM(this.gmid, "格式错误：.simplifycompetition on|off");
/*    */     }
/*    */     
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\PGM_SimplifyCompetition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */