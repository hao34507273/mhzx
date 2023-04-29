/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_DoUpdateGoldIngotReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_DoUpdateGoldReq
/*    */   extends IDIPCmd<IDIPPacket_DoUpdateGoldReq, IDIPPacket_DoUpdateGoldRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4183;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_DoUpdateGoldReq, IDIPPacket_DoUpdateGoldRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_DoUpdateGoldReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_DoUpdateGoldReq req, IDIPPacket_DoUpdateGoldRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_DoUpdateGoldReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_DoUpdateGoldReq create()
/*    */   {
/* 33 */     IDIPPacket_DoUpdateGoldReq req = IDIPPacket_DoUpdateGoldReq.create();
/* 34 */     IDIPPacket_DoUpdateGoldRsp rsp = IDIPPacket_DoUpdateGoldRsp.create();
/* 35 */     return new IDIPCmd_DoUpdateGoldReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_DoUpdateGoldReq create(IDIPPacket_DoUpdateGoldReq req, IDIPPacket_DoUpdateGoldRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_DoUpdateGoldReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_DoUpdateGoldReq(IDIPPacket_DoUpdateGoldReq req, IDIPPacket_DoUpdateGoldRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4183;
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
/* 62 */     return new PIDIPCmd_DoUpdateGoldIngotReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_DoUpdateGoldReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */