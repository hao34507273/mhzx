/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.item.confbean.SItemCfg;
/*    */ import mzm.gsp.item.event.RemoveItemEventProcedure;
/*    */ import mzm.gsp.item.event.RemoveItemeArg;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import xbean.Pod;
/*    */ import xbean.RoamItemRecord;
/*    */ import xbean.TreasureBagRoamOperator;
/*    */ 
/*    */ public class POnRemoveItem extends RemoveItemEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     if (!mzm.gsp.GameServerInfoManager.isRoamServer())
/*    */     {
/* 20 */       return true;
/*    */     }
/*    */     
/* 23 */     long roleId = ((RemoveItemeArg)this.arg).roleId;
/* 24 */     TLogArg logArg = ((RemoveItemeArg)this.arg).logArg;
/*    */     
/* 26 */     TreasureBagRoamOperator xTreasureBagRoamOperator = xtable.Role2treasurebagroamoperator.get(Long.valueOf(roleId));
/* 27 */     Map<Integer, Integer> removeItemId2NumMap = ((RemoveItemeArg)this.arg).itemOperateResult.getItemChangeMap();
/*    */     
/*    */ 
/* 30 */     RoamItemRecord xRoamItemRecord = Pod.newRoamItemRecord();
/* 31 */     xRoamItemRecord.getLogreason().add(Integer.valueOf(logArg.logReason.value));
/* 32 */     xRoamItemRecord.getLogreason().add(Integer.valueOf(logArg.subReason));
/*    */     
/* 34 */     for (Map.Entry<Integer, Integer> entry : removeItemId2NumMap.entrySet())
/*    */     {
/* 36 */       int itemCfgId = ((Integer)entry.getKey()).intValue();
/*    */       
/* 38 */       SItemCfg sItemCfg = SItemCfg.get(itemCfgId);
/* 39 */       if ((sItemCfg != null) && 
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 44 */         (RoleTreasureBag.canAddItemToBag(sItemCfg.type)))
/*    */       {
/*    */ 
/*    */ 
/* 48 */         xRoamItemRecord.setRemovemodel(((RemoveItemeArg)this.arg).itemOperateResult.getRemoveModelEnum().ordinal());
/* 49 */         xRoamItemRecord.getItemmap().put(entry.getKey(), entry.getValue());
/*    */       }
/*    */     }
/* 52 */     if (xRoamItemRecord.getItemmap().isEmpty())
/*    */     {
/* 54 */       return true;
/*    */     }
/*    */     
/* 57 */     if (xTreasureBagRoamOperator == null)
/*    */     {
/* 59 */       xTreasureBagRoamOperator = Pod.newTreasureBagRoamOperator();
/* 60 */       xtable.Role2treasurebagroamoperator.add(Long.valueOf(roleId), xTreasureBagRoamOperator);
/*    */     }
/* 62 */     xTreasureBagRoamOperator.getRecordlist().add(xRoamItemRecord);
/*    */     
/* 64 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\POnRemoveItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */