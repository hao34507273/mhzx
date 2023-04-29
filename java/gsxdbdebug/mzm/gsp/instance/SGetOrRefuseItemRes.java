/*     */ package mzm.gsp.instance;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SGetOrRefuseItemRes
/*     */   extends __SGetOrRefuseItemRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12591365;
/*     */   public long awarduuid;
/*     */   public int itemid;
/*     */   public long roleid;
/*     */   public int code;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12591365;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetOrRefuseItemRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SGetOrRefuseItemRes(long _awarduuid_, int _itemid_, long _roleid_, int _code_)
/*     */   {
/*  39 */     this.awarduuid = _awarduuid_;
/*  40 */     this.itemid = _itemid_;
/*  41 */     this.roleid = _roleid_;
/*  42 */     this.code = _code_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.awarduuid);
/*  51 */     _os_.marshal(this.itemid);
/*  52 */     _os_.marshal(this.roleid);
/*  53 */     _os_.marshal(this.code);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.awarduuid = _os_.unmarshal_long();
/*  59 */     this.itemid = _os_.unmarshal_int();
/*  60 */     this.roleid = _os_.unmarshal_long();
/*  61 */     this.code = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SGetOrRefuseItemRes)) {
/*  71 */       SGetOrRefuseItemRes _o_ = (SGetOrRefuseItemRes)_o1_;
/*  72 */       if (this.awarduuid != _o_.awarduuid) return false;
/*  73 */       if (this.itemid != _o_.itemid) return false;
/*  74 */       if (this.roleid != _o_.roleid) return false;
/*  75 */       if (this.code != _o_.code) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += (int)this.awarduuid;
/*  84 */     _h_ += this.itemid;
/*  85 */     _h_ += (int)this.roleid;
/*  86 */     _h_ += this.code;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.awarduuid).append(",");
/*  94 */     _sb_.append(this.itemid).append(",");
/*  95 */     _sb_.append(this.roleid).append(",");
/*  96 */     _sb_.append(this.code).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGetOrRefuseItemRes _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = Long.signum(this.awarduuid - _o_.awarduuid);
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.itemid - _o_.itemid;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.code - _o_.code;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\SGetOrRefuseItemRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */