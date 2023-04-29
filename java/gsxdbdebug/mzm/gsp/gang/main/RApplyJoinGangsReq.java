/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.gang.cache.ApplyJoinGangManager;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xbean.GangMember;
/*    */ import xbean.RoleApplyGang;
/*    */ 
/*    */ class RApplyJoinGangsReq extends LogicRunnable
/*    */ {
/*    */   private final long roleid;
/*    */   private int applyCount;
/*    */   private Collection<Long> excludeGangs;
/*    */   
/*    */   RApplyJoinGangsReq(long roleid, int applyCount, Collection<Long> excludeGangs)
/*    */   {
/* 20 */     this.roleid = roleid;
/* 21 */     this.applyCount = applyCount;
/* 22 */     this.excludeGangs = excludeGangs;
/*    */   }
/*    */   
/*    */   public void process() throws Exception
/*    */   {
/* 27 */     long nowMillis = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 28 */     if (ApplyJoinGangManager.getInstance().needRefresh(nowMillis)) {
/* 29 */       GangManager.refreshApplyJoinGangManager(nowMillis);
/*    */     }
/*    */     
/* 32 */     List<Long> gangs = ApplyJoinGangManager.getInstance().getRandomApplyGangs(this.applyCount);
/* 33 */     gangs.removeAll(this.excludeGangs);
/*    */     
/* 35 */     Iterator<Long> iter = gangs.iterator();
/* 36 */     while ((iter.hasNext()) && (this.applyCount > 0)) {
/* 37 */       this.applyCount -= 1;
/* 38 */       long gangid = ((Long)iter.next()).longValue();
/* 39 */       new PApply(this.roleid, gangid).call();
/*    */     }
/*    */   }
/*    */   
/*    */   private static class PApply extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     private final long roleid;
/*    */     private final long gangid;
/*    */     
/*    */     PApply(long roleid, long gangid) {
/* 49 */       this.roleid = roleid;
/* 50 */       this.gangid = gangid;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 56 */       GangMember xMember = GangManager.getXGangMember(this.roleid, true);
/*    */       
/* 58 */       if (xMember != null)
/*    */       {
/* 60 */         lock(xtable.Gang.getTable(), Arrays.asList(new Long[] { Long.valueOf(xMember.getGangid()), Long.valueOf(this.gangid) }));
/*    */         
/*    */ 
/* 63 */         xbean.Gang xOldGang = GangManager.getXGang(xMember.getGangid(), true);
/* 64 */         if ((xOldGang != null) && 
/* 65 */           (GangManager.isInGang(xOldGang, this.roleid))) {
/* 66 */           return false;
/*    */         }
/*    */       }
/*    */       
/*    */ 
/*    */ 
/* 72 */       RoleApplyGang xApplyGang = GangManager.getAndCreateXRoleApplyGang(this.roleid);
/*    */       
/* 74 */       if (GangManager.hasAppliedGang(xApplyGang, this.gangid)) {
/* 75 */         GangManager.logWarn("RApplyJoinGangsReq.PApply.processImp@already applied gang|roleid=%d|gangid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.gangid) });
/* 76 */         return false;
/*    */       }
/*    */       
/*    */ 
/* 80 */       xbean.Gang xGang = xtable.Gang.get(Long.valueOf(this.gangid));
/* 81 */       if (xGang == null) {
/* 82 */         GangManager.logWarn("RApplyJoinGangsReq.PApply.processImp@gang not existed|roleid=%d|gangid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.gangid) });
/* 83 */         return false;
/*    */       }
/*    */       
/* 86 */       xbean.GangMemoryBean xGangMemory = GangManager.getAndCreateXGangMemory(this.gangid);
/*    */       
/* 88 */       GangManager.addApplyRelationAndBroadcast(this.gangid, xGang, xGangMemory, this.roleid, xApplyGang, -1L);
/*    */       
/* 90 */       GangManager.logInfo("RApplyJoinGangsReq.PApply.processImp@apply|roleid=%d|gangid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.gangid) });
/*    */       
/* 92 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\RApplyJoinGangsReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */