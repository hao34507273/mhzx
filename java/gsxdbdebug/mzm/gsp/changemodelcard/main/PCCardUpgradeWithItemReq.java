/*     */ package mzm.gsp.changemodelcard.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.changemodelcard.SCardUpgradeWithItemFail;
/*     */ import mzm.gsp.changemodelcard.SCardUpgradeWithItemSuccess;
/*     */ import mzm.gsp.changemodelcard.confbean.SCardLevelBean;
/*     */ import mzm.gsp.changemodelcard.confbean.SChangeModelCardFragmentCfg;
/*     */ import mzm.gsp.changemodelcard.confbean.SChangeModelCardItemCfg;
/*     */ import mzm.gsp.changemodelcard.event.ChangeModelCardUpgrade;
/*     */ import mzm.gsp.changemodelcard.event.ChangeModelCardUpgradeArg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChangeModelCardInfo;
/*     */ import xbean.Role2ChangeModelCardInfo;
/*     */ 
/*     */ public class PCCardUpgradeWithItemReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long mainCardId;
/*     */   private final int costItemCfgId;
/*     */   private final boolean useAll;
/*     */   
/*     */   public PCCardUpgradeWithItemReq(long roleId, long mainCardId, int costItemCfgId, byte useAll)
/*     */   {
/*  33 */     this.roleId = roleId;
/*  34 */     this.mainCardId = mainCardId;
/*  35 */     this.costItemCfgId = costItemCfgId;
/*  36 */     this.useAll = (useAll > 0);
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  43 */     if (!ChangeModelCardManager.isChangeModelCardOpen(this.roleId))
/*     */     {
/*  45 */       String logstr = String.format("[changemodelcard]PCCardUpgradeWithItemReq.processImp@function not open|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  47 */       GameServer.logger().info(logstr);
/*  48 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  52 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1977, true))
/*     */     {
/*  54 */       String logstr = String.format("[changemodelcard]PCCardUpgradeWithItemReq.processImp@status error|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  56 */       GameServer.logger().info(logstr);
/*  57 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  61 */     if (!ChangeModelCardManager.checkRoleLevel(this.roleId))
/*     */     {
/*  63 */       onFail(-1);
/*  64 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  68 */     Role2ChangeModelCardInfo xRole2CardInfo = ChangeModelCardManager.getRole2CardInfo(this.roleId);
/*  69 */     ChangeModelCardInfo xMainCardInfo = (ChangeModelCardInfo)xRole2CardInfo.getCardid2info().get(Long.valueOf(this.mainCardId));
/*  70 */     if (null == xMainCardInfo)
/*     */     {
/*     */ 
/*  73 */       String logstr = String.format("[changemodelcard]PCCardUpgradeWithItemReq.processImp@cardId in Role2ChangeModelCardInfo not in xbean.ChangeModelCardInfo!!|roleId=%d,cardId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.mainCardId) });
/*     */       
/*     */ 
/*  76 */       GameServer.logger().warn(logstr);
/*     */       
/*  78 */       onFail(-2);
/*  79 */       return false;
/*     */     }
/*  81 */     int oldLevel = xMainCardInfo.getLevel();
/*     */     
/*     */ 
/*     */     SChangeModelCardItemCfg itemCfg;
/*     */     
/*     */     int matchCardCfgId;
/*     */     
/*  88 */     if (null != (itemCfg = SChangeModelCardItemCfg.get(this.costItemCfgId)))
/*     */     {
/*     */ 
/*  91 */       if (itemCfg.cardLevel > oldLevel)
/*     */       {
/*  93 */         onFail(-8);
/*  94 */         return false;
/*     */       }
/*  96 */       int provideExp = itemCfg.provideExp;
/*  97 */       matchCardCfgId = itemCfg.cardCfgId; } else { SChangeModelCardFragmentCfg fragmentCfg;
/*     */       int matchCardCfgId;
/*  99 */       if (null != (fragmentCfg = SChangeModelCardFragmentCfg.get(this.costItemCfgId)))
/*     */       {
/*     */ 
/* 102 */         int provideExp = fragmentCfg.provideExp;
/* 103 */         matchCardCfgId = fragmentCfg.cardCfgId;
/*     */       }
/*     */       else
/*     */       {
/* 107 */         onFail(-5);
/* 108 */         return false;
/*     */       } }
/*     */     int matchCardCfgId;
/*     */     int provideExp;
/* 112 */     if (matchCardCfgId != xMainCardInfo.getCard_cfg_id())
/*     */     {
/* 114 */       onFail(-6);
/* 115 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 119 */     int itemCount = ItemInterface.getItemNumberById(this.roleId, 340600007, this.costItemCfgId, true);
/*     */     
/* 121 */     if (itemCount == 0)
/*     */     {
/* 123 */       onFail(-4);
/* 124 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 128 */     SCardLevelBean sCardLevelBean = ChangeModelCardCfgManager.getCardLevelCfg(xMainCardInfo.getCard_cfg_id(), xMainCardInfo.getLevel());
/*     */     
/* 130 */     if (sCardLevelBean.upgradeExp == 0)
/*     */     {
/* 132 */       onFail(-3);
/* 133 */       return false;
/*     */     }
/*     */     
/*     */     int costItemCount;
/*     */     int costItemCount;
/* 138 */     if (this.useAll)
/*     */     {
/* 140 */       int remainItemCount = itemCount;
/* 141 */       SCardLevelBean startCardLevelBean = sCardLevelBean;
/*     */       
/*     */       do
/*     */       {
/* 145 */         int upgradeNeedCount = (int)Math.ceil((startCardLevelBean.upgradeExp - xMainCardInfo.getExp()) / provideExp);
/*     */         
/* 147 */         int cutCount = Math.min(remainItemCount, upgradeNeedCount);
/* 148 */         ChangeModelCardManager.addCardExp(xMainCardInfo, cutCount * provideExp);
/* 149 */         startCardLevelBean = ChangeModelCardCfgManager.getCardLevelCfg(xMainCardInfo.getCard_cfg_id(), xMainCardInfo.getLevel());
/*     */         
/* 151 */         remainItemCount -= cutCount;
/*     */       }
/* 153 */       while ((null != startCardLevelBean) && (startCardLevelBean.upgradeExp > 0) && (remainItemCount > 0));
/* 154 */       costItemCount = itemCount - remainItemCount;
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 159 */       ChangeModelCardManager.addCardExp(xMainCardInfo, provideExp);
/* 160 */       costItemCount = 1;
/*     */     }
/*     */     
/*     */ 
/* 164 */     TLogArg logArg = new TLogArg(LogReason.CHANGE_MODEL_CARD_UPGRADE_COST);
/* 165 */     ItemInterface.removeItemById(this.roleId, 340600007, this.costItemCfgId, costItemCount, logArg);
/*     */     
/*     */ 
/* 168 */     onSuccess(xMainCardInfo, costItemCount, costItemCount * provideExp, oldLevel);
/*     */     
/* 170 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onSuccess(ChangeModelCardInfo xMainCardInfo, int costCount, int addExp, int oldLevel)
/*     */   {
/* 180 */     int newLevel = xMainCardInfo.getLevel();
/*     */     
/* 182 */     SCardUpgradeWithItemSuccess protocol = new SCardUpgradeWithItemSuccess();
/* 183 */     protocol.main_card_id = this.mainCardId;
/* 184 */     protocol.now_level = newLevel;
/* 185 */     protocol.now_exp = xMainCardInfo.getExp();
/* 186 */     protocol.add_exp = addExp;
/* 187 */     OnlineManager.getInstance().send(this.roleId, protocol);
/*     */     
/*     */ 
/* 190 */     String logstr = String.format("[changemodelcard]PCCardUpgradeWithItemReq.onSuccess@PCCardUpgradeWithCardReq success|roleId=%d,mainCardId=%d,cardInfo=%s,itemCfgId=%d,costCount=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.mainCardId), xMainCardInfo, Integer.valueOf(this.costItemCfgId), Integer.valueOf(costCount) });
/*     */     
/*     */ 
/* 193 */     GameServer.logger().info(logstr);
/*     */     
/*     */ 
/* 196 */     int cardCfgId = xMainCardInfo.getCard_cfg_id();
/* 197 */     ChangeModelCardTLogManager.addChangeModelCardUpgradeByItemTlog(this.roleId, this.mainCardId, cardCfgId, protocol.now_level, protocol.now_exp, addExp, this.costItemCfgId, costCount);
/*     */     
/*     */ 
/*     */ 
/* 201 */     if (newLevel != oldLevel)
/*     */     {
/* 203 */       ChangeModelCardUpgradeArg arg = new ChangeModelCardUpgradeArg(this.roleId, cardCfgId, oldLevel, newLevel);
/* 204 */       TriggerEventsManger.getInstance().triggerEvent(new ChangeModelCardUpgrade(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFail(int errorCode)
/*     */   {
/* 217 */     SCardUpgradeWithItemFail proto = new SCardUpgradeWithItemFail();
/* 218 */     proto.error_code = errorCode;
/* 219 */     OnlineManager.getInstance().sendAtOnce(this.roleId, proto);
/*     */     
/*     */ 
/* 222 */     String logstr = String.format("[changemodelcard]PCCardUpgradeWithItemReq.onFail@PCCardUpgradeWithItemReq failed|errorCode=%d,roleId=%d,mainCardId=%d", new Object[] { Integer.valueOf(errorCode), Long.valueOf(this.roleId), Long.valueOf(this.mainCardId) });
/*     */     
/*     */ 
/* 225 */     GameServer.logger().info(logstr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\main\PCCardUpgradeWithItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */