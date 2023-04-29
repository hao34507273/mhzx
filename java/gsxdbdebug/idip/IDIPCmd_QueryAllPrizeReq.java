/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_QueryAllPrizeReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_QueryAllPrizeReq
/*    */   extends IDIPCmd<IDIPPacket_QueryAllPrizeReq, IDIPPacket_QueryAllPrizeRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4229;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_QueryAllPrizeReq, IDIPPacket_QueryAllPrizeRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_QueryAllPrizeReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_QueryAllPrizeReq req, IDIPPacket_QueryAllPrizeRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_QueryAllPrizeReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_QueryAllPrizeReq create()
/*    */   {
/* 33 */     IDIPPacket_QueryAllPrizeReq req = IDIPPacket_QueryAllPrizeReq.create();
/* 34 */     IDIPPacket_QueryAllPrizeRsp rsp = IDIPPacket_QueryAllPrizeRsp.create();
/* 35 */     return new IDIPCmd_QueryAllPrizeReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_QueryAllPrizeReq create(IDIPPacket_QueryAllPrizeReq req, IDIPPacket_QueryAllPrizeRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_QueryAllPrizeReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_QueryAllPrizeReq(IDIPPacket_QueryAllPrizeReq req, IDIPPacket_QueryAllPrizeRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4229;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 62 */     return new PIDIPCmd_QueryAllPrizeReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_QueryAllPrizeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */