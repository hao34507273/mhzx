/*    */ package xtable;
/*    */ 
/*    */ import java.util.Set;
/*    */ import xbean.GangRaceGameInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Gangrace2gameinfo
/*    */ {
/*    */   public static GangRaceGameInfo get(Long key)
/*    */   {
/* 12 */     return (GangRaceGameInfo)_Tables_.getInstance().gangrace2gameinfo.get(key);
/*    */   }
/*    */   
/*    */   public static GangRaceGameInfo get(Long key, GangRaceGameInfo value)
/*    */   {
/* 17 */     return (GangRaceGameInfo)_Tables_.getInstance().gangrace2gameinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, GangRaceGameInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().gangrace2gameinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().gangrace2gameinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, GangRaceGameInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().gangrace2gameinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().gangrace2gameinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, GangRaceGameInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().gangrace2gameinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, GangRaceGameInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().gangrace2gameinfo;
/*    */   }
/*    */   
/*    */   public static GangRaceGameInfo select(Long key)
/*    */   {
/* 52 */     (GangRaceGameInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public GangRaceGameInfo get(GangRaceGameInfo v)
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
/*    */       public Integer get(GangRaceGameInfo v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getGameid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Long> selectCurgameroleids(Long key)
/*    */   {
/* 74 */     (Set)getTable().select(key, new TField()
/*    */     {
/*    */       public Set<Long> get(GangRaceGameInfo v)
/*    */       {
/* 78 */         return v.getCurgameroleidsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Long> selectAllroleids(Long key)
/*    */   {
/* 85 */     (Set)getTable().select(key, new TField()
/*    */     {
/*    */       public Set<Long> get(GangRaceGameInfo v)
/*    */       {
/* 89 */         return v.getAllroleidsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static java.util.Map<Integer, Integer> selectRaceid2money(Long key)
/*    */   {
/* 96 */     (java.util.Map)getTable().select(key, new TField()
/*    */     {
/*    */       public java.util.Map<Integer, Integer> get(GangRaceGameInfo v)
/*    */       {
/* :0 */         return v.getRaceid2moneyAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Gangrace2gameinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */