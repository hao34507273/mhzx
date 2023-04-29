/*    */ package mzm.gsp.redgift.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.RedgiftRoleidSet;
/*    */ import xtable.Redgift;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PAutoGetRedgiftActivityRewardReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     if (!RedGiftManager.isRedGiftFunOpen()) {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     long localId = GameServerInfoManager.getLocalId();
/*    */     
/* 32 */     RedgiftRoleidSet xRedgiftRoleidSet = Redgift.get(Long.valueOf(localId));
/* 33 */     if (xRedgiftRoleidSet == null) {
/* 34 */       if (RedGiftManager.LOGGER.isDebugEnabled()) {
/* 35 */         RedGiftManager.LOGGER.debug("红包活动信息出错 xRedgiftRoleidSet为null,PAutoGetRedgiftActivityRewardReq redgiftactivity roleid info error!");
/*    */       }
/* 37 */       return false;
/*    */     }
/* 39 */     Iterator<Long> redgiftRoleSetrIterable = xRedgiftRoleidSet.getRoleidset().iterator();
/* 40 */     while (redgiftRoleSetrIterable.hasNext()) {
/* 41 */       long roleId = ((Long)redgiftRoleSetrIterable.next()).longValue();
/* 42 */       NoneRealTimeTaskManager.getInstance().addTask(new PAutoSendRedGiftActivityRewardReq(roleId));
/* 43 */       redgiftRoleSetrIterable.remove();
/*    */     }
/*    */     
/* 46 */     NoneRealTimeTaskManager.getInstance().addTask(new POnRedgiftEnd());
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\redgift\main\PAutoGetRedgiftActivityRewardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */