/*    */ package mzm.gsp.grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class GrcPassedFriendInfo implements Marshal
/*    */ {
/*    */   public Octets nickname;
/*    */   public Octets figure_url;
/*    */   
/*    */   public GrcPassedFriendInfo()
/*    */   {
/* 15 */     this.nickname = new Octets();
/* 16 */     this.figure_url = new Octets();
/*    */   }
/*    */   
/*    */   public GrcPassedFriendInfo(Octets _nickname_, Octets _figure_url_) {
/* 20 */     this.nickname = _nickname_;
/* 21 */     this.figure_url = _figure_url_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.nickname);
/* 30 */     _os_.marshal(this.figure_url);
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 35 */     this.nickname = _os_.unmarshal_Octets();
/* 36 */     this.figure_url = _os_.unmarshal_Octets();
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 41 */     if (_o1_ == this) return true;
/* 42 */     if ((_o1_ instanceof GrcPassedFriendInfo)) {
/* 43 */       GrcPassedFriendInfo _o_ = (GrcPassedFriendInfo)_o1_;
/* 44 */       if (!this.nickname.equals(_o_.nickname)) return false;
/* 45 */       if (!this.figure_url.equals(_o_.figure_url)) return false;
/* 46 */       return true;
/*    */     }
/* 48 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 52 */     int _h_ = 0;
/* 53 */     _h_ += this.nickname.hashCode();
/* 54 */     _h_ += this.figure_url.hashCode();
/* 55 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 59 */     StringBuilder _sb_ = new StringBuilder();
/* 60 */     _sb_.append("(");
/* 61 */     _sb_.append("B").append(this.nickname.size()).append(",");
/* 62 */     _sb_.append("B").append(this.figure_url.size()).append(",");
/* 63 */     _sb_.append(")");
/* 64 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\GrcPassedFriendInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */