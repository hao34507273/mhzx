/*     */ package mzm.gsp.question.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.question.CGetXiangShiQuestionReq;
/*     */ import mzm.gsp.question.SXiangShiQuestionRes;
/*     */ import mzm.gsp.question.confbean.KeJuQuestionConsts;
/*     */ import mzm.gsp.question.confbean.SKeJuQuestionItemCfg;
/*     */ import mzm.gsp.question.session.QuestionSessionInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.KeJuInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2keju;
/*     */ import xtable.Role2properties;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PGetXiangShiQuestionReq extends AbsQuestionProcedure<CGetXiangShiQuestionReq>
/*     */ {
/*     */   public PGetXiangShiQuestionReq(CGetXiangShiQuestionReq protocol)
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
/*  40 */       String logStr = String.format("[keju]PGetXiangShiQuestionReq.processImp@role state can not answer question|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  42 */       KeJuQuestionManager.logger.info(logStr);
/*  43 */       return false;
/*     */     }
/*  45 */     if (!MapInterface.isNearByNPC(this.roleId, KeJuQuestionConsts.getInstance().XIANGSHI_NPC_ID))
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     int stageIdx = ActivityInterface.getActivityStage(KeJuQuestionConsts.getInstance().ACTIVITY_ID);
/*  51 */     long activitystarttime = ActivityInterface.getActivityStartTime(KeJuQuestionConsts.getInstance().ACTIVITY_ID);
/*     */     
/*  53 */     if (stageIdx != 0)
/*     */     {
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     String userId = RoleInterface.getUserId(this.roleId);
/*     */     
/*  60 */     Lockeys.lock(User.getTable(), Arrays.asList(new String[] { userId }));
/*  61 */     Lockeys.lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*     */     
/*  63 */     ActivityJoinResult joinResult = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, KeJuQuestionConsts.getInstance().ACTIVITY_ID);
/*     */     
/*  65 */     if (!joinResult.isCanJoin())
/*     */     {
/*  67 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  87 */     KeJuInfo xKeJuInfo = Role2keju.get(Long.valueOf(this.roleId));
/*  88 */     if (xKeJuInfo == null)
/*     */     {
/*  90 */       String logStr = String.format("[keju]PGetXiangShiQuestionReq.processImp@xKeJuInfo null not init|userId=%s|roleid=%d", new Object[] { userId, Long.valueOf(this.roleId) });
/*     */       
/*  92 */       KeJuQuestionManager.logger.error(logStr);
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     if (xKeJuInfo.getState() != 1)
/*     */     {
/*  98 */       return false;
/*     */     }
/* 100 */     if (xKeJuInfo.getStarttime() < activitystarttime)
/*     */     {
/* 102 */       xKeJuInfo.setStarttime(DateTimeUtils.getCurrTimeInMillis());
/*     */     }
/*     */     
/* 105 */     KeJuWrapper wrapper = new KeJuWrapper(xKeJuInfo);
/* 106 */     SXiangShiQuestionRes res = new SXiangShiQuestionRes();
/* 107 */     res.alreadyanswer = wrapper.getAnswerNum();
/* 108 */     res.questionid = wrapper.getQuestionid();
/* 109 */     res.rightanswer = wrapper.getRightNum();
/* 110 */     if (res.questionid >= 0)
/*     */     {
/* 112 */       SKeJuQuestionItemCfg cfg = SKeJuQuestionItemCfg.get(res.questionid);
/* 113 */       if (cfg == null) {}
/*     */       
/*     */ 
/*     */ 
/* 117 */       long sessionid = QuestionSessionInterface.createQuestionSession(this.roleId, QuestionTypeEnum.XIANGSHI, res.questionid, 0, cfg.answer_num, 1);
/*     */       
/* 119 */       res.sessionid = sessionid;
/* 120 */       res.answer_sequence.addAll(QuestionSessionInterface.getAnswerRandomSequence(sessionid));
/*     */     }
/* 122 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 124 */     ActivityInterface.tlogActivity(this.roleId, KeJuQuestionConsts.getInstance().ACTIVITY_ID, ActivityLogStatus.ATTEND);
/* 125 */     ActivityInterface.logActivity(this.roleId, KeJuQuestionConsts.getInstance().ACTIVITY_ID, ActivityLogStatus.ATTEND);
/* 126 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PGetXiangShiQuestionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */