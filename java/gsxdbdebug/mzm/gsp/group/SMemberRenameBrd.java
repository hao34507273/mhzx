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
/*    */ public class SMemberRenameBrd
/*    */   extends __SMemberRenameBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605205;
/*    */   public long groupid;
/*    */   public long memberid;
/*    */   public Octets name;
/*    */   public long info_version;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12605205;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SMemberRenameBrd()
/*    */   {
/* 36 */     this.name = new Octets();
/*    */   }
/*    */   
/*    */   public SMemberRenameBrd(long _groupid_, long _memberid_, Octets _name_, long _info_version_) {
/* 40 */     this.groupid = _groupid_;
/* 41 */     this.memberid = _memberid_;
/* 42 */     this.name = _name_;
/* 43 */     this.info_version = _info_version_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.groupid);
/* 52 */     _os_.marshal(this.memberid);
/* 53 */     _os_.marshal(this.name);
/* 54 */     _os_.marshal(this.info_version);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.groupid = _os_.unmarshal_long();
/* 60 */     this.memberid = _os_.unmarshal_long();
/* 61 */     this.name = _os_.unmarshal_Octets();
/* 62 */     this.info_version = _os_.unmarshal_long();
/* 63 */     if (!_validator_()) {
/* 64 */       throw new VerifyError("validator failed");
/*    */     }
/* 66 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 70 */     if (_o1_ == this) return true;
/* 71 */     if ((_o1_ instanceof SMemberRenameBrd)) {
/* 72 */       SMemberRenameBrd _o_ = (SMemberRenameBrd)_o1_;
/* 73 */       if (this.groupid != _o_.groupid) return false;
/* 74 */       if (this.memberid != _o_.memberid) return false;
/* 75 */       if (!this.name.equals(_o_.name)) return false;
/* 76 */       if (this.info_version != _o_.info_version) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += (int)this.groupid;
/* 85 */     _h_ += (int)this.memberid;
/* 86 */     _h_ += this.name.hashCode();
/* 87 */     _h_ += (int)this.info_version;
/* 88 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 92 */     StringBuilder _sb_ = new StringBuilder();
/* 93 */     _sb_.append("(");
/* 94 */     _sb_.append(this.groupid).append(",");
/* 95 */     _sb_.append(this.memberid).append(",");
/* 96 */     _sb_.append("B").append(this.name.size()).append(",");
/* 97 */     _sb_.append(this.info_version).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\SMemberRenameBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */