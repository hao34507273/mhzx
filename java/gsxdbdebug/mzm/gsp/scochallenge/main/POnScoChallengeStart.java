/*    */ package mzm.gsp.scochallenge.main;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.SSchoolChallengeCfgConsts;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ public class POnScoChallengeStart
/*    */   extends LogicProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     if (OpenInterface.getOpenStatus(10))
/*    */     {
/* 17 */       ControllerInterface.triggerController(SSchoolChallengeCfgConsts.getInstance().CONTROLLER_ID);
/*    */     }
/*    */     
/*    */ 
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\scochallenge\main\POnScoChallengeStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */