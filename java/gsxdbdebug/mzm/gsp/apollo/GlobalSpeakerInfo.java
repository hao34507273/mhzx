/*    */ package mzm.gsp.apollo;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class GlobalSpeakerInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public Octets openid;
/*    */   public Octets nickname;
/*    */   public byte is_open_mic;
/*    */   
/*    */   public GlobalSpeakerInfo()
/*    */   {
/* 14 */     this.openid = new Octets();
/* 15 */     this.nickname = new Octets();
/*    */   }
/*    */   
/*    */   public GlobalSpeakerInfo(Octets _openid_, Octets _nickname_, byte _is_open_mic_) {
/* 19 */     this.openid = _openid_;
/* 20 */     this.nickname = _nickname_;
/* 21 */     this.is_open_mic = _is_open_mic_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.openid);
/* 30 */     _os_.marshal(this.nickname);
/* 31 */     _os_.marshal(this.is_open_mic);
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 36 */     this.openid = _os_.unmarshal_Octets();
/* 37 */     this.nickname = _os_.unmarshal_Octets();
/* 38 */     this.is_open_mic = _os_.unmarshal_byte();
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof GlobalSpeakerInfo)) {
/* 45 */       GlobalSpeakerInfo _o_ = (GlobalSpeakerInfo)_o1_;
/* 46 */       if (!this.openid.equals(_o_.openid)) return false;
/* 47 */       if (!this.nickname.equals(_o_.nickname)) return false;
/* 48 */       if (this.is_open_mic != _o_.is_open_mic) return false;
/* 49 */       return true;
/*    */     }
/* 51 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 55 */     int _h_ = 0;
/* 56 */     _h_ += this.openid.hashCode();
/* 57 */     _h_ += this.nickname.hashCode();
/* 58 */     _h_ += this.is_open_mic;
/* 59 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     StringBuilder _sb_ = new StringBuilder();
/* 64 */     _sb_.append("(");
/* 65 */     _sb_.append("B").append(this.openid.size()).append(",");
/* 66 */     _sb_.append("B").append(this.nickname.size()).append(",");
/* 67 */     _sb_.append(this.is_open_mic).append(",");
/* 68 */     _sb_.append(")");
/* 69 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\GlobalSpeakerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */