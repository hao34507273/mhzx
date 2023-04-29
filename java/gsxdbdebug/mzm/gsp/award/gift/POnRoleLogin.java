/*     */ package mzm.gsp.award.gift;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.SCanGetGiftAward;
/*     */ import mzm.gsp.award.SCanGetGifts;
/*     */ import mzm.gsp.giftaward.confbean.SClientGetGiftCfg;
/*     */ import mzm.gsp.giftaward.confbean.SNewClientBagGiftCfg;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnRoleLogin
/*     */   extends PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  29 */     long roleId = ((Long)this.arg).longValue();
/*  30 */     RoleGiftInfo roleGiftInfo = new RoleGiftInfo(roleId, true);
/*  31 */     if (!roleGiftInfo.hasXAwardInfo())
/*     */     {
/*  33 */       roleGiftInfo.createXAwardInfo();
/*     */     }
/*     */     
/*  36 */     synGetGiftInfo(roleGiftInfo, roleId);
/*  37 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void synGetGiftInfo(RoleGiftInfo roleGiftInfo, long roleId)
/*     */   {
/*  49 */     if (!GiftManager.isNewClientOpen(roleId, false))
/*     */     {
/*  51 */       GameServer.logger().info(String.format("[gift]POnRoleLogin.checkCanGetGift@ module close!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*  52 */       return;
/*     */     }
/*  54 */     SCanGetGifts pro = new SCanGetGifts();
/*  55 */     fillUseTypeData(roleGiftInfo, pro.usetypeinfo);
/*  56 */     if (pro.usetypeinfo.size() > 0)
/*     */     {
/*  58 */       OnlineManager.getInstance().send(roleId, pro);
/*     */     }
/*     */   }
/*     */   
/*     */   private void fillUseTypeData(RoleGiftInfo roleGiftInfo, Map<Integer, Integer> useTypeData)
/*     */   {
/*  64 */     for (SClientGetGiftCfg cfg : SClientGetGiftCfg.getAll().values())
/*     */     {
/*  66 */       int xGlobalValue = GlobalGiftManager.getUseTypeGlobal(cfg.useType);
/*  67 */       if (xGlobalValue < 0)
/*     */       {
/*  69 */         GameServer.logger().error(String.format("[gift]POnRoleLogin.fillUseTypeData@ xGlobal not contains this useType!|roleId=%d|useType", new Object[] { this.arg, Integer.valueOf(cfg.useType) }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/*  75 */       else if (cfg.maxCount > 0)
/*     */       {
/*     */ 
/*     */ 
/*  79 */         int count = roleGiftInfo.getGiftAwardCount(cfg.useType, xGlobalValue);
/*  80 */         if (count < 0)
/*     */         {
/*  82 */           GameServer.logger().error(String.format("[gift]POnRoleLogin.fillUseTypeData@ xGlobal not contains this useType!|roleId=%d|useType", new Object[] { this.arg, Integer.valueOf(cfg.useType) }));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/*  88 */           useTypeData.put(Integer.valueOf(cfg.useType), Integer.valueOf(count));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void oldNotice(long roleId, RoleGiftInfo roleGiftInfo)
/*     */   {
/*  96 */     Set<Integer> cfgXIds = getAwardXCfgIds(RoleGiftInfo.COMPLETE_CLIENT_AWARD);
/*  97 */     if ((cfgXIds == null) || (cfgXIds.size() == 0))
/*     */     {
/*  99 */       return;
/*     */     }
/* 101 */     getAwardNotice(roleId, roleGiftInfo, cfgXIds);
/*     */   }
/*     */   
/*     */   private void getAwardNotice(long roleId, RoleGiftInfo roleGiftInfo, Set<Integer> cfgXIds)
/*     */   {
/* 106 */     if (!GiftManager.isNewClientOpen(roleId, false))
/*     */     {
/* 108 */       GameServer.logger().info(String.format("[gift]POnRoleLogin.getAwardNotice@ module close!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/* 109 */       return;
/*     */     }
/* 111 */     Set<Integer> notGetIds = new HashSet();
/* 112 */     for (Iterator i$ = cfgXIds.iterator(); i$.hasNext();) { int awardXId = ((Integer)i$.next()).intValue();
/*     */       
/* 114 */       int alCount = roleGiftInfo.getAwardXIdNum(RoleGiftInfo.COMPLETE_CLIENT_AWARD, awardXId);
/* 115 */       if (alCount <= 0)
/*     */       {
/*     */ 
/*     */ 
/* 119 */         notGetIds.add(Integer.valueOf(awardXId)); }
/*     */     }
/* 121 */     if (notGetIds.size() > 0)
/*     */     {
/* 123 */       GameServer.logger().info(String.format("[gift]POnRoleLogin.getAwardNotice@ has can get award!|roleId=%d|notGetIds=%s", new Object[] { Long.valueOf(roleId), notGetIds.toString() }));
/*     */       
/*     */ 
/* 126 */       OnlineManager.getInstance().send(roleId, new SCanGetGiftAward(new ArrayList(notGetIds)));
/*     */     }
/*     */   }
/*     */   
/*     */   Set<Integer> getAwardXCfgIds(int type)
/*     */   {
/* 132 */     return SNewClientBagGiftCfg.getAll().keySet();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\gift\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */