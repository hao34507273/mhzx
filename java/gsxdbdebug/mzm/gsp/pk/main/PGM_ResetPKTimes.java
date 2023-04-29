/*    */ package mzm.gsp.pk.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.RolePKInformation;
/*    */ 
/*    */ public class PGM_ResetPKTimes extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_ResetPKTimes(long gmRoleId, long roleId)
/*    */   {
/* 13 */     this.gmRoleId = gmRoleId;
/* 14 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     RolePKInformation xRolePKInformation = PKManager.getRolePKInformation(this.roleId);
/* 21 */     if (xRolePKInformation != null)
/*    */     {
/* 23 */       xRolePKInformation.setActive_pk_times(0);
/*    */     }
/* 25 */     PKLogManager.info(String.format("PGM_ResetPKTimes.processImp()@done|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/* 26 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("为%d重置PK次数成功", new Object[] { Long.valueOf(this.roleId) }));
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\main\PGM_ResetPKTimes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */