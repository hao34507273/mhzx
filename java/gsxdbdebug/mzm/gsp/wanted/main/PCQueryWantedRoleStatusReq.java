/*    */ package mzm.gsp.wanted.main;
/*    */ 
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.npc.main.NpcInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pk.confbean.SPKConsts;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.wanted.SQueryWantedRoleStatusError;
/*    */ import mzm.gsp.wanted.SQueryWantedRoleStatusRsp;
/*    */ 
/*    */ public class PCQueryWantedRoleStatusReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   final long roleId;
/*    */   final long wantedRoleId;
/*    */   
/*    */   public PCQueryWantedRoleStatusReq(long roleId, long wantedRoleId)
/*    */   {
/* 22 */     this.roleId = roleId;
/* 23 */     this.wantedRoleId = wantedRoleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     if (this.wantedRoleId <= 0L)
/*    */     {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     boolean ret = WantedManager.checkSwitchAndCross(this.roleId, 1655);
/* 35 */     if (!ret)
/*    */     {
/* 37 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 41 */     if (!NpcInterface.checkNpcService(SPKConsts.getInstance().WANTED_NPC_ID, SPKConsts.getInstance().ARREST_SERVICE_ID, this.roleId))
/*    */     {
/*    */ 
/* 44 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 48 */     if (!MapInterface.isNearByNPC(this.roleId, SPKConsts.getInstance().WANTED_NPC_ID))
/*    */     {
/* 50 */       return false;
/*    */     }
/*    */     
/* 53 */     SQueryWantedRoleStatusError queryWantedRoleStatusError = new SQueryWantedRoleStatusError();
/* 54 */     queryWantedRoleStatusError.roleid = this.wantedRoleId;
/*    */     
/*    */ 
/* 57 */     if (!OnlineManager.getInstance().isOnline(this.wantedRoleId))
/*    */     {
/* 59 */       queryWantedRoleStatusError.errorcode = 1;
/* 60 */       OnlineManager.getInstance().sendAtOnce(this.roleId, queryWantedRoleStatusError);
/* 61 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 65 */     if (!WantedPageManager.getInstance().containsRecord(Long.valueOf(this.wantedRoleId)))
/*    */     {
/* 67 */       queryWantedRoleStatusError.errorcode = 2;
/* 68 */       OnlineManager.getInstance().sendAtOnce(this.roleId, queryWantedRoleStatusError);
/* 69 */       return false;
/*    */     }
/*    */     
/* 72 */     SQueryWantedRoleStatusRsp queryWantedRoleStatusRsp = new SQueryWantedRoleStatusRsp();
/* 73 */     queryWantedRoleStatusRsp.roleid = this.wantedRoleId;
/* 74 */     queryWantedRoleStatusRsp.mapid = MapInterface.getRoleMapId(this.wantedRoleId);
/* 75 */     queryWantedRoleStatusRsp.power = RoleInterface.getFightValue(this.wantedRoleId);
/*    */     
/* 77 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.wantedRoleId);
/* 78 */     if (teamInfo == null)
/*    */     {
/* 80 */       queryWantedRoleStatusRsp.teammembercount = 0;
/*    */     }
/*    */     else
/*    */     {
/* 84 */       queryWantedRoleStatusRsp.teammembercount = teamInfo.getTeamNormalMembersNum();
/*    */     }
/*    */     
/* 87 */     OnlineManager.getInstance().send(this.roleId, queryWantedRoleStatusRsp);
/* 88 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\main\PCQueryWantedRoleStatusReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */