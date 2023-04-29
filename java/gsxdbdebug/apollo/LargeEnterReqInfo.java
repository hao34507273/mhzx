/*     */ package apollo;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class LargeEnterReqInfo implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public long roomid;
/*     */   public long roomkey;
/*     */   public int memberid;
/*     */   public int user_openid;
/*     */   public Octets user_ip;
/*     */   public int dump_switch;
/*     */   public int client_link_info_report_switch;
/*     */   public int user_ability;
/*     */   public int mix_voice_ability;
/*     */   public int net_type;
/*     */   public long gid;
/*     */   public Octets uuid;
/*     */   public int member_type;
/*     */   
/*     */   public LargeEnterReqInfo()
/*     */   {
/*  24 */     this.roomid = 0L;
/*  25 */     this.roomkey = 0L;
/*  26 */     this.memberid = 0;
/*  27 */     this.user_openid = 0;
/*  28 */     this.user_ip = new Octets();
/*  29 */     this.dump_switch = 0;
/*  30 */     this.client_link_info_report_switch = 0;
/*  31 */     this.user_ability = 0;
/*  32 */     this.mix_voice_ability = 0;
/*  33 */     this.net_type = 0;
/*  34 */     this.gid = 0L;
/*  35 */     this.uuid = new Octets();
/*  36 */     this.member_type = 2;
/*     */   }
/*     */   
/*     */   public LargeEnterReqInfo(long _roomid_, long _roomkey_, int _memberid_, int _user_openid_, Octets _user_ip_, int _dump_switch_, int _client_link_info_report_switch_, int _user_ability_, int _mix_voice_ability_, int _net_type_, long _gid_, Octets _uuid_, int _member_type_) {
/*  40 */     this.roomid = _roomid_;
/*  41 */     this.roomkey = _roomkey_;
/*  42 */     this.memberid = _memberid_;
/*  43 */     this.user_openid = _user_openid_;
/*  44 */     this.user_ip = _user_ip_;
/*  45 */     this.dump_switch = _dump_switch_;
/*  46 */     this.client_link_info_report_switch = _client_link_info_report_switch_;
/*  47 */     this.user_ability = _user_ability_;
/*  48 */     this.mix_voice_ability = _mix_voice_ability_;
/*  49 */     this.net_type = _net_type_;
/*  50 */     this.gid = _gid_;
/*  51 */     this.uuid = _uuid_;
/*  52 */     this.member_type = _member_type_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  56 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  60 */     _os_.marshal(this.roomid);
/*  61 */     _os_.marshal(this.roomkey);
/*  62 */     _os_.marshal(this.memberid);
/*  63 */     _os_.marshal(this.user_openid);
/*  64 */     _os_.marshal(this.user_ip);
/*  65 */     _os_.marshal(this.dump_switch);
/*  66 */     _os_.marshal(this.client_link_info_report_switch);
/*  67 */     _os_.marshal(this.user_ability);
/*  68 */     _os_.marshal(this.mix_voice_ability);
/*  69 */     _os_.marshal(this.net_type);
/*  70 */     _os_.marshal(this.gid);
/*  71 */     _os_.marshal(this.uuid);
/*  72 */     _os_.marshal(this.member_type);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  77 */     this.roomid = _os_.unmarshal_long();
/*  78 */     this.roomkey = _os_.unmarshal_long();
/*  79 */     this.memberid = _os_.unmarshal_int();
/*  80 */     this.user_openid = _os_.unmarshal_int();
/*  81 */     this.user_ip = _os_.unmarshal_Octets();
/*  82 */     this.dump_switch = _os_.unmarshal_int();
/*  83 */     this.client_link_info_report_switch = _os_.unmarshal_int();
/*  84 */     this.user_ability = _os_.unmarshal_int();
/*  85 */     this.mix_voice_ability = _os_.unmarshal_int();
/*  86 */     this.net_type = _os_.unmarshal_int();
/*  87 */     this.gid = _os_.unmarshal_long();
/*  88 */     this.uuid = _os_.unmarshal_Octets();
/*  89 */     this.member_type = _os_.unmarshal_int();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  94 */     if (_o1_ == this) return true;
/*  95 */     if ((_o1_ instanceof LargeEnterReqInfo)) {
/*  96 */       LargeEnterReqInfo _o_ = (LargeEnterReqInfo)_o1_;
/*  97 */       if (this.roomid != _o_.roomid) return false;
/*  98 */       if (this.roomkey != _o_.roomkey) return false;
/*  99 */       if (this.memberid != _o_.memberid) return false;
/* 100 */       if (this.user_openid != _o_.user_openid) return false;
/* 101 */       if (!this.user_ip.equals(_o_.user_ip)) return false;
/* 102 */       if (this.dump_switch != _o_.dump_switch) return false;
/* 103 */       if (this.client_link_info_report_switch != _o_.client_link_info_report_switch) return false;
/* 104 */       if (this.user_ability != _o_.user_ability) return false;
/* 105 */       if (this.mix_voice_ability != _o_.mix_voice_ability) return false;
/* 106 */       if (this.net_type != _o_.net_type) return false;
/* 107 */       if (this.gid != _o_.gid) return false;
/* 108 */       if (!this.uuid.equals(_o_.uuid)) return false;
/* 109 */       if (this.member_type != _o_.member_type) return false;
/* 110 */       return true;
/*     */     }
/* 112 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 116 */     int _h_ = 0;
/* 117 */     _h_ += (int)this.roomid;
/* 118 */     _h_ += (int)this.roomkey;
/* 119 */     _h_ += this.memberid;
/* 120 */     _h_ += this.user_openid;
/* 121 */     _h_ += this.user_ip.hashCode();
/* 122 */     _h_ += this.dump_switch;
/* 123 */     _h_ += this.client_link_info_report_switch;
/* 124 */     _h_ += this.user_ability;
/* 125 */     _h_ += this.mix_voice_ability;
/* 126 */     _h_ += this.net_type;
/* 127 */     _h_ += (int)this.gid;
/* 128 */     _h_ += this.uuid.hashCode();
/* 129 */     _h_ += this.member_type;
/* 130 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 134 */     StringBuilder _sb_ = new StringBuilder();
/* 135 */     _sb_.append("(");
/* 136 */     _sb_.append(this.roomid).append(",");
/* 137 */     _sb_.append(this.roomkey).append(",");
/* 138 */     _sb_.append(this.memberid).append(",");
/* 139 */     _sb_.append(this.user_openid).append(",");
/* 140 */     _sb_.append("B").append(this.user_ip.size()).append(",");
/* 141 */     _sb_.append(this.dump_switch).append(",");
/* 142 */     _sb_.append(this.client_link_info_report_switch).append(",");
/* 143 */     _sb_.append(this.user_ability).append(",");
/* 144 */     _sb_.append(this.mix_voice_ability).append(",");
/* 145 */     _sb_.append(this.net_type).append(",");
/* 146 */     _sb_.append(this.gid).append(",");
/* 147 */     _sb_.append("B").append(this.uuid.size()).append(",");
/* 148 */     _sb_.append(this.member_type).append(",");
/* 149 */     _sb_.append(")");
/* 150 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\LargeEnterReqInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */