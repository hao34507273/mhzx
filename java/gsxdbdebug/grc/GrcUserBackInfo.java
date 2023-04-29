/*    */ package grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class GrcUserBackInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int first;
/*    */   public long back_time;
/*    */   public ArrayList<GrcRecallFriendInfo> recall_friends;
/*    */   
/*    */   public GrcUserBackInfo()
/*    */   {
/* 14 */     this.recall_friends = new ArrayList();
/*    */   }
/*    */   
/*    */   public GrcUserBackInfo(int _first_, long _back_time_, ArrayList<GrcRecallFriendInfo> _recall_friends_) {
/* 18 */     this.first = _first_;
/* 19 */     this.back_time = _back_time_;
/* 20 */     this.recall_friends = _recall_friends_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     for (GrcRecallFriendInfo _v_ : this.recall_friends)
/* 25 */       if (!_v_._validator_()) return false;
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.marshal(this.first);
/* 31 */     _os_.marshal(this.back_time);
/* 32 */     _os_.compact_uint32(this.recall_friends.size());
/* 33 */     for (GrcRecallFriendInfo _v_ : this.recall_friends) {
/* 34 */       _os_.marshal(_v_);
/*    */     }
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 40 */     this.first = _os_.unmarshal_int();
/* 41 */     this.back_time = _os_.unmarshal_long();
/* 42 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 43 */       GrcRecallFriendInfo _v_ = new GrcRecallFriendInfo();
/* 44 */       _v_.unmarshal(_os_);
/* 45 */       this.recall_friends.add(_v_);
/*    */     }
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 51 */     if (_o1_ == this) return true;
/* 52 */     if ((_o1_ instanceof GrcUserBackInfo)) {
/* 53 */       GrcUserBackInfo _o_ = (GrcUserBackInfo)_o1_;
/* 54 */       if (this.first != _o_.first) return false;
/* 55 */       if (this.back_time != _o_.back_time) return false;
/* 56 */       if (!this.recall_friends.equals(_o_.recall_friends)) return false;
/* 57 */       return true;
/*    */     }
/* 59 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 63 */     int _h_ = 0;
/* 64 */     _h_ += this.first;
/* 65 */     _h_ += (int)this.back_time;
/* 66 */     _h_ += this.recall_friends.hashCode();
/* 67 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 71 */     StringBuilder _sb_ = new StringBuilder();
/* 72 */     _sb_.append("(");
/* 73 */     _sb_.append(this.first).append(",");
/* 74 */     _sb_.append(this.back_time).append(",");
/* 75 */     _sb_.append(this.recall_friends).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcUserBackInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */