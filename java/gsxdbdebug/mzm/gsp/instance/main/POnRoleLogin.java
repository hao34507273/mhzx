/*     */ package mzm.gsp.instance.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.instance.SEnterInstanceRes;
/*     */ import mzm.gsp.instance.SSynInstanceInfo;
/*     */ import mzm.gsp.instance.SSynSingleInstanceInfo;
/*     */ import mzm.gsp.instance.STeamInstanceCurProcess;
/*     */ import mzm.gsp.instance.SingleInfo;
/*     */ import mzm.gsp.instance.TeamInfo;
/*     */ import mzm.gsp.instance.confbean.SInstanceCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.InstanceBean;
/*     */ import xbean.InstanceCacheBean;
/*     */ import xtable.Instance;
/*     */ import xtable.Role2instance;
/*     */ 
/*     */ public class POnRoleLogin extends mzm.gsp.online.event.PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  26 */     InstanceBean xInstanceBean = Role2instance.get((Long)this.arg);
/*  27 */     boolean juqingfubenOpen = (OpenInterface.getOpenStatus(7)) || (!OpenInterface.isBanPlay(((Long)this.arg).longValue(), 7));
/*     */     
/*     */ 
/*  30 */     if (xInstanceBean != null) {
/*  31 */       if (juqingfubenOpen) {
/*  32 */         SSynInstanceInfo synInstanceInfo = new SSynInstanceInfo();
/*     */         
/*     */ 
/*  35 */         for (Map.Entry<Integer, xbean.TeamInstance> entry : xInstanceBean.getTeaminstancemap().entrySet()) {
/*  36 */           TeamInfo teamInfo = new TeamInfo();
/*  37 */           xbean.TeamInstance xTeamInstance = (xbean.TeamInstance)entry.getValue();
/*  38 */           int processid = ((xbean.TeamInstance)entry.getValue()).getToprocess();
/*  39 */           TeamInstance.fillInTeamInfo(teamInfo, processid, ((Integer)entry.getKey()).intValue(), xTeamInstance.getSign());
/*  40 */           synInstanceInfo.teaminstances.add(teamInfo);
/*     */         }
/*  42 */         OnlineManager.getInstance().send(((Long)this.arg).longValue(), synInstanceInfo);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  56 */       boolean heilonghaojieOpen = (OpenInterface.getOpenStatus(4)) || (!OpenInterface.isBanPlay(((Long)this.arg).longValue(), 4));
/*     */       
/*     */ 
/*     */ 
/*  60 */       if (heilonghaojieOpen) {
/*  61 */         SSynSingleInstanceInfo synSingleInstanceInfo = new SSynSingleInstanceInfo();
/*  62 */         synSingleInstanceInfo.singlefailtime = xInstanceBean.getSinglefailtime();
/*  63 */         for (Map.Entry<Integer, xbean.SingleInstance> entry : xInstanceBean.getSingleinstancemap().entrySet()) {
/*  64 */           xbean.SingleInstance xSingleInstance = (xbean.SingleInstance)entry.getValue();
/*  65 */           SingleInfo singleInfo = new SingleInfo();
/*  66 */           SingleInstance.fillInSingleInfo(singleInfo, xSingleInstance.getHighprocess(), xSingleInstance.getCurprocess(), xSingleInstance.getFinishtimes(), ((Integer)entry.getKey()).intValue(), xSingleInstance.getSign());
/*     */           
/*     */ 
/*  69 */           synSingleInstanceInfo.singleinstanceinfo.add(singleInfo);
/*     */         }
/*  71 */         OnlineManager.getInstance().send(((Long)this.arg).longValue(), synSingleInstanceInfo);
/*     */       }
/*     */       
/*     */ 
/*  75 */       Long instanceUuid = xtable.Role2instanceuuid.get((Long)this.arg);
/*  76 */       if (instanceUuid != null) {
/*  77 */         final long roleid = ((Long)this.arg).longValue();
/*     */         
/*  79 */         InstanceCacheBean xInstanceCacheBean = Instance.get(instanceUuid);
/*  80 */         int instanceid = xInstanceCacheBean.getInstancecfgid();
/*  81 */         SInstanceCfg instanceCfg = SInstanceCfg.get(instanceid);
/*  82 */         switch (instanceCfg.instanceType) {
/*     */         case 1: 
/*  84 */           if (!heilonghaojieOpen) {
/*  85 */             NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicProcedure()
/*     */             {
/*     */ 
/*     */               protected boolean processImp()
/*     */                 throws Exception
/*     */               {
/*  91 */                 InstanceBean xInstanceBean = Role2instance.get(Long.valueOf(roleid));
/*     */                 
/*  93 */                 InstanceCacheBean xInstanceCacheBean = Instance.get(this.val$instanceUuid);
/*     */                 
/*     */ 
/*  96 */                 if (xInstanceCacheBean == null) {
/*  97 */                   return false;
/*     */                 }
/*  99 */                 return SingleInstance.onleaveInstance(roleid, this.val$instanceUuid.longValue(), xInstanceCacheBean, xInstanceBean);
/*     */               }
/*     */               
/* 102 */             });
/* 103 */             return true;
/*     */           }
/*     */           break;
/*     */         case 2: 
/* 107 */           if (!juqingfubenOpen) {
/* 108 */             NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicProcedure()
/*     */             {
/*     */               protected boolean processImp()
/*     */                 throws Exception
/*     */               {
/* 113 */                 Long teamid = TeamInterface.getTeamidByRoleid(roleid, false);
/* 114 */                 if (teamid == null) {
/* 115 */                   return false;
/*     */                 }
/*     */                 
/* 118 */                 java.util.List<Long> allTeamMembers = TeamInterface.getTeamMemberList(teamid.longValue(), false);
/* 119 */                 if (allTeamMembers.size() <= 0) {
/* 120 */                   return false;
/*     */                 }
/*     */                 
/* 123 */                 if (!TeamInterface.isTeamLeader(teamid.longValue(), roleid, false)) {
/* 124 */                   return false;
/*     */                 }
/*     */                 
/*     */ 
/*     */ 
/* 129 */                 lock(Role2instance.getTable(), allTeamMembers);
/*     */                 
/* 131 */                 InstanceCacheBean xInstanceCacheTeamBean = Instance.get(this.val$instanceUuid);
/*     */                 
/*     */ 
/* 134 */                 if (xInstanceCacheTeamBean == null) {
/* 135 */                   return false;
/*     */                 }
/* 137 */                 return TeamInstance.onleaveInstance(allTeamMembers, this.val$instanceUuid.longValue(), xInstanceCacheTeamBean);
/*     */               }
/*     */               
/* 140 */             });
/* 141 */             return true;
/*     */           }
/*     */           
/*     */           break;
/*     */         }
/*     */         
/* 147 */         SEnterInstanceRes sEnterInstanceRes = new SEnterInstanceRes();
/* 148 */         sEnterInstanceRes.instancecfgid = instanceid;
/* 149 */         sEnterInstanceRes.instancetype = SInstanceCfg.get(instanceid).instanceType;
/* 150 */         OnlineManager.getInstance().send(((Long)this.arg).longValue(), sEnterInstanceRes);
/*     */         
/* 152 */         Integer processid = (Integer)xInstanceCacheBean.getExtra().get(Integer.valueOf(InstanceExtra.TEAM_INSTANCE_PROCESS.ordinal()));
/*     */         
/* 154 */         if (processid != null) {
/* 155 */           STeamInstanceCurProcess teamInstanceCurProcess = new STeamInstanceCurProcess();
/* 156 */           teamInstanceCurProcess.curprocess = processid.intValue();
/* 157 */           OnlineManager.getInstance().send(((Long)this.arg).longValue(), teamInstanceCurProcess);
/*     */         }
/*     */       }
/*     */     }
/* 161 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */