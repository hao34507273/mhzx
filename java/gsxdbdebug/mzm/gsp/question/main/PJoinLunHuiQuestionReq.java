/*     */ package mzm.gsp.question.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.question.SJoinLunHuiQuestionRes;
/*     */ import mzm.gsp.question.confbean.SEveryDayQuestionConsts;
/*     */ import mzm.gsp.question.confbean.SEveryDayQuestionItemCfg;
/*     */ import mzm.gsp.question.session.QuestionSessionInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.EveryDayQuestionAnswerInfo;
/*     */ import xbean.QuestionInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2properties;
/*     */ import xtable.Role2question;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class PJoinLunHuiQuestionReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   
/*     */   public PJoinLunHuiQuestionReq(long roleId)
/*     */   {
/*  32 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (!EveryDayQuestionManager.getInstance().isZhuxianQiYuanSwitchOpenForRole(this.roleId))
/*     */     {
/*  40 */       return false;
/*     */     }
/*  42 */     if (!QuestionInterface.isRoleStateCanAnswerQuestion(this.roleId))
/*     */     {
/*  44 */       String logStr = String.format("[everydayquestion]PJoinLunHuiQuestionReq.processImp@role state can not answer question|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  46 */       EveryDayQuestionManager.getInstance().logger.info(logStr);
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     String userid = RoleInterface.getUserId(this.roleId);
/*  51 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*  53 */     lock(Lockeys.get(Role2properties.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*  55 */     ActivityJoinResult joinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleId, EveryDayQuestionManager.getInstance().getActivityId());
/*     */     
/*     */ 
/*     */ 
/*  59 */     if (!joinResult.isCanJoin())
/*     */     {
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     QuestionInfo xQuestionInfo = Role2question.get(Long.valueOf(this.roleId));
/*     */     
/*  66 */     if (xQuestionInfo == null)
/*     */     {
/*  68 */       return false;
/*     */     }
/*  70 */     EveryDayQuestionAnswerInfo xEveryDayInfo = xQuestionInfo.getEverydayinfo();
/*     */     
/*  72 */     SJoinLunHuiQuestionRes res = new SJoinLunHuiQuestionRes();
/*  73 */     res.answerednum = xEveryDayInfo.getCurrentquestionidx();
/*     */     
/*  75 */     if (xEveryDayInfo.getQuestionlist().size() <= xEveryDayInfo.getCurrentquestionidx())
/*     */     {
/*  77 */       res.questionid = -1;
/*     */     }
/*     */     else
/*     */     {
/*  81 */       res.questionid = ((Integer)xEveryDayInfo.getQuestionlist().get(xEveryDayInfo.getCurrentquestionidx())).intValue();
/*     */       
/*  83 */       String logstrs = String.format("[everydayquestion]PJoinLunHuiQuestionReq.processImp@ init getCurrentanswerpageidx unnormal|userid=%s|roleid=%d|questionId=%d|answersize=%d", new Object[] { userid, Long.valueOf(this.roleId), Integer.valueOf(res.questionid), Integer.valueOf(xEveryDayInfo.getCurrentanswerpageidx()) });
/*     */       
/*     */ 
/*  86 */       EveryDayQuestionManager.getInstance().logger.warn(logstrs);
/*     */       
/*  88 */       SEveryDayQuestionItemCfg questionItemCfg = SEveryDayQuestionItemCfg.get(res.questionid);
/*     */       
/*  90 */       if ((questionItemCfg != null) && (xEveryDayInfo.getCurrentanswerpageidx() >= questionItemCfg.answerList.size() / SEveryDayQuestionConsts.getInstance().ANSWER_SIZE))
/*     */       {
/*     */ 
/*     */ 
/*  94 */         String logstr = String.format("[everydayquestion]PJoinLunHuiQuestionReq.processImp@getCurrentanswerpageidx unnormal|userid=%s|roleid=%d|questionId=%d|answersize=%d|totalsize=%d", new Object[] { userid, Long.valueOf(this.roleId), Integer.valueOf(res.questionid), Integer.valueOf(xEveryDayInfo.getCurrentanswerpageidx()), Integer.valueOf(questionItemCfg.answerList.size()) });
/*     */         
/*     */ 
/*     */ 
/*  98 */         EveryDayQuestionManager.getInstance().logger.warn(logstr);
/*     */         
/* 100 */         xEveryDayInfo.setCurrentanswerpageidx(0);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 105 */     res.nextpageindex = xEveryDayInfo.getCurrentanswerpageidx();
/* 106 */     res.money = xEveryDayInfo.getAwardmoney();
/* 107 */     res.exp = xEveryDayInfo.getAwardexp();
/* 108 */     res.usehelpnum = xEveryDayInfo.getUsehelpnum();
/* 109 */     if (res.questionid >= 0)
/*     */     {
/* 111 */       SEveryDayQuestionItemCfg cfg = SEveryDayQuestionItemCfg.get(res.questionid);
/* 112 */       if (cfg == null) {}
/*     */       
/*     */ 
/*     */ 
/* 116 */       long sessionid = QuestionSessionInterface.createQuestionSession(this.roleId, QuestionTypeEnum.ZHUXIANQIYUAN, res.questionid, res.nextpageindex, SEveryDayQuestionConsts.getInstance().ANSWER_SIZE, 1);
/*     */       
/* 118 */       res.sessionid = sessionid;
/* 119 */       res.answer_sequence.addAll(QuestionSessionInterface.getAnswerRandomSequence(sessionid));
/*     */     }
/* 121 */     OnlineManager.getInstance().send(this.roleId, res);
/* 122 */     ActivityInterface.tlogActivity(this.roleId, EveryDayQuestionManager.getInstance().getActivityId(), ActivityLogStatus.ATTEND);
/* 123 */     ActivityInterface.logActivity(this.roleId, EveryDayQuestionManager.getInstance().getActivityId(), ActivityLogStatus.ATTEND);
/*     */     
/* 125 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PJoinLunHuiQuestionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */