/*     */ package openau;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class TransferOrderArg implements Marshal
/*     */ {
/*     */   public int sn;
/*     */   public Octets account;
/*     */   public int userid;
/*     */   public long roleid;
/*     */   public int zoneid;
/*     */   public long createtime;
/*     */   public Octets gameorderid;
/*     */   public Octets gameproductid;
/*     */   public int gameproductamount;
/*     */   public Octets gameclientext;
/*     */   public Octets gameserverext;
/*     */   public Octets platid;
/*     */   public Octets payplatid;
/*     */   public Octets devicecategory;
/*     */   public long platcallbacktime;
/*     */   public Octets platorderid;
/*     */   public Octets platproductid;
/*     */   public int platproductamount;
/*     */   public Octets platcurrency;
/*     */   public int rawamount;
/*     */   public Octets rawcurrency;
/*     */   public Octets platext;
/*     */   public Octets ext;
/*     */   public int flags;
/*     */   public int cashtype;
/*     */   public int cashamount;
/*     */   public int extracashamount;
/*     */   public int reserved1;
/*     */   public Octets reserved2;
/*     */   
/*     */   public TransferOrderArg()
/*     */   {
/*  42 */     this.account = new Octets();
/*  43 */     this.userid = -1;
/*  44 */     this.gameorderid = new Octets();
/*  45 */     this.gameproductid = new Octets();
/*  46 */     this.gameclientext = new Octets();
/*  47 */     this.gameserverext = new Octets();
/*  48 */     this.platid = new Octets();
/*  49 */     this.payplatid = new Octets();
/*  50 */     this.devicecategory = new Octets();
/*  51 */     this.platorderid = new Octets();
/*  52 */     this.platproductid = new Octets();
/*  53 */     this.platcurrency = new Octets();
/*  54 */     this.rawcurrency = new Octets();
/*  55 */     this.platext = new Octets();
/*  56 */     this.ext = new Octets();
/*  57 */     this.reserved1 = 0;
/*  58 */     this.reserved2 = new Octets();
/*     */   }
/*     */   
/*     */   public TransferOrderArg(int _sn_, Octets _account_, int _userid_, long _roleid_, int _zoneid_, long _createtime_, Octets _gameorderid_, Octets _gameproductid_, int _gameproductamount_, Octets _gameclientext_, Octets _gameserverext_, Octets _platid_, Octets _payplatid_, Octets _devicecategory_, long _platcallbacktime_, Octets _platorderid_, Octets _platproductid_, int _platproductamount_, Octets _platcurrency_, int _rawamount_, Octets _rawcurrency_, Octets _platext_, Octets _ext_, int _flags_, int _cashtype_, int _cashamount_, int _extracashamount_, int _reserved1_, Octets _reserved2_) {
/*  62 */     this.sn = _sn_;
/*  63 */     this.account = _account_;
/*  64 */     this.userid = _userid_;
/*  65 */     this.roleid = _roleid_;
/*  66 */     this.zoneid = _zoneid_;
/*  67 */     this.createtime = _createtime_;
/*  68 */     this.gameorderid = _gameorderid_;
/*  69 */     this.gameproductid = _gameproductid_;
/*  70 */     this.gameproductamount = _gameproductamount_;
/*  71 */     this.gameclientext = _gameclientext_;
/*  72 */     this.gameserverext = _gameserverext_;
/*  73 */     this.platid = _platid_;
/*  74 */     this.payplatid = _payplatid_;
/*  75 */     this.devicecategory = _devicecategory_;
/*  76 */     this.platcallbacktime = _platcallbacktime_;
/*  77 */     this.platorderid = _platorderid_;
/*  78 */     this.platproductid = _platproductid_;
/*  79 */     this.platproductamount = _platproductamount_;
/*  80 */     this.platcurrency = _platcurrency_;
/*  81 */     this.rawamount = _rawamount_;
/*  82 */     this.rawcurrency = _rawcurrency_;
/*  83 */     this.platext = _platext_;
/*  84 */     this.ext = _ext_;
/*  85 */     this.flags = _flags_;
/*  86 */     this.cashtype = _cashtype_;
/*  87 */     this.cashamount = _cashamount_;
/*  88 */     this.extracashamount = _extracashamount_;
/*  89 */     this.reserved1 = _reserved1_;
/*  90 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  94 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  98 */     _os_.marshal(this.sn);
/*  99 */     _os_.marshal(this.account);
/* 100 */     _os_.marshal(this.userid);
/* 101 */     _os_.marshal(this.roleid);
/* 102 */     _os_.marshal(this.zoneid);
/* 103 */     _os_.marshal(this.createtime);
/* 104 */     _os_.marshal(this.gameorderid);
/* 105 */     _os_.marshal(this.gameproductid);
/* 106 */     _os_.marshal(this.gameproductamount);
/* 107 */     _os_.marshal(this.gameclientext);
/* 108 */     _os_.marshal(this.gameserverext);
/* 109 */     _os_.marshal(this.platid);
/* 110 */     _os_.marshal(this.payplatid);
/* 111 */     _os_.marshal(this.devicecategory);
/* 112 */     _os_.marshal(this.platcallbacktime);
/* 113 */     _os_.marshal(this.platorderid);
/* 114 */     _os_.marshal(this.platproductid);
/* 115 */     _os_.marshal(this.platproductamount);
/* 116 */     _os_.marshal(this.platcurrency);
/* 117 */     _os_.marshal(this.rawamount);
/* 118 */     _os_.marshal(this.rawcurrency);
/* 119 */     _os_.marshal(this.platext);
/* 120 */     _os_.marshal(this.ext);
/* 121 */     _os_.marshal(this.flags);
/* 122 */     _os_.marshal(this.cashtype);
/* 123 */     _os_.marshal(this.cashamount);
/* 124 */     _os_.marshal(this.extracashamount);
/* 125 */     _os_.marshal(this.reserved1);
/* 126 */     _os_.marshal(this.reserved2);
/* 127 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 131 */     this.sn = _os_.unmarshal_int();
/* 132 */     this.account = _os_.unmarshal_Octets();
/* 133 */     this.userid = _os_.unmarshal_int();
/* 134 */     this.roleid = _os_.unmarshal_long();
/* 135 */     this.zoneid = _os_.unmarshal_int();
/* 136 */     this.createtime = _os_.unmarshal_long();
/* 137 */     this.gameorderid = _os_.unmarshal_Octets();
/* 138 */     this.gameproductid = _os_.unmarshal_Octets();
/* 139 */     this.gameproductamount = _os_.unmarshal_int();
/* 140 */     this.gameclientext = _os_.unmarshal_Octets();
/* 141 */     this.gameserverext = _os_.unmarshal_Octets();
/* 142 */     this.platid = _os_.unmarshal_Octets();
/* 143 */     this.payplatid = _os_.unmarshal_Octets();
/* 144 */     this.devicecategory = _os_.unmarshal_Octets();
/* 145 */     this.platcallbacktime = _os_.unmarshal_long();
/* 146 */     this.platorderid = _os_.unmarshal_Octets();
/* 147 */     this.platproductid = _os_.unmarshal_Octets();
/* 148 */     this.platproductamount = _os_.unmarshal_int();
/* 149 */     this.platcurrency = _os_.unmarshal_Octets();
/* 150 */     this.rawamount = _os_.unmarshal_int();
/* 151 */     this.rawcurrency = _os_.unmarshal_Octets();
/* 152 */     this.platext = _os_.unmarshal_Octets();
/* 153 */     this.ext = _os_.unmarshal_Octets();
/* 154 */     this.flags = _os_.unmarshal_int();
/* 155 */     this.cashtype = _os_.unmarshal_int();
/* 156 */     this.cashamount = _os_.unmarshal_int();
/* 157 */     this.extracashamount = _os_.unmarshal_int();
/* 158 */     this.reserved1 = _os_.unmarshal_int();
/* 159 */     this.reserved2 = _os_.unmarshal_Octets();
/* 160 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 164 */     if (_o1_ == this) return true;
/* 165 */     if ((_o1_ instanceof TransferOrderArg)) {
/* 166 */       TransferOrderArg _o_ = (TransferOrderArg)_o1_;
/* 167 */       if (this.sn != _o_.sn) return false;
/* 168 */       if (!this.account.equals(_o_.account)) return false;
/* 169 */       if (this.userid != _o_.userid) return false;
/* 170 */       if (this.roleid != _o_.roleid) return false;
/* 171 */       if (this.zoneid != _o_.zoneid) return false;
/* 172 */       if (this.createtime != _o_.createtime) return false;
/* 173 */       if (!this.gameorderid.equals(_o_.gameorderid)) return false;
/* 174 */       if (!this.gameproductid.equals(_o_.gameproductid)) return false;
/* 175 */       if (this.gameproductamount != _o_.gameproductamount) return false;
/* 176 */       if (!this.gameclientext.equals(_o_.gameclientext)) return false;
/* 177 */       if (!this.gameserverext.equals(_o_.gameserverext)) return false;
/* 178 */       if (!this.platid.equals(_o_.platid)) return false;
/* 179 */       if (!this.payplatid.equals(_o_.payplatid)) return false;
/* 180 */       if (!this.devicecategory.equals(_o_.devicecategory)) return false;
/* 181 */       if (this.platcallbacktime != _o_.platcallbacktime) return false;
/* 182 */       if (!this.platorderid.equals(_o_.platorderid)) return false;
/* 183 */       if (!this.platproductid.equals(_o_.platproductid)) return false;
/* 184 */       if (this.platproductamount != _o_.platproductamount) return false;
/* 185 */       if (!this.platcurrency.equals(_o_.platcurrency)) return false;
/* 186 */       if (this.rawamount != _o_.rawamount) return false;
/* 187 */       if (!this.rawcurrency.equals(_o_.rawcurrency)) return false;
/* 188 */       if (!this.platext.equals(_o_.platext)) return false;
/* 189 */       if (!this.ext.equals(_o_.ext)) return false;
/* 190 */       if (this.flags != _o_.flags) return false;
/* 191 */       if (this.cashtype != _o_.cashtype) return false;
/* 192 */       if (this.cashamount != _o_.cashamount) return false;
/* 193 */       if (this.extracashamount != _o_.extracashamount) return false;
/* 194 */       if (this.reserved1 != _o_.reserved1) return false;
/* 195 */       if (!this.reserved2.equals(_o_.reserved2)) return false;
/* 196 */       return true;
/*     */     }
/* 198 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 202 */     int _h_ = 0;
/* 203 */     _h_ += this.sn;
/* 204 */     _h_ += this.account.hashCode();
/* 205 */     _h_ += this.userid;
/* 206 */     _h_ += (int)this.roleid;
/* 207 */     _h_ += this.zoneid;
/* 208 */     _h_ += (int)this.createtime;
/* 209 */     _h_ += this.gameorderid.hashCode();
/* 210 */     _h_ += this.gameproductid.hashCode();
/* 211 */     _h_ += this.gameproductamount;
/* 212 */     _h_ += this.gameclientext.hashCode();
/* 213 */     _h_ += this.gameserverext.hashCode();
/* 214 */     _h_ += this.platid.hashCode();
/* 215 */     _h_ += this.payplatid.hashCode();
/* 216 */     _h_ += this.devicecategory.hashCode();
/* 217 */     _h_ += (int)this.platcallbacktime;
/* 218 */     _h_ += this.platorderid.hashCode();
/* 219 */     _h_ += this.platproductid.hashCode();
/* 220 */     _h_ += this.platproductamount;
/* 221 */     _h_ += this.platcurrency.hashCode();
/* 222 */     _h_ += this.rawamount;
/* 223 */     _h_ += this.rawcurrency.hashCode();
/* 224 */     _h_ += this.platext.hashCode();
/* 225 */     _h_ += this.ext.hashCode();
/* 226 */     _h_ += this.flags;
/* 227 */     _h_ += this.cashtype;
/* 228 */     _h_ += this.cashamount;
/* 229 */     _h_ += this.extracashamount;
/* 230 */     _h_ += this.reserved1;
/* 231 */     _h_ += this.reserved2.hashCode();
/* 232 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 236 */     StringBuilder _sb_ = new StringBuilder();
/* 237 */     _sb_.append("(");
/* 238 */     _sb_.append(this.sn).append(",");
/* 239 */     _sb_.append("B").append(this.account.size()).append(",");
/* 240 */     _sb_.append(this.userid).append(",");
/* 241 */     _sb_.append(this.roleid).append(",");
/* 242 */     _sb_.append(this.zoneid).append(",");
/* 243 */     _sb_.append(this.createtime).append(",");
/* 244 */     _sb_.append("B").append(this.gameorderid.size()).append(",");
/* 245 */     _sb_.append("B").append(this.gameproductid.size()).append(",");
/* 246 */     _sb_.append(this.gameproductamount).append(",");
/* 247 */     _sb_.append("B").append(this.gameclientext.size()).append(",");
/* 248 */     _sb_.append("B").append(this.gameserverext.size()).append(",");
/* 249 */     _sb_.append("B").append(this.platid.size()).append(",");
/* 250 */     _sb_.append("B").append(this.payplatid.size()).append(",");
/* 251 */     _sb_.append("B").append(this.devicecategory.size()).append(",");
/* 252 */     _sb_.append(this.platcallbacktime).append(",");
/* 253 */     _sb_.append("B").append(this.platorderid.size()).append(",");
/* 254 */     _sb_.append("B").append(this.platproductid.size()).append(",");
/* 255 */     _sb_.append(this.platproductamount).append(",");
/* 256 */     _sb_.append("B").append(this.platcurrency.size()).append(",");
/* 257 */     _sb_.append(this.rawamount).append(",");
/* 258 */     _sb_.append("B").append(this.rawcurrency.size()).append(",");
/* 259 */     _sb_.append("B").append(this.platext.size()).append(",");
/* 260 */     _sb_.append("B").append(this.ext.size()).append(",");
/* 261 */     _sb_.append(this.flags).append(",");
/* 262 */     _sb_.append(this.cashtype).append(",");
/* 263 */     _sb_.append(this.cashamount).append(",");
/* 264 */     _sb_.append(this.extracashamount).append(",");
/* 265 */     _sb_.append(this.reserved1).append(",");
/* 266 */     _sb_.append("B").append(this.reserved2.size()).append(",");
/* 267 */     _sb_.append(")");
/* 268 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\openau\TransferOrderArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */