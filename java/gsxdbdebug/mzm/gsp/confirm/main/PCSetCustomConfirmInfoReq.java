/*    */ package mzm.gsp.confirm.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.function.confbean.SCommonTeamConfirmCfg;
/*    */ 
/*    */ public class PCSetCustomConfirmInfoReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final Map<Integer, Integer> settings;
/*    */   
/*    */   public PCSetCustomConfirmInfoReq(long roleId, Map<Integer, Integer> settings)
/*    */   {
/* 15 */     this.roleId = roleId;
/* 16 */     this.settings = settings;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if ((this.settings == null) || (this.settings.isEmpty()))
/*    */     {
/* 25 */       return false;
/*    */     }
/* 27 */     for (Iterator i$ = this.settings.keySet().iterator(); i$.hasNext();) { int option = ((Integer)i$.next()).intValue();
/*    */       
/* 29 */       SCommonTeamConfirmCfg cfg = SCommonTeamConfirmCfg.get(option);
/* 30 */       if (cfg == null)
/*    */       {
/* 32 */         return false;
/*    */       }
/* 34 */       if (!cfg.canSet)
/*    */       {
/* 36 */         return false;
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 41 */     xbean.SystemSetting xSystemSetting = xtable.Role2systemsetting.get(Long.valueOf(this.roleId));
/* 42 */     if (xSystemSetting == null)
/*    */     {
/* 44 */       return false;
/*    */     }
/* 46 */     for (Map.Entry<Integer, Integer> entry : this.settings.entrySet())
/*    */     {
/* 48 */       xSystemSetting.getConformsettings().put(entry.getKey(), Integer.valueOf(((Integer)entry.getValue()).intValue() > 0 ? 1 : 0));
/*    */     }
/* 50 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\confirm\main\PCSetCustomConfirmInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */