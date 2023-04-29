/*     */ package mzm.gsp.corps;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.corps.main.PCCreateCorpsConfirmRep;
/*     */ 
/*     */ public class CCreateCorpsConfirmRep
/*     */   extends __CCreateCorpsConfirmRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617501;
/*     */   public static final int REPLY_ACCEPT = 1;
/*     */   public static final int REPLY_REFUSE = 2;
/*     */   public long sessionid;
/*     */   public int reply;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new PCCreateCorpsConfirmRep(roleId, this.reply, this.sessionid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12617501;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CCreateCorpsConfirmRep() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CCreateCorpsConfirmRep(long _sessionid_, int _reply_)
/*     */   {
/*  44 */     this.sessionid = _sessionid_;
/*  45 */     this.reply = _reply_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.sessionid);
/*  54 */     _os_.marshal(this.reply);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.sessionid = _os_.unmarshal_long();
/*  60 */     this.reply = _os_.unmarshal_int();
/*  61 */     if (!_validator_()) {
/*  62 */       throw new VerifyError("validator failed");
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  68 */     if (_o1_ == this) return true;
/*  69 */     if ((_o1_ instanceof CCreateCorpsConfirmRep)) {
/*  70 */       CCreateCorpsConfirmRep _o_ = (CCreateCorpsConfirmRep)_o1_;
/*  71 */       if (this.sessionid != _o_.sessionid) return false;
/*  72 */       if (this.reply != _o_.reply) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += (int)this.sessionid;
/*  81 */     _h_ += this.reply;
/*  82 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  86 */     StringBuilder _sb_ = new StringBuilder();
/*  87 */     _sb_.append("(");
/*  88 */     _sb_.append(this.sessionid).append(",");
/*  89 */     _sb_.append(this.reply).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CCreateCorpsConfirmRep _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = Long.signum(this.sessionid - _o_.sessionid);
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.reply - _o_.reply;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\CCreateCorpsConfirmRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */