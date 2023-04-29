/*     */ package mzm.gsp.corps.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.corps.SReplaceBadgeBro;
/*     */ import mzm.gsp.corps.confbean.CorpsConsts;
/*     */ import mzm.gsp.corps.confbean.SCorpsBadgeCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CorpsMember;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2corps;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCReplaceBadgeReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int badgeId;
/*     */   
/*     */   public PCReplaceBadgeReq(long roleId, int badgeId)
/*     */   {
/*  31 */     this.roleId = roleId;
/*  32 */     this.badgeId = badgeId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     SCorpsBadgeCfg cfg = CorpsManager.getCorpsBadgeCfg(this.badgeId);
/*  39 */     if (cfg == null)
/*     */     {
/*  41 */       GameServer.logger().error(String.format("[corps]PCReplaceBadgeReq.processImp@ not have this badge cfg!|roleId=%d|badgeId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.badgeId) }));
/*     */       
/*     */ 
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     Lockeys.lock(User.getTable(), Arrays.asList(new String[] { RoleInterface.getUserId(this.roleId) }));
/*     */     
/*  49 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  50 */     CorpsMember xCorpsMember = Role2corps.get(Long.valueOf(this.roleId));
/*  51 */     if (xCorpsMember == null)
/*     */     {
/*  53 */       GameServer.logger().error(String.format("[corps]PCReplaceBadgeReq.processImp@ not own corps!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     long corpsId = xCorpsMember.getCorpsid();
/*  58 */     xbean.Corps xCorps = xtable.Corps.get(Long.valueOf(corpsId));
/*  59 */     if (xCorps == null)
/*     */     {
/*  61 */       GameServer.logger().error(String.format("[corps]PCReplaceBadgeReq.processImp@ IMPOSSIBLE! not have this corps!|roleId=%d|corpsId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(corpsId) }));
/*     */       
/*     */ 
/*     */ 
/*  65 */       return false;
/*     */     }
/*  67 */     if (!canChangeBadge(xCorps, xCorpsMember))
/*     */     {
/*     */ 
/*  70 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  74 */     if (!RoleInterface.cutGold(this.roleId, CorpsConsts.getInstance().REPLACE_BADGE_COST_GOLD_NUM, new TLogArg(LogReason.REPLACE_BADGE_COST)))
/*     */     {
/*     */ 
/*  77 */       GameServer.logger().error(String.format("[corps]PCReplaceBadgeReq.processImp@ cut gold err!|roleId=%d|badgeId=%d|cutNum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.badgeId), Integer.valueOf(CorpsConsts.getInstance().REPLACE_BADGE_COST_GOLD_NUM) }));
/*     */       
/*     */ 
/*  80 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  84 */     xCorps.setCorpsbadge(this.badgeId);
/*     */     
/*     */ 
/*  87 */     CorpsManager.corpsBrocast(xCorps, true, new SReplaceBadgeBro(this.badgeId));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  93 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean canChangeBadge(xbean.Corps xCorps, CorpsMember xCorpsMember)
/*     */   {
/*  99 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1227, true))
/*     */     {
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     if (xCorpsMember.getDuty() != 1)
/*     */     {
/* 106 */       GameServer.logger().error(String.format("[corps]PCReplaceBadgeReq.canChangeBadge@ not captain!|roleId=%d|badgeId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.badgeId) }));
/*     */       
/* 108 */       return false;
/*     */     }
/* 110 */     if (xCorps.getCorpsbadge() == this.badgeId)
/*     */     {
/* 112 */       GameServer.logger().error(String.format("[corps]PCReplaceBadgeReq.canChangeBadge@ same badge!|roleId=%d|badgeId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.badgeId) }));
/*     */       
/* 114 */       return false;
/*     */     }
/* 116 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\PCReplaceBadgeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */