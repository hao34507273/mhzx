/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.CrossBattleFinalAwardInfo;
/*    */ import xbean.RoleCrossBattleFinalAwardInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2crossbattlefinalaward
/*    */ {
/*    */   public static RoleCrossBattleFinalAwardInfo get(Long key)
/*    */   {
/* 12 */     return (RoleCrossBattleFinalAwardInfo)_Tables_.getInstance().role2crossbattlefinalaward.get(key);
/*    */   }
/*    */   
/*    */   public static RoleCrossBattleFinalAwardInfo get(Long key, RoleCrossBattleFinalAwardInfo value)
/*    */   {
/* 17 */     return (RoleCrossBattleFinalAwardInfo)_Tables_.getInstance().role2crossbattlefinalaward.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleCrossBattleFinalAwardInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2crossbattlefinalaward.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2crossbattlefinalaward.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleCrossBattleFinalAwardInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2crossbattlefinalaward.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2crossbattlefinalaward.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleCrossBattleFinalAwardInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2crossbattlefinalaward.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleCrossBattleFinalAwardInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2crossbattlefinalaward;
/*    */   }
/*    */   
/*    */   public static RoleCrossBattleFinalAwardInfo select(Long key)
/*    */   {
/* 52 */     (RoleCrossBattleFinalAwardInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleCrossBattleFinalAwardInfo get(RoleCrossBattleFinalAwardInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, CrossBattleFinalAwardInfo> selectActivity_award_map(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, CrossBattleFinalAwardInfo> get(RoleCrossBattleFinalAwardInfo v)
/*    */       {
/* 67 */         return v.getActivity_award_mapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2crossbattlefinalaward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */