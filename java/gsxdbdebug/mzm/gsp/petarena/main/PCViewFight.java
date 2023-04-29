/*     */ package mzm.gsp.petarena.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.petarena.SViewFightFailed;
/*     */ import mzm.gsp.petarena.SViewFightSuccess;
/*     */ import mzm.gsp.petarena.confbean.SPetArenaConst;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PetArenaFightRecordInfo;
/*     */ import xbean.PetArenaInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCViewFight extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long recordid;
/*     */   
/*     */   public PCViewFight(long roleid, long recordid)
/*     */   {
/*  27 */     this.roleid = roleid;
/*  28 */     this.recordid = recordid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if (this.recordid < 0L)
/*     */     {
/*  36 */       return false;
/*     */     }
/*  38 */     if (!PetArenaManager.canDoAction(this.roleid, 2118))
/*     */     {
/*  40 */       return false;
/*     */     }
/*  42 */     if (!PetArenaManager.isFunOpen(this.roleid))
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     if ((TeamInterface.isTeamMemberNormal(this.roleid)) && (TeamInterface.getNormalRoleList(this.roleid).size() > 1))
/*     */     {
/*  49 */       onFailed(-3);
/*  50 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  54 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*  55 */     lock(Lockeys.get(User.getTable(), userid));
/*  56 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*     */     
/*  58 */     int activityCfgid = SPetArenaConst.getInstance().ACTIVITY_CFG_ID;
/*  59 */     ActivityJoinResult joinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, activityCfgid);
/*     */     
/*  61 */     if ((!joinResult.isCanJoin()) && (!joinResult.isSingleRoleTeam()))
/*     */     {
/*  63 */       onFailed(-2);
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     PetArenaInfo xPetArenaInfo = xtable.Role2petarenainfo.get(Long.valueOf(this.roleid));
/*  68 */     if (xPetArenaInfo == null)
/*     */     {
/*  70 */       onFailed(1);
/*  71 */       return false;
/*     */     }
/*  73 */     PetArenaManager.checkData(xPetArenaInfo);
/*     */     
/*  75 */     PetArenaFightRecordInfo xTargetArenaFightRecordInfo = null;
/*  76 */     for (PetArenaFightRecordInfo xFightRecordInfo : xPetArenaInfo.getRecords())
/*     */     {
/*  78 */       if (xFightRecordInfo.getRecordid() == this.recordid)
/*     */       {
/*  80 */         xTargetArenaFightRecordInfo = xFightRecordInfo;
/*     */       }
/*     */     }
/*  83 */     if (xTargetArenaFightRecordInfo == null)
/*     */     {
/*  85 */       onFailed(-1);
/*  86 */       return false;
/*     */     }
/*     */     
/*  89 */     mzm.gsp.fight.main.FightInterface.watchFightRecord(this.roleid, this.recordid);
/*     */     
/*  91 */     SViewFightSuccess rsp = new SViewFightSuccess();
/*  92 */     rsp.recordid = this.recordid;
/*  93 */     OnlineManager.getInstance().send(this.roleid, rsp);
/*     */     
/*  95 */     GameServer.logger().info(String.format("[petarena]PCViewFight.processImp@view success|roleid=%d|record=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.recordid) }));
/*     */     
/*  97 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 102 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 107 */     SViewFightFailed rsp = new SViewFightFailed();
/* 108 */     rsp.retcode = retcode;
/* 109 */     rsp.recordid = this.recordid;
/* 110 */     OnlineManager.getInstance().sendAtOnce(this.roleid, rsp);
/*     */     
/* 112 */     StringBuilder logBuilder = new StringBuilder();
/* 113 */     logBuilder.append("[petarena]PCViewFight.onFailed@failed");
/* 114 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 115 */     logBuilder.append('|').append("recordid=").append(this.recordid);
/* 116 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 118 */     if (extraParams != null)
/*     */     {
/* 120 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 122 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 126 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\PCViewFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */