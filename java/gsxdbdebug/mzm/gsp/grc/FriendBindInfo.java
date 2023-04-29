/*    */ package mzm.gsp.grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class FriendBindInfo
/*    */   implements Marshal
/*    */ {
/*    */   public RecallUserInfo user_info;
/*    */   public int bind_time;
/*    */   
/*    */   public FriendBindInfo()
/*    */   {
/* 15 */     this.user_info = new RecallUserInfo();
/*    */   }
/*    */   
/*    */   public FriendBindInfo(RecallUserInfo _user_info_, int _bind_time_) {
/* 19 */     this.user_info = _user_info_;
/* 20 */     this.bind_time = _bind_time_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     if (!this.user_info._validator_()) return false;
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.user_info);
/* 30 */     _os_.marshal(this.bind_time);
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 35 */     this.user_info.unmarshal(_os_);
/* 36 */     this.bind_time = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 41 */     if (_o1_ == this) return true;
/* 42 */     if ((_o1_ instanceof FriendBindInfo)) {
/* 43 */       FriendBindInfo _o_ = (FriendBindInfo)_o1_;
/* 44 */       if (!this.user_info.equals(_o_.user_info)) return false;
/* 45 */       if (this.bind_time != _o_.bind_time) return false;
/* 46 */       return true;
/*    */     }
/* 48 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 52 */     int _h_ = 0;
/* 53 */     _h_ += this.user_info.hashCode();
/* 54 */     _h_ += this.bind_time;
/* 55 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 59 */     StringBuilder _sb_ = new StringBuilder();
/* 60 */     _sb_.append("(");
/* 61 */     _sb_.append(this.user_info).append(",");
/* 62 */     _sb_.append(this.bind_time).append(",");
/* 63 */     _sb_.append(")");
/* 64 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\FriendBindInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */