/*    */ package mzm.gsp.buff.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ public class PUninstallBuff
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int buffId;
/*    */   
/*    */   public PUninstallBuff(long roleId, int buffId)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.buffId = buffId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     return BuffManager.uninstallBuff(this.roleId, this.buffId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\main\PUninstallBuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */