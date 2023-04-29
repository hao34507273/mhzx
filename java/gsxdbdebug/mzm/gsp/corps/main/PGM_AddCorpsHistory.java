/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import java.lang.reflect.Field;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.corps.confbean.HistoryType;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.CorpsMember;
/*    */ import xtable.Role2corps;
/*    */ 
/*    */ public class PGM_AddCorpsHistory extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int type;
/*    */   private final List<String> args;
/*    */   
/*    */   public PGM_AddCorpsHistory(long roleId, int type, List<String> args)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.type = type;
/* 23 */     this.args = args;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     if (!isTypeValid(this.type))
/*    */     {
/* 31 */       GmManager.getInstance().sendResultToGM(this.roleId, "不支持的历史类型~");
/* 32 */       return false;
/*    */     }
/* 34 */     CorpsMember xCorpsLeader = Role2corps.select(Long.valueOf(this.roleId));
/* 35 */     if (xCorpsLeader == null)
/*    */     {
/* 37 */       GmManager.getInstance().sendResultToGM(this.roleId, "没有战队，不能添加战队历史~");
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     long corpsId = xCorpsLeader.getCorpsid();
/* 42 */     xbean.Corps xCorps = xtable.Corps.get(Long.valueOf(corpsId));
/* 43 */     if (xCorps == null)
/*    */     {
/* 45 */       GmManager.getInstance().sendResultToGM(this.roleId, "没有战队，不能添加战队历史~");
/* 46 */       return false;
/*    */     }
/* 48 */     CorpsManager.addCorpsHistory(xCorps, this.type, this.args);
/* 49 */     GmManager.getInstance().sendResultToGM(this.roleId, "添加成功~");
/* 50 */     return true;
/*    */   }
/*    */   
/*    */   private boolean isTypeValid(int type) throws Exception
/*    */   {
/* 55 */     Set<Integer> types = getAllHistoryTypes();
/* 56 */     return types.contains(Integer.valueOf(type));
/*    */   }
/*    */   
/*    */   private static Set<Integer> getAllHistoryTypes() throws Exception
/*    */   {
/* 61 */     Set<Integer> types = new HashSet();
/* 62 */     Field[] fs = HistoryType.class.getDeclaredFields();
/* 63 */     for (int i = 0; i < fs.length; i++)
/*    */     {
/* 65 */       Field f = fs[i];
/* 66 */       String fType = f.getType().toString();
/* 67 */       if ((fType.endsWith("int")) || (fType.endsWith("Integer")))
/*    */       {
/* 69 */         types.add(Integer.valueOf(f.getInt(HistoryType.class)));
/*    */       }
/*    */     }
/* 72 */     return types;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\PGM_AddCorpsHistory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */