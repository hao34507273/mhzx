/*     */ package mzm.gsp.wing.main2;
/*     */ 
/*     */ import xbean.AllWingPlans;
/*     */ import xbean.TransferOccupationWing;
/*     */ import xbean.WingPlan;
/*     */ 
/*     */ public class RoleWingInfo
/*     */ {
/*     */   private long roleId;
/*     */   private AllWingPlans xWingPlans;
/*     */   private boolean locked;
/*     */   public static final int PLAN_A = 1;
/*     */   
/*     */   public RoleWingInfo(long roleId, boolean remainLock)
/*     */   {
/*  16 */     this.roleId = roleId;
/*  17 */     this.locked = remainLock;
/*  18 */     if (remainLock)
/*     */     {
/*  20 */       this.xWingPlans = xtable.Role2wingplans.get(Long.valueOf(roleId));
/*  21 */       if (this.xWingPlans != null)
/*     */       {
/*     */ 
/*  24 */         WingManager.transformOccData(roleId, this.xWingPlans);
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/*  29 */       this.xWingPlans = xtable.Role2wingplans.select(Long.valueOf(roleId));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public AllWingPlans getxWingPlans()
/*     */   {
/*  36 */     return this.xWingPlans;
/*     */   }
/*     */   
/*     */   long getRoleId()
/*     */   {
/*  41 */     return this.roleId;
/*     */   }
/*     */   
/*     */   boolean isLocked()
/*     */   {
/*  46 */     return this.locked;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean hasXData()
/*     */   {
/*  56 */     return this.xWingPlans != null;
/*     */   }
/*     */   
/*     */   void createXData()
/*     */   {
/*  61 */     if (this.xWingPlans != null)
/*     */     {
/*  63 */       return;
/*     */     }
/*  65 */     this.xWingPlans = xbean.Pod.newAllWingPlans();
/*  66 */     this.xWingPlans.setEffectwingoccid(mzm.gsp.role.main.RoleInterface.getOccupationId(this.roleId));
/*  67 */     xtable.Role2wingplans.insert(Long.valueOf(this.roleId), this.xWingPlans);
/*     */   }
/*     */   
/*     */   int getEffectWingOccId()
/*     */   {
/*  72 */     return this.xWingPlans.getEffectwingoccid();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void setEffectWingOccId(int occId)
/*     */   {
/*  82 */     this.xWingPlans.setEffectwingoccid(occId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   WingPlan getWingPlan(int plan)
/*     */   {
/*  93 */     if (this.xWingPlans == null)
/*     */     {
/*  95 */       return null;
/*     */     }
/*  97 */     return getWingPlan(plan, getEffectWingOccId(), false);
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
/*     */   WingPlan getWingPlan(int plan, int occId, boolean createIfAbsent)
/*     */   {
/* 110 */     TransferOccupationWing xWingInfo = getXOccWingInfo(occId, createIfAbsent);
/* 111 */     return xWingInfo == null ? null : (WingPlan)xWingInfo.getWings().get(Integer.valueOf(plan));
/*     */   }
/*     */   
/*     */   private TransferOccupationWing getXOccWingInfo(int occId, boolean createIfAbsent)
/*     */   {
/* 116 */     if (this.xWingPlans == null)
/*     */     {
/* 118 */       return null;
/*     */     }
/* 120 */     TransferOccupationWing xWingInfo = (TransferOccupationWing)this.xWingPlans.getTransfer_occupation_wing_map().get(Integer.valueOf(occId));
/* 121 */     if ((xWingInfo == null) && (createIfAbsent))
/*     */     {
/* 123 */       this.xWingPlans.getTransfer_occupation_wing_map().put(Integer.valueOf(occId), xWingInfo = xbean.Pod.newTransferOccupationWing());
/*     */     }
/* 125 */     return xWingInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   WingPlan addNewPlan(int plan, int occId)
/*     */   {
/* 137 */     TransferOccupationWing xWingInfo = getXOccWingInfo(occId, true);
/* 138 */     if (xWingInfo == null)
/*     */     {
/* 140 */       return null;
/*     */     }
/* 142 */     WingPlan xWingPlan = (WingPlan)xWingInfo.getWings().get(Integer.valueOf(plan));
/* 143 */     if (xWingPlan == null)
/*     */     {
/* 145 */       xWingInfo.getWings().put(Integer.valueOf(plan), xWingPlan = xbean.Pod.newWingPlan());
/*     */     }
/* 147 */     return xWingPlan;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   WingPlan createNewPlan(int plan)
/*     */   {
/* 158 */     return addNewPlan(plan, getEffectWingOccId());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\RoleWingInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */