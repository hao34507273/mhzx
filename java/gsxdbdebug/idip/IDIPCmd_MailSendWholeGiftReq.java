/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_MailSendWholeGiftReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_MailSendWholeGiftReq
/*    */   extends IDIPCmd<IDIPPacket_MailSendWholeGiftReq, IDIPPacket_MailSendWholeGiftRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4173;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_MailSendWholeGiftReq, IDIPPacket_MailSendWholeGiftRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_MailSendWholeGiftReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_MailSendWholeGiftReq req, IDIPPacket_MailSendWholeGiftRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_MailSendWholeGiftReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_MailSendWholeGiftReq create()
/*    */   {
/* 33 */     IDIPPacket_MailSendWholeGiftReq req = IDIPPacket_MailSendWholeGiftReq.create();
/* 34 */     IDIPPacket_MailSendWholeGiftRsp rsp = IDIPPacket_MailSendWholeGiftRsp.create();
/* 35 */     return new IDIPCmd_MailSendWholeGiftReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_MailSendWholeGiftReq create(IDIPPacket_MailSendWholeGiftReq req, IDIPPacket_MailSendWholeGiftRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_MailSendWholeGiftReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_MailSendWholeGiftReq(IDIPPacket_MailSendWholeGiftReq req, IDIPPacket_MailSendWholeGiftRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4173;
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
/* 62 */     return new PIDIPCmd_MailSendWholeGiftReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_MailSendWholeGiftReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */