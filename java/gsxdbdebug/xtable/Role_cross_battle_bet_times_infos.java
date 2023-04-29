/*    */ package xtable;
/*    */ 
/*    */ import xbean.RoleCrossBattleBetTimesInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role_cross_battle_bet_times_infos
/*    */ {
/*    */   public static RoleCrossBattleBetTimesInfo get(Long key)
/*    */   {
/* 12 */     return (RoleCrossBattleBetTimesInfo)_Tables_.getInstance().role_cross_battle_bet_times_infos.get(key);
/*    */   }
/*    */   
/*    */   public static RoleCrossBattleBetTimesInfo get(Long key, RoleCrossBattleBetTimesInfo value)
/*    */   {
/* 17 */     return (RoleCrossBattleBetTimesInfo)_Tables_.getInstance().role_cross_battle_bet_times_infos.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleCrossBattleBetTimesInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role_cross_battle_bet_times_infos.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role_cross_battle_bet_times_infos.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleCrossBattleBetTimesInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role_cross_battle_bet_times_infos.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role_cross_battle_bet_times_infos.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, RoleCrossBattleBetTimesInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role_cross_battle_bet_times_infos.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleCrossBattleBetTimesInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role_cross_battle_bet_times_infos;
/*    */   }
/*    */   
/*    */   public static RoleCrossBattleBetTimesInfo select(Long key)
/*    */   {
/* 52 */     (RoleCrossBattleBetTimesInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public RoleCrossBattleBetTimesInfo get(RoleCrossBattleBetTimesInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectTimes(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(RoleCrossBattleBetTimesInfo v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getTimes());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectTimestamp(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(RoleCrossBattleBetTimesInfo v)
/*    */       {
/* 78 */         return Long.valueOf(v.getTimestamp());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role_cross_battle_bet_times_infos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */