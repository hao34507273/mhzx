/*    */ package mzm.gsp.wing.main2;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.AllWingPlans;
/*    */ import xbean.TransferOccupationWing;
/*    */ import xbean.WingPlan;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_TransformToOldData
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_TransformToOldData(long gmRoleId, long roleId)
/*    */   {
/* 23 */     this.gmRoleId = gmRoleId;
/* 24 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     RoleWingInfo roleWingInfo = new RoleWingInfo(this.roleId, true);
/* 31 */     AllWingPlans xWingPlans = roleWingInfo.getxWingPlans();
/* 32 */     if (xWingPlans == null)
/*    */     {
/* 34 */       return false;
/*    */     }
/* 36 */     WingPlan xWingPlan = roleWingInfo.getWingPlan(1);
/* 37 */     if (xWingPlan == null)
/*    */     {
/*    */ 
/* 40 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "该玩家没有羽翼，请先开启羽翼功能！");
/* 41 */       return false;
/*    */     }
/* 43 */     if (OnlineManager.getInstance().isOnline(this.roleId))
/*    */     {
/*    */ 
/* 46 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "被操作者必须处于离线状态！");
/* 47 */       return false;
/*    */     }
/* 49 */     int occId = RoleInterface.getOccupationId(this.roleId);
/*    */     
/* 51 */     TransferOccupationWing xOccWingInfo = (TransferOccupationWing)xWingPlans.getTransfer_occupation_wing_map().remove(Integer.valueOf(occId));
/* 52 */     if (xOccWingInfo == null)
/*    */     {
/* 54 */       return false;
/*    */     }
/*    */     
/* 57 */     xWingPlans.setCurplan(1);
/* 58 */     xWingPlans.getWings().clear();
/* 59 */     for (Map.Entry<Integer, WingPlan> entry : xOccWingInfo.getWings().entrySet())
/*    */     {
/* 61 */       xWingPlans.getWings().put(entry.getKey(), ((WingPlan)entry.getValue()).copy());
/*    */     }
/*    */     
/* 64 */     xWingPlans.setEffectwingoccid(0);
/* 65 */     xWingPlans.getOcc2lastplanoccid().clear();
/* 66 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "转换数据成功！");
/* 67 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\PGM_TransformToOldData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */