/*     */ package mzm.gsp.jiuxiao.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.SJiuXiaoActivityInfoCfg;
/*     */ import mzm.gsp.activity.confbean.SJueZhanJiuXiaoCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.jiuxiao.SEnterJiuXiaoMapRes;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.JiuXiaoActivityBean;
/*     */ import xbean.JiuXiaoActivityInfo;
/*     */ import xbean.JiuXiaoCacheBean;
/*     */ import xtable.Role2jiuxiao;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCEnterJiuXiaoMapReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   
/*     */   public PCEnterJiuXiaoMapReq(long roleid)
/*     */   {
/*  31 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  36 */     if (!OpenInterface.getOpenStatus(13)) {
/*  37 */       OpenInterface.sendCloseProtocol(this.roleid, 13);
/*  38 */       return false;
/*     */     }
/*  40 */     if (OpenInterface.isBanPlay(this.roleid, 13)) {
/*  41 */       OpenInterface.sendBanPlayMsg(this.roleid, 13);
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     JiuXiaoCacheBean xSelectJiuXiaoCacheBean = xtable.Role2jiuxiaocache.select(Long.valueOf(this.roleid));
/*  46 */     if (xSelectJiuXiaoCacheBean == null) {
/*  47 */       GameServer.logger().error(String.format("[JiuXiao]PCEnterJiuXiaoMapReq.processImp@role is not in activityid|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  50 */       return false;
/*     */     }
/*  52 */     int activityid = xSelectJiuXiaoCacheBean.getJiuxiaoactivityid();
/*  53 */     SJiuXiaoActivityInfoCfg jiuXiaoActivityInfoCfg = SJiuXiaoActivityInfoCfg.get(activityid);
/*  54 */     if (jiuXiaoActivityInfoCfg == null) {
/*  55 */       GameServer.logger().error(String.format("[JiuXiao]PCEnterJiuXiaoMapReq.processImp@jiuxiao activityinfo cfg not exist|activityid=%d|roleid=%d", new Object[] { Integer.valueOf(activityid), Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  62 */       return false;
/*     */     }
/*  64 */     if (!mzm.gsp.npc.main.NpcInterface.checkNpcService(jiuXiaoActivityInfoCfg.npcInWaitRoom, jiuXiaoActivityInfoCfg.mapServiceid, this.roleid))
/*     */     {
/*  66 */       GameServer.logger().info(String.format("[JiuXiao]PCEnterJiuXiaoMapReq.processImp@enter jiuxiao map service is not useable|activityid=%d|npcid=%d|serviceid=%d|roleid=%d", new Object[] { Integer.valueOf(activityid), Integer.valueOf(jiuXiaoActivityInfoCfg.npcInWaitRoom), Integer.valueOf(jiuXiaoActivityInfoCfg.mapServiceid), Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  74 */       return false;
/*     */     }
/*  76 */     List<Long> normalRole = mzm.gsp.team.main.TeamInterface.getNormalRoleList(this.roleid);
/*  77 */     if (normalRole.size() <= 0) {
/*  78 */       normalRole.add(Long.valueOf(this.roleid));
/*     */     }
/*  80 */     Map<Long, String> role2user = new HashMap();
/*  81 */     for (Iterator i$ = normalRole.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*  82 */       role2user.put(Long.valueOf(tmpRoleId), RoleInterface.getUserId(tmpRoleId));
/*     */     }
/*     */     
/*  85 */     xdb.Lockeys.lock(User.getTable(), role2user.values());
/*  86 */     lock(Role2jiuxiao.getTable(), normalRole);
/*  87 */     for (int i = 1; i < normalRole.size(); i++) {
/*  88 */       long roleid = ((Long)normalRole.get(i)).longValue();
/*  89 */       if (OpenInterface.isBanPlay(roleid, 13)) {
/*  90 */         OpenInterface.sendBanPlayMsg(this.roleid, roleid, RoleInterface.getName(roleid), 13);
/*     */         
/*  92 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  96 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(role2user, normalRole, activityid);
/*     */     
/*  98 */     if (!activityJoinResult.isCanJoin()) {
/*  99 */       GameServer.logger().info(String.format("[JiuXiao]PCEnterJiuXiaoMapReq.processImp@can not join jiuxiao activity|reason=%d", new Object[] { Integer.valueOf(activityJoinResult.getReasonValue()) }));
/*     */       
/*     */ 
/* 102 */       return false;
/*     */     }
/*     */     
/* 105 */     if (!mzm.gsp.status.main.RoleStatusInterface.setStatus(normalRole, 19, true)) {
/* 106 */       return false;
/*     */     }
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
/*     */ 
/*     */ 
/* 138 */     JiuXiaoActivityBean xJiuXiaoActivityBean = xtable.Jiuxiaotable.select(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/* 139 */     if (xJiuXiaoActivityBean == null) {
/* 140 */       GameServer.logger().info(String.format("[JiuXiao]PCEnterJiuXiaoMapReq.processImp@jiuxiao activity is closed", new Object[0]));
/*     */       
/* 142 */       return false;
/*     */     }
/*     */     
/* 145 */     JiuXiaoActivityInfo xJiuXiaoActivityInfo = (JiuXiaoActivityInfo)xJiuXiaoActivityBean.getActivityinfomap().get(Integer.valueOf(activityid));
/* 146 */     if (xJiuXiaoActivityInfo == null) {
/* 147 */       GameServer.logger().info(String.format("[JiuXiao]PCEnterJiuXiaoMapReq.processImp@jiuxiao activity is closed", new Object[0]));
/*     */       
/* 149 */       return false;
/*     */     }
/* 151 */     if (ActivityInterface.getActivityStage(activityid) <= 0) {
/* 152 */       SEnterJiuXiaoMapRes enterJiuXiaoMapRes = new SEnterJiuXiaoMapRes();
/* 153 */       enterJiuXiaoMapRes.result = 1;
/* 154 */       int sec = ActivityInterface.getActivityStageLeftTime(activityid, 0) / 1000;
/* 155 */       sec = Math.max(1, sec);
/* 156 */       enterJiuXiaoMapRes.args.add(sec + "");
/* 157 */       OnlineManager.getInstance().sendAtOnce(this.roleid, enterJiuXiaoMapRes);
/* 158 */       return false;
/*     */     }
/* 160 */     SJueZhanJiuXiaoCfg jueZhanJiuXiaoCfg = JiuXiaoCfgManager.getNextJiuXiaoCfg(activityid, 0);
/* 161 */     if (jueZhanJiuXiaoCfg == null) {
/* 162 */       if (GameServer.logger().isDebugEnabled())
/* 163 */         GameServer.logger().debug("第一层数据不存在");
/* 164 */       return false;
/*     */     }
/* 166 */     MapInterface.transferToScene(this.roleid, xJiuXiaoActivityInfo.getWorldid(), jueZhanJiuXiaoCfg.mapid);
/*     */     
/*     */ 
/* 169 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\main\PCEnterJiuXiaoMapReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */