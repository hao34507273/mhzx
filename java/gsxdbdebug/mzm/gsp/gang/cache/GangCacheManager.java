/*     */ package mzm.gsp.gang.cache;
/*     */ 
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import xbean.GangMember;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GangCacheManager
/*     */ {
/*     */   public static boolean changeMemberDuty(long gangid, long roleid, int duty)
/*     */   {
/*  17 */     Gang gang = GangLRUCache.getInstance().getGang(gangid);
/*  18 */     if (gang == null) {
/*  19 */       return false;
/*     */     }
/*  21 */     Member member = gang.getMember(roleid);
/*  22 */     if (member == null) {
/*  23 */       return false;
/*     */     }
/*  25 */     member.setDuty(duty);
/*  26 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean setMemberForbidTalkEndTime(long gangid, long roleid, long endTime)
/*     */   {
/*  38 */     Gang gang = GangLRUCache.getInstance().getGang(gangid);
/*  39 */     if (gang == null) {
/*  40 */       return false;
/*     */     }
/*  42 */     Member member = gang.getMember(roleid);
/*  43 */     if (member == null) {
/*  44 */       return false;
/*     */     }
/*  46 */     member.setForbidTalkEndTime(endTime);
/*  47 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean changeMemberLevel(long gangid, long roleid, int level)
/*     */   {
/*  59 */     Gang gang = GangLRUCache.getInstance().getGang(gangid);
/*  60 */     if (gang == null) {
/*  61 */       return false;
/*     */     }
/*  63 */     Member member = gang.getMember(roleid);
/*  64 */     if (member == null) {
/*  65 */       return false;
/*     */     }
/*  67 */     member.setLevel(level);
/*  68 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean changeMemberName(long gangid, long roleid, String name)
/*     */   {
/*  80 */     Gang gang = GangLRUCache.getInstance().getGang(gangid);
/*  81 */     if (gang == null) {
/*  82 */       return false;
/*     */     }
/*  84 */     Member member = gang.getMember(roleid);
/*  85 */     if (member == null) {
/*  86 */       return false;
/*     */     }
/*  88 */     member.setName(name);
/*  89 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean changeMemberAvatar(long gangid, long roleid, int avatarid)
/*     */   {
/* 100 */     Gang gang = GangLRUCache.getInstance().getGang(gangid);
/* 101 */     if (gang == null) {
/* 102 */       return false;
/*     */     }
/* 104 */     Member member = gang.getMember(roleid);
/* 105 */     if (member == null) {
/* 106 */       return false;
/*     */     }
/* 108 */     member.setAvatarid(avatarid);
/* 109 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean changeMemberAvatarFrame(long gangid, long roleid, int avatarFrame)
/*     */   {
/* 120 */     Gang gang = GangLRUCache.getInstance().getGang(gangid);
/* 121 */     if (gang == null) {
/* 122 */       return false;
/*     */     }
/* 124 */     Member member = gang.getMember(roleid);
/* 125 */     if (member == null) {
/* 126 */       return false;
/*     */     }
/* 128 */     member.setAvatarFrame(avatarFrame);
/* 129 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean setMemberOfflineTime(long gangid, long roleid, long time)
/*     */   {
/* 140 */     Gang gang = GangLRUCache.getInstance().getGang(gangid);
/* 141 */     if (gang == null) {
/* 142 */       return false;
/*     */     }
/* 144 */     Member member = gang.getMember(roleid);
/* 145 */     if (member == null) {
/* 146 */       return false;
/*     */     }
/* 148 */     member.setOfflineTime(time);
/* 149 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public static boolean changeMemberContribute(long gangid, long roleid, int currentContribute, int sumContribute)
/*     */   {
/* 155 */     Gang gang = GangLRUCache.getInstance().getGang(gangid);
/* 156 */     if (gang == null) {
/* 157 */       return false;
/*     */     }
/* 159 */     Member member = gang.getMember(roleid);
/* 160 */     if (member == null) {
/* 161 */       return false;
/*     */     }
/* 163 */     member.setCurrentContribute(currentContribute);
/* 164 */     member.setSumContribute(sumContribute);
/* 165 */     return true;
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
/*     */   public static boolean changeMemberWeekContribute(long gangid, long roleid, int weekContribute, long addContributeTime)
/*     */   {
/* 178 */     Gang gang = GangLRUCache.getInstance().getGang(gangid);
/* 179 */     if (gang == null) {
/* 180 */       return false;
/*     */     }
/* 182 */     Member member = gang.getMember(roleid);
/* 183 */     if (member == null) {
/* 184 */       return false;
/*     */     }
/* 186 */     member.setWeekContribute(weekContribute);
/* 187 */     member.setAddContributeTime(addContributeTime);
/* 188 */     return true;
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
/*     */ 
/*     */   public static boolean changeMemberWeekItemContributeCount(long gangid, long roleid, int weekItemContributeCount, long itemContributeTime)
/*     */   {
/* 202 */     Gang gang = GangLRUCache.getInstance().getGang(gangid);
/* 203 */     if (gang == null) {
/* 204 */       return false;
/*     */     }
/* 206 */     Member member = gang.getMember(roleid);
/* 207 */     if (member == null) {
/* 208 */       return false;
/*     */     }
/* 210 */     member.setweekItemContributeCount(weekItemContributeCount);
/* 211 */     member.setItemContributeTime(itemContributeTime);
/* 212 */     return true;
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
/*     */   public static boolean changeMemberGetLiHeTime(long gangid, long roleid, long time)
/*     */   {
/* 225 */     Gang gang = GangLRUCache.getInstance().getGang(gangid);
/* 226 */     if (gang == null) {
/* 227 */       return false;
/*     */     }
/* 229 */     Member member = gang.getMember(roleid);
/* 230 */     if (member == null) {
/* 231 */       return false;
/*     */     }
/* 233 */     member.setGetLiheTime(time);
/* 234 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean setMemberGongXun(long gangid, long roleid, int gongXun)
/*     */   {
/* 245 */     Gang gang = GangLRUCache.getInstance().getGang(gangid);
/* 246 */     if (gang == null) {
/* 247 */       return false;
/*     */     }
/* 249 */     Member member = gang.getMember(roleid);
/* 250 */     if (member == null) {
/* 251 */       return false;
/*     */     }
/* 253 */     member.setGongXun(gongXun);
/* 254 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean changeMemberFightValue(long gangid, long roleid, int fightValue)
/*     */   {
/* 265 */     Gang gang = GangLRUCache.getInstance().getGang(gangid);
/* 266 */     if (gang == null) {
/* 267 */       return false;
/*     */     }
/* 269 */     Member member = gang.getMember(roleid);
/* 270 */     if (member == null) {
/* 271 */       return false;
/*     */     }
/* 273 */     member.setFightValue(fightValue);
/* 274 */     return true;
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
/*     */   public static boolean addMember(long gangid, Role role, int avatarid, int avatarFrame, int fightValue, GangMember xMember)
/*     */   {
/* 287 */     Gang gang = GangLRUCache.getInstance().getGang(gangid);
/* 288 */     if (gang == null) {
/* 289 */       return false;
/*     */     }
/* 291 */     Member member = newMemberCache(role, avatarid, avatarFrame, fightValue, xMember);
/* 292 */     return gang.addMember(role.getId(), member);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean updateMember(long gangid, Role role, int avatarid, GangMember xMember)
/*     */   {
/* 304 */     Gang gang = GangLRUCache.getInstance().getGang(gangid);
/* 305 */     if (gang == null) {
/* 306 */       return false;
/*     */     }
/* 308 */     Member member = gang.getMember(role.getId());
/* 309 */     if (member == null) {
/* 310 */       return false;
/*     */     }
/* 312 */     resetMember(member, role, avatarid, xMember);
/* 313 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean removeMember(long gangid, long roleid)
/*     */   {
/* 324 */     Gang gang = GangLRUCache.getInstance().getGang(gangid);
/* 325 */     if (gang == null) {
/* 326 */       return false;
/*     */     }
/* 328 */     return gang.removeMember(roleid);
/*     */   }
/*     */   
/*     */ 
/*     */   public static Member newMemberCache(Role role, int avatarid, int avatarFrame, int fightValue, GangMember xMember)
/*     */   {
/* 334 */     long roleid = role.getId();
/* 335 */     String name = role.getName();
/* 336 */     int level = role.getLevel();
/* 337 */     int gender = role.getGender();
/* 338 */     int menpai = role.getOccupationId();
/* 339 */     int duty = xMember.getDuty();
/* 340 */     int currentContribute = (int)xMember.getBanggong();
/* 341 */     int sumContribute = (int)xMember.getHistorybanggong();
/* 342 */     int weekContribute = xMember.getWeekbanggong();
/* 343 */     long addContributeTime = xMember.getAddbanggong_time();
/* 344 */     int weekItemContributeCount = xMember.getWeekitem_banggong_count();
/* 345 */     long itemContributeTime = xMember.getItem_banggong_time();
/* 346 */     long offlineTime = -1L;
/* 347 */     if (!OnlineManager.getInstance().isOnlineOrInProtect(roleid)) {
/* 348 */       offlineTime = role.getLastLogoffTime();
/*     */     }
/* 350 */     long forbidTalkEndTime = xMember.getForbiddentalkend();
/* 351 */     long joinTime = xMember.getJointime();
/* 352 */     long getLiHeTime = xMember.getLastgetlihetime();
/* 353 */     int gongXun = xMember.getGongxun();
/*     */     
/* 355 */     Member memberCache = new Member(name, level, gender, menpai, avatarid, avatarFrame, duty, currentContribute, sumContribute, weekContribute, addContributeTime, weekItemContributeCount, itemContributeTime, offlineTime, forbidTalkEndTime, joinTime, getLiHeTime, gongXun, fightValue);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 360 */     return memberCache;
/*     */   }
/*     */   
/*     */   public static void resetMember(Member member, Role role, int avatarid, GangMember xMember)
/*     */   {
/* 365 */     member.setName(role.getName());
/* 366 */     member.setLevel(role.getLevel());
/* 367 */     member.setGender(role.getGender());
/* 368 */     member.setMenpai(role.getOccupationId());
/* 369 */     member.setAvatarid(avatarid);
/* 370 */     member.setDuty(xMember.getDuty());
/* 371 */     member.setCurrentContribute((int)xMember.getBanggong());
/* 372 */     member.setSumContribute((int)xMember.getHistorybanggong());
/* 373 */     member.setWeekContribute(xMember.getWeekbanggong());
/* 374 */     member.setAddContributeTime(xMember.getAddbanggong_time());
/* 375 */     member.setweekItemContributeCount(xMember.getWeekitem_banggong_count());
/* 376 */     member.setItemContributeTime(xMember.getItem_banggong_time());
/* 377 */     if (!OnlineManager.getInstance().isOnlineOrInProtect(role.getId())) {
/* 378 */       member.setOfflineTime(role.getLastLogoffTime());
/*     */     }
/*     */     else {
/* 381 */       member.setOfflineTime(-1L);
/*     */     }
/* 383 */     member.setForbidTalkEndTime(xMember.getForbiddentalkend());
/* 384 */     member.setJoinTime(xMember.getJointime());
/* 385 */     member.setGetLiheTime(xMember.getLastgetlihetime());
/* 386 */     member.setGongXun(xMember.getGongxun());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\cache\GangCacheManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */