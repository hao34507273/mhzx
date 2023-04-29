/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BuildingFactory
/*    */ {
/*    */   static void init(long gangId, xbean.Gang xGang)
/*    */   {
/* 11 */     createGangBuilding(gangId, xGang, 0).init();
/* 12 */     createGangBuilding(gangId, xGang, 2).init();
/* 13 */     createGangBuilding(gangId, xGang, 1).init();
/* 14 */     createGangBuilding(gangId, xGang, 3).init();
/* 15 */     createGangBuilding(gangId, xGang, 5).init();
/* 16 */     createGangBuilding(gangId, xGang, 4).init();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static AbsGangBuilding createGangBuilding(long gangId, xbean.Gang xGang, int type)
/*    */   {
/* 26 */     switch (type)
/*    */     {
/*    */     case 0: 
/* 29 */       return new XiangFang(gangId, type, xGang);
/*    */     case 2: 
/* 31 */       return new JinKu(gangId, type, xGang);
/*    */     case 1: 
/* 33 */       return new CangKu(gangId, type, xGang);
/*    */     case 3: 
/* 35 */       return new YaoDian(gangId, type, xGang);
/*    */     case 5: 
/* 37 */       return new ShuYuan(gangId, type, xGang);
/*    */     case 4: 
/* 39 */       return new Gang(gangId, type, xGang);
/*    */     }
/* 41 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\BuildingFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */