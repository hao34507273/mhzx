/*    */ package mzm.gsp.chess.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity3.confbean.ChessActivityConsts;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.npc.confbean.SNpc;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeRunnable;
/*    */ 
/*    */ public class ROnOpenChange extends OpenChangeRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 14 */     if (((OpenChangeComplexArg)this.arg).getType() != 396)
/*    */     {
/* 16 */       return;
/*    */     }
/*    */     
/* 19 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 21 */       return;
/*    */     }
/* 23 */     int npcId = ChessActivityConsts.getInstance().NPC_ID;
/* 24 */     SNpc sNpc = SNpc.get(npcId);
/* 25 */     if (null == sNpc)
/*    */     {
/* 27 */       String logstr = String.format("[chess]chess.main.ROnOpenChange.process@npc cfg not exsists|npcId=%d", new Object[] { Integer.valueOf(npcId) });
/* 28 */       ChessActivityManager.logger.error(logstr);
/* 29 */       return;
/*    */     }
/* 31 */     if (((OpenChangeComplexArg)this.arg).isOpen())
/*    */     {
/* 33 */       ControllerInterface.triggerController(sNpc.controllerId);
/*    */     }
/*    */     else
/*    */     {
/* 37 */       ControllerInterface.collectController(sNpc.controllerId);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chess\main\ROnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */