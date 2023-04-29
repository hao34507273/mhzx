/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.RoleBigBossRemoteChartAwardInfo;
/*    */ import xbean.RoleBigBossRemoteChartInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role_big_boss_remote_chart_infos
/*    */ {
/*    */   public static RoleBigBossRemoteChartInfo get(Long key)
/*    */   {
/* 12 */     return (RoleBigBossRemoteChartInfo)_Tables_.getInstance().role_big_boss_remote_chart_infos.get(key);
/*    */   }
/*    */   
/*    */   public static RoleBigBossRemoteChartInfo get(Long key, RoleBigBossRemoteChartInfo value)
/*    */   {
/* 17 */     return (RoleBigBossRemoteChartInfo)_Tables_.getInstance().role_big_boss_remote_chart_infos.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleBigBossRemoteChartInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role_big_boss_remote_chart_infos.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role_big_boss_remote_chart_infos.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleBigBossRemoteChartInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role_big_boss_remote_chart_infos.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role_big_boss_remote_chart_infos.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleBigBossRemoteChartInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role_big_boss_remote_chart_infos.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleBigBossRemoteChartInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role_big_boss_remote_chart_infos;
/*    */   }
/*    */   
/*    */   public static RoleBigBossRemoteChartInfo select(Long key)
/*    */   {
/* 52 */     (RoleBigBossRemoteChartInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleBigBossRemoteChartInfo get(RoleBigBossRemoteChartInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, RoleBigBossRemoteChartAwardInfo> selectAward_infos(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, RoleBigBossRemoteChartAwardInfo> get(RoleBigBossRemoteChartInfo v)
/*    */       {
/* 67 */         return v.getAward_infosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role_big_boss_remote_chart_infos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */