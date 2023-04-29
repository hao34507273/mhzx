/*    */ package mzm.gsp.magicmark.main;
/*    */ 
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.magicmark.SUnEuquipMagicMarkRes;
/*    */ import mzm.gsp.magicmark.event.MagicMarkModelChangeEvent;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.role.main.RoleOneByOneManager;
/*    */ import xbean.MagicMarkInfo;
/*    */ import xbean.MagicMarkSys;
/*    */ 
/*    */ public class PCUnEuquipMagicMarkReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int magicMarkType;
/*    */   
/*    */   public PCUnEuquipMagicMarkReq(long roleid, int magicmarktype)
/*    */   {
/* 19 */     this.roleid = roleid;
/* 20 */     this.magicMarkType = magicmarktype;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 25 */     if (!OpenInterface.getOpenStatus(206)) {
/* 26 */       mzm.gsp.GameServer.logger().info(String.format("[MagicMark]PCUnEuquipMagicMarkReq.processImp@switch is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/* 28 */       return false;
/*    */     }
/* 30 */     if (OpenInterface.isBanPlay(this.roleid, 206)) {
/* 31 */       OpenInterface.sendBanPlayMsg(this.roleid, 206);
/* 32 */       return false;
/*    */     }
/* 34 */     if (!MagicMarkManager.isOpenLevel(this.roleid)) {
/* 35 */       sendError(3);
/* 36 */       return false;
/*    */     }
/* 38 */     if (!MagicMarkManager.checkMutexStatus(this.roleid)) {
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     MagicMarkSys xMagicMarkSys = MagicMarkManager.getXMagicMarkSys(this.roleid, true);
/* 43 */     if (xMagicMarkSys == null) {
/* 44 */       sendError(2);
/* 45 */       return false;
/*    */     }
/* 47 */     MagicMarkInfo xMagicMarkInfo = (MagicMarkInfo)xMagicMarkSys.getMagicmarkinfos().get(Integer.valueOf(this.magicMarkType));
/* 48 */     if (xMagicMarkInfo == null) {
/* 49 */       sendError(2);
/* 50 */       return false;
/*    */     }
/* 52 */     if (this.magicMarkType != xMagicMarkSys.getEuqipedmagicmarktype()) {
/* 53 */       sendError(2);
/* 54 */       return false;
/*    */     }
/* 56 */     xMagicMarkSys.setEuqipedmagicmarktype(0);
/*    */     
/* 58 */     MagicMarkModelChangeEvent magicMarkModelChangeEvent = new MagicMarkModelChangeEvent();
/* 59 */     TriggerEventsManger.getInstance().triggerEvent(magicMarkModelChangeEvent, Long.valueOf(this.roleid), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*    */     
/*    */ 
/* 62 */     SUnEuquipMagicMarkRes unEuquipMagicMarkRes = new SUnEuquipMagicMarkRes();
/* 63 */     unEuquipMagicMarkRes.ret = 1;
/* 64 */     unEuquipMagicMarkRes.magicmarktype = this.magicMarkType;
/* 65 */     OnlineManager.getInstance().send(this.roleid, unEuquipMagicMarkRes);
/*    */     
/* 67 */     MagicMarkManager.tlogMagicMark(this.roleid, this.magicMarkType, 3, xMagicMarkInfo.getExpiredtime());
/*    */     
/* 69 */     return true;
/*    */   }
/*    */   
/*    */   private void sendError(int ret) {
/* 73 */     SUnEuquipMagicMarkRes unEuquipMagicMarkRes = new SUnEuquipMagicMarkRes();
/* 74 */     unEuquipMagicMarkRes.ret = ret;
/* 75 */     OnlineManager.getInstance().sendAtOnce(this.roleid, unEuquipMagicMarkRes);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\magicmark\main\PCUnEuquipMagicMarkReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */