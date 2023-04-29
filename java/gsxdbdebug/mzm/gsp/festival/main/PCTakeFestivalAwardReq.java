/*    */ package mzm.gsp.festival.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.confbean.FestivalAwardOwnCfg;
/*    */ import mzm.gsp.activity.confbean.SFestivalAwardConst;
/*    */ import mzm.gsp.festival.STakeFestivalAwardRes;
/*    */ import mzm.gsp.idip.main.IdipManager;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.item.main.ItemOperateResult;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.FestivalAward;
/*    */ import xtable.Role2festivalaward;
/*    */ 
/*    */ public class PCTakeFestivalAwardReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int festivalAwardid;
/*    */   
/*    */   public PCTakeFestivalAwardReq(long roleid, int festivalawardid)
/*    */   {
/* 24 */     this.roleid = roleid;
/* 25 */     this.festivalAwardid = festivalawardid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 30 */     if (!MapInterface.isNearByNPC(this.roleid, SFestivalAwardConst.getInstance().festivalNpcid)) {
/* 31 */       GameServer.logger().info(String.format("[FestivalModule]PCTakeFestivalAwardReq.processImp@not near npc|npcid=%d", new Object[] { Integer.valueOf(SFestivalAwardConst.getInstance().festivalNpcid) }));
/*    */       
/*    */ 
/* 34 */       return false;
/*    */     }
/* 36 */     FestivalAwardOwnCfg festivalAwardCfg = FestivalManager.getCurrentFestivalAwardCfg();
/* 37 */     if ((festivalAwardCfg == null) || (festivalAwardCfg.cfgid != this.festivalAwardid)) {
/* 38 */       FestivalManager.sendNormalRet(this.roleid, 0, new String[0]);
/* 39 */       return false;
/*    */     }
/* 41 */     if (festivalAwardCfg.minLevel > 0) {
/* 42 */       int level = mzm.gsp.role.main.RoleInterface.getLevel(this.roleid);
/* 43 */       if (level < festivalAwardCfg.minLevel) {
/* 44 */         GameServer.logger().info(String.format("[FestivalModule]PCTakeFestivalAwardReq.processImp@level not enough|roleid=%d|needLevel=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(festivalAwardCfg.minLevel) }));
/*    */         
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 51 */         return false;
/*    */       }
/*    */     }
/*    */     
/* 55 */     FestivalAward xFestivalAward = Role2festivalaward.get(Long.valueOf(this.roleid));
/* 56 */     if (xFestivalAward == null) {
/* 57 */       xFestivalAward = xbean.Pod.newFestivalAward();
/* 58 */       Role2festivalaward.insert(Long.valueOf(this.roleid), xFestivalAward);
/*    */     }
/*    */     
/* 61 */     if (xFestivalAward.getLastestawardedcfgid() == this.festivalAwardid) {
/* 62 */       GameServer.logger().info(String.format("[FestivalModule]PCTakeFestivalAwardReq.processImp@role has already token festival award|id=%d", new Object[] { Integer.valueOf(festivalAwardCfg.cfgid) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 69 */       return false;
/*    */     }
/*    */     
/* 72 */     int awardItemid = festivalAwardCfg.giftid;
/* 73 */     if (!IdipManager.isZeroProfit(this.roleid)) {
/* 74 */       ItemOperateResult itemOperateResult = ItemInterface.addItem(this.roleid, awardItemid, 1, true, new mzm.gsp.tlog.TLogArg(LogReason.FESTIVAL_AWARD_ADD, this.festivalAwardid));
/*    */       
/* 76 */       if (!itemOperateResult.success()) {
/* 77 */         GameServer.logger().info(String.format("[FestivalModule]PCTakeFestivalAwardReq.processImp@add item not succeed|itemid=%d", new Object[] { Integer.valueOf(festivalAwardCfg.giftid) }));
/*    */         
/*    */ 
/*    */ 
/* 81 */         if (itemOperateResult.isBagFull()) {
/* 82 */           FestivalManager.sendNormalRet(this.roleid, 1, new String[0]);
/*    */         } else {
/* 84 */           FestivalManager.sendNormalRet(this.roleid, 3, new String[0]);
/*    */         }
/* 86 */         return false;
/*    */       }
/*    */     }
/*    */     
/* 90 */     xFestivalAward.setLastestawardedcfgid(this.festivalAwardid);
/*    */     
/* 92 */     STakeFestivalAwardRes takeFestivalAwardRes = new STakeFestivalAwardRes();
/* 93 */     takeFestivalAwardRes.festivalawardid = this.festivalAwardid;
/* 94 */     OnlineManager.getInstance().send(this.roleid, takeFestivalAwardRes);
/*    */     
/* 96 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\festival\main\PCTakeFestivalAwardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */