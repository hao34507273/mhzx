/*     */ package mzm.gsp.hula.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.hula.confbean.SHulaCfgConsts;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HulaInfo;
/*     */ import xbean.HulaMonsterInfo;
/*     */ import xbean.HulaWorldInfo;
/*     */ import xtable.Hulaworld;
/*     */ import xtable.Role2hula;
/*     */ 
/*     */ public class PMarkMonsterReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int seq;
/*     */   private final Octets markcontent;
/*     */   
/*     */   public PMarkMonsterReq(long roleid, int seq, Octets markcontent)
/*     */   {
/*  23 */     this.roleid = roleid;
/*  24 */     this.seq = seq;
/*  25 */     this.markcontent = markcontent;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  31 */     if (this.seq <= 0)
/*     */     {
/*  33 */       return false;
/*     */     }
/*  35 */     if (!HulaManager.isHulaSwitchOpenForRole(this.roleid))
/*     */     {
/*  37 */       return false;
/*     */     }
/*  39 */     if (!HulaManager.isInHulaFubenWorld(this.roleid))
/*     */     {
/*  41 */       String logstr = String.format("[hula]PMarkMonsterReq.processImp@role not in hula world|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  42 */       HulaManager.logger.info(logstr);
/*  43 */       return false;
/*     */     }
/*  45 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 450, true))
/*     */     {
/*  47 */       String log = String.format("[hula]PMarkMonsterReq.processImp@role status can not mark monster|roleid=%d|seq=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.seq) });
/*     */       
/*  49 */       HulaManager.logger.info(log);
/*  50 */       return false;
/*     */     }
/*  52 */     int stage = ActivityInterface.getActivityStage(SHulaCfgConsts.getInstance().ACTIVITY_ID);
/*  53 */     if (!HulaManager.isThisStage(stage, 1))
/*     */     {
/*  55 */       String log = String.format("[hula]PMarkMonsterReq.processImp@now stage can not do this|stage=%d|roleid=%d|seq=%d", new Object[] { Integer.valueOf(stage), Long.valueOf(this.roleid), Integer.valueOf(this.seq) });
/*     */       
/*  57 */       HulaManager.logger.info(log);
/*     */     }
/*     */     
/*  60 */     String markString = this.markcontent.getString("UTF-8");
/*  61 */     if (markString == null)
/*     */     {
/*  63 */       return false;
/*     */     }
/*  65 */     if (markString.length() > 30)
/*     */     {
/*  67 */       String logString = String.format("[hula]PMarkMonsterReq.processImp@mark content error,newName error|roleId=%d|seq=%d|markstring=%s", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.seq), markString });
/*     */       
/*     */ 
/*     */ 
/*  71 */       HulaManager.logger.info(logString);
/*  72 */       return false;
/*     */     }
/*  74 */     if (mzm.gsp.sensitive.main.SensitiveInterface.isNameSensitive(markString))
/*     */     {
/*     */ 
/*  77 */       String logString = String.format("[home]PMarkMonsterReq.processImp@mark content is sensitive|roleId=%d|seq=%d|markstring=%s", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.seq), markString });
/*     */       
/*     */ 
/*  80 */       HulaManager.logger.warn(logString);
/*  81 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  85 */     HulaInfo xHulaInfo = Role2hula.get(Long.valueOf(this.roleid));
/*  86 */     if (xHulaInfo == null)
/*     */     {
/*  88 */       return false;
/*     */     }
/*  90 */     long worldid = xHulaInfo.getWorldid();
/*  91 */     long key = GameServerInfoManager.toGlobalId(worldid);
/*  92 */     HulaWorldInfo xHulaWorldInfo = Hulaworld.get(Long.valueOf(key));
/*  93 */     if (xHulaWorldInfo == null)
/*     */     {
/*  95 */       return false;
/*     */     }
/*  97 */     if (!xHulaWorldInfo.getRoleids().contains(Long.valueOf(this.roleid)))
/*     */     {
/*  99 */       String log = String.format("[hula]PMarkMonsterReq.processImp@xHulaWorldInfo has no this roleid|stage=%d|roleid=%d|seq=%d|worldid=%d", new Object[] { Integer.valueOf(stage), Long.valueOf(this.roleid), Integer.valueOf(this.seq), Long.valueOf(worldid) });
/*     */       
/*     */ 
/* 102 */       HulaManager.logger.info(log);
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     for (HulaMonsterInfo xHulaMonsterInfo : xHulaWorldInfo.getMonsters())
/*     */     {
/* 108 */       if (xHulaMonsterInfo.getSeq() == this.seq)
/*     */       {
/* 110 */         xHulaMonsterInfo.setMark_content(markString);
/* 111 */         HulaManager.broadCastSMarkMonsterRes(this.seq, this.markcontent, xHulaWorldInfo.getRoleids());
/* 112 */         String log = String.format("[hula]PMarkMonsterReq.processImp@mark monster success|stage=%d|roleid=%d|seq=%d|worldid=%d|monsterid=%d|marketcontent=%s", new Object[] { Integer.valueOf(stage), Long.valueOf(this.roleid), Integer.valueOf(this.seq), Long.valueOf(worldid), Integer.valueOf(xHulaMonsterInfo.getMonsterid()), markString });
/*     */         
/*     */ 
/* 115 */         HulaManager.logger.info(log);
/*     */         
/* 117 */         HulaManager.tlogHulamark(this.roleid, HulaManager.getTurn(stage), xHulaWorldInfo, xHulaInfo.getPoint(), xHulaMonsterInfo.getMonsterid(), this.seq, markString);
/*     */         
/*     */ 
/* 120 */         break;
/*     */       }
/*     */     }
/* 123 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\main\PMarkMonsterReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */