/*     */ package mzm.gsp.teamplatform.match;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import mzm.gsp.buff.main.BuffInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.team.SBeFiredProtectStateChange;
/*     */ import mzm.gsp.team.confbean.TeamConsts;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xtable.Basic;
/*     */ 
/*     */ public class POnTeamMatchBuffChange
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int buffId;
/*     */   private final int type;
/*     */   
/*     */   public POnTeamMatchBuffChange(long roleId, int buffId, int type)
/*     */   {
/*  23 */     this.roleId = roleId;
/*  24 */     this.buffId = buffId;
/*  25 */     this.type = type;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  31 */     if (this.buffId != TeamConsts.getInstance().ROLE_MATCH_TEAM_BUF)
/*     */     {
/*  33 */       return false;
/*     */     }
/*  35 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/*  36 */     if (teamInfo == null)
/*     */     {
/*  38 */       return false;
/*     */     }
/*  40 */     long teamId = teamInfo.getTeamId();
/*     */     
/*  42 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  43 */     teamInfo = TeamInterface.getTeamInfo(teamId, true);
/*  44 */     if (!checkLock(teamInfo))
/*     */     {
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     return sendProtectStateChange(teamInfo.getTeamMemberList());
/*     */   }
/*     */   
/*     */   private boolean sendProtectStateChange(List<Long> members)
/*     */   {
/*  54 */     SBeFiredProtectStateChange pro = new SBeFiredProtectStateChange();
/*  55 */     pro.roleid = this.roleId;
/*  56 */     switch (this.type)
/*     */     {
/*     */     case 0: 
/*  59 */       if (BuffInterface.isContainBuff(this.roleId, this.buffId))
/*     */       {
/*  61 */         return false;
/*     */       }
/*  63 */       pro.protectstate = 2;
/*     */       
/*  65 */       break;
/*     */     case 1: 
/*  67 */       if (!BuffInterface.isContainBuff(this.roleId, this.buffId))
/*     */       {
/*  69 */         return false;
/*     */       }
/*  71 */       pro.protectstate = 1;
/*     */       
/*  73 */       break;
/*     */     
/*     */ 
/*     */     default: 
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     OnlineManager.getInstance().sendMulti(pro, members);
/*  81 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkLock(TeamInfo teamInfo)
/*     */   {
/*  92 */     if (teamInfo == null)
/*     */     {
/*  94 */       return false;
/*     */     }
/*  96 */     if (!teamInfo.getTeamMemberList().contains(Long.valueOf(this.roleId)))
/*     */     {
/*  98 */       return false;
/*     */     }
/* 100 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\POnTeamMatchBuffChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */