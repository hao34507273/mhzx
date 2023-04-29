/*     */ package mzm.gsp.singlebattle.gm;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.gm.main.GmManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.singlebattle.main.CreateSingleBattleInfo;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ 
/*     */ public class PGM_StartSingleBattle
/*     */   extends LogicRunnable
/*     */ {
/*     */   private final long roleId;
/*     */   private final long passiveRoleId;
/*     */   private final int battleCfgId;
/*     */   
/*     */   public PGM_StartSingleBattle(long roleId, long passiveRoleId, int battleCfgId)
/*     */   {
/*  23 */     this.roleId = roleId;
/*  24 */     this.passiveRoleId = passiveRoleId;
/*  25 */     this.battleCfgId = battleCfgId;
/*     */   }
/*     */   
/*  28 */   private Set<Long> roleIds1 = new HashSet();
/*  29 */   private Set<Long> roleIds2 = new HashSet();
/*     */   
/*     */   public void process()
/*     */     throws Exception
/*     */   {
/*  34 */     if (this.roleId == this.passiveRoleId)
/*     */     {
/*  36 */       return;
/*     */     }
/*  38 */     if (!RoleInterface.isRoleExist(this.passiveRoleId, false))
/*     */     {
/*  40 */       GmManager.getInstance().sendResultToGM(this.roleId, String.format("玩家不存在呐~RoleId=%d", new Object[] { Long.valueOf(this.passiveRoleId) }));
/*  41 */       return;
/*     */     }
/*     */     
/*  44 */     TeamInfo teamInfo1 = TeamInterface.getTeamInfoByRoleId(this.roleId);
/*  45 */     if (teamInfo1 == null)
/*     */     {
/*  47 */       this.roleIds1.add(Long.valueOf(this.roleId));
/*     */     }
/*     */     else
/*     */     {
/*  51 */       this.roleIds1.addAll(teamInfo1.getTeamMemberList());
/*     */     }
/*     */     
/*  54 */     TeamInfo teamInfo2 = TeamInterface.getTeamInfoByRoleId(this.passiveRoleId);
/*  55 */     if (teamInfo2 == null)
/*     */     {
/*  57 */       this.roleIds2.add(Long.valueOf(this.passiveRoleId));
/*     */     }
/*     */     else
/*     */     {
/*  61 */       this.roleIds2.addAll(teamInfo2.getTeamMemberList());
/*     */     }
/*     */     
/*  64 */     CreateSingleBattleInfo res = SingleBattleInterface.startSingleBattle(this.battleCfgId, this.roleIds1, this.roleIds2, new GM_BattleContext());
/*     */     
/*  66 */     if (res.get_battleId() <= 0L)
/*     */     {
/*  68 */       GmManager.getInstance().sendResultToGM(this.roleId, "创建战场失败！");
/*  69 */       return;
/*     */     }
/*     */     
/*     */ 
/*  73 */     if (!dismissTeams(teamInfo1, teamInfo2))
/*     */     {
/*  75 */       GmManager.getInstance().sendResultToGM(this.roleId, "解散队伍出错！");
/*  76 */       return;
/*     */     }
/*     */     
/*     */ 
/*  80 */     for (Iterator i$ = this.roleIds1.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*  82 */       SingleBattleInterface.joinBattle(res.get_battleId(), roleId);
/*     */     }
/*  84 */     for (Iterator i$ = this.roleIds2.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*  86 */       SingleBattleInterface.joinBattle(res.get_battleId(), roleId);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean dismissTeams(TeamInfo teamInfo1, TeamInfo teamInfo2)
/*     */   {
/*  92 */     boolean res = true;
/*  93 */     if (teamInfo1 != null)
/*     */     {
/*  95 */       res = TeamInterface.activeDismissTeamSyn(teamInfo1.getTeamId());
/*     */     }
/*  97 */     if (teamInfo2 != null)
/*     */     {
/*  99 */       res = TeamInterface.activeDismissTeamSyn(teamInfo2.getTeamId());
/*     */     }
/* 101 */     return res;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\gm\PGM_StartSingleBattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */