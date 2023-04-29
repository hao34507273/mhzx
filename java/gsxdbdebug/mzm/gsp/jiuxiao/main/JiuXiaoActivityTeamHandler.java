/*    */ package mzm.gsp.jiuxiao.main;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import xbean.JiuXiaoActivityBean;
/*    */ import xbean.JiuXiaoActivityInfo;
/*    */ 
/*    */ public class JiuXiaoActivityTeamHandler implements mzm.gsp.team.main.ActivityTeamHandler
/*    */ {
/*    */   private int activityid;
/*    */   
/*    */   public JiuXiaoActivityTeamHandler(int activityid)
/*    */   {
/* 15 */     this.activityid = activityid;
/*    */   }
/*    */   
/*    */   public java.util.List<Long> findTeams(long roleId, long worldId)
/*    */   {
/* 20 */     JiuXiaoActivityBean xjiuXiaoActivityBean = xtable.Jiuxiaotable.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 21 */     if (xjiuXiaoActivityBean == null) {
/* 22 */       return Collections.emptyList();
/*    */     }
/* 24 */     JiuXiaoActivityInfo xJiuXiaoActivityInfo = (JiuXiaoActivityInfo)xjiuXiaoActivityBean.getActivityinfomap().get(Integer.valueOf(this.activityid));
/* 25 */     if (xJiuXiaoActivityInfo == null) {
/* 26 */       return Collections.emptyList();
/*    */     }
/* 28 */     long worldid = xJiuXiaoActivityInfo.getWorldid();
/* 29 */     if (worldId != worldid) {
/* 30 */       return Collections.emptyList();
/*    */     }
/* 32 */     int mapid = MapInterface.getRoleMapId(roleId);
/* 33 */     return MapInterface.getAllTeamInWorld(worldId, mapid);
/*    */   }
/*    */   
/*    */   public java.util.List<Long> findMembers(long roleId, long worldId)
/*    */   {
/* 38 */     JiuXiaoActivityBean xjiuXiaoActivityBean = xtable.Jiuxiaotable.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 39 */     if (xjiuXiaoActivityBean == null) {
/* 40 */       return Collections.emptyList();
/*    */     }
/* 42 */     JiuXiaoActivityInfo xJiuXiaoActivityInfo = (JiuXiaoActivityInfo)xjiuXiaoActivityBean.getActivityinfomap().get(Integer.valueOf(this.activityid));
/* 43 */     if (xJiuXiaoActivityInfo == null) {
/* 44 */       return Collections.emptyList();
/*    */     }
/* 46 */     long worldid = xJiuXiaoActivityInfo.getWorldid();
/* 47 */     if (worldId != worldid) {
/* 48 */       return Collections.emptyList();
/*    */     }
/* 50 */     int mapid = MapInterface.getRoleMapId(roleId);
/* 51 */     return MapInterface.getAllSingleRoleInWorld(worldid, mapid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\main\JiuXiaoActivityTeamHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */