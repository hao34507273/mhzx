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
/*    */ public class PGM_StartPic
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int levelId;
/*    */   
/*    */   public PGM_StartPic(long roleId, int levelId)
/*    */   {
/* 19 */     this.roleId = roleId;
/* 20 */     this.levelId = levelId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     List<Long> memberList = TeamInterface.getNormalRoleList(this.roleId);
/* 27 */     if (memberList.isEmpty())
/*    */     {
/* 29 */       memberList.add(Long.valueOf(this.roleId));
/*    */     }
/* 31 */     PictureQuestionManager.getInstance().preparePictureQuestion(memberList, this.levelId, null);
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PGM_StartPic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */