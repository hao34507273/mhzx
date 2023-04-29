/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_AqDoUpdateMoneyReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_AqDoUpdateMoneyReq
/*    */   extends IDIPCmd<IDIPPacket_AqDoUpdateMoneyReq, IDIPPacket_AqDoUpdateMoneyRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4139;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_AqDoUpdateMoneyReq, IDIPPacket_AqDoUpdateMoneyRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_AqDoUpdateMoneyReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_AqDoUpdateMoneyReq req, IDIPPacket_AqDoUpdateMoneyRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_AqDoUpdateMoneyReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_AqDoUpdateMoneyReq create()
/*    */   {
/* 33 */     IDIPPacket_AqDoUpdateMoneyReq req = IDIPPacket_AqDoUpdateMoneyReq.create();
/* 34 */     IDIPPacket_AqDoUpdateMoneyRsp rsp = IDIPPacket_AqDoUpdateMoneyRsp.create();
/* 35 */     return new IDIPCmd_AqDoUpdateMoneyReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_AqDoUpdateMoneyReq create(IDIPPacket_AqDoUpdateMoneyReq req, IDIPPacket_AqDoUpdateMoneyRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_AqDoUpdateMoneyReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_AqDoUpdateMoneyReq(IDIPPacket_AqDoUpdateMoneyReq req, IDIPPacket_AqDoUpdateMoneyRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4139;
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
/* 62 */     return new PIDIPCmd_AqDoUpdateMoneyReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_AqDoUpdateMoneyReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */