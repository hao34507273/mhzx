/*     */ package mzm.gsp.question.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.question.CGetHuiShiQuestionReq;
/*     */ import mzm.gsp.question.SGetHuiShiQuestionRes;
/*     */ import mzm.gsp.question.confbean.KeJuQuestionConsts;
/*     */ import mzm.gsp.question.confbean.SKeJuQuestionItemCfg;
/*     */ import mzm.gsp.question.session.QuestionSessionInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.KeJuInfo;
/*     */ import xtable.Role2keju;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PGetHuiShiQuestionReq
/*     */   extends AbsQuestionProcedure<CGetHuiShiQuestionReq>
/*     */ {
/*     */   public PGetHuiShiQuestionReq(CGetHuiShiQuestionReq protocol)
/*     */   {
/*  27 */     super(protocol);
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     if (!KeJuQuestionManager.getInstance().isKejuSwitchOpenForRole(this.roleId))
/*     */     {
/*  35 */       return false;
/*     */     }
/*  37 */     if (!QuestionInterface.isRoleStateCanAnswerQuestion(this.roleId))
/*     */     {
/*  39 */       String logStr = String.format("[keju]PGetHuiShiQuestionReq.processImp@role state can not answer question|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  41 */       KeJuQuestionManager.logger.info(logStr);
/*  42 */       return false;
/*     */     }
/*  44 */     if (!MapInterface.isNearByNPC(this.roleId, KeJuQuestionConsts.getInstance().HUISHI_NPC_ID))
/*     */     {
/*  46 */       return false;
/*     */     }
/*  48 */     int stage = ActivityInterface.getActivityStage(KeJuQuestionConsts.getInstance().ACTIVITY_ID);
/*  49 */     if ((stage != 0) && (stage != 1))
/*     */     {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     KeJuInfo xKeJu = Role2keju.get(Long.valueOf(this.roleId));
/*  55 */     if (xKeJu == null)
/*     */     {
/*  57 */       return false;
/*     */     }
/*  59 */     ActivityInterface.tlogActivity(this.roleId, KeJuQuestionConsts.getInstance().ACTIVITY_ID, ActivityLogStatus.ATTEND);
/*  60 */     ActivityInterface.logActivity(this.roleId, KeJuQuestionConsts.getInstance().ACTIVITY_ID, ActivityLogStatus.ATTEND);
/*     */     
/*  62 */     if (xKeJu.getState() == 2)
/*     */     {
/*  64 */       KeJuWrapper wrapper = new KeJuWrapper(xKeJu);
/*  65 */       SGetHuiShiQuestionRes res = new SGetHuiShiQuestionRes();
/*  66 */       res.questionid = wrapper.getQuestionid();
/*  67 */       res.alreadyanswer = wrapper.getAnswerNum();
/*  68 */       res.rightanswer = wrapper.getRightNum();
/*  69 */       res.totaladdtime = wrapper.getPunishTime();
/*  70 */       res.starttime = ((int)TimeUnit.MILLISECONDS.toSeconds(wrapper.getQuestionBeginTime()));
/*  71 */       if (res.questionid >= 0)
/*     */       {
/*  73 */         SKeJuQuestionItemCfg cfg = SKeJuQuestionItemCfg.get(res.questionid);
/*  74 */         if (cfg == null) {}
/*     */         
/*     */ 
/*     */ 
/*  78 */         long sessionid = QuestionSessionInterface.createQuestionSession(this.roleId, QuestionTypeEnum.HUISHI, res.questionid, 0, cfg.answer_num, 1);
/*     */         
/*  80 */         res.sessionid = sessionid;
/*  81 */         res.answer_sequence.addAll(QuestionSessionInterface.getAnswerRandomSequence(sessionid));
/*     */       }
/*  83 */       OnlineManager.getInstance().send(this.roleId, res);
/*  84 */       return true;
/*     */     }
/*     */     
/*     */ 
/*  88 */     if ((!xKeJu.getQuestionlist().isEmpty()) || (xKeJu.getState() != 1))
/*     */     {
/*  90 */       return false;
/*     */     }
/*  92 */     KeJuWrapper wrapper = new KeJuWrapper(xKeJu);
/*  93 */     if (wrapper.getRightNum() < KeJuQuestionConsts.getInstance().HUISHI_NEED_RIGHTANSWER_NUM)
/*     */     {
/*  95 */       return false;
/*     */     }
/*  97 */     List<Integer> questionIdList = KeJuQuestionManager.getInstance().randomQuestionByType(2);
/*  98 */     xKeJu.setState(2);
/*  99 */     xKeJu.getQuestionlist().addAll(questionIdList);
/* 100 */     xKeJu.setAnswernum(0);
/* 101 */     xKeJu.setRightnum(0);
/* 102 */     xKeJu.setFinishtime(0L);
/*     */     
/* 104 */     xKeJu.setStarttime(DateTimeUtils.getCurrTimeInMillis());
/*     */     
/* 106 */     SGetHuiShiQuestionRes res = new SGetHuiShiQuestionRes();
/* 107 */     res.questionid = wrapper.getQuestionid();
/* 108 */     res.alreadyanswer = wrapper.getAnswerNum();
/* 109 */     res.rightanswer = wrapper.getRightNum();
/* 110 */     res.totaladdtime = wrapper.getPunishTime();
/* 111 */     if (res.questionid >= 0)
/*     */     {
/* 113 */       SKeJuQuestionItemCfg cfg = SKeJuQuestionItemCfg.get(res.questionid);
/* 114 */       if (cfg == null) {}
/*     */       
/*     */ 
/*     */ 
/* 118 */       long sessionid = QuestionSessionInterface.createQuestionSession(this.roleId, QuestionTypeEnum.HUISHI, res.questionid, 0, cfg.answer_num, 1);
/*     */       
/* 120 */       res.sessionid = sessionid;
/* 121 */       res.answer_sequence.addAll(QuestionSessionInterface.getAnswerRandomSequence(sessionid));
/*     */     }
/* 123 */     res.starttime = ((int)TimeUnit.MILLISECONDS.toSeconds(wrapper.getQuestionBeginTime()));
/* 124 */     OnlineManager.getInstance().send(this.roleId, res);
/* 125 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PGetHuiShiQuestionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */