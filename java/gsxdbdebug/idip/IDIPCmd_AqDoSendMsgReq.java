/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_AqDoSendMsgReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_AqDoSendMsgReq
/*    */   extends IDIPCmd<IDIPPacket_AqDoSendMsgReq, IDIPPacket_AqDoSendMsgRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4137;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_AqDoSendMsgReq, IDIPPacket_AqDoSendMsgRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_AqDoSendMsgReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_AqDoSendMsgReq req, IDIPPacket_AqDoSendMsgRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_AqDoSendMsgReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_AqDoSendMsgReq create()
/*    */   {
/* 33 */     IDIPPacket_AqDoSendMsgReq req = IDIPPacket_AqDoSendMsgReq.create();
/* 34 */     IDIPPacket_AqDoSendMsgRsp rsp = IDIPPacket_AqDoSendMsgRsp.create();
/* 35 */     return new IDIPCmd_AqDoSendMsgReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_AqDoSendMsgReq create(IDIPPacket_AqDoSendMsgReq req, IDIPPacket_AqDoSendMsgRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_AqDoSendMsgReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_AqDoSendMsgReq(IDIPPacket_AqDoSendMsgReq req, IDIPPacket_AqDoSendMsgRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4137;
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
/* 62 */     return new PIDIPCmd_AqDoSendMsgReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_AqDoSendMsgReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */