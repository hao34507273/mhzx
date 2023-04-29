/*     */ package mzm.gsp.team;
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
/*     */ public class SGetHeart
/*     */   extends __SGetHeart__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12588346;
/*     */   public long otherroleid;
/*     */   public String othername;
/*     */   public int otherlv;
/*     */   public int othermenpai;
/*     */   public int othergender;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12588346;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetHeart()
/*     */   {
/*  37 */     this.othername = "";
/*     */   }
/*     */   
/*     */   public SGetHeart(long _otherroleid_, String _othername_, int _otherlv_, int _othermenpai_, int _othergender_) {
/*  41 */     this.otherroleid = _otherroleid_;
/*  42 */     this.othername = _othername_;
/*  43 */     this.otherlv = _otherlv_;
/*  44 */     this.othermenpai = _othermenpai_;
/*  45 */     this.othergender = _othergender_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.otherroleid);
/*  54 */     _os_.marshal(this.othername, "UTF-16LE");
/*  55 */     _os_.marshal(this.otherlv);
/*  56 */     _os_.marshal(this.othermenpai);
/*  57 */     _os_.marshal(this.othergender);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.otherroleid = _os_.unmarshal_long();
/*  63 */     this.othername = _os_.unmarshal_String("UTF-16LE");
/*  64 */     this.otherlv = _os_.unmarshal_int();
/*  65 */     this.othermenpai = _os_.unmarshal_int();
/*  66 */     this.othergender = _os_.unmarshal_int();
/*  67 */     if (!_validator_()) {
/*  68 */       throw new VerifyError("validator failed");
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  74 */     if (_o1_ == this) return true;
/*  75 */     if ((_o1_ instanceof SGetHeart)) {
/*  76 */       SGetHeart _o_ = (SGetHeart)_o1_;
/*  77 */       if (this.otherroleid != _o_.otherroleid) return false;
/*  78 */       if (!this.othername.equals(_o_.othername)) return false;
/*  79 */       if (this.otherlv != _o_.otherlv) return false;
/*  80 */       if (this.othermenpai != _o_.othermenpai) return false;
/*  81 */       if (this.othergender != _o_.othergender) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += (int)this.otherroleid;
/*  90 */     _h_ += this.othername.hashCode();
/*  91 */     _h_ += this.otherlv;
/*  92 */     _h_ += this.othermenpai;
/*  93 */     _h_ += this.othergender;
/*  94 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  98 */     StringBuilder _sb_ = new StringBuilder();
/*  99 */     _sb_.append("(");
/* 100 */     _sb_.append(this.otherroleid).append(",");
/* 101 */     _sb_.append("T").append(this.othername.length()).append(",");
/* 102 */     _sb_.append(this.otherlv).append(",");
/* 103 */     _sb_.append(this.othermenpai).append(",");
/* 104 */     _sb_.append(this.othergender).append(",");
/* 105 */     _sb_.append(")");
/* 106 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\SGetHeart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */