/*     */ package mzm.gsp.changemodelcard.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.changemodelcard.SCardDecomposeFail;
/*     */ import mzm.gsp.changemodelcard.SCardDecomposeSuccess;
/*     */ import mzm.gsp.changemodelcard.confbean.SCardLevelBean;
/*     */ import mzm.gsp.mall.main.JifenOperateResult;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChangeModelCardInfo;
/*     */ import xbean.Role2ChangeModelCardInfo;
/*     */ 
/*     */ public class PCCardDecomposeReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final List<Long> cardIds;
/*     */   
/*     */   public PCCardDecomposeReq(long roleId, List<Long> cardIds)
/*     */   {
/*  27 */     this.roleId = roleId;
/*  28 */     this.cardIds = cardIds;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     if (!ChangeModelCardManager.isChangeModelCardOpen(this.roleId))
/*     */     {
/*  37 */       String logstr = String.format("[changemodelcard]PCCardDecomposeReq.processImp@function not open|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  39 */       GameServer.logger().info(logstr);
/*  40 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  44 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1976, true))
/*     */     {
/*  46 */       String logstr = String.format("[changemodelcard]PCCardDecomposeReq.processImp@status error|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  48 */       GameServer.logger().info(logstr);
/*  49 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  53 */     if (!ChangeModelCardManager.checkRoleLevel(this.roleId))
/*     */     {
/*  55 */       onFail(-1);
/*  56 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  60 */     Role2ChangeModelCardInfo xRole2CardInfo = ChangeModelCardManager.getRole2CardInfo(this.roleId);
/*  61 */     int totalScore = 0;
/*  62 */     for (Iterator i$ = this.cardIds.iterator(); i$.hasNext();) { long cardId = ((Long)i$.next()).longValue();
/*     */       
/*  64 */       ChangeModelCardInfo xCardInfo = (ChangeModelCardInfo)xRole2CardInfo.getCardid2info().get(Long.valueOf(cardId));
/*  65 */       if (null == xCardInfo)
/*     */       {
/*  67 */         onFail(-2);
/*  68 */         return false;
/*     */       }
/*     */       
/*  71 */       int cardCfgId = xCardInfo.getCard_cfg_id();
/*  72 */       int cardLevel = xCardInfo.getLevel();
/*  73 */       SCardLevelBean sCardLevelBean = ChangeModelCardCfgManager.getCardLevelCfg(cardCfgId, cardLevel);
/*     */       
/*  75 */       if (null != sCardLevelBean)
/*     */       {
/*  77 */         totalScore += sCardLevelBean.sellScore;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  82 */     if (!ChangeModelCardManager.removeChangeModelCard(this.roleId, xRole2CardInfo, this.cardIds, ChangeModelCardManager.RemoveCardReason.DECOMPOSE))
/*     */     {
/*  84 */       onFail(-2);
/*  85 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  89 */     TLogArg arg = new TLogArg(LogReason.CHANGE_MODEL_CARD_DECOMPOSE_AWARD);
/*  90 */     JifenOperateResult result = MallInterface.addJifen(this.roleId, totalScore, 10, false, arg);
/*     */     
/*  92 */     if (!result.isSuccess())
/*     */     {
/*  94 */       onFail(-3);
/*  95 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  99 */     onSuccess(result.getChangenum());
/*     */     
/* 101 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onSuccess(long changeNum)
/*     */   {
/* 109 */     long newScore = MallInterface.getJifen(this.roleId, 10);
/*     */     
/* 111 */     SCardDecomposeSuccess protocol = new SCardDecomposeSuccess();
/* 112 */     protocol.get_score = changeNum;
/* 113 */     OnlineManager.getInstance().send(this.roleId, protocol);
/*     */     
/*     */ 
/* 116 */     String logstr = String.format("[changemodelcard]PCCardDecomposeReq.onSuccess@PCCardDecomposeReq success|roleId=%d,cardIds=%s,newScore=%d", new Object[] { Long.valueOf(this.roleId), this.cardIds, Long.valueOf(newScore) });
/*     */     
/*     */ 
/* 119 */     GameServer.logger().info(logstr);
/*     */     
/*     */ 
/* 122 */     ChangeModelCardTLogManager.addChangeModelCardDecomposeTlog(this.roleId, newScore, changeNum);
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
/* 133 */     SCardDecomposeFail sCardDecomposeFail = new SCardDecomposeFail();
/* 134 */     sCardDecomposeFail.error_code = errorCode;
/* 135 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sCardDecomposeFail);
/*     */     
/*     */ 
/* 138 */     String logstr = String.format("[changemodelcard]PCCardDecomposeReq.onFail@PCCardDecomposeReq failed|errorCode=%d,roleId=%d,cardIds=%s", new Object[] { Integer.valueOf(errorCode), Long.valueOf(this.roleId), this.cardIds });
/*     */     
/*     */ 
/* 141 */     GameServer.logger().info(logstr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\main\PCCardDecomposeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */