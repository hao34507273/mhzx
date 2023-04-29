/*     */ package mzm.gsp.cake;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SCakeInfoChangeBro
/*     */   extends __SCakeInfoChangeBro__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12627716;
/*     */   public static final int REASON_ADD = 1;
/*     */   public static final int REASON_MAKE = 2;
/*     */   public int activityid;
/*     */   public long roleid;
/*     */   public Octets mastername;
/*     */   public long makeroleid;
/*     */   public int itemid;
/*     */   public int reason;
/*     */   public CakeDetailInfo cakeinfo;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12627716;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SCakeInfoChangeBro()
/*     */   {
/*  42 */     this.mastername = new Octets();
/*  43 */     this.cakeinfo = new CakeDetailInfo();
/*     */   }
/*     */   
/*     */   public SCakeInfoChangeBro(int _activityid_, long _roleid_, Octets _mastername_, long _makeroleid_, int _itemid_, int _reason_, CakeDetailInfo _cakeinfo_) {
/*  47 */     this.activityid = _activityid_;
/*  48 */     this.roleid = _roleid_;
/*  49 */     this.mastername = _mastername_;
/*  50 */     this.makeroleid = _makeroleid_;
/*  51 */     this.itemid = _itemid_;
/*  52 */     this.reason = _reason_;
/*  53 */     this.cakeinfo = _cakeinfo_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  57 */     if (!this.cakeinfo._validator_()) return false;
/*  58 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  62 */     _os_.marshal(this.activityid);
/*  63 */     _os_.marshal(this.roleid);
/*  64 */     _os_.marshal(this.mastername);
/*  65 */     _os_.marshal(this.makeroleid);
/*  66 */     _os_.marshal(this.itemid);
/*  67 */     _os_.marshal(this.reason);
/*  68 */     _os_.marshal(this.cakeinfo);
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  73 */     this.activityid = _os_.unmarshal_int();
/*  74 */     this.roleid = _os_.unmarshal_long();
/*  75 */     this.mastername = _os_.unmarshal_Octets();
/*  76 */     this.makeroleid = _os_.unmarshal_long();
/*  77 */     this.itemid = _os_.unmarshal_int();
/*  78 */     this.reason = _os_.unmarshal_int();
/*  79 */     this.cakeinfo.unmarshal(_os_);
/*  80 */     if (!_validator_()) {
/*  81 */       throw new VerifyError("validator failed");
/*     */     }
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  87 */     if (_o1_ == this) return true;
/*  88 */     if ((_o1_ instanceof SCakeInfoChangeBro)) {
/*  89 */       SCakeInfoChangeBro _o_ = (SCakeInfoChangeBro)_o1_;
/*  90 */       if (this.activityid != _o_.activityid) return false;
/*  91 */       if (this.roleid != _o_.roleid) return false;
/*  92 */       if (!this.mastername.equals(_o_.mastername)) return false;
/*  93 */       if (this.makeroleid != _o_.makeroleid) return false;
/*  94 */       if (this.itemid != _o_.itemid) return false;
/*  95 */       if (this.reason != _o_.reason) return false;
/*  96 */       if (!this.cakeinfo.equals(_o_.cakeinfo)) return false;
/*  97 */       return true;
/*     */     }
/*  99 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 103 */     int _h_ = 0;
/* 104 */     _h_ += this.activityid;
/* 105 */     _h_ += (int)this.roleid;
/* 106 */     _h_ += this.mastername.hashCode();
/* 107 */     _h_ += (int)this.makeroleid;
/* 108 */     _h_ += this.itemid;
/* 109 */     _h_ += this.reason;
/* 110 */     _h_ += this.cakeinfo.hashCode();
/* 111 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 115 */     StringBuilder _sb_ = new StringBuilder();
/* 116 */     _sb_.append("(");
/* 117 */     _sb_.append(this.activityid).append(",");
/* 118 */     _sb_.append(this.roleid).append(",");
/* 119 */     _sb_.append("B").append(this.mastername.size()).append(",");
/* 120 */     _sb_.append(this.makeroleid).append(",");
/* 121 */     _sb_.append(this.itemid).append(",");
/* 122 */     _sb_.append(this.reason).append(",");
/* 123 */     _sb_.append(this.cakeinfo).append(",");
/* 124 */     _sb_.append(")");
/* 125 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\SCakeInfoChangeBro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */