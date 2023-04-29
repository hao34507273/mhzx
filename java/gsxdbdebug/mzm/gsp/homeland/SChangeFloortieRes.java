/*     */ package mzm.gsp.homeland;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SChangeFloortieRes
/*     */   extends __SChangeFloortieRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12605502;
/*     */   public int furnitureid;
/*     */   public long furnitureuuid;
/*     */   public long unfurnitureuuid;
/*     */   public int unfurnitureid;
/*     */   public int changefengshui;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12605502;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SChangeFloortieRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SChangeFloortieRes(int _furnitureid_, long _furnitureuuid_, long _unfurnitureuuid_, int _unfurnitureid_, int _changefengshui_)
/*     */   {
/*  38 */     this.furnitureid = _furnitureid_;
/*  39 */     this.furnitureuuid = _furnitureuuid_;
/*  40 */     this.unfurnitureuuid = _unfurnitureuuid_;
/*  41 */     this.unfurnitureid = _unfurnitureid_;
/*  42 */     this.changefengshui = _changefengshui_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.furnitureid);
/*  51 */     _os_.marshal(this.furnitureuuid);
/*  52 */     _os_.marshal(this.unfurnitureuuid);
/*  53 */     _os_.marshal(this.unfurnitureid);
/*  54 */     _os_.marshal(this.changefengshui);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.furnitureid = _os_.unmarshal_int();
/*  60 */     this.furnitureuuid = _os_.unmarshal_long();
/*  61 */     this.unfurnitureuuid = _os_.unmarshal_long();
/*  62 */     this.unfurnitureid = _os_.unmarshal_int();
/*  63 */     this.changefengshui = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof SChangeFloortieRes)) {
/*  73 */       SChangeFloortieRes _o_ = (SChangeFloortieRes)_o1_;
/*  74 */       if (this.furnitureid != _o_.furnitureid) return false;
/*  75 */       if (this.furnitureuuid != _o_.furnitureuuid) return false;
/*  76 */       if (this.unfurnitureuuid != _o_.unfurnitureuuid) return false;
/*  77 */       if (this.unfurnitureid != _o_.unfurnitureid) return false;
/*  78 */       if (this.changefengshui != _o_.changefengshui) return false;
/*  79 */       return true;
/*     */     }
/*  81 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  85 */     int _h_ = 0;
/*  86 */     _h_ += this.furnitureid;
/*  87 */     _h_ += (int)this.furnitureuuid;
/*  88 */     _h_ += (int)this.unfurnitureuuid;
/*  89 */     _h_ += this.unfurnitureid;
/*  90 */     _h_ += this.changefengshui;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.furnitureid).append(",");
/*  98 */     _sb_.append(this.furnitureuuid).append(",");
/*  99 */     _sb_.append(this.unfurnitureuuid).append(",");
/* 100 */     _sb_.append(this.unfurnitureid).append(",");
/* 101 */     _sb_.append(this.changefengshui).append(",");
/* 102 */     _sb_.append(")");
/* 103 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SChangeFloortieRes _o_) {
/* 107 */     if (_o_ == this) return 0;
/* 108 */     int _c_ = 0;
/* 109 */     _c_ = this.furnitureid - _o_.furnitureid;
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     _c_ = Long.signum(this.furnitureuuid - _o_.furnitureuuid);
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = Long.signum(this.unfurnitureuuid - _o_.unfurnitureuuid);
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = this.unfurnitureid - _o_.unfurnitureid;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = this.changefengshui - _o_.changefengshui;
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\SChangeFloortieRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */