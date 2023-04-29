/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_AqDoZeroprofitReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_AqDoZeroprofitReq
/*    */   extends IDIPCmd<IDIPPacket_AqDoZeroprofitReq, IDIPPacket_AqDoZeroprofitRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4163;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_AqDoZeroprofitReq, IDIPPacket_AqDoZeroprofitRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_AqDoZeroprofitReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_AqDoZeroprofitReq req, IDIPPacket_AqDoZeroprofitRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_AqDoZeroprofitReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_AqDoZeroprofitReq create()
/*    */   {
/* 33 */     IDIPPacket_AqDoZeroprofitReq req = IDIPPacket_AqDoZeroprofitReq.create();
/* 34 */     IDIPPacket_AqDoZeroprofitRsp rsp = IDIPPacket_AqDoZeroprofitRsp.create();
/* 35 */     return new IDIPCmd_AqDoZeroprofitReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_AqDoZeroprofitReq create(IDIPPacket_AqDoZeroprofitReq req, IDIPPacket_AqDoZeroprofitRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_AqDoZeroprofitReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_AqDoZeroprofitReq(IDIPPacket_AqDoZeroprofitReq req, IDIPPacket_AqDoZeroprofitRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4163;
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
/* 62 */     return new PIDIPCmd_AqDoZeroprofitReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_AqDoZeroprofitReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */