/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGMAddSilver
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long addSilver;
/*    */   
/*    */   public PGMAddSilver(long roleId, long addSilver)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.addSilver = addSilver;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     RoleInterface.addSilver(this.roleId, this.addSilver, new TLogArg(LogReason.GM_ADD));
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PGMAddSilver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */