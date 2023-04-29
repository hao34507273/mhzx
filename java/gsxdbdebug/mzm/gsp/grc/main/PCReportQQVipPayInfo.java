/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCReportQQVipPayInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int vipFlag;
/*    */   private final byte isNew;
/*    */   
/*    */   public PCReportQQVipPayInfo(long roleid, int vipFlag, byte isNew)
/*    */   {
/* 14 */     this.roleid = roleid;
/* 15 */     this.vipFlag = vipFlag;
/* 16 */     this.isNew = isNew;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     if (!GrcManager.isOpenPrivilege(this.roleid))
/*    */     {
/* 24 */       return false;
/*    */     }
/*    */     
/* 27 */     if (!GrcManager.canDoAction(this.roleid, 303))
/*    */     {
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     return GrcManager.checkQQVipPayInfo(this.roleid, this.vipFlag, this.isNew);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\PCReportQQVipPayInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */