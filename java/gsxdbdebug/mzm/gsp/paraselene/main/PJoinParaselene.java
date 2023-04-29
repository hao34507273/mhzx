/*    */ package mzm.gsp.paraselene.main;
/*    */ 
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.npc.main.NpcInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.paraselene.SJoinParaseleneSuc;
/*    */ import mzm.gsp.paraselene.confbean.SParaseleneActivitySeq;
/*    */ import mzm.gsp.paraselene.confbean.SParaseleneCfgConsts;
/*    */ import mzm.gsp.paraselene.event.JoinParaselene;
/*    */ import mzm.gsp.paraselene.event.JoinParaseleneArg;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PJoinParaselene
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   public PJoinParaselene(long roleid)
/*    */   {
/* 27 */     this.roleId = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 34 */     if (!OpenInterface.getOpenStatus(12))
/*    */     {
/* 36 */       String logstr = String.format("[paraselene]PJoinParaselene.processImp@Paraselene switch is closed roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 38 */       ParaseleneManager.logger.info(logstr);
/*    */       
/* 40 */       OpenInterface.sendCloseProtocol(this.roleId, 12, null);
/* 41 */       return false;
/*    */     }
/* 43 */     if (!NpcInterface.checkNpcService(SParaseleneCfgConsts.getInstance().Npc, SParaseleneCfgConsts.getInstance().Npc_Service, this.roleId))
/*    */     {
/*    */ 
/* 46 */       return false;
/*    */     }
/* 48 */     Long teamId = TeamInterface.getTeamidByRoleid(this.roleId, false);
/* 49 */     if (teamId == null)
/*    */     {
/* 51 */       ParaseleneManager.sendErrorInfo(this.roleId, 1);
/* 52 */       return false;
/*    */     }
/* 54 */     if (!TeamInterface.isTeamLeader(teamId.longValue(), this.roleId, false))
/*    */     {
/* 56 */       return false;
/*    */     }
/* 58 */     if (!ParaseleneManager.checkTeam(this.roleId, teamId.longValue()))
/*    */     {
/* 60 */       return false;
/*    */     }
/* 62 */     long worldid = ParaseleneManager.getWorldidByteamid(teamId.longValue());
/*    */     
/* 64 */     SParaseleneActivitySeq paraseleneActivitySeq = ParaseleneManager.getParaseleneActivityBylayer(1);
/* 65 */     if (paraseleneActivitySeq == null)
/*    */     {
/* 67 */       return false;
/*    */     }
/* 69 */     SJoinParaseleneSuc suc = new SJoinParaseleneSuc();
/* 70 */     OnlineManager.getInstance().send(this.roleId, suc);
/*    */     
/* 72 */     boolean ret = RoleStatusInterface.setStatus(TeamInterface.getNormalRoleList(this.roleId), 12, true);
/* 73 */     if (ret)
/*    */     {
/* 75 */       MapInterface.transferToScene(this.roleId, worldid, paraseleneActivitySeq.mapid);
/* 76 */       TriggerEventsManger.getInstance().triggerEvent(new JoinParaselene(), new JoinParaseleneArg(TeamInterface.getNormalRoleList(this.roleId)));
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 81 */       String logstr = String.format("[paraselene]PJoinParaselene.processImp@can not set role paraselene state|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 83 */       ParaseleneManager.logger.info(logstr);
/*    */     }
/*    */     
/* 86 */     return ret;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\PJoinParaselene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */