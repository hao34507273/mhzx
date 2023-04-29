/*     */ package mzm.gsp.wanted.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.pk.confbean.SPKConsts;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.wanted.event.DeleteRoleOnWantedList;
/*     */ import xbean.Pod;
/*     */ import xbean.WantedInfo;
/*     */ import xbean.WantedRank;
/*     */ import xtable.Role2wantedinfo;
/*     */ import xtable.Wantedrank;
/*     */ 
/*     */ public class WantedPageManager extends PageManager<Long>
/*     */ {
/*     */   private WantedPageManager(int countPerPage)
/*     */   {
/*  25 */     super(countPerPage);
/*     */   }
/*     */   
/*     */   private static class InstanceHolder
/*     */   {
/*  30 */     private static final WantedPageManager INSTANCE = new WantedPageManager(SPKConsts.getInstance().WANTED_RECORD_COUNT_PER_PAGE, null);
/*     */   }
/*     */   
/*     */ 
/*     */   public static WantedPageManager getInstance()
/*     */   {
/*  36 */     return InstanceHolder.INSTANCE;
/*     */   }
/*     */   
/*     */ 
/*     */   protected void loadDataFromDB()
/*     */     throws Exception
/*     */   {
/*  43 */     WantedRank xWantedRank = Wantedrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  44 */     if (xWantedRank == null)
/*  45 */       return;
/*  46 */     List<Long> roleIds = xWantedRank.getRoleids();
/*     */     
/*     */ 
/*  49 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*  51 */       WantedInfo xWantedInfo = Role2wantedinfo.select(Long.valueOf(roleId));
/*  52 */       addRoleToWantedList(roleId, xWantedInfo);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void deleteRecordInDB(Long roleId)
/*     */   {
/*  60 */     WantedRank xWantedRank = Wantedrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  61 */     if (xWantedRank == null)
/*  62 */       return;
/*  63 */     xWantedRank.getRoleids().remove(roleId);
/*     */     
/*     */ 
/*  66 */     WantedInfo xWantedInfo = Role2wantedinfo.get(roleId);
/*  67 */     if (xWantedInfo == null)
/*     */     {
/*  69 */       return;
/*     */     }
/*     */     
/*  72 */     Session.removeSession(xWantedInfo.getSessionid());
/*  73 */     Role2wantedinfo.remove(roleId);
/*     */     
/*  75 */     this.recordsLock.writeLock().lock();
/*     */     try
/*     */     {
/*  78 */       this.removedFromRecords.remove(roleId);
/*     */     }
/*     */     finally
/*     */     {
/*  82 */       this.recordsLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void addRecordToDB(Long roleId)
/*     */   {
/*  90 */     WantedRank xWantedRank = Wantedrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  91 */     if (xWantedRank == null)
/*     */     {
/*  93 */       xWantedRank = Pod.newWantedRank();
/*  94 */       Wantedrank.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xWantedRank);
/*     */     }
/*  96 */     if (!xWantedRank.getRoleids().contains(roleId))
/*     */     {
/*  98 */       xWantedRank.getRoleids().add(roleId);
/*     */     }
/*     */     
/*     */ 
/* 102 */     WantedInfo xWantedInfo = Role2wantedinfo.get(roleId);
/* 103 */     if (xWantedInfo == null)
/*     */     {
/* 105 */       xWantedInfo = Pod.newWantedInfo();
/* 106 */       Role2wantedinfo.insert(roleId, xWantedInfo);
/*     */     }
/*     */     
/*     */ 
/* 110 */     NPCWantedSession session = new NPCWantedSession(TimeUnit.MINUTES.toSeconds(SPKConsts.getInstance().NPC_ARREST_MINUTES), roleId.longValue(), SPKConsts.getInstance().NPC_ARREST_FIGHT_ID_1);
/*     */     
/*     */ 
/* 113 */     xWantedInfo.setSessionid(session.getSessionId());
/* 114 */     xWantedInfo.setStarttimestamp(DateTimeUtils.getCurrTimeInMillis());
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onDeleteRecordFromList(Long roleId)
/*     */     throws Exception
/*     */   {
/* 121 */     TriggerEventsManger.getInstance().triggerEvent(new DeleteRoleOnWantedList(), new mzm.gsp.wanted.event.DeleteRoleOnWantedListArg(roleId.longValue()));
/*     */     
/* 123 */     WantedTlogManager.tlogRemoveRoleFromWanted(roleId.longValue(), MallInterface.getJifen(roleId.longValue(), 7));
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onAddRecordToList(Long roleId)
/*     */     throws Exception
/*     */   {
/* 130 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.wanted.event.AddRoleOnWantedList(), new mzm.gsp.wanted.event.AddRoleOnWantedListArg(roleId.longValue()));
/*     */     
/* 132 */     WantedTlogManager.tlogAddRoleToWanted(roleId.longValue(), MallInterface.getJifen(roleId.longValue(), 7));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addRoleToWantedList(long roleId, WantedInfo xWantedInfo)
/*     */     throws Exception
/*     */   {
/* 144 */     if (containsRecord(Long.valueOf(roleId)))
/*     */     {
/* 146 */       return;
/*     */     }
/* 148 */     long interval = TimeUnit.MINUTES.toMillis(SPKConsts.getInstance().NPC_ARREST_MINUTES) - DateTimeUtils.getCurrTimeInMillis() + xWantedInfo.getStarttimestamp();
/*     */     
/*     */ 
/* 151 */     if (interval > 0L)
/*     */     {
/* 153 */       Session oldSession = Session.getSession(xWantedInfo.getSessionid());
/* 154 */       if ((oldSession != null) && (oldSession.getOwerId() == roleId))
/*     */       {
/* 156 */         return;
/*     */       }
/* 158 */       NPCWantedSession npcWantedSession = new NPCWantedSession(TimeUnit.MILLISECONDS.toSeconds(interval), roleId, SPKConsts.getInstance().NPC_ARREST_FIGHT_ID_1);
/*     */       
/* 160 */       xWantedInfo.setSessionid(npcWantedSession.getSessionId());
/* 161 */       getInstance().addRecordToList(Long.valueOf(roleId));
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\main\WantedPageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */