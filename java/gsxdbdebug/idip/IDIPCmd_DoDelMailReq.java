/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_DoDelMailReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_DoDelMailReq
/*    */   extends IDIPCmd<IDIPPacket_DoDelMailReq, IDIPPacket_DoDelMailRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4227;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_DoDelMailReq, IDIPPacket_DoDelMailRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_DoDelMailReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_DoDelMailReq req, IDIPPacket_DoDelMailRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_DoDelMailReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_DoDelMailReq create()
/*    */   {
/* 33 */     IDIPPacket_DoDelMailReq req = IDIPPacket_DoDelMailReq.create();
/* 34 */     IDIPPacket_DoDelMailRsp rsp = IDIPPacket_DoDelMailRsp.create();
/* 35 */     return new IDIPCmd_DoDelMailReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_DoDelMailReq create(IDIPPacket_DoDelMailReq req, IDIPPacket_DoDelMailRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_DoDelMailReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_DoDelMailReq(IDIPPacket_DoDelMailReq req, IDIPPacket_DoDelMailRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4227;
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
/* 62 */     return new PIDIPCmd_DoDelMailReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_DoDelMailReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */