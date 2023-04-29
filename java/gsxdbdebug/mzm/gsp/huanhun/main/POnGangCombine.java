/*    */ package mzm.gsp.huanhun.main;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.HashSet;
/*    */ import mzm.gsp.gang.event.GangCombineArg;
/*    */ import mzm.gsp.gang.event.GangCombineProcedure;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnGangCombine
/*    */   extends GangCombineProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     HuanhunManager.rmGangAllHelp(((GangCombineArg)this.arg).mainGangid, getAllMembers());
/* 21 */     HuanhunManager.rmGangAllHelp(((GangCombineArg)this.arg).viceGangid, new HashSet());
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   Collection<Long> getAllMembers()
/*    */   {
/* 27 */     return GangInterface.getGangMemberList(((GangCombineArg)this.arg).mainGangid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\POnGangCombine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */