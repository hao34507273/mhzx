/*     */ package grc;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class GrcUserLoginRes implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public int retcode;
/*     */   public HashMap<Integer, QQVipInfo> qq_vip_infos;
/*     */   public int friend_total_count;
/*     */   public ArrayList<GrcUserInfo> friends;
/*     */   public ArrayList<GrcUserSendGiftInfo> user_send_gift_infos;
/*     */   public ArrayList<GrcUserReceiveGiftTimesInfo> user_receive_gift_times_infos;
/*     */   public ArrayList<GrcUserReceiveGiftMetaInfo> user_receive_gift_meta_infos;
/*     */   public int receive_gift_total_count;
/*     */   public ArrayList<GrcReceiveGiftInfo> receive_gift_infos;
/*     */   public ArrayList<GrcUserProfileInfo> profile_info;
/*     */   public ArrayList<GrcLossUserInfo> recall_friends;
/*     */   public ArrayList<GrcRecallInfo> recall_info;
/*     */   public ArrayList<GrcUserBackInfo> back_info;
/*     */   public ArrayList<GrcBindRewardInfo> bind_reward_info;
/*     */   public ArrayList<GrcBindFriendVitalityInfo> recall_bind_info;
/*     */   public ArrayList<GrcBindFriendVitalityInfo> back_bind_info;
/*     */   public ArrayList<GrcRoleInfo> role_vitality_info;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   public GrcUserLoginRes()
/*     */   {
/*  32 */     this.retcode = 9;
/*  33 */     this.qq_vip_infos = new HashMap();
/*  34 */     this.friends = new ArrayList();
/*  35 */     this.user_send_gift_infos = new ArrayList();
/*  36 */     this.user_receive_gift_times_infos = new ArrayList();
/*  37 */     this.user_receive_gift_meta_infos = new ArrayList();
/*  38 */     this.receive_gift_infos = new ArrayList();
/*  39 */     this.profile_info = new ArrayList();
/*  40 */     this.recall_friends = new ArrayList();
/*  41 */     this.recall_info = new ArrayList();
/*  42 */     this.back_info = new ArrayList();
/*  43 */     this.bind_reward_info = new ArrayList();
/*  44 */     this.recall_bind_info = new ArrayList();
/*  45 */     this.back_bind_info = new ArrayList();
/*  46 */     this.role_vitality_info = new ArrayList();
/*  47 */     this.reserved1 = 0;
/*  48 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public GrcUserLoginRes(int _retcode_, HashMap<Integer, QQVipInfo> _qq_vip_infos_, int _friend_total_count_, ArrayList<GrcUserInfo> _friends_, ArrayList<GrcUserSendGiftInfo> _user_send_gift_infos_, ArrayList<GrcUserReceiveGiftTimesInfo> _user_receive_gift_times_infos_, ArrayList<GrcUserReceiveGiftMetaInfo> _user_receive_gift_meta_infos_, int _receive_gift_total_count_, ArrayList<GrcReceiveGiftInfo> _receive_gift_infos_, ArrayList<GrcUserProfileInfo> _profile_info_, ArrayList<GrcLossUserInfo> _recall_friends_, ArrayList<GrcRecallInfo> _recall_info_, ArrayList<GrcUserBackInfo> _back_info_, ArrayList<GrcBindRewardInfo> _bind_reward_info_, ArrayList<GrcBindFriendVitalityInfo> _recall_bind_info_, ArrayList<GrcBindFriendVitalityInfo> _back_bind_info_, ArrayList<GrcRoleInfo> _role_vitality_info_, int _reserved1_, int _reserved2_) {
/*  52 */     this.retcode = _retcode_;
/*  53 */     this.qq_vip_infos = _qq_vip_infos_;
/*  54 */     this.friend_total_count = _friend_total_count_;
/*  55 */     this.friends = _friends_;
/*  56 */     this.user_send_gift_infos = _user_send_gift_infos_;
/*  57 */     this.user_receive_gift_times_infos = _user_receive_gift_times_infos_;
/*  58 */     this.user_receive_gift_meta_infos = _user_receive_gift_meta_infos_;
/*  59 */     this.receive_gift_total_count = _receive_gift_total_count_;
/*  60 */     this.receive_gift_infos = _receive_gift_infos_;
/*  61 */     this.profile_info = _profile_info_;
/*  62 */     this.recall_friends = _recall_friends_;
/*  63 */     this.recall_info = _recall_info_;
/*  64 */     this.back_info = _back_info_;
/*  65 */     this.bind_reward_info = _bind_reward_info_;
/*  66 */     this.recall_bind_info = _recall_bind_info_;
/*  67 */     this.back_bind_info = _back_bind_info_;
/*  68 */     this.role_vitality_info = _role_vitality_info_;
/*  69 */     this.reserved1 = _reserved1_;
/*  70 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  74 */     for (Map.Entry<Integer, QQVipInfo> _e_ : this.qq_vip_infos.entrySet()) {
/*  75 */       if (!((QQVipInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  77 */     for (GrcUserInfo _v_ : this.friends)
/*  78 */       if (!_v_._validator_()) return false;
/*  79 */     for (GrcUserSendGiftInfo _v_ : this.user_send_gift_infos)
/*  80 */       if (!_v_._validator_()) return false;
/*  81 */     for (GrcUserReceiveGiftTimesInfo _v_ : this.user_receive_gift_times_infos)
/*  82 */       if (!_v_._validator_()) return false;
/*  83 */     for (GrcUserReceiveGiftMetaInfo _v_ : this.user_receive_gift_meta_infos)
/*  84 */       if (!_v_._validator_()) return false;
/*  85 */     for (GrcReceiveGiftInfo _v_ : this.receive_gift_infos)
/*  86 */       if (!_v_._validator_()) return false;
/*  87 */     for (GrcUserProfileInfo _v_ : this.profile_info)
/*  88 */       if (!_v_._validator_()) return false;
/*  89 */     for (GrcLossUserInfo _v_ : this.recall_friends)
/*  90 */       if (!_v_._validator_()) return false;
/*  91 */     for (GrcRecallInfo _v_ : this.recall_info)
/*  92 */       if (!_v_._validator_()) return false;
/*  93 */     for (GrcUserBackInfo _v_ : this.back_info)
/*  94 */       if (!_v_._validator_()) return false;
/*  95 */     for (GrcBindRewardInfo _v_ : this.bind_reward_info)
/*  96 */       if (!_v_._validator_()) return false;
/*  97 */     for (GrcBindFriendVitalityInfo _v_ : this.recall_bind_info)
/*  98 */       if (!_v_._validator_()) return false;
/*  99 */     for (GrcBindFriendVitalityInfo _v_ : this.back_bind_info)
/* 100 */       if (!_v_._validator_()) return false;
/* 101 */     for (GrcRoleInfo _v_ : this.role_vitality_info)
/* 102 */       if (!_v_._validator_()) return false;
/* 103 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/* 107 */     _os_.marshal(this.retcode);
/* 108 */     _os_.compact_uint32(this.qq_vip_infos.size());
/* 109 */     for (Map.Entry<Integer, QQVipInfo> _e_ : this.qq_vip_infos.entrySet()) {
/* 110 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 111 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 113 */     _os_.marshal(this.friend_total_count);
/* 114 */     _os_.compact_uint32(this.friends.size());
/* 115 */     for (GrcUserInfo _v_ : this.friends) {
/* 116 */       _os_.marshal(_v_);
/*     */     }
/* 118 */     _os_.compact_uint32(this.user_send_gift_infos.size());
/* 119 */     for (GrcUserSendGiftInfo _v_ : this.user_send_gift_infos) {
/* 120 */       _os_.marshal(_v_);
/*     */     }
/* 122 */     _os_.compact_uint32(this.user_receive_gift_times_infos.size());
/* 123 */     for (GrcUserReceiveGiftTimesInfo _v_ : this.user_receive_gift_times_infos) {
/* 124 */       _os_.marshal(_v_);
/*     */     }
/* 126 */     _os_.compact_uint32(this.user_receive_gift_meta_infos.size());
/* 127 */     for (GrcUserReceiveGiftMetaInfo _v_ : this.user_receive_gift_meta_infos) {
/* 128 */       _os_.marshal(_v_);
/*     */     }
/* 130 */     _os_.marshal(this.receive_gift_total_count);
/* 131 */     _os_.compact_uint32(this.receive_gift_infos.size());
/* 132 */     for (GrcReceiveGiftInfo _v_ : this.receive_gift_infos) {
/* 133 */       _os_.marshal(_v_);
/*     */     }
/* 135 */     _os_.compact_uint32(this.profile_info.size());
/* 136 */     for (GrcUserProfileInfo _v_ : this.profile_info) {
/* 137 */       _os_.marshal(_v_);
/*     */     }
/* 139 */     _os_.compact_uint32(this.recall_friends.size());
/* 140 */     for (GrcLossUserInfo _v_ : this.recall_friends) {
/* 141 */       _os_.marshal(_v_);
/*     */     }
/* 143 */     _os_.compact_uint32(this.recall_info.size());
/* 144 */     for (GrcRecallInfo _v_ : this.recall_info) {
/* 145 */       _os_.marshal(_v_);
/*     */     }
/* 147 */     _os_.compact_uint32(this.back_info.size());
/* 148 */     for (GrcUserBackInfo _v_ : this.back_info) {
/* 149 */       _os_.marshal(_v_);
/*     */     }
/* 151 */     _os_.compact_uint32(this.bind_reward_info.size());
/* 152 */     for (GrcBindRewardInfo _v_ : this.bind_reward_info) {
/* 153 */       _os_.marshal(_v_);
/*     */     }
/* 155 */     _os_.compact_uint32(this.recall_bind_info.size());
/* 156 */     for (GrcBindFriendVitalityInfo _v_ : this.recall_bind_info) {
/* 157 */       _os_.marshal(_v_);
/*     */     }
/* 159 */     _os_.compact_uint32(this.back_bind_info.size());
/* 160 */     for (GrcBindFriendVitalityInfo _v_ : this.back_bind_info) {
/* 161 */       _os_.marshal(_v_);
/*     */     }
/* 163 */     _os_.compact_uint32(this.role_vitality_info.size());
/* 164 */     for (GrcRoleInfo _v_ : this.role_vitality_info) {
/* 165 */       _os_.marshal(_v_);
/*     */     }
/* 167 */     _os_.marshal(this.reserved1);
/* 168 */     _os_.marshal(this.reserved2);
/* 169 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 173 */     this.retcode = _os_.unmarshal_int();
/* 174 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 176 */       int _k_ = _os_.unmarshal_int();
/* 177 */       QQVipInfo _v_ = new QQVipInfo();
/* 178 */       _v_.unmarshal(_os_);
/* 179 */       this.qq_vip_infos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 181 */     this.friend_total_count = _os_.unmarshal_int();
/* 182 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 183 */       GrcUserInfo _v_ = new GrcUserInfo();
/* 184 */       _v_.unmarshal(_os_);
/* 185 */       this.friends.add(_v_);
/*     */     }
/* 187 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 188 */       GrcUserSendGiftInfo _v_ = new GrcUserSendGiftInfo();
/* 189 */       _v_.unmarshal(_os_);
/* 190 */       this.user_send_gift_infos.add(_v_);
/*     */     }
/* 192 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 193 */       GrcUserReceiveGiftTimesInfo _v_ = new GrcUserReceiveGiftTimesInfo();
/* 194 */       _v_.unmarshal(_os_);
/* 195 */       this.user_receive_gift_times_infos.add(_v_);
/*     */     }
/* 197 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 198 */       GrcUserReceiveGiftMetaInfo _v_ = new GrcUserReceiveGiftMetaInfo();
/* 199 */       _v_.unmarshal(_os_);
/* 200 */       this.user_receive_gift_meta_infos.add(_v_);
/*     */     }
/* 202 */     this.receive_gift_total_count = _os_.unmarshal_int();
/* 203 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 204 */       GrcReceiveGiftInfo _v_ = new GrcReceiveGiftInfo();
/* 205 */       _v_.unmarshal(_os_);
/* 206 */       this.receive_gift_infos.add(_v_);
/*     */     }
/* 208 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 209 */       GrcUserProfileInfo _v_ = new GrcUserProfileInfo();
/* 210 */       _v_.unmarshal(_os_);
/* 211 */       this.profile_info.add(_v_);
/*     */     }
/* 213 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 214 */       GrcLossUserInfo _v_ = new GrcLossUserInfo();
/* 215 */       _v_.unmarshal(_os_);
/* 216 */       this.recall_friends.add(_v_);
/*     */     }
/* 218 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 219 */       GrcRecallInfo _v_ = new GrcRecallInfo();
/* 220 */       _v_.unmarshal(_os_);
/* 221 */       this.recall_info.add(_v_);
/*     */     }
/* 223 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 224 */       GrcUserBackInfo _v_ = new GrcUserBackInfo();
/* 225 */       _v_.unmarshal(_os_);
/* 226 */       this.back_info.add(_v_);
/*     */     }
/* 228 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 229 */       GrcBindRewardInfo _v_ = new GrcBindRewardInfo();
/* 230 */       _v_.unmarshal(_os_);
/* 231 */       this.bind_reward_info.add(_v_);
/*     */     }
/* 233 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 234 */       GrcBindFriendVitalityInfo _v_ = new GrcBindFriendVitalityInfo();
/* 235 */       _v_.unmarshal(_os_);
/* 236 */       this.recall_bind_info.add(_v_);
/*     */     }
/* 238 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 239 */       GrcBindFriendVitalityInfo _v_ = new GrcBindFriendVitalityInfo();
/* 240 */       _v_.unmarshal(_os_);
/* 241 */       this.back_bind_info.add(_v_);
/*     */     }
/* 243 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 244 */       GrcRoleInfo _v_ = new GrcRoleInfo();
/* 245 */       _v_.unmarshal(_os_);
/* 246 */       this.role_vitality_info.add(_v_);
/*     */     }
/* 248 */     this.reserved1 = _os_.unmarshal_int();
/* 249 */     this.reserved2 = _os_.unmarshal_int();
/* 250 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 254 */     if (_o1_ == this) return true;
/* 255 */     if ((_o1_ instanceof GrcUserLoginRes)) {
/* 256 */       GrcUserLoginRes _o_ = (GrcUserLoginRes)_o1_;
/* 257 */       if (this.retcode != _o_.retcode) return false;
/* 258 */       if (!this.qq_vip_infos.equals(_o_.qq_vip_infos)) return false;
/* 259 */       if (this.friend_total_count != _o_.friend_total_count) return false;
/* 260 */       if (!this.friends.equals(_o_.friends)) return false;
/* 261 */       if (!this.user_send_gift_infos.equals(_o_.user_send_gift_infos)) return false;
/* 262 */       if (!this.user_receive_gift_times_infos.equals(_o_.user_receive_gift_times_infos)) return false;
/* 263 */       if (!this.user_receive_gift_meta_infos.equals(_o_.user_receive_gift_meta_infos)) return false;
/* 264 */       if (this.receive_gift_total_count != _o_.receive_gift_total_count) return false;
/* 265 */       if (!this.receive_gift_infos.equals(_o_.receive_gift_infos)) return false;
/* 266 */       if (!this.profile_info.equals(_o_.profile_info)) return false;
/* 267 */       if (!this.recall_friends.equals(_o_.recall_friends)) return false;
/* 268 */       if (!this.recall_info.equals(_o_.recall_info)) return false;
/* 269 */       if (!this.back_info.equals(_o_.back_info)) return false;
/* 270 */       if (!this.bind_reward_info.equals(_o_.bind_reward_info)) return false;
/* 271 */       if (!this.recall_bind_info.equals(_o_.recall_bind_info)) return false;
/* 272 */       if (!this.back_bind_info.equals(_o_.back_bind_info)) return false;
/* 273 */       if (!this.role_vitality_info.equals(_o_.role_vitality_info)) return false;
/* 274 */       if (this.reserved1 != _o_.reserved1) return false;
/* 275 */       if (this.reserved2 != _o_.reserved2) return false;
/* 276 */       return true;
/*     */     }
/* 278 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 282 */     int _h_ = 0;
/* 283 */     _h_ += this.retcode;
/* 284 */     _h_ += this.qq_vip_infos.hashCode();
/* 285 */     _h_ += this.friend_total_count;
/* 286 */     _h_ += this.friends.hashCode();
/* 287 */     _h_ += this.user_send_gift_infos.hashCode();
/* 288 */     _h_ += this.user_receive_gift_times_infos.hashCode();
/* 289 */     _h_ += this.user_receive_gift_meta_infos.hashCode();
/* 290 */     _h_ += this.receive_gift_total_count;
/* 291 */     _h_ += this.receive_gift_infos.hashCode();
/* 292 */     _h_ += this.profile_info.hashCode();
/* 293 */     _h_ += this.recall_friends.hashCode();
/* 294 */     _h_ += this.recall_info.hashCode();
/* 295 */     _h_ += this.back_info.hashCode();
/* 296 */     _h_ += this.bind_reward_info.hashCode();
/* 297 */     _h_ += this.recall_bind_info.hashCode();
/* 298 */     _h_ += this.back_bind_info.hashCode();
/* 299 */     _h_ += this.role_vitality_info.hashCode();
/* 300 */     _h_ += this.reserved1;
/* 301 */     _h_ += this.reserved2;
/* 302 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 306 */     StringBuilder _sb_ = new StringBuilder();
/* 307 */     _sb_.append("(");
/* 308 */     _sb_.append(this.retcode).append(",");
/* 309 */     _sb_.append(this.qq_vip_infos).append(",");
/* 310 */     _sb_.append(this.friend_total_count).append(",");
/* 311 */     _sb_.append(this.friends).append(",");
/* 312 */     _sb_.append(this.user_send_gift_infos).append(",");
/* 313 */     _sb_.append(this.user_receive_gift_times_infos).append(",");
/* 314 */     _sb_.append(this.user_receive_gift_meta_infos).append(",");
/* 315 */     _sb_.append(this.receive_gift_total_count).append(",");
/* 316 */     _sb_.append(this.receive_gift_infos).append(",");
/* 317 */     _sb_.append(this.profile_info).append(",");
/* 318 */     _sb_.append(this.recall_friends).append(",");
/* 319 */     _sb_.append(this.recall_info).append(",");
/* 320 */     _sb_.append(this.back_info).append(",");
/* 321 */     _sb_.append(this.bind_reward_info).append(",");
/* 322 */     _sb_.append(this.recall_bind_info).append(",");
/* 323 */     _sb_.append(this.back_bind_info).append(",");
/* 324 */     _sb_.append(this.role_vitality_info).append(",");
/* 325 */     _sb_.append(this.reserved1).append(",");
/* 326 */     _sb_.append(this.reserved2).append(",");
/* 327 */     _sb_.append(")");
/* 328 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcUserLoginRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */