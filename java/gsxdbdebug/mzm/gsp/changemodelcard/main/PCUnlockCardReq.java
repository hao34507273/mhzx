/*     */ package mzm.gsp.changemodelcard.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.changemodelcard.SUnlockCardFail;
/*     */ import mzm.gsp.changemodelcard.SUnlockCardSuccess;
/*     */ import mzm.gsp.changemodelcard.confbean.SChangeModelCardItemCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChangeModelCardInfo;
/*     */ import xbean.Role2ChangeModelCardInfo;
/*     */ 
/*     */ public class PCUnlockCardReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long itemUuid;
/*     */   
/*     */   public PCUnlockCardReq(long roleId, long itemUuid)
/*     */   {
/*  24 */     this.roleId = roleId;
/*  25 */     this.itemUuid = itemUuid;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     if (!ChangeModelCardManager.isChangeModelCardOpen(this.roleId))
/*     */     {
/*  34 */       String logstr = String.format("[changemodelcard]PCUnlockCardReq.processImp@function not open|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  36 */       GameServer.logger().info(logstr);
/*  37 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  41 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1971, true))
/*     */     {
/*  43 */       String logstr = String.format("[changemodelcard]PCUnlockCardReq.processImp@status error|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  45 */       GameServer.logger().info(logstr);
/*  46 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  50 */     if (!ChangeModelCardManager.checkRoleLevel(this.roleId))
/*     */     {
/*  52 */       onFail(-1);
/*  53 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  57 */     BasicItem item = ItemInterface.getItemByUuid(this.roleId, 340600007, this.itemUuid);
/*  58 */     if (null == item)
/*     */     {
/*  60 */       onFail(-2);
/*  61 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  65 */     int itemCfgId = item.getCfgId();
/*  66 */     SChangeModelCardItemCfg sChangeModelCardItemCfg = SChangeModelCardItemCfg.get(itemCfgId);
/*  67 */     if (null == sChangeModelCardItemCfg)
/*     */     {
/*  69 */       onFail(-3);
/*  70 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  74 */     TLogArg tLogArg = new TLogArg(LogReason.CHANGE_MODEL_CARD_UNLOCK_COST);
/*  75 */     boolean removeItemRes = ItemInterface.removeItemByUuid(this.roleId, 340600007, this.itemUuid, 1, tLogArg);
/*     */     
/*  77 */     if (!removeItemRes)
/*     */     {
/*  79 */       onFail(-4);
/*  80 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  84 */     int cardCfgId = sChangeModelCardItemCfg.cardCfgId;
/*  85 */     int cardLevel = sChangeModelCardItemCfg.cardLevel;
/*  86 */     Role2ChangeModelCardInfo xRole2ChangeModelCardInfo = ChangeModelCardManager.getRole2CardInfo(this.roleId);
/*     */     
/*  88 */     long newCardId = ChangeModelCardManager.addChangeModelCard(this.roleId, xRole2ChangeModelCardInfo, cardCfgId, cardLevel);
/*     */     
/*     */ 
/*     */ 
/*  92 */     onSuccess(xRole2ChangeModelCardInfo, newCardId);
/*     */     
/*  94 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onSuccess(Role2ChangeModelCardInfo xRole2ChangeModelCardInfo, long newCardId)
/*     */   {
/* 102 */     ChangeModelCardInfo xCardInfo = (ChangeModelCardInfo)xRole2ChangeModelCardInfo.getCardid2info().get(Long.valueOf(newCardId));
/*     */     
/* 104 */     SUnlockCardSuccess protocol = new SUnlockCardSuccess();
/* 105 */     protocol.card_id = newCardId;
/* 106 */     protocol.card_info = ChangeModelCardManager.packageCardInfoBean(xCardInfo);
/* 107 */     OnlineManager.getInstance().send(this.roleId, protocol);
/*     */     
/*     */ 
/* 110 */     String logstr = String.format("[changemodelcard]PCUnlockCardReq.onSuccess@PCUnlockCardReq success|roleId=%d,cardId=%d,cardCfgId=%d,cardLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(newCardId), Integer.valueOf(xCardInfo.getCard_cfg_id()), Integer.valueOf(xCardInfo.getLevel()) });
/*     */     
/*     */ 
/* 113 */     GameServer.logger().info(logstr);
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
/* 124 */     SUnlockCardFail sUnlockCardFail = new SUnlockCardFail();
/* 125 */     sUnlockCardFail.error_code = errorCode;
/* 126 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sUnlockCardFail);
/*     */     
/*     */ 
/* 129 */     String logstr = String.format("[changemodelcard]PCUnlockCardReq.onFail@PCUnlockCardReq failed|errorCode=%d,roleId=%d,itemUuid=%d", new Object[] { Integer.valueOf(errorCode), Long.valueOf(this.roleId), Long.valueOf(this.itemUuid) });
/*     */     
/*     */ 
/* 132 */     GameServer.logger().info(logstr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\main\PCUnlockCardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */