/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.GuideState;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2guidestate
/*    */ {
/*    */   public static GuideState get(Long key)
/*    */   {
/* 12 */     return (GuideState)_Tables_.getInstance().role2guidestate.get(key);
/*    */   }
/*    */   
/*    */   public static GuideState get(Long key, GuideState value)
/*    */   {
/* 17 */     return (GuideState)_Tables_.getInstance().role2guidestate.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, GuideState value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2guidestate.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2guidestate.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, GuideState value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2guidestate.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2guidestate.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, GuideState> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2guidestate.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, GuideState> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2guidestate;
/*    */   }
/*    */   
/*    */   public static GuideState select(Long key)
/*    */   {
/* 52 */     (GuideState)getTable().select(key, new TField()
/*    */     {
/*    */       public GuideState get(GuideState v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectGuideid2state(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(GuideState v)
/*    */       {
/* 67 */         return v.getGuideid2stateAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectGuideid2param(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(GuideState v)
/*    */       {
/* 78 */         return v.getGuideid2paramAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2guidestate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */