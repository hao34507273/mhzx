/*     */ package mzm.gsp.grc;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class RecallUserInfo implements Marshal
/*     */ {
/*     */   public static final int LOGIN_PRIVILEGE_NONE = 0;
/*     */   public static final int LOGIN_PRIVILEGE_QQ_GAME_CENTER = 1;
/*     */   public static final int LOGIN_PRIVILEGE_WECHAT_GAME_CENTER = 2;
/*     */   public static final int LOGIN_PRIVILEGE_YYB = 3;
/*     */   public Octets openid;
/*     */   public Octets nickname;
/*     */   public Octets figure_url;
/*     */   public int last_login;
/*     */   public int login_privilege;
/*     */   public HashMap<Integer, QQVipInfo> qq_vip_infos;
/*     */   
/*     */   public RecallUserInfo()
/*     */   {
/*  24 */     this.openid = new Octets();
/*  25 */     this.nickname = new Octets();
/*  26 */     this.figure_url = new Octets();
/*  27 */     this.login_privilege = 0;
/*  28 */     this.qq_vip_infos = new HashMap();
/*     */   }
/*     */   
/*     */   public RecallUserInfo(Octets _openid_, Octets _nickname_, Octets _figure_url_, int _last_login_, int _login_privilege_, HashMap<Integer, QQVipInfo> _qq_vip_infos_) {
/*  32 */     this.openid = _openid_;
/*  33 */     this.nickname = _nickname_;
/*  34 */     this.figure_url = _figure_url_;
/*  35 */     this.last_login = _last_login_;
/*  36 */     this.login_privilege = _login_privilege_;
/*  37 */     this.qq_vip_infos = _qq_vip_infos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  41 */     for (Map.Entry<Integer, QQVipInfo> _e_ : this.qq_vip_infos.entrySet()) {
/*  42 */       if (!((QQVipInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.openid);
/*  49 */     _os_.marshal(this.nickname);
/*  50 */     _os_.marshal(this.figure_url);
/*  51 */     _os_.marshal(this.last_login);
/*  52 */     _os_.marshal(this.login_privilege);
/*  53 */     _os_.compact_uint32(this.qq_vip_infos.size());
/*  54 */     for (Map.Entry<Integer, QQVipInfo> _e_ : this.qq_vip_infos.entrySet()) {
/*  55 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  56 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  62 */     this.openid = _os_.unmarshal_Octets();
/*  63 */     this.nickname = _os_.unmarshal_Octets();
/*  64 */     this.figure_url = _os_.unmarshal_Octets();
/*  65 */     this.last_login = _os_.unmarshal_int();
/*  66 */     this.login_privilege = _os_.unmarshal_int();
/*  67 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  69 */       int _k_ = _os_.unmarshal_int();
/*  70 */       QQVipInfo _v_ = new QQVipInfo();
/*  71 */       _v_.unmarshal(_os_);
/*  72 */       this.qq_vip_infos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  78 */     if (_o1_ == this) return true;
/*  79 */     if ((_o1_ instanceof RecallUserInfo)) {
/*  80 */       RecallUserInfo _o_ = (RecallUserInfo)_o1_;
/*  81 */       if (!this.openid.equals(_o_.openid)) return false;
/*  82 */       if (!this.nickname.equals(_o_.nickname)) return false;
/*  83 */       if (!this.figure_url.equals(_o_.figure_url)) return false;
/*  84 */       if (this.last_login != _o_.last_login) return false;
/*  85 */       if (this.login_privilege != _o_.login_privilege) return false;
/*  86 */       if (!this.qq_vip_infos.equals(_o_.qq_vip_infos)) return false;
/*  87 */       return true;
/*     */     }
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  93 */     int _h_ = 0;
/*  94 */     _h_ += this.openid.hashCode();
/*  95 */     _h_ += this.nickname.hashCode();
/*  96 */     _h_ += this.figure_url.hashCode();
/*  97 */     _h_ += this.last_login;
/*  98 */     _h_ += this.login_privilege;
/*  99 */     _h_ += this.qq_vip_infos.hashCode();
/* 100 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 104 */     StringBuilder _sb_ = new StringBuilder();
/* 105 */     _sb_.append("(");
/* 106 */     _sb_.append("B").append(this.openid.size()).append(",");
/* 107 */     _sb_.append("B").append(this.nickname.size()).append(",");
/* 108 */     _sb_.append("B").append(this.figure_url.size()).append(",");
/* 109 */     _sb_.append(this.last_login).append(",");
/* 110 */     _sb_.append(this.login_privilege).append(",");
/* 111 */     _sb_.append(this.qq_vip_infos).append(",");
/* 112 */     _sb_.append(")");
/* 113 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\RecallUserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */