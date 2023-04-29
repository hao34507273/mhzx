/*     */ package mzm.gsp.shitu;
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
/*     */ public class SRelieveShiTuRelation
/*     */   extends __SRelieveShiTuRelation__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601615;
/*     */   public long apprenticeroleid;
/*     */   public String apprenticerolename;
/*     */   public long masterroleid;
/*     */   public String masterrolename;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12601615;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SRelieveShiTuRelation()
/*     */   {
/*  36 */     this.apprenticerolename = "";
/*  37 */     this.masterrolename = "";
/*     */   }
/*     */   
/*     */   public SRelieveShiTuRelation(long _apprenticeroleid_, String _apprenticerolename_, long _masterroleid_, String _masterrolename_) {
/*  41 */     this.apprenticeroleid = _apprenticeroleid_;
/*  42 */     this.apprenticerolename = _apprenticerolename_;
/*  43 */     this.masterroleid = _masterroleid_;
/*  44 */     this.masterrolename = _masterrolename_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.apprenticeroleid);
/*  53 */     _os_.marshal(this.apprenticerolename, "UTF-16LE");
/*  54 */     _os_.marshal(this.masterroleid);
/*  55 */     _os_.marshal(this.masterrolename, "UTF-16LE");
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.apprenticeroleid = _os_.unmarshal_long();
/*  61 */     this.apprenticerolename = _os_.unmarshal_String("UTF-16LE");
/*  62 */     this.masterroleid = _os_.unmarshal_long();
/*  63 */     this.masterrolename = _os_.unmarshal_String("UTF-16LE");
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof SRelieveShiTuRelation)) {
/*  73 */       SRelieveShiTuRelation _o_ = (SRelieveShiTuRelation)_o1_;
/*  74 */       if (this.apprenticeroleid != _o_.apprenticeroleid) return false;
/*  75 */       if (!this.apprenticerolename.equals(_o_.apprenticerolename)) return false;
/*  76 */       if (this.masterroleid != _o_.masterroleid) return false;
/*  77 */       if (!this.masterrolename.equals(_o_.masterrolename)) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += (int)this.apprenticeroleid;
/*  86 */     _h_ += this.apprenticerolename.hashCode();
/*  87 */     _h_ += (int)this.masterroleid;
/*  88 */     _h_ += this.masterrolename.hashCode();
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.apprenticeroleid).append(",");
/*  96 */     _sb_.append("T").append(this.apprenticerolename.length()).append(",");
/*  97 */     _sb_.append(this.masterroleid).append(",");
/*  98 */     _sb_.append("T").append(this.masterrolename.length()).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\SRelieveShiTuRelation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */