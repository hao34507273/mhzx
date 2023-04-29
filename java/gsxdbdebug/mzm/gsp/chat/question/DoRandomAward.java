/*    */ package mzm.gsp.chat.question;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.AnswerWorldQuestionData;
/*    */ import xtable.Basic;
/*    */ import xtable.Role2worldquestion;
/*    */ import xtable.User;
/*    */ 
/*    */ class DoRandomAward extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   DoRandomAward(long roleId)
/*    */   {
/* 20 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*    */     
/*    */ 
/* 29 */     lock(User.getTable(), Arrays.asList(new String[] { userId }));
/*    */     
/* 31 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*    */     
/* 33 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*    */     
/*    */ 
/* 36 */     AnswerWorldQuestionData xAnswerWorldQuestionData = getAndResetRoleWorldQuestionData(curTime);
/*    */     
/* 38 */     int alreadyAwardCount = xAnswerWorldQuestionData.getGetnbawardnum();
/* 39 */     if ((WorldQuestion.getInstance().isDayAwardMaxOpen()) && (alreadyAwardCount >= WorldQuestion.getInstance().getDayAwardNBCount()))
/*    */     {
/*    */ 
/* 42 */       GameServer.logger().info(String.format("[worldquestion]DoRandomAward.processImp@ touch max line!|roleId=%d|alreadyAwardCount=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(alreadyAwardCount) }));
/*    */       
/*    */ 
/* 45 */       return false;
/*    */     }
/* 47 */     AwardReason reason = new AwardReason(LogReason.WORLD_QUESTION_RANDOM_AWARD_ADD);
/* 48 */     mzm.gsp.award.main.AwardModel am = mzm.gsp.award.main.AwardInterface.award(WorldQuestion.getInstance().getNBAwardId(), userId, this.roleId, -1, false, true, reason);
/*    */     
/* 50 */     if (am == null)
/*    */     {
/* 52 */       GameServer.logger().error(String.format("[worldquestion]DoRandomAward.processImp@ do random award err!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*    */       
/* 54 */       return false;
/*    */     }
/* 56 */     xAnswerWorldQuestionData.setGetnbawardnum(alreadyAwardCount + 1);
/* 57 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private AnswerWorldQuestionData getAndResetRoleWorldQuestionData(long curTime)
/*    */   {
/* 70 */     AnswerWorldQuestionData xAnswerWorldQuestionData = Role2worldquestion.get(Long.valueOf(this.roleId));
/* 71 */     if (xAnswerWorldQuestionData == null)
/*    */     {
/* 73 */       Role2worldquestion.insert(Long.valueOf(this.roleId), xAnswerWorldQuestionData = xbean.Pod.newAnswerWorldQuestionData());
/*    */     }
/* 75 */     if ((xAnswerWorldQuestionData.getUpdatetime() <= 0L) || (DateTimeUtils.needDailyReset(xAnswerWorldQuestionData.getUpdatetime(), curTime, 0)))
/*    */     {
/*    */ 
/* 78 */       xAnswerWorldQuestionData.setGetnbawardnum(0);
/* 79 */       xAnswerWorldQuestionData.setUpdatetime(curTime);
/*    */     }
/* 81 */     return xAnswerWorldQuestionData;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\question\DoRandomAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */