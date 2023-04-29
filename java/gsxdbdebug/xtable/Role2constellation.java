/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.RoleConstellation;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2constellation
/*    */ {
/*    */   public static RoleConstellation get(Long key)
/*    */   {
/* 12 */     return (RoleConstellation)_Tables_.getInstance().role2constellation.get(key);
/*    */   }
/*    */   
/*    */   public static RoleConstellation get(Long key, RoleConstellation value)
/*    */   {
/* 17 */     return (RoleConstellation)_Tables_.getInstance().role2constellation.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleConstellation value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2constellation.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2constellation.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleConstellation value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2constellation.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2constellation.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleConstellation> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2constellation.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleConstellation> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2constellation;
/*    */   }
/*    */   
/*    */   public static RoleConstellation select(Long key)
/*    */   {
/* 52 */     (RoleConstellation)getTable().select(key, new TField()
/*    */     {
/*    */       public RoleConstellation get(RoleConstellation v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectAward_constellations(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(RoleConstellation v)
/*    */       {
/* 67 */         return v.getAward_constellationsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectSet_times(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(RoleConstellation v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getSet_times());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectConstellation(Long key)
/*    */   {
/* 85 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(RoleConstellation v)
/*    */       {
/* 89 */         return Integer.valueOf(v.getConstellation());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectSum_exp(Long key)
/*    */   {
/* 96 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(RoleConstellation v)
/*    */       {
/* :0 */         return Integer.valueOf(v.getSum_exp());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2constellation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */