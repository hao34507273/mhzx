/*     */ package mzm.gsp.fabaolingqi.main;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.fabaolingqi.confbean.SFabaoArtifactCfg;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.FabaoArtifactRecord;
/*     */ import xbean.FabaoArtifactRecords;
/*     */ import xbean.FabaoArtifactSessionInfo;
/*     */ 
/*     */ 
/*     */ class FabaoArtifactExpireSession
/*     */   extends Session
/*     */ {
/*     */   private long roleId;
/*     */   private int artifactClassId;
/*     */   
/*     */   private FabaoArtifactExpireSession(long roleId, int artifactClassId, long interval)
/*     */   {
/*  23 */     super(interval, roleId);
/*  24 */     this.roleId = roleId;
/*  25 */     this.artifactClassId = artifactClassId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  31 */     new TimeoutProcedure(null).call();
/*     */   }
/*     */   
/*     */   private class TimeoutProcedure extends LogicProcedure
/*     */   {
/*     */     private TimeoutProcedure() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  40 */       FabaoArtifactRecords xRecords = FabaoArtifactManager.getRecords(FabaoArtifactExpireSession.this.roleId, true);
/*  41 */       FabaoArtifactSessionInfo xSessionInfo = FabaoArtifactManager.getSessionInfo(FabaoArtifactExpireSession.this.roleId, true);
/*  42 */       if ((xRecords == null) || (xSessionInfo == null)) {
/*  43 */         return false;
/*     */       }
/*  45 */       if (!FabaoArtifactManager.hasArtifact(xRecords, FabaoArtifactExpireSession.this.artifactClassId))
/*  46 */         return false;
/*  47 */       Long sessionId = (Long)xSessionInfo.getSessions().get(Integer.valueOf(FabaoArtifactExpireSession.this.artifactClassId));
/*  48 */       if ((sessionId == null) || (sessionId.longValue() != FabaoArtifactExpireSession.this.getSessionId())) {
/*  49 */         return false;
/*     */       }
/*  51 */       FabaoArtifactRecord removedRecord = (FabaoArtifactRecord)xRecords.getRecords().remove(Integer.valueOf(FabaoArtifactExpireSession.this.artifactClassId));
/*  52 */       if (xRecords.getEquipped_artifact_class() == FabaoArtifactExpireSession.this.artifactClassId)
/*     */       {
/*  54 */         xRecords.setEquipped_artifact_class(0);
/*  55 */         FabaoArtifactEvents.triggerEquipArtifactEvent(FabaoArtifactExpireSession.this.roleId, false, true);
/*     */       }
/*  57 */       xSessionInfo.getSessions().remove(Integer.valueOf(FabaoArtifactExpireSession.this.artifactClassId));
/*     */       
/*  59 */       FabaoArtifactProtocols.notifyArtifactExpire(FabaoArtifactExpireSession.this.roleId, FabaoArtifactExpireSession.this.artifactClassId);
/*     */       
/*  61 */       FabaoArtifactManager.tlogExpire(FabaoArtifactExpireSession.this.roleId, FabaoArtifactExpireSession.this.artifactClassId, removedRecord.getExpire_time());
/*     */       
/*  63 */       if (FabaoArtifactManager.isEnable())
/*     */       {
/*  65 */         SFabaoArtifactCfg artifactCfg = FabaoArtifactManager.getArtifactCfg(FabaoArtifactExpireSession.this.artifactClassId, removedRecord.getLevel());
/*     */         
/*  67 */         if (artifactCfg != null)
/*     */         {
/*  69 */           FabaoArtifactManager.sendExpireMail(FabaoArtifactExpireSession.this.roleId, artifactCfg.id, removedRecord.getExpire_time());
/*     */         }
/*     */       }
/*     */       
/*  73 */       FabaoArtifactEvents.triggerArtifactExpireEvent(FabaoArtifactExpireSession.this.roleId, Collections.singleton(Integer.valueOf(FabaoArtifactExpireSession.this.artifactClassId)));
/*     */       
/*  75 */       FabaoArtifactManager.info("FabaoArtifactExpireSession.TimeoutProcedure.processImp()@done|roleid=%d|artifact_classid=%d", new Object[] { Long.valueOf(FabaoArtifactExpireSession.this.roleId), Integer.valueOf(FabaoArtifactExpireSession.this.artifactClassId) });
/*     */       
/*     */ 
/*  78 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void startSession(long roleId, FabaoArtifactSessionInfo xSessionInfo, int artifactClassId, int expireTime)
/*     */   {
/*  88 */     long interval = expireTime - (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/*  89 */     if (interval <= 0L)
/*  90 */       return;
/*  91 */     FabaoArtifactExpireSession session = new FabaoArtifactExpireSession(roleId, artifactClassId, interval);
/*  92 */     xSessionInfo.getSessions().put(Integer.valueOf(artifactClassId), Long.valueOf(session.getSessionId()));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void startSessions(long roleId, FabaoArtifactRecords xRecords, FabaoArtifactSessionInfo xSessionInfo)
/*     */   {
/* 101 */     if ((xRecords == null) || (xSessionInfo == null))
/* 102 */       return;
/* 103 */     for (Map.Entry<Integer, FabaoArtifactRecord> e : xRecords.getRecords().entrySet())
/*     */     {
/* 105 */       int artifactClassId = ((Integer)e.getKey()).intValue();
/* 106 */       int expireTime = ((FabaoArtifactRecord)e.getValue()).getExpire_time();
/* 107 */       if (expireTime > 0) {
/* 108 */         startSession(roleId, xSessionInfo, artifactClassId, expireTime);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void removeSession(long roleId, FabaoArtifactSessionInfo xSessionInfo, int artifactClassId)
/*     */   {
/* 117 */     if (xSessionInfo == null)
/* 118 */       return;
/* 119 */     Long sessionId = (Long)xSessionInfo.getSessions().remove(Integer.valueOf(artifactClassId));
/* 120 */     if (sessionId != null) {
/* 121 */       Session.removeSession(sessionId.longValue(), roleId);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void removeSessions(long roleId, FabaoArtifactSessionInfo xSessionInfo)
/*     */   {
/* 129 */     if (xSessionInfo == null)
/* 130 */       return;
/* 131 */     for (Long sessionId : xSessionInfo.getSessions().values())
/* 132 */       Session.removeSession(sessionId.longValue(), roleId);
/* 133 */     xSessionInfo.getSessions().clear();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void restartSession(long roleId, FabaoArtifactSessionInfo xSessionInfo, int artifactClassId, int expireTime)
/*     */   {
/* 142 */     removeSession(roleId, xSessionInfo, artifactClassId);
/* 143 */     startSession(roleId, xSessionInfo, artifactClassId, expireTime);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\main\FabaoArtifactExpireSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */