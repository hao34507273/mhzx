/*     */ package mzm.gsp.wing.main2;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AllWingPlans;
/*     */ import xbean.TransferOccupationWing;
/*     */ import xbean.WingPlan;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2wingplans;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ public class PCGetOnWingReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int rpWingId;
/*     */   
/*     */   public PCGetOnWingReq(long roleId, int rpWingId)
/*     */   {
/*  26 */     this.roleId = roleId;
/*  27 */     this.rpWingId = rpWingId;
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
/*  45 */       GameServer.logger().error(String.format("[wing]PCGetOffWingReq.processImp@ wing plan not open!|roleId=%d|plan=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1) }));
/*     */       
/*     */ 
/*  48 */       return false;
/*     */     }
/*  50 */     RoleWingPlan xPlan = new RoleWingPlan(this.roleId, 1, xWingPlan);
/*     */     
/*  52 */     if (!xPlan.hasWing(this.rpWingId))
/*     */     {
/*  54 */       GameServer.logger().error(String.format("[wing]PCGetOffWingReq.processImp@ not own wing!|roleId=%d|plan=%d|rpWingId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(this.rpWingId) }));
/*     */       
/*     */ 
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     int orgWingId = xPlan.getOutLookWing();
/*  61 */     int orgColorId = xPlan.getWingColorId(orgWingId);
/*  62 */     xPlan.rpOutLookWing(this.rpWingId);
/*     */     
/*  64 */     getOnTransferOccupationWing();
/*     */     
/*  66 */     WingManager.noticeOutLookChange(this.roleId, orgWingId, orgColorId, this.rpWingId, xPlan.getWingColorId(this.rpWingId), roleWingInfo.getEffectWingOccId());
/*     */     
/*     */ 
/*  69 */     return true;
/*     */   }
/*     */   
/*     */   boolean isValid()
/*     */   {
/*  74 */     if (RoleInterface.getLevel(this.roleId) < WingInterface.getMinRoleLvForWing())
/*     */     {
/*  76 */       WingManager.sendWingNotice(this.roleId, 8, new String[0]);
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     if (!WingManager.isWingChangeViewSwitchOpenForRole(this.roleId))
/*     */     {
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 283, true))
/*     */     {
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void getOnTransferOccupationWing()
/*     */   {
/*  98 */     AllWingPlans xAllWingPlans = Role2wingplans.get(Long.valueOf(this.roleId));
/*  99 */     if (xAllWingPlans == null)
/*     */     {
/* 101 */       return;
/*     */     }
/* 103 */     Map<Integer, TransferOccupationWing> xTransferOccupationWingMap = xAllWingPlans.getTransfer_occupation_wing_map();
/* 104 */     for (Map.Entry<Integer, TransferOccupationWing> entry : xTransferOccupationWingMap.entrySet())
/*     */     {
/* 106 */       if (((Integer)entry.getKey()).intValue() != xAllWingPlans.getEffectwingoccid())
/*     */       {
/*     */ 
/*     */ 
/* 110 */         WingPlan xWingPlan = (WingPlan)((TransferOccupationWing)entry.getValue()).getWings().get(Integer.valueOf(1));
/* 111 */         if (xWingPlan != null)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 116 */           if (xWingPlan.getWings().containsKey(Integer.valueOf(this.rpWingId)))
/*     */           {
/* 118 */             xWingPlan.setCurwing(this.rpWingId);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\PCGetOnWingReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */