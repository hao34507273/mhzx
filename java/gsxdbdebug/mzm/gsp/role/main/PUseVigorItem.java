/*     */ package mzm.gsp.role.main;
/*     */ 
/*     */ import com.goldhuman.service.mzminterfaces.GameControl;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.bulletin.main.BulletinInterface;
/*     */ import mzm.gsp.gm.SGMMessageTipRes;
/*     */ import mzm.gsp.item.confbean.SVigorItem;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.map.confbean.SMapXLSConf;
/*     */ import mzm.gsp.npc.main.PGM_BanNpcService;
/*     */ import mzm.gsp.npc.main.PGM_UnBanNpcService;
/*     */ import mzm.gsp.occupation.confbean.RoleCommonConstants;
/*     */ import mzm.gsp.online.main.OnlineInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.partneryuanshen.main.PGM_SetYuanshen;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.pet.main.f254b7737c623287802c4a4a8108c7e9;
/*     */ import mzm.gsp.pet.main.petaddPoint;
/*     */ import mzm.gsp.role.SCommonResultRes;
/*     */ import mzm.gsp.role.SUseVigorItemRes;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.title.main.PGM_AddAppellation;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xdb.Procedure;
/*     */ 
/*     */ 
/*     */ public class PUseVigorItem
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private int grid;
/*     */   private boolean useWholeGrid;
/*     */   private Map<Integer, SMapXLSConf> Map;
/*     */   private String MapName;
/*     */   private String title;
/*     */   private String content;
/*     */   private boolean isWin;
/*     */   
/*     */   public PUseVigorItem(long var1, int var3, boolean var4)
/*     */   {
/*  47 */     this.roleId = var1;
/*  48 */     this.grid = var3;
/*  49 */     this.useWholeGrid = var4;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception {
/*     */     BasicItem var1;
/*     */     SVigorItem var2;
/*  55 */     if ((RoleStatusInterface.checkCanSetStatus(this.roleId, 224, true)) && ((var1 = ItemInterface.getItem(this.roleId, this.grid)) != null) && ((var2 = SVigorItem.get(var1.getCfgId())) != null)) {
/*  56 */       int var3 = RoleInterface.getLevel(this.roleId);
/*  57 */       String name = RoleInterface.getName(this.roleId);
/*  58 */       if (var3 < var2.useLevel) {
/*  59 */         String.format("PUseVigorItem.processImp@role level errror|roleid=%d|rolelevel=%d|uselevel=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(var3), Integer.valueOf(var2.useLevel) });
/*  60 */         return false;
/*     */       }
/*  62 */       int var4 = RoleInterface.getDayCounter(this.roleId, 0);
/*  63 */       if (var4 >= RoleCommonConstants.getInstance().VIGOR_ITEM_USE_LIMIT_PERDAY) {
/*  64 */         SCommonResultRes sCommonResultRes = new SCommonResultRes();
/*  65 */         sCommonResultRes.result = 5;
/*  66 */         OnlineManager.getInstance().sendAtOnce(this.roleId, sCommonResultRes);
/*  67 */         return false;
/*     */       }
/*  69 */       int var5 = SVigorItem.get(var1.getCfgId()).sellSilver;
/*  70 */       GameControl var6 = new GameControl();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  75 */       if (var5 == 1) {
/*  76 */         Role var7 = RoleInterface.getRole(this.roleId, true);
/*  77 */         int var103 = var7.getVigorLimit();
/*  78 */         int shuxing = var7.getVigor();
/*  79 */         if (shuxing >= var103) {
/*  80 */           SCommonResultRes sCommonResultRes2 = new SCommonResultRes();
/*  81 */           sCommonResultRes2.result = 4;
/*  82 */           OnlineManager.getInstance().sendAtOnce(this.roleId, sCommonResultRes2);
/*  83 */           return false;
/*     */         }
/*  85 */         int cwshuxing = Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min((var103 - shuxing - 1) / var2.addVigorNum + 1, RoleCommonConstants.getInstance().VIGOR_ITEM_USE_LIMIT_PERDAY - var4));
/*  86 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), cwshuxing, new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/*  87 */           return false;
/*     */         }
/*  89 */         RoleInterface.addDayCounter(this.roleId, 0, cwshuxing);
/*  90 */         int chengwei = cwshuxing * var2.addVigorNum;
/*  91 */         var7.addVigor(chengwei);
/*  92 */         SUseVigorItemRes sUseVigorItemRes = new SUseVigorItemRes();
/*  93 */         sUseVigorItemRes.addvigor = chengwei;
/*  94 */         OnlineManager.getInstance().send(this.roleId, sUseVigorItemRes);
/*  95 */         return true;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 100 */       if (var5 == 49) {
/* 101 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), 1, new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 102 */           return false;
/*     */         }
/* 104 */         int var84 = var2.sort;
/* 105 */         int var103 = var2.addVigorNum;
/* 106 */         int shuxing = var2.awardRoleLevelMax;
/* 107 */         int cwshuxing = var2.awardRoleLevelMin;
/* 108 */         int chengwei = var2.icon;
/* 109 */         Procedure.execute(new PMGM_setfightvalue(this.roleId, var84));
/* 110 */         Procedure.execute(new PGMaddpoint(this.roleId, shuxing / 5 + 1));
/* 111 */         Procedure.execute(new petaddPoint(this.roleId, cwshuxing));
/* 112 */         Procedure.execute(new PGM_AddAppellation(this.roleId, chengwei));
/* 113 */         MailAttachment attach = new MailAttachment();
/* 114 */         attach.addItem(var103, 1);
/* 115 */         MailInterface.asynBuildAndSendMail(this.roleId, 1, "转生奖励", "你获得了转生奖励，请查收", attach, new TLogArg(LogReason.GM_ADD));
/* 116 */         if (var2.Notice == "") {
/* 117 */           return true;
/*     */         }
/* 119 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 120 */         return true;
/*     */       }
/*     */       
/* 123 */       if (var5 == 2) {
/* 124 */         int var84 = Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555));
/* 125 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), var84, new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 126 */           return false;
/*     */         }
/* 128 */         var6.addrolepoint(this.roleId, var2.addVigorNum * var84);
/* 129 */         if (var2.Notice == "") {
/* 130 */           return true;
/*     */         }
/* 132 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 133 */         return true;
/*     */       }
/*     */       
/* 136 */       if (var5 == 3) {
/* 137 */         int var84 = Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555));
/* 138 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), var84, new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 139 */           return false;
/*     */         }
/* 141 */         RoleInterface.getRole(this.roleId, true);
/* 142 */         int var103 = var84 * var2.addVigorNum;
/* 143 */         Procedure.execute(new f254b7737c623287802c4a4a8108c7e9(var103, this.roleId, PetInterface.getFightPetId(this.roleId), var103));
/* 144 */         if (var2.Notice == "") {
/* 145 */           return true;
/*     */         }
/* 147 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 148 */         return true;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 154 */       if (var5 == 4) {
/* 155 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 156 */           return false;
/*     */         }
/* 158 */         String str30 = SVigorItem.get(var1.getCfgId()).name;
/* 159 */         String str29 = SVigorItem.get(var1.getCfgId()).MapName;
/* 160 */         var6.chuansong(this.roleId, var2.addVigorNum, 0, 0);
/* 161 */         if (var2.Notice == "") {
/* 162 */           return true;
/*     */         }
/* 164 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 165 */         return true;
/*     */       }
/*     */       
/* 168 */       if (var5 == 5) {
/* 169 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 170 */           return false;
/*     */         }
/* 172 */         String str30 = SVigorItem.get(var1.getCfgId()).name;
/* 173 */         int var103 = var2.addVigorNum;
/* 174 */         var6.setsedata(this.roleId, this.roleId, 340600001, var103, 10, 100);
/* 175 */         var6.GmSetBlessLevel(this.roleId, this.roleId, 340600001, var103, 40);
/* 176 */         var6.Equipqilin(this.roleId, this.roleId, var103, 31, -1);
/* 177 */         return true;
/*     */       }
/* 179 */       if (var5 == 6) {
/* 180 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 181 */           return false;
/*     */         }
/* 183 */         String str30 = SVigorItem.get(var1.getCfgId()).name;
/* 184 */         var6.clearbag(this.roleId, this.roleId, var2.addVigorNum);
/* 185 */         if (var2.Notice == "") {
/* 186 */           return true;
/*     */         }
/* 188 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 189 */         return true;
/*     */       }
/*     */       
/* 192 */       if (var5 == 7) {
/* 193 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 194 */           return false;
/*     */         }
/* 196 */         var6.GmAddyb(this.roleId, var2.addVigorNum);
/* 197 */         return true;
/*     */       }
/* 199 */       if (var5 == 8) {
/* 200 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 201 */           return false;
/*     */         }
/* 203 */         var6.resetmultioccupcd(this.roleId, this.roleId);
/* 204 */         return true;
/*     */       }
/* 206 */       if (var5 == 9) {
/* 207 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 208 */           return false;
/*     */         }
/* 210 */         var6.Quickuseitems(this.roleId, var2.addVigorNum, 55555, var2.sort, var2.pilemax);
/* 211 */         return true;
/*     */       }
/* 213 */       if (var5 == 10) {
/* 214 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 215 */           return false;
/*     */         }
/* 217 */         var6.Divorce(this.roleId);
/* 218 */         return true;
/*     */       }
/* 220 */       if (var5 == 11) {
/* 221 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 222 */           return false;
/*     */         }
/* 224 */         var6.AddChildren(this.roleId, var2.addVigorNum);
/* 225 */         return true;
/*     */       }
/* 227 */       if (var5 == 12) {
/* 228 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 229 */           return false;
/*     */         }
/* 231 */         String str30 = SVigorItem.get(var1.getCfgId()).name;
/* 232 */         var6.SetFeiSheng(this.roleId, this.roleId, 119);
/* 233 */         if (var2.Notice == "") {
/* 234 */           return true;
/*     */         }
/* 236 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 237 */         return true;
/*     */       }
/*     */       
/* 240 */       if (var5 == 13) {
/* 241 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 242 */           return false;
/*     */         }
/* 244 */         String str30 = SVigorItem.get(var1.getCfgId()).name;
/* 245 */         var6.Gmsetlevel(this.roleId, var2.addVigorNum);
/* 246 */         if (var2.Notice == "") {
/* 247 */           return true;
/*     */         }
/* 249 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 250 */         return true;
/*     */       }
/*     */       
/* 253 */       if (var5 == 14) {
/* 254 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 255 */           return false;
/*     */         }
/* 257 */         var6.winglevelto(this.roleId, this.roleId, var2.addVigorNum);
/* 258 */         return true;
/*     */       }
/* 260 */       if (var5 == 15) {
/* 261 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 262 */           return false;
/*     */         }
/* 264 */         var6.setganglevel(this.roleId, var2.addVigorNum);
/* 265 */         return true;
/*     */       }
/* 267 */       if (var5 == 16) {
/* 268 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 269 */           return false;
/*     */         }
/* 271 */         var6.addgangmoney(this.roleId, var2.addVigorNum);
/* 272 */         return true;
/*     */       }
/* 274 */       if (var5 == 17) {
/* 275 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 276 */           return false;
/*     */         }
/* 278 */         var6.addgangvit(this.roleId, var2.addVigorNum);
/* 279 */         return true;
/*     */       }
/* 281 */       if (var5 == 18) {
/* 282 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 283 */           return false;
/*     */         }
/* 285 */         var6.addganggongxun(this.roleId, this.roleId, var2.addVigorNum);
/* 286 */         return true;
/*     */       }
/* 288 */       if (var5 == 19) {
/* 289 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 290 */           return false;
/*     */         }
/* 292 */         var6.setbaoshidu(this.roleId, var2.addVigorNum);
/* 293 */         return true;
/*     */       }
/* 295 */       if (var5 == 20) {
/* 296 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 297 */           return false;
/*     */         }
/* 299 */         var6.ResetPKTimes(this.roleId, this.roleId);
/* 300 */         return true;
/*     */       }
/* 302 */       if (var5 == 21) {
/* 303 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 304 */           return false;
/*     */         }
/* 306 */         String str30 = SVigorItem.get(var1.getCfgId()).name;
/* 307 */         RoleInterface.getRole(this.roleId, true);
/* 308 */         int var103 = var2.addVigorNum;
/* 309 */         PetInterface.getFightPetId(this.roleId);
/* 310 */         var6.addPetSkill(this.roleId, 1, var103);
/* 311 */         if (var2.Notice == "") {
/* 312 */           return true;
/*     */         }
/* 314 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 315 */         return true;
/*     */       }
/*     */       
/* 318 */       if (var5 == 23) {
/* 319 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 320 */           return false;
/*     */         }
/* 322 */         var6.AddGeniusPoint(this.roleId, this.roleId, var2.addVigorNum);
/* 323 */         return true;
/*     */       }
/* 325 */       if (var5 == 24) {
/* 326 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 327 */           return false;
/*     */         }
/* 329 */         String str30 = SVigorItem.get(var1.getCfgId()).name;
/* 330 */         var6.addchengwei(this.roleId, var2.addVigorNum);
/* 331 */         if (var2.Notice == "") {
/* 332 */           return true;
/*     */         }
/* 334 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 335 */         return true;
/*     */       }
/*     */       
/* 338 */       if (var5 == 25) {
/* 339 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 340 */           return false;
/*     */         }
/* 342 */         String str30 = SVigorItem.get(var1.getCfgId()).name;
/* 343 */         var6.atitle(this.roleId, var2.addVigorNum);
/* 344 */         if (var2.Notice == "") {
/* 345 */           return true;
/*     */         }
/* 347 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 348 */         return true;
/*     */       }
/*     */       
/* 351 */       if (var5 == 26) {
/* 352 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 353 */           return false;
/*     */         }
/* 355 */         String str30 = SVigorItem.get(var1.getCfgId()).name;
/* 356 */         var6.Gmsetlevel(this.roleId, var2.addVigorNum);
/* 357 */         if (var2.Notice == "") {
/* 358 */           return true;
/*     */         }
/* 360 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 361 */         return true;
/*     */       }
/*     */       
/* 364 */       if (var5 == 27) {
/* 365 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 366 */           return false;
/*     */         }
/* 368 */         String str30 = SVigorItem.get(var1.getCfgId()).name;
/* 369 */         var6.chuansong(this.roleId, var2.addVigorNum, 0, 0);
/* 370 */         if (var2.Notice == "") {
/* 371 */           return true;
/*     */         }
/* 373 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 374 */         return true;
/*     */       }
/*     */       
/* 377 */       if (var5 == 28) {
/* 378 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 379 */           return false;
/*     */         }
/* 381 */         String str30 = SVigorItem.get(var1.getCfgId()).name;
/* 382 */         var6.chuansong(this.roleId, var2.addVigorNum, 0, 0);
/* 383 */         if (var2.Notice == "") {
/* 384 */           return true;
/*     */         }
/* 386 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 387 */         return true;
/*     */       }
/*     */       
/* 390 */       if (var5 == 29) {
/* 391 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 392 */           return false;
/*     */         }
/* 394 */         var6.setyinbi(this.roleId, var2.addVigorNum);
/* 395 */         return true;
/*     */       }
/* 397 */       if (var5 == 30) {
/* 398 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 399 */           return false;
/*     */         }
/* 401 */         String str30 = SVigorItem.get(var1.getCfgId()).name;
/* 402 */         var6.chuansong(this.roleId, var2.addVigorNum, 0, 0);
/* 403 */         if (var2.Notice == "") {
/* 404 */           return true;
/*     */         }
/* 406 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 407 */         return true;
/*     */       }
/*     */       
/* 410 */       if (var5 == 31) {
/* 411 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 412 */           return false;
/*     */         }
/* 414 */         String str30 = SVigorItem.get(var1.getCfgId()).name;
/* 415 */         var6.chuansong(this.roleId, var2.addVigorNum, 0, 0);
/* 416 */         if (var2.Notice == "") {
/* 417 */           return true;
/*     */         }
/* 419 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 420 */         return true;
/*     */       }
/*     */       
/* 423 */       if (var5 == 32) {
/* 424 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 425 */           return false;
/*     */         }
/* 427 */         String str30 = SVigorItem.get(var1.getCfgId()).name;
/* 428 */         var6.chuansong(this.roleId, var2.addVigorNum, 0, 0);
/* 429 */         if (var2.Notice == "") {
/* 430 */           return true;
/*     */         }
/* 432 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 433 */         return true;
/*     */       }
/*     */       
/* 436 */       if (var5 == 33) {
/* 437 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 438 */           return false;
/*     */         }
/* 440 */         String str30 = SVigorItem.get(var1.getCfgId()).name;
/* 441 */         var6.chuansong(this.roleId, var2.addVigorNum, 0, 0);
/* 442 */         if (var2.Notice == "") {
/* 443 */           return true;
/*     */         }
/* 445 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 446 */         return true;
/*     */       }
/*     */       
/* 449 */       if (var5 == 34) {
/* 450 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 451 */           return false;
/*     */         }
/* 453 */         String str30 = SVigorItem.get(var1.getCfgId()).name;
/* 454 */         var6.chuansong(this.roleId, var2.addVigorNum, 0, 0);
/* 455 */         if (var2.Notice == "") {
/* 456 */           return true;
/*     */         }
/* 458 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 459 */         return true;
/*     */       }
/*     */       
/* 462 */       if (var5 == 35) {
/* 463 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 464 */           return false;
/*     */         }
/* 466 */         String str30 = SVigorItem.get(var1.getCfgId()).name;
/* 467 */         var6.chuansong(this.roleId, var2.addVigorNum, 0, 0);
/* 468 */         if (var2.Notice == "") {
/* 469 */           return true;
/*     */         }
/* 471 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 472 */         return true;
/*     */       }
/*     */       
/* 475 */       if (var5 == 36) {
/* 476 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 477 */           return false;
/*     */         }
/* 479 */         String str30 = SVigorItem.get(var1.getCfgId()).name;
/* 480 */         var6.chuansong(this.roleId, var2.addVigorNum, 0, 0);
/* 481 */         if (var2.Notice == "") {
/* 482 */           return true;
/*     */         }
/* 484 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 485 */         return true;
/*     */       }
/*     */       
/* 488 */       if (var5 == 37) {
/* 489 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 490 */           return false;
/*     */         }
/* 492 */         String str30 = SVigorItem.get(var1.getCfgId()).name;
/* 493 */         var6.chuansong(this.roleId, var2.addVigorNum, 0, 0);
/* 494 */         if (var2.Notice == "") {
/* 495 */           return true;
/*     */         }
/* 497 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 498 */         return true;
/*     */       }
/*     */       
/* 501 */       if (var5 == 38) {
/* 502 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 503 */           return false;
/*     */         }
/* 505 */         String str30 = SVigorItem.get(var1.getCfgId()).name;
/* 506 */         var6.setOpenActivityGm(var2.addVigorNum, 8191L);
/* 507 */         if (var2.Notice == "") {
/* 508 */           return true;
/*     */         }
/* 510 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 511 */         return true;
/*     */       }
/*     */       
/* 514 */       if (var5 == 39) {
/* 515 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 516 */           return false;
/*     */         }
/* 518 */         String str30 = SVigorItem.get(var1.getCfgId()).name;
/* 519 */         String str29 = SVigorItem.get(var1.getCfgId()).MapName;
/* 520 */         var6.setOpenActivityGm(var2.addVigorNum, 8191L);
/* 521 */         if (var2.Notice == "") {
/* 522 */           return true;
/*     */         }
/* 524 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 525 */         return true;
/*     */       }
/*     */       
/* 528 */       if (var5 == 40) {
/* 529 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 530 */           return false;
/*     */         }
/* 532 */         String str30 = SVigorItem.get(var1.getCfgId()).name;
/* 533 */         var6.mailCompensate(SVigorItem.get(var1.getCfgId()).name, SVigorItem.get(var1.getCfgId()).MapName, var2.addVigorNum, var2.pilemax);
/* 534 */         if (var2.Notice == "") {
/* 535 */           return true;
/*     */         }
/* 537 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 538 */         return true;
/*     */       }
/*     */       
/* 541 */       if (var5 == 41) {
/* 542 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 543 */           return false;
/*     */         }
/* 545 */         String str30 = SVigorItem.get(var1.getCfgId()).name;
/* 546 */         var6.mailCompensate(SVigorItem.get(var1.getCfgId()).name, SVigorItem.get(var1.getCfgId()).MapName, var2.addVigorNum, var2.pilemax);
/* 547 */         if (var2.Notice == "") {
/* 548 */           return true;
/*     */         }
/* 550 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 551 */         return true;
/*     */       }
/*     */       
/* 554 */       if (var5 == 42) {
/* 555 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 556 */           return false;
/*     */         }
/* 558 */         String str30 = SVigorItem.get(var1.getCfgId()).name;
/* 559 */         String str29 = SVigorItem.get(var1.getCfgId()).MapName;
/* 560 */         var6.setOpenActivityGm(var2.addVigorNum, 8191L);
/* 561 */         if (var2.Notice == "") {
/* 562 */           return true;
/*     */         }
/* 564 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 565 */         return true;
/*     */       }
/*     */       
/* 568 */       if (var5 == 43) {
/* 569 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 570 */           return false;
/*     */         }
/* 572 */         String str30 = SVigorItem.get(var1.getCfgId()).name;
/* 573 */         String str29 = SVigorItem.get(var1.getCfgId()).MapName;
/* 574 */         var6.setOpenActivityGm(var2.addVigorNum, 8191L);
/* 575 */         if (var2.Notice == "") {
/* 576 */           return true;
/*     */         }
/* 578 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 579 */         return true;
/*     */       }
/*     */       
/* 582 */       if (var5 == 44) {
/* 583 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 584 */           return false;
/*     */         }
/* 586 */         String str30 = SVigorItem.get(var1.getCfgId()).name;
/* 587 */         var6.sendNotice(SVigorItem.get(var1.getCfgId()).MapName);
/* 588 */         if (var2.Notice == "") {
/* 589 */           return true;
/*     */         }
/* 591 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 592 */         return true;
/*     */       }
/*     */       
/* 595 */       if (var5 == 45) {
/* 596 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 597 */           return false;
/*     */         }
/* 599 */         var6.closeRoleFight(this.roleId, var2.addVigorNum == 0);
/* 600 */         return true;
/*     */       }
/* 602 */       if (var5 == 46) {
/* 603 */         int var84 = Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555));
/* 604 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), var84, new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 605 */           return false;
/*     */         }
/* 607 */         RoleInterface.getRole(this.roleId, true);
/* 608 */         int var103 = var84 * var2.addVigorNum;
/* 609 */         Procedure.execute(new f254b7737c623287802c4a4a8108c7e9(var103, this.roleId, PetInterface.getFightPetId(this.roleId), var103));
/* 610 */         if (var2.Notice == "") {
/* 611 */           return true;
/*     */         }
/* 613 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 614 */         return true;
/*     */       }
/*     */       
/* 617 */       if (var5 == 47) {
/* 618 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 619 */           return false;
/*     */         }
/* 621 */         Procedure.execute(new PGM_BanNpcService(this.roleId, var2.addVigorNum));
/* 622 */         if (var2.Notice == "") {
/* 623 */           return true;
/*     */         }
/* 625 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 626 */         return true;
/*     */       }
/*     */       
/* 629 */       if (var5 == 50) {
/* 630 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), 1, new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 631 */           return false;
/*     */         }
/* 633 */         long time = SVigorItem.get(var1.getCfgId()).addVigorNum;
/* 634 */         OnlineInfo onlineInfo = OnlineManager.getInstance().getOnlineInfo(this.roleId);
/* 635 */         onlineInfo.setUseOfflineItem(true);
/* 636 */         onlineInfo.setTime(time);
/* 637 */         sendToast(this.roleId, "离线道具使用道具成功");
/* 638 */         if (var2.Notice == "") {
/* 639 */           return true;
/*     */         }
/* 641 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 642 */         return true;
/*     */       }
/*     */       
/* 645 */       if (var5 == 48) {
/* 646 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 647 */           return false;
/*     */         }
/* 649 */         Procedure.execute(new PGM_UnBanNpcService(this.roleId, var2.addVigorNum));
/* 650 */         if (var2.Notice == "") {
/* 651 */           return true;
/*     */         }
/* 653 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 654 */         return true;
/*     */       }
/*     */       
/* 657 */       if (var5 == 51) {
/* 658 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 659 */           return false;
/*     */         }
/* 661 */         Procedure.execute(new POneKeySurface(this.roleId));
/* 662 */         if (var2.Notice == "") {
/* 663 */           return true;
/*     */         }
/* 665 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 666 */         return true;
/*     */       }
/*     */       
/* 669 */       if (var5 == 52) {
/* 670 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555)), new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 671 */           return false;
/*     */         }
/* 673 */         Procedure.execute(new POnekeySplit(this.roleId));
/* 674 */         if (var2.Notice == "") {
/* 675 */           return true;
/*     */         }
/* 677 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 678 */         return true;
/*     */       }
/*     */       
/* 681 */       if (var5 == 53) {
/* 682 */         int var84 = Math.min(this.useWholeGrid ? var1.getNumber() : 1, Math.min(100, 55555));
/* 683 */         if (!ItemInterface.removeItemByUuid(this.roleId, var1.getFirstUuid().longValue(), var84, new TLogArg(LogReason.ROLE_USE_VIGOR_ITEM_REM, var1.getCfgId()))) {
/* 684 */           return false;
/*     */         }
/* 686 */         Procedure.execute(new PGM_SetYuanshen(this.roleId, this.roleId, 1, var2.addVigorNum, 10));
/* 687 */         Procedure.execute(new PGM_SetYuanshen(this.roleId, this.roleId, 2, var2.addVigorNum, 10));
/* 688 */         Procedure.execute(new PGM_SetYuanshen(this.roleId, this.roleId, 3, var2.addVigorNum, 10));
/* 689 */         Procedure.execute(new PGM_SetYuanshen(this.roleId, this.roleId, 4, var2.addVigorNum, 10));
/* 690 */         Procedure.execute(new PGM_SetYuanshen(this.roleId, this.roleId, 5, var2.addVigorNum, 10));
/* 691 */         Procedure.execute(new PGM_SetYuanshen(this.roleId, this.roleId, 6, var2.addVigorNum, 10));
/* 692 */         if (var2.Notice == "") {
/* 693 */           return true;
/*     */         }
/* 695 */         BulletinInterface.sendNotice(var2.Notice.replace("{name}", name).replace("{color1}", "<font color=").replace("{color2}", ">").replace("{color3}", "</font>"));
/* 696 */         return true;
/*     */       }
/*     */       
/*     */ 
/* 700 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 707 */     return false;
/*     */   }
/*     */   
/*     */   private void sendToast(long roleId, String message)
/*     */   {
/* 712 */     SGMMessageTipRes sGMMessageTipRes = new SGMMessageTipRes();
/* 713 */     sGMMessageTipRes.result = 41;
/* 714 */     sGMMessageTipRes.args.add(message);
/* 715 */     OnlineManager.getInstance().sendAtOnce(roleId, sGMMessageTipRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PUseVigorItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */