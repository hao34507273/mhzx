/*    */ package mzm.gsp.paraselene.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.JigsawInfo;
/*    */ 
/*    */ public class PJigsawFail extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PJigsawFail(long roleid)
/*    */   {
/* 13 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     String logstr = String.format("[jigsaw]PJigsawFail.processImp@receive jigsaw fail req|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*    */     
/*    */ 
/* 22 */     JigsawManager.logger.info(logstr);
/*    */     
/* 24 */     Long jigsawid = xtable.Role2jigsaw.select(Long.valueOf(this.roleid));
/*    */     
/* 26 */     if (jigsawid == null)
/*    */     {
/* 28 */       JigsawManager.sendJigsawRes(this.roleid, 3);
/* 29 */       return false;
/*    */     }
/* 31 */     JigsawInfo jigsawInfo = xtable.Jigsawinfo.get(jigsawid);
/* 32 */     if (jigsawInfo == null)
/*    */     {
/* 34 */       JigsawManager.sendJigsawRes(this.roleid, 3);
/* 35 */       return false;
/*    */     }
/* 37 */     if (jigsawInfo.getSucroleids().contains(Long.valueOf(this.roleid)))
/*    */     {
/* 39 */       logstr = String.format("[jigsaw]PJigsawFail.processImp@role is already success|jigsawcfgid=%d|roleid=%d|roleids=%s", new Object[] { jigsawid, Long.valueOf(this.roleid), jigsawInfo.getAllroleids().toString() });
/*    */       
/*    */ 
/* 42 */       JigsawManager.logger.warn(logstr);
/*    */       
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     if ((jigsawInfo.getEndtime() != 0L) && (jigsawInfo.getEndtime() < mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis()))
/*    */     {
/* 49 */       JigsawManager.sendJigsawRes(this.roleid, 2);
/*    */     }
/*    */     else
/*    */     {
/* 53 */       JigsawManager.sendJigsawRes(this.roleid, 4);
/*    */     }
/* 55 */     jigsawInfo.getFailroleids().add(Long.valueOf(this.roleid));
/* 56 */     if (jigsawInfo.getFailroleids().size() + jigsawInfo.getSucroleids().size() >= jigsawInfo.getAllroleids().size())
/*    */     {
/* 58 */       JigsawManager.triggerEvent(jigsawInfo.getSucroleids(), jigsawInfo.getFailroleids(), jigsawInfo.getAllroleids(), jigsawInfo.getCfgid(), jigsawInfo.getContext());
/*    */       
/* 60 */       JigsawManager.removeAllJigsawRoles(jigsawInfo.getAllroleids());
/* 61 */       xtable.Jigsawinfo.remove(jigsawid);
/*    */     }
/*    */     
/* 64 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\PJigsawFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */