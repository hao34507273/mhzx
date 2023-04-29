/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_AqDoInitAccountReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_AqDoInitAccountReq
/*    */   extends IDIPCmd<IDIPPacket_AqDoInitAccountReq, IDIPPacket_AqDoInitAccountRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4161;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_AqDoInitAccountReq, IDIPPacket_AqDoInitAccountRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_AqDoInitAccountReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_AqDoInitAccountReq req, IDIPPacket_AqDoInitAccountRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_AqDoInitAccountReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_AqDoInitAccountReq create()
/*    */   {
/* 33 */     IDIPPacket_AqDoInitAccountReq req = IDIPPacket_AqDoInitAccountReq.create();
/* 34 */     IDIPPacket_AqDoInitAccountRsp rsp = IDIPPacket_AqDoInitAccountRsp.create();
/* 35 */     return new IDIPCmd_AqDoInitAccountReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_AqDoInitAccountReq create(IDIPPacket_AqDoInitAccountReq req, IDIPPacket_AqDoInitAccountRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_AqDoInitAccountReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_AqDoInitAccountReq(IDIPPacket_AqDoInitAccountReq req, IDIPPacket_AqDoInitAccountRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4161;
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
/* 62 */     return new PIDIPCmd_AqDoInitAccountReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_AqDoInitAccountReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */