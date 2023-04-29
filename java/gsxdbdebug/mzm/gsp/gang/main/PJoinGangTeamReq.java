/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Gang;
/*    */ import xbean.GangMemoryBean;
/*    */ import xbean.GangTeam;
/*    */ 
/*    */ 
/*    */ public class PJoinGangTeamReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long gangTeamid;
/*    */   
/*    */   public PJoinGangTeamReq(long roleid, long gangTeamid)
/*    */   {
/* 19 */     this.roleid = roleid;
/* 20 */     this.gangTeamid = gangTeamid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 25 */     if (!OpenInterface.getOpenStatus(513)) {
/* 26 */       GangManager.logError("PJoinGangTeamReq.processImp@not open|roleid=%d|gang_teamid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.gangTeamid) });
/*    */       
/* 28 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 32 */     Long gangid = GangManager.getGangidByRole(this.roleid);
/* 33 */     if (gangid == null) {
/* 34 */       GangManager.sendNormalResult(this.roleid, 221, new Object[0]);
/* 35 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 39 */     Gang xGang = GangManager.getXGang(gangid.longValue(), true);
/*    */     
/* 41 */     if (xGang == null) {
/* 42 */       GangManager.sendNormalResult(this.roleid, 221, new Object[0]);
/* 43 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 47 */     if (!GangManager.isInGang(xGang, this.roleid)) {
/* 48 */       GangManager.sendNormalResult(this.roleid, 221, new Object[0]);
/* 49 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 53 */     long selfGangTeamid = GangManager.getGangTeamid(xGang, this.roleid);
/* 54 */     if (selfGangTeamid > 0L) {
/* 55 */       GangManager.sendNormalResult(this.roleid, 222, new Object[0]);
/* 56 */       return false;
/*    */     }
/*    */     
/* 59 */     GangTeam xGangTeam = (GangTeam)xGang.getTeams().get(Long.valueOf(this.gangTeamid));
/* 60 */     if (xGangTeam == null) {
/* 61 */       GangManager.sendNormalResult(this.roleid, 223, new Object[0]);
/* 62 */       return false;
/*    */     }
/*    */     
/* 65 */     if (GangManager.isGangTeamFull(xGangTeam)) {
/* 66 */       GangManager.sendNormalResult(this.roleid, 225, new Object[0]);
/* 67 */       return false;
/*    */     }
/*    */     
/* 70 */     GangMemoryBean xGangMemory = GangManager.getAndCreateXGangMemory(gangid.longValue());
/* 71 */     boolean ret = GangManager.addGangTeamApplicantAndBroadcast(xGangMemory, this.gangTeamid, xGangTeam, this.roleid);
/* 72 */     if (!ret) {
/* 73 */       GangManager.sendNormalResult(this.roleid, 224, new Object[0]);
/* 74 */       return false;
/*    */     }
/*    */     
/* 77 */     GangManager.sendNormalResult(this.roleid, 226, new Object[0]);
/*    */     
/* 79 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PJoinGangTeamReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */