/*     */ package mzm.gsp.wing.main2;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.wing.confbean.SWingRankCfg;
/*     */ import mzm.gsp.wing.confbean.WingCfgConsts;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AllWingPlans;
/*     */ import xbean.TransferOccupationWing;
/*     */ import xbean.WingPlan;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2wingplans;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POpenWingPlan
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public POpenWingPlan(long roleId)
/*     */   {
/*  25 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     String userid = RoleInterface.getUserId(this.roleId);
/*  33 */     lock(Lockeys.get(User.getTable(), userid));
/*  34 */     RoleWingInfo roleWingInfo = new RoleWingInfo(this.roleId, true);
/*  35 */     WingPlan xWingPlan = roleWingInfo.getWingPlan(1);
/*  36 */     if (xWingPlan != null)
/*     */     {
/*  38 */       GameServer.logger().error(String.format("[wing]POpenWing.processImp@ wing plan has opened!|roleId=%d|plan=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1) }));
/*     */       
/*     */ 
/*  41 */       return false;
/*     */     }
/*  43 */     xWingPlan = roleWingInfo.createNewPlan(1);
/*     */     
/*  45 */     xWingPlan.setCurlv(getFristLv());
/*  46 */     xWingPlan.setCurrank(getFristRank());
/*     */     
/*  48 */     RoleWingPlan xPlan = new RoleWingPlan(this.roleId, 1, xWingPlan);
/*     */     
/*  50 */     SWingRankCfg rankcfg = SWingRankCfg.get(getFristRank());
/*  51 */     if (rankcfg == null)
/*     */     {
/*  53 */       GameServer.logger().error(String.format("[wing]POpenWingPlan.processImp@ next rank cfg is null!|roleId=%d|plan=%d|curRank", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(getFristRank()) }));
/*     */       
/*     */ 
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     int roleLv = RoleInterface.getLevel(this.roleId);
/*  60 */     if (roleLv < rankcfg.upNeedRoleLv)
/*     */     {
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     int wingCfgId = rankcfg.wingInfoId;
/*  66 */     if (!WingManager.getNewWing(xPlan, wingCfgId))
/*     */     {
/*  68 */       GameServer.logger().error(String.format("[wing]POpenWingPlan.processImp@ get new wing error!|roleId=%d|plan=%d|wingId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(wingCfgId) }));
/*     */       
/*     */ 
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     if (!afterOpenPlan(roleWingInfo.getxWingPlans(), xWingPlan, rankcfg))
/*     */     {
/*  76 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  80 */     initTransferOccupationWingInfo(wingCfgId);
/*     */     
/*  82 */     return true;
/*     */   }
/*     */   
/*     */   private boolean afterOpenPlan(AllWingPlans xAllWingPlans, WingPlan xWingPlan, SWingRankCfg rankcfg)
/*     */   {
/*  87 */     WingManager.synRoleWingInfo(this.roleId, xAllWingPlans, 1);
/*     */     
/*  89 */     WingManager.trigGetNewWing(this.roleId, rankcfg.wingInfoId);
/*     */     
/*  91 */     WingTLogManager.tlogOpenWing(this.roleId, xWingPlan, rankcfg.wingInfoId, xAllWingPlans.getEffectwingoccid());
/*     */     
/*  93 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getFristLv()
/*     */   {
/* 103 */     return WingCfgConsts.getInstance().WING_INIT_LEVEL;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getFristRank()
/*     */   {
/* 113 */     return WingCfgConsts.getInstance().WING_INIT_PHASE;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void initTransferOccupationWingInfo(int wingCfgId)
/*     */   {
/* 121 */     AllWingPlans xAllWingPlans = Role2wingplans.get(Long.valueOf(this.roleId));
/* 122 */     if (xAllWingPlans == null)
/*     */     {
/* 124 */       return;
/*     */     }
/*     */     
/* 127 */     Map<Integer, TransferOccupationWing> xTransferOccupationWingMap = xAllWingPlans.getTransfer_occupation_wing_map();
/* 128 */     if (xTransferOccupationWingMap.isEmpty())
/*     */     {
/* 130 */       return;
/*     */     }
/*     */     
/* 133 */     for (Map.Entry<Integer, TransferOccupationWing> entry : xTransferOccupationWingMap.entrySet())
/*     */     {
/* 135 */       if (((Integer)entry.getKey()).intValue() != xAllWingPlans.getEffectwingoccid())
/*     */       {
/*     */ 
/*     */ 
/* 139 */         WingPlan xWingPlan = (WingPlan)((TransferOccupationWing)entry.getValue()).getWings().get(Integer.valueOf(1));
/* 140 */         if (xWingPlan != null)
/*     */         {
/*     */ 
/*     */ 
/* 144 */           xWingPlan.setCurlv(getFristLv());
/* 145 */           xWingPlan.setCurrank(getFristRank());
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\POpenWingPlan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */