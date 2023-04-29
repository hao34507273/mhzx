/*    */ package mzm.gsp.question.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.award.main.AwardInterface;
/*    */ import mzm.gsp.award.main.AwardModel;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.question.confbean.SEveryDayQuestionConsts;
/*    */ import mzm.gsp.storageexp.main.StorageExpInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import xbean.EveryDayQuestionAnswerInfo;
/*    */ import xbean.Pod;
/*    */ import xbean.QuestionInfo;
/*    */ import xtable.Role2question;
/*    */ 
/*    */ 
/*    */ public class EveryDayQuestionActivityInit
/*    */   implements ActivityHandler
/*    */ {
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 24 */     QuestionInfo xQuestion = Role2question.get(Long.valueOf(roleId));
/* 25 */     if (xQuestion == null)
/*    */     {
/* 27 */       xQuestion = Pod.newQuestionInfo();
/* 28 */       Role2question.add(Long.valueOf(roleId), xQuestion);
/*    */     }
/*    */     
/* 31 */     EveryDayQuestionAnswerInfo xEveryDayInfo = xQuestion.getEverydayinfo();
/* 32 */     int num = xEveryDayInfo.getQuestionlist().size() - xEveryDayInfo.getCurrentquestionidx();
/* 33 */     AwardReason reason = new AwardReason(LogReason.EVERY_DAY_QUESTION_STORAGE_ADD, EveryDayQuestionManager.getInstance().getWrongAwardId());
/*    */     
/* 35 */     reason.setJustQuery(true);
/* 36 */     AwardModel awardModel = AwardInterface.getRoleAwardModel(EveryDayQuestionManager.getInstance().getWrongAwardId(), roleId, -1, reason);
/*    */     
/* 38 */     if (awardModel != null)
/*    */     {
/* 40 */       if (turn >= 1)
/*    */       {
/* 42 */         StorageExpInterface.addStorageExp(roleId, turn * EveryDayQuestionManager.getInstance().getQuestionSize() * awardModel.getRoleExp() * SEveryDayQuestionConsts.getInstance().STORAGE_EXP_RATE / EveryDayQuestionManager.WAN);
/*    */ 
/*    */       }
/*    */       else
/*    */       {
/*    */ 
/* 48 */         StorageExpInterface.addStorageExp(roleId, num * awardModel.getRoleExp() * SEveryDayQuestionConsts.getInstance().STORAGE_EXP_RATE / EveryDayQuestionManager.WAN);
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 53 */     xEveryDayInfo.setCurrentquestionidx(0);
/* 54 */     xEveryDayInfo.setCurrentanswerpageidx(0);
/* 55 */     xEveryDayInfo.setRightnum(0);
/* 56 */     xEveryDayInfo.setUsehelpnum(0);
/* 57 */     xEveryDayInfo.setAwardexp(0);
/* 58 */     xEveryDayInfo.setAwardmoney(0L);
/*    */     
/* 60 */     List<Integer> idList = EveryDayQuestionManager.getInstance().randomQuestion();
/* 61 */     xEveryDayInfo.getQuestionlist().clear();
/* 62 */     xEveryDayInfo.getQuestionlist().addAll(idList);
/*    */   }
/*    */   
/*    */ 
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 68 */     return new AwardReason(LogReason.EVERY_DAY_QUESTION_ACTIVITY_ADD);
/*    */   }
/*    */   
/*    */ 
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 74 */     return null;
/*    */   }
/*    */   
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid) {}
/*    */   
/*    */   public void onActivityStageStart(int stageIndex, boolean startAgain, int activityid) {}
/*    */   
/*    */   public void onActivityEnd(int activityid) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\EveryDayQuestionActivityInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */