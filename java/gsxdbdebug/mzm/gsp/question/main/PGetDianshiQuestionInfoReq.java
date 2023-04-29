/*    */ package mzm.gsp.question.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityLogStatus;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.question.CGetDianShiQuestionInfo;
/*    */ import mzm.gsp.question.SSyncDianShiQuestionRes;
/*    */ import mzm.gsp.question.confbean.KeJuQuestionConsts;
/*    */ import mzm.gsp.question.confbean.SKeJuQuestionItemCfg;
/*    */ import mzm.gsp.question.session.QuestionSessionInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.KeJuInfo;
/*    */ import xtable.Role2keju;
/*    */ 
/*    */ public class PGetDianshiQuestionInfoReq
/*    */   extends AbsQuestionProcedure<CGetDianShiQuestionInfo>
/*    */ {
/*    */   public PGetDianshiQuestionInfoReq(CGetDianShiQuestionInfo protocol)
/*    */   {
/* 22 */     super(protocol);
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     if (!KeJuQuestionManager.getInstance().isKejuSwitchOpenForRole(this.roleId))
/*    */     {
/* 30 */       return false;
/*    */     }
/* 32 */     if (!QuestionInterface.isRoleStateCanAnswerQuestion(this.roleId))
/*    */     {
/* 34 */       String logStr = String.format("[keju]PGetDianshiQuestionInfoReq.processImp@role state can not answer question|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 36 */       KeJuQuestionManager.logger.info(logStr);
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     int stage = ActivityInterface.getActivityStage(KeJuQuestionConsts.getInstance().ACTIVITY_ID);
/* 41 */     if (stage != 3)
/*    */     {
/* 43 */       return false;
/*    */     }
/* 45 */     if (!MapInterface.isNearByNPC(this.roleId, KeJuQuestionConsts.getInstance().DIANSHI_NPC_ID))
/*    */     {
/* 47 */       return false;
/*    */     }
/* 49 */     KeJuInfo xKeJuInfo = Role2keju.get(Long.valueOf(this.roleId));
/* 50 */     if ((xKeJuInfo == null) || (xKeJuInfo.getState() != 3))
/*    */     {
/* 52 */       return false;
/*    */     }
/* 54 */     KeJuWrapper wrapper = new KeJuWrapper(xKeJuInfo);
/* 55 */     SSyncDianShiQuestionRes res = new SSyncDianShiQuestionRes();
/* 56 */     res.questionid = wrapper.getQuestionid();
/* 57 */     res.alreadyanswer = wrapper.getAnswerNum();
/* 58 */     res.rightanswer = wrapper.getRightNum();
/* 59 */     res.totaladdtime = wrapper.getPunishTime();
/* 60 */     if (res.questionid >= 0)
/*    */     {
/* 62 */       SKeJuQuestionItemCfg cfg = SKeJuQuestionItemCfg.get(res.questionid);
/* 63 */       if (cfg == null) {}
/*    */       
/*    */ 
/*    */ 
/* 67 */       long sessionid = QuestionSessionInterface.createQuestionSession(this.roleId, QuestionTypeEnum.DIANSHI, res.questionid, 0, cfg.answer_num, 1);
/*    */       
/* 69 */       res.sessionid = sessionid;
/* 70 */       res.answer_sequence.addAll(QuestionSessionInterface.getAnswerRandomSequence(sessionid));
/*    */     }
/* 72 */     OnlineManager.getInstance().send(this.roleId, res);
/* 73 */     ActivityInterface.tlogActivity(this.roleId, KeJuQuestionConsts.getInstance().ACTIVITY_ID, ActivityLogStatus.ATTEND);
/* 74 */     ActivityInterface.logActivity(this.roleId, KeJuQuestionConsts.getInstance().ACTIVITY_ID, ActivityLogStatus.ATTEND);
/*    */     
/* 76 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PGetDianshiQuestionInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */