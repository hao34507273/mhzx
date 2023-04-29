/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_DoSendItemReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_DoSendItemReq
/*    */   extends IDIPCmd<IDIPPacket_DoSendItemReq, IDIPPacket_DoSendItemRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4117;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_DoSendItemReq, IDIPPacket_DoSendItemRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_DoSendItemReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_DoSendItemReq req, IDIPPacket_DoSendItemRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_DoSendItemReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_DoSendItemReq create()
/*    */   {
/* 33 */     IDIPPacket_DoSendItemReq req = IDIPPacket_DoSendItemReq.create();
/* 34 */     IDIPPacket_DoSendItemRsp rsp = IDIPPacket_DoSendItemRsp.create();
/* 35 */     return new IDIPCmd_DoSendItemReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_DoSendItemReq create(IDIPPacket_DoSendItemReq req, IDIPPacket_DoSendItemRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_DoSendItemReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_DoSendItemReq(IDIPPacket_DoSendItemReq req, IDIPPacket_DoSendItemRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4117;
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
/* 62 */     return new PIDIPCmd_DoSendItemReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_DoSendItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */