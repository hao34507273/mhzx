/*     */ package mzm.gsp.homeland;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class SSynHomelandRes extends __SSynHomelandRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12605461;
/*     */   public int homelevel;
/*     */   public int cleanliness;
/*     */   public int fengshuivalue;
/*     */   public int petroomlevel;
/*     */   public int dayttrainpetcount;
/*     */   public int bedroomlevel;
/*     */   public int dayrestorevigorcount;
/*     */   public int dayrestoresatiationcount;
/*     */   public int daycleancount;
/*     */   public int drugroomlevel;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12605461;
/*     */   }
/*     */   
/*     */ 
/*     */   public int kitchenlevel;
/*     */   
/*     */   public int maidroomlevel;
/*     */   
/*     */   public HashMap<Long, MaidInfo> hasmaids;
/*     */   
/*     */   public long currentmaiduuid;
/*     */   
/*     */   public HashSet<Long> my_display_room_furniture_uuid_set;
/*     */   
/*     */   public int isowner;
/*     */   
/*     */   public HashSet<Long> my_display_courtyard_furniture_uuid_set;
/*     */   
/*     */   public int courtyard_cleanliness;
/*     */   
/*     */   public int courtyard_beautiful_value;
/*     */   
/*     */   public int courtyard_level;
/*     */   public int courtyard_day_clean_count;
/*     */   public SSynHomelandRes()
/*     */   {
/*  53 */     this.hasmaids = new HashMap();
/*  54 */     this.my_display_room_furniture_uuid_set = new HashSet();
/*  55 */     this.my_display_courtyard_furniture_uuid_set = new HashSet();
/*     */   }
/*     */   
/*     */   public SSynHomelandRes(int _homelevel_, int _cleanliness_, int _fengshuivalue_, int _petroomlevel_, int _dayttrainpetcount_, int _bedroomlevel_, int _dayrestorevigorcount_, int _dayrestoresatiationcount_, int _daycleancount_, int _drugroomlevel_, int _kitchenlevel_, int _maidroomlevel_, HashMap<Long, MaidInfo> _hasmaids_, long _currentmaiduuid_, HashSet<Long> _my_display_room_furniture_uuid_set_, int _isowner_, HashSet<Long> _my_display_courtyard_furniture_uuid_set_, int _courtyard_cleanliness_, int _courtyard_beautiful_value_, int _courtyard_level_, int _courtyard_day_clean_count_) {
/*  59 */     this.homelevel = _homelevel_;
/*  60 */     this.cleanliness = _cleanliness_;
/*  61 */     this.fengshuivalue = _fengshuivalue_;
/*  62 */     this.petroomlevel = _petroomlevel_;
/*  63 */     this.dayttrainpetcount = _dayttrainpetcount_;
/*  64 */     this.bedroomlevel = _bedroomlevel_;
/*  65 */     this.dayrestorevigorcount = _dayrestorevigorcount_;
/*  66 */     this.dayrestoresatiationcount = _dayrestoresatiationcount_;
/*  67 */     this.daycleancount = _daycleancount_;
/*  68 */     this.drugroomlevel = _drugroomlevel_;
/*  69 */     this.kitchenlevel = _kitchenlevel_;
/*  70 */     this.maidroomlevel = _maidroomlevel_;
/*  71 */     this.hasmaids = _hasmaids_;
/*  72 */     this.currentmaiduuid = _currentmaiduuid_;
/*  73 */     this.my_display_room_furniture_uuid_set = _my_display_room_furniture_uuid_set_;
/*  74 */     this.isowner = _isowner_;
/*  75 */     this.my_display_courtyard_furniture_uuid_set = _my_display_courtyard_furniture_uuid_set_;
/*  76 */     this.courtyard_cleanliness = _courtyard_cleanliness_;
/*  77 */     this.courtyard_beautiful_value = _courtyard_beautiful_value_;
/*  78 */     this.courtyard_level = _courtyard_level_;
/*  79 */     this.courtyard_day_clean_count = _courtyard_day_clean_count_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  83 */     for (Map.Entry<Long, MaidInfo> _e_ : this.hasmaids.entrySet()) {
/*  84 */       if (!((MaidInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  86 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  90 */     _os_.marshal(this.homelevel);
/*  91 */     _os_.marshal(this.cleanliness);
/*  92 */     _os_.marshal(this.fengshuivalue);
/*  93 */     _os_.marshal(this.petroomlevel);
/*  94 */     _os_.marshal(this.dayttrainpetcount);
/*  95 */     _os_.marshal(this.bedroomlevel);
/*  96 */     _os_.marshal(this.dayrestorevigorcount);
/*  97 */     _os_.marshal(this.dayrestoresatiationcount);
/*  98 */     _os_.marshal(this.daycleancount);
/*  99 */     _os_.marshal(this.drugroomlevel);
/* 100 */     _os_.marshal(this.kitchenlevel);
/* 101 */     _os_.marshal(this.maidroomlevel);
/* 102 */     _os_.compact_uint32(this.hasmaids.size());
/* 103 */     for (Map.Entry<Long, MaidInfo> _e_ : this.hasmaids.entrySet()) {
/* 104 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/* 105 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/* 107 */     _os_.marshal(this.currentmaiduuid);
/* 108 */     _os_.compact_uint32(this.my_display_room_furniture_uuid_set.size());
/* 109 */     for (Long _v_ : this.my_display_room_furniture_uuid_set) {
/* 110 */       _os_.marshal(_v_.longValue());
/*     */     }
/* 112 */     _os_.marshal(this.isowner);
/* 113 */     _os_.compact_uint32(this.my_display_courtyard_furniture_uuid_set.size());
/* 114 */     for (Long _v_ : this.my_display_courtyard_furniture_uuid_set) {
/* 115 */       _os_.marshal(_v_.longValue());
/*     */     }
/* 117 */     _os_.marshal(this.courtyard_cleanliness);
/* 118 */     _os_.marshal(this.courtyard_beautiful_value);
/* 119 */     _os_.marshal(this.courtyard_level);
/* 120 */     _os_.marshal(this.courtyard_day_clean_count);
/* 121 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 125 */     this.homelevel = _os_.unmarshal_int();
/* 126 */     this.cleanliness = _os_.unmarshal_int();
/* 127 */     this.fengshuivalue = _os_.unmarshal_int();
/* 128 */     this.petroomlevel = _os_.unmarshal_int();
/* 129 */     this.dayttrainpetcount = _os_.unmarshal_int();
/* 130 */     this.bedroomlevel = _os_.unmarshal_int();
/* 131 */     this.dayrestorevigorcount = _os_.unmarshal_int();
/* 132 */     this.dayrestoresatiationcount = _os_.unmarshal_int();
/* 133 */     this.daycleancount = _os_.unmarshal_int();
/* 134 */     this.drugroomlevel = _os_.unmarshal_int();
/* 135 */     this.kitchenlevel = _os_.unmarshal_int();
/* 136 */     this.maidroomlevel = _os_.unmarshal_int();
/* 137 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 139 */       long _k_ = _os_.unmarshal_long();
/* 140 */       MaidInfo _v_ = new MaidInfo();
/* 141 */       _v_.unmarshal(_os_);
/* 142 */       this.hasmaids.put(Long.valueOf(_k_), _v_);
/*     */     }
/* 144 */     this.currentmaiduuid = _os_.unmarshal_long();
/* 145 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/* 147 */       long _v_ = _os_.unmarshal_long();
/* 148 */       this.my_display_room_furniture_uuid_set.add(Long.valueOf(_v_));
/*     */     }
/* 150 */     this.isowner = _os_.unmarshal_int();
/* 151 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/* 153 */       long _v_ = _os_.unmarshal_long();
/* 154 */       this.my_display_courtyard_furniture_uuid_set.add(Long.valueOf(_v_));
/*     */     }
/* 156 */     this.courtyard_cleanliness = _os_.unmarshal_int();
/* 157 */     this.courtyard_beautiful_value = _os_.unmarshal_int();
/* 158 */     this.courtyard_level = _os_.unmarshal_int();
/* 159 */     this.courtyard_day_clean_count = _os_.unmarshal_int();
/* 160 */     if (!_validator_()) {
/* 161 */       throw new VerifyError("validator failed");
/*     */     }
/* 163 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 167 */     if (_o1_ == this) return true;
/* 168 */     if ((_o1_ instanceof SSynHomelandRes)) {
/* 169 */       SSynHomelandRes _o_ = (SSynHomelandRes)_o1_;
/* 170 */       if (this.homelevel != _o_.homelevel) return false;
/* 171 */       if (this.cleanliness != _o_.cleanliness) return false;
/* 172 */       if (this.fengshuivalue != _o_.fengshuivalue) return false;
/* 173 */       if (this.petroomlevel != _o_.petroomlevel) return false;
/* 174 */       if (this.dayttrainpetcount != _o_.dayttrainpetcount) return false;
/* 175 */       if (this.bedroomlevel != _o_.bedroomlevel) return false;
/* 176 */       if (this.dayrestorevigorcount != _o_.dayrestorevigorcount) return false;
/* 177 */       if (this.dayrestoresatiationcount != _o_.dayrestoresatiationcount) return false;
/* 178 */       if (this.daycleancount != _o_.daycleancount) return false;
/* 179 */       if (this.drugroomlevel != _o_.drugroomlevel) return false;
/* 180 */       if (this.kitchenlevel != _o_.kitchenlevel) return false;
/* 181 */       if (this.maidroomlevel != _o_.maidroomlevel) return false;
/* 182 */       if (!this.hasmaids.equals(_o_.hasmaids)) return false;
/* 183 */       if (this.currentmaiduuid != _o_.currentmaiduuid) return false;
/* 184 */       if (!this.my_display_room_furniture_uuid_set.equals(_o_.my_display_room_furniture_uuid_set)) return false;
/* 185 */       if (this.isowner != _o_.isowner) return false;
/* 186 */       if (!this.my_display_courtyard_furniture_uuid_set.equals(_o_.my_display_courtyard_furniture_uuid_set)) return false;
/* 187 */       if (this.courtyard_cleanliness != _o_.courtyard_cleanliness) return false;
/* 188 */       if (this.courtyard_beautiful_value != _o_.courtyard_beautiful_value) return false;
/* 189 */       if (this.courtyard_level != _o_.courtyard_level) return false;
/* 190 */       if (this.courtyard_day_clean_count != _o_.courtyard_day_clean_count) return false;
/* 191 */       return true;
/*     */     }
/* 193 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 197 */     int _h_ = 0;
/* 198 */     _h_ += this.homelevel;
/* 199 */     _h_ += this.cleanliness;
/* 200 */     _h_ += this.fengshuivalue;
/* 201 */     _h_ += this.petroomlevel;
/* 202 */     _h_ += this.dayttrainpetcount;
/* 203 */     _h_ += this.bedroomlevel;
/* 204 */     _h_ += this.dayrestorevigorcount;
/* 205 */     _h_ += this.dayrestoresatiationcount;
/* 206 */     _h_ += this.daycleancount;
/* 207 */     _h_ += this.drugroomlevel;
/* 208 */     _h_ += this.kitchenlevel;
/* 209 */     _h_ += this.maidroomlevel;
/* 210 */     _h_ += this.hasmaids.hashCode();
/* 211 */     _h_ += (int)this.currentmaiduuid;
/* 212 */     _h_ += this.my_display_room_furniture_uuid_set.hashCode();
/* 213 */     _h_ += this.isowner;
/* 214 */     _h_ += this.my_display_courtyard_furniture_uuid_set.hashCode();
/* 215 */     _h_ += this.courtyard_cleanliness;
/* 216 */     _h_ += this.courtyard_beautiful_value;
/* 217 */     _h_ += this.courtyard_level;
/* 218 */     _h_ += this.courtyard_day_clean_count;
/* 219 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 223 */     StringBuilder _sb_ = new StringBuilder();
/* 224 */     _sb_.append("(");
/* 225 */     _sb_.append(this.homelevel).append(",");
/* 226 */     _sb_.append(this.cleanliness).append(",");
/* 227 */     _sb_.append(this.fengshuivalue).append(",");
/* 228 */     _sb_.append(this.petroomlevel).append(",");
/* 229 */     _sb_.append(this.dayttrainpetcount).append(",");
/* 230 */     _sb_.append(this.bedroomlevel).append(",");
/* 231 */     _sb_.append(this.dayrestorevigorcount).append(",");
/* 232 */     _sb_.append(this.dayrestoresatiationcount).append(",");
/* 233 */     _sb_.append(this.daycleancount).append(",");
/* 234 */     _sb_.append(this.drugroomlevel).append(",");
/* 235 */     _sb_.append(this.kitchenlevel).append(",");
/* 236 */     _sb_.append(this.maidroomlevel).append(",");
/* 237 */     _sb_.append(this.hasmaids).append(",");
/* 238 */     _sb_.append(this.currentmaiduuid).append(",");
/* 239 */     _sb_.append(this.my_display_room_furniture_uuid_set).append(",");
/* 240 */     _sb_.append(this.isowner).append(",");
/* 241 */     _sb_.append(this.my_display_courtyard_furniture_uuid_set).append(",");
/* 242 */     _sb_.append(this.courtyard_cleanliness).append(",");
/* 243 */     _sb_.append(this.courtyard_beautiful_value).append(",");
/* 244 */     _sb_.append(this.courtyard_level).append(",");
/* 245 */     _sb_.append(this.courtyard_day_clean_count).append(",");
/* 246 */     _sb_.append(")");
/* 247 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\SSynHomelandRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */