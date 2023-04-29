/*    */ package mzm.gsp.factionpve.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.factionpve.confbean.SFactionPVEConsts;
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.FactionPVETmp;
/*    */ import xtable.Factionpve_tmp;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_FactionKillMonsterCount
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmid;
/*    */   private final long roleid;
/*    */   private final int monsterid;
/*    */   private final int count;
/*    */   
/*    */   public PGM_FactionKillMonsterCount(long gmid, long roleid, int monsterid, int count)
/*    */   {
/* 25 */     this.gmid = gmid;
/* 26 */     this.roleid = roleid;
/* 27 */     this.monsterid = monsterid;
/* 28 */     this.count = count;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 33 */     if (this.count < 0) {
/* 34 */       GmManager.getInstance().sendResultToGM(this.gmid, "杀怪数量不可以为负数");
/* 35 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 39 */     Gang faction = GangInterface.getGangByRoleId(this.roleid, true);
/* 40 */     if (faction == null) {
/* 41 */       GmManager.getInstance().sendResultToGM(this.gmid, "角色没有帮派，无法设置pve副本杀怪数量");
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     FactionPVETmp xFactionPVETmp = Factionpve_tmp.get(Long.valueOf(faction.getGangId()));
/* 46 */     if (xFactionPVETmp == null) {
/* 47 */       GmManager.getInstance().sendResultToGM(this.gmid, "不在活动时间内，无法设置pve副本杀怪数量");
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     if (xFactionPVETmp.getStage() != 2) {
/* 52 */       GmManager.getInstance().sendResultToGM(this.gmid, "当前不是杀小怪阶段，无法设置杀怪数量，当前阶段：" + xFactionPVETmp.getStage());
/*    */       
/* 54 */       return false;
/*    */     }
/*    */     
/* 57 */     if (!FactionPVEConfigManager.isGoalMonster(this.monsterid)) {
/* 58 */       GmManager.getInstance().sendResultToGM(this.gmid, "不是帮派目标怪物");
/* 59 */       return false;
/*    */     }
/*    */     
/* 62 */     xFactionPVETmp.getGoal().put(Integer.valueOf(this.monsterid), Integer.valueOf(this.count));
/*    */     
/* 64 */     FactionPVEManager.broadcastFactionKillMonster(xFactionPVETmp);
/*    */     
/* 66 */     if (FactionPVEManager.checkMonsterGoalOfFaction(xFactionPVETmp))
/*    */     {
/* 68 */       BossCountDownSession session = new BossCountDownSession(faction.getGangId(), TimeUnit.SECONDS.toMillis(SFactionPVEConsts.getInstance().BossCountDownSeconds));
/*    */       
/*    */ 
/* 71 */       FactionPVEManager.setStageAndBroadcast(faction.getGangId(), faction, xFactionPVETmp, 3, session);
/*    */     }
/*    */     
/*    */ 
/* 75 */     GmManager.getInstance().sendResultToGM(this.gmid, "设置帮派杀怪数量成功");
/*    */     
/* 77 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\PGM_FactionKillMonsterCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */