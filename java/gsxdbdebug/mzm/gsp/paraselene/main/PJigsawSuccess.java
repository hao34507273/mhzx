/*    */ package mzm.gsp.paraselene.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.JigsawInfo;
/*    */ 
/*    */ public class PJigsawSuccess extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PJigsawSuccess(long roleid)
/*    */   {
/* 13 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     String logstr = String.format("[jigsaw]PJigsawSuccess.processImp@receive jigsaw success req|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/* 20 */     JigsawManager.logger.info(logstr);
/*    */     
/* 22 */     Long jigsawid = xtable.Role2jigsaw.select(Long.valueOf(this.roleid));
/*    */     
/* 24 */     if (jigsawid == null)
/*    */     {
/* 26 */       JigsawManager.sendJigsawRes(this.roleid, 3);
/* 27 */       return false;
/*    */     }
/* 29 */     JigsawInfo jigsawInfo = xtable.Jigsawinfo.get(jigsawid);
/* 30 */     if (jigsawInfo == null)
/*    */     {
/* 32 */       JigsawManager.sendJigsawRes(this.roleid, 3);
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     if (jigsawInfo.getFailroleids().contains(Long.valueOf(this.roleid)))
/*    */     {
/* 38 */       logstr = String.format("[jigsaw]PJigsawSuccess.processImp@role is already failed|jigsawcfgid=%d|roleid=%d|roleids=%s", new Object[] { jigsawid, Long.valueOf(this.roleid), jigsawInfo.getAllroleids().toString() });
/*    */       
/*    */ 
/* 41 */       JigsawManager.logger.warn(logstr);
/* 42 */       return false;
/*    */     }
/* 44 */     if ((jigsawInfo.getEndtime() != 0L) && (jigsawInfo.getEndtime() < mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis()))
/*    */     {
/*    */ 
/* 47 */       JigsawManager.sendJigsawRes(this.roleid, 2);
/* 48 */       jigsawInfo.getFailroleids().add(Long.valueOf(this.roleid));
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 53 */       JigsawManager.sendJigsawRes(this.roleid, 1);
/* 54 */       jigsawInfo.getSucroleids().add(Long.valueOf(this.roleid));
/*    */     }
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\PJigsawSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */