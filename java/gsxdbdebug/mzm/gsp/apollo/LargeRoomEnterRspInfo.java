/*     */ package mzm.gsp.apollo;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class LargeRoomEnterRspInfo implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public long gid;
/*     */   public long roomid;
/*     */   public long roomkey;
/*     */   public int memberid;
/*     */   public int user_openid;
/*     */   public Octets user_ip;
/*     */   public Octets user_access;
/*     */   public int entrypt_switch;
/*     */   public int mix_voice_ability;
/*     */   public Octets uuid;
/*     */   
/*     */   public LargeRoomEnterRspInfo()
/*     */   {
/*  21 */     this.gid = 0L;
/*  22 */     this.roomid = 0L;
/*  23 */     this.roomkey = 0L;
/*  24 */     this.memberid = 0;
/*  25 */     this.user_openid = 0;
/*  26 */     this.user_ip = new Octets();
/*  27 */     this.user_access = new Octets();
/*  28 */     this.entrypt_switch = 0;
/*  29 */     this.mix_voice_ability = 0;
/*  30 */     this.uuid = new Octets();
/*     */   }
/*     */   
/*     */   public LargeRoomEnterRspInfo(long _gid_, long _roomid_, long _roomkey_, int _memberid_, int _user_openid_, Octets _user_ip_, Octets _user_access_, int _entrypt_switch_, int _mix_voice_ability_, Octets _uuid_) {
/*  34 */     this.gid = _gid_;
/*  35 */     this.roomid = _roomid_;
/*  36 */     this.roomkey = _roomkey_;
/*  37 */     this.memberid = _memberid_;
/*  38 */     this.user_openid = _user_openid_;
/*  39 */     this.user_ip = _user_ip_;
/*  40 */     this.user_access = _user_access_;
/*  41 */     this.entrypt_switch = _entrypt_switch_;
/*  42 */     this.mix_voice_ability = _mix_voice_ability_;
/*  43 */     this.uuid = _uuid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.gid);
/*  52 */     _os_.marshal(this.roomid);
/*  53 */     _os_.marshal(this.roomkey);
/*  54 */     _os_.marshal(this.memberid);
/*  55 */     _os_.marshal(this.user_openid);
/*  56 */     _os_.marshal(this.user_ip);
/*  57 */     _os_.marshal(this.user_access);
/*  58 */     _os_.marshal(this.entrypt_switch);
/*  59 */     _os_.marshal(this.mix_voice_ability);
/*  60 */     _os_.marshal(this.uuid);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  65 */     this.gid = _os_.unmarshal_long();
/*  66 */     this.roomid = _os_.unmarshal_long();
/*  67 */     this.roomkey = _os_.unmarshal_long();
/*  68 */     this.memberid = _os_.unmarshal_int();
/*  69 */     this.user_openid = _os_.unmarshal_int();
/*  70 */     this.user_ip = _os_.unmarshal_Octets();
/*  71 */     this.user_access = _os_.unmarshal_Octets();
/*  72 */     this.entrypt_switch = _os_.unmarshal_int();
/*  73 */     this.mix_voice_ability = _os_.unmarshal_int();
/*  74 */     this.uuid = _os_.unmarshal_Octets();
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof LargeRoomEnterRspInfo)) {
/*  81 */       LargeRoomEnterRspInfo _o_ = (LargeRoomEnterRspInfo)_o1_;
/*  82 */       if (this.gid != _o_.gid) return false;
/*  83 */       if (this.roomid != _o_.roomid) return false;
/*  84 */       if (this.roomkey != _o_.roomkey) return false;
/*  85 */       if (this.memberid != _o_.memberid) return false;
/*  86 */       if (this.user_openid != _o_.user_openid) return false;
/*  87 */       if (!this.user_ip.equals(_o_.user_ip)) return false;
/*  88 */       if (!this.user_access.equals(_o_.user_access)) return false;
/*  89 */       if (this.entrypt_switch != _o_.entrypt_switch) return false;
/*  90 */       if (this.mix_voice_ability != _o_.mix_voice_ability) return false;
/*  91 */       if (!this.uuid.equals(_o_.uuid)) return false;
/*  92 */       return true;
/*     */     }
/*  94 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  98 */     int _h_ = 0;
/*  99 */     _h_ += (int)this.gid;
/* 100 */     _h_ += (int)this.roomid;
/* 101 */     _h_ += (int)this.roomkey;
/* 102 */     _h_ += this.memberid;
/* 103 */     _h_ += this.user_openid;
/* 104 */     _h_ += this.user_ip.hashCode();
/* 105 */     _h_ += this.user_access.hashCode();
/* 106 */     _h_ += this.entrypt_switch;
/* 107 */     _h_ += this.mix_voice_ability;
/* 108 */     _h_ += this.uuid.hashCode();
/* 109 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 113 */     StringBuilder _sb_ = new StringBuilder();
/* 114 */     _sb_.append("(");
/* 115 */     _sb_.append(this.gid).append(",");
/* 116 */     _sb_.append(this.roomid).append(",");
/* 117 */     _sb_.append(this.roomkey).append(",");
/* 118 */     _sb_.append(this.memberid).append(",");
/* 119 */     _sb_.append(this.user_openid).append(",");
/* 120 */     _sb_.append("B").append(this.user_ip.size()).append(",");
/* 121 */     _sb_.append("B").append(this.user_access.size()).append(",");
/* 122 */     _sb_.append(this.entrypt_switch).append(",");
/* 123 */     _sb_.append(this.mix_voice_ability).append(",");
/* 124 */     _sb_.append("B").append(this.uuid.size()).append(",");
/* 125 */     _sb_.append(")");
/* 126 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\LargeRoomEnterRspInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */