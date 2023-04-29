/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Gang;
/*    */ import xbean.GangMemoryBean;
/*    */ import xbean.GangTeam;
/*    */ 
/*    */ 
/*    */ public class PAutoJoinGangTeamReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PAutoJoinGangTeamReq(long roleid)
/*    */   {
/* 21 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 26 */     if (!OpenInterface.getOpenStatus(513)) {
/* 27 */       GangManager.logError("PAutoJoinGangTeamReq.processImp@not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*    */       
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     Long gangid = GangManager.getGangidByRole(this.roleid);
/* 33 */     if (gangid == null) {
/* 34 */       GangManager.sendNormalResult(this.roleid, 231, new Object[0]);
/* 35 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 39 */     Gang xGang = GangManager.getXGang(gangid.longValue(), true);
/* 40 */     if ((xGang == null) || (!GangManager.isInGang(xGang, this.roleid))) {
/* 41 */       GangManager.sendNormalResult(this.roleid, 231, new Object[0]);
/* 42 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 46 */     long selfGangTeamid = GangManager.getGangTeamid(xGang, this.roleid);
/* 47 */     if (selfGangTeamid > 0L) {
/* 48 */       GangManager.sendNormalResult(this.roleid, 232, new Object[0]);
/* 49 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 53 */     GangMemoryBean xGangMemory = GangManager.getAndCreateXGangMemory(gangid.longValue());
/*    */     
/* 55 */     Iterator<Map.Entry<Long, GangTeam>> iter = xGang.getTeams().entrySet().iterator();
/* 56 */     while (iter.hasNext()) {
/* 57 */       Map.Entry<Long, GangTeam> entry = (Map.Entry)iter.next();
/* 58 */       long gangTeamid = ((Long)entry.getKey()).longValue();
/* 59 */       GangTeam xGangTeam = (GangTeam)entry.getValue();
/*    */       
/* 61 */       if (!GangManager.isGangTeamFull(xGangTeam))
/*    */       {
/*    */ 
/*    */ 
/* 65 */         boolean ret = GangManager.addGangTeamApplicantAndBroadcast(xGangMemory, gangTeamid, xGangTeam, this.roleid);
/* 66 */         if (ret) {
/* 67 */           GangManager.logInfo("PAutoJoinGangTeamReq.processImp@apply gang team|roleid=%d|gangid=%d|gang_teamid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(gangid.longValue()), Long.valueOf(gangTeamid) });
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 73 */     GangManager.sendNormalResult(this.roleid, 233, new Object[0]);
/*    */     
/* 75 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PAutoJoinGangTeamReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */