/*    */ package mzm.gsp.magicmark.main;
/*    */ 
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.magicmark.SEquipMagicMarkRes;
/*    */ import mzm.gsp.magicmark.event.MagicMarkModelChangeEvent;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.role.main.RoleOneByOneManager;
/*    */ import xbean.MagicMarkInfo;
/*    */ import xbean.MagicMarkSys;
/*    */ 
/*    */ public class PCEquipMagicMarkReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int magicMarkType;
/*    */   
/*    */   public PCEquipMagicMarkReq(long roleid, int magicmarktype)
/*    */   {
/* 19 */     this.roleid = roleid;
/* 20 */     this.magicMarkType = magicmarktype;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 25 */     if (!OpenInterface.getOpenStatus(206)) {
/* 26 */       mzm.gsp.GameServer.logger().info(String.format("[MagicMark]PCEquipMagicMarkReq.processImp@switch is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/* 28 */       return false;
/*    */     }
/* 30 */     if (OpenInterface.isBanPlay(this.roleid, 206)) {
/* 31 */       OpenInterface.sendBanPlayMsg(this.roleid, 206);
/* 32 */       return false;
/*    */     }
/* 34 */     if (!MagicMarkManager.isOpenLevel(this.roleid)) {
/* 35 */       sendErrorRes(3);
/* 36 */       return false;
/*    */     }
/* 38 */     if (!MagicMarkManager.checkMutexStatus(this.roleid)) {
/* 39 */       return false;
/*    */     }
/* 41 */     MagicMarkSys xMagicMarkSys = MagicMarkManager.getXMagicMarkSys(this.roleid, true);
/* 42 */     if (xMagicMarkSys == null) {
/* 43 */       sendErrorRes(2);
/* 44 */       return false;
/*    */     }
/* 46 */     MagicMarkInfo xMagicMarkInfo = (MagicMarkInfo)xMagicMarkSys.getMagicmarkinfos().get(Integer.valueOf(this.magicMarkType));
/* 47 */     if (xMagicMarkInfo == null) {
/* 48 */       sendErrorRes(2);
/* 49 */       return false;
/*    */     }
/* 51 */     if (!MagicMarkManager.isMargicMarkAvailable(xMagicMarkInfo)) {
/* 52 */       sendErrorRes(2);
/* 53 */       return false;
/*    */     }
/* 55 */     xMagicMarkSys.setEuqipedmagicmarktype(this.magicMarkType);
/*    */     
/* 57 */     MagicMarkModelChangeEvent magicMarkModelChangeEvent = new MagicMarkModelChangeEvent();
/* 58 */     TriggerEventsManger.getInstance().triggerEvent(magicMarkModelChangeEvent, Long.valueOf(this.roleid), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*    */     
/*    */ 
/* 61 */     SEquipMagicMarkRes equipMagicMarkRes = new SEquipMagicMarkRes();
/* 62 */     equipMagicMarkRes.ret = 1;
/* 63 */     equipMagicMarkRes.magicmarktype = this.magicMarkType;
/* 64 */     OnlineManager.getInstance().send(this.roleid, equipMagicMarkRes);
/*    */     
/* 66 */     MagicMarkManager.tlogMagicMark(this.roleid, this.magicMarkType, 2, xMagicMarkInfo.getExpiredtime());
/*    */     
/* 68 */     return true;
/*    */   }
/*    */   
/*    */   private void sendErrorRes(int ret) {
/* 72 */     SEquipMagicMarkRes equipMagicMarkRes = new SEquipMagicMarkRes();
/* 73 */     equipMagicMarkRes.ret = ret;
/* 74 */     OnlineManager.getInstance().sendAtOnce(this.roleid, equipMagicMarkRes);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\magicmark\main\PCEquipMagicMarkReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */