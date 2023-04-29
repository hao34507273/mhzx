/*    */ package mzm.gsp.question.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RolePictureQuestionInfo;
/*    */ import xtable.Role2picturequestion;
/*    */ 
/*    */ public class StartPictureQuestion
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public StartPictureQuestion(long roleid)
/*    */   {
/* 16 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     RolePictureQuestionInfo roleInfo = Role2picturequestion.get(Long.valueOf(this.roleid));
/* 23 */     if (roleInfo == null)
/*    */     {
/* 25 */       return false;
/*    */     }
/* 27 */     Long teamIdLong = TeamInterface.getTeamidByRoleid(this.roleid, false);
/* 28 */     if ((teamIdLong != null) && (!TeamInterface.isTeamLeader(teamIdLong.longValue(), this.roleid, false)))
/*    */     {
/* 30 */       PictureQuestionManager.getInstance().sendErrorRes(2, Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     QuestionInterface.startPictureQuestion(roleInfo.getPicinfoid());
/* 35 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\StartPictureQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */