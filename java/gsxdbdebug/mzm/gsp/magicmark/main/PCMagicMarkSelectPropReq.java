/*    */ package mzm.gsp.magicmark.main;
/*    */ 
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.magicmark.SMagicMarkSelectPropRes;
/*    */ import mzm.gsp.magicmark.event.MagicMarkPassiveSkillChangeEvent;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.role.main.RoleOneByOneManager;
/*    */ import xbean.MagicMarkInfo;
/*    */ import xbean.MagicMarkSys;
/*    */ 
/*    */ public class PCMagicMarkSelectPropReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int magicMarkType;
/*    */   
/*    */   public PCMagicMarkSelectPropReq(long roleid, int magicmarktype)
/*    */   {
/* 19 */     this.roleid = roleid;
/* 20 */     this.magicMarkType = magicmarktype;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 25 */     if (!OpenInterface.getOpenStatus(206)) {
/* 26 */       mzm.gsp.GameServer.logger().info(String.format("[MagicMark]PCMagicMarkSelectPropReq.processImp@switch is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/*    */ 
/* 29 */       return false;
/*    */     }
/* 31 */     if (OpenInterface.isBanPlay(this.roleid, 206)) {
/* 32 */       OpenInterface.sendBanPlayMsg(this.roleid, 206);
/* 33 */       return false;
/*    */     }
/* 35 */     if (!MagicMarkManager.isOpenLevel(this.roleid)) {
/* 36 */       sendError(3);
/* 37 */       return false;
/*    */     }
/* 39 */     if (!MagicMarkManager.checkMutexStatus(this.roleid)) {
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     MagicMarkSys xMagicMarkSys = MagicMarkManager.getXMagicMarkSys(this.roleid, true);
/* 44 */     if (xMagicMarkSys == null) {
/* 45 */       sendError(2);
/* 46 */       return false;
/*    */     }
/* 48 */     MagicMarkInfo xMagicMarkInfo = (MagicMarkInfo)xMagicMarkSys.getMagicmarkinfos().get(Integer.valueOf(this.magicMarkType));
/* 49 */     if (xMagicMarkInfo == null) {
/* 50 */       sendError(2);
/* 51 */       return false;
/*    */     }
/* 53 */     if (!MagicMarkManager.isMargicMarkAvailable(xMagicMarkInfo)) {
/* 54 */       sendError(2);
/* 55 */       return false;
/*    */     }
/* 57 */     xMagicMarkSys.setPropmagicmarktype(this.magicMarkType);
/*    */     
/* 59 */     MagicMarkPassiveSkillChangeEvent skillChangeEvent = new MagicMarkPassiveSkillChangeEvent();
/* 60 */     TriggerEventsManger.getInstance().triggerEvent(skillChangeEvent, Long.valueOf(this.roleid), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*    */     
/*    */ 
/* 63 */     SMagicMarkSelectPropRes magicMarkSelectPropRes = new SMagicMarkSelectPropRes();
/* 64 */     magicMarkSelectPropRes.ret = 1;
/* 65 */     magicMarkSelectPropRes.magicmarktype = xMagicMarkSys.getPropmagicmarktype();
/* 66 */     OnlineManager.getInstance().send(this.roleid, magicMarkSelectPropRes);
/*    */     
/* 68 */     MagicMarkManager.tlogMagicMark(this.roleid, this.magicMarkType, 6, xMagicMarkInfo.getExpiredtime());
/*    */     
/* 70 */     return true;
/*    */   }
/*    */   
/*    */   private void sendError(int ret) {
/* 74 */     SMagicMarkSelectPropRes magicMarkSelectPropRes = new SMagicMarkSelectPropRes();
/* 75 */     magicMarkSelectPropRes.ret = ret;
/* 76 */     OnlineManager.getInstance().sendAtOnce(this.roleid, magicMarkSelectPropRes);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\magicmark\main\PCMagicMarkSelectPropReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */