/*    */ package mzm.gsp.personal.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.MergeMain;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.NoneRealTimeSnsRoles;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Nonerealtimesnsroles;
/*    */ 
/*    */ public class PSnsMerge extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     long mainKey = MergeMain.getMainZoneid();
/* 15 */     long viceKey = MergeMain.getViceZoneid();
/* 16 */     lock(Lockeys.get(Nonerealtimesnsroles.getTable(), new Object[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*    */     
/* 18 */     NoneRealTimeSnsRoles xViceNoneRealTimeSnsRoles = Nonerealtimesnsroles.get(Long.valueOf(viceKey));
/* 19 */     if (xViceNoneRealTimeSnsRoles != null)
/*    */     {
/* 21 */       NoneRealTimeSnsRoles xMainNoneRealTimeSnsRoles = Nonerealtimesnsroles.get(Long.valueOf(mainKey));
/* 22 */       if (xMainNoneRealTimeSnsRoles == null)
/*    */       {
/* 24 */         xMainNoneRealTimeSnsRoles = xbean.Pod.newNoneRealTimeSnsRoles();
/* 25 */         Nonerealtimesnsroles.insert(Long.valueOf(mainKey), xMainNoneRealTimeSnsRoles);
/*    */       }
/* 27 */       xMainNoneRealTimeSnsRoles.getRoleids().addAll(xViceNoneRealTimeSnsRoles.getRoleids());
/*    */     }
/* 29 */     Nonerealtimesnsroles.remove(Long.valueOf(viceKey));
/*    */     
/* 31 */     GameServer.logger().info(String.format("[personal]PSnsMerge.processImp@merge success|main_key=%d|vice_key=%d", new Object[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*    */     
/*    */ 
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\PSnsMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */