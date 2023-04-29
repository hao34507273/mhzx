/*    */ package mzm.gsp.auction.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.auction.confbean.SAuctionActivityCfg;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AuctionModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 20 */     ActivityInterface.registerActivityByLogicType(135, new AuctionActivityHandler());
/* 21 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 27 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 33 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 39 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public void postInit()
/*    */   {
/* 45 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 47 */       return;
/*    */     }
/*    */     
/*    */ 
/* 51 */     if (!OpenInterface.getOpenStatus(534))
/*    */     {
/* 53 */       return;
/*    */     }
/*    */     
/* 56 */     Set<Integer> activityIdSet = SAuctionActivityCfg.getAll().keySet();
/* 57 */     if ((activityIdSet == null) || (activityIdSet.isEmpty()))
/*    */     {
/* 59 */       return;
/*    */     }
/* 61 */     for (Iterator i$ = activityIdSet.iterator(); i$.hasNext();) { int activityId = ((Integer)i$.next()).intValue();
/*    */       
/* 63 */       AuctionOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityId), new PCheckAuctionInfo(activityId));
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\main\AuctionModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */