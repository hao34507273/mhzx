/*     */ package mzm.gsp.factionpve.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.factionpve.confbean.SFactionPVEConsts;
/*     */ import mzm.gsp.gang.main.Gang;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import xbean.FactionPVE;
/*     */ import xbean.FactionPVETmp;
/*     */ 
/*     */ 
/*     */ 
/*     */ class RInitAllFactionPVE
/*     */   extends LogicRunnable
/*     */ {
/*     */   public void process()
/*     */     throws Exception
/*     */   {
/*  24 */     Set<Long> allGangs = GangInterface.getAllGangIdSet();
/*  25 */     for (Iterator i$ = allGangs.iterator(); i$.hasNext();) { long factionid = ((Long)i$.next()).longValue();
/*  26 */       boolean ret = new PInitFactionPVE(factionid).call();
/*  27 */       if (!ret) {
/*  28 */         FactionPVEManager.logError("RInitAllFactionPVE.process@init faction pve err|factionid=%d", new Object[] { Long.valueOf(factionid) });
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static class PInitFactionPVE
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long factionid;
/*     */     
/*     */     PInitFactionPVE(long factionid)
/*     */     {
/*  41 */       this.factionid = factionid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  47 */       FactionPVE xFactionPVE = FactionPVEManager.getXFactionPVEIfNotExist(this.factionid);
/*  48 */       FactionPVETmp xFactionPVETmp = FactionPVEManager.getXFactionPVETmpIfNotExist(this.factionid);
/*  49 */       Gang faction = GangInterface.getGang(this.factionid, true);
/*     */       
/*  51 */       FactionPVEManager.checkAndInitXFactionPVEAndXFactionPVETmp(xFactionPVE, xFactionPVETmp);
/*     */       
/*  53 */       long startPVETime = xFactionPVE.getStart_timestamp();
/*  54 */       long now = DateTimeUtils.getCurrTimeInMillis();
/*     */       
/*  56 */       long delta = startPVETime - now;
/*     */       
/*  58 */       if (delta > 0L)
/*     */       {
/*  60 */         FactionPVEStartSession startSession = new FactionPVEStartSession(this.factionid, delta);
/*  61 */         FactionPVEManager.setStageAndBroadcast(this.factionid, faction, xFactionPVETmp, 0, startSession);
/*     */       }
/*     */       else
/*     */       {
/*  65 */         long endTime = FactionPVEManager.getFactionPVEEndTime(xFactionPVE);
/*  66 */         long leftMillis = endTime - now;
/*  67 */         if (leftMillis > 0L)
/*     */         {
/*  69 */           long world = FactionPVEManager.createPrepareWorld();
/*  70 */           xFactionPVETmp.setWorld(world);
/*     */           
/*     */ 
/*     */ 
/*  74 */           long factionWorld = GangInterface.getGangWorldId(this.factionid);
/*  75 */           ControllerInterface.triggerWorldController(factionWorld, SFactionPVEConsts.getInstance().ControllerIn);
/*     */           
/*     */ 
/*  78 */           PrepareSession session = new PrepareSession(this.factionid, TimeUnit.MINUTES.toMillis(SFactionPVEConsts.getInstance().PrepareMinutes));
/*     */           
/*     */ 
/*     */ 
/*  82 */           FactionPVEManager.setStageAndBroadcast(this.factionid, faction, xFactionPVETmp, 1, session);
/*     */           
/*     */ 
/*     */ 
/*  86 */           FactionPVEEndSession endSession = new FactionPVEEndSession(this.factionid, leftMillis);
/*  87 */           xFactionPVETmp.setEnd_sessionid(endSession.getSessionId());
/*     */         }
/*     */         else
/*     */         {
/*  91 */           FactionPVEManager.setStageAndBroadcast(this.factionid, faction, xFactionPVETmp, 6, null);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*  96 */       FactionPVEManager.logInfo("PInitFactionPVE.processImp@init faction pve|factionid=%d|stage=%d", new Object[] { Long.valueOf(this.factionid), Integer.valueOf(xFactionPVETmp.getStage()) });
/*     */       
/*     */ 
/*     */ 
/* 100 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\RInitAllFactionPVE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */