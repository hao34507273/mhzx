/*    */ package mzm.gsp.grow.LevelGuide;
/*    */ 
/*    */ import mzm.gsp.lifeskill.event.LifeSkillArg;
/*    */ import mzm.gsp.lifeskill.event.MakeWuQiFuEventProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnMakeWuQiFuEvent
/*    */   extends MakeWuQiFuEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     return LevelGuideManager.shengChanPro((LifeSkillArg)this.arg, 3);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnMakeWuQiFuEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */