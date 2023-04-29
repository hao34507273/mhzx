/*    */ package mzm.gsp.grow.LevelGuide;
/*    */ 
/*    */ import mzm.gsp.instance.event.MultiInstanceProArg;
/*    */ import mzm.gsp.instance.event.MultiInstanceProEventProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnMultiInstanceProEvent
/*    */   extends MultiInstanceProEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     if (!((MultiInstanceProArg)this.arg).isFirstTime)
/*    */     {
/* 17 */       return false;
/*    */     }
/* 19 */     int activityId = ((MultiInstanceProArg)this.arg).instanceCfgid;
/* 20 */     return LevelGuideManager.finishActivity(((MultiInstanceProArg)this.arg).roleid, activityId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnMultiInstanceProEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */