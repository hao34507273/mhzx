/*     */ package mzm.gsp.jiuxiao.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.SJiuXiaoActivityInfoCfg;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.JiuXiaoActivityBean;
/*     */ import xbean.JiuXiaoActivityInfo;
/*     */ import xtable.Role2jiuxiao;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCEnterJiuXiaoRoomReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private int activityid;
/*     */   
/*     */   public PCEnterJiuXiaoRoomReq(long roleid, int activityid)
/*     */   {
/*  28 */     this.activityid = activityid;
/*  29 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  34 */     if (!OpenInterface.getOpenStatus(13)) {
/*  35 */       OpenInterface.sendCloseProtocol(this.roleid, 13);
/*  36 */       return false;
/*     */     }
/*  38 */     if (OpenInterface.isBanPlay(this.roleid, 13)) {
/*  39 */       OpenInterface.sendBanPlayMsg(this.roleid, 13);
/*  40 */       return false;
/*     */     }
/*  42 */     List<Long> normalList = new ArrayList();
/*  43 */     SJiuXiaoActivityInfoCfg jiuXiaoActivityInfoCfg = SJiuXiaoActivityInfoCfg.get(this.activityid);
/*  44 */     if (jiuXiaoActivityInfoCfg == null) {
/*  45 */       GameServer.logger().error(String.format("[JiuXiao]PCEnterJiuXiaoMapReq.processImp@jiuxiao activityinfo cfg not exist|activityid=%d|roleid=%d", new Object[] { Integer.valueOf(this.activityid), Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  52 */       return false;
/*     */     }
/*  54 */     if (!mzm.gsp.npc.main.NpcInterface.checkNpcService(jiuXiaoActivityInfoCfg.npcid, jiuXiaoActivityInfoCfg.waitRoomServiceid, this.roleid))
/*     */     {
/*  56 */       GameServer.logger().info(String.format("[JiuXiao]PCEnterJiuXiaoMapReq.processImp@enter jiuxiao map service is not useable|activityid=%d|npcid=%d|serviceid=%d|roleid=%d", new Object[] { Integer.valueOf(this.activityid), Integer.valueOf(jiuXiaoActivityInfoCfg.npcid), Integer.valueOf(jiuXiaoActivityInfoCfg.mapServiceid), Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  64 */       return false;
/*     */     }
/*  66 */     normalList.addAll(TeamInterface.getNormalRoleList(this.roleid));
/*  67 */     if (normalList.size() <= 0) {
/*  68 */       normalList.add(Long.valueOf(this.roleid));
/*     */     }
/*  70 */     if (((Long)normalList.get(0)).longValue() != this.roleid)
/*     */     {
/*  72 */       if (normalList.contains(Long.valueOf(this.roleid))) {
/*  73 */         GameServer.logger().info(String.format("[JiuXiao]PCEnterJiuXiaoRoomReq.processImp@玩家在队伍中但不是队长不能操作|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */         
/*  75 */         return false;
/*     */       }
/*     */       
/*  78 */       normalList.clear();
/*  79 */       normalList.add(Long.valueOf(this.roleid));
/*     */     }
/*  81 */     for (Iterator i$ = normalList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  82 */       if (OpenInterface.isBanPlay(roleid, 13)) {
/*  83 */         OpenInterface.sendBanPlayMsg(this.roleid, roleid, RoleInterface.getName(roleid), 13);
/*     */         
/*  85 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  89 */     Map<Long, String> role2user = new HashMap();
/*  90 */     for (Iterator i$ = normalList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  91 */       role2user.put(Long.valueOf(roleid), RoleInterface.getUserId(roleid));
/*     */     }
/*  93 */     lock(User.getTable(), role2user.values());
/*  94 */     lock(Role2jiuxiao.getTable(), normalList);
/*     */     
/*  96 */     ActivityJoinResult activityJoinResult = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(role2user, normalList, this.activityid);
/*     */     
/*  98 */     if ((!activityJoinResult.isCanJoin()) && (!activityJoinResult.isPerSonCountWrong()))
/*     */     {
/* 100 */       GameServer.logger().info(String.format("[JiuXiao]PCEnterJiuXiaoRoomReq.processImp@can not join activity|roleid=%d|activityid=%d|reason=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityid), Integer.valueOf(activityJoinResult.getReasonValue()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 107 */       return false;
/*     */     }
/*     */     
/* 110 */     JiuXiaoActivityBean xJiuXiaoActivityBean = xtable.Jiuxiaotable.select(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/* 111 */     if (xJiuXiaoActivityBean == null) {
/* 112 */       GameServer.logger().info(String.format("[JiuXiao]PCEnterJiuXiaoRoomReq.processImp@jiuxiao activity is closed", new Object[0]));
/*     */       
/* 114 */       return false;
/*     */     }
/* 116 */     JiuXiaoActivityInfo xJiuXiaoActivityInfo = (JiuXiaoActivityInfo)xJiuXiaoActivityBean.getActivityinfomap().get(Integer.valueOf(this.activityid));
/* 117 */     if (xJiuXiaoActivityInfo == null) {
/* 118 */       GameServer.logger().info(String.format("[JiuXiao]PCEnterJiuXiaoRoomReq.processImp@jiuxiao activity is closed", new Object[0]));
/*     */       
/* 120 */       return false;
/*     */     }
/*     */     
/* 123 */     if (!mzm.gsp.status.main.RoleStatusInterface.setStatus(normalList, 19, true)) {
/* 124 */       return false;
/*     */     }
/*     */     
/* 127 */     for (Iterator i$ = normalList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 128 */       JiuXiaoManager.setJiuxiaoActivityid(roleid, this.activityid);
/*     */     }
/*     */     
/* 131 */     for (Iterator i$ = normalList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 132 */       MapInterface.transferToScene(roleid, xJiuXiaoActivityInfo.getWorldid(), jiuXiaoActivityInfoCfg.waitRoomMapid);
/*     */     }
/*     */     
/* 135 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\main\PCEnterJiuXiaoRoomReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */