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
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
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
/*     */ public class PExtendBag
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int bagId;
/*     */   private final long curYuanbaoNum;
/*     */   private final int isUseYuanbao;
/*     */   
/*     */   public PExtendBag(long roleid, int bagId, long curYuanbaoNum, int isUseYuanbao)
/*     */   {
/*  37 */     this.roleid = roleid;
/*  38 */     this.bagId = bagId;
/*  39 */     this.curYuanbaoNum = curYuanbaoNum;
/*  40 */     this.isUseYuanbao = isUseYuanbao;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  46 */     if (!ItemModuleSwitchInterface.isBagExtendSwitchOpenForRole(this.roleid))
/*     */     {
/*  48 */       return false;
/*     */     }
/*  50 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*     */     {
/*  52 */       String logStr = String.format("[item]PExtendBag.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  53 */       ItemManager.logger.info(logStr);
/*  54 */       return false;
/*     */     }
/*  56 */     if (this.bagId != 340600000)
/*     */     {
/*  58 */       return false;
/*     */     }
/*  60 */     SBagCfg bagCfg = SBagCfg.get(this.bagId);
/*  61 */     if (bagCfg == null)
/*     */     {
/*  63 */       return false;
/*     */     }
/*  65 */     SItemCfg itemCfg = SItemCfg.get(bagCfg.expendItemId);
/*  66 */     if (itemCfg == null)
/*     */     {
/*  68 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  72 */     String userid = RoleInterface.getUserId(this.roleid);
/*  73 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*     */ 
/*  76 */     if (QingfuInterface.getBalance(userid, true) != this.curYuanbaoNum)
/*     */     {
/*  78 */       return false;
/*     */     }
/*  80 */     RoleItemBag extendBag = ItemManager.getBag(this.roleid, this.bagId, true);
/*  81 */     if (extendBag == null) {
/*  82 */       return false;
/*     */     }
/*  84 */     if (extendBag.getCapacity() >= bagCfg.maxcapacity)
/*     */     {
/*  86 */       return false;
/*     */     }
/*  88 */     int beforecapacity = extendBag.getCapacity();
/*     */     
/*     */ 
/*  91 */     int extendGrid = extendBag.getCapacity() - bagCfg.initcapacity;
/*  92 */     if (extendGrid < 0)
/*     */     {
/*  94 */       extendGrid = 0;
/*     */     }
/*     */     
/*     */ 
/*  98 */     int extendCount = extendGrid / bagCfg.addCount + 1;
/*     */     
/* 100 */     int needItemnum = ItemConfigManager.getExpendNeedItemnum(this.bagId, extendCount);
/* 101 */     if (needItemnum == -1)
/*     */     {
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     RoleItemBag bag = ItemManager.getBag(this.roleid, 340600000, false);
/* 107 */     int itemNumber = bag.getItemNumberBycfgId(bagCfg.expendItemId);
/* 108 */     LogReason logReason = this.bagId == 340600000 ? LogReason.ITEM_EXPEND_BAG_REM : LogReason.ITEM_EXPEND_STORAGE_REM;
/*     */     
/* 110 */     TLogArg logArg = new TLogArg(logReason);
/* 111 */     boolean ret = false;
/* 112 */     if (itemNumber >= needItemnum)
/*     */     {
/* 114 */       ret = ItemInterface.removeItemById(this.roleid, 340600000, bagCfg.expendItemId, needItemnum, logArg);
/*     */ 
/*     */ 
/*     */ 
/*     */     }
/* 119 */     else if (this.isUseYuanbao != 1)
/*     */     {
/* 121 */       ret = false;
/*     */     }
/*     */     else
/*     */     {
/* 125 */       int yuanbaoNum = (needItemnum - itemNumber) * ItemInterface.getItemYuanBaoPrice(itemCfg.id);
/*     */       
/*     */ 
/* 128 */       ret = QingfuInterface.costYuanbao(userid, this.roleid, yuanbaoNum, CostType.COST_BIND_FIRST_ITEM_EXTEND_BAG, logArg) == CostResult.Success;
/* 129 */       if ((ret) && (itemNumber > 0))
/*     */       {
/* 131 */         ret = ItemInterface.removeItemById(this.roleid, 340600000, bagCfg.expendItemId, itemNumber, logArg);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 136 */     if (ret)
/*     */     {
/* 138 */       int addCapacity = Math.min(bagCfg.maxcapacity - extendBag.getCapacity(), bagCfg.addCount);
/* 139 */       ret = extendBag.expandCapacity(addCapacity);
/* 140 */       SExtendBagRes sExtendBagRes = new SExtendBagRes();
/* 141 */       sExtendBagRes.bagid = this.bagId;
/* 142 */       sExtendBagRes.capcity = extendBag.getCapacity();
/* 143 */       OnlineManager.getInstance().send(this.roleid, sExtendBagRes);
/*     */       
/* 145 */       int aftercapacity = extendBag.getCapacity();
/* 146 */       int bagtype = this.bagId == 340600000 ? 1 : 2;
/* 147 */       ItemManager.tlogBagExpend(this.roleid, bagtype, beforecapacity, aftercapacity);
/*     */       
/* 149 */       TriggerEventsManger.getInstance().triggerEvent(new ExtendBagEvent(), new ExtendBagArg(this.roleid, beforecapacity, aftercapacity), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 155 */     return ret;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PExtendBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */