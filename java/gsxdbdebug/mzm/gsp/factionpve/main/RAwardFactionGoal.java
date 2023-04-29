/*    */ package mzm.gsp.factionpve.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.award.main.AwardInterface;
/*    */ import mzm.gsp.award.main.AwardModel;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.factionpve.confbean.SFactionPVEConsts;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ class RAwardFactionGoal
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final long world;
/*    */   
/*    */   public RAwardFactionGoal(long world)
/*    */   {
/* 26 */     this.world = world;
/*    */   }
/*    */   
/*    */   public void process() throws Exception
/*    */   {
/* 31 */     List<Long> roles = MapInterface.getRoleList(this.world);
/* 32 */     for (Iterator i$ = roles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 33 */       PAwardFactionGoal pAward = new PAwardFactionGoal(roleid);
/* 34 */       if (!pAward.call()) {
/* 35 */         FactionPVEManager.logError("RAwardFactionGoal.process@award failed|roleid=%d|world=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(this.world) });
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   static class PAwardFactionGoal
/*    */     extends LogicProcedure
/*    */   {
/*    */     private final long roleid;
/*    */     
/*    */     PAwardFactionGoal(long roleid)
/*    */     {
/* 47 */       this.roleid = roleid;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 53 */       String userid = RoleInterface.getUserId(this.roleid);
/*    */       
/*    */ 
/* 56 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */       
/* 58 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*    */       
/*    */ 
/* 61 */       AwardReason awardReason = new AwardReason(LogReason.FACTION_PVE_FACTION_GOAL);
/* 62 */       AwardModel awardModel = AwardInterface.awardFixAward(SFactionPVEConsts.getInstance().FactionGoalAward, userid, this.roleid, false, false, awardReason);
/*    */       
/*    */ 
/*    */ 
/* 66 */       FactionPVEManager.sendFactionGoalAward(this.roleid, awardModel);
/*    */       
/* 68 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\RAwardFactionGoal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */