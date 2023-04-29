/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_DoDelItemReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_DoDelItemReq
/*    */   extends IDIPCmd<IDIPPacket_DoDelItemReq, IDIPPacket_DoDelItemRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4119;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_DoDelItemReq, IDIPPacket_DoDelItemRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_DoDelItemReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_DoDelItemReq req, IDIPPacket_DoDelItemRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_DoDelItemReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_DoDelItemReq create()
/*    */   {
/* 33 */     IDIPPacket_DoDelItemReq req = IDIPPacket_DoDelItemReq.create();
/* 34 */     IDIPPacket_DoDelItemRsp rsp = IDIPPacket_DoDelItemRsp.create();
/* 35 */     return new IDIPCmd_DoDelItemReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_DoDelItemReq create(IDIPPacket_DoDelItemReq req, IDIPPacket_DoDelItemRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_DoDelItemReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_DoDelItemReq(IDIPPacket_DoDelItemReq req, IDIPPacket_DoDelItemRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4119;
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
/* 62 */     return new PIDIPCmd_DoDelItemReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_DoDelItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */