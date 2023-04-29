/*    */ package mzm.gsp.addiction.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeRunnable;
/*    */ 
/*    */ public class ROnOpenChange extends OpenChangeRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 11 */     int type = ((OpenChangeComplexArg)this.arg).getType();
/* 12 */     if (type != 195)
/*    */     {
/* 14 */       return;
/*    */     }
/*    */     
/* 17 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 19 */       return;
/*    */     }
/*    */     
/* 22 */     boolean open = ((OpenChangeComplexArg)this.arg).isOpen();
/* 23 */     if (open)
/*    */     {
/* 25 */       AddictionManager.onFunOpen();
/*    */     }
/*    */     else
/*    */     {
/* 29 */       AddictionManager.onFunClose();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\main\ROnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */