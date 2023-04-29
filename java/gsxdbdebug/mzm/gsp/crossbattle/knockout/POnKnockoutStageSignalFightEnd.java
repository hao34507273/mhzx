/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.avatar.main.AvatarInterface;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*     */ import mzm.gsp.crossbattle.event.KnockOutSignalFightEndArg;
/*     */ import mzm.gsp.crossbattle.event.KnockOutSignalFightEndProcedure;
/*     */ import mzm.gsp.crossbattle.own.CrossBattleOwnInterface;
/*     */ import mzm.gsp.grc.main.GrcInterface;
/*     */ import mzm.gsp.pubdata.ModelInfo;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import xbean.CorpsMember;
/*     */ import xdb.Executor;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ public class POnKnockoutStageSignalFightEnd extends KnockOutSignalFightEndProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  24 */     int activityCfgId = CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID;
/*     */     
/*  26 */     long corpsId = ((KnockOutSignalFightEndArg)this.arg).corpsId;
/*     */     
/*  28 */     List<Long> roleIdList = CrossBattleOwnInterface.getCrossBattleRegisterRoleList(corpsId, activityCfgId, true);
/*  29 */     if (roleIdList == null)
/*     */     {
/*  31 */       return false;
/*     */     }
/*  33 */     for (Iterator i$ = roleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*  35 */       new PReportFightEndCorpsRoleInfo(activityCfgId, ((KnockOutSignalFightEndArg)this.arg).corpsId, roleId, ((KnockOutSignalFightEndArg)this.arg).knockOutType, ((KnockOutSignalFightEndArg)this.arg).stage).execute();
/*     */     }
/*     */     
/*  38 */     return true;
/*     */   }
/*     */   
/*     */   private static class PReportFightEndCorpsRoleInfo
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final int activityCfgId;
/*     */     private final long corpsId;
/*     */     private final long roleId;
/*     */     private final int knockOutType;
/*     */     private final int stage;
/*     */     
/*     */     public PReportFightEndCorpsRoleInfo(int activityCfgId, long corpsId, long roleId, int knockOutType, int stage)
/*     */     {
/*  52 */       this.activityCfgId = activityCfgId;
/*  53 */       this.corpsId = corpsId;
/*  54 */       this.roleId = roleId;
/*  55 */       this.knockOutType = knockOutType;
/*  56 */       this.stage = stage;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  62 */       CorpsMember xCorpsMember = xtable.Role2corps.get(Long.valueOf(this.roleId));
/*  63 */       int duty = 2;
/*  64 */       int joinTime = (int)(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis() / 1000L);
/*  65 */       if ((xCorpsMember == null) || (xCorpsMember.getCorpsid() != this.corpsId))
/*     */       {
/*  67 */         GameServer.logger().error(String.format("[crossbattle_knockout]PReprotFightEndCorpsRoleInfo.processimp@corps member null|activity_cfg_id=%d|cropsId=%d|roleId=%d|knock_out_type=%d|stage=%d", new Object[] { Integer.valueOf(this.activityCfgId), Long.valueOf(this.corpsId), Long.valueOf(this.roleId), Integer.valueOf(this.knockOutType), Integer.valueOf(this.stage) }));
/*     */ 
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*  74 */         duty = xCorpsMember.getDuty();
/*  75 */         joinTime = (int)(xCorpsMember.getJointime() / 1000L);
/*     */       }
/*     */       
/*  78 */       Role role = RoleInterface.getRole(this.roleId, true);
/*  79 */       int roleLevel = role.getLevel();
/*  80 */       int occupationId = role.getOccupationId();
/*  81 */       int avatarId = AvatarInterface.getCurrentAvatar(this.roleId, true);
/*  82 */       int gender = role.getGender();
/*  83 */       String roleName = role.getName();
/*     */       
/*  85 */       int multifightvalue = RoleInterface.getRoleMFValue(this.roleId);
/*  86 */       int mfvrank = RoleInterface.getRoleOccupatinMFVRank(this.roleId);
/*     */       
/*  88 */       ModelInfo modelInfo = new ModelInfo();
/*  89 */       role.fillModelInfo(modelInfo);
/*     */       
/*  91 */       boolean isSendSuccess = GrcInterface.reportCrossBattleStageFightEndCorpsRoleInfo(this.activityCfgId, this.knockOutType, this.stage, this.corpsId, this.roleId, roleName, occupationId, roleLevel, avatarId, multifightvalue, mfvrank, gender, joinTime, duty, modelInfo);
/*     */       
/*     */ 
/*  94 */       if (!isSendSuccess)
/*     */       {
/*  96 */         Xdb.executor().schedule(new POnKnockoutStageSignalFightEnd.RRepeatReportCrossBattleStageFightEndCorpsRoleInfo(this.activityCfgId, this.knockOutType, this.stage, this.corpsId, this.roleId, roleName, occupationId, roleLevel, avatarId, multifightvalue, mfvrank, gender, joinTime, duty, modelInfo), 60000L, TimeUnit.MICROSECONDS);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 105 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class RRepeatReportCrossBattleStageFightEndCorpsRoleInfo
/*     */     implements Runnable
/*     */   {
/*     */     private final int activityCfgId;
/*     */     
/*     */     private final int knockOutType;
/*     */     private final int fightStage;
/*     */     private final long corpsId;
/*     */     private final long roleId;
/*     */     private final String roleName;
/*     */     private final int occupationId;
/*     */     private final int roleLevel;
/*     */     private final int avatarId;
/*     */     private final int multifightvalue;
/*     */     private final int mfvrank;
/*     */     private final int gender;
/*     */     private final int joinTime;
/*     */     private final int duty;
/*     */     private final ModelInfo modelInfo;
/*     */     private int repeatTimes;
/*     */     
/*     */     public RRepeatReportCrossBattleStageFightEndCorpsRoleInfo(int activityCfgId, int knockOutType, int fightStage, long corpsId, long roleId, String roleName, int occupationId, int roleLevel, int avatarId, int multifightvalue, int mfvrank, int gender, int joinTime, int duty, ModelInfo modelInfo)
/*     */     {
/* 133 */       this.activityCfgId = activityCfgId;
/* 134 */       this.knockOutType = knockOutType;
/* 135 */       this.fightStage = fightStage;
/* 136 */       this.corpsId = corpsId;
/* 137 */       this.roleId = roleId;
/* 138 */       this.roleName = roleName;
/* 139 */       this.occupationId = occupationId;
/* 140 */       this.roleLevel = roleLevel;
/* 141 */       this.avatarId = avatarId;
/* 142 */       this.multifightvalue = multifightvalue;
/* 143 */       this.mfvrank = mfvrank;
/* 144 */       this.gender = gender;
/* 145 */       this.joinTime = joinTime;
/* 146 */       this.duty = duty;
/* 147 */       this.modelInfo = modelInfo;
/* 148 */       this.repeatTimes = 1;
/*     */     }
/*     */     
/*     */ 
/*     */     public void run()
/*     */     {
/* 154 */       boolean isSendSuccess = GrcInterface.reportCrossBattleStageFightEndCorpsRoleInfo(this.activityCfgId, this.knockOutType, this.fightStage, this.corpsId, this.roleId, this.roleName, this.occupationId, this.roleLevel, this.avatarId, this.multifightvalue, this.mfvrank, this.gender, this.joinTime, this.duty, this.modelInfo);
/*     */       
/*     */ 
/* 157 */       if (!isSendSuccess)
/*     */       {
/* 159 */         this.repeatTimes += 1;
/* 160 */         Xdb.executor().schedule(this, 60000L, TimeUnit.MICROSECONDS);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\POnKnockoutStageSignalFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */