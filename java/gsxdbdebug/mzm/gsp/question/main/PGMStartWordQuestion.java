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
/*    */ public class PGMStartWordQuestion
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int levelId;
/*    */   
/*    */   public PGMStartWordQuestion(long roleId, int levelId)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.levelId = levelId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     List<Long> allList = TeamInterface.getNormalRoleList(this.roleId);
/* 28 */     if (allList.isEmpty())
/*    */     {
/* 30 */       allList.add(Long.valueOf(this.roleId));
/*    */     }
/* 32 */     WordQuestionManager.getInstance().startQuestion(allList, this.levelId, 4, null);
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PGMStartWordQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */