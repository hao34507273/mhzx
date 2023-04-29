/*    */ package mzm.gsp.fight.handle;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public abstract interface CounterHandle { public abstract void beforeCounter(InputObj paramInputObj, OutputObj paramOutputObj);
/*    */   
/*    */   public abstract void afterCounter(InputObj paramInputObj, OutputObj paramOutputObj);
/*    */   
/*    */   public static class InputObj { private Fighter releser;
/*    */     
/* 11 */     public InputObj(Fighter releser, Fighter target) { this.releser = releser;
/* 12 */       this.target = target;
/*    */     }
/*    */     
/*    */     private Fighter target;
/* 16 */     public Fighter getReleser() { return this.releser; }
/*    */     
/*    */     public Fighter getTarget()
/*    */     {
/* 20 */       return this.target;
/*    */     }
/*    */   }
/*    */   
/*    */   public static class OutputObj
/*    */   {
/* 26 */     public boolean isCanCounter = true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\handle\CounterHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */