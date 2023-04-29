/*    */ package mzm.gsp.gangrace.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.concurrent.atomic.AtomicBoolean;
/*    */ import mzm.gsp.activity.confbean.SGangRaceConsts;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.award.main.AwardInterface;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.idip.main.IdipManager;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AwardObserver
/*    */   extends Observer
/*    */ {
/* 27 */   private final AtomicBoolean isOpen = new AtomicBoolean(true);
/*    */   
/*    */   AwardObserver() {
/* 30 */     super(SGangRaceConsts.getInstance().ExpSpanTime);
/*    */   }
/*    */   
/*    */   public boolean update()
/*    */   {
/* 35 */     if (!this.isOpen.get()) {
/* 36 */       return false;
/*    */     }
/* 38 */     Procedure.execute(new PAward(this.isOpen, null));
/*    */     
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   private static class PAward extends LogicProcedure {
/*    */     private final AtomicBoolean isOpen;
/*    */     
/*    */     private PAward(AtomicBoolean isOpen) {
/* 47 */       this.isOpen = isOpen;
/*    */     }
/*    */     
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 52 */       int activityId = SGangRaceConsts.getInstance().activity;
/*    */       
/*    */ 
/* 55 */       boolean opened = (ActivityInterface.isActivityOpen(activityId)) && (OpenInterface.getOpenStatus(99));
/* 56 */       int awardId; AwardReason awardReason; Iterator i$; if (opened) {
/* 57 */         awardId = SGangRaceConsts.getInstance().ExpAwardId;
/* 58 */         awardReason = new AwardReason(LogReason.GANGRACE_AWARD_EXP);
/*    */         
/* 60 */         Collection<Long> allGangIds = GangInterface.getAllGangIdSet();
/*    */         
/* 62 */         for (i$ = allGangIds.iterator(); i$.hasNext();) { long gangid = ((Long)i$.next()).longValue();
/* 63 */           long worldId = GangInterface.getGangWorldId(gangid);
/* 64 */           if (worldId > 0L)
/*    */           {
/*    */ 
/* 67 */             ArrayList<Long> roleIds = new ArrayList();
/*    */             
/*    */ 
/* 70 */             Gang faction = GangInterface.getGang(gangid, false);
/* 71 */             Collection<Long> allRoles = MapInterface.getRoleList(worldId);
/*    */             
/* 73 */             for (Iterator i$ = allRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 74 */               if ((faction.isInGang(roleid)) && (!IdipManager.isZeroProfit(roleid))) {
/* 75 */                 roleIds.add(Long.valueOf(roleid));
/*    */               }
/*    */             }
/*    */             
/* 79 */             if (!roleIds.isEmpty()) {
/* 80 */               AwardInterface.awardToAllNoneRealTime(roleIds, awardId, -1, true, true, awardReason);
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/* 85 */       this.isOpen.set(opened);
/*    */       
/* 87 */       return opened;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangrace\main\AwardObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */