/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_DoUpdateExpReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_DoUpdateExpReq
/*    */   extends IDIPCmd<IDIPPacket_DoUpdateExpReq, IDIPPacket_DoUpdateExpRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4115;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_DoUpdateExpReq, IDIPPacket_DoUpdateExpRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_DoUpdateExpReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_DoUpdateExpReq req, IDIPPacket_DoUpdateExpRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_DoUpdateExpReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_DoUpdateExpReq create()
/*    */   {
/* 33 */     IDIPPacket_DoUpdateExpReq req = IDIPPacket_DoUpdateExpReq.create();
/* 34 */     IDIPPacket_DoUpdateExpRsp rsp = IDIPPacket_DoUpdateExpRsp.create();
/* 35 */     return new IDIPCmd_DoUpdateExpReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_DoUpdateExpReq create(IDIPPacket_DoUpdateExpReq req, IDIPPacket_DoUpdateExpRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_DoUpdateExpReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_DoUpdateExpReq(IDIPPacket_DoUpdateExpReq req, IDIPPacket_DoUpdateExpRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4115;
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
/* 62 */     return new PIDIPCmd_DoUpdateExpReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_DoUpdateExpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */