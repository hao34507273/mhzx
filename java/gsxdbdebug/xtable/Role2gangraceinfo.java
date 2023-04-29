/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.GangRaceRoleInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2gangraceinfo
/*    */ {
/*    */   public static GangRaceRoleInfo get(Long key)
/*    */   {
/* 12 */     return (GangRaceRoleInfo)_Tables_.getInstance().role2gangraceinfo.get(key);
/*    */   }
/*    */   
/*    */   public static GangRaceRoleInfo get(Long key, GangRaceRoleInfo value)
/*    */   {
/* 17 */     return (GangRaceRoleInfo)_Tables_.getInstance().role2gangraceinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, GangRaceRoleInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2gangraceinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2gangraceinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, GangRaceRoleInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2gangraceinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2gangraceinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, GangRaceRoleInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2gangraceinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, GangRaceRoleInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2gangraceinfo;
/*    */   }
/*    */   
/*    */   public static GangRaceRoleInfo select(Long key)
/*    */   {
/* 52 */     (GangRaceRoleInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public GangRaceRoleInfo get(GangRaceRoleInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectGameid(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(GangRaceRoleInfo v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getGameid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectRaceid2money(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(GangRaceRoleInfo v)
/*    */       {
/* 78 */         return v.getRaceid2moneyAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2gangraceinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */