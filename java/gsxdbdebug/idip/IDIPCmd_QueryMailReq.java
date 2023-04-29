/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_QueryMailReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_QueryMailReq
/*    */   extends IDIPCmd<IDIPPacket_QueryMailReq, IDIPPacket_QueryMailRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4225;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_QueryMailReq, IDIPPacket_QueryMailRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_QueryMailReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_QueryMailReq req, IDIPPacket_QueryMailRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_QueryMailReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_QueryMailReq create()
/*    */   {
/* 33 */     IDIPPacket_QueryMailReq req = IDIPPacket_QueryMailReq.create();
/* 34 */     IDIPPacket_QueryMailRsp rsp = IDIPPacket_QueryMailRsp.create();
/* 35 */     return new IDIPCmd_QueryMailReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_QueryMailReq create(IDIPPacket_QueryMailReq req, IDIPPacket_QueryMailRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_QueryMailReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_QueryMailReq(IDIPPacket_QueryMailReq req, IDIPPacket_QueryMailRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4225;
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
/* 62 */     return new PIDIPCmd_QueryMailReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_QueryMailReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */