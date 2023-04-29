/*     */ package grc;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ public class GrcUserInfo implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public static final int LOGIN_PRIVILEGE_NONE = 0;
/*     */   public static final int LOGIN_PRIVILEGE_QQ_GAME_CENTER = 1;
/*     */   public static final int LOGIN_PRIVILEGE_WECHAT_GAME_CENTER = 2;
/*     */   public static final int LOGIN_PRIVILEGE_YYB = 3;
/*     */   public Octets openid;
/*     */   public Octets channel;
/*     */   public Octets nickname;
/*     */   public int gender;
/*     */   public Octets figure_url;
/*     */   public Octets province;
/*     */   public Octets city;
/*     */   public int login_privilege;
/*     */   public HashMap<Integer, QQVipInfo> qq_vip_infos;
/*     */   public Octets wechat_vip_infos;
/*     */   public GrcRoleInfo roleinfo;
/*     */   
/*     */   public GrcUserInfo()
/*     */   {
/*  27 */     this.openid = new Octets();
/*  28 */     this.channel = new Octets();
/*  29 */     this.nickname = new Octets();
/*  30 */     this.figure_url = new Octets();
/*  31 */     this.province = new Octets();
/*  32 */     this.city = new Octets();
/*  33 */     this.login_privilege = 0;
/*  34 */     this.qq_vip_infos = new HashMap();
/*  35 */     this.wechat_vip_infos = new Octets();
/*  36 */     this.roleinfo = new GrcRoleInfo();
/*     */   }
/*     */   
/*     */   public GrcUserInfo(Octets _openid_, Octets _channel_, Octets _nickname_, int _gender_, Octets _figure_url_, Octets _province_, Octets _city_, int _login_privilege_, HashMap<Integer, QQVipInfo> _qq_vip_infos_, Octets _wechat_vip_infos_, GrcRoleInfo _roleinfo_) {
/*  40 */     this.openid = _openid_;
/*  41 */     this.channel = _channel_;
/*  42 */     this.nickname = _nickname_;
/*  43 */     this.gender = _gender_;
/*  44 */     this.figure_url = _figure_url_;
/*  45 */     this.province = _province_;
/*  46 */     this.city = _city_;
/*  47 */     this.login_privilege = _login_privilege_;
/*  48 */     this.qq_vip_infos = _qq_vip_infos_;
/*  49 */     this.wechat_vip_infos = _wechat_vip_infos_;
/*  50 */     this.roleinfo = _roleinfo_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  54 */     for (java.util.Map.Entry<Integer, QQVipInfo> _e_ : this.qq_vip_infos.entrySet()) {
/*  55 */       if (!((QQVipInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  57 */     if (!this.roleinfo._validator_()) return false;
/*  58 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  62 */     _os_.marshal(this.openid);
/*  63 */     _os_.marshal(this.channel);
/*  64 */     _os_.marshal(this.nickname);
/*  65 */     _os_.marshal(this.gender);
/*  66 */     _os_.marshal(this.figure_url);
/*  67 */     _os_.marshal(this.province);
/*  68 */     _os_.marshal(this.city);
/*  69 */     _os_.marshal(this.login_privilege);
/*  70 */     _os_.compact_uint32(this.qq_vip_infos.size());
/*  71 */     for (java.util.Map.Entry<Integer, QQVipInfo> _e_ : this.qq_vip_infos.entrySet()) {
/*  72 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  73 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/*  75 */     _os_.marshal(this.wechat_vip_infos);
/*  76 */     _os_.marshal(this.roleinfo);
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  81 */     this.openid = _os_.unmarshal_Octets();
/*  82 */     this.channel = _os_.unmarshal_Octets();
/*  83 */     this.nickname = _os_.unmarshal_Octets();
/*  84 */     this.gender = _os_.unmarshal_int();
/*  85 */     this.figure_url = _os_.unmarshal_Octets();
/*  86 */     this.province = _os_.unmarshal_Octets();
/*  87 */     this.city = _os_.unmarshal_Octets();
/*  88 */     this.login_privilege = _os_.unmarshal_int();
/*  89 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  91 */       int _k_ = _os_.unmarshal_int();
/*  92 */       QQVipInfo _v_ = new QQVipInfo();
/*  93 */       _v_.unmarshal(_os_);
/*  94 */       this.qq_vip_infos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  96 */     this.wechat_vip_infos = _os_.unmarshal_Octets();
/*  97 */     this.roleinfo.unmarshal(_os_);
/*  98 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 102 */     if (_o1_ == this) return true;
/* 103 */     if ((_o1_ instanceof GrcUserInfo)) {
/* 104 */       GrcUserInfo _o_ = (GrcUserInfo)_o1_;
/* 105 */       if (!this.openid.equals(_o_.openid)) return false;
/* 106 */       if (!this.channel.equals(_o_.channel)) return false;
/* 107 */       if (!this.nickname.equals(_o_.nickname)) return false;
/* 108 */       if (this.gender != _o_.gender) return false;
/* 109 */       if (!this.figure_url.equals(_o_.figure_url)) return false;
/* 110 */       if (!this.province.equals(_o_.province)) return false;
/* 111 */       if (!this.city.equals(_o_.city)) return false;
/* 112 */       if (this.login_privilege != _o_.login_privilege) return false;
/* 113 */       if (!this.qq_vip_infos.equals(_o_.qq_vip_infos)) return false;
/* 114 */       if (!this.wechat_vip_infos.equals(_o_.wechat_vip_infos)) return false;
/* 115 */       if (!this.roleinfo.equals(_o_.roleinfo)) return false;
/* 116 */       return true;
/*     */     }
/* 118 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 122 */     int _h_ = 0;
/* 123 */     _h_ += this.openid.hashCode();
/* 124 */     _h_ += this.channel.hashCode();
/* 125 */     _h_ += this.nickname.hashCode();
/* 126 */     _h_ += this.gender;
/* 127 */     _h_ += this.figure_url.hashCode();
/* 128 */     _h_ += this.province.hashCode();
/* 129 */     _h_ += this.city.hashCode();
/* 130 */     _h_ += this.login_privilege;
/* 131 */     _h_ += this.qq_vip_infos.hashCode();
/* 132 */     _h_ += this.wechat_vip_infos.hashCode();
/* 133 */     _h_ += this.roleinfo.hashCode();
/* 134 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 138 */     StringBuilder _sb_ = new StringBuilder();
/* 139 */     _sb_.append("(");
/* 140 */     _sb_.append("B").append(this.openid.size()).append(",");
/* 141 */     _sb_.append("B").append(this.channel.size()).append(",");
/* 142 */     _sb_.append("B").append(this.nickname.size()).append(",");
/* 143 */     _sb_.append(this.gender).append(",");
/* 144 */     _sb_.append("B").append(this.figure_url.size()).append(",");
/* 145 */     _sb_.append("B").append(this.province.size()).append(",");
/* 146 */     _sb_.append("B").append(this.city.size()).append(",");
/* 147 */     _sb_.append(this.login_privilege).append(",");
/* 148 */     _sb_.append(this.qq_vip_infos).append(",");
/* 149 */     _sb_.append("B").append(this.wechat_vip_infos.size()).append(",");
/* 150 */     _sb_.append(this.roleinfo).append(",");
/* 151 */     _sb_.append(")");
/* 152 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcUserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */