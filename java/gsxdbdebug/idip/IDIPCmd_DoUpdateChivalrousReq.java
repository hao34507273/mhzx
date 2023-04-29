/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_DoUpdateChivalrousReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_DoUpdateChivalrousReq
/*    */   extends IDIPCmd<IDIPPacket_DoUpdateChivalrousReq, IDIPPacket_DoUpdateChivalrousRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4107;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_DoUpdateChivalrousReq, IDIPPacket_DoUpdateChivalrousRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_DoUpdateChivalrousReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_DoUpdateChivalrousReq req, IDIPPacket_DoUpdateChivalrousRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_DoUpdateChivalrousReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_DoUpdateChivalrousReq create()
/*    */   {
/* 33 */     IDIPPacket_DoUpdateChivalrousReq req = IDIPPacket_DoUpdateChivalrousReq.create();
/* 34 */     IDIPPacket_DoUpdateChivalrousRsp rsp = IDIPPacket_DoUpdateChivalrousRsp.create();
/* 35 */     return new IDIPCmd_DoUpdateChivalrousReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_DoUpdateChivalrousReq create(IDIPPacket_DoUpdateChivalrousReq req, IDIPPacket_DoUpdateChivalrousRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_DoUpdateChivalrousReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_DoUpdateChivalrousReq(IDIPPacket_DoUpdateChivalrousReq req, IDIPPacket_DoUpdateChivalrousRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4107;
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
/* 62 */     return new PIDIPCmd_DoUpdateChivalrousReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_DoUpdateChivalrousReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */