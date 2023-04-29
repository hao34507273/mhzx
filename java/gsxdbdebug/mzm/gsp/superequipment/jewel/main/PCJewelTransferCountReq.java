/*    */ package mzm.gsp.superequipment.jewel.main;
/*    */ 
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.npc.main.NpcInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.superequipment.SJewelTransferCountRsp;
/*    */ import mzm.gsp.superequipment.jewel.confbean.SuperEquipmentJewelConstants;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCJewelTransferCountReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   final long roleId;
/*    */   
/*    */   public PCJewelTransferCountReq(long roleId)
/*    */   {
/* 23 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     if (!OpenInterface.getOpenStatus(441))
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1606, false))
/*    */     {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     if (!MapInterface.isNearByNPC(this.roleId, SuperEquipmentJewelConstants.getInstance().TRANSFER_NPC_ID))
/*    */     {
/* 40 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 44 */     if (!NpcInterface.checkNpcService(SuperEquipmentJewelConstants.getInstance().TRANSFER_NPC_ID, SuperEquipmentJewelConstants.getInstance().TRANSFER_NPC_SERVICE, this.roleId))
/*    */     {
/*    */ 
/* 47 */       return false;
/*    */     }
/*    */     
/* 50 */     SJewelTransferCountRsp jewelTransferCountRsp = new SJewelTransferCountRsp();
/* 51 */     jewelTransferCountRsp.count = SuperEquipmentJewelManager.getAvailableTransferCount(this.roleId);
/* 52 */     OnlineManager.getInstance().send(this.roleId, jewelTransferCountRsp);
/* 53 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\jewel\main\PCJewelTransferCountReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */