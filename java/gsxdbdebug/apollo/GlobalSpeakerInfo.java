/*    */ package apollo;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class GlobalSpeakerInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public Octets channel;
/*    */   public Octets openid;
/*    */   public Octets nickname;
/*    */   public java.util.HashSet<Integer> open_mic_zoneids;
/*    */   
/*    */   public GlobalSpeakerInfo()
/*    */   {
/* 15 */     this.channel = new Octets();
/* 16 */     this.openid = new Octets();
/* 17 */     this.nickname = new Octets();
/* 18 */     this.open_mic_zoneids = new java.util.HashSet();
/*    */   }
/*    */   
/*    */   public GlobalSpeakerInfo(Octets _channel_, Octets _openid_, Octets _nickname_, java.util.HashSet<Integer> _open_mic_zoneids_) {
/* 22 */     this.channel = _channel_;
/* 23 */     this.openid = _openid_;
/* 24 */     this.nickname = _nickname_;
/* 25 */     this.open_mic_zoneids = _open_mic_zoneids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.channel);
/* 34 */     _os_.marshal(this.openid);
/* 35 */     _os_.marshal(this.nickname);
/* 36 */     _os_.compact_uint32(this.open_mic_zoneids.size());
/* 37 */     for (Integer _v_ : this.open_mic_zoneids) {
/* 38 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 44 */     this.channel = _os_.unmarshal_Octets();
/* 45 */     this.openid = _os_.unmarshal_Octets();
/* 46 */     this.nickname = _os_.unmarshal_Octets();
/* 47 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 49 */       int _v_ = _os_.unmarshal_int();
/* 50 */       this.open_mic_zoneids.add(Integer.valueOf(_v_));
/*    */     }
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 56 */     if (_o1_ == this) return true;
/* 57 */     if ((_o1_ instanceof GlobalSpeakerInfo)) {
/* 58 */       GlobalSpeakerInfo _o_ = (GlobalSpeakerInfo)_o1_;
/* 59 */       if (!this.channel.equals(_o_.channel)) return false;
/* 60 */       if (!this.openid.equals(_o_.openid)) return false;
/* 61 */       if (!this.nickname.equals(_o_.nickname)) return false;
/* 62 */       if (!this.open_mic_zoneids.equals(_o_.open_mic_zoneids)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.channel.hashCode();
/* 71 */     _h_ += this.openid.hashCode();
/* 72 */     _h_ += this.nickname.hashCode();
/* 73 */     _h_ += this.open_mic_zoneids.hashCode();
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append("B").append(this.channel.size()).append(",");
/* 81 */     _sb_.append("B").append(this.openid.size()).append(",");
/* 82 */     _sb_.append("B").append(this.nickname.size()).append(",");
/* 83 */     _sb_.append(this.open_mic_zoneids).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\GlobalSpeakerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */