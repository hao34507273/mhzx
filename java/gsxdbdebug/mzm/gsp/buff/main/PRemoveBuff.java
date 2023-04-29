/*    */ package mzm.gsp.buff.main;
/*    */ 
/*    */ import mzm.gsp.buff.confbean.SBuffCfg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ public class PRemoveBuff
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int buffId;
/*    */   
/*    */   public PRemoveBuff(long roleId, int buffId)
/*    */   {
/* 15 */     this.roleId = roleId;
/* 16 */     this.buffId = buffId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     SBuffCfg buffCfg = SBuffCfg.get(this.buffId);
/* 23 */     if (buffCfg == null) {
/* 24 */       return false;
/*    */     }
/* 26 */     if (buffCfg.canDelete) {
/* 27 */       return BuffManager.uninstallBuff(this.roleId, this.buffId);
/*    */     }
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\main\PRemoveBuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */