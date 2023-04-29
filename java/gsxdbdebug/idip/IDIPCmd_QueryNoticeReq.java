/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_QueryNoticeReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_QueryNoticeReq
/*    */   extends IDIPCmd<IDIPPacket_QueryNoticeReq, IDIPPacket_QueryNoticeRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4187;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_QueryNoticeReq, IDIPPacket_QueryNoticeRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_QueryNoticeReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_QueryNoticeReq req, IDIPPacket_QueryNoticeRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_QueryNoticeReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_QueryNoticeReq create()
/*    */   {
/* 33 */     IDIPPacket_QueryNoticeReq req = IDIPPacket_QueryNoticeReq.create();
/* 34 */     IDIPPacket_QueryNoticeRsp rsp = IDIPPacket_QueryNoticeRsp.create();
/* 35 */     return new IDIPCmd_QueryNoticeReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_QueryNoticeReq create(IDIPPacket_QueryNoticeReq req, IDIPPacket_QueryNoticeRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_QueryNoticeReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_QueryNoticeReq(IDIPPacket_QueryNoticeReq req, IDIPPacket_QueryNoticeRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4187;
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
/* 62 */     return new PIDIPCmd_QueryNoticeReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_QueryNoticeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */