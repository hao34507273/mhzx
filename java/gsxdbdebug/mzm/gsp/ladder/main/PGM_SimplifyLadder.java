/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.SActivityCfg;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.ladder.confbean.SLadderConsts;
/*    */ 
/*    */ public class PGM_SimplifyLadder extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final int num;
/*    */   
/*    */   public PGM_SimplifyLadder(long gmRoleid, int num)
/*    */   {
/* 14 */     this.gmRoleid = gmRoleid;
/* 15 */     this.num = num;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     SActivityCfg activityCfg = SActivityCfg.get(SLadderConsts.getInstance().activityid);
/* 21 */     activityCfg.personMin = this.num;
/* 22 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("操作成功,%d人即可参加天梯活动", new Object[] { Integer.valueOf(this.num) }));
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\PGM_SimplifyLadder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */