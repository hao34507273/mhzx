/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.instance.SSynTeamInstanceEnterRes;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2instance;
/*    */ 
/*    */ public class EnterInstanceCallBack implements mzm.gsp.map.main.MapCallback<Long>
/*    */ {
/* 16 */   private List<Long> roleids = new ArrayList();
/*    */   private int instanceCfgid;
/*    */   private long teamid;
/*    */   
/*    */   public EnterInstanceCallBack(List<Long> roleids, int instanceCfgid, long teamid) {
/* 21 */     this.roleids.addAll(roleids);
/* 22 */     this.instanceCfgid = instanceCfgid;
/* 23 */     this.teamid = teamid;
/*    */   }
/*    */   
/*    */   public boolean isCallInProcedure()
/*    */   {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public boolean onResult(Long worldid)
/*    */   {
/* 33 */     SSynTeamInstanceEnterRes synTeamInstanceEnterRes = new SSynTeamInstanceEnterRes();
/* 34 */     synTeamInstanceEnterRes.ret = 1;
/* 35 */     if ((worldid == null) || (worldid.longValue() == -1L)) {
/* 36 */       GameServer.logger().error(String.format("[Instance]EnterInstanceCallBack.onResult@地图接口返回worldid错误!!", new Object[0]));
/* 37 */       synTeamInstanceEnterRes.ret = 2;
/*    */     }
/* 39 */     List<Long> nowRoleids = mzm.gsp.team.main.TeamInterface.getTeamMemberList(this.teamid, false);
/* 40 */     if (nowRoleids.size() < 0) {
/* 41 */       synTeamInstanceEnterRes.ret = 2;
/*    */     }
/*    */     
/* 44 */     Lockeys.lock(Role2instance.getTable(), this.roleids);
/* 45 */     for (Iterator i$ = this.roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 46 */       if (InstanceInterface.isRoleInInstance(roleid, true)) {
/* 47 */         synTeamInstanceEnterRes.ret = 2;
/* 48 */         break;
/*    */       }
/*    */     }
/* 51 */     xbean.InstanceCacheBean xInstanceCacheBean = xbean.Pod.newInstanceCacheBean();
/* 52 */     Long instanceUuid = xtable.Instance.insert(xInstanceCacheBean);
/* 53 */     boolean suc = synTeamInstanceEnterRes.ret == 1;
/* 54 */     if (suc) {
/* 55 */       suc = TeamInstance.allAgreeRoleCheck(this.roleids, nowRoleids, true);
/* 56 */       if (suc)
/* 57 */         suc = TeamInstance.enterInstance(this.roleids, this.instanceCfgid, instanceUuid.longValue(), xInstanceCacheBean, worldid.longValue());
/*    */     }
/* 59 */     if (suc) {
/* 60 */       synTeamInstanceEnterRes.ret = 1;
/*    */     } else
/* 62 */       synTeamInstanceEnterRes.ret = 2;
/* 63 */     OnlineManager.getInstance().sendMultiAtOnce(synTeamInstanceEnterRes, this.roleids);
/* 64 */     if ((!suc) && (worldid != null) && (worldid.longValue() != -1L)) {
/* 65 */       MapInterface.destroyWorld(worldid.longValue());
/*    */     }
/* 67 */     GameServer.logger().info(String.format("[instance]EnterInstanceCallBack.onResult@on create world result|worldid=%d|teamid=%d|instance_cfg_id=%d|suc=%b", new Object[] { Long.valueOf(worldid == null ? -1L : worldid.longValue()), Long.valueOf(this.teamid), Integer.valueOf(this.instanceCfgid), Boolean.valueOf(suc) }));
/*    */     
/*    */ 
/*    */ 
/* 71 */     return suc;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\EnterInstanceCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */