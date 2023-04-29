/*     */ package mzm.gsp.grc;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ public class GrcFriendInfo implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public static final int LOGIN_PRIVILEGE_NONE = 0;
/*     */   public static final int LOGIN_PRIVILEGE_QQ_GAME_CENTER = 1;
/*     */   public static final int LOGIN_PRIVILEGE_WECHAT_GAME_CENTER = 2;
/*     */   public static final int LOGIN_PRIVILEGE_YYB = 3;
/*     */   public static final int RECALL_CAN_NOT = 0;
/*     */   public static final int RECALL_CAN = 1;
/*     */   public static final int RECALL_ALEARDY = 2;
/*     */   public Octets openid;
/*     */   public Octets nickname;
/*     */   public Octets figure_url;
/*     */   public long roleid;
/*     */   public Octets rolename;
/*     */   public int level;
/*     */   public int gender;
/*     */   public int occupation;
/*     */   public int avatarid;
/*     */   public int avatar_frameid;
/*     */   public long fighting_capacity;
/*     */   public int zoneid;
/*     */   public int login_privilege;
/*     */   public HashMap<Integer, QQVipInfo> qq_vip_infos;
/*     */   public Octets wechat_vip_infos;
/*     */   public int recall_state;
/*     */   
/*     */   public GrcFriendInfo()
/*     */   {
/*  35 */     this.openid = new Octets();
/*  36 */     this.nickname = new Octets();
/*  37 */     this.figure_url = new Octets();
/*  38 */     this.rolename = new Octets();
/*  39 */     this.login_privilege = 0;
/*  40 */     this.qq_vip_infos = new HashMap();
/*  41 */     this.wechat_vip_infos = new Octets();
/*     */   }
/*     */   
/*     */   public GrcFriendInfo(Octets _openid_, Octets _nickname_, Octets _figure_url_, long _roleid_, Octets _rolename_, int _level_, int _gender_, int _occupation_, int _avatarid_, int _avatar_frameid_, long _fighting_capacity_, int _zoneid_, int _login_privilege_, HashMap<Integer, QQVipInfo> _qq_vip_infos_, Octets _wechat_vip_infos_, int _recall_state_) {
/*  45 */     this.openid = _openid_;
/*  46 */     this.nickname = _nickname_;
/*  47 */     this.figure_url = _figure_url_;
/*  48 */     this.roleid = _roleid_;
/*  49 */     this.rolename = _rolename_;
/*  50 */     this.level = _level_;
/*  51 */     this.gender = _gender_;
/*  52 */     this.occupation = _occupation_;
/*  53 */     this.avatarid = _avatarid_;
/*  54 */     this.avatar_frameid = _avatar_frameid_;
/*  55 */     this.fighting_capacity = _fighting_capacity_;
/*  56 */     this.zoneid = _zoneid_;
/*  57 */     this.login_privilege = _login_privilege_;
/*  58 */     this.qq_vip_infos = _qq_vip_infos_;
/*  59 */     this.wechat_vip_infos = _wechat_vip_infos_;
/*  60 */     this.recall_state = _recall_state_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  64 */     for (java.util.Map.Entry<Integer, QQVipInfo> _e_ : this.qq_vip_infos.entrySet()) {
/*  65 */       if (!((QQVipInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  67 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  71 */     _os_.marshal(this.openid);
/*  72 */     _os_.marshal(this.nickname);
/*  73 */     _os_.marshal(this.figure_url);
/*  74 */     _os_.marshal(this.roleid);
/*  75 */     _os_.marshal(this.rolename);
/*  76 */     _os_.marshal(this.level);
/*  77 */     _os_.marshal(this.gender);
/*  78 */     _os_.marshal(this.occupation);
/*  79 */     _os_.marshal(this.avatarid);
/*  80 */     _os_.marshal(this.avatar_frameid);
/*  81 */     _os_.marshal(this.fighting_capacity);
/*  82 */     _os_.marshal(this.zoneid);
/*  83 */     _os_.marshal(this.login_privilege);
/*  84 */     _os_.compact_uint32(this.qq_vip_infos.size());
/*  85 */     for (java.util.Map.Entry<Integer, QQVipInfo> _e_ : this.qq_vip_infos.entrySet()) {
/*  86 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  87 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/*  89 */     _os_.marshal(this.wechat_vip_infos);
/*  90 */     _os_.marshal(this.recall_state);
/*  91 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  95 */     this.openid = _os_.unmarshal_Octets();
/*  96 */     this.nickname = _os_.unmarshal_Octets();
/*  97 */     this.figure_url = _os_.unmarshal_Octets();
/*  98 */     this.roleid = _os_.unmarshal_long();
/*  99 */     this.rolename = _os_.unmarshal_Octets();
/* 100 */     this.level = _os_.unmarshal_int();
/* 101 */     this.gender = _os_.unmarshal_int();
/* 102 */     this.occupation = _os_.unmarshal_int();
/* 103 */     this.avatarid = _os_.unmarshal_int();
/* 104 */     this.avatar_frameid = _os_.unmarshal_int();
/* 105 */     this.fighting_capacity = _os_.unmarshal_long();
/* 106 */     this.zoneid = _os_.unmarshal_int();
/* 107 */     this.login_privilege = _os_.unmarshal_int();
/* 108 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 110 */       int _k_ = _os_.unmarshal_int();
/* 111 */       QQVipInfo _v_ = new QQVipInfo();
/* 112 */       _v_.unmarshal(_os_);
/* 113 */       this.qq_vip_infos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 115 */     this.wechat_vip_infos = _os_.unmarshal_Octets();
/* 116 */     this.recall_state = _os_.unmarshal_int();
/* 117 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 121 */     if (_o1_ == this) return true;
/* 122 */     if ((_o1_ instanceof GrcFriendInfo)) {
/* 123 */       GrcFriendInfo _o_ = (GrcFriendInfo)_o1_;
/* 124 */       if (!this.openid.equals(_o_.openid)) return false;
/* 125 */       if (!this.nickname.equals(_o_.nickname)) return false;
/* 126 */       if (!this.figure_url.equals(_o_.figure_url)) return false;
/* 127 */       if (this.roleid != _o_.roleid) return false;
/* 128 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 129 */       if (this.level != _o_.level) return false;
/* 130 */       if (this.gender != _o_.gender) return false;
/* 131 */       if (this.occupation != _o_.occupation) return false;
/* 132 */       if (this.avatarid != _o_.avatarid) return false;
/* 133 */       if (this.avatar_frameid != _o_.avatar_frameid) return false;
/* 134 */       if (this.fighting_capacity != _o_.fighting_capacity) return false;
/* 135 */       if (this.zoneid != _o_.zoneid) return false;
/* 136 */       if (this.login_privilege != _o_.login_privilege) return false;
/* 137 */       if (!this.qq_vip_infos.equals(_o_.qq_vip_infos)) return false;
/* 138 */       if (!this.wechat_vip_infos.equals(_o_.wechat_vip_infos)) return false;
/* 139 */       if (this.recall_state != _o_.recall_state) return false;
/* 140 */       return true;
/*     */     }
/* 142 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 146 */     int _h_ = 0;
/* 147 */     _h_ += this.openid.hashCode();
/* 148 */     _h_ += this.nickname.hashCode();
/* 149 */     _h_ += this.figure_url.hashCode();
/* 150 */     _h_ += (int)this.roleid;
/* 151 */     _h_ += this.rolename.hashCode();
/* 152 */     _h_ += this.level;
/* 153 */     _h_ += this.gender;
/* 154 */     _h_ += this.occupation;
/* 155 */     _h_ += this.avatarid;
/* 156 */     _h_ += this.avatar_frameid;
/* 157 */     _h_ += (int)this.fighting_capacity;
/* 158 */     _h_ += this.zoneid;
/* 159 */     _h_ += this.login_privilege;
/* 160 */     _h_ += this.qq_vip_infos.hashCode();
/* 161 */     _h_ += this.wechat_vip_infos.hashCode();
/* 162 */     _h_ += this.recall_state;
/* 163 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 167 */     StringBuilder _sb_ = new StringBuilder();
/* 168 */     _sb_.append("(");
/* 169 */     _sb_.append("B").append(this.openid.size()).append(",");
/* 170 */     _sb_.append("B").append(this.nickname.size()).append(",");
/* 171 */     _sb_.append("B").append(this.figure_url.size()).append(",");
/* 172 */     _sb_.append(this.roleid).append(",");
/* 173 */     _sb_.append("B").append(this.rolename.size()).append(",");
/* 174 */     _sb_.append(this.level).append(",");
/* 175 */     _sb_.append(this.gender).append(",");
/* 176 */     _sb_.append(this.occupation).append(",");
/* 177 */     _sb_.append(this.avatarid).append(",");
/* 178 */     _sb_.append(this.avatar_frameid).append(",");
/* 179 */     _sb_.append(this.fighting_capacity).append(",");
/* 180 */     _sb_.append(this.zoneid).append(",");
/* 181 */     _sb_.append(this.login_privilege).append(",");
/* 182 */     _sb_.append(this.qq_vip_infos).append(",");
/* 183 */     _sb_.append("B").append(this.wechat_vip_infos.size()).append(",");
/* 184 */     _sb_.append(this.recall_state).append(",");
/* 185 */     _sb_.append(")");
/* 186 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\GrcFriendInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */