/*     */ package mzm.gsp.question.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.question.CAnswerHuiShiShiQuestionReq;
/*     */ import mzm.gsp.question.SAnswerHuiShiQuestionRes;
/*     */ import mzm.gsp.question.confbean.KeJuQuestionConsts;
/*     */ import mzm.gsp.question.confbean.SKeJuQuestionItemCfg;
/*     */ import mzm.gsp.question.session.CheckAnswerResultEnum;
/*     */ import mzm.gsp.question.session.QuestionSessionInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.KeJuInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2keju;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PAnswerHuiShiQuestionReq
/*     */   extends AbsQuestionProcedure<CAnswerHuiShiShiQuestionReq>
/*     */ {
/*     */   public PAnswerHuiShiQuestionReq(CAnswerHuiShiShiQuestionReq protocol)
/*     */   {
/*  31 */     super(protocol);
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (!KeJuQuestionManager.getInstance().isKejuSwitchOpenForRole(this.roleId))
/*     */     {
/*  39 */       return false;
/*     */     }
/*  41 */     if (!QuestionInterface.isRoleStateCanAnswerQuestion(this.roleId))
/*     */     {
/*  43 */       String logStr = String.format("[keju]PAnswerHuiShiQuestionReq.processImp@role state can not answer question|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  45 */       KeJuQuestionManager.logger.info(logStr);
/*  46 */       return false;
/*     */     }
/*  48 */     int stage = ActivityInterface.getActivityStage(KeJuQuestionConsts.getInstance().ACTIVITY_ID);
/*  49 */     if ((stage != 0) && (stage != 1))
/*     */     {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     String userId = RoleInterface.getUserId(this.roleId);
/*  55 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  57 */     KeJuInfo xKeJuInfo = Role2keju.get(Long.valueOf(this.roleId));
/*  58 */     if (!checkBefore(xKeJuInfo))
/*     */     {
/*  60 */       return false;
/*     */     }
/*  62 */     KeJuWrapper wrapper = new KeJuWrapper(xKeJuInfo);
/*     */     
/*  64 */     CheckAnswerResultEnum result = QuestionSessionInterface.checkAnswer(((CAnswerHuiShiShiQuestionReq)this.protocol).sessionid, this.roleId, QuestionTypeEnum.HUISHI, ((CAnswerHuiShiShiQuestionReq)this.protocol).questionid, 0, ((CAnswerHuiShiShiQuestionReq)this.protocol).answeridx);
/*     */     
/*  66 */     if ((result == CheckAnswerResultEnum.INVALID_SESSION_ID) || (result == CheckAnswerResultEnum.ARG_NOT_MATCH))
/*     */     {
/*  68 */       return false; }
/*     */     boolean ret;
/*  70 */     boolean ret; if (result == CheckAnswerResultEnum.WRONG)
/*     */     {
/*  72 */       ret = doWrong(userId, wrapper);
/*     */     }
/*     */     else
/*     */     {
/*  76 */       ret = doRight(userId, wrapper);
/*     */     }
/*  78 */     QuestionInterface.tlogQuestion(this.roleId, QuestionTypeEnum.HUISHI.value, ((CAnswerHuiShiShiQuestionReq)this.protocol).questionid, ret, KeJuQuestionConsts.getInstance().ACTIVITY_ID);
/*     */     
/*  80 */     if ((ret) && (wrapper.isFinish()))
/*     */     {
/*     */ 
/*  83 */       xKeJuInfo.setFinishtime(DateTimeUtils.getCurrTimeInMillis());
/*  84 */       int usetime = (int)(TimeUnit.MILLISECONDS.toSeconds(xKeJuInfo.getFinishtime() - xKeJuInfo.getStarttime()) + xKeJuInfo.getPunishtime());
/*  85 */       KeJuQuestionManager.getInstance().addHuishiResult(this.roleId, usetime);
/*     */     }
/*  87 */     return ret;
/*     */   }
/*     */   
/*     */   private boolean doWrong(String userId, KeJuWrapper wrapper)
/*     */   {
/*  92 */     wrapper.moveNextQuestion();
/*  93 */     wrapper.addAnswer();
/*  94 */     wrapper.addPunishTime(KeJuQuestionConsts.getInstance().HUISHI_WRONG_ANSWER_ADD_SECNOD);
/*  95 */     AwardModel awardModel = AwardInterface.award(KeJuQuestionConsts.getInstance().HUISHI_WRONG_AWARD, userId, this.roleId, false, true, new AwardReason(LogReason.KEJU_ACTIVITY_HUISHI_WRONG_AWARD));
/*     */     
/*  97 */     if (awardModel == null)
/*     */     {
/*  99 */       String logStr = String.format("[keju]PAnswerHuiShiQuestionReq.doWrong@award huishi question error,AwardModel null|userId=%s|roleid=%d|rewardid=%d", new Object[] { userId, Long.valueOf(this.roleId), Integer.valueOf(KeJuQuestionConsts.getInstance().HUISHI_WRONG_ANSWER_ADD_SECNOD) });
/*     */       
/*     */ 
/* 102 */       KeJuQuestionManager.logger.error(logStr);
/*     */     }
/* 104 */     notifyClient(wrapper);
/* 105 */     return true;
/*     */   }
/*     */   
/*     */   private boolean doRight(String userId, KeJuWrapper wrapper)
/*     */   {
/* 110 */     wrapper.moveNextQuestion();
/* 111 */     wrapper.addRightAnswer();
/* 112 */     AwardModel awardModel = AwardInterface.award(KeJuQuestionConsts.getInstance().HUISHI_RIGHT_AWARD, userId, this.roleId, false, true, new AwardReason(LogReason.KEJU_ACTIVITY_HUISHI_RIGHT_AWARD));
/*     */     
/*     */ 
/* 115 */     if (awardModel == null)
/*     */     {
/* 117 */       String logStr = String.format("[keju]PAnswerHuiShiQuestionReq.doRight@award huishi question error,AwardModel null|userId=%s|roleid=%d|rewardid=%d", new Object[] { userId, Long.valueOf(this.roleId), Integer.valueOf(KeJuQuestionConsts.getInstance().HUISHI_RIGHT_AWARD) });
/*     */       
/*     */ 
/* 120 */       KeJuQuestionManager.logger.error(logStr);
/*     */     }
/* 122 */     notifyClient(wrapper);
/* 123 */     return true;
/*     */   }
/*     */   
/*     */   private void notifyClient(KeJuWrapper wrapper)
/*     */   {
/* 128 */     SAnswerHuiShiQuestionRes res = new SAnswerHuiShiQuestionRes();
/* 129 */     res.newquestionid = wrapper.getQuestionid();
/* 130 */     res.alreadyanswer = wrapper.getAnswerNum();
/* 131 */     res.rightanswer = wrapper.getRightNum();
/* 132 */     res.totaladdtime = wrapper.getPunishTime();
/* 133 */     if (res.newquestionid >= 0)
/*     */     {
/* 135 */       SKeJuQuestionItemCfg cfg = SKeJuQuestionItemCfg.get(res.newquestionid);
/* 136 */       if (cfg == null) {}
/*     */       
/*     */ 
/*     */ 
/* 140 */       long sessionid = QuestionSessionInterface.createQuestionSession(this.roleId, QuestionTypeEnum.HUISHI, res.newquestionid, 0, cfg.answer_num, 1);
/*     */       
/* 142 */       res.sessionid = sessionid;
/* 143 */       res.answer_sequence.addAll(QuestionSessionInterface.getAnswerRandomSequence(sessionid));
/*     */     }
/* 145 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */   }
/*     */   
/*     */   private boolean checkBefore(KeJuInfo xKeJuInfo)
/*     */   {
/* 150 */     if (xKeJuInfo == null)
/* 151 */       return false;
/* 152 */     if (xKeJuInfo.getState() != 2)
/*     */     {
/* 154 */       return false;
/*     */     }
/* 156 */     if (xKeJuInfo.getQuestionlist().isEmpty())
/*     */     {
/* 158 */       return false;
/*     */     }
/* 160 */     if (((Integer)xKeJuInfo.getQuestionlist().get(0)).intValue() != ((CAnswerHuiShiShiQuestionReq)this.protocol).questionid)
/*     */     {
/* 162 */       return false;
/*     */     }
/* 164 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PAnswerHuiShiQuestionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */