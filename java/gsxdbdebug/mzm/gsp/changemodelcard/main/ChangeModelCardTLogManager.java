/*     */ package mzm.gsp.changemodelcard.main;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.changemodelcard.CardItemInfo;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChangeModelCardTLogManager
/*     */ {
/*     */   static void addChangeModelCardAddTlog(long roleId, long cardId, int cardCfgId, int cardLevel)
/*     */   {
/*  24 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  25 */     String userid = RoleInterface.getUserId(roleId);
/*  26 */     int rolelevel = RoleInterface.getLevel(roleId);
/*  27 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Long.valueOf(cardId), Integer.valueOf(cardCfgId), Integer.valueOf(cardLevel) });
/*  28 */     TLogManager.getInstance().addLog(roleId, "ChangeModelCardAdd", logStr);
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
/*     */ 
/*     */   static void addChangeModelCardRemoveTlog(long roleId, long cardId, int cardCfgId, int cardLevel, ChangeModelCardManager.RemoveCardReason reason)
/*     */   {
/*  42 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  43 */     String userid = RoleInterface.getUserId(roleId);
/*  44 */     int rolelevel = RoleInterface.getLevel(roleId);
/*  45 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Long.valueOf(cardId), Integer.valueOf(cardCfgId), Integer.valueOf(cardLevel), Integer.valueOf(reason.value) });
/*     */     
/*  47 */     TLogManager.getInstance().addLog(roleId, "ChangeModelCardRemove", logStr);
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
/*     */ 
/*     */ 
/*     */   static void addChangeModelCardStateAddTlog(long roleId, int cardCfgId, int cardLevel, int newOverlayCount)
/*     */   {
/*  62 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  63 */     String userid = RoleInterface.getUserId(roleId);
/*  64 */     int rolelevel = RoleInterface.getLevel(roleId);
/*  65 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(cardCfgId), Integer.valueOf(cardLevel), Integer.valueOf(newOverlayCount) });
/*     */     
/*  67 */     TLogManager.getInstance().addLog(roleId, "ChangeModelCardStateAdd", logStr);
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
/*     */ 
/*     */ 
/*     */   static void addChangeModelCardStateRemoveTlog(long roleId, int cardCfgId, int cardLevel, ChangeModelCardManager.RemoveCardStateReason reason)
/*     */   {
/*  82 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  83 */     String userid = RoleInterface.getUserId(roleId);
/*  84 */     int rolelevel = RoleInterface.getLevel(roleId);
/*  85 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(cardCfgId), Integer.valueOf(cardLevel), Integer.valueOf(reason.value) });
/*     */     
/*  87 */     TLogManager.getInstance().addLog(roleId, "ChangeModelCardStateRemove", logStr);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addChangeModelCardUpgradeByCardTlog(long roleId, long cardId, int cardCfgId, int newLevel, int newExp, int addExp, long consumeCardId)
/*     */   {
/* 104 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 105 */     String userid = RoleInterface.getUserId(roleId);
/* 106 */     int rolelevel = RoleInterface.getLevel(roleId);
/* 107 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Long.valueOf(cardId), Integer.valueOf(cardCfgId), Integer.valueOf(newLevel), Integer.valueOf(newExp), Integer.valueOf(addExp), Long.valueOf(consumeCardId), Integer.valueOf(0), Integer.valueOf(0) });
/*     */     
/* 109 */     TLogManager.getInstance().addLog(roleId, "ChangeModelCardUpgrade", logStr);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addChangeModelCardUpgradeByItemTlog(long roleId, long cardId, int cardCfgId, int newLevel, int newExp, int addExp, int consumeItemCfgId, int consumeItemCount)
/*     */   {
/* 126 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 127 */     String userid = RoleInterface.getUserId(roleId);
/* 128 */     int rolelevel = RoleInterface.getLevel(roleId);
/* 129 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Long.valueOf(cardId), Integer.valueOf(cardCfgId), Integer.valueOf(newLevel), Integer.valueOf(newExp), Integer.valueOf(addExp), Integer.valueOf(0), Integer.valueOf(consumeItemCfgId), Integer.valueOf(consumeItemCount) });
/*     */     
/* 131 */     TLogManager.getInstance().addLog(roleId, "ChangeModelCardUpgrade", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addChangeModelCardDecomposeTlog(long roleId, long newScore, long addScore)
/*     */   {
/* 142 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 143 */     String userid = RoleInterface.getUserId(roleId);
/* 144 */     int rolelevel = RoleInterface.getLevel(roleId);
/* 145 */     String logStr = String.format("%s|%s|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Long.valueOf(newScore), Long.valueOf(addScore) });
/* 146 */     TLogManager.getInstance().addLog(roleId, "ChangeModelCardDecompose", logStr);
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
/*     */ 
/*     */   static void addChangeModelCardLotteryTlog(long roleId, int lotteryCount, long newScore, Collection<CardItemInfo> cardItemInfos)
/*     */   {
/* 160 */     StringBuilder builder = new StringBuilder();
/* 161 */     for (CardItemInfo itemInfo : cardItemInfos)
/*     */     {
/* 163 */       builder.append(itemInfo.item_cfg_id);
/* 164 */       builder.append("_");
/* 165 */       builder.append(itemInfo.count);
/* 166 */       builder.append(",");
/*     */     }
/* 168 */     builder.deleteCharAt(builder.length() - 1);
/* 169 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 170 */     String userid = RoleInterface.getUserId(roleId);
/* 171 */     int rolelevel = RoleInterface.getLevel(roleId);
/* 172 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%s", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(lotteryCount), Long.valueOf(newScore), builder.toString() });
/*     */     
/* 174 */     TLogManager.getInstance().addLog(roleId, "ChangeModelCardLottery", logStr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\main\ChangeModelCardTLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */