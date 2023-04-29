/*    */ package mzm.gsp.fabao.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.item.confbean.SFabaoItem;
/*    */ import mzm.gsp.item.event.GainItemeArg;
/*    */ import mzm.gsp.item.main.ItemOperateResult;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ 
/*    */ public class POnGainItemEvent extends mzm.gsp.item.event.GainItemEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     int addReason = ItemFabaoTypeEnum.TYPE_REWARD.value;
/* 17 */     if (((GainItemeArg)this.arg).logArg.logReason.value == LogReason.FABAO_COMPLEX_ADD.value) {
/* 18 */       addReason = ItemFabaoTypeEnum.TYPE_COMPLEX.value;
/*    */     }
/*    */     
/* 21 */     Map<Integer, Set<Long>> changeItemUuids = ((GainItemeArg)this.arg).itemOperateResult.getChangedItemId2Uuids();
/*    */     
/* 23 */     for (Map.Entry<Integer, Integer> entry : ((GainItemeArg)this.arg).itemOperateResult.getItemChangeMap().entrySet()) {
/* 24 */       int itemCfgid = ((Integer)entry.getKey()).intValue();
/* 25 */       SFabaoItem sFabaoItem = SFabaoItem.get(itemCfgid);
/* 26 */       if (sFabaoItem != null) {
/* 27 */         int num = mzm.gsp.item.main.ItemInterface.getItemNumberById(((GainItemeArg)this.arg).roleId, 340600006, itemCfgid);
/* 28 */         Set<Long> uuids = (Set)changeItemUuids.get(Integer.valueOf(itemCfgid));
/* 29 */         String uuidStr = FabaoManager.getComplexStrByComma(uuids);
/* 30 */         FabaoManager.tlogItemFabao(((GainItemeArg)this.arg).roleId, itemCfgid, addReason, ((Integer)entry.getValue()).intValue(), num, ((GainItemeArg)this.arg).logArg.logReason.value, sFabaoItem.rank, uuidStr);
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 35 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\main\POnGainItemEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */