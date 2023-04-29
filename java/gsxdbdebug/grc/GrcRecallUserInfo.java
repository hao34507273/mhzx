/*     */ package grc;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ public class GrcRecallUserInfo implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public static final int LOGIN_PRIVILEGE_NONE = 0;
/*     */   public static final int LOGIN_PRIVILEGE_QQ_GAME_CENTER = 1;
/*     */   public static final int LOGIN_PRIVILEGE_WECHAT_GAME_CENTER = 2;
/*     */   public static final int LOGIN_PRIVILEGE_YYB = 3;
/*     */   public Octets openid;
/*     */   public Octets nickname;
/*     */   public Octets figure_url;
/*     */   public long login_time;
/*     */   public int login_privilege;
/*     */   public HashMap<Integer, QQVipInfo> qq_vip_infos;
/*     */   
/*     */   public GrcRecallUserInfo()
/*     */   {
/*  22 */     this.openid = new Octets();
/*  23 */     this.nickname = new Octets();
/*  24 */     this.figure_url = new Octets();
/*  25 */     this.login_privilege = 0;
/*  26 */     this.qq_vip_infos = new HashMap();
/*     */   }
/*     */   
/*     */   public GrcRecallUserInfo(Octets _openid_, Octets _nickname_, Octets _figure_url_, long _login_time_, int _login_privilege_, HashMap<Integer, QQVipInfo> _qq_vip_infos_) {
/*  30 */     this.openid = _openid_;
/*  31 */     this.nickname = _nickname_;
/*  32 */     this.figure_url = _figure_url_;
/*  33 */     this.login_time = _login_time_;
/*  34 */     this.login_privilege = _login_privilege_;
/*  35 */     this.qq_vip_infos = _qq_vip_infos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  39 */     for (java.util.Map.Entry<Integer, QQVipInfo> _e_ : this.qq_vip_infos.entrySet()) {
/*  40 */       if (!((QQVipInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  42 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  46 */     _os_.marshal(this.openid);
/*  47 */     _os_.marshal(this.nickname);
/*  48 */     _os_.marshal(this.figure_url);
/*  49 */     _os_.marshal(this.login_time);
/*  50 */     _os_.marshal(this.login_privilege);
/*  51 */     _os_.compact_uint32(this.qq_vip_infos.size());
/*  52 */     for (java.util.Map.Entry<Integer, QQVipInfo> _e_ : this.qq_vip_infos.entrySet()) {
/*  53 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  54 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  60 */     this.openid = _os_.unmarshal_Octets();
/*  61 */     this.nickname = _os_.unmarshal_Octets();
/*  62 */     this.figure_url = _os_.unmarshal_Octets();
/*  63 */     this.login_time = _os_.unmarshal_long();
/*  64 */     this.login_privilege = _os_.unmarshal_int();
/*  65 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  67 */       int _k_ = _os_.unmarshal_int();
/*  68 */       QQVipInfo _v_ = new QQVipInfo();
/*  69 */       _v_.unmarshal(_os_);
/*  70 */       this.qq_vip_infos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof GrcRecallUserInfo)) {
/*  78 */       GrcRecallUserInfo _o_ = (GrcRecallUserInfo)_o1_;
/*  79 */       if (!this.openid.equals(_o_.openid)) return false;
/*  80 */       if (!this.nickname.equals(_o_.nickname)) return false;
/*  81 */       if (!this.figure_url.equals(_o_.figure_url)) return false;
/*  82 */       if (this.login_time != _o_.login_time) return false;
/*  83 */       if (this.login_privilege != _o_.login_privilege) return false;
/*  84 */       if (!this.qq_vip_infos.equals(_o_.qq_vip_infos)) return false;
/*  85 */       return true;
/*     */     }
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  91 */     int _h_ = 0;
/*  92 */     _h_ += this.openid.hashCode();
/*  93 */     _h_ += this.nickname.hashCode();
/*  94 */     _h_ += this.figure_url.hashCode();
/*  95 */     _h_ += (int)this.login_time;
/*  96 */     _h_ += this.login_privilege;
/*  97 */     _h_ += this.qq_vip_infos.hashCode();
/*  98 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 102 */     StringBuilder _sb_ = new StringBuilder();
/* 103 */     _sb_.append("(");
/* 104 */     _sb_.append("B").append(this.openid.size()).append(",");
/* 105 */     _sb_.append("B").append(this.nickname.size()).append(",");
/* 106 */     _sb_.append("B").append(this.figure_url.size()).append(",");
/* 107 */     _sb_.append(this.login_time).append(",");
/* 108 */     _sb_.append(this.login_privilege).append(",");
/* 109 */     _sb_.append(this.qq_vip_infos).append(",");
/* 110 */     _sb_.append(")");
/* 111 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcRecallUserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */