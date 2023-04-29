/*    */ package mzm.gsp.factionpve.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Basic;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PLeaveFactionPVEMapReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PLeaveFactionPVEMapReq(long roleid)
/*    */   {
/* 24 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     int mapid = MapInterface.getRoleMapId(this.roleid);
/* 31 */     if (!FactionPVEConfigManager.isActivityMap(mapid)) {
/* 32 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 36 */     TeamInfo team = TeamInterface.getTeamInfoByRoleId(this.roleid);
/*    */     
/* 38 */     List<Long> lockRoles = new ArrayList();
/* 39 */     if (team != null) {
/* 40 */       lockRoles.addAll(team.getTeamMemberList());
/*    */     }
/*    */     else {
/* 43 */       lockRoles.add(Long.valueOf(this.roleid));
/*    */     }
/*    */     
/*    */ 
/* 47 */     lock(Basic.getTable(), lockRoles);
/*    */     
/* 49 */     if ((team != null) && 
/* 50 */       (team.isNormalState(this.roleid)) && 
/* 51 */       (!team.isLeader(this.roleid))) {
/* 52 */       FactionPVEManager.sendNormalResult(this.roleid, 22, new String[0]);
/*    */       
/* 54 */       return false;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 67 */     Gang faction = GangInterface.getGangByRoleId(this.roleid, true);
/*    */     
/* 69 */     FactionPVEManager.leave(this.roleid, faction);
/*    */     
/* 71 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\PLeaveFactionPVEMapReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */