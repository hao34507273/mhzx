/*    */ package mzm.gsp.factionpve.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.FactionPVETmp;
/*    */ import xbean.RoleFactionPVE;
/*    */ import xtable.Factionpve_tmp;
/*    */ 
/*    */ public class PGM_SelfKillMonsterCount
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmid;
/*    */   private final long roleid;
/*    */   private final int monsterid;
/*    */   private final int count;
/*    */   
/*    */   public PGM_SelfKillMonsterCount(long gmid, long roleid, int monsterid, int count)
/*    */   {
/* 22 */     this.gmid = gmid;
/* 23 */     this.roleid = roleid;
/* 24 */     this.monsterid = monsterid;
/* 25 */     this.count = count;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 30 */     if (this.count < 0) {
/* 31 */       GmManager.getInstance().sendResultToGM(this.gmid, "杀怪数量不可以为负数");
/* 32 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 36 */     Gang faction = GangInterface.getGangByRoleId(this.roleid, true);
/* 37 */     if (faction == null) {
/* 38 */       GmManager.getInstance().sendResultToGM(this.gmid, "角色没有帮派，无法设置pve副本杀怪数量");
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     FactionPVETmp xFactionPVETmp = Factionpve_tmp.get(Long.valueOf(faction.getGangId()));
/* 43 */     if (xFactionPVETmp == null) {
/* 44 */       GmManager.getInstance().sendResultToGM(this.gmid, "不在活动时间内，无法设置pve副本杀怪数量");
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     if (!FactionPVEManager.isStageCanEnter(xFactionPVETmp.getStage())) {
/* 49 */       GmManager.getInstance().sendResultToGM(this.gmid, "当前不是可以杀小怪的阶段，无法设置杀怪数量，当前阶段：" + xFactionPVETmp.getStage());
/*    */       
/* 51 */       return false;
/*    */     }
/*    */     
/* 54 */     if (!FactionPVEConfigManager.isGoalMonster(this.monsterid)) {
/* 55 */       GmManager.getInstance().sendResultToGM(this.gmid, "不是个人目标怪物");
/* 56 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 60 */     RoleFactionPVE xRolePVE = FactionPVEManager.getXRoleFactionPVEIfNotExist(this.roleid);
/* 61 */     xRolePVE.getGoal().put(Integer.valueOf(this.monsterid), Integer.valueOf(this.count));
/* 62 */     FactionPVEManager.checkAndHandleRoleGoal(xRolePVE);
/*    */     
/* 64 */     FactionPVEManager.syncSelfKillMonster(this.roleid, xRolePVE);
/*    */     
/* 66 */     GmManager.getInstance().sendResultToGM(this.gmid, "设置个人杀怪数量成功");
/*    */     
/* 68 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\PGM_SelfKillMonsterCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */