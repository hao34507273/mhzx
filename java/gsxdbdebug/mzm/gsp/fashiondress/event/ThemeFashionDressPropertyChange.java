/*    */ package mzm.gsp.fashiondress.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ThemeFashionDressPropertyChange extends mzm.event.BasicEvent<ThemeFashionDressPropertyChangeArg>
/*    */ {
/*  7 */   private static EventManager<ThemeFashionDressPropertyChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ThemeFashionDressPropertyChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.main.POnThemeFashionDressPropertyChange());
/* 16 */     manager.register(new mzm.gsp.fashiondress.main.POnThemeFashionDressPropertyChange());
/* 17 */     manager.register(new mzm.gsp.achievement.main.POnThemeFashionChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\event\ThemeFashionDressPropertyChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */