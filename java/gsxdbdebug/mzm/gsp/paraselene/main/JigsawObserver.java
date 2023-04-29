/*    */ package mzm.gsp.paraselene.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.JigsawInfo;
/*    */ import xtable.Jigsawinfo;
/*    */ 
/*    */ public class JigsawObserver extends Session
/*    */ {
/*    */   private long jigsawid;
/*    */   
/*    */   public JigsawObserver(long interval, long jigsawid)
/*    */   {
/* 16 */     super(interval, jigsawid);
/*    */     
/* 18 */     this.jigsawid = jigsawid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 25 */     new LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 31 */         JigsawInfo jigsawInfo = Jigsawinfo.get(Long.valueOf(JigsawObserver.this.jigsawid));
/* 32 */         if (jigsawInfo != null)
/*    */         {
/* 34 */           List<Long> list = new ArrayList();
/* 35 */           list.addAll(jigsawInfo.getAllroleids());
/*    */           
/* 37 */           list.removeAll(jigsawInfo.getSucroleids());
/* 38 */           list.removeAll(jigsawInfo.getFailroleids());
/*    */           
/* 40 */           jigsawInfo.getFailroleids().addAll(list);
/*    */           
/* 42 */           JigsawManager.triggerEvent(jigsawInfo.getSucroleids(), jigsawInfo.getFailroleids(), jigsawInfo.getAllroleids(), jigsawInfo.getCfgid(), jigsawInfo.getContext());
/*    */           
/*    */ 
/* 45 */           JigsawManager.removeAllJigsawRoles(jigsawInfo.getAllroleids());
/* 46 */           Jigsawinfo.remove(Long.valueOf(JigsawObserver.this.jigsawid));
/*    */         }
/*    */         
/* 49 */         return true;
/*    */       }
/*    */     }.execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\JigsawObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */