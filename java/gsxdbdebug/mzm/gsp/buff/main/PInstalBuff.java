/*    */ package mzm.gsp.buff.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ public class PInstalBuff
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int buffcfgId;
/*    */   
/*    */   public PInstalBuff(long roleId, int buffcfgId)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.buffcfgId = buffcfgId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     return BuffManager.installBuff(this.roleId, this.buffcfgId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\main\PInstalBuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */