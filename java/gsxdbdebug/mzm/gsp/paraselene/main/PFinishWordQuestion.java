/*    */ package mzm.gsp.paraselene.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.paraselene.confbean.SParaseleneCfgConsts;
/*    */ import mzm.gsp.question.event.FinishWordQuestionProcedure;
/*    */ import mzm.gsp.question.event.WordQuestionArg;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PFinishWordQuestion extends FinishWordQuestionProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     if (!(((WordQuestionArg)this.arg).attachObject instanceof WordQuestionContext))
/*    */     {
/* 20 */       return false;
/*    */     }
/* 22 */     WordQuestionContext context = (WordQuestionContext)((WordQuestionArg)this.arg).attachObject;
/*    */     
/* 24 */     if ((((WordQuestionArg)this.arg).roleList == null) || (((WordQuestionArg)this.arg).roleList.size() == 0))
/*    */     {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     boolean isActivityOpen = ActivityInterface.isActivityOpen(SParaseleneCfgConsts.getInstance().ActivityId);
/*    */     
/* 31 */     Map<Long, String> roleidToUserid = new HashMap();
/* 32 */     for (Long roleid : ((WordQuestionArg)this.arg).roleList)
/*    */     {
/* 34 */       String userid = RoleInterface.getUserId(roleid.longValue());
/* 35 */       roleidToUserid.put(roleid, userid);
/*    */     }
/*    */     
/* 38 */     lock(User.getTable(), roleidToUserid.values());
/* 39 */     lock(xtable.Role2properties.getTable(), ((WordQuestionArg)this.arg).roleList);
/*    */     
/* 41 */     int activityid = context.getActivityid();
/* 42 */     int layer = context.getLayer();
/* 43 */     if (activityid != SParaseleneCfgConsts.getInstance().ActivityId)
/*    */     {
/* 45 */       return false;
/*    */     }
/* 47 */     ParaseleneManager.sendWordQuestionRes(((WordQuestionArg)this.arg).roleList, ((WordQuestionArg)this.arg).questionNum, ((WordQuestionArg)this.arg).rightNumMap, ((WordQuestionArg)this.arg).isPass);
/*    */     
/* 49 */     if (((WordQuestionArg)this.arg).isPass)
/*    */     {
/* 51 */       boolean hasFanPai = ParaseleneManager.offerAwardOnTaskEnd(roleidToUserid, ((WordQuestionArg)this.arg).roleList, ((WordQuestionArg)this.arg).roleList, layer, LogReason.PARASELENE_ACTIVITY_REWARD_ADD);
/*    */       
/* 53 */       ParaseleneManager.sendOnTaskSuccess(layer, ((WordQuestionArg)this.arg).roleList);
/* 54 */       if (isActivityOpen)
/*    */       {
/* 56 */         if (!hasFanPai)
/*    */         {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 62 */           ParaseleneManager.transferToNextLayer(((WordQuestionArg)this.arg).roleList, layer);
/*    */         }
/*    */       }
/*    */       
/* 66 */       ParaseleneManager.logActivityAndAddCount(roleidToUserid, ((WordQuestionArg)this.arg).roleList);
/*    */       
/* 68 */       return true;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 73 */     ParaseleneManager.sendOnTaskFailed(layer, ((WordQuestionArg)this.arg).roleList);
/*    */     
/* 75 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\PFinishWordQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */