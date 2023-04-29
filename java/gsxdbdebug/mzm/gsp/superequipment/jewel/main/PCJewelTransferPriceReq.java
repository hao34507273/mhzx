/*    */ package mzm.gsp.superequipment.jewel.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.npc.main.NpcInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.superequipment.SJewelTransferPriceRsp;
/*    */ import mzm.gsp.superequipment.jewel.confbean.SSuperEquipmentJewelItem;
/*    */ import mzm.gsp.superequipment.jewel.confbean.SuperEquipmentJewelConstants;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCJewelTransferPriceReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   final long roleId;
/*    */   final List<Integer> jewelCfgIds;
/*    */   
/*    */   public PCJewelTransferPriceReq(long roleId, List<Integer> jewelCfgIds)
/*    */   {
/* 27 */     this.roleId = roleId;
/* 28 */     this.jewelCfgIds = jewelCfgIds;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 34 */     if (!OpenInterface.getOpenStatus(441))
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1607, false))
/*    */     {
/* 40 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 44 */     if (!MapInterface.isNearByNPC(this.roleId, SuperEquipmentJewelConstants.getInstance().TRANSFER_NPC_ID))
/*    */     {
/* 46 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 50 */     if (!NpcInterface.checkNpcService(SuperEquipmentJewelConstants.getInstance().TRANSFER_NPC_ID, SuperEquipmentJewelConstants.getInstance().TRANSFER_NPC_SERVICE, this.roleId))
/*    */     {
/*    */ 
/* 53 */       return false;
/*    */     }
/*    */     
/* 56 */     SJewelTransferPriceRsp jewelTransferPriceRsp = new SJewelTransferPriceRsp();
/*    */     
/*    */ 
/* 59 */     for (Iterator i$ = this.jewelCfgIds.iterator(); i$.hasNext();) { int jewelCfgId = ((Integer)i$.next()).intValue();
/*    */       
/* 61 */       SSuperEquipmentJewelItem jewelItem = SSuperEquipmentJewelItem.get(jewelCfgId);
/* 62 */       if (jewelItem == null)
/*    */       {
/* 64 */         return false;
/*    */       }
/* 66 */       if (jewelItem.jewelLevel < SuperEquipmentJewelConstants.getInstance().TRANSFER_MIN_JEWEL_LEVEL)
/*    */       {
/* 68 */         return false;
/*    */       }
/* 70 */       float basePrice = SuperEquipmentJewelManager.getJewelTransferBasePrice(jewelCfgId);
/* 71 */       if (basePrice == -1.0F)
/*    */       {
/* 73 */         return false;
/*    */       }
/*    */       
/* 76 */       jewelTransferPriceRsp.jewelcfgid2price.put(Integer.valueOf(jewelCfgId), Float.valueOf((float)(basePrice * Math.pow(2.0D, jewelItem.jewelLevel - 1))));
/*    */     }
/* 78 */     OnlineManager.getInstance().send(this.roleId, jewelTransferPriceRsp);
/* 79 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\jewel\main\PCJewelTransferPriceReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */