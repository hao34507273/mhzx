/*    */ package xtable;
/*    */ 
/*    */ import xbean.RoleGrabData;
/*    */ import xbean.RoleGrabSessions;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2rolegrabdata
/*    */ {
/*    */   public static RoleGrabData get(Long key)
/*    */   {
/* 12 */     return (RoleGrabData)_Tables_.getInstance().role2rolegrabdata.get(key);
/*    */   }
/*    */   
/*    */   public static RoleGrabData get(Long key, RoleGrabData value)
/*    */   {
/* 17 */     return (RoleGrabData)_Tables_.getInstance().role2rolegrabdata.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleGrabData value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2rolegrabdata.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2rolegrabdata.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleGrabData value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2rolegrabdata.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2rolegrabdata.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleGrabData> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2rolegrabdata.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleGrabData> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2rolegrabdata;
/*    */   }
/*    */   
/*    */   public static RoleGrabData select(Long key)
/*    */   {
/* 52 */     (RoleGrabData)getTable().select(key, new TField()
/*    */     {
/*    */       public RoleGrabData get(RoleGrabData v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static java.util.Map<Integer, Integer> selectOwnpositions(Long key)
/*    */   {
/* 63 */     (java.util.Map)getTable().select(key, new TField()
/*    */     {
/*    */       public java.util.Map<Integer, Integer> get(RoleGrabData v)
/*    */       {
/* 67 */         return v.getOwnpositionsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static RoleGrabSessions selectSessiondata(Long key)
/*    */   {
/* 74 */     (RoleGrabSessions)getTable().select(key, new TField()
/*    */     {
/*    */       public RoleGrabSessions get(RoleGrabData v)
/*    */       {
/* 78 */         return v.getSessiondata().toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectPoint(Long key)
/*    */   {
/* 85 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(RoleGrabData v)
/*    */       {
/* 89 */         return Integer.valueOf(v.getPoint());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectGrabpositionid(Long key)
/*    */   {
/* 96 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(RoleGrabData v)
/*    */       {
/* :0 */         return Integer.valueOf(v.getGrabpositionid());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2rolegrabdata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */