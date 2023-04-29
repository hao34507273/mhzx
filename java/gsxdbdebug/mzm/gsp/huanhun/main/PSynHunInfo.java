/*    */ package mzm.gsp.huanhun.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.HanhunInfo;
/*    */ import xtable.Role2huanhun;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PSynHunInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final boolean isFristTime;
/*    */   
/*    */   public PSynHunInfo(long roleId, boolean isFristTime)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.isFristTime = isFristTime;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     HanhunInfo xHunInfo = Role2huanhun.select(Long.valueOf(this.roleId));
/* 29 */     if (xHunInfo == null)
/*    */     {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     HuanhunManager.synHunInfo(this.roleId, xHunInfo, this.isFristTime);
/*    */     
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\PSynHunInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */