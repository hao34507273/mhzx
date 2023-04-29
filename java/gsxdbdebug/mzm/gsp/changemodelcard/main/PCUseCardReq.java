/*     */ package mzm.gsp.changemodelcard.main;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.changemodelcard.SUseCardFail;
/*     */ import mzm.gsp.changemodelcard.SUseCardSuccess;
/*     */ import mzm.gsp.changemodelcard.confbean.SCardLevelBean;
/*     */ import mzm.gsp.changemodelcard.confbean.SCardLevelCfg;
/*     */ import mzm.gsp.changemodelcard.confbean.SChangeModelCardCfg;
/*     */ import mzm.gsp.mall.main.JifenOperateResult;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChangeModelCardInfo;
/*     */ import xbean.Role2ChangeModelCardInfo;
/*     */ import xtable.Role2changemodelcard;
/*     */ 
/*     */ public class PCUseCardReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long cardId;
/*     */   
/*     */   public PCUseCardReq(long roleId, long cardId)
/*     */   {
/*  30 */     this.roleId = roleId;
/*  31 */     this.cardId = cardId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (!ChangeModelCardManager.isChangeModelCardOpen(this.roleId))
/*     */     {
/*  40 */       String logstr = String.format("[changemodelcard]PCUseCardReq.processImp@function not open|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  42 */       GameServer.logger().info(logstr);
/*  43 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  47 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1972, true))
/*     */     {
/*  49 */       String logstr = String.format("[changemodelcard]PCUseCardReq.processImp@status error|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
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
/*  62 */     Role2ChangeModelCardInfo xRole2CardInfo = Role2changemodelcard.get(Long.valueOf(this.roleId));
/*  63 */     ChangeModelCardInfo xCardInfo = (ChangeModelCardInfo)xRole2CardInfo.getCardid2info().get(Long.valueOf(this.cardId));
/*  64 */     if (null == xCardInfo)
/*     */     {
/*     */ 
/*  67 */       String logstr = String.format("[changemodelcard]PCUseCardReq.processImp@cardId in Role2ChangeModelCardInfo not in xbean.ChangeModelCardInfo!!|roleId=%d,cardId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.cardId) });
/*     */       
/*     */ 
/*  70 */       GameServer.logger().warn(logstr);
/*     */       
/*  72 */       onFail(-2);
/*  73 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  77 */     int cardCfgId = xCardInfo.getCard_cfg_id();
/*  78 */     int cardLevel = xCardInfo.getLevel();
/*  79 */     SChangeModelCardCfg sChangeModelCardCfg = SChangeModelCardCfg.get(cardCfgId);
/*     */     
/*     */ 
/*  82 */     if (RoleInterface.getLevel(this.roleId) < sChangeModelCardCfg.useLevel)
/*     */     {
/*  84 */       onFail(-1);
/*  85 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  89 */     SCardLevelBean sCardLevelBean = (SCardLevelBean)SCardLevelCfg.get(cardCfgId).level2Bean.get(Integer.valueOf(cardLevel));
/*     */     
/*     */ 
/*  92 */     TLogArg logArg = new TLogArg(LogReason.CHANGE_MODEL_CARD_USE_COST);
/*  93 */     JifenOperateResult result = MallInterface.cutJifen(this.roleId, sCardLevelBean.useCostEssence, 9, logArg);
/*     */     
/*  95 */     if (!result.isSuccess())
/*     */     {
/*  97 */       onFail(-3);
/*  98 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 102 */     if (!ChangeModelCardManager.addChangeModelState(this.roleId, xRole2CardInfo, sCardLevelBean, sChangeModelCardCfg))
/*     */     {
/* 104 */       onFail(-4);
/* 105 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 109 */     if (sCardLevelBean.useCount > 0)
/*     */     {
/* 111 */       int newUseCount = xCardInfo.getUse_count() + 1;
/* 112 */       xCardInfo.setUse_count(newUseCount);
/*     */       
/*     */ 
/* 115 */       if (newUseCount >= sCardLevelBean.useCount)
/*     */       {
/* 117 */         boolean removeResult = ChangeModelCardManager.removeChangeModelCard(this.roleId, xRole2CardInfo, Collections.singletonList(Long.valueOf(this.cardId)), ChangeModelCardManager.RemoveCardReason.REACH_MAX_USE_COUNT);
/*     */         
/* 119 */         if (!removeResult)
/*     */         {
/* 121 */           onFail(-2);
/* 122 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 128 */     onSuccess(xRole2CardInfo, xCardInfo);
/*     */     
/* 130 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onSuccess(Role2ChangeModelCardInfo xRole2CardInfo, ChangeModelCardInfo xCardInfo)
/*     */   {
/* 142 */     SUseCardSuccess sUseCardSuccess = new SUseCardSuccess();
/* 143 */     sUseCardSuccess.card_id = this.cardId;
/* 144 */     sUseCardSuccess.use_count = xCardInfo.getUse_count();
/* 145 */     sUseCardSuccess.card_cfg_id = xCardInfo.getCard_cfg_id();
/* 146 */     OnlineManager.getInstance().send(this.roleId, sUseCardSuccess);
/*     */     
/* 148 */     long newEssence = MallInterface.getJifen(this.roleId, 9);
/* 149 */     String logstr = String.format("[changemodelcard]PCUseCardReq.onSuccess@PCUseCardReq success|roleId=%d,cardId=%d,overlayCount=%d,cardInfo=%s,newEssence=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.cardId), Integer.valueOf(xRole2CardInfo.getOverlay_count()), xCardInfo, Long.valueOf(newEssence) });
/*     */     
/*     */ 
/* 152 */     GameServer.logger().info(logstr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFail(int errorCode)
/*     */   {
/* 163 */     SUseCardFail sUseCardFail = new SUseCardFail();
/* 164 */     sUseCardFail.error_code = errorCode;
/* 165 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sUseCardFail);
/*     */     
/*     */ 
/* 168 */     String logstr = String.format("[changemodelcard]PCUseCardReq.onFail@PCUseCardReq failed|errorCode=%d,roleId=%d,cardId=%d", new Object[] { Integer.valueOf(errorCode), Long.valueOf(this.roleId), Long.valueOf(this.cardId) });
/*     */     
/*     */ 
/* 171 */     GameServer.logger().info(logstr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\main\PCUseCardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */