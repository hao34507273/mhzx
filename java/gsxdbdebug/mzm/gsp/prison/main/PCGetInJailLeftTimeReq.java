/*    */ package mzm.gsp.prison.main;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.npc.main.NpcInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pk.confbean.SPKConsts;
/*    */ import mzm.gsp.prison.SGetInJailLeftTimeRsp;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.PrisonInfo;
/*    */ import xtable.Role2prisoninfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCGetInJailLeftTimeReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   final long roleId;
/*    */   
/*    */   public PCGetInJailLeftTimeReq(long roleId)
/*    */   {
/* 24 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     boolean ret = PrisonManager.checkSwitchAndCross(this.roleId, 1667);
/* 32 */     if (!ret)
/*    */     {
/* 34 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 38 */     ret = NpcInterface.checkNpcService(SPKConsts.getInstance().PRISON_BREAK_NPC_ID, SPKConsts.getInstance().PRISON_SERVE_TIME_SERVICE_ID, this.roleId);
/*    */     
/* 40 */     if (!ret)
/*    */     {
/* 42 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 46 */     ret = MapInterface.isNearByNPC(this.roleId, SPKConsts.getInstance().PRISON_BREAK_NPC_ID);
/* 47 */     if (!ret)
/*    */     {
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     PrisonInfo xPrisonInfo = Role2prisoninfo.get(Long.valueOf(this.roleId));
/* 53 */     if (xPrisonInfo == null)
/*    */     {
/* 55 */       return false;
/*    */     }
/*    */     
/* 58 */     SGetInJailLeftTimeRsp getInJailLeftTimeRsp = new SGetInJailLeftTimeRsp();
/* 59 */     getInJailLeftTimeRsp.endtimestamp = (TimeUnit.SECONDS.toMillis(PrisonInterface.checkCanLetRoleOutOfJail(this.roleId, Role2prisoninfo.get(Long.valueOf(this.roleId))).inJailLeftTime) + DateTimeUtils.getCurrTimeInMillis());
/*    */     
/*    */ 
/* 62 */     OnlineManager.getInstance().send(this.roleId, getInJailLeftTimeRsp);
/* 63 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\PCGetInJailLeftTimeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */