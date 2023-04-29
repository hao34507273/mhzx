/*     */ package mzm.gsp.msdkprofile.main.wechat;
/*     */ 
/*     */ import mzm.gsp.msdkprofile.main.Reporter;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReporterImp
/*     */   implements Reporter
/*     */ {
/*     */   public boolean reportRoleLevel(String userid, long roleid, int level)
/*     */   {
/*  14 */     StringBuilder log = new StringBuilder();
/*  15 */     log.append(roleid).append('|');
/*  16 */     log.append(level);
/*     */     
/*  18 */     TLogManager.getInstance().addLog(roleid, "LevelRankFlow", log.toString());
/*  19 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean reportRoleRankScore(String userid, long roleid, int rankScore, long expire)
/*     */   {
/*  25 */     StringBuilder log = new StringBuilder();
/*  26 */     log.append(roleid).append('|');
/*  27 */     log.append(rankScore).append('|');
/*  28 */     log.append(expire);
/*     */     
/*  30 */     TLogManager.getInstance().addLog(roleid, "FlowerRankFlow", log.toString());
/*  31 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean reportRoleFightValue(String userid, long roleid, int fightValue)
/*     */   {
/*  37 */     StringBuilder log = new StringBuilder();
/*  38 */     log.append(roleid).append('|');
/*  39 */     log.append(fightValue);
/*     */     
/*  41 */     TLogManager.getInstance().addLog(roleid, "FightValueRankFlow", log.toString());
/*  42 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean reportRoleOnlineSeconds(String userid, long roleid, int seconds)
/*     */   {
/*  49 */     StringBuilder log = new StringBuilder();
/*  50 */     log.append(roleid).append('|');
/*  51 */     log.append(RoleInterface.getFightValue(roleid));
/*     */     
/*  53 */     TLogManager.getInstance().addLog(roleid, "FightValueRankFlow", log.toString());
/*  54 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean reportRoleLogin(String userid, long roleid)
/*     */   {
/*  61 */     StringBuilder log = new StringBuilder();
/*  62 */     log.append(roleid).append('|');
/*  63 */     log.append(RoleInterface.getFightValue(roleid));
/*     */     
/*  65 */     TLogManager.getInstance().addLog(roleid, "FightValueRankFlow", log.toString());
/*  66 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean reportScore(String userid, long roleid, String param)
/*     */   {
/*  73 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean reportRoleCash(String userid, long roleid, long cash)
/*     */   {
/*  80 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean reportRoleCreate(String userid, long roleid)
/*     */   {
/*  87 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean reportRoleName(String userid, long roleid)
/*     */   {
/*  94 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean reportRoleRecharge(String userid, long roleid, long oldSaveAmt, long currSaveAmt)
/*     */   {
/* 101 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean reportGangName(String userid, long roleid, long gangId, String gangName)
/*     */   {
/* 108 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean reportGangLevel(String userid, long roleid, long gangId, int gangLevel)
/*     */   {
/* 115 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean reportGangCreate(String userid, long roleid, long gangId)
/*     */   {
/* 122 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean reportGangDestory(String userid, long roleid, long gangid)
/*     */   {
/* 129 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean reportGangMemberJoin(String userid, long roleid, long gangId)
/*     */   {
/* 136 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean reportGangMemberExit(String userid, long roleid, long gangId)
/*     */   {
/* 143 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean reportGangPositionChange(String userid, long roleid, long gangId, int type)
/*     */   {
/* 150 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean reportGangBindQQ(String userid, long roleid, long gangId, String qq)
/*     */   {
/* 157 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean reportGangMemberAbility(String userid, long roleid, long gangId, int value)
/*     */   {
/* 164 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\msdkprofile\main\wechat\ReporterImp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */