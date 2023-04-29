/*    */ package mzm.gsp.qmhw.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.qmhw.confbean.SQMHWCfgConsts;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.QMHWActivity;
/*    */ import xtable.Role2qmhw;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCJoinQMHWReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCJoinQMHWReq(long roleid)
/*    */   {
/* 28 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 33 */     if ((!OpenInterface.getOpenStatus(58)) || (OpenInterface.isBanPlay(this.roleid, 58)))
/*    */     {
/* 35 */       OpenInterface.sendBanPlayMsg(this.roleid, 58);
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     if (!mzm.gsp.npc.main.NpcInterface.checkNpcService(SQMHWCfgConsts.getInstance().NPC_ID, 150205074, this.roleid)) {
/* 40 */       return false;
/*    */     }
/* 42 */     List<Long> normalList = new ArrayList();
/* 43 */     normalList.addAll(TeamInterface.getNormalRoleList(this.roleid));
/* 44 */     if (normalList.size() <= 0) {
/* 45 */       normalList.add(Long.valueOf(this.roleid));
/*    */     }
/* 47 */     if (((Long)normalList.get(0)).longValue() != this.roleid)
/*    */     {
/* 49 */       if (normalList.contains(Long.valueOf(this.roleid))) {
/* 50 */         GameServer.logger().info(String.format("[QMHW]PCJoinQMHWReq.processImp@in team and is not leader|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */         
/* 52 */         return false;
/*    */       }
/*    */       
/* 55 */       normalList.clear();
/* 56 */       normalList.add(Long.valueOf(this.roleid));
/*    */     }
/* 58 */     Map<Long, String> role2user = new HashMap();
/* 59 */     for (Iterator i$ = normalList.iterator(); i$.hasNext();) { long tmpRoleid = ((Long)i$.next()).longValue();
/* 60 */       role2user.put(Long.valueOf(tmpRoleid), RoleInterface.getUserId(tmpRoleid));
/*    */     }
/* 62 */     lock(User.getTable(), role2user.values());
/*    */     
/* 64 */     lock(Role2qmhw.getTable(), normalList);
/*    */     
/* 66 */     for (int i = 1; i < normalList.size(); i++) {
/* 67 */       long banRoleId = ((Long)normalList.get(i)).longValue();
/* 68 */       if (OpenInterface.isBanPlay(banRoleId, 58)) {
/* 69 */         OpenInterface.sendBanPlayMsg(this.roleid, banRoleId, RoleInterface.getName(banRoleId), 58);
/*    */         
/* 71 */         return false;
/*    */       }
/*    */     }
/*    */     
/* 75 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(role2user, normalList, SQMHWCfgConsts.getInstance().ACTIVITY_ID);
/*    */     
/* 77 */     if (!activityJoinResult.isCanJoin()) {
/* 78 */       GameServer.logger().info(String.format("[QMHW]PCJoinQMHWReq.processImp@can not join qmhw|roleid=%d|reason=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(activityJoinResult.getReasonValue()) }));
/*    */       
/*    */ 
/* 81 */       return false;
/*    */     }
/* 83 */     QMHWActivity xQmhwActivity = xtable.Qmhw.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 84 */     if (xQmhwActivity == null) {
/* 85 */       if (GameServer.logger().isDebugEnabled())
/* 86 */         GameServer.logger().debug(String.format("[QMHW]PCJoinQMHWReq.processImp@activity data is null", new Object[0]));
/* 87 */       return false;
/*    */     }
/* 89 */     if (!mzm.gsp.status.main.RoleStatusInterface.setStatus(normalList, 31, true)) {
/* 90 */       return false;
/*    */     }
/*    */     
/* 93 */     for (Iterator i$ = normalList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 94 */       MapInterface.transferToScene(roleid, xQmhwActivity.getWorldid(), SQMHWCfgConsts.getInstance().ACTIVITY_MAP_ID);
/*    */     }
/*    */     
/* 97 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\main\PCJoinQMHWReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */