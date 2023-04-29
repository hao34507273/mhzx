/*    */ package mzm.gsp.memorycompetition.event;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ public class MemoryCompetitionGameEndArg
/*    */ {
/*    */   public final List<Long> roleIdList;
/*    */   public final int activityCfgId;
/*    */   public final int memoryCompetitionCfgId;
/*    */   public final int score;
/*    */   public final Map<Long, List<MemoryQuestionInfo>> questionInfoMap;
/*    */   
/*    */   public MemoryCompetitionGameEndArg(List<Long> roleIdList, int activityCfgId, int memoryCompetitionCfgId, int score, Map<Long, List<MemoryQuestionInfo>> questionInfoMap)
/*    */   {
/* 17 */     this.roleIdList = roleIdList;
/* 18 */     this.activityCfgId = activityCfgId;
/* 19 */     this.memoryCompetitionCfgId = memoryCompetitionCfgId;
/* 20 */     this.score = score;
/* 21 */     this.questionInfoMap = questionInfoMap;
/*    */   }
/*    */   
/*    */   public static class MemoryQuestionInfo
/*    */   {
/*    */     public final int questionId;
/*    */     public final boolean isAnswerRight;
/*    */     public final long answerTime;
/*    */     
/*    */     public MemoryQuestionInfo(int questionId, boolean isAnswerRight, long answerTime)
/*    */     {
/* 32 */       this.questionId = questionId;
/* 33 */       this.isAnswerRight = isAnswerRight;
/* 34 */       this.answerTime = answerTime;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\event\MemoryCompetitionGameEndArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */