/*     */ package mzm.gsp.question.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.question.SAnswerLunHuiResultRes;
/*     */ import mzm.gsp.question.confbean.SEveryDayQuestionConsts;
/*     */ import mzm.gsp.question.confbean.SEveryDayQuestionItemCfg;
/*     */ import mzm.gsp.question.event.PlayerAnswerQuestion;
/*     */ import mzm.gsp.question.event.PlayerFinishActivity;
/*     */ import mzm.gsp.question.event.QuestionArg;
/*     */ import mzm.gsp.question.session.CheckAnswerResultEnum;
/*     */ import mzm.gsp.question.session.QuestionSessionInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.EveryDayQuestionAnswerInfo;
/*     */ import xbean.QuestionInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2question;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PAnswerLunHuiQuestionReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int answerIconId;
/*     */   private final int questionid;
/*     */   private final int answerPageIndex;
/*     */   private final long sessionid;
/*     */   
/*     */   public PAnswerLunHuiQuestionReq(long roleId, int answerIconId, int questionid, int answerPageIndex, long sessionid)
/*     */   {
/*  38 */     this.roleId = roleId;
/*  39 */     this.answerIconId = answerIconId;
/*  40 */     this.questionid = questionid;
/*  41 */     this.answerPageIndex = answerPageIndex;
/*  42 */     this.sessionid = sessionid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  48 */     if (!EveryDayQuestionManager.getInstance().isZhuxianQiYuanSwitchOpenForRole(this.roleId))
/*     */     {
/*  50 */       return false;
/*     */     }
/*  52 */     if (!QuestionInterface.isRoleStateCanAnswerQuestion(this.roleId))
/*     */     {
/*  54 */       String logStr = String.format("[keju]PAnswerLunHuiQuestionReq.processImp@role state can not answer question|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  56 */       EveryDayQuestionManager.getInstance().logger.info(logStr);
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     if (!EveryDayQuestionManager.getInstance().isActivityStart())
/*     */     {
/*  62 */       return false;
/*     */     }
/*  64 */     boolean isOver = false;
/*     */     
/*     */ 
/*  67 */     String userId = RoleInterface.getUserId(this.roleId);
/*  68 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  70 */     QuestionInfo xQuestionInfo = Role2question.get(Long.valueOf(this.roleId));
/*  71 */     EveryDayQuestionAnswerInfo xEveryDayInfo = xQuestionInfo.getEverydayinfo();
/*  72 */     List<Integer> questionList = xEveryDayInfo.getQuestionlist();
/*  73 */     int curQuestionIdx = xEveryDayInfo.getCurrentquestionidx();
/*     */     
/*  75 */     if (questionList.size() == curQuestionIdx)
/*     */     {
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     if (xEveryDayInfo.getCurrentanswerpageidx() != this.answerPageIndex)
/*     */     {
/*  82 */       return false;
/*     */     }
/*  84 */     int questionId = ((Integer)questionList.get(curQuestionIdx)).intValue();
/*     */     
/*  86 */     SAnswerLunHuiResultRes res = new SAnswerLunHuiResultRes();
/*  87 */     res.nextpageindex = (this.answerPageIndex + 1);
/*  88 */     boolean answerError = false;
/*  89 */     CheckAnswerResultEnum result = EveryDayQuestionManager.getInstance().checkAnswer(this.sessionid, this.roleId, this.questionid, this.answerPageIndex, this.answerIconId);
/*     */     
/*  91 */     if ((result == CheckAnswerResultEnum.INVALID_SESSION_ID) || (result == CheckAnswerResultEnum.ARG_NOT_MATCH))
/*     */     {
/*  93 */       return false;
/*     */     }
/*  95 */     if (result == CheckAnswerResultEnum.RIGHT)
/*     */     {
/*  97 */       if (EveryDayQuestionManager.getInstance().isAllAnswered(questionId, this.answerPageIndex))
/*     */       {
/*     */ 
/* 100 */         AwardModel model = EveryDayQuestionManager.getInstance().awardRightAnswer(userId, this.roleId, this.answerPageIndex + 1);
/* 101 */         xEveryDayInfo.setAwardmoney(xEveryDayInfo.getAwardmoney() + model.getSilver());
/* 102 */         xEveryDayInfo.setAwardexp(xEveryDayInfo.getAwardexp() + model.getRoleExp());
/* 103 */         xEveryDayInfo.setRightnum(xEveryDayInfo.getRightnum() + 1);
/*     */       }
/* 105 */       res.islastanswerright = 1;
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 110 */       AwardModel model = EveryDayQuestionManager.getInstance().awardWrongAnswer(userId, this.roleId);
/* 111 */       xEveryDayInfo.setAwardmoney(xEveryDayInfo.getAwardmoney() + model.getSilver());
/* 112 */       xEveryDayInfo.setAwardexp(xEveryDayInfo.getAwardexp() + model.getRoleExp());
/* 113 */       res.islastanswerright = 0;
/* 114 */       answerError = true;
/*     */     }
/* 116 */     xEveryDayInfo.setCurrentanswerpageidx(this.answerPageIndex + 1);
/*     */     
/* 118 */     res.exp = xEveryDayInfo.getAwardexp();
/* 119 */     res.money = xEveryDayInfo.getAwardmoney();
/*     */     
/* 121 */     if ((EveryDayQuestionManager.getInstance().isAllAnswered(questionId, this.answerPageIndex)) || (answerError))
/*     */     {
/* 123 */       curQuestionIdx++;
/* 124 */       xEveryDayInfo.setCurrentquestionidx(curQuestionIdx);
/* 125 */       xEveryDayInfo.setCurrentanswerpageidx(0);
/* 126 */       ActivityInterface.addActivityCount(userId, this.roleId, EveryDayQuestionManager.getInstance().getActivityId());
/* 127 */       QuestionArg arg = new QuestionArg(this.roleId, !answerError, curQuestionIdx);
/* 128 */       TriggerEventsManger.getInstance().triggerEvent(new PlayerAnswerQuestion(), arg);
/*     */       
/* 130 */       if (questionList.size() == xEveryDayInfo.getCurrentquestionidx())
/*     */       {
/* 132 */         res.nextquestionid = -1;
/* 133 */         isOver = true;
/*     */       }
/* 135 */       res.nextpageindex = 0;
/*     */       
/*     */ 
/* 138 */       if (isOver)
/*     */       {
/* 140 */         TriggerEventsManger.getInstance().triggerEvent(new PlayerFinishActivity(), arg);
/*     */       }
/*     */     }
/* 143 */     if (questionList.size() > curQuestionIdx)
/*     */     {
/* 145 */       res.nextquestionid = ((Integer)questionList.get(curQuestionIdx)).intValue();
/*     */     }
/* 147 */     if (res.nextquestionid >= 0)
/*     */     {
/* 149 */       SEveryDayQuestionItemCfg cfg = SEveryDayQuestionItemCfg.get(res.nextquestionid);
/* 150 */       if (cfg == null) {}
/*     */       
/*     */ 
/*     */ 
/* 154 */       long sessionid = QuestionSessionInterface.createQuestionSession(this.roleId, QuestionTypeEnum.ZHUXIANQIYUAN, res.nextquestionid, res.nextpageindex, SEveryDayQuestionConsts.getInstance().ANSWER_SIZE, 1);
/*     */       
/* 156 */       res.sessionid = sessionid;
/* 157 */       res.answer_sequence.addAll(QuestionSessionInterface.getAnswerRandomSequence(sessionid));
/*     */     }
/* 159 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 161 */     if (answerError)
/*     */     {
/* 163 */       ActivityInterface.tlogActivity(this.roleId, EveryDayQuestionManager.getInstance().getActivityId(), ActivityLogStatus.ATTEND);
/*     */       
/* 165 */       ActivityInterface.logActivity(this.roleId, EveryDayQuestionManager.getInstance().getActivityId(), ActivityLogStatus.ATTEND);
/*     */       
/* 167 */       QuestionInterface.tlogQuestion(this.roleId, QuestionTypeEnum.ZHUXIANQIYUAN.value, questionId, false, EveryDayQuestionManager.getInstance().getActivityId());
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 173 */       ActivityInterface.tlogActivity(this.roleId, EveryDayQuestionManager.getInstance().getActivityId(), ActivityLogStatus.FINISH);
/*     */       
/* 175 */       ActivityInterface.logActivity(this.roleId, EveryDayQuestionManager.getInstance().getActivityId(), ActivityLogStatus.FINISH);
/*     */       
/*     */ 
/* 178 */       QuestionInterface.tlogQuestion(this.roleId, QuestionTypeEnum.ZHUXIANQIYUAN.value, questionId, true, EveryDayQuestionManager.getInstance().getActivityId());
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 183 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PAnswerLunHuiQuestionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */