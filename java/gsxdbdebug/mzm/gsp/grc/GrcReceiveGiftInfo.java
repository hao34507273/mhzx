/*    */ package mzm.gsp.grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class GrcReceiveGiftInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int gift_type;
/*    */   public long serialid;
/*    */   public Octets from;
/*    */   public Octets from_nickname;
/*    */   public Octets from_figure_url;
/*    */   public int count;
/*    */   public int timestamp;
/*    */   
/*    */   public GrcReceiveGiftInfo()
/*    */   {
/* 18 */     this.from = new Octets();
/* 19 */     this.from_nickname = new Octets();
/* 20 */     this.from_figure_url = new Octets();
/*    */   }
/*    */   
/*    */   public GrcReceiveGiftInfo(int _gift_type_, long _serialid_, Octets _from_, Octets _from_nickname_, Octets _from_figure_url_, int _count_, int _timestamp_) {
/* 24 */     this.gift_type = _gift_type_;
/* 25 */     this.serialid = _serialid_;
/* 26 */     this.from = _from_;
/* 27 */     this.from_nickname = _from_nickname_;
/* 28 */     this.from_figure_url = _from_figure_url_;
/* 29 */     this.count = _count_;
/* 30 */     this.timestamp = _timestamp_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 38 */     _os_.marshal(this.gift_type);
/* 39 */     _os_.marshal(this.serialid);
/* 40 */     _os_.marshal(this.from);
/* 41 */     _os_.marshal(this.from_nickname);
/* 42 */     _os_.marshal(this.from_figure_url);
/* 43 */     _os_.marshal(this.count);
/* 44 */     _os_.marshal(this.timestamp);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 49 */     this.gift_type = _os_.unmarshal_int();
/* 50 */     this.serialid = _os_.unmarshal_long();
/* 51 */     this.from = _os_.unmarshal_Octets();
/* 52 */     this.from_nickname = _os_.unmarshal_Octets();
/* 53 */     this.from_figure_url = _os_.unmarshal_Octets();
/* 54 */     this.count = _os_.unmarshal_int();
/* 55 */     this.timestamp = _os_.unmarshal_int();
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 60 */     if (_o1_ == this) return true;
/* 61 */     if ((_o1_ instanceof GrcReceiveGiftInfo)) {
/* 62 */       GrcReceiveGiftInfo _o_ = (GrcReceiveGiftInfo)_o1_;
/* 63 */       if (this.gift_type != _o_.gift_type) return false;
/* 64 */       if (this.serialid != _o_.serialid) return false;
/* 65 */       if (!this.from.equals(_o_.from)) return false;
/* 66 */       if (!this.from_nickname.equals(_o_.from_nickname)) return false;
/* 67 */       if (!this.from_figure_url.equals(_o_.from_figure_url)) return false;
/* 68 */       if (this.count != _o_.count) return false;
/* 69 */       if (this.timestamp != _o_.timestamp) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.gift_type;
/* 78 */     _h_ += (int)this.serialid;
/* 79 */     _h_ += this.from.hashCode();
/* 80 */     _h_ += this.from_nickname.hashCode();
/* 81 */     _h_ += this.from_figure_url.hashCode();
/* 82 */     _h_ += this.count;
/* 83 */     _h_ += this.timestamp;
/* 84 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 88 */     StringBuilder _sb_ = new StringBuilder();
/* 89 */     _sb_.append("(");
/* 90 */     _sb_.append(this.gift_type).append(",");
/* 91 */     _sb_.append(this.serialid).append(",");
/* 92 */     _sb_.append("B").append(this.from.size()).append(",");
/* 93 */     _sb_.append("B").append(this.from_nickname.size()).append(",");
/* 94 */     _sb_.append("B").append(this.from_figure_url.size()).append(",");
/* 95 */     _sb_.append(this.count).append(",");
/* 96 */     _sb_.append(this.timestamp).append(",");
/* 97 */     _sb_.append(")");
/* 98 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\GrcReceiveGiftInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */