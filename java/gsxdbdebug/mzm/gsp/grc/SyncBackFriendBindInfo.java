/*    */ package mzm.gsp.grc;
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
/*    */ 
/*    */ public class SyncBackFriendBindInfo
/*    */   extends __SyncBackFriendBindInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600375;
/*    */   public ArrayList<FriendBindInfo> back_friends;
/*    */   public RebateInfo rebate_info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12600375;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SyncBackFriendBindInfo()
/*    */   {
/* 34 */     this.back_friends = new ArrayList();
/* 35 */     this.rebate_info = new RebateInfo();
/*    */   }
/*    */   
/*    */   public SyncBackFriendBindInfo(ArrayList<FriendBindInfo> _back_friends_, RebateInfo _rebate_info_) {
/* 39 */     this.back_friends = _back_friends_;
/* 40 */     this.rebate_info = _rebate_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     for (FriendBindInfo _v_ : this.back_friends)
/* 45 */       if (!_v_._validator_()) return false;
/* 46 */     if (!this.rebate_info._validator_()) return false;
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.compact_uint32(this.back_friends.size());
/* 52 */     for (FriendBindInfo _v_ : this.back_friends) {
/* 53 */       _os_.marshal(_v_);
/*    */     }
/* 55 */     _os_.marshal(this.rebate_info);
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 60 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 61 */       FriendBindInfo _v_ = new FriendBindInfo();
/* 62 */       _v_.unmarshal(_os_);
/* 63 */       this.back_friends.add(_v_);
/*    */     }
/* 65 */     this.rebate_info.unmarshal(_os_);
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof SyncBackFriendBindInfo)) {
/* 75 */       SyncBackFriendBindInfo _o_ = (SyncBackFriendBindInfo)_o1_;
/* 76 */       if (!this.back_friends.equals(_o_.back_friends)) return false;
/* 77 */       if (!this.rebate_info.equals(_o_.rebate_info)) return false;
/* 78 */       return true;
/*    */     }
/* 80 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 84 */     int _h_ = 0;
/* 85 */     _h_ += this.back_friends.hashCode();
/* 86 */     _h_ += this.rebate_info.hashCode();
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append(this.back_friends).append(",");
/* 94 */     _sb_.append(this.rebate_info).append(",");
/* 95 */     _sb_.append(")");
/* 96 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\SyncBackFriendBindInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */