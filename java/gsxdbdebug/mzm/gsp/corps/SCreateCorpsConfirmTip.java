/*     */ package mzm.gsp.corps;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SCreateCorpsConfirmTip
/*     */   extends __SCreateCorpsConfirmTip__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617500;
/*     */   public long creatorid;
/*     */   public Octets name;
/*     */   public Octets declaration;
/*     */   public int corpsbadgeid;
/*     */   public long sessionid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617500;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SCreateCorpsConfirmTip()
/*     */   {
/*  37 */     this.name = new Octets();
/*  38 */     this.declaration = new Octets();
/*     */   }
/*     */   
/*     */   public SCreateCorpsConfirmTip(long _creatorid_, Octets _name_, Octets _declaration_, int _corpsbadgeid_, long _sessionid_) {
/*  42 */     this.creatorid = _creatorid_;
/*  43 */     this.name = _name_;
/*  44 */     this.declaration = _declaration_;
/*  45 */     this.corpsbadgeid = _corpsbadgeid_;
/*  46 */     this.sessionid = _sessionid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.creatorid);
/*  55 */     _os_.marshal(this.name);
/*  56 */     _os_.marshal(this.declaration);
/*  57 */     _os_.marshal(this.corpsbadgeid);
/*  58 */     _os_.marshal(this.sessionid);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.creatorid = _os_.unmarshal_long();
/*  64 */     this.name = _os_.unmarshal_Octets();
/*  65 */     this.declaration = _os_.unmarshal_Octets();
/*  66 */     this.corpsbadgeid = _os_.unmarshal_int();
/*  67 */     this.sessionid = _os_.unmarshal_long();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SCreateCorpsConfirmTip)) {
/*  77 */       SCreateCorpsConfirmTip _o_ = (SCreateCorpsConfirmTip)_o1_;
/*  78 */       if (this.creatorid != _o_.creatorid) return false;
/*  79 */       if (!this.name.equals(_o_.name)) return false;
/*  80 */       if (!this.declaration.equals(_o_.declaration)) return false;
/*  81 */       if (this.corpsbadgeid != _o_.corpsbadgeid) return false;
/*  82 */       if (this.sessionid != _o_.sessionid) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += (int)this.creatorid;
/*  91 */     _h_ += this.name.hashCode();
/*  92 */     _h_ += this.declaration.hashCode();
/*  93 */     _h_ += this.corpsbadgeid;
/*  94 */     _h_ += (int)this.sessionid;
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.creatorid).append(",");
/* 102 */     _sb_.append("B").append(this.name.size()).append(",");
/* 103 */     _sb_.append("B").append(this.declaration.size()).append(",");
/* 104 */     _sb_.append(this.corpsbadgeid).append(",");
/* 105 */     _sb_.append(this.sessionid).append(",");
/* 106 */     _sb_.append(")");
/* 107 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\SCreateCorpsConfirmTip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */