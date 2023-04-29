/*      */ package mzm.gsp.instance.main;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.activity.main.ActivityInterface;
/*      */ import mzm.gsp.activitycompensate.main.ActivityCompensateInterface;
/*      */ import mzm.gsp.award.main.AwardInterface;
/*      */ import mzm.gsp.award.main.AwardReason;
/*      */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*      */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*      */ import mzm.gsp.chivalry.main.ChivalryInterface;
/*      */ import mzm.gsp.confirm.main.TeamConfirmInterface;
/*      */ import mzm.gsp.instance.SEnterInstanceRes;
/*      */ import mzm.gsp.instance.SLeaveInstanceRes;
/*      */ import mzm.gsp.instance.STeamInstanceCurProcess;
/*      */ import mzm.gsp.instance.STeamInstanceProcess;
/*      */ import mzm.gsp.instance.TeamInfo;
/*      */ import mzm.gsp.instance.confbean.OperaInstanceProcessCfg;
/*      */ import mzm.gsp.instance.confbean.SInstanceCfg;
/*      */ import mzm.gsp.instance.confbean.SInstanceConsts;
/*      */ import mzm.gsp.instance.confbean.SOperaInstanceCfg;
/*      */ import mzm.gsp.instance.event.FinishMultiInstance;
/*      */ import mzm.gsp.instance.event.FinishMultiInstanceArg;
/*      */ import mzm.gsp.instance.event.MultiInstanceProArg;
/*      */ import mzm.gsp.instance.event.MultiInstanceProEvent;
/*      */ import mzm.gsp.item.main.access.ItemAccessManager;
/*      */ import mzm.gsp.map.main.MapInterface;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.open.main.OpenInterface;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.role.main.RoleOneByOneManager;
/*      */ import mzm.gsp.status.main.RoleStatusInterface;
/*      */ import mzm.gsp.task.main.TaskInterface;
/*      */ import mzm.gsp.team.main.TeamInterface;
/*      */ import mzm.gsp.tlog.LogReason;
/*      */ import mzm.gsp.tlog.TLogArg;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.util.LogicProcedure;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.InstanceBean;
/*      */ import xbean.InstanceCacheBean;
/*      */ import xbean.Pod;
/*      */ import xdb.Procedure;
/*      */ import xtable.Instance;
/*      */ import xtable.Role2instance;
/*      */ import xtable.Role2instanceuuid;
/*      */ import xtable.Role2properties;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ class TeamInstance
/*      */ {
/*      */   static final int BEFORE_AWARD = 1;
/*      */   static final int AWARDING = 2;
/*      */   static final int AWARDED = 3;
/*      */   
/*      */   static boolean onleaveInstance(List<Long> roleids, long instanceUuid, InstanceCacheBean xInstanceCacheBean)
/*      */   {
/*   69 */     SInstanceCfg instanceCfg = SInstanceCfg.get(xInstanceCacheBean.getInstancecfgid());
/*   70 */     long worldid = xInstanceCacheBean.getWorldid();
/*   71 */     final SOperaInstanceCfg operaInstanceCfg = InstanceCfgManager.getOperaInstanceCfg(instanceCfg.id);
/*   72 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */       
/*   74 */       Role2instanceuuid.remove(Long.valueOf(roleid));
/*      */       
/*   76 */       TaskInterface.closeActivityGraphWithoutEvent(roleid, operaInstanceCfg.taskGraph);
/*   77 */       MapInterface.forceTransferToScene(roleid, instanceCfg.out_mapid, instanceCfg.out_x, instanceCfg.out_y);
/*      */     }
/*   79 */     RoleStatusInterface.unsetStatus(roleids, 14);
/*      */     
/*   81 */     final long passtime = (DateTimeUtils.getCurrTimeInMillis() - xInstanceCacheBean.getOpentime()) / 1000L;
/*   82 */     Integer teamInstanceProcess = (Integer)xInstanceCacheBean.getExtra().get(Integer.valueOf(InstanceExtra.TEAM_INSTANCE_PROCESS.ordinal()));
/*   83 */     if (teamInstanceProcess == null) {
/*   84 */       teamInstanceProcess = Integer.valueOf(0);
/*   85 */       GameServer.logger().error("队伍中的进度数值不存在,不应该出现的情况teamInstance,instanceCfgid:" + instanceCfg.id);
/*      */     }
/*   87 */     final int teamProcess = teamInstanceProcess.intValue();
/*   88 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*   89 */       InstanceManager.logInstance(roleid, instanceUuid, xInstanceCacheBean.getInstancecfgid(), 4, passtime, teamProcess, 2);
/*      */       
/*   91 */       InstanceManager.tlogInstance(roleid, instanceUuid, xInstanceCacheBean.getInstancecfgid(), 4, passtime, teamProcess);
/*      */     }
/*      */     
/*   94 */     xInstanceCacheBean.getRoleids().removeAll(roleids);
/*      */     
/*   96 */     for (Iterator i$ = xInstanceCacheBean.getRoleids().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*   97 */       Procedure.execute(new LogicProcedure()
/*      */       {
/*      */         protected boolean processImp()
/*      */           throws Exception
/*      */         {
/*  102 */           Long newInstanceUuid = Role2instanceuuid.get(Long.valueOf(this.val$roleid));
/*  103 */           if ((newInstanceUuid == null) || (newInstanceUuid.longValue() != operaInstanceCfg))
/*      */           {
/*  105 */             return false;
/*      */           }
/*  107 */           Role2instanceuuid.remove(Long.valueOf(this.val$roleid));
/*  108 */           RoleStatusInterface.unsetStatus(this.val$roleid, 14);
/*  109 */           TaskInterface.closeActivityGraphWithoutEvent(this.val$roleid, passtime.taskGraph);
/*  110 */           MapInterface.forceTransferToScene(this.val$roleid, teamProcess.out_mapid, teamProcess.out_x, teamProcess.out_y);
/*      */           
/*  112 */           InstanceManager.logInstance(this.val$roleid, operaInstanceCfg, teamProcess.id, 4, this.val$passtime, this.val$teamProcess, 2);
/*      */           
/*  114 */           InstanceManager.tlogInstance(this.val$roleid, operaInstanceCfg, teamProcess.id, 4, this.val$passtime, this.val$teamProcess);
/*      */           
/*  116 */           return true;
/*      */         }
/*      */       });
/*      */     }
/*      */     
/*  121 */     Instance.remove(Long.valueOf(instanceUuid));
/*  122 */     MapInterface.destroyWorld(worldid);
/*      */     
/*  124 */     TeamInterface.unRegisterJoinTeam(worldid);
/*      */     
/*      */ 
/*  127 */     SLeaveInstanceRes leaveInstanceRes = new SLeaveInstanceRes();
/*  128 */     leaveInstanceRes.instancetype = instanceCfg.instanceType;
/*  129 */     leaveInstanceRes.instancecfgid = instanceCfg.id;
/*  130 */     OnlineManager.getInstance().sendMulti(leaveInstanceRes, roleids);
/*  131 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onLeaveTeam(long roleid, long instanceUuid, InstanceCacheBean xInstanceCacheBean)
/*      */   {
/*  143 */     if (xInstanceCacheBean != null) {
/*  144 */       onMemLeave(roleid, instanceUuid, xInstanceCacheBean);
/*  145 */       return;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onMemLeave(long roleid, final long instanceUuid, InstanceCacheBean xInstanceCacheBean)
/*      */   {
/*  157 */     Role2instanceuuid.remove(Long.valueOf(roleid));
/*  158 */     RoleStatusInterface.unsetStatus(roleid, 14);
/*      */     
/*  160 */     xInstanceCacheBean.getRoleids().remove(Long.valueOf(roleid));
/*  161 */     SInstanceCfg instanceCfg = SInstanceCfg.get(xInstanceCacheBean.getInstancecfgid());
/*  162 */     MapInterface.forceTransferToScene(roleid, instanceCfg.out_mapid, instanceCfg.out_x, instanceCfg.out_y);
/*  163 */     if (xInstanceCacheBean.getRoleids().size() == 0) {
/*  164 */       MapInterface.destroyWorld(xInstanceCacheBean.getWorldid());
/*      */     } else {
/*  166 */       List<Long> allRoles = new ArrayList();
/*  167 */       allRoles.addAll(xInstanceCacheBean.getRoleids());
/*  168 */       Procedure.execute(new LogicProcedure()
/*      */       {
/*      */ 
/*      */         protected boolean processImp()
/*      */           throws Exception
/*      */         {
/*  174 */           lock(Role2properties.getTable(), this.val$allRoles);
/*  175 */           for (Iterator i$ = this.val$allRoles.iterator(); i$.hasNext();) { long cacheRoleid = ((Long)i$.next()).longValue();
/*  176 */             if (OnlineManager.getInstance().isOnline(cacheRoleid)) {
/*  177 */               return false;
/*      */             }
/*      */           }
/*      */           
/*      */ 
/*  182 */           InstanceCacheBean xInstanceCacheBean = Instance.get(Long.valueOf(instanceUuid));
/*  183 */           if (xInstanceCacheBean == null) {
/*  184 */             return false;
/*      */           }
/*  186 */           return TeamInstance.onleaveInstance(this.val$allRoles, instanceUuid, xInstanceCacheBean);
/*      */         }
/*      */       });
/*      */     }
/*      */     
/*      */ 
/*  192 */     SLeaveInstanceRes leaveInstanceRes = new SLeaveInstanceRes();
/*  193 */     leaveInstanceRes.instancetype = instanceCfg.instanceType;
/*  194 */     leaveInstanceRes.instancecfgid = instanceCfg.id;
/*  195 */     OnlineManager.getInstance().send(roleid, leaveInstanceRes);
/*  196 */     long passtime = (DateTimeUtils.getCurrTimeInMillis() - xInstanceCacheBean.getOpentime()) / 1000L;
/*  197 */     Integer teamProcess = (Integer)xInstanceCacheBean.getExtra().get(Integer.valueOf(InstanceExtra.TEAM_INSTANCE_PROCESS.ordinal()));
/*  198 */     if (teamProcess == null) {
/*  199 */       teamProcess = Integer.valueOf(0);
/*  200 */       GameServer.logger().error("队伍中的进度数值不存在,不应该出现的情况teamInstance,instanceCfgid:" + instanceCfg.id);
/*      */     }
/*  202 */     InstanceManager.logInstance(roleid, instanceUuid, xInstanceCacheBean.getInstancecfgid(), 4, passtime, teamProcess.intValue(), 2);
/*      */     
/*  204 */     InstanceManager.tlogInstance(roleid, instanceUuid, xInstanceCacheBean.getInstancecfgid(), 4, passtime, teamProcess.intValue());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean canTransfer(long roleId, int mapId, int sceneId, int targetMapId, int targetSceneId, int instancecfgid)
/*      */   {
/*  223 */     if (TeamInterface.isRoleInTeam(roleId, false)) {
/*  224 */       int teamStatus = TeamInterface.getTeamMemberStatus(roleId);
/*  225 */       if ((teamStatus != 0) && 
/*  226 */         (OnlineManager.getInstance().isOnline(roleId))) {
/*  227 */         return false;
/*      */       }
/*      */     }
/*      */     
/*  231 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getRoleInstanceProcess(int instanceid, InstanceBean xInstanceBean)
/*      */   {
/*  243 */     int process = 0;
/*  244 */     if (xInstanceBean != null) {
/*  245 */       xbean.TeamInstance teamInstance = (xbean.TeamInstance)xInstanceBean.getTeaminstancemap().get(Integer.valueOf(instanceid));
/*  246 */       if (teamInstance != null) {
/*  247 */         process = teamInstance.getToprocess();
/*      */       }
/*      */     }
/*  250 */     return process;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean canEnterInstance(int instanceid, List<Long> roleids)
/*      */   {
/*  261 */     EnterInstanceResult enterInstanceResult = InstanceManager.canEnterInstance(roleids, instanceid);
/*  262 */     if (!enterInstanceResult.canJoin) {
/*  263 */       if (enterInstanceResult.isPerSonCountWrong()) {
/*  264 */         InstanceManager.sendNormalRet(roleids, 1, new String[0]);
/*  265 */       } else if (enterInstanceResult.isItemNotEnough()) {
/*  266 */         InstanceManager.sendNormalRet(roleids, 5, new String[] { SInstanceCfg.get(instanceid).itemid + "" });
/*      */       }
/*  268 */       else if (enterInstanceResult.isRoleLevelWrong()) {
/*  269 */         String rolename = RoleInterface.getName(enterInstanceResult.getRoleid());
/*  270 */         InstanceManager.sendNormalRet(roleids, 2, new String[] { rolename });
/*      */       }
/*  272 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  276 */     long teamLeaderId = ((Long)roleids.get(0)).longValue();
/*  277 */     int teamLeaderLevel = RoleInterface.getLevel(teamLeaderId);
/*  278 */     SInstanceCfg instanceCfg = SInstanceCfg.get(instanceid);
/*  279 */     if ((instanceCfg.closeLevel > 0) && (instanceCfg.closeLevel < teamLeaderLevel)) {
/*  280 */       if (GameServer.logger().isDebugEnabled()) {
/*  281 */         GameServer.logger().debug(String.format("[Instance]TeamInstance.canEnterInstance@leader is over instance closelevel|instancecfgid=%d|roleid=%d", new Object[] { Integer.valueOf(instanceCfg.id), Long.valueOf(teamLeaderId) }));
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  288 */       return false;
/*      */     }
/*      */     
/*  291 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long memberid = ((Long)i$.next()).longValue();
/*  292 */       int teamStatus = TeamInterface.getTeamMemberStatus(memberid);
/*  293 */       if (teamStatus != 0) {
/*  294 */         String roleName = RoleInterface.getName(memberid);
/*  295 */         if (teamStatus == 2) {
/*  296 */           InstanceManager.sendNormalRet(((Long)roleids.get(0)).longValue(), 6, new String[] { roleName });
/*      */         }
/*      */         else {
/*  299 */           InstanceManager.sendNormalRet(((Long)roleids.get(0)).longValue(), 3, new String[] { roleName });
/*      */         }
/*  301 */         return false;
/*      */       }
/*      */     }
/*  304 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean enterInstance(List<Long> roleids, int instanceid, long instanceUuid, InstanceCacheBean xInstanceCacheBean, long worldid)
/*      */   {
/*  318 */     long teamLeaderid = ((Long)roleids.get(0)).longValue();
/*      */     
/*  320 */     InstanceBean xInstanceBean = Role2instance.get(Long.valueOf(teamLeaderid));
/*  321 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  322 */     if (xInstanceBean == null) {
/*  323 */       xInstanceBean = Pod.newInstanceBean();
/*  324 */       Role2instance.insert(Long.valueOf(teamLeaderid), xInstanceBean);
/*  325 */       InstanceManager.initInstanceBean(xInstanceBean, curTime);
/*      */     }
/*  327 */     xbean.TeamInstance xTeamInstance = (xbean.TeamInstance)xInstanceBean.getTeaminstancemap().get(Integer.valueOf(instanceid));
/*  328 */     if (xTeamInstance == null) {
/*  329 */       xTeamInstance = Pod.newTeamInstance();
/*  330 */       xInstanceBean.getTeaminstancemap().put(Integer.valueOf(instanceid), xTeamInstance);
/*      */     }
/*  332 */     if (xTeamInstance.getSign() == 0) {
/*  333 */       if (GameServer.logger().isDebugEnabled())
/*  334 */         GameServer.logger().debug("队伍副本已经关闭了,instancecfgid:" + instanceid);
/*  335 */       return false;
/*      */     }
/*  337 */     int processid = xTeamInstance.getToprocess();
/*      */     
/*  339 */     OperaInstanceProcessCfg operaInstanceProcessCfg2 = InstanceCfgManager.getOperaInstanceProcessCfg(instanceid, processid + 1);
/*      */     
/*  341 */     if (operaInstanceProcessCfg2 == null) {
/*  342 */       GameServer.logger().info(String.format("[Instance]TeamInstance.enterInstance@leader is finished|instancecfgid=%d|processid=%d|roleid=%d", new Object[] { Integer.valueOf(instanceid), Integer.valueOf(processid), Long.valueOf(teamLeaderid) }));
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*  347 */       return false;
/*      */     }
/*      */     
/*  350 */     if (!RoleStatusInterface.setStatus(roleids, 14, true)) {
/*  351 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  355 */     if (processid <= 0) {
/*  356 */       processid = 1;
/*  357 */       xTeamInstance.setToprocess(processid);
/*  358 */       STeamInstanceProcess teamInstanceProcess = new STeamInstanceProcess();
/*  359 */       fillInTeamInfo(teamInstanceProcess.teaminstanceinfo, processid, instanceid, xTeamInstance.getSign());
/*  360 */       OnlineManager.getInstance().send(teamLeaderid, teamInstanceProcess);
/*      */     }
/*      */     
/*      */ 
/*  364 */     OperaInstanceProcessCfg processCfg = InstanceCfgManager.getOperaInstanceProcessCfg(instanceid, processid);
/*  365 */     SOperaInstanceCfg operaInstanceCfg = InstanceCfgManager.getOperaInstanceCfg(instanceid);
/*      */     
/*  367 */     xInstanceCacheBean.setInstancecfgid(instanceid);
/*  368 */     xInstanceCacheBean.setWorldid(worldid);
/*  369 */     xInstanceCacheBean.setOpentime(DateTimeUtils.getCurrTimeInMillis());
/*  370 */     xInstanceCacheBean.getRoleids().addAll(roleids);
/*  371 */     xInstanceCacheBean.getExtra().put(Integer.valueOf(InstanceExtra.TEAM_INSTANCE_PROCESS.ordinal()), Integer.valueOf(processid));
/*      */     
/*      */ 
/*  374 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */       
/*      */ 
/*  377 */       Role2instanceuuid.insert(Long.valueOf(roleid), Long.valueOf(instanceUuid));
/*      */       
/*  379 */       if (roleid != teamLeaderid)
/*      */       {
/*      */ 
/*  382 */         boolean needSyn = false;
/*  383 */         InstanceBean xMemberInstanceBean = Role2instance.get(Long.valueOf(roleid));
/*  384 */         if (xMemberInstanceBean == null) {
/*  385 */           xMemberInstanceBean = Pod.newInstanceBean();
/*  386 */           Role2instance.insert(Long.valueOf(roleid), xMemberInstanceBean);
/*      */         }
/*  388 */         xbean.TeamInstance xMemberTeamInstance = (xbean.TeamInstance)xMemberInstanceBean.getTeaminstancemap().get(Integer.valueOf(instanceid));
/*  389 */         if (xMemberTeamInstance == null) {
/*  390 */           needSyn = true;
/*  391 */           xMemberTeamInstance = Pod.newTeamInstance();
/*  392 */           xMemberInstanceBean.getTeaminstancemap().put(Integer.valueOf(instanceid), xMemberTeamInstance);
/*      */         }
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  401 */         int memProcess = xMemberTeamInstance.getToprocess();
/*  402 */         if (memProcess < processid) {
/*  403 */           needSyn = true;
/*  404 */           xMemberTeamInstance.setToprocess(processid);
/*      */         }
/*  406 */         if (needSyn) {
/*  407 */           STeamInstanceProcess teamInstanceProcess = new STeamInstanceProcess();
/*  408 */           fillInTeamInfo(teamInstanceProcess.teaminstanceinfo, xMemberTeamInstance.getToprocess(), instanceid, xTeamInstance.getSign());
/*      */           
/*  410 */           OnlineManager.getInstance().send(roleid, teamInstanceProcess);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  415 */     TaskInterface.acceptGraphXTask(teamLeaderid, operaInstanceCfg.taskGraph, processCfg.opentaskid);
/*      */     
/*  417 */     MapInterface.transferToScene(teamLeaderid, worldid, processCfg.in_mapid);
/*      */     try
/*      */     {
/*  420 */       TeamInterface.registerJoinTeam(worldid, new TeamInstanceTeamCheck());
/*      */     } catch (Exception e) {
/*  422 */       GameServer.logger().error("注册队伍检查出错!!", e);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  428 */     SEnterInstanceRes sEnterInstanceRes = new SEnterInstanceRes();
/*  429 */     sEnterInstanceRes.instancetype = 2;
/*  430 */     sEnterInstanceRes.instancecfgid = instanceid;
/*  431 */     OnlineManager.getInstance().sendMulti(sEnterInstanceRes, roleids);
/*      */     
/*  433 */     STeamInstanceCurProcess synTeamInstanceCurProcess = new STeamInstanceCurProcess();
/*  434 */     synTeamInstanceCurProcess.curprocess = processid;
/*  435 */     OnlineManager.getInstance().sendMulti(synTeamInstanceCurProcess, roleids);
/*      */     
/*  437 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  438 */       InstanceManager.logInstance(roleid, instanceUuid, instanceid, 2, 0L, processid, 2);
/*      */       
/*  440 */       InstanceManager.tlogInstance(roleid, instanceUuid, instanceid, 2, 0L, processid);
/*      */     }
/*      */     
/*  443 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean onTeamRoleToNormal(long changeNormalRoleid, long instanceUuid, InstanceCacheBean xInstanceCacheBean, InstanceBean xInstanceBean)
/*      */   {
/*  459 */     Integer processid = (Integer)xInstanceCacheBean.getExtra().get(Integer.valueOf(InstanceExtra.TEAM_INSTANCE_PROCESS.ordinal()));
/*  460 */     if (processid == null) {
/*  461 */       GameServer.logger().error("缓存的副本数据中没有对象的进度信息!!");
/*  462 */       return false;
/*      */     }
/*  464 */     xbean.TeamInstance teamInstance = (xbean.TeamInstance)xInstanceBean.getTeaminstancemap().get(Integer.valueOf(xInstanceCacheBean.getInstancecfgid()));
/*  465 */     if (teamInstance.getToprocess() < processid.intValue()) {
/*  466 */       teamInstance.setToprocess(processid.intValue());
/*      */     }
/*  468 */     STeamInstanceProcess teamInstanceProcess = new STeamInstanceProcess();
/*  469 */     fillInTeamInfo(teamInstanceProcess.teaminstanceinfo, teamInstance.getToprocess(), xInstanceCacheBean.getInstancecfgid(), teamInstance.getSign());
/*      */     
/*  471 */     OnlineManager.getInstance().send(changeNormalRoleid, teamInstanceProcess);
/*      */     
/*  473 */     STeamInstanceCurProcess teamInstanceCurProcess = new STeamInstanceCurProcess();
/*  474 */     teamInstanceCurProcess.curprocess = processid.intValue();
/*  475 */     OnlineManager.getInstance().send(changeNormalRoleid, teamInstanceCurProcess);
/*  476 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean onTaskFinish(int graphid, int taskid, String userid, long roleid, int instanceid, long instanceUuid, InstanceCacheBean xInstanceCacheBean, InstanceBean xInstanceBean)
/*      */   {
/*  494 */     xbean.TeamInstance xTeamInstance = (xbean.TeamInstance)xInstanceBean.getTeaminstancemap().get(Integer.valueOf(instanceid));
/*  495 */     int oriProcess = xTeamInstance.getToprocess();
/*      */     
/*  497 */     int curProcess = xTeamInstance.getToprocess();
/*  498 */     int size = InstanceCfgManager.getOperaInstanceProcessSize(instanceid);
/*  499 */     for (int i = 0; i <= size; i++) {
/*  500 */       OperaInstanceProcessCfg operaInstanceProcessCfg = InstanceCfgManager.getOperaInstanceProcessCfg(instanceid, curProcess + i);
/*      */       
/*  502 */       if (operaInstanceProcessCfg == null) {
/*      */         break;
/*      */       }
/*  505 */       if (operaInstanceProcessCfg.taskid == taskid) {
/*  506 */         curProcess += i;
/*  507 */         break;
/*      */       }
/*      */     }
/*  510 */     OperaInstanceProcessCfg operaInstanceProcessCfg = InstanceCfgManager.getOperaInstanceProcessCfg(instanceid, curProcess);
/*      */     
/*  512 */     SOperaInstanceCfg operaInstanceCfg = InstanceCfgManager.getOperaInstanceCfg(instanceid);
/*  513 */     if (curProcess <= 0) {
/*  514 */       return false;
/*      */     }
/*      */     
/*  517 */     int roleLevel = RoleInterface.getLevel(roleid);
/*  518 */     SInstanceCfg instanceCfg = SInstanceCfg.get(instanceid);
/*  519 */     if (operaInstanceProcessCfg.taskid == taskid) {
/*  520 */       AwardReason awardReason = new AwardReason(LogReason.INSTANCE_MULTI_AWARD_ADD, instanceid);
/*      */       
/*  522 */       if ((instanceCfg.closeLevel <= 0) || (instanceCfg.closeLevel >= roleLevel)) {
/*  523 */         AwardInterface.award(operaInstanceProcessCfg.awardid, userid, roleid, false, true, awardReason);
/*      */       } else {
/*  525 */         addChivalry(instanceid, roleid);
/*      */       }
/*      */       
/*  528 */       int nextProcessid = curProcess + 1;
/*  529 */       OperaInstanceProcessCfg operaInstanceProcessCfg2 = InstanceCfgManager.getOperaInstanceProcessCfg(instanceid, nextProcessid);
/*      */       
/*  531 */       if ((operaInstanceProcessCfg2 == null) || (operaInstanceProcessCfg2.taskid <= 0)) {
/*  532 */         TriggerEventsManger.getInstance().triggerEvent(new FinishMultiInstance(), new FinishMultiInstanceArg(roleid, InstanceCfgManager.getOperaInstanceCfg(instanceid).disType, true), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleid)));
/*      */         
/*      */ 
/*  535 */         ActivityInterface.addActivityCount(userid, roleid, operaInstanceCfg.activityid);
/*  536 */         if (!ActivityInterface.isToMaxCount(userid, roleid, operaInstanceCfg.activityid)) {
/*  537 */           xTeamInstance.setToprocess(0);
/*      */         }
/*  539 */         else if (operaInstanceProcessCfg2 != null) {
/*  540 */           xTeamInstance.setToprocess(nextProcessid);
/*      */         }
/*  542 */         int awradKey = InstanceExtra.TEAM_INSTANCE_AWARD_STATUS.ordinal();
/*      */         
/*  544 */         if (!xInstanceCacheBean.getExtra().containsKey(Integer.valueOf(awradKey))) {
/*  545 */           xInstanceCacheBean.getExtra().put(Integer.valueOf(awradKey), Integer.valueOf(1));
/*  546 */           TeamSucAwardSessionManager.addSession(instanceUuid);
/*      */         }
/*      */         
/*      */ 
/*  550 */         if ((instanceCfg.closeLevel <= 0) || (instanceCfg.closeLevel >= roleLevel)) {
/*  551 */           xInstanceCacheBean.getSucroleids().add(Long.valueOf(roleid));
/*      */         }
/*  553 */         xInstanceCacheBean.getFinishroleids().add(Long.valueOf(roleid));
/*  554 */         checkAwardAllSucReward(instanceid, instanceUuid, xInstanceCacheBean);
/*      */         
/*  556 */         STeamInstanceProcess teamInstanceProcess = new STeamInstanceProcess();
/*  557 */         fillInTeamInfo(teamInstanceProcess.teaminstanceinfo, xTeamInstance.getToprocess(), instanceid, xTeamInstance.getSign());
/*      */         
/*  559 */         OnlineManager.getInstance().send(roleid, teamInstanceProcess);
/*      */         
/*      */ 
/*  562 */         Integer cacheProcess = (Integer)xInstanceCacheBean.getExtra().get(Integer.valueOf(InstanceExtra.TEAM_INSTANCE_PROCESS.ordinal()));
/*  563 */         if (((cacheProcess == null) || (cacheProcess.intValue() < nextProcessid)) && 
/*  564 */           (operaInstanceProcessCfg2 != null)) {
/*  565 */           xInstanceCacheBean.getExtra().put(Integer.valueOf(InstanceExtra.TEAM_INSTANCE_PROCESS.ordinal()), Integer.valueOf(nextProcessid));
/*  566 */           STeamInstanceCurProcess sTeamInstanceCurProcess = new STeamInstanceCurProcess();
/*  567 */           sTeamInstanceCurProcess.curprocess = nextProcessid;
/*  568 */           OnlineManager.getInstance().sendMulti(sTeamInstanceCurProcess, TeamInterface.getNormalRoleList(roleid));
/*      */         }
/*      */         
/*      */       }
/*      */       else
/*      */       {
/*  574 */         xTeamInstance.setToprocess(nextProcessid);
/*  575 */         Integer cacheProcess = (Integer)xInstanceCacheBean.getExtra().get(Integer.valueOf(InstanceExtra.TEAM_INSTANCE_PROCESS.ordinal()));
/*  576 */         if ((cacheProcess == null) || (cacheProcess.intValue() < nextProcessid)) {
/*  577 */           xInstanceCacheBean.getExtra().put(Integer.valueOf(InstanceExtra.TEAM_INSTANCE_PROCESS.ordinal()), Integer.valueOf(nextProcessid));
/*      */           
/*  579 */           STeamInstanceCurProcess sTeamInstanceCurProcess = new STeamInstanceCurProcess();
/*  580 */           sTeamInstanceCurProcess.curprocess = nextProcessid;
/*  581 */           OnlineManager.getInstance().sendMulti(sTeamInstanceCurProcess, TeamInterface.getNormalRoleList(roleid));
/*      */         }
/*      */         
/*      */ 
/*  585 */         STeamInstanceProcess teamInstanceProcess = new STeamInstanceProcess();
/*  586 */         fillInTeamInfo(teamInstanceProcess.teaminstanceinfo, nextProcessid, instanceid, xTeamInstance.getSign());
/*  587 */         OnlineManager.getInstance().send(roleid, teamInstanceProcess);
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*  592 */       long passtime = (DateTimeUtils.getCurrTimeInMillis() - xInstanceCacheBean.getOpentime()) / 1000L;
/*  593 */       InstanceManager.logInstance(roleid, instanceUuid, instanceid, 3, passtime, curProcess, 2);
/*      */       
/*  595 */       InstanceManager.tlogInstance(roleid, instanceUuid, instanceid, 3, passtime, curProcess);
/*      */       
/*      */ 
/*      */ 
/*  599 */       MultiInstanceProArg multiInstanceProArg = new MultiInstanceProArg(roleid, instanceid, curProcess, true);
/*  600 */       TriggerEventsManger.getInstance().triggerEvent(new MultiInstanceProEvent(), multiInstanceProArg);
/*      */     }
/*      */     else
/*      */     {
/*  604 */       boolean isFinished = false;
/*  605 */       int beforeFinishPro = -1;
/*  606 */       for (int i = oriProcess - 1; i >= 0; i--) {
/*  607 */         OperaInstanceProcessCfg orInstanceProcessCfg = InstanceCfgManager.getOperaInstanceProcessCfg(instanceid, i);
/*      */         
/*  609 */         if (orInstanceProcessCfg == null) {
/*      */           break;
/*      */         }
/*  612 */         if (orInstanceProcessCfg.taskid == taskid) {
/*  613 */           isFinished = true;
/*  614 */           beforeFinishPro = i;
/*  615 */           break;
/*      */         }
/*      */       }
/*  618 */       if (isFinished) {
/*  619 */         addChivalry(instanceid, roleid);
/*      */         
/*  621 */         OperaInstanceProcessCfg nextInstanceProcessCfg = InstanceCfgManager.getOperaInstanceProcessCfg(instanceid, beforeFinishPro + 1);
/*      */         
/*  623 */         if ((nextInstanceProcessCfg == null) || (nextInstanceProcessCfg.taskid <= 0)) {
/*  624 */           xInstanceCacheBean.getFinishroleids().add(Long.valueOf(roleid));
/*  625 */           checkAwardAllSucReward(instanceid, instanceUuid, xInstanceCacheBean);
/*  626 */           TriggerEventsManger.getInstance().triggerEvent(new FinishMultiInstance(), new FinishMultiInstanceArg(roleid, InstanceCfgManager.getOperaInstanceCfg(instanceid).disType, false), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleid)));
/*      */         }
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*  632 */         MultiInstanceProArg multiInstanceProArg = new MultiInstanceProArg(roleid, instanceid, beforeFinishPro, false);
/*      */         
/*  634 */         TriggerEventsManger.getInstance().triggerEvent(new MultiInstanceProEvent(), multiInstanceProArg);
/*      */       }
/*      */     }
/*      */     
/*  638 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void addChivalry(int instanceid, long roleid)
/*      */   {
/*  649 */     SOperaInstanceCfg operaInstanceCfg = InstanceCfgManager.getOperaInstanceCfg(instanceid);
/*  650 */     switch (operaInstanceCfg.disType) {
/*      */     case 1: 
/*  652 */       ChivalryInterface.addRoleChivalry(roleid, SInstanceConsts.getInstance().INSTANCE_HERO_VALUE, 4, new TLogArg(LogReason.INSTANCE_MULTI_HLEPED, instanceid), true);
/*      */       
/*  654 */       break;
/*      */     case 2: 
/*  656 */       ChivalryInterface.addRoleChivalry(roleid, SInstanceConsts.getInstance().INSTANCE_HERO_VALUE, 5, new TLogArg(LogReason.INSTANCE_MULTI_HLEPED, instanceid), true);
/*      */       
/*  658 */       break;
/*      */     case 3: 
/*  660 */       ChivalryInterface.addRoleChivalry(roleid, SInstanceConsts.getInstance().INSTANCE_HERO_VALUE, 9, new TLogArg(LogReason.INSTANCE_MULTI_HLEPED, instanceid), true);
/*      */       
/*  662 */       break;
/*      */     case 4: 
/*  664 */       ChivalryInterface.addRoleChivalry(roleid, SInstanceConsts.getInstance().INSTANCE_HERO_VALUE, 10, new TLogArg(LogReason.INSTANCE_MULTI_HLEPED, instanceid), true);
/*      */       
/*      */ 
/*      */ 
/*  668 */       break;
/*      */     case 5: 
/*  670 */       ChivalryInterface.addRoleChivalry(roleid, SInstanceConsts.getInstance().INSTANCE_HERO_VALUE, 11, new TLogArg(LogReason.INSTANCE_MULTI_HLEPED, instanceid), true);
/*      */       
/*  672 */       break;
/*      */     }
/*      */     
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void checkAwardAllSucReward(int instanceid, long instanceUuid, InstanceCacheBean instanceCacheBean)
/*      */   {
/*  687 */     int awradKey = InstanceExtra.TEAM_INSTANCE_AWARD_STATUS.ordinal();
/*  688 */     if (instanceCacheBean.getFinishroleids().containsAll(instanceCacheBean.getRoleids())) {
/*  689 */       Integer awardState = (Integer)instanceCacheBean.getExtra().get(Integer.valueOf(awradKey));
/*  690 */       if ((awardState != null) && (awardState.intValue() < 2)) {
/*  691 */         instanceCacheBean.getExtra().put(Integer.valueOf(awradKey), Integer.valueOf(2));
/*  692 */         awardAllSucReward(instanceUuid, instanceid, new ArrayList(instanceCacheBean.getSucroleids()));
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   boolean onGraphFinish(int graphid, long roleid, int instanceid)
/*      */   {
/*  705 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void awardAllSucReward(final long instanceUuid, int instanceCfgId, final List<Long> roleids)
/*      */   {
/*  718 */     Procedure.execute(new LogicProcedure()
/*      */     {
/*      */       protected boolean processImp() throws Exception
/*      */       {
/*  722 */         SOperaInstanceCfg operaInstanceCfg = InstanceCfgManager.getOperaInstanceCfg(this.val$instanceCfgId);
/*  723 */         int totalLevel = 0;
/*  724 */         for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long tempRoleid = ((Long)i$.next()).longValue();
/*      */           
/*  726 */           totalLevel += RoleInterface.getLevel(tempRoleid);
/*      */         }
/*  728 */         int size = roleids.size();
/*  729 */         if (size > 0) {
/*  730 */           totalLevel /= size;
/*      */         }
/*  732 */         AwardPoolResultData awardPoolResultData = AwardPoolInterface.getAwardPoolData(operaInstanceCfg.awardpoolid, totalLevel);
/*      */         
/*  734 */         List<Integer> itemids = new ArrayList();
/*  735 */         for (Map.Entry<Integer, Integer> itemMap : awardPoolResultData.getItemMap().entrySet()) {
/*  736 */           int itemid = ((Integer)itemMap.getKey()).intValue();
/*  737 */           int itemValue = ((Integer)itemMap.getValue()).intValue();
/*  738 */           for (int i = 0; i < itemValue; i++) {
/*  739 */             itemids.add(Integer.valueOf(itemid));
/*      */           }
/*      */         }
/*  742 */         if (itemids.size() <= 0) {
/*  743 */           GameServer.logger().error("instancecfgid:" + this.val$instanceCfgId + ",副本没有随机到副本的通关奖励道具!!");
/*      */         }
/*      */         
/*  746 */         lock(Role2properties.getTable(), roleids);
/*  747 */         BoxAwardManager.getInstance().awardItems(roleids, itemids, new TeamAwardContext(instanceUuid, this.val$instanceCfgId));
/*      */         
/*  749 */         return true;
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean onRoleTransferScene(List<Long> roleids, long newWorldId, int newMapCfgid, long oldWorldid, int oldMapCfgid, long instanceUuid, InstanceCacheBean instanceCacheBean)
/*      */   {
/*  768 */     if (oldWorldid == instanceCacheBean.getWorldid()) {
/*  769 */       onleaveInstance(roleids, instanceUuid, instanceCacheBean);
/*      */     }
/*  771 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean onNormalUpdate(long roleid, InstanceBean instanceBean)
/*      */   {
/*  781 */     if (instanceBean == null) {
/*  782 */       return false;
/*      */     }
/*  784 */     int roleLevel = RoleInterface.getLevel(roleid);
/*  785 */     for (Map.Entry<Integer, xbean.TeamInstance> entry : instanceBean.getTeaminstancemap().entrySet()) {
/*  786 */       int instancecfgid = ((Integer)entry.getKey()).intValue();
/*  787 */       SOperaInstanceCfg sOperaInstanceCfg = InstanceCfgManager.getOperaInstanceCfg(instancecfgid);
/*  788 */       if ((sOperaInstanceCfg != null) && (sOperaInstanceCfg.disType == 1))
/*      */       {
/*      */ 
/*  791 */         SInstanceCfg sInstanceCfg = SInstanceCfg.get(instancecfgid);
/*  792 */         if (sInstanceCfg != null) {
/*  793 */           if ((sInstanceCfg.closeLevel > 0) && (sInstanceCfg.closeLevel < roleLevel)) {
/*  794 */             ((xbean.TeamInstance)entry.getValue()).setSign(0);
/*  795 */           } else if (sInstanceCfg.level <= roleLevel) {
/*  796 */             ((xbean.TeamInstance)entry.getValue()).setSign(1);
/*      */           }
/*      */         }
/*  799 */         ((xbean.TeamInstance)entry.getValue()).setToprocess(0);
/*      */       } }
/*  801 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean onTeamInstanceUpdate(long roleid, xbean.TeamInstance xTeamInstance, int instancecfgid)
/*      */   {
/*  813 */     if (xTeamInstance == null) {
/*  814 */       return false;
/*      */     }
/*  816 */     int roleLevel = RoleInterface.getLevel(roleid);
/*  817 */     SInstanceCfg sInstanceCfg = SInstanceCfg.get(instancecfgid);
/*  818 */     if (sInstanceCfg != null) {
/*  819 */       if ((sInstanceCfg.closeLevel > 0) && (sInstanceCfg.closeLevel < roleLevel)) {
/*  820 */         xTeamInstance.setSign(0);
/*  821 */       } else if (sInstanceCfg.level <= roleLevel) {
/*  822 */         xTeamInstance.setSign(1);
/*      */       }
/*      */     }
/*  825 */     xTeamInstance.setToprocess(0);
/*  826 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean onMasterUpdate(long roleid, InstanceBean instanceBean)
/*      */   {
/*  836 */     if (instanceBean == null) {
/*  837 */       return false;
/*      */     }
/*  839 */     int roleLevel = RoleInterface.getLevel(roleid);
/*  840 */     for (Map.Entry<Integer, xbean.TeamInstance> entry : instanceBean.getTeaminstancemap().entrySet()) {
/*  841 */       int instancecfgid = ((Integer)entry.getKey()).intValue();
/*  842 */       SOperaInstanceCfg sOperaInstanceCfg = InstanceCfgManager.getOperaInstanceCfg(instancecfgid);
/*  843 */       if ((sOperaInstanceCfg != null) && (sOperaInstanceCfg.disType == 2))
/*      */       {
/*      */ 
/*  846 */         SInstanceCfg sInstanceCfg = SInstanceCfg.get(instancecfgid);
/*  847 */         if (sInstanceCfg != null) {
/*  848 */           if ((sInstanceCfg.closeLevel > 0) && (sInstanceCfg.closeLevel < roleLevel)) {
/*  849 */             ((xbean.TeamInstance)entry.getValue()).setSign(0);
/*  850 */           } else if (sInstanceCfg.level <= roleLevel) {
/*  851 */             ((xbean.TeamInstance)entry.getValue()).setSign(1);
/*      */           }
/*      */         }
/*  854 */         ((xbean.TeamInstance)entry.getValue()).setToprocess(0);
/*      */       } }
/*  856 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean onTeamDissolve(List<Long> members, long instanceUuid, InstanceCacheBean instanceCacheBean)
/*      */   {
/*  868 */     SInstanceCfg instanceCfg = SInstanceCfg.get(instanceCacheBean.getInstancecfgid());
/*  869 */     boolean ret = onleaveInstance(members, instanceUuid, instanceCacheBean);
/*      */     Iterator i$;
/*  871 */     if (ret)
/*  872 */       for (i$ = members.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  873 */         MapInterface.forceTransferToScene(roleid, instanceCfg.out_mapid, instanceCfg.out_x, instanceCfg.out_y);
/*      */       }
/*  875 */     return ret;
/*      */   }
/*      */   
/*      */   static void fillInTeamInfo(TeamInfo teamInfo, int toProcess, int instancecfgid, int sign) {
/*  879 */     teamInfo.toprocess = toProcess;
/*  880 */     teamInfo.instancecfgid = instancecfgid;
/*  881 */     teamInfo.sign = sign;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean playerEnterProtect(List<Long> roleids, long instanceUuid, InstanceCacheBean instanceCacheBean)
/*      */   {
/*  894 */     boolean needClear = true;
/*  895 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long memid = ((Long)i$.next()).longValue();
/*  896 */       if (OnlineManager.getInstance().isOnline(memid)) {
/*  897 */         needClear = false;
/*      */       }
/*      */     }
/*  900 */     if (needClear) {
/*  901 */       onleaveInstance(roleids, instanceUuid, instanceCacheBean);
/*      */     }
/*  903 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean onLogOff(List<Long> roleids, long instanceUuid, InstanceCacheBean instanceCacheBean)
/*      */   {
/*  915 */     return playerEnterProtect(roleids, instanceUuid, instanceCacheBean);
/*      */   }
/*      */   
/*      */   static void init()
/*      */   {
/*  920 */     for (OperaInstanceProcessCfg sOperaInstanceProcessCfg : ) {
/*  921 */       if (sOperaInstanceProcessCfg.taskid > 0) {
/*  922 */         ItemAccessManager.registerActivityReward(InstanceInterface.getMulInstanceActivityid(sOperaInstanceProcessCfg.instanceid), sOperaInstanceProcessCfg.awardid);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  927 */     for (SOperaInstanceCfg sOperaInstanceCfg : SOperaInstanceCfg.getAll().values()) {
/*  928 */       ItemAccessManager.registerActivityPooltypeid(sOperaInstanceCfg.activityid, sOperaInstanceCfg.awardpoolid);
/*      */     }
/*      */     
/*  931 */     TeamInstanceNormalActivityHandler normalActivityHandler = new TeamInstanceNormalActivityHandler();
/*  932 */     ActivityInterface.registerActivityByLogicType(28, normalActivityHandler);
/*  933 */     ActivityInterface.registerActivityByLogicType(7, normalActivityHandler);
/*  934 */     ActivityInterface.registerActivityByLogicType(105, normalActivityHandler);
/*  935 */     ActivityInterface.registerActivityByLogicType(106, normalActivityHandler);
/*      */     
/*  937 */     ActivityInterface.registerActivityByLogicType(107, normalActivityHandler);
/*      */     
/*  939 */     TeamInstanceConfirmHandler confirmHandler = new TeamInstanceConfirmHandler();
/*  940 */     TeamConfirmInterface.registerConfirmHandler(8, confirmHandler);
/*  941 */     TeamConfirmInterface.registerConfirmHandler(9, confirmHandler);
/*  942 */     TeamConfirmInterface.registerConfirmHandler(10, confirmHandler);
/*  943 */     TeamConfirmInterface.registerConfirmHandler(11, confirmHandler);
/*  944 */     TeamConfirmInterface.registerConfirmHandler(12, confirmHandler);
/*      */     
/*  946 */     TeamInstanceActivityCompensateHandler activityCompensateHandler = new TeamInstanceActivityCompensateHandler();
/*  947 */     ActivityCompensateInterface.registerCompensateHandler(7, activityCompensateHandler);
/*      */     
/*  949 */     ActivityCompensateInterface.registerCompensateHandler(28, activityCompensateHandler);
/*      */     
/*  951 */     ActivityCompensateInterface.registerCompensateHandler(105, activityCompensateHandler);
/*  952 */     ActivityCompensateInterface.registerCompensateHandler(106, activityCompensateHandler);
/*      */     
/*  954 */     ActivityCompensateInterface.registerCompensateHandler(107, activityCompensateHandler);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void postinit()
/*      */     throws Exception
/*      */   {}
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void setProcess(long roleid, int instanceid, int process, InstanceBean instanceBean)
/*      */   {
/*  969 */     if (instanceBean == null) {
/*  970 */       instanceBean = Pod.newInstanceBean();
/*  971 */       InstanceManager.initInstanceBean(instanceBean, DateTimeUtils.getCurrTimeInMillis());
/*  972 */       Role2instance.insert(Long.valueOf(roleid), instanceBean);
/*      */     }
/*  974 */     xbean.TeamInstance teamInstance = (xbean.TeamInstance)instanceBean.getTeaminstancemap().get(Integer.valueOf(instanceid));
/*  975 */     if (teamInstance == null) {
/*  976 */       teamInstance = Pod.newTeamInstance();
/*  977 */       instanceBean.getTeaminstancemap().put(Integer.valueOf(instanceid), teamInstance);
/*      */     }
/*  979 */     teamInstance.setToprocess(process);
/*  980 */     STeamInstanceProcess teamInstanceProcess = new STeamInstanceProcess();
/*  981 */     fillInTeamInfo(teamInstanceProcess.teaminstanceinfo, process, instanceid, teamInstance.getSign());
/*  982 */     OnlineManager.getInstance().send(roleid, teamInstanceProcess);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean allAgreeRoleCheck(List<Long> beforeRoles, List<Long> afterRoles, boolean sendTip)
/*      */   {
/*  993 */     if (beforeRoles.size() != afterRoles.size()) {
/*  994 */       GameServer.logger().info(String.format("[instance]TeamInstance.allAgreeRoleCheck@num not match|beforeRoles=%s|afterRoles=%s|sendTip=%b", new Object[] { beforeRoles.toString(), afterRoles.toString(), Boolean.valueOf(sendTip) }));
/*      */       
/*      */ 
/*      */ 
/*  998 */       return false;
/*      */     }
/* 1000 */     if (!beforeRoles.containsAll(afterRoles)) {
/* 1001 */       GameServer.logger().info(String.format("[instance]TeamInstance.allAgreeRoleCheck@element not match|beforeRoles=%s|afterRoles=%s|sendTip=%b", new Object[] { beforeRoles.toString(), afterRoles.toString(), Boolean.valueOf(sendTip) }));
/*      */       
/*      */ 
/*      */ 
/* 1005 */       return false;
/*      */     }
/* 1007 */     if (!RoleStatusInterface.checkCansetStatus(beforeRoles, 14, sendTip)) {
/* 1008 */       GameServer.logger().info(String.format("[instance]TeamInstance.allAgreeRoleCheck@status error|beforeRoles=%s|afterRoles=%s|sendTip=%b", new Object[] { beforeRoles.toString(), afterRoles.toString(), Boolean.valueOf(sendTip) }));
/*      */       
/*      */ 
/*      */ 
/* 1012 */       return false;
/*      */     }
/* 1014 */     GameServer.logger().info(String.format("[instance]TeamInstance.allAgreeRoleCheck@all role agree|beforeRoles=%s|afterRoles=%s|sendTip=%b", new Object[] { beforeRoles.toString(), afterRoles.toString(), Boolean.valueOf(sendTip) }));
/*      */     
/*      */ 
/*      */ 
/* 1018 */     return true;
/*      */   }
/*      */   
/*      */   static boolean isTeamInstanceSwitchOpenForRole(long roleid, int instanceid) {
/* 1022 */     if (!OpenInterface.getOpenStatus(7)) {
/* 1023 */       return false;
/*      */     }
/* 1025 */     if (OpenInterface.isBanPlay(roleid, 7)) {
/* 1026 */       OpenInterface.sendBanPlayMsg(roleid, 7);
/* 1027 */       return false;
/*      */     }
/* 1029 */     SOperaInstanceCfg operaInstanceCfg = InstanceCfgManager.getOperaInstanceCfg(instanceid);
/* 1030 */     if (operaInstanceCfg == null) {
/* 1031 */       return false;
/*      */     }
/* 1033 */     switch (operaInstanceCfg.disType) {
/*      */     case 1: 
/* 1035 */       if (!OpenInterface.getOpenStatus(388)) {
/* 1036 */         return false;
/*      */       }
/* 1038 */       if (OpenInterface.isBanPlay(roleid, 388)) {
/* 1039 */         OpenInterface.sendBanPlayMsg(roleid, 388);
/* 1040 */         return false;
/*      */       }
/*      */       break;
/*      */     case 2: 
/* 1044 */       if (!OpenInterface.getOpenStatus(389)) {
/* 1045 */         return false;
/*      */       }
/* 1047 */       if (OpenInterface.isBanPlay(roleid, 389)) {
/* 1048 */         OpenInterface.sendBanPlayMsg(roleid, 389);
/* 1049 */         return false;
/*      */       }
/*      */       break;
/*      */     case 3: 
/* 1053 */       if (!OpenInterface.getOpenStatus(390)) {
/* 1054 */         return false;
/*      */       }
/* 1056 */       if (OpenInterface.isBanPlay(roleid, 390)) {
/* 1057 */         OpenInterface.sendBanPlayMsg(roleid, 390);
/* 1058 */         return false;
/*      */       }
/*      */       break;
/*      */     case 4: 
/* 1062 */       if (!OpenInterface.getOpenStatus(391)) {
/* 1063 */         return false;
/*      */       }
/* 1065 */       if (OpenInterface.isBanPlay(roleid, 391)) {
/* 1066 */         OpenInterface.sendBanPlayMsg(roleid, 391);
/* 1067 */         return false;
/*      */       }
/*      */       break;
/*      */     case 5: 
/* 1071 */       if (!OpenInterface.getOpenStatus(392)) {
/* 1072 */         return false;
/*      */       }
/* 1074 */       if (OpenInterface.isBanPlay(roleid, 392)) {
/* 1075 */         OpenInterface.sendBanPlayMsg(roleid, 392);
/* 1076 */         return false;
/*      */       }
/*      */       break;
/*      */     default: 
/* 1080 */       return false;
/*      */     }
/* 1082 */     return true;
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\TeamInstance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */