/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.item.SUnLockHunSuccess;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PUnLockEquipHun extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private long uuid;
/*    */   private byte hunIndex;
/*    */   private int bagid;
/*    */   
/*    */   public PUnLockEquipHun(long roleid, int bagid, long uuid, int hunIndex)
/*    */   {
/* 19 */     this.roleid = roleid;
/* 20 */     this.uuid = uuid;
/* 21 */     this.hunIndex = ((byte)(hunIndex - 1));
/* 22 */     this.bagid = bagid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     if ((this.bagid < 0) || (this.hunIndex < 0))
/*    */     {
/* 30 */       return false;
/*    */     }
/* 32 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*    */     {
/* 34 */       String logStr = String.format("[item]PUnLockEquipHun.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/* 35 */       ItemManager.logger.info(logStr);
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     RoleItemBag itemBag = ItemManager.getBag(this.roleid, this.bagid);
/* 40 */     if (itemBag == null)
/*    */     {
/* 42 */       ItemManager.sendWrongInfo(this.roleid, 99, new String[0]);
/* 43 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 47 */     BasicItem basicItem = itemBag.getItemByUuid(this.uuid);
/* 48 */     if ((basicItem == null) || (!(basicItem instanceof EquipmentItem)))
/*    */     {
/* 50 */       ItemManager.sendWrongInfo(this.roleid, 102, new String[0]);
/* 51 */       return false;
/*    */     }
/*    */     
/* 54 */     EquipmentItem equipmentItem = (EquipmentItem)basicItem;
/*    */     
/* 56 */     if (!equipmentItem.isLockedHun(this.hunIndex))
/*    */     {
/* 58 */       ItemManager.sendWrongInfo(this.roleid, 370, new String[0]);
/* 59 */       return false;
/*    */     }
/*    */     
/* 62 */     if (!equipmentItem.unLockHun(this.hunIndex))
/*    */     {
/* 64 */       ItemManager.sendWrongInfo(this.roleid, 100, new String[0]);
/* 65 */       return false;
/*    */     }
/*    */     
/* 68 */     SUnLockHunSuccess resp = new SUnLockHunSuccess();
/* 69 */     resp.bagid = this.bagid;
/* 70 */     resp.uuid = this.uuid;
/* 71 */     resp.hunindex = ((byte)(this.hunIndex + 1));
/* 72 */     OnlineManager.getInstance().send(this.roleid, resp);
/*    */     
/* 74 */     String userid = RoleInterface.getUserId(this.roleid);
/*    */     
/* 76 */     ItemManager.tlogEquipLockhun(userid, this.roleid, this.uuid, equipmentItem.getCfgId(), this.bagid, this.hunIndex, false);
/*    */     
/* 78 */     StringBuilder sBuilder = new StringBuilder();
/* 79 */     sBuilder.append("[item]PLockEquipHun.processImp@unlock hun success");
/* 80 */     sBuilder.append("|equip_uuid=").append(this.uuid);
/* 81 */     sBuilder.append("|equip_item_id=").append(equipmentItem.getCfgId());
/* 82 */     sBuilder.append("|hun_index=").append(this.hunIndex);
/* 83 */     sBuilder.append("|bag_id=").append(this.bagid);
/*    */     
/* 85 */     GameServer.logger().info(sBuilder.toString());
/*    */     
/* 87 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PUnLockEquipHun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */