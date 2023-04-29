/*    */ package mzm.gsp.question.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.PictureInfo;
/*    */ import xbean.PictureQuestionInfo;
/*    */ import xbean.RolePictureQuestionInfo;
/*    */ import xtable.Role2picturequestion;
/*    */ 
/*    */ public class PGM_PassPic extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_PassPic(long roleId)
/*    */   {
/* 16 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     RolePictureQuestionInfo xRoleInfo = Role2picturequestion.get(Long.valueOf(this.roleId));
/* 23 */     if (xRoleInfo == null)
/* 24 */       return false;
/* 25 */     long picQuestionid = xRoleInfo.getPicinfoid();
/* 26 */     PictureInfo xPictureInfo = xtable.Picturequestion.get(Long.valueOf(picQuestionid));
/* 27 */     if (xPictureInfo == null)
/* 28 */       return false;
/* 29 */     int idx = xPictureInfo.getQuestionidx();
/* 30 */     if (xPictureInfo.getQuestionlist().size() <= idx)
/*    */     {
/* 32 */       return false;
/*    */     }
/* 34 */     PictureQuestionInfo xPictureQuestionInfo = (PictureQuestionInfo)xPictureInfo.getQuestionlist().get(idx);
/*    */     
/* 36 */     if (xPictureQuestionInfo.getAnswerroleid() != this.roleId)
/*    */     {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     xPictureInfo.setRightanswercount(xPictureInfo.getRightanswercount() + 1);
/* 42 */     xRoleInfo.setRightnum(xRoleInfo.getRightnum() + 1);
/* 43 */     xRoleInfo.setTotalnum(xRoleInfo.getTotalnum() + 1);
/* 44 */     xPictureInfo.setQuestionidx(xPictureInfo.getQuestionidx() + 1);
/* 45 */     PictureQuestionManager.getInstance().moveToCurrentQuestion(picQuestionid, xPictureInfo, true, xPictureQuestionInfo.getRightanswer());
/*    */     
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PGM_PassPic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */