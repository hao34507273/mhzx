/*     */ package mzm.gsp.map.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.aircraft.main.AircraftInterface;
/*     */ import mzm.gsp.feijian.confbean.SFeJianConsts;
/*     */ import mzm.gsp.feijian.confbean.SFeiJianCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.map.SMapFlyErrorRes;
/*     */ import mzm.gsp.map.main.message.MMH_PlayerFly;
/*     */ import mzm.gsp.map.main.proto.MapPrototype;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Role2properties;
/*     */ 
/*     */ public class PPlayerFlyReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int targetX;
/*     */   private final int targetY;
/*     */   
/*     */   public PPlayerFlyReq(long roleId, int targetX, int targetY)
/*     */   {
/*  30 */     this.roleId = roleId;
/*  31 */     this.targetX = targetX;
/*  32 */     this.targetY = targetY;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     List<Long> normalList = TeamInterface.getNormalRoleList(this.roleId);
/*  39 */     if ((normalList.size() > 0) && (normalList.contains(Long.valueOf(this.roleId))))
/*     */     {
/*  41 */       lock(Role2properties.getTable(), normalList);
/*  42 */       Long teamId = TeamInterface.getTeamidByRoleid(this.roleId, true);
/*  43 */       if (teamId == null)
/*     */       {
/*  45 */         GameServer.logger().info(String.format("[map]PPlayerFlyReq.processImp@team info is not consistent|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */         
/*     */ 
/*  48 */         SMapFlyErrorRes mapFlyErrorRes = new SMapFlyErrorRes();
/*  49 */         mapFlyErrorRes.ret = 1;
/*  50 */         OnlineManager.getInstance().sendAtOnce(this.roleId, mapFlyErrorRes);
/*  51 */         return false;
/*     */       }
/*     */       
/*  54 */       TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId.longValue(), true);
/*  55 */       if ((!teamInfo.isLeader(this.roleId)) || (!teamInfo.getTeamNormalList().equals(normalList)))
/*     */       {
/*  57 */         GameServer.logger().info(String.format("[map]PPlayerFlyReq.processImp@team info is not consistent|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */         
/*     */ 
/*  60 */         SMapFlyErrorRes mapFlyErrorRes = new SMapFlyErrorRes();
/*  61 */         mapFlyErrorRes.ret = 1;
/*  62 */         OnlineManager.getInstance().sendAtOnce(this.roleId, mapFlyErrorRes);
/*  63 */         return false;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/*  68 */       normalList.clear();
/*     */       
/*  70 */       normalList.add(Long.valueOf(this.roleId));
/*     */     }
/*     */     
/*  73 */     Set<Integer> roleStatusSet = RoleStatusInterface.getStatusSet(this.roleId);
/*     */     
/*  75 */     if ((roleStatusSet.contains(Integer.valueOf(29))) || (roleStatusSet.contains(Integer.valueOf(28))))
/*     */     {
/*  77 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  81 */     boolean forceFly = (roleStatusSet.contains(Integer.valueOf(33))) || (roleStatusSet.contains(Integer.valueOf(1834))) || (TaskInterface.hasFlyTask(this.roleId, true));
/*     */     
/*     */ 
/*     */ 
/*  85 */     int mapCfgid = MapInterface.getRoleMapId(this.roleId);
/*  86 */     MapPrototype mapConf = MapCfgManager.getInstance().getMapProtoById(mapCfgid);
/*  87 */     if ((!forceFly) && ((mapConf == null) || (!mapConf.canFly())))
/*     */     {
/*  89 */       GameServer.logger().info(String.format("[map]PPlayerFlyReq.processImp@map can not fly|roleid=%d|mapcfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(mapCfgid) }));
/*     */       
/*     */ 
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     int feijianCfgid = AircraftInterface.getEquipedFeiJianCfgId(this.roleId, true);
/*  96 */     if (feijianCfgid <= 0)
/*     */     {
/*  98 */       if (!forceFly)
/*     */       {
/* 100 */         SMapFlyErrorRes mapFlyErrorRes = new SMapFlyErrorRes();
/* 101 */         mapFlyErrorRes.ret = 3;
/* 102 */         OnlineManager.getInstance().sendAtOnce(this.roleId, mapFlyErrorRes);
/* 103 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 107 */       feijianCfgid = SFeJianConsts.getInstance().DEFAULT_FEIJIANID;
/*     */     }
/*     */     
/* 110 */     SFeiJianCfg cfg = ItemInterface.getFeiJianCfg(feijianCfgid);
/* 111 */     if (cfg == null)
/*     */     {
/* 113 */       GameServer.logger().info(String.format("[map]PPlayerFlyReq.processImp@do not have airCraft|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/* 115 */       SMapFlyErrorRes mapFlyErrorRes = new SMapFlyErrorRes();
/* 116 */       mapFlyErrorRes.ret = 3;
/* 117 */       OnlineManager.getInstance().sendAtOnce(this.roleId, mapFlyErrorRes);
/* 118 */       return false;
/*     */     }
/*     */     
/* 121 */     boolean ret = RoleStatusInterface.setStatus(normalList, 2, true);
/* 122 */     if (!ret)
/*     */     {
/* 124 */       GameServer.logger().info(String.format("[map]PPlayerFlyReq.processImp@status can not fly|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/* 126 */       SMapFlyErrorRes mapFlyErrorRes = new SMapFlyErrorRes();
/* 127 */       mapFlyErrorRes.ret = 1;
/* 128 */       OnlineManager.getInstance().sendAtOnce(this.roleId, mapFlyErrorRes);
/* 129 */       return false;
/*     */     }
/*     */     
/* 132 */     new MMH_PlayerFly(this.roleId, this.targetX, this.targetY, cfg.velocity).execute();
/*     */     
/* 134 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\PPlayerFlyReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */