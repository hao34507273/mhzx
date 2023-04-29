/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.item.SConfirmRefreshHunSuccess;
/*    */ import mzm.gsp.item.confbean.EquipItemCfgConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.XExtraProBean;
/*    */ 
/*    */ public class PConfirmRefreshHunReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long uuid;
/*    */   private final int bagid;
/*    */   private final boolean isReplace;
/*    */   
/*    */   public PConfirmRefreshHunReq(long roleid, int bagid, long uuid, boolean isReplace)
/*    */   {
/* 22 */     this.roleid = roleid;
/* 23 */     this.uuid = uuid;
/* 24 */     this.bagid = bagid;
/* 25 */     this.isReplace = isReplace;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     if (!ItemModuleSwitchInterface.isEquipXihunSwitchOpenForRole(this.roleid))
/*    */     {
/* 33 */       return false;
/*    */     }
/* 35 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*    */     {
/* 37 */       String logStr = String.format("[item]PConfirmRefreshHunReq.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*    */       
/* 39 */       ItemManager.logger.info(logStr);
/* 40 */       return false;
/*    */     }
/* 42 */     int userLevel = RoleInterface.getLevel(this.roleid);
/* 43 */     if (userLevel < EquipItemCfgConsts.getInstance().EQUIP_QILIN_OPEN_LEVEL)
/*    */     {
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     RoleItemBag itemBag = ItemManager.getBag(this.roleid, this.bagid);
/* 49 */     if (itemBag == null)
/*    */     {
/* 51 */       ItemManager.sendWrongInfo(this.roleid, 99, new String[0]);
/* 52 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 56 */     BasicItem basicItem = itemBag.getItemByUuid(this.uuid);
/* 57 */     if ((basicItem == null) || (!(basicItem instanceof EquipmentItem)))
/*    */     {
/* 59 */       ItemManager.sendWrongInfo(this.roleid, 102, new String[0]);
/* 60 */       return false;
/*    */     }
/* 62 */     EquipmentItem equipmentItem = (EquipmentItem)basicItem;
/*    */     
/*    */ 
/* 65 */     int lockedHumNum = equipmentItem.getLockedHunNum();
/* 66 */     if (lockedHumNum >= equipmentItem.getHunNum())
/*    */     {
/*    */ 
/* 69 */       ItemManager.sendWrongInfo(this.roleid, 100, new String[0]);
/* 70 */       return false;
/*    */     }
/*    */     
/* 73 */     List<XExtraProBean> oldExtraProBeans = equipmentItem.getCopyXExtraProBeans();
/*    */     
/* 75 */     int result = equipmentItem.confirmRefreshHun(this.isReplace);
/* 76 */     if (result != 0)
/*    */     {
/* 78 */       if (result == -1)
/*    */       {
/* 80 */         ItemManager.sendWrongInfo(this.roleid, 301, new String[0]);
/*    */       }
/*    */       else
/*    */       {
/* 84 */         ItemManager.sendWrongInfo(this.roleid, 100, new String[0]);
/*    */       }
/*    */       
/* 87 */       return false;
/*    */     }
/*    */     
/* 90 */     SConfirmRefreshHunSuccess resp = new SConfirmRefreshHunSuccess();
/* 91 */     resp.bagid = this.bagid;
/* 92 */     resp.uuid = this.uuid;
/* 93 */     resp.isreplace = ((byte)(this.isReplace ? 1 : 0));
/* 94 */     OnlineManager.getInstance().send(this.roleid, resp);
/*    */     
/* 96 */     ItemManager.tlogEquiphunrefresh(this.roleid, equipmentItem.getCfgId(), equipmentItem.getCopyXExtraProBeans(), oldExtraProBeans, equipmentItem.getTlogUuid());
/*    */     
/*    */ 
/* 99 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PConfirmRefreshHunReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */