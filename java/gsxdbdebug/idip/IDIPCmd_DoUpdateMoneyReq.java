/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_DoUpdateMoneyReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_DoUpdateMoneyReq
/*    */   extends IDIPCmd<IDIPPacket_DoUpdateMoneyReq, IDIPPacket_DoUpdateMoneyRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4099;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_DoUpdateMoneyReq, IDIPPacket_DoUpdateMoneyRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_DoUpdateMoneyReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_DoUpdateMoneyReq req, IDIPPacket_DoUpdateMoneyRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_DoUpdateMoneyReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_DoUpdateMoneyReq create()
/*    */   {
/* 33 */     IDIPPacket_DoUpdateMoneyReq req = IDIPPacket_DoUpdateMoneyReq.create();
/* 34 */     IDIPPacket_DoUpdateMoneyRsp rsp = IDIPPacket_DoUpdateMoneyRsp.create();
/* 35 */     return new IDIPCmd_DoUpdateMoneyReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_DoUpdateMoneyReq create(IDIPPacket_DoUpdateMoneyReq req, IDIPPacket_DoUpdateMoneyRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_DoUpdateMoneyReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_DoUpdateMoneyReq(IDIPPacket_DoUpdateMoneyReq req, IDIPPacket_DoUpdateMoneyRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4099;
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
/* 62 */     return new PIDIPCmd_DoUpdateMoneyReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_DoUpdateMoneyReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */