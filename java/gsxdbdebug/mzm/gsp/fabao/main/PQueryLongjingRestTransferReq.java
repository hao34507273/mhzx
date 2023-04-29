/*    */ package mzm.gsp.fabao.main;
/*    */ 
/*    */ import mzm.gsp.fabao.SQueryLongjingRestTransferRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Role2fabaosys;
/*    */ 
/*    */ public class PQueryLongjingRestTransferReq extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PQueryLongjingRestTransferReq(long roleid)
/*    */   {
/* 14 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     if (!LongjingTransferInterface.isLongjingTransferSwitchOpenForRole(this.roleid))
/*    */     {
/* 22 */       return false;
/*    */     }
/* 24 */     Integer transferCount = Role2fabaosys.selectTransfercount(Long.valueOf(this.roleid));
/* 25 */     if (transferCount == null)
/*    */     {
/* 27 */       return false;
/*    */     }
/* 29 */     if (transferCount.intValue() < 0)
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     SQueryLongjingRestTransferRes res = new SQueryLongjingRestTransferRes();
/* 34 */     res.resttransfercount = (LongjingTransferInterface.getMaxLongjingTransferCount() - transferCount.intValue());
/* 35 */     OnlineManager.getInstance().send(this.roleid, res);
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\main\PQueryLongjingRestTransferReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */