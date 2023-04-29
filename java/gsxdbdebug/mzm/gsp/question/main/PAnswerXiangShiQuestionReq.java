/*     */ package mzm.gsp.question.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.question.CAnswerXiangShiQuestionReq;
/*     */ import mzm.gsp.question.SAnswerXiangShiQuestionRes;
/*     */ import mzm.gsp.question.SSyncFinishXiangShi;
/*     */ import mzm.gsp.question.confbean.KeJuQuestionConsts;
/*     */ import mzm.gsp.question.confbean.SKeJuQuestionItemCfg;
/*     */ import mzm.gsp.question.session.CheckAnswerResultEnum;
/*     */ import mzm.gsp.question.session.QuestionSessionInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.KeJuInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2keju;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PAnswerXiangShiQuestionReq extends AbsQuestionProcedure<CAnswerXiangShiQuestionReq>
/*     */ {
/*     */   public PAnswerXiangShiQuestionReq(CAnswerXiangShiQuestionReq protocol)
/*     */   {
/*  28 */     super(protocol);
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if (!KeJuQuestionManager.getInstance().isKejuSwitchOpenForRole(this.roleId))
/*     */     {
/*  36 */       return false;
/*     */     }
/*  38 */     if (!QuestionInterface.isRoleStateCanAnswerQuestion(this.roleId))
/*     */     {
/*  40 */       String logStr = String.format("[keju]PAnswerXiangShiQuestionReq.processImp@role state can not answer question|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  42 */       KeJuQuestionManager.logger.info(logStr);
/*  43 */       return false;
/*     */     }
/*  45 */     int stage = ActivityInterface.getActivityStage(KeJuQuestionConsts.getInstance().ACTIVITY_ID);
/*  46 */     if (stage != 0)
/*     */     {
/*  48 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  52 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  53 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  55 */     KeJuInfo xKeJuInfo = Role2keju.get(Long.valueOf(this.roleId));
/*  56 */     if (!checkBefore(xKeJuInfo))
/*     */     {
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     KeJuWrapper wrapper = new KeJuWrapper(xKeJuInfo);
/*  62 */     CheckAnswerResultEnum result = QuestionSessionInterface.checkAnswer(((CAnswerXiangShiQuestionReq)this.protocol).sessionid, this.roleId, QuestionTypeEnum.XIANGSHI, ((CAnswerXiangShiQuestionReq)this.protocol).questionid, 0, ((CAnswerXiangShiQuestionReq)this.protocol).answeridx);
/*     */     
/*  64 */     if ((result == CheckAnswerResultEnum.INVALID_SESSION_ID) || (result == CheckAnswerResultEnum.ARG_NOT_MATCH))
/*     */     {
/*  66 */       return false;
/*     */     }
/*  68 */     if (result == CheckAnswerResultEnum.WRONG)
/*     */     {
/*  70 */       QuestionInterface.tlogQuestion(this.roleId, QuestionTypeEnum.XIANGSHI.value, ((CAnswerXiangShiQuestionReq)this.protocol).questionid, false, KeJuQuestionConsts.getInstance().ACTIVITY_ID);
/*     */       
/*  72 */       return doWrong(userId, wrapper);
/*     */     }
/*  74 */     QuestionInterface.tlogQuestion(this.roleId, QuestionTypeEnum.XIANGSHI.value, ((CAnswerXiangShiQuestionReq)this.protocol).questionid, true, KeJuQuestionConsts.getInstance().ACTIVITY_ID);
/*     */     
/*  76 */     return doRight(userId, wrapper);
/*     */   }
/*     */   
/*     */   private boolean checkBefore(KeJuInfo xKeJuInfo)
/*     */   {
/*  81 */     if (xKeJuInfo == null)
/*  82 */       return false;
/*  83 */     if (xKeJuInfo.getState() != 1)
/*     */     {
/*  85 */       return false;
/*     */     }
/*  87 */     if (xKeJuInfo.getQuestionlist().isEmpty())
/*     */     {
/*  89 */       return false;
/*     */     }
/*  91 */     if (((Integer)xKeJuInfo.getQuestionlist().get(0)).intValue() != ((CAnswerXiangShiQuestionReq)this.protocol).questionid)
/*     */     {
/*  93 */       return false;
/*     */     }
/*  95 */     return true;
/*     */   }
/*     */   
/*     */   private boolean doWrong(String userId, KeJuWrapper wrapper)
/*     */   {
/* 100 */     wrapper.moveNextQuestion();
/* 101 */     wrapper.addAnswer();
/* 102 */     AwardModel awardModel = AwardInterface.award(KeJuQuestionConsts.getInstance().XIANGSHI_WRONG_AWARD, userId, this.roleId, false, true, new AwardReason(LogReason.KEJU_ACTIVITY_XIANGSHI_WRONG_AWARD));
/*     */     
/* 104 */     if (awardModel == null)
/*     */     {
/* 106 */       String logStr = String.format("[keju]PAnswerXiangShiQuestionReq.doWrong@award xianshi question error,AwardModel null|userId=%s|roleid=%d|rewardid=%d", new Object[] { userId, Long.valueOf(this.roleId), Integer.valueOf(KeJuQuestionConsts.getInstance().XIANGSHI_WRONG_AWARD) });
/*     */       
/*     */ 
/* 109 */       KeJuQuestionManager.logger.error(logStr);
/*     */     }
/*     */     
/* 112 */     notifyClient(wrapper);
/* 113 */     return true;
/*     */   }
/*     */   
/*     */   private boolean doRight(String userId, KeJuWrapper wrapper)
/*     */   {
/* 118 */     wrapper.moveNextQuestion();
/* 119 */     wrapper.addRightAnswer();
/* 120 */     AwardModel awardModel = AwardInterface.award(KeJuQuestionConsts.getInstance().XIANGSHI_RIGHT_AWARD, userId, this.roleId, false, true, new AwardReason(LogReason.KEJU_ACTIVITY_XIANGSHI_RIGHT_AWARD));
/*     */     
/* 122 */     if (awardModel == null)
/*     */     {
/* 124 */       String logStr = String.format("[keju]PAnswerXiangShiQuestionReq.doRight@award xianshi question error,AwardModel null|userId=%s|roleid=%d|rewardid=%d", new Object[] { userId, Long.valueOf(this.roleId), Integer.valueOf(KeJuQuestionConsts.getInstance().XIANGSHI_RIGHT_AWARD) });
/*     */       
/*     */ 
/* 127 */       KeJuQuestionManager.logger.error(logStr);
/*     */     }
/* 129 */     notifyClient(wrapper);
/* 130 */     return true;
/*     */   }
/*     */   
/*     */   private void notifyClient(KeJuWrapper wrapper)
/*     */   {
/* 135 */     SAnswerXiangShiQuestionRes res = new SAnswerXiangShiQuestionRes();
/* 136 */     res.alreadyanswer = wrapper.getAnswerNum();
/* 137 */     res.rightanswer = wrapper.getRightNum();
/* 138 */     res.newquestionid = wrapper.getQuestionid();
/* 139 */     if (res.newquestionid >= 0)
/*     */     {
/* 141 */       SKeJuQuestionItemCfg cfg = SKeJuQuestionItemCfg.get(res.newquestionid);
/* 142 */       if (cfg == null) {}
/*     */       
/*     */ 
/*     */ 
/* 146 */       long sessionid = QuestionSessionInterface.createQuestionSession(this.roleId, QuestionTypeEnum.XIANGSHI, res.newquestionid, 0, cfg.answer_num, 1);
/*     */       
/* 148 */       res.sessionid = sessionid;
/* 149 */       res.answer_sequence.addAll(QuestionSessionInterface.getAnswerRandomSequence(sessionid));
/*     */     }
/* 151 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 153 */     if (wrapper.isFinish())
/*     */     {
/* 155 */       SSyncFinishXiangShi sSyncFinishHuiShi = new SSyncFinishXiangShi();
/* 156 */       sSyncFinishHuiShi.ispass = (wrapper.getRightNum() >= KeJuQuestionConsts.getInstance().HUISHI_NEED_RIGHTANSWER_NUM ? 1 : 0);
/*     */       
/* 158 */       OnlineManager.getInstance().send(this.roleId, sSyncFinishHuiShi);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PAnswerXiangShiQuestionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */