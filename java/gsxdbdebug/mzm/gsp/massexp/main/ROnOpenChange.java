/*    */ package mzm.gsp.massexp.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.massexp.confbean.SMassExpCfgConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class ROnOpenChange extends mzm.gsp.open.event.OpenChangeRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 16 */     int type = ((OpenChangeComplexArg)this.arg).getType();
/* 17 */     if (type != 196)
/*    */     {
/* 19 */       return;
/*    */     }
/*    */     
/* 22 */     if (mzm.gsp.GameServerInfoManager.isRoamServer())
/*    */     {
/* 24 */       return;
/*    */     }
/*    */     
/*    */ 
/* 28 */     int serverLevel = mzm.gsp.server.main.ServerInterface.getCurrentServerLevel();
/* 29 */     if (serverLevel < SMassExpCfgConsts.getInstance().SERVER_LEVEL_LIMIT)
/*    */     {
/* 31 */       GameServer.logger().info(String.format("[massexp]ROnOpenChange.process@server level limit|server_level=%d|limit_level=%d", new Object[] { Integer.valueOf(serverLevel), Integer.valueOf(SMassExpCfgConsts.getInstance().SERVER_LEVEL_LIMIT) }));
/*    */       
/*    */ 
/* 34 */       return;
/*    */     }
/*    */     
/* 37 */     boolean open = ((OpenChangeComplexArg)this.arg).isOpen();
/* 38 */     Iterator i$; Iterator i$; if (open)
/*    */     {
/* 40 */       for (i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */         
/* 42 */         NoneRealTimeTaskManager.getInstance().addTask(new POnMassExpOpen(roleId));
/*    */       }
/*    */       
/*    */     }
/*    */     else {
/* 47 */       for (i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */         
/* 49 */         NoneRealTimeTaskManager.getInstance().addTask(new POnMassExpClose(roleId));
/*    */       }
/*    */     }
/*    */     
/* 53 */     GameServer.logger().info(String.format("[massexp]ROnOpenChange.process@handle done|open=%b", new Object[] { Boolean.valueOf(open) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\massexp\main\ROnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */