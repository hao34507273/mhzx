/*     */ package mzm.gsp.award;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class AwardBean implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public static final int AWARD_TYPE__ROLE_EXP = 1;
/*     */   public static final int AWARD_TYPE__SILVER = 10;
/*     */   public static final int AWARD_ADD_TYPE__LEADER = 1;
/*     */   public static final int AWARD_ADD_TYPE__TEAM = 2;
/*     */   public static final int AWARD_ADD_TYPE__STABLE_TEAM = 3;
/*     */   public static final int AWARD_ADD_TYPE__SWORN = 4;
/*     */   public static final int AWARD_ADD_TYPE__MARRIAGE = 5;
/*     */   public static final int AWARD_MOD_TYPE__SERVER = 20;
/*     */   public static final int AWARD_MOD_TYPE__QQ_N_VIP = 100;
/*     */   public static final int AWARD_MOD_TYPE__QQ_S_VIP = 101;
/*     */   public static final int AWARD_MOD_TYPE__QQ_GAME_CENTER = 102;
/*     */   public static final int AWARD_MOD_TYPE__WECAHT_GAME_CENTER = 103;
/*     */   public static final int AWARD_MOD_TYPE__APP_GAME_CENTER = 104;
/*     */   public long yuanbao;
/*     */   public long gold;
/*     */   public long silver;
/*     */   public int gang;
/*     */   public int goldingot;
/*     */   public int roleexp;
/*     */   public int petexp;
/*     */   public int xiulianexp;
/*     */   public HashMap<Long, Integer> petexpmap;
/*     */   public HashMap<Integer, Integer> itemmap;
/*     */   public HashMap<Integer, Integer> tokenmap;
/*     */   public HashMap<Integer, AwardAddBean> awardaddmap;
/*     */   
/*     */   public AwardBean()
/*     */   {
/*  37 */     this.petexpmap = new HashMap();
/*  38 */     this.itemmap = new HashMap();
/*  39 */     this.tokenmap = new HashMap();
/*  40 */     this.awardaddmap = new HashMap();
/*     */   }
/*     */   
/*     */   public AwardBean(long _yuanbao_, long _gold_, long _silver_, int _gang_, int _goldingot_, int _roleexp_, int _petexp_, int _xiulianexp_, HashMap<Long, Integer> _petexpmap_, HashMap<Integer, Integer> _itemmap_, HashMap<Integer, Integer> _tokenmap_, HashMap<Integer, AwardAddBean> _awardaddmap_) {
/*  44 */     this.yuanbao = _yuanbao_;
/*  45 */     this.gold = _gold_;
/*  46 */     this.silver = _silver_;
/*  47 */     this.gang = _gang_;
/*  48 */     this.goldingot = _goldingot_;
/*  49 */     this.roleexp = _roleexp_;
/*  50 */     this.petexp = _petexp_;
/*  51 */     this.xiulianexp = _xiulianexp_;
/*  52 */     this.petexpmap = _petexpmap_;
/*  53 */     this.itemmap = _itemmap_;
/*  54 */     this.tokenmap = _tokenmap_;
/*  55 */     this.awardaddmap = _awardaddmap_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  59 */     for (Map.Entry<Integer, AwardAddBean> _e_ : this.awardaddmap.entrySet()) {
/*  60 */       if (!((AwardAddBean)_e_.getValue())._validator_()) return false;
/*     */     }
/*  62 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  66 */     _os_.marshal(this.yuanbao);
/*  67 */     _os_.marshal(this.gold);
/*  68 */     _os_.marshal(this.silver);
/*  69 */     _os_.marshal(this.gang);
/*  70 */     _os_.marshal(this.goldingot);
/*  71 */     _os_.marshal(this.roleexp);
/*  72 */     _os_.marshal(this.petexp);
/*  73 */     _os_.marshal(this.xiulianexp);
/*  74 */     _os_.compact_uint32(this.petexpmap.size());
/*  75 */     for (Map.Entry<Long, Integer> _e_ : this.petexpmap.entrySet()) {
/*  76 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  77 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  79 */     _os_.compact_uint32(this.itemmap.size());
/*  80 */     for (Map.Entry<Integer, Integer> _e_ : this.itemmap.entrySet()) {
/*  81 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  82 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  84 */     _os_.compact_uint32(this.tokenmap.size());
/*  85 */     for (Map.Entry<Integer, Integer> _e_ : this.tokenmap.entrySet()) {
/*  86 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  87 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  89 */     _os_.compact_uint32(this.awardaddmap.size());
/*  90 */     for (Map.Entry<Integer, AwardAddBean> _e_ : this.awardaddmap.entrySet()) {
/*  91 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  92 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/*  94 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  98 */     this.yuanbao = _os_.unmarshal_long();
/*  99 */     this.gold = _os_.unmarshal_long();
/* 100 */     this.silver = _os_.unmarshal_long();
/* 101 */     this.gang = _os_.unmarshal_int();
/* 102 */     this.goldingot = _os_.unmarshal_int();
/* 103 */     this.roleexp = _os_.unmarshal_int();
/* 104 */     this.petexp = _os_.unmarshal_int();
/* 105 */     this.xiulianexp = _os_.unmarshal_int();
/* 106 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 108 */       long _k_ = _os_.unmarshal_long();
/*     */       
/* 110 */       int _v_ = _os_.unmarshal_int();
/* 111 */       this.petexpmap.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 113 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 115 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 117 */       int _v_ = _os_.unmarshal_int();
/* 118 */       this.itemmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 120 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 122 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 124 */       int _v_ = _os_.unmarshal_int();
/* 125 */       this.tokenmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 127 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 129 */       int _k_ = _os_.unmarshal_int();
/* 130 */       AwardAddBean _v_ = new AwardAddBean();
/* 131 */       _v_.unmarshal(_os_);
/* 132 */       this.awardaddmap.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 134 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 138 */     if (_o1_ == this) return true;
/* 139 */     if ((_o1_ instanceof AwardBean)) {
/* 140 */       AwardBean _o_ = (AwardBean)_o1_;
/* 141 */       if (this.yuanbao != _o_.yuanbao) return false;
/* 142 */       if (this.gold != _o_.gold) return false;
/* 143 */       if (this.silver != _o_.silver) return false;
/* 144 */       if (this.gang != _o_.gang) return false;
/* 145 */       if (this.goldingot != _o_.goldingot) return false;
/* 146 */       if (this.roleexp != _o_.roleexp) return false;
/* 147 */       if (this.petexp != _o_.petexp) return false;
/* 148 */       if (this.xiulianexp != _o_.xiulianexp) return false;
/* 149 */       if (!this.petexpmap.equals(_o_.petexpmap)) return false;
/* 150 */       if (!this.itemmap.equals(_o_.itemmap)) return false;
/* 151 */       if (!this.tokenmap.equals(_o_.tokenmap)) return false;
/* 152 */       if (!this.awardaddmap.equals(_o_.awardaddmap)) return false;
/* 153 */       return true;
/*     */     }
/* 155 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 159 */     int _h_ = 0;
/* 160 */     _h_ += (int)this.yuanbao;
/* 161 */     _h_ += (int)this.gold;
/* 162 */     _h_ += (int)this.silver;
/* 163 */     _h_ += this.gang;
/* 164 */     _h_ += this.goldingot;
/* 165 */     _h_ += this.roleexp;
/* 166 */     _h_ += this.petexp;
/* 167 */     _h_ += this.xiulianexp;
/* 168 */     _h_ += this.petexpmap.hashCode();
/* 169 */     _h_ += this.itemmap.hashCode();
/* 170 */     _h_ += this.tokenmap.hashCode();
/* 171 */     _h_ += this.awardaddmap.hashCode();
/* 172 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 176 */     StringBuilder _sb_ = new StringBuilder();
/* 177 */     _sb_.append("(");
/* 178 */     _sb_.append(this.yuanbao).append(",");
/* 179 */     _sb_.append(this.gold).append(",");
/* 180 */     _sb_.append(this.silver).append(",");
/* 181 */     _sb_.append(this.gang).append(",");
/* 182 */     _sb_.append(this.goldingot).append(",");
/* 183 */     _sb_.append(this.roleexp).append(",");
/* 184 */     _sb_.append(this.petexp).append(",");
/* 185 */     _sb_.append(this.xiulianexp).append(",");
/* 186 */     _sb_.append(this.petexpmap).append(",");
/* 187 */     _sb_.append(this.itemmap).append(",");
/* 188 */     _sb_.append(this.tokenmap).append(",");
/* 189 */     _sb_.append(this.awardaddmap).append(",");
/* 190 */     _sb_.append(")");
/* 191 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\AwardBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */