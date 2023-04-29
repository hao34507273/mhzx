/*     */ package mzm.gsp.marriage;
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
/*     */ public class SSendMarriageMsgToFriend
/*     */   extends __SSendMarriageMsgToFriend__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12599811;
/*     */   public long roleid;
/*     */   public String roleidaname;
/*     */   public String roleidbname;
/*     */   public int level;
/*     */   public int timesec;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12599811;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSendMarriageMsgToFriend()
/*     */   {
/*  37 */     this.roleidaname = "";
/*  38 */     this.roleidbname = "";
/*     */   }
/*     */   
/*     */   public SSendMarriageMsgToFriend(long _roleid_, String _roleidaname_, String _roleidbname_, int _level_, int _timesec_) {
/*  42 */     this.roleid = _roleid_;
/*  43 */     this.roleidaname = _roleidaname_;
/*  44 */     this.roleidbname = _roleidbname_;
/*  45 */     this.level = _level_;
/*  46 */     this.timesec = _timesec_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.roleid);
/*  55 */     _os_.marshal(this.roleidaname, "UTF-16LE");
/*  56 */     _os_.marshal(this.roleidbname, "UTF-16LE");
/*  57 */     _os_.marshal(this.level);
/*  58 */     _os_.marshal(this.timesec);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.roleid = _os_.unmarshal_long();
/*  64 */     this.roleidaname = _os_.unmarshal_String("UTF-16LE");
/*  65 */     this.roleidbname = _os_.unmarshal_String("UTF-16LE");
/*  66 */     this.level = _os_.unmarshal_int();
/*  67 */     this.timesec = _os_.unmarshal_int();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SSendMarriageMsgToFriend)) {
/*  77 */       SSendMarriageMsgToFriend _o_ = (SSendMarriageMsgToFriend)_o1_;
/*  78 */       if (this.roleid != _o_.roleid) return false;
/*  79 */       if (!this.roleidaname.equals(_o_.roleidaname)) return false;
/*  80 */       if (!this.roleidbname.equals(_o_.roleidbname)) return false;
/*  81 */       if (this.level != _o_.level) return false;
/*  82 */       if (this.timesec != _o_.timesec) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += (int)this.roleid;
/*  91 */     _h_ += this.roleidaname.hashCode();
/*  92 */     _h_ += this.roleidbname.hashCode();
/*  93 */     _h_ += this.level;
/*  94 */     _h_ += this.timesec;
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.roleid).append(",");
/* 102 */     _sb_.append("T").append(this.roleidaname.length()).append(",");
/* 103 */     _sb_.append("T").append(this.roleidbname.length()).append(",");
/* 104 */     _sb_.append(this.level).append(",");
/* 105 */     _sb_.append(this.timesec).append(",");
/* 106 */     _sb_.append(")");
/* 107 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\SSendMarriageMsgToFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */