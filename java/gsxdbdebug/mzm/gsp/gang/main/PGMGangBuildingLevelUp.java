/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.confbean.SGangDutyCfg;
/*    */ import mzm.gsp.gang.confbean.SGangLevelCfg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ public class PGMGangBuildingLevelUp
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private String buildingType;
/*    */   private int lv;
/*    */   
/*    */   public PGMGangBuildingLevelUp(long roleId, String buildingType, int lv)
/*    */   {
/* 18 */     this.roleId = roleId;
/* 19 */     this.buildingType = buildingType;
/* 20 */     this.lv = lv;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(this.roleId));
/* 27 */     if (xGangMember == null) {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(xGangMember.getGangid()));
/* 32 */     if (xGang == null) {
/* 33 */       return false;
/*    */     }
/* 35 */     if (!GangManager.isInGang(xGang, this.roleId)) {
/* 36 */       return false;
/*    */     }
/* 38 */     SGangDutyCfg sGangDutyCfg = GangManager.getDutyCfg(xGangMember);
/* 39 */     if (!sGangDutyCfg.isCanLevelUpGang) {
/* 40 */       return false;
/*    */     }
/* 42 */     SGangLevelCfg sGangLevelCfg = SGangLevelCfg.get(xGang.getLevel());
/* 43 */     if (this.buildingType.equals("yaodian")) {
/* 44 */       YaoDian yaodian = (YaoDian)BuildingFactory.createGangBuilding(xGangMember.getGangid(), xGang, 3);
/* 45 */       int maxLv = Math.min(sGangLevelCfg.yaoDianMaxLevel, this.lv);
/* 46 */       yaodian.setLevel(maxLv);
/* 47 */       yaodian.brocadcastLevelUp();
/* 48 */     } else if (this.buildingType.equals("xiangfang")) {
/* 49 */       XiangFang yaodian = (XiangFang)BuildingFactory.createGangBuilding(xGangMember.getGangid(), xGang, 0);
/* 50 */       int maxLv = Math.min(sGangLevelCfg.xiangFangMaxLevel, this.lv);
/* 51 */       yaodian.setLevel(maxLv);
/* 52 */       yaodian.brocadcastLevelUp();
/* 53 */     } else if (this.buildingType.equals("jinku")) {
/* 54 */       JinKu yaodian = (JinKu)BuildingFactory.createGangBuilding(xGangMember.getGangid(), xGang, 2);
/* 55 */       int maxLv = Math.min(sGangLevelCfg.jinKuMaxLevel, this.lv);
/* 56 */       yaodian.setLevel(maxLv);
/* 57 */       yaodian.brocadcastLevelUp();
/* 58 */     } else if (this.buildingType.equals("cangku")) {
/* 59 */       CangKu yaodian = (CangKu)BuildingFactory.createGangBuilding(xGangMember.getGangid(), xGang, 1);
/* 60 */       int maxLv = Math.min(sGangLevelCfg.jinKuMaxLevel, this.lv);
/* 61 */       yaodian.setLevel(maxLv);
/* 62 */       yaodian.brocadcastLevelUp();
/* 63 */     } else if (this.buildingType.equals("shuyuan")) {
/* 64 */       ShuYuan yaodian = (ShuYuan)BuildingFactory.createGangBuilding(xGangMember.getGangid(), xGang, 5);
/* 65 */       int maxLv = Math.min(sGangLevelCfg.shuYuanMaxLevel, this.lv);
/* 66 */       yaodian.setLevel(maxLv);
/* 67 */       yaodian.brocadcastLevelUp();
/*    */     }
/* 69 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PGMGangBuildingLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */