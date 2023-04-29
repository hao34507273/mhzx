/*    */ package mzm.gsp.redgift.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.activity.confbean.RedGiftActivityConst;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ class RCheckAddAllToGiftList
/*    */   extends LogicRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 16 */     List<Long> allOnlineRoleID = OnlineManager.getInstance().getAllRolesInWorld();
/* 17 */     Iterator<Long> iter = allOnlineRoleID.iterator();
/*    */     
/* 19 */     Set<Long> brdList = new HashSet();
/* 20 */     while (iter.hasNext()) {
/* 21 */       long roleid = ((Long)iter.next()).longValue();
/* 22 */       boolean ret = new PCheckAddGiftList(roleid).call();
/* 23 */       if (ret) {
/* 24 */         brdList.add(Long.valueOf(roleid));
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 31 */     new RedgiftAutoGetRewardObserver(RedGiftActivityConst.getInstance().serverEndGetRedgiftTime);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\redgift\main\RCheckAddAllToGiftList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */