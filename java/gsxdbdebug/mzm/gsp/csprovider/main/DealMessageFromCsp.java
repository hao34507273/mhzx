/*     */ package mzm.gsp.csprovider.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.bulletin.main.BulletinInterface;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.online.main.ForbidInfoManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.PresentResult;
/*     */ import mzm.gsp.qingfu.main.PresentType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.ModMoneyResult;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.json.JSONArray;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DealMessageFromCsp
/*     */ {
/*     */   public static int sendBulletin(JSONObject jso)
/*     */   {
/*  41 */     String content = jso.getString("notice_content");
/*  42 */     if (content == null)
/*     */     {
/*  44 */       return Retcode.PARAMETER_ERROR.value;
/*     */     }
/*  46 */     BulletinInterface.sendNotice(content);
/*  47 */     return Retcode.SUCCESS.value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int sendMailToRole(long roleid, JSONObject jso)
/*     */   {
/*  58 */     String mail_title = jso.getString("mail_title");
/*  59 */     if (mail_title == null)
/*     */     {
/*  61 */       return Retcode.PARAMETER_ERROR.value;
/*     */     }
/*  63 */     String mail_content = jso.getString("mail_content");
/*  64 */     if (mail_content == null)
/*     */     {
/*  66 */       return Retcode.PARAMETER_ERROR.value;
/*     */     }
/*  68 */     MailAttachment mailAttachment = MailInterface.createMailAttachment();
/*  69 */     int ret = parseMailData(jso, mailAttachment);
/*     */     
/*  71 */     if (ret == Retcode.SUCCESS.value)
/*     */     {
/*  73 */       MailInterface.synBuildAndSendMail(roleid, 1, mail_title, mail_content, mailAttachment, new TLogArg(LogReason.CSP_ADD));
/*     */     }
/*     */     
/*     */ 
/*  77 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */   private static int parseMailData(JSONObject jso, MailAttachment mailAttachment)
/*     */   {
/*  83 */     JSONArray itemArray = jso.getJSONArray("attachment");
/*  84 */     if ((itemArray == null) || (itemArray.length() == 0))
/*     */     {
/*  86 */       return Retcode.ATTACHMENT_ERROR.value;
/*     */     }
/*     */     
/*     */ 
/*  90 */     for (int i = 0; i < itemArray.length(); i++)
/*     */     {
/*  92 */       JSONObject itemid2num = itemArray.getJSONObject(i);
/*  93 */       Long itemid = Long.valueOf(itemid2num.getLong("item_id"));
/*  94 */       Long num = Long.valueOf(itemid2num.getLong("item_count"));
/*  95 */       if ((itemid == null) || (num == null))
/*     */       {
/*  97 */         return Retcode.PARAMETER_ERROR.value;
/*     */       }
/*     */       
/* 100 */       if (num.longValue() <= 0L)
/*     */       {
/* 102 */         return Retcode.VERIFY_PARAMETER_ERROR.value;
/*     */       }
/* 104 */       if (itemid.longValue() == 1L)
/*     */       {
/* 106 */         mailAttachment.setSilver(num.intValue());
/*     */       }
/* 108 */       else if (itemid.longValue() == 2L)
/*     */       {
/* 110 */         mailAttachment.setGold(num.intValue());
/*     */       }
/* 112 */       if (itemid.longValue() == 6L)
/*     */       {
/* 114 */         mailAttachment.setGoldIngot(num.intValue());
/*     */       }
/* 116 */       else if (itemid.longValue() == 3L)
/*     */       {
/* 118 */         mailAttachment.setYuanBao(num.intValue());
/*     */       }
/* 120 */       else if (itemid.longValue() == 4L)
/*     */       {
/* 122 */         mailAttachment.setBindYuanBao(num.intValue());
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 127 */         if (!ItemInterface.isItemExist(itemid.intValue()))
/*     */         {
/* 129 */           return Retcode.VERIFY_PARAMETER_ERROR.value;
/*     */         }
/* 131 */         mailAttachment.addItem(itemid.intValue(), num.intValue());
/*     */       }
/*     */     }
/*     */     
/* 135 */     return Retcode.SUCCESS.value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int sendMailToAll(JSONObject jso)
/*     */   {
/* 145 */     Map<Integer, String> mailcontentMap = new HashMap();
/* 146 */     String mail_title = jso.getString("mail_title");
/* 147 */     if (mail_title == null)
/*     */     {
/* 149 */       return Retcode.PARAMETER_ERROR.value;
/*     */     }
/* 151 */     String mail_content = jso.getString("mail_content");
/* 152 */     if (mail_content == null)
/*     */     {
/* 154 */       return Retcode.PARAMETER_ERROR.value;
/*     */     }
/* 156 */     mailcontentMap.put(Integer.valueOf(1000), mail_title);
/* 157 */     mailcontentMap.put(Integer.valueOf(1001), mail_content);
/*     */     
/* 159 */     Long serialid = Long.valueOf(jso.getLong("serialid"));
/* 160 */     if (serialid == null)
/*     */     {
/* 162 */       return Retcode.PARAMETER_ERROR.value;
/*     */     }
/* 164 */     JSONArray itemArray = jso.getJSONArray("attachment");
/* 165 */     if ((itemArray == null) || (itemArray.length() == 0))
/*     */     {
/* 167 */       return Retcode.ATTACHMENT_ERROR.value;
/*     */     }
/* 169 */     Map<Integer, Integer> type2valueMap = new HashMap();
/* 170 */     Map<Integer, Integer> itemid2numMap = new HashMap();
/* 171 */     for (int i = 0; i < itemArray.length(); i++)
/*     */     {
/* 173 */       JSONObject itemid2num = itemArray.getJSONObject(i);
/* 174 */       Long itemid = Long.valueOf(itemid2num.getLong("item_id"));
/* 175 */       Long num = Long.valueOf(itemid2num.getLong("item_count"));
/* 176 */       if ((itemid == null) || (num == null))
/*     */       {
/* 178 */         return Retcode.PARAMETER_ERROR.value;
/*     */       }
/*     */       
/* 181 */       if (num.longValue() <= 0L)
/*     */       {
/* 183 */         return Retcode.VERIFY_PARAMETER_ERROR.value;
/*     */       }
/*     */       
/* 186 */       if (itemid.longValue() == 1L)
/*     */       {
/* 188 */         type2valueMap.put(Integer.valueOf(1), Integer.valueOf(num.intValue()));
/*     */       }
/* 190 */       else if (itemid.longValue() == 2L)
/*     */       {
/* 192 */         type2valueMap.put(Integer.valueOf(2), Integer.valueOf(num.intValue()));
/*     */       }
/* 194 */       if (itemid.longValue() == 6L)
/*     */       {
/* 196 */         type2valueMap.put(Integer.valueOf(6), Integer.valueOf(num.intValue()));
/*     */       }
/* 198 */       else if (itemid.longValue() == 3L)
/*     */       {
/* 200 */         type2valueMap.put(Integer.valueOf(3), Integer.valueOf(num.intValue()));
/*     */       }
/* 202 */       else if (itemid.longValue() == 4L)
/*     */       {
/* 204 */         type2valueMap.put(Integer.valueOf(4), Integer.valueOf(num.intValue()));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 209 */         if (!ItemInterface.isItemExist(itemid.intValue()))
/*     */         {
/* 211 */           return Retcode.VERIFY_PARAMETER_ERROR.value;
/*     */         }
/* 213 */         itemid2numMap.put(Integer.valueOf(itemid.intValue()), Integer.valueOf(num.intValue()));
/*     */       }
/*     */     }
/*     */     
/* 217 */     long st = DateTimeUtils.getCurrTimeInMillis();
/* 218 */     long end = st + 86400000L;
/* 219 */     type2valueMap.put(Integer.valueOf(998), Integer.valueOf(LogReason.CSP_ADD.value));
/* 220 */     type2valueMap.put(Integer.valueOf(999), Integer.valueOf(LogReason.CSP_ADD.value));
/* 221 */     boolean ret = ItemInterface.addSystemAward(itemid2numMap, DateTimeUtils.getCurrTimeInMillis(), end, type2valueMap, mailcontentMap);
/*     */     
/* 223 */     if (ret)
/*     */     {
/* 225 */       for (Iterator i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */         
/* 227 */         NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */         {
/*     */           protected boolean processImp()
/*     */             throws Exception
/*     */           {
/* 232 */             return ItemInterface.offerSystemAwards(this.val$roleid);
/*     */           }
/*     */         });
/*     */       }
/*     */       
/* 237 */       return Retcode.SUCCESS.value;
/*     */     }
/* 239 */     return Retcode.VERIFY_PARAMETER_ERROR.value;
/*     */   }
/*     */   
/*     */ 
/*     */   public static int modifyItemNum(JSONObject jso)
/*     */   {
/* 245 */     Long itemid = Long.valueOf(jso.getLong("itemid"));
/* 246 */     Integer type = Integer.valueOf(jso.getInt("type"));
/* 247 */     Long val = Long.valueOf(jso.getLong("val"));
/* 248 */     Integer targettype = Integer.valueOf(jso.getInt("targettype"));
/* 249 */     String target = jso.getString("target");
/* 250 */     if ((itemid == null) || (type == null) || (val == null) || (target == null) || (targettype == null))
/*     */     {
/* 252 */       return Retcode.PARSE_PARAMETER_ERROR.value;
/*     */     }
/* 254 */     if (targettype.intValue() != 1)
/*     */     {
/* 256 */       return Retcode.PARAMETER_ERROR.value;
/*     */     }
/* 258 */     Long roleId = null;
/*     */     try
/*     */     {
/* 261 */       roleId = Long.valueOf(Long.parseLong(target));
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 265 */       return Retcode.PARSE_PARAMETER_ERROR.value;
/*     */     }
/* 267 */     if (!RoleInterface.isRoleExist(roleId.longValue(), false))
/*     */     {
/* 269 */       return Retcode.ROLE_NOT_EXIST.value;
/*     */     }
/* 271 */     if (val.longValue() <= 0L)
/*     */     {
/* 273 */       return Retcode.VERIFY_PARAMETER_ERROR.value;
/*     */     }
/*     */     
/* 276 */     if (itemid.longValue() == 1L)
/*     */     {
/* 278 */       if (type.intValue() == 1)
/*     */       {
/* 280 */         TLogArg logArg = new TLogArg(LogReason.CSP_ADD);
/* 281 */         boolean res = RoleInterface.addSilver(roleId.longValue(), val.longValue(), logArg).isSucceed();
/* 282 */         if (!res)
/*     */         {
/* 284 */           return Retcode.DB_ERROR.value;
/*     */         }
/*     */       }
/* 287 */       else if (type.intValue() == 2)
/*     */       {
/* 289 */         TLogArg logArg = new TLogArg(LogReason.CSP_REM);
/* 290 */         boolean res = RoleInterface.cutSilver(roleId.longValue(), val.longValue(), logArg);
/* 291 */         if (!res)
/*     */         {
/* 293 */           return Retcode.DB_ERROR.value;
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 298 */         return Retcode.VERIFY_PARAMETER_ERROR.value;
/*     */       }
/*     */     }
/* 301 */     else if (itemid.longValue() == 2L)
/*     */     {
/* 303 */       if (type.intValue() == 1)
/*     */       {
/* 305 */         TLogArg logArg = new TLogArg(LogReason.CSP_ADD);
/* 306 */         boolean res = RoleInterface.addGold(roleId.longValue(), val.longValue(), logArg).isSucceed();
/* 307 */         if (!res)
/*     */         {
/* 309 */           return Retcode.DB_ERROR.value;
/*     */         }
/*     */       }
/* 312 */       else if (type.intValue() == 2)
/*     */       {
/* 314 */         TLogArg logArg = new TLogArg(LogReason.CSP_REM);
/* 315 */         boolean res = RoleInterface.cutGold(roleId.longValue(), val.longValue(), logArg);
/* 316 */         if (!res)
/*     */         {
/* 318 */           return Retcode.DB_ERROR.value;
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 323 */         return Retcode.VERIFY_PARAMETER_ERROR.value;
/*     */       }
/*     */     }
/* 326 */     else if (itemid.longValue() == 6L)
/*     */     {
/* 328 */       if (type.intValue() == 1)
/*     */       {
/* 330 */         TLogArg logArg = new TLogArg(LogReason.CSP_ADD);
/* 331 */         boolean res = RoleInterface.addGoldIngotInAll(roleId.longValue(), val.longValue(), logArg, true).isSucceed();
/* 332 */         if (!res)
/*     */         {
/* 334 */           return Retcode.DB_ERROR.value;
/*     */         }
/*     */       }
/* 337 */       else if (type.intValue() == 2)
/*     */       {
/* 339 */         TLogArg logArg = new TLogArg(LogReason.CSP_REM);
/* 340 */         boolean res = RoleInterface.cutGoldIngot(roleId.longValue(), val.longValue(), logArg);
/* 341 */         if (!res)
/*     */         {
/* 343 */           return Retcode.DB_ERROR.value;
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 348 */         return Retcode.VERIFY_PARAMETER_ERROR.value;
/*     */       }
/*     */     }
/* 351 */     else if (itemid.longValue() == 3L)
/*     */     {
/* 353 */       if (type.intValue() != 1)
/*     */       {
/*     */ 
/*     */ 
/* 357 */         if (type.intValue() != 2)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 363 */           return Retcode.VERIFY_PARAMETER_ERROR.value;
/*     */         }
/*     */       }
/* 366 */     } else if (itemid.longValue() == 4L)
/*     */     {
/* 368 */       if (type.intValue() == 1)
/*     */       {
/* 370 */         String userid = RoleInterface.getUserId(roleId.longValue());
/* 371 */         boolean res = QingfuInterface.presentYuanbao(userid, roleId.longValue(), val.intValue(), PresentType.PRESENT_BIND_CSP, new TLogArg(LogReason.CSP_ADD)) == PresentResult.Success;
/*     */         
/* 373 */         if (!res)
/*     */         {
/* 375 */           return Retcode.DB_ERROR.value;
/*     */         }
/*     */       }
/* 378 */       else if (type.intValue() == 2)
/*     */       {
/* 380 */         String userid = RoleInterface.getUserId(roleId.longValue());
/* 381 */         boolean res = QingfuInterface.costYuanbao(userid, roleId.longValue(), val.intValue(), CostType.COST_BIND_FIRST_CSP, new TLogArg(LogReason.CSP_REM)) == CostResult.Success;
/*     */         
/* 383 */         if (!res)
/*     */         {
/* 385 */           return Retcode.DB_ERROR.value;
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 390 */         return Retcode.VERIFY_PARAMETER_ERROR.value;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 395 */       if (!ItemInterface.isItemExist(itemid.intValue()))
/*     */       {
/* 397 */         return Retcode.VERIFY_PARAMETER_ERROR.value;
/*     */       }
/* 399 */       if (type.intValue() == 1)
/*     */       {
/* 401 */         ItemOperateResult res = ItemInterface.addItem(roleId.longValue(), itemid.intValue(), val.intValue(), new TLogArg(LogReason.CSP_ADD));
/*     */         
/* 403 */         if ((!res.success()) && (!res.isBagFull()))
/*     */         {
/* 405 */           return Retcode.DB_ERROR.value;
/*     */         }
/*     */       }
/* 408 */       else if (type.intValue() == 2)
/*     */       {
/* 410 */         boolean res = ItemInterface.removeItemById(roleId.longValue(), 340600000, itemid.intValue(), val.intValue(), new TLogArg(LogReason.CSP_REM));
/*     */         
/* 412 */         if (!res)
/*     */         {
/* 414 */           return Retcode.DB_ERROR.value;
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 419 */         return Retcode.VERIFY_PARAMETER_ERROR.value;
/*     */       }
/*     */     }
/* 422 */     return Retcode.SUCCESS.value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static JSONObject queryRoleJSONObject(long roleId)
/*     */   {
/* 433 */     String userid = RoleInterface.getUserId(roleId);
/* 434 */     String rolename = RoleInterface.getName(roleId);
/* 435 */     String zoneid = String.valueOf(GameServerInfoManager.getZoneidFromRoleid(roleId));
/* 436 */     String platform = String.valueOf(RoleInterface.getPlatform(roleId));
/* 437 */     String channelid = String.valueOf(RoleInterface.getChannel(roleId));
/* 438 */     String ocp = String.valueOf(RoleInterface.getOccupationId(roleId));
/* 439 */     String level = String.valueOf(RoleInterface.getLevel(roleId));
/* 440 */     String cents = String.valueOf(QingfuInterface.getTotalCash(userid, false));
/* 441 */     long cash_add = QingfuInterface.getYuanbao(userid, false);
/* 442 */     long cash_used = QingfuInterface.getTotalCost(userid, false);
/* 443 */     long bind_cash_add = QingfuInterface.getBindYuanbao(userid, false);
/* 444 */     long bind_cash_used = QingfuInterface.getTotalCostBind(userid, false);
/* 445 */     String gold = String.valueOf(RoleInterface.getGold(roleId));
/* 446 */     String silver = String.valueOf(RoleInterface.getSilver(roleId));
/* 447 */     String godIngot = String.valueOf(RoleInterface.getGoldIngot(roleId));
/* 448 */     String bangGong = String.valueOf(GangInterface.getBangGong(roleId));
/* 449 */     String xiayi_value = String.valueOf(MallInterface.getJifen(roleId, 1));
/* 450 */     String jingji_value = String.valueOf(MallInterface.getJifen(roleId, 2));
/* 451 */     String shimen_value = String.valueOf(MallInterface.getJifen(roleId, 3));
/* 452 */     String shengwang_value = String.valueOf(MallInterface.getJifen(roleId, 4));
/* 453 */     String ladderscore_value = String.valueOf(MallInterface.getJifen(roleId, 5));
/*     */     
/* 455 */     JSONObject result = new JSONObject();
/* 456 */     result.put("1", userid);
/* 457 */     result.put("2", roleId);
/* 458 */     result.put("42", convertToCid(roleId));
/* 459 */     result.put("3", rolename);
/* 460 */     result.put("4", zoneid);
/* 461 */     result.put("5", platform);
/* 462 */     result.put("6", channelid);
/* 463 */     result.put("7", ocp);
/* 464 */     result.put("8", level);
/* 465 */     result.put("9", cents);
/* 466 */     result.put("10", cash_add + "");
/* 467 */     result.put("11", cash_used + "");
/* 468 */     result.put("12", bind_cash_add + "");
/* 469 */     result.put("13", bind_cash_used + "");
/* 470 */     result.put("14", gold);
/* 471 */     result.put("15", silver);
/*     */     
/* 473 */     result.put("16", godIngot);
/* 474 */     result.put("17", bangGong);
/* 475 */     result.put("18", xiayi_value);
/* 476 */     result.put("19", jingji_value);
/* 477 */     result.put("20", shimen_value);
/* 478 */     result.put("21", shengwang_value);
/* 479 */     result.put("22", ladderscore_value);
/*     */     
/* 481 */     JSONArray forbidarray = new JSONArray();
/* 482 */     JSONArray a = new JSONArray();
/*     */     
/* 484 */     a.put(100);
/* 485 */     a.put(ForbidInfoManager.getRoleForbideEndTime(roleId));
/* 486 */     a.put(ForbidInfoManager.getFirbidRoleReason(roleId));
/* 487 */     forbidarray.put(a);
/* 488 */     JSONArray b = new JSONArray();
/* 489 */     b.put(101);
/* 490 */     b.put(ForbidInfoManager.getFirbidTalkTime(roleId));
/* 491 */     b.put(ForbidInfoManager.getFirbidTalkReason(roleId));
/* 492 */     forbidarray.put(b);
/* 493 */     result.put("forbidlist", forbidarray);
/*     */     
/* 495 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String queryRoleInfo(long roleId)
/*     */   {
/* 507 */     JSONObject result = queryRoleJSONObject(roleId);
/* 508 */     JSONArray roleArray = new JSONArray();
/* 509 */     roleArray.put(result);
/* 510 */     JSONObject js = new JSONObject();
/* 511 */     js.put("rolelist", roleArray);
/* 512 */     return js.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String queryRoleInfoList(List<Long> roles)
/*     */   {
/* 522 */     JSONArray roleArray = new JSONArray();
/* 523 */     for (Iterator i$ = roles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 525 */       JSONObject result = queryRoleJSONObject(roleId);
/* 526 */       roleArray.put(result);
/*     */     }
/* 528 */     JSONObject js = new JSONObject();
/* 529 */     js.put("rolelist", roleArray);
/* 530 */     return js.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int parseCommand(JSONObject jso)
/*     */   {
/* 543 */     String command = jso.getString("command_content");
/* 544 */     if (command == null)
/*     */     {
/* 546 */       return Retcode.PARSE_PARAMETER_ERROR.value;
/*     */     }
/* 548 */     return Retcode.SUCCESS.value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int setServerOnlineNum(JSONObject jso)
/*     */   {
/* 559 */     Integer max_player_num = Integer.valueOf(jso.getInt("max_player_num"));
/* 560 */     Integer max_with_queue_num = Integer.valueOf(jso.getInt("max_with_queue_num"));
/* 561 */     if ((max_player_num == null) || (max_with_queue_num == null))
/*     */     {
/* 563 */       return Retcode.PARSE_PARAMETER_ERROR.value;
/*     */     }
/* 565 */     return Retcode.SUCCESS.value;
/*     */   }
/*     */   
/*     */ 
/*     */   static long convertToRoleid(String roleNo)
/*     */   {
/* 571 */     return CommonUtils.roleNoToID(roleNo);
/*     */   }
/*     */   
/*     */   static long convertToCid(long roleid)
/*     */   {
/* 576 */     long base = 1000000L;
/* 577 */     long step = 4096L;
/*     */     
/* 579 */     long roleIndex = roleid / step;
/* 580 */     long severIndex = roleid % step;
/* 581 */     long displayId = severIndex * base + roleIndex;
/*     */     
/* 583 */     return displayId;
/*     */   }
/*     */   
/*     */ 
/*     */   public static int forbidRole(long roleId, JSONObject jso)
/*     */   {
/* 589 */     Long forbidtype = Long.valueOf(jso.getLong("forbid_type"));
/* 590 */     Long time = Long.valueOf(jso.getLong("forbid_time"));
/* 591 */     String reason = jso.getString("reason");
/* 592 */     if ((forbidtype == null) || (time == null) || (reason == null))
/*     */     {
/* 594 */       return Retcode.PARSE_PARAMETER_ERROR.value;
/*     */     }
/* 596 */     if (forbidtype.longValue() == 101L)
/*     */     {
/* 598 */       if (time.longValue() == 0L)
/*     */       {
/* 600 */         ForbidInfoManager.unforbidTalk(roleId);
/* 601 */         return Retcode.SUCCESS.value;
/*     */       }
/* 603 */       if (time.longValue() > 0L)
/*     */       {
/*     */ 
/* 606 */         ForbidInfoManager.forbidTalk(roleId, time.longValue(), reason);
/* 607 */         return Retcode.SUCCESS.value;
/*     */       }
/*     */       
/*     */ 
/* 611 */       return Retcode.VERIFY_PARAMETER_ERROR.value;
/*     */     }
/*     */     
/* 614 */     if (forbidtype.longValue() == 100L)
/*     */     {
/* 616 */       if (time.longValue() == 0L)
/*     */       {
/* 618 */         ForbidInfoManager.unforbidRole(roleId);
/* 619 */         return Retcode.SUCCESS.value;
/*     */       }
/* 621 */       if (time.longValue() > 0L)
/*     */       {
/* 623 */         ForbidInfoManager.forbidRole(roleId, time.longValue(), reason);
/* 624 */         return Retcode.SUCCESS.value;
/*     */       }
/*     */       
/*     */ 
/* 628 */       return Retcode.VERIFY_PARAMETER_ERROR.value;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 633 */     return Retcode.VERIFY_PARAMETER_ERROR.value;
/*     */   }
/*     */   
/*     */ 
/*     */   public static int forbidUser(JSONObject jso)
/*     */   {
/* 639 */     String userId = jso.getString("account");
/* 640 */     Long forbidtype = Long.valueOf(jso.getLong("forbid_type"));
/* 641 */     Integer time = Integer.valueOf(jso.getInt("forbid_time"));
/* 642 */     String reason = jso.getString("reason");
/* 643 */     if ((userId == null) || (forbidtype == null) || (time == null) || (reason == null))
/*     */     {
/* 645 */       return Retcode.PARSE_PARAMETER_ERROR.value;
/*     */     }
/* 647 */     if (forbidtype.longValue() == 100L)
/*     */     {
/* 649 */       if (time.intValue() == 0)
/*     */       {
/* 651 */         ForbidInfoManager.unforbidUser(userId);
/* 652 */         return Retcode.SUCCESS.value;
/*     */       }
/* 654 */       if (time.intValue() > 0)
/*     */       {
/* 656 */         ForbidInfoManager.forbidUser(userId, time.intValue(), reason);
/* 657 */         return Retcode.SUCCESS.value;
/*     */       }
/*     */       
/*     */ 
/* 661 */       return Retcode.VERIFY_PARAMETER_ERROR.value;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 666 */     return Retcode.VERIFY_PARAMETER_ERROR.value;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\main\DealMessageFromCsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */