/*     */ package mzm.gsp.teamplatform.match;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.confbean.STeamPlatformMomCfg;
/*     */ import mzm.gsp.team.confbean.TeamPlatformConsts;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.teamplatform.TeamInfo;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MatchActivityCfg;
/*     */ import xbean.MatchKey;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RoleMatchInfo
/*     */ {
/*     */   private long roleId;
/*     */   private boolean remainMatchLock;
/*     */   private MatchActivityCfg xMatchInfo;
/*     */   
/*     */   public RoleMatchInfo(long roleId, boolean remainMatchLock)
/*     */   {
/*  30 */     this.roleId = roleId;
/*  31 */     this.remainMatchLock = remainMatchLock;
/*  32 */     this.xMatchInfo = TeamMatchMananger.getRoleActivity(roleId, remainMatchLock);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getRoleId()
/*     */   {
/*  42 */     return this.roleId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isRemainMatchLock()
/*     */   {
/*  52 */     return this.remainMatchLock;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public MatchActivityCfg getXMatchInfo()
/*     */   {
/*  62 */     return this.xMatchInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean inMatchQueue()
/*     */   {
/*  72 */     return this.xMatchInfo != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isSingleMatch()
/*     */   {
/*  82 */     return this.xMatchInfo.getMatchtype() == 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isTeamMatch()
/*     */   {
/*  92 */     return this.xMatchInfo.getMatchtype() == 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isTakeNew()
/*     */   {
/* 102 */     return (this.xMatchInfo.getLevelhigh() == 0) && (this.xMatchInfo.getLevellow() == 0);
/*     */   }
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
/*     */   public boolean isMatchNewGuyIng()
/*     */   {
/* 116 */     return RoleInterface.getLevel(this.roleId) >= this.xMatchInfo.getNeedlevelhigh();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Integer> getRoleSelectLevelRange()
/*     */   {
/* 126 */     return Arrays.asList(new Integer[] { Integer.valueOf(this.xMatchInfo.getLevellow()), Integer.valueOf(this.xMatchInfo.getLevelhigh()) });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Integer> getRoleNowNeedLevelRange()
/*     */   {
/* 136 */     return Arrays.asList(new Integer[] { Integer.valueOf(this.xMatchInfo.getNeedlevellow()), Integer.valueOf(this.xMatchInfo.getNeedlevelhigh()) });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<RoleActivityCfg> getRoleMatchActivtys()
/*     */   {
/* 149 */     List<RoleActivityCfg> activityCfgs = new ArrayList();
/* 150 */     RoleActivityCfg activity = new RoleActivityCfg(this.xMatchInfo.getActivity().getActivityid(), this.xMatchInfo.getActivity().getIndex());
/*     */     
/* 152 */     activityCfgs.add(activity);
/* 153 */     return activityCfgs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public RoleActivityCfg getRoleMatchActivityCfg()
/*     */   {
/* 163 */     return new RoleActivityCfg(this.xMatchInfo.getActivity().getActivityid(), this.xMatchInfo.getActivity().getIndex());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getTakeNewGuyNum()
/*     */   {
/* 173 */     int momCfgId = this.xMatchInfo.getActivity().getActivityid();
/* 174 */     STeamPlatformMomCfg cfg = STeamPlatformMomCfg.get(momCfgId);
/* 175 */     if (cfg == null)
/*     */     {
/* 177 */       return 0;
/*     */     }
/* 179 */     return cfg.newGuyNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Integer> getTakeNewLevelRange()
/*     */   {
/* 189 */     ArrayList<Integer> levelRange = new ArrayList();
/* 190 */     if (!isTeamMatch())
/*     */     {
/* 192 */       return levelRange;
/*     */     }
/* 194 */     if (!isTakeNew())
/*     */     {
/* 196 */       return levelRange;
/*     */     }
/* 198 */     RoleActivityCfg cfg = getRoleMatchActivityCfg();
/* 199 */     return TeamMatchInterface.getRoleNewGuyRange(cfg.getMomCfgId(), cfg.getIndex(), this.roleId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Integer> getNeedShowLevelRange()
/*     */   {
/* 209 */     ArrayList<Integer> levelRange = new ArrayList();
/* 210 */     if (!isTeamMatch())
/*     */     {
/* 212 */       return levelRange;
/*     */     }
/* 214 */     if (!isTakeNew())
/*     */     {
/* 216 */       levelRange.addAll(getRoleSelectLevelRange());
/*     */     }
/*     */     else
/*     */     {
/* 220 */       RoleActivityCfg cfg = getRoleMatchActivityCfg();
/* 221 */       levelRange.addAll(TeamMatchInterface.getRoleNewGuyRange(cfg.getMomCfgId(), cfg.getIndex(), this.roleId));
/*     */     }
/* 223 */     checkShowLevel(levelRange);
/* 224 */     return levelRange;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void checkShowLevel(ArrayList<Integer> levelRange)
/*     */   {
/* 234 */     if ((levelRange.size() != 2) || (((Integer)levelRange.get(0)).intValue() > ((Integer)levelRange.get(1)).intValue()))
/*     */     {
/* 236 */       int level = RoleInterface.getLevel(this.roleId);
/* 237 */       levelRange.clear();
/* 238 */       levelRange.add(Integer.valueOf(level - TeamPlatformConsts.getInstance().LEVEL_LITTLE_TOP));
/* 239 */       levelRange.add(Integer.valueOf(level + TeamPlatformConsts.getInstance().LEVEL_LITTLE_TOP));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   TeamInfo getPTeamInfo()
/*     */   {
/* 253 */     TeamInfo pTeamInfo = new TeamInfo();
/* 254 */     return fillPTeamInfo(pTeamInfo) ? pTeamInfo : null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean fillPTeamInfo(TeamInfo teamInfo)
/*     */   {
/* 267 */     if (!isTeamMatch())
/*     */     {
/* 269 */       GameServer.logger().error(String.format("[teammatch]RoleMatchInfo.fillPTeamInfo@ not team type match!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/* 271 */       return false;
/*     */     }
/* 273 */     if (teamInfo == null)
/*     */     {
/* 275 */       teamInfo = new TeamInfo();
/*     */     }
/*     */     
/* 278 */     Long teamId = TeamInterface.getTeamidByRoleid(this.roleId, false);
/* 279 */     if (teamId == null)
/*     */     {
/* 281 */       GameServer.logger().error(String.format("[teammatch]RoleMatchInfo.fillPTeamInfo@ not in team!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/* 282 */       return false;
/*     */     }
/* 284 */     RoleActivityCfg activityCfg = getRoleMatchActivityCfg();
/* 285 */     if (activityCfg.getMomCfgId() <= 0)
/*     */     {
/* 287 */       GameServer.logger().error(String.format("[teammatch]RoleMatchInfo.fillPTeamInfo@ get RoleActivityCfg err!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/* 289 */       return false;
/*     */     }
/*     */     
/* 292 */     TeamMatchMananger.fillTeamInfo(teamId.longValue(), this.roleId, teamInfo, this.xMatchInfo.getLevellow(), this.xMatchInfo.getLevelhigh(), activityCfg.getMomCfgId(), activityCfg.getIndex(), false);
/*     */     
/* 294 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\RoleMatchInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */