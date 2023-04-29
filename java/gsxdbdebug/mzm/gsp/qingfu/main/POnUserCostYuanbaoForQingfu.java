/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import xbean.CheckOrderInfo;
/*    */ import xtable.Qingfu;
/*    */ 
/*    */ public class POnUserCostYuanbaoForQingfu extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final String userid;
/*    */   private final long roleid;
/*    */   private final String billno;
/*    */   
/*    */   public POnUserCostYuanbaoForQingfu(String userid, long roleid, String billno)
/*    */   {
/* 14 */     this.userid = userid;
/* 15 */     this.roleid = roleid;
/* 16 */     this.billno = billno;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     if (!QingfuManager.isMidasMode)
/*    */     {
/* 24 */       return true;
/*    */     }
/*    */     
/* 27 */     xbean.QingfuInfo xQingfuInfo = Qingfu.get(this.userid);
/* 28 */     if (xQingfuInfo == null)
/*    */     {
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     xbean.UserAuAnyCheckOrders xUserAuAnyCheckOrders = xtable.User2auanycheckorders.get(this.userid);
/* 34 */     if (xUserAuAnyCheckOrders == null)
/*    */     {
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     CheckOrderInfo xCheckOrderInfo = xtable.Checkorders.get(this.billno);
/* 40 */     if ((xCheckOrderInfo == null) || (xCheckOrderInfo.getStatus() != 1))
/*    */     {
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     return QingfuManager.sendTryCheckNextOrderReq(this.userid, this.billno, xUserAuAnyCheckOrders, xCheckOrderInfo);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\POnUserCostYuanbaoForQingfu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */