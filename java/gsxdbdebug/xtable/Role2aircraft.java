/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.AircraftInfo;
/*    */ import xbean.Role2AircraftInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2aircraft
/*    */ {
/*    */   public static Role2AircraftInfo get(Long key)
/*    */   {
/* 12 */     return (Role2AircraftInfo)_Tables_.getInstance().role2aircraft.get(key);
/*    */   }
/*    */   
/*    */   public static Role2AircraftInfo get(Long key, Role2AircraftInfo value)
/*    */   {
/* 17 */     return (Role2AircraftInfo)_Tables_.getInstance().role2aircraft.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Role2AircraftInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2aircraft.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2aircraft.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Role2AircraftInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2aircraft.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2aircraft.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, Role2AircraftInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2aircraft.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Role2AircraftInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2aircraft;
/*    */   }
/*    */   
/*    */   public static Role2AircraftInfo select(Long key)
/*    */   {
/* 52 */     (Role2AircraftInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Role2AircraftInfo get(Role2AircraftInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, AircraftInfo> selectOwn_aircraft_map(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, AircraftInfo> get(Role2AircraftInfo v)
/*    */       {
/* 67 */         return v.getOwn_aircraft_mapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectCurrent_aircraft_cfg_id(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Integer get(Role2AircraftInfo v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getCurrent_aircraft_cfg_id());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2aircraft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */