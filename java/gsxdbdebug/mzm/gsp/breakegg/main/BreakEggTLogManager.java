/*    */ package mzm.gsp.breakegg.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ import xbean.BreakEggGameInfo;
/*    */ import xbean.BreakEggInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BreakEggTLogManager
/*    */ {
/*    */   private static final String TLOG_BREAK_EGG_ACTIVITY = "BreakEggActivity";
/*    */   
/*    */   public static void tlogBreakEgg(BreakEggGameInfo xBreakegg_info, List<Long> rewardRoleIds)
/*    */   {
/* 22 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 23 */     String userid = RoleInterface.getUserId(xBreakegg_info.getInviter_id());
/* 24 */     int rolelevel = RoleInterface.getLevel(xBreakegg_info.getInviter_id());
/*    */     
/* 26 */     StringBuffer sb = new StringBuffer();
/* 27 */     for (Map.Entry<Integer, BreakEggInfo> entry : xBreakegg_info.getIndex2break_egg_info().entrySet())
/*    */     {
/* 29 */       sb.append("[");
/* 30 */       sb.append(entry.getKey()).append("_");
/* 31 */       sb.append(((BreakEggInfo)entry.getValue()).getRole_id()).append("_");
/* 32 */       sb.append(((BreakEggInfo)entry.getValue()).getItemid2num().toString());
/* 33 */       sb.append("]");
/* 34 */       sb.append(",");
/*    */     }
/*    */     
/* 37 */     String logStr = String.format("%s|%s|%d|%d|%d|%s|%s|%s|%s", new Object[] { vGameIP, userid, Long.valueOf(xBreakegg_info.getInviter_id()), Integer.valueOf(rolelevel), Integer.valueOf(xBreakegg_info.getActivity_id()), xBreakegg_info.getReward_info_id().toString(), xBreakegg_info.getRoleid_list().toString(), rewardRoleIds.toString(), sb.toString() });
/*    */     
/*    */ 
/* 40 */     TLogManager.getInstance().addLog(userid, "BreakEggActivity", logStr);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\main\BreakEggTLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */