/*    */ package mzm.gsp.magicmark.main;
/*    */ 
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.magicmark.SMagicMarkUnSelectPropRes;
/*    */ import mzm.gsp.magicmark.event.MagicMarkPassiveSkillChangeEvent;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.role.main.RoleOneByOneManager;
/*    */ import xbean.MagicMarkInfo;
/*    */ import xbean.MagicMarkSys;
/*    */ 
/*    */ public class PCMagicMarkUnSelectPropReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int magicMarkType;
/*    */   
/*    */   public PCMagicMarkUnSelectPropReq(long roleid, int magicmarktype)
/*    */   {
/* 20 */     this.roleid = roleid;
/* 21 */     this.magicMarkType = magicmarktype;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 26 */     if (!OpenInterface.getOpenStatus(206)) {
/* 27 */       GameServer.logger().info(String.format("[MagicMark]PCMagicMarkUnSelectPropReq.processImp@switch is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/*    */ 
/* 30 */       return false;
/*    */     }
/* 32 */     if (OpenInterface.isBanPlay(this.roleid, 206)) {
/* 33 */       OpenInterface.sendBanPlayMsg(this.roleid, 206);
/* 34 */       return false;
/*    */     }
/* 36 */     if (!MagicMarkManager.isOpenLevel(this.roleid)) {
/* 37 */       sendError(3);
/* 38 */       return false;
/*    */     }
/* 40 */     if (!MagicMarkManager.checkMutexStatus(this.roleid)) {
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     MagicMarkSys xMagicMarkSys = MagicMarkManager.getXMagicMarkSys(this.roleid, true);
/* 45 */     if (xMagicMarkSys == null) {
/* 46 */       sendError(2);
/* 47 */       return false;
/*    */     }
/* 49 */     MagicMarkInfo xMagicMarkInfo = (MagicMarkInfo)xMagicMarkSys.getMagicmarkinfos().get(Integer.valueOf(this.magicMarkType));
/* 50 */     if (xMagicMarkInfo == null) {
/* 51 */       sendError(2);
/* 52 */       return false;
/*    */     }
/* 54 */     if (this.magicMarkType != xMagicMarkSys.getPropmagicmarktype()) {
/* 55 */       sendError(2);
/* 56 */       return false;
/*    */     }
/* 58 */     xMagicMarkSys.setPropmagicmarktype(0);
/*    */     
/* 60 */     MagicMarkPassiveSkillChangeEvent passiveSkillChangeEvent = new MagicMarkPassiveSkillChangeEvent();
/* 61 */     TriggerEventsManger.getInstance().triggerEvent(passiveSkillChangeEvent, Long.valueOf(this.roleid), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*    */     
/*    */ 
/* 64 */     SMagicMarkUnSelectPropRes magicMarkUnSelectPropRes = new SMagicMarkUnSelectPropRes();
/* 65 */     magicMarkUnSelectPropRes.ret = 1;
/* 66 */     magicMarkUnSelectPropRes.magicmarktype = xMagicMarkSys.getPropmagicmarktype();
/* 67 */     OnlineManager.getInstance().send(this.roleid, magicMarkUnSelectPropRes);
/*    */     
/* 69 */     MagicMarkManager.tlogMagicMark(this.roleid, this.magicMarkType, 7, xMagicMarkInfo.getExpiredtime());
/*    */     
/* 71 */     return true;
/*    */   }
/*    */   
/*    */   private void sendError(int ret) {
/* 75 */     SMagicMarkUnSelectPropRes magicMarkUnSelectPropRes = new SMagicMarkUnSelectPropRes();
/* 76 */     magicMarkUnSelectPropRes.ret = ret;
/* 77 */     OnlineManager.getInstance().sendAtOnce(this.roleid, magicMarkUnSelectPropRes);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\magicmark\main\PCMagicMarkUnSelectPropReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */