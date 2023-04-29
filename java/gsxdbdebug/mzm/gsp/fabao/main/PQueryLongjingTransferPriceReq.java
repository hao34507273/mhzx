/*    */ package mzm.gsp.fabao.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import mzm.gsp.fabao.SQueryLongjingTransferPriceRes;
/*    */ import mzm.gsp.fabao.confbean.SFabaoConstants;
/*    */ import mzm.gsp.item.confbean.SLongJingItem;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PQueryLongjingTransferPriceReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int srcItemid;
/*    */   private final int targetItemid;
/*    */   
/*    */   public PQueryLongjingTransferPriceReq(long roleid, int srcItemid, int targetItemid)
/*    */   {
/* 21 */     this.roleid = roleid;
/* 22 */     this.srcItemid = srcItemid;
/* 23 */     this.targetItemid = targetItemid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     if (this.srcItemid == this.targetItemid)
/*    */     {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     SLongJingItem sTargetItem = SLongJingItem.get(this.targetItemid);
/* 35 */     if (sTargetItem == null)
/*    */     {
/* 37 */       return false;
/*    */     }
/* 39 */     if (sTargetItem.lv < SFabaoConstants.getInstance().MIN_LEVEL_FOR_TRANSFER)
/*    */     {
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     SLongJingItem sSrcItem = SLongJingItem.get(this.srcItemid);
/* 45 */     if (sSrcItem == null)
/*    */     {
/* 47 */       return false;
/*    */     }
/* 49 */     if (sSrcItem.lv < SFabaoConstants.getInstance().MIN_LEVEL_FOR_TRANSFER)
/*    */     {
/* 51 */       return false;
/*    */     }
/* 53 */     if (sTargetItem.lv != sSrcItem.lv)
/*    */     {
/* 55 */       LongjingTransferInterface.sendErrorCode(this.roleid, 6);
/* 56 */       return false;
/*    */     }
/*    */     
/* 59 */     float targetBasePrice = LongjingTransferInterface.getLongJingItemBasePrice(sTargetItem.id);
/* 60 */     if (targetBasePrice <= 0.0F)
/*    */     {
/* 62 */       return false;
/*    */     }
/* 64 */     float srcBasePrice = LongjingTransferInterface.getLongJingItemBasePrice(sSrcItem.id);
/* 65 */     if (srcBasePrice <= 0.0F)
/*    */     {
/* 67 */       return false;
/*    */     }
/*    */     
/* 70 */     if (!LongjingTransferInterface.isRoleStateCanTransferLongjing(this.roleid))
/*    */     {
/* 72 */       return false;
/*    */     }
/*    */     
/* 75 */     if (!LongjingTransferInterface.isLongjingTransferSwitchOpenForRole(this.roleid))
/*    */     {
/* 77 */       return false;
/*    */     }
/*    */     
/* 80 */     float targetTotal = (float)(Math.pow(2.0D, sTargetItem.lv - 1) * targetBasePrice);
/* 81 */     float srcTotal = (float)(Math.pow(2.0D, sSrcItem.lv - 1) * srcBasePrice);
/* 82 */     SQueryLongjingTransferPriceRes res = new SQueryLongjingTransferPriceRes();
/* 83 */     res.itemid2price.put(Integer.valueOf(this.targetItemid), Float.valueOf(targetTotal));
/* 84 */     res.itemid2price.put(Integer.valueOf(this.srcItemid), Float.valueOf(srcTotal));
/* 85 */     OnlineManager.getInstance().send(this.roleid, res);
/* 86 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\main\PQueryLongjingTransferPriceReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */