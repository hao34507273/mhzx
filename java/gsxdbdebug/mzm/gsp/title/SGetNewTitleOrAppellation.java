/*     */ package mzm.gsp.title;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SGetNewTitleOrAppellation
/*     */   extends __SGetNewTitleOrAppellation__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12593923;
/*     */   public int changeid;
/*     */   public int changetype;
/*     */   public ArrayList<String> appargs;
/*     */   public long timeout;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12593923;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetNewTitleOrAppellation()
/*     */   {
/*  36 */     this.appargs = new ArrayList();
/*     */   }
/*     */   
/*     */   public SGetNewTitleOrAppellation(int _changeid_, int _changetype_, ArrayList<String> _appargs_, long _timeout_) {
/*  40 */     this.changeid = _changeid_;
/*  41 */     this.changetype = _changetype_;
/*  42 */     this.appargs = _appargs_;
/*  43 */     this.timeout = _timeout_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.changeid);
/*  52 */     _os_.marshal(this.changetype);
/*  53 */     _os_.compact_uint32(this.appargs.size());
/*  54 */     for (String _v_ : this.appargs) {
/*  55 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  57 */     _os_.marshal(this.timeout);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.changeid = _os_.unmarshal_int();
/*  63 */     this.changetype = _os_.unmarshal_int();
/*  64 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  66 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/*  67 */       this.appargs.add(_v_);
/*     */     }
/*  69 */     this.timeout = _os_.unmarshal_long();
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof SGetNewTitleOrAppellation)) {
/*  79 */       SGetNewTitleOrAppellation _o_ = (SGetNewTitleOrAppellation)_o1_;
/*  80 */       if (this.changeid != _o_.changeid) return false;
/*  81 */       if (this.changetype != _o_.changetype) return false;
/*  82 */       if (!this.appargs.equals(_o_.appargs)) return false;
/*  83 */       if (this.timeout != _o_.timeout) return false;
/*  84 */       return true;
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  90 */     int _h_ = 0;
/*  91 */     _h_ += this.changeid;
/*  92 */     _h_ += this.changetype;
/*  93 */     _h_ += this.appargs.hashCode();
/*  94 */     _h_ += (int)this.timeout;
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.changeid).append(",");
/* 102 */     _sb_.append(this.changetype).append(",");
/* 103 */     _sb_.append(this.appargs).append(",");
/* 104 */     _sb_.append(this.timeout).append(",");
/* 105 */     _sb_.append(")");
/* 106 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\SGetNewTitleOrAppellation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */