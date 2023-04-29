/*     */ package mzm.gsp.prison.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pk.confbean.SPKConsts;
/*     */ import mzm.gsp.pk.event.MoralValueChangeArg;
/*     */ import mzm.gsp.prison.SNotifyPutInJail;
/*     */ import mzm.gsp.prison.event.PutRoleInJailArg;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.wanted.main.PageManager;
/*     */ import xbean.JailProtectInfo;
/*     */ import xbean.JailStatInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.PrisonInfo;
/*     */ import xbean.PrisonRank;
/*     */ import xtable.Prisonrank;
/*     */ import xtable.Role2jailprotect;
/*     */ import xtable.Role2jailstatinfo;
/*     */ import xtable.Role2prisoninfo;
/*     */ 
/*     */ public class PrisonPageManager extends PageManager<Long>
/*     */ {
/*     */   private PrisonPageManager(int countPerPage)
/*     */   {
/*  39 */     super(countPerPage);
/*     */   }
/*     */   
/*     */   private static class InstanceHolder
/*     */   {
/*  44 */     private static final PrisonPageManager INSTANCE = new PrisonPageManager(SPKConsts.getInstance().PRISON_RECORD_COUNT_PER_PAGE, null);
/*     */   }
/*     */   
/*     */ 
/*     */   public static PrisonPageManager getInstance()
/*     */   {
/*  50 */     return InstanceHolder.INSTANCE;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void loadDataFromDB()
/*     */   {
/*  57 */     PrisonRank xPrisonRank = Prisonrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  58 */     if (xPrisonRank == null)
/*     */     {
/*  60 */       return;
/*     */     }
/*  62 */     long requiredOnlineTime = TimeUnit.MINUTES.toMillis(SPKConsts.getInstance().PRISON_SERVE_MINUTES);
/*  63 */     this.recordsLock.writeLock().lock();
/*     */     try
/*     */     {
/*  66 */       for (i$ = xPrisonRank.getRoleids().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */         
/*  68 */         PrisonInfo xPrisonInfo = Role2prisoninfo.select(Long.valueOf(roleId));
/*  69 */         if (xPrisonInfo.getInjailonlinetime() < requiredOnlineTime)
/*     */         {
/*     */ 
/*     */ 
/*  73 */           this.records.add(Long.valueOf(roleId));
/*     */         }
/*     */       }
/*     */     } finally {
/*     */       Iterator i$;
/*  78 */       this.recordsLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void deleteRecordInDB(Long roleId)
/*     */   {
/*  86 */     PrisonRank xPrisonRank = Prisonrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  87 */     if (xPrisonRank == null)
/*     */     {
/*  89 */       return;
/*     */     }
/*  91 */     xPrisonRank.getRoleids().remove(roleId);
/*     */     
/*     */ 
/*  94 */     PrisonInfo xPrisonInfo = Role2prisoninfo.get(roleId);
/*  95 */     if (xPrisonInfo == null)
/*     */     {
/*  97 */       return;
/*     */     }
/*     */     
/*     */ 
/* 101 */     Session.removeSession(xPrisonInfo.getSessionid());
/* 102 */     Role2prisoninfo.remove(roleId);
/*     */     
/* 104 */     this.recordsLock.writeLock().lock();
/*     */     try
/*     */     {
/* 107 */       this.removedFromRecords.remove(roleId);
/*     */     }
/*     */     finally
/*     */     {
/* 111 */       this.recordsLock.writeLock().unlock();
/*     */     }
/*     */     
/*     */ 
/* 115 */     JailProtectInfo xJailProtectInfo = Role2jailprotect.get(roleId);
/* 116 */     if (xJailProtectInfo == null)
/*     */     {
/* 118 */       xJailProtectInfo = Pod.newJailProtectInfo();
/* 119 */       Role2jailprotect.insert(roleId, xJailProtectInfo);
/*     */     }
/* 121 */     Session.removeSession(xJailProtectInfo.getSessionid(), roleId.longValue());
/* 122 */     Session session = new JailProtectSession(TimeUnit.MINUTES.toSeconds(SPKConsts.getInstance().LEAVE_PRISON_FORBIDDEN_PK_MINUTES), roleId.longValue());
/*     */     
/* 124 */     xJailProtectInfo.setSessionid(session.getSessionId());
/* 125 */     xJailProtectInfo.setLeavejailtimestamp(DateTimeUtils.getCurrTimeInMillis());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void addRecordToDB(Long roleId)
/*     */   {
/* 132 */     PrisonRank xPrisonRank = Prisonrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 133 */     if (xPrisonRank == null)
/*     */     {
/* 135 */       xPrisonRank = Pod.newPrisonRank();
/* 136 */       Prisonrank.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xPrisonRank);
/*     */     }
/* 138 */     xPrisonRank.getRoleids().add(roleId);
/*     */     
/* 140 */     PrisonInfo xPrisonInfo = Pod.newPrisonInfo();
/* 141 */     Session session = new RoleOutOfJailSession(TimeUnit.MINUTES.toSeconds(SPKConsts.getInstance().PRISON_SERVE_MINUTES), roleId.longValue());
/*     */     
/* 143 */     xPrisonInfo.setSessionid(session.getSessionId());
/* 144 */     xPrisonInfo.setJailaction(1);
/*     */     
/* 146 */     Role2prisoninfo.insert(roleId, xPrisonInfo);
/*     */     
/* 148 */     JailStatInfo xJailStatInfo = Role2jailstatinfo.get(roleId);
/* 149 */     if (xJailStatInfo == null)
/*     */     {
/* 151 */       xJailStatInfo = Pod.newJailStatInfo();
/* 152 */       Role2jailstatinfo.insert(roleId, xJailStatInfo);
/*     */     }
/* 154 */     xJailStatInfo.setJailcount(xJailStatInfo.getJailcount() + 1);
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onDeleteRecordFromList(Long roleId)
/*     */     throws Exception
/*     */   {
/* 161 */     RoleStatusInterface.unsetStatus(roleId.longValue(), 1661);
/*     */     
/* 163 */     RoleStatusInterface.setStatus(roleId.longValue(), 1662, false);
/*     */     
/* 165 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.prison.event.RoleOutOfJail(), new mzm.gsp.prison.event.RoleOutOfJailArg(roleId.longValue()));
/*     */     
/* 167 */     if (TeamInterface.isRoleInTeam(roleId.longValue(), true))
/*     */     {
/*     */ 
/* 170 */       RoleStatusInterface.setStatus(roleId.longValue(), 1669, false);
/* 171 */       TeamInterface.leaveTeamNoneRealTime(roleId.longValue());
/*     */     }
/*     */     else
/*     */     {
/* 175 */       MapInterface.forceTransferToScene(roleId.longValue(), MapInterface.getBigWorldid(), SPKConsts.getInstance().LEAVE_PRISON_MAP_ID);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 180 */     long curMoral = MallInterface.getJifen(roleId.longValue(), 7);
/* 181 */     MallInterface.addJifen(roleId.longValue(), SPKConsts.getInstance().LEAVE_PRISON_MORAL_VALUE - curMoral, 7, false, new TLogArg(LogReason.JAIL_OUT_ADD_MORAL));
/*     */     
/*     */ 
/* 184 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.pk.event.MoralValueChanged(), new MoralValueChangeArg(roleId.longValue(), (int)curMoral, SPKConsts.getInstance().LEAVE_PRISON_MORAL_VALUE));
/*     */     
/*     */ 
/* 187 */     PrisonTlogManager.tlogLetRoleOutOfJail(roleId.longValue());
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onAddRecordToList(Long roleId)
/*     */     throws Exception
/*     */   {
/* 194 */     mzm.gsp.wanted.main.WantedInterface.removeRoleWantedInfo(roleId.longValue());
/*     */     
/*     */ 
/* 197 */     mzm.gsp.mail.main.MailInterface.asynBuildAndSendMail(roleId.longValue(), SPKConsts.getInstance().ARRESTED_MAIL_ID, new ArrayList(), new ArrayList(), new TLogArg(LogReason.WANTED_PRISON_MAIL));
/*     */     
/*     */ 
/* 200 */     OnlineManager.getInstance().sendAtOnce(roleId.longValue(), new SNotifyPutInJail());
/*     */     
/*     */ 
/* 203 */     RoleStatusInterface.setStatus(roleId.longValue(), 1661, false);
/*     */     
/* 205 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.prison.event.PutRoleInJail(), new PutRoleInJailArg(roleId.longValue()));
/*     */     
/* 207 */     if (TeamInterface.isRoleInTeam(roleId.longValue(), true))
/*     */     {
/*     */ 
/* 210 */       RoleStatusInterface.setStatus(roleId.longValue(), 1670, false);
/* 211 */       TeamInterface.leaveTeamNoneRealTime(roleId.longValue());
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 216 */       MapInterface.setXunLuoState(roleId.longValue(), false);
/* 217 */       MapInterface.forceTransferToScene(roleId.longValue(), JailWorldManager.getInstance().getWorldId(), ((Integer)JailWorldManager.getInstance().getMapCfgIds().get(0)).intValue(), SPKConsts.getInstance().WANTED_ENTER_PRISON_MAP_X, SPKConsts.getInstance().WANTED_ENTER_PRISON_MAP_Y);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 223 */     PrisonTlogManager.tlogPutRoleInJail(roleId.longValue());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\PrisonPageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */