/*     */ package mzm.gsp.group;
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
/*     */ public class SInviteJoinGroupSuccessBrd
/*     */   extends __SInviteJoinGroupSuccessBrd__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12605218;
/*     */   public long groupid;
/*     */   public long inviter;
/*     */   public GroupMemberInfo newmember;
/*     */   public long info_version;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12605218;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SInviteJoinGroupSuccessBrd()
/*     */   {
/*  36 */     this.newmember = new GroupMemberInfo();
/*     */   }
/*     */   
/*     */   public SInviteJoinGroupSuccessBrd(long _groupid_, long _inviter_, GroupMemberInfo _newmember_, long _info_version_) {
/*  40 */     this.groupid = _groupid_;
/*  41 */     this.inviter = _inviter_;
/*  42 */     this.newmember = _newmember_;
/*  43 */     this.info_version = _info_version_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     if (!this.newmember._validator_()) return false;
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.groupid);
/*  53 */     _os_.marshal(this.inviter);
/*  54 */     _os_.marshal(this.newmember);
/*  55 */     _os_.marshal(this.info_version);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.groupid = _os_.unmarshal_long();
/*  61 */     this.inviter = _os_.unmarshal_long();
/*  62 */     this.newmember.unmarshal(_os_);
/*  63 */     this.info_version = _os_.unmarshal_long();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof SInviteJoinGroupSuccessBrd)) {
/*  73 */       SInviteJoinGroupSuccessBrd _o_ = (SInviteJoinGroupSuccessBrd)_o1_;
/*  74 */       if (this.groupid != _o_.groupid) return false;
/*  75 */       if (this.inviter != _o_.inviter) return false;
/*  76 */       if (!this.newmember.equals(_o_.newmember)) return false;
/*  77 */       if (this.info_version != _o_.info_version) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += (int)this.groupid;
/*  86 */     _h_ += (int)this.inviter;
/*  87 */     _h_ += this.newmember.hashCode();
/*  88 */     _h_ += (int)this.info_version;
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.groupid).append(",");
/*  96 */     _sb_.append(this.inviter).append(",");
/*  97 */     _sb_.append(this.newmember).append(",");
/*  98 */     _sb_.append(this.info_version).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\SInviteJoinGroupSuccessBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */