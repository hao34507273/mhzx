/*    */ package mzm.gsp.superequipment.wushi.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCPutOffWuShi
/*    */   extends LogicProcedure
/*    */ {
/*    */   final long roleId;
/*    */   
/*    */   public PCPutOffWuShi(long roleId)
/*    */   {
/* 14 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     return WuShiManager.putOffWuShi(this.roleId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\wushi\main\PCPutOffWuShi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */