/*     */ package mzm.gsp.instance.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.instance.SEnterInstanceRes;
/*     */ import mzm.gsp.instance.confbean.SInstanceCfg;
/*     */ import mzm.gsp.instance.confbean.SInstanceConsts;
/*     */ import mzm.gsp.instance.confbean.SingleInstanceData;
/*     */ import mzm.gsp.instance.event.JoinSingleInstanceArg;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.InstanceBean;
/*     */ import xbean.InstanceCacheBean;
/*     */ import xbean.Pod;
/*     */ import xbean.SingleInstance;
/*     */ import xtable.Role2instance;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCChallengeSingleReq extends mzm.gsp.util.LogicProcedure implements mzm.gsp.map.main.MapCallback<Long>
/*     */ {
/*     */   private int instancecfgid;
/*     */   private int processid;
/*     */   private long roleid;
/*     */   
/*     */   public PCChallengeSingleReq(long roleid, int instanceid, int processid)
/*     */   {
/*  39 */     this.roleid = roleid;
/*  40 */     this.instancecfgid = instanceid;
/*  41 */     this.processid = processid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  47 */     if ((!OpenInterface.getOpenStatus(4)) || (OpenInterface.isBanPlay(this.roleid, 4)))
/*     */     {
/*  49 */       OpenInterface.sendBanPlayMsg(this.roleid, 4);
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     SingleInstanceData singleInstanceDataCfg = InstanceCfgManager.getSingleInstanceCfg(this.instancecfgid, this.processid);
/*  54 */     if (singleInstanceDataCfg == null) {
/*  55 */       GameServer.logger().info(String.format("[Instance]PCChallengeSingleReq.processImp@单人副本进度配置信息不存在!!!|roleid=%d|instancdCfgid=%d|processid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.instancecfgid), Integer.valueOf(this.processid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     Map<Long, String> role2Userid = new HashMap();
/*  64 */     role2Userid.put(Long.valueOf(this.roleid), mzm.gsp.role.main.RoleInterface.getUserId(this.roleid));
/*  65 */     lock(User.getTable(), role2Userid.values());
/*     */     
/*  67 */     List<Long> roleIds = Arrays.asList(new Long[] { Long.valueOf(this.roleid) });
/*  68 */     lock(Role2instance.getTable(), roleIds);
/*     */     
/*  70 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(role2Userid, roleIds, SInstanceConsts.getInstance().SINGLE_INSTANCE_ACTIVITY_TYPE_ID);
/*     */     
/*  72 */     if (!activityJoinResult.isCanJoin()) {
/*  73 */       GameServer.logger().info(String.format("[SingleInstance]PCChallengeSingleReq.processImp@can not join singleInstance|roleid=%d|instanceid=%d|reasion=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.instancecfgid), Integer.valueOf(activityJoinResult.getReasonValue()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     EnterInstanceResult enterInstanceResult = InstanceManager.canEnterInstance(Arrays.asList(new Long[] { Long.valueOf(this.roleid) }), this.instancecfgid);
/*     */     
/*  83 */     if (!enterInstanceResult.canJoin) {
/*  84 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  88 */     if (!reCheckCanChallenge()) {
/*  89 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  93 */     InstanceBean xInstanceBean = Role2instance.get(Long.valueOf(this.roleid));
/*  94 */     if (xInstanceBean == null) {
/*  95 */       xInstanceBean = Pod.newInstanceBean();
/*  96 */       Role2instance.insert(Long.valueOf(this.roleid), xInstanceBean);
/*  97 */       long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  98 */       InstanceManager.initInstanceBean(xInstanceBean, curTime);
/*     */     }
/* 100 */     SingleInstance xSingleInstance = (SingleInstance)xInstanceBean.getSingleinstancemap().get(Integer.valueOf(this.instancecfgid));
/* 101 */     if (xSingleInstance == null) {
/* 102 */       xSingleInstance = Pod.newSingleInstance();
/* 103 */       xInstanceBean.getSingleinstancemap().put(Integer.valueOf(this.instancecfgid), xSingleInstance);
/*     */     }
/* 105 */     if (xSingleInstance.getSign() == 0) {
/* 106 */       GameServer.logger().info(String.format("[Instance]PCChallengeSingleReq.processImp@挑战的副本已经关闭了|roleid=%d|instancecfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.instancecfgid) }));
/*     */       
/*     */ 
/* 109 */       return false;
/*     */     }
/* 111 */     int curProcess = xSingleInstance.getCurprocess();
/*     */     
/* 113 */     if (this.processid != curProcess) {
/* 114 */       GameServer.logger().info(String.format("[Instance]PCChallengeSingleReq.processImp@挑战的关卡不是当前的关卡!!!|roleid=%d|instanceid=%d|cur_process=%d|req_process=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.instancecfgid), Integer.valueOf(curProcess), Integer.valueOf(this.processid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 119 */       return false;
/*     */     }
/*     */     
/* 122 */     int loseTime = xInstanceBean.getSinglefailtime();
/* 123 */     if (loseTime >= SInstanceConsts.getInstance().SINGLE_INSTANCE_FAIL_TIMES) {
/* 124 */       GameServer.logger().info(String.format("[Instance]PCChallengeSingleReq.processImp@单人挑战的失败次数不足!!!!|roleid=%d|loseTime=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(loseTime) }));
/*     */       
/*     */ 
/* 127 */       return false;
/*     */     }
/* 129 */     SInstanceCfg instanceCfg = SInstanceCfg.get(this.instancecfgid);
/* 130 */     int finishTime = xSingleInstance.getFinishtimes();
/* 131 */     if (finishTime >= instanceCfg.finishTime) {
/* 132 */       GameServer.logger().info(String.format("[Instance]PCChallengeSingleReq.processImp@已经到达最大的通关次数了,不能在挑战了|roleid=%d|finishTime=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(finishTime) }));
/*     */       
/*     */ 
/*     */ 
/* 136 */       return false;
/*     */     }
/*     */     
/* 139 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 13, true)) {
/* 140 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 146 */     java.util.Set<Integer> mapSet = InstanceCfgManager.getMapsByInstanceid(this.instancecfgid);
/* 147 */     MapInterface.createWorld(mapSet, this);
/*     */     
/*     */ 
/* 150 */     long endTime = ActivityInterface.getActivityEndTime(SInstanceConsts.getInstance().SINGLE_INSTANCE_ACTIVITY_TYPE_ID);
/*     */     
/* 152 */     JoinSingleInstanceArg joinSingleInstanceArg = new JoinSingleInstanceArg(this.roleid, endTime, this.instancecfgid);
/* 153 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.instance.event.JoinSingleInstanceEvent(), joinSingleInstanceArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*     */     
/* 155 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean reCheckCanChallenge()
/*     */   {
/* 165 */     if (TeamInterface.isRoleInTeam(this.roleid, true)) {
/* 166 */       GameServer.logger().info(String.format("[Instance]PCChallengeSingleReq.processImp@玩家在队伍中不能够进入单人副本!!!|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/* 168 */       return false;
/*     */     }
/*     */     
/* 171 */     if (InstanceInterface.isRoleInInstance(this.roleid, true)) {
/* 172 */       GameServer.logger().info(String.format("[Instance]PCChallengeSingleReq.processImp@玩家在副本中!!!|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/* 174 */       return false;
/*     */     }
/* 176 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isCallInProcedure()
/*     */   {
/* 181 */     return true;
/*     */   }
/*     */   
/*     */   public boolean onResult(Long worldid)
/*     */   {
/* 186 */     if ((worldid == null) || (worldid.longValue() == -1L)) {
/* 187 */       GameServer.logger().error(String.format("[Instance]PCChallengeSingleReq.onResult@create world error|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/* 189 */       return false;
/*     */     }
/*     */     
/* 192 */     if (!reCheckCanChallenge()) {
/* 193 */       MapInterface.destroyWorld(worldid.longValue());
/* 194 */       return false;
/*     */     }
/*     */     
/* 197 */     if (!RoleStatusInterface.setStatus(this.roleid, 13, true)) {
/* 198 */       MapInterface.destroyWorld(worldid.longValue());
/* 199 */       return false;
/*     */     }
/*     */     
/* 202 */     InstanceCacheBean instanceCacheBean = Pod.newInstanceCacheBean();
/*     */     
/*     */ 
/* 205 */     long instanceUUId = xtable.Instance.insert(instanceCacheBean).longValue();
/*     */     
/* 207 */     instanceCacheBean.setInstancecfgid(this.instancecfgid);
/* 208 */     instanceCacheBean.setWorldid(worldid.longValue());
/* 209 */     instanceCacheBean.getRoleids().add(Long.valueOf(this.roleid));
/* 210 */     instanceCacheBean.setOpentime(DateTimeUtils.getCurrTimeInMillis());
/*     */     
/* 212 */     xtable.Role2instanceuuid.insert(Long.valueOf(this.roleid), Long.valueOf(instanceUUId));
/*     */     
/* 214 */     SingleInstanceData singleInstanceDataCfg = InstanceCfgManager.getSingleInstanceCfg(this.instancecfgid, this.processid);
/*     */     
/* 216 */     MapInterface.spawnVisibleMonster(worldid.longValue(), singleInstanceDataCfg.in_mapid, singleInstanceDataCfg.monsterid);
/* 217 */     if (this.processid == 1) {
/* 218 */       MapInterface.transferToScene(this.roleid, worldid.longValue(), singleInstanceDataCfg.in_mapid);
/*     */     } else {
/* 220 */       MapInterface.teleportToMonster(this.roleid, worldid.longValue(), singleInstanceDataCfg.in_mapid, singleInstanceDataCfg.monsterid);
/*     */     }
/*     */     
/* 223 */     TeamInterface.registerJoinTeam(worldid.longValue(), new SingleInstanceTeamCheck());
/*     */     
/*     */ 
/* 226 */     SEnterInstanceRes sEnterInstanceRes = new SEnterInstanceRes();
/* 227 */     sEnterInstanceRes.instancetype = 1;
/* 228 */     sEnterInstanceRes.instancecfgid = this.instancecfgid;
/* 229 */     OnlineManager.getInstance().send(this.roleid, sEnterInstanceRes);
/*     */     
/*     */ 
/* 232 */     InstanceManager.logInstance(this.roleid, instanceUUId, this.instancecfgid, 2, 0L, this.processid, 1);
/*     */     
/* 234 */     InstanceManager.tlogInstance(this.roleid, instanceUUId, this.instancecfgid, 2, 0L, this.processid);
/* 235 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\PCChallengeSingleReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */