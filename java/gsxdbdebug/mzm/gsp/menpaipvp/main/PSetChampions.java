/*    */ package mzm.gsp.menpaipvp.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.badge.main.BadgeInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.menpaipvp.Champion;
/*    */ import mzm.gsp.menpaipvp.SChampionsBrd;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class PSetChampions
/*    */   extends LogicProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     Map<Integer, Long> menpai2Champion = MenpaiPVPManager.getMenpaiChampions();
/*    */     
/* 25 */     SChampionsBrd brd = new SChampionsBrd();
/* 26 */     for (Map.Entry<Integer, Long> entry : menpai2Champion.entrySet()) {
/* 27 */       int menpai = ((Integer)entry.getKey()).intValue();
/* 28 */       long champion = ((Long)entry.getValue()).longValue();
/*    */       
/* 30 */       Champion bean = new Champion();
/* 31 */       bean.roleid = champion;
/* 32 */       String name = RoleInterface.getName(champion);
/* 33 */       bean.name = name;
/* 34 */       bean.menpai = menpai;
/*    */       
/* 36 */       brd.champions.add(bean);
/*    */       
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 42 */       BadgeInterface.addBadgeNoneRealTime(champion, MenpaiPVPConfigManager.getInstance().getChampionBadge());
/*    */       
/*    */ 
/* 45 */       MapInterface.setMenPaiNpcModelAsyc(champion);
/*    */       
/*    */ 
/* 48 */       MenpaiPVPManager.logInfo("PSetChampions.process@menpai champion|menpai=%d|roleid=%d|name=%s", new Object[] { Integer.valueOf(menpai), Long.valueOf(champion), name });
/*    */     }
/*    */     
/* 51 */     OnlineManager.getInstance().sendAll(brd);
/*    */     
/* 53 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\main\PSetChampions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */