/*    */ package mzm.gsp.fabao.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.item.confbean.SFabaoItem;
/*    */ import mzm.gsp.item.event.RemoveItemEventProcedure;
/*    */ import mzm.gsp.item.event.RemoveItemeArg;
/*    */ import mzm.gsp.item.main.ItemOperateResult;
/*    */ 
/*    */ public class POnRemoveItemEvent extends RemoveItemEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     int addReason = ItemFabaoTypeEnum.TYPE_COST.value;
/*    */     
/* 17 */     Map<Integer, Set<Long>> changeItemUuids = ((RemoveItemeArg)this.arg).itemOperateResult.getChangedItemId2Uuids();
/*    */     
/* 19 */     for (Map.Entry<Integer, Integer> entry : ((RemoveItemeArg)this.arg).itemOperateResult.getItemChangeMap().entrySet()) {
/* 20 */       int itemCfgid = ((Integer)entry.getKey()).intValue();
/* 21 */       SFabaoItem sFabaoItem = SFabaoItem.get(itemCfgid);
/* 22 */       if (sFabaoItem != null) {
/* 23 */         int num = mzm.gsp.item.main.ItemInterface.getItemNumberById(((RemoveItemeArg)this.arg).roleId, 340600006, itemCfgid);
/* 24 */         Set<Long> uuids = (Set)changeItemUuids.get(Integer.valueOf(itemCfgid));
/* 25 */         String uuidStr = FabaoManager.getComplexStrByComma(uuids);
/* 26 */         FabaoManager.tlogItemFabao(((RemoveItemeArg)this.arg).roleId, itemCfgid, addReason, -((Integer)entry.getValue()).intValue(), num, ((RemoveItemeArg)this.arg).logArg.logReason.value, sFabaoItem.rank, uuidStr);
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\main\POnRemoveItemEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */