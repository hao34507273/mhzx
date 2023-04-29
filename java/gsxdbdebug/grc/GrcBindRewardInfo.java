/*    */ package grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class GrcBindRewardInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public ArrayList<GrcBackBindFriendInfo> back_friends;
/*    */   public GrcRebateInfo rebate_info;
/*    */   
/*    */   public GrcBindRewardInfo()
/*    */   {
/* 13 */     this.back_friends = new ArrayList();
/* 14 */     this.rebate_info = new GrcRebateInfo();
/*    */   }
/*    */   
/*    */   public GrcBindRewardInfo(ArrayList<GrcBackBindFriendInfo> _back_friends_, GrcRebateInfo _rebate_info_) {
/* 18 */     this.back_friends = _back_friends_;
/* 19 */     this.rebate_info = _rebate_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     for (GrcBackBindFriendInfo _v_ : this.back_friends)
/* 24 */       if (!_v_._validator_()) return false;
/* 25 */     if (!this.rebate_info._validator_()) return false;
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.compact_uint32(this.back_friends.size());
/* 31 */     for (GrcBackBindFriendInfo _v_ : this.back_friends) {
/* 32 */       _os_.marshal(_v_);
/*    */     }
/* 34 */     _os_.marshal(this.rebate_info);
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 39 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 40 */       GrcBackBindFriendInfo _v_ = new GrcBackBindFriendInfo();
/* 41 */       _v_.unmarshal(_os_);
/* 42 */       this.back_friends.add(_v_);
/*    */     }
/* 44 */     this.rebate_info.unmarshal(_os_);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 49 */     if (_o1_ == this) return true;
/* 50 */     if ((_o1_ instanceof GrcBindRewardInfo)) {
/* 51 */       GrcBindRewardInfo _o_ = (GrcBindRewardInfo)_o1_;
/* 52 */       if (!this.back_friends.equals(_o_.back_friends)) return false;
/* 53 */       if (!this.rebate_info.equals(_o_.rebate_info)) return false;
/* 54 */       return true;
/*    */     }
/* 56 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 60 */     int _h_ = 0;
/* 61 */     _h_ += this.back_friends.hashCode();
/* 62 */     _h_ += this.rebate_info.hashCode();
/* 63 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 67 */     StringBuilder _sb_ = new StringBuilder();
/* 68 */     _sb_.append("(");
/* 69 */     _sb_.append(this.back_friends).append(",");
/* 70 */     _sb_.append(this.rebate_info).append(",");
/* 71 */     _sb_.append(")");
/* 72 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcBindRewardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */