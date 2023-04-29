/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Gang;
/*    */ import xbean.GangTeam;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PChangeGangTeamNameReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final String newName;
/*    */   
/*    */   public PChangeGangTeamNameReq(long roleid, String newName)
/*    */   {
/* 19 */     this.roleid = roleid;
/* 20 */     this.newName = newName;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 25 */     if (!OpenInterface.getOpenStatus(513)) {
/* 26 */       GangManager.logError("PCreateGangTeamReq.processImp@not open|roleid=%d|new_name=%s", new Object[] { Long.valueOf(this.roleid), this.newName });
/*    */       
/* 28 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 32 */     Long gangid = GangManager.getGangidByRole(this.roleid);
/* 33 */     if (gangid == null) {
/* 34 */       GangManager.sendNormalResult(this.roleid, 211, new Object[0]);
/* 35 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 39 */     Gang xGang = GangManager.getXGang(gangid.longValue(), true);
/* 40 */     if ((xGang == null) || (!GangManager.isInGang(xGang, this.roleid))) {
/* 41 */       GangManager.sendNormalResult(this.roleid, 211, new Object[0]);
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     Long gangTeamid = (Long)xGang.getMember2teamid().get(Long.valueOf(this.roleid));
/* 46 */     if (gangTeamid == null) {
/* 47 */       GangManager.sendNormalResult(this.roleid, 212, new Object[0]);
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     GangTeam xGangTeam = (GangTeam)xGang.getTeams().get(gangTeamid);
/* 52 */     if (xGangTeam == null) {
/* 53 */       GangManager.sendNormalResult(this.roleid, 212, new Object[0]);
/* 54 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 58 */     if (!GangManager.isGangTeamLeader(xGangTeam, this.roleid)) {
/* 59 */       GangManager.sendNormalResult(this.roleid, 213, new Object[0]);
/* 60 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 64 */     if (GangConfigManager.getInstance().isGangTeamNameTooLong(this.newName)) {
/* 65 */       GangManager.sendNormalResult(this.roleid, 214, new Object[0]);
/* 66 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 70 */     if (!GangConfigManager.getInstance().isGangTeamNameLegal(this.newName)) {
/* 71 */       GangManager.sendNormalResult(this.roleid, 215, new Object[0]);
/* 72 */       return false;
/*    */     }
/*    */     
/* 75 */     xGangTeam.setName(this.newName);
/*    */     
/* 77 */     GangManager.broadcastChangeGangTeamName(xGang, gangTeamid.longValue(), this.newName);
/*    */     
/*    */ 
/* 80 */     GangManager.logInfo("PChangeGangTeamNameReq.processImp@change name succeed|roleid=%d|gangid=%d|gang_teamid=%d|new_name=%s", new Object[] { Long.valueOf(this.roleid), Long.valueOf(gangid.longValue()), Long.valueOf(gangTeamid.longValue()), this.newName });
/*    */     
/*    */ 
/*    */ 
/* 84 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PChangeGangTeamNameReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */