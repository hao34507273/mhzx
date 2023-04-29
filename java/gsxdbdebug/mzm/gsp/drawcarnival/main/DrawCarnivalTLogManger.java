/*    */ package mzm.gsp.drawcarnival.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*    */ import mzm.gsp.role.main.Role;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ 
/*    */ public class DrawCarnivalTLogManger
/*    */ {
/*    */   private static final String T_LOG_DRAW = "DrawCarnivalDrawLog";
/*    */   
/*    */   private static String getTLogString(Object object)
/*    */   {
/* 20 */     if (object == null)
/*    */     {
/* 22 */       return "0";
/*    */     }
/* 24 */     if ((object instanceof Map))
/*    */     {
/* 26 */       return getMapTLogString((Map)object);
/*    */     }
/* 28 */     if ((object instanceof Collection))
/*    */     {
/* 30 */       return getCollectionTLogString((Collection)object);
/*    */     }
/* 32 */     return object.toString();
/*    */   }
/*    */   
/*    */   private static <K, V> String getMapTLogString(Map<K, V> map)
/*    */   {
/* 37 */     StringBuilder stringBuilder = new StringBuilder();
/* 38 */     boolean isFirst = true;
/* 39 */     for (Map.Entry<K, V> entry : map.entrySet())
/*    */     {
/* 41 */       if (!isFirst)
/*    */       {
/* 43 */         stringBuilder.append("#");
/*    */       }
/* 45 */       stringBuilder.append(getTLogString(entry.getKey())).append("#").append(getTLogString(entry.getValue()));
/* 46 */       isFirst = false;
/*    */     }
/* 48 */     return stringBuilder.toString();
/*    */   }
/*    */   
/*    */   private static <V> String getCollectionTLogString(Collection<V> collection)
/*    */   {
/* 53 */     StringBuilder stringBuilder = new StringBuilder();
/* 54 */     boolean isFirst = true;
/* 55 */     for (V value : collection)
/*    */     {
/* 57 */       if (!isFirst)
/*    */       {
/* 59 */         stringBuilder.append("#");
/*    */       }
/* 61 */       stringBuilder.append(getTLogString(value));
/* 62 */       isFirst = false;
/*    */     }
/* 64 */     return stringBuilder.toString();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   static void tLogDraw(long roleId, int activityId, int passTypeId, int isUseYuanBao, int isFree, int passCountIndex, int drawCountIndex, int awardType, AwardPoolResultData awardPoolResultData)
/*    */   {
/* 71 */     Role role = RoleInterface.getRole(roleId, true);
/* 72 */     if (role == null)
/*    */     {
/* 74 */       return;
/*    */     }
/*    */     
/* 77 */     List<Object> logColumns = new ArrayList();
/*    */     
/* 79 */     logColumns.add(GameServerInfoManager.getHostIP());
/* 80 */     logColumns.add(role.getUserId());
/* 81 */     logColumns.add(Long.valueOf(role.getId()));
/* 82 */     logColumns.add(Integer.valueOf(role.getLevel()));
/*    */     
/* 84 */     logColumns.add(Integer.valueOf(activityId));
/* 85 */     logColumns.add(Integer.valueOf(passTypeId));
/* 86 */     logColumns.add(Integer.valueOf(isUseYuanBao));
/* 87 */     logColumns.add(Integer.valueOf(isFree));
/* 88 */     logColumns.add(Integer.valueOf(passCountIndex));
/* 89 */     logColumns.add(Integer.valueOf(drawCountIndex));
/* 90 */     logColumns.add(Integer.valueOf(awardType));
/* 91 */     logColumns.add(getTLogString(awardPoolResultData.getItemMap()));
/*    */     
/* 93 */     TLogManager.getInstance().addLog(role.getUserId(), "DrawCarnivalDrawLog", logColumns.toArray());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\main\DrawCarnivalTLogManger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */