/*     */ package mzm.gsp.changemodelcard.main;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.changemodelcard.SCardUpgradeWithCardFail;
/*     */ import mzm.gsp.changemodelcard.SCardUpgradeWithCardSuccess;
/*     */ import mzm.gsp.changemodelcard.confbean.SCardLevelBean;
/*     */ import mzm.gsp.changemodelcard.event.ChangeModelCardUpgrade;
/*     */ import mzm.gsp.changemodelcard.event.ChangeModelCardUpgradeArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChangeModelCardInfo;
/*     */ import xbean.Role2ChangeModelCardInfo;
/*     */ 
/*     */ public class PCCardUpgradeWithCardReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long mainCardId;
/*     */   private final long costCardId;
/*     */   
/*     */   public PCCardUpgradeWithCardReq(long roleId, long mainCardId, long costCardId)
/*     */   {
/*  28 */     this.roleId = roleId;
/*  29 */     this.mainCardId = mainCardId;
/*  30 */     this.costCardId = costCardId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (!ChangeModelCardManager.isChangeModelCardOpen(this.roleId))
/*     */     {
/*  39 */       String logstr = String.format("[changemodelcard]PCCardUpgradeWithCardReq.processImp@function not open|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  41 */       GameServer.logger().info(logstr);
/*  42 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  46 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1977, true))
/*     */     {
/*  48 */       String logstr = String.format("[changemodelcard]PCCardUpgradeWithCardReq.processImp@status error|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  50 */       GameServer.logger().info(logstr);
/*  51 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  55 */     if (!ChangeModelCardManager.checkRoleLevel(this.roleId))
/*     */     {
/*  57 */       onFail(-1);
/*  58 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  62 */     Role2ChangeModelCardInfo xRole2CardInfo = ChangeModelCardManager.getRole2CardInfo(this.roleId);
/*  63 */     Map<Long, ChangeModelCardInfo> cardId2InfoMap = xRole2CardInfo.getCardid2info();
/*  64 */     ChangeModelCardInfo xMainCardInfo = (ChangeModelCardInfo)cardId2InfoMap.get(Long.valueOf(this.mainCardId));
/*  65 */     if (null == xMainCardInfo)
/*     */     {
/*  67 */       onFail(-2);
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     ChangeModelCardInfo xCostCardInfo = (ChangeModelCardInfo)cardId2InfoMap.get(Long.valueOf(this.costCardId));
/*  72 */     if (null == xCostCardInfo)
/*     */     {
/*  74 */       onFail(-4);
/*  75 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  79 */     if (xMainCardInfo.getCard_cfg_id() != xCostCardInfo.getCard_cfg_id())
/*     */     {
/*  81 */       onFail(-6);
/*  82 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  86 */     int oldLevel = xMainCardInfo.getLevel();
/*  87 */     if (oldLevel < xCostCardInfo.getLevel())
/*     */     {
/*  89 */       onFail(-5);
/*  90 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  94 */     SCardLevelBean sCostCardLevelCfg = ChangeModelCardCfgManager.getCardLevelCfg(xCostCardInfo.getCard_cfg_id(), xCostCardInfo.getLevel());
/*     */     
/*  96 */     if (sCostCardLevelCfg.provideExp <= 0)
/*     */     {
/*  98 */       onFail(-7);
/*  99 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 103 */     if (!ChangeModelCardManager.addCardExp(xMainCardInfo, sCostCardLevelCfg.provideExp))
/*     */     {
/* 105 */       onFail(-3);
/* 106 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 110 */     ChangeModelCardManager.removeChangeModelCard(this.roleId, xRole2CardInfo, Collections.singleton(Long.valueOf(this.costCardId)), ChangeModelCardManager.RemoveCardReason.LEVEL_UP);
/*     */     
/*     */ 
/*     */ 
/* 114 */     onSuccess(xMainCardInfo, sCostCardLevelCfg.provideExp, oldLevel);
/*     */     
/* 116 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onSuccess(ChangeModelCardInfo xMainCardInfo, int addExp, int oldLevel)
/*     */   {
/* 126 */     int newLevel = xMainCardInfo.getLevel();
/*     */     
/* 128 */     SCardUpgradeWithCardSuccess protocol = new SCardUpgradeWithCardSuccess();
/* 129 */     protocol.main_card_id = this.mainCardId;
/* 130 */     protocol.now_level = newLevel;
/* 131 */     protocol.now_exp = xMainCardInfo.getExp();
/* 132 */     protocol.add_exp = addExp;
/* 133 */     OnlineManager.getInstance().send(this.roleId, protocol);
/*     */     
/*     */ 
/* 136 */     String logstr = String.format("[changemodelcard]PCCardUpgradeWithCardReq.onSuccess@PCCardUpgradeWithCardReq success|roleId=%d,mainCardId=%d,costCardId=%d,cardInfo=%s", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.mainCardId), Long.valueOf(this.costCardId), xMainCardInfo });
/*     */     
/*     */ 
/* 139 */     GameServer.logger().info(logstr);
/*     */     
/*     */ 
/* 142 */     int cardCfgId = xMainCardInfo.getCard_cfg_id();
/* 143 */     ChangeModelCardTLogManager.addChangeModelCardUpgradeByCardTlog(this.roleId, this.mainCardId, cardCfgId, protocol.now_level, protocol.now_exp, addExp, this.costCardId);
/*     */     
/*     */ 
/*     */ 
/* 147 */     if (newLevel != oldLevel)
/*     */     {
/* 149 */       ChangeModelCardUpgradeArg arg = new ChangeModelCardUpgradeArg(this.roleId, cardCfgId, oldLevel, newLevel);
/* 150 */       TriggerEventsManger.getInstance().triggerEvent(new ChangeModelCardUpgrade(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
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
/* 163 */     SCardUpgradeWithCardFail proto = new SCardUpgradeWithCardFail();
/* 164 */     proto.error_code = errorCode;
/* 165 */     OnlineManager.getInstance().sendAtOnce(this.roleId, proto);
/*     */     
/*     */ 
/* 168 */     String logstr = String.format("[changemodelcard]PCCardUpgradeWithCardReq.onFail@PCCardUpgradeWithCardReq failed|errorCode=%d,roleId=%d,mainCardId=%d,costCardId=%d", new Object[] { Integer.valueOf(errorCode), Long.valueOf(this.roleId), Long.valueOf(this.mainCardId), Long.valueOf(this.costCardId) });
/*     */     
/*     */ 
/* 171 */     GameServer.logger().info(logstr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\main\PCCardUpgradeWithCardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */