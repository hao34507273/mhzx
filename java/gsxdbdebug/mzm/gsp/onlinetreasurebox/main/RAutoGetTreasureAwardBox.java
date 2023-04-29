/*    */ package mzm.gsp.onlinetreasurebox.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class RAutoGetTreasureAwardBox
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final Set<Long> roleIdSet;
/*    */   
/*    */   public RAutoGetTreasureAwardBox(Set<Long> roleIdSet)
/*    */   {
/* 44 */     this.roleIdSet = roleIdSet;
/*    */   }
/*    */   
/*    */   public void process() throws Exception {
/* 48 */     if ((this.roleIdSet == null) || (this.roleIdSet.size() == 0)) {
/* 49 */       return;
/*    */     }
/* 51 */     for (Iterator i$ = this.roleIdSet.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/* 52 */       new PCGetOnlineBoxRewardReq(roleId).call();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\onlinetreasurebox\main\RAutoGetTreasureAwardBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */