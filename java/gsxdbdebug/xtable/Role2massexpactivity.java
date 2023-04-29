/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.MassExpActivity;
/*    */ import xbean.MassExpInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2massexpactivity
/*    */ {
/*    */   public static MassExpActivity get(Long key)
/*    */   {
/* 12 */     return (MassExpActivity)_Tables_.getInstance().role2massexpactivity.get(key);
/*    */   }
/*    */   
/*    */   public static MassExpActivity get(Long key, MassExpActivity value)
/*    */   {
/* 17 */     return (MassExpActivity)_Tables_.getInstance().role2massexpactivity.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, MassExpActivity value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2massexpactivity.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2massexpactivity.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, MassExpActivity value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2massexpactivity.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2massexpactivity.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, MassExpActivity> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2massexpactivity.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MassExpActivity> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2massexpactivity;
/*    */   }
/*    */   
/*    */   public static MassExpActivity select(Long key)
/*    */   {
/* 52 */     (MassExpActivity)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public MassExpActivity get(MassExpActivity v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, MassExpInfo> selectMass_exp_infos(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, MassExpInfo> get(MassExpActivity v)
/*    */       {
/* 67 */         return v.getMass_exp_infosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2massexpactivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */