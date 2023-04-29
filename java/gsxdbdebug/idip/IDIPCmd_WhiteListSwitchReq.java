/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_WhiteListSwitchReq
/*    */   extends IDIPCmd<IDIPPacket_WhiteListSwitchReq, IDIPPacket_WhiteListSwitchRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4167;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_WhiteListSwitchReq, IDIPPacket_WhiteListSwitchRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_WhiteListSwitchReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_WhiteListSwitchReq req, IDIPPacket_WhiteListSwitchRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_WhiteListSwitchReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_WhiteListSwitchReq create()
/*    */   {
/* 33 */     IDIPPacket_WhiteListSwitchReq req = IDIPPacket_WhiteListSwitchReq.create();
/* 34 */     IDIPPacket_WhiteListSwitchRsp rsp = IDIPPacket_WhiteListSwitchRsp.create();
/* 35 */     return new IDIPCmd_WhiteListSwitchReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_WhiteListSwitchReq create(IDIPPacket_WhiteListSwitchReq req, IDIPPacket_WhiteListSwitchRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_WhiteListSwitchReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_WhiteListSwitchReq(IDIPPacket_WhiteListSwitchReq req, IDIPPacket_WhiteListSwitchRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4167;
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
/* 62 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_WhiteListSwitchReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */