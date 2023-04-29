/*    */ package mzm.gsp.shanghui.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.MergeMain;
/*    */ import mzm.gsp.MergeModule;
/*    */ import mzm.gsp.shanghui.confbean.SShangHuiItemToolsCfg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Table;
/*    */ import xtable.Role2shanghui;
/*    */ import xtable.Shanghui;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShanghuiMerge
/*    */   implements MergeModule
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 26 */     List<Table> tables = new ArrayList();
/* 27 */     tables.add(Role2shanghui.getTable());
/* 28 */     tables.add(Shanghui.getTable());
/* 29 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 35 */     for (Iterator i$ = SShangHuiItemToolsCfg.getAll().keySet().iterator(); i$.hasNext();) { int itemid = ((Integer)i$.next()).intValue();
/*    */       
/* 37 */       if (!new Merger_Shanghui_Pro(itemid).call())
/*    */       {
/* 39 */         MergeMain.formatLogError("ShanghuiMerge.handleMerge@shanghui table delete vice server data fail！|itemid=%d", new Object[] { Integer.valueOf(itemid) });
/*    */         
/* 41 */         return false;
/*    */       }
/*    */     }
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   private static class Merger_Shanghui_Pro extends LogicProcedure
/*    */   {
/*    */     private final int itemid;
/*    */     
/*    */     public Merger_Shanghui_Pro(int itemid)
/*    */     {
/* 53 */       this.itemid = itemid;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 59 */       long mainKey = GameServerInfoManager.toGlobalId(this.itemid, MergeMain.getMainZoneid());
/* 60 */       long viceKey = GameServerInfoManager.toGlobalId(this.itemid, MergeMain.getViceZoneid());
/* 61 */       lock(Shanghui.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*    */       
/* 63 */       Shanghui.remove(Long.valueOf(viceKey));
/* 64 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\main\ShanghuiMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */