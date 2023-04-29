/*    */ package grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class GrcReceiveGiftInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int gift_type;
/*    */   public long serialid;
/*    */   public Octets from_openid;
/*    */   public Octets from_nickname;
/*    */   public Octets from_figure_url;
/*    */   public int gift_count;
/*    */   public int timestamp;
/*    */   
/*    */   public GrcReceiveGiftInfo()
/*    */   {
/* 18 */     this.gift_type = 1;
/* 19 */     this.from_openid = new Octets();
/* 20 */     this.from_nickname = new Octets();
/* 21 */     this.from_figure_url = new Octets();
/*    */   }
/*    */   
/*    */   public GrcReceiveGiftInfo(int _gift_type_, long _serialid_, Octets _from_openid_, Octets _from_nickname_, Octets _from_figure_url_, int _gift_count_, int _timestamp_) {
/* 25 */     this.gift_type = _gift_type_;
/* 26 */     this.serialid = _serialid_;
/* 27 */     this.from_openid = _from_openid_;
/* 28 */     this.from_nickname = _from_nickname_;
/* 29 */     this.from_figure_url = _from_figure_url_;
/* 30 */     this.gift_count = _gift_count_;
/* 31 */     this.timestamp = _timestamp_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 39 */     _os_.marshal(this.gift_type);
/* 40 */     _os_.marshal(this.serialid);
/* 41 */     _os_.marshal(this.from_openid);
/* 42 */     _os_.marshal(this.from_nickname);
/* 43 */     _os_.marshal(this.from_figure_url);
/* 44 */     _os_.marshal(this.gift_count);
/* 45 */     _os_.marshal(this.timestamp);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 50 */     this.gift_type = _os_.unmarshal_int();
/* 51 */     this.serialid = _os_.unmarshal_long();
/* 52 */     this.from_openid = _os_.unmarshal_Octets();
/* 53 */     this.from_nickname = _os_.unmarshal_Octets();
/* 54 */     this.from_figure_url = _os_.unmarshal_Octets();
/* 55 */     this.gift_count = _os_.unmarshal_int();
/* 56 */     this.timestamp = _os_.unmarshal_int();
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof GrcReceiveGiftInfo)) {
/* 63 */       GrcReceiveGiftInfo _o_ = (GrcReceiveGiftInfo)_o1_;
/* 64 */       if (this.gift_type != _o_.gift_type) return false;
/* 65 */       if (this.serialid != _o_.serialid) return false;
/* 66 */       if (!this.from_openid.equals(_o_.from_openid)) return false;
/* 67 */       if (!this.from_nickname.equals(_o_.from_nickname)) return false;
/* 68 */       if (!this.from_figure_url.equals(_o_.from_figure_url)) return false;
/* 69 */       if (this.gift_count != _o_.gift_count) return false;
/* 70 */       if (this.timestamp != _o_.timestamp) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.gift_type;
/* 79 */     _h_ += (int)this.serialid;
/* 80 */     _h_ += this.from_openid.hashCode();
/* 81 */     _h_ += this.from_nickname.hashCode();
/* 82 */     _h_ += this.from_figure_url.hashCode();
/* 83 */     _h_ += this.gift_count;
/* 84 */     _h_ += this.timestamp;
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.gift_type).append(",");
/* 92 */     _sb_.append(this.serialid).append(",");
/* 93 */     _sb_.append("B").append(this.from_openid.size()).append(",");
/* 94 */     _sb_.append("B").append(this.from_nickname.size()).append(",");
/* 95 */     _sb_.append("B").append(this.from_figure_url.size()).append(",");
/* 96 */     _sb_.append(this.gift_count).append(",");
/* 97 */     _sb_.append(this.timestamp).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcReceiveGiftInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */