/*    */ package mzm.gsp.buff.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ public class PUninstallBuffWithType
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int type;
/*    */   
/*    */   public PUninstallBuffWithType(long roleId, int type)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.type = type;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     BuffManager.uninstallBuffWithType(this.roleId, this.type);
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\main\PUninstallBuffWithType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */