/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.gang.cache.ApplyJoinGangManager;
/*    */ import mzm.gsp.gang.cache.GangLRUCache;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_GangCache
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmid;
/*    */   
/*    */   public PGM_GangCache(long gmid)
/*    */   {
/* 19 */     this.gmid = gmid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 24 */     Set<Long> allGangs = GangLRUCache.getInstance().getGangIdSet();
/*    */     
/* 26 */     GmManager.getInstance().sendResultToGM(this.gmid, "帮派id缓存：" + allGangs);
/* 27 */     GmManager.getInstance().sendResultToGM(this.gmid, "帮派一键申请缓存：" + ApplyJoinGangManager.getInstance().toString());
/*    */     
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PGM_GangCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */