/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_DoSendMarqueeReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_DoSendMarqueeReq
/*    */   extends IDIPCmd<IDIPPacket_DoSendMarqueeReq, IDIPPacket_DoSendMarqueeRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4177;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_DoSendMarqueeReq, IDIPPacket_DoSendMarqueeRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_DoSendMarqueeReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_DoSendMarqueeReq req, IDIPPacket_DoSendMarqueeRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_DoSendMarqueeReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_DoSendMarqueeReq create()
/*    */   {
/* 33 */     IDIPPacket_DoSendMarqueeReq req = IDIPPacket_DoSendMarqueeReq.create();
/* 34 */     IDIPPacket_DoSendMarqueeRsp rsp = IDIPPacket_DoSendMarqueeRsp.create();
/* 35 */     return new IDIPCmd_DoSendMarqueeReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_DoSendMarqueeReq create(IDIPPacket_DoSendMarqueeReq req, IDIPPacket_DoSendMarqueeRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_DoSendMarqueeReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_DoSendMarqueeReq(IDIPPacket_DoSendMarqueeReq req, IDIPPacket_DoSendMarqueeRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4177;
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
/* 62 */     return new PIDIPCmd_DoSendMarqueeReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_DoSendMarqueeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */