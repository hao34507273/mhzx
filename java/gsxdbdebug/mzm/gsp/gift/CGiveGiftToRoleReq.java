/*     */ package mzm.gsp.gift;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.gift.main.PCGiveGiftRoleReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CGiveGiftToRoleReq
/*     */   extends __CGiveGiftToRoleReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12611074;
/*     */   public long roleid;
/*     */   public long invitationuuid;
/*     */   public int giftcfgid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     Role.addRoleProcedure(roleid, new PCGiveGiftRoleReq(roleid, this.roleid, this.invitationuuid, this.giftcfgid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  29 */     return 12611074;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CGiveGiftToRoleReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CGiveGiftToRoleReq(long _roleid_, long _invitationuuid_, int _giftcfgid_)
/*     */   {
/*  40 */     this.roleid = _roleid_;
/*  41 */     this.invitationuuid = _invitationuuid_;
/*  42 */     this.giftcfgid = _giftcfgid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.roleid);
/*  51 */     _os_.marshal(this.invitationuuid);
/*  52 */     _os_.marshal(this.giftcfgid);
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  57 */     this.roleid = _os_.unmarshal_long();
/*  58 */     this.invitationuuid = _os_.unmarshal_long();
/*  59 */     this.giftcfgid = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CGiveGiftToRoleReq)) {
/*  69 */       CGiveGiftToRoleReq _o_ = (CGiveGiftToRoleReq)_o1_;
/*  70 */       if (this.roleid != _o_.roleid) return false;
/*  71 */       if (this.invitationuuid != _o_.invitationuuid) return false;
/*  72 */       if (this.giftcfgid != _o_.giftcfgid) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += (int)this.roleid;
/*  81 */     _h_ += (int)this.invitationuuid;
/*  82 */     _h_ += this.giftcfgid;
/*  83 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  87 */     StringBuilder _sb_ = new StringBuilder();
/*  88 */     _sb_.append("(");
/*  89 */     _sb_.append(this.roleid).append(",");
/*  90 */     _sb_.append(this.invitationuuid).append(",");
/*  91 */     _sb_.append(this.giftcfgid).append(",");
/*  92 */     _sb_.append(")");
/*  93 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGiveGiftToRoleReq _o_) {
/*  97 */     if (_o_ == this) return 0;
/*  98 */     int _c_ = 0;
/*  99 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = Long.signum(this.invitationuuid - _o_.invitationuuid);
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.giftcfgid - _o_.giftcfgid;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gift\CGiveGiftToRoleReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */