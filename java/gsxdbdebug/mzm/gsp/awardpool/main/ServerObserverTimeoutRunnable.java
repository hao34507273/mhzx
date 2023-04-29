/*    */ package mzm.gsp.awardpool.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.awardpool.confbean.SAwardTypeId2PreciousItemSubId;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ class ServerObserverTimeoutRunnable extends LogicRunnable
/*    */ {
/*    */   private final int clearType;
/*    */   
/*    */   public ServerObserverTimeoutRunnable(int clearType)
/*    */   {
/* 14 */     this.clearType = clearType;
/*    */   }
/*    */   
/*    */ 
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 21 */     for (SAwardTypeId2PreciousItemSubId s : SAwardTypeId2PreciousItemSubId.getAll().values())
/*    */     {
/*    */ 
/* 24 */       for (i$ = s.itemSubIds.iterator(); i$.hasNext();) { int itemSubId = ((Integer)i$.next()).intValue();
/*    */         
/* 26 */         NoneRealTimeTaskManager.getInstance().addTask(new InitServerAwardPoolPrecious(itemSubId, this.clearType));
/*    */       }
/*    */     }
/*    */     Iterator i$;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\main\ServerObserverTimeoutRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */