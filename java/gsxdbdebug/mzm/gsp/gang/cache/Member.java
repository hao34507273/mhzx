/*     */ package mzm.gsp.gang.cache;
/*     */ 
/*     */ import mzm.gsp.gang.MemberInfo;
/*     */ 
/*     */ public class Member
/*     */ {
/*     */   private volatile String name;
/*     */   private volatile int level;
/*     */   private volatile int gender;
/*     */   private volatile int menpai;
/*     */   private volatile int avatarid;
/*     */   private volatile int avatarFrame;
/*     */   private volatile int duty;
/*     */   private volatile int currentContribute;
/*     */   private volatile int sumContribute;
/*     */   private volatile int weekContribute;
/*     */   private volatile long addContributeTime;
/*     */   private volatile int weekItemContributeCount;
/*     */   private volatile long itemContributeTime;
/*     */   private volatile long offlineTime;
/*     */   private volatile long forbidTalkEndTime;
/*     */   private volatile long joinTime;
/*     */   private volatile long getLiheTime;
/*     */   private volatile int gongXun;
/*     */   private volatile int fightValue;
/*     */   
/*     */   public Member(String name, int level, int gender, int menpai, int avatarid, int avatarFrame, int duty, int currentContribute, int sumContribute, int weekContribute, long addContributeTime, int weekItemContributeCount, long itemContributeTime, long offlineTime, long forbidTalkEndTime, long joinTime, long getLiHeTime, int gongXun, int fightValue)
/*     */   {
/*  29 */     this.name = name;
/*  30 */     this.level = level;
/*  31 */     this.gender = gender;
/*  32 */     this.menpai = menpai;
/*  33 */     this.avatarid = avatarid;
/*  34 */     this.avatarFrame = avatarFrame;
/*  35 */     this.duty = duty;
/*  36 */     this.currentContribute = currentContribute;
/*  37 */     this.sumContribute = sumContribute;
/*  38 */     this.weekContribute = weekContribute;
/*  39 */     this.addContributeTime = addContributeTime;
/*  40 */     this.weekItemContributeCount = weekItemContributeCount;
/*  41 */     this.itemContributeTime = itemContributeTime;
/*  42 */     this.offlineTime = offlineTime;
/*  43 */     this.forbidTalkEndTime = forbidTalkEndTime;
/*  44 */     this.joinTime = joinTime;
/*  45 */     this.getLiheTime = getLiHeTime;
/*  46 */     this.gongXun = gongXun;
/*  47 */     this.fightValue = fightValue;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  52 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  56 */     this.name = name;
/*     */   }
/*     */   
/*     */   public int getLevel() {
/*  60 */     return this.level;
/*     */   }
/*     */   
/*     */   public void setLevel(int level) {
/*  64 */     this.level = level;
/*     */   }
/*     */   
/*     */   public int getGender() {
/*  68 */     return this.gender;
/*     */   }
/*     */   
/*     */   public void setGender(int gender) {
/*  72 */     this.gender = gender;
/*     */   }
/*     */   
/*     */   public int getMenpai() {
/*  76 */     return this.menpai;
/*     */   }
/*     */   
/*     */   public void setMenpai(int menpai) {
/*  80 */     this.menpai = menpai;
/*     */   }
/*     */   
/*     */   public int getAvatarid() {
/*  84 */     return this.avatarid;
/*     */   }
/*     */   
/*     */   public void setAvatarid(int avatarid) {
/*  88 */     this.avatarid = avatarid;
/*     */   }
/*     */   
/*     */   public int getAvatarFrame() {
/*  92 */     return this.avatarFrame;
/*     */   }
/*     */   
/*     */   public void setAvatarFrame(int avatarFrame) {
/*  96 */     this.avatarFrame = avatarFrame;
/*     */   }
/*     */   
/*     */   public int getDuty() {
/* 100 */     return this.duty;
/*     */   }
/*     */   
/*     */   public void setDuty(int duty) {
/* 104 */     this.duty = duty;
/*     */   }
/*     */   
/*     */   public int getCurrentContribute() {
/* 108 */     return this.currentContribute;
/*     */   }
/*     */   
/*     */   public void setCurrentContribute(int currentContribute) {
/* 112 */     this.currentContribute = currentContribute;
/*     */   }
/*     */   
/*     */   public int getSumContribute() {
/* 116 */     return this.sumContribute;
/*     */   }
/*     */   
/*     */   public void setSumContribute(int sumContribute) {
/* 120 */     this.sumContribute = sumContribute;
/*     */   }
/*     */   
/*     */   public void setWeekContribute(int weekContribute) {
/* 124 */     this.weekContribute = weekContribute;
/*     */   }
/*     */   
/*     */   public void setAddContributeTime(long addContributeTime) {
/* 128 */     this.addContributeTime = addContributeTime;
/*     */   }
/*     */   
/*     */   public void setweekItemContributeCount(int weekItemContributeCount) {
/* 132 */     this.weekItemContributeCount = weekItemContributeCount;
/*     */   }
/*     */   
/*     */   public void setItemContributeTime(long itemContributeTime) {
/* 136 */     this.itemContributeTime = itemContributeTime;
/*     */   }
/*     */   
/*     */   public long getOfflineTime() {
/* 140 */     return this.offlineTime;
/*     */   }
/*     */   
/*     */   public void setOfflineTime(long offlineTime) {
/* 144 */     this.offlineTime = offlineTime;
/*     */   }
/*     */   
/*     */   public long getForbidTalkEndTime() {
/* 148 */     return this.forbidTalkEndTime;
/*     */   }
/*     */   
/*     */   public void setForbidTalkEndTime(long forbidTalkEndTime) {
/* 152 */     this.forbidTalkEndTime = forbidTalkEndTime;
/*     */   }
/*     */   
/*     */   public long getJoinTime() {
/* 156 */     return this.joinTime;
/*     */   }
/*     */   
/*     */   public void setJoinTime(long joinTime) {
/* 160 */     this.joinTime = joinTime;
/*     */   }
/*     */   
/*     */   public long getGetLiheTime() {
/* 164 */     return this.getLiheTime;
/*     */   }
/*     */   
/*     */   public void setGetLiheTime(long getLiheTime) {
/* 168 */     this.getLiheTime = getLiheTime;
/*     */   }
/*     */   
/*     */   public int getGongXun() {
/* 172 */     return this.gongXun;
/*     */   }
/*     */   
/*     */   public void setGongXun(int gongXun) {
/* 176 */     this.gongXun = gongXun;
/*     */   }
/*     */   
/*     */   public int getFightValue() {
/* 180 */     return this.fightValue;
/*     */   }
/*     */   
/*     */   public void setFightValue(int fightValue) {
/* 184 */     this.fightValue = fightValue;
/*     */   }
/*     */   
/*     */   public void fillMemberInfoBean(long roleid, MemberInfo memberInfoBean) {
/* 188 */     memberInfoBean.roleid = roleid;
/* 189 */     memberInfoBean.name = this.name;
/* 190 */     memberInfoBean.level = this.level;
/* 191 */     memberInfoBean.gender = this.gender;
/* 192 */     memberInfoBean.occupationid = this.menpai;
/* 193 */     memberInfoBean.avatarid = this.avatarid;
/* 194 */     memberInfoBean.avatar_frame = this.avatarFrame;
/* 195 */     memberInfoBean.duty = this.duty;
/* 196 */     memberInfoBean.curbanggong = this.currentContribute;
/* 197 */     memberInfoBean.historybanggong = this.sumContribute;
/* 198 */     memberInfoBean.weekbanggong = this.weekContribute;
/* 199 */     memberInfoBean.add_banggong_time = this.addContributeTime;
/* 200 */     memberInfoBean.weekitem_banggong_count = this.weekItemContributeCount;
/* 201 */     memberInfoBean.item_banggong_time = this.itemContributeTime;
/* 202 */     memberInfoBean.offlinetime = this.offlineTime;
/* 203 */     memberInfoBean.forbiddentalk = this.forbidTalkEndTime;
/* 204 */     memberInfoBean.jointime = this.joinTime;
/* 205 */     memberInfoBean.getlihetime = this.getLiheTime;
/* 206 */     memberInfoBean.gongxun = this.gongXun;
/* 207 */     memberInfoBean.fight_value = this.fightValue;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\cache\Member.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */