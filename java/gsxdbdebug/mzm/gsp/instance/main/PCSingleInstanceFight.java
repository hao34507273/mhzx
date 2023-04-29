/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ 
/*    */ public class PCSingleInstanceFight extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int monsterInstanceid;
/*    */   
/*    */   public PCSingleInstanceFight(long roleid, int monsterInstanceid)
/*    */   {
/* 13 */     this.roleid = roleid;
/* 14 */     this.monsterInstanceid = monsterInstanceid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     if ((!OpenInterface.getOpenStatus(4)) || (OpenInterface.isBanPlay(this.roleid, 4)))
/*    */     {
/* 22 */       OpenInterface.sendBanPlayMsg(this.roleid, 4);
/* 23 */       GameServer.logger().info(String.format("[Instance]PCSingleInstanceFight.processImp@副本开关没有开启|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     Long instanceUuid = xtable.Role2instanceuuid.get(Long.valueOf(this.roleid));
/* 29 */     if (instanceUuid == null) {
/* 30 */       GameServer.logger().info(String.format("[Instance]PCSingleInstanceFight.processImp@副本开关没有开启|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     xbean.InstanceBean xInstanceBean = xtable.Role2instance.get(Long.valueOf(this.roleid));
/*    */     
/* 37 */     xbean.InstanceCacheBean xInstanceCacheBean = xtable.Instance.get(instanceUuid);
/* 38 */     SingleInstance.fightMonster(this.roleid, this.monsterInstanceid, instanceUuid.longValue(), xInstanceCacheBean, xInstanceBean);
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\PCSingleInstanceFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */