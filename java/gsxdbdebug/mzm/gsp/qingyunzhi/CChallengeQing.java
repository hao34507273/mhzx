/*     */ package mzm.gsp.qingyunzhi;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.qingyunzhi.main.PCChallengeQing;
/*     */ 
/*     */ 
/*     */ public class CChallengeQing
/*     */   extends __CChallengeQing__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590341;
/*     */   public int outposttype;
/*     */   public int chapter;
/*     */   public int section;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 1L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new PCChallengeQing(roleId, this.outposttype, this.chapter, this.section));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12590341;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CChallengeQing() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CChallengeQing(int _outposttype_, int _chapter_, int _section_)
/*     */   {
/*  42 */     this.outposttype = _outposttype_;
/*  43 */     this.chapter = _chapter_;
/*  44 */     this.section = _section_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.outposttype);
/*  53 */     _os_.marshal(this.chapter);
/*  54 */     _os_.marshal(this.section);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.outposttype = _os_.unmarshal_int();
/*  60 */     this.chapter = _os_.unmarshal_int();
/*  61 */     this.section = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof CChallengeQing)) {
/*  71 */       CChallengeQing _o_ = (CChallengeQing)_o1_;
/*  72 */       if (this.outposttype != _o_.outposttype) return false;
/*  73 */       if (this.chapter != _o_.chapter) return false;
/*  74 */       if (this.section != _o_.section) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += this.outposttype;
/*  83 */     _h_ += this.chapter;
/*  84 */     _h_ += this.section;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.outposttype).append(",");
/*  92 */     _sb_.append(this.chapter).append(",");
/*  93 */     _sb_.append(this.section).append(",");
/*  94 */     _sb_.append(")");
/*  95 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CChallengeQing _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     _c_ = this.outposttype - _o_.outposttype;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.chapter - _o_.chapter;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.section - _o_.section;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyunzhi\CChallengeQing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */