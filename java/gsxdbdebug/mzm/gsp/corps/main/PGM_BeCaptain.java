/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_BeCaptain extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_BeCaptain(long roleId)
/*    */   {
/* 12 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     AppointCaptainRes res = CorpsInterface.appointCaptainByIdip(this.roleId);
/* 19 */     if (res.isSuc())
/*    */     {
/* 21 */       GmManager.getInstance().sendResultToGM(this.roleId, "设置队长成功！");
/* 22 */       return true;
/*    */     }
/* 24 */     GmManager.getInstance().sendResultToGM(this.roleId, String.format("设置队长失败！reason=%s", new Object[] { res.getErrReason() }));
/* 25 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\PGM_BeCaptain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */