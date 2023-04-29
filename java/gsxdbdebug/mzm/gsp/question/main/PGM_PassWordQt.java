/*    */ package mzm.gsp.question.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RoleWordQuestionInfo;
/*    */ import xbean.WordQuestionInfo;
/*    */ import xtable.Role2wordquestion;
/*    */ 
/*    */ public class PGM_PassWordQt extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_PassWordQt(long roleId)
/*    */   {
/* 16 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     Long wordQId = Role2wordquestion.get(Long.valueOf(this.roleId));
/* 23 */     if (wordQId == null)
/*    */     {
/* 25 */       return false;
/*    */     }
/* 27 */     WordQuestionInfo xWordQuestionInfo = xtable.Wordquestion.get(wordQId);
/* 28 */     if (xWordQuestionInfo == null)
/*    */     {
/* 30 */       return false;
/*    */     }
/* 32 */     RoleWordQuestionInfo xRoleInfo = (RoleWordQuestionInfo)xWordQuestionInfo.getRolequestionmap().get(Long.valueOf(this.roleId));
/* 33 */     if (xRoleInfo == null)
/*    */     {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     xRoleInfo.setRightnum(xRoleInfo.getRightnum() + 1);
/*    */     
/* 40 */     xRoleInfo.setCuridx(xRoleInfo.getCuridx() + 1);
/* 41 */     WordQuestionItemSession session = (WordQuestionItemSession)WordQuestionItemSession.getSession(xRoleInfo.getSessionid());
/* 42 */     if (session != null)
/*    */     {
/* 44 */       session.stopTimer();
/*    */     }
/* 46 */     WordQuestionManager.getInstance().syncAnswerInfo(this.roleId, xWordQuestionInfo, 1);
/* 47 */     if (xRoleInfo.getCuridx() >= xRoleInfo.getQuestionidlist().size())
/*    */     {
/* 49 */       WordQuestionManager.getInstance().detectedIsEnd(wordQId.longValue(), xWordQuestionInfo);
/*    */     }
/* 51 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PGM_PassWordQt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */