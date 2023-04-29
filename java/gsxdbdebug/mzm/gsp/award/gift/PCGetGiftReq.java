/*     */ package mzm.gsp.award.gift;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.SGetGiftRep;
/*     */ import mzm.gsp.giftaward.confbean.SClientGetGiftCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
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
/*     */ public class PCGetGiftReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int useType;
/*     */   
/*     */   public PCGetGiftReq(long roleId, int useType)
/*     */   {
/*  30 */     this.roleId = roleId;
/*  31 */     this.useType = useType;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (!GiftManager.isNewClientOpen(this.roleId, false))
/*     */     {
/*  39 */       GameServer.logger().info(String.format("[gift]PCGetGiftAwardReq.doAward@ module close!|roleId=%d|useType=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.useType) }));
/*     */       
/*  41 */       return false;
/*     */     }
/*  43 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 231, true))
/*     */     {
/*  45 */       return false;
/*     */     }
/*  47 */     SClientGetGiftCfg cfg = SClientGetGiftCfg.get(this.useType);
/*  48 */     if (cfg == null)
/*     */     {
/*  50 */       GameServer.logger().error(String.format("[gift]PCGetGiftReq.processImp@ illegal useType!|roleId=%d|useType=%d|", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.useType) }));
/*     */       
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     if ((ActivityInterface.getActivityCfg(cfg.activityId) != null) && (!OpenInterface.getOpenStatus(cfg.switchId)))
/*     */     {
/*  57 */       GameServer.logger().error(String.format("[gift]PCGetGiftReq.processImp@ activity closed|roleId=%d|useType=%d|activityid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.useType), Integer.valueOf(cfg.activityId) }));
/*     */       
/*     */ 
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     String userId = RoleInterface.getUserId(this.roleId);
/*  64 */     lock(Lockeys.get(User.getTable(), userId));
/*  65 */     RoleGiftInfo roleGiftInfo = new RoleGiftInfo(this.roleId, true);
/*     */     
/*  67 */     int global = GlobalGiftManager.getUseTypeGlobal(this.useType);
/*  68 */     if (global < 0)
/*     */     {
/*  70 */       GameServer.logger().error(String.format("[gift]PCGetGiftReq.processImp@ db not contains this useType!|roleId=%d|useType=%d|", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.useType) }));
/*     */       
/*     */ 
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     if (!isActivityValid(cfg, userId))
/*     */     {
/*     */ 
/*  79 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  83 */     int lastCount = roleGiftInfo.addGiftCount(this.useType, global);
/*  84 */     switch (lastCount)
/*     */     {
/*     */ 
/*     */     case -4: 
/*  88 */       return false;
/*     */     case -3: 
/*  90 */       return false;
/*     */     }
/*     */     
/*     */     
/*     */ 
/*  95 */     if (!doAward(cfg, userId))
/*     */     {
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     OnlineManager.getInstance().send(this.roleId, new SGetGiftRep(this.useType, lastCount));
/*     */     
/* 102 */     if (!addActivityCount(cfg.activityId, userId))
/*     */     {
/* 104 */       GameServer.logger().error(String.format("[gift]PCGetGiftReq.processImp@ add activity count err!|roleId=%d|useType=%d|activityId", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.useType), Integer.valueOf(cfg.activityId) }));
/*     */       
/*     */ 
/* 107 */       return false;
/*     */     }
/* 109 */     return true;
/*     */   }
/*     */   
/*     */   private boolean addActivityCount(int activityId, String userId)
/*     */   {
/* 114 */     if (activityId <= 0)
/*     */     {
/*     */ 
/* 117 */       return true;
/*     */     }
/*     */     
/* 120 */     return ActivityInterface.addActivityCount(userId, this.roleId, activityId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean isActivityValid(SClientGetGiftCfg cfg, String userId)
/*     */   {
/* 132 */     if (cfg.activityId <= 0)
/*     */     {
/*     */ 
/* 135 */       return true;
/*     */     }
/* 137 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, cfg.activityId);
/* 138 */     if (res.isCanJoin())
/*     */     {
/* 140 */       return true;
/*     */     }
/* 142 */     GameServer.logger().error(String.format("[gift]PCGetGiftReq.isActivityValid@ can not join activity!|roleId=%d|activityId=%d|useType=%d|resCode=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(cfg.activityId), Integer.valueOf(this.useType), Integer.valueOf(res.getReasonValue()) }));
/*     */     
/*     */ 
/*     */ 
/* 146 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean doAward(SClientGetGiftCfg cfg, String userId)
/*     */   {
/* 158 */     GiftAwardType giftAwardType = getGiftAwardType(cfg.awardType, userId, this.roleId, this.useType);
/* 159 */     if (giftAwardType == null)
/*     */     {
/* 161 */       GameServer.logger().error(String.format("[gift]PCGetGiftReq.processImp@ illegal awardType!|roleId=%d|useType=%d|awardType=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.useType), Integer.valueOf(cfg.awardType) }));
/*     */       
/*     */ 
/* 164 */       return false;
/*     */     }
/* 166 */     boolean getAward = giftAwardType.giveAward();
/* 167 */     if (!getAward)
/*     */     {
/* 169 */       GameServer.logger().error(String.format("[gift]PCGetGiftReq.processImp@ give award err!|roleId=%d|useType=%d|awardType=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.useType), Integer.valueOf(cfg.awardType) }));
/*     */       
/*     */ 
/* 172 */       return false;
/*     */     }
/* 174 */     return true;
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
/*     */   GiftAwardType getGiftAwardType(int awardType, String userId, long roleId, int usetType)
/*     */   {
/* 187 */     switch (awardType)
/*     */     {
/*     */     case 1: 
/* 190 */       return new AwardFix(userId, roleId, usetType);
/*     */     case 2: 
/* 192 */       return new AwardMail(userId, roleId, usetType);
/*     */     case 3: 
/* 194 */       return new AwardItem(userId, roleId, usetType);
/*     */     }
/*     */     
/* 197 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\gift\PCGetGiftReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */