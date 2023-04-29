/*    */ package mzm.gsp.shanghui.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PRefreshShangHuiListReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int subType;
/*    */   private int index;
/*    */   
/*    */   public PRefreshShangHuiListReq(long roleId, int subType, int index)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.subType = subType;
/* 16 */     this.index = index;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     if (!ShanghuiManager.isShangHuiSwitchOpenForRole(this.roleId)) {
/* 23 */       return false;
/*    */     }
/* 25 */     ShanghuiManager.syncShangHuiInfo(this.roleId, this.subType, this.index);
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\main\PRefreshShangHuiListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */