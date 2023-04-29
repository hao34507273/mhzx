/*     */ package gnet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class UserInfoRep extends __UserInfoRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 211;
/*     */   public static final int ALGORITHM_NONE = 0;
/*     */   public static final int ALGORITHM_CARD = 65536;
/*     */   public static final int ALGORITHM_HANDSET = 131072;
/*     */   public static final int ALGORITHM_USBKEY = 196608;
/*     */   public static final int ALGORITHM_PHONE = 262400;
/*     */   public static final int ALGORITHM_USBKEY2 = 327680;
/*     */   public com.goldhuman.Common.Octets userid;
/*     */   public int retcode;
/*     */   
/*     */   protected void process() {
/*  18 */     if (this.retcode == 0) {
/*  19 */       GdeliveryHelper.userInfoRevecier(this);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  27 */     return 211;
/*     */   }
/*     */   
/*     */ 
/*     */   public int loginip;
/*     */   
/*     */   public byte blisgm;
/*     */   
/*     */   public java.util.ArrayList<Integer> auth;
/*     */   
/*     */   public int algorithm;
/*     */   
/*     */   public int func;
/*     */   
/*     */   public int funcparm;
/*     */   
/*     */   public byte gender;
/*     */   
/*     */   public com.goldhuman.Common.Octets nickname;
/*     */   
/*     */   public com.goldhuman.Common.Octets device_info;
/*     */   public com.goldhuman.Common.Octets extinfo;
/*     */   public UserInfoRep()
/*     */   {
/*  51 */     this.userid = new com.goldhuman.Common.Octets();
/*  52 */     this.auth = new java.util.ArrayList();
/*  53 */     this.nickname = new com.goldhuman.Common.Octets();
/*  54 */     this.device_info = new com.goldhuman.Common.Octets();
/*  55 */     this.extinfo = new com.goldhuman.Common.Octets();
/*     */   }
/*     */   
/*     */   public UserInfoRep(com.goldhuman.Common.Octets _userid_, int _retcode_, int _loginip_, byte _blisgm_, java.util.ArrayList<Integer> _auth_, int _algorithm_, int _func_, int _funcparm_, byte _gender_, com.goldhuman.Common.Octets _nickname_, com.goldhuman.Common.Octets _device_info_, com.goldhuman.Common.Octets _extinfo_) {
/*  59 */     this.userid = _userid_;
/*  60 */     this.retcode = _retcode_;
/*  61 */     this.loginip = _loginip_;
/*  62 */     this.blisgm = _blisgm_;
/*  63 */     this.auth = _auth_;
/*  64 */     this.algorithm = _algorithm_;
/*  65 */     this.func = _func_;
/*  66 */     this.funcparm = _funcparm_;
/*  67 */     this.gender = _gender_;
/*  68 */     this.nickname = _nickname_;
/*  69 */     this.device_info = _device_info_;
/*  70 */     this.extinfo = _extinfo_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  74 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  78 */     _os_.marshal(this.userid);
/*  79 */     _os_.marshal(this.retcode);
/*  80 */     _os_.marshal(this.loginip);
/*  81 */     _os_.marshal(this.blisgm);
/*  82 */     _os_.compact_uint32(this.auth.size());
/*  83 */     for (Integer _v_ : this.auth) {
/*  84 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  86 */     _os_.marshal(this.algorithm);
/*  87 */     _os_.marshal(this.func);
/*  88 */     _os_.marshal(this.funcparm);
/*  89 */     _os_.marshal(this.gender);
/*  90 */     _os_.marshal(this.nickname);
/*  91 */     _os_.marshal(this.device_info);
/*  92 */     _os_.marshal(this.extinfo);
/*  93 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  97 */     this.userid = _os_.unmarshal_Octets();
/*  98 */     this.retcode = _os_.unmarshal_int();
/*  99 */     this.loginip = _os_.unmarshal_int();
/* 100 */     this.blisgm = _os_.unmarshal_byte();
/* 101 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/* 103 */       int _v_ = _os_.unmarshal_int();
/* 104 */       this.auth.add(Integer.valueOf(_v_));
/*     */     }
/* 106 */     this.algorithm = _os_.unmarshal_int();
/* 107 */     this.func = _os_.unmarshal_int();
/* 108 */     this.funcparm = _os_.unmarshal_int();
/* 109 */     this.gender = _os_.unmarshal_byte();
/* 110 */     this.nickname = _os_.unmarshal_Octets();
/* 111 */     this.device_info = _os_.unmarshal_Octets();
/* 112 */     this.extinfo = _os_.unmarshal_Octets();
/* 113 */     if (!_validator_()) {
/* 114 */       throw new VerifyError("validator failed");
/*     */     }
/* 116 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 120 */     if (_o1_ == this) return true;
/* 121 */     if ((_o1_ instanceof UserInfoRep)) {
/* 122 */       UserInfoRep _o_ = (UserInfoRep)_o1_;
/* 123 */       if (!this.userid.equals(_o_.userid)) return false;
/* 124 */       if (this.retcode != _o_.retcode) return false;
/* 125 */       if (this.loginip != _o_.loginip) return false;
/* 126 */       if (this.blisgm != _o_.blisgm) return false;
/* 127 */       if (!this.auth.equals(_o_.auth)) return false;
/* 128 */       if (this.algorithm != _o_.algorithm) return false;
/* 129 */       if (this.func != _o_.func) return false;
/* 130 */       if (this.funcparm != _o_.funcparm) return false;
/* 131 */       if (this.gender != _o_.gender) return false;
/* 132 */       if (!this.nickname.equals(_o_.nickname)) return false;
/* 133 */       if (!this.device_info.equals(_o_.device_info)) return false;
/* 134 */       if (!this.extinfo.equals(_o_.extinfo)) return false;
/* 135 */       return true;
/*     */     }
/* 137 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 141 */     int _h_ = 0;
/* 142 */     _h_ += this.userid.hashCode();
/* 143 */     _h_ += this.retcode;
/* 144 */     _h_ += this.loginip;
/* 145 */     _h_ += this.blisgm;
/* 146 */     _h_ += this.auth.hashCode();
/* 147 */     _h_ += this.algorithm;
/* 148 */     _h_ += this.func;
/* 149 */     _h_ += this.funcparm;
/* 150 */     _h_ += this.gender;
/* 151 */     _h_ += this.nickname.hashCode();
/* 152 */     _h_ += this.device_info.hashCode();
/* 153 */     _h_ += this.extinfo.hashCode();
/* 154 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 158 */     StringBuilder _sb_ = new StringBuilder();
/* 159 */     _sb_.append("(");
/* 160 */     _sb_.append("B").append(this.userid.size()).append(",");
/* 161 */     _sb_.append(this.retcode).append(",");
/* 162 */     _sb_.append(this.loginip).append(",");
/* 163 */     _sb_.append(this.blisgm).append(",");
/* 164 */     _sb_.append(this.auth).append(",");
/* 165 */     _sb_.append(this.algorithm).append(",");
/* 166 */     _sb_.append(this.func).append(",");
/* 167 */     _sb_.append(this.funcparm).append(",");
/* 168 */     _sb_.append(this.gender).append(",");
/* 169 */     _sb_.append("B").append(this.nickname.size()).append(",");
/* 170 */     _sb_.append("B").append(this.device_info.size()).append(",");
/* 171 */     _sb_.append("B").append(this.extinfo.size()).append(",");
/* 172 */     _sb_.append(")");
/* 173 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\UserInfoRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */