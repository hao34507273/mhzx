/*     */ package mzm.gsp.wing.main2;
/*     */ 
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.wing.confbean.WingCfgConsts;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.WingPlan;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PAddWing
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int wingId;
/*     */   
/*     */   public PAddWing(long roleId, int wingId)
/*     */   {
/*  26 */     this.roleId = roleId;
/*  27 */     this.wingId = wingId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     if (!isValid())
/*     */     {
/*  35 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  39 */     String userid = RoleInterface.getUserId(this.roleId);
/*  40 */     lock(Lockeys.get(User.getTable(), userid));
/*  41 */     RoleWingInfo roleWingInfo = new RoleWingInfo(this.roleId, true);
/*  42 */     WingPlan xWingPlan = roleWingInfo.getWingPlan(1);
/*  43 */     if (xWingPlan == null)
/*     */     {
/*  45 */       GameServer.logger().error(String.format("[wing]PAddWing.processImp@ wing plan not open!|roleId=%d|plan=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1) }));
/*     */       
/*     */ 
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     RoleWingPlan xPlan = new RoleWingPlan(this.roleId, 1, xWingPlan);
/*     */     
/*  53 */     boolean fristAdd = xPlan.getOwnWings().size() == 0;
/*     */     
/*  55 */     if (fristAdd)
/*     */     {
/*  57 */       xWingPlan.setCurlv(getFristLv());
/*  58 */       xWingPlan.setCurrank(getFristRank());
/*     */     }
/*     */     
/*  61 */     if (!WingManager.getNewWing(xPlan, this.wingId))
/*     */     {
/*  63 */       GameServer.logger().error(String.format("[wing]PAddWing.processImp@ get new wing error!|roleId=%d|plan=%d|wingId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(this.wingId) }));
/*     */       
/*     */ 
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     if (fristAdd)
/*     */     {
/*  71 */       WingManager.synRoleWingInfo(this.roleId, roleWingInfo.getxWingPlans(), 1);
/*     */     }
/*     */     else
/*     */     {
/*  75 */       WingManager.noticeClientGetNewWing(this.roleId, xPlan.getWingData(this.wingId));
/*     */     }
/*  77 */     WingManager.trigGetNewWing(this.roleId, this.wingId);
/*     */     
/*  79 */     WingTLogManager.tlogGetNewWing(this.roleId, xWingPlan, this.wingId, 2, roleWingInfo.getEffectWingOccId());
/*     */     
/*  81 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getFristLv()
/*     */   {
/*  91 */     return WingCfgConsts.getInstance().WING_INIT_LEVEL;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getFristRank()
/*     */   {
/* 101 */     return WingCfgConsts.getInstance().WING_INIT_PHASE;
/*     */   }
/*     */   
/*     */   boolean isValid()
/*     */   {
/* 106 */     if (RoleInterface.getLevel(this.roleId) < WingInterface.getMinRoleLvForWing())
/*     */     {
/* 108 */       WingManager.sendWingNotice(this.roleId, 8, new String[0]);
/* 109 */       return false;
/*     */     }
/*     */     
/* 112 */     if (!WingManager.isWingSwitchOpenForRole(this.roleId))
/*     */     {
/* 114 */       return false;
/*     */     }
/*     */     
/* 117 */     if (!WingCfgManager.canActiveGain(this.wingId))
/*     */     {
/* 119 */       GameServer.logger().error(String.format("[wing]PAddWing.isValid@ this wing can not be gained forwardly!|roleId=%d|plan=%d|wingId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(this.wingId) }));
/*     */       
/*     */ 
/* 122 */       return false;
/*     */     }
/*     */     
/* 125 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\PAddWing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */