/*    */ package mzm.gsp.onlinetreasurebox.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ROnlineTreasureBuffChange
/*    */   extends LogicRunnable
/*    */ {
/*    */   private List<Long> roleSet;
/*    */   private boolean isInstall;
/*    */   
/*    */   ROnlineTreasureBuffChange(List<Long> roleSet, boolean isInstall)
/*    */   {
/* 21 */     this.roleSet = roleSet;
/* 22 */     this.isInstall = isInstall;
/*    */   }
/*    */   
/*    */   public void process() throws Exception
/*    */   {
/* 27 */     if (!OnlineTreasureBoxManager.isOnlineTreasureBoxFunOpen()) {
/* 28 */       return;
/*    */     }
/*    */     
/* 31 */     if ((OnlineTreasureBoxManager.onlineTreasureBoxActionEnum == OnlineTreasureBoxActionEnum.CLOSE_STAGE) && (this.isInstall)) {
/* 32 */       return;
/*    */     }
/* 34 */     if ((this.roleSet == null) || (this.roleSet.size() == 0)) {
/* 35 */       return;
/*    */     }
/* 37 */     for (Iterator i$ = this.roleSet.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/* 38 */       new POnlineTreasureBuffChange(roleId, this.isInstall).call();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\onlinetreasurebox\main\ROnlineTreasureBuffChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */