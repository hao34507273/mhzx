/*    */ package xtable;
/*    */ 
/*    */ import xbean.RoleCompetition;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role_competition
/*    */ {
/*    */   public static RoleCompetition get(Long key)
/*    */   {
/* 12 */     return (RoleCompetition)_Tables_.getInstance().role_competition.get(key);
/*    */   }
/*    */   
/*    */   public static RoleCompetition get(Long key, RoleCompetition value)
/*    */   {
/* 17 */     return (RoleCompetition)_Tables_.getInstance().role_competition.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleCompetition value)
/*    */   {
/* 22 */     _Tables_.getInstance().role_competition.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role_competition.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleCompetition value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role_competition.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role_competition.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, RoleCompetition> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role_competition.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleCompetition> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role_competition;
/*    */   }
/*    */   
/*    */   public static RoleCompetition select(Long key)
/*    */   {
/* 52 */     (RoleCompetition)getTable().select(key, new TField()
/*    */     {
/*    */       public RoleCompetition get(RoleCompetition v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectAction_point(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(RoleCompetition v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getAction_point());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectWin_streak(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(RoleCompetition v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getWin_streak());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Boolean selectParticipated(Long key)
/*    */   {
/* 85 */     (Boolean)getTable().select(key, new TField()
/*    */     {
/*    */       public Boolean get(RoleCompetition v)
/*    */       {
/* 89 */         return Boolean.valueOf(v.getParticipated());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Boolean selectAwarded_final(Long key)
/*    */   {
/* 96 */     (Boolean)getTable().select(key, new TField()
/*    */     {
/*    */       public Boolean get(RoleCompetition v)
/*    */       {
/* :0 */         return Boolean.valueOf(v.getAwarded_final());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role_competition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */