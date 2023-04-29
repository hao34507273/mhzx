/*     */ package mzm.gsp.group;
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
/*     */ public class SKickGroupMemberSuccessBrd
/*     */   extends __SKickGroupMemberSuccessBrd__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12605214;
/*     */   public long groupid;
/*     */   public Octets group_name;
/*     */   public Octets master_name;
/*     */   public long memberid;
/*     */   public long info_version;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12605214;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SKickGroupMemberSuccessBrd()
/*     */   {
/*  37 */     this.group_name = new Octets();
/*  38 */     this.master_name = new Octets();
/*     */   }
/*     */   
/*     */   public SKickGroupMemberSuccessBrd(long _groupid_, Octets _group_name_, Octets _master_name_, long _memberid_, long _info_version_) {
/*  42 */     this.groupid = _groupid_;
/*  43 */     this.group_name = _group_name_;
/*  44 */     this.master_name = _master_name_;
/*  45 */     this.memberid = _memberid_;
/*  46 */     this.info_version = _info_version_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.groupid);
/*  55 */     _os_.marshal(this.group_name);
/*  56 */     _os_.marshal(this.master_name);
/*  57 */     _os_.marshal(this.memberid);
/*  58 */     _os_.marshal(this.info_version);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.groupid = _os_.unmarshal_long();
/*  64 */     this.group_name = _os_.unmarshal_Octets();
/*  65 */     this.master_name = _os_.unmarshal_Octets();
/*  66 */     this.memberid = _os_.unmarshal_long();
/*  67 */     this.info_version = _os_.unmarshal_long();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SKickGroupMemberSuccessBrd)) {
/*  77 */       SKickGroupMemberSuccessBrd _o_ = (SKickGroupMemberSuccessBrd)_o1_;
/*  78 */       if (this.groupid != _o_.groupid) return false;
/*  79 */       if (!this.group_name.equals(_o_.group_name)) return false;
/*  80 */       if (!this.master_name.equals(_o_.master_name)) return false;
/*  81 */       if (this.memberid != _o_.memberid) return false;
/*  82 */       if (this.info_version != _o_.info_version) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += (int)this.groupid;
/*  91 */     _h_ += this.group_name.hashCode();
/*  92 */     _h_ += this.master_name.hashCode();
/*  93 */     _h_ += (int)this.memberid;
/*  94 */     _h_ += (int)this.info_version;
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.groupid).append(",");
/* 102 */     _sb_.append("B").append(this.group_name.size()).append(",");
/* 103 */     _sb_.append("B").append(this.master_name.size()).append(",");
/* 104 */     _sb_.append(this.memberid).append(",");
/* 105 */     _sb_.append(this.info_version).append(",");
/* 106 */     _sb_.append(")");
/* 107 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\SKickGroupMemberSuccessBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */