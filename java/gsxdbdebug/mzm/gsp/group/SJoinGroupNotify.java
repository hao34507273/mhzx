/*    */ package mzm.gsp.group;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SJoinGroupNotify
/*    */   extends __SJoinGroupNotify__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605202;
/*    */   public long inviterid;
/*    */   public Octets inviter_name;
/*    */   public GroupInfo group_basic_info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12605202;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SJoinGroupNotify()
/*    */   {
/* 35 */     this.inviter_name = new Octets();
/* 36 */     this.group_basic_info = new GroupInfo();
/*    */   }
/*    */   
/*    */   public SJoinGroupNotify(long _inviterid_, Octets _inviter_name_, GroupInfo _group_basic_info_) {
/* 40 */     this.inviterid = _inviterid_;
/* 41 */     this.inviter_name = _inviter_name_;
/* 42 */     this.group_basic_info = _group_basic_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     if (!this.group_basic_info._validator_()) return false;
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.inviterid);
/* 52 */     _os_.marshal(this.inviter_name);
/* 53 */     _os_.marshal(this.group_basic_info);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.inviterid = _os_.unmarshal_long();
/* 59 */     this.inviter_name = _os_.unmarshal_Octets();
/* 60 */     this.group_basic_info.unmarshal(_os_);
/* 61 */     if (!_validator_()) {
/* 62 */       throw new VerifyError("validator failed");
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 68 */     if (_o1_ == this) return true;
/* 69 */     if ((_o1_ instanceof SJoinGroupNotify)) {
/* 70 */       SJoinGroupNotify _o_ = (SJoinGroupNotify)_o1_;
/* 71 */       if (this.inviterid != _o_.inviterid) return false;
/* 72 */       if (!this.inviter_name.equals(_o_.inviter_name)) return false;
/* 73 */       if (!this.group_basic_info.equals(_o_.group_basic_info)) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += (int)this.inviterid;
/* 82 */     _h_ += this.inviter_name.hashCode();
/* 83 */     _h_ += this.group_basic_info.hashCode();
/* 84 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 88 */     StringBuilder _sb_ = new StringBuilder();
/* 89 */     _sb_.append("(");
/* 90 */     _sb_.append(this.inviterid).append(",");
/* 91 */     _sb_.append("B").append(this.inviter_name.size()).append(",");
/* 92 */     _sb_.append(this.group_basic_info).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\SJoinGroupNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */