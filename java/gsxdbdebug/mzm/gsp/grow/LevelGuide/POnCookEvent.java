/*    */ package mzm.gsp.grow.LevelGuide;
/*    */ 
/*    */ import mzm.gsp.lifeskill.event.CookEventProcedure;
/*    */ import mzm.gsp.lifeskill.event.LifeSkillArg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnCookEvent
/*    */   extends CookEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     return LevelGuideManager.shengChanPro((LifeSkillArg)this.arg, 2);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnCookEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */