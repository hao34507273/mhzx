/*    */ package mzm.gsp.fabao.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import mzm.gsp.fabao.SLongjingComposeErrorRes;
/*    */ import mzm.gsp.fabao.SLongjingComposeSucRes;
/*    */ import mzm.gsp.item.confbean.SLongJingCompose;
/*    */ import mzm.gsp.item.confbean.SLongJingItem;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.item.main.ItemOperateResult;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ 
/*    */ public class PLongjingCompose extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int itemid;
/*    */   
/*    */   public PLongjingCompose(long roleid, int itemid)
/*    */   {
/* 21 */     this.roleid = roleid;
/* 22 */     this.itemid = itemid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 27 */     if (FabaoManager.checkInCross(this.roleid)) {
/* 28 */       sendError(7);
/* 29 */       return false;
/*    */     }
/* 31 */     SLongJingCompose sLongJingCompose = SLongJingCompose.get(this.itemid);
/* 32 */     SLongJingItem sLongJingItem = SLongJingItem.get(this.itemid);
/* 33 */     if ((sLongJingCompose == null) || (sLongJingItem == null)) {
/* 34 */       sendError(4);
/* 35 */       return false;
/*    */     }
/* 37 */     int maxLongjingLv = FabaoManager.getLongjingMaxLevel(mzm.gsp.role.main.RoleInterface.getLevel(this.roleid));
/* 38 */     if (sLongJingItem.lv > maxLongjingLv) {
/* 39 */       sendError(6);
/* 40 */       return false;
/*    */     }
/* 42 */     SLongJingItem beforeLongjingItem = SLongJingItem.get(sLongJingCompose.beforeLongjingid);
/* 43 */     if (beforeLongjingItem == null) {
/* 44 */       sendError(4);
/* 45 */       return false;
/*    */     }
/* 47 */     if (!ItemInterface.removeItemById(this.roleid, beforeLongjingItem.id, beforeLongjingItem.complexNextCount, new TLogArg(LogReason.FABAO_LONGJING_REM)))
/*    */     {
/* 49 */       sendError(1);
/* 50 */       return false;
/*    */     }
/*    */     
/* 53 */     ItemOperateResult itemOperateResult = ItemInterface.addItem(this.roleid, this.itemid, 1, new TLogArg(LogReason.FABAO_LONGJING_ADD));
/*    */     
/* 55 */     if (!itemOperateResult.success()) {
/* 56 */       sendError(5);
/* 57 */       return false;
/*    */     }
/*    */     
/* 60 */     SLongjingComposeSucRes sLongjingComposeSucRes = new SLongjingComposeSucRes();
/* 61 */     sLongjingComposeSucRes.itemid2num.put(Integer.valueOf(this.itemid), Integer.valueOf(1));
/* 62 */     OnlineManager.getInstance().send(this.roleid, sLongjingComposeSucRes);
/*    */     
/* 64 */     return true;
/*    */   }
/*    */   
/*    */   private void sendError(int error) {
/* 68 */     SLongjingComposeErrorRes longjingComplexErrorRes = new SLongjingComposeErrorRes();
/* 69 */     longjingComplexErrorRes.resultcode = error;
/* 70 */     OnlineManager.getInstance().sendAtOnce(this.roleid, longjingComplexErrorRes);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\main\PLongjingCompose.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */