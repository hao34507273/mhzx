/*    */ package mzm.gsp.friend;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSynFriendName
/*    */   extends __SSynFriendName__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587028;
/*    */   public long friendid;
/*    */   public String name;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12587028;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynFriendName()
/*    */   {
/* 32 */     this.name = "";
/*    */   }
/*    */   
/*    */   public SSynFriendName(long _friendid_, String _name_) {
/* 36 */     this.friendid = _friendid_;
/* 37 */     this.name = _name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.marshal(this.friendid);
/* 46 */     _os_.marshal(this.name, "UTF-16LE");
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.friendid = _os_.unmarshal_long();
/* 52 */     this.name = _os_.unmarshal_String("UTF-16LE");
/* 53 */     if (!_validator_()) {
/* 54 */       throw new VerifyError("validator failed");
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 60 */     if (_o1_ == this) return true;
/* 61 */     if ((_o1_ instanceof SSynFriendName)) {
/* 62 */       SSynFriendName _o_ = (SSynFriendName)_o1_;
/* 63 */       if (this.friendid != _o_.friendid) return false;
/* 64 */       if (!this.name.equals(_o_.name)) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += (int)this.friendid;
/* 73 */     _h_ += this.name.hashCode();
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append(this.friendid).append(",");
/* 81 */     _sb_.append("T").append(this.name.length()).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\SSynFriendName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */