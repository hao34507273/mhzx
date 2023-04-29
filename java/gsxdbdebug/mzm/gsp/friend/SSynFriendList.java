/*    */ package mzm.gsp.friend;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSynFriendList
/*    */   extends __SSynFriendList__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587021;
/*    */   public ArrayList<FriendInfo> friendlist;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12587021;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSynFriendList()
/*    */   {
/* 31 */     this.friendlist = new ArrayList();
/*    */   }
/*    */   
/*    */   public SSynFriendList(ArrayList<FriendInfo> _friendlist_) {
/* 35 */     this.friendlist = _friendlist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 39 */     for (FriendInfo _v_ : this.friendlist)
/* 40 */       if (!_v_._validator_()) return false;
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.compact_uint32(this.friendlist.size());
/* 46 */     for (FriendInfo _v_ : this.friendlist) {
/* 47 */       _os_.marshal(_v_);
/*    */     }
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 54 */       FriendInfo _v_ = new FriendInfo();
/* 55 */       _v_.unmarshal(_os_);
/* 56 */       this.friendlist.add(_v_);
/*    */     }
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SSynFriendList)) {
/* 67 */       SSynFriendList _o_ = (SSynFriendList)_o1_;
/* 68 */       if (!this.friendlist.equals(_o_.friendlist)) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.friendlist.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.friendlist).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\SSynFriendList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */