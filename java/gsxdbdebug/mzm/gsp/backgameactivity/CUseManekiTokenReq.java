/*     */ package mzm.gsp.backgameactivity;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.backgameactivity.main.PCUseManekiTokenReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CUseManekiTokenReq
/*     */   extends __CUseManekiTokenReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12620568;
/*     */   public int activityid;
/*     */   public int manekitokencfgid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId <= 0L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCUseManekiTokenReq(roleId, this.activityid, this.manekitokencfgid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12620568;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CUseManekiTokenReq() {}
/*     */   
/*     */ 
/*     */   public CUseManekiTokenReq(int _activityid_, int _manekitokencfgid_)
/*     */   {
/*  43 */     this.activityid = _activityid_;
/*  44 */     this.manekitokencfgid = _manekitokencfgid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.activityid);
/*  53 */     _os_.marshal(this.manekitokencfgid);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.activityid = _os_.unmarshal_int();
/*  59 */     this.manekitokencfgid = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CUseManekiTokenReq)) {
/*  69 */       CUseManekiTokenReq _o_ = (CUseManekiTokenReq)_o1_;
/*  70 */       if (this.activityid != _o_.activityid) return false;
/*  71 */       if (this.manekitokencfgid != _o_.manekitokencfgid) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += this.activityid;
/*  80 */     _h_ += this.manekitokencfgid;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.activityid).append(",");
/*  88 */     _sb_.append(this.manekitokencfgid).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CUseManekiTokenReq _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = this.activityid - _o_.activityid;
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.manekitokencfgid - _o_.manekitokencfgid;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\CUseManekiTokenReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */