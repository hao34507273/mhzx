/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_AqDoUpdateOtherCashReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_AqDoUpdateOtherCashReq
/*    */   extends IDIPCmd<IDIPPacket_AqDoUpdateOtherCashReq, IDIPPacket_AqDoUpdateOtherCashRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4143;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_AqDoUpdateOtherCashReq, IDIPPacket_AqDoUpdateOtherCashRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_AqDoUpdateOtherCashReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_AqDoUpdateOtherCashReq req, IDIPPacket_AqDoUpdateOtherCashRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_AqDoUpdateOtherCashReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_AqDoUpdateOtherCashReq create()
/*    */   {
/* 33 */     IDIPPacket_AqDoUpdateOtherCashReq req = IDIPPacket_AqDoUpdateOtherCashReq.create();
/* 34 */     IDIPPacket_AqDoUpdateOtherCashRsp rsp = IDIPPacket_AqDoUpdateOtherCashRsp.create();
/* 35 */     return new IDIPCmd_AqDoUpdateOtherCashReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_AqDoUpdateOtherCashReq create(IDIPPacket_AqDoUpdateOtherCashReq req, IDIPPacket_AqDoUpdateOtherCashRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_AqDoUpdateOtherCashReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_AqDoUpdateOtherCashReq(IDIPPacket_AqDoUpdateOtherCashReq req, IDIPPacket_AqDoUpdateOtherCashRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4143;
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
/* 62 */     return new PIDIPCmd_AqDoUpdateOtherCashReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_AqDoUpdateOtherCashReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */