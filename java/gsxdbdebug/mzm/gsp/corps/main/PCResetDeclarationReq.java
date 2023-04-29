/*     */ package mzm.gsp.corps.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.corps.SResetDeclarationBro;
/*     */ import mzm.gsp.corps.confbean.CorpsConsts;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.sensitive.main.SensitiveInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CorpsMember;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2corps;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCResetDeclarationReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private String newDeclaration;
/*     */   private final Octets declarationOctets;
/*     */   
/*     */   public PCResetDeclarationReq(long roleId, Octets declaration)
/*     */   {
/*  35 */     this.roleId = roleId;
/*  36 */     this.declarationOctets = declaration;
/*     */     
/*  38 */     String tmpStr = null;
/*     */     try
/*     */     {
/*  41 */       tmpStr = declaration.getString("UTF-8");
/*     */     }
/*     */     catch (Exception e) {}
/*     */     
/*     */ 
/*     */ 
/*  47 */     this.newDeclaration = tmpStr;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  54 */     Lockeys.lock(User.getTable(), Arrays.asList(new String[] { RoleInterface.getUserId(this.roleId) }));
/*     */     
/*  56 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  57 */     CorpsMember xCorpsMember = Role2corps.get(Long.valueOf(this.roleId));
/*  58 */     if (xCorpsMember == null)
/*     */     {
/*  60 */       GameServer.logger().error(String.format("[corps]PCResetDeclarationReq.processImp@ not own corps!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     long corpsId = xCorpsMember.getCorpsid();
/*  66 */     xbean.Corps xCorps = xtable.Corps.get(Long.valueOf(corpsId));
/*  67 */     if (xCorps == null)
/*     */     {
/*  69 */       GameServer.logger().error(String.format("[corps]PCResetDeclarationReq.processImp@ IMPOSSIBLE! not have this corps!|roleId=%d|corpsId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(corpsId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     if (!canRpDeclarationCorps(xCorpsMember))
/*     */     {
/*     */ 
/*  80 */       return false;
/*     */     }
/*  82 */     int checkRes = checkDeclarationContent(this.newDeclaration);
/*  83 */     if (checkRes > 0)
/*     */     {
/*  85 */       GameServer.logger().error(String.format("[corps]PCResetDeclarationReq.processImp@ declaration content check err!|roleId=%d|newDeclaration=%s|res=%d", new Object[] { Long.valueOf(this.roleId), this.newDeclaration, Integer.valueOf(checkRes) }));
/*     */       
/*     */ 
/*     */ 
/*  89 */       CorpsManager.sendCorpsNotice(this.roleId, false, checkRes, new String[0]);
/*  90 */       return false;
/*     */     }
/*     */     
/*  93 */     xCorps.setCorpsdeclaration(this.newDeclaration);
/*     */     
/*  95 */     CorpsManager.corpsBrocast(xCorps, true, new SResetDeclarationBro(this.declarationOctets));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 100 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean canRpDeclarationCorps(CorpsMember xCorpsMember)
/*     */   {
/* 106 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1227, true))
/*     */     {
/* 108 */       return false;
/*     */     }
/*     */     
/* 111 */     if (xCorpsMember.getDuty() != 1)
/*     */     {
/* 113 */       GameServer.logger().error(String.format("[corps]PCResetDeclarationReq.canRpDeclarationCorps@ not leader!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/* 115 */       return false;
/*     */     }
/* 117 */     return true;
/*     */   }
/*     */   
/*     */   private int checkDeclarationContent(String declaration)
/*     */   {
/* 122 */     if (SensitiveInterface.isContentSensitive(declaration))
/*     */     {
/* 124 */       return 62;
/*     */     }
/*     */     
/* 127 */     if ((Math.ceil(CommonUtils.getUTF16Length(declaration) / 2.0D) > CorpsConsts.getInstance().CORPS_DECLARATION_MAX_LENGTH) || (Math.ceil(CommonUtils.getUTF16Length(declaration) / 2.0D) < CorpsConsts.getInstance().CORPS_DECLARATION_MIN_LENGTH))
/*     */     {
/*     */ 
/* 130 */       return 62;
/*     */     }
/* 132 */     return -1;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\PCResetDeclarationReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */