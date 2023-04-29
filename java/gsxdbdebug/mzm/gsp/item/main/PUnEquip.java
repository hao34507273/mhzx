/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PUnEquip
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int key;
/*    */   
/*    */   public PUnEquip(long roleid, int key)
/*    */   {
/* 21 */     this.roleid = roleid;
/* 22 */     this.key = key;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     if (this.key == 8)
/*    */     {
/* 30 */       return false;
/*    */     }
/* 32 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*    */     {
/* 34 */       String logStr = String.format("[item]PUnEquip.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/* 35 */       ItemManager.logger.info(logStr);
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     RoleItemBag bag = ItemManager.getRoleItemBag(this.roleid);
/* 40 */     RoleEquipBag equipBag = ItemManager.getRoleEquipBag(this.roleid);
/* 41 */     if ((bag == null) || (equipBag == null))
/*    */     {
/* 43 */       ItemManager.sendWrongInfo(this.roleid, 580, new String[0]);
/* 44 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 48 */     BasicItem basicItem = equipBag.get(this.key);
/* 49 */     if (basicItem == null)
/*    */     {
/* 51 */       ItemManager.sendWrongInfo(this.roleid, 581, new String[0]);
/* 52 */       return false;
/*    */     }
/* 54 */     long toUnUuid = basicItem.getTlogUuid();
/*    */     
/* 56 */     int desGrid = bag.getNextAvailableGrid();
/* 57 */     if (desGrid == -1)
/*    */     {
/* 59 */       ItemInterface.sendSpecificBagFull(this.roleid, 340600000);
/* 60 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 64 */     boolean ret = ItemInterface.moveItemBetWeenBags(this.roleid, 340600001, this.key, 340600000, desGrid);
/* 65 */     if (!ret)
/*    */     {
/* 67 */       ItemManager.sendWrongInfo(this.roleid, 582, new String[0]);
/* 68 */       return false;
/*    */     }
/*    */     
/* 71 */     ItemManager.tlogEquipOff(this.roleid, basicItem, toUnUuid, this.key);
/* 72 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PUnEquip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */