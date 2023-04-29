/*    */ package mzm.gsp.questionvoice.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.questionvoice.confbean.SOpenId2ActivityId;
/*    */ 
/*    */ public class ROnOpenChange extends mzm.gsp.open.event.OpenChangeRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 11 */     int type = ((OpenChangeComplexArg)this.arg).getType();
/* 12 */     if (!SOpenId2ActivityId.getAll().containsKey(Integer.valueOf(type)))
/*    */     {
/* 14 */       return;
/*    */     }
/*    */     
/* 17 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 19 */       return;
/*    */     }
/* 21 */     int activityId = SOpenId2ActivityId.get(type).activityId;
/* 22 */     QuestionVoiceManager.onOpenChange(activityId, ((OpenChangeComplexArg)this.arg).isOpen());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\questionvoice\main\ROnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */