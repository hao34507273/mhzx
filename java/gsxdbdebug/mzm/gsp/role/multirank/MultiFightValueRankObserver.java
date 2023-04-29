/*    */ package mzm.gsp.role.multirank;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class MultiFightValueRankObserver extends Observer
/*    */ {
/*    */   public MultiFightValueRankObserver(long intervalSeconds)
/*    */   {
/* 14 */     super(intervalSeconds);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 21 */     NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicRunnable()
/*    */     {
/*    */ 
/*    */       public void process()
/*    */         throws Exception
/*    */       {
/* 27 */         GameServer.logger().info(String.format("[MFV]MultiFightValueRankObserver.update@ begin rank MFV!", new Object[0]));
/* 28 */         boolean isOccMFVOpen = MultiRankManager.isOccMFVOpen();
/* 29 */         if (!isOccMFVOpen)
/*    */         {
/* 31 */           GameServer.logger().info(String.format("[MFV]OccMFVRankObserver.update@ occMFV not open!", new Object[0]));
/*    */         }
/* 33 */         for (Iterator i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */           
/* 35 */           NoneRealTimeTaskManager.getInstance().addTask(new RRankRoleMFV(roleid, isOccMFVOpen));
/*    */         }
/*    */         
/*    */       }
/* 39 */     });
/* 40 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\MultiFightValueRankObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */