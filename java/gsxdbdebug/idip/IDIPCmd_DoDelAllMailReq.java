/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_DoDelAllMailReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_DoDelAllMailReq
/*    */   extends IDIPCmd<IDIPPacket_DoDelAllMailReq, IDIPPacket_DoDelAllMailRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4233;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_DoDelAllMailReq, IDIPPacket_DoDelAllMailRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_DoDelAllMailReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_DoDelAllMailReq req, IDIPPacket_DoDelAllMailRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_DoDelAllMailReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_DoDelAllMailReq create()
/*    */   {
/* 33 */     IDIPPacket_DoDelAllMailReq req = IDIPPacket_DoDelAllMailReq.create();
/* 34 */     IDIPPacket_DoDelAllMailRsp rsp = IDIPPacket_DoDelAllMailRsp.create();
/* 35 */     return new IDIPCmd_DoDelAllMailReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_DoDelAllMailReq create(IDIPPacket_DoDelAllMailReq req, IDIPPacket_DoDelAllMailRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_DoDelAllMailReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_DoDelAllMailReq(IDIPPacket_DoDelAllMailReq req, IDIPPacket_DoDelAllMailRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4233;
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
/* 62 */     return new PIDIPCmd_DoDelAllMailReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_DoDelAllMailReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */