/*    */ package mzm.gsp.grow.LevelGuide;
/*    */ 
/*    */ import mzm.gsp.jingji.event.JingjiActivityArg;
/*    */ import mzm.gsp.jingji.event.JingjiActivityFinishedProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnJingjiActivityFinished
/*    */   extends JingjiActivityFinishedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     if (!((JingjiActivityArg)this.arg).isIswin())
/*    */     {
/* 17 */       return false;
/*    */     }
/* 19 */     return LevelGuideManager.finishActivity(((JingjiActivityArg)this.arg).getRoleid(), ((JingjiActivityArg)this.arg).getActivityId());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnJingjiActivityFinished.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */