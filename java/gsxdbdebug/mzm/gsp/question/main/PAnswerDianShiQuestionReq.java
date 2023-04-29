/*     */ package mzm.gsp.question.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.idip.main.IdipManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.question.CAnswerDianShiShiQuestionReq;
/*     */ import mzm.gsp.question.SAnswerDianShiQuestionRes;
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
/*     */ 
/*     */ public class PAnswerDianShiQuestionReq
/*     */   extends AbsQuestionProcedure<CAnswerDianShiShiQuestionReq>
/*     */ {
/*     */   public PAnswerDianShiQuestionReq(CAnswerDianShiShiQuestionReq protocol)
/*     */   {
/*  33 */     super(protocol);
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if (!KeJuQuestionManager.getInstance().isKejuSwitchOpenForRole(this.roleId))
/*     */     {
/*  41 */       return false;
/*     */     }
/*  43 */     if (!QuestionInterface.isRoleStateCanAnswerQuestion(this.roleId))
/*     */     {
/*  45 */       String logStr = String.format("[keju]PAnswerDianShiQuestionReq.processImp@role state can not answer question|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  47 */       KeJuQuestionManager.logger.info(logStr);
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     int stage = ActivityInterface.getActivityStage(KeJuQuestionConsts.getInstance().ACTIVITY_ID);
/*  52 */     if (stage != 3)
/*     */     {
/*  54 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  58 */     String userId = RoleInterface.getUserId(this.roleId);
/*  59 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  61 */     KeJuInfo xkeJuInfo = Role2keju.get(Long.valueOf(this.roleId));
/*  62 */     if ((xkeJuInfo == null) || (xkeJuInfo.getState() != 3))
/*     */     {
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     KeJuWrapper wrapper = new KeJuWrapper(xkeJuInfo);
/*  68 */     if (((CAnswerDianShiShiQuestionReq)this.protocol).questionid != wrapper.getQuestionid())
/*     */     {
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     CheckAnswerResultEnum result = QuestionSessionInterface.checkAnswer(((CAnswerDianShiShiQuestionReq)this.protocol).sessionid, this.roleId, QuestionTypeEnum.DIANSHI, ((CAnswerDianShiShiQuestionReq)this.protocol).questionid, 0, ((CAnswerDianShiShiQuestionReq)this.protocol).answeridx);
/*     */     
/*  75 */     if ((result == CheckAnswerResultEnum.INVALID_SESSION_ID) || (result == CheckAnswerResultEnum.ARG_NOT_MATCH))
/*     */     {
/*  77 */       return false; }
/*     */     boolean ret;
/*  79 */     boolean ret; if (result == CheckAnswerResultEnum.WRONG)
/*     */     {
/*  81 */       ret = doWrong(userId, wrapper);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  86 */       ret = doRight(userId, wrapper);
/*     */     }
/*  88 */     if (!ret)
/*     */     {
/*  90 */       return false;
/*     */     }
/*  92 */     QuestionInterface.tlogQuestion(this.roleId, QuestionTypeEnum.DIANSHI.value, ((CAnswerDianShiShiQuestionReq)this.protocol).questionid, ret, KeJuQuestionConsts.getInstance().ACTIVITY_ID);
/*     */     
/*  94 */     if (wrapper.isFinish())
/*     */     {
/*  96 */       if (!IdipManager.isBanRank(this.roleId, 4))
/*     */       {
/*  98 */         xkeJuInfo.setFinishtime(DateTimeUtils.getCurrTimeInMillis());
/*  99 */         int usetime = (int)(TimeUnit.MILLISECONDS.toSeconds(xkeJuInfo.getFinishtime() - xkeJuInfo.getStarttime()) + xkeJuInfo.getPunishtime());
/* 100 */         KeJuQuestionManager.getInstance().addDianshiResult(this.roleId, usetime);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 105 */         String logstr = String.format("[keju]PAnswerDianShiQuestionReq.processImp@role is is ban rank state|roleid=%d|normalStartTime=%d|normalFinishTime=%d|punishTime=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(xkeJuInfo.getStarttime()), Long.valueOf(DateTimeUtils.getCurrTimeInMillis()), Integer.valueOf(xkeJuInfo.getPunishtime()) });
/*     */         
/*     */ 
/*     */ 
/* 109 */         KeJuQuestionManager.logger.info(logstr);
/*     */         
/* 111 */         xkeJuInfo.setFinishtime(0L);
/* 112 */         xkeJuInfo.setPunishtime(0);
/* 113 */         xkeJuInfo.setStarttime(0L);
/*     */       }
/*     */       
/* 116 */       ActivityInterface.tlogActivity(this.roleId, KeJuQuestionConsts.getInstance().ACTIVITY_ID, ActivityLogStatus.FINISH);
/* 117 */       ActivityInterface.logActivity(this.roleId, KeJuQuestionConsts.getInstance().ACTIVITY_ID, ActivityLogStatus.FINISH);
/*     */     }
/* 119 */     return ret;
/*     */   }
/*     */   
/*     */   private void notifyNext(KeJuWrapper wrapper)
/*     */   {
/* 124 */     SAnswerDianShiQuestionRes res = new SAnswerDianShiQuestionRes();
/* 125 */     res.alreadyanswer = wrapper.getAnswerNum();
/* 126 */     res.rightanswer = wrapper.getRightNum();
/* 127 */     res.newquestionid = wrapper.getQuestionid();
/* 128 */     res.totaladdtime = wrapper.getPunishTime();
/* 129 */     if (res.newquestionid >= 0)
/*     */     {
/* 131 */       SKeJuQuestionItemCfg cfg = SKeJuQuestionItemCfg.get(res.newquestionid);
/* 132 */       if (cfg == null) {}
/*     */       
/*     */ 
/*     */ 
/* 136 */       long sessionid = QuestionSessionInterface.createQuestionSession(this.roleId, QuestionTypeEnum.DIANSHI, res.newquestionid, 0, cfg.answer_num, 1);
/*     */       
/* 138 */       res.sessionid = sessionid;
/* 139 */       res.answer_sequence.addAll(QuestionSessionInterface.getAnswerRandomSequence(sessionid));
/*     */     }
/* 141 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */   }
/*     */   
/*     */   private boolean doRight(String userId, KeJuWrapper wrapper)
/*     */   {
/* 146 */     wrapper.moveNextQuestion();
/* 147 */     wrapper.addRightAnswer();
/* 148 */     AwardModel a = AwardInterface.award(KeJuQuestionConsts.getInstance().DIANSHI_RIGHT_AWARD, userId, this.roleId, false, true, new AwardReason(LogReason.KEJU_ACTIVITY_DIANSHI_RIGHT_AWARD));
/*     */     
/* 150 */     if (a == null)
/*     */     {
/* 152 */       String logStr = String.format("[keju]PAnswerDianShiQuestionReq.doRight@award dianshi question error,AwardModel null|userId=%s|roleid=%d|rewardid=%d", new Object[] { userId, Long.valueOf(this.roleId), Integer.valueOf(KeJuQuestionConsts.getInstance().DIANSHI_RIGHT_AWARD) });
/*     */       
/*     */ 
/* 155 */       KeJuQuestionManager.logger.error(logStr);
/*     */     }
/* 157 */     notifyNext(wrapper);
/* 158 */     return true;
/*     */   }
/*     */   
/*     */   private boolean doWrong(String userId, KeJuWrapper wrapper)
/*     */   {
/* 163 */     wrapper.moveNextQuestion();
/* 164 */     wrapper.addAnswer();
/* 165 */     wrapper.addPunishTime(KeJuQuestionConsts.getInstance().DIANSHI_WRONG_ANSWER_DECREASE_SECOND);
/* 166 */     AwardModel a = AwardInterface.award(KeJuQuestionConsts.getInstance().DIANSHI_WRONG_AWARD, userId, this.roleId, false, true, new AwardReason(LogReason.KEJU_ACTIVITY_DIANSHI_WRONG_AWARD));
/*     */     
/* 168 */     if (a == null)
/*     */     {
/* 170 */       String logStr = String.format("[keju]PAnswerDianShiQuestionReq.doWrong@award dianshi question error,AwardModel null|userId=%s|roleid=%d|rewardid=%d", new Object[] { userId, Long.valueOf(this.roleId), Integer.valueOf(KeJuQuestionConsts.getInstance().DIANSHI_WRONG_AWARD) });
/*     */       
/*     */ 
/* 173 */       KeJuQuestionManager.logger.error(logStr);
/*     */     }
/* 175 */     notifyNext(wrapper);
/* 176 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PAnswerDianShiQuestionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */