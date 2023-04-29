/*     */ package mzm.gsp.bulletin;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SBulletinInfo extends __SBulletinInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12586497;
/*     */   public static final int ROLE_GET_ITEM = 1;
/*     */   public static final int ROLE_WABAO_GET_ITEM = 2;
/*     */   public static final int ROLE_WABAO_FENGYAO = 3;
/*     */   public static final int ROLE_EQUIP_LING_LEVEL = 4;
/*     */   public static final int ACTIVITY_OPEN = 5;
/*     */   public static final int YAOSHOUTUXI_FIGHT_WIN = 6;
/*     */   public static final int YAOSHOUTUXI_FIGHT_LOSE = 7;
/*     */   public static final int GANG_CREATE = 8;
/*     */   public static final int BAOTU_TRIGGER_CTRL = 9;
/*     */   public static final int YAOSHOUTUXI_MONSTER_BORN = 10;
/*     */   public static final int SHENGXIAO_MONSTER_BORN = 11;
/*     */   public static final int BAOTU_AWARD_ITEM = 12;
/*     */   public static final int ROLE_RENAME = 13;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType() {
/*  25 */     return 12586497;
/*     */   }
/*     */   
/*     */ 
/*     */   public static final int ROLE_USE_LOTTERY = 14;
/*     */   
/*     */   public static final int ROLE_JINGJI_PVP_VICTORY = 15;
/*     */   
/*     */   public static final int ROLE_JINGJI_PVP_CHUANSHUO = 16;
/*     */   
/*     */   public static final int JIU_XIAO_END_TIP = 17;
/*     */   
/*     */   public static final int FLOWER_GIVE = 18;
/*     */   
/*     */   public static final int YAOSHOUTUXI_STAR_LEVELUP = 19;
/*     */   
/*     */   public static final int KEJU_TOP3 = 20;
/*     */   
/*     */   public static final int BIGBOSS_RANK = 21;
/*     */   
/*     */   public static final int BIGBOSS_MONSTER = 22;
/*     */   
/*     */   public static final int SHENSHOU_REDEEM = 23;
/*     */   
/*     */   public static final int BIGBOSS_ACTIVITY_END = 24;
/*     */   
/*     */   public static final int KEJU_DIANSHI_KAISHI = 25;
/*     */   
/*     */   public static final int MOSHOU_REDEEM = 26;
/*     */   
/*     */   public static final int PET_HUASHENG = 27;
/*     */   public static final int HB_TIME_DESC = 28;
/*     */   public static final int PET_COMPREHEND_SKILL = 29;
/*     */   public static final int PET_SKILL_LEVELUP = 30;
/*     */   public static final int ONLINE_TREASURE_BOX = 31;
/*     */   public static final int MI_BAO_DRAW_LOTTERY = 32;
/*     */   public static final int EXPLORE_CAT_BEST_PARTNER = 33;
/*     */   public static final int REFRESH_LUCKY_BAG = 34;
/*     */   public static final int PAY_NEW_YEAR = 35;
/*     */   public static final int SIGN_PRECIOUS = 36;
/*     */   public static final int CROSS_BATTLE_SELECTION_BEGIN = 37;
/*     */   public static final int MYSTERY_SHOP_BUY = 38;
/*     */   public static final int CROSS_BATTLE_SELECTION_RANK_UP = 39;
/*     */   public static final int CROSS_BATTLE_SELECTION_RANK_UP_FINAL = 40;
/*     */   public static final int CROSS_BATTLE_SELECTION_WIN_TITLE = 41;
/*     */   public static final int CROSS_BATTLE_FINAL_BEGIN = 42;
/*     */   public static final int CROSS_BATTLE_FINAL_RANK_UP = 43;
/*     */   public static final int CROSS_BATTLE_FINAL_WIN_TITLE = 44;
/*     */   public static final int CROSS_BATTLE_COMPETE_FINAL = 45;
/*     */   public static final int FRIENDS_CIRCLE_GIVE_GIFT = 46;
/*     */   public static final int XIAO_HUI_KUAI_PAO_INNER_DRAW = 47;
/*     */   public static final int XIAO_HUI_KUAI_PAO_OUTER_DRAW = 48;
/*     */   public static final int AUCTION_END_BID = 49;
/*     */   public static final int AUCTION_WIN_BID = 50;
/*     */   public static final int CROSS_BATTLE_COMPETE_SELECTION = 51;
/*     */   public static final int COMMON_VISIBLE_MONSTER_TRIGGER = 52;
/*     */   public static final int CHRISTMAS_STOCKING_AWARD = 53;
/*     */   public static final int DRAW_CARNIVAL_ACTIVITY_DRAW = 54;
/*     */   public int bulletintype;
/*     */   public java.util.HashMap<Integer, String> params;
/*     */   public SBulletinInfo()
/*     */   {
/*  87 */     this.params = new java.util.HashMap();
/*     */   }
/*     */   
/*     */   public SBulletinInfo(int _bulletintype_, java.util.HashMap<Integer, String> _params_) {
/*  91 */     this.bulletintype = _bulletintype_;
/*  92 */     this.params = _params_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  96 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/* 100 */     _os_.marshal(this.bulletintype);
/* 101 */     _os_.compact_uint32(this.params.size());
/* 102 */     for (java.util.Map.Entry<Integer, String> _e_ : this.params.entrySet()) {
/* 103 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 104 */       _os_.marshal((String)_e_.getValue(), "UTF-16LE");
/*     */     }
/* 106 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 110 */     this.bulletintype = _os_.unmarshal_int();
/* 111 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 113 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 115 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/* 116 */       this.params.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 118 */     if (!_validator_()) {
/* 119 */       throw new VerifyError("validator failed");
/*     */     }
/* 121 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 125 */     if (_o1_ == this) return true;
/* 126 */     if ((_o1_ instanceof SBulletinInfo)) {
/* 127 */       SBulletinInfo _o_ = (SBulletinInfo)_o1_;
/* 128 */       if (this.bulletintype != _o_.bulletintype) return false;
/* 129 */       if (!this.params.equals(_o_.params)) return false;
/* 130 */       return true;
/*     */     }
/* 132 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 136 */     int _h_ = 0;
/* 137 */     _h_ += this.bulletintype;
/* 138 */     _h_ += this.params.hashCode();
/* 139 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 143 */     StringBuilder _sb_ = new StringBuilder();
/* 144 */     _sb_.append("(");
/* 145 */     _sb_.append(this.bulletintype).append(",");
/* 146 */     _sb_.append(this.params).append(",");
/* 147 */     _sb_.append(")");
/* 148 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bulletin\SBulletinInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */