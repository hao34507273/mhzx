/*    */ package mzm.gsp.npc.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.npc.CTeamLeaderInteractNpcReq;
/*    */ import mzm.gsp.npc.SSynTeamerInteractNpcReq;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCTeamLeaderInteractNpcReq extends LogicProcedure
/*    */ {
/*    */   private CTeamLeaderInteractNpcReq req;
/*    */   private long roleId;
/*    */   
/*    */   public PCTeamLeaderInteractNpcReq(long roleId, CTeamLeaderInteractNpcReq req)
/*    */   {
/* 18 */     this.req = req;
/* 19 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 24 */     if (!TeamInterface.isRoleInTeam(this.roleId, false)) {
/* 25 */       return false;
/*    */     }
/* 27 */     Long teamId = TeamInterface.getTeamidByRoleid(this.roleId, false);
/* 28 */     if (teamId == null) {
/* 29 */       return false;
/*    */     }
/* 31 */     List<Long> teamer = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/* 32 */     if ((teamer.size() > 0) && (this.roleId == ((Long)teamer.get(0)).longValue()))
/*    */     {
/* 34 */       SSynTeamerInteractNpcReq sSynTeamerInteractNpcReq = new SSynTeamerInteractNpcReq();
/* 35 */       sSynTeamerInteractNpcReq.npcid = this.req.npcid;
/* 36 */       sSynTeamerInteractNpcReq.args.addAll(this.req.args);
/* 37 */       for (Iterator i$ = teamer.iterator(); i$.hasNext();) { long teamerId = ((Long)i$.next()).longValue();
/* 38 */         OnlineManager.getInstance().send(teamerId, sSynTeamerInteractNpcReq);
/*    */       }
/* 40 */       return true;
/*    */     }
/* 42 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\main\PCTeamLeaderInteractNpcReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */