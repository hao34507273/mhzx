/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class PointRaceUserDataBack implements Marshal
/*    */ {
/*    */   public Octets userid;
/*    */   public long roleid;
/*    */   public Octets user_token;
/*    */   public ArrayList<ExchangeDataHandlerInfo> exchange_data_handler_info;
/*    */   
/*    */   public PointRaceUserDataBack()
/*    */   {
/* 17 */     this.userid = new Octets();
/* 18 */     this.roleid = 0L;
/* 19 */     this.user_token = new Octets();
/* 20 */     this.exchange_data_handler_info = new ArrayList();
/*    */   }
/*    */   
/*    */   public PointRaceUserDataBack(Octets _userid_, long _roleid_, Octets _user_token_, ArrayList<ExchangeDataHandlerInfo> _exchange_data_handler_info_) {
/* 24 */     this.userid = _userid_;
/* 25 */     this.roleid = _roleid_;
/* 26 */     this.user_token = _user_token_;
/* 27 */     this.exchange_data_handler_info = _exchange_data_handler_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 31 */     for (ExchangeDataHandlerInfo _v_ : this.exchange_data_handler_info)
/* 32 */       if (!_v_._validator_()) return false;
/* 33 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 37 */     _os_.marshal(this.userid);
/* 38 */     _os_.marshal(this.roleid);
/* 39 */     _os_.marshal(this.user_token);
/* 40 */     _os_.compact_uint32(this.exchange_data_handler_info.size());
/* 41 */     for (ExchangeDataHandlerInfo _v_ : this.exchange_data_handler_info) {
/* 42 */       _os_.marshal(_v_);
/*    */     }
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 48 */     this.userid = _os_.unmarshal_Octets();
/* 49 */     this.roleid = _os_.unmarshal_long();
/* 50 */     this.user_token = _os_.unmarshal_Octets();
/* 51 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 52 */       ExchangeDataHandlerInfo _v_ = new ExchangeDataHandlerInfo();
/* 53 */       _v_.unmarshal(_os_);
/* 54 */       this.exchange_data_handler_info.add(_v_);
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 60 */     if (_o1_ == this) return true;
/* 61 */     if ((_o1_ instanceof PointRaceUserDataBack)) {
/* 62 */       PointRaceUserDataBack _o_ = (PointRaceUserDataBack)_o1_;
/* 63 */       if (!this.userid.equals(_o_.userid)) return false;
/* 64 */       if (this.roleid != _o_.roleid) return false;
/* 65 */       if (!this.user_token.equals(_o_.user_token)) return false;
/* 66 */       if (!this.exchange_data_handler_info.equals(_o_.exchange_data_handler_info)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.userid.hashCode();
/* 75 */     _h_ += (int)this.roleid;
/* 76 */     _h_ += this.user_token.hashCode();
/* 77 */     _h_ += this.exchange_data_handler_info.hashCode();
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append("B").append(this.userid.size()).append(",");
/* 85 */     _sb_.append(this.roleid).append(",");
/* 86 */     _sb_.append("B").append(this.user_token.size()).append(",");
/* 87 */     _sb_.append(this.exchange_data_handler_info).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\PointRaceUserDataBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */