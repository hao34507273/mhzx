/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_DoDeleteNoticeReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_DoDeleteNoticeReq
/*    */   extends IDIPCmd<IDIPPacket_DoDeleteNoticeReq, IDIPPacket_DoDeleteNoticeRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4191;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_DoDeleteNoticeReq, IDIPPacket_DoDeleteNoticeRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_DoDeleteNoticeReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_DoDeleteNoticeReq req, IDIPPacket_DoDeleteNoticeRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_DoDeleteNoticeReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_DoDeleteNoticeReq create()
/*    */   {
/* 33 */     IDIPPacket_DoDeleteNoticeReq req = IDIPPacket_DoDeleteNoticeReq.create();
/* 34 */     IDIPPacket_DoDeleteNoticeRsp rsp = IDIPPacket_DoDeleteNoticeRsp.create();
/* 35 */     return new IDIPCmd_DoDeleteNoticeReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_DoDeleteNoticeReq create(IDIPPacket_DoDeleteNoticeReq req, IDIPPacket_DoDeleteNoticeRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_DoDeleteNoticeReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_DoDeleteNoticeReq(IDIPPacket_DoDeleteNoticeReq req, IDIPPacket_DoDeleteNoticeRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4191;
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
/* 62 */     return new PIDIPCmd_DoDeleteNoticeReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_DoDeleteNoticeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */