/*     */ package mzm.gsp.jiuxiao.main;
/*     */ 
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.JoinTeamResult;
/*     */ import mzm.gsp.team.main.JoinTeamResult.Receiver;
/*     */ import mzm.gsp.team.main.JoinTeamResult.Result;
/*     */ import mzm.gsp.team.main.JoinTeamType;
/*     */ import mzm.gsp.team.main.ReturnTeamResult;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import xbean.JiuXiaoActivityBean;
/*     */ import xbean.JiuXiaoActivityInfo;
/*     */ 
/*     */ class JoinTeamCheck implements mzm.gsp.team.main.JoinTeamCheckHandler
/*     */ {
/*     */   private int activityid;
/*     */   
/*     */   public JoinTeamCheck(int activityid)
/*     */   {
/*  22 */     this.activityid = activityid;
/*     */   }
/*     */   
/*     */ 
/*     */   public JoinTeamResult canJoinTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId, boolean tf2LeaderAftJoin, JoinTeamType joinTeamType)
/*     */   {
/*  28 */     JoinTeamResult joinTeamResult = new JoinTeamResult();
/*  29 */     joinTeamResult.setSucceed(true);
/*  30 */     long leaderid = teamInfo.getLeaderId();
/*  31 */     int mapCfgid = MapInterface.getRoleMapId(leaderid);
/*  32 */     if (JiuXiaoCfgManager.isJiuXiaoMap(this.activityid, mapCfgid)) {
/*  33 */       JiuXiaoActivityBean xJiuXiaoActivityBean = xtable.Jiuxiaotable.select(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/*     */       
/*  35 */       if (xJiuXiaoActivityBean == null) {
/*  36 */         return joinTeamResult;
/*     */       }
/*  38 */       JiuXiaoActivityInfo xJiuXiaoActivityInfo = (JiuXiaoActivityInfo)xJiuXiaoActivityBean.getActivityinfomap().get(Integer.valueOf(this.activityid));
/*  39 */       if (xJiuXiaoActivityInfo == null) {
/*  40 */         return joinTeamResult;
/*     */       }
/*  42 */       if (leaderWorldId != xJiuXiaoActivityInfo.getWorldid()) {
/*  43 */         return joinTeamResult;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*  48 */       if (ActivityInterface.isInActivityLevelByLevel(this.activityid, mzm.gsp.role.main.RoleInterface.getLevel(roleId))) {
/*  49 */         if (tf2LeaderAftJoin) {
/*  50 */           boolean ret = (OpenInterface.getOpenStatus(13)) && (!OpenInterface.isBanPlay(roleId, 13));
/*     */           
/*  52 */           if (ret) {
/*  53 */             ret = RoleStatusInterface.setStatus(roleId, 19, false);
/*  54 */             JiuXiaoManager.setJiuxiaoActivityid(roleId, this.activityid);
/*     */           }
/*  56 */           if (!ret) {
/*  57 */             joinTeamResult.setSucceed(false);
/*  58 */             if (joinTeamType == JoinTeamType.JOIN_TEAM__APPLY)
/*     */             {
/*  60 */               JoinTeamResult.Result result = new JoinTeamResult.Result(123, new String[0]);
/*     */               
/*  62 */               joinTeamResult.addResult(JoinTeamResult.Receiver.Leader, result);
/*  63 */             } else if (joinTeamType == JoinTeamType.JOIN_TEAM__INVITE)
/*     */             {
/*  65 */               JoinTeamResult.Result result = new JoinTeamResult.Result(124, new String[0]);
/*     */               
/*  67 */               joinTeamResult.addResult(JoinTeamResult.Receiver.Member, result);
/*     */             }
/*     */           }
/*     */         }
/*  71 */         return joinTeamResult;
/*     */       }
/*  73 */       joinTeamResult.setSucceed(false);
/*     */       
/*  75 */       if (joinTeamType == JoinTeamType.JOIN_TEAM__APPLY)
/*     */       {
/*  77 */         JoinTeamResult.Result result = new JoinTeamResult.Result(121, new String[0]);
/*     */         
/*  79 */         joinTeamResult.addResult(JoinTeamResult.Receiver.Leader, result);
/*  80 */       } else if (joinTeamType == JoinTeamType.JOIN_TEAM__INVITE)
/*     */       {
/*  82 */         JoinTeamResult.Result result = new JoinTeamResult.Result(122, new String[0]);
/*     */         
/*  84 */         joinTeamResult.addResult(JoinTeamResult.Receiver.Member, result);
/*     */       }
/*     */     }
/*     */     
/*  88 */     return joinTeamResult;
/*     */   }
/*     */   
/*     */   public ReturnTeamResult canReturnTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId)
/*     */   {
/*  93 */     ReturnTeamResult returnTeamResult = new ReturnTeamResult();
/*  94 */     returnTeamResult.setSucceed(true);
/*  95 */     boolean isLeaderInJiuXiao = RoleStatusInterface.containsStatus(teamInfo.getLeaderId(), 19);
/*     */     
/*  97 */     if (isLeaderInJiuXiao) {
/*  98 */       boolean ret = (OpenInterface.getOpenStatus(13)) && (!OpenInterface.isBanPlay(roleId, 13));
/*     */       
/* 100 */       if (ret) {
/* 101 */         JiuXiaoManager.setJiuxiaoActivityid(roleId, this.activityid);
/* 102 */         ret = RoleStatusInterface.setStatus(roleId, 19, false);
/*     */       }
/* 104 */       if (!ret) {
/* 105 */         returnTeamResult.setSucceed(false);
/* 106 */         returnTeamResult.setResult(new mzm.gsp.team.main.ReturnTeamResult.Result(125, new String[0]));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 111 */     return returnTeamResult;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\main\JoinTeamCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */