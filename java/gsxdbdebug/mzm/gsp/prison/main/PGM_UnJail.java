/*    */ package mzm.gsp.prison.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.pk.confbean.SPKConsts;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_UnJail
/*    */   extends LogicProcedure
/*    */ {
/*    */   final long targetRoleId;
/*    */   final long gmRoleId;
/*    */   
/*    */   public PGM_UnJail(long targetRoleId, long gmRoleId)
/*    */   {
/* 21 */     this.targetRoleId = targetRoleId;
/* 22 */     this.gmRoleId = gmRoleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     if (PrisonInterface.isRoleInJail(this.targetRoleId))
/*    */     {
/* 30 */       PrisonInterface.letRoleOutOfJail(this.targetRoleId, SPKConsts.getInstance().JAIL_OUT_MAIL_ID, new ArrayList(), new ArrayList(), new TLogArg(LogReason.JAIL_OUT_MAIL));
/*    */       
/* 32 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "角色出狱成功");
/*    */     }
/*    */     else
/*    */     {
/* 36 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "角色已经出狱");
/*    */     }
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\PGM_UnJail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */