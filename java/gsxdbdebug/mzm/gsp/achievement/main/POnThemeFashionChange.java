/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import mzm.gsp.fashiondress.event.ThemeFashionDressPropertyChangeArg;
/*    */ import mzm.gsp.fashiondress.event.ThemeFashionDressPropertyChangeProcedure;
/*    */ import mzm.gsp.fashiondress.main.FashionDressInterface;
/*    */ 
/*    */ public class POnThemeFashionChange
/*    */   extends ThemeFashionDressPropertyChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 14 */     Collection<Integer> themeFashionCfgIds = FashionDressInterface.calculateRoleEntireThemeFashionDressCfgids(((ThemeFashionDressPropertyChangeArg)this.arg).themeFashionDressTypeSet);
/*    */     
/* 16 */     AchievementManager.updateGoalTypeState(((ThemeFashionDressPropertyChangeArg)this.arg).roleId, 3019, Integer.valueOf(themeFashionCfgIds.size()), "POnThemeFashionChange.processImp@handle THEME_FASHION_OWN success");
/*    */     
/*    */ 
/*    */ 
/* 20 */     AchievementManager.updateGoalTypeState(((ThemeFashionDressPropertyChangeArg)this.arg).roleId, 3020, themeFashionCfgIds, "POnThemeFashionChange.processImp@handle THEME_FASHION_SPECIFIC_OWN success");
/*    */     
/*    */ 
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnThemeFashionChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */