/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_AqDoUpdateCashReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_AqDoUpdateCashReq
/*    */   extends IDIPCmd<IDIPPacket_AqDoUpdateCashReq, IDIPPacket_AqDoUpdateCashRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4141;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_AqDoUpdateCashReq, IDIPPacket_AqDoUpdateCashRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_AqDoUpdateCashReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_AqDoUpdateCashReq req, IDIPPacket_AqDoUpdateCashRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_AqDoUpdateCashReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_AqDoUpdateCashReq create()
/*    */   {
/* 33 */     IDIPPacket_AqDoUpdateCashReq req = IDIPPacket_AqDoUpdateCashReq.create();
/* 34 */     IDIPPacket_AqDoUpdateCashRsp rsp = IDIPPacket_AqDoUpdateCashRsp.create();
/* 35 */     return new IDIPCmd_AqDoUpdateCashReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_AqDoUpdateCashReq create(IDIPPacket_AqDoUpdateCashReq req, IDIPPacket_AqDoUpdateCashRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_AqDoUpdateCashReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_AqDoUpdateCashReq(IDIPPacket_AqDoUpdateCashReq req, IDIPPacket_AqDoUpdateCashRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4141;
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
/* 62 */     return new PIDIPCmd_AqDoUpdateCashReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_AqDoUpdateCashReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */