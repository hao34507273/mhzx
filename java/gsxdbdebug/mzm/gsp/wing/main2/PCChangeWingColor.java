/*     */ package mzm.gsp.wing.main2;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.wing.confbean.WingCfgConsts;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AllWingPlans;
/*     */ import xbean.TransferOccupationWing;
/*     */ import xbean.WingContent;
/*     */ import xbean.WingPlan;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2wingplans;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCChangeWingColor
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int wingId;
/*     */   private final long uuid;
/*     */   private final int num;
/*     */   private final long yuanBao;
/*     */   private final boolean useYuanbao;
/*     */   
/*     */   public PCChangeWingColor(long roleId, int wingId, long uuid, int num, long yuanbao, byte useYuanbao)
/*     */   {
/*  36 */     this.roleId = roleId;
/*  37 */     this.wingId = wingId;
/*  38 */     this.uuid = uuid;
/*  39 */     this.num = num;
/*  40 */     this.yuanBao = yuanbao;
/*  41 */     this.useYuanbao = (useYuanbao == 1);
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  47 */     if (!isValid())
/*     */     {
/*  49 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  53 */     String userid = RoleInterface.getUserId(this.roleId);
/*  54 */     lock(Lockeys.get(User.getTable(), userid));
/*  55 */     RoleWingInfo roleWingInfo = new RoleWingInfo(this.roleId, true);
/*  56 */     WingPlan xWingPlan = roleWingInfo.getWingPlan(1);
/*  57 */     if (xWingPlan == null)
/*     */     {
/*  59 */       GameServer.logger().error(String.format("[wing]PCChangeWingColor.processImp@ wing plan not open!|roleId=%d|plan=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1) }));
/*     */       
/*     */ 
/*  62 */       return false;
/*     */     }
/*  64 */     RoleWingPlan xPlan = new RoleWingPlan(this.roleId, 1, xWingPlan);
/*     */     
/*  66 */     WingContent xWingData = xPlan.getWingData(this.wingId);
/*  67 */     if (xWingData == null)
/*     */     {
/*  69 */       GameServer.logger().error(String.format("[wing]PCChangeWingColor.processImp@ not own this wing!|roleId=%d|plan=%d|wingId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(this.wingId) }));
/*     */       
/*     */ 
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     if (!WingManager.payPrice(userid, this.roleId, getColorItemId(), getNeedItemNum(), this.useYuanbao, this.yuanBao, CostType.COST_BIND_FIRST_WING_MODLE_DYE, new TLogArg(LogReason.WING_MODEL_DYE_REM, getColorItemId())))
/*     */     {
/*     */ 
/*  78 */       GameServer.logger().error(String.format("[wing]PCChangeWingColor.processImp@ pay error!|roleId=%d|plan=%d|wingId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(this.wingId) }));
/*     */       
/*     */ 
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     if (!changeColor(xWingData, roleWingInfo.getEffectWingOccId()))
/*     */     {
/*  86 */       GameServer.logger().error(String.format("[wing]PCChangeWingColor.processImp@ change color error!|roleId=%d|plan=%d|wingId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(this.wingId) }));
/*     */       
/*     */ 
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean changeColor(WingContent xWingData, int effectOccId)
/*     */   {
/* 103 */     int orgColorId = xWingData.getColorid();
/*     */     
/* 105 */     int colorLibId = WingCfgManager.getWingRanColorId(this.wingId);
/* 106 */     if (colorLibId <= 0)
/*     */     {
/* 108 */       GameServer.logger().error(String.format("[wing]PCChangeWingColor.changeColor@ no colorLibId!|roleId=%d|plan=%d|wingId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(this.wingId) }));
/*     */       
/*     */ 
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     int newColorId = WingCfgManager.ranNewColor(colorLibId, orgColorId);
/*     */     
/* 116 */     if (newColorId < 0)
/*     */     {
/* 118 */       GameServer.logger().error(String.format("[wing]PCChangeWingColor.changeColor@ ran newColorId error!|roleId=%d|plan=%d|wingId=%d|colorLibId=%d|orgColorId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(1), Integer.valueOf(this.wingId), Integer.valueOf(colorLibId), Integer.valueOf(orgColorId) }));
/*     */       
/*     */ 
/*     */ 
/* 122 */       return false;
/*     */     }
/*     */     
/* 125 */     xWingData.setColorid(newColorId);
/*     */     
/* 127 */     changeTransferOccupationWingColor(newColorId);
/*     */     
/* 129 */     WingManager.noticeColorChange(this.roleId, this.wingId, newColorId, orgColorId, effectOccId);
/* 130 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void changeTransferOccupationWingColor(int newColorId)
/*     */   {
/* 138 */     AllWingPlans xAllWingPlans = Role2wingplans.get(Long.valueOf(this.roleId));
/* 139 */     if (xAllWingPlans == null)
/*     */     {
/* 141 */       return;
/*     */     }
/* 143 */     Map<Integer, TransferOccupationWing> xTransferOccupationWingMap = xAllWingPlans.getTransfer_occupation_wing_map();
/* 144 */     for (Map.Entry<Integer, TransferOccupationWing> entry : xTransferOccupationWingMap.entrySet())
/*     */     {
/* 146 */       if (((Integer)entry.getKey()).intValue() != xAllWingPlans.getEffectwingoccid())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 151 */         WingPlan xWingPlan = (WingPlan)((TransferOccupationWing)entry.getValue()).getWings().get(Integer.valueOf(1));
/* 152 */         if (xWingPlan != null)
/*     */         {
/*     */ 
/*     */ 
/* 156 */           WingContent xWingContent = (WingContent)xWingPlan.getWings().get(Integer.valueOf(this.wingId));
/* 157 */           if (xWingContent != null)
/*     */           {
/*     */ 
/*     */ 
/* 161 */             xWingContent.setColorid(newColorId); }
/*     */         }
/*     */       } }
/*     */   }
/*     */   
/*     */   boolean isValid() {
/* 167 */     if (RoleInterface.getLevel(this.roleId) < WingInterface.getMinRoleLvForWing())
/*     */     {
/* 169 */       WingManager.sendWingNotice(this.roleId, 8, new String[0]);
/* 170 */       return false;
/*     */     }
/*     */     
/* 173 */     if (!WingManager.isWingDyeSwitchOpenForRole(this.roleId))
/*     */     {
/* 175 */       return false;
/*     */     }
/*     */     
/* 178 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 281, true))
/*     */     {
/* 180 */       return false;
/*     */     }
/*     */     
/* 183 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getColorItemId()
/*     */   {
/* 193 */     return WingCfgConsts.getInstance().WING_DYE_ITEM_ID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   int getNeedItemNum()
/*     */   {
/* 201 */     return 1;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\PCChangeWingColor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */