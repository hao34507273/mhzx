/*    */ package mzm.gsp.question.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGMStartQuestion
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int questionCfgId;
/*    */   
/*    */   public PGMStartQuestion(long roleId, int questionCfgId)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.questionCfgId = questionCfgId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     List<Long> roleids = TeamInterface.getNormalRoleList(this.roleId);
/* 29 */     if (roleids.size() == 0)
/*    */     {
/* 31 */       roleids.add(Long.valueOf(this.roleId));
/*    */     }
/* 33 */     QuestionInterface.startHuanYueDongFuWordQuestion(roleids, this.questionCfgId, null);
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PGMStartQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */