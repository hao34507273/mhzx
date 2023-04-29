/*    */ package mzm.gsp.paraselene.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.paraselene.confbean.SParaseleneCfgConsts;
/*    */ import mzm.gsp.question.event.FinishPictureQuestionProcedure;
/*    */ import mzm.gsp.question.event.PictureQuestionArg;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PFinishPictureQuestion extends FinishPictureQuestionProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     if (!(((PictureQuestionArg)this.arg).attachObject instanceof PictureQuestionContext))
/*    */     {
/* 19 */       return false;
/*    */     }
/* 21 */     PictureQuestionContext context = (PictureQuestionContext)((PictureQuestionArg)this.arg).attachObject;
/* 22 */     int activityid = context.getActivityid();
/* 23 */     int layer = context.getLayer();
/* 24 */     if (activityid != SParaseleneCfgConsts.getInstance().ActivityId)
/*    */     {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     if ((((PictureQuestionArg)this.arg).roleList == null) || (((PictureQuestionArg)this.arg).roleList.size() == 0))
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     boolean isActivityOpen = ActivityInterface.isActivityOpen(SParaseleneCfgConsts.getInstance().ActivityId);
/* 34 */     if (!isActivityOpen)
/*    */     {
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     Map<Long, String> roleidToUserid = new HashMap();
/* 40 */     for (Long roleid : ((PictureQuestionArg)this.arg).roleList)
/*    */     {
/* 42 */       String userid = RoleInterface.getUserId(roleid.longValue());
/* 43 */       roleidToUserid.put(roleid, userid);
/*    */     }
/*    */     
/* 46 */     lock(User.getTable(), roleidToUserid.values());
/* 47 */     lock(xtable.Role2properties.getTable(), ((PictureQuestionArg)this.arg).roleList);
/*    */     
/* 49 */     ParaseleneManager.sendPictureQuestionRes(((PictureQuestionArg)this.arg).roleScoreMap, ((PictureQuestionArg)this.arg).isPass);
/* 50 */     if (((PictureQuestionArg)this.arg).isPass)
/*    */     {
/* 52 */       boolean hasFanPai = ParaseleneManager.offerAwardOnTaskEnd(roleidToUserid, ((PictureQuestionArg)this.arg).roleList, ((PictureQuestionArg)this.arg).roleList, layer, LogReason.PARASELENE_ACTIVITY_REWARD_ADD);
/*    */       
/*    */ 
/* 55 */       ParaseleneManager.sendOnTaskSuccess(layer, ((PictureQuestionArg)this.arg).roleList);
/*    */       
/* 57 */       if (isActivityOpen)
/*    */       {
/* 59 */         if (!hasFanPai)
/*    */         {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 65 */           ParaseleneManager.transferToNextLayer(((PictureQuestionArg)this.arg).roleList, layer);
/*    */         }
/*    */       }
/*    */       
/*    */ 
/* 70 */       ParaseleneManager.logActivityAndAddCount(roleidToUserid, ((PictureQuestionArg)this.arg).roleList);
/*    */       
/* 72 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 76 */     ParaseleneManager.sendOnTaskFailed(layer, ((PictureQuestionArg)this.arg).roleList);
/* 77 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\PFinishPictureQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */