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
/*    */ 
/*    */ public class SAddNewFriendRes
/*    */   extends __SAddNewFriendRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587022;
/*    */   public FriendInfo friendinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12587022;
/*    */   }
/*    */   
/*    */ 
/*    */   public SAddNewFriendRes()
/*    */   {
/* 31 */     this.friendinfo = new FriendInfo();
/*    */   }
/*    */   
/*    */   public SAddNewFriendRes(FriendInfo _friendinfo_) {
/* 35 */     this.friendinfo = _friendinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 39 */     if (!this.friendinfo._validator_()) return false;
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.friendinfo);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 49 */     this.friendinfo.unmarshal(_os_);
/* 50 */     if (!_validator_()) {
/* 51 */       throw new VerifyError("validator failed");
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof SAddNewFriendRes)) {
/* 59 */       SAddNewFriendRes _o_ = (SAddNewFriendRes)_o1_;
/* 60 */       if (!this.friendinfo.equals(_o_.friendinfo)) return false;
/* 61 */       return true;
/*    */     }
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 67 */     int _h_ = 0;
/* 68 */     _h_ += this.friendinfo.hashCode();
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.friendinfo).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\SAddNewFriendRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */