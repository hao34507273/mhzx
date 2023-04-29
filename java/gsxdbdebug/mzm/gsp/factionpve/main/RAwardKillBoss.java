/*    */ package mzm.gsp.factionpve.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.award.main.AwardInterface;
/*    */ import mzm.gsp.award.main.AwardModel;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.factionpve.confbean.SKillBossAwardCfg;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ class RAwardKillBoss
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final long world;
/*    */   private final SKillBossAwardCfg awardCfg;
/*    */   
/*    */   public RAwardKillBoss(long world, SKillBossAwardCfg awardCfg)
/*    */   {
/* 27 */     this.world = world;
/* 28 */     this.awardCfg = awardCfg;
/*    */   }
/*    */   
/*    */   public void process() throws Exception
/*    */   {
/* 33 */     List<Long> roles = MapInterface.getRoleList(this.world);
/* 34 */     for (Iterator i$ = roles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 35 */       PAwardKillBoss pAward = new PAwardKillBoss(roleid, this.awardCfg);
/* 36 */       if (!pAward.call()) {
/* 37 */         FactionPVEManager.logError("RAwardKillBoss.process@award failed|roleid=%d|world=%d|bossid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(this.world), Integer.valueOf(this.awardCfg.awardid) });
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   static class PAwardKillBoss
/*    */     extends LogicProcedure
/*    */   {
/*    */     private final long roleid;
/*    */     private final SKillBossAwardCfg awardCfg;
/*    */     
/*    */     PAwardKillBoss(long roleid, SKillBossAwardCfg awardCfg)
/*    */     {
/* 50 */       this.roleid = roleid;
/* 51 */       this.awardCfg = awardCfg;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 57 */       String userid = RoleInterface.getUserId(this.roleid);
/*    */       
/*    */ 
/* 60 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */       
/* 62 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*    */       
/*    */ 
/* 65 */       AwardReason awardReason = new AwardReason(LogReason.FACTION_PVE_KILL_BOSS, this.awardCfg.bossid);
/* 66 */       AwardModel awardModel = AwardInterface.awardFixAward(this.awardCfg.awardid, userid, this.roleid, false, false, awardReason);
/*    */       
/*    */ 
/* 69 */       FactionPVEManager.sendKillBossAward(this.roleid, this.awardCfg.bossid, awardModel);
/*    */       
/* 71 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\RAwardKillBoss.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */