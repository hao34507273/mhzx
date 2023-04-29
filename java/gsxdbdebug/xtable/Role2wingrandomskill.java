/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.RandomSkillInfo;
/*    */ import xbean.WingRandomSkill;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2wingrandomskill
/*    */ {
/*    */   public static WingRandomSkill get(Long key)
/*    */   {
/* 12 */     return (WingRandomSkill)_Tables_.getInstance().role2wingrandomskill.get(key);
/*    */   }
/*    */   
/*    */   public static WingRandomSkill get(Long key, WingRandomSkill value)
/*    */   {
/* 17 */     return (WingRandomSkill)_Tables_.getInstance().role2wingrandomskill.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, WingRandomSkill value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2wingrandomskill.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2wingrandomskill.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, WingRandomSkill value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2wingrandomskill.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2wingrandomskill.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, WingRandomSkill> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2wingrandomskill.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, WingRandomSkill> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2wingrandomskill;
/*    */   }
/*    */   
/*    */   public static WingRandomSkill select(Long key)
/*    */   {
/* 52 */     (WingRandomSkill)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public WingRandomSkill get(WingRandomSkill v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, RandomSkillInfo> selectIndex2wingskill(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, RandomSkillInfo> get(WingRandomSkill v)
/*    */       {
/* 67 */         return v.getIndex2wingskillAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2wingrandomskill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */