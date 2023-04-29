/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.SSyncBuildingLevelUpSuccess;
/*    */ import mzm.gsp.gang.confbean.SGangDutyCfg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ public class PGMSetGangLevel
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int level;
/*    */   
/*    */   public PGMSetGangLevel(long roleId, int level)
/*    */   {
/* 17 */     this.roleId = roleId;
/* 18 */     this.level = level;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(this.roleId));
/* 25 */     if (xGangMember == null) {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(xGangMember.getGangid()));
/* 30 */     if (xGang == null) {
/* 31 */       return false;
/*    */     }
/* 33 */     if (!GangManager.isInGang(xGang, this.roleId)) {
/* 34 */       return false;
/*    */     }
/* 36 */     SGangDutyCfg sGangDutyCfg = GangManager.getDutyCfg(xGangMember);
/* 37 */     if (!sGangDutyCfg.isCanLevelUpGang) {
/* 38 */       return false;
/*    */     }
/* 40 */     int oldLv = xGang.getLevel();
/*    */     
/* 42 */     if (this.level <= oldLv) {
/* 43 */       return false;
/*    */     }
/* 45 */     xGang.setLevel(this.level);
/* 46 */     SSyncBuildingLevelUpSuccess sSyncGangLevelUp = new SSyncBuildingLevelUpSuccess();
/* 47 */     sSyncGangLevelUp.level = this.level;
/* 48 */     sSyncGangLevelUp.buildingtype = 4;
/* 49 */     GangManager.broadcast(xGang, sSyncGangLevelUp);
/* 50 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PGMSetGangLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */