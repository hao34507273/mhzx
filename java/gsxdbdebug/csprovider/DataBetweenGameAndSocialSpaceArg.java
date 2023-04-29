/*    */ package csprovider;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class DataBetweenGameAndSocialSpaceArg implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int gameid;
/*    */   public int serverid;
/*    */   public int qtype;
/*    */   public Octets data;
/*    */   public int reserved1;
/*    */   public Octets reserved2;
/*    */   
/*    */   public DataBetweenGameAndSocialSpaceArg()
/*    */   {
/* 17 */     this.data = new Octets();
/* 18 */     this.reserved2 = new Octets();
/*    */   }
/*    */   
/*    */   public DataBetweenGameAndSocialSpaceArg(int _gameid_, int _serverid_, int _qtype_, Octets _data_, int _reserved1_, Octets _reserved2_) {
/* 22 */     this.gameid = _gameid_;
/* 23 */     this.serverid = _serverid_;
/* 24 */     this.qtype = _qtype_;
/* 25 */     this.data = _data_;
/* 26 */     this.reserved1 = _reserved1_;
/* 27 */     this.reserved2 = _reserved2_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 35 */     _os_.marshal(this.gameid);
/* 36 */     _os_.marshal(this.serverid);
/* 37 */     _os_.marshal(this.qtype);
/* 38 */     _os_.marshal(this.data);
/* 39 */     _os_.marshal(this.reserved1);
/* 40 */     _os_.marshal(this.reserved2);
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 45 */     this.gameid = _os_.unmarshal_int();
/* 46 */     this.serverid = _os_.unmarshal_int();
/* 47 */     this.qtype = _os_.unmarshal_int();
/* 48 */     this.data = _os_.unmarshal_Octets();
/* 49 */     this.reserved1 = _os_.unmarshal_int();
/* 50 */     this.reserved2 = _os_.unmarshal_Octets();
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 55 */     if (_o1_ == this) return true;
/* 56 */     if ((_o1_ instanceof DataBetweenGameAndSocialSpaceArg)) {
/* 57 */       DataBetweenGameAndSocialSpaceArg _o_ = (DataBetweenGameAndSocialSpaceArg)_o1_;
/* 58 */       if (this.gameid != _o_.gameid) return false;
/* 59 */       if (this.serverid != _o_.serverid) return false;
/* 60 */       if (this.qtype != _o_.qtype) return false;
/* 61 */       if (!this.data.equals(_o_.data)) return false;
/* 62 */       if (this.reserved1 != _o_.reserved1) return false;
/* 63 */       if (!this.reserved2.equals(_o_.reserved2)) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.gameid;
/* 72 */     _h_ += this.serverid;
/* 73 */     _h_ += this.qtype;
/* 74 */     _h_ += this.data.hashCode();
/* 75 */     _h_ += this.reserved1;
/* 76 */     _h_ += this.reserved2.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.gameid).append(",");
/* 84 */     _sb_.append(this.serverid).append(",");
/* 85 */     _sb_.append(this.qtype).append(",");
/* 86 */     _sb_.append("B").append(this.data.size()).append(",");
/* 87 */     _sb_.append(this.reserved1).append(",");
/* 88 */     _sb_.append("B").append(this.reserved2.size()).append(",");
/* 89 */     _sb_.append(")");
/* 90 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\csprovider\DataBetweenGameAndSocialSpaceArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */