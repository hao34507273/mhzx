/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ abstract class AbstractMapMsgHandler implements Runnable
/*    */ {
/*  7 */   private static final Logger logger = Logger.getLogger(AbstractMapMsgHandler.class);
/*    */   
/*    */ 
/*    */   public void run()
/*    */   {
/*    */     try
/*    */     {
/* 14 */       doProcess();
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 18 */       logger.error("[map]AbstractMapMsgHandler.run@map message do process error", e);
/*    */     }
/*    */   }
/*    */   
/*    */   public abstract void doProcess();
/*    */   
/*    */   public void execute()
/*    */   {
/* 26 */     MapMessageQueue.getInstance().postMessage(this);
/*    */   }
/*    */   
/*    */   public void call()
/*    */   {
/* 31 */     MapMessageQueue.getInstance().addMessage(this);
/*    */   }
/*    */   
/*    */   protected <T extends AbstractMapMsgHandler> MapMsgHandlerDone<T> getMapMsgHandlerDone()
/*    */   {
/* 36 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\AbstractMapMsgHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */