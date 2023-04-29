/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.item.SResUseFumoItem;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PClearFumoEffect
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long uuid;
/*    */   private long roleId;
/*    */   private int propertyType;
/*    */   private long currenttime;
/*    */   
/*    */   public PClearFumoEffect(long roleId, long uuid, int propertyType, long currenttime)
/*    */   {
/* 27 */     this.roleId = roleId;
/* 28 */     this.uuid = uuid;
/* 29 */     this.propertyType = propertyType;
/* 30 */     this.currenttime = currenttime;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 37 */     SResUseFumoItem equipFumoInfo = new SResUseFumoItem();
/*    */     
/* 39 */     equipFumoInfo.equipfumoinfo.bagid = 340600001;
/* 40 */     EquipmentItem item = (EquipmentItem)ItemInterface.getItemByUuid(this.roleId, 340600001, this.uuid);
/* 41 */     if (item == null)
/*    */     {
/* 43 */       item = (EquipmentItem)ItemInterface.getItemByUuid(this.roleId, 340600000, this.uuid);
/* 44 */       equipFumoInfo.equipfumoinfo.bagid = 340600000;
/*    */     }
/* 46 */     if (item == null)
/*    */     {
/* 48 */       List<RoleStorageBag> bags = ItemManager.getAllRoleStorageBags(this.roleId, true);
/* 49 */       for (RoleStorageBag bag : bags)
/*    */       {
/* 51 */         BasicItem basicItem = bag.getItemByUuid(this.uuid);
/* 52 */         if (basicItem != null)
/*    */         {
/* 54 */           item = (EquipmentItem)basicItem;
/* 55 */           equipFumoInfo.equipfumoinfo.bagid = bag.getStorageCfgId();
/* 56 */           break;
/*    */         }
/*    */       }
/*    */     }
/* 60 */     if (item != null)
/*    */     {
/* 62 */       if (item.getFumoTimeout(this.propertyType) > this.currenttime)
/*    */       {
/* 64 */         return true;
/*    */       }
/* 66 */       item.removeFumoProperty(this.propertyType);
/*    */       
/* 68 */       equipFumoInfo.equipfumoinfo.addvalue = 0;
/* 69 */       equipFumoInfo.equipfumoinfo.propertytype = this.propertyType;
/* 70 */       equipFumoInfo.equipfumoinfo.expirationtime = 0L;
/* 71 */       equipFumoInfo.equipfumoinfo.uuid = this.uuid;
/* 72 */       equipFumoInfo.equipfumoinfo.itemid = item.getCfgId();
/* 73 */       OnlineManager.getInstance().send(this.roleId, equipFumoInfo);
/*    */     }
/*    */     
/*    */ 
/* 77 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PClearFumoEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */