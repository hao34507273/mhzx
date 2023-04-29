/*    */ package mzm.gsp.genius.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ public class ROnOpenChange extends mzm.gsp.open.event.OpenChangeRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 13 */     int type = ((OpenChangeComplexArg)this.arg).getType();
/* 14 */     if (type != 313)
/*    */     {
/* 16 */       return;
/*    */     }
/*    */     
/* 19 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 21 */       return;
/*    */     }
/*    */     
/* 24 */     boolean open = ((OpenChangeComplexArg)this.arg).isOpen();
/* 25 */     Iterator i$; if (!open)
/*    */     {
/* 27 */       for (i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */         
/* 29 */         NoneRealTimeTaskManager.getInstance().addTask(new POnDoubleGeniusClosed(roleId));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genius\main\ROnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */