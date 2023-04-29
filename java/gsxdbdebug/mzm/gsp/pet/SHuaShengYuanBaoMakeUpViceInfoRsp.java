/*     */ package mzm.gsp.pet;
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
/*     */ public class SHuaShengYuanBaoMakeUpViceInfoRsp
/*     */   extends __SHuaShengYuanBaoMakeUpViceInfoRsp__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590679;
/*     */   public long mainpetid;
/*     */   public int vicecfgid;
/*     */   public int needyuanbaocount;
/*     */   public int skillcount;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12590679;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SHuaShengYuanBaoMakeUpViceInfoRsp() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SHuaShengYuanBaoMakeUpViceInfoRsp(long _mainpetid_, int _vicecfgid_, int _needyuanbaocount_, int _skillcount_)
/*     */   {
/*  37 */     this.mainpetid = _mainpetid_;
/*  38 */     this.vicecfgid = _vicecfgid_;
/*  39 */     this.needyuanbaocount = _needyuanbaocount_;
/*  40 */     this.skillcount = _skillcount_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.mainpetid);
/*  49 */     _os_.marshal(this.vicecfgid);
/*  50 */     _os_.marshal(this.needyuanbaocount);
/*  51 */     _os_.marshal(this.skillcount);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  56 */     this.mainpetid = _os_.unmarshal_long();
/*  57 */     this.vicecfgid = _os_.unmarshal_int();
/*  58 */     this.needyuanbaocount = _os_.unmarshal_int();
/*  59 */     this.skillcount = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof SHuaShengYuanBaoMakeUpViceInfoRsp)) {
/*  69 */       SHuaShengYuanBaoMakeUpViceInfoRsp _o_ = (SHuaShengYuanBaoMakeUpViceInfoRsp)_o1_;
/*  70 */       if (this.mainpetid != _o_.mainpetid) return false;
/*  71 */       if (this.vicecfgid != _o_.vicecfgid) return false;
/*  72 */       if (this.needyuanbaocount != _o_.needyuanbaocount) return false;
/*  73 */       if (this.skillcount != _o_.skillcount) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += (int)this.mainpetid;
/*  82 */     _h_ += this.vicecfgid;
/*  83 */     _h_ += this.needyuanbaocount;
/*  84 */     _h_ += this.skillcount;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.mainpetid).append(",");
/*  92 */     _sb_.append(this.vicecfgid).append(",");
/*  93 */     _sb_.append(this.needyuanbaocount).append(",");
/*  94 */     _sb_.append(this.skillcount).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SHuaShengYuanBaoMakeUpViceInfoRsp _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = Long.signum(this.mainpetid - _o_.mainpetid);
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.vicecfgid - _o_.vicecfgid;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.needyuanbaocount - _o_.needyuanbaocount;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.skillcount - _o_.skillcount;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\SHuaShengYuanBaoMakeUpViceInfoRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */