/*     */ package mzm.gsp.jiuxiao.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.confbean.SJueZhanJiuXiaoCfg;
/*     */ import mzm.gsp.activity.confbean.SJueZhanJiuXiaoConsts;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.award.MultiRoleAwardBean;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.fight.event.PVEFightEndArg;
/*     */ import mzm.gsp.jiuxiao.RoleData;
/*     */ import mzm.gsp.jiuxiao.SJiuXiaoWinBossRes;
/*     */ import mzm.gsp.jiuxiao.SSynJiuXiaoFisrtWinRes;
/*     */ import mzm.gsp.npc.main.NpcFightContext;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.JiuXiaoActivityBean;
/*     */ import xbean.JiuXiaoActivityInfo;
/*     */ import xbean.JiuXiaoBean;
/*     */ import xbean.JiuXiaoFloorBean;
/*     */ import xtable.Role2jiuxiaocache;
/*     */ 
/*     */ public class POnPVEFightEnd extends mzm.gsp.fight.event.PVEFightEndProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  35 */     if (!mzm.gsp.open.main.OpenInterface.getOpenStatus(13)) {
/*  36 */       return false;
/*     */     }
/*  38 */     if (!((PVEFightEndArg)this.arg).isPlayerWin) {
/*  39 */       return false;
/*     */     }
/*  41 */     if ((((PVEFightEndArg)this.arg).context instanceof NpcFightContext)) {
/*  42 */       NpcFightContext npcFightContext = (NpcFightContext)((PVEFightEndArg)this.arg).context;
/*  43 */       long leaderRoleid = ((Long)((PVEFightEndArg)this.arg).roleList.get(0)).longValue();
/*  44 */       final int activityid = JiuXiaoManager.getRoleActivityid(leaderRoleid, false);
/*  45 */       int mapCfgid = npcFightContext.mapcfgid;
/*  46 */       final SJueZhanJiuXiaoCfg jueZhanJiuXiaoCfg = JiuXiaoCfgManager.getJueZhanJiuXiaoByMapId(activityid, mapCfgid);
/*     */       
/*  48 */       if (jueZhanJiuXiaoCfg == null) {
/*  49 */         return false;
/*     */       }
/*  51 */       if (jueZhanJiuXiaoCfg.bossNPC == npcFightContext.npcid)
/*     */       {
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
/*     */ 
/*     */ 
/*  67 */         Map<Long, String> allUsers = new java.util.HashMap();
/*  68 */         for (Long roleid : ((PVEFightEndArg)this.arg).roleList) {
/*  69 */           String userid = RoleInterface.getUserId(roleid.longValue());
/*  70 */           allUsers.put(roleid, userid);
/*     */         }
/*     */         
/*  73 */         lock(xtable.User.getTable(), allUsers.values());
/*     */         
/*  75 */         lock(Role2jiuxiaocache.getTable(), ((PVEFightEndArg)this.arg).roleList);
/*     */         
/*     */ 
/*  78 */         for (Iterator i$ = ((PVEFightEndArg)this.arg).roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  79 */           ActivityInterface.logActivity(roleid, activityid, ActivityLogStatus.FINISH);
/*  80 */           ActivityInterface.tlogActivity(roleid, activityid, ActivityLogStatus.FINISH);
/*     */         }
/*  82 */         int sec = (int)(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis() - ActivityInterface.getActivityStartTime(jueZhanJiuXiaoCfg.activityid) - SJueZhanJiuXiaoConsts.getInstance().waitTime * 60000) / 1000;
/*     */         
/*     */ 
/*     */ 
/*  86 */         JiuXiaoManager.rankRole(jueZhanJiuXiaoCfg, sec, ((PVEFightEndArg)this.arg).roleList);
/*     */         
/*  88 */         NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicProcedure()
/*     */         {
/*     */           protected boolean processImp()
/*     */             throws Exception
/*     */           {
/*  93 */             lock(Role2jiuxiaocache.getTable(), ((PVEFightEndArg)POnPVEFightEnd.this.arg).roleList);
/*     */             
/*  95 */             JiuXiaoActivityBean xJiuXiaoActivityBean = xtable.Jiuxiaotable.get(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/*     */             
/*  97 */             if (xJiuXiaoActivityBean != null) {
/*  98 */               JiuXiaoActivityInfo xJiuXiaoActivityInfo = (JiuXiaoActivityInfo)xJiuXiaoActivityBean.getActivityinfomap().get(Integer.valueOf(activityid));
/*     */               
/* 100 */               if (xJiuXiaoActivityInfo != null) {
/* 101 */                 if (xJiuXiaoActivityInfo.getWinlayers().contains(Integer.valueOf(jueZhanJiuXiaoCfg.floor))) {
/* 102 */                   return false;
/*     */                 }
/* 104 */                 xJiuXiaoActivityInfo.getWinlayers().add(Integer.valueOf(jueZhanJiuXiaoCfg.floor));
/*     */                 
/* 106 */                 SSynJiuXiaoFisrtWinRes synJiuXiaoFisrtWinRes = new SSynJiuXiaoFisrtWinRes();
/* 107 */                 synJiuXiaoFisrtWinRes.cfgid = jueZhanJiuXiaoCfg.id;
/* 108 */                 for (Iterator i$ = ((PVEFightEndArg)POnPVEFightEnd.this.arg).roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 109 */                   RoleData roleData = new RoleData();
/* 110 */                   roleData.roleid = roleid;
/* 111 */                   roleData.rolename = RoleInterface.getName(roleid);
/* 112 */                   synJiuXiaoFisrtWinRes.roles.add(roleData);
/*     */                 }
/* 114 */                 OnlineManager.getInstance().sendAll(synJiuXiaoFisrtWinRes);
/* 115 */                 return true;
/*     */               }
/*     */             }
/*     */             
/*     */ 
/* 120 */             return true;
/*     */           }
/*     */           
/*     */ 
/* 124 */         });
/* 125 */         SJiuXiaoWinBossRes sJiuXiaoWinBossRes = new SJiuXiaoWinBossRes();
/* 126 */         sJiuXiaoWinBossRes.cfgid = jueZhanJiuXiaoCfg.id;
/* 127 */         OnlineManager.getInstance().sendMulti(sJiuXiaoWinBossRes, ((PVEFightEndArg)this.arg).roleList);
/*     */         
/*     */ 
/* 130 */         List<Long> awardedList = new ArrayList();
/* 131 */         List<Long> notAwardedList = new ArrayList();
/* 132 */         for (Iterator i$ = ((PVEFightEndArg)this.arg).roleList.iterator(); i$.hasNext();) { long awardRoleid = ((Long)i$.next()).longValue();
/* 133 */           JiuXiaoBean xjiuXiaoBean = xtable.Role2jiuxiao.get(Long.valueOf(awardRoleid));
/* 134 */           if (xjiuXiaoBean.getFloormap().containsKey(Integer.valueOf(jueZhanJiuXiaoCfg.id))) {
/* 135 */             JiuXiaoFloorBean xJiuXiaoFloorBean = (JiuXiaoFloorBean)xjiuXiaoBean.getFloormap().get(Integer.valueOf(jueZhanJiuXiaoCfg.id));
/* 136 */             if (xJiuXiaoFloorBean.getIsawarded() == 1) {
/* 137 */               awardedList.add(Long.valueOf(awardRoleid));
/*     */             } else {
/* 139 */               notAwardedList.add(Long.valueOf(awardRoleid));
/* 140 */               xJiuXiaoFloorBean.setIsawarded(1);
/* 141 */               xJiuXiaoFloorBean.setTimesec(sec);
/*     */             }
/*     */           } else {
/* 144 */             JiuXiaoFloorBean xJiuXiaoFloorBean = xbean.Pod.newJiuXiaoFloorBean();
/* 145 */             xjiuXiaoBean.getFloormap().put(Integer.valueOf(jueZhanJiuXiaoCfg.id), xJiuXiaoFloorBean);
/* 146 */             notAwardedList.add(Long.valueOf(awardRoleid));
/* 147 */             xJiuXiaoFloorBean.setIsawarded(1);
/* 148 */             xJiuXiaoFloorBean.setTimesec(sec);
/*     */           }
/*     */         }
/*     */         
/* 152 */         for (Iterator i$ = notAwardedList.iterator(); i$.hasNext();) { long notAwardRoleid = ((Long)i$.next()).longValue();
/* 153 */           AwardInterface.award(jueZhanJiuXiaoCfg.winAward, (String)allUsers.get(Long.valueOf(notAwardRoleid)), notAwardRoleid, -1, ((PVEFightEndArg)this.arg).roleList, ((PVEFightEndArg)this.arg).roleList, false, true, new mzm.gsp.award.main.AwardReason(LogReason.JIU_XIAO_FIGHT_BOSS_AWARD, jueZhanJiuXiaoCfg.id));
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 158 */         List<AwardPoolResultData> awardPoolResultDatas = mzm.gsp.awardpool.main.AwardPoolInterface.getAwardPoolData(jueZhanJiuXiaoCfg.bossAward);
/*     */         
/*     */ 
/* 161 */         if ((awardedList.size() == ((PVEFightEndArg)this.arg).roleList.size()) || (awardPoolResultDatas == null) || (awardPoolResultDatas.size() <= 0))
/*     */         {
/*     */ 
/*     */ 
/* 165 */           SJueZhanJiuXiaoCfg nextJueZhanJiuXiaoCfg = JiuXiaoCfgManager.getNextJiuXiaoCfg(activityid, jueZhanJiuXiaoCfg.floor);
/*     */           
/* 167 */           if (nextJueZhanJiuXiaoCfg != null) {
/* 168 */             JiuXiaoManager.finishFloor(nextJueZhanJiuXiaoCfg, ((PVEFightEndArg)this.arg).roleList);
/*     */           }
/* 170 */           return true;
/*     */         }
/* 172 */         List<MultiRoleAwardBean> multiRoleAwardBeans = new ArrayList();
/* 173 */         for (AwardPoolResultData awardPoolResultData : awardPoolResultDatas)
/* 174 */           for (Map.Entry<Integer, List<Integer>> entry : awardPoolResultData.getItemId2NumList().entrySet())
/*     */           {
/* 176 */             itemid = ((Integer)entry.getKey()).intValue();
/* 177 */             for (i$ = ((List)entry.getValue()).iterator(); i$.hasNext();) { int count = ((Integer)i$.next()).intValue();
/* 178 */               MultiRoleAwardBean awardBean = new MultiRoleAwardBean();
/* 179 */               awardBean.count = count;
/* 180 */               awardBean.id = itemid;
/* 181 */               multiRoleAwardBeans.add(awardBean);
/*     */             } }
/*     */         int itemid;
/*     */         Iterator i$;
/* 185 */         AwardInterface.awardMultiRoleSelectAward(((PVEFightEndArg)this.arg).roleList, awardedList, multiRoleAwardBeans, new JiuXiaoMultiRoleAwardContext(jueZhanJiuXiaoCfg.floor, activityid), new mzm.gsp.tlog.TLogArg(LogReason.JIU_XIAO_BOSS_AWARD, jueZhanJiuXiaoCfg.id));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 192 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\main\POnPVEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */