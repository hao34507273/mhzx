/*    */ package mzm.gsp.grow.LevelGuide;
/*    */ 
/*    */ import mzm.gsp.lifeskill.event.LianYaoEventProcedure;
/*    */ import mzm.gsp.lifeskill.event.LifeSkillArg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnLianYaoEvent
/*    */   extends LianYaoEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     return LevelGuideManager.shengChanPro((LifeSkillArg)this.arg, 1);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnLianYaoEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */