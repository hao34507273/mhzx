/*     */ package mzm.gsp.gift;
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
/*     */ 
/*     */ public class SGiveGiftToRoleRes
/*     */   extends __SGiveGiftToRoleRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12611077;
/*     */   public long roleid;
/*     */   public long invitationuuid;
/*     */   public int giftcfgid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12611077;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SGiveGiftToRoleRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SGiveGiftToRoleRes(long _roleid_, long _invitationuuid_, int _giftcfgid_)
/*     */   {
/*  38 */     this.roleid = _roleid_;
/*  39 */     this.invitationuuid = _invitationuuid_;
/*  40 */     this.giftcfgid = _giftcfgid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.roleid);
/*  49 */     _os_.marshal(this.invitationuuid);
/*  50 */     _os_.marshal(this.giftcfgid);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.roleid = _os_.unmarshal_long();
/*  56 */     this.invitationuuid = _os_.unmarshal_long();
/*  57 */     this.giftcfgid = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SGiveGiftToRoleRes)) {
/*  67 */       SGiveGiftToRoleRes _o_ = (SGiveGiftToRoleRes)_o1_;
/*  68 */       if (this.roleid != _o_.roleid) return false;
/*  69 */       if (this.invitationuuid != _o_.invitationuuid) return false;
/*  70 */       if (this.giftcfgid != _o_.giftcfgid) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += (int)this.roleid;
/*  79 */     _h_ += (int)this.invitationuuid;
/*  80 */     _h_ += this.giftcfgid;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.roleid).append(",");
/*  88 */     _sb_.append(this.invitationuuid).append(",");
/*  89 */     _sb_.append(this.giftcfgid).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGiveGiftToRoleRes _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = Long.signum(this.invitationuuid - _o_.invitationuuid);
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.giftcfgid - _o_.giftcfgid;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gift\SGiveGiftToRoleRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */