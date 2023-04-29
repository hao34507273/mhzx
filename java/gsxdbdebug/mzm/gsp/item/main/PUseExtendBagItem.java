/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.bag.confbean.SBagCfg;
/*     */ import mzm.gsp.item.SExtendBagRes;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.item.event.ExtendBagArg;
/*     */ import mzm.gsp.item.event.ExtendBagEvent;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PUseExtendBagItem
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long uuid;
/*     */   
/*     */   public PUseExtendBagItem(long roleid, long uuid)
/*     */   {
/*  34 */     this.roleid = roleid;
/*  35 */     this.uuid = uuid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (!ItemModuleSwitchInterface.isBagExtendSwitchOpenForRole(this.roleid))
/*     */     {
/*  43 */       return false;
/*     */     }
/*  45 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*     */     {
/*  47 */       String logStr = String.format("[item]PUseExtendBagItem.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*  49 */       ItemManager.logger.info(logStr);
/*  50 */       return false;
/*     */     }
/*  52 */     SBagCfg bagCfg = SBagCfg.get(340600000);
/*  53 */     if (bagCfg == null)
/*     */     {
/*  55 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  59 */     String userid = RoleInterface.getUserId(this.roleid);
/*  60 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*  62 */     BasicItem item = ItemInterface.getItemByUuid(this.roleid, 340600000, this.uuid, true);
/*  63 */     if ((item == null) || (item.getCfgId() != bagCfg.expendItemId))
/*     */     {
/*  65 */       return false;
/*     */     }
/*  67 */     SItemCfg itemCfg = SItemCfg.get(bagCfg.expendItemId);
/*  68 */     if ((itemCfg == null) || (itemCfg.type != 49))
/*     */     {
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     RoleItemBag extendBag = ItemManager.getBag(this.roleid, 340600000, true);
/*  74 */     if (extendBag == null)
/*  75 */       return false;
/*  76 */     if (extendBag.getCapacity() >= bagCfg.maxcapacity)
/*     */     {
/*  78 */       return false;
/*     */     }
/*  80 */     int beforecapacity = extendBag.getCapacity();
/*  81 */     int extendGrid = extendBag.getCapacity() - bagCfg.initcapacity;
/*  82 */     if (extendGrid < 0)
/*     */     {
/*  84 */       extendGrid = 0;
/*     */     }
/*     */     
/*  87 */     int extendCount = extendGrid / bagCfg.addCount + 1;
/*     */     
/*  89 */     int needItemnum = ItemConfigManager.getExpendNeedItemnum(340600000, extendCount);
/*  90 */     if (needItemnum == -1)
/*     */     {
/*  92 */       return false;
/*     */     }
/*  94 */     TLogArg logArg = new TLogArg(LogReason.ITEM_EXPEND_BAG_REM);
/*  95 */     int itemNumber = ItemInterface.getItemNumberById(this.roleid, 340600000, item.getCfgId(), true);
/*  96 */     if (itemNumber < needItemnum)
/*     */     {
/*     */ 
/*  99 */       int yuanbaoNum = (needItemnum - itemNumber) * ItemInterface.getItemYuanBaoPrice(item.getCfgId());
/*     */       
/* 101 */       boolean ret = QingfuInterface.costYuanbao(userid, this.roleid, yuanbaoNum, CostType.COST_BIND_FIRST_USE_EXTEND_BAG_ITEM, logArg) == CostResult.Success;
/*     */       
/*     */ 
/* 104 */       if ((ret) && (itemNumber > 0))
/*     */       {
/* 106 */         ret = ItemInterface.removeItemById(this.roleid, 340600000, bagCfg.expendItemId, itemNumber, logArg);
/*     */       }
/* 108 */       if (!ret)
/*     */       {
/* 110 */         return false;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 115 */       int hasnum = item.getNumber();
/* 116 */       if (hasnum < needItemnum)
/*     */       {
/* 118 */         boolean ret = ItemInterface.removeItemByUuid(this.roleid, this.uuid, hasnum, logArg);
/* 119 */         if (!ret)
/*     */         {
/* 121 */           return false;
/*     */         }
/* 123 */         ret = ItemInterface.removeItemById(this.roleid, 340600000, bagCfg.expendItemId, needItemnum - hasnum, logArg);
/* 124 */         if (!ret)
/*     */         {
/* 126 */           return false;
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 143 */         boolean ret = ItemInterface.removeItemByUuid(this.roleid, this.uuid, needItemnum, logArg);
/* 144 */         if (!ret)
/*     */         {
/* 146 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 152 */     int addCapacity = Math.min(bagCfg.maxcapacity - extendBag.getCapacity(), bagCfg.addCount);
/*     */     
/* 154 */     boolean r = extendBag.expandCapacity(addCapacity);
/* 155 */     SExtendBagRes sExtendBagRes = new SExtendBagRes();
/* 156 */     sExtendBagRes.bagid = 340600000;
/* 157 */     sExtendBagRes.capcity = extendBag.getCapacity();
/* 158 */     OnlineManager.getInstance().send(this.roleid, sExtendBagRes);
/* 159 */     int aftercapacity = sExtendBagRes.capcity;
/* 160 */     int bagtype = 1;
/* 161 */     ItemManager.tlogBagExpend(this.roleid, bagtype, beforecapacity, aftercapacity);
/* 162 */     TriggerEventsManger.getInstance().triggerEvent(new ExtendBagEvent(), new ExtendBagArg(this.roleid, beforecapacity, addCapacity));
/*     */     
/* 164 */     return r;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PUseExtendBagItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */