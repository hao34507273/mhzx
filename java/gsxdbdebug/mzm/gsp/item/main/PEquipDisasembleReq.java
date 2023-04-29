/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.item.SEquipDisassembleRes;
/*     */ import mzm.gsp.item.confbean.EquipItemCfgConsts;
/*     */ import mzm.gsp.item.confbean.EquipItemid2NeedItems;
/*     */ import mzm.gsp.item.confbean.NeedItemId2Num;
/*     */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PEquipDisasembleReq extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long uuid;
/*     */   
/*     */   public PEquipDisasembleReq(long roleid, long uuid)
/*     */   {
/*  24 */     this.roleid = roleid;
/*  25 */     this.uuid = uuid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  31 */     if (!ItemModuleSwitchInterface.isEquipDisassembleSwitchOpenForRole(this.roleid))
/*     */     {
/*  33 */       return false;
/*     */     }
/*  35 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*     */     {
/*  37 */       String logStr = String.format("[item]PEquipRecycleReq.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  38 */       ItemManager.logger.info(logStr);
/*  39 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  43 */     String userid = RoleInterface.getUserId(this.roleid);
/*  44 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*     */ 
/*  47 */     RoleItemBag itemBag = ItemManager.getRoleItemBag(this.roleid);
/*     */     
/*  49 */     if (itemBag == null)
/*     */     {
/*  51 */       String logstr = String.format("[item]PEquipRecycleReq.processImp@role item bag null|roleid=%d|uuid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid) });
/*     */       
/*  53 */       ItemManager.logger.error(logstr);
/*  54 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  58 */     BasicItem basicItem = itemBag.getItemByUuid(this.uuid);
/*  59 */     if ((basicItem == null) || (!(basicItem instanceof EquipmentItem)))
/*     */     {
/*     */ 
/*  62 */       String logstr = String.format("[item]PEquipRecycleReq.processImp@item uuid error,not equipment|roleid=%d|uuid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid) });
/*     */       
/*  64 */       ItemManager.logger.error(logstr);
/*  65 */       return false;
/*     */     }
/*  67 */     if ((!EquipItemCfgConsts.getInstance().IS_BIND_EQUIP_CAN_DISASSEMBLE) && (basicItem.isBind()))
/*     */     {
/*  69 */       String logstr = String.format("[item]PEquipRecycleReq.processImp@item is bind|roleid=%d|uuid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid) });
/*  70 */       ItemManager.logger.error(logstr);
/*  71 */       return false;
/*     */     }
/*  73 */     int itemId = basicItem.getCfgId();
/*  74 */     SItemEquipCfg itemEquipCfg = SItemEquipCfg.get(itemId);
/*  75 */     if (itemEquipCfg == null)
/*     */     {
/*  77 */       String logstr = String.format("[item]PEquipRecycleReq.processImp@iSItemEquipCfg is null|roleid=%d|uuid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(itemId) });
/*     */       
/*     */ 
/*  80 */       ItemManager.logger.error(logstr);
/*  81 */       return false;
/*     */     }
/*  83 */     if (itemEquipCfg.useLevel < EquipItemCfgConsts.getInstance().MIN_EQUIP_LEVEL_FOR_DISASSEMBLE)
/*     */     {
/*  85 */       String logstr = String.format("[item]PEquipRecycleReq.processImp@item level error|roleid=%d|uuid=%d|itemid=%d|use_level=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(itemId), Integer.valueOf(itemEquipCfg.useLevel) });
/*     */       
/*     */ 
/*  88 */       ItemManager.logger.error(logstr);
/*  89 */       return false;
/*     */     }
/*  91 */     if (itemEquipCfg.namecolor < EquipItemCfgConsts.getInstance().MIN_EQUIP_COLOR_FOR_DISASSEMBLE)
/*     */     {
/*  93 */       String logstr = String.format("[item]PEquipRecycleReq.processImp@item color error|roleid=%d|uuid=%d|itemid=%d|color=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(itemId), Integer.valueOf(itemEquipCfg.namecolor) });
/*     */       
/*     */ 
/*  96 */       ItemManager.logger.error(logstr);
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     EquipmentItem equipmentItem = (EquipmentItem)basicItem;
/* 101 */     if (equipmentItem.getSuperEquipmentStage() > 0)
/*     */     {
/* 103 */       String logstr = String.format("[item]PEquipRecycleReq.processImp@item is super equipment|roleid=%d|uuid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(itemId) });
/*     */       
/*     */ 
/* 106 */       ItemManager.logger.error(logstr);
/* 107 */       return false;
/*     */     }
/*     */     
/* 110 */     EquipItemid2NeedItems equipItemid2NeedItems = EquipItemid2NeedItems.get(itemEquipCfg.id);
/* 111 */     if (equipItemid2NeedItems == null)
/*     */     {
/* 113 */       String logstr = String.format("[item]PEquipRecycleReq.processImp@EquipItemid2NeedItems is null|roleid=%d|uuid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(itemId) });
/*     */       
/*     */ 
/* 116 */       ItemManager.logger.error(logstr);
/* 117 */       return false;
/*     */     }
/*     */     
/* 120 */     int addNum = getOutPutItemNum(equipItemid2NeedItems);
/* 121 */     if (addNum < 0)
/*     */     {
/* 123 */       String logstr = String.format("[item]PEquipRecycleReq.processImp@equip make need yuanbao error|roleid=%d|uuid=%d|itemid=%d|addNum=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(itemId), Integer.valueOf(addNum) });
/*     */       
/*     */ 
/* 126 */       ItemManager.logger.error(logstr);
/* 127 */       return false;
/*     */     }
/* 129 */     TLogArg logArg = new TLogArg(LogReason.EQUIP_DISASSEMBLE, itemId);
/* 130 */     boolean result = ItemInterface.removeItemByUuid(this.roleid, this.uuid, 1, logArg);
/* 131 */     if (result)
/*     */     {
/* 133 */       if (addNum >= 1)
/*     */       {
/* 135 */         ItemOperateResult itemOperateResult = ItemInterface.addItemActive(this.roleid, EquipItemCfgConsts.getInstance().EQUIP_DISASSEMBLE_OUT_PUT_ITEMID, addNum, false, true, logArg);
/*     */         
/* 137 */         if (!itemOperateResult.success())
/*     */         {
/* 139 */           String logstr = String.format("[item]PEquipRecycleReq.processImp@add item error|roleid=%d|itemid=%d|num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(EquipItemCfgConsts.getInstance().EQUIP_DISASSEMBLE_OUT_PUT_ITEMID), Integer.valueOf(addNum) });
/*     */           
/*     */ 
/* 142 */           ItemManager.logger.error(logstr);
/* 143 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 147 */       SEquipDisassembleRes res = new SEquipDisassembleRes();
/* 148 */       res.itemid = EquipItemCfgConsts.getInstance().EQUIP_DISASSEMBLE_OUT_PUT_ITEMID;
/* 149 */       res.itemnum = addNum;
/* 150 */       OnlineManager.getInstance().send(this.roleid, res);
/* 151 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 156 */     String logstr = String.format("[item]PEquipRecycleReq.processImp@remove item error|roleid=%d|uuid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid) });
/*     */     
/* 158 */     ItemManager.logger.error(logstr);
/* 159 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getOutPutItemNum(EquipItemid2NeedItems equipItemid2NeedItems)
/*     */   {
/* 172 */     int total = 0;
/* 173 */     for (NeedItemId2Num needItemId2Num : equipItemid2NeedItems.needItemList)
/*     */     {
/* 175 */       int price = ItemInterface.getItemYuanBaoPrice(needItemId2Num.itemId);
/* 176 */       if (price <= 0)
/*     */       {
/* 178 */         String logstr = String.format("[item]PEquipRecycleReq.getEquipMakeNeedYuanbao@get item price error|roleid=%d|uuid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(needItemId2Num.itemId) });
/*     */         
/*     */ 
/* 181 */         ItemManager.logger.error(logstr);
/* 182 */         return -1;
/*     */       }
/* 184 */       total += price * needItemId2Num.itemNum;
/*     */     }
/* 186 */     return (int)(total * (EquipItemCfgConsts.getInstance().EQUIP_DISASSEMBLE_PRICE_RATE / 10000.0F));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PEquipDisasembleReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */