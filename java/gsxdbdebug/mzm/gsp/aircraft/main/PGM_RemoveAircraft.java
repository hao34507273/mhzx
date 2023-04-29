/*    */ package mzm.gsp.aircraft.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_RemoveAircraft
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long targetRoleId;
/*    */   private final int aircraftCfgId;
/*    */   
/*    */   public PGM_RemoveAircraft(long gmRoleId, long targetRoleId, int aircraftCfgId)
/*    */   {
/* 17 */     this.gmRoleId = gmRoleId;
/* 18 */     this.targetRoleId = targetRoleId;
/* 19 */     this.aircraftCfgId = aircraftCfgId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     int ret = AircraftInterface.removeAircraft(this.targetRoleId, this.aircraftCfgId);
/* 26 */     if (ret == 0)
/*    */     {
/* 28 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "删除飞行器成功");
/* 29 */       return true;
/*    */     }
/* 31 */     if (ret == 64095)
/*    */     {
/* 33 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "飞行器配置不存在");
/* 34 */       return false;
/*    */     }
/* 36 */     if (ret == 64094)
/*    */     {
/* 38 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "被删除角色的数据不存在");
/* 39 */       return false;
/*    */     }
/* 41 */     if (ret == 64093)
/*    */     {
/* 43 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "角色未拥有该飞行器");
/* 44 */       return false;
/*    */     }
/* 46 */     if (ret == 64096)
/*    */     {
/* 48 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "角色没有飞行器数据");
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\aircraft\main\PGM_RemoveAircraft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */