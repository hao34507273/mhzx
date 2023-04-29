/*    */ package mzm.gsp.memorycompetition.romanticdance;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity2.confbean.SRomanticDanceConsts;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeRunnable;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ 
/*    */ public class ROnOpenChange
/*    */   extends OpenChangeRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 15 */     if (((OpenChangeComplexArg)this.arg).getType() != 231)
/*    */     {
/* 17 */       return;
/*    */     }
/*    */     
/* 20 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 21 */     long startTime = ActivityInterface.getActivityStartTime(SRomanticDanceConsts.getInstance().activity_cfg_id);
/* 22 */     long endTime = ActivityInterface.getActivityEndTime(SRomanticDanceConsts.getInstance().activity_cfg_id);
/*    */     
/* 24 */     if ((startTime > now) || (now > endTime))
/*    */     {
/* 26 */       return;
/*    */     }
/*    */     
/* 29 */     boolean isOpen = ((OpenChangeComplexArg)this.arg).isOpen();
/* 30 */     if (isOpen)
/*    */     {
/*    */ 
/* 33 */       ControllerInterface.triggerController(SRomanticDanceConsts.getInstance().ControllerId);
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 38 */       ControllerInterface.collectController(SRomanticDanceConsts.getInstance().ControllerId);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\romanticdance\ROnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */