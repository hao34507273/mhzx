/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_DoUpdateNoticeReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_DoUpdateNoticeReq
/*    */   extends IDIPCmd<IDIPPacket_DoUpdateNoticeReq, IDIPPacket_DoUpdateNoticeRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4189;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_DoUpdateNoticeReq, IDIPPacket_DoUpdateNoticeRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_DoUpdateNoticeReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_DoUpdateNoticeReq req, IDIPPacket_DoUpdateNoticeRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_DoUpdateNoticeReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_DoUpdateNoticeReq create()
/*    */   {
/* 33 */     IDIPPacket_DoUpdateNoticeReq req = IDIPPacket_DoUpdateNoticeReq.create();
/* 34 */     IDIPPacket_DoUpdateNoticeRsp rsp = IDIPPacket_DoUpdateNoticeRsp.create();
/* 35 */     return new IDIPCmd_DoUpdateNoticeReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_DoUpdateNoticeReq create(IDIPPacket_DoUpdateNoticeReq req, IDIPPacket_DoUpdateNoticeRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_DoUpdateNoticeReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_DoUpdateNoticeReq(IDIPPacket_DoUpdateNoticeReq req, IDIPPacket_DoUpdateNoticeRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4189;
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
/* 62 */     return new PIDIPCmd_DoUpdateNoticeReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_DoUpdateNoticeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */