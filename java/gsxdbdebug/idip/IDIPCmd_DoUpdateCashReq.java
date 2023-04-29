/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_DoUpdateCashReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_DoUpdateCashReq
/*    */   extends IDIPCmd<IDIPPacket_DoUpdateCashReq, IDIPPacket_DoUpdateCashRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4097;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_DoUpdateCashReq, IDIPPacket_DoUpdateCashRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_DoUpdateCashReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_DoUpdateCashReq req, IDIPPacket_DoUpdateCashRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_DoUpdateCashReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_DoUpdateCashReq create()
/*    */   {
/* 33 */     IDIPPacket_DoUpdateCashReq req = IDIPPacket_DoUpdateCashReq.create();
/* 34 */     IDIPPacket_DoUpdateCashRsp rsp = IDIPPacket_DoUpdateCashRsp.create();
/* 35 */     return new IDIPCmd_DoUpdateCashReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_DoUpdateCashReq create(IDIPPacket_DoUpdateCashReq req, IDIPPacket_DoUpdateCashRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_DoUpdateCashReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_DoUpdateCashReq(IDIPPacket_DoUpdateCashReq req, IDIPPacket_DoUpdateCashRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4097;
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
/* 62 */     return new PIDIPCmd_DoUpdateCashReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_DoUpdateCashReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */