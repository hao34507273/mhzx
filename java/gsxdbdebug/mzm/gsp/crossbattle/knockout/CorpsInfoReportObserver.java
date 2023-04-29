/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.corps.CorpsBriefInfo;
/*     */ import mzm.gsp.corps.main.CorpsInfo;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ import mzm.gsp.grc.main.GrcInterface;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.CorpsMember;
/*     */ 
/*     */ public class CorpsInfoReportObserver extends Observer
/*     */ {
/*     */   private final int activityCfgId;
/*     */   private final Map<Long, List<Long>> corpsId2RoleIdListMap;
/*     */   
/*     */   public CorpsInfoReportObserver(long intervalMilliSeconds, int activityCfgId, Map<Long, List<Long>> corpsId2RoleIdListMap)
/*     */   {
/*  25 */     super(intervalMilliSeconds);
/*  26 */     this.activityCfgId = activityCfgId;
/*  27 */     this.corpsId2RoleIdListMap = corpsId2RoleIdListMap;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  33 */     new POnCorpsInfoReportObserver(this.activityCfgId, this.corpsId2RoleIdListMap).execute();
/*     */     
/*  35 */     return true;
/*     */   }
/*     */   
/*     */   private static class POnCorpsInfoReportObserver extends LogicProcedure
/*     */   {
/*     */     private final int activityCfgId;
/*     */     private final Map<Long, List<Long>> corpsId2RoleIdListMap;
/*     */     
/*     */     public POnCorpsInfoReportObserver(int activityCfgId, Map<Long, List<Long>> corpsId2RoleIdListMap)
/*     */     {
/*  45 */       this.activityCfgId = activityCfgId;
/*  46 */       this.corpsId2RoleIdListMap = corpsId2RoleIdListMap;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  52 */       for (Map.Entry<Long, List<Long>> entry : this.corpsId2RoleIdListMap.entrySet())
/*     */       {
/*  54 */         corpsId = ((Long)entry.getKey()).longValue();
/*  55 */         List<Long> roleIdList = (List)entry.getValue();
/*  56 */         CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityCfgId), new CorpsInfoReportObserver.PReportCorpsInfo(this.activityCfgId, corpsId));
/*     */         
/*  58 */         for (i$ = roleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */           
/*  60 */           CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityCfgId), new CorpsInfoReportObserver.PReprotCorpsRoleInfo(this.activityCfgId, corpsId, roleId));
/*     */         }
/*     */       }
/*     */       long corpsId;
/*     */       Iterator i$;
/*  65 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PReportCorpsInfo
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final int activityCfgId;
/*     */     private final long corpsId;
/*     */     
/*     */     public PReportCorpsInfo(int activityCfgId, long corpsId)
/*     */     {
/*  77 */       this.activityCfgId = activityCfgId;
/*  78 */       this.corpsId = corpsId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  84 */       CorpsInfo corpsInfo = mzm.gsp.corps.main.CorpsInterface.getCorpsInfoByCorpsId(this.corpsId, true);
/*  85 */       if (corpsInfo == null)
/*     */       {
/*  87 */         return false;
/*     */       }
/*     */       
/*  90 */       CorpsBriefInfo corpsBriefInfo = corpsInfo.getBriefInfo();
/*     */       
/*  92 */       GrcInterface.reportCrossBattleCorpsInfo(this.activityCfgId, this.corpsId, corpsBriefInfo.declaration.getString("UTF-8"), corpsBriefInfo.createtime);
/*     */       
/*  94 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PReprotCorpsRoleInfo extends LogicProcedure
/*     */   {
/*     */     private final int activityCfgId;
/*     */     private final long corpsId;
/*     */     private final long roleId;
/*     */     
/*     */     public PReprotCorpsRoleInfo(int activityCfgId, long corpsId, long roleId)
/*     */     {
/* 106 */       this.activityCfgId = activityCfgId;
/* 107 */       this.corpsId = corpsId;
/* 108 */       this.roleId = roleId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 114 */       CorpsMember xCorpsMember = xtable.Role2corps.get(Long.valueOf(this.roleId));
/* 115 */       int duty = -1;
/* 116 */       int joinTime = (int)(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis() / 1000L);
/* 117 */       if ((xCorpsMember == null) || (xCorpsMember.getCorpsid() != this.corpsId))
/*     */       {
/*     */ 
/* 120 */         GameServer.logger().error(String.format("[crossbattle_knockout]PReprotCorpsRoleInfo.processimp@corps member null|activity_cfg_id=%d|cropsId=%d|roleId=%d", new Object[] { Integer.valueOf(this.activityCfgId), Long.valueOf(this.corpsId), Long.valueOf(this.roleId) }));
/*     */ 
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*     */ 
/* 128 */         duty = xCorpsMember.getDuty();
/* 129 */         joinTime = (int)(xCorpsMember.getJointime() / 1000L);
/*     */       }
/*     */       
/* 132 */       Role role = RoleInterface.getRole(this.roleId, true);
/* 133 */       int roleLevel = role.getLevel();
/* 134 */       int occupationId = role.getOccupationId();
/* 135 */       int avatarId = mzm.gsp.avatar.main.AvatarInterface.getCurrentAvatar(this.roleId, false);
/* 136 */       int gender = role.getGender();
/* 137 */       String roleName = role.getName();
/* 138 */       int lastLogOffTime = (int)(role.getLastLogoffTime() / 1000L);
/*     */       
/* 140 */       int multifightvalue = RoleInterface.getRoleMFValue(this.roleId);
/* 141 */       int mfvrank = RoleInterface.getRoleOccupatinMFVRank(this.roleId);
/*     */       
/* 143 */       GrcInterface.reportCrossBattleCorpsRoleInfo(this.activityCfgId, this.corpsId, this.roleId, roleName, occupationId, roleLevel, avatarId, multifightvalue, mfvrank, gender, joinTime, duty, lastLogOffTime);
/*     */       
/* 145 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\CorpsInfoReportObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */