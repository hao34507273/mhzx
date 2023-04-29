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
/*     */ public class PCGetOffWingReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PCGetOffWingReq(long roleId)
/*     */   {
/*  25 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  31 */     if (!isValid())
/*     */     {
/*  33 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  37 */     String userid = RoleInterface.getUserId(this.roleId);
/*  38 */     lock(Lockeys.get(User.getTable(), userid));
/*  39 */     RoleWingInfo roleWingInfo = new RoleWingInfo(this.roleId, true);
/*  40 */     WingPlan xWingPlan = roleWingInfo.getWingPlan(1);
/*  41 */     if (xWingPlan == null)
/*     */     {
/*  43 */       GameServer.logger().error(String.format("[wing]PCGetOffWingReq.processImp@ wing plan not open!|roleId=%d|plan=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1) }));
/*     */       
/*     */ 
/*  46 */       return false;
/*     */     }
/*  48 */     RoleWingPlan xPlan = new RoleWingPlan(this.roleId, 1, xWingPlan);
/*     */     
/*  50 */     int oldWingCfgId = xPlan.getOutLookWing();
/*  51 */     int oldWingColorId = xPlan.getWingColorId(oldWingCfgId);
/*  52 */     xPlan.rpOutLookWing(0);
/*     */     
/*  54 */     getOffTransferOccupationWing();
/*     */     
/*  56 */     WingManager.noticeOutLookChange(this.roleId, oldWingCfgId, oldWingColorId, 0, 0, roleWingInfo.getEffectWingOccId());
/*  57 */     return true;
/*     */   }
/*     */   
/*     */   boolean isValid()
/*     */   {
/*  62 */     if (RoleInterface.getLevel(this.roleId) < WingInterface.getMinRoleLvForWing())
/*     */     {
/*  64 */       WingManager.sendWingNotice(this.roleId, 8, new String[0]);
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     if (!WingManager.isWingChangeViewSwitchOpenForRole(this.roleId))
/*     */     {
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 282, true))
/*     */     {
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void getOffTransferOccupationWing()
/*     */   {
/*  86 */     AllWingPlans xAllWingPlans = Role2wingplans.get(Long.valueOf(this.roleId));
/*  87 */     if (xAllWingPlans == null)
/*     */     {
/*  89 */       return;
/*     */     }
/*  91 */     Map<Integer, TransferOccupationWing> xTransferOccupationWingMap = xAllWingPlans.getTransfer_occupation_wing_map();
/*  92 */     for (Map.Entry<Integer, TransferOccupationWing> entry : xTransferOccupationWingMap.entrySet())
/*     */     {
/*  94 */       if (((Integer)entry.getKey()).intValue() != xAllWingPlans.getEffectwingoccid())
/*     */       {
/*     */ 
/*     */ 
/*  98 */         WingPlan xWingPlan = (WingPlan)((TransferOccupationWing)entry.getValue()).getWings().get(Integer.valueOf(1));
/*  99 */         if (xWingPlan != null)
/*     */         {
/*     */ 
/*     */ 
/* 103 */           xWingPlan.setCurwing(0);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\PCGetOffWingReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */