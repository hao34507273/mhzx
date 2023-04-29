/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_AqDoBanAddFriendReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_AqDoBanAddFriendReq
/*    */   extends IDIPCmd<IDIPPacket_AqDoBanAddFriendReq, IDIPPacket_AqDoBanAddFriendRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4199;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_AqDoBanAddFriendReq, IDIPPacket_AqDoBanAddFriendRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_AqDoBanAddFriendReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_AqDoBanAddFriendReq req, IDIPPacket_AqDoBanAddFriendRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_AqDoBanAddFriendReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_AqDoBanAddFriendReq create()
/*    */   {
/* 33 */     IDIPPacket_AqDoBanAddFriendReq req = IDIPPacket_AqDoBanAddFriendReq.create();
/* 34 */     IDIPPacket_AqDoBanAddFriendRsp rsp = IDIPPacket_AqDoBanAddFriendRsp.create();
/* 35 */     return new IDIPCmd_AqDoBanAddFriendReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_AqDoBanAddFriendReq create(IDIPPacket_AqDoBanAddFriendReq req, IDIPPacket_AqDoBanAddFriendRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_AqDoBanAddFriendReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_AqDoBanAddFriendReq(IDIPPacket_AqDoBanAddFriendReq req, IDIPPacket_AqDoBanAddFriendRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4199;
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
/* 62 */     return new PIDIPCmd_AqDoBanAddFriendReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_AqDoBanAddFriendReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */