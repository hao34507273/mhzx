/*    */ package mzm.gsp.question.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.question.SQYXTQuestionRes;
/*    */ import mzm.gsp.question.confbean.SQYXTQuestionCfg;
/*    */ import mzm.gsp.question.confbean.SQYXTQuestionConst;
/*    */ import mzm.gsp.question.session.QuestionSessionInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.QYXTQuestionInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2qyxtquestion;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCGetQYXTQuestionReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCGetQYXTQuestionReq(long roleid)
/*    */   {
/* 24 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     if (!QYXTQuestionActivity.checkMutexStatus(this.roleid))
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/* 36 */     lock(Lockeys.get(User.getTable(), userid));
/* 37 */     lock(Lockeys.get(Role2qyxtquestion.getTable(), Long.valueOf(this.roleid)));
/* 38 */     ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, SQYXTQuestionConst.getInstance().ACTIVITY_ID);
/* 39 */     QYXTQuestionInfo qyxtQuestionInfo = Role2qyxtquestion.get(Long.valueOf(this.roleid));
/* 40 */     if (qyxtQuestionInfo == null)
/*    */     {
/* 42 */       GameServer.logger().info(String.format("[QYXT]PCGetQYXTQuestionReq.processImp@questionInfo is null|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     int count = ActivityInterface.getActivityCount(userid, this.roleid, SQYXTQuestionConst.getInstance().ACTIVITY_ID, true);
/*    */     
/* 49 */     int nextQyxtQuestionCfgId = QYXTQuestionActivity.getNextQuestionid(qyxtQuestionInfo, count);
/* 50 */     SQYXTQuestionCfg sqyxtQuestionCfg = SQYXTQuestionCfg.get(nextQyxtQuestionCfgId);
/* 51 */     if (sqyxtQuestionCfg == null)
/*    */     {
/* 53 */       GameServer.logger().info(String.format("[QYXT]PCGetQYXTQuestionReq.processImp@question cfg id is not exist|role_id=%d|question_cfg_id", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(nextQyxtQuestionCfgId) }));
/*    */       
/*    */ 
/*    */ 
/* 57 */       return false;
/*    */     }
/* 59 */     Set<Integer> currentSeekSet = qyxtQuestionInfo.getSeek_help_questions();
/* 60 */     boolean isInGangHelp = currentSeekSet.contains(Integer.valueOf(nextQyxtQuestionCfgId));
/*    */     
/* 62 */     long sessionId = QuestionSessionInterface.createQuestionSession(this.roleid, QuestionTypeEnum.QYXT, nextQyxtQuestionCfgId, 0, sqyxtQuestionCfg.answerNum, 1);
/*    */     
/*    */ 
/* 65 */     SQYXTQuestionRes sqyxtQuestionRes = new SQYXTQuestionRes();
/* 66 */     sqyxtQuestionRes.alreadyanswer = count;
/* 67 */     sqyxtQuestionRes.rightanswer = qyxtQuestionInfo.getRightnum();
/* 68 */     sqyxtQuestionRes.questionid = nextQyxtQuestionCfgId;
/* 69 */     sqyxtQuestionRes.isinganghelp = (isInGangHelp ? 1 : 0);
/* 70 */     sqyxtQuestionRes.useganghelptimes = currentSeekSet.size();
/* 71 */     sqyxtQuestionRes.session_id = sessionId;
/* 72 */     sqyxtQuestionRes.answer_sequence.addAll(QuestionSessionInterface.getAnswerRandomSequence(sessionId));
/*    */     
/* 74 */     OnlineManager.getInstance().send(this.roleid, sqyxtQuestionRes);
/* 75 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PCGetQYXTQuestionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */