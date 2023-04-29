/*    */ package mzm.gsp.question.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.question.SSyncDianShiQuestionRes;
/*    */ import mzm.gsp.question.confbean.SKeJuQuestionItemCfg;
/*    */ import mzm.gsp.question.session.QuestionSessionInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.KeJuInfo;
/*    */ import xtable.Role2keju;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PStartDianShi
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private long begintime;
/*    */   
/*    */   public PStartDianShi(long roleId, long begintime)
/*    */   {
/* 25 */     this.roleId = roleId;
/* 26 */     this.begintime = begintime;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     if (!QuestionInterface.isRoleStateCanAnswerQuestion(this.roleId))
/*    */     {
/* 34 */       String logStr = String.format("[keju]PStartDianShi.processImp@role state can not answer question|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/* 35 */       KeJuQuestionManager.logger.info(logStr);
/* 36 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 40 */     if (MapInterface.getRoleWorldInstanceId(this.roleId) != KeJuQuestionManager.getInstance().getDianshiWorldid())
/*    */     {
/* 42 */       return false;
/*    */     }
/* 44 */     KeJuInfo xKeJuInfo = Role2keju.get(Long.valueOf(this.roleId));
/* 45 */     if (xKeJuInfo == null)
/*    */     {
/* 47 */       return false;
/*    */     }
/* 49 */     xKeJuInfo.setState(3);
/* 50 */     xKeJuInfo.setStarttime(this.begintime);
/* 51 */     xKeJuInfo.setAnswernum(0);
/* 52 */     xKeJuInfo.setFinishtime(0L);
/* 53 */     xKeJuInfo.setRightnum(0);
/* 54 */     xKeJuInfo.setPunishtime(0);
/* 55 */     List<Integer> questionidList = KeJuQuestionManager.getInstance().randomQuestionByType(3);
/* 56 */     xKeJuInfo.getQuestionlist().clear();
/* 57 */     xKeJuInfo.getQuestionlist().addAll(questionidList);
/* 58 */     KeJuWrapper wrapper = new KeJuWrapper(xKeJuInfo);
/* 59 */     SSyncDianShiQuestionRes res = new SSyncDianShiQuestionRes();
/* 60 */     res.questionid = wrapper.getQuestionid();
/* 61 */     res.alreadyanswer = wrapper.getAnswerNum();
/* 62 */     res.rightanswer = wrapper.getRightNum();
/* 63 */     res.totaladdtime = wrapper.getPunishTime();
/* 64 */     if (res.questionid >= 0)
/*    */     {
/* 66 */       SKeJuQuestionItemCfg cfg = SKeJuQuestionItemCfg.get(res.questionid);
/* 67 */       if (cfg == null) {}
/*    */       
/*    */ 
/*    */ 
/* 71 */       long sessionid = QuestionSessionInterface.createQuestionSession(this.roleId, QuestionTypeEnum.DIANSHI, res.questionid, 0, cfg.answer_num, 1);
/*    */       
/* 73 */       res.sessionid = sessionid;
/* 74 */       res.answer_sequence.addAll(QuestionSessionInterface.getAnswerRandomSequence(sessionid));
/*    */     }
/* 76 */     OnlineManager.getInstance().send(this.roleId, res);
/* 77 */     KeJuQuestionManager.getInstance().syncKeJuState(this.roleId, xKeJuInfo, 3);
/* 78 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PStartDianShi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */