/*     */ package mzm.gsp.wing.main2;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.WingContent;
/*     */ import xbean.WingPlan;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCRpWingContentReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int wingId;
/*     */   private final byte rpType;
/*     */   
/*     */   public PCRpWingContentReq(long roleId, int wingId, byte rpType)
/*     */   {
/*  26 */     this.roleId = roleId;
/*  27 */     this.wingId = wingId;
/*  28 */     this.rpType = rpType;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if (!isValid())
/*     */     {
/*  36 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  40 */     String userid = RoleInterface.getUserId(this.roleId);
/*  41 */     lock(Lockeys.get(User.getTable(), userid));
/*  42 */     RoleWingInfo roleWingInfo = new RoleWingInfo(this.roleId, true);
/*  43 */     WingPlan xWingPlan = roleWingInfo.getWingPlan(1);
/*  44 */     if (xWingPlan == null)
/*     */     {
/*  46 */       GameServer.logger().error(String.format("[wing]PCAddWingRankReq.processImp@ wing plan not open!|roleId=%d|plan=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1) }));
/*     */       
/*     */ 
/*  49 */       return false;
/*     */     }
/*  51 */     RoleWingPlan xPlan = new RoleWingPlan(this.roleId, 1, xWingPlan);
/*     */     
/*  53 */     if (!xPlan.hasWing(this.wingId))
/*     */     {
/*  55 */       GameServer.logger().error(String.format("[wing]PCResetWingReq.processImp@ not own this wing!|roleId=%d|plan=%d|wingId=%d|rpType=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(this.wingId), Byte.valueOf(this.rpType) }));
/*     */       
/*     */ 
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     if (this.rpType == 0)
/*     */     {
/*     */ 
/*  64 */       if (!xPlan.rpByResetPros(this.wingId))
/*     */       {
/*  66 */         GameServer.logger().error(String.format("[wing]PCResetWingReq.processImp@ rpByResetPros error!|roleId=%d|plan=%d|wingId=%d|rpType=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(this.wingId), Byte.valueOf(this.rpType) }));
/*     */         
/*     */ 
/*     */ 
/*  70 */         return false;
/*     */       }
/*     */       
/*     */     }
/*     */     else
/*     */     {
/*  76 */       if (!xPlan.rpByResetSkills(this.wingId))
/*     */       {
/*  78 */         GameServer.logger().error(String.format("[wing]PCResetWingReq.processImp@ rpByResetPros error!|roleId=%d|plan=%d|wingId=%d|rpType=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(this.wingId), Byte.valueOf(this.rpType) }));
/*     */         
/*     */ 
/*     */ 
/*  82 */         return false;
/*     */       }
/*     */       
/*  85 */       if (WingManager.isWingSetTargetSkillSwitchOpenForRole(this.roleId))
/*     */       {
/*  87 */         xPlan.checkTargetSkills(xPlan.getWingData(this.wingId).getSkills());
/*     */       }
/*     */       
/*  90 */       if (WingManager.isWingSkillGuaranteeSwitchOpenForRole(this.roleId))
/*     */       {
/*  92 */         xPlan.clearGuaranteeTimes(this.wingId);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  97 */     WingManager.noticeWingReplace(this.roleId, xPlan.getWingData(this.wingId), this.rpType, roleWingInfo.getEffectWingOccId());
/*     */     
/*  99 */     return true;
/*     */   }
/*     */   
/*     */   boolean isValid()
/*     */   {
/* 104 */     if (RoleInterface.getLevel(this.roleId) < WingInterface.getMinRoleLvForWing())
/*     */     {
/* 106 */       WingManager.sendWingNotice(this.roleId, 8, new String[0]);
/* 107 */       return false;
/*     */     }
/*     */     
/* 110 */     if (!WingManager.isWingSwitchOpenForRole(this.roleId))
/*     */     {
/* 112 */       return false;
/*     */     }
/*     */     
/* 115 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 284, true))
/*     */     {
/* 117 */       return false;
/*     */     }
/*     */     
/* 120 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\PCRpWingContentReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */